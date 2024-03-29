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
package di.uniba.map.b.lab.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author pierpaolo
 */
public class EsercizioMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : args[0].split("\\s+")) {
            Integer count = map.get(s);
            //map.put(s, (count == null) ? 1 : count + 1);
            if (count == null) {
                map.put(s, 1);
            } else {
                map.put(s, count + 1);
            }
        }
        for (Map.Entry<String, Integer> i : map.entrySet()) {
            System.out.println("Key: " + i.getKey() + " Count: " + i.getValue());
        }
        for (String k : map.keySet()) {
            System.out.println("Key: " + k + " Count: " + map.get(k));
        }
        /*Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String k = it.next();
            if (k.equals("topolino")) {
                it.remove();
            }
        }
        for (String k : map.keySet()) {
            System.out.println("Key: " + k + " Count: " + map.get(k));
        }*/
    }

}
