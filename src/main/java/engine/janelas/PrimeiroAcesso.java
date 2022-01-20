package engine.janelas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static engine.janelas.JanelaPrincipal.CONFIG;

import engine.janelas.uiElement.Leitor;


public class PrimeiroAcesso  extends JPanel implements Leitor {
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxBotoes = new JPanel();
	private final JPanel boxBotoesII = new JPanel();
	private final JPanel boxRodape = new JPanel();
	private final JLabel titulo = new JLabel("Bem Vindo, escolha uma opção abaixo");
	
	private static  final Entradas inBranch = new Entradas("Nome da Branch: ");
	private static final Entradas inPath = new Entradas("Caminho do Projeto: ");
	
	
	public PrimeiroAcesso() {
		menuConfiguration();
	}
	
	
	private void menuConfiguration() {
		JLabel infoI = new JLabel("- Configuração inicial - ");
		JLabel infoII = new JLabel("- Insira as Informações abaixo - ");
		
		JButton botao = new JButton("Confirmar");
		
		botao.addActionListener(this);
		botao.setActionCommand("Config");
		boxTitulo.add(titulo);
		boxTitulo.add(infoI);
		boxTitulo.add(infoII);
		boxBotoes.add(inBranch.labelFor());
		boxBotoes.add(inBranch);
		boxBotoesII.add(inPath.labelFor());
		boxBotoesII.add(inPath);
		boxRodape.add(botao);
		add(boxTitulo);
		add(boxBotoes);
		add(boxBotoesII);
		add(boxRodape);
	}
	
	public static void setConfiguration() {
		CONFIG.criarConfig(inBranch.getText(), inPath.getText());
	}
}
