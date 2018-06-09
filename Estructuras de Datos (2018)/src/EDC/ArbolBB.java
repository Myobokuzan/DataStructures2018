/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDC;

import lineales.dinamicas.ListaGen;

/**
 *
 * @author tomas
 */
public class ArbolBB {
    private NodoABB raiz;
    public ArbolBB(){
        this.raiz=null;
    }
    //SIMULACRO 
    private void eliminarMin(NodoABB n){
        if(n!=null){
            NodoABB izq=n.getIzquierdo();
            if(izq!=null){
                if(izq.getIzquierdo()==null){
                    n.setIzquierdo(izq.getDerecho());
                }else{
                    eliminarMin(izq);
                }
            }
        }
    }
    public void eliminarMimino(){
        eliminarMin(this.raiz);
    }
    private NodoABB obtenerRaiz(NodoABB n,Comparable elem){
        NodoABB nodo=null;
        if(n!=null){
            if(n.getElem().compareTo(elem)==0){
                nodo=n;
            }else{
                if(n.getElem().compareTo(elem)>0){
                    nodo=obtenerRaiz(n.getIzquierdo(),elem);
                }else{
                    nodo=obtenerRaiz(n.getDerecho(),elem);
                }
            }
        }
        return nodo;
    }
    private NodoABB clonarInv(NodoABB n){
        NodoABB nodo=null;
        if(n!=null){
            nodo=new NodoABB(n.getElem());
            nodo.setIzquierdo(clonarInv(n.getDerecho()));
            nodo.setDerecho(clonarInv(n.getIzquierdo()));
        }
        return nodo;
    }
    public ArbolBB clonarParteInvertida(Comparable elem){
        ArbolBB arbol=new ArbolBB();
        arbol.raiz=clonarInv(obtenerRaiz(this.raiz,13));
        return arbol;
    }
    //FIN SIMULACRO
    private boolean pertenece(NodoABB n,Comparable elem){
        boolean exito=false;
        if(n!=null){
            if(n.getElem().compareTo(elem)==0){
                exito=true;
            }else{
                if(n.getElem().compareTo(elem)>0){
                    exito=pertenece(n.getIzquierdo(),elem);
                }else{
                    exito=pertenece(n.getDerecho(),elem);
                }
            }
        }
        return exito;
    }
    public boolean pertenece(Comparable elem){
        return pertenece(this.raiz,elem);
    }
    private boolean insertarAux(NodoABB n,Comparable elem){
        boolean exito;
        if(n.getElem().compareTo(elem)==0){
            exito=false;
        }else{
        if(elem.compareTo(n.getElem())<0){
            if(n.getIzquierdo()==null){
                n.setIzquierdo(new NodoABB(elem));
                exito=true;
            }else{
                exito=insertarAux(n.getIzquierdo(),elem);
            }
        }else{
            if(n.getDerecho()==null){
                n.setDerecho(new NodoABB(elem));
                exito=true;
            }else{
                exito=insertarAux(n.getDerecho(),elem);
            }
        }
        }
        return exito;
    }
    public boolean insertar(Comparable elem){
        boolean exito=false;
        if(this.raiz==null){
            this.raiz=new NodoABB(elem);
            exito=true;
        }else{
            exito=insertarAux(this.raiz,elem);
        }
        return exito;
    }
    public NodoABB candidato(NodoABB n){
        NodoABB nodo;
        if(n.getIzquierdo()!=null){
            nodo=candidato(n.getIzquierdo());
        }else{
            nodo=n;
        }
        return nodo;
    }
    private NodoABB obtenerPadre(NodoABB n,Comparable elem){
        NodoABB nodo=null;
        if(n!=null){
            if((n.getIzquierdo()!=null&&n.getIzquierdo().getElem().compareTo(elem)==0)||(n.getDerecho()!=null&&n.getDerecho().getElem().compareTo(elem)==0)){
                nodo=n;
            }else{
                if(n.getElem().compareTo(elem)>0){
                    nodo=obtenerPadre(n.getIzquierdo(),elem);
                }else{
                    nodo=obtenerPadre(n.getDerecho(),elem);
                }
            }
        }
        return nodo;
    }
    private void caso1(NodoABB p,NodoABB n){
        if(p.getIzquierdo()!=null&&p.getIzquierdo().getElem().equals(n.getElem())){
            p.setIzquierdo(null);
        }else{
            if(p.getDerecho()!=null&&p.getDerecho().equals(n)){
            p.setDerecho(null);
            }
        }
    }
    private void caso2(NodoABB p,NodoABB n){
        if(p.getIzquierdo()!=null&&p.getIzquierdo().getElem().equals(n.getElem())){
            if(n.getIzquierdo()!=null){
                p.setIzquierdo(n.getIzquierdo());
            }else{
                p.setIzquierdo(n.getDerecho());
            }
        }else{
            if(n.getIzquierdo()!=null){
                p.setDerecho(n.getIzquierdo());
            }else{
                p.setDerecho(n.getDerecho());
            }
        }    
    }
    private void caso3(NodoABB p,NodoABB n){
        NodoABB candidato=candidato(n.getDerecho());
        System.out.println("yo soy candidato: "+candidato.getElem());
        NodoABB padreCandidato=obtenerPadre(this.raiz,candidato.getElem());
        System.out.println("yo soy el padre del candidato: "+padreCandidato.getElem());
        n.setElem(candidato.getElem());
        if(candidato.getIzquierdo()==null&&candidato.getDerecho()==null){
            caso1(padreCandidato,candidato);
        }else{
            caso2(padreCandidato,candidato);
        }
    }
    private boolean eliminarAux(Comparable elem){
        boolean exito=false;
        NodoABB padre,nodo=null;
        if(this.raiz!=null){
            if(this.raiz.getElem().compareTo(elem)==0){
                padre=this.raiz;
                nodo=this.raiz;
            }else{
                padre=obtenerPadre(this.raiz,elem);
                if(padre!=null){
                if(padre.getIzquierdo()!=null&&padre.getIzquierdo().getElem().compareTo(elem)==0){
                        nodo=padre.getIzquierdo();
                    }else{
                        nodo=padre.getDerecho();
                    }
                }
            }
               if(padre!=null){
                    if(nodo.getIzquierdo()==null&&nodo.getDerecho()==null){
                        caso1(padre,nodo);
                        exito=true;
                    }else{
                        if(nodo.getIzquierdo()!=null&&nodo.getDerecho()!=null){
                            caso3(padre,nodo);
                            exito=true;
                        }else{
                            caso2(padre,nodo);
                            exito=true;
                        }
                    }
                }
            }
        return exito;
    }
    public boolean eliminar(Comparable elem){
        return eliminarAux(elem);
    }
    private void listarAux(NodoABB n,ListaGen ls){
        if(n!=null){
           listarAux(n.getIzquierdo(),ls);
           ls.insertar(n.getElem(),ls.longitud()+1);
           listarAux(n.getDerecho(),ls);
        }
    }
    public ListaGen listar(){
        ListaGen lista=new ListaGen();
        listarAux(this.raiz,lista);
        return lista;
    }
    private void listarRango(NodoABB n,Comparable min,Comparable max,ListaGen ls){
        if(n!=null){
            if(n.getElem().compareTo(min)>=0){
                listarRango(n.getIzquierdo(),min,max,ls);
                if(n.getElem().compareTo(max)<=0){
                    ls.insertar(n.getElem(),ls.longitud()+1);
                    listarRango(n.getDerecho(),min,max,ls);
                }
            }else{
                listarRango(n.getDerecho(),min,max,ls);
                if(n.getElem().compareTo(min)>=0){
                    ls.insertar(n.getElem(),ls.longitud()+1);
                    listarRango(n.getIzquierdo(),min,max,ls);
                }
            }
        }
    }
    public ListaGen listarRango(Comparable min,Comparable max){
        ListaGen ls=new ListaGen();
        listarRango(this.raiz,min,max,ls);
        return ls;
    }
    private Comparable minimoElem(NodoABB n){
        Comparable res;
        if(n.getIzquierdo()!=null){
            res=minimoElem(n.getIzquierdo());
        }else{
            res=n.getElem();
        }
        return res;
    }
    public Comparable minimoElem(){
        return minimoElem(this.raiz);
    }
    private Comparable maximoElem(NodoABB n){
        Comparable res;
        if(n.getDerecho()!=null){
            res=maximoElem(n.getDerecho());
        }else{
            res=n.getElem();
        }
        return res;
    }
    public Comparable maximoElem(){
        return maximoElem(this.raiz);
    }
    public boolean esVacio(){
        return this.raiz==null; 
    }
    private String toString(NodoABB n){
        String s="";
        if(n!=null){
            s="Nodo: "+s+n.getElem();
            if(n.getIzquierdo()!=null){
                s=s+" HI:"+n.getIzquierdo().getElem();
            }else{
                s=s+" HI:-";
            }
            if(n.getDerecho()!=null){
                s=s+" HD: "+n.getDerecho().getElem()+"\n";
            }else{
                s=s+" HD:-"+"\n";
            }
            s=s+toString(n.getIzquierdo());
            s=s+toString(n.getDerecho());
        }
        return s;
    }
    @Override
    public String toString(){
        return "Raiz: "+toString(this.raiz);
    }
}