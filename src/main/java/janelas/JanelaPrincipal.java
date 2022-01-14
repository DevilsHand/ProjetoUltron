package janelas;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame {
	private static final Entradas ENTRADA = new Entradas();
	private JPanel painelAtivo;
	public JanelaPrincipal() {
		super("Git Helper 0.0.2");
		setSize(new Dimension(300, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void menuPrimeiroAcesso() {
		painelAtivo = new MenuPrimeiroAcesso(this);
		getContentPane().add(painelAtivo);
		painelAtivo.updateUI();
	}

}
