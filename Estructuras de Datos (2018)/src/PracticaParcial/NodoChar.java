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
public class NodoChar {
  private char elem;
  private NodoChar enlace;
//Constructores
public NodoChar(char elem,NodoChar enlace){
    this.elem=elem;
    this.enlace=enlace;
}  
public NodoChar(char elemN){
    this.elem=elemN;
    this.enlace=null;
}
//
public char getElem(){
    return elem;
}
public void setElem(char elem){
    this.elem=elem;
}
public NodoChar getEnlace(){
    return enlace;
}
public void setEnlace(NodoChar enlaceN){
    this.enlace=enlaceN;
}
}
