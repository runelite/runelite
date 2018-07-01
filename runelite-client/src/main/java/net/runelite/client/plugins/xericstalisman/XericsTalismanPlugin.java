package net.runelite.client.plugins.xericstalisman;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.Subscribe;
import java.util.Arrays;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(name = "Xeric's Talisman")
public class XericsTalismanPlugin extends Plugin
{
	private static final String XERIC_NAME = "Xeric";
	private static final String LOCATION_PREFIX = " <col=e0dbd8>(";
	private static final String LOCATION_SUFFIX = ")</col>";

	private static final Map<String, String> teleportOptions = ImmutableMap.of(
		"Xeric's Look-out", "Shayzien House",
		"Xeric's Glad", "Hosidius House",
		"Xeric's Inferno", "Lovakengj House",
		"Xeric's Heart", "Kourend Castle",
		"Xeric's Honour", "Mount Quidamortem"
	);

	@Inject
	private Client client;

	private Widget xericTeleportOptionsContainer = null;
	private boolean haveOptionedBeenPatched = false;

	// TODO: Add toggle to replace default name entirely.
	// TODO: Remove "Xeric's Talisman" suffix on menu entries.
	// TODO: Add a tooltip saying where it takes you.
	// TODO: Maybe color the options differently if locked/unlocked.
	// TODO: Show charges on necklace (or add that as part of the other jewellery plugin).

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (xericTeleportOptionsContainer == null || haveOptionedBeenPatched)
		{
			return;
		}

		Widget[] children = xericTeleportOptionsContainer.getDynamicChildren();
		if (children == null)
		{
			return;
		}

		for (Widget child : children)
		{
			if (child == null)
			{
				continue;
			}

			// All of the teleport options we want to chagne contain "Xeric" in them.
			final String widgetText = child.getText();
			if (Strings.isNullOrEmpty(widgetText) || !widgetText.contains(XERIC_NAME))
			{
				continue;
			}

			child.setText(replaceText(widgetText));
			haveOptionedBeenPatched |= !child.getText().equals(widgetText);
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (event.getGroupId() == WidgetID.XERICS_TALISMAN_MENU_GROUP_ID)
		{
			xericTeleportOptionsContainer = client.getWidget(WidgetInfo.XERICS_TALISMAN_TELEPORT_OPTIONS);
			haveOptionedBeenPatched = false;
		}
	}

	@Subscribe
	public void onMenuOpened(MenuOpened event)
	{
		MenuEntry firstEntry = event.getFirstEntry();
		if (firstEntry == null)
		{
			return;
		}

		final int widgetId = firstEntry.getParam1();
		if (widgetId != WidgetInfo.EQUIPMENT_AMULET.getId())
		{
			return;
		}

		Widget amuletSlotWidget = client.getWidget(WidgetInfo.EQUIPMENT_AMULET);
		if (amuletSlotWidget == null)
		{
			return;
		}

		Widget itemWidget = amuletSlotWidget.getChild(1);
		if (itemWidget == null || itemWidget.getItemId() != ItemID.XERICS_TALISMAN)
		{
			return;
		}

		MenuEntry[] menuEntries = event.getMenuEntries();
		Arrays.stream(menuEntries)
				.filter(menuEntry -> menuEntry.getOption().contains("Xeric"))
				.forEach(menuEntry -> menuEntry.setOption(replaceText(menuEntry.getOption())));

		client.setMenuEntries(menuEntries);
	}

	private String replaceText(String originalText)
	{
		for (Map.Entry<String, String> entry : teleportOptions.entrySet())
		{
			if (originalText.contains(entry.getKey()))
			{
				return originalText + LOCATION_PREFIX + entry.getValue() + LOCATION_SUFFIX;
			}
		}
		return originalText;
	}
}
