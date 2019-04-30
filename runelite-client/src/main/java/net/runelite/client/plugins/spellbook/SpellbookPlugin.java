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
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Spellbook",
	description = "Modifications to the spellbook",
	tags = {"resize", "spell", "mobile", "lowers", "pvp", "skill", "level"}
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

		if ("canDrag".equals(key))
		{
			refreshMagicTabOption();
		}
		else if ("filter".equals(key))
		{
			loadFilter();
		}

		runRebuild();
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

		if ("shouldFilterSpell".equals(event.getEventName()))
		{
			String spell = sStack[sStackSize - 1].toLowerCase();
			int widget = iStack[iStackSize - 1];

			spellbook = Spellbook.getByID(client.getVar(Varbits.SPELLBOOK));
			loadSpells();

			// Add the spell to spells
			if (!spells.containsKey(widget))
			{
				Spell s = new Spell();
				s.setWidget(widget);
				s.setX(-1);
				s.setY(-1);
				s.setName(spell);

				spells.put(widget, s);
			}

			if (notFilteredSpells.isEmpty())
			{
				return;
			}

			iStack[iStackSize - 2] = notFilteredSpells.stream().anyMatch(spell::contains) ? 1 : 0;
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
		}
		else if (event.getMenuOption().equals(LOCK))
		{
			config.canDrag(false);
			overlayManager.remove(overlay);
			mouseManager.unregisterMouseListener(mouseListener);
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
	}

	private void saveSpells()
	{
		if (spells.isEmpty())
		{
			return;
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

	boolean isOnSpellWidget(java.awt.Point point)
	{
		Widget boundsWidget = client.getWidget(WidgetInfo.SPELLBOOK_FILTERED_BOUNDS);
		if (boundsWidget == null || !boundsWidget.getBounds().contains(point))
		{
			return false;
		}

		for (int id : spells.keySet())
		{
			Widget w = client.getWidget(WidgetInfo.TO_GROUP(id), WidgetInfo.TO_CHILD(id)); // lol very useful

			if (w == null || notFilteredSpells.stream().noneMatch(spells.get(id).getName()::contains))
			{
				continue;
			}

			if (w.getBounds().contains(point))
			{
				return true;
			}
		}

		return false;
	}

	void startDragging(java.awt.Point point)
	{
		for (int id : spells.keySet())
		{
			Widget w = client.getWidget(WidgetInfo.TO_GROUP(id), WidgetInfo.TO_CHILD(id)); // y tho let me just plop in id

			if (w == null || !w.getBounds().contains(point) || notFilteredSpells.stream().noneMatch(spells.get(id).getName()::contains))
			{
				continue;
			}

			draggingWidget = w;
			break;
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

		spells.replace(draggedID, n);

		draggingWidget.setHidden(false);
		dragging = false;

		saveSpells();
	}
}
