/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Tomas
 */
public class ColaGen {
    private NodoGen2 frente;
    private NodoGen2 fin;
   
   //Constructor
   public ColaGen(){
       this.frente=null;
       this.fin=null;
   }
   
   //Modificadores
   public boolean poner(Object elem){
       NodoGen2 nuevoNodo=new NodoGen2(elem);
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
   public Object obtenerFrente(){
       Object res;
       if(this.frente==null){
           res=null;
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
   
       public NodoGen2 cloneNodos(NodoGen2 nodo){
       NodoGen2 nuevoNodo;
       if(nodo.getEnlace()==null){
       nuevoNodo=new NodoGen2(nodo.getElem());
   }else{
       nuevoNodo=new NodoGen2(nodo.getElem(),cloneNodos(nodo.getEnlace()));
       }
       return nuevoNodo;
   }
   
   public ColaGen clone(){
       ColaGen colaClon=new ColaGen();
       colaClon.frente=cloneNodos(this.frente);
       NodoGen2 aux=colaClon.frente;
       while(aux.getEnlace()!=null){
           aux=aux.getEnlace();
       }
       colaClon.fin=aux;
       return colaClon;
   }
   public Object obtenerFin(){
       return this.fin.getElem();
   }
   public String toString(){
       String cadena="";
      if(this.frente==null){
          cadena="Cola vacía";
      }else{
          cadena="<-";
          NodoGen2 aux=this.frente;
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
