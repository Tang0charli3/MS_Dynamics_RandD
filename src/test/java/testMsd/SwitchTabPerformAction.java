package testMsd;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class SwitchTabPerformAction {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		String cmdCommand = "chrome.exe -remote-debugging-port=2708 --no-first-run --no-default-browser-check --user-data-dir=C:\\ChromeDataForMSD";
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
		Thread.sleep(500);
		
	
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
//		DesiredCapabilities cap=new DesiredCapabilities();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--user-data-C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 3");
		opt.setExperimentalOption("debuggerAddress", "localhost:2708");
		opt.addArguments("--disable notifications");
		opt.addArguments("--remote-allow-origins=*");
//		cap.merge(opt);
		//WebDriver driver = WebDriverManager.chromedriver().capabilities(opt).create();

		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://org4ef4f40f.crm8.dynamics.com/main.aspx?appid=ef556a1a-5dc6-ed11-b597-6045bdadab7e&pagetype=dashboard&id=eaa6e6bb-4712-ec11-b6e7-00224820f09b&type=system&_canOverride=true");

		driver.findElement(By.xpath("//span[.='Leads']")).click();
		driver.findElement(By.xpath("(//span[.='New'])[2]")).click();
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
//		String currentHandle = ;
//
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.gmail.com");
////		
//		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
//
//
//		// driver.findElement(By.xpath("(//mat-icon[@data-mat-icon-name='message'])[3]")).click();
//
////		
////		driver.findElement(By.linkText("Sign in")).click();
////		driver.findElement(By.id("identifierId")).sendKeys("jitendra.jira@gmail.com", Keys.ENTER);
////		driver.findElement(By.name("Password")).sendKeys("Jithufriends@007", Keys.ENTER);
////		
////		driver.get("https://voice.google.com/");
////		driver.findElement(By.linkText("Sign in")).click();

	}
}

