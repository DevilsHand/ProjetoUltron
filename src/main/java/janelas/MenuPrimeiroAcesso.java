package janelas;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scriptmakers.ScriptObj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MenuPrimeiroAcesso extends JPanel implements ActionListener {
	private final JanelaPrincipal CONTROLADOR;
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxBotoes = new JPanel();
	private final JLabel titulo = new JLabel("Bem Vindo, escolha uma op��o abaixo");
	private final JButton btnPull = new JButton(" Pull ");
	private final JButton btnPush = new JButton(" Push ");
	private final JButton btnCommit = new JButton(" Commit ");
	private final JButton btnMudarBranch = new JButton(" Mudar Branch ");
	
	public MenuPrimeiroAcesso(JanelaPrincipal janela) {
			CONTROLADOR = janela;
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			//torna os bot�es responsivos
			btnCommit.addActionListener(this);
			btnPull.addActionListener(this);
			btnPush.addActionListener(this);
			btnMudarBranch.addActionListener(this);
			//comandos para os bot�es
			btnCommit.setActionCommand("Commit");
			btnPull.setActionCommand("N�o Add");
			btnPush.setActionCommand("N�o Add");//TODO implementar
			btnMudarBranch.setActionCommand("N�o Add");//TODO implementar
			
			boxTitulo.add(titulo);
			boxBotoes.add(btnPull);
			boxBotoes.add(btnPush);
			boxBotoes.add(btnMudarBranch);
			boxBotoes.add(btnCommit);
			add(boxTitulo);
			add(boxBotoes);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Commit":
			ScriptObj script = new ScriptObj();
			script.comandoCommit("Commit automatizado");
			script.executar();
			break;
		case "N�o Add":
			JLabel msgErro = new JLabel("Fun��o ainda n�o adicionada");
			boxTitulo.add(msgErro);
			updateUI();
			break;		
			
		}
		
		
		
	}
	
	

}
