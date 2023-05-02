package testMsd;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class IntegratingSheets {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		String cmdCommand = "chrome.exe -remote-debugging-port=2708 --no-first-run --no-default-browser-check --user-data-dir=C:\\ChromeDataForMSD";
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
		Thread.sleep(500);
		
	
		
//		System.setProperty("driver.webdriver.chrome", "C:\\Users\\user1\\Downloads\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		

		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "localhost:2708");
		opt.addArguments("--disable notifications");
		opt.addArguments("--remote-allow-origins=*");
//		cap.merge(opt);
		//WebDriver driver = WebDriverManager.chromedriver().capabilities(opt).create();

		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.fireflink.com");
		Thread.sleep(3000);
		driver.close();
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");

		
//		String currentHandle = ;
//
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.fireflink.com");
////		
//		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);


		// driver.findElement(By.xpath("(//mat-icon[@data-mat-icon-name='message'])[3]")).click();

//		
//		driver.findElement(By.linkText("Sign in")).click();
//		driver.findelement(by.id("identifierid")).sendkeys("jitendra.jira@gmail.com", Keys.ENTER);
//		driver.findElement(By.name("Password")).sendKeys("Jithufriends@007", Keys.ENTER);
//		
//		driver.get("https://voice.google.com/");
//		driver.findElement(By.linkText("Sign in")).click();

	}
}
