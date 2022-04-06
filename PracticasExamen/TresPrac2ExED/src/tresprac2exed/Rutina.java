package tresprac2exed;

import javax.swing.JOptionPane;

public class Rutina {

    private int vec[] = new int[4];
    private int mat[][] = new int[2][2];
    private NodoP cima;
    private NodoSC iniSC;
    private NodoSC finSC;
    private NodoDC iniDC;
    private NodoDC finDC;

    public Rutina() {
        this.cima = null;
        this.iniSC = null;
        this.finSC = null;
        this.iniDC = null;
        this.finDC = null;
    }

    public boolean esVaciaP() {
        if (cima == null) {
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

    public void llenarVector() {
        int x;
        for (x = 0; x < vec.length; x++) {
            vec[x] = (int) (1 + Math.random() * 98);
        }
        JOptionPane.showMessageDialog(null,
                "Se llenó el vector");
    }

    public void llenarMatriz() {
        int x, y;
        for (x = 0; x < mat.length; x++) {
            for (y = 0; y < mat.length; y++) {
                mat[x][y] = (int) (1 + Math.random() * 98);
            }
        }
        JOptionPane.showMessageDialog(null,
                "Se llenó la matriz");
    }

    public void llenarPila() {
        int x;
        for (x = 0; x < 4; x++) {
            Dato d = new Dato();
            d.setNum((int) (1 + Math.random() * 98));
            NodoP nuevo = new NodoP();
            nuevo.setElemento(d);
            if (esVaciaP()) {
                cima = nuevo;
            } else {
                nuevo.setSiguiente(cima);
                cima = nuevo;
            }
        }
        JOptionPane.showMessageDialog(null,
                "Se llenó la pila");
    }

    public void copiarAListaSC() {
        int x, y;
        for (x = 0; x < vec.length; x++) {
            llenarListaSC(vec[x]);
        }
        JOptionPane.showMessageDialog(null,
                "Se copió el vector");
        for (x = 0; x < mat.length; x++) {
            for (y = 0; y < mat.length; y++) {
                llenarListaSC(mat[x][y]);
            }
        }
        JOptionPane.showMessageDialog(null,
                "Se copió la matriz");
        if (!esVaciaP()) {
            NodoP aux = cima;
            while (aux != null) {
                llenarListaSC(aux.getElemento().getNum());
                aux = aux.getSiguiente();
            }
        }
        JOptionPane.showMessageDialog(null,
                "Se copió la pila");
    }

    public void llenarListaSC(int num) {
        Dato d = new Dato();
        d.setNum(num);
        NodoSC nuevo = new NodoSC();
        nuevo.setElemento(d);
        if (esVaciaSC()) {
            iniSC = nuevo;
            finSC = nuevo;
            finSC.setSiguiente(iniSC);
        } else if (d.getNum() < iniSC.getElemento().getNum()) {
            nuevo.setSiguiente(iniSC);
            iniSC = nuevo;
            finSC.setSiguiente(iniSC);
        } else if (d.getNum() >= finSC.getElemento().getNum()) {
            finSC.setSiguiente(nuevo);
            finSC = nuevo;
            finSC.setSiguiente(iniSC);
        } else {
            NodoSC aux = iniSC;
            while (aux.getSiguiente().getElemento().getNum()
                    < d.getNum()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            finSC.setSiguiente(iniSC);
        }
    }

    public int calcularTamVec02() {
        int cant = 0;
        if (!esVaciaSC()) {
            NodoSC aux = iniSC;
            cant = cant + 1;
            aux = aux.getSiguiente();
            while (aux != iniSC) {
                cant = cant + 1;
                aux = aux.getSiguiente();
            }
        }
        return cant;
    }

    public void copiarListaSCAVector() {
        int cant = calcularTamVec02();
        int x = 0;
        String s = "";
        if (!esVaciaSC()) {
            NodoSC aux = iniSC;
            Dato vec02[] = new Dato[cant];
            vec02[x] = iniSC.getElemento();
            x++;
            aux = aux.getSiguiente();
            while (aux != iniSC) {
                vec02[x] = aux.getElemento();
                x++;
                aux = aux.getSiguiente();
            }
            for (x = 0; x < vec02.length; x++) {
                s = s + vec02[x].getNum() + " ";
            }
            JOptionPane.showMessageDialog(null,
                    "El vector contiene:\n" + s);
            for (x = 0; x < vec02.length; x++) {
                llenarListaDC(vec02[x].getNum());
            }
        }
    }

    public void llenarListaDC(int num) {
        Dato d = new Dato();
        d.setNum(num);
        NodoDC nuevo = new NodoDC();
        nuevo.setElemento(d);
        if (esVaciaDC()) {
            iniDC = nuevo;
            finDC = nuevo;
            finDC.setSiguiente(iniDC);
            iniDC.setAnterior(finDC);
        } else if (d.getNum() < iniDC.getElemento().getNum()) {
            nuevo.setSiguiente(iniDC);
            iniDC = nuevo;
            finDC.setSiguiente(iniDC);
            iniDC.setAnterior(finDC);
        } else if (d.getNum() >= finDC.getElemento().getNum()) {
            finDC.setSiguiente(nuevo);
            finDC = nuevo;
            finDC.setSiguiente(iniDC);
            iniDC.setAnterior(finDC);
        } else {
            NodoDC aux = iniDC;
            while (aux.getSiguiente().getElemento().getNum()
                    < d.getNum()) {
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
            NodoDC aux = iniDC;
            s = s + aux.getElemento().getNum() + "<==>";
            aux = aux.getSiguiente();
            while (aux != iniDC) {
                s = s + aux.getElemento().getNum() + "<==>";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null,
                    "La lista contiene:\n"+s);
        }else{
            JOptionPane.showMessageDialog(null,
                    "No se puede mostrar, lista vacía!");        
        }
    }
    }
