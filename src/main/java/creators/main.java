package creators;

import java.util.Scanner;

import scriptmakers.ScriptObj;

public class main {

	public static void main(String[] args) {
		ScriptObj run = new ScriptObj();
		System.out.println("Escreva seu nome: ");
		String nome = new Scanner(System.in).nextLine();
		
		run.exemploEscreverNome(nome);
	}

}
