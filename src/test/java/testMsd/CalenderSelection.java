package testMsd;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CalenderSelection {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		String msDURL="https://org89ec3798.crm8.dynamics.com/main.aspx?appid=f702bcbe-92d1-ed11-a7c7-002248d5dc61&pagetype=dashboard&id=eaa6e6bb-4712-ec11-b6e7-00224820f09b&type=system&_canOverride=true";
		String cmdCommand = "chrome.exe -remote-debugging-port=2708 --no-first-run --no-default-browser-check --user-data-dir=C:\\ChromeDataForMSD";
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
		String firstName="Alpha";
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
		Thread.sleep(500);
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
//		Connect to launched browser	
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "localhost:2708");
		opt.addArguments("--disable notifications");
		opt.addArguments("--remote-allow-origins=*");
//		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		//Time Starts here
		long start = System.currentTimeMillis();
//		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(msDURL);
		driver.findElement(By.xpath("//span[text()='Opportunities']")).click();
		driver.findElement(By.xpath("//div[text()='KumaChiragr Pvt Ltd']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Go to main form']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Create a timeline record.']")).click();
		driver.findElement(By.xpath("//*[@id=\"id-cb430327-bcc1-416d-959d-db7592e685af-18-notescontrol-createNewRecord_flyoutMenuItem_phonecall\"]/div/div")).click();
		driver.findElement(By.xpath("//input[@aria-label='Date of Due']")).sendKeys("4/16/2023");

		//driver.close();
		//Time ends here
		long end = System.currentTimeMillis();
    	NumberFormat formatter = new DecimalFormat("#0.00000");
//    	System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

		
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
		Runtime.getRuntime().exec("taskkill /F /FI \"WINDOWTITLE eq Terminal\"");
	}
}
