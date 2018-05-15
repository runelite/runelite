package net.runelite.client.plugins.ammooverlay;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "ammooverlay",
		name = "Ammo Overlay",
		description = "Configures the ammo overlay plugin"
)
public interface AmmoOverlayConfig extends Config
{
	@ConfigItem(
			keyName = "showOnlyIfRangeWeaponEquipped",
			name = "Show only if range weapon equipped",
			description = "Configures whether or not to show overlay when a ranged weapon is equipped."
	)
	default boolean showOnlyIfRangeWeaponEquipped()
	{
		return true;
	}

	@ConfigItem(
			keyName = "lowAmmoQuantity",
			name = "Low Ammo Quantity",
			description = "Configures the amount of ammo to consider as low ammo"
	)
	default int lowAmmoQuantity()
	{
		return 25;
	}
}
