package parte1;

public class Buffer {
	private final int N; 
	private Producto buf [];
	private int ini; 
	private int fin; 
	private int count;
	boolean lleno = false, vacio = true;
	
	public Buffer(int n, int ini, int fin, int count){
		this.N = n;
		this.count = count;
		this.ini = ini;
		this.fin = fin;
		this.buf = new Producto[N];
	}
	
	public synchronized void deposit (Producto data){
		while (count == N){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buf [fin]= data;
		fin = (fin+1) % N;
		count ++;
		System.out.println("Estoy produciendo el producto " + data.codigo);
		notify();
	}
	
	public synchronized void fetch (Producto data){
		while (count == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		data = buf[ini];
		ini = (ini + 1) % N;
		count--;
		System.out.println("Estoy consumiendo el producto " + data.codigo);
		notify();
	}
}
