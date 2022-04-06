package unoprac2exed;

import javax.swing.JOptionPane;

public class Rutina {
   private NodoSC iniSC;
   private NodoSC finSC;
   private NodoC iniC;
   private NodoC finC;
   private NodoDC iniDC;
   private NodoDC finDC;
   
   public Rutina(){
      this.iniSC=null;
      this.finSC=null;
      this.iniC=null;
      this.finC=null;
      this.iniDC=null;
      this.finDC=null;
   }
   public boolean esVaciaSC(){
      if(iniSC==null){
         return true;
      }else{
         return false;
      }
   }
   public boolean esVaciaC(){
      if(iniC==null){
         return true;
      }else{
         return false;
      }
   }
   public boolean esVaciaDC(){
      if(iniDC==null){
         return true;
      }else{
         return false;
      }
   }
   public void llenarListaSC(){
      int x;
      for(x=1;x<=30;x++){
         Dato d=new Dato();
         d.setNum(x);
         NodoSC nuevo=new NodoSC();
         nuevo.setElemento(d);
         if(esVaciaSC()){
            iniSC=nuevo;
            finSC=nuevo;
            finSC.setSiguiente(iniSC);
         }else if(d.getNum()<iniSC.getElemento().getNum()){
            nuevo.setSiguiente(iniSC);
            iniSC=nuevo;
            finSC.setSiguiente(iniSC);
         }else if(d.getNum()>=finSC.getElemento().getNum()){
            finSC.setSiguiente(nuevo);
            finSC=nuevo;
            finSC.setSiguiente(iniSC);
         }else{
            NodoSC aux=iniSC;
            while(aux.getSiguiente().getElemento().getNum()<
                    d.getNum()){
               aux=aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            finSC.setSiguiente(iniSC);
         }
      }  
   }
   public void copiarLSCACola(){
      if(!esVaciaSC()){
         NodoSC aux=iniSC;
         llenarCola(aux.getElemento().getNum());
         aux=aux.getSiguiente();
         while(aux!=iniSC){
            llenarCola(aux.getElemento().getNum());
            aux=aux.getSiguiente();
         }
      }
      JOptionPane.showMessageDialog(null,
              "La lista simple circular fue copiada a la cola!");
   }
   public void llenarCola(int num){
      Dato d=new Dato();
      d.setNum(num);
      NodoC nuevo=new NodoC();
      nuevo.setElemento(d);
      if(esVaciaC()){
         iniC=nuevo;
         finC=nuevo;
      }else{
         finC.setSiguiente(nuevo);
         finC=nuevo;
      }
   }
   public void copiarColaAListaDC(){
      if(!esVaciaC()){
         NodoC aux=iniC;
         while(aux!=null){
            llenarListaDC(aux.getElemento().getNum());
            aux=aux.getSiguiente();
         }
      }
      JOptionPane.showMessageDialog(null,
              "La cola fue copiada a lista doble circular!");
   }
   public void llenarListaDC(int num){
      Dato d=new Dato();
      d.setNum(num);
      NodoDC nuevo=new NodoDC();
      nuevo.setElemento(d);
      if(esVaciaDC()){
         iniDC=nuevo;
         finDC=nuevo;
         finDC.setSiguiente(iniDC);
         iniDC.setAnterior(finDC);
      }else if(d.getNum()<iniDC.getElemento().getNum()){
         nuevo.setSiguiente(iniDC);
         iniDC=nuevo;
         finDC.setSiguiente(iniDC);
         iniDC.setAnterior(finDC);
      }else if(d.getNum()>=finDC.getElemento().getNum()){
         finDC.setSiguiente(nuevo);
         finDC=nuevo;
         finDC.setSiguiente(iniDC);
         iniDC.setAnterior(finDC);
      }else{
         NodoDC aux=iniDC;
         while(aux.getSiguiente().getElemento().getNum()<
                 d.getNum()){
            aux=aux.getSiguiente();
         }
         nuevo.setSiguiente(aux.getSiguiente());
         nuevo.setAnterior(aux);
         aux.setSiguiente(nuevo);
         aux.getSiguiente().setAnterior(nuevo);
      }
   }
   public void mostrarListaDC(){
      int suma=0,cant=0,prom=0;
      String s="";
      if(!esVaciaDC()){
         NodoDC aux=iniDC;
         suma=suma+aux.getElemento().getNum();
         cant=cant+1;
         s=s+aux.getElemento().getNum()+"--";
         aux=aux.getSiguiente();
         while(aux!=iniDC){
            suma=suma+aux.getElemento().getNum();
            cant=cant+1;
            s=s+aux.getElemento().getNum()+"--";
            aux=aux.getSiguiente();
         }
         prom=suma/cant;
         JOptionPane.showMessageDialog(null,
            "La lista doble circular contiene:\n"+s+
            "\n\nEl promedio de los valores almacenados es:"+prom);
      }
   }
   public void determinarPrimerParCola(){
      int primerPar=0;
      if(!esVaciaC()){
         NodoC aux=iniC;
         while(aux!=null){
            if((aux.getElemento().getNum()%2==0)&&(primerPar==0)){
                primerPar=aux.getElemento().getNum();
            }
            aux=aux.getSiguiente();
         }
      }
      JOptionPane.showMessageDialog(null,
              "El primer par almacenado en la cola es:"+primerPar);
   }
}
