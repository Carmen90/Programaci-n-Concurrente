package parte2;

public class Main {
	static int d = 0;
	public static void main(String[] args) throws InterruptedException {
		final int N = 1000;
		
		MiThread t[] = new MiThread [N];
		MiSegundoThread t2[] = new MiSegundoThread [N];
		//MiThread t = null;
		//MiSegundoThread t2= null; 
	
		for (int i=0; i < N; i++){
			t[i] = new MiThread();
			t2[i] = new MiSegundoThread();
			t[i].start();
			t2[i].start();
			
		}
		for (int i = 0; i <N; i++){
			t[i].join();
			t2[i].join();
		}
		
		System.out.println ("Han termiando "+ d);
	}

}
