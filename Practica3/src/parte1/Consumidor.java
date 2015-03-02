package parte1;

public class Consumidor extends Thread {
	Almacen almacen;
	Producto producto;
	
	public Consumidor ( Almacen almacen){
		this.almacen = almacen;
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
			producto = almacen.extraer();
			consumir(producto);
		//	i++;
		//}
	}

}
