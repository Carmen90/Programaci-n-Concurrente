package parte1;

public class Productor extends Thread{
	Almacen almacen;
	Producto p;
	int codigo;
	
	public Productor (Almacen almacen){
		this.almacen = almacen;
		this.codigo = 0;
	}
	
	public Productor (Almacen almacen, int codigo){
		this.almacen = almacen;
		this.codigo = codigo;
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
			producir(this.codigo);
			almacen.almacenar(this.p);
		//	i++;
		//}
	}
	
}
