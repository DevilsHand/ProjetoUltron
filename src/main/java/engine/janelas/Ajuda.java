package engine.janelas;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Ajuda extends JPanel implements ActionListener {
	private final JanelaPrincipal MENU;
	private final JButton voltar = new JButton(" Voltar ");
	private JPanel painel = new JPanel();
	
	
	public Ajuda(JanelaPrincipal menu) {
		MENU = menu;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		inicio();
	}
	private void inicio() {
		voltar.addActionListener(this);
		voltar.setActionCommand("Voltar");
		painel.add(new JLabel("Bem vindo, essa ferramenta visa ajudar no processo de automa��o"));
		painel.add(new JLabel("Configura��o inicial: Informe o nome da branch que voc� edita,"));
		painel.add(new JLabel("al�m da raiz do projeto, ap�s isso ficara salvo para uso futuro"));
		painel.add(new JLabel("Git Helper: essa ferramenta ajuda a dar merge, pull no git"));
		painel.add(new JLabel("As demais fun��es est�o sendo implementadas"));
		painel.add(voltar);
		painel.add(new JLabel("Beta 0.2"));
		add(painel);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Voltar") {
			MENU.inicio();
		}
		
	}
	

}
