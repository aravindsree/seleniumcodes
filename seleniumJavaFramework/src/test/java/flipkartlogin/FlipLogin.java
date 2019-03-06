package flipkartlogin;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class FlipLogin {
	
	public static WebDriver driver;
	public static String driverPath = "C:\\workspace\\tools\\selenium\\";
	public static String sBookKey = "Selenium";
 

	public static void initWebDriver(String URL) throws InterruptedException {

		// Setting up Chrome driver path.
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		// Launching Chrome browser.
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}

	public static void main(String[] args) throws InterruptedException {

		initWebDriver("http://www.flipkart.com");

		flipkartLogin();
		
		driver.findElement(By.className("LM6RPg")).sendKeys("casio" + Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.className("_2mylT6")).click();
		Thread.sleep(2000);
 

		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iter = windowIds.iterator();
		
		String mainWindow = iter.next();
		String childWindow = iter.next();
		
		driver.switchTo().window(childWindow);
		
		System.out.println("Title"+ driver.getTitle());
		
		Thread.sleep(3000);

		
		//driver.findElement(By.className("_3X4tVa")).sendKeys("695001");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[3]/button")).click();


		
		
		//driver.findElement(By.className("_2HNZdt")).click();
		Thread.sleep(5000);
		endSession();
		 
	}

	public static WebElement getElement(final By locator) {
		@SuppressWarnings("deprecation")
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver arg0) {
				return arg0.findElement(locator);
			}

		});

		return element;
	}

	public static void flipkartLogin() {
		driver.findElement(By.className("_29YdH8")).click();
		//driver.findElement(By.className("_29YdH8")).click();
		driver.findElement(By.linkText("Login & Signup")).click();

		// TBD: Fill your username/password of flipkart  .
		driver.findElement(By.className("_2zrpKA")).sendKeys("getmeatme@gmail.com");
		driver.findElement(By.className("_3v41xv")).sendKeys("sreedevu007");
		driver.findElement(By.className("_7UHT_c")).click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TBD: Auto-generated catch block.
			e.printStackTrace();
		}
	}

	public static void endSession() {
		driver.close();
		driver.quit();
	}

}
