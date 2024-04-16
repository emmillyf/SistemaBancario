package br.com.poo.g3.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.poo.g3.entities.Diretor;

public class DiretorService {

	public List<Diretor> listaDiretores() throws IOException {
		List<Diretor> listaDiretores = new ArrayList<>();
		for (Diretor diretores : Diretor.getMapaDiretores().values()) {
			listaDiretores.add(diretores);
		}
		return listaDiretores;
	}
}