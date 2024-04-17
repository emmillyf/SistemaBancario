package br.com.poo.g3.services;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.entities.Cliente;
import br.com.poo.g3.entities.Diretor;
import br.com.poo.g3.entities.Funcionario;
import br.com.poo.g3.entities.Gerente;
import br.com.poo.g3.entities.Presidente;
import br.com.poo.g3.entities.Usuarios;
import br.com.poo.g3.enums.TipoPessoa;
import br.com.poo.g3.util.Util;

public class AutenticacaoService {
	static Scanner sc = new Scanner(System.in);
	static Logger logger = Util.setupLogger();
	Usuarios users = new Usuarios();

	public Cliente credenciais(Usuarios usuarios, TipoPessoa tipo) {
		users = usuarios;
		Util.customizer();
		logger.log(Level.INFO, "Digite seu cpf: ");
		String nome = sc.nextLine();
		logger.log(Level.INFO, "Digite sua senha: ");
		String senha = sc.nextLine();
		switch (tipo){
			case DIRETOR -> {
				return loginDiretor(nome, senha);
			}
			case PRESIDENTE -> {
				return loginPresidente(nome, senha);
			}
			case GERENTE -> {
			return loginGerente(nome, senha);
			}
			
			case FUNCIONARIO -> {
				return loginFuncionario(nome, senha);
			}
		}
		return login(nome, senha);
	}

	public Cliente login(String cpf, String senha) {
		// System.out.println(Cliente.getMapaClientes());
		for (Cliente cliente : users.getClientes().values()) {
			if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
				return cliente;
			}
		}
		return null;
	}

	public Funcionario loginFuncionario(String cpf, String senha) {
		// System.out.println(Cliente.getMapaClientes());
		for (Funcionario funcionario : users.getFuncionarios().values()) {
			if (funcionario.getCpf().equals(cpf) && funcionario.getSenha().equals(senha)) {
				return funcionario;
			}
		}
		return null;
	}
	public Presidente loginPresidente(String cpf, String senha) {
		// System.out.println(Cliente.getMapaClientes());
		for (Presidente presidente : users.getPresidente().values()) {
			if (presidente.getCpf().equals(cpf) && presidente.getSenha().equals(senha)) {
				return presidente;
			}
		}
		return null;
}
	public Gerente loginGerente(String cpf, String senha) {
		// System.out.println(Cliente.getMapaClientes());
		for (Gerente gerente : users.getGerentes().values()) {
			
			if (gerente.getCpf().equals(cpf) && gerente.getSenha().equals(senha)) {
				
				return gerente;
			}
			
		}
		return null;
	}
	public Diretor loginDiretor(String cpf, String senha) {
		// System.out.println(Cliente.getMapaClientes());
		for (Diretor diretor : users.getDiretores().values()) {
			if (diretor.getCpf().equals(cpf) && diretor.getSenha().equals(senha)) {
				return diretor;
			}
		}
		return null;	
	}
}