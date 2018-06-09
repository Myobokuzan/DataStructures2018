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
public class PilaInt {
  private NodoInt tope;
  public PilaInt(){
      this.tope=null;
  }
  public boolean apilar(int nuevoElem){
      NodoInt nodoNuevo=new NodoInt(nuevoElem,this.tope);
      this.tope=nodoNuevo;
      return true;
  }
  public boolean desapilar(){
      boolean exito;
      if(this.tope==null){
          exito=false;
      }else{
          this.tope=this.tope.getEnlace();
          exito=true;
      }
      return exito;
  }
  public int obtenerTope(){
      if(this.tope!=null){
          return this.tope.getElem();
      }else{
          return Integer.MIN_VALUE;
      }
  }
  public boolean esVacia(){
      boolean exito;
      return exito=this.tope==null;
  }
  public void vaciar(){
      this.tope=null;
  }
  private NodoInt cloneNodos(NodoInt nodo){
      NodoInt nuevoNodo;
      if(nodo.getEnlace()==null){
          nuevoNodo=new NodoInt(nodo.getElem());
      }else{
          nuevoNodo=new NodoInt(nodo.getElem(),cloneNodos(nodo.getEnlace()));
      }
      return nuevoNodo;
  }
  public PilaInt clone(){
      PilaInt pilaClon=new PilaInt();
      pilaClon.tope=cloneNodos(this.tope);
      return pilaClon;
  }
  public String toString(){
      String cadena="";
      if(this.tope==null){
          cadena="Pila vacía";
      }else{
          cadena="[";
          NodoInt aux=this.tope;
          while(aux!=null){
              cadena +=aux.getElem();
              aux=aux.getEnlace();
              if(aux!=null){
                  cadena +=",";
              }
          }
          cadena +="]";
      }
      
      return cadena;
  }
}
