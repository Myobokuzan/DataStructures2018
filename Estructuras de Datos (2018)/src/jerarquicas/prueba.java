/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author tomas
 */
public class prueba {
    public static void main(String[]args){
        NodoGen n1=new NodoGen("hola");
        NodoGen n2=new NodoGen("hola");
        System.out.println(n1.equals(n2));
    }
}
