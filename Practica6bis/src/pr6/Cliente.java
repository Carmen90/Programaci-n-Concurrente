package pr6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * Es responsable de llevar a cabo todas las comunicaciones con el servidor, y cuando sea necesario ejecutar el envío o recepción de ficheros.
Además ofrece el soporte para la interacción con el usuario del sistema.*/
public class Cliente {
	static String nombre;
	static String contra;
	int ip;
	Socket socket;
	//Flujos flujos;
	public static void main (String[] args) throws UnknownHostException, IOException{
		System.out.println ("Introduzca su nombre de usuario:");
		Scanner reader = new Scanner(System.in);
		nombre = reader.next();
		System.out.println ("Introduzca su contraseña:");
		reader = new Scanner(System.in);
		contra= reader.next();
		InetAddress host = InetAddress.getLocalHost();
		//String fname = "Fich.txt";
		String fname= "Fich.txt";
		Socket s = new Socket (host, 9999);
		Mensaje msg = new Mensaje ( TipoMensaje.SOLICITUD_CONEXION, s.getInetAddress(), host);
	//	OyenteServidor oySer = new OyenteServidor (mg);
		BufferedReader fserver = new BufferedReader (new InputStreamReader (s.getInputStream()));
		PrintWriter fout = new PrintWriter (s.getOutputStream());
		fout.println (fname);
		fout.flush();
		String l;
		while ((l = fserver.readLine()) != null){
			System.out.println (l);
			System.out.println("hoila");
		}
		s.close();
		fserver.close();
		fout.close();
	}

}

