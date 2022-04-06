package pila;
import javax.swing.JOptionPane;
public class Pila {
   private NodoP cima;
   
   public Pila(){
      this.cima=null;
   }
   
   public boolean esVacia(){
      if(cima==null){
         return true;
      }else{
         return false;
      }  
   }
   
   public void apilar(){
      Dato d=new Dato();
      d.setCodLibro(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el código del libro:")));
      d.setTitulo(JOptionPane.showInputDialog(null,"Digite el título:"));
      d.setAutor(JOptionPane.showInputDialog(null,"Digite el autor:"));
      NodoP nuevo=new NodoP();
      nuevo.setElemento(d);
      if(esVacia()){
         cima=nuevo;
      }else{
         nuevo.setSiguiente(cima);
         cima=nuevo;
      }
   }
   
   public void desapilar(){
      if(!esVacia()){
         cima=cima.getSiguiente();
         JOptionPane.showMessageDialog(null,"El elemento fue extraído!",
                 "Elemento extraído",JOptionPane.INFORMATION_MESSAGE);
      }else{
         JOptionPane.showMessageDialog(null,
                 "No se puede extraer, elementos, pila vacía!",
                 "Error",JOptionPane.ERROR_MESSAGE);
      }
   }
   
   public void mostrarElementos(){
      String s="";
      if(!esVacia()){
         NodoP aux=cima;
         while(aux!=null){
            s=s+aux.getElemento().getCodLibro()+"--"+
                    aux.getElemento().getTitulo()+"--"+aux.getElemento().getAutor()+"\n";
            aux=aux.getSiguiente();
         }
         JOptionPane.showMessageDialog(null,"La pila contiene:\n"+s);
      }else{
         JOptionPane.showMessageDialog(null,"¡No hay elementos para mostrar pila vacía!");
      }
   }
}
