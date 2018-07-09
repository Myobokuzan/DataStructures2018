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

    c1.poner('8');
    c1.poner('-');
    c1.poner('{');
    c1.poner('3');
    c1.poner('*');
    c1.poner('(');
    c1.poner('4');
    c1.poner('-');
    c1.poner('2');
    c1.poner('}');
    c1.poner(')');
        System.out.println(c1.toString());
        System.out.println(verificarBalanceo(c1));
    }
public static ColaChar generar(ColaChar c1){
    ColaChar c2=c1.clone();
    PilaChar p1=new PilaChar();
    ColaChar c3=new ColaChar();
    ColaChar c4=new ColaChar();
    int i=1;
    while(!c2.esVacia()){
        c3.poner(c2.obtenerFrente());
        p1.apilar(c2.obtenerFrente());
        c4.poner(c2.obtenerFrente());
        c2.sacar();
        if(c2.obtenerFrente()=='#'||c2.esVacia()){
            while(!p1.esVacia()){
                c3.poner(p1.obtenerTope());
                p1.desapilar();
            }
            while(!c4.esVacia()){
                c3.poner(c4.obtenerFrente());
                c4.sacar();
            }
            if(c2.obtenerFrente()=='#'){
                c3.poner('#');
            }
            c2.sacar();
        }
    }
    return c3;
}
public static boolean verificarBalanceo(ColaChar q){
    ColaChar c1=q.clone();
    PilaChar p=new PilaChar();
    boolean balance=true;
    while(!c1.esVacia()&&c1.obtenerFrente()!=']'&&c1.obtenerFrente()!=')'&&c1.obtenerFrente()!='}'){
        if(c1.obtenerFrente()=='{'||c1.obtenerFrente()=='['||c1.obtenerFrente()=='('){
            p.apilar(c1.obtenerFrente());
        }
        c1.sacar();
    }
    if(!c1.esVacia()){
        while(!c1.esVacia()&&balance){
            if(c1.obtenerFrente()==']'){
                if(p.obtenerTope()=='['){
                    p.desapilar();
                }else{
                    balance=false;
                }
            }else{
                if(c1.obtenerFrente()==')'){
                    if(p.obtenerTope()=='('){
                        p.desapilar();
                    }else{
                        balance=false;
                    }
                }else{
                    if(c1.obtenerFrente()=='}'){
                        if(p.obtenerTope()=='{'){
                            p.desapilar();
                        }else{
                            balance=false;
                        }
                    }
                }
            }
            c1.sacar();
        }
        if(!p.esVacia()){
            balance=false;
        }
    }
    return balance;
}
    
}
