package net.runelite.client.plugins.bankcontents;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Bank Contents",
	description = "Export the contents of your bank and/or current tab",
	tags = {"grand", "exchange", "high", "alchemy", "prices", "bank"}
)
public class BankContentsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private BankContentsConfig config;
	
	@Inject BankContents bankContents;

	@Provides
	BankContentsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BankContentsConfig.class);
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (!event.getEventName().equals("setBankTitle"))
		{
			return;
		}

		bankContents.createArray();
	}



}
