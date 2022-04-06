package arbolbinario;

import javax.swing.JOptionPane;

public class Menu {
   Arbol a=new Arbol(); 
   public void mostrarMenu(){
      int opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
              "MENÚ PRINCIPAL\n\n\n1.Agregar nodo\n2.Mostrar nodos\n3.Salir\n\n"
                      + "Digite su opción:"));
      switch(opcion){
          case 1:{
             a.crearRaiz();
             mostrarMenu();
             break;
          }
          case 2:{
             a.mostrarRaiz();
             mostrarMenu();
             break;
          }
          case 3:{
             System.exit(0);
             break;
          }
          default:{
             JOptionPane.showMessageDialog(null,"Opción incorrecta!");
             mostrarMenu();
          }
      }
   }
}
