/*Llene una cola con letras, una lista simple circular con números, 
una lista doble circular con palabras. Copie todo en una cola. 
Muestre la cola sin tomar en cuenta los números pares, ni las vocales, 
ni las palabras que inicien con una consonante.*/
package ochoprac2ex02;
public class Main {
    public static void main(String[] args) {
       Rutina r=new Rutina();
       r.encolar();
       r.llenarListaSC();
       r.llenarListaDC();
       r.copiarCola01aCola02();
       r.copiarListaSCaCola02();
       r.copiarListaDCaCola02();
       r.mostrarColaCompleta();
       r.mostrarColaSinVocalesSinParesSinPalabrasInicianConConsonante();
    }    
}
