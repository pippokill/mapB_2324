/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure;

import di.uniba.map.b.adventure.impl.FireHouseGame;
import di.uniba.map.b.adventure.parser.Parser;
import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.CommandType;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

/**
 * ATTENZIONE: l'Engine è molto spartano, in realtà demanda la logica alla
 * classe che implementa GameDescription e si occupa di gestire I/O sul
 * terminale.
 *
 * @author pierpaolo
 */
public class Engine {

    private final GameDescription game;

    private Parser parser;

    /**
     *
     * @param game
     */
    public Engine(GameDescription game) {
        this.game = game;
        try {
            this.game.init();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        try {
            Set<String> stopwords = Utils.loadFileListInSet(new File("./resources/stopwords"));
            parser = new Parser(stopwords);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     *
     */
    public void execute() {
        System.out.println("================================");
        System.out.println("* Adventure v. 0.4 - 2023-2024 *");
        System.out.println("*         developed by         *");
        System.out.println("*       Pierpaolo Basile       *");
        System.out.println("================================");
        System.out.println();
        System.out.println(game.getWelcomeMsg());
        System.out.println();
        System.out.println("Ti trovi qui: " + game.getCurrentRoom().getName());
        System.out.println();
        System.out.println(game.getCurrentRoom().getDescription());
        System.out.println();
        System.out.print("?> ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            ParserOutput p = parser.parse(command, game.getCommands(), game.getCurrentRoom().getObjects(), game.getInventory());
            if (p == null || p.getCommand() == null) {
                System.out.println("Non capisco quello che mi vuoi dire.");
            } else if (p.getCommand() != null && p.getCommand().getType() == CommandType.END) {
                System.out.println("Sei un fifone, addio!");
                break;
            } else {
                game.nextMove(p, System.out);
                if (game.getCurrentRoom() == null) {
                    System.out.println("La tua avventura termina qui! Complimenti!");
                    System.exit(0);
                }
            }
            System.out.print("?> ");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Engine engine = new Engine(new FireHouseGame());
        engine.execute();
    }

}
