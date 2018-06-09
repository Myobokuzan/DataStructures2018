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
public class ListaChar {
    //Atributos
NodoChar cabecera;
int longitud;
//Constructor
public ListaChar(){
    this.cabecera=null;
    this.longitud=0;
}
public int cab(){
    return this.cabecera.getElem();
}
/*public void eliminarApariciones(int x){
    if(this.cabecera!=null){
    NodoInt aux=this.cabecera;
    NodoInt aux2=this.cabecera.getEnlace();
    while(aux2!=null){
        if(this.cabecera.getElem()==x){
            this.cabecera=this.cabecera.getEnlace();
            aux=this.cabecera;
            aux2=this.cabecera.getEnlace();
        }else{
            if(aux2.getElem()==x){
                aux.setEnlace(aux2.getEnlace());
                if(aux2.getEnlace().getEnlace()!=null){
                    aux=aux2.getEnlace();
                    aux2.getEnlace().getEnlace();
                    System.out.println("aiuda");
                }else{
                    aux=aux2;
                    aux2=aux2.getEnlace();
                    System.out.println("khe");
                }
            }
        }
    }
    }
}*/
/*private void insertarPromedio(int suma,NodoInt nodo){
    if(nodo!=null){
        if(nodo.getEnlace()==null){
            nodo.setEnlace(new NodoInt((suma+nodo.getElem())/this.longitud));
            this.longitud++;
        }else{
            insertarPromedio(suma+nodo.getElem(),nodo.getEnlace());
        }
    }
}
public void insertarPromedio(){
    insertarPromedio(0,this.cabecera);
}
/*public void insertarPromedio(){
    int suma=0;
    NodoInt aux=this.cabecera;
    NodoInt aux2=this.cabecera;
    while(aux2!=null){
        suma=suma+aux2.getElem();
        aux=aux2;
        aux2=aux2.getEnlace();
    }
    if(this.longitud!=0){
        int prom=suma/this.longitud;
        aux.setEnlace(new NodoInt(prom));
        this.longitud++;
    }
}*/
public boolean insertar(char elem,int pos){
    boolean exito;
    int i=1;
    if(pos<1||pos>this.longitud+1){
        exito=false;
    }else{
        NodoChar nuevo=new NodoChar(elem);
        if(pos==1){
            nuevo.setEnlace(this.cabecera);
            this.cabecera=nuevo;
            exito=true;
        }else{
        
        NodoChar ant=this.cabecera;
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
        NodoChar ant=this.cabecera;
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
public char recuperar(int pos){
    char elem;
    if(pos<1||pos>this.longitud+1||this.cabecera==null){
        elem='?';
    }else{
        NodoChar nodo=this.cabecera;
        for(int i=1;i<pos;i++){
            nodo=nodo.getEnlace();
        }
        elem=nodo.getElem();
    }
    return elem;
}
public int localizar(char elem){
    int pos=1;
    boolean encontrado=false;
    NodoChar aux=this.cabecera;
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
public NodoChar cloneNodos(NodoChar nodo){
       NodoChar nuevoNodo;
       if(nodo.getEnlace()==null){
       nuevoNodo=new NodoChar(nodo.getElem());
   }else{
       nuevoNodo=new NodoChar(nodo.getElem(),cloneNodos(nodo.getEnlace()));
       }
       return nuevoNodo;
   }
public ListaChar clone(){
       ListaChar listaClon=new ListaChar();
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
          NodoChar aux=this.cabecera;
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
