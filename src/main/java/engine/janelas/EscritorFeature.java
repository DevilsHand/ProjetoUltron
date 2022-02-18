package engine.janelas;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import engine.janelas.uiElement.Entradas;

public class EscritorFeature {
	private Entradas featureText = new Entradas("Feature:");
	private Entradas scenarioText = new Entradas("Scenario:");
	private Entradas givenText = new Entradas("Given:");
	private Entradas whenText = new Entradas("When:");
	private Entradas thenText = new Entradas("Then:");
	
	public JPanel entradas() {
		JPanel label = new JPanel();
		label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
		label.add(featureText.pannelFor());
		label.add(scenarioText.pannelFor());
		label.add(givenText.pannelFor());
		label.add(whenText.pannelFor());
		label.add(thenText.pannelFor());
		return label;
	}
	
	public String getGivenText() {
		return givenText.getText();
	}
	
	public String getWhenText() {
		return whenText.getText();
	}
	
	public String getThenText() {
		return thenText.getText();
	}
	
	public String getFeatureText() {
		return featureText.getText();
	}
	
	public String getSceenarioText() {
		return scenarioText.getText();
	}
}
