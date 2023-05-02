package testMsd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ExistingChromeExample {
    public static void main(String[] args) throws Exception {
    	long start = System.currentTimeMillis();
    	Thread.sleep(5000);
    	long end = System.currentTimeMillis();
    	NumberFormat formatter = new DecimalFormat("#0.00000");
    	System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }
}
