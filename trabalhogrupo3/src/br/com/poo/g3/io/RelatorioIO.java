package br.com.poo.g3.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import br.com.poo.g3.entities.Cliente;
import br.com.poo.g3.entities.Conta;
import br.com.poo.g3.entities.ContaCorrente;
import br.com.poo.g3.entities.ContaPoupanca;
import br.com.poo.g3.entities.Diretor;
import br.com.poo.g3.entities.Funcionario;
import br.com.poo.g3.entities.Gerente;
import br.com.poo.g3.entities.Presidente;
import br.com.poo.g3.entities.Usuarios;
import br.com.poo.g3.enums.TipoConta;
import br.com.poo.g3.enums.TipoPessoa;
import br.com.poo.g3.util.Util;

public class RelatorioIO extends Funcionario {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static Usuarios leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";
		boolean isFinish = true;
		Usuarios usuarios = new Usuarios();
		Map<String, Funcionario> novofuncionario = new HashMap<>();
		Map<String, Gerente> novogerente = new HashMap<>();
		Map<String, Presidente> novopresidente = new HashMap<>();
		Map<String, Diretor> novodiretor = new HashMap<>();
		Map<String, Cliente> novocliente = new HashMap<>();
		Map<String, Conta> novaconta = new HashMap<>();


		while (isFinish) {
			linha = buffRead.readLine();
			if (linha != null) {
				Util.customizer();
				String[] dados = linha.split(";");

				if (dados[0].equalsIgnoreCase(TipoPessoa.GERENTE.name())) {

					Gerente gerente = new Gerente(Integer.parseInt(dados[1]), dados[2], LocalDate.parse(dados[3], dtf),
							dados[4], dados[6], Double.parseDouble(dados[5]), TipoPessoa.GERENTE);

					if ((dados[7].equalsIgnoreCase(TipoConta.CONTA_CORRENTE.name()))) {
						ContaCorrente contaCorrente = new ContaCorrente(Integer.parseInt(dados[8]),
								Double.parseDouble(dados[9]), Integer.parseInt(dados[10]), dados[4]);

						novaconta.put(dados[4], contaCorrente);
					}
					if ((dados[7].equalsIgnoreCase(TipoConta.CONTA_POUPANCA.name()))) {
						ContaPoupanca contaPoupanca = new ContaPoupanca(Integer.parseInt(dados[8]),
								Double.parseDouble(dados[9]), Integer.parseInt(dados[10]), dados[4]);
						novaconta.put(dados[4], contaPoupanca);

					}

					novogerente.put(dados[4], gerente);


				} else if (dados[0].equalsIgnoreCase(TipoPessoa.DIRETOR.name())) {
		
					Diretor diretor = new Diretor(Integer.parseInt(dados[1]), dados[2], LocalDate.parse(dados[3], dtf),
							dados[4], dados[6], Double.parseDouble(dados[5]), TipoPessoa.DIRETOR);

					if ((dados[7].equalsIgnoreCase(TipoConta.CONTA_CORRENTE.name()))) {
						ContaCorrente contaCorrente = new ContaCorrente(Integer.parseInt(dados[8]),
								Double.parseDouble(dados[9]), Integer.parseInt(dados[10]), dados[4]);
						
						novaconta.put(dados[4], contaCorrente);
					}
					if ((dados[7].equalsIgnoreCase(TipoConta.CONTA_POUPANCA.name()))) {
						ContaPoupanca contaPoupanca = new ContaPoupanca(Integer.parseInt(dados[8]),
								Double.parseDouble(dados[9]), Integer.parseInt(dados[10]), dados[4]);

						novaconta.put(dados[4], contaPoupanca);

					}
					novodiretor.put(dados[4], diretor);


				} else if (dados[0].equalsIgnoreCase(TipoPessoa.PRESIDENTE.name())) {
				
					Presidente presidente = new Presidente(Integer.parseInt(dados[1]), dados[2],
							LocalDate.parse(dados[3], dtf), dados[4], dados[6], Double.parseDouble(dados[5]),
							TipoPessoa.PRESIDENTE);

					if ((dados[7].equalsIgnoreCase(TipoConta.CONTA_CORRENTE.name()))) {
						ContaCorrente contaCorrente = new ContaCorrente(Integer.parseInt(dados[8]),
								Double.parseDouble(dados[9]), Integer.parseInt(dados[10]), dados[4]);

						novaconta.put(dados[4], contaCorrente);
					}
					if ((dados[7].equalsIgnoreCase(TipoConta.CONTA_POUPANCA.name()))) {
						ContaPoupanca contaPoupanca = new ContaPoupanca(Integer.parseInt(dados[8]),
								Double.parseDouble(dados[9]), Integer.parseInt(dados[10]), dados[4]);
						novaconta.put(dados[4], contaPoupanca);

					}
					novopresidente.put(dados[4], presidente);
				} else if (dados[0].equalsIgnoreCase(TipoPessoa.FUNCIONARIO.name())) {
				
					Funcionario funcionario = new Funcionario(Integer.parseInt(dados[1]), dados[2],
							LocalDate.parse(dados[3], dtf), dados[4], dados[6], Double.parseDouble(dados[5]),
							TipoPessoa.FUNCIONARIO);

					novofuncionario.put(dados[4], funcionario);


				} else if (dados[0].equalsIgnoreCase(TipoPessoa.CLIENTE.name())) {
					
					Cliente cliente = new Cliente(Integer.parseInt(dados[1]), dados[2], LocalDate.parse(dados[3], dtf),
							dados[4], dados[5]);

					if ((dados[6].equalsIgnoreCase(TipoConta.CONTA_CORRENTE.name()))) {
						ContaCorrente contaCorrente = new ContaCorrente(Integer.parseInt(dados[7]),
								Double.parseDouble(dados[8]), Integer.parseInt(dados[9]), dados[4]);
						novaconta.put(dados[4], contaCorrente);
					}
					if ((dados[6].equalsIgnoreCase(TipoConta.CONTA_POUPANCA.name()))) {
						ContaPoupanca contaPoupanca = new ContaPoupanca(Integer.parseInt(dados[7]),
								Double.parseDouble(dados[8]), Integer.parseInt(dados[9]), dados[4]);
						novaconta.put(dados[4], contaPoupanca);

					}
					novocliente.put(dados[4], cliente);

				}
			} else {
				usuarios.setClientes(novocliente);
				usuarios.setDiretores(novodiretor);
				usuarios.setFuncionarios(novofuncionario);
				usuarios.setPresidente(novopresidente);
				usuarios.setGerentes(novogerente);
				usuarios.setContas(novaconta);

				isFinish = false;
				break;
			}
		}
		buffRead.close();
		return usuarios;
	}
}
