package ochoprac2ex02;

public class NodoC02 {

    private DatoC02 elemento;
    private NodoC02 siguiente;

    public NodoC02() {
        this.siguiente = null;
    }

    public DatoC02 getElemento() {
        return elemento;
    }

    public void setElemento(DatoC02 elemento) {
        this.elemento = elemento;
    }

    public NodoC02 getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoC02 siguiente) {
        this.siguiente = siguiente;
    }

}
