package engine.janelas.uiElement;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import engine.janelas.SnippetMaker;

public class FileSelect extends JFileChooser{
	private final FileNameExtensionFilter filter;
	private final SnippetMaker menu;
	public FileSelect(SnippetMaker menu) {
		 filter = new FileNameExtensionFilter("Cucumber Feature Files", "feature");
		 this.menu = menu;
		 setFileFilter(filter);
	}
	
	@Override
	public void approveSelection() {
		menu.setCucumberFile();
	}

}
