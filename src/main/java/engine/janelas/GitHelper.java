package engine.janelas;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.janelas.JanelaPrincipal.NomeBranch;
import engine.janelas.uiElement.ButtonElement;
import engine.janelas.uiElement.Entradas;
import engine.janelas.uiElement.Leitor;

public class GitHelper extends JPanel implements Leitor {
	private final static Entradas entradaCommit = new Entradas("Mensagem do Commit"); 
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxBotoes = new JPanel();
	private final JPanel boxEntrada = new JPanel();
	private final JPanel nomeBranch;
	private final JLabel titulo = new JLabel("- Git Helper -");
	private final ButtonElement btnPull = new ButtonElement(" Pull ", this, "pull");
	private final ButtonElement btnPush = new ButtonElement(" Push ", this, "push");
	private final ButtonElement btnCommit = new ButtonElement(" Commit ", this, "commit");
	//private final ButtonElement btnMudarBranch = new ButtonElement(" Mudar Branch ", this, "mudarBranch");
	private final ButtonElement btnStatus = new ButtonElement(" Status ", this, "status");
	private final ButtonElement btnVoltar = new ButtonElement(" Voltar ", this, "voltar");
	
	public GitHelper(NomeBranch nb) {
			nomeBranch = nb.getNomeBranch();
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			startUp();
	}
	private void startUp() {
		entradaCommit.setText("");
		boxTitulo.add(titulo);
		boxEntrada.add(entradaCommit.labelFor());
		boxEntrada.add(entradaCommit);
		boxBotoes.add(btnStatus);
		boxBotoes.add(btnPull);
		boxBotoes.add(btnPush);
		/*boxBotoes.add(btnMudarBranch);*/
		boxBotoes.add(btnCommit);
		boxBotoes.add(btnVoltar);
		add(boxTitulo);
		add(boxEntrada);
		add(boxBotoes);
		add(nomeBranch);

	}
	public static String getNomeCommit() {
		return entradaCommit.getText();
	}
	
}
