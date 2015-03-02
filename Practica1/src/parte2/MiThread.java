package parte2;

public class MiThread extends Thread {
	/*final int T = 100;
	int id;
	
	public MiThread (int i ){
		this.id = i;
	}
	public void run (){
		System.out.println(id+ "antes");
		try {
			MiThread.sleep(T);
			System.out.println(id + "despues");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}*/
	
	public MiThread ( ){
	}
	
	public void run (){
		Main.d += 1;
		//System.out.println("suma " + Main.d);
	}
}
