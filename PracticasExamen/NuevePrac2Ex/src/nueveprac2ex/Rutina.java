package nueveprac2ex;

import javax.swing.JOptionPane;

public class Rutina {

    private NodoP cima;
    private NodoDC iniDC;
    private NodoDC finDC;
    private int mat[][] = new int[2][2];
    private int vec[] = new int[4];
    
    public Rutina() {
        this.cima = null;
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

    public boolean esVaciaDC() {
        if (iniDC == null) {
            return true;
        } else {
            return false;
        }
    }

    public void apilar() {
        int x;
        for (x = 0; x < 4; x++) {
            Dato d = new Dato();
            d.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Digite un número:")));
            NodoP nuevo = new NodoP();
            nuevo.setElemento(d);
            if(esVaciaP()){
               cima=nuevo;
            }else{
               nuevo.setSiguiente(cima);
               cima=nuevo;
            }
        }
    }
    public void llenarMatriz(){
       int x,y;
       for (x = 0; x < 2; x++) {
         for(y=0;y<2;y++){
             mat[x][y]=Integer.parseInt(JOptionPane.showInputDialog(null,
                     "Digite un número:"));
         }  
       }
    }
    public void llenarVector(){
       int x;
        for (x = 0; x < 4; x++) {
            vec[x]=Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Digite un número:"));
        }
    }
    public void copiarPila(){
       if(!esVaciaP()){
          NodoP aux=cima;
          while(aux!=null){
             llenarListaDC(aux.getElemento().getNumero());
             aux=aux.getSiguiente();
          }
            JOptionPane.showMessageDialog(null,"La pila fue copiada!");
       }else{
            JOptionPane.showMessageDialog(null,"No se puede copiar, pila vacía!");
       }
    }
    public void copiarMatrizAListaDC(){
       int x,y;
       for(x=0;x<2;x++){
         for(y=0;y<2;y++){
             llenarListaDC(mat[x][y]);
         }
       }
        JOptionPane.showMessageDialog(null,"La matriz fue copiada!");
    }
    public void copiarVectorAListaDC(){
       int x;
       for(x=0;x<vec.length;x++){
           llenarListaDC(vec[x]);
       }
        JOptionPane.showMessageDialog(null,"El vector fue copiado!");
    }
    public void llenarListaDC(int numero){
      Dato d=new Dato();
      d.setNumero(numero);
      NodoDC nuevo=new NodoDC();
      nuevo.setElemento(d);
      if(esVaciaDC()){
         iniDC=nuevo;
         finDC=nuevo;
         finDC.setSiguiente(iniDC);
         iniDC.setAnterior(finDC);
      }else if(d.getNumero()<iniDC.getElemento().getNumero()){
         nuevo.setSiguiente(iniDC);
         iniDC=nuevo;
         finDC.setSiguiente(iniDC);
         iniDC.setAnterior(finDC);
      }else if(d.getNumero()>=finDC.getElemento().getNumero()){
         finDC.setSiguiente(nuevo);
         finDC=nuevo;
         finDC.setSiguiente(iniDC);
         iniDC.setAnterior(finDC);
      }else{
         NodoDC aux=iniDC;
         while(aux.getSiguiente().getElemento().getNumero()<d.getNumero()){
            aux=aux.getSiguiente();
         }
         nuevo.setSiguiente(aux.getSiguiente());
         nuevo.setAnterior(aux);
         aux.setSiguiente(nuevo);
         nuevo.getSiguiente().setAnterior(nuevo);
      }
   }
   public void mostrarListaDC(){
      if(!esVaciaDC()){
         String s=""; 
         NodoDC aux=iniDC;
         s=s+aux.getElemento().getNumero()+"<--";
         aux=aux.getSiguiente();
         while(aux!=iniDC){
            s=s+aux.getElemento().getNumero()+"<--";
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
