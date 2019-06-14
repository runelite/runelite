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
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import static net.runelite.api.MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPCDefinition;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcActionChanged;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.events.PlayerMenuOptionsChanged;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
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

	private static MenuEntry CANCEL()
	{
		MenuEntry cancel = new MenuEntry();
		cancel.setOption("Cancel");
		cancel.setTarget("");
		cancel.setIdentifier(0);
		cancel.setType(MenuAction.CANCEL.getId());
		cancel.setParam0(0);
		cancel.setParam1(0);

		return cancel;
	}

	private final Client client;
	private final EventBus eventBus;

	//Maps the indexes that are being used to the menu option.
	private final Map<Integer, String> playerMenuIndexMap = new HashMap<>();
	//Used to manage custom non-player menu options
	private final Multimap<Integer, WidgetMenuOption> managedMenuOptions = HashMultimap.create();
	private final Set<String> npcMenuOptions = new HashSet<>();

	private final Set<ComparableEntry> priorityEntries = new HashSet<>();
	private final Set<MenuEntry> currentPriorityEntries = new HashSet<>();
	private final Set<ComparableEntry> hiddenEntries = new HashSet<>();

	private final Map<ComparableEntry, ComparableEntry> swaps = new HashMap<>();
	private final Map<MenuEntry, Integer> originalTypes = new HashMap<>();

	@Inject
	private MenuManager(Client client, EventBus eventBus)
	{
		this.client = client;
		this.eventBus = eventBus;
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

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		int widgetId = event.getActionParam1();
		Collection<WidgetMenuOption> options = managedMenuOptions.get(widgetId);
		MenuEntry[] menuEntries = client.getMenuEntries();

		if (menuEntries.length == 1)
		{
			// Menu entries reset, so priority entries should reset as well
			currentPriorityEntries.clear();

			originalTypes.clear();
		}

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

		final MenuEntry newestEntry = menuEntries[menuEntries.length - 1];

		boolean isPrio = false;
		for (ComparableEntry p : priorityEntries)
		{
			if (p.matches(newestEntry))
			{
				isPrio = true;
				break;
			}
		}

		// If the last entry was a priority entry, keep track of it
		if (isPrio)
		{
			currentPriorityEntries.add(newestEntry);
		}

		// Make a copy of the menu entries, cause you can't remove from Arrays.asList()
		List<MenuEntry> copy = Lists.newArrayList(menuEntries);

		// If there are entries we want to prioritize, we have to remove the rest
		if (!currentPriorityEntries.isEmpty())
		{
			copy.retainAll(currentPriorityEntries);

			copy.add(0, CANCEL());
		}

		// Find the current entry in the swaps map
		ComparableEntry swapEntry = null;
		for (ComparableEntry e : swaps.keySet())
		{
			if (e.matches(newestEntry))
			{
				swapEntry = e;
				break;
			}
		}

		if (swapEntry != null)
		{
			ComparableEntry swapTarget = swaps.get(swapEntry);

			// Find the target for the swap in current menu entries
			MenuEntry foundSwap = null;
			for (MenuEntry entry : Lists.reverse(copy))
			{
				if (swapTarget.matches(entry))
				{
					foundSwap = entry;
					break;
				}
			}

			if (foundSwap != null)
			{
				// This is the type for the entry we're swapping the newest with
				final int foundType = foundSwap.getType();
				// This is the type for the newest entry
				final int lastType = newestEntry.getType();

				// MenuActions with an id of over 1000 get shifted to the back of the menu entry array
				// They have different id's in the packet buffer though, so we got to modify them back on click
				// I couldn't get this to work with objects, so we're using modified objectcomposition for that
				final boolean shouldModifyFoundType = foundType >= 1000;

				final boolean shouldModifyLastType = lastType >= 1000;

				// Bitwise or so we don't end up making things left click when they shouldn't
				if (shouldModifyFoundType ^ shouldModifyLastType)
				{
					int typeToSet;
					switch (MenuAction.of(shouldModifyFoundType ? foundType : lastType))
					{
						case EXAMINE_ITEM_BANK_EQ:
							typeToSet = MenuAction.WIDGET_DEFAULT.getId();
							break;
						case GAME_OBJECT_FIFTH_OPTION:
							typeToSet = MenuAction.GAME_OBJECT_FIRST_OPTION.getId();
							break;
						default:
							typeToSet = shouldModifyFoundType ? foundType : lastType;
							break;
					}

					if (shouldModifyFoundType)
					{
						foundSwap.setType(typeToSet);
						originalTypes.put(foundSwap, foundType);
					}
					else
					{
						newestEntry.setType(typeToSet);
						originalTypes.put(newestEntry, lastType);

						// We're probably trying to make something left click, so just slap on
						// the menu action deprioritize 2000-inator++
						foundSwap.setType(foundType + MENU_ACTION_DEPRIORITIZE_OFFSET);
					}
				}

				// Swap
				int index = copy.indexOf(foundSwap);
				int newIndex = copy.indexOf(newestEntry);

				copy.set(index, newestEntry);
				copy.set(newIndex, foundSwap);
			}
		}

		boolean isHidden = false;
		for (ComparableEntry p : hiddenEntries)
		{
			if (p.matches(newestEntry))
			{
				isHidden = true;
				break;
			}
		}

		if (isHidden)
		{
			copy.remove(newestEntry);
		}

		client.setMenuEntries(copy.toArray(new MenuEntry[0]));
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

	@Subscribe
	public void onPlayerMenuOptionsChanged(PlayerMenuOptionsChanged event)
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

	@Subscribe
	public void onNpcActionChanged(NpcActionChanged event)
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

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		// if (originalTypes.get(event.ge
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		// This right here. That's the moment I realized once again that
		// this event still is one of the worst fucking things that has
		// ever happened to this project. MenuOptionClicked right? What
		// do you expect the data in the event object to be?
		// A FUCKING MENU ENTRY. Honestly I originally forgot why I wrote
		// the rant below this, but the hate is coming back to me once again.
		// What the fuck do you expect me to do? Make another MenuEntry from
		// all the info WHICH WOULD HAVE BEEN INSIDE THE FUCKING MENUENTRY TO
		// BEGIN WITH??? I am legit still perplexed over why someone would do
		// it like this, and I don't want them to take this lightly cause they
		// should really really really feel terrible about this.

		if (!event.getMenuTarget().equals("do not edit") &&
			!originalTypes.isEmpty() &&
			event.getMenuAction() == MenuAction.WIDGET_DEFAULT ||
			event.getMenuAction() == MenuAction.GAME_OBJECT_FIRST_OPTION)
		{
			for (Map.Entry<MenuEntry, Integer> ent : originalTypes.entrySet())
			{
				// Honestly, I was about to write a huge ass rant about
				// how I hate whoever wrote the menuoptionclicked class
				// but I decided that that'd be un-nice to them, and they
				// probably spent over 24 hours writing it. Not because
				// it was that difficult to write, of course, but because
				// they must have the fucking iq of a retarded, under developed,
				// braindead, basically good-for-nothing, idiotic chimp.
				//
				// Just kidding, of course, that would be too big of an
				// insult towards those poor chimps. It's not their fault
				// some dumbass is the way they are, right? Why should they
				// feel bad for something they can't do anything about?
				//
				// Whoever wrote that class though, should actually feel
				// 100% terrible. If they aren't depressed, I really wish
				// they become depressed very, very soon. What the fuck
				// were they even thinking.

				MenuEntry e = ent.getKey();

				if (event.getMenuAction().getId() != e.getType()
					|| event.getId() != e.getIdentifier()
					|| !event.getMenuOption().equals(e.getOption()))
				{
					continue;
				}

				event.consume();

				client.invokeMenuAction(
					event.getActionParam(),
					event.getWidgetId(),
					ent.getValue(),
					event.getId(),
					event.getMenuOption(),
					"do not edit",
					client.getMouseCanvasPosition().getX(),
					client.getMouseCanvasPosition().getY()
				);

				break;
			}
		}

		if (event.getMenuAction() != MenuAction.RUNELITE)
		{
			return; // not a player menu
		}

		int widgetId = event.getWidgetId();
		Collection<WidgetMenuOption> options = managedMenuOptions.get(widgetId);

		for (WidgetMenuOption curMenuOption : options)
		{
			if (curMenuOption.getMenuTarget().equals(event.getMenuTarget())
				&& curMenuOption.getMenuOption().equals(event.getMenuOption()))
			{
				WidgetMenuOptionClicked customMenu = new WidgetMenuOptionClicked();
				customMenu.setMenuOption(event.getMenuOption());
				customMenu.setMenuTarget(event.getMenuTarget());
				customMenu.setWidget(curMenuOption.getWidget());
				eventBus.post(customMenu);
				return; // don't continue because it's not a player option
			}
		}

		String target = event.getMenuTarget();

		// removes tags and level from player names for example:
		// <col=ffffff>username<col=40ff00>  (level-42) or <col=ffffff><img=2>username</col>
		String username = Text.removeTags(target).split("[(]")[0].trim();

		PlayerMenuOptionClicked playerMenuOptionClicked = new PlayerMenuOptionClicked();
		playerMenuOptionClicked.setMenuOption(event.getMenuOption());
		playerMenuOptionClicked.setMenuTarget(username);

		eventBus.post(playerMenuOptionClicked);
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
	public void addPriorityEntry(String option, String target)
	{
		option = Text.standardize(option);
		target = Text.standardize(target);

		ComparableEntry entry = new ComparableEntry(option, target);

		priorityEntries.add(entry);
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
	public void addPriorityEntry(String option)
	{
		option = Text.standardize(option);

		ComparableEntry entry = new ComparableEntry(option, "", false);

		priorityEntries.add(entry);
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
}
