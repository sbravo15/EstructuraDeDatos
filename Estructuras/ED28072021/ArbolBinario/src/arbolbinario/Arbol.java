package arbolbinario;

import javax.swing.JOptionPane;

public class Arbol {
   private Nodo raiz;
   
   public Arbol(){
      this.raiz=null;
   }
   public boolean esVacio(){
      if(raiz==null){
         return true;
      }else{
         return false;
      }
   }
   public void crearRaiz(){
      Dato d=new Dato();
      d.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null,
              "Digite un número:")));
      Nodo nuevo=new Nodo();
      nuevo.setElemento(d);
      if(esVacio()){
         raiz=nuevo;
      }else{
         crearNodo(raiz,nuevo);
      }
   }
   public void crearNodo(Nodo raiz,Nodo nuevo){
      if(nuevo.getElemento().getNumero()<=raiz.getElemento().getNumero()){
         if(raiz.getEnlaceIzq()==null){
            raiz.setEnlaceIzq(nuevo);
         }else{
            crearNodo(raiz.getEnlaceIzq(),nuevo);
         }
      }else{
         if(raiz.getEnlaceDer()==null){
            raiz.setEnlaceDer(nuevo);
         }else{
            crearNodo(raiz.getEnlaceDer(),nuevo);
         }
      }
   }
   public void mostrarRaiz(){
      if(!esVacio()){
         mostrarNodo(raiz);
      }else{
         System.out.print("No se puede mostrar, árbol vacío!");
      }
   }
   public void mostrarNodo(Nodo n){
      if(n!=null){
         mostrarNodo(n.getEnlaceIzq());
         System.out.print(n.getElemento().getNumero()+" ");
         mostrarNodo(n.getEnlaceDer());
      }
   }
}
