package pr1;

public class MiThread extends Thread{
	final int T = 100;
	int id;
	
	public MiThread (int i ){
		this.id = i;
	}
	public void run (){
		if ( this.id != -1){
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

}
