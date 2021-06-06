package mypackage;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MyClass {

	public String Namex =  this.getClass().getSimpleName();
	
	public static void main(String args[]) throws Exception
	{
		String key;
		DesiredCapabilities caps = new DesiredCapabilities();
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "chrome");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
		capsHashtable.put("build", "a suitename");
		capsHashtable.put("name", "Test_Thread");
		
		Set<String> keys = capsHashtable.keySet();
		Iterator<String> itr = keys.iterator();
		
		while (itr.hasNext())
		{
			key = itr.next();
			caps.setCapability(key, capsHashtable.get(key));
			System.out.println(key + ": " + capsHashtable.get(key));
		}
		
		String kstr;
		Set<String> k = caps.getCapabilityNames();
		Iterator<String> kitr = k.iterator();
		while(kitr.hasNext())
		{
			kstr = kitr.next();
			System.out.println(kstr + ":: " + caps.getCapability(kstr));
		}
		
	
	}
}
