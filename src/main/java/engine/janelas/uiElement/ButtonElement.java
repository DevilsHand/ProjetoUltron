package engine.janelas.uiElement;

import javax.swing.JButton;

public class ButtonElement extends JButton {
	
	public ButtonElement(String nome, Leitor leitorAcoes, String comando) {
		setText(nome);
		setActionCommand(comando);
		addActionListener(leitorAcoes);
	}
	public JButton getBotao() {
		return this;
	}

}
