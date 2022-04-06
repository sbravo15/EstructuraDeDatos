/*Diseñe una aplicación que lea una palabra. 
Diseñe los métodos para:
- Copiar la palabra en una pila, letra por letra.
- Recorrer la pila y almacenar sus valores en una cola.
- Recorrer la cola y copiarla en una lista doble circular.
- Determinar la cantidad de letras vocales de la lista doble circular.
- Mostrar la lista doble circular y la cantidad de vocales. */
package dosprac2ex02;

public class Main {

    public static void main(String[] args) {
       Rutina r=new Rutina();
       r.leerPalabra();
       r.copiarAPila();
       r.copiarACola();
       r.copiarALista();
       r.mostrarElementosLDC();
    }
    
}
