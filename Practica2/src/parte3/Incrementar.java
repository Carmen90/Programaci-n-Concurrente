package parte3;

public class Incrementar extends Thread{
	int i;
	
	public Incrementar(int i){
		this.i = i;
	}

	public void run (){
		for (int n = 0; n < Main3.N; n++){
			for( int j = 0; j < Main3.M; j++){
				Main3.turn [i] = j;
				Main3.last[j] = i;
				for ( int k = 0; k < Main3.M  && k != i; k++){
					while (Main3.turn[k]>= Main3.turn[i] && Main3.last[j]==i);
				}
			}
			Main3.total++;
			Main3.turn[i]= 0;
		}
	
	}
}
