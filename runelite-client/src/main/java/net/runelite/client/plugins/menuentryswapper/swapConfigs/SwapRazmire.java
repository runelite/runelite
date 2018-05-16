package net.runelite.client.plugins.menuentryswapper.swapConfigs;

public enum SwapRazmire
{
	OFF("Off"),
	GENERAL("General"),
	BUILDERS("Builders");

	private final String name;

	SwapRazmire(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
