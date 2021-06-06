package mypackage;

import static org.testng.Assert.assertThrows;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;



public class MyTest1
{


	@Test
	public void testing123()
	{
		try
		{
			System.out.println("start testing");
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe"); 
			WebDriver driver = new ChromeDriver();
			driver.navigate().to("https://www.google.com/");
			System.out.println("URL: " + driver.getCurrentUrl());
			try
			{
				Assert.assertEquals(true,  driver.getCurrentUrl().contains("goodddgle"), "URL has google");
				System.out.println("success");
			}
			catch(Throwable t)
			{
				if(t.toString().contains("AssertionError"))
				{
					System.out.println("fail");
				}
				else
				{
					t.printStackTrace();
				}
			}

			driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
