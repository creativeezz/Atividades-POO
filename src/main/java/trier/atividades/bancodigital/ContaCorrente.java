package trier.atividades.bancodigital;

import java.time.LocalDateTime;

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
            atualizarData();
            verificarDataNegativo();
        } else if (valor > 0 && valor <= (getSaldo() + limiteCredito)) {
            double valorUsadoCredito = valor - getSaldo();
            setSaldo(0);
            limiteCredito -= valorUsadoCredito;
            System.out.println("Saque realizado utilizando crédito! Novo saldo: " + getSaldo());
            getExtrato().adicionarMovimentacao("Saque: " + valor);
            atualizarData();
            verificarDataNegativo();
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }
    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor > 0 && valor <= getSaldo()) {
            sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência de " + valor + " realizada com sucesso para " + contaDestino.getCliente().getNome());
            getExtrato().adicionarMovimentacao("Transferência: " + valor + " para " + contaDestino.getCliente().getNome());
            atualizarData();
            verificarDataNegativo();
        } else if (valor > 0 && valor <= (getSaldo() + limiteCredito)) {
            double valorUsadoCredito = valor - getSaldo();
            setSaldo(0);
            limiteCredito -= valorUsadoCredito;
            contaDestino.depositar(valor);
            System.out.println("Transferência de " + valor + " realizada utilizando crédito para " + contaDestino.getCliente().getNome());
            getExtrato().adicionarMovimentacao("Transferência: " + valor + " para " + contaDestino.getCliente().getNome());
            atualizarData();
            verificarDataNegativo();
        } else {
            System.out.println("Valor de transferência inválido ou saldo insuficiente.");
        }
    }
}
