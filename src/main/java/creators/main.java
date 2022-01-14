package creators;

import java.io.PrintStream;
import java.util.Scanner;

import scriptmakers.ScriptObj;

public class main {
	private static ScriptObj run = new ScriptObj();
	private static Scanner seletor = new Scanner(System.in);
	private static PrintStream stream = System.out;
	public static void main(String[] args) {
		stream.println("Selecione uma opção:/n[1]Nome/n[2]Pull");
		String option = seletor.nextLine();
		menuTemporario(option);
	}
	private static void menuTemporario(String opt) {
		switch (opt) {
		case "1":
			stream.print("Escreva o nome: ");
			String nome = seletor.nextLine();
			run.exemploEscreverNome(nome);
			break;
		case "2":
			stream.print("Escreva o nome da Branch: ");
			String branch = seletor.nextLine();
			stream.print("Escreva o nome do commit: ");
			String commit = seletor.nextLine();
			run.comandoPull(branch, commit);
			run.executar();
			break;			
		}
		
	}

}
