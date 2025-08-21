package trier.atividades.bancodigital;

public class ContaCorrente extends Conta{
    private double limiteCredito;

    public ContaCorrente(Cliente titular, double saldo, boolean ativa, double limiteCredito){
        super(titular, saldo, ativa);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= (getSaldo() + limiteCredito)) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso! Novo saldo: " + getSaldo());
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }
}
