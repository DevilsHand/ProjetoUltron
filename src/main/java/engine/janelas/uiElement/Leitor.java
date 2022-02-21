package engine.janelas.uiElement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.janelas.GitClone;
import engine.janelas.GitHelper;
import engine.janelas.PrimeiroAcesso;
import engine.janelas.SnippetMaker;
import engine.scriptmakers.ScriptObj;
import engine.scriptmakers.SnippetWriter;

import static creators.main.MENU;

public interface Leitor extends ActionListener {
	
	ScriptObj script = new ScriptObj();
	
	default void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "clone":
			MENU.gitClone();
			break;
		case "enviarGitClone":
			script.comandoGitClone(GitClone.getClone(), GitClone.getPath());
			PrimeiroAcesso.setConfiguration(GitClone.getPath());
			script.executar();
		case "configInicial":
			PrimeiroAcesso.setConfiguration();
			MENU.inicio();
			break;
		case "gitHelper":
			MENU.gitHelper();
			break;
		case "ajuda":
			MENU.ajuda();
			break;
		case "snippets":
			MENU.snippetMaker();			
			break;
		case "commit":
			script.comandoCommit();
			script.executar();
			break;
		case "pull":
			script.comandoPull();
			script.executar();
			break;
		case "push":
			script.comandoPush();
			script.executar();
			break;
		case "status":
			script.commandoStatus();
			script.executar();
			break;
		case "voltar":
			MENU.inicio();
			break;
		}
		

	}
}
