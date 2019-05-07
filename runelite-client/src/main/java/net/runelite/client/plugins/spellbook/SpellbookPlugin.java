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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Point;
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
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.MouseManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Spellbook",
	description = "Modifications to the spellbook",
	tags = {"resize", "spell", "mobile", "lowers", "pvp", "skill", "level"},
	type = PluginType.UTILITY
)
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
	private static final WidgetMenuOption RESIZABLE_MAGIC_TAB_LOCK = new WidgetMenuOption(LOCK,	MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_MAGIC_TAB);
	private static final WidgetMenuOption RESIZABLE_MAGIC_TAB_UNLOCK = new WidgetMenuOption(UNLOCK,	MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_MAGIC_TAB);
	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_MAGIC_TAB_LOCK = new WidgetMenuOption(LOCK,	MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_MAGIC_TAB);
	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_MAGIC_TAB_UNLOCK = new WidgetMenuOption(UNLOCK,	MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_MAGIC_TAB);
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

	@Getter
	private boolean dragging;

	@Getter
	private Widget draggingWidget;

	@Getter
	private Point draggingLocation;

	private Map<Integer, Spell> spells = new HashMap<>();
	private Map<Integer, Spell> tmp = null;
	private List<String> notFilteredSpells = new ArrayList<>();
	private Spellbook spellbook;
	private SpellbookMouseListener mouseListener;


	@Provides
	SpellbookConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SpellbookConfig.class);
	}

	@Override
	protected void startUp()
	{
		refreshMagicTabOption();
		loadFilter();
		mouseListener = new SpellbookMouseListener(this);
	}

	@Override
	protected void shutDown()
	{
		clearMagicTabMenus();
		saveSpells();
		config.canDrag(false);
		mouseManager.unregisterMouseListener(mouseListener);
		mouseManager.unregisterMouseWheelListener(mouseListener);
		mouseListener = null;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			refreshMagicTabOption();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!"spellbook".equals(event.getGroup()))
		{
			return;
		}

		String key = event.getKey();

		if ("filter".equals(key))
		{
			loadFilter();
		}

		clientThread.invokeLater(this::runRebuild);
		refreshMagicTabOption();
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (config.canDrag())
		{
			config.canDrag(client.getVar(Varbits.FILTER_SPELLBOOK) == 1);
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (client.getVar(Varbits.FILTER_SPELLBOOK) != 0 || !config.enableMobile() || !event.getEventName().toLowerCase().contains("spell"))
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

			for (String str : notFilteredSpells)
			{
				WordFilterMode mode = getFilterMode(str);
				str = str.replaceAll("\"", "");

				if (mode == WordFilterMode.CONTAINS)
				{
					if (spell.contains(str))
					{
						iStack[iStackSize - 2] = 1;
						break;
					}
				}
				else if (mode == WordFilterMode.STARTSWITH)
				{
					if (spell.startsWith(str))
					{
						iStack[iStackSize - 2] = 1;
						break;
					}
				}
				else if (mode == WordFilterMode.ENDSWITH)
				{
					if (spell.endsWith(str))
					{
						iStack[iStackSize - 2] = 1;
						break;
					}
				}
				else if (mode == WordFilterMode.EQUALS)
				{
					if (spell.equals(str))
					{
						iStack[iStackSize - 2] = 1;
						break;
					}
				}

				iStack[iStackSize - 2] = 0;
			}
		}
		else if ("isMobileSpellbookEnabled".equals(event.getEventName()))
		{
			iStack[iStackSize - 1] = 1;
		}
		else if ("resizeSpell".equals(event.getEventName()))
		{
			int size = config.size();
			int columns = Math.max(2, Math.min(FULL_WIDTH / size, 3));

			iStack[iStackSize - 1] = columns;
			iStack[iStackSize - 2] = size;
		}
		else if ("setSpellAreaSize".equals(event.getEventName()))
		{
			if (!config.dragSpells())
			{
				return;
			}

			iStack[iStackSize - 1] = FULL_HEIGHT;
			iStack[iStackSize - 2] = FULL_WIDTH;
		}
		else if ("resizeIndividualSpells".equals(event.getEventName()))
		{
			int widget = iStack[iStackSize - 1];
			int visCount =
				(int) spells.values().stream()
					.map(Spell::getName)
					.filter(s -> notFilteredSpells
						.stream()
						.anyMatch(s.replaceAll("\"", "" )::contains))
					.count();


			if (visCount > 20 || visCount == 0)
			{
				return;
			}

			Spell spell = spells.get(widget);
			int newSize = spell.getSize() * 5 + config.size();

			iStack[iStackSize - 2] = newSize;
			iStack[iStackSize - 3] = newSize;
		}
		else if ("setSpellPosition".equals(event.getEventName()))
		{
			if (!config.dragSpells())
			{
				return;
			}

			int widget = iStack[iStackSize - 1];
			Spell s = spells.get(widget);
			int x = s.getX();
			int y = s.getY();

			if (x == -1)
			{
				return;
			}

			iStack[iStackSize - 5] = x;
			iStack[iStackSize - 4] = y;
		}
	}


	@Subscribe
	public void onWidgetMenuOptionClicked(WidgetMenuOptionClicked event)
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

			if (config.scroll())
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
		if (client.getGameState() != GameState.LOGGED_IN || !config.dragSpells())
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

	private void loadFilter()
	{
		notFilteredSpells.clear();
		notFilteredSpells.addAll(Text.fromCSV(config.filter().toLowerCase()));
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
		Collection<Spell> gson = GSON.fromJson(cfg, new TypeToken<List<Spell>>(){}.getType());
		// CHECKSTYLE:ON
		gson.stream().filter(Objects::nonNull).forEach(s -> spells.put(s.getWidget(), s));

		if (tmp != null)
		{
			tmp.forEach((k, v) -> spells.replace(k, v));
		}
	}

	private void saveSpells()
	{
		if (spells.isEmpty())
		{
			return;
		}

		tmp.forEach((k, v) -> spells.replace(k, v));

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

	boolean isOnSpellWidget(java.awt.Point point)
	{
		Widget boundsWidget = client.getWidget(WidgetInfo.SPELLBOOK_FILTERED_BOUNDS);
		if (boundsWidget == null || !boundsWidget.getBounds().contains(point))
		{
			return false;
		}

		return currentWidget(point) != null;
	}

	private Widget currentWidget(java.awt.Point point)
	{
		for (int id : spells.keySet())
		{
			Widget w = client.getWidget(WidgetInfo.TO_GROUP(id), WidgetInfo.TO_CHILD(id)); // y tho let me just plop in id

			if (w == null || !w.getBounds().contains(point) || notFilteredSpells.stream().noneMatch(spells.get(id).getName()::contains))
			{
				continue;
			}

			return w;
		}

		return null;
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
		int size = config.size();

		if (x < 0)
		{
			x = 0;
		}
		else if (x > FULL_WIDTH - size)
		{
			x = FULL_WIDTH - size;
		}

		if (y < 0)
		{
			y = 0;
		}
		else if (y > FULL_HEIGHT - size)
		{
			y = FULL_HEIGHT - size;
		}

		int draggedID = draggingWidget.getId();

		Spell n = spells.get(draggedID);

		n.setX(x);
		n.setY(y);

		tmp.put(draggedID, n);

		draggingWidget.setHidden(false);
		dragging = false;

		runRebuild();
	}

	void resetZoom(java.awt.Point point)
	{
		Widget clickedWidget = currentWidget(point);

		if (clickedWidget == null || !config.scroll())
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

		clickedSpell.setSize(0);

		clickedSpell.setX(clickedSpell.getX() + oldSize * 5 / 2);
		clickedSpell.setY(clickedSpell.getY() + oldSize * 5 / 2);

		tmp.put(clickedWidgetId, clickedSpell);

		runRebuild();
	}

	void decreaseSize(java.awt.Point point)
	{
		Widget scrolledWidget = currentWidget(point);

		if (scrolledWidget == null)
		{
			return;
		}

		int scrolledWidgetId = scrolledWidget.getId();

		if (!spells.containsKey(scrolledWidgetId))
		{
			return;
		}

		Spell scrolledSpell = spells.get(scrolledWidgetId);

		scrolledSpell.setSize(scrolledSpell.getSize() + 1);

		if (scrolledSpell.getSize() % 2 == 0)
		{
			scrolledSpell.setX(scrolledSpell.getX() - 3);
			scrolledSpell.setY(scrolledSpell.getY() - 3);
		}
		else
		{
			scrolledSpell.setX(scrolledSpell.getX() - 2);
			scrolledSpell.setY(scrolledSpell.getY() - 2);
		}

		tmp.put(scrolledWidgetId, scrolledSpell);

		runRebuild();
	}

	void increaseSize(java.awt.Point point)
	{
		Widget scrolledWidget = currentWidget(point);

		if (scrolledWidget == null)
		{
			return;
		}

		int scrolledWidgetId = scrolledWidget.getId();

		if (!spells.containsKey(scrolledWidgetId))
		{
			return;
		}

		Spell scrolledSpell = spells.get(scrolledWidgetId);
		scrolledSpell.setSize(scrolledSpell.getSize() - 1);

		if (scrolledSpell.getSize() % 2 == 0)
		{
			scrolledSpell.setX(scrolledSpell.getX() + 3);
			scrolledSpell.setY(scrolledSpell.getY() + 3);
		}
		else
		{
			scrolledSpell.setX(scrolledSpell.getX() + 2);
			scrolledSpell.setY(scrolledSpell.getY() + 2);
		}

		tmp.put(scrolledWidgetId, scrolledSpell);

		runRebuild();
	}
}
