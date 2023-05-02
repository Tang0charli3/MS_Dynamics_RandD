package testMsd;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PieChartAutomation {
	public static void main(String args[]) throws InterruptedException{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
	 WebDriver driver=new ChromeDriver(opt);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
	 driver.get("https://www.w3schools.com/howto/howto_google_charts.asp");
	 Thread.sleep(5000);
	 driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@src='tryhow_google_pie_chart.htm']")));
	 String expectedTooltip = "Github"; 
//	    //*[@aria-label='A chart.']/*
	 List<WebElement> element=driver.findElements(By.xpath(".//*[@id='piechart']/div/div/div/*[name()='svg']/*[name()='g']/*[name()='text']"));
	 
	 System.out.println(element);
	 Thread.sleep(5000);
	 System.out.println(element.size());
	 for(WebElement ele: element) {
		 System.out.println(ele.getText());
	 }
	 Thread.sleep(5000);

	    
	     
//	    String actualTooltip = github.getText(); 
	    
	    //Assert the tooltip's value is as expected   
//	    System.out.println("Actual Title of Tool Tip"+actualTooltip);       
//	    if(actualTooltip.equals(expectedTooltip)) {       
//	        System.out.println("Test Case Passed");     
//	    }  
	    driver.quit(); 
	}
}
