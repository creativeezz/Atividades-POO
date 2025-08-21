package trier.atividades.lanchonete;

import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Lanche> lanches = new ArrayList<>();
    private ArrayList<Bebida> bebidas = new ArrayList<>();
    private ArrayList<Sobremesa> sobremesas = new ArrayList<>();
    private Lanche lanche;
    private Bebida bebida;

    public void adicionarLanche(Lanche lanche) {

    }

    public void adicionarBebida(Bebida bebida) {
        bebida = new Bebida("Refrigerante", 5.0);
        bebida.setEstoque(50);
        bebidas.add(bebida);
    }
    public void adicionarSobremesa(Sobremesa sobremesa) {
        Sobremesa sorvete = new Sobremesa("Sorvete", 7.0);
        sorvete.setEstoque(30);
        sobremesas.add(sorvete);
    }

    public void listarLanches() {
        System.out.println("======== Lanches ========");
        for (Lanche lanche : lanches) {
            System.out.println(lanche.getNome() + " - R$" + lanche.getPreco());
        }
    }
    public void listarBebidas() {
        System.out.println("======== Bebidas ========");
        for (Bebida bebidass : bebidas) {
            System.out.println(bebidass.getNome() + " - R$" + bebidass.getPreco());
        }
    }
    public void listarSobremesas() {
        System.out.println("======== Sobremesas ========");
        for (Sobremesa sobremesa : sobremesas) {
            System.out.println(sobremesa.getNome() + " - R$" + sobremesa.getPreco());
        }
    }
}
