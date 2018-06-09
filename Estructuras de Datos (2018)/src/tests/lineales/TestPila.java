/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;
import Utiles.*;
import lineales.estaticas.PilaInt;

/**
 *
 * @author tomas
 */
public class TestPila {
    public static void main(String[]args){
        PilaInt testPila=new PilaInt();
        testPila.apilar(5);
        testPila.apilar(-2);
        testPila.apilar(0);
        testPila.apilar(4);
        testPila.apilar(8);
        testPila.desapilar();
        System.out.println(testPila.toString());
        System.out.println("Tope: "+testPila.obtenerTope());
        if(testPila.esVacia()){
            System.out.println("Pila vacía");
        }else{
            System.out.println("Pila no vacía");
        }
        System.out.println("toString() de pila clonada: "+testPila.Clone().toString());
        testPila.vaciar();
        System.out.println("Se vació la pila");
        System.out.println(testPila.toString());
        System.out.println("Tope: "+testPila.obtenerTope());
        PilaInt pila2=new PilaInt();
        pila2.apilar(6);
        pila2.apilar(1);
        pila2.apilar(1);
        pila2.apilar(1);
        pila2.apilar(6);
        System.out.println(capicua(pila2));
        //capicua(pila2);
    }
    public static boolean capicua(PilaInt pila){
        PilaInt pilaCapi=new PilaInt();
        PilaInt pilaClon;
        pilaClon=pila.Clone();
        boolean capicua=true;
        
        for(int j=0;j<=5;j++){
            pilaCapi.apilar(pilaClon.obtenerTope());
            pilaClon.desapilar();
        }
        while(capicua==true&&pila.obtenerTope()!=Integer.MIN_VALUE){
            if(pila.obtenerTope()==pilaCapi.obtenerTope()){
                pila.desapilar();
                pilaCapi.desapilar();
            }else{
                capicua=false;
            }
        }
        //System.out.println(pilaCapi.toString());
        return capicua;
    }
}
