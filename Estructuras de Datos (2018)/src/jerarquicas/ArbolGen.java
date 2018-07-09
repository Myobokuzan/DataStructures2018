/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.ListaGen;

/**
 *
 * @author tomas
 */
public class ArbolGen {
    private NodoGen raiz;
    //SIMULACRO PARCIAL ;_;
    /*private boolean verificarCamino(NodoGen n,ListaGen ls,int i){
        boolean exito=false;
        if(n!=null){
            if(n.getElem().equals(ls.recuperar(i))){
                if(i==ls.longitud()){
                    exito=true;
                }else{
                    exito=verificarCamino(n.getHijoIzquierdo(),ls,i+1);
                }
            }else{
                NodoGen h=n.getHermanoDerecho();
                while(h!=null&&!exito){
                    exito=verificarCamino(h,ls,i);
                    h=h.getHermanoDerecho();
                }
            }
        }
        return exito;
    }*/
    private void entreNiveles(NodoGen n, int min,int max,int lvlActual,ListaGen ls){
        if(n!=null){
            if(lvlActual<max){
                entreNiveles(n.getHijoIzquierdo(),min,max,lvlActual+1,ls);
            }
            if(lvlActual>=min&&lvlActual<=max){
                ls.insertar(n.getElem(),ls.longitud()+1);
            }
            //if(lvlActual+1<=max&&lvlActual+1>=min){
                if(n.getHijoIzquierdo()!=null){
                    NodoGen h=n.getHijoIzquierdo().getHermanoDerecho();
                    while(h!=null){
                        entreNiveles(h,min,max,lvlActual+1,ls);
                        h=h.getHermanoDerecho();
                    }
                }
            //}
        }
    }
    public ListaGen entreNiveles(int min,int max){
        ListaGen ls=new ListaGen();
        entreNiveles(this.raiz,min,max,0,ls);
        return ls;
    }
    private boolean verificarCamino(NodoGen n,ListaGen ls,int i){
        boolean exito=false;
        if(n!=null){
            if(n.getElem().equals(ls.recuperar(i))){
                if(i==ls.longitud()){
                    exito=true;
                }else{
                    exito=verificarCamino(n.getHijoIzquierdo(),ls,i+1);
                    if(!exito){
                        if(n.getHijoIzquierdo()!=null){
                        NodoGen h=n.getHijoIzquierdo().getHermanoDerecho();
                        while(!exito&&h!=null){
                            exito=verificarCamino(h,ls,i+1);
                            h=h.getHermanoDerecho();
                        }
                    }
                }
            }
        }
    }
        return exito;
    }
    public boolean verificarCamino(ListaGen ls){
        return verificarCamino(this.raiz,ls,1);
    }
    private void listarEntreNiveles(NodoGen n,int niv1,int niv2,int nivActual,ListaGen ls){
        if(n!=null){
            System.out.println(n.getElem());
            if(n.getHijoIzquierdo()!=null&&nivActual<niv2){
                listarEntreNiveles(n.getHijoIzquierdo(),niv1,niv2,nivActual+1,ls);
            }
            if(nivActual>=niv1){
                ls.insertar(n.getElem(),ls.longitud()+1);
            }
            if(n.getHijoIzquierdo()!=null){
                NodoGen h=n.getHijoIzquierdo().getHermanoDerecho();
                while(h!=null&&nivActual<niv2){
                    listarEntreNiveles(h,niv1,niv2,nivActual+1,ls);
                    h=h.getHermanoDerecho();
                }
            }
        }
    }
    public ListaGen listarEntreNiveles(int niv1,int niv2){
        ListaGen lista=new ListaGen();
        listarEntreNiveles(this.raiz,niv1,niv2,0,lista);
        return lista;
    }
    private boolean eliminar(NodoGen n,Object elem){
        boolean encontrado=false;
        if(n.getHijoIzquierdo()!=null){
            if(n.getHijoIzquierdo().getElem().equals(elem)){
                n.setHijoIzquierdo(n.getHijoIzquierdo().getHermanoDerecho());
                encontrado=true;
            }else{
                encontrado=eliminar(n.getHijoIzquierdo(),elem);
            }
        }
        if(!encontrado){
            if(n.getHijoIzquierdo()!=null){
                NodoGen h=n.getHijoIzquierdo().getHermanoDerecho();
                while(h!=null&&!encontrado){
                    if(h.getElem().equals(elem)){
                        n.getHijoIzquierdo().setHermanoDerecho(h.getHermanoDerecho());
                        encontrado=true;
                    }else{
                        encontrado=eliminar(h,elem);
                        h=h.getHermanoDerecho();
                    }
                }
            }
        }
        return encontrado;
    }
    public void eliminar(Object elem){
        if(this.raiz.getElem().equals(elem)){
            this.raiz=null;
        }else{
            eliminar(this.raiz,elem);
        }
        
    }
    private void listarHastaNivel(NodoGen n,int niv,int nivActual,ListaGen ls){
        if(n!=null){
            ls.insertar(n.getElem(),ls.longitud()+1);
            if(nivActual<niv){
                listarHastaNivel(n.getHijoIzquierdo(),niv,nivActual+1,ls);
                if(n.getHijoIzquierdo()!=null){
                    NodoGen h=n.getHijoIzquierdo();
                    while(h!=null){
                        listarHastaNivel(h,niv,nivActual,ls);
                        h=h.getHermanoDerecho();
                    }
                }
            }
        }
    }
    public ListaGen listarHastaNivel(int niv){
        ListaGen lista=new ListaGen();
        if(niv>=0){
            listarHastaNivel(this.raiz,niv,0,lista);
        }
        return lista;
    }
    
    //FIN SIMULACRO (lol)
    private NodoGen obtenerNodo(NodoGen n,Object elem){
        NodoGen res=null;
        NodoGen hijo;
        if(n!=null){
            if(n.getElem().equals(elem)){
                res=n;
            }else{
                hijo=n.getHijoIzquierdo();
                while(hijo!=null&&res==null){
                    res=obtenerNodo(hijo,elem);
                    hijo=hijo.getHermanoDerecho();
                }
            }
        }
        return res;
    } 
    public boolean insertar(Object padre,Object elem){
        boolean exito=false;
        if(this.raiz==null){
                this.raiz=new NodoGen(elem);
                exito=true;
            }else{
            NodoGen nodoPadre=obtenerNodo(this.raiz,padre);
            if(nodoPadre!=null){
                NodoGen nuevo=new NodoGen(elem);
                if(nodoPadre.getHijoIzquierdo()==null){
                    nodoPadre.setHijoIzquierdo(nuevo);
                }else{
                    NodoGen aux=nodoPadre.getHijoIzquierdo();
                    while(aux.getHermanoDerecho()!=null){
                        aux=aux.getHermanoDerecho();
                    }
                    aux.setHermanoDerecho(nuevo);
                    exito=true;
                }
            }
        }
        
        return exito;
    }
    public boolean pertenece(Object elem){
        return obtenerNodo(this.raiz,elem)!=null;
    }
    public boolean esVacio(){
        return this.raiz==null;
    }
    private Object padre(NodoGen n,Object elem){
        NodoGen hijo=n.getHijoIzquierdo();
        Object res=null;
        if(hijo!=null){
            while(hijo!=null&&res==null){
                if(hijo.getElem().equals(elem)){
                    res=n.getElem();
                }else{
                    res=padre(hijo,elem);
                    hijo=hijo.getHermanoDerecho();
                }
            }
        }
        return res;
    }
    public Object padre(Object elem){
        return padre(this.raiz,elem);
    }
    private int altura(NodoGen n){
        int alt,alt2;
        NodoGen hijo;
        if(n.getHijoIzquierdo()==null){
            alt=0;
        }else{
            alt=1+altura(n.getHijoIzquierdo());
        }
        if(n.getHijoIzquierdo()!=null){
            hijo=n.getHijoIzquierdo().getHermanoDerecho();
            while(hijo!=null){
                alt2=1+altura(hijo);
                if(alt2>alt){
                    alt=alt2;
                }
                hijo=hijo.getHermanoDerecho();
            }
        }
        return alt;
    }
    public int altura(){
        return altura(this.raiz);
    }
    private int nivel(NodoGen n,Object elem){
        int lvl=-1;
        NodoGen hijo;
        if(n!=null){
            if(n.getElem().equals(elem)){
                lvl=0;
            }else{
                hijo=n.getHijoIzquierdo();
                while(hijo!=null&&lvl==-1){
                    lvl=nivel(hijo,elem);
                    hijo=hijo.getHermanoDerecho();
                }
                if(lvl!=-1){
                    lvl=lvl+1;
                }
            }
        }
        return lvl;
    }
    public int nivel(Object elem){
        return nivel(this.raiz,elem);
    }
    private boolean ancestros(NodoGen n,Object elem,ListaGen ls){
        boolean encontrado=false;
        if(n!=null){
            if(n.getElem()==elem){
                ls.insertar(elem,1);
                encontrado=true;
            }else{
                NodoGen hijo=n.getHijoIzquierdo();
                while(hijo!=null&&encontrado==false){
                    encontrado=ancestros(hijo,elem,ls);
                    if(encontrado==false){
                        hijo=hijo.getHermanoDerecho();
                    }else{
                        ls.insertar(n.getElem(),1);
                    }
                }
            }
        }
        return encontrado;
    }
    public ListaGen ancestros(Object elem){
        ListaGen nuevaLs=new ListaGen();
        ancestros(this.raiz,elem,nuevaLs);
        return nuevaLs;
    }
    private NodoGen clone(NodoGen n){
        NodoGen clon=null,hijo;
        if(n!=null){
            clon=new NodoGen(n.getElem());
            clon.setHijoIzquierdo(n.getHijoIzquierdo());
            hijo=n.getHijoIzquierdo().getHermanoDerecho();
            while(hijo!=null){
                clon.setHermanoDerecho(hijo);
                hijo=hijo.getHermanoDerecho();
            }
        }
        return clon;
    }
    @Override
    public ArbolGen clone(){
        ArbolGen nuevoArbol=new ArbolGen();
        nuevoArbol.raiz=clone(this.raiz);
        return nuevoArbol;
    }
    public void vaciar(){
        this.raiz=null;
    }
    private void listarPreorden(NodoGen n,ListaGen ls){
        ls.insertar(n.getElem(),ls.longitud()+1);
        if(n.getHijoIzquierdo()!=null){
            listarPreorden(n.getHijoIzquierdo(),ls);
        }
        if(n.getHijoIzquierdo()!=null){
            NodoGen hijo=n.getHijoIzquierdo().getHermanoDerecho();
            while(hijo!=null){
                listarPreorden(hijo,ls);
                hijo=hijo.getHermanoDerecho();
            }
        }
    }
    public ListaGen listarPreorden(){
        ListaGen nueva=new ListaGen();
        listarPreorden(this.raiz,nueva);
        return nueva;
    }
    private void listarInorden(NodoGen n,ListaGen ls){
        
        if(n.getHijoIzquierdo()!=null){
            listarInorden(n.getHijoIzquierdo(),ls);
        }
        ls.insertar(n.getElem(),ls.longitud()+1);
        if(n.getHijoIzquierdo()!=null){
            NodoGen hijo=n.getHijoIzquierdo().getHermanoDerecho();
            while(hijo!=null){
                listarInorden(hijo,ls);
                hijo=hijo.getHermanoDerecho();
            }
        }
    }
    public ListaGen listarInorden(){
        ListaGen nueva=new ListaGen();
        listarInorden(this.raiz,nueva);
        return nueva;
    }
    private void listarPosorden(NodoGen n,ListaGen ls){
        
        if(n.getHijoIzquierdo()!=null){
            listarPosorden(n.getHijoIzquierdo(),ls);
        }
        
        if(n.getHijoIzquierdo()!=null){
            NodoGen hijo=n.getHijoIzquierdo().getHermanoDerecho();
            while(hijo!=null){
                listarPosorden(hijo,ls);
                hijo=hijo.getHermanoDerecho();
            }
        }
        ls.insertar(n.getElem(),ls.longitud()+1);
    }
    public ListaGen listarPosorden(){
        ListaGen nueva=new ListaGen();
        listarPosorden(this.raiz,nueva);
        return nueva;
    }
    @Override
    public String toString(){
        return toString(this.raiz);
    }
    private String toString(NodoGen n){
        String s="";
        if(n==null){
            s="Árbol vacío.";
        }else{
            s+=n.getElem().toString()+" -> ";
            NodoGen hijo=n.getHijoIzquierdo();
            while(hijo!=null){
                s+=hijo.getElem().toString()+", ";
                hijo=hijo.getHermanoDerecho();
            }
            hijo=n.getHijoIzquierdo();
            while(hijo!=null){
                s+="\n"+toString(hijo);
                hijo=hijo.getHermanoDerecho();
            }
        }
        return s;
    }
}


