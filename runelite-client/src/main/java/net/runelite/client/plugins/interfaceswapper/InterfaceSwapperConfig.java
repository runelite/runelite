package net.runelite.client.plugins.interfaceswapper;


import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		name = "Interface Swapper",
		keyName = "interfaceswapper",
		description = "Configuration for swapping interfaces"
)
public interface InterfaceSwapperConfig extends Config
{
	@ConfigItem(
			position = 1,
			keyName = "horizontalSwap",
			name = "Swap Horizontal",
			description = "Swap the interfaces horizontal"
	)
	default boolean horizontalSwap()
	{
		return false;
	}

	@ConfigItem(
			position = 2,
			keyName = "verticalSwap",
			name = "Swap Vertical",
			description = "Swap the interfaces vertical"
	)
	default boolean verticalSwap()
	{
		return false;
	}
}
