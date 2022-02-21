package engine.janelas.uiElement;

import java.util.function.Consumer;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewButtonElement extends JButton implements ActionListener {
	private Consumer comando;
	public NewButtonElement(String name) {
		addActionListener(this);
		setActionCommand("e");
		setText(name);
	}
	public void setCommand(Consumer command) {
		this.comando = command;

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("e")) {
			comando.accept("");			
		}
		
	}
	
	
}
