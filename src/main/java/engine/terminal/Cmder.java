package engine.terminal;

import java.lang.ProcessBuilder;
import java.util.List;

public class Cmder {
	private static Process process;
	private final static String PATH = "./utils/cmder/vendor/git-for-windows/git-bash.exe";
	
	public static String executarSh(String script) {
		try {
			process = new ProcessBuilder(PATH, script).start();
			return "Executado";
			
		} catch  (Exception e) {
			System.out.println(e);
			return e.getMessage();
		}
	}
	
}
