package pr6;

import java.io.File;

public class Usuario {
	String id;
	String contra;
	int ip;
	File [] ficheros;
	
	public Usuario( String id, String cont){
		this.contra =cont;
		this.id = id;
	}

}
