/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.adventure.impl;

import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.GameObserver;
import di.uniba.map.b.adventure.GameUtils;
import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.CommandType;

/**
 *
 * @author pierpaolo
 */
public class UseObserver implements GameObserver {

    /**
     *
     * @param description
     * @param parserOutput
     * @return
     */
    @Override
    public String update(GameDescription description, ParserOutput parserOutput) {
        StringBuilder msg = new StringBuilder();
        if (parserOutput.getCommand().getType() == CommandType.USE) {
            boolean interact = false;
            boolean key = parserOutput.getInvObject() != null && parserOutput.getInvObject().getId() == 4;
            key = key || parserOutput.getObject() != null && parserOutput.getObject().getId() == 4;
            if (key && description.getCurrentRoom().getObject(2) != null) {
                if (description.getCurrentRoom().getObject(2).isOpen()) {
                    msg.append("L'armadio è già aperto...hai la memoria di un criceto!");
                } else {
                    if (description.getCurrentRoom().getObject(2).isOpenable()) {
                        msg.append(("L'armadio è già aperto! Perché mi chiedi di fare cose così stupide..."));
                    } else {
                        msg.append("Sei fortunato! La chiave ha sbloccato la serratura dell'armadio. Adesso puoi aprirlo.");
                        description.getCurrentRoom().getObject(2).setOpenable(true);
                    }
                }
                interact = true;
            }
            boolean battery = parserOutput.getInvObject() != null && parserOutput.getInvObject().getId() == 1;
            battery = battery || parserOutput.getObject() != null && parserOutput.getObject().getId() == 1;
            if (battery && GameUtils.getObjectFromInventory(description.getInventory(), 3) != null) {
                GameUtils.getObjectFromInventory(description.getInventory(), 3).setPushable(true);
                msg.append("Hai inserito le batterie nel giocattolo. Sei ritornato un bambino felice!");
                interact = true;
            } else if (battery) {
                msg.append("Non c'è nessun oggetto nell'inventario che funziona con questo tipo di batterie.");
                interact = true;
            }
            boolean wardrobe = parserOutput.getObject() != null && parserOutput.getObject().getId() == 2;
            if (wardrobe) {
                if (parserOutput.getObject().isOpen()) {
                    msg.append("L'armadio è troppo pieno, non puoi inserirci più nulla!");
                } else {
                    msg.append("L'armadio è chiuso e di certo non puoi sollevarlo o spostarlo, è troppo pesante e tu non hai abbastanza muscoli!");
                }
                interact = true;
            }
            boolean toy = parserOutput.getInvObject() != null && parserOutput.getInvObject().getId() == 3;
            toy = toy || parserOutput.getObject() != null && parserOutput.getObject().getId() == 3;
            if (toy) {
                if (parserOutput.getObject() != null && parserOutput.getObject().getId() == 3) {
                    msg.append("Devi prima raccoglierlo per poterlo utilizzare.");
                    interact = true;
                } else if (parserOutput.getInvObject() != null && parserOutput.getInvObject().getId() == 3) {
                    if (parserOutput.getInvObject().isPushable()) {
                        msg.append("Premi il pulsante del giocattolo e in seguito ad una forte esplosione la tua casa prende fuoco...\ntu e tuoi famigliari cercate invano di salvarvi e venite avvolti dalle fiamme...\nè stata una morte CALOROSA...addio!");
                        description.setCurrentRoom(null);
                        interact = true;
                    } else {
                        msg.append("Mancano le batterie, non posso utilizzarlo così.");
                        interact = true;
                    }
                }
            }
            if (!interact) {
                msg.append("Non ci sono oggetti utilizzabili qui.");
            }
        }
        return msg.toString();
    }

}
