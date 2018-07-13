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
public class NodoAdy {
    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    
    public NodoAdy(){
        this.vertice=null;
        this.sigAdyacente=null;
    }
    public NodoAdy(NodoVert vert){
        vertice=vert;
        sigAdyacente=null;
    }
    public NodoVert getVertice(){
        return vertice;
    }
    public void setVertice(NodoVert nuevo){
        vertice=nuevo;
    }
    public NodoAdy getSigAdyacente(){
        return sigAdyacente;
    }
    public void setSigAdyacente(NodoAdy nuevo){
        this.sigAdyacente=nuevo;
    }
    
}
