package listadoblecircular;
import javax.swing.JOptionPane;
public class ListaDC {
   private NodoDC inicio;
   private NodoDC fin;
   
   public ListaDC(){
      this.inicio=null;
      this.fin=null;
   }
   public boolean esVaciaDC(){
      if(inicio==null){
         return true;
      }else{
         return false;
      }
   }
   public void agregar(){
      Prenda p=new Prenda();
      p.setCodigoPrenda(Integer.parseInt(JOptionPane.
       showInputDialog(null,"Digite el código del producto:")));
      p.setDescripcion(JOptionPane.showInputDialog(null,
              "Digite la descripción:"));
      p.setCantidad(Integer.parseInt(JOptionPane.
              showInputDialog(null,"Digite la cantidad:")));
      p.setPrecio(Double.parseDouble(JOptionPane.
              showInputDialog(null,"Digite el precio:")));
      NodoDC nuevo=new NodoDC();
      nuevo.setElemento(p);
      if(esVaciaDC()){
         inicio=nuevo;
         fin=nuevo;
         fin.setSiguiente(inicio);
         inicio.setAnterior(fin);
      }else if(p.getCodigoPrenda()<inicio.getElemento().getCodigoPrenda()){
         nuevo.setSiguiente(inicio);
         inicio=nuevo;
         fin.setSiguiente(inicio);
         inicio.setAnterior(fin);
      }else if(p.getCodigoPrenda()>=fin.getElemento().getCodigoPrenda()){
         fin.setSiguiente(nuevo);
         fin=nuevo;
         fin.setSiguiente(inicio);
         inicio.setAnterior(fin);
      }else{
         NodoDC aux=inicio;
         while(aux.getSiguiente().getElemento().getCodigoPrenda()<
                 p.getCodigoPrenda()){
            aux=aux.getSiguiente();
         }
         nuevo.setSiguiente(aux.getSiguiente());
         nuevo.setAnterior(aux);
         aux.setSiguiente(nuevo);
         nuevo.getSiguiente().setAnterior(nuevo);
      }
   }
   public void extraeralInicio(){
      if(!esVaciaDC()){
         inicio=inicio.getSiguiente();
         fin.setSiguiente(inicio);
         inicio.setAnterior(fin);
         JOptionPane.showMessageDialog(null,"El elemento fue extraído!");
      }else{
         JOptionPane.showMessageDialog(null,"No existen elementos, lista vacía!");
      }
   }
   public void mostrarElementos(){
      if(!esVaciaDC()){
         String s="";
         NodoDC aux=inicio;
         s=s+aux.getElemento().getCodigoPrenda()+"--"+
                 aux.getElemento().getDescripcion()+"--"+
                 aux.getElemento().getCantidad()+"--"+
                 aux.getElemento().getPrecio()+"<==>";
         aux=aux.getSiguiente();
         while(aux!=inicio){
            s=s+aux.getElemento().getCodigoPrenda()+"--"+
                 aux.getElemento().getDescripcion()+"--"+
                 aux.getElemento().getCantidad()+"--"+
                 aux.getElemento().getPrecio()+"<==>";
            aux=aux.getSiguiente();
         }
         JOptionPane.showMessageDialog(null,
                 "La lista doble circular contiene:\n"+s);
      }else{
            JOptionPane.showMessageDialog(null,
                 "No se puede mostrar, lista vacía!"); 
      }
   }
}
