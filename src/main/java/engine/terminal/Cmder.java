package engine.terminal;

import java.lang.ProcessBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cmder {
	private static Process process;
	private final static String PATH = "./utils/cmder/vendor/git-for-windows/git-bash.exe";
	
	public static List<String> executarSh(String script) {
		try {
			process = new ProcessBuilder(PATH, script).start();
			Scanner sc = new Scanner(process.getInputStream());
			List<String> leitor = new ArrayList<String>();
			while (sc.hasNextLine()) {
				leitor.add(sc.nextLine());
			}
			sc.close();
			return leitor;
			
		} catch  (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}
	
}
