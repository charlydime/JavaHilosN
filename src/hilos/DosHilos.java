package hilos;

public class DosHilos {

	
	public static void main(String[] args) {
	

		
		Thread hilo1 = new Thread ( new Uno() );
		Thread hilo2 = new Thread ( new Dos() );
		
		hilo1.start();
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hilo2.start();
		
		System.out.println("main");
	}

}


 class Uno implements Runnable{

	@Override
	public void run() {
		try {
			if (Thread.currentThread().isInterrupted()) {
				throw new InterruptedException( Thread.currentThread().getName() + " Interrumpido " + Thread.currentThread().getState() );
			}
		
		
		
		for(int i = 0; i < 70; i++ ) {
			System.out.print(i +" ");
			if ( (i % 10 == 0 ) == true ) System.out.println();
			
		}
		
		} catch (Exception e) {
			System.out.println("hilo en interrupcion" + e);
		}
		
	}
	 
	 
	 
	
}

 
 class Dos implements Runnable{

	@Override
	public void run() {
		try {
			if (Thread.currentThread().isInterrupted()) {
				throw new InterruptedException( Thread.currentThread().getName() + " Interrumpido " + Thread.currentThread().getState() );
			}
		
		
		
		for(int i = 100; i < 120; i++ ) {
			System.out.print(i +" ");
			if ( (i % 10 == 0 ) == true ) System.out.println();
			
		}
		
		} catch (Exception e) {
			System.out.println("hilo en interrupcion" + e);
		}
		
	}
	 
	 
	 
	
}
