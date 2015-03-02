package parte1;

public class MiThread extends Thread{
	final int T = 1000;
	int id;
	
	public MiThread (int i ){
		this.id = i;
	}
	public void run (){
		System.out.println(id);
		try {
			MiThread.sleep(T);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(id);
	
	}

}
