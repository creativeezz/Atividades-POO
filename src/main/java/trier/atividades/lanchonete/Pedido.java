package trier.atividades.lanchonete;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    List<Produto> itens = new ArrayList<>();
    private boolean taxaServico;

    public Pedido(Cliente cliente, boolean taxaServico) {
        this.cliente = cliente;
        this.taxaServico = taxaServico;
    }
    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.getEstoque() >= quantidade) {
            for(int i = 0; i < quantidade; i++) {
                itens.add(produto);
            }
            produto.reduzirEstoque(quantidade);
        }
    }
}
