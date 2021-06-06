package mypackage;

import java.util.Map;

public class MyClass {

	public String Namex =  this.getClass().getSimpleName();
	
	public static void main(String args[]) throws Exception
	{

		
		//MyTest1 myt = new MyTest1();
		//myt.testing123();

		System.out.println("class name:" + TestA.class.getSimpleName());
		
		StackTraceElement[] stack = Thread.currentThread ().getStackTrace ();
		StackTraceElement main = stack[stack.length - 1];
		String mainClass = main.getClassName();
		
		System.out.println("main class" + mainClass);
		
		//String className = this.getClass().getSimpleName();
		
	
	}
}
