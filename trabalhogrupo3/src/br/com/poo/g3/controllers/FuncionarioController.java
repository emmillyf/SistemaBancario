package br.com.poo.g3.controllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.indiv.services.FuncionarioService;
import br.com.indiv.util.Util;

public class FuncionarioController {
	
	FuncionarioService funcionarioService = new FuncionarioService();
	static Logger logger = Util.setupLogger();

	public void listarNomesFuncionarios() throws IOException {
		List<String> funcionario = funcionarioService.listaNomesFuncionarios();
		Util.customizer();
		logger.log(Level.INFO, () -> funcionario + "\nLista gerada com sucesso!");
	}
}
