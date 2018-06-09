/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Usuario
 */
public class NodoInt {
  private int elem;
  private NodoInt enlace;
//Constructores
public NodoInt(int elem,NodoInt enlace){
    this.elem=elem;
    this.enlace=enlace;
}  
public NodoInt(int elemN){
    this.elem=elemN;
    this.enlace=null;
}
//
public int getElem(){
    return elem;
}
public void setElem(int elem){
    this.elem=elem;
}
public NodoInt getEnlace(){
    return enlace;
}
public void setEnlace(NodoInt enlaceN){
    this.enlace=enlaceN;
}
}
