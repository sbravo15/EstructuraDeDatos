package arbolalista;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
       Rutina r=new Rutina();
       int seguir=0;
       String s="";
       while(seguir==0){
          int num=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite un número:"));
          r.crearRaiz(num);
          seguir=JOptionPane.showConfirmDialog(null,"¿Desea ingresar otro elemento?");
       }
       s=r.mostrarRaiz();
       JOptionPane.showMessageDialog(null,s);
       r.copiar();
       r.mostrarLES();
    }
}
