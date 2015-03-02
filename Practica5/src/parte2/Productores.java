package parte2;

import parte2.Buffer;
import parte2.Producto;

public class Productores extends Thread{
	Buffer buffer;
	Producto []p;
	int codigo;
	int nPro;
	
	public Productores (Buffer buf, int numProd){
		this.buffer = buf;
		this.codigo = 0;
		this.nPro = numProd;
		this.p = new Producto[nPro];
	}
	
	public Productores (Buffer buf, int codigo, int numProd){
		this.buffer = buf;
		this.codigo = codigo;
		this.nPro = numProd;
		this.p = new Producto[nPro];
	} 
	
	public void producir( Producto pro, int i){
		pro = new Producto (i*this.codigo);
		//this.p = new Producto (codigo);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		for ( int i =0; i<nPro; i++){
			producir(this.p[i], i);
			buffer.deposit(this.p[i]);
		}
		
	}
}
