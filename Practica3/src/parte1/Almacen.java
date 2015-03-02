package parte1;

import java.util.concurrent.Semaphore;

public class Almacen {
	Producto producto;
	Semaphore lleno, vacio;
	
	public Almacen (){
		this.producto = new Producto ();
		this.lleno = new Semaphore (0);
		this.vacio = new Semaphore (1);
	}
	
	public void almacenar ( Producto p){
		try {
			this.vacio.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.producto = p;
		this.lleno.release();
	}
	
	public Producto extraer (){
		Producto aux;
		try {
			this.lleno.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aux = this.producto;
		this.producto = new Producto();
		this.vacio.release();
		return aux;
		
	}
}
