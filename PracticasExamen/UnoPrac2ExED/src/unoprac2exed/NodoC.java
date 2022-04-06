package unoprac2exed;
public class NodoC {
   private Dato elemento;
   private NodoC siguiente;
   
   public NodoC(){
      this.siguiente=null; 
   }

    public Dato getElemento() {
        return elemento;
    }

    public void setElemento(Dato elemento) {
        this.elemento = elemento;
    }

    public NodoC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoC siguiente) {
        this.siguiente = siguiente;
    }
   
}
