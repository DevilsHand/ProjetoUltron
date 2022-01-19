package engine.janelas;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.config.Config;
import engine.janelas.JanelaPrincipal.NomeBranch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuPrincipal extends JPanel implements ActionListener {
	private final JanelaPrincipal CONTROLADOR;
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxBotoes = new JPanel();
	private final JPanel boxRodape = new JPanel();
	private final JPanel nomeBranch;
	private final JLabel titulo = new JLabel("Bem Vindo, escolha uma opção abaixo");
	private final JButton btnGitHelper = new JButton(" Git Helper ");
	private final JButton btnSnippetMaker = new JButton(" Snippet Maker ");
	
	public MenuPrincipal(JanelaPrincipal janela, NomeBranch bn) {
			CONTROLADOR = janela;
			nomeBranch = bn.getNomeBranch();
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			startUp();
	}
	
	private void startUp() {
		//torna os botões responsivos
		btnGitHelper.addActionListener(this);
		btnSnippetMaker.addActionListener(this);
		//Action command
		btnGitHelper.setActionCommand("GitHelper");
		btnSnippetMaker.setActionCommand("Snippets");
		
		boxBotoes.add(btnGitHelper);
		boxBotoes.add(btnSnippetMaker);
		boxTitulo.add(titulo);
		boxRodape.add(nomeBranch);
		
		add(boxTitulo);
		add(boxBotoes);
		add(nomeBranch);
		updateUI();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "GitHelper":
			CONTROLADOR.gitHelper();
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
