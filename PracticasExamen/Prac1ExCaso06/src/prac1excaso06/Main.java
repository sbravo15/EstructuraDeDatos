/*Llene una pila con letras. Recorra la pila recursivamente y 
copie su contenido en una matriz. Muestre ambas estructuras.*/
package prac1excaso06;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
       String s=""; 
       NodoP cima=null; 
       Rutina r=new Rutina(cima);
       cima=r.apilar(0,cima);
       NodoP aux=cima;
       s=s+r.mostrarPila(aux,s);
       JOptionPane.showMessageDialog(null,"La pila contiene:\n"+s);
       r.copiarPilaAMatriz(aux,0,0);
       s="";
       s=s+r.mostrarMatriz(0,0,s);
       JOptionPane.showMessageDialog(null,"La matriz contiene:\n"+s);
    }    
}
