package pr6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * usada para proporcionar concurrencia respecto a las sesiones de casa
   usuario con el servidor. El metodo \run()" se limita a hacer lecturas del 
   flujo de entrada correspondiente, realizar las acciones oportunas, y devolver los resultados
   en forma de mensajes que seran enviados al usuario o usuarios involucrados.
*/
public class OyenteCliente extends Thread {
	Usuario user;
	Socket socket;
	BufferedReader fin;// = new BufferedReader ( new InputStreamReader ( socket.getInputStream()));
	PrintWriter fout;// = new PrintWriter (socket.getOutputStream());
	
	public OyenteCliente (Socket sok) throws IOException{
		socket = sok;
		fin = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		fout = new PrintWriter (socket.getOutputStream());
	}
	
	public Mensaje mensaje() throws IOException{
		String mensj = fin.readLine();
		Mensaje msg = new Mensaje();
		msg.origen = socket.getInetAddress();
		msg.destino = socket.getLocalAddress();
		
		//while (true){
			if (mensj.equalsIgnoreCase("CONFIRM_LIST_USERS"))
				msg.tipo = TipoMensaje.CONFIRM_LIST_USERS;
			else if (mensj.equalsIgnoreCase("CONFIRMA_CONEXION"))
				msg.tipo = TipoMensaje.CONFIRMA_CONEXION;
			else if (mensj.equalsIgnoreCase("EMITIR_FICHERO"))
				msg.tipo = TipoMensaje.EMITIR_FICHERO;
			else if (mensj.equalsIgnoreCase("LIS_USERS"))
				msg.tipo = TipoMensaje.LIS_USERS;
			else if (mensj.equalsIgnoreCase("PEDIR_FICHERO"))
				msg.tipo = TipoMensaje.PEDIR_FICHERO;
			else if (mensj.equalsIgnoreCase("SOLICITUD_CONEXION"))
				msg.tipo = TipoMensaje.SOLICITUD_CONEXION;
	//	}
		
		return msg;
	}
	

}
