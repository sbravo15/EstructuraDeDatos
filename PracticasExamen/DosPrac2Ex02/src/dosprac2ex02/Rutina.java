package dosprac2ex02;

import javax.swing.JOptionPane;

public class Rutina {

    private NodoC iniC;
    private NodoC finC;
    private NodoP cima;
    private NodoDC iniDC;
    private NodoDC finDC;
    private String palabra;

    public Rutina() {
        this.iniC = null;
        this.finC = null;
        this.cima = null;
        this.iniDC = null;
        this.finDC = null;
    }

    public boolean esVaciaC() {
        if (iniC == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esVaciaP() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esVaciaLDC() {
        if (iniDC == null) {
            return true;
        } else {
            return false;
        }
    }

    public void leerPalabra() {
        palabra = JOptionPane.showInputDialog(null, "Digite una palabra:");
    }

    public void copiarAPila() {
        int x;
        for (x = 0; x < palabra.length(); x++) {
            apilar(palabra.charAt(x));
        }
    }

    public void apilar(char letra) {
        Dato d = new Dato();
        d.setLetra(letra);
        NodoP nuevo = new NodoP();
        nuevo.setElemento(d);
        if (esVaciaP()) {
            this.cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            this.cima = nuevo;
        }
    }

    public void copiarACola() {
        if (!esVaciaP()) {
            NodoP aux = cima;
            while (aux != null) {
                encolar(aux.getElemento().getLetra());
                aux = aux.getSiguiente();
            }
        }
    }

    public void encolar(char letra) {
        Dato d = new Dato();
        d.setLetra(letra);
        NodoC nuevo = new NodoC();
        nuevo.setElemento(d);
        if (esVaciaC()) {
            iniC = nuevo;
            finC = nuevo;
        } else {
            finC.setSiguiente(nuevo);
            finC = nuevo;
        }

    }
    public void copiarALista() {
        if (!esVaciaP()) {
            NodoC aux = iniC;
            while (aux != null) {
                agregarLDC(aux.getElemento().getLetra());
                aux = aux.getSiguiente();
            }
        }
    }
    public void agregarLDC(char letra){
      Dato d = new Dato();
        d.setLetra(letra);
        NodoDC nuevo=new NodoDC();
        nuevo.setElemento(d);
      if(esVaciaLDC()){
         iniDC=nuevo;
         finDC=nuevo;
         finDC.setSiguiente(iniDC);
         iniDC.setAnterior(finDC);
      }else if(d.getLetra()<iniDC.getElemento().getLetra()){
         nuevo.setSiguiente(iniDC);
         iniDC=nuevo;
         finDC.setSiguiente(iniDC);
         iniDC.setAnterior(finDC);
      }else if(d.getLetra()>=finDC.getElemento().getLetra()){
         finDC.setSiguiente(nuevo);
         finDC=nuevo;
         finDC.setSiguiente(iniDC);
         iniDC.setAnterior(finDC);
      }else{
         NodoDC aux=iniDC;
         while(aux.getSiguiente().getElemento().getLetra()<
                 d.getLetra()){
            aux=aux.getSiguiente();
         }
         nuevo.setSiguiente(aux.getSiguiente());
         nuevo.setAnterior(aux);
         aux.setSiguiente(nuevo);
         nuevo.getSiguiente().setAnterior(nuevo);
      }
   }
   public void mostrarElementosLDC(){
      int cantVoc=0;
      if(!esVaciaLDC()){
         String s="";
         NodoDC aux=iniDC;
         char letra=String.valueOf(aux.getElemento().getLetra())
                 .toUpperCase().charAt(0);
         s=s+letra+"<==>";
         if((letra=='A')||(letra=='E')||
         (letra=='I')||(letra=='O')||
         (letra=='U')){
             cantVoc++;
         }
         aux=aux.getSiguiente();
         while(aux!=iniDC){
            letra=String.valueOf(aux.getElemento().getLetra())
                 .toUpperCase().charAt(0); 
            s=s+letra+"<==>";
            if((letra=='A')||(letra=='E')||
         (letra=='I')||(letra=='O')||
         (letra=='U')){
             cantVoc++;
         }
            aux=aux.getSiguiente();
         }
         JOptionPane.showMessageDialog(null,
                 "La lista doble circular contiene:\n"+s+
                         "\nLa cantidad de vocales es:"+cantVoc);
      }else{
            JOptionPane.showMessageDialog(null,
                 "No se puede mostrar, lista vacía!"); 
      }
   } 
}
