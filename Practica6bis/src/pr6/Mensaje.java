package pr6;

import java.net.InetAddress;


/*
 * TIENE QUE SER ABSTRACTA!!! DISTINTAS CLASES DE MENSAJE QUE LA IMPLEMENTEN
 * */
public  class Mensaje {
	TipoMensaje tipo;
	InetAddress origen, destino;
	
	public Mensaje (){
	}
	
	public Mensaje ( TipoMensaje tipo, InetAddress or, InetAddress dest){
		this.tipo = tipo;
		this.origen = or;
		this.destino = dest;
	}
	
	public TipoMensaje getTipo(){
		return tipo;
	}
	
	public InetAddress getOrigen() {
		return origen;
	}

	public InetAddress getDestino() {
		return destino;
	}
	

}
