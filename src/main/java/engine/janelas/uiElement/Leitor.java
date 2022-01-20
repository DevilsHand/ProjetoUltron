package engine.janelas.uiElement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.scriptmakers.ScriptObj;

import static creators.main.MENU;
import static engine.janelas.JanelaPrincipal.CONFIG;

public interface Leitor extends ActionListener {
	ScriptObj script = new ScriptObj();
	
	default void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Config":
			
			MENU.inicio();
			break;
		
		
		case "GitHelper":
			MENU.gitHelper();
			break;
		case "Ajuda":
			MENU.ajuda();
			break;
		case "Snippets":
			MENU.snippetMaker();			
			break;
			
		
			
		case "Commit":
			script.comandoCommit("Commit automatizado");
			script.executar();
			break;
		case "Pull":
			script.comandoPull("Pull Automatizado");
			script.executar();
			break;
		case "Push":
			script.comandoPush("Push Automatizado");
			script.executar();
			break;
		case "Status":
			script.commandoStatus();
			script.executar();
			break;
		case "Voltar":
			MENU.inicio();
			break;
		}

	}
}
