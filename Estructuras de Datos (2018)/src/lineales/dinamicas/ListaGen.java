/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

import jerarquicas.*;

/**
 *
 * @author tomas
 */
public class ListaGen{
    //Atributos
NodoGen2 cabecera;
int longitud;
//Constructor
public ListaGen(){
    this.cabecera=null;
    this.longitud=0;
}
public boolean insertar(Object elem,int pos){
    boolean exito;
    int i=1;
    if(pos<1||pos>this.longitud+1){
        exito=false;
    }else{
        NodoGen2 nuevo=new NodoGen2(elem);
        if(pos==1){
            nuevo.setEnlace(this.cabecera);
            this.cabecera=nuevo;
            exito=true;
        }else{
        
        NodoGen2 ant=this.cabecera;
        while(i<pos-1){
        ant=ant.getEnlace();
        i++;
        }
        nuevo.setEnlace(ant.getEnlace());
        ant.setEnlace(nuevo);
        exito=true;
        
    }
        this.longitud++;
    }
    return exito;
}
public boolean esVacia(){
    boolean vacia;
    return vacia=this.cabecera==null;
}
public int longitud(){
   return this.longitud;
}
public void vaciar(){
    this.cabecera=null;
    this.longitud=0;
}
public boolean eliminar(int pos){
    boolean exito;
    if(pos<1||pos>this.longitud+1||this.cabecera==null){
        exito=false;
    }else{
        if(pos==1){
            this.cabecera=this.cabecera.getEnlace();
        }else{
        NodoGen2 ant=this.cabecera;
        for(int i=1;i<pos-1;i++){
            ant=ant.getEnlace();
        }
        ant.setEnlace(ant.getEnlace().getEnlace());
        
        }
    }
    exito=true;
    this.longitud--;
    return exito;
}
public Object recuperar(int pos){
    Object elem;
    if(pos<1||pos>this.longitud+1||this.cabecera==null){
        elem=null;
    }else{
        NodoGen2 nodo=this.cabecera;
        for(int i=1;i<pos;i++){
            nodo=nodo.getEnlace();
        }
        elem=nodo.getElem();
    }
    return elem;
}
public int localizar(Object elem){
    int pos=1;
    boolean encontrado=false;
    NodoGen2 aux=this.cabecera;
    while(pos<=this.longitud&&encontrado==false){
        if(aux.getElem()==elem){
            encontrado=true;
        }else{
            aux=aux.getEnlace();
            pos++;
        }
    }
    if(encontrado==false){
        pos=-1;
    }
    return pos;
}
public NodoGen2 cloneNodos(NodoGen2 nodo){
       NodoGen2 nuevoNodo;
       if(nodo.getEnlace()==null){
       nuevoNodo=new NodoGen2(nodo.getElem());
   }else{
       nuevoNodo=new NodoGen2(nodo.getElem(),cloneNodos(nodo.getEnlace()));
       }
       return nuevoNodo;
   }
public ListaGen clone(){
       ListaGen listaClon=new ListaGen();
       listaClon.cabecera=cloneNodos(this.cabecera);
       listaClon.longitud=this.longitud;
       return listaClon;
   }
public String toString(){
       String cadena="";
      if(this.cabecera==null){
          cadena="Lista vacía";
      }else{
          cadena="-";
          NodoGen2 aux=this.cabecera;
          while(aux!=null){
              cadena +=aux.getElem();
              aux=aux.getEnlace();
              if(aux!=null){
                  cadena +=",";
              }
          }
          cadena +="-";
      }
      return cadena;
   }
}
