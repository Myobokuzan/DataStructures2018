/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDC;

/**
 *
 * @author tomas
 */
public class NodoABB {
    private Comparable elem;
    private NodoABB izquierdo;
    private NodoABB derecho;
    
    public NodoABB(Comparable elem){
        this.elem=elem;
        this.izquierdo=null;
        this.derecho=null;
    }
    public Comparable getElem(){
        return this.elem;
    }
    public void setElem(Comparable elem){
        this.elem=elem;
    }
    public NodoABB getIzquierdo(){
        return this.izquierdo;
    }
    public void setIzquierdo(NodoABB izq){
        this.izquierdo=izq;
    }
    public NodoABB getDerecho(){
        return this.derecho;
    }
    public void setDerecho(NodoABB der){
        this.derecho=der;
    }
}
