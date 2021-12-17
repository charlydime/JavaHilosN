package hilos;

public class ThreadCicle {

	
	public static class Walk  implements Runnable{ 
		@Override
		public void run() {
			
			for(int i = 1 ; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println("Walk...." + Thread.currentThread().getState());
				System.out.println("Walk.... isAlive " + Thread.currentThread().isAlive());
			}
		}
	}
	
	public static class Chew  implements Runnable{ 
		@Override
		public void run() {
			
			for(int i = 1 ; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println("Chew...." + Thread.currentThread().getState());
			}
		}
	}
	
	public static void main(String[] args) {
		
		Thread walkT = new Thread(new Walk());
		//Thread chewT = new Thread(new Chew());
		System.out.println("Walk initialize" + walkT.getState());
		System.out.println("main initialize" + Thread.currentThread().getState());
		System.out.println("Walk initialize isAlive" + walkT.isAlive());
		
		try {
			walkT.start();
			System.out.println("Walk start" + walkT.getState());
			System.out.println("main after walk" + Thread.currentThread().getState());
			System.out.println("Walk start isAlive " + walkT.isAlive());
			
			
			Thread.sleep(1000);
			walkT.join();
			
			System.out.println("Walk Join" + walkT.getState());
			System.out.println("main after walk join" + Thread.currentThread().getState());
			System.out.println("Walk Join isAlive" + walkT.isAlive());
			
			Thread.sleep(1000);
			System.out.println("Walk end" + walkT.getState());
			System.out.println("main end" + Thread.currentThread().getState());
			System.out.println("Walk end isAlive" + walkT.isAlive());
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//chewT.start();
		
		System.out.println("main....");
		
	}



}
