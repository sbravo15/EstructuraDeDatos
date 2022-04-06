package listadcaarbol;

import javax.swing.JOptionPane;

public class Rutina {

    private NodoDC iniDC;
    private NodoDC finDC;
    private Nodo raiz;

    public Rutina() {
        this.iniDC = null;
        this.finDC = null;
        this.raiz = null;
    }

    public boolean esVaciaDC() {
        if (iniDC == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esVacio() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarDC() {
        Dato d = new Dato();
        d.setNumero(Integer.parseInt(JOptionPane.
                showInputDialog(null, "Digite un número:")));
        NodoDC nuevo = new NodoDC();
        nuevo.setDato(d);
        if (esVaciaDC()) {
            iniDC = nuevo;
            finDC = nuevo;
            finDC.setSiguiente(iniDC);
            iniDC.setAnterior(finDC);
        } else if (d.getNumero() < iniDC.getDato().getNumero()) {
            nuevo.setSiguiente(iniDC);
            iniDC = nuevo;
            finDC.setSiguiente(iniDC);
            iniDC.setAnterior(finDC);
        } else if (d.getNumero() >= finDC.getDato().getNumero()) {
            finDC.setSiguiente(nuevo);
            finDC = nuevo;
            finDC.setSiguiente(iniDC);
            iniDC.setAnterior(finDC);
        } else {
            NodoDC aux = iniDC;
            while (aux.getSiguiente().getDato().getNumero()
                    < d.getNumero()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            nuevo.getSiguiente().setAnterior(nuevo);
        }
    }

    public void mostrarListaDC() {
        String s = "";
        if (!esVaciaDC()) {
            NodoDC auxDC = iniDC;
            s = s + auxDC.getDato().getNumero()
                    + "<==>";
            auxDC = auxDC.getSiguiente();
            while (auxDC != iniDC) {
                s = s + auxDC.getDato().getNumero()
                        + "<==>";
                auxDC = auxDC.getSiguiente();
            }
            JOptionPane.showMessageDialog(null,
                    "La lista doble circular contiene:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se puede mostrar, lista vacía!");
        }
    }

    public void copiar() {
        if (!esVaciaDC()) {
            NodoDC aux = iniDC;
            crearRaiz(aux.getDato().getNumero());
            aux = aux.getSiguiente();
            while (aux != iniDC) {
                crearRaiz(aux.getDato().getNumero());
                aux = aux.getSiguiente();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se puede copiar, lista vacía!");
        }
    }

    public void crearRaiz(int numero) {
        Dato d = new Dato();
        d.setNumero(numero);
        Nodo nuevo = new Nodo();
        nuevo.setElemento(d);
        if (esVacio()) {
            raiz = nuevo;
        } else {
            crearNodo(raiz, nuevo);
        }
    }

    public void crearNodo(Nodo raiz, Nodo nuevo) {
        if (nuevo.getElemento().getNumero()
                <= raiz.getElemento().getNumero()) {
            if (raiz.getEnlaceIzq() == null) {
                raiz.setEnlaceIzq(nuevo);
            } else {
                crearNodo(raiz.getEnlaceIzq(), nuevo);
            }
        } else {
            if (raiz.getEnlaceDer() == null) {
                raiz.setEnlaceDer(nuevo);
            } else {
                crearNodo(raiz.getEnlaceDer(), nuevo);
            }
        }
    }

    public void mostrarRaiz() {
        if (!esVacio()) {
            mostrarNodo(raiz);
        } else {
            System.out.print("No se puede mostrar, árbol vacío!");
        }
    }

    public void mostrarNodo(Nodo n) {
        if (n != null) {
            mostrarNodo(n.getEnlaceIzq());
            System.out.print(n.getElemento().getNumero() + " ");
            mostrarNodo(n.getEnlaceDer());
        }
    }
}
