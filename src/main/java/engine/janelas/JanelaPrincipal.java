package engine.janelas;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.config.Config;

public class JanelaPrincipal extends JFrame {
	public static final Config CONFIGURATION = new Config();
	private static NomeBranch nomeBranch; 
	
	private JPanel painelAtivo;
	public JanelaPrincipal() {
		super("Automation Helper 0.0.2" );
		nomeBranch = this.new NomeBranch();
		setSize(new Dimension(400, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	public void inicio() {
		if (CONFIGURATION.isLive) {
			menuPrincipal();
		} else {
			menuConfiguration();
		}
	}
	
	private void menuPrincipal() {
		if (painelAtivo != null) {
			remove(painelAtivo);			
		}
		
		painelAtivo = new MenuPrincipal(this, nomeBranch);
		getContentPane().add(painelAtivo);		
		painelAtivo.updateUI();
		
	}
	
	private void menuConfiguration() {
		painelAtivo = new PrimeiroAcesso(this);
		getContentPane().add(painelAtivo);
		painelAtivo.updateUI();

	}
	
	public void gitHelper() {
		remove(painelAtivo);
		painelAtivo = new GitHelper(this, nomeBranch);
		getContentPane().add(painelAtivo);
		painelAtivo.updateUI();
	}
	public class NomeBranch extends JPanel {
		private final JLabel nomeBranch;
		
		public NomeBranch() {
			nomeBranch = new JLabel("Branch Atual: " + CONFIGURATION.getOption("branch"));
			add(nomeBranch);
		}
		public JPanel getNomeBranch() {
			return this;
		}
		
	}

}
