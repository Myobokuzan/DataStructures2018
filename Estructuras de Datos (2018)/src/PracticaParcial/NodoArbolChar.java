/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaParcial;

/**
 *
 * @author tomas
 */
public class NodoArbolChar {
    //Atributos
    private int elem;
    private NodoArbolChar izquierdo;
    private NodoArbolChar derecho;
    
    //Constructores
    public NodoArbolChar(char nuevoElem,NodoArbolChar izq,NodoArbolChar der){
        this.elem=nuevoElem;
        this.izquierdo=izq;
        this.derecho=der;
    }
    public NodoArbolChar(char nuevoElem){
        this.elem=nuevoElem;
        this.izquierdo=null;
        this.derecho=null;
    }
    //Obervadores
    public int getElem(){
        return this.elem;
    }
    public NodoArbolChar getIzquierdo(){
        return this.izquierdo;
    }
    public NodoArbolChar getDerecho(){
        return this.derecho;
    }
    //Modificadores
    public void setElem(int elem){
        this.elem=elem;
    }
    public void setIzquierdo(NodoArbolChar nuevoIzq){
        this.izquierdo=nuevoIzq;
    }
    public void setDerecho(NodoArbolChar nuevoDer){
        this.derecho=nuevoDer;
    }
}
