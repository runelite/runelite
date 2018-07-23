/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.SwingUtilities;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.UsernameChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;

@PluginDescriptor(
	name = "Skill Calculator",
	description = "Enable the Skill Calculator panel",
	tags = {"panel", "skilling"}
)
public class SkillCalculatorPlugin extends Plugin
{
	@Inject
	private ClientUI ui;

	@Inject
	private Client client;

	@Inject
	private SkillIconManager skillIconManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private SkillCalculatorConfig skillCalculatorConfig;

	private NavigationButton uiNavigationButton;
	private SkillCalculatorPanel uiPanel;

	@Getter
	private Map<Integer, Integer> bankMap = new HashMap<>();

	// Used to check if the bankMap has changed (sends new bank map to panel)
	private int itemsHash;

	@Provides
	SkillCalculatorConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SkillCalculatorConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("calc.png"));
		}

		SkillCalculator.spriteManager = spriteManager;
		SkillCalculator.itemManager = itemManager;
		SkillCalculator.plugin = this;

		uiPanel = new SkillCalculatorPanel(skillIconManager, client, skillCalculatorConfig);
		uiNavigationButton = NavigationButton.builder()
			.tooltip("Skill Calculator")
			.icon(icon)
			.priority(6)
			.panel(uiPanel)
			.build();
		pluginToolbar.addNavigation(uiNavigationButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		pluginToolbar.removeNavigation(uiNavigationButton);
		bankMap.clear();
		itemsHash = -1;
	}

	@Subscribe
	public void onUsernameChanged(UsernameChanged e)
	{
		bankMap.clear();
		itemsHash = -1;
		SwingUtilities.invokeLater(() -> uiPanel.refreshCurrentCalc());
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("skillCalculator"))
		{
			if (event.getKey().equals("showBankedXp"))
			{
				bankMap.clear();
				itemsHash = -1;
			}

			SwingUtilities.invokeLater(() -> uiPanel.refreshPanel());
		}
	}

	// Pulled from bankvalue plugin to check if bank is open
	@Subscribe
	public void onGameTick(GameTick event)
	{
		Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);

		// Don't update on a search because rs seems to constantly update the title
		if (widgetBankTitleBar == null || widgetBankTitleBar.isHidden() || widgetBankTitleBar.getText().contains("Showing"))
		{
			return;
		}

		// Is there a way to only run when bank first opened/bank gets updated? Currently runs every tick bank is open.
		updateBankItems();
	}

	// Recreates the bankMap hashmap and sends it to the panel if its changed
	private void updateBankItems()
	{
		if (skillCalculatorConfig.showBankedXp())
		{

			Item[] widgetItems = client.getItemContainer(InventoryID.BANK).getItems();

			if (widgetItems == null || widgetItems.length == 0)
			{
				return;
			}

			Map<Integer, Integer> map = new HashMap<>();

			for (Item widgetItem : widgetItems)
			{
				map.put(widgetItem.getId(), widgetItem.getQuantity());
			}

			bankMap = map;

			// Check for change in bank content
			int curHash = map.hashCode();

			if (curHash != itemsHash)
			{
				itemsHash = curHash;
				// send updated bank map to ui
				uiPanel.updateBankMap(bankMap);
			}
		}
	}
}