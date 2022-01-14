package janelas;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MenuPrimeiroAcesso extends JPanel implements ActionListener {
	private final JanelaPrincipal CONTROLADOR;
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxBotoes = new JPanel();
	private final JLabel titulo = new JLabel("Bem Vindo, escolha uma opção abaixo");
	private final JButton btnPull = new JButton(" Pull ");
	private final JButton btnPush = new JButton(" Push ");
	private final JButton btnMudarBranch = new JButton(" Mudar Branch ");
	
	public MenuPrimeiroAcesso(JanelaPrincipal janela) {
			CONTROLADOR = janela;
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));			
			btnPull.addActionListener(this);
			btnPull.setActionCommand("");
			boxTitulo.add(titulo);
			boxBotoes.add(btnPull);
			boxBotoes.add(btnPush);
			boxBotoes.add(btnMudarBranch);
			add(boxTitulo);
			add(boxBotoes);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}
	
	

}
