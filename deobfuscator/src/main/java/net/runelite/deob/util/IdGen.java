package net.runelite.deob.util;

public class IdGen
{
	private int cur = 1;
	
	public synchronized int get()
	{
		return cur++;
	}
}
