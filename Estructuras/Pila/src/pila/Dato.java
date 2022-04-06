package pila;

public class Dato {

    private int codLibro;
    private String titulo;
    private String autor;

    public Dato() {
        this.codLibro = 0;
        this.titulo = "";
        this.autor = "";
    }

    public int getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(int codLibro) {
        this.codLibro = codLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
