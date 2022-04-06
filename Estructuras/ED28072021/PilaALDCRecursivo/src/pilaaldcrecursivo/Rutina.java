package pilaaldcrecursivo;

import javax.swing.JOptionPane;

public class Rutina {

    private NodoP cima;
    private NodoDC iniDC;
    private NodoDC finDC;

    public boolean esVacia() {
        if (cima == null) {
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

    public NodoP apilar() {
      int x;
      for(x=0;x<5;x++){
        NodoP nuevo = new NodoP();
        Dato d = new Dato();
        d.setId(Byte.parseByte(JOptionPane.
                showInputDialog(null, "Digite el id.:")));
        d.setNombre(JOptionPane.showInputDialog(null,
                "Digite el nombre:"));
        nuevo.setElemento(d);
        if (esVacia()) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
      }  
      return cima;
    }
    
    public void mostrarPila() {
        String s = "";
        NodoP aux = cima;
        if (!esVacia()) {
            while (aux != null) {
                s = s + aux.getElemento().getId()
                        + "  " + aux.getElemento().getNombre() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null,
                    "La pila contiene:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se puede mostrar,pila vacía!",
                    "Pila vacía", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void copiar(NodoP aux){
       if(aux!=null){
          agregarDC(aux);
          aux=aux.getSiguiente();
          copiar(aux);
       }
    }
    public void agregarDC(NodoP aux) {
        int x;
        NodoDC nuevo = new NodoDC();
        nuevo.setElemento(aux.getElemento());
        if (esVaciaDC()) {
            iniDC = nuevo;
            finDC = nuevo;
            finDC.setSiguiente(iniDC);
            iniDC.setAnterior(finDC);
        } else if (aux.getElemento().getId()< iniDC.getElemento().getId()) {
            nuevo.setSiguiente(iniDC);
            iniDC = nuevo;
            finDC.setSiguiente(iniDC);
            iniDC.setAnterior(finDC);
        } else if (aux.getElemento().getId() >= finDC.getElemento().getId()) {
            finDC.setSiguiente(nuevo);
            finDC = nuevo;
            finDC.setSiguiente(iniDC);
            iniDC.setAnterior(finDC);
        } else {
            NodoDC auxi = iniDC;
            while (auxi.getSiguiente().getElemento().getId()
                    < aux.getElemento().getId()) {
                auxi = auxi.getSiguiente();
            }
            nuevo.setSiguiente(auxi.getSiguiente());
            nuevo.setAnterior(auxi);
            auxi.setSiguiente(nuevo);
            nuevo.getSiguiente().setAnterior(nuevo);
        }
    }
    public void mostrarLDC(){
      if(!esVaciaDC()){
         String s="";
         NodoDC aux=iniDC;
         s=s+aux.getElemento().getId()+"--"+
                 aux.getElemento().getNombre()+"<==>";
         aux=aux.getSiguiente();
         while(aux!=iniDC){
            s=s+aux.getElemento().getId()+"--"+
                 aux.getElemento().getNombre()+"<==>";;
            aux=aux.getSiguiente();
         }
         JOptionPane.showMessageDialog(null,
                 "La lista doble circular contiene:\n"+s);
      }else{
            JOptionPane.showMessageDialog(null,
                 "No se puede mostrar, lista vacía!"); 
      }
   }
}


