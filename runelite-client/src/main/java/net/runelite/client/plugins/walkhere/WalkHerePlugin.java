package net.runelite.client.plugins.walkhere;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.*;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOpened;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

import javax.inject.Inject;

@PluginDescriptor(name = "Walk Here")
public class WalkHerePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private WalkHereConfig config;

	@Inject
	private WalkHereInput inputListener;

	@Inject
	private KeyManager keyManager;

	private boolean shouldClear = false;

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !shouldClear)
		{
			return;
		}

		String option = Text.removeTags(event.getOption()).toLowerCase();

		if (option.equals("attack") || option.equals("talk-to"))
		{
			removeOption(option);
		}
	}

	private void removeOption(String option)
	{
		MenuEntry[] entries = client.getMenuEntries();

	}
}
