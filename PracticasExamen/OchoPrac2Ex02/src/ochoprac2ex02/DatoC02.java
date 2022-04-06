package ochoprac2ex02;

public class DatoC02 {

    private char letra;
    private int num;
    private String palabra;

    public DatoC02() {
        this.letra = '\0';
        this.num = 0;
        this.palabra = "";
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

}
