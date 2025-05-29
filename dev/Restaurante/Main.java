package dev.Restaurante;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cardapio cardapio = new Cardapio();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Gerente gerente = new GerenteRestaurante(cardapio, pedidos);
        Garcom garcom = new GarcomRestaurante(gerente.getClientes(), cardapio, pedidos);

        int opcao = -1;

        while (opcao = -1) {
            System.out.println("\nVocê é:");
            System.out.println("1 - Gerente");
            System.out.println("2 - Garçom");
            System.out.println("3 - Cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            try{
                E_Opcao x = new E_Opcao(opcao);
            }
            catch(RuntimeException exception){
                System.out.println(exception.getMessage());
            }

            switch (opcao) {
                case 1:
                    menuGerente(gerente, sc);
                    break;
                case 2:
                    menuGarcom(garcom, sc);
                    break;
                case 3:
                    menuCliente(gerente.getClientes(), sc);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
            }
        }

        sc.close();
    }

    public static void menuGerente(Gerente gerente, Scanner sc) {
        int opcao = -1;

        while (opcao != 11) {
            System.out.println("\nMenu do Gerente:");
            System.out.println("1 - Cadastrar prato");
            System.out.println("2 - Ver pratos");
            System.out.println("3 - Editar prato");
            System.out.println("4 - Remover prato");
            System.out.println("5 - Cadastrar cliente");
            System.out.println("6 - Ver clientes");
            System.out.println("7 - Editar cliente");
            System.out.println("8 - Remover cliente");
            System.out.println("9 - Consultar pratos por categoria");
            System.out.println("10 - Consultar pedidos com filtros");
            System.out.println("11 - Voltar");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            try {
                E_Gerente y = new E_Gerente(opcao);
            }
            catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome do prato: ");
                    String nomePrato = sc.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();
                    gerente.cadastrarPrato(nomePrato, categoria);
                    break;
                case 2:
                    gerente.listarPratos();
                    break;
                case 3:
                    gerente.listarPratos();
                    System.out.print("Índice do prato para editar: ");
                    int idxPrato = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Nova categoria: ");
                    String novaCat = sc.nextLine();
                    gerente.editarPrato(idxPrato, novoNome, novaCat);
                    break;
                case 4:
                    gerente.listarPratos();
                    System.out.print("Índice do prato para remover: ");
                    int idxRemoverPrato = sc.nextInt();
                    gerente.removerPrato(idxRemoverPrato);
                    break;
                case 5:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = sc.nextLine();
                    gerente.cadastrarCliente(nomeCliente);
                    break;
                case 6:
                    gerente.listarClientes();
                    break;
                case 7:
                    gerente.listarClientes();
                    System.out.print("Índice do cliente para editar: ");
                    int idxCliente = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNomeCliente = sc.nextLine();
                    gerente.editarCliente(idxCliente, novoNomeCliente);
                    break;
                case 8:
                    gerente.listarClientes();
                    System.out.print("Índice do cliente para remover: ");
                    int idxRemoverCliente = sc.nextInt();
                    gerente.removerCliente(idxRemoverCliente);
                    break;
                case 9:
                    ArrayList<Prato> pratos = gerente.getCardapio().getPratos();
                    if (pratos.isEmpty()) {
                        System.out.println("Nenhum prato cadastrado.");
                    } else {
                        ArrayList<String> categorias = new ArrayList<>();
                        for (Prato p : pratos) {
                            if (!categorias.contains(p.getCategoria())) {
                                categorias.add(p.getCategoria());
                            }
                        }

                        System.out.println("Categorias disponíveis:");
                        for (int i = 0; i < categorias.size(); i++) {
                            System.out.println(i + " - " + categorias.get(i));
                        }
                        System.out.print("Escolha o índice da categoria: ");
                        int idxCategoria = sc.nextInt();
                        sc.nextLine();

                        if (idxCategoria >= 0 && idxCategoria < categorias.size()) {
                            String categoriaEscolhida = categorias.get(idxCategoria);
                            gerente.listarPratosPorCategoria(categoriaEscolhida);
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    break;
                case 10:
                    menuConsultaPedidosComFiltros(gerente, sc);
                    break;
                case 11:
                    System.out.println("Voltando ao menu principal...");
                    break;
            }
        }
    }

    public static void menuGarcom(Garcom garcom, Scanner sc) {
        int opcao = -1;

        while (opcao != 4) {
            System.out.println("\nMenu do Garçom:");
            System.out.println("1 - Registrar pedido");
            System.out.println("2 - Alterar pedido");
            System.out.println("3 - Remover pedido");
            System.out.println("4 - Voltar");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    garcom.registrarPedido(sc);
                    break;
                case 2:
                    garcom.alterarPedido(sc);
                    break;
                case 3:
                    garcom.removerPedido(sc);
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void menuCliente(List<Cliente> clientes, Scanner sc) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Peça para o gerente cadastrar clientes primeiro.");
            return;
        }

        System.out.println("Escolha seu nome na lista de clientes:");

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i).getNome());
        }
        System.out.print("Digite o índice do seu nome: ");
        int idx = sc.nextInt();
        sc.nextLine();

        if (idx < 0 || idx >= clientes.size()) {
            System.out.println("Índice inválido. Retornando ao menu principal.");
            return;
        }

        Cliente clienteSelecionado = clientes.get(idx);
        clienteSelecionado.iniciarAtendimento();
    }

    public static void menuConsultaPedidosComFiltros(Gerente gerente, Scanner sc) {
        int opcaoFiltro = -1;

        while (opcaoFiltro != 0) {
            System.out.println("\nConsultar pedidos com filtros:");
            System.out.println("1 - Por status");
            System.out.println("2 - Por cliente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcaoFiltro = sc.nextInt();
            sc.nextLine();

            ArrayList<Pedido> pedidos = gerente.getPedidos();

            switch (opcaoFiltro) {
                case 1:
                    if (pedidos.isEmpty()) {
                        System.out.println("Não há pedidos registrados para consultar por status.");
                        break;
                    }

                    ArrayList<String> statusUnicos = new ArrayList<>();
                    for (Pedido p : pedidos) {
                        if (!statusUnicos.contains(p.getStatus())) {
                            statusUnicos.add(p.getStatus());
                        }
                    }

                    if (statusUnicos.isEmpty()) {
                        System.out.println("Nenhum status registrado nos pedidos.");
                        break;
                    }

                    System.out.println("Status disponíveis:");
                    for (int i = 0; i < statusUnicos.size(); i++) {
                        System.out.println(i + " - " + statusUnicos.get(i));
                    }

                    System.out.print("Escolha o índice do status: ");
                    int idxStatus = sc.nextInt();
                    sc.nextLine();

                    if (idxStatus >= 0 && idxStatus < statusUnicos.size()) {
                        String statusEscolhido = statusUnicos.get(idxStatus);
                        gerente.listarPedidosPorStatus(statusEscolhido);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 2:
                    ArrayList<Cliente> clientes = gerente.getClientes();
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                        break;
                    }

                    if (pedidos.isEmpty()) {
                        System.out.println("Não há pedidos registrados para consultar por cliente.");
                        break;
                    }

                    System.out.println("Clientes cadastrados:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println(i + " - " + clientes.get(i).getNome());
                    }
                    System.out.print("Escolha o índice do cliente: ");
                    int idxClienteFiltro = sc.nextInt();
                    sc.nextLine();

                    if (idxClienteFiltro >= 0 && idxClienteFiltro < clientes.size()) {
                        String nomeClienteFiltro = clientes.get(idxClienteFiltro).getNome();
                        gerente.listarPedidosPorCliente(nomeClienteFiltro);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
