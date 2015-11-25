package net.runelite.deob.execution.two;

public class TestClass
{
	int i;
	
	public void init()
	{
		method5(this);
	}
	
	static void method5(TestClass tc)
	{
		tc.method6();
	}
	
	void method6()
	{
		if (i > 42)
		{
			int i = 5 + 6;
			method7();
		}
	}
	
	void method7()
	{
		
	}
}