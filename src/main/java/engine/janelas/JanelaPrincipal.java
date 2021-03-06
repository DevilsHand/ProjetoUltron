package engine.janelas;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.config.Config;

public class JanelaPrincipal extends JFrame {
	public static final Config CONFIG = new Config();
	private  NomeBranch nomeBranch; 
	private static JPanel painelAtivo;
	
	public JanelaPrincipal() {
		super("Automation Helper (beta 0.3)" );
		setSize(new Dimension(400, 280));
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
		
		painelAtivo = new MenuPrincipal(nomeBranch);
		getContentPane().add(painelAtivo);		
		painelAtivo.updateUI();
		
	}
	
	private void menuConfiguration() {
		painelAtivo = new PrimeiroAcesso();
		getContentPane().add(painelAtivo);
		painelAtivo.updateUI();

	}
	
	public void gitHelper() {
		remove(painelAtivo);
		painelAtivo = new GitHelper(nomeBranch);
		getContentPane().add(painelAtivo);
		painelAtivo.updateUI();
	}
	
	
	public void ajuda() {
		remove(painelAtivo);
		painelAtivo = new Ajuda();
		getContentPane().add(painelAtivo);
		painelAtivo.updateUI();
		
	}

	public void snippetMaker() {
		remove(painelAtivo);
		painelAtivo = new SnippetMaker(this);
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
}
