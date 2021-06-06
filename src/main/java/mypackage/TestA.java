package mypackage;

import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class TestA
{
	public void executeTest(Hashtable<String, String> capsHashtable)
	{
		String key;
		DesiredCapabilities caps = new DesiredCapabilities();
		// Iterate over the hashtable and set the capabilities
		Set<String> keys = capsHashtable.keySet();
		Iterator<String> itr = keys.iterator();
		while (itr.hasNext())
		{
			key = itr.next();
			caps.setCapability(key, capsHashtable.get(key));
			
		}
		print_DesiredCapabilities(caps);
		
		WebDriver driver;
		
		try {
			driver = new RemoteWebDriver(new URL(BrowserStackConfiguration.URL), caps);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// Searching for 'BrowserStack' on google.com
			driver.get("https://www.google.com");
			WebElement element = driver.findElement(By.name("q"));
			element.sendKeys("BrowserStack");
			element.submit();

			// Setting the status of test as 'passed' or 'failed' based on the condition; if
			// title of the web page contains 'BrowserStack'
			// WebDriverWait wait = new WebDriverWait(driver, 5);
			try
			{
				Assert.assertEquals(true, driver.getCurrentUrl().contains("goodddgle"));
				// wait.until(ExpectedConditions.titleContains("BrowserStack"));
				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
			} catch (Throwable e) {
				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
			}
			System.out.println(driver.getTitle());
			driver.quit();
		}
		// catch (MalformedURLException e)
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void print_DesiredCapabilities(DesiredCapabilities dcaps)
	{
		String key;
		Set<String> dcaps_keys = dcaps.getCapabilityNames();
		Iterator<String> itr = dcaps_keys.iterator();
		while(itr.hasNext())
		{
			key = itr.next();
			System.out.println(key + ": " + dcaps.getCapability(key));
		}
	}
}

