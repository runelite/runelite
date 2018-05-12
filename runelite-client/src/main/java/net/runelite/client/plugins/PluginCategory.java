package net.runelite.client.plugins;

public enum PluginCategory
{
	COMBAT("Combat"),
	SKILLS("Skills"),
	ITEM("Item"),
	ACTIVITY("Activity"),
	MINIGAME("Minigame"),
	UTILITY("Utility"),
	CLIENT("Client");

	private final String category;

	PluginCategory(final String category)
	{
		this.category = category;
	}

	@Override
	public String toString()
	{
		return category;
	}
}
