package trier.atividades.lanchonete;

import java.util.Scanner;

public class LanchoneteMain {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        Cardapio cardapio = new Cardapio();

        Lanche lanche = new Lanche("X-Burger", 15.0);
        Bebida bebida = new Bebida("Refrigerante", 5.0);
        Sobremesa sobremesa = new Sobremesa("Sorvete", 7.0);

        cardapio.adicionarLanche(lanche);
        cardapio.adicionarBebida(bebida);
        cardapio.adicionarSobremesa(sobremesa);

        do {
            System.out.println("======== Lanchonete Digital ========");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Ver cardápio");
            System.out.println("3. Sair");
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

                    Cliente novoCliente = new Cliente (nome, telefone, endereco);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("======== Cardápio ========");
                    System.out.println("1. Lanches");
                    System.out.println("2. Bebidas");
                    System.out.println("3. Sobremesas");
                    System.out.println("4. Voltar ao menu principal");
                    System.out.println("Escolha uma opção:");
                    int escolhaCardapio = entrada.nextInt();
                    entrada.nextLine();

                    switch (escolhaCardapio) {
                        case 1:
                            cardapio.listarLanches();
                            break;
                        case 2:
                            cardapio.listarBebidas();
                        case 3:
                            cardapio.listarSobremesas();
                            break;
                        case 4:
                            System.out.println("Voltando ao menu principal...");
                            break;
                    }

            }

        } while (opcao != 3);
    }
}
