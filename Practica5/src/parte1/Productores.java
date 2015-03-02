package parte1;

public class Productores extends Thread{
	Buffer buffer;
	Producto p;
	int codigo;
	
	public Productores (Buffer buf){
		this.buffer = buf;
		this.codigo = 0;
	}
	
	public Productores (Buffer buf, int codigo){
		this.buffer = buf;
		this.codigo = codigo;
	} 
	
	public void producir( int p){
		this.p = new Producto (codigo);
		//System.out.println("Estoy produciendo el producto " + this.p.codigo);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		producir(this.codigo);
		buffer.deposit(this.p);
	}
	
}
