package parte1;

public class MiSegundoThread extends Thread {
	final int N = 5;
	public  MiSegundoThread(){
		
	}
	public void run(){
		MiThread t = null;
		for (int i=0; i < N; i++){
			t = new MiThread (i);
			t.start();
		}
		try {
			t.join();
			//MiSegundoThread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
