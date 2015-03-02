package pr6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Servidor {
	Usuario [] usuarios = new Usuario [2];
	
	public Servidor(){
		this.usuarios[0] = new Usuario("Pepe", "casa");
		this.usuarios[1] = new Usuario("Luis", "mesa");
	}
	//ConexionesSalida [] tout

	public static void main(String[] args) throws IOException {
		
		ServerSocket listen = new ServerSocket (9999);
		
		while ( true){
			Socket s = listen.accept ();
			BufferedReader fin = new BufferedReader ( new InputStreamReader ( s.getInputStream()));
			PrintWriter fout = new PrintWriter (s.getOutputStream());
			String fichCliente = fin.readLine();
			File inputFile = new File (fichCliente);
			File fClientes = new File ("Users.txt");
			
			if ( !inputFile.exists()){
				fin.close();
				fout.close();
				s.close();
			}
			else{
				BufferedReader input = new BufferedReader (new FileReader (inputFile));
				String l;
				while ((l = input.readLine()) != null){
					fout.println(l);
					System.out.println(l);
				}
				fin.close();
				fout.close();
				input.close();
				s.close();
			}
			
		}
		/*
		 * probar metiendo el while dentro de un try catch y el listen.close(); dentro del
		 * finally del catch
		 * */
		//listen.close();
	}
}
