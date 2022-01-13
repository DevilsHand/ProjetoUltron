package creators;

import engine.terminal.Cmder;

public class main {

	public static void main(String[] args) {
		String path = "C:\\Users\\gabriel.araujo\\Documents\\CMDer\\Cmder.exe"; 
		String bash = "./utils/cmder/vendor/git-for-windows/git-bash.exe";
		//ENFIA O CAMINHO DO SEU BASH NESSA VARIAVEL AKI ENCIMA
		
		String pathCmd = "C:\\Windows\\system32\\cmd.exe";
		
		
		new Cmder(bash);
	}

}
