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
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Digite as seguintes informações para criar a conta:\n\n");

					break;
				case 2:
					System.out.println("As contas são:\n\n");

					break;
				case 3:
					System.out.println("Digite o número da conta que deseja:\n\n");

					break;
				case 4:
					System.out.println("Digite os novos dados:\n\n");

					break;
				case 5:
					System.out.println("tem certeza que deseja apagar a conta?\n\n");

					break;
				case 6:
					System.out.println("Digite o valor que deseja sacar:\n\n");

					break;
				case 7:
					System.out.println("Digite o valor que deseja depositar:\n\n");

					break;
				case 8:
					System.out.println("Digite a conta e o valor que deseja transferir:\n\n");

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
	}


}


