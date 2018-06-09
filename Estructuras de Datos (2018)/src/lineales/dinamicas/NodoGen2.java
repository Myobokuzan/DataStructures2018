/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author tomas
 */
public class NodoGen2 {
  private Object elem;
  private NodoGen2 enlace;
//Constructores
public NodoGen2(Object elem,NodoGen2 enlace){
    this.elem=elem;
    this.enlace=enlace;
}  
public NodoGen2(Object elemN){
    this.elem=elemN;
    this.enlace=null;
}
//
public Object getElem(){
    return elem;
}
public void setElem(Object elem){
    this.elem=elem;
}
public NodoGen2 getEnlace(){
    return enlace;
}
public void setEnlace(NodoGen2 enlaceN){
    this.enlace=enlaceN;
}
}
