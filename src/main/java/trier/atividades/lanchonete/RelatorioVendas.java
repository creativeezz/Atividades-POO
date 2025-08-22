package trier.atividades.lanchonete;

import java.util.ArrayList;

public class RelatorioVendas {
    private ArrayList<Produto> produtosVendidos = new ArrayList<>();

    public void registrarVenda(Produto produto, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            produtosVendidos.add(produto);
        }
    }

    public void exibirRelatorio() {
        double totalArrecadado = 0;
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();

        for (Produto produto : produtosVendidos) {
            totalArrecadado += produto.getPreco();
            String nome = produto.getNome();
            int idx = nomes.indexOf(nome);
            if (idx == -1) {
                nomes.add(nome);
                quantidades.add(1);
            } else {
                quantidades.set(idx, quantidades.get(idx) + 1);
            }
        }

        System.out.println("=== Relatório Diário de Vendas ===");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i) + ": " + quantidades.get(i) + " vendidos");
        }
        System.out.println("Total arrecadado: R$" + totalArrecadado);
    }
}