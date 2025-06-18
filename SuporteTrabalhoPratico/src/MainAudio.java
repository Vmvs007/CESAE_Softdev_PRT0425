import static java.lang.Thread.sleep;

public class MainAudio {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("O programa começou...");

        sleep(2000);

        Audio.playMusic("AudioFiles/super_mario_theme.wav");

        System.out.println("A musica é engraçada");
        sleep(1000);
        System.out.println("A musica continua...");

        Audio.playMusic("AudioFiles/sonic_ring_effect.wav");

        sleep(10000);

        System.out.println("Obrigado");
    }
}