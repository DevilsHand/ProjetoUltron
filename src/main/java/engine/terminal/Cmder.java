package engine.terminal;

import java.lang.ProcessBuilder;

public class Cmder {
	private Process process;
	private final String PATH;
	private final String PROJECTPATH = "cd C:\\Projects";
	private final String scripts = "./src/main/java/scripts/openCMD.sh";
	public Cmder(String path) {
		PATH = path;
		try {
			process = new ProcessBuilder(PATH, scripts).start();
			
		} catch  (Exception e) {
			System.out.println(e);
		}
	}
}
