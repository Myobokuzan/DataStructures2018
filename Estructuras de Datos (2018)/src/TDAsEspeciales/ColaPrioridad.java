/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAsEspeciales;

import lineales.dinamicas.ListaGen;

/**
 *
 * @author Tomas
 */
public class ColaPrioridad {
    private static final int TAM=20;
    private NodoCP[] heap;
    private int ultimo;
    private int ordenLlegada;
    
    public ColaPrioridad(){
        this.heap=new NodoCP[TAM];
        this.ultimo=0;
        this.ordenLlegada=0;
    }
    public Object recuperarFrente(){
        Object res=null;
        if(this.ultimo>0){
            res=this.heap[1].getElem();
        }
        return res;
    }
    public boolean insertar(Object elem,Comparable prioridad){
        boolean exito=false;
        if(this.ultimo==0){
            this.ultimo++;
            this.ordenLlegada++;
            this.heap[this.ultimo]=new NodoCP(prioridad,this.ordenLlegada,elem);
            exito=true;
        }else{
            if(this.ultimo<this.heap.length-1){
                this.ultimo++;
                this.ordenLlegada++;
                NodoCP nuevoNodo=new NodoCP(prioridad,this.ordenLlegada,elem);
                this.heap[this.ultimo]=nuevoNodo;
                int aux=this.ultimo;
                int padre=(int)aux/2;
                while(!exito){
                    if(this.heap[aux].getPrioridad().compareTo(this.heap[padre].getPrioridad())<0){
                        this.heap[aux]=this.heap[padre];
                        this.heap[padre]=nuevoNodo;
                        aux=padre;
                        padre=aux/2;
                        if(aux==1){
                            exito=true;
                        }
                    }else{
                        exito=true;
                    }
                }
            }
        }
        return exito;
    }
    public boolean eliminarFrente(){
        boolean exito=false;
        if(this.ultimo!=0){
            this.heap[1]=this.heap[this.ultimo];
            this.ultimo--;
            hacerBajar(1);
            exito=true;
        }else{
            if(this.ultimo==1){
                this.ultimo--;
                exito=true;
            }
        }
        return exito;
    }
    private void hacerBajar(int pos){
        int hijoMenor;
        NodoCP temp=this.heap[pos];
        boolean salir=false;
        while(!salir){
            hijoMenor=pos*2;
            if(hijoMenor<=this.ultimo){
                if(hijoMenor<this.ultimo){
                    if(this.heap[hijoMenor+1].getPrioridad().compareTo(this.heap[hijoMenor].getPrioridad())<0){
                        hijoMenor++;
                    }else{
                        if(this.heap[hijoMenor+1].getPrioridad().compareTo(this.heap[hijoMenor].getPrioridad())==0){
                            if(this.heap[hijoMenor+1].getOrdenLlegada()<this.heap[hijoMenor].getOrdenLlegada()){
                                hijoMenor++;
                            }
                        }
                    }
                }
                if(this.heap[hijoMenor].getPrioridad().compareTo(temp.getPrioridad())<0){
                    this.heap[pos]=this.heap[hijoMenor];
                    pos=hijoMenor;
                }else{
                    if(this.heap[hijoMenor].getPrioridad().compareTo(temp.getPrioridad())==0){
                        if(this.heap[hijoMenor].getOrdenLlegada()<temp.getOrdenLlegada()){
                            this.heap[pos]=this.heap[hijoMenor];
                            pos=hijoMenor;
                            this.heap[pos]=temp;
                        }
                    }
                }
                salir=true;
            }else{
                salir=true;
            }
            
        }
        
    }
    public int getUltimo(){
        return this.ultimo;
    }
    public boolean esVacia(){
        return this.ultimo==0;
    }
    @Override
    public String toString(){
        String s="";
        if(ultimo==0){
            s="Árbol vacío.";
        }else{
            s="[";
            for(int i=1;i<=this.ultimo;i++){
                s=s+this.heap[i].getElem()+",";
            }
            s=s+"]";
        }
        return s;
    }
}    
