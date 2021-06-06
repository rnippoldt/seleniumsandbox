package mypackage;


public class SuiteTest_A
{
	public static void main(String[] args) throws Exception
	{	
		String className = new SuiteTest_A().getClass().getSimpleName();
		Thread object1 = new Thread(new TestClass1(className));
		object1.start();
		
		//Thread object2 = new Thread(new TestClass_TestA());
		//object2.start();
		
		//Thread object3 = new Thread(new TestClass3());
		//object3.start();
	}

}
