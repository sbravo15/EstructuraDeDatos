package arbolalista;
import javax.swing.JOptionPane;
public class Rutina {
   private NodoArbol raiz;
   private NodoLES inicio;
   private String s="";
   
   public boolean esVacioArbol(){
      if(raiz==null){
         return true;
      }else{
         return false;
      }
   }
   
   public boolean esVaciaLES(){
      if(inicio==null){
         return true;
      }else{
         return false;
      }
   }   
   
   public void crearRaiz(int num){
      Dato d=new Dato();
      d.setNum(num);
      NodoArbol nuevo=new NodoArbol();
      nuevo.setElemento(d);
      if(esVacioArbol()){
         raiz=nuevo;
      }else{
         crearNodo(raiz,nuevo);
      }
   }   
   public void crearNodo(NodoArbol raiz,NodoArbol nuevo){
      if(nuevo.getElemento().getNum()<=raiz.getElemento().getNum()){
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
   public String mostrarRaiz(){
      if(!esVacioArbol()){  
          s=s+mostrarNodo(raiz);
      }else{
          JOptionPane.showMessageDialog(null,"No existen elementos para mostrar, árbol vacío!");
      } 
      return s;
   }
   public String mostrarNodo(NodoArbol n){
      if(n!=null){
         mostrarNodo(n.getEnlaceIzq());
         s=s+n.getElemento().getNum()+" ";
         mostrarNodo(n.getEnlaceDer());
      }
      return s;
   }
   public void copiar(){
      if(!esVacioArbol()){
         copiarNodo(raiz);
      }else{
         JOptionPane.showMessageDialog(null,"¡No existen elementos para copiar, árbol vacío!");
      }
   }
   public void copiarNodo(NodoArbol n){
      if(n!=null){
         copiarNodo(n.getEnlaceIzq());
         llenarLES(n.getElemento().getNum());
         copiarNodo(n.getEnlaceDer());
      }
   }
   public void llenarLES(int num){
      Dato d=new Dato();
      d.setNum(num);
      NodoLES nuevo=new NodoLES();
      nuevo.setElemento(d);
      if(esVaciaLES()){
         inicio=nuevo;
      }else if(d.getNum()<inicio.getElemento().getNum()){
         nuevo.setSiguiente(inicio);
         inicio=nuevo;
      }else if(inicio.getSiguiente()==null){
         inicio.setSiguiente(nuevo);
      }else{
         NodoLES aux=inicio;
         while((aux.getSiguiente()!=null)&&(aux.getSiguiente().getElemento().getNum()<
                 d.getNum())){
             aux=aux.getSiguiente();
         }
         nuevo.setSiguiente(aux.getSiguiente());
         aux.setSiguiente(nuevo);
      }
   }
   public void mostrarLES(){
      s=""; 
      if(!esVaciaLES()){
         NodoLES aux=inicio;
         while(aux!=null){
            s=s+aux.getElemento().getNum()+"<--";
            aux=aux.getSiguiente();
         }
         JOptionPane.showMessageDialog(null,"La lista contiene:\n"+s);
      }else{
         JOptionPane.showMessageDialog(null,"No se puede mostrar. ¡La lista está vacía!");
      }
   }
}
