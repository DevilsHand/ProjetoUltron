package engine.janelas;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.scriptmakers.ScriptObj;


import engine.janelas.JanelaPrincipal.NomeBranch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GitHelper extends JPanel implements ActionListener {
	private final JanelaPrincipal MENU;
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxBotoes = new JPanel();
	private final JPanel nomeBranch;
	private final JLabel titulo = new JLabel("- Git Helper -");
	private final JButton btnPull = new JButton(" Pull ");
	private final JButton btnPush = new JButton(" Push ");
	private final JButton btnCommit = new JButton(" Commit ");
	private final JButton btnMudarBranch = new JButton(" Mudar Branch ");
	private final JButton btnStatus = new JButton(" Status ");
	private final JButton btnVoltar = new JButton(" Voltar ");
	
	public GitHelper(JanelaPrincipal janela, NomeBranch nb) {
			MENU = janela;
			nomeBranch = nb.getNomeBranch();
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			startUp();
	}
	private void startUp() {
		btnVoltar.addActionListener(this);
		btnCommit.addActionListener(this);
		btnPull.addActionListener(this);
		btnPush.addActionListener(this);
		btnMudarBranch.addActionListener(this);
		btnStatus.addActionListener(this);
		//comandos para os botões
		btnVoltar.setActionCommand("Voltar");
		btnCommit.setActionCommand("Commit");
		btnPull.setActionCommand("Pull");
		btnPush.setActionCommand("Push");
		btnMudarBranch.setActionCommand("MudarBranch");//TODO implementar
		btnStatus.setActionCommand("Status");
		
		boxTitulo.add(titulo);
		boxBotoes.add(btnStatus);
		boxBotoes.add(btnPull);
		boxBotoes.add(btnPush);
		/*boxBotoes.add(btnMudarBranch);*/
		boxBotoes.add(btnCommit);
		boxBotoes.add(btnVoltar);
		add(boxTitulo);
		add(boxBotoes);
		add(nomeBranch);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		ScriptObj script = new ScriptObj();
		switch (e.getActionCommand()) {
		
		case "Commit":
			script.comandoCommit("Commit automatizado");
			script.executar();
			break;
		case "Pull":
			script.comandoPull("Pull Automatizado");
			script.executar();
			break;
		case "Push":
			script.comandoPush("Push Automatizado");
			script.executar();
			break;
		case "Status":
			script.commandoStatus();
			script.executar();
			break;
		case "Voltar":
			MENU.inicio();
			break;
			
		}
		
		
		
	}
	
	

}
