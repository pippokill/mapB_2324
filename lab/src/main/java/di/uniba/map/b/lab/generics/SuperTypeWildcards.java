/*
 * Copyright (C) 2020 pierpaolo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package di.uniba.map.b.lab.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class SuperTypeWildcards {

    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        //apples.add(new Orange()); // Orange doesn’t extend Apple
        //apples.add(new Fruit()); // Fruit doesn’t extend Apple
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Apple> l = new ArrayList<>();
        //List<Fruit> l=new ArrayList<>();
        writeTo(l);
        for (Object o : l) {
            System.out.println(o.getClass().getName());
        }
    }

}
