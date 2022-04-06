package tresprac2exed;

public class NodoSC {

    private Dato elemento;
    private NodoSC siguiente;

    public NodoSC() {
        this.siguiente = null;
    }

    public Dato getElemento() {
        return elemento;
    }

    public void setElemento(Dato elemento) {
        this.elemento = elemento;
    }

    public NodoSC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSC siguiente) {
        this.siguiente = siguiente;
    }

}
