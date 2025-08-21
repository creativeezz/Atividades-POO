package trier.atividades.bancodigital;

public class ContaCorrente extends Conta{
    private double limiteCredito;

    public ContaCorrente(Cliente titular, double saldo, boolean ativa, double limiteCredito){
        super(titular, saldo, ativa);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso! Novo saldo: " + getSaldo());
            getExtrato().adicionarMovimentacao("Saque: " + valor + " | Saldo: " + getSaldo());
        } else if (valor > 0 && valor <= (getSaldo() + limiteCredito)) {
            double valorUsadoCredito = valor - getSaldo();
            setSaldo(0);
            limiteCredito -= valorUsadoCredito;
            System.out.println("Saque realizado utilizando crédito! Novo saldo: " + getSaldo());
            getExtrato().adicionarMovimentacao("Saque: " + valor);
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }
}
