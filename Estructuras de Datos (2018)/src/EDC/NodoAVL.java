/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDC;

/**
 *
 * @author Tomas
 */
public class NodoAVL {
    private Comparable elem;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    
    public NodoAVL(Comparable elemento){
        elem=elemento;
        izquierdo=null;
        derecho=null;
        altura=0;
    }
    public Comparable getElem(){
        return elem;
    }
    public void setElem(Comparable nuevo){
        elem=nuevo;
    }
    public int getAltura(){
        return altura;
    }
    private int recalcularAltura(NodoAVL n){
        int h1,h2,h=-1;
        if(n!=null){
            if(n.getIzquierdo()==null){
                h1=0;
            }else{
                h1=recalcularAltura(n.getIzquierdo())+1;
            }
            if(n.getDerecho()==null){
                h2=0;
            }else{
                h2=recalcularAltura(n.getDerecho())+1;
            }
            if(h1>=h2){
                h=h1;
            }else{
                h=h2;
            }
        }
        return h;
    }
    public void recalcularAltura(){
        altura=recalcularAltura(this);
    }
    public NodoAVL getIzquierdo(){
        return izquierdo;
    }
    public NodoAVL getDerecho(){
        return derecho;
    }
    public void setIzquierdo(NodoAVL izq){
        izquierdo=izq;
    }
    public void setDerecho(NodoAVL der){
        derecho=der;
    }
}    
