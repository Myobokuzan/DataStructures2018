/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author Tomas
 */
public class NodoVert {
    private Object elem;
    private NodoVert sigVert;
    private NodoAdy primerAdy;
    private NodoVert vertAnterior; //Variable usada para almacenar el nodo anterior en un determinado recorrido.
    private Object valorAcum; //Variable que almacea la suma de los pesos de los arcos anteriores al nodo desde un nodo origen.
    
    public NodoVert(Object elemento,NodoVert vertice){
        this.elem=elemento;
        this.sigVert=vertice;
        this.primerAdy=null;
        this.vertAnterior=null;
        this.valorAcum=0;
    }
    public Object getElem(){
        return this.elem;
    }
    public void setElem(Object nuevoElem){
        elem=nuevoElem;
    }
    public NodoVert getSigVert(){
        return sigVert;
    }
    public void setSigVert(NodoVert nuevo){
        sigVert=nuevo;
    }
    public NodoAdy getPrimerAdy(){
        return primerAdy;
    }
    public void setPrimerAdy(NodoAdy nuevo){
        primerAdy=nuevo;
    }
    
    public NodoVert getAnterior(){
        return vertAnterior;
    }
    public NodoVert setAnterior(NodoVert nuevo){
        return this.vertAnterior=nuevo;
    }
    public Object getValorAcum(){
        return this.valorAcum;
    }
    public void setValorAcum(Object nuevoValor){
        this.valorAcum=nuevoValor;
    }
}
