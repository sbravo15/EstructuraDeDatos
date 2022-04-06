/* Diseñe un programa que permita llenar:  
- Un vector de 4 posiciones. 
- Una matriz. 
- Una pila.  
- Copie todas las estructuras en 
una lista simple circular.  
- Copie la lista simple circular en un vector.  
- Muestre el vector, recorra el vector y 
cópielo en una lista doble circular. 
Muestre la lista. */
package tresprac2exed;
public class Main {
    public static void main(String[] args) {
       Rutina r=new Rutina();
       r.llenarVector();
       r.llenarMatriz();
       r.llenarPila();
       r.copiarAListaSC();
       r.copiarListaSCAVector();
       r.mostrarListaDC();
    }    
}
