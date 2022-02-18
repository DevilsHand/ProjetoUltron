package engine.scriptmakers;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import engine.janelas.EscritorFeature;

public class FeatureWriter {
	private static final File output = new File("./output/GenericFeature.feature");
	private List<String> create;
	private EscritorFeature escritor;
	public FeatureWriter(EscritorFeature escritor) {
		this.escritor = escritor;
		create = new ArrayList<String>();
	}
	
	public void escreverFeature() {
		create.add("#language: en");
		create.add("Feature: "+escritor.getFeatureText());
		create.add("\tScenario: "+escritor.getSceenarioText());
		create.add("\t\tGiven: "+escritor.getGivenText());
		create.add("\t\tWhen: "+escritor.getWhenText());
		create.add("\t\tThen: "+escritor.getThenText());
		writeFile();
	}
	public void writeFile() {
		try {
			Files.write(output.toPath(), create, StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
