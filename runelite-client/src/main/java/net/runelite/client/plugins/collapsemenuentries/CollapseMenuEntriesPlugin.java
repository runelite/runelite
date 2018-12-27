package net.runelite.client.plugins.collapsemenuentries;

import net.runelite.client.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuOpened;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ColorUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Slf4j
@PluginDescriptor(
		name = "Collapse Menu Entries",
		description = "Collapse duplicate context menu entries on ground items, reducing clutter.",
		tags = {"collapse", "item", "context", "ground", "menu", "entries"}
)
public class CollapseMenuEntriesPlugin extends Plugin {

	static class ItemOption {
		protected String option = "";
		protected String target = "";
		protected int numOccurrences = 1;
		protected boolean bProcessedInRebuild = false;
	}

	public final static String COUNT_PREFIX = " (x",
							   COUNT_SUFFIX = ")";

	public final static int GROUND_ITEM_OPTION_1 = 20,
						    GROUND_ITEM_OPTION_2 = 21,
						    GROUND_ITEM_OPTION_3 = 22,
							GROUND_ITEM_EXAMINE = 1004;

	@Inject
	private Client client;
	@Inject
	private CollapseMenuEntriesConfig config;

	private HashMap<Integer, ArrayList<ItemOption>> optionMap;

	@Override
	protected void startUp() {
		optionMap = new HashMap<>();
	}

	@Subscribe
	public void onMenuOpened(MenuOpened event) {
		MenuEntry[] menuEntries = client.getMenuEntries();
		int numOptionsCulled = buildOptionMap(menuEntries);

		if (numOptionsCulled > 0) {
			rebuildContextMenu(menuEntries, numOptionsCulled);
		}
	}

	/**
	 * Populates the option map with data from the current context menu.
	 * @param menuEntries - The client's array of menu entries.
	 * @return The number of duplicate options that'll be culled from the final menu.
	 **/
	private int buildOptionMap(MenuEntry[] menuEntries) {
		optionMap.clear();

		int numOptionsCulled = 0;

		for (int i = 0; i != menuEntries.length; i++) {
			MenuEntry entry = menuEntries[i];

			if (isGroundItemOption(entry) == false) {
				continue;
			}

			int itemID = entry.getIdentifier();

			if (optionMap.containsKey(itemID)) {
				ArrayList<ItemOption> itemOptions = optionMap.get(itemID);
				Iterator<ItemOption> optionIterator = itemOptions.iterator();
				boolean bFoundOption = false;

				while (optionIterator.hasNext()) {
					ItemOption itemOption = optionIterator.next();

					if (entry.getOption().equals(itemOption.option)) {
						itemOption.numOccurrences++;
						numOptionsCulled++;
						bFoundOption = true;
						break;
					}
				}

				if (bFoundOption == false) {
					ItemOption newOption = new ItemOption();
					newOption.option = entry.getOption();
					newOption.target = entry.getTarget();
					itemOptions.add(newOption);
				}
			}
			else {
				ArrayList<ItemOption> newOptionList = new ArrayList<>();

				ItemOption newOption = new ItemOption();
				newOption.option = entry.getOption();
				newOption.target = entry.getTarget();

				newOptionList.add(newOption);
				optionMap.put(itemID, newOptionList);
			}
		}
		return numOptionsCulled;
	}

	/**
	 * Creates the new slimmed-down context menu based on the option map.
	 * @param menuEntries - The client's array of menu entries.
	 * @param numOptionsCulled - The number of duplicate options that'll be culled from the final menu.
	 **/
	private void rebuildContextMenu(MenuEntry[] menuEntries, int numOptionsCulled) {
		MenuEntry[] newMenuEntries = new MenuEntry[menuEntries.length - numOptionsCulled];
		int newEntryIndex = 0;

		for (int i = 0; i != menuEntries.length; i++) {
			MenuEntry entry = menuEntries[i];

			if (isGroundItemOption(entry)) {
				int itemID = entry.getIdentifier();
				ArrayList<ItemOption> itemOptions = optionMap.get(itemID);
				Iterator<ItemOption> optionIterator = itemOptions.iterator();

				while (optionIterator.hasNext()) {
					ItemOption itemOption = optionIterator.next();

					if (entry.getOption().equals(itemOption.option)) {
						if (itemOption.bProcessedInRebuild == false) {
							if (itemOption.numOccurrences > 1 && config.showNumber()) {
								entry.setTarget(itemOption.target + "</col>" + ColorUtil.wrapWithColorTag(COUNT_PREFIX + itemOption.numOccurrences + COUNT_SUFFIX, config.collapsedColour()));
							}
							itemOption.bProcessedInRebuild = true;
							newMenuEntries[newEntryIndex++] = entry;
						}
					}
				}
			}
			else {
				newMenuEntries[newEntryIndex++] = entry;
			}
		}

		client.setMenuEntries(newMenuEntries);
	}

	/**
	 * Returns true if the provided MenuEntry regards an item. Checks the entry's type - this should equal 20, 21, 22, or 1004 for ground items.
	 * These are declared as named constants.
	 * @param entry - The menu entry.
	 **/
	private boolean isGroundItemOption(MenuEntry entry) {
		int type = entry.getType();

		return type == GROUND_ITEM_OPTION_1 || type == GROUND_ITEM_OPTION_2 || type <= GROUND_ITEM_OPTION_3 || type == GROUND_ITEM_EXAMINE;
	}

	@Provides
	CollapseMenuEntriesConfig getConfig(ConfigManager configManager) {
		return configManager.getConfig(CollapseMenuEntriesConfig.class);
	}
}