package net.runelite.client.plugins.xericstalisman;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "xericstalisman",
	name = "Xeric's Talisman",
	description = "Configuration for the Xeric's Talisman plugin"
)
public interface XericsTalismanConfig extends Config
{
	@ConfigItem(
		keyName = "hideOriginalTeleportName",
		name = "Hide Original Teleport Name",
		description = "Hide the original text and only show the actual location."
	)
	default boolean hideOriginalTeleportName() { return false; }

	@ConfigItem(
		keyName = "hideMenuActionTargetForTeleports",
		name = "Hide Item Name Suffix For Teleports",
		description = "Hide the 'Xeric's talisman' suffix on each teleport menu action."
	)
	default boolean hideMenuActionTargetForTeleports() { return true; }
}
