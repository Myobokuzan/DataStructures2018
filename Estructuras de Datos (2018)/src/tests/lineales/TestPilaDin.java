/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;
import Utiles.TecladoIn;
import Utiles.*;
import lineales.dinamicas.*; 

/**
 *
 * @author Usuario
 */
public class TestPilaDin {
    public static void main(String []args){
        PilaInt pila=new PilaInt();
        /*char cont='s';
        menu();
         while(cont=='s'){
            int op=TecladoIn.readLineInt();
            switch(op){
                case 1:
                    System.out.println("Escriba entero.");
                    int elem=TecladoIn.readLineInt();
                    pila.apilar(elem);
                    System.out.println("Exito."); break;
                case 2:
                    if(pila.desapilar()==true){
                        System.out.println("Exito.");
                    }else{
                        System.out.println("Error. Pila vacía.");
                    } break;
                case 3:
                    System.out.println(pila.obtenerTope()); break;
                case 4:
                    if(pila.esVacia()==true){
                        System.out.println("Pila vacía.");
                    }else{
                        System.out.println("Pila no vacía.");
                    }break;
                case 5:
                    pila.vaciar();
                    System.out.println("Se vació la pila."); break;
                case 6:
                    pila.clone();
                    System.out.println("Pila clonada"); break;
                case 7:
                    System.out.println(pila.toString()); break;
            }
            System.out.println("Continuar? s/n");
            cont=TecladoIn.readLineNonwhiteChar();
        }*/
         pila.apilar(2);
         pila.apilar(1);
         pila.apilar(7);
         pila.apilar(5);
         pila.apilar(8);
         System.out.println(pila.toString());
         PilaInt pilaClonada=pila.clone();
         pilaClonada.desapilar();
         pilaClonada.apilar(25);
         pilaClonada.desapilar();
         pilaClonada.desapilar();
         pilaClonada.vaciar();
         System.out.println(pilaClonada.toString());
         
    }
    public static void menu(){
        System.out.println("Opciones: \n 1)Apilar elemento. \n 2)Desapilar elemento. \n 3)Obtener tope. \n 4)Verificar si la pila esta vacía. \n 5)Vaciar pila. \n 6)Clonar pila. \n 7)toString()");
    }
}
