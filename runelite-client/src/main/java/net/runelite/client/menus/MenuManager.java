/*
 * Copyright (c) 2017, Robin <robin.weymans@gmail.com>
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.menus;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import static net.runelite.api.MenuOpcode.MENU_ACTION_DEPRIORITIZE_OFFSET;
import net.runelite.api.NPCDefinition;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcActionChanged;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.events.PlayerMenuOptionsChanged;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.events.WidgetPressed;
import net.runelite.api.util.Text;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.EventBus;
import static net.runelite.client.menus.ComparableEntries.newBaseComparableEntry;

@Singleton
@Slf4j
public class MenuManager
{
	/*
	 * The index needs to be between 4 and 7,
	 */
	private static final int IDX_LOWER = 4;
	private static final int IDX_UPPER = 8;

	private final Client client;
	private final EventBus eventBus;

	//Maps the indexes that are being used to the menu option.
	private final Map<Integer, String> playerMenuIndexMap = new HashMap<>();
	//Used to manage custom non-player menu options
	private final Multimap<Integer, WidgetMenuOption> managedMenuOptions = HashMultimap.create();
	private final Set<String> npcMenuOptions = new HashSet<>();
	private final Set<AbstractComparableEntry> priorityEntries = new HashSet<>();
	private final Map<MenuEntry, AbstractComparableEntry> currentPriorityEntries = new LinkedHashMap<>();
	private final Set<AbstractComparableEntry> hiddenEntries = new HashSet<>();
	private final Map<AbstractComparableEntry, AbstractComparableEntry> swaps = new HashMap<>();

	private MenuEntry leftClickEntry = null;
	private MenuEntry firstEntry = null;

	private int playerAttackIdx = -1;

	@Inject
	private MenuManager(Client client, EventBus eventBus)
	{
		this.client = client;
		this.eventBus = eventBus;


		eventBus.subscribe(MenuOpened.class, this, this::onMenuOpened);
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(BeforeRender.class, this, this::onBeforeRender);
		eventBus.subscribe(PlayerMenuOptionsChanged.class, this, this::onPlayerMenuOptionsChanged);
		eventBus.subscribe(NpcActionChanged.class, this, this::onNpcActionChanged);
		eventBus.subscribe(WidgetPressed.class, this, this::onWidgetPressed);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
	}

	/**
	 * Adds a CustomMenuOption to the list of managed menu options.
	 *
	 * @param customMenuOption The custom menu to add
	 */
	public void addManagedCustomMenu(WidgetMenuOption customMenuOption)
	{
		WidgetInfo widget = customMenuOption.getWidget();
		managedMenuOptions.put(widget.getId(), customMenuOption);
	}

	/**
	 * Removes a CustomMenuOption from the list of managed menu options.
	 *
	 * @param customMenuOption The custom menu to add
	 */
	public void removeManagedCustomMenu(WidgetMenuOption customMenuOption)
	{
		WidgetInfo widget = customMenuOption.getWidget();
		managedMenuOptions.remove(widget.getId(), customMenuOption);
	}

	private boolean menuContainsCustomMenu(WidgetMenuOption customMenuOption)
	{
		for (MenuEntry menuEntry : client.getMenuEntries())
		{
			String option = menuEntry.getOption();
			String target = menuEntry.getTarget();

			if (option.equals(customMenuOption.getMenuOption()) && target.equals(customMenuOption.getMenuTarget()))
			{
				return true;
			}
		}
		return false;
	}

	private void onMenuOpened(MenuOpened event)
	{
		currentPriorityEntries.clear();

		// Need to reorder the list to normal, then rebuild with swaps
		MenuEntry[] oldEntries = event.getMenuEntries();

		firstEntry = null;

		List<MenuEntry> newEntries = Lists.newArrayList(oldEntries);

		boolean shouldDeprioritize = false;

		prioritizer:
		for (MenuEntry entry : oldEntries)
		{
			for (AbstractComparableEntry p : priorityEntries)
			{
				// Create list of priority entries, and remove from menus
				if (p.matches(entry))
				{
					// Other entries need to be deprioritized if their types are lower than 1000
					if (entry.getOpcode() >= 1000 && !shouldDeprioritize)
					{
						shouldDeprioritize = true;
					}
					currentPriorityEntries.put(entry, p);
					newEntries.remove(entry);
					continue prioritizer;
				}
			}

			if (newEntries.size() > 0)
			{
				// Swap first matching entry to top
				for (AbstractComparableEntry src : swaps.keySet())
				{
					if (!src.matches(entry))
					{
						continue;
					}

					MenuEntry swapFrom = null;

					AbstractComparableEntry from = swaps.get(src);

					for (MenuEntry e : newEntries)
					{
						if (from.matches(e))
						{
							swapFrom = e;
							break;
						}
					}

					// Do not need to swap with itself or if the swapFrom is already the first entry
					if (swapFrom != null && swapFrom != entry && swapFrom != Iterables.getLast(newEntries))
					{
						// Deprioritize entries if the swaps are not in similar opcode groups
						if ((swapFrom.getOpcode() >= 1000 && entry.getOpcode() < 1000) || (entry.getOpcode() >= 1000 && swapFrom.getOpcode() < 1000) && !shouldDeprioritize)
						{
							shouldDeprioritize = true;
						}

						int indexFrom = newEntries.indexOf(swapFrom);
						int indexTo = newEntries.indexOf(entry);

						Collections.swap(newEntries, indexFrom, indexTo);
					}
				}
			}
		}

		if (shouldDeprioritize)
		{
			for (MenuEntry entry : newEntries)
			{
				if (entry.getOpcode() <= MENU_ACTION_DEPRIORITIZE_OFFSET)
				{
					entry.setOpcode(entry.getOpcode() + MENU_ACTION_DEPRIORITIZE_OFFSET);
				}
			}
		}

		if (!currentPriorityEntries.isEmpty())
		{
			newEntries.addAll(currentPriorityEntries.entrySet().stream()
				.sorted(Comparator.comparingInt(e -> e.getValue().getPriority()))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList()));
		}

		MenuEntry[] arrayEntries = newEntries.toArray(new MenuEntry[0]);

		// Need to set the event entries to prevent conflicts
		event.setMenuEntries(arrayEntries);
		event.setModified();
	}

	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		for (AbstractComparableEntry e : hiddenEntries)
		{
			if (e.matches(event))
			{
				client.setMenuOptionCount(client.getMenuOptionCount() - 1);
				return;
			}
		}

		int widgetId = event.getParam1();
		Collection<WidgetMenuOption> options = managedMenuOptions.get(widgetId);

		for (WidgetMenuOption currentMenu : options)
		{
			if (!menuContainsCustomMenu(currentMenu))//Don't add if we have already added it to this widget
			{
				client.insertMenuItem(
					currentMenu.getMenuOption(),
					currentMenu.getMenuTarget(),
					MenuOpcode.RUNELITE.getId(),
					0,
					0,
					widgetId,
					false
				);
			}
		}
	}

	private void onBeforeRender(BeforeRender event)
	{
		rebuildLeftClickMenu();
	}

	private MenuEntry rebuildLeftClickMenu()
	{
		if (client.isMenuOpen())
		{
			return null;
		}

		int menuOptionCount = client.getMenuOptionCount();
		if (menuOptionCount <= 2)
		{
			return null;
		}

		firstEntry = null;
		MenuEntry[] entries = new MenuEntry[menuOptionCount + priorityEntries.size()];
		System.arraycopy(client.getMenuEntries(), 0, entries, 0, menuOptionCount);

		if (!priorityEntries.isEmpty())
		{
			indexPriorityEntries(entries, menuOptionCount);
		}

		if (firstEntry == null && !swaps.isEmpty())
		{
			indexSwapEntries(entries, menuOptionCount);
		}


		if (firstEntry == null)
		{
			// stop being null smh
			firstEntry = entries[menuOptionCount - 1];
		}

		client.setMenuEntries(entries);

		return firstEntry;
	}

	public void addPlayerMenuItem(String menuText)
	{
		Preconditions.checkNotNull(menuText);

		int playerMenuIndex = findEmptyPlayerMenuIndex();
		if (playerMenuIndex == IDX_UPPER)
		{
			return; // no more slots
		}

		addPlayerMenuItem(playerMenuIndex, menuText);
	}

	public void removePlayerMenuItem(String menuText)
	{
		Preconditions.checkNotNull(menuText);
		for (Map.Entry<Integer, String> entry : playerMenuIndexMap.entrySet())
		{
			if (entry.getValue().equalsIgnoreCase(menuText))
			{
				removePlayerMenuItem(entry.getKey());
				break;
			}
		}
	}

	private void onPlayerMenuOptionsChanged(PlayerMenuOptionsChanged event)
	{
		int idx = event.getIndex();

		String menuText = playerMenuIndexMap.get(idx);
		if (menuText == null)
		{
			return; // not our menu
		}

		// find new index for this option
		int newIdx = findEmptyPlayerMenuIndex();
		if (newIdx == IDX_UPPER)
		{
			log.debug("Client has updated player menu index {} where option {} was, and there are no more free slots available", idx, menuText);
			return;
		}

		log.debug("Client has updated player menu index {} where option {} was, moving to index {}", idx, menuText, newIdx);

		playerMenuIndexMap.remove(idx);
		addPlayerMenuItem(newIdx, menuText);
	}

	private void onNpcActionChanged(NpcActionChanged event)
	{
		NPCDefinition composition = event.getNpcDefinition();
		for (String npcOption : npcMenuOptions)
		{
			addNpcOption(composition, npcOption);
		}
	}

	private void addNpcOption(NPCDefinition composition, String npcOption)
	{
		String[] actions = composition.getActions();
		int unused = -1;
		for (int i = 0; i < actions.length; ++i)
		{
			if (actions[i] == null && unused == -1)
			{
				unused = i;
			}
			else if (actions[i] != null && actions[i].equals(npcOption))
			{
				return;
			}
		}
		if (unused == -1)
		{
			return;
		}
		actions[unused] = npcOption;
	}

	private void removeNpcOption(NPCDefinition composition, String npcOption)
	{
		String[] actions = composition.getActions();

		if (composition.getActions() == null)
		{
			return;
		}

		for (int i = 0; i < actions.length; ++i)
		{
			if (actions[i] != null && actions[i].equals(npcOption))
			{
				actions[i] = null;
			}
		}
	}

	private void onWidgetPressed(WidgetPressed event)
	{
		leftClickEntry = rebuildLeftClickMenu();
	}

	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!client.isMenuOpen() && event.isAuthentic())
		{
			if (event.getMouseButton() != 0)
			{
				leftClickEntry = rebuildLeftClickMenu();
			}

			if (leftClickEntry != null)
			{
				event.setMenuEntry(leftClickEntry);
				leftClickEntry = null;
			}
		}

		if (event.getMenuOpcode() != MenuOpcode.RUNELITE)
		{
			return; // not a player menu
		}

		int widgetId = event.getParam1();
		Collection<WidgetMenuOption> options = managedMenuOptions.get(widgetId);

		for (WidgetMenuOption curMenuOption : options)
		{
			if (curMenuOption.getMenuTarget().equals(event.getTarget())
				&& curMenuOption.getMenuOption().equals(event.getOption()))
			{
				WidgetMenuOptionClicked customMenu = new WidgetMenuOptionClicked();
				customMenu.setMenuOption(event.getOption());
				customMenu.setMenuTarget(event.getTarget());
				customMenu.setWidget(curMenuOption.getWidget());
				eventBus.post(WidgetMenuOptionClicked.class, customMenu);
				return; // don't continue because it's not a player option
			}
		}

		String username = Text.removeTags(event.getTarget(), true);

		PlayerMenuOptionClicked playerMenuOptionClicked = new PlayerMenuOptionClicked();
		playerMenuOptionClicked.setMenuOption(event.getOption());
		playerMenuOptionClicked.setMenuTarget(username);

		eventBus.post(PlayerMenuOptionClicked.class, playerMenuOptionClicked);
	}

	private void addPlayerMenuItem(int playerOptionIndex, String menuText)
	{
		client.getPlayerOptions()[playerOptionIndex] = menuText;
		client.getPlayerOptionsPriorities()[playerOptionIndex] = true;
		client.getPlayerMenuTypes()[playerOptionIndex] = MenuOpcode.RUNELITE.getId();

		playerMenuIndexMap.put(playerOptionIndex, menuText);
	}

	private void removePlayerMenuItem(int playerOptionIndex)
	{
		client.getPlayerOptions()[playerOptionIndex] = null;
		playerMenuIndexMap.remove(playerOptionIndex);
	}

	/**
	 * Find the next empty player menu slot index
	 */
	private int findEmptyPlayerMenuIndex()
	{
		int index = IDX_LOWER;

		String[] playerOptions = client.getPlayerOptions();
		while (index < IDX_UPPER && playerOptions[index] != null)
		{
			index++;
		}

		return index;
	}

	public int getPlayerAttackOpcode()
	{
		final String[] playerMenuOptions = client.getPlayerOptions();

		if (playerAttackIdx != -1 && playerMenuOptions[playerAttackIdx].equals("Attack"))
		{
			return client.getPlayerMenuTypes()[playerAttackIdx];
		}

		playerAttackIdx = -1;

		for (int i = IDX_LOWER; i < IDX_UPPER; i++)
		{
			if ("Attack".equals(playerMenuOptions[i]))
			{
				playerAttackIdx = i;
				break;
			}
		}

		return playerAttackIdx >= 0 ? client.getPlayerMenuTypes()[playerAttackIdx] : -1;
	}

	/**
	 * Adds to the set of menu entries which when present, will remove all entries except for this one
	 */
	public AbstractComparableEntry addPriorityEntry(String option, String target)
	{
		option = option.trim().toLowerCase();
		target = Text.standardize(target);

		AbstractComparableEntry entry = newBaseComparableEntry(option, target);

		priorityEntries.add(entry);

		return entry;
	}

	public void removePriorityEntry(String option, String target)
	{
		option = option.trim().toLowerCase();
		target = Text.standardize(target);

		AbstractComparableEntry entry = newBaseComparableEntry(option, target);

		priorityEntries.remove(entry);
	}


	/**
	 * Adds to the set of menu entries which when present, will remove all entries except for this one
	 * This method will add one with strict option, but not-strict target (contains for target, equals for option)
	 */
	public AbstractComparableEntry addPriorityEntry(String option)
	{
		option = option.trim().toLowerCase();

		AbstractComparableEntry entry = newBaseComparableEntry(option, "", false);

		priorityEntries.add(entry);

		return entry;
	}

	public AbstractComparableEntry addPriorityEntry(String option, boolean strictOption)
	{
		option = option.trim().toLowerCase();

		AbstractComparableEntry entry =
			newBaseComparableEntry(option, "", -1, -1, false, strictOption);

		priorityEntries.add(entry);

		return entry;
	}

	public AbstractComparableEntry addPriorityEntry(AbstractComparableEntry entry)
	{
		priorityEntries.add(entry);

		return entry;
	}

	public void removePriorityEntry(AbstractComparableEntry entry)
	{
		priorityEntries.remove(entry);
	}

	public void removePriorityEntry(String option)
	{
		option = option.trim().toLowerCase();

		AbstractComparableEntry entry = newBaseComparableEntry(option, "", false);

		priorityEntries.remove(entry);
	}

	public void removePriorityEntry(String option, boolean strictOption)
	{
		option = option.trim().toLowerCase();

		AbstractComparableEntry entry =
			newBaseComparableEntry(option, "", -1, -1, false, strictOption);

		priorityEntries.remove(entry);
	}

	public void addPriorityEntries(Collection<AbstractComparableEntry> entries)
	{
		priorityEntries.addAll(entries);
	}

	public void removePriorityEntries(Collection<AbstractComparableEntry> entries)
	{
		priorityEntries.removeAll(entries);
	}

	/**
	 * Adds to the map of swaps. Strict options, not strict target but target1=target2
	 */
	public void addSwap(String option, String target, String option2)
	{
		addSwap(option, target, option2, target, true, false);
	}

	public void removeSwap(String option, String target, String option2)
	{
		removeSwap(option, target, option2, target, true, false);
	}

	/**
	 * Adds to the map of swaps.
	 */
	public void addSwap(String option, String target, String option2, String target2, boolean strictOption, boolean strictTarget)
	{
		option = option.trim().toLowerCase();
		target = Text.standardize(target);

		option2 = option2.trim().toLowerCase();
		target2 = Text.standardize(target2);

		AbstractComparableEntry swapFrom = newBaseComparableEntry(option, target, -1, -1, strictOption, strictTarget);
		AbstractComparableEntry swapTo = newBaseComparableEntry(option2, target2, -1, -1, strictOption, strictTarget);

		if (swapTo.equals(swapFrom))
		{
			log.warn("You shouldn't try swapping an entry for itself");
			return;
		}

		swaps.put(swapFrom, swapTo);
	}


	public void removeSwap(String option, String target, String option2, String target2, boolean strictOption, boolean strictTarget)
	{
		option = option.trim().toLowerCase();
		target = Text.standardize(target);

		option2 = option2.trim().toLowerCase();
		target2 = Text.standardize(target2);

		AbstractComparableEntry swapFrom = newBaseComparableEntry(option, target, -1, -1, strictOption, strictTarget);
		AbstractComparableEntry swapTo = newBaseComparableEntry(option2, target2, -1, -1, strictOption, strictTarget);

		removeSwap(swapFrom, swapTo);
	}

	/**
	 * Adds to the map of swaps. - Strict option + target
	 */
	public void addSwap(String option, String target, String option2, String target2)
	{
		addSwap(option, target, option2, target2, false, false);
	}

	public void removeSwap(String option, String target, String option2, String target2)
	{
		removeSwap(option, target, option2, target2, false, false);
	}

	/**
	 * Adds to the map of swaps - Pre-baked entry
	 */
	public void addSwap(AbstractComparableEntry swapFrom, AbstractComparableEntry swapTo)
	{
		if (swapTo.equals(swapFrom))
		{
			log.warn("You shouldn't try swapping an entry for itself");
			return;
		}

		swaps.put(swapFrom, swapTo);
	}

	/**
	 * Adds to the map of swaps - Non-strict option/target, but with opcode & id
	 * ID's of -1 are ignored in matches()!
	 */
	public void addSwap(String option, String target, int id, int type, String option2, String target2, int id2, int type2)
	{
		option = option.trim().toLowerCase();
		target = Text.standardize(target);

		option2 = option2.trim().toLowerCase();
		target2 = Text.standardize(target2);

		AbstractComparableEntry swapFrom = newBaseComparableEntry(option, target, id, type, false, false);
		AbstractComparableEntry swapTo = newBaseComparableEntry(option2, target2, id2, type2, false, false);

		if (swapTo.equals(swapFrom))
		{
			log.warn("You shouldn't try swapping an entry for itself");
			return;
		}

		swaps.put(swapFrom, swapTo);
	}

	public void removeSwap(String option, String target, int id, int type, String option2, String target2, int id2, int type2)
	{
		option = option.trim().toLowerCase();
		target = Text.standardize(target);

		option2 = option2.trim().toLowerCase();
		target2 = Text.standardize(target2);

		AbstractComparableEntry swapFrom = newBaseComparableEntry(option, target, id, type, false, false);
		AbstractComparableEntry swapTo = newBaseComparableEntry(option2, target2, id2, type2, false, false);

		swaps.entrySet().removeIf(e -> e.getKey().equals(swapFrom) && e.getValue().equals(swapTo));
	}

	public void removeSwap(AbstractComparableEntry swapFrom, AbstractComparableEntry swapTo)
	{
		swaps.entrySet().removeIf(e -> e.getKey().equals(swapFrom) && e.getValue().equals(swapTo));
	}

	/**
	 * Removes all swaps with target
	 */
	public void removeSwaps(String... fromTarget)
	{
		for (String target : fromTarget)
		{
			final String s = Text.standardize(target);
			swaps.keySet().removeIf(e -> e.getTarget().equals(s));
			priorityEntries.removeIf(e -> e.getTarget().equals(s));
			hiddenEntries.removeIf(e -> e.getTarget().equals(s));
		}
	}

	/**
	 * Adds to the set of menu entries which when present, will be hidden from the menu
	 */
	public void addHiddenEntry(String option, String target)
	{
		option = option.trim().toLowerCase();
		target = Text.standardize(target);

		AbstractComparableEntry entry = newBaseComparableEntry(option, target);

		hiddenEntries.add(entry);
	}

	public void removeHiddenEntry(String option, String target)
	{
		option = option.trim().toLowerCase();
		target = Text.standardize(target);

		AbstractComparableEntry entry = newBaseComparableEntry(option, target);

		hiddenEntries.removeIf(entry::equals);
	}

	/**
	 * Adds to the set of menu entries which when present, will be hidden from the menu
	 * This method will add one with strict option, but not-strict target (contains for target, equals for option)
	 */
	public void addHiddenEntry(String option)
	{
		option = option.trim().toLowerCase();

		AbstractComparableEntry entry = newBaseComparableEntry(option, "", false);

		hiddenEntries.add(entry);
	}

	public void removeHiddenEntry(String option)
	{
		option = option.trim().toLowerCase();

		AbstractComparableEntry entry = newBaseComparableEntry(option, "", false);

		hiddenEntries.removeIf(entry::equals);
	}

	/**
	 * Adds to the set of hidden entries.
	 */
	public void addHiddenEntry(String option, String target, boolean strictOption, boolean strictTarget)
	{
		option = option.trim().toLowerCase();
		target = Text.standardize(target);

		AbstractComparableEntry entry = newBaseComparableEntry(option, target, -1, -1, strictOption, strictTarget);

		hiddenEntries.add(entry);
	}

	public void removeHiddenEntry(String option, String target, boolean strictOption, boolean strictTarget)
	{
		option = option.trim().toLowerCase();
		target = Text.standardize(target);

		AbstractComparableEntry entry = newBaseComparableEntry(option, target, -1, -1, strictOption, strictTarget);

		hiddenEntries.remove(entry);
	}

	/**
	 * Adds to the set of hidden entries - Pre-baked Comparable entry
	 */
	public void addHiddenEntry(AbstractComparableEntry entry)
	{
		hiddenEntries.add(entry);
	}

	public void removeHiddenEntry(AbstractComparableEntry entry)
	{
		hiddenEntries.remove(entry);
	}

	// This could use some optimization
	private void indexPriorityEntries(MenuEntry[] entries, int menuOptionCount)
	{
		// create a array of priority entries so we can sort those
		final SortMapping[] prios = new SortMapping[entries.length - menuOptionCount];

		int prioAmt = 0;
		for (int i = 0; i < menuOptionCount; i++)
		{
			final MenuEntry entry = entries[i];
			for (AbstractComparableEntry prio : priorityEntries)
			{
				if (!prio.matches(entry))
				{
					continue;
				}

				final SortMapping map = new SortMapping(prio.getPriority(), entry);
				prios[prioAmt++] = map;
				entries[i] = null;
				break;
			}
		}

		if (prioAmt == 0)
		{
			return;
		}

		// Sort em!
		Arrays.sort(prios, 0, prioAmt);
		int i;

		// Just place them after the standard entries. clientmixin ignores null entries
		for (i = 0; i < prioAmt; i++)
		{
			entries[menuOptionCount + i] = prios[i].entry;
		}

		firstEntry = entries[menuOptionCount + i - 1];

	}

	private void indexSwapEntries(MenuEntry[] entries, int menuOptionCount)
	{
		// firstEntry was null, so it's the entry at count - 1
		final MenuEntry first = entries[menuOptionCount - 1];
		if (first == null)
		{
			log.debug("First entry is null");
			return;
		}

		Set<AbstractComparableEntry> values = new HashSet<>();

		for (Map.Entry<AbstractComparableEntry, AbstractComparableEntry> pair : swaps.entrySet())
		{
			if (pair.getKey().matches(first))
			{
				values.add(pair.getValue());
			}
		}

		if (values.isEmpty())
		{
			return;
		}

		// Backwards so we swap with the otherwise highest one
		// Count - 2 so we don't compare the entry against itself
		for (int i = menuOptionCount - 2; i > 0; i--)
		{
			final MenuEntry entry = entries[i];
			for (AbstractComparableEntry swap : values)
			{
				if (!swap.matches(entry))
				{
					continue;
				}

				entries[i] = first;
				entries[menuOptionCount - 1] = entry;
				firstEntry = entry;
				return;
			}
		}
	}

	@AllArgsConstructor
	private static class SortMapping implements Comparable<SortMapping>
	{
		private final int priority;
		private final MenuEntry entry;

		@Override
		public int compareTo(@Nonnull SortMapping mapping)
		{
			return Integer.compare(this.priority, mapping.priority);
		}
	}
}
