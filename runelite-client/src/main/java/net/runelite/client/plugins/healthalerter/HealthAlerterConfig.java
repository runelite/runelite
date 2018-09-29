package net.runelite.client.plugins.healthalerter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(HealthAlerterPlugin.CONFIG_GROUP)
public interface HealthAlerterConfig extends Config {

    @ConfigItem(
            keyName = "healthAlert",
            name = "Alert at Health",
            description = "At which hp level you should be alerted",
            position = 0
    )

    default int healthAlert() {
        return 0;
    }

}
