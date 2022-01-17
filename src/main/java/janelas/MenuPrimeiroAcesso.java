package janelas;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrimeiroAcesso extends JPanel implements ActionListener {
	private final JanelaPrincipal CONTROLADOR;
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxBotoes = new JPanel();
	private final JLabel titulo = new JLabel("Bem Vindo, escolha uma opção abaixo");
	private final JButton btnGitHelper = new JButton(" Git Helper ");
	private final JButton btnSnippetMaker = new JButton(" Snippet Maker ");
	
	public MenuPrimeiroAcesso(JanelaPrincipal janela) {
			CONTROLADOR = janela;
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			//torna os botões responsivos
			btnGitHelper.addActionListener(this);
			btnSnippetMaker.addActionListener(this);
			//Action command
			btnGitHelper.setActionCommand("GitHelper");
			btnSnippetMaker.setActionCommand("Snippets");
			
			boxBotoes.add(btnGitHelper);
			boxBotoes.add(btnSnippetMaker);
			boxTitulo.add(titulo);
			
			add(boxTitulo);
			add(boxBotoes);
			
			
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "GitHelper":
			CONTROLADOR.gitHelper();
			break;
		default :
			JLabel msgErro = new JLabel("Função ainda não adicionada");
			boxTitulo.add(msgErro);
			updateUI();
			break;		
			
		}
		
		
		
	}
	
	

}
