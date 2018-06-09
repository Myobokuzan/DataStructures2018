/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.ListaInt;

/**
 *
 * @author tomas
 */
public class NodoArbolInt {
    //Atributos
    private int elem;
    private NodoArbolInt izquierdo;
    private NodoArbolInt derecho;
    
    //Constructores
    public NodoArbolInt(int nuevoElem,NodoArbolInt izq,NodoArbolInt der){
        this.elem=nuevoElem;
        this.izquierdo=izq;
        this.derecho=der;
    }
    
    public NodoArbolInt(int nuevoElem){
        this.elem=nuevoElem;
        this.izquierdo=null;
        this.derecho=null;
    }
    //Obervadores
    public int getElem(){
        return this.elem;
    }
    public NodoArbolInt getIzquierdo(){
        return this.izquierdo;
    }
    public NodoArbolInt getDerecho(){
        return this.derecho;
    }
    //Modificadores
    public void setElem(int elem){
        this.elem=elem;
    }
    public void setIzquierdo(NodoArbolInt nuevoIzq){
        this.izquierdo=nuevoIzq;
    }
    public void setDerecho(NodoArbolInt nuevoDer){
        this.derecho=nuevoDer;
    }
}
