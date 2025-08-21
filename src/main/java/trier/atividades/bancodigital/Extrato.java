package trier.atividades.bancodigital;

import java.util.ArrayList;

public class Extrato {
    private ArrayList<String> movimentacoes = new ArrayList<String>();

    public void adicionarMovimentacao(String movimentacao) {
        movimentacoes.add(movimentacao);
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato ===");
        if (movimentacoes.isEmpty()) {
            System.out.println("Nenhuma movimentação registrada.");
        } else {
            for (String movimentacao : movimentacoes) {
                System.out.println(movimentacao);
            }
        }
    }
}
