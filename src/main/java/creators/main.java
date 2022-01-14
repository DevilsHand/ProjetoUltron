package creators;

import java.io.PrintStream;
import java.util.Scanner;

import janelas.JanelaPrincipal;
import scriptmakers.ScriptObj;

public class main {
	private static ScriptObj run = new ScriptObj();
	private static Scanner seletor = new Scanner(System.in);
	private static PrintStream stream = System.out;
	private static JanelaPrincipal janela;
	public static void main(String[] args) {
		janela = new JanelaPrincipal();
		janela.menuPrimeiroAcesso();
		
	}
	

}
