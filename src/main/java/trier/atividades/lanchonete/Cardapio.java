package trier.atividades.lanchonete;

import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Lanche> lanches = new ArrayList<>();
    private ArrayList<Bebida> bebidas = new ArrayList<>();
    private ArrayList<Sobremesa> sobremesas = new ArrayList<>();
    private Lanche lanche;
    private Bebida bebida;
    private Sobremesa sobremesa;

    public void adicionarLanche(String nome, double preco, int estoque) {
        lanche = new Lanche(nome, preco);
        lanche.setEstoque(estoque);
        lanches.add(lanche);
    }

    public void adicionarBebida(String nome, double preco, int estoque) {
        bebida = new Bebida(nome, preco);
        bebida.setEstoque(estoque);
        bebidas.add(bebida);
    }
    public void adicionarSobremesa(String nome, double preco, int estoque) {
        sobremesa = new Sobremesa(nome, preco);
        sobremesa.setEstoque(estoque);
        sobremesas.add(sobremesa);
    }

    public void listarLanches() {
        System.out.println("======== Lanches ========");
        for (Lanche lanche : lanches) {
            System.out.println(lanche.getNome() + " - R$" + lanche.getPreco());
        }
    }
    public void listarBebidas() {
        System.out.println("======== Bebidas ========");
        for (Bebida bebida : bebidas) {
            System.out.println(bebida.getNome() + " - R$" + bebida.getPreco());
        }
    }
    public void listarSobremesas() {
        System.out.println("======== Sobremesas ========");
        for (Sobremesa sobremesa : sobremesas) {
            System.out.println(sobremesa.getNome() + " - R$" + sobremesa.getPreco());
        }
    }
}
