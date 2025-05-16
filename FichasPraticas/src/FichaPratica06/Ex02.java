package FichaPratica06;

import java.util.Scanner;

public class Ex02 {

    public static int lerInteiroPositivo() {
        Scanner input = new Scanner(System.in);

        int numeroUtilizador;

        do {
            System.out.print("Introduza um número positivo: ");
            numeroUtilizador = input.nextInt();
        } while (numeroUtilizador < 0);

        return numeroUtilizador;
    }

    public static void imprimirAsteriscos(int quantidade) {

        for (int i = 0; i < quantidade; i++) {
            System.out.print("*");
        }

    }

    public static void main(String[] args) {

        int numero = lerInteiroPositivo();
        imprimirAsteriscos(numero);
    }
}
