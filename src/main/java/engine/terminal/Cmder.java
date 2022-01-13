package engine.terminal;

import java.lang.ProcessBuilder;

public class Cmder {
	private Process process;
	private final String PATH;
	private final String PROJECTPATH = "cd C:\\Projects";
	public Cmder(String path) {
		PATH = path;
		try {
			process = new ProcessBuilder(PATH, "/start", PROJECTPATH ).start();
			
		} catch  (Exception e) {
			System.out.println(e);
		}
	}
}
