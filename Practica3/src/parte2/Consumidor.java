package parte2;

import java.util.concurrent.Semaphore;

import parte2.AlmacenN;
import parte2.Producto;

public class Consumidor extends Thread {
	AlmacenN almacen;
	Producto producto;
	Semaphore mutexC;
	
	public Consumidor ( AlmacenN almacen){
		this.almacen = almacen;
		this.mutexC = new Semaphore(1);
	}
	
	public void consumir ( Producto pro){
		//this.almacen.producto = null;
		System.out.println("Estoy consumiendo el producto " + pro.codigo);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run (){
		/*int i = 0;
		while (i < Main.nCons){*/
		try {
			this.mutexC.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producto = almacen.extraer();
		consumir(producto);
			
		this.mutexC.release();
		//	i++;
		//}
	}

}
