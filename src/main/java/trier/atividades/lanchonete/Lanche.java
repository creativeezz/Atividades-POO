package trier.atividades.lanchonete;

import java.util.ArrayList;
import java.util.List;

public class Lanche extends Produto{
    private String pao;
    private String carne;
    private String queijo;
    private boolean salada;
    private int estoque;

    public Lanche(String nome, double preco) {
        super(nome, preco);
    }
}
