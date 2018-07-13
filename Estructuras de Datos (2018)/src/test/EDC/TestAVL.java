/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.EDC;
import EDC.*;
/**
 *
 * @author Tomas
 */
public class TestAVL {
    public static void main(String[]args){
        NodoAVL nuevo=new NodoAVL(4);
        NodoAVL otro=new NodoAVL(1);
        NodoAVL otromas=new NodoAVL(5);
        otro.setDerecho(otromas);
        //NodoAVL otromas=new NodoAVL(3);
        nuevo.setIzquierdo(otro);
        nuevo.setDerecho(new NodoAVL(3));
        nuevo.recalcularAltura();
        System.out.println(nuevo.getAltura());
        //otro.setDerecho(otromas);
        nuevo.recalcularAltura();
        ArbolAVL arbol=new ArbolAVL();
        arbol.insertar(8);
        arbol.insertar(15);
        arbol.insertar(5);
        arbol.insertar(13);
        arbol.insertar(20);
        arbol.insertar(29);
        System.out.println(arbol.imprimirRaiz());
        arbol.insertar(60);
        System.out.println(arbol.toString());
        System.out.println(arbol.imprimirRaiz());
        //arbol.insertar(21);
        //arbol.insertar(40);
        //arbol.insertar(45);
        
        System.out.println(arbol.toString());
    }
}
