package trier.atividades.bancodigital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContaCorrente extends Conta{
    private double limiteCredito;

    public ContaCorrente(Cliente titular, double saldo, boolean ativa, double limiteCredito){
        super(titular, saldo, ativa);
        this.limiteCredito = limiteCredito;
    }
    public double getLimiteCredito() {
        return  limiteCredito;
    }
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() > -200) {
            if (valor > 0 && valor <= getSaldo()) {
                setSaldo(getSaldo() - valor);
                System.out.println("Saque realizado com sucesso! Novo saldo: R$ " + getSaldo());
                getExtrato().adicionarMovimentacao("Saque: R$ " + valor + " | Saldo: " + getSaldo());
                String dataFormatada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                getExtrato().adicionarMovimentacao("Data do saque: " + dataFormatada);
                atualizarData();
                verificarDataNegativo();
            } else if (valor > 0 && valor <= (getSaldo() + limiteCredito)) {
                setSaldo(getSaldo() - valor);
                System.out.println("Saque realizado utilizando crédito! Novo saldo: R$ " + getSaldo());
                getExtrato().adicionarMovimentacao("Saque: R$ " + valor);
                String dataFormatada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                getExtrato().adicionarMovimentacao("Data do saque: " + dataFormatada);
                atualizarData();
                verificarDataNegativo();
            } else {
                System.out.println("Valor de saque inválido ou saldo insuficiente.");
            }
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }
    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (getSaldo() > -200) {
            if (valor > 0 && valor <= getSaldo()) {
                sacar(valor);
                contaDestino.depositar(valor);
                System.out.println("Transferência de R$ " + valor + " realizada com sucesso para " + contaDestino.getCliente().getNome());
                getExtrato().adicionarMovimentacao("Transferência: R$ " + valor + " para " + contaDestino.getCliente().getNome());
                String dataFormatada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                getExtrato().adicionarMovimentacao("Data da transferência: " + dataFormatada);
                atualizarData();
                verificarDataNegativo();

            } else if (valor > 0 && valor <= (getSaldo() + limiteCredito)) {
                double valorUsadoCredito = valor - getSaldo();
                setSaldo(0);
                limiteCredito -= valorUsadoCredito;
                contaDestino.depositar(valor);
                System.out.println("Transferência de R$ " + valor + " realizada utilizando crédito para " + contaDestino.getCliente().getNome());
                getExtrato().adicionarMovimentacao("Transferência: R$ " + valor + " para " + contaDestino.getCliente().getNome());
                String dataFormatada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                getExtrato().adicionarMovimentacao("Data da transferência: R$ " + dataFormatada);
                atualizarData();
                verificarDataNegativo();
            } else {
                System.out.println("Valor de transferência inválido ou saldo insuficiente.");
            }
        } else {
            System.out.println("Valor de transferência inválido ou saldo insuficiente.");
        }
    }
}
