package net.runelite.client.plugins;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PluginCategory
{
	RUNELITE("RuneLite"),
	ACTIVITY("Activity"),
	CHAT("Chat"),
	CLIENT("Client"),
	COMBAT("Combat"),
	ITEM("Item"),
	MINIGAME("Minigame"),
	SKILLS("Skills"),
	UTILITY("Utility"),
	UNCATEGORISED("Uncategorised"),
	;

	private final String category;

	@Override
	public String toString()
	{
		return category;
	}
}
