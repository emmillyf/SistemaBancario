package br.com.poo.g3;

import java.io.IOException;
import java.util.Scanner;

import br.com.poo.g3.controller.AutenticacaoController;
import br.com.poo.g3.io.RelatorioIO;
import br.com.poo.g3.services.*;
public class GrupoApplication {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {

		AutenticacaoController autenticacaoController = new AutenticacaoController();
		
		try {
			RelatorioIO.leitor("banco");
			autenticacaoController.login();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
