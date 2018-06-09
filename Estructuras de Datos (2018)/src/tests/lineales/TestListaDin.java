/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import Utiles.TecladoIn;
import lineales.dinamicas.ListaInt;


/**
 *
 * @author tomas
 */
public class TestListaDin {
   public static void main(String []args){
        ListaInt lista=new ListaInt();
        char cont='s';
        int pos,elem;
        menu();
        lista.insertar(1, 1);
        lista.insertar(2, 2);
        lista.insertar(3, 3);
        lista.insertar(4, 4);
        lista.insertar(5, 5);
        lista.insertar(6, 6);
        lista.insertar(7, 7);
        lista.insertar(8, 8);
        lista.insertar(9, 9);
         while(cont=='s'){
            int op=TecladoIn.readLineInt();
            switch(op){
                case 1:
                    System.out.println("Escriba entero y posición a insertar.");
                    elem=TecladoIn.readLineInt();
                    pos=TecladoIn.readLineInt();
                    if(lista.insertar(elem,pos)){
                        System.out.println("Exito.");
                    }else{
                        System.out.println("Error. Posición no válida.");
                    }break;
                case 2:
                    System.out.println("Escriba posición a eliminar.");
                    pos=TecladoIn.readLineInt();
                    if(lista.eliminar(pos)){
                        System.out.println("Exito.");
                    }else{
                        System.out.println("Error. Lista vacía o poisición no válida.");
                    } break;
                case 3:
                    System.out.println("Escriba posición para obtener elemento.");
                    pos=TecladoIn.readLineInt();
                    System.out.println(lista.recuperar(pos)); break;
                case 4:
                    System.out.println("Escriba elemento para localizar su posición.");
                    elem=TecladoIn.readLineInt();
                    System.out.println(lista.localizar(elem));
                    break;
                case 5:
                    lista.vaciar();
                    System.out.println("Se vació la lista."); break;
                case 6:
                    if(lista.esVacia()){
                       System.out.println("La lista está vacía."); 
                    }else{
                        System.out.println("La lista no está vacía.");
                    }break;
                case 7:
                    if(lista.esVacia()){
                    System.out.println("Lista vacía. No se puede clonar.");   
                    }else{
                    lista.clone(); 
                    System.out.println("Se clonó la lista.");
                    }break;
                case 8:
                    System.out.println("Longitud de la lista: "+lista.longitud()+'.');break;
                case 9:
                    System.out.println(lista.toString());break;
                case 10:System.out.println(lista.cab());break;
                case 11:
                    lista.insertarPromedio();
                    System.out.println("Promedio insertado. ;)");break;
                case 12:
                    lista.eliminarApariciones(1);
                    System.out.println("Apareciones repetidas eliminadas :o");break;
                case 13:
                    System.out.println(lista.toString());
                    lista.compactar(2);
                    System.out.println(lista.toString());
                    System.out.println(lista.longitud());
                    System.exit(0);break;
            }
            System.out.println("Continuar? s/n");
            cont=TecladoIn.readLineNonwhiteChar();
        } 
}
   public static void menu(){
        System.out.println("Opciones: \n 1)Insertar elemento. \n 2)Eliminar elemento. \n 3)Recuperar. \n 4)Localizar. \n 5)Vaciar lista. \n 6)Verificar si la lista está vacía. \n 7)Clonar lista.\n 8)Longitud de la lista.\n 9)toString().");
    }
}
