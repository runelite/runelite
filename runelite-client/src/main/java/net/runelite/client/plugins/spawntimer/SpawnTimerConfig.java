package net.runelite.client.plugins.spawntimer;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("spawntimer")
public interface SpawnTimerConfig extends Config 
{
	@ConfigItem(
		position = 1,
		keyName = "npcToHighlight",
		name = "NPCs to show timer for",
		description = "List of NPC names to show timer for"
	)
	default String getNpcToHighlight()
	{
		return "";
	}

	@ConfigItem(
		position = 2,
		keyName = "npcColor",
		name = "Text Color",
		description = "Color of the NPC timer"
	)
	default Color getHighlightColor()
	{
		return Color.RED;
	}
}