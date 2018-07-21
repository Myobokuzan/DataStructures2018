/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import TDAsEspeciales.ColaPrioridad;
import lineales.dinamicas.ColaGen;

/**
 *
 * @author Tomas
 */
public class TestGrafoNoEtiq {
    public static void main(String[]a){
        GrafoEtiq grafo=new GrafoEtiq();
        /*grafo.insertarVertice('A');
        grafo.insertarVertice('B');
        grafo.insertarVertice('C');
        grafo.insertarVertice('D');
        grafo.insertarVertice('E');
        grafo.insertarVertice('F');
        grafo.insertarVertice('G');
        grafo.insertarArco('A','B',1);
        grafo.insertarArco('A','C',3);
        grafo.insertarArco('B','F',5);
        grafo.insertarArco('B','E',8);
        grafo.insertarArco('C','D',5);
        grafo.insertarArco('E','F',2);
        grafo.insertarArco('F','G',1);
        grafo.insertarArco('G','E',5);
        grafo.insertarArco('E','D',2);
        grafo.insertarArco('B','C',4);*/
        //System.out.println(grafo.caminoMasCortoMenorCosto('A','E'));
        //ColaPrioridad w=new ColaPrioridad();
        /*q.insertar(1,1);
        q.insertar(null,1);
        q.insertar(5,null);
        q.eliminarFrente();
        q.insertar(4,5);
        q.insertar(5,5);
        q.insertar(6,5);
        q.insertar(7,5);
        q.insertar(8,5);
        q.insertar(9,4);*/
        //q.insertar('A',0);
        //q.eliminarFrente();
        //q.insertar('B',0);
        grafo.insertarVertice('O');
        grafo.insertarVertice('A');
        grafo.insertarVertice('B');
        grafo.insertarVertice('C');
        grafo.insertarVertice('D');
        grafo.insertarVertice('E');
        grafo.insertarVertice('F');
        grafo.insertarVertice('T');
        grafo.insertarArco('O','A',3);
        grafo.insertarArco('O','B',2);
        grafo.insertarArco('A','C',1);
        grafo.insertarArco('A','D',4);
        grafo.insertarArco('B','C',3);
        grafo.insertarArco('B','E',4);
        grafo.insertarArco('C','F',2);
        grafo.insertarArco('C','E',2);
        grafo.insertarArco('D','T',6);
        grafo.insertarArco('E','F',3);
        grafo.insertarArco('E','T',5);
        grafo.insertarArco('F','T',4);
        System.out.println(grafo.toString());
        System.out.println(grafo.caminoMasCortoMenorCosto('O','T').toString());
        
        
    }
}
