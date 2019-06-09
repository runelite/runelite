package net.runelite.runesuite;

public class HookMethod
{
	String method;
	String owner;
	String name;
	int access;
	String[] parameters;
	String descriptor;

	@Override
	public String toString()
	{
		return method +
				owner +
				name;
	}
}
