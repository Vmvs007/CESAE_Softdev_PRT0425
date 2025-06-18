package Ex_03;

import Ex_03.Enums.TamanhoPizza;
import Ex_03.Ingredientes.*;

import java.io.IOException;
import java.util.ArrayList;

public class Pizza {
    private int MAX_INGREDIENTES = 5;
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private TamanhoPizza tamanho;
    private ArrayList<IngredientePizza> listaIngredientesPizza;

    public Pizza(int id, String nome, String descricao, double preco, TamanhoPizza tamanho, Base base, double quantidadeBase, Topping primeiroTopping, double quantidadeTopping) throws IOException {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.listaIngredientesPizza = new ArrayList<IngredientePizza>();
        this.adicionarIngredientePizza(base, quantidadeBase);
        this.adicionarIngredientePizza(primeiroTopping, quantidadeTopping);
    }

    /**
     * Método que permite adicionar um novo <b>IngredientePizza</b> à <b>Pizza</b>
     *
     * @param ingredienteNovo <b>Ingrediente</b> que queremos adicionar
     * @param quantidade      Quantidade do novo <b>IngredientePizza</b>
     */
    public void adicionarIngredientePizza(Ingrediente ingredienteNovo, double quantidade) throws IOException {

        Logger loggerAdicionar = Logger.getInstance("logIngredientes.txt");

        loggerAdicionar.logarMensagem("O utilizador está a tentar acrescentar: " + ingredienteNovo.getNome() + " com " + quantidade + " quantidade.");

        // IngredienteNovo é uma base e a Pizza não tem nenhum ingrediente
        if (ingredienteNovo instanceof Base && this.listaIngredientesPizza.isEmpty()) {
            loggerAdicionar.logarMensagem("IngredienteNovo é uma base e a Pizza não tem nenhum ingrediente! Tudo certo!");
            IngredientePizza ipNovo = new IngredientePizza(ingredienteNovo, quantidade);
            this.listaIngredientesPizza.add(ipNovo);
            loggerAdicionar.logarMensagem("Começamos a pizza com uma boa base :D\n");
        }

        if (ingredienteNovo instanceof Topping && this.listaIngredientesPizza.size() > 0 && this.listaIngredientesPizza.size() < this.MAX_INGREDIENTES) {
            loggerAdicionar.logarMensagem("IngredienteNovo é um Topping e a Pizza já tem uma base! Tudo certo!");
            IngredientePizza ipNovo = new IngredientePizza(ingredienteNovo, quantidade);
            this.listaIngredientesPizza.add(ipNovo);
            loggerAdicionar.logarMensagem("Acrescentamos mais um ingrediente à pizza :D\n");
        }


    }

    public void removerIngredientePizza(int idRemover) throws IOException {

        Logger loggerRemocao = Logger.getInstance("loggerIng.txt");
        loggerRemocao.logarMensagem("\nO utilizador está a tentar remover o ingrediente com o id: " + idRemover);

        loggerRemocao.logarMensagem("Estamos a tentar encontrar o ingrediente com aquele id");
        for (IngredientePizza ingredientePizzaAtual : this.listaIngredientesPizza) {
            loggerRemocao.logarMensagem("Estou a analisar o ingrediente: " + ingredientePizzaAtual.getIngrediente().getNome() + " que tem o id: " + ingredientePizzaAtual.getIngrediente().getId());
            if (ingredientePizzaAtual.getIngrediente().getId() == idRemover && ingredientePizzaAtual.getIngrediente() instanceof Topping) {
                loggerRemocao.logarMensagem("Encontramos!! Está removido!");
                this.listaIngredientesPizza.remove(ingredientePizzaAtual);
                return;
            }
        }
    }

    public void editarQuantidadeIngredientePizza(Ingrediente ingredienteEditar, double quantidadeNova) {
        for (IngredientePizza ingredientePizzaAtual : this.listaIngredientesPizza) {
            if (ingredientePizzaAtual.getIngrediente().equals(ingredienteEditar)) {
                ingredientePizzaAtual.setQuantidade(quantidadeNova);
            }
        }
    }

    public double calcularKcalTotais() throws IOException {

        Logger loggerKcal = Logger.getInstance("LoggerIngredientes.txt");
        loggerKcal.logarMensagem("\nVamos calcular as calorias da pizza!");

        double kcalTotais = 0;

        for (IngredientePizza ingredientePizzaAtual : this.listaIngredientesPizza) {
            loggerKcal.logarMensagem("Vamos acrescentar: " + ingredientePizzaAtual.getIngrediente().getKcalPorMedida() * ingredientePizzaAtual.getQuantidade());
            kcalTotais += ingredientePizzaAtual.getIngrediente().getKcalPorMedida() * ingredientePizzaAtual.getQuantidade();
            loggerKcal.logarMensagem("Neste momento está a: " + kcalTotais);
        }


        loggerKcal.logarMensagem("Portanto, a pizza tem " + kcalTotais + " Kcal totais!");
        return kcalTotais;
    }

    public void tipoPizza() {
        int contadorCarnes = 0, contadorVegetais = 0, contadorQueijos = 0, contadorMarisco = 0;

        for (IngredientePizza ingredientePizzaAtual : this.listaIngredientesPizza) {

            if (ingredientePizzaAtual.getIngrediente() instanceof Carne) {
                contadorCarnes++;
            }

            if (ingredientePizzaAtual.getIngrediente() instanceof Vegetal) {
                contadorVegetais++;
            }

            if (ingredientePizzaAtual.getIngrediente() instanceof Queijo) {
                contadorQueijos++;
            }

            if (ingredientePizzaAtual.getIngrediente() instanceof FrutoMar) {
                contadorMarisco++;
            }

        }

        if (contadorCarnes > 0 && contadorVegetais == 0 && contadorQueijos == 0 && contadorMarisco == 0) {
            System.out.println("Pizza de Carne");
        } else if (contadorCarnes == 0 && contadorVegetais > 0 && contadorQueijos == 0 && contadorMarisco == 0) {
            System.out.println("Pizza Vegetariana");
        } else if (contadorCarnes == 0 && contadorVegetais == 0 && contadorQueijos > 0 && contadorMarisco == 0) {
            System.out.println("Pizza de Queijo");
        } else if (contadorCarnes == 0 && contadorVegetais == 0 && contadorQueijos == 0 && contadorMarisco > 0) {
            System.out.println("Pizza do Mar");
        } else if (contadorCarnes > 0 && contadorVegetais > 0 && contadorQueijos > 0 && contadorMarisco > 0) {
            System.out.println("Pizza Completa");
        } else {
            System.out.println("Pizza Mista");
        }
    }

    public void exibirDetalhes() throws IOException {
        System.out.println("\n***** " + this.nome + " *****");
        System.out.println("Código: " + this.id);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Preço: " + this.preco + " €");
        System.out.println("Tamanho: " + this.tamanho);
        System.out.println("Informação Nutricional: " + this.calcularKcalTotais() + " Kcal");

        int contadorIngredientesPizza = 1;

        for (IngredientePizza ingredientePizzaAtual : this.listaIngredientesPizza) {
            System.out.print("Ingrediente " + contadorIngredientesPizza++ + ": ");
            ingredientePizzaAtual.exibirDetalhes();

            // Este é o método abstrato de Ingrediente, só conseguimos invocar porque temos a certeza que ele existe em todos os Ingredientes (inclusive descendentes)
            ingredientePizzaAtual.getIngrediente().imprimirTipoIngrediente();
        }
    }


}
