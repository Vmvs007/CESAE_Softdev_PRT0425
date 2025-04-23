package FichaPratica02;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        double salario, taxa = 0;

        // Ler salario
        System.out.print("Insira o salário anual: ");
        salario = input.nextDouble();

        if (salario <= 15000) { // Taxa de 20%
            taxa = salario * 0.2;
            System.out.println("Paga taxa de 20%: " + taxa);

        } else { // Taxa de 30%
            taxa = salario * 0.3;
            System.out.println("Paga taxa de 30%: " + taxa);
        }
    }
}
