package trier.atividades.bancodigital;

import java.time.LocalDateTime;

public abstract class Conta {
    private double saldo;
    private Cliente titular;
    private boolean ativa;
    private LocalDateTime dataNegativo;
    private LocalDateTime dataCriacao;
    private Extrato extrato = new Extrato();

    public Conta(Cliente titular, double saldo, boolean ativa) {
        this.titular = titular;
        this.saldo = saldo;
        this.ativa = ativa;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Cliente getCliente() {
        return titular;
    }
    public void setCliente(Cliente cliente) {
        this.titular = cliente;
    }
    public boolean taAtiva() {
        return ativa;
    }
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso! Novo saldo: " + saldo);
            extrato.adicionarMovimentacao("Depósito: " + valor + " | Saldo: " + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso! Novo saldo: " + saldo);
            extrato.adicionarMovimentacao("Saque: " + valor + " | Saldo: " + saldo);
            atualizarData();
            verificarDataNegativo();

        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }
    public void transferir(double valor, Conta contaDestino) {
        if (valor > 0 && valor <= saldo) {
            sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência de " + valor + " realizada com sucesso para " + contaDestino.getCliente().getNome());
            extrato.adicionarMovimentacao("Transferência: " + valor + " para " + contaDestino.getCliente().getNome());
            atualizarData();
            verificarDataNegativo();
        } else {
            System.out.println("Valor de transferência inválido ou saldo insuficiente.");
        }
    }
    public Extrato getExtrato() {
        return extrato;
    }
    public void atualizarData() {
        if (saldo < 0 && dataNegativo == null) {
            dataNegativo = LocalDateTime.now();
        } else {
            dataNegativo = null;
        }
    }
    public void verificarDataNegativo() {
        if (saldo < 0 && dataNegativo != null) {
            int dias = (int) java.time.Duration.between(dataNegativo, LocalDateTime.now()).toDays();

            if (dias > 30) {
                ativa = false;
            }
        } else {
            ativa = true;
        }
    }
}