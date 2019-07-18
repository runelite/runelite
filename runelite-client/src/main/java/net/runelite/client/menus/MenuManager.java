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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import static net.runelite.api.MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;
import net.runelite.api.MenuEntry;
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
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.util.Text;

@Singleton
@Slf4j
public class MenuManager
{
	/*
	 * The index needs to be between 4 and 7,
	 */
	private static final int IDX_LOWER = 4;
	private static final int IDX_UPPER = 8;
	static final Pattern LEVEL_PATTERN = Pattern.compile("\\(level-[0-9]*\\)");

	private final Client client;
	private final EventBus eventBus;

	//Maps the indexes that are being used to the menu option.
	private final Map<Integer, String> playerMenuIndexMap = new HashMap<>();
	//Used to manage custom non-player menu options
	private final Multimap<Integer, WidgetMenuOption> managedMenuOptions = HashMultimap.create();
	private final Set<String> npcMenuOptions = new HashSet<>();

	private final HashSet<ComparableEntry> priorityEntries = new HashSet<>();
	private HashMap<MenuEntry, ComparableEntry> currentPriorityEntries = new HashMap<>();
	private final ConcurrentHashMap<MenuEntry, ComparableEntry> safeCurrentPriorityEntries = new ConcurrentHashMap<>();
	private final HashSet<ComparableEntry> hiddenEntries = new HashSet<>();
	private HashSet<MenuEntry> currentHiddenEntries = new HashSet<>();
	private final HashMap<ComparableEntry, ComparableEntry> swaps = new HashMap<>();

	private final LinkedHashSet<MenuEntry> entries = Sets.newLinkedHashSet();

	private MenuEntry leftClickEntry = null;
	private MenuEntry firstEntry = null;

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

		client.sortMenuEntries();

		List<MenuEntry> newEntries = Lists.newArrayList(oldEntries);

		boolean shouldDeprioritize = false;

		prioritizer: for (MenuEntry entry : oldEntries)
		{
			// Remove hidden entries from menus
			for (ComparableEntry p : hiddenEntries)
			{
				if (p.matches(entry))
				{
					newEntries.remove(entry);
					continue prioritizer;
				}
			}

			for (ComparableEntry p : priorityEntries)
			{
				// Create list of priority entries, and remove from menus
				if (p.matches(entry))
				{
					// Other entries need to be deprioritized if their types are lower than 1000
					if (entry.getType() >= 1000 && !shouldDeprioritize)
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
				for (ComparableEntry src : swaps.keySet())
				{
					if (!src.matches(entry))
					{
						continue;
					}

					MenuEntry swapFrom = null;

					ComparableEntry from = swaps.get(src);

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
						// Deprioritize entries if the swaps are not in similar type groups
						if ((swapFrom.getType() >= 1000 && entry.getType() < 1000) || (entry.getType() >= 1000 && swapFrom.getType() < 1000) && !shouldDeprioritize)
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
				if (entry.getType() <= MENU_ACTION_DEPRIORITIZE_OFFSET)
				{
					entry.setType(entry.getType() + MENU_ACTION_DEPRIORITIZE_OFFSET);
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
		client.setMenuEntries(arrayEntries);
	}

	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		int widgetId = event.getActionParam1();
		Collection<WidgetMenuOption> options = managedMenuOptions.get(widgetId);
		MenuEntry[] menuEntries = client.getMenuEntries();

		for (WidgetMenuOption currentMenu : options)
		{
			if (!menuContainsCustomMenu(currentMenu))//Don't add if we have already added it to this widget
			{
				menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);

				MenuEntry menuEntry = menuEntries[menuEntries.length - 1] = new MenuEntry();
				menuEntry.setOption(currentMenu.getMenuOption());
				menuEntry.setParam1(widgetId);
				menuEntry.setTarget(currentMenu.getMenuTarget());
				menuEntry.setType(MenuAction.RUNELITE.getId());

				client.setMenuEntries(menuEntries);
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

		firstEntry = null;
		entries.clear();
		entries.addAll(Arrays.asList(client.getMenuEntries()));

		if (entries.size() < 2)
		{
			return null;
		}

		if (!hiddenEntries.isEmpty())
		{
			currentHiddenEntries.clear();
			indexHiddenEntries(entries);

			if (!currentHiddenEntries.isEmpty())
			{
				entries.removeAll(currentHiddenEntries);
			}
		}

		if (!priorityEntries.isEmpty())
		{
			indexPriorityEntries(entries);
		}

		if (firstEntry == null && !swaps.isEmpty())
		{
			indexSwapEntries(entries);
		}

		if (firstEntry != null)
		{
			entries.remove(firstEntry);
			entries.add(firstEntry);
		}
		else if (!currentHiddenEntries.isEmpty())
		{
			firstEntry = Iterables.getLast(entries, null);
		}

		client.setMenuEntries(entries.toArray(new MenuEntry[0]));

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
			// The mouse button will not be 0 if a non draggable widget was clicked,
			// otherwise the left click entry will have been set in onWidgetPressed
			if (client.getMouseCurrentButton() != 0)
			{
				leftClickEntry = rebuildLeftClickMenu();
			}

			if (leftClickEntry != null)
			{
				event.setMenuEntry(leftClickEntry);
				leftClickEntry = null;
			}
		}

		if (event.getMenuAction() != MenuAction.RUNELITE)
		{
			return; // not a player menu
		}

		int widgetId = event.getActionParam1();
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

		String target = event.getTarget();

		// removes tags and level from player names for example:
		// <col=ffffff>username<col=40ff00>  (level-42) or <col=ffffff><img=2>username</col>
		String username = Text.removeTags(target).split("[(]")[0].trim();

		PlayerMenuOptionClicked playerMenuOptionClicked = new PlayerMenuOptionClicked();
		playerMenuOptionClicked.setMenuOption(event.getOption());
		playerMenuOptionClicked.setMenuTarget(username);

		eventBus.post(PlayerMenuOptionClicked.class, playerMenuOptionClicked);
	}

	private void addPlayerMenuItem(int playerOptionIndex, String menuText)
	{
		client.getPlayerOptions()[playerOptionIndex] = menuText;
		client.getPlayerOptionsPriorities()[playerOptionIndex] = true;
		client.getPlayerMenuTypes()[playerOptionIndex] = MenuAction.RUNELITE.getId();

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

	/**
	 * Adds to the set of menu entries which when present, will remove all entries except for this one
	 */
	public ComparableEntry addPriorityEntry(String option, String target)
	{
		option = Text.standardize(option);
		target = Text.standardize(target);

		ComparableEntry entry = new ComparableEntry(option, target);

		priorityEntries.add(entry);

		return entry;
	}

	public void removePriorityEntry(String option, String target)
	{
		option = Text.standardize(option);
		target = Text.standardize(target);

		ComparableEntry entry = new ComparableEntry(option, target);

		priorityEntries.removeIf(entry::equals);
	}


	/**
	 * Adds to the set of menu entries which when present, will remove all entries except for this one
	 * This method will add one with strict option, but not-strict target (contains for target, equals for option)
	 */
	public ComparableEntry addPriorityEntry(String option)
	{
		option = Text.standardize(option);

		ComparableEntry entry = new ComparableEntry(option, "", false);

		priorityEntries.add(entry);

		return entry;
	}

	public void removePriorityEntry(String option)
	{
		option = Text.standardize(option);

		ComparableEntry entry = new ComparableEntry(option, "", false);

		priorityEntries.removeIf(entry::equals);
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
		option = Text.standardize(option);
		target = Text.standardize(target);

		option2 = Text.standardize(option2);
		target2 = Text.standardize(target2);

		ComparableEntry swapFrom = new ComparableEntry(option, target, -1, -1, strictOption, strictTarget);
		ComparableEntry swapTo = new ComparableEntry(option2, target2, -1, -1, strictOption, strictTarget);

		if (swapTo.equals(swapFrom))
		{
			log.warn("You shouldn't try swapping an entry for itself");
			return;
		}

		swaps.put(swapFrom, swapTo);
	}


	public void removeSwap(String option, String target, String option2, String target2, boolean strictOption, boolean strictTarget)
	{
		option = Text.standardize(option);
		target = Text.standardize(target);

		option2 = Text.standardize(option2);
		target2 = Text.standardize(target2);

		ComparableEntry swapFrom = new ComparableEntry(option, target, -1, -1, strictOption, strictTarget);
		ComparableEntry swapTo = new ComparableEntry(option2, target2, -1, -1, strictOption, strictTarget);

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
	public void addSwap(ComparableEntry swapFrom, ComparableEntry swapTo)
	{
		if (swapTo.equals(swapFrom))
		{
			log.warn("You shouldn't try swapping an entry for itself");
			return;
		}

		swaps.put(swapFrom, swapTo);
	}

	/**
	 * Adds to the map of swaps - Non-strict option/target, but with type & id
	 * ID's of -1 are ignored in matches()!
	 */
	public void addSwap(String option, String target, int id, int type, String option2, String target2, int id2, int type2)
	{
		option = Text.standardize(option);
		target = Text.standardize(target);

		option2 = Text.standardize(option2);
		target2 = Text.standardize(target2);

		ComparableEntry swapFrom = new ComparableEntry(option, target, id, type, false, false);
		ComparableEntry swapTo = new ComparableEntry(option2, target2, id2, type2, false, false);

		if (swapTo.equals(swapFrom))
		{
			log.warn("You shouldn't try swapping an entry for itself");
			return;
		}

		swaps.put(swapFrom, swapTo);
	}

	public void removeSwap(String option, String target, int id, int type, String option2, String target2, int id2, int type2)
	{
		option = Text.standardize(option);
		target = Text.standardize(target);

		option2 = Text.standardize(option2);
		target2 = Text.standardize(target2);

		ComparableEntry swapFrom = new ComparableEntry(option, target, id, type, false, false);
		ComparableEntry swapTo = new ComparableEntry(option2, target2, id2, type2, false, false);

		swaps.entrySet().removeIf(e -> e.getKey().equals(swapFrom) && e.getValue().equals(swapTo));
	}

	public void removeSwap(ComparableEntry swapFrom, ComparableEntry swapTo)
	{
		swaps.entrySet().removeIf(e -> e.getKey().equals(swapFrom) && e.getValue().equals(swapTo));
	}

	/**
	 * Removes all swaps with target
	 */
	public void removeSwaps(String withTarget)
	{
		final String target = Text.standardize(withTarget);

		swaps.keySet().removeIf(e -> e.getTarget().equals(target));
	}

	/**
	 * Adds to the set of menu entries which when present, will be hidden from the menu
	 */
	public void addHiddenEntry(String option, String target)
	{
		option = Text.standardize(option);
		target = Text.standardize(target);

		ComparableEntry entry = new ComparableEntry(option, target);

		hiddenEntries.add(entry);
	}

	public void removeHiddenEntry(String option, String target)
	{
		option = Text.standardize(option);
		target = Text.standardize(target);

		ComparableEntry entry = new ComparableEntry(option, target);

		hiddenEntries.removeIf(entry::equals);
	}

	/**
	 * Adds to the set of menu entries which when present, will be hidden from the menu
	 * This method will add one with strict option, but not-strict target (contains for target, equals for option)
	 */
	public void addHiddenEntry(String option)
	{
		option = Text.standardize(option);

		ComparableEntry entry = new ComparableEntry(option, "", false);

		hiddenEntries.add(entry);
	}

	public void removeHiddenEntry(String option)
	{
		option = Text.standardize(option);

		ComparableEntry entry = new ComparableEntry(option, "", false);

		hiddenEntries.removeIf(entry::equals);
	}

	/**
	 * Adds to the set of hidden entries.
	 */
	public void addHiddenEntry(String option, String target, boolean strictOption, boolean strictTarget)
	{
		option = Text.standardize(option);
		target = Text.standardize(target);

		ComparableEntry entry = new ComparableEntry(option, target, -1, -1, strictOption, strictTarget);

		hiddenEntries.add(entry);
	}

	public void removeHiddenEntry(String option, String target, boolean strictOption, boolean strictTarget)
	{
		option = Text.standardize(option);
		target = Text.standardize(target);

		ComparableEntry entry = new ComparableEntry(option, target, -1, -1, strictOption, strictTarget);

		hiddenEntries.remove(entry);
	}

	/**
	 * Adds to the set of hidden entries - Pre-baked Comparable entry
	 */
	public void addHiddenEntry(ComparableEntry entry)
	{
		hiddenEntries.add(entry);
	}

	public void removeHiddenEntry(ComparableEntry entry)
	{
		hiddenEntries.remove(entry);
	}

	private void indexHiddenEntries(Set<MenuEntry> entries)
	{
		currentHiddenEntries = entries.parallelStream().filter(entry ->
		{
			for (ComparableEntry p : hiddenEntries)
			{
				if (p.matches(entry))
				{
					return true;
				}
			}
			return false;
		}).collect(Collectors.toCollection(HashSet::new));
	}

	// This could use some optimization
	private void indexPriorityEntries(Set<MenuEntry> entries)
	{
		safeCurrentPriorityEntries.clear();
		entries.parallelStream().forEach(entry ->
		{
			for (ComparableEntry p : priorityEntries)
			{
				if (p.matches(entry))
				{
					safeCurrentPriorityEntries.put(entry, p);
					break;
				}
			}
		});

		firstEntry = Iterables.getLast(safeCurrentPriorityEntries.entrySet().stream()
			.sorted(Comparator.comparingInt(e -> e.getValue().getPriority()))
			.map(Map.Entry::getKey)
			.collect(Collectors.toList()), null);
	}

	private void indexSwapEntries(Set<MenuEntry> entries)
	{
		MenuEntry first = Iterables.getLast(entries);

		List<ComparableEntry> values = new ArrayList<>();

		for (Map.Entry<ComparableEntry, ComparableEntry> pair : swaps.entrySet())
		{
			if (pair.getKey().matches(first))
			{
				values.add(pair.getValue());
			}
		}

		firstEntry = entries.parallelStream().filter(entry ->
		{
			for (ComparableEntry value : values)
			{
				if (value.matches(entry))
				{
					return true;
				}
			}
			return false;
		}).findFirst().orElse(null);
	}
}