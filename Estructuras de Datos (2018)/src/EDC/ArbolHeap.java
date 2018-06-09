/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDC;
import Utiles.*;
/**
 *
 * @author tomas
 */
public class ArbolHeap {
    private static final int TAM=20;
    private Comparable[] heap;
    private int ultimo;
    
    public ArbolHeap(){
        this.heap=new Comparable[20];
        ultimo=0;
    }
    public boolean insertar(Comparable elem){
        boolean exito=false;
        if(this.ultimo==0){
            this.ultimo++;
            this.heap[this.ultimo]=elem;
            exito=true;
        }else{
            this.ultimo++;
            this.heap[this.ultimo]=elem;
            int aux=this.ultimo;
            int padre=(int)aux/2;
            while(!exito){
                if(this.heap[aux].compareTo(this.heap[padre])<0){
                    this.heap[aux]=this.heap[padre];
                    this.heap[padre]=elem;
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
        return exito;
    }
    @Override
    public String toString(){
        String s="";
        if(ultimo==0){
            s="Árbol vacío.";
        }else{
            s="[";
            for(int i=1;i<=this.ultimo;i++){
                s=s+this.heap[i]+",";
            }
            s=s+"]";
        }
        return s;
    }
}
