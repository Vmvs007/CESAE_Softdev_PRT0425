package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex03 {

    public static void copiarFicheiro(String caminhoOrigem, String caminhoDestino) throws FileNotFoundException {

        File ficheiroOrigem = new File(caminhoOrigem);
        Scanner sc = new Scanner(ficheiroOrigem);

        // Scanner sc = new Scanner(new File(caminhoOrigem));

        File ficheiroDestino = new File(caminhoDestino);
        PrintWriter pw = new PrintWriter(ficheiroDestino);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            pw.println(linha);
        }

        pw.close();
    }

    public static void main(String[] args) throws FileNotFoundException {

        copiarFicheiro("Ficheiros/exercicio_03_Alternativa01.txt","Ficheiros/exercicio_03_copia.txt");

    }
}
