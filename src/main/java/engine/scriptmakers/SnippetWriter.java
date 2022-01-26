package engine.scriptmakers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
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
	public void makeSnippet(String step, String stepName ) {
		create.add(String.format("\t@%s(\"%s\")", step,stepName));
		create.add(String.format("\tpublic void %s() {", stepName.replace(' ', '_')));
		create.add("\t//insira aqui os comandos que executam esse passo\n");
		create.add("\t}");
	}
	
	public void writeFile() {
		try {
			Files.write(output.toPath(), create, StandardCharsets.UTF_8);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private class CucumberReader {
		private final File file;
		private List<String> text;
		public CucumberReader(File file) {
			this.file = file;
		}
		public void readFile() throws IOException {
			text = new ArrayList<String>();
			Scanner sc = new Scanner(file,StandardCharsets.UTF_8);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] comparador = {"Given", "When", "Then", "And"};
				for (int i = 0; i <= 3; i++) {
					if (line.contains(comparador[i])) {
						String stringTratada = line.replace(comparador[i],"");//TODO tratar tabs e acentos
						stringTratada = tratarString(stringTratada);						
						if (text.indexOf(stringTratada) == -1) {
							text.add(stringTratada);
							makeSnippet(comparador[i], stringTratada);
							}
						}
					
					}
				}
			}
		}
	
	private String tratarString(String stringTratada) { // TODO adicionar tratamentos pra acentos
		stringTratada = stringTratada.replace("\t", "");
		stringTratada =  stringTratada.replaceFirst(" ", "");
		//TODO cuidar de acentos
		stringTratada = stringTratada.replace('ח', 'c');
		stringTratada = stringTratada.replace("/[אבגדהו]/", "a");
		return stringTratada;
	}
}
