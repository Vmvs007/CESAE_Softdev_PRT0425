package Ex_03;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static Logger instance;

    private String caminhoFicheiro;

    private Logger(String caminhoFicheiro) {
        this.caminhoFicheiro = caminhoFicheiro;
    }

    public static Logger getInstance(String caminhoFicheiro) {
        if (instance == null) {
            instance = new Logger(caminhoFicheiro);
        }

        return instance;
    }

    public void logarMensagem(String mensagem) throws IOException {
        FileWriter fw = new FileWriter(this.caminhoFicheiro, true);
        fw.append(mensagem + "\n");
        fw.close();
    }
}
