package ochoprac2ex02;
public class NodoSC {
   private DatoSC elemento;
   private NodoSC siguiente;
   
   public NodoSC(){
      this.siguiente=null;
   }

    public DatoSC getElemento() {
        return elemento;
    }

    public void setElemento(DatoSC elemento) {
        this.elemento = elemento;
    }

    public NodoSC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSC siguiente) {
        this.siguiente = siguiente;
    }
   
}
