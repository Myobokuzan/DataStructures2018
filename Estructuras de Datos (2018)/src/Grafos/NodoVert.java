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
    
    public NodoVert(Object elemento,NodoVert vertice){
        this.elem=elemento;
        this.sigVert=vertice;
        this.primerAdy=null;
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
}
