package net.runelite.deob.execution.one;

public class TestClass
{
	int i;
	
	public void init()
	{
		method1(this);
	}
	
	static void method1(TestClass tc)
	{
		tc.method2();
	}
	
	void method2()
	{
		if (i > 42)
		{
			int i = 5 + 6;
			method3();
		}
	}
	
	void method3()
	{
		
	}
}