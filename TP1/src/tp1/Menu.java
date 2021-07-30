package tp1;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

	public static void main(String[] args) {
		
		//Inputs
		Scanner ler = new Scanner(System.in);
		Scanner lerString = new Scanner(System.in);
		
		//Parâmetros
		int opcao;
		int qtdClientes, qtdProdutos, qtdEstoque;
		int cadastrados = 10, produtosCadastrados = 10;
		int idCliente = 0, idProduto = 0;
		int vendas;
		boolean clienteExiste;
		boolean produtoExiste;
		String nome, nomeProduto;
		
		//Lists
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		ArrayList<Produto> estoque = new ArrayList<>();
		
		cadastrarDezClientes(listaClientes);
		cadastrarDezProdutos(estoque);
		mostraMenu();
		opcao = ler.nextInt();
		
		do {
			
			
			switch(opcao) {
			
			case 1:
				System.out.println("Informe a quantidade de clientes novos: ");
				qtdClientes = ler.nextInt();
				
				for (int i = 0; i < qtdClientes; i++) {
					
					cadastroClientes(listaClientes, lerString);
					//Cadastrados ira informar o tamanho da listaClientes
					cadastrados++;
				}
								
				System.out.println("\nPara exibir o menu digite qualquer tecla: ");
				lerString.nextLine();
				mostraMenu();
				opcao = ler.nextInt();
				
				break;
				
			case 2:
				System.out.println("Digite o nome do cliente: ");
				nome = lerString.nextLine();
				
				clienteExiste = false;
				
				for (int i = 0; i < cadastrados; i++) {
					if (nome.equals(listaClientes.get(i).getNome())) {
						
						clienteExiste = true;
						idCliente = i;
						i = cadastrados;
					}
				}
				
				if (clienteExiste) {
					System.out.println("\n---Cliente encontrado---\n"
							+ "\nNome: " + listaClientes.get(idCliente).getNome()
							+ "\nEndereço: " + listaClientes.get(idCliente).getEndereco()
							+ "\nTelefone: " + listaClientes.get(idCliente).getTelefone());
					System.out.println("\n(Digite 1) Para alterar dados"
							+ "\n(Digite outro número) Para prosseguir sem alterar");
					opcao = ler.nextInt();
					
					if (opcao == 1) {
						System.out.printf("Insira o nome: ");
						listaClientes.get(idCliente).setNome(lerString.nextLine());
						
						System.out.printf("Insira o endereço: ");
						listaClientes.get(idCliente).setEndereco(lerString.nextLine());
						
						System.out.printf("Insira o telefone: ");
						listaClientes.get(idCliente).setTelefone(lerString.nextLine());
						
						System.out.println("\n---Alteração feita com sucesso---");
					}
					
				} else {
					System.out.println("\n---Cliente não encontrado---\n");
				}
				
				System.out.println("\nPara exibir o menu digite qualquer tecla: ");
				lerString.nextLine();
				mostraMenu();
				opcao = ler.nextInt();
				
				break;
				
			case 3:
				
				System.out.println("Informe a quantidade de produtos novos: ");
				qtdProdutos = ler.nextInt();
				
				for	(int i = 0; i < qtdProdutos; i++) {
					
					cadastroProdutos(estoque, lerString, ler);
					//ProdutosCadastrados ira informar o tamanho da lista estoque
					produtosCadastrados++;
				}
				
				System.out.println("\nPara exibir o menu digite qualquer tecla: ");
				lerString.nextLine();
				mostraMenu();
				opcao = ler.nextInt();
				
				break;
			
			case 4:
				System.out.println("Digite o nome do produto: ");
				nomeProduto = lerString.nextLine();
				//Produto não existe até que se prove o contrário
				produtoExiste = false;
				
				for (int i = 0; i < produtosCadastrados; i++) {
					if (nomeProduto.equals(estoque.get(i).getNomeProduto())) {
						//Prova real que o produto existe
						produtoExiste = true;
						//Guarda o índice do produto para identificação
						idProduto = i;
						i = produtosCadastrados;
					}
				}
				
				if (produtoExiste) {
					System.out.println("\n---Produto encontrado---\n"
							+ "\nProduto: " + estoque.get(idProduto).getNomeProduto()
							+ "\nDescrição: " + estoque.get(idProduto).getDescricao()
							+ "\nValor: " + estoque.get(idProduto).getValor()
							+ "\nLucro: " + estoque.get(idProduto).getLucro() + "%"
							+ "\nEm estoque: " + estoque.get(idProduto).getQtdEstoque());
					System.out.println("\n(Digite 1) Para alterar dados"
							+ "\n(Digite outro número) Para prosseguir sem alterar");
					opcao = ler.nextInt();
					
					//Alteração de dados do objeto Produto atráves de método setter
					
					if (opcao == 1) {
						System.out.printf("Insira o nome: ");
						estoque.get(idProduto).setNome(lerString.nextLine());
						
						System.out.printf("Insira a descrição: ");
						estoque.get(idProduto).setDescricao(lerString.nextLine());
						
						System.out.printf("Insira o valor: ");
						estoque.get(idProduto).setValor(lerString.nextLine());
						
						System.out.printf("Insira o lucro: ");
						estoque.get(idProduto).setLucro(lerString.nextLine());
						
						System.out.printf("Insira o estoque: ");
						estoque.get(idProduto).setQtdEstoque(ler.nextInt());
						
						System.out.println("\n---Alteração feita com sucesso---");
					}
					
				} else {
					System.out.println("\n---Produto não encontrado---\n");
				}
				
				System.out.println("\nPara exibir o menu digite qualquer tecla: ");
				lerString.nextLine();
				mostraMenu();
				opcao = ler.nextInt();
				break;
			
			case 5:
				
				System.out.println("\n---Lista de Clientes---\n");
				for (int i = 0; i < cadastrados; i++) {
					System.out.println("Cliente " + (i+1) + " : " 
							+ listaClientes.get(i).getNome());
				}
				
				System.out.println("\nSelecione um cliente: ");
				
				idCliente = ler.nextInt();
				//Validação
				while (idCliente <= 0 || idCliente > cadastrados) {
					System.out.println("\nCliente inexistente, digite novamente:");
					idCliente = ler.nextInt();
				}
				//A lista visual começa em 1, logo devemos subtrair 1 aqui para corrigir a id 
				idCliente--;
				
				//Laço para sempre mostrar a lista até que o usuário decida sair
				do {
					System.out.println("\n---Lista de Produtos---\n");
					for (int i = 0; i < produtosCadastrados; i++ ) {
						if (estoque.get(i).getQtdEstoque() == 0) {
							System.out.println("Produto " + (i+1) + " : " 
									+ estoque.get(i).getNomeProduto() 
								    + " ------ Em estoque: Esgotado\n");
						}	else {
							System.out.println("Produto " + (i+1) + " : " 
									+ estoque.get(i).getNomeProduto() 
								    + " ------ Em estoque: " + estoque.get(i).getQtdEstoque()
								    + "\n");
						}
					}
					
					System.out.println("\nSelecione um produto: ");
					
					idProduto = ler.nextInt();
					//Validação
					while (idProduto <= 0 || idProduto > produtosCadastrados) {
						System.out.println("\nProduto inexistente, digite novamente:");
						idProduto = ler.nextInt();
					}
					//A lista visual começa em 1, logo devemos subtrair 1 aqui para corrigir a id
					idProduto--;
					
					if (estoque.get(idProduto).getQtdEstoque() == 0) {
						System.out.println("---Produto esgotado---");
					} else {
						System.out.println("\nInserir Nº de vendas para o cliente: ");
						vendas = ler.nextInt();
						//Validação
							while(vendas > estoque.get(idProduto).getQtdEstoque() || vendas < 0) {
								if(vendas < 0) {
									System.out.println("Quantidade inválida, digite novamente: ");
									vendas = ler.nextInt();	
								}	else {
									System.out.println("Quantidade excede o estoque, digite novamente: ");
									vendas = ler.nextInt();	
								}
								
							}
						//Obtendo a quantidade alterada do estoque após as vendas	
						qtdEstoque = estoque.get(idProduto).getQtdEstoque() - vendas;
						estoque.get(idProduto).setQtdEstoque(qtdEstoque);	
					}
					System.out.println("\n(Digite 1) Para cadastrar mais vendas ao cliente" 
					+ "\n(Digite outro número) Para prosseguir");
					opcao = ler.nextInt();
					
				}while(opcao == 1);
				
				
				System.out.println("\nPara exibir o menu digite qualquer tecla: ");
				lerString.nextLine();
				mostraMenu();
				opcao = ler.nextInt();
				break;
				
			case 6:
				System.out.println("---Estoque---\n");
				
				for (int i = 0; i < produtosCadastrados; i++ ) {
					if (estoque.get(i).getQtdEstoque() == 0) {
						System.out.println("Produto " + (i+1) + " : " 
								+ estoque.get(i).getNomeProduto() 
							    + " ------ Em estoque: Esgotado\n");
					}	else {
						System.out.println("Produto " + (i+1) + " : " 
								+ estoque.get(i).getNomeProduto() 
							    + " ------ Em estoque: " + estoque.get(i).getQtdEstoque()
							    + "\n");
					}
					
				}
				
				System.out.println("\nPara exibir o menu digite qualquer tecla: ");
				lerString.nextLine();
				mostraMenu();
				opcao = ler.nextInt();
				
				break;
			
			default:
				//Validação da navegação
				while (opcao < 1 || opcao > 7) {
					System.out.println("Opção invalida, digite novamente: ");
					opcao = ler.nextInt();
				}
				
				break;
				
			}
			
		} while(opcao != 7);
		
		System.out.println("\n---Fim de execução---");
		System.out.println("\nObrigado por utilizar UwU");
		
		ler.close();
		lerString.close();
		
	}
	
	public static void mostraMenu(){
		System.out.println("---MENU---\n");
		System.out.println("(Digite 1) - Cadastrar novo cliente \n"
		+ "(Digite 2) - Busca por cliente \n"
		+ "(Digite 3) - Cadastrar novo produto \n"
		+ "(Digite 4) - Busca por produto \n"
		+ "(Digite 5) - Cadastro de venda \n"
		+ "(Digite 6) - Mostrar produtos em estoque \n"
		+ "(Digite 7) - Sair \n\n"
		+ "Digite a opção aqui: ");
	}
	
	public static void cadastrarDezClientes(ArrayList<Cliente> listaClientes) {
		listaClientes.add(new Cliente("Capitolina Gomes", "Gama", "61992150220"));
		listaClientes.add(new Cliente("Santiago Silva", "Valparaíso", "61992152000"));
		listaClientes.add(new Cliente("Fortunato Gomes", "Brasília", "61992340220"));
		listaClientes.add(new Cliente("Victor Santana", "Luziânia", "61992050230"));
		listaClientes.add(new Cliente("Carlos Borges", "Novo Gama", "61992105230"));
		listaClientes.add(new Cliente("Geovana Lima", "Gama", "66992150220"));
		listaClientes.add(new Cliente("Jhonatan Alves", "Novo Gama", "67992150210"));
		listaClientes.add(new Cliente("Leonildo Santos", "Novo Gama", "63992150280"));
		listaClientes.add(new Cliente("Gilmar Mendes", "Cidade Ocidental", "63992000270"));
		listaClientes.add(new Cliente("Silvano da Silva", "Novo Gama", "64924150370"));
	}
	
	public static void cadastrarDezProdutos(ArrayList<Produto> estoque) {
		estoque.add(new Produto("Caneta","Azul Bic","1.00","5",10));
		estoque.add(new Produto("Cadeira","Ultra confort","100.00","5",15));
		estoque.add(new Produto("Moletom","100% Algodão","90.00","5",10));
		estoque.add(new Produto("Mesa","100% Madeira","500.00","5",5));
		estoque.add(new Produto("Mouse","Bluetooth","100.00","10",10));
		estoque.add(new Produto("Teclado","Mecânico","300.00","8",13));
		estoque.add(new Produto("Garrafa","Plástica","15.00","5",10));
		estoque.add(new Produto("Estojo","Bordado","20.00","7",17));
		estoque.add(new Produto("Caderno","10 Matérias","10.00","3",8));
		estoque.add(new Produto("Óculos","Filtro ultravioleta","300.00","15",5));
	}
	
	public static void cadastroClientes(ArrayList<Cliente> listaClientes, Scanner lerString) {

		String nome, endereco, telefone;
		
		System.out.printf("Insira o nome: ");
		nome = lerString.nextLine();
		
		System.out.printf("Insira o endereço: ");
		endereco = lerString.nextLine();
		
		System.out.printf("Insira o telefone: ");
		telefone = lerString.nextLine();
		
		listaClientes.add(new Cliente(nome, endereco, telefone));
	
	}
	
	public static void cadastroProdutos(ArrayList<Produto> estoque, Scanner lerString, Scanner ler) {
		
		String nomeProduto, descricao, valor, lucro;
		int qtdEstoque;
		
		System.out.println("Nome do produto: ");
		nomeProduto = lerString.nextLine();
		
		System.out.println("Descrição do produto: ");
		descricao = lerString.nextLine();
		
		System.out.println("Valor de compra:");
		valor = lerString.nextLine();
		
		System.out.println("Porcentagem de lucro: ");
		lucro = lerString.nextLine();
		
		System.out.println("Quantidade em estoque");
		qtdEstoque = ler.nextInt();
		
		estoque.add(new Produto(nomeProduto, descricao, valor, lucro, qtdEstoque));
	}
	
}
	

