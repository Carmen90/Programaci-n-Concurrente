package pr1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiSegundoThread main = new MiSegundoThread();
		main.start();
		try {
			main.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Han terminado");
	}

}
