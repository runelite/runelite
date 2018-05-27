/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.combat;

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.text.DecimalFormat;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Combat"
)
public class CombatPlugin extends Plugin
{
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###");
	private static final int FIXED_VIEWPORT_MULTI_ADJUSTED = 300;
	private static final int FIXED_VIEWPORT_MULTI_DEFAULT = 296;

	private static final ImmutableList<WorldType> EXCLUDE_WORLD_TYPES = ImmutableList.of(
		WorldType.DEADMAN,
		WorldType.SEASONAL_DEADMAN,
		WorldType.PVP,
		WorldType.PVP_HIGH_RISK);

	@Inject
	private CombatOverlay overlay;

	@Inject
	private Client client;

	@Inject
	private CombatConfig config;

	@Provides
	CombatConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CombatConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Override
	protected void shutDown() throws Exception
	{
		restoreCombatLevel();
		restoreWidgetPosition();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals("combat"))
		{
			if (!config.showCombatDecimals())
			{
				restoreCombatLevel();
			}
			else if (!config.showCombatRange())
			{
				restoreWidgetPosition();
			}
		}
	}

	@Subscribe
	public void updateCombatLevel(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Widget multiWidget = client.getWidget(WidgetInfo.FIXED_VIEWPORT_MULTI_INDICATOR);
		if (config.showCombatRange() && multiWidget != null && !isExcludedWorld())
		{
			multiWidget.setRelativeY(FIXED_VIEWPORT_MULTI_ADJUSTED);
		}

		Widget combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);
		if (!config.showCombatDecimals() || combatLevelWidget == null)
		{
			return;
		}

		double combatLevelPrecise = Experience.getCombatLevelPrecise(
				client.getRealSkillLevel(Skill.ATTACK),
				client.getRealSkillLevel(Skill.STRENGTH),
				client.getRealSkillLevel(Skill.DEFENCE),
				client.getRealSkillLevel(Skill.HITPOINTS),
				client.getRealSkillLevel(Skill.MAGIC),
				client.getRealSkillLevel(Skill.RANGED),
				client.getRealSkillLevel(Skill.PRAYER)
		);

		combatLevelWidget.setText("Combat Lvl: " + DECIMAL_FORMAT.format(combatLevelPrecise));
	}

	public boolean isExcludedWorld()
	{
		return EXCLUDE_WORLD_TYPES.stream().anyMatch(entry -> client.getWorldType().contains(entry));
	}

	private void restoreCombatLevel()
	{
		Widget combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);
		if (combatLevelWidget != null)
		{
			String widgetText = combatLevelWidget.getText();

			if (widgetText.contains("."))
			{
				combatLevelWidget.setText(widgetText.substring(0, widgetText.indexOf(".")));
			}
		}
	}

	private void restoreWidgetPosition()
	{
		Widget multiWidget = client.getWidget(WidgetInfo.FIXED_VIEWPORT_MULTI_INDICATOR);
		if (multiWidget != null)
		{
			multiWidget.setRelativeY(FIXED_VIEWPORT_MULTI_DEFAULT);
		}
	}
}
