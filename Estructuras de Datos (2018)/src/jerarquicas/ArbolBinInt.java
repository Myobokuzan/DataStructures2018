/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;
import lineales.dinamicas.*;
/**
 *
 * @author tomas
 */
public class ArbolBinInt {
    //Atributos
    private NodoArbolInt raiz;
    //Constructor
    public ArbolBinInt(){
        this.raiz=null;
    }
    private boolean equals(NodoArbolInt nodo,NodoArbolInt nodo2){
        boolean equal=false;
        if(nodo==null&&nodo2==null){
            equal=true;
        }else{
            if(nodo!=null&&nodo2!=null){
            if(nodo.getElem()==nodo2.getElem()){
                equal=equals(nodo.getIzquierdo(),nodo2.getIzquierdo());
            }
            if(equal){
                equal=equals(nodo.getDerecho(),nodo2.getDerecho());
            }
        }
    }
        return equal;
    }
    public boolean equals(ArbolBinInt otro){
        return equals(this.raiz,otro.raiz);
    }
    private NodoArbolInt clonarInvertido(NodoArbolInt nodo){
        NodoArbolInt clon=null;
        if(nodo!=null){
            clon=new NodoArbolInt(nodo.getElem());
            clon.setIzquierdo(clonarInvertido(nodo.getDerecho()));
            clon.setDerecho(clonarInvertido(nodo.getIzquierdo()));
        }
        return clon;
    }
    public ArbolBinInt clonarInvertido(){
        ArbolBinInt clonArbol=new ArbolBinInt();
        clonArbol.raiz=clonarInvertido(this.raiz);
        return clonArbol;
    }
    private void frontera(NodoArbolInt nodo,ListaInt lista){
        if(nodo!=null){
            if(nodo.getIzquierdo()==null&&nodo.getDerecho()==null){
                lista.insertar(nodo.getElem(),lista.longitud()+1);
            }else{
                frontera(nodo.getIzquierdo(),lista);
                frontera(nodo.getDerecho(),lista);
            }
        }
    }
    public ListaInt frontera(){
        ListaInt lista=new ListaInt();
        frontera(this.raiz,lista);
        return lista;
    }
    private boolean verificarPatron(NodoArbolInt nodo,ListaInt lisPatron,int pos){
        boolean exito=false;
        if(nodo!=null){
            if(pos<=lisPatron.longitud()){
                if(nodo.getIzquierdo()==null&&nodo.getDerecho()==null){
                    if(nodo.getElem()==lisPatron.recuperar(pos)&&pos==lisPatron.longitud()){
                        exito=true;
                    }
                }else{
                    if(nodo.getElem()==lisPatron.recuperar(pos)){
                    exito=verificarPatron(nodo.getIzquierdo(),lisPatron,pos+1);
                    if(!exito){
                        exito=verificarPatron(nodo.getDerecho(),lisPatron,pos+1);
                        }
                    }
                }
            }
        }
        return exito;
    }
    public boolean verificarPatron(ListaInt lisPatron){
        return verificarPatron(this.raiz,lisPatron,1);
    }
    private NodoArbolInt obtenerNodo(NodoArbolInt n,int elem){
        NodoArbolInt res=null;
        if(n!=null){
            if(n.getElem()==elem){
                res=n;
            }else{
                res=obtenerNodo(n.getIzquierdo(),elem);
            }
            if(res==null){
                res=obtenerNodo(n.getDerecho(),elem);
            }
        }
        return res;
    }
    public boolean insertar(int elemNuevo,int elemPadre,char lugar){
        boolean exito=true;
        NodoArbolInt padre=obtenerNodo(this.raiz,elemPadre);
        if(this.raiz==null){
            this.raiz=new NodoArbolInt(elemNuevo);
        }else{
            if(padre==null){
                exito=false;
            }else{
                if(lugar=='I'&&padre.getIzquierdo()==null){
                    padre.setIzquierdo(new NodoArbolInt(elemNuevo));
                }else{
                    if(lugar=='D'&&padre.getDerecho()==null){
                        padre.setDerecho(new NodoArbolInt(elemNuevo));
                    }else{
                        exito=false;
                    }
                }
            }
        }
        return exito;
    }
    private int padre(NodoArbolInt nodo,int elem){
        int elemPadre=Integer.MIN_VALUE;
        if(nodo!=null){
            if((nodo.getIzquierdo()!=null&&nodo.getIzquierdo().getElem()==elem)||(nodo.getDerecho()!=null&&nodo.getDerecho().getElem()==elem)){
                elemPadre=nodo.getElem();
            }else{
                elemPadre=padre(nodo.getIzquierdo(),elem);
                if(elemPadre==Integer.MIN_VALUE){
                    elemPadre=padre(nodo.getDerecho(),elem);
                }
            }
        }
        return elemPadre;
    }
    public int padre(int elem){
        return padre(this.raiz,elem);
    }
    private int altura(NodoArbolInt nodo){
        int i=-1,j=-1,res=-1;
        if(nodo!=null){
            i=altura(nodo.getIzquierdo())+1;
            j=altura(nodo.getDerecho())+1;
            if(i>=j){
                res=i;
            }else{
                res=j;
            }
        }
        return res;
    }
    public int altura(){
        return altura(this.raiz);
    }
    private int nivel(NodoArbolInt nodo,int elem){
        int niv=-1;
        if(nodo!=null){
            if(nodo.getElem()==elem){
                niv=0;
            }else{
                niv=nivel(nodo.getIzquierdo(),elem)+1;
                if(niv==0){
                    niv=nivel(nodo.getDerecho(),elem)+1;
                }
                if(niv==0){
                    niv=-1;
                }
            }
        }
        return niv;
    }
    public int nivel(int elem){
        return nivel(this.raiz,elem);
    }
    private void listarPreorden(NodoArbolInt nodo,ListaInt lista){
        if(nodo!=null){
            lista.insertar(nodo.getElem(),lista.longitud()+1);
            listarPreorden(nodo.getIzquierdo(),lista);
            listarPreorden(nodo.getDerecho(),lista);
        }
    }
    public ListaInt listarPreorden(){
        ListaInt nuevaLista=new ListaInt();
        listarPreorden(this.raiz,nuevaLista);
        return nuevaLista;
    }
    private void listarInorden(NodoArbolInt nodo,ListaInt lista){
        if(nodo!=null){
            listarPreorden(nodo.getIzquierdo(),lista);
            lista.insertar(nodo.getElem(),lista.longitud()+1);
            listarPreorden(nodo.getDerecho(),lista);
        }
    }
    public ListaInt listarInorden(){
        ListaInt nuevaLista=new ListaInt();
        listarInorden(this.raiz,nuevaLista);
        return nuevaLista;
    }
    private void listarPosorden(NodoArbolInt nodo,ListaInt lista){
        if(nodo!=null){
            listarPosorden(nodo.getIzquierdo(),lista);
            listarPosorden(nodo.getDerecho(),lista);
            lista.insertar(nodo.getElem(),lista.longitud()+1);
        }
    }
    public ListaInt listarPosorden(){
        ListaInt nuevaLista=new ListaInt();
        listarPosorden(this.raiz,nuevaLista);
        return nuevaLista;
    }
    public boolean esVacio(){
        return this.raiz==null;
    }
    public void vaciar(){
        this.raiz=null;
    }
    //private ListaInt listarPorNiveles(){
        
    //}
    private String toString(NodoArbolInt nodo){
        String cadena="";
        if(nodo!=null){
            cadena="Nodo:"+cadena+nodo.getElem();
            if(nodo.getIzquierdo()!=null){
                cadena=cadena+" hi:"+nodo.getIzquierdo().getElem();
            }else{
                cadena=cadena+" hi:-";
            }
            if(nodo.getDerecho()!=null){
                cadena=cadena+" hd:"+nodo.getDerecho().getElem()+"\n";
            }else{
                cadena=cadena+" hd:-"+"\n";
            }
            cadena=cadena+toString(nodo.getIzquierdo());
            cadena=cadena+toString(nodo.getDerecho());
        }
            
        return cadena;
    }
    public String toString(){
        String cad="raiz: ";
        return cad+toString(this.raiz);
    }
    private NodoArbolInt clone(NodoArbolInt nodo){
        NodoArbolInt clon=null;
        if(nodo!=null){
            clon=new NodoArbolInt(nodo.getElem());
            clon.setIzquierdo(clone(nodo.getIzquierdo()));
            clon.setDerecho(clone(nodo.getDerecho()));
        }
        return clon;
    }
    public ArbolBinInt clone(){
        ArbolBinInt nuevoArbol=new ArbolBinInt();
        nuevoArbol.raiz=clone(this.raiz);
        return nuevoArbol;
    }
}