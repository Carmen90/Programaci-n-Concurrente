package pr6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * Es responsable de llevar a cabo todas las comunicaciones con el servidor, y cuando sea necesario ejecutar el env�o o recepci�n de ficheros.
Adem�s ofrece el soporte para la interacci�n con el usuario del sistema.*/
public class Cliente {
	String nomUsu;
	String contra;
	int ip;
	Socket socket;
	//Flujos flujos;
	public static void main (String[] args) throws UnknownHostException, IOException{
		InetAddress host = InetAddress.getLocalHost();
		//String host = ip;
		String fname = "Fich.txt";
		Socket s = new Socket (host, 9999);
		BufferedReader fserver = new BufferedReader (new InputStreamReader (s.getInputStream()));
		PrintWriter fout = new PrintWriter (s.getOutputStream());
		fout.println (fname);
		fout.flush();
		String l;
		while ((l = fserver.readLine()) != null){
			System.out.println (l);
		}
		s.close();
		fserver.close();
		fout.close();
	}

}

