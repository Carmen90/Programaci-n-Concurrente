package parte1;

public class Consumidor extends Thread {
	Buffer buffer;
	Producto producto;
	
	public Consumidor ( Buffer buf){
		this.buffer = buf;
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
		buffer.fetch(producto);
		consumir(producto);
		
	}

}
