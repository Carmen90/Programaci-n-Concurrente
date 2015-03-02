package parte3;

public class Main3 {

	public static final int N = 100;
	public static int total = 0;
	public static final int M = 500;
	public static int[] turn = new int [2*M];
	public static int[] last = new int [2*M];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decrementar [] de = new Decrementar[M];
		Incrementar [] in = new Incrementar[M];
		
		for ( int i = 0; i < 2*M; i++ ){
			turn[i]= 0;
			last[i]= 0;
			
		}
		for ( int i = 0; i < M; i++){
			de[i] = new Decrementar(i);
			in[i] = new Incrementar(M+i);
		}
		
		for ( int i = 0; i < M; i ++){
			de[i].start();
			in[i].start();
		}
		
		for ( int i = 0; i < M; i ++){
			try {
				de[i].join();
				in[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println ("El resultado de n es: " + total);

	}

	public static boolean Operacion (int a, int b, int c, int d){
		
		if ( a > c || (a == c && b > d) ){
			return true;
		}
		return false;
	}
}
