package net.runelite.client.events;

import lombok.Value;
import net.runelite.client.plugins.Plugin;

@Value
public class PluginConfigClicked
{
	Class<? extends Plugin> pluginClass;
}
