package net.runelite.client.plugins.xpglobes;

import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

/**
 * Created by Steve on 6/17/2017.
 */
@ConfigGroup(
		keyName = "xpglobes",
		name = "XP Globes",
		description = "Configuration for the xp globes plugin"
)
public interface XpGlobesConfig
{
	@ConfigItem(
			keyName = "enabled",
			name = "Enabled",
			description = "Configures whether or not xp globes are displayed"
	)
	default boolean enabled()
	{
		return true;
	}
}
