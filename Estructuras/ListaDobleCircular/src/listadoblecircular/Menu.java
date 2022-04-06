package listadoblecircular;
import javax.swing.JOptionPane;
public class Menu {
   private int opcion;
   private ListaDC ldc=new ListaDC();
   public void mostrarMenu(){
      opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
              "***LISTA DOBLE CIRCULAR***\n\n"
                      + "1.Agregar elemento\n"
                      + "2.Extraer elemento del inicio\n"
                      + "3.Mostrar elementos\n"
                      + "4.Salir\n\n"
                      + "Digite su opción:"));
      switch(opcion){
          case 1:{
            ldc.agregar();
            mostrarMenu();
            break;
          }
          case 2:{
            ldc.extraeralInicio();
            mostrarMenu();
            break;
          }
          case 3:{
            ldc.mostrarElementos();
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
