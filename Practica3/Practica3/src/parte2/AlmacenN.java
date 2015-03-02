package parte2;

import java.util.concurrent.Semaphore;

import parte2.Producto;

public class AlmacenN {
	Producto [] products;
	int ini;
	int fin;
	int capacidad;
	Semaphore full, empty;
	
	public AlmacenN (){
		this.ini = 0;
		this.fin = 0;
		this.capacidad = 0;
		this.products = new Producto[this.capacidad];
		this.full = new Semaphore (0);
		this.empty = new Semaphore (capacidad);
	}
	
	public AlmacenN (int ini , int fin , int capa){
		this.ini = ini;
		this.fin = fin;
		this.capacidad = capa;
		this.products = new Producto[this.capacidad];
		this.full = new Semaphore (0);
		this.empty = new Semaphore (capacidad);
	}
	
	public void almacenar ( Producto p){
		try {
			this.empty.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.products[this.fin] = p;
		fin = (fin+1) % capacidad;
		this.full.release();
	}
	
	public Producto extraer (){
		Producto aux;
		try {
			this.full.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aux = this.products[ini];
		this.products[ini] = new Producto();
		this.ini = (this.ini +1) % capacidad;
		this.empty.release();
		return aux;
	}

}
