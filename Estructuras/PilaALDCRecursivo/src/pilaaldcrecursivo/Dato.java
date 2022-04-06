package pilaaldcrecursivo;

public class Dato {
   private byte id;
   private String nombre;
   
   public Dato(){
      this.id=0;
      this.nombre="";
   }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
}
