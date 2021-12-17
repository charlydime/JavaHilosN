package hilos;


public class DosHilosInterrupt {

	
	public static void main(String[] args) {
	

		
		Thread hilo1 = new Thread ( new Uno() );
		Thread hilo2 = new Thread ( new Dos() );
		
		hilo1.start();
		hilo2.start();
		

		hilo1.interrupt();
		//hilo2.interrupt();
		
		
	}

}


	 
	

