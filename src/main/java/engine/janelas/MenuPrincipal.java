package engine.janelas;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.janelas.JanelaPrincipal.NomeBranch;
import engine.janelas.uiElement.ButtonElement;
import engine.janelas.uiElement.Leitor;

public class MenuPrincipal extends JPanel implements Leitor {
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxBotoes = new JPanel();
	private final JPanel boxRodape = new JPanel();
	private final JPanel nomeBranch;
	private final JLabel titulo = new JLabel("Bem Vindo, escolha uma opção abaixo");
	private final ButtonElement btnGitHelper = new ButtonElement(" Git Helper ", this, "gitHelper");
	private final ButtonElement btnSnippetMaker = new ButtonElement(" Snippet Helper ", this, "snippets");
	private final ButtonElement btnAjuda = new ButtonElement(" Ajuda ", this, "ajuda");
	
	public MenuPrincipal(NomeBranch bn) {
			nomeBranch = bn.getNomeBranch();
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			startUp();
	}
	
	private void startUp() {
			
		boxBotoes.add(btnGitHelper);
		boxBotoes.add(btnSnippetMaker);
		boxTitulo.add(titulo);
		boxRodape.add(btnAjuda);
		
		add(boxTitulo);
		add(boxBotoes);
		add(boxRodape);
		add(nomeBranch);
		updateUI();
	}
}
