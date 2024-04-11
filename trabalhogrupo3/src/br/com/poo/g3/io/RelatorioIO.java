package br.com.poo.g3.io;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.entities.ContaCorrente;
import br.com.poo.g3.util.Util;
import br.com.poo.g3.enums.TipoRegistro;

public class RelatorioIO extends ContaCorrente {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	private static Logger logger = Util.setupLogger();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";
		while (true) {
			linha = buffRead.readLine();
			if(linha != null) {
				Util.customizer();
			String[] dados = linha.split(";");

			if (dados[0].equalsIgnoreCase(TipoRegistro.TIPOCONTA.name())) {

				/*
				 * private Integer id; 
				 * private String nome; 
				 * private String funcao; 
				 * private String genero; 
				 * private static DateTimeFormatter DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
				 * private String cpf;
				 * private String telefone; 
				 * private String email; 
				 * private String senha; 
				 * private Float salario;
				 * private String permissao; 
				 * private Integer fkDep;
				 */

				ContaCorrente contaCorrente = new ContaCorrente(Integer.parseInt(dados[1]);
					
				Funcionario.getMapaFuncionarios().put(Integer.parseInt(dados[1]), funcionario);
				
				logger.log(Level.INFO, funcionario::toString);
			} else if (dados[0].equalsIgnoreCase(TipoRegistro.DEPARTAMENTO.name())) {
				
				Departamento departamento = new Departamento(Integer.parseInt(dados[1]),
						dados[2], dados[3], dados[4], dados[5], dados[6]);
				
				Departamento.getMapaDepartamento().put(Integer.parseInt(dados[1]), departamento);
				
				logger.log(Level.INFO, departamento::toString);
			} else {
				break;
			}
		}
			
		}
		buffRead.close();
	}

	public static void escritor(String path) throws IOException {
		Scanner sc = new Scanner(System.in);
		Util.customizer();
		logger.log(Level.INFO, () -> "Escreva o nome do arquivo: ");
		String nome = sc.next();

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		String linha = "";

		Util.customizer();
		logger.log(Level.INFO, () -> "Escreva algo: ");
		Scanner sc1 = new Scanner(System.in);
		linha = sc1.nextLine();
		buffWrite.append(linha + "\n");
		buffWrite.close();
		sc.close();
		sc1.close();

	}
}