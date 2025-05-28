package Ex_04;

public class Circulo {
    private String cor;
    private double raio;

    public Circulo(double raio) {
        this.cor="Branco";
        this.raio = raio;
    }

    public Circulo(String cor, double raio) {
        this.cor = cor;
        this.raio = raio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * this.raio;
    }

    public double calcularArea() {
        return Math.PI * this.raio * this.raio;
    }
}
