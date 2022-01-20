package engine.janelas.uiElement;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Entradas extends JTextField {
	private JLabel labelFor;
	
	public Entradas(String label) {
		labelFor = new JLabel(label);
		setPreferredSize(new Dimension(150, 20));
	}
	
	public boolean checarEntrada() {
		return false;//temporario só p agradecer meu T.O.C.
		
	}
	public JLabel labelFor() {
		return labelFor;
	}

}
