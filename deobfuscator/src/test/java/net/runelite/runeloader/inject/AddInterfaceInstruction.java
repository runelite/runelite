package net.runelite.runeloader.inject;

public class AddInterfaceInstruction
{
	private final String clientClass;
	private final String interfaceClass;

	public AddInterfaceInstruction(String var1, String var2)
	{
		this.clientClass = var1;
		this.interfaceClass = var2;
	}

	public String getClientClass()
	{
		return this.clientClass;
	}

	public String getInterfaceClass()
	{
		return this.interfaceClass;
	}
}
