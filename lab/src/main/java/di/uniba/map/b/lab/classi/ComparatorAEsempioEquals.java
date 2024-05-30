/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.classi;

import java.util.Comparator;

/**
 *
 * @author pierpaolo
 */
public class ComparatorAEsempioEquals implements Comparator<EsempioEquals> {

    /**
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(EsempioEquals o1, EsempioEquals o2) {
        return o1.getA().compareTo(o2.getA());
    }
    
}
