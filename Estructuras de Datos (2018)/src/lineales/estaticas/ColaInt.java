/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Usuario
 */
public class ColaInt {

    //Atributos
    private static final int TAM = 5;
    private int frente;
    private int fin;
    private int[] array;

    //Constructor
    public ColaInt() {
        this.array = new int[TAM];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(int elem) {
        boolean exito;
        if (this.frente == (this.fin + 1) % TAM) {
            return false;
        } else {
            this.array[fin] = elem;
            this.fin = (fin + 1) % this.TAM;
            return true;
        }
    }
    public boolean sacar(){
        boolean exito;
        if(this.esVacia()){
            exito= false;
        }else{
            this.frente=(this.frente+1)%this.TAM;
            exito= true;
        }
        return exito;
    }
    public int obtenerFrente(){
        int res;
        if(this.frente!=this.fin){
            res= array[this.frente];
        }else{
            res= Integer.MIN_VALUE;
        }
        return res;
    }
    public boolean esVacia(){
        return this.frente==this.fin;
    }
    public void vaciar(){
        this.frente=0;
        this.fin=0;
    }
    public ColaInt clone(){
        ColaInt colaAux=new ColaInt();
        colaAux.frente=this.frente;
        colaAux.fin=this.fin;
        colaAux.array=this.array.clone();
        return colaAux;
    }
    public String toString(){
        String cadena="";
        int i=this.frente;
        if(esVacia()){
            cadena="Cola vacía.";
        }else{
            cadena="<-";
            while(i!=this.fin){
            cadena=cadena+this.array[i];
            i=(i%this.TAM)+1;
        }
            cadena=cadena+"<-";
        }

        return cadena;
    }
}
