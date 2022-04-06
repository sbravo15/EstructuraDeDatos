package pila;
import javax.swing.JOptionPane;
public class Menu {
   private int opcion;
   private Pila p=new Pila();
   public void mostrarMenu(){
      opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
              "***MENÚ PRINCIPAL***\n\n"
                      + "1.Apilar elemento\n"
                      + "2.Desapilar elemento\n"
                      + "3.Mostrar elementos\n"
                      + "4.Salir\n\n"
                      + "Digite su opción:"));
      switch(opcion){
          case 1:{
            p.apilar();
            mostrarMenu();
            break;
          }
          case 2:{
            p.desapilar();
            mostrarMenu();
            break;
          }
          case 3:{
            p.mostrarElementos();
            mostrarMenu();
            break;
          }
          case 4:{
            System.exit(0);
            break;
          }
          default:{
            JOptionPane.showMessageDialog(null,"Usted digitó una opción incorrecta!");
            mostrarMenu();
          }
      }
   }
}
