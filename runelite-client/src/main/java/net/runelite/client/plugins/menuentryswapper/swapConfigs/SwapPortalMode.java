package net.runelite.client.plugins.menuentryswapper.swapConfigs;

public enum SwapPortalMode
{
	OFF("Off"),
	HOME("Home"),
	BUILD_MODE("Build mode");

	private final String name;

	SwapPortalMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
