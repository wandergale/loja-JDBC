package application;

import java.util.Scanner;

import entities.Cliente;
import entities.Pedido;
import DAO.ClienteDAO;
import DAO.PedidoDAO;

public class Program {

	private static Scanner scanner = new Scanner(System.in);
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static PedidoDAO pedidoDAO = new PedidoDAO();

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    adicionarPedido();
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        System.out.println("Encerrando o programa...");
    }

    private static void exibirMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Adicionar Pedido");
        System.out.println("0. Sair do programa");
    }

    private static int lerOpcao() {
        System.out.print("Digite a opção desejada: ");
        return scanner.nextInt();
    }

    private static void adicionarCliente() {
    	scanner.nextLine();

        System.out.println("Digite o ID do cliente:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Digite o endereço do cliente:");
        String endereco = scanner.nextLine();

        System.out.println("Digite o email do cliente:");
        String email = scanner.nextLine();

        System.out.println("Digite o tipo do cliente:");
        String tipoCliente = scanner.nextLine();

        Cliente cliente = new Cliente(id, nome, endereco, email, tipoCliente);
        clienteDAO.adicionarCliente(cliente);

        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void adicionarPedido() {
    	scanner.nextLine();

    	System.out.println("Digite o ID do pedido:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o ID do cliente:");
        int clienteId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a data do pedido (dd/mm/aaaa):");
        String dataPedido = scanner.nextLine();

        System.out.println("Digite o status do pedido:");
        String statusPedido = scanner.nextLine();
        
        Cliente cliente = clienteDAO.obterCliente(clienteId);

        Pedido pedido = new Pedido(id, cliente, dataPedido, statusPedido);
        pedidoDAO.adicionarPedido(pedido);

        System.out.println("Pedido adicionado com sucesso!");
    }
	
}
