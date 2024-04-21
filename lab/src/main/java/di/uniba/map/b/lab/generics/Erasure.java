/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package di.uniba.map.b.lab.generics;

import java.util.ArrayList;

/**
 *
 * @author pierpaolo
 */
public class Erasure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> a=new ArrayList<>();
        System.out.println(a.getClass().getName());
        ArrayList<Integer> b=new ArrayList<>();
        System.out.println(b.getClass().getName());
    }
    
}
