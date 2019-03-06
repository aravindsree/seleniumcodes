package seleniumJavaFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {

	public static void main(String[] args) {
		
	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aravind\\eclipse-workspace\\seleniumJavaFramework\\drivers\\geckodriver\\geckodriver.exe");	
	//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aravind\\eclipse-workspace\\seleniumJavaFramework\\drivers\\chromedriver\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://seleniumhq.org/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		//driver.quit();
		
	}
	
}
