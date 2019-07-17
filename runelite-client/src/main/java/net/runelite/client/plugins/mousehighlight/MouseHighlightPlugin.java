/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package net.runelite.client.plugins.mousehighlight;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Mouse Tooltips",
	description = "Render default actions as a tooltip",
	tags = {"actions", "overlay", "tooltip", "hide"}
)
@Singleton
public class MouseHighlightPlugin extends Plugin
{
	@Inject
	MouseHighlightConfig config;
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MouseHighlightOverlay overlay;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private boolean mainTooltip;
	@Getter(AccessLevel.PACKAGE)
	private boolean uiTooltip;
	@Getter(AccessLevel.PACKAGE)
	private boolean chatboxTooltip;
	private boolean shouldHideSpells;
	private boolean shouldHideCombat;
	@Getter(AccessLevel.PACKAGE)
	private boolean isRightClickTooltipEnabled;

	@Provides
	MouseHighlightConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MouseHighlightConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		adjustTips();
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		resetTips();
		overlayManager.remove(overlay);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			adjustTips();
		}
	}

	private void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.SPELLBOOK_GROUP_ID || event.getGroupId() == WidgetID.COMBAT_GROUP_ID)
		{
			adjustTips();
		}
	}

	private void onGameTick(GameTick event)
	{
		adjustTips();
	}

	private void adjustTips()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		try
		{
			setTipHidden(WidgetInfo.SPELL_TOOLTIP, this.shouldHideSpells);
			setTipHidden(WidgetInfo.COMBAT_TOOLTIP, this.shouldHideCombat);
		}
		catch (Exception e)
		{
			//swallow
		}
	}

	private void resetTips()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		try
		{
			setTipHidden(WidgetInfo.SPELL_TOOLTIP, false);
			setTipHidden(WidgetInfo.COMBAT_TOOLTIP, false);
		}
		catch (Exception e)
		{
			//swallow
		}
	}

	private void setTipHidden(WidgetInfo widgetInfo, boolean hidden)
	{
		Widget widget = client.getWidget(widgetInfo);

		if (widget == null)
		{
			return;
		}

		widget.setHidden(hidden);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("motherlode"))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.mainTooltip = config.mainTooltip();
		this.uiTooltip = config.uiTooltip();
		this.chatboxTooltip = config.chatboxTooltip();
		this.shouldHideSpells = config.shouldHideSpells();
		this.shouldHideCombat = config.shouldHideCombat();
		this.isRightClickTooltipEnabled = config.isRightClickTooltipEnabled();
	}
}
