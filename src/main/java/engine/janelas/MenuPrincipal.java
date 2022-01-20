package engine.janelas;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.janelas.JanelaPrincipal.NomeBranch;

import engine.janelas.uiElement.Leitor;

public class MenuPrincipal extends JPanel implements Leitor {
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxBotoes = new JPanel();
	private final JPanel boxRodape = new JPanel();
	private final JPanel nomeBranch;
	private final JLabel titulo = new JLabel("Bem Vindo, escolha uma op��o abaixo");
	private final JButton btnGitHelper = new JButton(" Git Helper ");
	private final JButton btnSnippetMaker = new JButton(" Snippet Maker ");
	private final JButton btnAjuda = new JButton(" Ajuda ");
	
	public MenuPrincipal(NomeBranch bn) {
			nomeBranch = bn.getNomeBranch();
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			startUp();
	}
	
	private void startUp() {
		//torna os bot�es responsivos
		btnGitHelper.addActionListener(this);
		btnSnippetMaker.addActionListener(this);
		btnAjuda.addActionListener(this);
		//Action command
		btnGitHelper.setActionCommand("GitHelper");
		btnSnippetMaker.setActionCommand("Snippets");
		btnAjuda.setActionCommand("Ajuda");
		
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
