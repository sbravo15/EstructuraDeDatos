package ochoprac2ex02;

import javax.swing.JOptionPane;

public class Rutina {

    private NodoC iniC01;
    private NodoC finC01;
    private NodoSC iniSC;
    private NodoSC finSC;
    private NodoDC iniDC;
    private NodoDC finDC;
    private NodoC02 iniC02;
    private NodoC02 finC02;

    public boolean esVaciaC01() {
        if (iniC01 == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esVaciaSC() {
        if (iniSC == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esVaciaDC() {
        if (iniDC == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esVaciaC02() {
        if (iniC02 == null) {
            return true;
        } else {
            return false;
        }
    }

    public void encolar() {
        int x;
        for (x = 0; x < 5; x++) {
            DatoC dc = new DatoC();
            dc.setLetra(JOptionPane.showInputDialog(null, "Digite una letra:").charAt(0));
            NodoC nuevo = new NodoC();
            nuevo.setElemento(dc);
            if (esVaciaC01()) {
                iniC01 = nuevo;
                finC01 = nuevo;
            } else {
                finC01.setSiguiente(nuevo);
                finC01 = nuevo;
            }
        }
        JOptionPane.showMessageDialog(null, "Se llenó la primera cola!");
    }

    public void llenarListaSC() {
        int x;
        for (x = 0; x < 5; x++) {
            DatoSC d = new DatoSC();
            d.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite un número:")));
            NodoSC nuevo = new NodoSC();
            nuevo.setElemento(d);
            if (esVaciaSC()) {
                iniSC = nuevo;
                finSC = nuevo;
                finSC.setSiguiente(iniSC);
            } else if (d.getNumero() < iniSC.getElemento().getNumero()) {
                nuevo.setSiguiente(iniSC);
                iniSC = nuevo;
                finSC.setSiguiente(iniSC);
            } else if (d.getNumero() >= finSC.getElemento().getNumero()) {
                finSC.setSiguiente(nuevo);
                finSC = nuevo;
                finSC.setSiguiente(iniSC);
            } else {
                NodoSC aux = iniSC;
                while (aux.getSiguiente().getElemento().getNumero() < d.getNumero()) {
                    aux = aux.getSiguiente();
                }
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
                finSC.setSiguiente(iniSC);
            }
        }
        JOptionPane.showMessageDialog(null, "Se llenó la lista simple circular!");
    }

    public void llenarListaDC() {
        int x;
        for (x = 0; x < 5; x++) {
            DatoDC dc = new DatoDC();
            dc.setPalabra(JOptionPane.showInputDialog(null, "Digite una palabra:"));
            NodoDC nuevo = new NodoDC();
            nuevo.setElemento(dc);
            if (esVaciaDC()) {
                iniDC = nuevo;
                finDC = nuevo;
                finDC.setSiguiente(iniDC);
                iniDC.setAnterior(finDC);
            } else if (dc.getPalabra().compareTo(iniDC.getElemento().getPalabra()) < 0) {
                nuevo.setSiguiente(iniDC);
                iniDC = nuevo;
                finDC.setSiguiente(iniDC);
                iniDC.setAnterior(finDC);
            } else if (dc.getPalabra().compareTo(finDC.getElemento().getPalabra()) >= 0) {
                finDC.setSiguiente(nuevo);
                finDC = nuevo;
                finDC.setSiguiente(iniDC);
                iniDC.setAnterior(finDC);
            } else {
                NodoDC aux = iniDC;
                while (aux.getSiguiente().getElemento().getPalabra().compareTo(dc.getPalabra()) < 0) {
                    aux = aux.getSiguiente();
                }
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
                nuevo.setAnterior(aux);
                nuevo.getSiguiente().setAnterior(nuevo);
            }
        }
        JOptionPane.showMessageDialog(null, "Se llenó la lista doble circular!");
    }

    public void copiarCola01aCola02() {
        if (!esVaciaC01()) {
            NodoC aux = iniC01;
            while (aux != null) {
                encolar02(aux.getElemento().getLetra(), 0, "No hay");
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La primera cola fue copiada!");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede copiar. Cola vacía!");
        }
    }

    public void copiarListaSCaCola02() {
        if (!esVaciaSC()) {
            NodoSC aux = iniSC;
            encolar02('*', aux.getElemento().getNumero(), "No hay");
            aux = aux.getSiguiente();
            while (aux != iniSC) {
                encolar02('*', aux.getElemento().getNumero(), "No hay");
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista simple circular fue copiada!");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede copiar. Lista simple circular vacía!");
        }
    }

    public void copiarListaDCaCola02() {
        if (!esVaciaDC()) {
            NodoDC aux = iniDC;
            encolar02('*', 0, aux.getElemento().getPalabra());
            aux = aux.getSiguiente();
            while (aux != iniDC) {
                encolar02('*', 0, aux.getElemento().getPalabra());
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista doble circular fue copiada!");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede copiar. Lista doble circular vacía!");
        }
    }

    public void encolar02(char letra, int numero, String palabra) {
        DatoC02 dc02 = new DatoC02();
        dc02.setLetra(letra);
        dc02.setPalabra(palabra);
        dc02.setNum(numero);
        NodoC02 nuevo = new NodoC02();
        nuevo.setElemento(dc02);
        if (esVaciaC02()) {
            iniC02 = nuevo;
            finC02 = nuevo;
        } else {
            finC02.setSiguiente(nuevo);
            finC02 = nuevo;
        }
    }

    public void mostrarColaCompleta() {
        if (!esVaciaC02()) {
            NodoC02 aux = iniC02;
            String s = "";
            while (aux != null) {
                s = s + aux.getElemento().getLetra() + "--" + aux.getElemento().getNum() + "--"
                        + aux.getElemento().getPalabra() + "-->";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La nueva cola contiene:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar. Cola vacía!");
        }
    }

    public void mostrarColaSinVocalesSinParesSinPalabrasInicianConConsonante() {
        if (!esVaciaC02()) {
            NodoC02 aux = iniC02;
            String s = "";
            while (aux != null) {
                if ((aux.getElemento().getLetra() != 'a') || (aux.getElemento().getLetra() != 'e')
                        || (aux.getElemento().getLetra() != 'i') || (aux.getElemento().getLetra() != 'o')
                        || (aux.getElemento().getLetra() != 'u')) {
                    if (aux.getElemento().getNum() % 2 != 0) {
                        if ((aux.getElemento().getPalabra().charAt(0) == 'a') || (aux.getElemento().getPalabra().charAt(0) == 'e')
                                || (aux.getElemento().getPalabra().charAt(0) == 'i') || (aux.getElemento().getPalabra().charAt(0) != 'o')
                                || (aux.getElemento().getPalabra().charAt(0) == 'u')) {
                            s = s + aux.getElemento().getLetra() + "--" + aux.getElemento().getNum() + "--"
                                    + aux.getElemento().getPalabra() + "-->";
                        }
                    }
                }
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La cola con los elementos excluidos contiene:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar. Cola vacía!");
        }
    }
}
