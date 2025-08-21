package trier.atividades.bancodigital;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente, double saldo, boolean ativa) {
        super(cliente, saldo, ativa);
    }
    public void aplicarRendimento(double taxa) {
        taxa = 0.05;
    }
}
