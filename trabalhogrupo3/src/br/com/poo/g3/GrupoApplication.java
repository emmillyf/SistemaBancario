package br.com.poo.g3;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// import javax.swing.plaf.synth.SynthOptionPaneUI;

import br.com.poo.g3.controller.AutenticacaoController;
import br.com.poo.g3.io.RelatorioIO;
import br.com.poo.g3.services.MenuService;
import br.com.poo.g3.util.Util;

public class GrupoApplication {
	static Logger logger = Util.setupLogger();
	public static Scanner sc = new Scanner(System.in);
	static MenuService menuService = new MenuService();
	static AutenticacaoController autenticacaoController = new AutenticacaoController();

	public static void main(String[] args) throws IOException {

		try {
			RelatorioIO.leitor("banco");
			menuInicial();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void menuInicial() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, """
				Menu interativo:
				[1]\tLogin
				[2]\tCadastro
				[3]\tSair
				Digite uma opção:
				""");

		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			menuLogin();
			break;
		case 2:
			Util.customizer();
			logger.log(Level.INFO, "Cadastrado com sucesso!");
			menuService.menuCadastro();
			break;
		case 3:
			Util.customizer();
			logger.log(Level.INFO, "Sessão encerrada!");
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuInicial();

		}
	}

	public static void menuLogin() throws IOException {
		Util.customizer();
		logger.log(Level.INFO, """
				Menu interativo:
				[1]\tLogar como funcionário
				[2]\tLogar como gerente
				[3]\tLogar como diretor
				[4]\tLogar como presidente
				[5]\tLogar como cliente
				[7]\tSair
				Digite uma opção:
				""");

		int key = sc.nextInt();

		switch (key) {
		case 1:
			Util.customizer();
			login();
			menuService.menuFuncionario();
			break;
		case 2:
			Util.customizer();

			menuService.menuGerente();
			break;
		case 3:
			Util.customizer();
			logger.log(Level.INFO, "Logado com sucesso!");
			menuService.menuDiretor();
			break;
		case 4:
			Util.customizer();
			logger.log(Level.INFO, "Logado com sucesso!");
			menuService.menuPresidente();
			break;
		case 5:
			Util.customizer();
			logger.log(Level.INFO, "Logado com sucesso!");
			menuService.menuCliente();
			break;
		case 6:
			Util.customizer();
			logger.log(Level.INFO, "Sessão encerrada!");
			break;
		default:
			logger.log(Level.INFO, "Opção inválida");
			menuLogin();
		}
	}

	public static void login() {
		try {
			autenticacaoController.login();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}