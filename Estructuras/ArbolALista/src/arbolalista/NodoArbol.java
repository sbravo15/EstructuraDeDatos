package arbolalista;

public class NodoArbol {

    private Dato elemento;
    private NodoArbol enlaceIzq;
    private NodoArbol enlaceDer;

    public NodoArbol() {
        this.enlaceIzq = null;
        this.enlaceDer = null;
    }

    public Dato getElemento() {
        return elemento;
    }

    public void setElemento(Dato elemento) {
        this.elemento = elemento;
    }

    public NodoArbol getEnlaceIzq() {
        return enlaceIzq;
    }

    public void setEnlaceIzq(NodoArbol enlaceIzq) {
        this.enlaceIzq = enlaceIzq;
    }

    public NodoArbol getEnlaceDer() {
        return enlaceDer;
    }

    public void setEnlaceDer(NodoArbol enlaceDer) {
        this.enlaceDer = enlaceDer;
    }

}
