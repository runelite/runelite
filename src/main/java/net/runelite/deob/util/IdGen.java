package net.runelite.deob.util;

public class IdGen
{
	private volatile int cur = 1;
	
	public synchronized int get()
	{
		return cur++;
	}
}
