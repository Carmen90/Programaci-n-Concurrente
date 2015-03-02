package parte2;

public class Incremento extends Thread {

	public Incremento(){
		
	}

	public void run (){
		for (int i = 0; i < Main2.N; i++){
			Main2.turn[0] = 1;
			while (Main2.turn[1] != 0);
			Main2.n ++;
			Main2.turn[0]= 0;
		}
	
	}
}
