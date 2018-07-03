/*
 * Copyright (c) 2018, Tyler Staples <github.com/tstaples>
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
package net.runelite.client.plugins.xericstalisman;

import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
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
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

/**
 * Possible extensions:
 * - Add a tooltip saying where it takes you (ie. "south of the Infirmary" for Shayzien).
 * - Colorize the options differently if locked/unlocked.
 * - Show charges on necklace (or add that as part of the other jewellery plugin).
 */
@PluginDescriptor(name = "Xeric's Talisman")
public class XericsTalismanPlugin extends Plugin
{
	private static final String XERIC_NAME = "Xeric";
	private static final Color TELEPORT_MENU_ACTION_COLOR = new Color(207, 205, 204);
	private static final Color TELEPORT_WINDOW_OPTION_COLOR = new Color(110, 10, 1);

	private static final Map<String, String> teleportOptions = ImmutableMap.of(
		"Xeric's Look-out", "Shayzien House",
		"Xeric's Glad", "Hosidius House",
		"Xeric's Inferno", "Lovakengj House",
		"Xeric's Heart", "Kourend Castle",
		"Xeric's Honour", "Mount Quidamortem"
	);

	@Inject
	private Client client;

	@Inject
	private XericsTalismanConfig config;

	@Provides
	private XericsTalismanConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(XericsTalismanConfig.class);
	}

	private Widget xericTeleportOptionsContainer = null;
	private boolean haveOptionedBeenPatched = false;

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

		Arrays.stream(children)
			.filter(Objects::nonNull)
			.filter(widget -> widget.getText().contains(XERIC_NAME))
			.forEach(widget -> widget.setText(getReplacedText(widget.getText(), TELEPORT_WINDOW_OPTION_COLOR)));

		// Prevent updating the text more than once.
		haveOptionedBeenPatched = true;
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		// Listen for when the user opens the teleport menu via the 'rub' option on the talisman.
		// The teleport options are dynamic widgets and therefore are not created yet when this is called. So instead
		// we store the widget and check on tick to see if the children have been created.
		if (event.getGroupId() == WidgetID.SCROLL_MENU_WIDGET_ID)
		{
			xericTeleportOptionsContainer = client.getWidget(WidgetInfo.SCROLL_MENU_WIDGET_OPTIONS_CONTAINER);
			haveOptionedBeenPatched = false;
		}
	}

	@Subscribe
	public void onMenuOpened(MenuOpened event)
	{
		if (!isEquippedTalismanMenu(event.getFirstEntry()))
		{
			return;
		}

		MenuEntry[] menuEntries = event.getMenuEntries();
		Arrays.stream(menuEntries)
			.filter(menuEntry -> menuEntry.getOption().contains(XERIC_NAME))
			.forEach(menuEntry ->
			{
				menuEntry.setOption(getReplacedText(menuEntry.getOption(), TELEPORT_MENU_ACTION_COLOR));
				menuEntry.setTarget(config.hideMenuActionTargetForTeleports() ? "" : menuEntry.getTarget());
			});

		client.setMenuEntries(menuEntries);
	}

	/**
	 * Checks if a menu entry belongs to the right-click menu of an equipped Xeric's talisman.
	 */
	private boolean isEquippedTalismanMenu(MenuEntry entry)
	{
		if (entry == null)
		{
			return false;
		}

		final int widgetId = entry.getParam1();
		if (widgetId != WidgetInfo.EQUIPMENT_AMULET.getId())
		{
			return false;
		}

		Widget amuletSlotWidget = client.getWidget(WidgetInfo.EQUIPMENT_AMULET);
		if (amuletSlotWidget == null)
		{
			return false;
		}

		Widget itemWidget = amuletSlotWidget.getChild(1);
		return (itemWidget != null && itemWidget.getItemId() == ItemID.XERICS_TALISMAN);
	}

	/**
	 * Looks up the corresponding location and if found returns the new string based on the config options:
	 * hideOriginalTeleportName is true - formatted as a colorized suffix of the original text and place in parenthesis.
	 * hideOriginalTeleportName is true - replaces the key part inline (without colorizing) so any surrounding text is preserved (ie. numbers in teleport menu).
	 * @param originalText The string (possibly containing a teleport option) to edit.
	 * @param textColor The color of the location name if the text is to be colorized based on the config.
	 * @return The full string that should be used instead of the original text - or the original text if no location was found.
	 */
	private String getReplacedText(String originalText, Color textColor)
	{
		Optional<String> key = teleportOptions.keySet()
			.stream()
			.filter(originalText::contains)
			.findAny();

		if (!key.isPresent())
		{
			return originalText;
		}

		final String locationName = teleportOptions.get(key.get());
		return config.hideOriginalTeleportName()
			? originalText.replaceAll(key.get(), locationName)
			: originalText + colorizeText(" (" + locationName + ")", textColor);
	}

	private static String colorizeText(String text, Color textColor)
	{
		return "<col=" + Integer.toHexString(textColor.getRGB() & 0xFFFFFF) + ">" + text + "</col>";
	}
}
