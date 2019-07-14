/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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

package net.runelite.client.plugins.skillcalculator;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.skillcalculator.banked.BankedCalculatorPanel;
import net.runelite.client.plugins.skillcalculator.banked.beans.Activity;
import net.runelite.client.plugins.skillcalculator.banked.beans.CriticalItem;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Skill Calculator",
	description = "Enable the Skill Calculator panel",
	tags = {"panel", "skilling"}
)
public class SkillCalculatorPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private SkillIconManager skillIconManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private SkillCalculatorConfig skillCalculatorConfig;

	@Inject
	private EventBus eventBus;

	private NavigationButton uiNavigationButton;
	private NavigationButton bankedUiNavigationButton;

	private BankedCalculatorPanel bankedUiPanel;
	private int bankHash = -1;

	@Provides
	SkillCalculatorConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SkillCalculatorConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "calc.png");
		final SkillCalculatorPanel uiPanel = new SkillCalculatorPanel(skillIconManager, client, spriteManager, itemManager);

		uiNavigationButton = NavigationButton.builder()
			.tooltip("Skill Calculator")
			.icon(icon)
			.priority(6)
			.panel(uiPanel)
			.build();

		clientToolbar.addNavigation(uiNavigationButton);

		toggleBankedXpPanel();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		clientToolbar.removeNavigation(uiNavigationButton);
		if (bankedUiNavigationButton != null)
		{
			clientToolbar.removeNavigation(bankedUiNavigationButton);
		}
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("skillCalculator") && event.getKey().equals("enabledBankedXp"))
		{
			toggleBankedXpPanel();
		}
	}

	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (!event.getEventName().equals("setBankTitle") || !skillCalculatorConfig.showBankedXp())
		{
			return;
		}

		updateBankItems();
	}

	private void toggleBankedXpPanel()
	{
		if (skillCalculatorConfig.showBankedXp())
		{
			final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "banked.png");

			bankedUiPanel = new BankedCalculatorPanel(client, skillCalculatorConfig, skillIconManager, itemManager);
			bankedUiNavigationButton = NavigationButton.builder()
				.tooltip("Banked XP")
				.icon(icon)
				.priority(6)
				.panel(bankedUiPanel)
				.build();

			clientToolbar.addNavigation(bankedUiNavigationButton);

			clientThread.invoke(() ->
			{
				switch (client.getGameState())
				{
					case LOGIN_SCREEN:
					case LOGIN_SCREEN_AUTHENTICATOR:
					case LOGGING_IN:
					case LOADING:
					case LOGGED_IN:
					case CONNECTION_LOST:
					case HOPPING:
						CriticalItem.prepareItemDefinitions(itemManager);
						Activity.prepareItemDefinitions(itemManager);
						return true;
					default:
						return false;
				}
			});
		}
		else
		{
			if (bankedUiNavigationButton == null)
			{
				return;
			}

			clientToolbar.removeNavigation(bankedUiNavigationButton);

			bankedUiNavigationButton = null;
		}
	}

	// Check if bank contents changed and if so send to UI
	private void updateBankItems()
	{
		final ItemContainer c = client.getItemContainer(InventoryID.BANK);
		if (c == null)
		{
			return;
		}

		final Item[] widgetItems = c.getItems();
		if (widgetItems == null || widgetItems.length == 0)
		{
			return;
		}

		final Map<Integer, Integer> m = new HashMap<>();
		for (Item widgetItem : widgetItems)
		{
			m.put(widgetItem.getId(), widgetItem.getQuantity());
		}

		final int curHash = m.hashCode();
		if (bankHash != curHash)
		{
			bankHash = curHash;
			SwingUtilities.invokeLater(() -> bankedUiPanel.setBankMap(m));
		}
	}
}