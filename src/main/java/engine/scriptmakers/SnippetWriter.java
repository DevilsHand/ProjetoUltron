package engine.scriptmakers;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SnippetWriter {
	private final File output = new File("./output/GenericSnippet.java");
	
	private List<String> create;
	
	public SnippetWriter() {
		create = new ArrayList<String>();
		create.add("package //insira o pacote");
		create.add("\n");
		create.add("public class GenericSteps {");
		
	}
	public void makeGiven(String stepName) {
		create.add(String.format("\t@Given(\"%s\")", stepName));
		create.add(String.format("\tpublic void %s() {", stepName.replace(' ', '_')));
		create.add("\t//insira aqui os comandos que executam esse passo");
		create.add("\t}");
		create.add("}");
	}
	
	public void print() {
		System.out.println(create);
		try {
			Files.write(output.toPath(), create, StandardCharsets.UTF_8);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
