/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.adventure.impl;

import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.CommandType;
import di.uniba.map.b.adventure.GameObserver;

/**
 *
 * @author pierpaolo
 */
public class MoveObserver implements GameObserver {

    /**
     *
     * @param description
     * @param parserOutput
     * @return
     */
    @Override
    public String update(GameDescription description, ParserOutput parserOutput) {
        if (parserOutput.getCommand().getType() == CommandType.NORD) {
            if (description.getCurrentRoom().getNorth() != null) {
                description.setCurrentRoom(description.getCurrentRoom().getNorth());
            } else {
                return "Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...";
            }
        } else if (parserOutput.getCommand().getType() == CommandType.SOUTH) {
            if (description.getCurrentRoom().getSouth() != null) {
                description.setCurrentRoom(description.getCurrentRoom().getSouth());
            } else {
                return "Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...";
            }
        } else if (parserOutput.getCommand().getType() == CommandType.EAST) {
            if (description.getCurrentRoom().getEast() != null) {
                description.setCurrentRoom(description.getCurrentRoom().getEast());
            } else {
                return "Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...";
            }
        } else if (parserOutput.getCommand().getType() == CommandType.WEST) {
            if (description.getCurrentRoom().getWest() != null) {
                description.setCurrentRoom(description.getCurrentRoom().getWest());
            } else {
                return "Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...";
            }
        }
        return "";
    }

}
