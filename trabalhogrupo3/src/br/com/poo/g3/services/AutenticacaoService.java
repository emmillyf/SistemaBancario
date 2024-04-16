package br.com.poo.g3.services;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.entities.Cliente;
import br.com.poo.g3.entities.Funcionario;
import br.com.poo.g3.util.Util;


public class AutenticacaoService {
	static Scanner sc = new Scanner(System.in);
	static Logger logger = Util.setupLogger();
	
	public Cliente credenciais() {
		Util.customizer();
		logger.log(Level.INFO, "Digite seu nome: ");
		String nome  = sc.nextLine();
		logger.log(Level.INFO, "Digite sua senha: ");
		String senha = sc.nextLine();
		return login(nome, senha);
	}
	public Cliente login(String nome, String senha) {
		for(Cliente cliente : Cliente.getMapaClientes().values()) {
			if(cliente.getNome().equals(nome) && cliente.getSenha().equals(senha)) {
				return cliente;
				
			}
		}
		return null;
	}
}

