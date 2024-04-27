/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author pierpaolo
 */
public class AdvObjectContainer extends AdvObject {

    private List<AdvObject> list = new ArrayList<>();

    /**
     *
     * @param id
     */
    public AdvObjectContainer(int id) {
        super(id);
    }

    /**
     *
     * @param id
     * @param name
     */
    public AdvObjectContainer(int id, String name) {
        super(id, name);
    }

    /**
     *
     * @param id
     * @param name
     * @param description
     */
    public AdvObjectContainer(int id, String name, String description) {
        super(id, name, description);
    }

    /**
     *
     * @param id
     * @param name
     * @param description
     * @param alias
     */
    public AdvObjectContainer(int id, String name, String description, Set<String> alias) {
        super(id, name, description, alias);
    }

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
