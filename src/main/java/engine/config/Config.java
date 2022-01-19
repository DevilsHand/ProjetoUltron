package engine.config;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Config {
	
	private  Dictionary<String, String> options = new Hashtable<String, String>();
	private static File config = new File("./src/main/java/engine/config/options.opt");
	public boolean isLive;
	
	public Config() {
		if (config.exists()) {
			try {
				readConfig();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} else { isLive = false; }
	}
	
	public void criarConfig(String branch, String path) {
		List<String> option = new ArrayList<String>();
		option.add(branch);
		option.add(path.replaceAll("\\\\", Matcher.quoteReplacement("\\\\")));
		config.delete();
		try {
			config.createNewFile();
			Files.write(config.toPath(), option, StandardCharsets.UTF_8);
			readConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void readConfig() throws IOException {
		Scanner sc = new Scanner(config);
		List<String> lista = new ArrayList<String>();
		while ( sc.hasNextLine()) {
			lista.add(sc.nextLine());
		}
		options.put("branch", lista.get(0));
		options.put("path", lista.get(1));
		isLive = true;
	}
	
	public void setOption(String option, String valor) { //TODO otimizar
		List<String> lista = new ArrayList<String>();
		options.put(option,valor);
		lista.add(options.get("branch"));
		lista.add(options.get("path"));
		try {
			Files.write(config.toPath(), lista, StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
	public String getOption(String option) {
		return options.get(option);
		
	}
	
	
	
}
