package engine.janelas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static engine.janelas.JanelaPrincipal.CONFIG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PrimeiroAcesso  extends JPanel implements ActionListener{
	private final JanelaPrincipal CONTROLADOR;
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxBotoes = new JPanel();
	private final JPanel boxBotoesII = new JPanel();
	private final JPanel boxRodape = new JPanel();
	private final JLabel titulo = new JLabel("Bem Vindo, escolha uma opção abaixo");
	
	private final Entradas inBranch = new Entradas("Nome da Branch: ");
	private final Entradas inPath = new Entradas("Caminho do Projeto: ");
	
	
	public PrimeiroAcesso(JanelaPrincipal janela) {
		CONTROLADOR = janela;
		menuConfiguration();
	}
	
	
	private void menuConfiguration() {
		JLabel infoI = new JLabel("- Configuração inicial - ");
		JLabel infoII = new JLabel("- Insira as Informações abaixo - ");
		
		JButton botao = new JButton("Confirmar");
		
		botao.addActionListener(this);
		botao.setActionCommand("Config");
		boxTitulo.add(titulo);
		boxTitulo.add(infoI);
		boxTitulo.add(infoII);
		boxBotoes.add(inBranch.labelFor());
		boxBotoes.add(inBranch);
		boxBotoesII.add(inPath.labelFor());
		boxBotoesII.add(inPath);
		boxRodape.add(botao);
		add(boxTitulo);
		add(boxBotoes);
		add(boxBotoesII);
		add(boxRodape);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Config":
			CONFIG.criarConfig(inBranch.getText(), inPath.getText());
			remove(boxTitulo);
			remove(boxBotoes);
			remove(boxBotoesII);
			remove(boxRodape);
			CONTROLADOR.inicio();
			break;
		default :
			JLabel msgErro = new JLabel("Função ainda não adicionada");
			boxTitulo.add(msgErro);
			updateUI();
			break;		
			
		}
	}
}
