package main.java.engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder;

public class Cmder {
	private ProcessBuilder commandLine ;
	private Process process;
	private final String PATH;
	public Cmder(String path) {
		PATH = path;
		commandLine = new ProcessBuilder(PATH, "/start", "C:\\Users\\gabriel.araujo\\Desktop");
		try {
			process = commandLine.start();
			
			while (true) {
				String line = (new BufferedReader(new InputStreamReader(process.getInputStream()))).readLine();
	            if (line == null) { break; }
	            System.out.println(line);
	        }
			
		} catch  (Exception e) {
			System.out.println(e);
		}
	}
}
