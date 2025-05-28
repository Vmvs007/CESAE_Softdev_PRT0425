package Ex_07;

public class Main {
    public static void main(String[] args) {

        Aluno aluno1= new Aluno("Vitor",25,"vitor@mail.pt","Informática",15);
        Aluno aluno2= new Aluno("Joaquim",30,"quim@mail.pt","Design",14);

        if(aluno1.situacaoAprovacao() && aluno2.situacaoAprovacao()){
            System.out.println("Ambos aprovados");
        }
    }
}
