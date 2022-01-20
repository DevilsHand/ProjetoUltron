package engine.scriptmakers;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import engine.janelas.GitHelper;

import static engine.terminal.Cmder.executarSh;
import static engine.janelas.JanelaPrincipal.CONFIG;

public class ScriptObj {
	private static final String PROJECTPATH = CONFIG.getOption("path");// Será removido daqui!!
	private static final String BRANCH = CONFIG.getOption("branch");
	private static final String path = "./src/main/java/scripts/runScript.sh";
	private File arquivoSh;
	private List<String> script = new ArrayList<String>();
	
	public ScriptObj() {
		
		arquivoSh = new File(path);
		script.add(String.format("cd %s", PROJECTPATH));
	}
	
	public void executar() {
		escreverSh();
		executarSh(path);
		apagarSh();
		script.clear();
		script.add(String.format("cd %s", PROJECTPATH));
		
	}
	private void escreverSh() {
		try {
			Files.write(arquivoSh.toPath(), script, StandardCharsets.UTF_8);
		} catch (Exception e) {
			//TODO retornar alguma informação pra tratarmos
		}
	}

	private void apagarSh() {
		try {
			Files.delete(arquivoSh.toPath());			
		} catch (Exception e) {
			//TODO retornar algo para tratarmos
		}
	}
	
	public void comandoCommit() {
		script.add("git add .");
		script.add(String.format("git commit -m '%s'", GitHelper.getNomeCommit()));
	}

	public void comandoPull() {
		comandoCommit();
		script.add(String.format("git pull %s %s", "origin", "main"));
	}
	
	public void comandoPush() {
		script.add("echo -+--+--+--+--+--+--+--+--+--+--+--+--+--+-");
		script.add("echo '|Insira sua senha do git no prompt abaixo|'");
		script.add("echo -+--+--+--+--+--+--+--+--+--+--+--+--+--+-");
		comandoCommit();
		script.add(String.format("git push %s %s", "origin", BRANCH));
	}
	
	public void comandoClone () {
		//TODO implementar o clone
	}
	
	public void comandoCheckout(String branch) {
		script.add(String.format("git checkout -b %s", branch));
	}
	public void commandoStatus() {
		script.add("git status");
		script.add("echo pressione ENTER para continuar");
		script.add("read $N");
		
	}
	

}
