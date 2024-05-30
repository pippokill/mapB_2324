/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.classi;

import java.util.Objects;

/**
 *
 * @author pierpaolo
 */
public class EsempioEquals implements Comparable<EsempioEquals> {
    
    private String a;
    
    private String b;
    
    private int c;

    /**
     *
     * @param a
     * @param b
     * @param c
     */
    public EsempioEquals(String a, String b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.a);
        hash = 29 * hash + this.c;
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EsempioEquals other = (EsempioEquals) obj;
        if (this.c != other.c) {
            return false;
        }
        return Objects.equals(this.a, other.a);
    }

    /**
     *
     * @return
     */
    public String getA() {
        return a;
    }

    /**
     *
     * @param a
     */
    public void setA(String a) {
        this.a = a;
    }

    /**
     *
     * @return
     */
    public String getB() {
        return b;
    }

    /**
     *
     * @param b
     */
    public void setB(String b) {
        this.b = b;
    }

    /**
     *
     * @return
     */
    public int getC() {
        return c;
    }

    /**
     *
     * @param c
     */
    public void setC(int c) {
        this.c = c;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(EsempioEquals o) {
        return Integer.compare(this.c, o.c);
    }
    
    
    
}
