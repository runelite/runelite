/*
 * Copyright (c) 2018, Connor <contact@connor-parks.email>
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

package net.runelite.client.plugins.wildernessassist;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "Wilderness Assist",
		description = "Gain assistance when in the wilderness"
)
@Slf4j
public class WildernessAssistPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PlayerSceneOverlay playerSceneOverlay;

	@Inject
	private Client client;

	@Inject
	private WildernessAssistConfig config;

	@Provides
	WildernessAssistConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WildernessAssistConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(playerSceneOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(playerSceneOverlay);
	}

	public int getWildernessLevel()
	{
		Widget container = client.getWidget(WidgetInfo.WILDERNESS_CONTAINER);

		if (container == null || container.isHidden())
		{
			return 0;
		}

		if (!config.shouldIgnoreSafeZones())
		{
			Widget disabled = client.getWidget(WidgetInfo.WILDERNESS_DISABLED);

			if (disabled != null && !disabled.isHidden())
			{
				return 0;
			}
		}

		Widget wildernessLevel = client.getWidget(WidgetInfo.WILDERNESS_LEVEL);

		if (wildernessLevel != null && !wildernessLevel.isHidden())
		{
			String text = wildernessLevel.getText();

			if (text == null || text.isEmpty())
			{
				return 0;
			}

			text = text.replace("Level:", "").trim();

			return Integer.valueOf(text);
		}

		return getPvPWorldWildernessLevel();
	}

	private int getPvPWorldWildernessLevel()
	{
		Widget wildernessLevelRange = client.getWidget(WidgetInfo.WILDERNESS_LEVEL_RANGE);

		if (wildernessLevelRange == null && wildernessLevelRange.isHidden())
		{
			return 0;
		}

		String text = wildernessLevelRange.getText();

		if (text == null || text.isEmpty())
		{
			return 0;
		}

		String[] levels = text.split("-");

		return (Integer.valueOf(levels[1]) - Integer.valueOf(levels[0])) / 2;
	}

	public boolean withinCombatLevelRange(Player p1, Player p2, int range)
	{
		return Math.abs(p1.getCombatLevel() - p2.getCombatLevel()) <= range;
	}

	public int getScaledDifficulty(Player p1, Player p2, int range)
	{
		int difference = p1.getCombatLevel() - p2.getCombatLevel();

		return Math.min(Math.max(-10, difference), 10);
	}
}
