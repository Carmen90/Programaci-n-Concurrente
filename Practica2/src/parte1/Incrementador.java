package parte1;

public class Incrementador extends Thread{
	
	public Incrementador(){
		
	}

	public void run (){
		for (int i = 0; i < Main.N; i++){
			Main.n ++;
		}
	
	}
}
