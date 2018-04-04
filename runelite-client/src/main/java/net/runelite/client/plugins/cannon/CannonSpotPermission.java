package net.runelite.client.plugins.cannon;

public enum CannonSpotPermission
{

	ALWAYS("Always"),
	HOLDING_CANNON("Holding cannon"),
	NEVER("Never");

	private final String name;

	CannonSpotPermission(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
