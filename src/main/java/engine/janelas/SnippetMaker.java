package engine.janelas;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.scriptmakers.SnippetWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnippetMaker extends JPanel implements ActionListener {
	private final JanelaPrincipal MENU;
	private final SnippetWriter maker;
	
	private final JButton botao = new JButton(" Testa Snippet ");
	
	public SnippetMaker(JanelaPrincipal janela) {
		MENU = janela;
		maker = new SnippetWriter();
		
		botao.addActionListener(this);
		botao.setActionCommand("Snippet");
		
		add(botao);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Snippet":
			maker.makeGiven("possuir um automatizador");
			maker.print();
			break;

		default:
			break;
		}
		
	}

}
