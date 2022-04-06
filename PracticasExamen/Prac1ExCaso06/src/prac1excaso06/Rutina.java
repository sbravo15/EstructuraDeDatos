package prac1excaso06;
import javax.swing.JOptionPane;
public class Rutina {
   public Rutina(NodoP cima){
      cima=null;
   }
   private char matriz[][]=new char[2][2];
   
  
   public boolean esVaciaP(NodoP cima){
      if(cima==null){
         return true;
      }else{
         return false;
      }
   }
   public NodoP apilar(int x,NodoP cima){
      if(x<4){
         Dato d=new Dato();
         d.setLetra(JOptionPane.showInputDialog(null,"Digite una letra:").charAt(0));
         NodoP nuevo=new NodoP();
         nuevo.setElemento(d);
         if(esVaciaP(cima)){
            cima=nuevo;
         }else{
            nuevo.setSiguiente(cima);
            cima=nuevo;
         }
         cima=apilar(x+1,cima);
      }
      return cima;
   }
   public void copiarPilaAMatriz(NodoP aux,int x,int y){
      if(aux!=null){
         matriz[x][y]=aux.getElemento().getLetra();
         JOptionPane.showMessageDialog(null,aux.getElemento().getLetra());
         y++;
         aux=aux.getSiguiente();
         if(y>1){
            x++;
            y=0;
         }
         copiarPilaAMatriz(aux,x,y);
      }
   }
   public String mostrarPila(NodoP aux,String s){
      while(aux!=null){
         s=s+aux.getElemento().getLetra()+"\n";
         aux=aux.getSiguiente();
      }
      return s;
   }
   public String mostrarMatriz(int x,int y,String s){
      if(x<2){
        if(y<2){
           s=s+matriz[x][y]+" ";
           y++;
        }
        if(y>1){
           x++;
           s=s+"\n";
           y=0;
        }   
        s=mostrarMatriz(x,y,s);
      }
      return s;
   }
}
