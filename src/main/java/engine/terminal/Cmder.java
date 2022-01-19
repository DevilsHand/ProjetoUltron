package engine.terminal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder;
import java.util.ArrayList;
import java.util.List;

public class Cmder {
	private static Process process;
	private final static String PATH = "./utils/cmder/vendor/git-for-windows/git-bash.exe";
	
	public static List<String> executarSh(String script) {
		try {
			process = new ProcessBuilder(PATH, script).start();
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			List<String> leitor = new ArrayList<String>();
			while (br.readLine() != null) {
				leitor.add(br.readLine());
			}
			return leitor;
			
		} catch  (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}
	
}
