#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "exampleplugin",
	name = "Example plugin",
	description = "Configuration for example plugin"
)
public interface ExamplePluginConfiguration extends Config
{
	@ConfigItem(
		keyName = "enabled",
		name = "Enable overlay",
		description = "Configures whether the overlay is enabled"
	)
	default boolean enabled()
	{
		return true;
	}
}
