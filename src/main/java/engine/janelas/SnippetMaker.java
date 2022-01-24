package engine.janelas;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JPanel;

import engine.scriptmakers.SnippetWriter;
import engine.janelas.uiElement.ButtonElement;
import engine.janelas.uiElement.FileSelect;
import engine.janelas.uiElement.Leitor;

public class SnippetMaker extends JPanel implements Leitor {
	private final static SnippetWriter snippetWriter = new SnippetWriter();
	private final FileSelect fileSelector = new FileSelect(this);
	private static File cucumberFile;
	private final ButtonElement botao = new ButtonElement(" Testa Snippet ",this, "makeSnippet");
	
	public SnippetMaker() {
		add(fileSelector);
		add(botao);
		
	}

	public void setCucumberFile() {
		cucumberFile = fileSelector.getSelectedFile();
		remove(fileSelector);
		updateUI();
		setSize(new Dimension(400, 280));
	}
	public static void createSnippetByFile() {
		snippetWriter.createSnippetByFile(cucumberFile);
	}

}
