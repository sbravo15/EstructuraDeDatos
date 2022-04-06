package listadoblecircular;

public class Prenda {

    private int codigoPrenda;
    private String descripcion;
    private int cantidad;
    private double precio;

    public Prenda() {
        this.codigoPrenda = 0;
        this.descripcion = "";
        this.cantidad = 0;
        this.precio = 0.00;
    }

    public int getCodigoPrenda() {
        return codigoPrenda;
    }

    public void setCodigoPrenda(int codigoPrenda) {
        this.codigoPrenda = codigoPrenda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
