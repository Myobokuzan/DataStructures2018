/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author Tomas
 */
public class GrafoNoEtiq {
    private NodoVert inicio;
    
    public GrafoNoEtiq(){
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
        if(aux.getElem().equals(elem)){
            this.inicio=aux.getSigVert();
            exito=true;
        }else{
            while(aux!=null&&!aux.getSigVert().getElem().equals(elem)){
                aux=aux.getSigVert();
            }
            if(aux!=null){
                aux.setSigVert(aux.getSigVert().getSigVert());
                exito=true;
            }
        }
        return exito;
    }
    public boolean existeVertice(Object elem){
        return ubicarVertice(elem)!=null;
    }
    public boolean insertarArco(Object origen,Object destino){
        boolean exito=false;
        NodoVert nodoOrigen=ubicarVertice(origen);
        NodoVert nodoDest=ubicarVertice(destino);
        if(nodoOrigen!=null&&nodoDest!=null){
            NodoAdy arcoAux=nodoOrigen.getPrimerAdy();
            if(arcoAux==null){
                nodoOrigen.setPrimerAdy(new NodoAdy(nodoDest));
                exito=true;
            }else{
                NodoAdy aux2=arcoAux;
                arcoAux=null;
                while(aux2!=null&&!aux2.getVertice().getElem().equals(destino)){
                    arcoAux=aux2;
                    aux2=aux2.getSigAdyacente();
                }
                if(aux2==null){
                    arcoAux.setSigAdyacente(new NodoAdy(nodoDest));
                    exito=true;
                }
            }
        }
        return exito;
    }
    public boolean eliminarArco(Object origen,Object destino){
        NodoVert NodoOrigen=ubicarVertice(origen);
        NodoVert NodoDest=ubicarVertice(destino);
        boolean exito=false;
        if(NodoOrigen!=null&&NodoDest!=null){
            if(NodoOrigen.getPrimerAdy()!=null){
                if(NodoOrigen.getPrimerAdy().getVertice().getElem().equals(destino)){
                    NodoOrigen.setPrimerAdy(NodoOrigen.getPrimerAdy().getSigAdyacente());
                }else{
                    NodoAdy aux=NodoOrigen.getPrimerAdy();
                    while(aux!=null&&aux.getSigAdyacente()!=null&&!aux.getSigAdyacente().getVertice().getElem().equals(destino)){
                        aux=aux.getSigAdyacente();
                    }
                    if(aux.getSigAdyacente().getVertice().getElem().equals(destino)){
                        aux.setSigAdyacente(aux.getSigAdyacente().getSigAdyacente());
                    }
                }
            }
            while(exito){
                
            }
        }
    }
}
