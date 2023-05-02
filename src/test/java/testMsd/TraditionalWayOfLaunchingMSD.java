package testMsd;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TraditionalWayOfLaunchingMSD {
public static void main(String[] args) throws InterruptedException {
	String msDURL="https://org89ec3798.crm8.dynamics.com/main.aspx?appid=f702bcbe-92d1-ed11-a7c7-002248d5dc61&pagetype=dashboard&id=eaa6e6bb-4712-ec11-b6e7-00224820f09b&type=system&_canOverride=true";
	String firstName="Tango";
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--disable notifications");
	opt.addArguments("--remote-allow-origins=*");
	
	WebDriver driver = new ChromeDriver(opt);
	driver.manage().window().maximize();
	//Time Starts here
	long start = System.currentTimeMillis();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(msDURL);
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sannidhiadarsha@gmail.com");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Hills@777");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	driver.findElement(By.xpath("//input[@type='button']")).click();
	driver.findElement(By.xpath("//span[.='Leads']")).click();
	driver.findElement(By.xpath("//span[.='New']")).click();
	driver.findElement(By.xpath("//input[@aria-label='Topic']")).sendKeys("Customer Buying 10 laptops");
	driver.findElement(By.xpath("//input[@aria-label='First Name']")).sendKeys(firstName);
	driver.findElement(By.xpath("//input[@aria-label='Last Name']")).sendKeys("Charlie");
	driver.findElement(By.xpath("//input[@aria-label='Company Name']")).sendKeys("FireCrowd");
	driver.findElement(By.xpath("//input[@aria-label='Email']")).sendKeys("tango@gmail.com");
	driver.findElement(By.xpath("//input[@aria-label='Mobile Phone']")).sendKeys("9876543211");
	driver.findElement(By.xpath("//span[text()='Save and Close']")).click();
	if(driver.findElement(By.xpath("//span[contains(text(),'"+firstName+"')]")).isDisplayed()) {
		System.out.println("Lead is Created");
	}
	driver.quit();
	//Time ends here
	long end = System.currentTimeMillis();
	NumberFormat formatter = new DecimalFormat("#0.00000");
	System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
}
}
