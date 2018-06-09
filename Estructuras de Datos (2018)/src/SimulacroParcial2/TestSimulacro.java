/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulacroParcial2;
import jerarquicas.*;
import lineales.dinamicas.ListaGen;
import EDC.*;
/**
 *
 * @author tomas
 */
public class TestSimulacro {
    public static void main(String[]lol){
        ListaGen lista=new ListaGen();
        ArbolGen arbol=new ArbolGen();
        arbol.insertar(1,20);
        arbol.insertar(20,13);
        arbol.insertar(20,54);
        arbol.insertar(13,15);
        arbol.insertar(13,12);
        arbol.insertar(54,11);
        arbol.insertar(54,27);
        arbol.insertar(54,4);
        arbol.insertar(27,17);
        
        lista.insertar(20,1);
        lista.insertar(54,2);
        lista.insertar(27,3);
        lista.insertar(17,4);
        System.out.println(arbol.toString());
        //System.out.println(arbol.listarHastaNivel(2).toString());
        System.out.println(arbol.verificarCamino(lista));
        //System.out.println(arbol.listarEntreNiveles(0,3).toString());
        //arbol.eliminar(11);
        //System.out.println(arbol.toString());
        
        /*ArbolBB arbol2=new ArbolBB();
        arbol2.insertar(56);
        arbol2.insertar(13);
        arbol2.insertar(78);
        arbol2.insertar(100);
        arbol2.insertar(7);
        arbol2.insertar(24);
        arbol2.insertar(15);
        //arbol2.eliminarMimino();
        System.out.println(arbol2.clonarParteInvertida(13));*/
    }
}
