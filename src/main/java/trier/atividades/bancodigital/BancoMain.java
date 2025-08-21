package trier.atividades.bancodigital;

import java.util.ArrayList;
import java.util.Scanner;

public class BancoMain {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Conta> contas = new ArrayList<Conta>();

        //teste inicial
        Cliente testeDaSilva = new Cliente("testeDaSilva", "123");
        clientes.add(testeDaSilva);
        Cliente ana = new  Cliente("Ana", "12");
        clientes.add(ana);

        ContaCorrente ccAna = new ContaCorrente(ana, 1000.0, true, 500.0);
        contas.add(ccAna);
        ContaPoupanca cpTeste = new ContaPoupanca(testeDaSilva, 500.0, true);
        contas.add(cpTeste);

        do {
            System.out.println("==========================");
            System.out.println("1 - Abrir conta");
            System.out.println("2 - Ver conta");
            System.out.println("3 - Sair");
            System.out.println("==========================");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("=== Abrir Conta ===");
                    System.out.print("Digite o nome do cliente: ");
                    String nome = entrada.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = entrada.nextLine();

                    Cliente novoCliente = new Cliente(nome, cpf);
                    clientes.add(novoCliente);

                    System.out.println("=== Tipo de conta ===");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupança");
                    System.out.print("Escolha o tipo de conta: ");
                    int tipoConta = entrada.nextInt();
                    entrada.nextLine();

                    if (tipoConta == 1) {
                        ContaCorrente novaConta = new ContaCorrente(novoCliente, 0.0, true, 200.0);
                        contas.add(novaConta);
                        System.out.println("Conta Corrente criada com sucesso para " + novoCliente.getNome());
                    } else {
                        ContaPoupanca novaConta = new ContaPoupanca(novoCliente, 0.0, true);
                        contas.add(novaConta);
                        System.out.println("Conta Poupança criada com sucesso para " + novoCliente.getNome());
                    }
                    break;
                case 2:
                    System.out.println("=== Ver Conta ===");
                    System.out.println("Digite o CPF do cliente para ver a conta: ");
                    String cpfConsulta = entrada.nextLine();

                    boolean encontrado = false;

                    Conta contaEncontrada  = null;
                    for (Conta conta : contas) {
                        if (conta.getCliente().getCpf().equals(cpfConsulta)) {
                            contaEncontrada = conta;
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado == true) {
                        System.out.println("Bem-vindo de volta, " + contaEncontrada.getCliente().getNome() + "!");
                        System.out.println("Saldo: R$" + contaEncontrada.getSaldo());
                        System.out.println("Status da conta: " + (contaEncontrada.taAtiva() ? "Ativa" : "Inativa"));

                        int acaoConta = 0;

                        do {
                            System.out.println("=== Ações da Conta ===");
                            System.out.println("1 - Depositar");
                            System.out.println("2 - Sacar");
                            System.out.println("3 - Transferir");
                            System.out.println("4 - Ver Extrato");
                            System.out.println("5 - Voltar");
                            System.out.print("Escolha uma opção: ");
                            acaoConta = entrada.nextInt();
                            entrada.nextLine();

                            switch (acaoConta) {
                                case 1:
                                    System.out.print("Digite o valor do depósito: ");
                                    double valorDeposito = entrada.nextDouble();
                                    contaEncontrada.depositar(valorDeposito);
                                    break;
                                case 2:
                                    System.out.print("Digite o valor do saque: ");
                                    double valorSaque = entrada.nextDouble();
                                    contaEncontrada.sacar(valorSaque);
                                    break;
                                case 3:
                                    System.out.println("Digite o CPF do destinatário: ");
                                    String cpfDestino = entrada.nextLine();

                                    Conta contaDestino = null;
                                    boolean contaDestinoEncontrada = false;
                                    for (Conta conta : contas) {
                                        if (conta.getCliente().getCpf().equals(cpfDestino)) {
                                            contaDestino = conta;
                                            contaDestinoEncontrada = true;
                                            break;
                                        }
                                    }
                                    if (contaDestinoEncontrada) {
                                        System.out.print("Digite o valor da transferência: ");
                                        double valorTransferencia = entrada.nextDouble();
                                        contaEncontrada.transferir(valorTransferencia, contaDestino);
                                    } else {
                                        System.out.println("Conta do destinatário não encontrada!");
                                    }
                                    break;
                                case 4:
                                    contaEncontrada.getExtrato().imprimirExtrato();
                                    break;
                                case 5:
                                    System.out.println("Voltando ao menu principal...");
                                    break;
                                default:
                                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                            }
                        } while (acaoConta != 5);
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (opcao != 3);
    }
}
