/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.combatlevel;

import com.google.inject.Provides;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Combat Level",
	description = "Show a more accurate combat level in Combat Options panel and other combat level functions",
	tags = {"wilderness", "attack", "range"}
)
@Singleton
public class CombatLevelPlugin extends Plugin
{
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###");
	private static final String CONFIG_GROUP = "combatlevel";
	private static final String ATTACK_RANGE_CONFIG_KEY = "wildernessAttackLevelRange";
	private static final Pattern WILDERNESS_LEVEL_PATTERN = Pattern.compile("^Level: (\\d+)$");
	private static final int SKULL_CONTAINER_ADJUSTED_ORIGINAL_Y = 6;
	private static final int WILDERNESS_LEVEL_TEXT_ADJUSTED_ORIGINAL_Y = 3;
	private static final int MIN_COMBAT_LEVEL = 3;

	private int originalWildernessLevelTextPosition = -1;
	private int originalSkullContainerPosition = -1;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private CombatLevelConfig config;

	@Inject
	private CombatLevelOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private boolean showLevelsUntil;
	private boolean wildernessAttackLevelRange;

	@Provides
	CombatLevelConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CombatLevelConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);

		if (this.wildernessAttackLevelRange)
		{
			appendAttackLevelRangeText();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		Widget combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);

		if (combatLevelWidget != null)
		{
			String widgetText = combatLevelWidget.getText();

			if (widgetText.contains("."))
			{
				combatLevelWidget.setText(widgetText.substring(0, widgetText.indexOf('.')));
			}
		}

		shutDownAttackLevelRange();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
	}

	private void onGameTick(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Widget combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);
		if (combatLevelWidget == null)
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

	private void onConfigChanged(ConfigChanged event)
	{
		if (!CONFIG_GROUP.equals(event.getGroup()) || !ATTACK_RANGE_CONFIG_KEY.equals(event.getKey()))
		{
			return;
		}

		updateConfig();

		if (this.wildernessAttackLevelRange)
		{
			appendAttackLevelRangeText();
		}
		else
		{
			shutDownAttackLevelRange();
		}
	}

	private void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (this.wildernessAttackLevelRange
			&& "wildernessWidgetTextSet".equals(event.getEventName()))
		{
			appendAttackLevelRangeText();
		}
	}

	private void appendAttackLevelRangeText()
	{
		final Widget wildernessLevelWidget = client.getWidget(WidgetInfo.PVP_WILDERNESS_LEVEL);
		if (wildernessLevelWidget == null)
		{
			return;
		}

		final String wildernessLevelText = wildernessLevelWidget.getText();
		final Matcher m = WILDERNESS_LEVEL_PATTERN.matcher(wildernessLevelText);
		if (!m.matches()
			|| WorldType.isPvpWorld(client.getWorldType()))
		{
			return;
		}

		final Widget skullContainer = client.getWidget(WidgetInfo.PVP_SKULL_CONTAINER);
		if (originalWildernessLevelTextPosition == -1)
		{
			originalWildernessLevelTextPosition = wildernessLevelWidget.getOriginalY();
		}
		if (originalSkullContainerPosition == -1)
		{
			originalSkullContainerPosition = skullContainer.getRelativeY();
		}

		final int wildernessLevel = Integer.parseInt(m.group(1));
		final int combatLevel = client.getLocalPlayer().getCombatLevel();

		wildernessLevelWidget.setText(wildernessLevelText + "<br>" + combatAttackRange(combatLevel, wildernessLevel));
		wildernessLevelWidget.setOriginalY(WILDERNESS_LEVEL_TEXT_ADJUSTED_ORIGINAL_Y);
		skullContainer.setOriginalY(SKULL_CONTAINER_ADJUSTED_ORIGINAL_Y);

		clientThread.invoke(wildernessLevelWidget::revalidate);
		clientThread.invoke(skullContainer::revalidate);
	}

	private void shutDownAttackLevelRange()
	{
		if (WorldType.isPvpWorld(client.getWorldType()))
		{
			return;
		}

		final Widget wildernessLevelWidget = client.getWidget(WidgetInfo.PVP_WILDERNESS_LEVEL);
		if (wildernessLevelWidget != null)
		{
			String wildernessLevelText = wildernessLevelWidget.getText();
			if (wildernessLevelText.contains("<br>"))
			{
				wildernessLevelWidget.setText(wildernessLevelText.substring(0, wildernessLevelText.indexOf("<br>")));
			}
			wildernessLevelWidget.setOriginalY(originalWildernessLevelTextPosition);
			clientThread.invoke(wildernessLevelWidget::revalidate);
		}
		originalWildernessLevelTextPosition = -1;

		final Widget skullContainer = client.getWidget(WidgetInfo.PVP_SKULL_CONTAINER);
		if (skullContainer != null)
		{
			skullContainer.setOriginalY(originalSkullContainerPosition);
			clientThread.invoke(skullContainer::revalidate);
		}
		originalSkullContainerPosition = -1;
	}

	private static String combatAttackRange(final int combatLevel, final int wildernessLevel)
	{
		return Math.max(MIN_COMBAT_LEVEL, combatLevel - wildernessLevel) + "-" + Math.min(Experience.MAX_COMBAT_LEVEL, combatLevel + wildernessLevel);
	}

	private void updateConfig()
	{
		this.showLevelsUntil = config.showLevelsUntil();
		this.wildernessAttackLevelRange = config.showLevelsUntil();
	}
}
