package parte2;

import parte2.Buffer;
import parte2.Consumidores;
import parte2.Productores;

public class Main {

	final static int nCons= 10;
	final static int nPro = 11;
	final static int cap = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer buffer = new Buffer(cap, 0, 0, 0);
		Productores []productor = new Productores[nPro];	
		Consumidores []consumidor = new Consumidores[nCons];
		System.out.println("Empieza");
		
		for (int i = 0; i < nCons; i++){
			consumidor[i] = new Consumidores(buffer, 3);
		}
		
		for (int i = 0; i < nPro; i++){
			productor[i] = new Productores(buffer, i, 3);
		}
		
		for (int i = 0; i < nPro; i++){
			productor[i].start();
			if (i < nCons){
				consumidor[i].start();
			}
		}
		
		for ( int i = 0; i < nPro; i++){
			try {
				productor[i].join();
				if (i < nCons)
					consumidor[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
