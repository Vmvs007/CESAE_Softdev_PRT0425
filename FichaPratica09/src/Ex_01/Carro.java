package Ex_01;

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private int anoFabrico;
    private int potenciaCv;
    private int cc;
    private TipoCombustivel combustivel;
    private double consumoL100Km;

    public Carro(String marca, String modelo, String cor, int anoFabrico, int potenciaCv, int cc, TipoCombustivel combustivel, double consumoL100Km) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.potenciaCv = potenciaCv;
        this.cc = cc;
        this.combustivel = combustivel;
        this.consumoL100Km = consumoL100Km;
    }

    public void ligar() {
        System.out.println("O " + this.marca + " " + this.cor + " está ligado...");
    }
}
