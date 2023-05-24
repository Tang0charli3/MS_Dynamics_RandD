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


public class ElementsVerification {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		String cmdCommand = "chrome.exe -remote-debugging-port=2708 --no-first-run --no-default-browser-check --user-data-dir=C:\\ChromeDataForMSD";
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
		Thread.sleep(500);
//		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "localhost:2708");
		opt.addArguments("--disable notifications");

		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
	}
}
