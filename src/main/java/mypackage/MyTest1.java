package mypackage;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;



public class MyTest1
{


	@Test
	public void testing123()
	{
		System.out.println("start testing");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		System.out.println("URL: " + driver.getCurrentUrl());
		
		driver.quit();
		Assert.assertEquals(true,  true, "testing");
		
		
	}
	
	
}
