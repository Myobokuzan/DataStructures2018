/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.EDC;
import Utiles.*;
import EDC.*;
/**
 *
 * @author tomas
 */
public class TestABB {
    public static void main(String[]a){
        ArbolBB arbol=new ArbolBB();
        arbol.insertar(8);
        arbol.insertar(4);
        arbol.insertar(12);
        arbol.insertar(2);
        arbol.insertar(6);
        arbol.insertar(10);
        arbol.insertar(14);
        arbol.insertar(1);
        arbol.insertar(3);
        arbol.insertar(5);
        arbol.insertar(7);
        arbol.insertar(9);
        arbol.insertar(11);
        arbol.insertar(13);
        arbol.insertar(15);
        
        System.out.println("Ingrese opción.");
        int op=TecladoIn.readLineInt();
        switch(op){
            case 1:
                System.out.println(arbol.pertenece(50));break;
            case 3:
                System.out.println(arbol.eliminar(4));
                System.out.println(arbol.listar());break;
            case 4:
                System.out.println(arbol.listar().toString());break;
            case 5:
                System.out.println(arbol.listarRango(45, 73).toString());break;
            case 6:
                System.out.println(arbol.minimoElem());break;
            case 7:
                System.out.println(arbol.maximoElem());break;
            case 8:
                System.out.println(arbol.esVacio());break;
        }
        System.out.println(arbol.toString());
    }
}
