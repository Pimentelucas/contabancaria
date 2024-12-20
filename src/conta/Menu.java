package conta;


import java.util.Scanner;

import conta.model.Conta;

public class Menu {

	public static final String ANSI_RESET = "\u001B[0m";          
    public static final String ANSI_RED = "\u001B[31m";           
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m"; 
	
	public static void main(String[] args) {
		Conta c1 = new Conta(123456, 0001, 1, "Maria das Neves", 500f);
		c1.setSaldo(5000f);
		
		System.out.println("Titular: " + c1.getTitular());
		System.out.println("Saldo: " + c1.getSaldo());
		
		Scanner leia = new Scanner(System.in);
		
		

		int opcao;

		while (true) {
			
			System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED);
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
                 leia.close();

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import controller.ContaController;

public class Menu { 
	
	public static void main(String[] args) {
		
		ContaController contas = new ContaController();		
		
		Scanner leia = new Scanner(System.in);
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 5000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		while (true) {
			
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED);
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
                 		leia.close();

				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Digite as seguintes informações para criar a conta:\n\n");


					break;
				case 2:
					System.out.println("As contas são:\n\n");

					System.out.println("Digite o Numero da Agência");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					do { 
						System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
						tipo = leia.nextInt();
					}while(tipo < 1 && tipo > 2);
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					
					switch(tipo) {
						case 1 -> {  
							System.out.println("Digite o Limite de Crédito (R$): ");
							limite = leia.nextFloat();
							contas.cadastrar(new ContaCorrente (contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
						}
					 	case 2 -> {
							System.out.println("Digite o dia do Aniversario da Conta: ");
							aniversario = leia.nextInt();
							contas.cadastrar(new ContaPoupanca (contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					 	}
					}
					
					keyPress();
					break;
				case 2:
					System.out.println("As contas são:\n\n");
					contas.listarTodas();
					keyPress();


					break;
				case 3:
					System.out.println("Digite o número da conta que deseja:\n\n");

			System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					contas.procurarPorNumero(numero);
					keyPress();


					break;
				case 4:
					System.out.println("Digite os novos dados:\n\n");


					break;
				case 5:
					System.out.println("tem certeza que deseja apagar a conta?\n\n");

					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					var buscaConta = contas.buscarNaCollection (numero);
					if(buscaConta != null) { 
						tipo = buscaConta.getTipo();
						System.out.println("Digite o Numero da Agência: ");
						agencia = leia.nextInt();
						System.out.println("Digite o Nome do Titular: ");
						leia.skip("\\R?"); titular = leia.nextLine();
						System.out.println("Digite o Saldo da Conta (R$): ");
						saldo = leia.nextFloat();
						
						switch (tipo) {
							case 1 -> {
								System.out.println("Digite o limite de crédio (R$): ");
								limite = leia.nextFloat();
							}
							case 2 ->{
								System.out.println("Digite o dia do Aniversario da Conta: ");
								aniversario = leia.nextInt();
								contas.cadastrar(new ContaPoupanca (contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
							}
							default -> {
								System.out.println("Tipo de conta inválido!");
							}
						}	
					}else {
						System.out.println("A Conta não foi encontradal"); 
					}
					keyPress();
					break;
				case 5:
					System.out.println("Tem certeza que deseja apagar a conta?\n\n");
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					contas.deletar(numero);
;					keyPress();


					break;
				case 6:
					System.out.println("Digite o valor que deseja sacar:\n\n");


					System.out.println("Digite o numero da conta: ");
					numero = leia.nextInt();
					
					do {
						System.out.println("Digite o valor do saque (R$): ");
						valor = leia.nextFloat();
					}while(valor <= 0);
					contas.sacar(numero, valor);
					keyPress();


					break;
				case 7:
					System.out.println("Digite o valor que deseja depositar:\n\n");


					System.out.println("Digite o numero da conta: ");
					numero = leia.nextInt();
					
					do {
						System.out.println("Digite o valor do depósito (R$): ");
						valor = leia.nextFloat();
					}while(valor <= 0);
					contas.depositar(numero, valor);
					keyPress();


					break;
				case 8:
					System.out.println("Digite a conta e o valor que deseja transferir:\n\n");


					System.out.println("Digite o numero da conta de origem: ");
					numero = leia.nextInt();
					System.out.println("Digite o numero da conta de destino: ");
					numeroDestino = leia.nextInt();
					
					do {
						System.out.println("Digite o valor da transferência (R$): ");
						valor = leia.nextFloat();
					}while(valor <= 0);
					contas.transferir(numero, numeroDestino, valor);
					keyPress();


					break;
				default:
					System.out.println("\nOpção Inválida!\n");

					break;
			}
		}
	}
    
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Lucas da Silva Pimentel ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("https://github.com/Pimentelucas/contabancaria");
		System.out.println("*********************************************************");

					keyPress();
					break;
			}
		

	
    
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Lucas da Silva Pimentel ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("https://github.com/Pimentelucas/contabancaria");
		System.out.println("*********************************************************");
	}
	public static void keyPress() {



		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}


