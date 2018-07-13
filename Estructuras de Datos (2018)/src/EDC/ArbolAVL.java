/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDC;

import lineales.dinamicas.ListaGen;
/**
 *
 * @author Tomas
 */
public class ArbolAVL{
    private NodoAVL raiz;
    public ArbolAVL(){
        raiz=null;
    }
    public int imprimirRaiz(){
        return (int)this.raiz.getElem();
    }
    private boolean pertenece(NodoAVL n,Comparable elem){
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
    private boolean insertarAux(NodoAVL n,Comparable elem){
        boolean exito;
        if(n.getElem().compareTo(elem)==0){
            exito=false;
        }else{
            if(elem.compareTo(n.getElem())<0){
                if(n.getIzquierdo()==null){
                    n.setIzquierdo(new NodoAVL(elem));
                    exito=true;
                    n.recalcularAltura();
                }else{
                    exito=insertarAux(n.getIzquierdo(),elem);
                }
            }else{
                if(n.getDerecho()==null){
                    n.setDerecho(new NodoAVL(elem));
                    exito=true;
                    n.recalcularAltura();
                }else{
                    exito=insertarAux(n.getDerecho(),elem);
                    n.recalcularAltura();
                    rotacionDeHijoDer(n);
                }
            }
        }
        return exito;
    }
    private NodoAVL rotacionDeRaiz(NodoAVL n){
        NodoAVL nuevaRaiz=n;
        if(calcularBalance(n)==2){
            if(calcularBalance(n.getIzquierdo())==1||calcularBalance(n.getIzquierdo())==0){
                    nuevaRaiz=rotarDerecha(n);
            }else{
                //rotarIzquierda(this.raiz.getIzquierdo());
                //rotarDerecha(this.raiz);
            }
        }else{
            if(calcularBalance(n)==-2){
                if(calcularBalance(n.getDerecho())==-1||calcularBalance(n.getDerecho())==0){
                    nuevaRaiz=rotarIzquierda(n);
                }else{
                    //rotarDerecha(this.raiz);
                    //rotarIzquierda(this.raiz);
                }
            }
        }
        return nuevaRaiz;
    }
    private void rotacionDeHijoDer(NodoAVL n){
        if(calcularBalance(n.getDerecho())==2){
                if(calcularBalance(n.getDerecho().getIzquierdo())==1||calcularBalance(n.getDerecho().getIzquierdo())==0){
                    n.setDerecho(rotarDerecha(n.getDerecho()));
                }else{
                    rotarIzquierda(n.getIzquierdo());
                    rotarDerecha(n);
                }
            }else{
                if(calcularBalance(n.getDerecho())==-2){
                    if(calcularBalance(n.getDerecho().getDerecho())==-1||calcularBalance(n.getDerecho().getDerecho())==0){
                        n.setDerecho(rotarIzquierda(n.getDerecho()));
                    }else{
                        rotarDerecha(n.getDerecho());
                        rotarIzquierda(n);
                    }
                }
            }
    }
    private void rotacionDeHijoIzq(NodoAVL n){
        if(calcularBalance(n.getIzquierdo())==2){
                if(calcularBalance(n.getIzquierdo().getIzquierdo())==1||calcularBalance(n.getIzquierdo().getIzquierdo())==0){
                    n.setIzquierdo(rotarDerecha(n.getIzquierdo()));
                }else{
                    //rotarIzquierda(n.getIzquierdo());
                    //rotarDerecha(n);
                }
            }else{
                if(calcularBalance(n.getIzquierdo())==-2){
                    if(calcularBalance(n.getIzquierdo().getDerecho())==-1||calcularBalance(n.getIzquierdo().getDerecho())==0){
                        n.setIzquierdo(rotarDerecha(n.getIzquierdo()));
                    }else{
                        //rotarDerecha(n.getDerecho());
                        //rotarIzquierda(n);
                    }
                }
            }
    }
    private NodoAVL rotarDerecha(NodoAVL r){
        NodoAVL h,temp;
        h=r.getIzquierdo();
        temp=h.getDerecho();
        h.setDerecho(r);
        r.setIzquierdo(temp);
        return h;
    }
    private NodoAVL rotarIzquierda(NodoAVL r){
        NodoAVL h,temp;
        h=r.getDerecho();
        temp=h.getIzquierdo();
        h.setIzquierdo(r);
        r.setDerecho(temp);
        return h;
    }
    private int calcularBalance(NodoAVL n){
        int bal;
        if(n.getIzquierdo()==null){
                if(n.getDerecho()==null){
                    bal=0;
                }else{
                    bal=-1-n.getDerecho().getAltura();
                }
            }else{
                if(n.getDerecho()==null){
                    bal=n.getIzquierdo().getAltura()+1;
                }else{
                    bal=n.getIzquierdo().getAltura()-n.getDerecho().getAltura();
                }
            }
        return bal;
    }    
    public boolean insertar(Comparable elem){
        boolean exito;
        if(this.raiz==null){
            this.raiz=new NodoAVL(elem);
            exito=true;
        }else{
            exito=insertarAux(this.raiz,elem);
            this.raiz.recalcularAltura();
            if(calcularBalance(this.raiz)==2||calcularBalance(this.raiz)==-2){
                this.raiz=rotacionDeRaiz(this.raiz);
            }
            this.raiz.recalcularAltura();
        }
        return exito;
    }
    public NodoAVL candidato(NodoAVL n){
        NodoAVL nodo;
        if(n.getIzquierdo()!=null){
            nodo=candidato(n.getIzquierdo());
        }else{
            nodo=n;
        }
        return nodo;
    }
    private NodoAVL obtenerPadre(NodoAVL n,Comparable elem){
        NodoAVL nodo=null;
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
    private void caso1(NodoAVL p,NodoAVL n){
        if(p.getIzquierdo()!=null&&p.getIzquierdo().getElem().equals(n.getElem())){
            p.setIzquierdo(null);
        }else{
            if(p.getDerecho()!=null&&p.getDerecho().equals(n)){
            p.setDerecho(null);
            }
        }
    }
    private void caso2(NodoAVL p,NodoAVL n){
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
    private void caso3(NodoAVL p,NodoAVL n){
        NodoAVL candidato=candidato(n.getDerecho());
        System.out.println("yo soy candidato: "+candidato.getElem());
        NodoAVL padreCandidato=obtenerPadre(this.raiz,candidato.getElem());
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
        NodoAVL padre,nodo=null;
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
    private void listarAux(NodoAVL n,ListaGen ls){
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
    private void listarRango(NodoAVL n,Comparable min,Comparable max,ListaGen ls){
        if(n!=null){
            System.out.println(n.getElem());
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
    private Comparable minimoElem(NodoAVL n){
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
    private Comparable maximoElem(NodoAVL n){
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
    private String toString(NodoAVL n){
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
