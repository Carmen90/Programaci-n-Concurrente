package parte1;

public class Main {

	public static final int N = 100;
	public static int n = 0;
	public static final int M = 500;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decrementador [] de= new Decrementador[M];
		Incrementador []in = new Incrementador[M];
		
		for ( int i = 0; i < M; i++){
			de[i] = new Decrementador();
			in[i] = new Incrementador();
			de[i].start();
			in[i].start();
		}
		
		for ( int i = 0; i < M; i++){
			try {
				de[i].join();
				in[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		System.out.println ("El resultado de n es: " + n);
	}

}
