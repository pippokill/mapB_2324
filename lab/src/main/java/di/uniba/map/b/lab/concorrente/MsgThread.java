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
package di.uniba.map.b.lab.concorrente;

/**
 *
 * @author pierpaolo
 */
public class MsgThread extends Thread {

    private String msg;

    private int sec;

    /**
     *
     * @param msg
     * @param sec
     */
    public MsgThread(String msg, int sec) {
        super();
        this.msg = msg;
        this.sec = sec;
    }

    /**
     *
     */
    @Override
    public void run() {
        try {
            sleep(sec * 1000);
        } catch (InterruptedException ex) {
            System.out.println("Mi hai interrotto.");
            return;
        }
        System.out.println(msg);
    }

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        Thread t1 = new MsgThread("Ciao 1", 4);
        t1.start();

        // Test join
        try {
            t1.join();
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
        
        Thread t2 = new MsgThread("Ciao 2", 4);
        t2.start();
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
            System.out.println(t2.isInterrupted());
        }
        t2.interrupt();
        System.out.println(t2.isInterrupted());

    }

}
