package br.com.poo.g3.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.entities.Cliente;
import br.com.poo.g3.entities.ContaCorrente;
import br.com.poo.g3.entities.ContaPoupanca;
import br.com.poo.g3.entities.Diretor;
import br.com.poo.g3.entities.Gerente;
import br.com.poo.g3.entities.Usuarios;
import br.com.poo.g3.enums.TipoPessoa;
import br.com.poo.g3.services.AutenticacaoService;
import br.com.poo.g3.services.MenuService;
import br.com.poo.g3.util.Util;

public class AutenticacaoController {
	AutenticacaoService autenticacaoService = new AutenticacaoService();
	static Logger logger = Util.setupLogger();

	public Cliente login(Usuarios usuarios, TipoPessoa tipo) throws IOException, InterruptedException {
		Cliente cliente;
		do {
			cliente = autenticacaoService.credenciais(usuarios, tipo);
			if (cliente != null) {
				Thread.sleep(2000);
				logger.log(Level.INFO, "\n\nLogin realizado com sucesso!");
				Thread.sleep(2000);
			} else {
				Thread.sleep(2000);
				logger.log(Level.INFO, "Login não realizado...");
				Thread.sleep(2000);
			}
		} while (cliente == null);
		return cliente;
	}
	public Cliente cadastrarCliente() throws IOException, InterruptedException {
		return autenticacaoService.cadastrarCliente();
	}
	public ContaPoupanca cadastrarContaPoupanca(String cpf) throws IOException, InterruptedException {
		return autenticacaoService.cadastrarContaPoupanca(cpf);
	}
	public ContaCorrente cadastrarContaCorrente(String cpf) throws IOException, InterruptedException {
		return autenticacaoService.cadastrarContaCorrente(cpf);
	}
	public Gerente cadastrarGerente() throws IOException, InterruptedException {
		return autenticacaoService.cadastrarGerente();
	}
	public Diretor cadastrarDiretor() throws IOException, InterruptedException {
		return autenticacaoService.cadastrarDiretor();
	}
}
