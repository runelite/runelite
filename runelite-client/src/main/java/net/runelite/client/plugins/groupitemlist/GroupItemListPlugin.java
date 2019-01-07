package net.runelite.client.plugins.groupitemlist;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuOpened;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@PluginDescriptor(
	name = "Group Item List",
	description = "Group the right click menu of a pile of items.",
	tags = {"ground", "compress", "pile", "group"},
	enabledByDefault = false
)

/**
 * Main class of plugin - Groups duplicate right click menu options to singular entries with a quantity.
 */
public class GroupItemListPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private GroupItemListConfig config;

	@Provides
	GroupItemListConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GroupItemListConfig.class);
	}

	/**
	 * Fired on a right click menu opening. Count all menu entries and build a new list of entries
	 * displaying item quantities.
	 *
	 * @param menu Right click menu opened
	 */
	@Subscribe
	public void onMenuOpened(MenuOpened menu)
	{
		LinkedHashMap<MenuEntry, GroupedItem> entryCount = new LinkedHashMap<>();
		ArrayList<MenuEntry> temp = new ArrayList<>();
		MenuEntry[] updatedMenuEntries;

		// Iterate over menu entries
		for (MenuEntry e : menu.getMenuEntries())
		{

			// Increment the count if entry has been seen before and refers to an item
			if (entryCount.containsKey(e) && isItem(e))
			{
				entryCount.get(e).incrementCount();
			}

			// Store in map if entry has not been seen before
			else
			{
				entryCount.put(e,
					new GroupedItem(e, config.getPositionConfig(), config.getStyleConfig(), config.includeX())
				);
			}
		}

		// Create a list of updated menu entries from the map of GroupedItem
		for (MenuEntry e : entryCount.keySet())
		{
			MenuEntry entry = entryCount.get(e).getEntry();
			temp.add(entry);
		}

		// Parse to an array and set the new menu entries
		updatedMenuEntries = temp.toArray(new MenuEntry[0]);
		client.setMenuEntries(updatedMenuEntries);
	}

	/**
	 * Tests whether a menu entry refers to an item.
	 *
	 * @param e MenuEntry to be tested
	 * @return boolean result
	 */
	private boolean isItem(MenuEntry e)
	{
		String option = e.getOption();
		return option.equals("Take") || option.equals("Examine");
	}
}
