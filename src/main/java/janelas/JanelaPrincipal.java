package janelas;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame {
	private static final Entradas ENTRADA = new Entradas();
	private JPanel painelAtivo;
	public JanelaPrincipal() {
		super("Automation Helper 0.0.2");
		setSize(new Dimension(400, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void menuPrimeiroAcesso() {
		if (painelAtivo != null) {
			remove(painelAtivo);			
		}
		painelAtivo = new MenuPrimeiroAcesso(this);
		getContentPane().add(painelAtivo);
		painelAtivo.updateUI();
		
	}
	
	public void gitHelper() {
		remove(painelAtivo);
		painelAtivo = new GitHelper(this);
		getContentPane().add(painelAtivo);
		painelAtivo.updateUI();
	}

}
