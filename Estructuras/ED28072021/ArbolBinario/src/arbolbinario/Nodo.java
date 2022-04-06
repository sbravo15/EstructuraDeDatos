package arbolbinario;

public class Nodo {

    private Dato elemento;
    private Nodo enlaceIzq;
    private Nodo enlaceDer;

    public Nodo() {
        this.enlaceIzq = null;
        this.enlaceDer = null;
    }

    public Dato getElemento() {
        return elemento;
    }

    public void setElemento(Dato elemento) {
        this.elemento = elemento;
    }

    public Nodo getEnlaceIzq() {
        return enlaceIzq;
    }

    public void setEnlaceIzq(Nodo enlaceIzq) {
        this.enlaceIzq = enlaceIzq;
    }

    public Nodo getEnlaceDer() {
        return enlaceDer;
    }

    public void setEnlaceDer(Nodo enlaceDer) {
        this.enlaceDer = enlaceDer;
    }

}
