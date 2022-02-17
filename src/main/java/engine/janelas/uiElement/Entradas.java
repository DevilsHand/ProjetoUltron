package engine.janelas.uiElement;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Entradas extends JTextField {
	private JLabel labelFor;
	
	public Entradas(String label) {
		labelFor = new JLabel(label);
		setPreferredSize(new Dimension(150, 20));
	}
	public Entradas(String label, int x, int y) {
		labelFor = new JLabel(label);
		setPreferredSize(new Dimension(x, y));
	}
	
	
	public boolean checarEntrada() {
		return false;//temporario só p agradecer meu T.O.C.
		
	}
	public JLabel labelFor() {
		return labelFor;
	}
	
	public JPanel pannelFor() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
		p.add(labelFor);
		p.add(this);
		return p;
	}

}
