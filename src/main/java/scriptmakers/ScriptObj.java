package scriptmakers;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import engine.terminal.Cmder;
import static engine.terminal.Cmder.executarSh;

public class ScriptObj {
	private final String PROJECTPATH = "C:\\Projects";// Será removido daqui!!
	private final String GPath = "C:\\Users\\gabriel.araujo\\eclipse-workspace\\ProjetoUltron";
	private final String path = "./src/main/java/scripts/runScript.sh";
	private File arquivoSh;
	private Cmder cmd;
	private List<String> script = new ArrayList<String>();

	public ScriptObj() {
		arquivoSh = new File(path);
		script.add(String.format("cd %s", GPath));
		script.add("ls");
	}
	
	
	public void executar() {
		executarSh(path);
		apagarSh();
	}
	private void escreverSh() {
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
	
	public void comandoCommit(String branch, String mergeMsg) {
		script.add("git add .");
		script.add(String.format("git commit -m '%s'", mergeMsg));
		escreverSh();
	}

	public void comandoPull(String branch, String mergeMsg) {
		comandoCommit(branch, mergeMsg);
		script.add(String.format("git pull %s %s", "git@github.com:DevilsHand/ProjetoUltron.git", branch));
		escreverSh();
	}

}
