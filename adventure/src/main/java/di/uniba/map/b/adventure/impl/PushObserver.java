/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.adventure.impl;

import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.CommandType;
import di.uniba.map.b.adventure.GameObserver;
import di.uniba.map.b.adventure.GameUtils;

/**
 *
 * @author pierpaolo
 */
public class PushObserver implements GameObserver {

    /**
     *
     * @param description
     * @param parserOutput
     * @return
     */
    @Override
    public String update(GameDescription description, ParserOutput parserOutput) {
        StringBuilder msg = new StringBuilder();
        if (parserOutput.getCommand().getType() == CommandType.PUSH) {
            //ricerca oggetti pushabili
            if (parserOutput.getObject() != null && parserOutput.getObject().isPushable()) {
                msg.append("Hai premuto: ").append(parserOutput.getObject().getName()).append("\n");
                if (parserOutput.getObject().getId() == 3 && GameUtils.getObjectFromInventory(description.getInventory(), 1) != null) {
                    msg.append("Premi il pulsante del giocattolo e in seguito ad una forte esplosione la tua casa prende fuoco...\ntu e tuoi famigliari cercate invano di salvarvi e venite avvolti dalle fiamme...\nè stata una morte CALOROSA...addio!");
                    description.setCurrentRoom(null);
                } else if (parserOutput.getObject().getId() == 3) {
                    msg.append("Non posso utilizzare il giocattolo senza delle batterie.");
                }
            } else if (parserOutput.getInvObject() != null && parserOutput.getInvObject().isPushable()) {
                msg.append("Hai premuto: ").append(parserOutput.getInvObject().getName()).append("\n");
                if (parserOutput.getInvObject().getId() == 3 && GameUtils.getObjectFromInventory(description.getInventory(), 1) != null) {
                    msg.append("Premi il pulsante del giocattolo e in seguito ad una forte esplosione la tua casa prende fuoco...\ntu e tuoi famigliari cercate invano di salvarvi e venite avvolti dalle fiamme...\nè stata una morte CALOROSA...addio!");
                    description.setCurrentRoom(null);
                } else if (parserOutput.getInvObject().getId() == 3) {
                    msg.append("Non posso utilizzare il giocattolo senza delle batterie.");
                }
            } else {
                msg.append("Non ci sono oggetti che puoi premere qui.");
            }
        }
        return msg.toString();
    }

}
