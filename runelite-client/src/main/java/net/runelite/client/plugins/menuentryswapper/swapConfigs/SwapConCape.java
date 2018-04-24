package net.runelite.client.plugins.menuentryswapper.swapConfigs;

public enum SwapConCape
{
	TELEPOH("Tele to POH"),
	TELE("Teleport");

	private final String name;

	SwapConCape(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
