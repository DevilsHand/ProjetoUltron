package engine.scriptmakers;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class SnippetWriter {
	private final File output = new File("./output/GenericSnippet.java");
	
	private List<String> create;
	
	public SnippetWriter() {
		create = new ArrayList<String>();
		create.add("package //insira o pacote");
		create.add("\n");
		create.add("public class GenericSteps {");
		
	}
	
	public void createSnippetByFile(File file) {
		CucumberReader reader = new CucumberReader(file);
		try {
			reader.readFile();
			
		} catch (Exception e) {
			System.out.println("Deu ruim no reader");
			e.printStackTrace();
		}
	}
	public void makeGiven(String stepName) {
		create.add(String.format("\t@Given(\"%s\")", stepName));
		create.add(String.format("\tpublic void %s() {", stepName.replace(' ', '_')));
		create.add("\t//insira aqui os comandos que executam esse passo");
		create.add("\t}");
	}
	
	public void print() {
		System.out.println(create);
		try {
			Files.write(output.toPath(), create, StandardCharsets.UTF_8);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	private class CucumberReader {
		private final File file;
		private Dictionary<String, String> text;
		public CucumberReader(File file) {
			this.file = file;
		}
		public void readFile() throws FileNotFoundException {
			text = new Hashtable<String, String>();
			Scanner sc = new Scanner(file);				
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] comparador = {"Given", "When", "Then"};
				for (int i = 0; i < 3; i++) {
					if (line.contains(comparador[i])) {
						String stringTratada = line.replace(comparador[i],"");
						//TODO cuidar de acentos
						text.put(comparador[i], stringTratada);
						}
					}
				}
			System.out.println(text);
			}
		}
}
