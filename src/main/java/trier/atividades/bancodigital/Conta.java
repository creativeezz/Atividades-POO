package trier.atividades.bancodigital;

public abstract class Conta {
    private double saldo;
    private Cliente titular;
    private boolean ativa;
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
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }
    public Extrato getExtrato() {
        return extrato;
    }
}