/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import TDAsEspeciales.ColaPrioridad;
import lineales.dinamicas.*;

/**
 *
 * @author Tomas
 */
public class GrafoEtiq {
    private NodoVert inicio;
    
    public GrafoEtiq(){
        this.inicio=null;
    }
    private NodoVert ubicarVertice(Object n){
        NodoVert aux=this.inicio;
        while(aux!=null&&!aux.getElem().equals(n)){
            aux=aux.getSigVert();
        }
        return aux;
    }
    public boolean insertarVertice(Object nuevo){
        boolean exito=false;
        if(ubicarVertice(nuevo)==null){
            exito=true;
            this.inicio=new NodoVert(nuevo,this.inicio);
        }
        return exito;
    }
    public boolean eliminarVertice(Object elem){
        boolean exito=false;
        NodoVert aux=this.inicio;
        NodoVert aux2=this.inicio;
        while(aux2!=null){
            eliminarArco(elem,aux2.getElem());
            eliminarArco(aux2.getElem(),elem);
            aux2=aux2.getSigVert();
        }
        if(aux!=null&&aux.getElem().equals(elem)){
            this.inicio=aux.getSigVert();
            exito=true;
        }else{
            boolean continuar=true;
            while(aux!=null&&continuar){
                if(aux.getSigVert()==null){
                    exito=false;
                    continuar=false;
                }else{
                    if(aux.getSigVert().getElem().equals(elem)){
                        exito=true;
                        continuar=false;
                        aux.setSigVert(aux.getSigVert().getSigVert());
                    }
                    aux=aux.getSigVert();
                }
            }
        }
        return exito;
    }
    public boolean existeVertice(Object elem){
        return ubicarVertice(elem)!=null;
    }
    private boolean insertarArco(Object origen,Object destino,boolean continuar,Object etiqueta){
        boolean exito=false;
        NodoVert nodoOrigen=ubicarVertice(origen);
        NodoVert nodoDest=ubicarVertice(destino);
        if(nodoOrigen!=null&&nodoDest!=null){
            NodoAdy aux=nodoOrigen.getPrimerAdy();
            if(aux!=null){
                while(aux.getSigAdyacente()!=null){
                    aux=aux.getSigAdyacente();
                }
                aux.setSigAdyacente(new NodoAdy(nodoDest,etiqueta));
            }else{
                nodoOrigen.setPrimerAdy(new NodoAdy(nodoDest,etiqueta));
            }
            exito=true;
            if(exito&&continuar){
                insertarArco(destino,origen,false,etiqueta);
            }
        }
        return exito;
    }
    public boolean insertarArco(Object origen,Object destino,Object etiqueta){
        return insertarArco(origen,destino,true,etiqueta);
    }
    private boolean eliminarArco(Object origen,Object destino,boolean continuar){
        NodoVert nodoOrigen=ubicarVertice(origen);
        NodoVert nodoDest=ubicarVertice(destino);
        boolean exito=false;
        if(nodoOrigen!=null&&nodoDest!=null){
            NodoAdy aux=nodoOrigen.getPrimerAdy();
            if(aux!=null){
                if(aux.getVertice().getElem().equals(destino)){
                    nodoOrigen.setPrimerAdy(aux.getSigAdyacente());
                    exito=true;
                }else{
                    while(aux.getSigAdyacente()!=null&&!aux.getSigAdyacente().getVertice().getElem().equals(destino)){
                        aux=aux.getSigAdyacente();
                    }
                    if(aux.getSigAdyacente()!=null){
                        aux.setSigAdyacente(aux.getSigAdyacente().getSigAdyacente());
                        exito=true;
                    }
                }
            }
            if(exito&&continuar){
                eliminarArco(destino,origen,false);
            }
        }
        return exito;
    }
    public boolean eliminarArco(Object origen,Object destino){
        return eliminarArco(origen,destino,true);
    }
    public boolean existeArco(Object origen,Object destino){
        boolean exito=false;
        NodoVert nodoOrigen=ubicarVertice(origen);
        NodoVert nodoDest=ubicarVertice(destino);
        if(nodoOrigen!=null&&nodoDest!=null){
            NodoAdy aux=nodoOrigen.getPrimerAdy();
            if(aux!=null){
                if(aux.getVertice().getElem().equals(destino)){
                    exito=true;
                }else{
                    while(aux!=null&&!aux.getVertice().getElem().equals(destino)){
                        aux=aux.getSigAdyacente();
                    }
                    if(aux!=null){
                        exito=true;
                    }
                }
            }
        }
        return exito;
    }
    public ListaGen caminoMasCorto(Object origen,Object dest){
        ListaGen ListaRes=new ListaGen();
        ListaGen visitados=new ListaGen();
        NodoVert nodoInicial=ubicarVertice(origen);
        ColaGen q=new ColaGen();
        q.poner(nodoInicial);
        if(nodoInicial!=null&&ubicarVertice(dest)!=null){
            ListaRes=caminoMasCortoAux(q,dest,visitados);
        }
        return ListaRes;
    }
    private ListaGen caminoMasCortoAux(ColaGen q,Object destino,ListaGen visitados){
        NodoAdy v=null;
        boolean encontrado=false;
        ListaGen res=new ListaGen();
        while(!q.esVacia()&&!encontrado){
                NodoVert u=((NodoVert)q.obtenerFrente());
                q.sacar();
                if(visitados.localizar(u.getElem())==-1){
                    visitados.insertar(u.getElem(),visitados.longitud()+1);
                        v=u.getPrimerAdy();
                        while(v!=null&&!encontrado){
                        if(visitados.localizar(v.getVertice().getElem())==-1){
                            q.poner(v.getVertice());
                            if(v.getVertice().getAnterior()==null){
                                v.getVertice().setAnterior(u);
                            }
                        }
                        if(v.getVertice().getElem().equals(destino)){
                            encontrado=true;
                        }else{
                            v=v.getSigAdyacente();
                        }
                    }
                }
            }
            if(encontrado){
                insertarEltos(res,v);
            }
            return res;
    }
    private void insertarEltos(ListaGen ls,NodoAdy v){
        ls.insertar(v.getVertice().getElem(),1);
            NodoVert aux=v.getVertice().getAnterior();
            while(aux!=null){
                ls.insertar(aux.getElem(),1);
                aux=aux.getAnterior();
            }
    }
    private void insertarEltos(ListaGen ls,NodoVert v){
        NodoVert aux=v;
        if(aux.getAnterior()!=null){
            while(aux!=null){
                ls.insertar(aux.getElem(),1);
                aux=aux.getAnterior();
            }
        }
    }
    public ListaGen caminoMasCortoMenorCosto(Object origen,Object destino){
        NodoVert nodoOrigen=ubicarVertice(origen);
        ListaGen res=new ListaGen();
        NodoAdy v;
        ColaPrioridad q=new ColaPrioridad();
        if(nodoOrigen!=null&&ubicarVertice(destino)!=null){
            ListaGen visitados=new ListaGen();
            q.insertar(nodoOrigen,(Comparable)nodoOrigen.getValorAcum());
            while(!q.esVacia()){
                NodoVert u=(NodoVert)q.recuperarFrente();
                q.eliminarFrente();
                
                if(visitados.localizar(u.getElem())==-1){
                    visitados.insertar(u.getElem(),visitados.longitud()+1);
                    v=u.getPrimerAdy();
                while(v!=null){
                    if(visitados.localizar(v.getVertice().getElem())==-1){
                        //
                        Object sumaPesos=(int)v.getEtiqueta()+(int)u.getValorAcum();
                        if(v.getVertice().getAnterior()==null||(((Comparable)v.getVertice().getValorAcum()).compareTo(sumaPesos))>0){
                            v.getVertice().setAnterior(u);
                            v.getVertice().setValorAcum(sumaPesos);
                            //q.insertar(v.getVertice(),(Comparable)sumaPesos);
                            q.insertar(v.getVertice(),(Comparable)v.getVertice().getValorAcum());
                        }
                    }
                 v=v.getSigAdyacente();
                }
                }
                
            }
            insertarEltos(res,ubicarVertice(destino));
        }
        
        return res;
    }
    public boolean esVacio(){
        return this.inicio==null;
    }
    @Override
    public String toString(){
        String s="";
        if(!esVacio()){
            s="Lista de Adyacencia: "+"\n";
            NodoVert aux=this.inicio;
            while(aux!=null){
                s=s+aux.getElem()+"--"+aux.getPrimerAdy().getEtiqueta()+"-->";
                NodoAdy aux2=aux.getPrimerAdy();
                while(aux2!=null){
                    s=s+aux2.getVertice().getElem()+"--";
                    if(aux2.getSigAdyacente()!=null){
                        s=s+aux2.getSigAdyacente().getEtiqueta()+"-->";
                    }else{
                        s=s+"-->";
                    }
                    aux2=aux2.getSigAdyacente();
                }
                s=s+"\n";
                aux=aux.getSigVert();
            }
        }else{
            s="Grafo vacío";
        }
        return s;
    }
    public String mostrarAdy(Object elem){
        NodoAdy n=ubicarVertice(elem).getPrimerAdy();
        String s="";
        while(n!=null){
            s=s+n.getVertice().getElem();
            n=n.getSigAdyacente();
        }
        return s;
    }
}
