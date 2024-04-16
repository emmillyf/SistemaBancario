package br.com.poo.g3.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.entities.Diretor;
import br.com.poo.g3.services.DiretorService;
import br.com.poo.g3.util.Util;

public class DiretorController {

	DiretorService diretorService = new DiretorService();
	static Logger logger = Util.setupLogger();

	public void listarDiretores() throws IOException {
		List<Diretor> diretor = diretorService.listaDiretores();
		Util.customizer();
		logger.log(Level.INFO, () -> diretor + "\nLista gerada com sucesso!");
	}
}