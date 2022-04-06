package pilaaldcrecursivo;
public class Main {
    public static void main(String[] args) {
       NodoP cima=null; 
       Rutina r=new Rutina();
       cima=r.apilar();
       NodoP aux=cima;
       r.copiar(aux);
       r.mostrarPila();
       r.mostrarLDC();
    }    
}
