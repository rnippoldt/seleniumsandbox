package mypackage;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import bsh.This;

import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;


class TestClass1 implements Runnable {
	
	
	
	public void run()
	{
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "chrome");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
		capsHashtable.put("build", "browserstack-build-2");
		capsHashtable.put("name", "Thread 1");
		
		capsHashtable.put("build", "SuiteTest_A");
						
		TestB r1 = new TestB();
		capsHashtable.put("name", r1.getClass().getSimpleName());
		r1.executeTest(capsHashtable);
		
		TestA r2 = new TestA();
		capsHashtable.put("name", r2.getClass().getSimpleName());
		r2.executeTest(capsHashtable);	
	}
}

//class T_TestA implements Runnable {
//	
//	public void run()
//	{
//		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
//		capsHashtable.put("browser", "chrome");
//		capsHashtable.put("browser_version", "latest");
//		capsHashtable.put("os", "Windows");
//		capsHashtable.put("os_version", "10");
//		capsHashtable.put("build", "browserstack-build-2");
//		capsHashtable.put("name", "Thread 1");
//		TestA r1 = new TestA();
//		r1.executeTest(capsHashtable);
//	}
//}

//class TestClass2 implements Runnable {
//	public void run() {
//		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
//		capsHashtable.put("browser", "firefox");
//		capsHashtable.put("browser_version", "latest");
//		capsHashtable.put("os", "Windows");
//		capsHashtable.put("os_version", "10");
//		capsHashtable.put("build", "browserstack-build-1");
//		capsHashtable.put("name", "Thread 2");
//		mainTestClass r2 = new mainTestClass();
//    	r2.executeTest(capsHashtable);
//  	}
//}

//class TestClass3 implements Runnable {
//	public void run() {
//		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
//		capsHashtable.put("browser", "safari");
//		capsHashtable.put("browser_version", "latest");
//		capsHashtable.put("os", "OS X");
//		capsHashtable.put("os_version", "Big Sur");
//		capsHashtable.put("build", "browserstack-build-1");
//		capsHashtable.put("name", "Thread 3");
//		mainTestClass r3 = new mainTestClass();
//    	r3.executeTest(capsHashtable);
//  	}
//}


public class SuiteTest_A {
	//public static final String USERNAME = "rossnippoldt_QApt7l";
	//public static final String AUTOMATE_KEY = "7yhzkp5vtmsLcff35fjN";
	//public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception
	{
		Thread object1 = new Thread(new TestClass1());
		object1.start();
		//Thread object2 = new Thread(new TestClass_TestA());
		//object2.start();
		
//		Thread object3 = new Thread(new TestClass3());
//		object3.start();
	}
//
//	public void executeTest(Hashtable<String, String> capsHashtable) {
//		String key;
//		DesiredCapabilities caps = new DesiredCapabilities();
//		// Iterate over the hashtable and set the capabilities
//		Set<String> keys = capsHashtable.keySet();
//		Iterator<String> itr = keys.iterator();
//		while (itr.hasNext()) {
//			key = itr.next();
//			caps.setCapability(key, capsHashtable.get(key));
//		}
//		WebDriver driver;
//		try {
//			driver = new RemoteWebDriver(new URL(URL), caps);
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//			// Searching for 'BrowserStack' on google.com
//			driver.get("https://www.google.com");
//			WebElement element = driver.findElement(By.name("q"));
//
//			element.sendKeys("BrowserStack");
//			element.submit();
//
//			// Setting the status of test as 'passed' or 'failed' based on the condition; if
//			// title of the web page contains 'BrowserStack'
//			// WebDriverWait wait = new WebDriverWait(driver, 5);
//			try {
//				Assert.assertEquals(true, driver.getCurrentUrl().contains("goodddgle"));
//				// wait.until(ExpectedConditions.titleContains("BrowserStack"));
//				jse.executeScript(
//						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
//			} catch (Throwable e) {
//				jse.executeScript(
//						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
//			}
//			System.out.println(driver.getTitle());
//			driver.quit();
//
//	
////	    	try
////			{
////				System.out.println("start testing");
////				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe"); 
////				WebDriver driverx = new ChromeDriver();
////				driverx.navigate().to("https://www.google.com/");
////				System.out.println("URL: " + driverx.getCurrentUrl());
////				
////				JavascriptExecutor jsex = (JavascriptExecutor)driverx;
////				try
////				{
////					Assert.assertEquals(true,  driverx.getCurrentUrl().contains("goodddgle"), "URL has google");
////					jsex.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
////					System.out.println("success");
////				}
////				catch(Throwable t)
////				{
////					
////					jsex.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
////				    driverx.quit();
////					if(t.toString().contains("AssertionError"))
////					{
////						System.out.println("fail");
////					}
////					else
////					{
////						t.printStackTrace();
////					}
////				}
////
////				driverx.quit();
////			}
////			catch(Exception e)
////			{
////				e.printStackTrace();
////			}
//
//		}
//		// catch (MalformedURLException e)
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
}
