
package net.runelite.client.plugins.wiki;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.plugins.wiki.config.WikiLeftClickOption;

@ConfigGroup("wiki")
public interface WikiConfig extends Config
{
	@ConfigItem(
		keyName = "leftClickOption",
		name = "Left click option",
		description = "Configures the default left click option of the wiki button",
		position = 1
	)
	default WikiLeftClickOption leftClickOption()
	{
		return WikiLeftClickOption.LOOKUP;
	}
}