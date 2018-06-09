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
public class PilaChar {
   private NodoChar tope;
   public PilaChar(){
      this.tope=null;
  }
  public boolean apilar(char nuevoElem){
      boolean exito;
      NodoChar nodoNuevo;
          nodoNuevo=new NodoChar(nuevoElem,this.tope);
          this.tope=nodoNuevo;
          exito=true;
      return exito;
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
  public char obtenerTope(){
      char tope;
      if(this.tope!=null){
          tope=this.tope.getElem();
      }else{
          tope='?';
      }
      return tope;
  }
  public boolean esVacia(){
      boolean exito;
      return exito=this.tope==null;
  }
  public void vaciar(){
      this.tope=null;
  }
  private NodoChar cloneNodos(NodoChar nodo){
      NodoChar nuevoNodo;
      if(nodo.getEnlace()==null){
          nuevoNodo=new NodoChar(nodo.getElem());
      }else{
          nuevoNodo=new NodoChar(nodo.getElem(),cloneNodos(nodo.getEnlace()));
      }
      return nuevoNodo;
  }
  public PilaChar clone(){
      PilaChar pilaClon=new PilaChar();
      pilaClon.tope=cloneNodos(this.tope);
      return pilaClon;
  }
  public String toString(){
      String cadena="";
      if(this.tope==null){
          cadena="Pila vacía";
      }else{
          cadena="[";
          NodoChar aux=this.tope;
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
