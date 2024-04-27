/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure;

import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.AdvObject;
import di.uniba.map.b.adventure.type.Command;
import di.uniba.map.b.adventure.type.Room;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public abstract class GameDescription {

    private final List<Room> rooms = new ArrayList<>();

    private final List<Command> commands = new ArrayList<>();

    private final List<AdvObject> inventory = new ArrayList<>();

    private Room currentRoom;

    /**
     *
     * @return
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     *
     * @return
     */
    public List<Command> getCommands() {
        return commands;
    }

    /**
     *
     * @return
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     *
     * @param currentRoom
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     *
     * @return
     */
    public List<AdvObject> getInventory() {
        return inventory;
    }

    /**
     *
     * @throws Exception
     */
    public abstract void init() throws Exception;

    /**
     *
     * @param p
     * @param out
     */
    public abstract void nextMove(ParserOutput p, PrintStream out);
    
    /**
     *
     * @return
     */
    public abstract String getWelcomeMsg();

}
