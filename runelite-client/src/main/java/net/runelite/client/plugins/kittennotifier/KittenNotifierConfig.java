package net.runelite.client.plugins.kittennotifier;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("kittennotifier")
public interface KittenNotifierConfig extends Config
{
	@ConfigItem
	(
		keyName = "kittenNeeds",
		name = "Notify on Kitten Needs",
		description = "Notify when your kitten needs attention or food."
	)
	default boolean kittenNeeds()
	{
		return true;
	}

}
