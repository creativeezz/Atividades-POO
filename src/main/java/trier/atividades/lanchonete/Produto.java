package trier.atividades.lanchonete;

public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public int getEstoque() {
        return estoque;
    }
    public void reduzirEstoque(int quantidade){
        this.estoque -= quantidade;
    }
}
