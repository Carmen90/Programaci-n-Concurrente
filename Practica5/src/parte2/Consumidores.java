package parte2;

import parte2.Buffer;
import parte2.Producto;

public class Consumidores extends Thread {
	Buffer buffer;
	Producto []producto;
	int nCons;
	
	public Consumidores ( Buffer buffer2, int numCons){
		this.buffer = buffer2;
		this.producto = new Producto [numCons];
		this.nCons = numCons;
	}
	
	public void consumir ( Producto pro){
		//this.almacen.producto = null;
		//System.out.println("Estoy consumiendo el producto " + pro.codigo);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run (){
		for (int i = 0; i < nCons; i++){
			buffer.fetch(producto[i]);
			consumir(producto[i]);
		}
		
	}
}
