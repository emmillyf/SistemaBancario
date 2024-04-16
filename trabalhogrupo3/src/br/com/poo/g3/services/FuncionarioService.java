package br.com.poo.g3.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.poo.g3.entities.Funcionario;

public class FuncionarioService {

	public List<Funcionario> listaFuncionarios() throws IOException {
		List<Funcionario> listaFuncionarios = new ArrayList<>();
		for (Funcionario funcionarios : Funcionario.getMapaFuncionarios().values()) {
			listaFuncionarios.add(funcionarios);
		}
		return listaFuncionarios;
	}
}