/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.EDC;
import EDC.ArbolHeap;
import Utiles.*;
/**
 *
 * @author tomas
 */
public class testArbolHeap {
    public static void main(String[]args){
        ArbolHeap arbol=new ArbolHeap();
        arbol.insertar(4);
        arbol.insertar(7);
        arbol.insertar(3);
        arbol.insertar(1);
        arbol.insertar(5);
        arbol.insertar(6);
        arbol.insertar(2);
        arbol.insertar(22);
        arbol.insertar(54);
        arbol.insertar(-5);
        arbol.insertar(-10);
        System.out.println(arbol);
    }
}
