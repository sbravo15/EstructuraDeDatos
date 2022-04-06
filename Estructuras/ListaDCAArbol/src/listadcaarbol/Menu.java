package listadcaarbol;

import javax.swing.JOptionPane;

public class Menu {
   Rutina a=new Rutina(); 
   public void mostrarMenu(){
      int opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
              "MENÚ PRINCIPAL\n\n\n1.Llenar lista\n2.Mostrar lista"
                      + "\n3.Copiar lista a árbol\n4.Mostrar árbol\n5.Salir\n\n"
                      + "Digite su opción:"));
      switch(opcion){
          case 1:{
             a.agregarDC();
             mostrarMenu();
             break;
          }
          case 2:{
             a.mostrarListaDC();
             mostrarMenu();
             break;
          }
          case 3:{
             a.copiar();
             mostrarMenu();
             break;
          }
          case 4:{
             a.mostrarRaiz();
             mostrarMenu();
             break;
          }   
          case 5:{   
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
