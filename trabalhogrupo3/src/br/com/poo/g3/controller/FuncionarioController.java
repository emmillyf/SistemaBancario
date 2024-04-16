package br.com.poo.g3.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.entities.Funcionario;
import br.com.poo.g3.services.FuncionarioService;
import br.com.poo.g3.util.Util;

public class FuncionarioController {

	FuncionarioService funcionarioService = new FuncionarioService();
	static Logger logger = Util.setupLogger();

	public void listarFuncionarios() throws IOException {
		List<Funcionario> funcionario = funcionarioService.listaFuncionarios();
		Util.customizer();
		logger.log(Level.INFO, () -> funcionario + "\nLista gerada com sucesso!");
	}
}