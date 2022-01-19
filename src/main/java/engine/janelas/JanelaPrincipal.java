package engine.janelas;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.config.Config;

public class JanelaPrincipal extends JFrame {
	public static final Config CONFIG = new Config();
	private  NomeBranch nomeBranch; 
	
	private JPanel painelAtivo;
	public JanelaPrincipal() {
		super("Automation Helper (beta 0.2)" );
		
		setSize(new Dimension(400, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	public void inicio() {
		if (CONFIG.isLive) {
			nomeBranch = this.new NomeBranch();
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
			nomeBranch = new JLabel("Branch Atual: " + CONFIG.getOption("branch"));
			add(nomeBranch);
		}
		public JPanel getNomeBranch() {
			return this;
		}
		
	}
	public void ajuda() {
		remove(painelAtivo);
		painelAtivo = new Ajuda(this);
		getContentPane().add(painelAtivo);
		painelAtivo.updateUI();
		
	}

}
