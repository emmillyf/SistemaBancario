package br.com.poo.g3;

import br.com.poo.g3.controller.AutenticacaoController;
import br.com.poo.g3.entities.Cliente;
import br.com.poo.g3.entities.Usuarios;
import br.com.poo.g3.enums.TipoPessoa;
import br.com.poo.g3.io.RelatorioIO;
import br.com.poo.g3.services.MenuService;
import br.com.poo.g3.util.Util;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrupoApplication {
    static Logger logger = Util.setupLogger();
    public static Scanner sc = new Scanner(System.in);
    static MenuService menuService = new MenuService();
    static AutenticacaoController autenticacaoController = new AutenticacaoController();

    public static void main(String[] args) throws IOException, InterruptedException {
    	Util.customizer();
    	logger.log(Level.INFO,
        		
        		"""
██████   █████  ███    ██  ██████  ██████      ███████ ███████ ██████  ██████   █████  ████████ ███████  ██████ 
██   ██ ██   ██ ████   ██ ██      ██    ██     ██      ██      ██   ██ ██   ██ ██   ██    ██    ██      ██      
██████  ███████ ██ ██  ██ ██      ██    ██     ███████ █████   ██████  ██████  ███████    ██    █████   ██      
██   ██ ██   ██ ██  ██ ██ ██      ██    ██          ██ ██      ██   ██ ██   ██ ██   ██    ██    ██      ██      
██████  ██   ██ ██   ████  ██████  ██████      ███████ ███████ ██   ██ ██   ██ ██   ██    ██    ███████  ██████ 
                                                                                                                                                                                                                         
                                                                                                                                                                             
 """);
    	Usuarios usuarios = RelatorioIO.leitor("banco");
        menuInicial(usuarios);
    }

    public static void menuInicial(Usuarios usuarios) throws IOException, InterruptedException {
    	
    	
        Util.customizer();
        logger.log(Level.INFO, """
                Menu interativo:
                [1]\tLogin
                [2]\tSair
                Digite uma opção:
                """);

        int key = sc.nextInt();

        switch (key) {
            case 1:
                Util.customizer();
                menuLogin(usuarios);
                break;
            case 2:
                Util.customizer();
                logger.log(Level.INFO, "Sessão encerrada!");
                break;
            default:
                logger.log(Level.INFO, "Opção inválida");
                menuInicial(usuarios);
        }
    }

    public static void menuLogin(Usuarios usuarios) throws IOException, InterruptedException {
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
                login(usuarios, TipoPessoa.FUNCIONARIO);
                menuService.menuFuncionario();
                break;
            case 2:
                Util.customizer();
                login(usuarios, TipoPessoa.GERENTE);
                menuService.menuGerente();
                break;
            case 3:
            	login(usuarios, TipoPessoa.DIRETOR);
                menuService.menuDiretor();
                break;
            case 4:
            	login(usuarios, TipoPessoa.PRESIDENTE);
                menuService.menuPresidente();
                break;
            case 5:
            	login(usuarios, TipoPessoa.CLIENTE);
                menuService.menuCliente();
                break;
            case 6:
                Util.customizer();
                logger.log(Level.INFO, "Sessão encerrada!");
                break;
            default:
                logger.log(Level.INFO, "Opção inválida");
                menuLogin(usuarios);
        }
    }

    public static void login(Usuarios usuarios, TipoPessoa tipo) {
        try {
           Cliente clientelogado = autenticacaoController.login(usuarios, tipo);
           menuService.setuser(clientelogado, usuarios.buscarConta(clientelogado.getCpf()), usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}