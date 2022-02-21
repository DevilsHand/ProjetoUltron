package engine.janelas;

import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.janelas.uiElement.Entradas;
import engine.janelas.uiElement.Leitor;
import engine.janelas.uiElement.ButtonElement;

public class GitClone extends JPanel implements Leitor {
	private JPanel boxTitulo = new JPanel();
	private JPanel boxBotoes = new JPanel();
	private JPanel boxBotoesII = new JPanel();
	private JPanel boxRodape = new JPanel();
	private JLabel labelTitulo = new JLabel("Informe os dados do projeto");
	private ButtonElement btnEnviar = new ButtonElement("Enviar", this, "enviarGitClone");
	private static Entradas origin = new Entradas("SSH ou HTML do clone: ");
	private static Entradas path = new Entradas("Caminho do Projeto: ");
	
	public GitClone() {
		inicio();
	}
	private void inicio() {	
		boxTitulo.add(labelTitulo);
		boxBotoes.add(origin.labelFor());
		boxBotoes.add(origin);
		boxBotoesII.add(path.labelFor());
		boxBotoesII.add(path);
		boxRodape.add(btnEnviar);
		add(boxTitulo);
		add(boxBotoes);
		add(boxBotoesII);
		add(boxRodape);
		update(getGraphics());
	}
	
	public static String getClone() {
		return origin.getText();
	}
	public static String getPath() {
		return path.getText();
	}
	
	
}
