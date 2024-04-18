/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package di.uniba.map.b.lab.io.esercizi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pierpaolo
 */
public class TextProcessing {

    /**
     *
     * @param file
     * @param toLowerCase
     * @return
     * @throws IOException
     */
    public static Map<String, Integer> count(File file, boolean toLowerCase) throws IOException {
        Map<String, Integer> count = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            String line = reader.readLine();
            if (toLowerCase) {
                line = line.toLowerCase();
            }
            Scanner scanner = new Scanner(line);
            while (scanner.hasNext()) {
                String token = scanner.next();
                Integer v = count.get(token);
                if (v == null) {
                    count.put(token, 1);
                } else {
                    count.put(token, v + 1);
                }
            }
        }
        reader.close();
        return count;
    }

    /**
     *
     * @param count
     * @param file
     * @throws IOException
     */
    public static void save(Map<String, Integer> count, File file) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream outStream = new ObjectOutputStream(out);
        outStream.writeObject(count);
        outStream.close();
    }

    /**
     *
     * @param file
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Map<String, Integer> load(File file) throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(file);
        ObjectInputStream inStream = new ObjectInputStream(in);
        Map<String, Integer> count = (Map<String, Integer>) inStream.readObject();
        inStream.close();
        return count;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Map<String, Integer> count = count(new File("resources/sorgente.txt"), true);
            System.out.println(count);
            save(count, new File("resources/count"));
            Map<String, Integer> countS = load(new File("resources/count"));
            System.out.println(countS);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(TextProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
