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
public class ColaInt {
   private NodoInt frente;
   private NodoInt fin;
   
   //Constructor
   public ColaInt(){
       this.frente=null;
       this.fin=null;
   }
   
   //Modificadores
   public boolean poner(int elem){
       NodoInt nuevoNodo=new NodoInt(elem);
       if(this.frente==null){
           this.frente=nuevoNodo;
           this.fin=nuevoNodo;
       }else{
           this.fin.setEnlace(nuevoNodo);
           this.fin=nuevoNodo;
       }
       return true;
   }
   
   public boolean sacar(){
       boolean exito;
       if(this.frente==null){
           exito=false;
       }else{
           if(this.frente==this.fin){
               this.frente=null;
               this.fin=null;
               exito=true;
           }else{
               this.frente=this.frente.getEnlace();
               exito=true;
           }
       }
       return exito;
   }
   
   public void vaciar(){
       this.frente=null;
       this.fin=null;
   }
   //Observadores
   public int obtenerFrente(){
       int res;
       if(this.frente==null){
           res=Integer.MIN_VALUE;
       }else{
           res=this.frente.getElem();
       }
       return res;
   }
   
   public boolean esVacia(){
       boolean vacia;
       return vacia=this.frente==null;
   }
   //
   
       public NodoInt cloneNodos(NodoInt nodo){
       NodoInt nuevoNodo;
       if(nodo.getEnlace()==null){
       nuevoNodo=new NodoInt(nodo.getElem());
   }else{
       nuevoNodo=new NodoInt(nodo.getElem(),cloneNodos(nodo.getEnlace()));
       }
       return nuevoNodo;
   }
   
   public ColaInt clone(){
       ColaInt colaClon=new ColaInt();
       colaClon.frente=cloneNodos(this.frente);
       NodoInt aux=colaClon.frente;
       while(aux.getEnlace()!=null){
           aux=aux.getEnlace();
       }
       colaClon.fin=aux;
       return colaClon;
   }
   public int obtenerFin(){
       return this.fin.getElem();
   }
   public String toString(){
       String cadena="";
      if(this.frente==null){
          cadena="Cola vacía";
      }else{
          cadena="<-";
          NodoInt aux=this.frente;
          while(aux!=null){
              cadena +=aux.getElem();
              aux=aux.getEnlace();
              if(aux!=null){
                  cadena +=",";
              }
          }
          cadena +="<-";
      }
      
      return cadena;
   }
}
   
