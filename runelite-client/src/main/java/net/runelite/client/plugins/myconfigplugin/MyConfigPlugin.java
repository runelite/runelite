package net.runelite.client.plugins.myconfigplugin;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "My Config Plugin",
	description = "My plugin with configs"
)

@Slf4j
public class MyConfigPlugin extends Plugin
{
	@Inject
	private MyConfig myConfig;

	@Provides
	MyConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MyConfig.class);
	}
	@Subscribe
	public void onConfigChanged(ConfigChanged event){
		System.out.println("Welcome, " + myConfig.nickname());
		System.out.println("Good luck on your goal level of: " + myConfig.goalLevel());

	}
}
