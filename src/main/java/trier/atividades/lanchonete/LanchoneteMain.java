package trier.atividades.lanchonete;

import java.util.ArrayList;
import java.util.Scanner;

public class LanchoneteMain {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        int escolhaCardapio = 0;

        Cardapio cardapio = new Cardapio();
        cardapio.inicializarCardapioPadrao();

        RelatorioVendas relatorioVendas = new RelatorioVendas();
        ArrayList<Produto> lista = new ArrayList<>();

        do {
            System.out.println("======== Lanchonete Digital ========");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Ver cardápio");
            System.out.println("3. Ver carrinho");
            System.out.println("4. Relatório de Vendas");
            System.out.println("5. Sair");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    String nome = entrada.nextLine();
                    System.out.println("Digite o telefone do cliente: ");
                    String telefone = entrada.nextLine();
                    System.out.println("Digite o endereço do cliente: ");
                    String endereco = entrada.nextLine();

                    Cliente novoCliente = new Cliente(nome, telefone, endereco);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:

                    do {
                        System.out.println("======== Cardápio ========");
                        System.out.println("1. Lanches");
                        System.out.println("2. Bebidas");
                        System.out.println("3. Sobremesas");
                        System.out.println("4. Voltar ao menu principal");
                        System.out.println("Escolha uma opção:");
                        escolhaCardapio = entrada.nextInt();
                        entrada.nextLine();

                        switch (escolhaCardapio) {
                            case 1:
                                cardapio.listarLanches();
                                System.out.println("Digite a opção: ");
                                int escolhaLanche = entrada.nextInt();

                                System.out.println("Digite a quantidade: ");
                                int quantidade = entrada.nextInt();
                                entrada.nextLine();

                                Lanche lancheEscolhido = cardapio.getLancheIndice(escolhaLanche - 1);

                                if (lancheEscolhido != null && lancheEscolhido.getEstoque() >= quantidade) {
                                    lancheEscolhido.reduzirEstoque(quantidade);
                                    for (int i = 0; i < quantidade; i++) {
                                        lista.add(lancheEscolhido);
                                    }
                                } else {
                                    System.err.println("Estoque insuficiente para o lanche escolhido.");
                                }

                                break;
                            case 2:
                                cardapio.listarBebidas();
                                System.out.println("Digite a opção: ");
                                int escolhaBebida = entrada.nextInt();

                                System.out.println("Digite a quantidade: ");
                                quantidade = entrada.nextInt();
                                entrada.nextLine();

                                Bebida bebidaEscolhida = cardapio.getBebidaIndice(escolhaBebida - 1);
                                if (bebidaEscolhida != null && bebidaEscolhida.getEstoque() >= quantidade) {
                                    bebidaEscolhida.reduzirEstoque(quantidade);
                                    for (int i = 0; i < quantidade; i++) {
                                        lista.add(bebidaEscolhida);
                                    }
                                } else {
                                    System.err.println("Estoque insuficiente para a bebida escolhida.");
                                }

                                break;
                            case 3:
                                cardapio.listarSobremesas();
                                System.out.println("Digite a opção: ");
                                int escolhaSobremesa = entrada.nextInt();

                                System.out.println("Digite a quantidade: ");
                                quantidade = entrada.nextInt();
                                entrada.nextLine();

                                Sobremesa sobremesaEscolhida = cardapio.getSobremesaIndice(escolhaSobremesa - 1);
                                if (sobremesaEscolhida != null && sobremesaEscolhida.getEstoque() >= quantidade) {
                                    sobremesaEscolhida.reduzirEstoque(quantidade);
                                    for (int i = 0; i < quantidade; i++) {
                                        lista.add(sobremesaEscolhida);
                                    }
                                } else {
                                    System.err.println("Estoque insuficiente para a sobremesa escolhida.");
                                }
                                break;
                            case 4:
                                System.out.println("Voltando ao menu principal...");
                                break;
                        }
                    } while (escolhaCardapio != 4);
                    break;

                case 3:
                    double total = 0;
                    System.out.println("======== Carrinho ========");
                    if (lista.isEmpty()) {
                        System.err.println("Seu carrinho está vazio.");
                    } else {
                        for (Produto produto : lista) {
                            System.out.println(produto.getNome() + " - R$" + produto.getPreco());
                        }
                        for (Produto pegarPreco : lista) {
                            total += pegarPreco.getPreco();
                        }
                        System.out.println("Total: R$" + total);
                        System.out.println("Deseja adicionar taxa de serviço? (1 - Sim, 2 - Não)");
                        int taxaServico = entrada.nextInt();
                        entrada.nextLine();

                        if(taxaServico == 1) {
                            total += total * 0.10;
                            System.out.println("Taxa de serviço adicionada. Total com taxa: R$" + total);
                        } else if (taxaServico == 2) {
                            System.out.println("Taxa de serviço não adicionada. Total: R$" + total);
                        } else {
                            System.err.println("Opção inválida! Por favor, escolha uma opção válida.");
                        }

                        System.out.println("Deseja finalizar o pedido? (1 - Sim, 2 - Não)");
                        int finalizarPedido = entrada.nextInt();
                        entrada.nextLine();

                        if(finalizarPedido == 1){
                            for(Produto produto : lista) {
                                relatorioVendas.registrarVenda(produto, 1);
                            }
                            System.out.println("Pedido finalizado com sucesso!");
                            System.out.println("Total a pagar: R$" + total);
                            lista.clear();
                        } else if(finalizarPedido == 2) {
                            System.err.println("Pedido não finalizado.");
                        } else {
                            System.err.println("Opção inválida! Por favor, escolha uma opção válida.");
                        }
                    }
                    break;
                case 4:
                    relatorioVendas.exibirRelatorio();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.err.println("Opção inválida! Por favor, escolha uma opção válida.");
                    break;
            }

        } while (opcao != 5);
    }
}