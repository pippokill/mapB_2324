/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class Inventory {

    private List<AdvObject> list = new ArrayList<>();

    /**
     *
     * @return
     */
    public List<AdvObject> getList() {
        return list;
    }

    /**
     *
     * @param list
     */
    public void setList(List<AdvObject> list) {
        this.list = list;
    }

    /**
     *
     * @param o
     */
    public void add(AdvObject o) {
        list.add(o);
    }

    /**
     *
     * @param o
     */
    public void remove(AdvObject o) {
        list.remove(o);
    }
}
