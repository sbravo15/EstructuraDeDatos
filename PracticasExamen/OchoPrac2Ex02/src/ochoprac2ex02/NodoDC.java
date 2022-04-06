package ochoprac2ex02;

public class NodoDC {

    private DatoDC elemento;
    private NodoDC siguiente;
    private NodoDC anterior;

    public NodoDC() {
        this.anterior = null;
        this.siguiente = null;
    }

    public DatoDC getElemento() {
        return elemento;
    }

    public void setElemento(DatoDC elemento) {
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
