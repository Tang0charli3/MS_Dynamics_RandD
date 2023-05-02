package testMsd;

import java.io.IOException;

import org.testng.annotations.Test;

public class ProcessBuildMethod {

	@Test
	public static void Launch() throws IOException, InterruptedException {
		
		int max=2000;
		int min=9999;
		int b = (int)(Math.random()*(max-min+1)+min);  
		System.out.println(b); 
	}
}
