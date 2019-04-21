package net.runelite.client.plugins.kittennotifier;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("kittennotifier")
public interface KittenNotifierConfig extends Config{
    @ConfigItem(
            keyName = "absolutelyNeeded",
            name = "Notify only on Absolute Need",
            description = "Only notify when kitten absolutely needs food or attention."
    )
    default boolean absolutelyNeeded() { return false; }
    @ConfigItem(
            keyName = "catOwned",
            name = "",
            description = "",
            hidden = true
    )
    default boolean catOwned() { return false; }
}
