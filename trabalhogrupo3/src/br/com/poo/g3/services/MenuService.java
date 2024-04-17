package br.com.poo.g3.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.controller.AutenticacaoController;
import br.com.poo.g3.entities.Cliente;
import br.com.poo.g3.entities.Conta;
import br.com.poo.g3.entities.ContaPoupanca;
import br.com.poo.g3.entities.Usuarios;
import br.com.poo.g3.util.Util;

public class MenuService {
	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);
	static AutenticacaoController autenticacaoController = new AutenticacaoController();
	static Cliente clientelogado;
	static Usuarios usuariosbanco;
	static Conta contacliente;
//	static Funcionario escravo = new Funcionario(198, 77.00, 1, "Amanda da silva", "666.666.666-99", 33.00, "4444",
//			TipoPessoa.FUNCIONARIO);
//	static Gerente trabalhador = new Gerente(200, 8888.00, 2, "Lucas da silva", "777.777.777-77", 1000.00, "9999",
//			TipoPessoa.GERENTE);
//
//	static FuncionarioService funcionarios = new FuncionarioService();
//	static Diretor puxaSaco = new Diretor(6969, 800.00, 6, "Nicolas da silva", "696.969.696-69", 6500.70, "9898",
//			TipoPessoa.DIRETOR);

//	public static void menuInicial() throws IOException, InterruptedException {
//
//		Util.customizer();
//		logger.log(Level.INFO, """
//				Menu interativo:
//				[1]\tLogin
//				[2]\tCadastro
//				[3]\tSair
//				Digite uma opção:
//				""");
//
//		int key = sc.nextInt();
//
//		switch (key) {
//		case 1:
//			Util.customizer();
//			menuLogin();
//			break;
//		case 2:
//			Util.customizer();
//			logger.log(Level.INFO, "Cadastrado com sucesso!");
//			menuCadastro();
//			break;
//		case 3:
//			Util.customizer();
//			logger.log(Level.INFO, "Sessão encerrada!");
//			break;
//		default:
//			logger.log(Level.INFO, "Opção inválida");
//			menuInicial();
//		}
//	}

//	public static void menuLogin() throws IOException, InterruptedException {
//		Util.customizer();
//		logger.log(Level.INFO, """
//				Menu interativo:
//				[1]\tLogar como funcionário
//				[2]\tLogar como gerente
//				[3]\tLogar como diretor
//				[4]\tLogar como presidente
//				[5]\tLogar como cliente
//				[7]\tSair
//				Digite uma opção:
//				""");
//
//		int key = sc.nextInt();
//
//		switch (key) {
//		case 1:
//			Util.customizer();
////			logger.log(Level.INFO, "Bem-Vindo " + escravo.getNome() + "");
//			menuFuncionario();
//			break;
//		case 2:
//			Util.customizer();
////			logger.log(Level.INFO, "Bem-Vindo" + trabalhador.getNome() + "");
//			menuGerente();
//			break;
//		case 3:
//			Util.customizer();
//			logger.log(Level.INFO, "Logado com sucesso!");
//			menuDiretor();
//			break;
//		case 4:
//			Util.customizer();
//			logger.log(Level.INFO, "Logado com sucesso!");
//			menuPresidente();
//			break;
//		case 5:
//			Util.customizer();
//			autenticacaoController.login();
//			logger.log(Level.INFO, "Logado com sucesso!");
////			menuCliente();
//			break;
//		case 6:
//			Util.customizer();
//			logger.log(Level.INFO, "Sessão encerrada!");
//			break;
//		default:
//			logger.log(Level.INFO, "Opção inválida");
//			menuLogin();
//		}
//	}

	public static void menuCadastro() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, """
				Menu interativo:
				[1]\tCriar conta poupança
				[2]\tCriar conta corrente
				[3]\tSair
				Digite uma opção:
				""");

		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "Conta poupança criada com sucesso!");
			break;
		case 2:
			Util.customizer();
			logger.log(Level.INFO, "Conta corrente criada com sucesso!");
			break;
		case 3:
			Util.customizer();
			logger.log(Level.INFO, "Sessão encerrada!");
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuCadastro();
		}
	}

	public static void menuGerente() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo:
				[1]\tConsultar total de contas
				[2]\tConsultar funcionários
				[3]\tSaldo disponível
				[4]\tVoltar
				Digite uma opção:
				""");

		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			// retirei o logger pq deletamos o atributo "nmero de funcionarios"

			break;
		case 2:
			Util.customizer();
//			logger.log(Level.INFO, String.valueOf(funcionarios.listaFuncionarios()));
			break;
		case 3:
			Util.customizer();
//			logger.log(Level.INFO, String.valueOf(trabalhador.getSaldo()));
			break;
		case 4:
			Util.customizer();
			logger.log(Level.INFO, "Sessão encerrada!");
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuGerente();
		}
	}

	public static void menuDiretor() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo:
				[1]\tConsultar contas
				[2]\tConsultar clientes
				[3]\tConsultar gerentes
				[4]\tSaldo disponível
				[5]\tVoltar
				Digite uma opção:
				""");

		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "Informações geradas com sucesso!");
			break;
		case 2:
			Util.customizer();
			logger.log(Level.INFO, "Informações geradas com sucesso!");
			break;
		case 3:
			Util.customizer();
			logger.log(Level.INFO, "Informações geradas com sucesso!");
			break;
		case 4:
			Util.customizer();
//			logger.log(Level.INFO, String.valueOf(puxaSaco.getSaldo()));
			break;
		case 5:
			Util.customizer();
			logger.log(Level.INFO, "Sessão encerrada!");
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuDiretor();
		}
	}

	public static void menuPresidente() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo:
				[1]\tConsultar informações dos diretores
				[2]\tConsultar total do capital
				[3]\tVoltar
				Digite uma opção:
				""");

		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "Informações geradas com sucesso!");
			break;
		case 2:
			Util.customizer();
			logger.log(Level.INFO, "Informações geradas com sucesso!");
			break;
		case 3:
			Util.customizer();
			logger.log(Level.INFO, "Sessão encerrada!");
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuPresidente();
		}
	}

	public static void menuCliente() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo:
				[1]\tMovimentos na conta
				[2]\tRelatórios
				[3]\tSaldo disponível
				[4]\tVoltar
				Digite uma opção:
				""");

		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "Movimentos na conta gerado com sucesso!");
			menuMovimentosContas();
			break;
		case 2:
			Util.customizer();
			contacliente.tributosconta();
			menuCliente();
			break;
		case 3:
			Util.customizer();
			logger.log(Level.INFO,
					"Saldo disponível gerado com sucesso!" + " " + "Você tem: " + " " + contacliente.getSaldo());
			menuCliente();
			break;
		case 4:
			Util.customizer();
			logger.log(Level.INFO, "Sessão encerrada!");
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuCliente();
		}
	}

	public static void menuFuncionario() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo:
				[1]\tID do cliente
				[2]\tConsultar salário
				[3]\tSaldo disponível
				[4]\tvoltar
				Digite uma opção:
				""");

		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
//			logger.log(Level.INFO, escravo.getId() + "");
			break;
		case 2:
			Util.customizer();
//			logger.log(Level.INFO, escravo.getSalario() + "");
			break;
		case 3:
			Util.customizer();
//			logger.log(Level.INFO, escravo.getSaldo() + "");
			break;
		case 4:
			Util.customizer();
			logger.log(Level.INFO, "Sessão encerrada!");
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuFuncionario();
		}
	}

	public static void menuMovimentosContas() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo:
				[1]\tSaque
				[2]\tDepósito
				[3]\tTransferência""");
		if(contacliente instanceof ContaPoupanca) {
			logger.log(Level.INFO, "[4]\tRelatorioContaPoupanca");
		}
		logger.log(Level.INFO, "[5]\tVoltar \ndigite uma opção");


		int key = sc.nextInt();

		switch (key) {
		case 1:
			System.out.println("Digite um valor: ");
			Util.customizer();
			double valorsacar = sc.nextDouble();
			contacliente.sacar(valorsacar);
			logger.log(Level.INFO, "Saque feito com sucesso!");
			menuMovimentosContas();
			break;
		case 2:
			System.out.println("Digite o valor de deposito: ");
			double valordepositar = sc.nextDouble();
			contacliente.depositar(valordepositar);
			Util.customizer();
			logger.log(Level.INFO, "Depósito feito com sucesso!");
			menuMovimentosContas();
			break;
		case 3:
			System.out.println("Digite o cpf do destinatario: ");
			String cpfdestinatario = sc.next();
			Conta contadestinatario = usuariosbanco.buscarConta(cpfdestinatario);
			if (contadestinatario == null) {
				System.out.println("Não foi! Usuario não encontrado");
				menuMovimentosContas();
				break;
			}
			System.out.println("Digite um valor: ");
			Double valortransf = sc.nextDouble();
			contacliente.transferencia(valortransf, contadestinatario);
			menuMovimentosContas();
			break;
		case 4:
			if(contacliente instanceof ContaPoupanca) {
				((ContaPoupanca) contacliente).simularpoupanca();
			}
		case 5:
			Util.customizer();
			menuCliente();
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuMovimentosContas();
		}
	}

	public void setuser(Cliente cliente, Conta conta, Usuarios usuarios) {
		clientelogado = cliente;
		contacliente = conta;
		usuariosbanco = usuarios;
	}
}
//		Scanner sc = new Scanner(System.in);
//		
//		String sysCpf = "995.866.968-47";
//		String sysSenha = "1456";
//		
//		
//		System.out.print("Insira seu cpf: ");
//		String Cpf = sc.next();
//		
//		System.out.print("Insira sua senha: ");
//		String Senha = sc.next();
//		Util.customizer();
//		if(sysCpf.equals(Cpf)) {
//			if(sysSenha.equals(Senha)) {
//				System.out.print("Bem vindo, presidente");
//			}else {
//				System.out.print("Cheque sua senha");
//			}
//			
//		}else {
//			System.out.print("Por favor, cheque seu cpf");
//		}