package net.runelite.runesuite;

import java.util.List;

public class HookMethod
{
	String method;
	String owner;
	String name;
	List<String> parameters;
	String descriptor;

	@Override
	public String toString()
	{
		return method +
				owner +
				name;
	}
}
