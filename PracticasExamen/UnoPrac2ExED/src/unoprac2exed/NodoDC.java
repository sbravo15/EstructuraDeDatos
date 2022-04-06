package unoprac2exed;
public class NodoDC {
   private Dato elemento;
   private NodoDC siguiente;
   private NodoDC anterior;
   
   public NodoDC(){
      this.siguiente=null;
      this.anterior=null;
   }

    public Dato getElemento() {
        return elemento;
    }

    public void setElemento(Dato elemento) {
        this.elemento = elemento;
    }

    public NodoDC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDC siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDC getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDC anterior) {
        this.anterior = anterior;
    }
   
}
