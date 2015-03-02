package parte2;

public class MiSegundoThread extends Thread{
	
	
	public MiSegundoThread ( ){
	}
	
	public void run (){
		Main.d -=1;
		//System.out.println("resta " + Main.d);
	}

}
