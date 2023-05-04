package testMsd;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MsdPieChart {
public static void main(String[] args) throws IOException, InterruptedException {
	String msDURL="https://org8f00a0bb.crm8.dynamics.com/main.aspx?appid=da2eb7f0-71e6-ed11-a7c6-6045bdada75a&pagetype=dashboard&id=eaa6e6bb-4712-ec11-b6e7-00224820f09b&type=system&_canOverride=true";
	String dir="C:\\ChromeDataForMSD";
	String cmdCommand = "chrome.exe -remote-debugging-port=2708 --no-first-run --no-default-browser-check --user-data-dir="+dir;
	String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
	String firstName="Alpha";
	Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
	Thread.sleep(500);
	System.setProperty("webdriver.http.factory", "jdk-http-client");
	
//	Connect to launched browser	
	ChromeOptions opt = new ChromeOptions();
	opt.setExperimentalOption("debuggerAddress", "localhost:2708");
	opt.addArguments("--disable notifications");
	opt.addArguments("--remote-allow-origins=*");
//	
	WebDriver driver = new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(msDURL);
	Thread.sleep(5000);
	int total=0;
//	//div[contains(@class,'chartcontainer')]//*[name()='svg']//*[name()='g']//*[name()='text']
	List<WebElement> element=driver.findElements(By.xpath("//div[contains(@class,'chartcontainer')]//*[name()='svg']//*[name()='g']//*[name()='text']"));
	 for(WebElement ele: element) {
		 System.out.println(ele.getText());
	int num=Integer.parseInt(ele.getText());
	total += num;
		 
	 }
	 System.out.println(total);
	 System.out.println(element.size());
	Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	Runtime.getRuntime().exec("taskkill /F /FI \"WINDOWTITLE eq Terminal\"");
	driver.findElement(By.xpath("//span[text()='Leads']")).click();
	driver.findElement(By.xpath("//span[text()='Edit columns']")).click();
	driver.findElement(By.xpath("//span[text()='Add columns']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Lead Source");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[text()='Lead Source']")).click();
	driver.findElement(By.xpath("//span[text()='Close']")).click();
	driver.findElement(By.xpath("//span[text()='Apply']")).click();
	String leadSource = "//div[@class='ag-center-cols-container']//div[@aria-label='Press SPACE to select this row.']//div[@aria-colindex='6']//label";
	List<WebElement> source=driver.findElements(By.xpath(leadSource));
	for(WebElement ele : source) {
		System.out.println(ele.getText());
	}
	int Partner=0;
	int PublicRelations=0;
	int TradeShow=0;
	int Other=0;
	int Seminar=0;
	int EmployeeReferral=0;
	int WordofMouth=0;
	int ExternalReferral=0;
	for( WebElement ele : source) {
		String text=ele.getText();
		if (text.equals("Partner")) {
			Partner+=1;
		}
		else if(text.equals("Public Relations")) {
			PublicRelations+=1;
		}
		else if(text.equals("Trade Show")) {
			TradeShow+=1;
		}
		else if(text.equals("Other")) {
			Other+=1;
		}
		else if(text.equals("Seminar")) {
			Seminar+=1;
		}
		else if(text.equals("Employee Referral")) {
			EmployeeReferral+=1;
		}
		else if(text.equals("Word of Mouth")) {
			WordofMouth+=1;
		}
		else if(text.equals("External Referral")) {
			ExternalReferral+=1;
		}
		
	}
//	List<Integer> list = new ArrayList<Integer>();
//	list.add(Partner);
//	list.add(PublicRelations);
//	list.add(TradeShow);
//	list.add(Other);
//	list.add(Seminar);
//	list.add(EmployeeReferral);
//	list.add(WordofMouth);
//	list.add(ExternalReferral);
//	boolean result=list.equals(source);
//	System.out.println(result);
	System.out.println(source.size());
	System.out.println("Partner " + Partner);
	System.out.println("Public Relations " +PublicRelations);
	System.out.println("Trade Show "+ TradeShow);
	System.out.println("Other "+Other);
	System.out.println("Seminar "+ Seminar);
	System.out.println("Employee Referral "+ EmployeeReferral);
	System.out.println("Word of Mouth "+ WordofMouth);
	System.out.println("External Referral "+ ExternalReferral);
}
}
