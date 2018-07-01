package net.runelite.client.plugins.xericstalisman;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.Subscribe;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
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

	// TODO: Add a tooltip saying where it takes you.
	// TODO: Maybe color the options differently if locked/unlocked.
	// TODO: Also patch the menu entry for when it's worn.
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

			String widgetText = child.getText();
			if (Strings.isNullOrEmpty(widgetText) || !widgetText.contains(XERIC_NAME))
			{
				continue;
			}

			for (String key : teleportOptions.keySet())
			{
				if (widgetText.contains(key))
				{
					child.setText(widgetText + " (" + teleportOptions.get(key) + ")");
					haveOptionedBeenPatched = true;
				}
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final int groupId = event.getGroupId();
		if (groupId == WidgetID.XERICS_TALISMAN_MENU_GROUP_ID)
		{
			xericTeleportOptionsContainer = client.getWidget(WidgetInfo.XERICS_TALISMAN_TELEPORT_OPTIONS);
			haveOptionedBeenPatched = false;
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		// TODO
	}
}
