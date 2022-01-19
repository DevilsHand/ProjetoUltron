package engine.scriptmakers;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static engine.terminal.Cmder.executarSh;
import static engine.janelas.JanelaPrincipal.CONFIGURATION;

public class ScriptObj {
	private static final String PROJECTPATH = CONFIGURATION.getOption("path");// Será removido daqui!!
	private static final String BRANCH = CONFIGURATION.getOption("branch");
	private static final String path = "./src/main/java/scripts/runScript.sh";
	private File arquivoSh;
	private List<String> leitor = new ArrayList<String>();
	private List<String> script = new ArrayList<String>();
	
	public ScriptObj() {
		
		arquivoSh = new File(path);
		script.add(String.format("cd %s", PROJECTPATH));//TODO alterar
		script.add("ls");
	
	}
	
	public void executar() {
		leitor = executarSh(path);
		System.out.println(leitor);
		
		//apagarSh();
	}
	private void escreverSh() {
		script.add("echo Esse Script ainda está em beta, pressione ENTER para finalizar");
		script.add("read $NAME");// só pro bash não fechar, pode ser ignorado dps
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

	public void exemploEscreverNome(String nome) { // apagar esse método exemplo
		script.add(String.format("echo  %s", nome));
		System.out.println(script);// printar a ArrayList pode ser ignorado e removido
		escreverSh();

	}
	
	public void comandoCommit(String mergeMsg) {
		script.add("git add .");
		script.add(String.format("git commit -m '%s'", mergeMsg));
		escreverSh();
	}

	public void comandoPull(String mergeMsg) {
		comandoCommit(mergeMsg);
		script.add(String.format("git pull %s %s", "origin", BRANCH));
		escreverSh();
	}
	
	public void comandoClone () {
		//TODO implementar o clone
	}
	
	public void comandoCheckout(String branch) {
		script.add(String.format("git checkout -b %s", branch));
	}
	public void commandoStatus() {
		script.add("git status");
		
		
	}
	

}
