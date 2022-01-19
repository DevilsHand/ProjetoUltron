package engine.janelas;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.janelas.JanelaPrincipal.NomeBranch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuPrincipal extends JPanel implements ActionListener {
	private final JanelaPrincipal MENU;
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxBotoes = new JPanel();
	private final JPanel boxRodape = new JPanel();
	private final JPanel nomeBranch;
	private final JLabel titulo = new JLabel("Bem Vindo, escolha uma opção abaixo");
	private final JButton btnGitHelper = new JButton(" Git Helper ");
	private final JButton btnSnippetMaker = new JButton(" Snippet Maker ");
	private final JButton btnAjuda = new JButton(" Ajuda ");
	
	public MenuPrincipal(JanelaPrincipal janela, NomeBranch bn) {
			MENU = janela;
			nomeBranch = bn.getNomeBranch();
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			startUp();
	}
	
	private void startUp() {
		//torna os botões responsivos
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "GitHelper":
			MENU.gitHelper();
			break;
		case "Ajuda":
			MENU.ajuda();
			break;
			
		case "Snippets":
			
			break;
			
		default :
			JLabel msgErro = new JLabel("Função ainda não adicionada");
			boxTitulo.add(msgErro);
			updateUI();
			break;		
			
		}
		
		
		
	}
	
	

}
