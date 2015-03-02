package parte2;

import java.util.concurrent.Semaphore;

import parte2.AlmacenN;
import parte2.Producto;

public class Productor extends Thread {
	AlmacenN almacen;
	Producto p;
	int codigo;
	Semaphore mutexP;
	
	public Productor (AlmacenN almacen){
		this.almacen = almacen;
		this.codigo = 0;
		this.mutexP = new Semaphore (1);
	}
	
	public Productor (AlmacenN almacen, int codigo){
		this.almacen = almacen;
		this.codigo = codigo;
		this.mutexP = new Semaphore (1);
	} 
	
	public void producir( int p){
		this.p = new Producto (codigo);
		System.out.println("Estoy produciendo el producto " + this.p.codigo);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		//int i = 0;
		//while (i < Main.nPro){
		try {
			this.mutexP.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producir(this.codigo);
		almacen.almacenar(this.p);
		this.mutexP.release();
		//	i++;
		//}
	}
	
}
