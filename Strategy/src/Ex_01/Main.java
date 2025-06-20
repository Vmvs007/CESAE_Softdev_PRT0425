package Ex_01;

public class Main {
    public static void main(String[] args) {

//        Ex_01.RangedAttackStrategy ras = new Ex_01.RangedAttackStrategy();
//        Ex_01.Hero quim = new Ex_01.Hero("Joaquim",100,20,ras);

        Hero quim = new Hero("Joaquim",100,20, new RangedAttackStrategy());

        quim.attack();
        quim.attack();

        quim.setFormaAtaque(new MagicAttackStrategy());

        quim.attack();

        quim.setFormaAtaque(new SilentAttackStrategy());

        quim.attack();
    }
}
