/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.adventure;

/**
 *
 * @author pierpaolo
 */
public interface GameObservable {
    
    public void attach(GameObserver o);
    
    public void detach(GameObserver o);
    
    public void notifyObservers();
    
}
