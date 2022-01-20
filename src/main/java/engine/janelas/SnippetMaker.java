package engine.janelas;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.scriptmakers.SnippetWriter;

import engine.janelas.uiElement.Leitor;

public class SnippetMaker extends JPanel implements Leitor {
	private final SnippetWriter snippetWriter = new SnippetWriter();
	
	private final JButton botao = new JButton(" Testa Snippet ");
	
	public SnippetMaker() {
		botao.addActionListener(this);
		botao.setActionCommand("Snippet");
		
		add(botao);		
	}
	

}
