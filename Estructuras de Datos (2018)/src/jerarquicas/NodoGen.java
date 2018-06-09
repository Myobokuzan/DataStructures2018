/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author tomas
 */
public class NodoGen {
    private Object elem;
    private NodoGen hijoIzq;
    private NodoGen hermanoDer;
    
    public NodoGen(Object elem){
        this.elem=elem;
        this.hijoIzq=null;
        this.hermanoDer=null;
    }
    public Object getElem(){
        return this.elem;
    }
    public NodoGen getHijoIzquierdo(){
        return this.hijoIzq;
    }
    public NodoGen getHermanoDerecho(){
        return this.hermanoDer;
    }
    public void setElem(Object nuevo){
        this.elem=nuevo;
    }
    public void setHijoIzquierdo(NodoGen nuevoIzq){
        this.hijoIzq=nuevoIzq;
    }
    public void setHermanoDerecho(NodoGen nuevoDer){
        this.hermanoDer=nuevoDer;
    }
    /*public boolean equals(Object o2){
        NodoGen n=(NodoGen)o2;
        return this.elem==n.elem&&this.hijoIzq==n.hijoIzq&&this.hermanoDer==n.hermanoDer;
    }*/
}
