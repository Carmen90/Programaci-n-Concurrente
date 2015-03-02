package parte2;

public class Main2 {
	public static final int N = 10000;
	public static int n = 0;
	public static int[] turn = {0,0};//= new int [2];
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Decremento de = new Decremento();
		Incremento in = new Incremento();
		
		de.start();
		in.start();
		
		try {
			in.join();
			de.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println ("El resultado de n es: " + n);

	}

}
