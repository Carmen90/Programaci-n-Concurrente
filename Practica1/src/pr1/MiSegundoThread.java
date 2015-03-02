package pr1;

public class MiSegundoThread extends Thread {
	final int N = 5;
	public  MiSegundoThread(){
		
	}
	public void run(){
		for (int i=0; i < N; i++){
			MiThread t = new MiThread (i);
			t.start();
		}
	}
}
