package hilos;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;


public class PageDownload implements Runnable {
	
	String[] urlList;
	
	public PageDownload ( String[] urls) {
		this.urlList = urls;
	}

	@Override
	public void run() {
		
		for( String urls : urlList) {
			
			URL url;
			

			try {
				url = new URL ( urls );
				String filename = urls.substring(urls.lastIndexOf("/")+1).trim() +".html";
				BufferedReader reader = new BufferedReader( new InputStreamReader(url.openStream()) );
			
			
				BufferedWriter writer = new BufferedWriter( new FileWriter(filename) );
				
				String line;
				while ( (line = reader.readLine()) != null ){
					writer.write(line);
				}
				System.out.println("page download:" + filename);
				writer.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		String[] url = new String[] {	
				"https://www.skillsoft.com/elearning-events",
				"https://requestmetrics.com/web-performance/http3-is-fast",
				"https://www.skillsoft.com/partners",
				"https://swizec.com/blog/why-null-checks-are-bad"
				};
		
		Thread dwn1 = new Thread( new PageDownload( Arrays.copyOfRange(url, 0 , 1 ) ) );
		
		Thread dwn2 = new Thread( new PageDownload( Arrays.copyOfRange(url, 2 , url.length ) ) );
		
		
		long startTime = System.currentTimeMillis();
		dwn1.start();
		try {
			dwn1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dwn2.start();
		long stopTime = System.currentTimeMillis();
		System.out.println("Total time: " + ( stopTime-startTime)/1000 );
		
		
	}
	
	

}
