package testMsd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimulateMobileView {
public static void main(String[] args) {
	ChromeOptions options = new ChromeOptions();
    options.addArguments("--window-size=393,851");
//    options.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1");
//    options.addArguments("--enable-viewport");
//    options.addArguments("--touch-events");
//    options.addArguments("--disable-dev-shm-usage");
//    options.addArguments("--no-sandbox");
    WebDriver driver = new ChromeDriver(options);
//    driver.get("https://fireflink.com/");
      driver.get("https://iiit-h.talentsprint.com/aiml/test/");
}
}
