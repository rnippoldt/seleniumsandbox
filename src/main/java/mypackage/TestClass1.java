package mypackage;

import java.util.Hashtable;

class TestClass1 implements Runnable
{	
	private Hashtable<String, String> capsHashtable;
	private String buildname;
	
	public TestClass1(String buildname)
	{		
		if(buildname.length() > 1 )
		{
			this.buildname = buildname;
		}
		else
		{
			this.buildname = "unknownAZZA";
		}
	}
		
	
	public void run()
	{		
		test_configuration();
		
		TestB testB = new TestB();
		capsHashtable.put("name", testB.getClass().getSimpleName());
		testB.executeTest(capsHashtable);
		
		TestA testA = new TestA();
		capsHashtable.put("name", testA.getClass().getSimpleName());
		testA.executeTest(capsHashtable);	
	}
	
	
	public void test_configuration()
	{
		capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "chrome");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
		capsHashtable.put("build", buildname);     //build is the suite name
		capsHashtable.put("name", "Test_Thread");  //name is name of the test or test thread
	}
	
	
	
	
	public Hashtable<String, String> getCapsHashtable() {
		return capsHashtable;
	}

	public void setCapsHashtable(Hashtable<String, String> capsHashtable) {
		this.capsHashtable = capsHashtable;
	}

	public String getBuildname() {
		return buildname;
	}

	public void setBuildname(String buildname) {
		this.buildname = buildname;
	}
	
	
}
