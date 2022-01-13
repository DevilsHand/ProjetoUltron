package main.java.engine.terminal;

import java.lang.ProcessBuilder;

public class Cmder {
	private Process process;
	private final String PATH;
	public Cmder(String path) {
		PATH = path;
		try {
			process = new ProcessBuilder(PATH, "/start ", "C:\\Users\\gabriel.araujo\\Desktop").start();
			
		} catch  (Exception e) {
			System.out.println(e);
		}
	}
}
