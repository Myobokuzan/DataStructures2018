/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.jerarquicas;
import Utiles.*;
import jerarquicas.*;
/**
 *
 * @author tomas
 */
public class TestArbolGen {
    public static void main(String []args){
        ArbolGen arbol=new ArbolGen();
        char cont='s',iod;
        int pos,elem;
        //menu();
        arbol.insertar('r','A');
        arbol.insertar('A','B');
        arbol.insertar('B','D');
        arbol.insertar('A','H');
        arbol.insertar('A','C');
        arbol.insertar('C','E');
        arbol.insertar('C','F');
        arbol.insertar('F','G');
        arbol.insertar('H','O');
        arbol.insertar('O','P');
        arbol.insertar('P','V');
        arbol.insertar('V','L');
         while(cont=='s'){
            int op=TecladoIn.readLineInt();
            switch(op){
                case 1:
                    System.out.println(arbol.pertenece('Z'));break;
                case 2:
                    System.out.println(arbol.esVacio());break;
                case 3:
                    System.out.println(arbol.padre('L'));break;
                case 4:
                    System.out.println(arbol.altura());break;
                case 5:
                    System.out.println(arbol.nivel('G'));break;
                case 6:
                    System.out.println(arbol.ancestros('E'));break;
                case 7:
                    ArbolGen arbolClon=arbol.clone();
                    System.out.println(arbolClon.toString());break;
                case 8:
                    arbol.vaciar();
                    System.out.println(arbol.toString());break;
                case 9:
                    System.out.println(arbol.listarPreorden());break;
                case 10:
                    System.out.println(arbol.listarInorden());break;
                case 11:
                    System.out.println(arbol.listarPosorden());break;
                case 13:
                    System.out.println(arbol.toString());break;
            }
            System.out.println("Continuar? s/n");
            cont=TecladoIn.readLineNonwhiteChar();
        }
        //System.out.println(arbol.toString());
    }
    /*public static void menu(){
        System.out.println("Opciones: \n 1)Insertar elemento. \n 2)Verificar si el árbol está vacío. \n 3)Devolver el padre de un elemento. \n 4)Calcular altura del árbol. \n 5)Calcular el nivel de un elemento. \n 6)Vaciar el árbol. \n 7)Clonar árbol.\n 8)toString().\n 9)Listar preorden.\n 10)Listar Posorden.\n 11)Listar Inorden.\n 12)Listar por niveles.");
    }*/
}
