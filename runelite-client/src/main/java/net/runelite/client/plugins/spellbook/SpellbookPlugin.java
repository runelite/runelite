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
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Point;
import static net.runelite.api.ScriptID.MAGIC_SPELLBOOK_REDRAW;
import net.runelite.api.VarClientInt;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.vars.InterfaceTab;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.input.MouseManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import static net.runelite.client.util.MiscUtils.clamp;
import net.runelite.api.util.Text;
import org.apache.commons.lang3.StringUtils;

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
	private final Map<Integer, Spell> spells = new HashMap<>();
	private final SpellbookMouseListener mouseListener = new SpellbookMouseListener(this);

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

	private ImmutableSet<String> notFilteredSpells;
	private Spellbook spellbook;
	private boolean mageTabOpen;
	private boolean enableMobile;
	private boolean dragSpells;
	private boolean scroll;
	private int size;

	@Provides
	SpellbookConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SpellbookConfig.class);
	}

	@Override
	protected void startUp()
	{
		addSubscriptions();
		updateConfig();
		refreshMagicTabOption();
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
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(VarClientIntChanged.class, this, this::onVarCIntChanged);
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(WidgetMenuOptionClicked.class, this, this::onWidgetMenuOptionClicked);
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
	}

	private void updateConfig()
	{
		loadFilter();
		this.enableMobile = config.enableMobile();
		this.dragSpells = config.dragSpells();
		this.scroll = config.scroll();
		this.size = config.size();
	}

	private void onConfigChanged(final ConfigChanged event)
	{
		if (!"spellbook".equals(event.getGroup()))
		{
			return;
		}

		switch (event.getKey())
		{
			case "filter":
				loadFilter();
				break;
			case "enableMobile":
				enableMobile = config.enableMobile();
				break;
			case "dragSpells":
				dragSpells = config.dragSpells();
				break;
			case "scroll":
				scroll = config.scroll();
				break;
			case "size":
				size = config.size();
				break;
			default:
				return;
		}

		runRebuild();
		refreshMagicTabOption();
	}

	private void loadFilter()
	{
		notFilteredSpells = ImmutableSet.copyOf(Text.fromCSV(config.filter().toLowerCase()));
		saveSpells();
		loadSpells();
	}

	private void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			mageTabOpen = client.getVar(VarClientInt.INTERFACE_TAB) == InterfaceTab.SPELLBOOK.getId();
			refreshMagicTabOption();
		}
	}

	private void onVarCIntChanged(final VarClientIntChanged event)
	{
		if (event.getIndex() != VarClientInt.INTERFACE_TAB.getIndex())
		{
			return;
		}

		final boolean intfTab = client.getVar(VarClientInt.INTERFACE_TAB) == InterfaceTab.SPELLBOOK.getId();
		if (intfTab != mageTabOpen)
		{
			mageTabOpen = intfTab;
			refreshMagicTabOption();
		}

		if (!config.canDrag() || client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final boolean shouldBeAbleToDrag = mageTabOpen && client.getVar(Varbits.FILTER_SPELLBOOK) == 0;
		if (shouldBeAbleToDrag)
		{
			return;
		}

		mouseManager.unregisterMouseListener(mouseListener);
		mouseManager.unregisterMouseWheelListener(mouseListener);
		config.canDrag(false);
	}

	private void onWidgetMenuOptionClicked(final WidgetMenuOptionClicked event)
	{
		if (event.getWidget() != WidgetInfo.FIXED_VIEWPORT_MAGIC_TAB
			&& event.getWidget() != WidgetInfo.RESIZABLE_VIEWPORT_MAGIC_TAB
			&& event.getWidget() != WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_MAGIC_TAB)
		{
			return;
		}

		saveSpells();
		loadSpells();

		if (event.getMenuOption().equals(UNLOCK))
		{
			config.canDrag(true);

			overlayManager.add(overlay);

			mouseManager.registerMouseListener(mouseListener);

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
		}

		refreshMagicTabOption();
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

		if (!this.dragSpells || !mageTabOpen)
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

	private void onScriptCallbackEvent(final ScriptCallbackEvent event)
	{
		if (client.getVar(Varbits.FILTER_SPELLBOOK) != 0
			|| !this.enableMobile
			|| !event.getEventName().toLowerCase().contains("spell"))
		{
			return;
		}

		final int[] iStack = client.getIntStack();
		final int iStackSize = client.getIntStackSize();

		final String[] sStack = client.getStringStack();
		final int sStackSize = client.getStringStackSize();

		switch (event.getEventName())
		{
			case "startSpellRedraw":
				final Spellbook pook = Spellbook.getByID(client.getVar(Varbits.SPELLBOOK));

				if (pook != spellbook)
				{
					saveSpells();
					spellbook = pook;
					loadSpells();
				}

				break;
			case "shouldFilterSpell":
			{
				final String spell = sStack[sStackSize - 1].toLowerCase();
				final int widget = iStack[iStackSize - 1];

				if (!spells.containsKey(widget))
				{
					final Spell s = new Spell();
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

				iStack[iStackSize - 2] = isUnfiltered(spell, notFilteredSpells) ? 1 : 0;
				break;
			}
			case "isMobileSpellbookEnabled":
				iStack[iStackSize - 1] = 1;
				break;
			case "resizeSpell":
				final int size = this.size;
				final int columns = clamp(FULL_WIDTH / size, 2, 3);

				iStack[iStackSize - 2] = size;
				iStack[iStackSize - 1] = columns;
				break;
			case "setSpellAreaSize":
				if (!this.dragSpells)
				{
					return;
				}

				iStack[iStackSize - 2] = FULL_WIDTH;
				iStack[iStackSize - 1] = FULL_HEIGHT;
				break;
			case "resizeIndividualSpells":
			{
				final int widget = iStack[iStackSize - 1];

				int visibleCount = 0;
				for (Spell spell : spells.values())
				{
					final String s = spell.getName();
					if (isUnfiltered(s, notFilteredSpells))
					{
						visibleCount++;
					}
				}

				if (visibleCount > 20 || visibleCount == 0)
				{
					return;
				}

				final Spell spell = spells.get(widget);
				final int newSize = clamp(trueSize(spell), 0, FULL_WIDTH);

				iStack[iStackSize - 3] = newSize;
				iStack[iStackSize - 2] = newSize;
				break;
			}
			case "setSpellPosition":
			{
				if (!this.dragSpells)
				{
					return;
				}

				final int widget = iStack[iStackSize - 1];
				final Spell s = spells.get(widget);
				final int x = s.getX();
				final int y = s.getY();

				if (x == -1 || y == -1)
				{
					return;
				}

				iStack[iStackSize - 5] = x;
				iStack[iStackSize - 4] = y;
				break;
			}
		}
	}

	private void loadSpells()
	{
		spells.clear();

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (spellbook == null)
		{
			log.debug("Spellbook is null?");
			return;
		}

		final String cfg = configManager.getConfiguration("spellbook", spellbook.getConfigKey());

		if (Strings.isNullOrEmpty(cfg))
		{
			return;
		}

		// CHECKSTYLE:OFF
		final Collection<Spell> gson = GSON.fromJson(cfg, new TypeToken<List<Spell>>() 
		{
		}
		.getType());
		// CHECKSTYLE:ON

		for (final Spell s : gson)
		{
			spells.put(s.getWidget(), s);
		}
	}

	private void saveSpells()
	{
		if (spells.isEmpty())
		{
			return;
		}

		configManager.setConfiguration("spellbook", spellbook.getConfigKey(), GSON.toJson(spells.values()));
	}

	private void runRebuild()
	{
		if (client.getGameState() != GameState.LOGGED_IN || !mageTabOpen)
		{
			return;
		}

		// Runs magic_spellbook_rebuild
		// The magic numbers probably are mobile specific widgetids
		// openosrs mobile when?
		clientThread.invoke(() ->
			client.runScript(
				MAGIC_SPELLBOOK_REDRAW,
				SPELLBOOK_FILTERED_BOUNDS.getId(),
				0x00da00b3,
				SPELL_TOOLTIP.getId(),
				SPELLBOOK_FILTERED_SPELLS_PARENT.getId(),
				SPELLBOOK_FILTER_BUTTON_PARENT.getId(),
				0x00da00ba,
				SPELLBOOK_FILTER_BUTTON.getId(),
				0x00da0002,
				SPELLBOOK_FILTER_SECTION_PARENT.getId(),
				SPELLBOOK_FILTER_BUTTONS_PARENT.getId(),
				"Info",
				"Filters",
				false
			)
		);
	}

	boolean isNotOnSpellWidget()
	{
		if (client.isMenuOpen() || !mageTabOpen)
		{
			return true;
		}

		return currentWidget() == null;
	}

	private Widget currentWidget()
	{
		final Widget parent = client.getWidget(SPELLBOOK_FILTERED_BOUNDS);
		if (parent == null)
		{
			return null;
		}

		for (final Widget w : parent.getStaticChildren())
		{
			if (w.containsMouse())
			{
				return w;
			}
		}

		return null;
	}

	void startDragging(final java.awt.Point point)
	{
		draggingWidget = currentWidget();

		if (draggingWidget == null)
		{
			return;
		}

		final Point widgetPos = draggingWidget.getCanvasLocation();

		final int x = point.x - widgetPos.getX();
		final int y = point.y - widgetPos.getY();

		draggingLocation = new Point(x, y);
		draggingWidget.setHidden(true);
		dragging = true;
	}

	void completeDragging(final java.awt.Point point)
	{
		final Point parentPos = client.getWidget(SPELLBOOK_FILTERED_BOUNDS).getCanvasLocation();

		int x = point.x - draggingLocation.getX() - parentPos.getX();
		int y = point.y - draggingLocation.getY() - parentPos.getY();
		final int size = draggingWidget.getWidth();

		x = clamp(x, 0, FULL_WIDTH - size);
		y = clamp(y, 0, FULL_HEIGHT - size);

		final int draggedID = draggingWidget.getId();
		final Spell n = spells.get(draggedID);

		n.setX(x);
		n.setY(y);

		draggingWidget.setHidden(false);
		dragging = false;

		runRebuild();
	}

	void increaseSize()
	{
		final Widget scrolledWidget = currentWidget();

		if (scrolledWidget == null || dragging)
		{
			return;
		}

		final int scrolledWidgetId = scrolledWidget.getId();
		final Spell scrolledSpell = spells.get(scrolledWidgetId);

		if (scrolledSpell.getX() == -1 || scrolledSpell.getY() == -1)
		{
			scrolledSpell.setX(scrolledWidget.getRelativeX());
			scrolledSpell.setY(scrolledWidget.getRelativeY());
		}

		if (trueSize(scrolledSpell) > FULL_WIDTH - 2)
		{
			scrolledSpell.setX(0);
			scrolledSpell.setY(clamp(scrolledSpell.getY(), 0, FULL_HEIGHT - FULL_WIDTH));
			return;
		}

		scrolledSpell.setSize(scrolledSpell.getSize() + 1);

		scrolledSpell.setX(clamp(scrolledSpell.getX() - 1, 0, FULL_WIDTH - trueSize(scrolledSpell)));
		scrolledSpell.setY(clamp(scrolledSpell.getY() - 1, 0, FULL_HEIGHT - trueSize(scrolledSpell)));

		runRebuild();
	}

	void decreaseSize()
	{
		final Widget scrolledWidget = currentWidget();

		if (scrolledWidget == null || dragging)
		{
			return;
		}

		final int scrolledWidgetId = scrolledWidget.getId();
		final Spell scrolledSpell = spells.get(scrolledWidgetId);

		// People probably don't want to scroll on a single pixel
		if (trueSize(scrolledSpell) <= 5)
		{
			return;
		}

		scrolledSpell.setSize(scrolledSpell.getSize() - 1);

		if (scrolledSpell.getX() == -1 || scrolledSpell.getY() == -1)
		{
			scrolledSpell.setX(scrolledWidget.getRelativeX());
			scrolledSpell.setY(scrolledWidget.getRelativeY());
		}

		scrolledSpell.setX(scrolledSpell.getX() + 1);
		scrolledSpell.setY(scrolledSpell.getY() + 1);

		runRebuild();
	}

	void resetSize()
	{
		final Widget clickedWidget = currentWidget();

		if (clickedWidget == null || dragging || !this.scroll)
		{
			return;
		}

		final int clickedWidgetId = clickedWidget.getId();
		final Spell clickedSpell = spells.get(clickedWidgetId);

		final int oldSize = clickedSpell.getSize();

		if (oldSize == 0)
		{
			return;
		}

		if (clickedSpell.getX() == -1 || clickedSpell.getY() == -1)
		{
			clickedSpell.setX(clickedWidget.getRelativeX());
			clickedSpell.setY(clickedWidget.getRelativeY());
		}

		clickedSpell.setX(clickedSpell.getX() + oldSize);
		clickedSpell.setY(clickedSpell.getY() + oldSize);

		clickedSpell.setSize(0);

		runRebuild();
	}

	// I know this still opens menu but else you
	// wouldn't be able to get out of the spellbook
	// mode thing lol
	void resetLocation()
	{
		final Widget clickedWidget = currentWidget();

		if (clickedWidget == null || dragging)
		{
			return;
		}

		final int clickedWidgetId = clickedWidget.getId();
		final Spell clickedSpell = spells.get(clickedWidgetId);

		clickedSpell.setX(-1);
		clickedSpell.setY(-1);

		runRebuild();
	}

	private int trueSize(final Spell s)
	{
		return s.getSize() * 2 + this.size;
	}

	private static boolean isUnfiltered(final String spell, final Set<String> unfiltereds)
	{
		for (final String str : unfiltereds)
		{
			boolean b;

			if (str.charAt(0) == '\"')
			{
				if (str.charAt(str.length() - 1) == '\"')
				{
					b = spell.equalsIgnoreCase(str.substring(1, str.length() - 1));
				}
				else
				{
					b = StringUtils.startsWithIgnoreCase(spell, str.substring(1));
				}
			}
			else if (str.charAt(str.length() - 1) == '\"')
			{
				b = StringUtils.endsWithIgnoreCase(spell, StringUtils.chop(str));
			}
			else
			{
				b = StringUtils.containsIgnoreCase(spell, str);
			}

			if (b)
			{
				return true;
			}
		}

		return false;
	}
}
