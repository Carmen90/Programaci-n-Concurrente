package parte1;

public class Main {
	final static int nCons= 10;
	final static int nPro = 11;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Almacen almacen = new Almacen();
		Productor []productor = new Productor[nPro];	
		Consumidor []consumidor = new Consumidor[nCons];
		
		for (int i = 0; i < nCons; i++){
			consumidor[i] = new Consumidor(almacen);
		}
		
		for (int i = 0; i < nPro; i++){
			productor[i] = new Productor(almacen);
		}
		
		for (int i = 0; i < nPro; i++){
			productor[i].run();
			if (i < nCons){
				consumidor[i].run();
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
		
		System.out.println(almacen.producto.codigo);
	}

}
