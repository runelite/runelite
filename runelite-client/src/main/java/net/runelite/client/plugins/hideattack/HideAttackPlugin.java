package net.runelite.client.plugins.hideattack;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Hide Attack",
	description = "Hide attack menu option",
	tags = {"attack", "hide", "friends", "clan"},
	enabledByDefault = false
)
public class HideAttackPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private HideAttackConfig config;

	@Inject
	private ShiftClickInputListener inputListener;

	@Inject
	private KeyManager keyManager;

	@Getter
	private boolean configuringShiftClick = false;

	@Setter
	private boolean shiftModifier = false;

	@Provides
	HideAttackConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HideAttackConfig.class);
	}

	@Override
	public void startUp()
	{
		keyManager.registerKeyListener(inputListener);
	}

	@Override
	public void shutDown()
	{
		keyManager.unregisterKeyListener(inputListener);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final int eventId = event.getIdentifier();
		final String option = Text.removeTags(event.getOption()).toLowerCase();

		Player[] players = client.getCachedPlayers();
		Player player = null;

		if (eventId >= 0 && eventId < players.length)
		{
			player = players[eventId];
		}

		if (option.equals("attack"))
		{
			if (player == null)
			{
				return;
			}

			if (config.shiftWalk() && shiftModifier || config.shiftWalk() && shiftModifier)
			{
				removeAttack(option);
			}
			if (config.swapAttack() == AttackMode.OFF)
			{
				return;
			}
			else if (config.swapAttack() == AttackMode.SWAP_ATTACK && player.isClanMember())
			{
				swapAttack(option);
			}
			else if (config.swapAttack() == AttackMode.REMOVE_ATTACK && player.isClanMember())
			{
				removeAttack(option);
			}
		}
	}

	/**
	 * Find the element for entries array
	 *
	 * @param entries menu entry
	 * @param option  right-click option to be found
	 * @return element of array
	 */
	private int findIndex(MenuEntry[] entries, String option)
	{
		for (int i = 0; i < entries.length; i++)
		{
			MenuEntry entry = entries[i];
			String entryOption = Text.removeTags(entry.getOption()).toLowerCase();
			if (entryOption.contains(option.toLowerCase()))
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * Swap Attack and Walk here values
	 *
	 * @param optionB Attack option
	 */
	private void swapAttack(String optionB)
	{
		MenuEntry[] entries = client.getMenuEntries();

		int walkHere = findIndex(entries, "walk here");
		int attack = findIndex(entries, optionB);

		if (walkHere >= 0 || attack >= 0)
		{
			//swap
			MenuEntry entry = entries[walkHere];
			entries[walkHere] = entries[attack];
			entries[attack] = entry;

			client.setMenuEntries(entries);
		}
	}

	/**
	 * Remove the Attack option from right-click menu
	 *
	 * @param optionB Attack option
	 */
	private void removeAttack(String optionB)
	{
		MenuEntry[] entries = client.getMenuEntries();
		int attack = findIndex(entries, optionB);

		MenuEntry[] newEntry = new MenuEntry[entries.length - 1];

		// remove
		int j = 0;
		for (int i = 0; i < entries.length; i++)
		{
			if (i != attack)
			{
				newEntry[j++] = entries[i];
			}
		}
		client.setMenuEntries(newEntry);
	}
}
