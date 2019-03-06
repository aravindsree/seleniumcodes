package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		
		googleSearch();
		
	} 	
	
	public static void googleSearch() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aravind\\eclipse-workspace\\seleniumJavaFramework\\drivers\\chromedriver\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
			
			//goto google
		
		driver.get("https://google.com");
		
			//Enter into search
		driver.findElement(By.name("q")).sendKeys("Aravind Ramachandran");
		
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//close browser
		
		driver.close();
		
		System.out.println("Test OK");
	
	}

	}


