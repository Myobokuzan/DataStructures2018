/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.jerarquicas;

import Utiles.TecladoIn;
import jerarquicas.*;
import lineales.dinamicas.ListaInt;
/**
 *
 * @author tomas
 */
//metodo de uso: dominio(Tests, uso de estructura)
//metodo de implementacion: TDAs
public class TestArbolBin {
    public static void main(String []args){
        ArbolBinInt arbol=new ArbolBinInt();
        char cont='s',iod;
        int pos,elem;
        menu();
        arbol.insertar(4, 0,'D');
        arbol.insertar(3, 4,'I');
        arbol.insertar(7, 4,'D');
        //arbol.insertar(5, 3,'D');
        arbol.insertar(1, 7,'I');
        arbol.insertar(2, 7,'D');
        arbol.insertar(6, 1,'I');
        arbol.insertar(0, 1,'D');
        //arbol.insertar(8, 3,'I');
         while(cont=='s'){
            int op=TecladoIn.readLineInt();
            switch(op){
                case 1:
                    System.out.println("Escriba entero, elemento padre e I(izquierda) o D(derecha) para posicionar el elemento.");
                    elem=TecladoIn.readLineInt();
                    int padre=TecladoIn.readLineInt();
                    iod=TecladoIn.readLineNonwhiteChar();
                    if(arbol.insertar(elem,padre,iod)){
                        System.out.println("Exito.");
                    }else{
                        System.out.println("Error.");
                    }break;
                case 2:
                    if(arbol.esVacio()){
                        System.out.println("Árbol vacío.");
                    }else{
                        System.out.println("Árbol no vacío.");
                    } break;
                case 3:
                    System.out.println("Escriba elemento para obtener el padre de este.");
                    elem=TecladoIn.readLineInt();
                    System.out.println("El elemento padre es: "+arbol.padre(elem)); break;
                case 4:
                    System.out.println("La altura del árbol es: "+arbol.altura());
                    break;
                case 5:
                    System.out.println("Escriba el elemento para obtener su nivel.");
                    elem=TecladoIn.readLineInt();
                    System.out.println("EL nivel de "+elem+" es: "+arbol.nivel(elem));break;
                case 6:
                    arbol.vaciar();
                    System.out.println("Árbol vaciado.");break;
                case 7:
                    arbol.clone();
                    System.out.println("Árbol clonado.");break;
                case 8:
                    System.out.println(arbol.toString());break;
                case 9:
                    System.out.println("Lista en preorden: "+arbol.listarPreorden().toString());break;
                case 10:
                    System.out.println("Lista en posorden: "+arbol.listarPosorden().toString());break;
                case 11:
                    System.out.println("Lista en inorden: "+arbol.listarInorden().toString());break;
                case 12:
                    ListaInt lista=new ListaInt();
                    lista.insertar(4,1);
                    lista.insertar(3,2);
                    
                    System.out.println(lista.toString());
                    System.out.println(arbol.verificarPatron(lista));break;
                case 13: 
                    System.out.println(arbol.frontera().toString());break;
                case 14:
                    System.out.println(arbol.clone().toString());break;
                case 15:
                    ArbolBinInt revez=arbol.clonarInvertido();
                    System.out.println(arbol.toString());
                    System.out.println(revez.toString());
                    //System.out.println(arbol.clonarInvertido().listarPreorden().toString());
                    System.exit(0);break;
                case 16:
                    ArbolBinInt arbol2=new ArbolBinInt();
                    arbol2.insertar(4, 0,'D');
                    arbol2.insertar(3, 4,'I');
                    arbol2.insertar(7, 4,'D');
                    arbol2.insertar(1, 7,'I');
                    arbol2.insertar(2, 7,'D');
                    arbol2.insertar(6, 1,'I');
                    arbol2.insertar(0, 1,'D');
                    System.out.println(arbol.equals(arbol2));
                    System.exit(0);
            }
            System.out.println("Continuar? s/n");
            cont=TecladoIn.readLineNonwhiteChar();
        }
    }
    public static void menu(){
        System.out.println("Opciones: \n 1)Insertar elemento. \n 2)Verificar si el árbol está vacío. \n 3)Devolver el padre de un elemento. \n 4)Calcular altura del árbol. \n 5)Calcular el nivel de un elemento. \n 6)Vaciar el árbol. \n 7)Clonar árbol.\n 8)toString().\n 9)Listar preorden.\n 10)Listar Posorden.\n 11)Listar Inorden.\n 12)Listar por niveles.");
    }
}
