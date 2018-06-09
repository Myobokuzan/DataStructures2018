/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaParcial;

/**
 *
 * @author tomas
 */
public class TestParcial {
    public static void main(String []args){
    ColaChar c1=new ColaChar();
    c1.poner('A');
    c1.poner('B');
    c1.poner('#');
    c1.poner('C');
    c1.poner('#');
    c1.poner('D');
    c1.poner('E');
    c1.poner('F');
        System.out.println(c1.toString());
        System.out.println(generar(c1).toString());
    }
public static ColaChar generar(ColaChar c1){
    ColaChar c2=c1.clone();
    PilaChar p1=new PilaChar();
    ListaChar l1=new ListaChar();
    ColaChar c3=new ColaChar();
    int i=1;
    while(!c2.esVacia()){
        c3.poner(c2.obtenerFrente());
        p1.apilar(c2.obtenerFrente());
        l1.insertar(c2.obtenerFrente(),i);
        c2.sacar();
        i++;
        if(c2.obtenerFrente()=='#'||c2.esVacia()){
            while(!p1.esVacia()){
                c3.poner(p1.obtenerTope());
                p1.desapilar();
            }
            while(!l1.esVacia()){
                c3.poner(l1.recuperar(1));
                l1.eliminar(1);
            }
            if(c2.obtenerFrente()=='#'){
                c3.poner('#');
            }
            i=1;
            c2.sacar();
        }
    }
    return c3;
}
    
}
