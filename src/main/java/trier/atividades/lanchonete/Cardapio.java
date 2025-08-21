package trier.atividades.lanchonete;

import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Lanche> lanches = new ArrayList<>();
    private ArrayList<Bebida> bebidas = new ArrayList<>();
    public ArrayList<Sobremesa> sobremesas = new ArrayList<>();
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
        int contador = 0;
        System.out.println("======== Lanches ========");
        for (Lanche lanche : lanches) {
            contador++;
            System.out.println(contador + " - " + lanche.getNome() + " - R$" + lanche.getPreco());
        }
    }
    public void listarBebidas() {
        int contador = 0;
        System.out.println("======== Bebidas ========");
        for (Bebida bebida : bebidas) {
            contador++;
            System.out.println(contador + " - " + bebida.getNome() + " - R$" + bebida.getPreco());
        }
    }
    public void listarSobremesas() {
        int contador = 0;
        System.out.println("======== Sobremesas ========");
        for (Sobremesa sobremesa : sobremesas) {
            contador++;
            System.out.println(contador + " - " + sobremesa.getNome() + " - R$" + sobremesa.getPreco());
        }
    }
    public Sobremesa getSobremesaIndice(int indice) {
        if (indice >= 0 && indice < sobremesas.size()) {
            return sobremesas.get(indice);
        } else {
            return null;
        }
    }
    public Lanche getLancheIndice(int indice) {
        if (indice >= 0 && indice < lanches.size()) {
            return lanches.get(indice);
        } else {
            return null;
        }
    }
    public Bebida getBebidaIndice(int indice) {
        if (indice >= 0 && indice < bebidas.size()) {
            return bebidas.get(indice);
        } else {
            return null;
        }
    }
    public void inicializarCardapioPadrao() {
        adicionarLanche("X-Burguer", 15.0, 10);
        adicionarLanche("X-Salada", 18.0, 40);
        adicionarLanche("X-Bacon", 20.0, 30);
        adicionarLanche("X-Tudo", 25.0, 20);

        adicionarBebida("Refrigerante", 5.0, 100);
        adicionarBebida("Suco", 6.0, 80);
        adicionarBebida("Água", 3.0, 150);
        adicionarBebida("Cerveja", 8.0, 60);

        adicionarSobremesa("Sorvete", 7.0, 70);
        adicionarSobremesa("Bolo", 6.0, 50);
        adicionarSobremesa("Pudim", 5.0, 40);
        adicionarSobremesa("Torta", 8.0, 30);
    }
}
