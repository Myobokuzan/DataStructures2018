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
public class ColaChar {
    private NodoChar frente;
    private NodoChar fin;
   
   //Constructor
   public ColaChar(){
       this.frente=null;
       this.fin=null;
   }
   
   //Modificadores
   public boolean poner(char elem){
       NodoChar nuevoNodo=new NodoChar(elem);
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
   public char obtenerFrente(){
       char res;
       if(this.frente==null){
           res='?';
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
   
       public NodoChar cloneNodos(NodoChar nodo){
       NodoChar nuevoNodo;
       if(nodo.getEnlace()==null){
       nuevoNodo=new NodoChar(nodo.getElem());
   }else{
       nuevoNodo=new NodoChar(nodo.getElem(),cloneNodos(nodo.getEnlace()));
       }
       return nuevoNodo;
   }
   
   public ColaChar clone(){
       ColaChar colaClon=new ColaChar();
       colaClon.frente=cloneNodos(this.frente);
       NodoChar aux=colaClon.frente;
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
          NodoChar aux=this.frente;
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
