/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;
import Utiles.*;
/**
 *
 * @author Usuario
 */
public class PilaInt {
    //Atributos
    private int[] array;
    private int tope;
    private static final int TAM=5;
    
    //Constructor
    public PilaInt(){
        this.array=new int[TAM];
        this.tope=-1;
    }
    
    //Modificadores
    public boolean apilar(int elemento){
        boolean res=false;
        if(this.tope<this.TAM-1){
            this.tope++;
            this.array[tope]=elemento;
            res=true;
        }
        return res;
    }
    
    public boolean desapilar(){
        boolean res=false;
        if(this.tope>=0){
            this.tope--;
            res=true;
        }
        return res;
    }
    
    //Observadores
    public int obtenerTope(){
        int elemento;
        if(this.tope==-1){
            elemento=Integer.MIN_VALUE;
        }else{
            elemento=this.array[tope];
        }
        return elemento;
    }
    
    public boolean esVacia(){
        boolean vacia;
        return vacia=this.tope==-1;
    }
    
    public void vaciar(){
        this.tope=-1;
    }
    
    public PilaInt Clone(){
        PilaInt pilaClon=new PilaInt();
        pilaClon.tope=this.tope;
        pilaClon.array=this.array.clone();
        return pilaClon;
    }
    
    public String toString(){
        String cadena="";
        if(this.tope==-1){
            cadena="Vacía";
        }else{
            for(int i=this.tope;i>=0;i--){
                cadena=cadena+"|"+this.array[i]+"|"+"\n";
            }
        }
        return cadena;
    }
}
