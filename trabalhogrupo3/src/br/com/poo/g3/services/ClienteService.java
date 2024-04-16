package br.com.poo.g3.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.poo.g3.entities.Cliente;

public class ClienteService {

	public List<Cliente> listaClientes() throws IOException {
		List<Cliente> listaClientes = new ArrayList<>();
		for (Cliente cliente : Cliente.getMapaClientes().values()) {
			listaClientes.add(cliente);
		}
		return listaClientes;
	}

}
