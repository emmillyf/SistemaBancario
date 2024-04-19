package br.com.poo.g3.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.GrupoApplication;
import br.com.poo.g3.controller.AutenticacaoController;
import br.com.poo.g3.entities.Cliente;
import br.com.poo.g3.entities.Conta;
import br.com.poo.g3.entities.ContaPoupanca;
import br.com.poo.g3.entities.Diretor;
import br.com.poo.g3.entities.Gerente;
import br.com.poo.g3.entities.Presidente;
import br.com.poo.g3.entities.Usuarios;
import br.com.poo.g3.util.Util;

public class MenuService {
	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);
	static AutenticacaoController autenticacaoController = new AutenticacaoController();
	static Cliente clientelogado;
	static Usuarios usuariosbanco;
	static Conta contacliente;

	public static void menuCadastro() throws IOException, InterruptedException {

		Util.customizer();
		logger.log(Level.INFO, """
				Menu interativo:
				[1]\tCriar conta poupança
				[2]\tCriar conta corrente""");
		if (clientelogado instanceof Diretor || clientelogado instanceof Presidente) {
			logger.log(Level.INFO, "[3]\tCadastroDeGerente");
		}
		if (clientelogado instanceof Presidente) {
			logger.log(Level.INFO, "[4]\tCadastroDeDiretor");
		}
		logger.log(Level.INFO, "[0]\tSair \ndigite uma opção");
		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			Cliente cliente = autenticacaoController.cadastrarCliente();
			Conta conta = autenticacaoController.cadastrarContaPoupanca(cliente.getCpf());
			usuariosbanco.CadastrarContaClientes(cliente, conta);
			GrupoApplication.menuInicial(usuariosbanco);
			break;
		case 2:
			Util.customizer();
			Cliente cliente2 = autenticacaoController.cadastrarCliente();
			Conta conta2 = autenticacaoController.cadastrarContaCorrente(cliente2.getCpf());
			usuariosbanco.CadastrarContaClientes(cliente2, conta2);
			break;
		case 3:
			if (clientelogado instanceof Diretor || clientelogado instanceof Presidente) {
				Util.customizer();
				Gerente gerente = autenticacaoController.cadastrarGerente();
				Conta contaGerente = autenticacaoController.cadastrarContaCorrente(gerente.getCpf());
				usuariosbanco.CadastrarContaGerentes(gerente, contaGerente);
				GrupoApplication.menuInicial(usuariosbanco);
			}else {
				logger.log(Level.INFO, "opção inválida =) ");
			}
		case 4:
			if (clientelogado instanceof Presidente) {
			Diretor diretor = autenticacaoController.cadastrarDiretor();
			Conta contaDiretor = autenticacaoController.cadastrarContaCorrente(diretor.getCpf());
			usuariosbanco.CadastrarContaDiretor(diretor, contaDiretor);
			GrupoApplication.menuInicial(usuariosbanco);
			}else {
				logger.log(Level.INFO, "opção inválida =) ");
			}
		case 0:
			Util.customizer();
			logger.log(Level.INFO, "Sessão encerrada!");
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuCadastro();
		}
	}

	public static void menuGerente() throws IOException, InterruptedException {

		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo:
				[1]\tConsultar total de contas
				[2]\tConsultar informações das contas
				[3]\tSaldo disponível
				[4]\tMenu cadastro
				[0]\tSair
				Digite uma opção:
				""");

		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "Total de contas na agência: "
					+ usuariosbanco.buscarTotalContasPorAgencia(contacliente.getNumeroDaAgencia()));
			menuGerente();
			break;
		case 2:
			Util.customizer();
			logger.log(Level.INFO, String
					.valueOf(usuariosbanco.buscarInformacoesDeContasPorAgencia(contacliente.getNumeroDaAgencia())));
			menuGerente();
			break;
		case 3:
			Util.customizer();
			logger.log(Level.INFO, String.valueOf(contacliente.getSaldo()));
			menuGerente();
			break;
		case 4:
			Util.customizer();
			menuCadastro();
			break;
		case 0:
			Util.customizer();
			logger.log(Level.INFO, "Sessão encerrada.");
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuGerente();
		}
	}

	public static void menuDiretor() throws IOException, InterruptedException {

		Util.customizer();
		logger.log(Level.INFO, """
				[1]\tRelatorios
				[2]\tMenuCadastro
				[0]\tSair
				Digite uma opção:
				""");
		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO,
					String.valueOf(usuariosbanco.buscarInformacoesDeClientes(contacliente.getNumeroDaAgencia())));
			menuDiretor();
			break;
		case 2:
			Util.customizer();
			menuCadastro();
			break;
		case 0:
			Util.customizer();
			logger.log(Level.INFO, "Sessão encerrada.");
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuDiretor();
		}
	}

	public static void menuPresidente() throws IOException, InterruptedException {

		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo
				[1]\tConsultar informações dos diretores
				[2]\tConsultar total do capital
				[3]\tMenu Cadastro
				[0]\tVoltar
				Digite uma opção:
				""");

		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, String.valueOf(usuariosbanco.buscarInformacoesDeDiretores()));
			menuPresidente();
			break;
		case 2:
			Util.customizer();
			logger.log(Level.INFO, String.valueOf(usuariosbanco.buscarCapital()));
			menuPresidente();
			break;
		case 3:
			Util.customizer();
			menuCadastro();
			break;
		case 0:
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

				[1]\tMenu cliente
				[2]\tConsultar salário
				[3]\tvoltar
				Digite uma opção:
				""");

		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			menuCliente();
			break;
		case 2:
			Util.customizer();
			logger.log(Level.INFO, String.valueOf(usuariosbanco.buscarSalarioFuncionario(clientelogado.getCpf())));
			break;
		case 3:
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
		if (contacliente instanceof ContaPoupanca) {
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
			if (contacliente instanceof ContaPoupanca) {
				ContaPoupanca.simularpoupanca();
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

	public static void setuser(Cliente cliente, Conta conta, Usuarios usuarios) {
		clientelogado = cliente;
		contacliente = conta;
		usuariosbanco = usuarios;
	}
}