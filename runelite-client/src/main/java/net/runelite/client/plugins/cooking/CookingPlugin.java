/*
 * Copyright (c) 2018, Joris K <kjorisje@gmail.com>
 * Copyright (c) 2018, Lasse <cronick@zytex.dk>
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
package net.runelite.client.plugins.cooking;

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.widgets.ComponentID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import java.awt.Color;
import net.runelite.client.util.ColorUtil;

@Slf4j
@PluginDescriptor(
	name = "Cooking",
	description = "Show cooking statistics",
	tags = {"overlay", "skilling", "cook"}
)
@PluginDependency(XpTrackerPlugin.class)
public class CookingPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private CookingConfig config;

	@Inject
	private CookingOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private CookingSession session;

	@Inject
	private TooltipManager tooltipManager;

	@Provides
	CookingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CookingConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		session = null;
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeIf(FermentTimer.class::isInstance);
		overlayManager.remove(overlay);
		session = null;
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (session == null || config.statTimeout() == 0)
		{
			return;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCooked = Duration.between(session.getLastCookingAction(), Instant.now());

		if (sinceCooked.compareTo(statTimeout) >= 0)
		{
			session = null;
		}
	}

	@Subscribe
	public void onGraphicChanged(GraphicChanged graphicChanged)
	{
		Player player = client.getLocalPlayer();

		if (graphicChanged.getActor() != player)
		{
			return;
		}

		if (player.getGraphic() == GraphicID.WINE_MAKE && config.fermentTimer())
		{
			Optional<FermentTimer> fermentTimerOpt = infoBoxManager.getInfoBoxes().stream()
				.filter(FermentTimer.class::isInstance)
				.map(FermentTimer.class::cast)
				.findAny();

			if (fermentTimerOpt.isPresent())
			{
				FermentTimer fermentTimer = fermentTimerOpt.get();
				fermentTimer.reset();
			}
			else
			{
				FermentTimer fermentTimer = new FermentTimer(itemManager.getImage(ItemID.JUG_OF_WINE), this);
				infoBoxManager.addInfoBox(fermentTimer);
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		final String message = event.getMessage();

		if (message.startsWith("You successfully cook")
			|| message.startsWith("You successfully bake")
			|| message.startsWith("You successfully fry")
			|| message.startsWith("You manage to cook")
			|| message.startsWith("You roast a")
			|| message.startsWith("You spit-roast")
			|| message.startsWith("You cook")
			|| message.startsWith("Eventually the Jubbly")
			|| message.startsWith("You half-cook")
			|| message.startsWith("The undead meat is now cooked")
			|| message.startsWith("The undead chicken is now cooked")
			|| message.startsWith("You successfully scramble")
			|| message.startsWith("You dry a piece of meat"))
		{
			if (session == null)
			{
				session = new CookingSession();
			}

			session.updateLastCookingAction();
			session.increaseCookAmount();

		}
		else if (message.startsWith("You accidentally burn")
			|| message.equals("You burn the mushroom in the fire.")
			|| message.startsWith("Unfortunately the Jubbly")
			|| message.startsWith("You accidentally spoil"))
		{
			if (session == null)
			{
				session = new CookingSession();
			}

			session.updateLastCookingAction();
			session.increaseBurnAmount();
		}
	}

	@Subscribe
	public void onBeforeRender(BeforeRender event)
	{
		if(!config.showCookingTooltips())
		{
			return;
		}

		final MenuEntry[] menuEntries = client.getMenu().getMenuEntries();
		final int last = menuEntries.length - 1;
		if (last < 0)
		{
			return;
		}

		final MenuEntry menuEntry = menuEntries[last];
		final MenuAction action = menuEntry.getType();
		final int widgetId = menuEntry.getParam1();
		final int groupId = WidgetUtil.componentToInterface(widgetId);

		switch (action)
		{
			case WIDGET_TARGET_ON_WIDGET:
				// Check target widget is the inventory
				if (menuEntry.getWidget().getId() != ComponentID.INVENTORY_CONTAINER)
				{
					break;
				}
				// FALLTHROUGH
			case CC_OP:
			case ITEM_USE:
			case ITEM_FIRST_OPTION:
			case ITEM_SECOND_OPTION:
			case ITEM_THIRD_OPTION:
			case ITEM_FOURTH_OPTION:
			case ITEM_FIFTH_OPTION:
				if (groupId == InterfaceID.INVENTORY || groupId == InterfaceID.BANK || groupId == InterfaceID.BANK_INVENTORY)
				{
					addCookingTooltip(menuEntry);
				}
				break;
			case WIDGET_TARGET:
				// Check that this is the inventory
				if (menuEntry.getWidget().getId() == ComponentID.INVENTORY_CONTAINER)
				{
					addCookingTooltip(menuEntry);
				}
		}
	}

	private Color getChanceColor(double chance) {
		if (chance >= 95) return new Color(0, 255, 0); // Bright green
		if (chance >= 80) return new Color(150, 255, 0); // Light green
		if (chance >= 60) return new Color(255, 255, 0); // Yellow
		if (chance >= 40) return new Color(255, 150, 0); // Orange
		return new Color(255, 0, 0); // Red
	}

	private void addCookingTooltip(MenuEntry menuEntry)
	{
		Widget widget = menuEntry.getWidget();
		if (widget == null)
		{
			return;
		}

		int itemId = widget.getItemId();
		Cookables cookable = Cookables.fromItemId(itemId);
		if (cookable == null)
		{
			return;
		}

		int level = client.getBoostedSkillLevel(Skill.COOKING);
		StringBuilder sb = new StringBuilder();
		
		int requiredLevel = cookable.getLevel();
		if (level < requiredLevel)
		{
			sb.append(ColorUtil.wrapWithColorTag("Required cooking level: " + requiredLevel, new Color(255, 0, 0)));
			tooltipManager.add(new Tooltip(sb.toString()));
			return;
		}

		sb.append(ColorUtil.wrapWithColorTag(
				"Cooking chances:",
				new Color(255, 255, 0)
		));
		double fireChance = cookable.calculateFireChance(level);
		if(fireChance > 0)
		{
			sb.append("<br>Fire: ").append(ColorUtil.wrapWithColorTag(
				String.format("%.2f", fireChance) + "%",
				getChanceColor(fireChance)
			));
			if (widget.getId() == ComponentID.BANK_ITEM_CONTAINER)
			{
				int quantity = widget.getItemQuantity();
				double xp = cookable.getXp();
				int totalXp = (int)(quantity * xp * fireChance / 100);
				sb.append("<br>Est. XP: ").append(ColorUtil.wrapWithColorTag(
					String.format("%,d", totalXp),
					new Color(0, 255, 0)
				));
			}
		}
		double rangeChance = cookable.calculateRangeChance(level);
		if(rangeChance > 0)
		{
			sb.append("<br>Range: ").append(ColorUtil.wrapWithColorTag(
				String.format("%.2f", rangeChance) + "%",
				getChanceColor(rangeChance)
			));
			if (widget.getId() == ComponentID.BANK_ITEM_CONTAINER)
			{
				int quantity = widget.getItemQuantity();
				double xp = cookable.getXp();
				int totalXp = (int)(quantity * xp * rangeChance / 100);
				sb.append("<br>Est. XP: ").append(ColorUtil.wrapWithColorTag(
					String.format("%,d", totalXp),
					new Color(0, 255, 0)
				));
			}
		}

		tooltipManager.add(new Tooltip(ColorUtil.wrapWithColorTag(sb.toString(), new Color(238, 238, 238))));
	}
}
