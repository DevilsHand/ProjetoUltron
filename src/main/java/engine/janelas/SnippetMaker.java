package engine.janelas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.scriptmakers.FeatureWriter;
import engine.scriptmakers.SnippetWriter;
import engine.janelas.uiElement.ButtonElement;
import engine.janelas.uiElement.FileSelect;
import engine.janelas.uiElement.Leitor;

public class SnippetMaker extends JPanel implements Leitor {
	private final SnippetWriter snippetWriter = new SnippetWriter();
	private final FileSelect fileSelector = new FileSelect(this);
	private EscritorFeature escritor = new EscritorFeature();
	private JanelaPrincipal janela;
	private File cucumberFile;
	private JPanel boxTitulo = new JPanel();
	private JPanel boxBotoes = new JPanel();
	private JPanel boxRodape = new JPanel(); 
	private final ButtonElement lerFeature = new ButtonElement("Criar Snippets",this, "readFeature");
	private final ButtonElement makeSnippets = new ButtonElement("Criar", this, "makeSnippet");
	private final ButtonElement voltar = new ButtonElement(" Voltar ", this, "voltar");
	private final ButtonElement criarFeature = new ButtonElement("Escrever Feature", this, "makeFeature");
	
	public SnippetMaker(JanelaPrincipal janela) {
		this.janela = janela; 
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		boxTitulo.add(new JLabel("Bem vindo ao Auxiliar de Cucumber\n Escolha uma das opções.\n"));
		add(boxTitulo);
		inicio();
	}
	
	public void inicio() {
		boxBotoes.add(criarFeature);
		boxBotoes.add(lerFeature);
		boxRodape.add(voltar);
		add(boxBotoes);
		add(boxRodape);
		updateUI();
	}
	
	public void searchFeature() {
		limpar();
		boxBotoes.add(fileSelector);
		boxBotoes.add(makeSnippets);
		janela.pack();
		updateUI();

	}
	

	public void setCucumberFile() {
		cucumberFile = fileSelector.getSelectedFile();
		remove(fileSelector);
		updateUI();
		setSize(new Dimension(400, 280));
		janela.pack();
		updateUI();
	}
	
	private void limpar() {
		voltar.setActionCommand("retornar");
		boxBotoes.remove(criarFeature);
		boxBotoes.remove(lerFeature);
		boxBotoes.remove(escritor.entradas());//
		updateUI();
	}
	
	private void createFeature() {
		limpar();
		
		ButtonElement button = new ButtonElement("Make Feature", this, "writeFeature");
		boxBotoes.add(escritor.entradas());
		boxBotoes.add(button);
		updateUI();		
	}
	
	public void createSnippetByFile() {
		snippetWriter.createSnippetByFile(cucumberFile);
		snippetWriter.writeFile();
		System.out.println("Executado");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "makeSnippet":
			createSnippetByFile();
			break;
		case "readFeature":
			searchFeature();
			break;
		case "makeFeature":
			createFeature();
			break;
		case "writeFeature":
			limpar();
			FeatureWriter w = new FeatureWriter(escritor);
			w.escreverFeature();
			boxBotoes.add(new JLabel("Executado"));
			break;
		case "retornar":
			inicio();
			break;
		case "voltar":
			janela.inicio();
			break;
		}
	}
	
	
	

}
