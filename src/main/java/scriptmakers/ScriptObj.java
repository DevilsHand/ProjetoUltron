package scriptmakers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import engine.terminal.Cmder;


public class ScriptObj {
	private final String PROJECTPATH = "C:\\Projects";//Será removido daqui!!
	private final String path = "./src/main/java/scripts/runScript.sh";
	private File arquivoSh;
	private List<String> script = new ArrayList<String>();
	
	public ScriptObj() {
		arquivoSh = new File(path);
		script.add("!/bin/bash");// remover 
		script.add(String.format("cd %s", PROJECTPATH));
		script.add("ls");
	}
	
	private void escreverSh() {
		try {
			Files.write(arquivoSh.toPath(), script , StandardCharsets.UTF_8);
			Cmder.executarSh(path);
		} catch (Exception e) {
			
		}
		
	}
	private void apagarSh() {
		//TODO implementar a função p apagr o script 
	}
	
	public void exemploEscreverNome(String nome) { // apagar esse método exemplo
		try {
			script.add(String.format("echo  %s", nome));
			script.add("read $NAME");//só pro bash não fechar, pode ser ignorado dps
			
			System.out.println(script);//printar a ArrayList pode ser ignorado e removido
			escreverSh();
			} catch (Exception e) {
			
		} finally {
			apagarSh();
		}
		
	}
	public void comandoPull( String branch) {
		
	}
}
