package testMsd;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class PreLoadData {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		String msDURL="https://www.arrow.com/";
//		String dir="C:\\ChromeDataForMSD";
//		String cmdCommand = "chrome.exe -remote-debugging-port=9292 --no-first-run --no-default-browser-check --user-data-dir=" + dir;
//		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
//		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
		Thread.sleep(500);
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
//		Connect to launched browser	
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "localhost:9292");
		opt.addArguments("--disable notifications");
		opt.addArguments("--remote-allow-origins=*");
//		
		WebDriver driver = new ChromeDriver(opt);
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
		Runtime.getRuntime().exec("taskkill /F /FI \"WINDOWTITLE eq Terminal\"");
	
		driver.manage().window().maximize();
		//Time Starts here
		long start = System.currentTimeMillis();
//		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(msDURL);
		
		driver.findElement(By.xpath("//span[.='Leads']")).click();
//		driver.findElement(By.xpath("//span[.='New']")).click();
//		driver.findElement(By.xpath("//input[@aria-label='Topic']")).sendKeys("Customer Buying 10 laptops");
//		driver.findElement(By.xpath("//input[@aria-label='First Name']")).sendKeys(firstName);
//		driver.findElement(By.xpath("//input[@aria-label='Last Name']")).sendKeys("Charlie");
//		driver.findElement(By.xpath("//input[@aria-label='Company Name']")).sendKeys("FireCloud");
//		driver.findElement(By.xpath("//input[@aria-label='Email']")).sendKeys("alpha@gmail.com");
//		driver.findElement(By.xpath("//input[@aria-label='Mobile Phone']")).sendKeys("9876543211");
//		driver.findElement(By.xpath("//span[text()='Save and Close']")).click();
//		if(driver.findElement(By.xpath("//span[contains(text(),'"+firstName+"')]")).isDisplayed()) {
//			System.out.println("Lead is Created");
//		}
		//driver.close();
		//Time ends here
		long end = System.currentTimeMillis();
    	NumberFormat formatter = new DecimalFormat("#0.00000");
    	System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

		
		
		
	}
}
