package FichaPratica01;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        double preco1, preco2, preco3, total, totalComDesconto;

        // Ler preços
        System.out.print("Insira preço do 1º produto: ");
        preco1 = input.nextDouble();

        System.out.print("Insira preço do 2º produto: ");
        preco2 = input.nextDouble();

        System.out.print("Insira preço do 3º produto: ");
        preco3 = input.nextDouble();

        // Calcular o total
        total = preco1 + preco2 + preco3;

        // Calcular o total com desconto
        totalComDesconto = total * 0.9;

        // Apresentar
        System.out.println("Preço com 10% de desconto: " + totalComDesconto);
    }
}
