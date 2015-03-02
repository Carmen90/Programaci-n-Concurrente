package parte2;

import parte1.Main;

public class Decremento extends Thread{
	
	public Decremento(){
		
	}

	public void run (){
		for (int i = 0; i < Main.N; i++){
			Main2.turn[1] = 1;
			while (Main2.turn[0] != 0);
			Main2.n --;
			Main2.turn[1]= 0;
		}
	}
}
