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
		
		TestB r1 = new TestB();
		capsHashtable.put("name", r1.getClass().getSimpleName());
		r1.executeTest(capsHashtable);
		
		TestA r2 = new TestA();
		capsHashtable.put("name", r2.getClass().getSimpleName());
		r2.executeTest(capsHashtable);	
	}
	
	
	public void test_configuration()
	{
		capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "chrome");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
		capsHashtable.put("build", buildname);
		capsHashtable.put("name", "Test_Thread");  //reset in run()
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
