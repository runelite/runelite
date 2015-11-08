package net.runelite.deob.util;

public class IdGen
{
	private volatile int cur;
	
	public synchronized int get()
	{
		return cur++;
	}
}
