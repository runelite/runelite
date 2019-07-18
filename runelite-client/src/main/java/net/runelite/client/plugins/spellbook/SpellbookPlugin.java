/*
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
package net.runelite.client.plugins.spellbook;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Point;
import net.runelite.api.VarClientInt;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.input.MouseManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import static net.runelite.client.util.MiscUtils.clamp;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Spellbook",
	description = "Modifications to the spellbook",
	tags = {"resize", "spell", "mobile", "lowers", "pvp", "skill", "level"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
@Slf4j
public class SpellbookPlugin extends Plugin
{
	private static final int FULL_WIDTH = 184;
	private static final int FULL_HEIGHT = 240;
	private static final Gson GSON = new Gson();
	private static final String LOCK = "Disable";
	private static final String UNLOCK = "Enable";
	private static final String MENU_TARGET = "Reordering";
	private static final WidgetMenuOption FIXED_MAGIC_TAB_LOCK = new WidgetMenuOption(LOCK, MENU_TARGET, WidgetInfo.FIXED_VIEWPORT_MAGIC_TAB);
	private static final WidgetMenuOption FIXED_MAGIC_TAB_UNLOCK = new WidgetMenuOption(UNLOCK, MENU_TARGET, WidgetInfo.FIXED_VIEWPORT_MAGIC_TAB);
	private static final WidgetMenuOption RESIZABLE_MAGIC_TAB_LOCK = new WidgetMenuOption(LOCK, MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_MAGIC_TAB);
	private static final WidgetMenuOption RESIZABLE_MAGIC_TAB_UNLOCK = new WidgetMenuOption(UNLOCK, MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_MAGIC_TAB);
	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_MAGIC_TAB_LOCK = new WidgetMenuOption(LOCK, MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_MAGIC_TAB);
	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_MAGIC_TAB_UNLOCK = new WidgetMenuOption(UNLOCK, MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_MAGIC_TAB);

	private enum WordFilterMode
	{
		CONTAINS,
		EQUALS,
		STARTSWITH,
		ENDSWITH
	}

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ConfigManager configManager;

	@Inject
	private SpellbookConfig config;

	@Inject
	private MenuManager menuManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private SpellbookDragOverlay overlay;

	@Inject
	private EventBus eventBus;

	@Getter
	private boolean dragging;

	@Getter
	private Widget draggingWidget;

	@Getter
	private Point draggingLocation;

	private final Map<Integer, Spell> spells = new HashMap<>();
	private Map<Integer, Spell> tmp = null;
	private ImmutableSet<String> notFilteredSpells;
	private Spellbook spellbook;
	private SpellbookMouseListener mouseListener;

	private boolean enableMobile;
	private boolean dragSpells;
	private boolean scroll;
	private int size;
	private String filter;

	@Provides
	SpellbookConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SpellbookConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();

		refreshMagicTabOption();
		loadFilter();
		mouseListener = new SpellbookMouseListener(this);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);
		clearMagicTabMenus();
		saveSpells();
		config.canDrag(false);
		mouseManager.unregisterMouseListener(mouseListener);
		mouseManager.unregisterMouseWheelListener(mouseListener);
		mouseListener = null;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(WidgetMenuOptionClicked.class, this, this::onWidgetMenuOptionClicked);
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			refreshMagicTabOption();
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!"spellbook".equals(event.getGroup()))
		{
			return;
		}

		updateConfig();

		String key = event.getKey();

		if ("filter".equals(key))
		{
			loadFilter();
		}

		clientThread.invokeLater(this::runRebuild);
		refreshMagicTabOption();
	}

	public void onVarbitChanged(VarbitChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (config.canDrag())
		{
			config.canDrag(client.getVar(Varbits.FILTER_SPELLBOOK) == 1 && client.getVar(VarClientInt.INVENTORY_TAB) == 6);
		}
	}

	private static boolean isUnfiltered(String spell, Set<String> unfiltereds)
	{
		for (String str : unfiltereds)
		{
			WordFilterMode mode = getFilterMode(str);
			str = removeFlyingComma(str).toLowerCase();
			spell = spell.toLowerCase();

			switch (mode)
			{
				case CONTAINS:
					if (spell.contains(str))
					{
						return true;
					}
					break;
				case STARTSWITH:
					if (spell.startsWith(str))
					{
						return true;
					}
					break;
				case ENDSWITH:
					if (spell.endsWith(str))
					{
						return true;
					}
					break;
				case EQUALS:
					if (spell.equals(str))
					{
						return true;
					}
					break;
			}
		}

		return false;
	}

	private void onWidgetMenuOptionClicked(WidgetMenuOptionClicked event)
	{
		if (event.getWidget() != WidgetInfo.FIXED_VIEWPORT_MAGIC_TAB
			&& event.getWidget() != WidgetInfo.RESIZABLE_VIEWPORT_MAGIC_TAB
			&& event.getWidget() != WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_MAGIC_TAB)
		{
			return;
		}

		if (event.getMenuOption().equals(UNLOCK))
		{
			config.canDrag(true);
			overlayManager.add(overlay);
			mouseManager.registerMouseListener(mouseListener);
			tmp = new HashMap<>();

			if (this.scroll)
			{
				mouseManager.registerMouseWheelListener(mouseListener);
			}
		}
		else if (event.getMenuOption().equals(LOCK))
		{
			config.canDrag(false);
			overlayManager.remove(overlay);
			mouseManager.unregisterMouseListener(mouseListener);
			mouseManager.unregisterMouseWheelListener(mouseListener);
			saveSpells();
			tmp = null;
		}
	}

	private void clearMagicTabMenus()
	{
		menuManager.removeManagedCustomMenu(FIXED_MAGIC_TAB_LOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_MAGIC_TAB_LOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_MAGIC_TAB_LOCK);
		menuManager.removeManagedCustomMenu(FIXED_MAGIC_TAB_UNLOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_MAGIC_TAB_UNLOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_MAGIC_TAB_UNLOCK);
	}

	private void refreshMagicTabOption()
	{
		clearMagicTabMenus();
		if (client.getGameState() != GameState.LOGGED_IN || !this.dragSpells)
		{
			return;
		}

		if (config.canDrag())
		{
			menuManager.addManagedCustomMenu(FIXED_MAGIC_TAB_LOCK);
			menuManager.addManagedCustomMenu(RESIZABLE_MAGIC_TAB_LOCK);
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_MAGIC_TAB_LOCK);
		}
		else
		{
			menuManager.addManagedCustomMenu(FIXED_MAGIC_TAB_UNLOCK);
			menuManager.addManagedCustomMenu(RESIZABLE_MAGIC_TAB_UNLOCK);
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_MAGIC_TAB_UNLOCK);
		}
	}

	private void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (client.getVar(Varbits.FILTER_SPELLBOOK) != 0
			|| !this.enableMobile
			|| !event.getEventName().toLowerCase().contains("spell"))
		{
			return;
		}

		int[] iStack = client.getIntStack();
		int iStackSize = client.getIntStackSize();

		String[] sStack = client.getStringStack();
		int sStackSize = client.getStringStackSize();

		if ("startSpellRedraw".equals(event.getEventName()))
		{
			if (config.canDrag())
			{
				return;
			}

			spellbook = Spellbook.getByID(client.getVar(Varbits.SPELLBOOK));
			loadSpells();
		}
		else if ("shouldFilterSpell".equals(event.getEventName()))
		{
			String spell = sStack[sStackSize - 1].toLowerCase();
			int widget = iStack[iStackSize - 1];

			// Add the spell to spells
			if (!spells.containsKey(widget))
			{
				Spell s = new Spell();
				s.setWidget(widget);
				s.setX(-1);
				s.setY(-1);
				s.setSize(0);
				s.setName(spell);

				spells.put(widget, s);
			}

			if (notFilteredSpells.isEmpty())
			{
				return;
			}

			ImmutableSet<String> tmp = ImmutableSet.copyOf(notFilteredSpells);

			iStack[iStackSize - 2] = isUnfiltered(spell, tmp) ? 1 : 0;
		}
		else if ("isMobileSpellbookEnabled".equals(event.getEventName()))
		{
			iStack[iStackSize - 1] = 1;
		}
		else if ("resizeSpell".equals(event.getEventName()))
		{
			int size = this.size;
			int columns = clamp(FULL_WIDTH / size, 2, 3);

			iStack[iStackSize - 2] = size;
			iStack[iStackSize - 1] = columns;
		}
		else if ("setSpellAreaSize".equals(event.getEventName()))
		{
			if (!this.dragSpells)
			{
				return;
			}

			iStack[iStackSize - 2] = FULL_WIDTH;
			iStack[iStackSize - 1] = FULL_HEIGHT;
		}
		else if ("resizeIndividualSpells".equals(event.getEventName()))
		{
			int widget = iStack[iStackSize - 1];

			int visibleCount = 0;
			for (Spell spell1 : spells.values())
			{
				String s = spell1.getName();
				if (isUnfiltered(s, notFilteredSpells))
				{
					visibleCount++;
				}
			}

			if (visibleCount > 20 || visibleCount == 0)
			{
				return;
			}

			Spell spell = spells.get(widget);

			int newSize = clamp(trueSize(spell), 0, FULL_WIDTH);

			iStack[iStackSize - 3] = newSize;
			iStack[iStackSize - 2] = newSize;
		}
		else if ("setSpellPosition".equals(event.getEventName()))
		{
			if (!this.dragSpells)
			{
				return;
			}

			int widget = iStack[iStackSize - 1];
			Spell s = spells.get(widget);
			int x = s.getX();
			int y = s.getY();

			if (x == -1 || y == -1)
			{
				return;
			}

			iStack[iStackSize - 5] = x;
			iStack[iStackSize - 4] = y;
		}
	}

	private void loadSpells()
	{
		if (client.getGameState() != GameState.LOGGED_IN || spellbook == null)
		{
			return;
		}

		spells.clear();

		String cfg = configManager.getConfiguration("spellbook", spellbook.getConfigKey());

		if (Strings.isNullOrEmpty(cfg))
		{
			return;
		}

		// CHECKSTYLE:OFF
		Collection<Spell> gson = GSON.fromJson(cfg, new TypeToken<List<Spell>>() {}.getType());
		// CHECKSTYLE:ON
		gson.stream().filter(Objects::nonNull).forEach(s -> spells.put(s.getWidget(), s));

		if (tmp != null)
		{
			for (Map.Entry<Integer, Spell> entry : tmp.entrySet())
			{
				spells.replace(entry.getKey(), entry.getValue());
			}
		}
	}

	private void saveSpells()
	{
		if (spells.isEmpty() || tmp == null || tmp.isEmpty())
		{
			return;
		}

		for (Map.Entry<Integer, Spell> entry : tmp.entrySet())
		{
			spells.replace(entry.getKey(), entry.getValue());
		}

		String key = spellbook.getConfigKey();

		configManager.setConfiguration("spellbook", key, GSON.toJson(spells.values()));
	}

	private void runRebuild()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		// Runs magic_spellbook_rebuild
		clientThread.invoke(() ->
			client.runScript(2611, 14286851, 14287027, 14287036, 14286849, 14287033, 14287034, 14287035, 14286850, 14287029, 14287032, "Info", "Filters", false)
		);
	}

	private static WordFilterMode getFilterMode(String s)
	{
		if (!s.contains("\""))
		{
			return WordFilterMode.CONTAINS;
		}
		if (s.startsWith("\""))
		{
			return s.endsWith("\"") ? WordFilterMode.EQUALS : WordFilterMode.STARTSWITH;
		}
		else if (s.endsWith("\""))
		{
			return WordFilterMode.ENDSWITH;
		}

		return WordFilterMode.CONTAINS; // but probably null soz
	}

	boolean isNotOnSpellWidget(java.awt.Point point)
	{
		Widget boundsWidget = client.getWidget(WidgetInfo.SPELLBOOK_FILTERED_BOUNDS);
		if (client.getVar(VarClientInt.INVENTORY_TAB) != 6
			|| client.isMenuOpen()
			|| boundsWidget == null
			|| !boundsWidget.getBounds().contains(point))
		{
			return true;
		}

		return currentWidget(point) == null;
	}

	private void loadFilter()
	{
		notFilteredSpells = ImmutableSet.copyOf(Text.fromCSV(this.filter.toLowerCase()));
	}

	void startDragging(java.awt.Point point)
	{
		draggingWidget = currentWidget(point);

		if (draggingWidget == null)
		{
			return;
		}

		Point widgetPos = draggingWidget.getCanvasLocation();

		int x = point.x - widgetPos.getX();
		int y = point.y - widgetPos.getY();

		draggingLocation = new Point(x, y);
		draggingWidget.setHidden(true);
		dragging = true;
	}

	void completeDragging(java.awt.Point point)
	{
		Point parentPos = client.getWidget(WidgetInfo.SPELLBOOK_FILTERED_BOUNDS).getCanvasLocation();

		int x = point.x - draggingLocation.getX() - parentPos.getX();
		int y = point.y - draggingLocation.getY() - parentPos.getY();
		int size = draggingWidget.getWidth();

		x = clamp(x, 0, FULL_WIDTH - size);
		y = clamp(y, 0, FULL_HEIGHT - size);

		int draggedID = draggingWidget.getId();
		Spell n = spells.get(draggedID);

		n.setX(x);
		n.setY(y);

		tmp.put(draggedID, n);

		draggingWidget.setHidden(false);
		dragging = false;

		runRebuild();
	}

	private Widget currentWidget(java.awt.Point point)
	{
		ImmutableSet<String> tmp = ImmutableSet.copyOf(notFilteredSpells);

		for (Map.Entry<Integer, Spell> spell : spells.entrySet())
		{
			Widget w = client.getWidget(WidgetInfo.TO_GROUP(spell.getKey()), WidgetInfo.TO_CHILD(spell.getKey())); // y tho let me just plop in id

			if (w == null || !w.getBounds().contains(point) || !isUnfiltered(spell.getValue().getName(), tmp))
			{
				continue;
			}

			return w;
		}

		return null;
	}

	void increaseSize(java.awt.Point point)
	{
		Widget scrolledWidget = currentWidget(point);

		if (scrolledWidget == null || dragging)
		{
			return;
		}

		int scrolledWidgetId = scrolledWidget.getId();

		if (!spells.containsKey(scrolledWidgetId))
		{
			return;
		}

		Spell scrolledSpell = spells.get(scrolledWidgetId);

		if (trueSize(scrolledSpell) > FULL_WIDTH - 2)
		{
			scrolledSpell.setX(0);
			scrolledSpell.setY(clamp(scrolledSpell.getY(), 0, FULL_HEIGHT - FULL_WIDTH));
			return;
		}

		scrolledSpell.setSize(scrolledSpell.getSize() + 1);

		scrolledSpell.setX(clamp(scrolledSpell.getX() - 1, 0, FULL_WIDTH - trueSize(scrolledSpell)));
		scrolledSpell.setY(clamp(scrolledSpell.getY() - 1, 0, FULL_HEIGHT - trueSize(scrolledSpell)));

		tmp.put(scrolledWidgetId, scrolledSpell);

		runRebuild();
	}

	void resetZoom(java.awt.Point point)
	{
		Widget clickedWidget = currentWidget(point);

		if (clickedWidget == null || dragging || !this.scroll)
		{
			return;
		}

		int clickedWidgetId = clickedWidget.getId();

		if (!spells.containsKey(clickedWidgetId))
		{
			return;
		}

		Spell clickedSpell = spells.get(clickedWidgetId);

		int oldSize = clickedSpell.getSize();
		int tmpSize = tmp.get(clickedWidgetId).getSize();

		if (tmpSize == 0 && oldSize == 0)
		{
			return;
		}

		clickedSpell.setX(clickedSpell.getX() + oldSize);
		clickedSpell.setY(clickedSpell.getY() + oldSize);
		clickedSpell.setSize(0);

		tmp.put(clickedWidgetId, clickedSpell);

		runRebuild();
	}

	void decreaseSize(java.awt.Point point)
	{
		Widget scrolledWidget = currentWidget(point);

		if (scrolledWidget == null || dragging)
		{
			return;
		}

		int scrolledWidgetId = scrolledWidget.getId();

		if (!spells.containsKey(scrolledWidgetId))
		{
			return;
		}

		Spell scrolledSpell = spells.get(scrolledWidgetId);

		// People probably don't want to scroll on a single pixel
		if (trueSize(scrolledSpell) <= 5)
		{
			return;
		}

		scrolledSpell.setSize(scrolledSpell.getSize() - 1);
		scrolledSpell.setX(scrolledSpell.getX() + 1);
		scrolledSpell.setY(scrolledSpell.getY() + 1);

		tmp.put(scrolledWidgetId, scrolledSpell);

		runRebuild();
	}

	private static String removeFlyingComma(String s)
	{
		return s.replaceAll("\"", "");
	}

	private int trueSize(Spell s)
	{
		return s.getSize() * 2 + this.size;
	}

	private void updateConfig()
	{
		this.enableMobile = config.enableMobile();
		this.dragSpells = config.dragSpells();
		this.scroll = config.scroll();
		this.size = config.size();
		this.filter = config.filter();
	}
}
