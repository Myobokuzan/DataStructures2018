/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;
import Utiles.*;
import lineales.estaticas.*;
/**
 *
 * @author Usuario
 */
public class TestCola {
  public static void main(String[]args){
      ColaInt cola=new ColaInt();
        char cont='s';
        menu();
         while(cont=='s'){
            int op=TecladoIn.readLineInt();
            switch(op){
                case 1:
                    System.out.println("Escriba entero.");
                    int elem=TecladoIn.readLineInt();
                    cola.poner(elem);
                    System.out.println("Exito."); break;
                case 2:
                    if(cola.sacar()==true){
                        System.out.println("Exito.");
                    }else{
                        System.out.println("Error. Cola vacía.");
                    } break;
                case 3:
                    System.out.println(cola.obtenerFrente()); break;
                case 4:
                    if(cola.esVacia()==true){
                        System.out.println("Cola vacía.");
                    }else{
                        System.out.println("Cola no vacía.");
                    }break;
                case 5:
                    cola.vaciar();
                    System.out.println("Se vació la cola."); break;
                case 6:
                    cola.clone();
                    System.out.println("Cola clonada"); break;
                case 7:
                    System.out.println(cola.toString()); break;
            }
            System.out.println("Continuar? s/n");
            cont=TecladoIn.readLineNonwhiteChar();
        }
  }
  public static void menu(){
        System.out.println("Opciones: \n 1)Poner elemento. \n 2)Sacar elemento. \n 3)Obtener frente. \n 4)Verificar si la cola esta vacía. \n 5)Vaciar cola. \n 6)Clonar cola. \n 7)toString()");
    }
}
