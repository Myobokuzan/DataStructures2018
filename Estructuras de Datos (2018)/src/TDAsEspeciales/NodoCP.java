/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAsEspeciales;

import lineales.dinamicas.ColaGen;

/**
 *
 * @author Tomas
 */
public class NodoCP {
    private Comparable prioridad;
    private int ordenLLegada;
    private Object elemento;
    
    public NodoCP(Comparable priori,int orden,Object elem){
        this.prioridad=priori;
        this.ordenLLegada=orden;
        this.elemento=elem;
    }
    public Comparable getPrioridad(){
        return this.prioridad;
    }
    public int getOrdenLlegada(){
        return this.ordenLLegada;
    }
    public Object getElem(){
        return this.elemento;
    }
}
