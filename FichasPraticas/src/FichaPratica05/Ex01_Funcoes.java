package FichaPratica05;

import java.util.Scanner;

import static Bibliotecas.Arrays.imprimirVetorInteiros;
import static Bibliotecas.Arrays.lerVetorInteiros;

public class Ex01_Funcoes {
    public static void main(String[] args) {

        int[] vetor = lerVetorInteiros(10);

        System.out.println("_____________________________________");

        imprimirVetorInteiros(vetor);
    }
}
