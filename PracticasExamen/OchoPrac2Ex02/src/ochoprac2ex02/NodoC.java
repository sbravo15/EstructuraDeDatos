package ochoprac2ex02;

public class NodoC {

    private DatoC elemento;
    private NodoC siguiente;

    public NodoC() {
        this.siguiente = null;
    }

    public DatoC getElemento() {
        return elemento;
    }

    public void setElemento(DatoC elemento) {
        this.elemento = elemento;
    }

    public NodoC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoC siguiente) {
        this.siguiente = siguiente;
    }

}
