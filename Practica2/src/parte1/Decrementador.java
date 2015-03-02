package parte1;

public class Decrementador extends Thread{
	
	public Decrementador(){
		
	}

	public void run (){
		for (int i = 0; i < Main.N; i++){
			Main.n --;
		}
	
	}
}
