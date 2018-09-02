/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.itemcharges;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Item Charges",
	description = "Show number of item charges remaining",
	tags = {"inventory", "notifications", "overlay"}
)
public class ItemChargePlugin extends Plugin
{
	private static final Pattern DODGY_CHECK_PATTERN = Pattern.compile(
		"Your dodgy necklace has (\\d+) charges? left\\.");
	private static final Pattern DODGY_PROTECT_PATTERN = Pattern.compile(
		"Your dodgy necklace protects you\\..*It has (\\d+) charges? left\\.");
	private static final Pattern DODGY_BREAK_PATTERN = Pattern.compile(
		"Your dodgy necklace protects you\\..*It then crumbles to dust\\.");
	private static final String RING_OF_RECOIL_BREAK_MESSAGE = "<col=7f007f>Your Ring of Recoil has shattered.</col>";
	private static final Pattern XERIC_CHECK_CHARGE_PATTERN = Pattern.compile(
		"talisman has (\\d+|one) charges?");
	private static final Pattern XERIC_RECHARGEWIDGET_PATTERN = Pattern.compile(
		"Your talisman now has (\\d+|one) charges?\\.");
	private static final Pattern XERIC_OUT_OF_CHARGES = Pattern.compile(
		"Your talisman has run out of charges");
	private static final Pattern XERIC_UNCHARGE_PATTERN = Pattern.compile(
		"lizard fangs? from your talisman\\.");
	private static final Pattern SOULBEARER_RECHARGE_PATTERN = Pattern.compile(
		"You add (\\d+|a) charges? to your soul bearer.It now has (\\d+) charges\\.");
	private static final Pattern SOULBEARER_RECHARGE_PATTERN2 = Pattern.compile(
		"Your soul bearer now has one charge\\.");
	private static final Pattern SOULBEARER_CHECK_CHARGE_PATTERN = Pattern.compile(
		"soul bearer has (\\d+|one) charges?\\.");
	private static final Pattern SOULBEARER_UNCHARGE_PATTERN = Pattern.compile(
		"You remove the runes from the soul bearer\\.");
	private static final Pattern SOULBEARER_BANKHEADS_PATTERN = Pattern.compile(
		"Your soul bearer carries the ensouled heads? to your ?bank\\. It has (\\d+|one) charges? left\\.");
	private static final Pattern SOULBEARER_OUT_OF_CHARGES = Pattern.compile(
		"Your soul bearer carries the ensouled heads? to (.+)\\. It has run out of charges\\.");

	private static final int MAX_DODGY_CHARGES = 10;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemChargeOverlay overlay;

	@Inject
	private Notifier notifier;

	@Inject
	private ItemChargeConfig config;

	@Inject
	private Client client;

	@Getter(AccessLevel.PACKAGE)
	private int dodgyCharges;

	@Getter(AccessLevel.PACKAGE)
	private int xericCharges;

	@Getter(AccessLevel.PACKAGE)
	private int soulbearerCharges;

	@Provides
	ItemChargeConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemChargeConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		dodgyCharges = config.dodgyNecklace();
		xericCharges = config.xericTalisman();
		soulbearerCharges = config.soulBearer();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String message = event.getMessage();
		if (event.getType() == ChatMessageType.SERVER || event.getType() == ChatMessageType.FILTERED)
		{
			Matcher dodgyCheckMatcher = DODGY_CHECK_PATTERN.matcher(message);
			Matcher dodgyProtectMatcher = DODGY_PROTECT_PATTERN.matcher(message);
			Matcher dodgyBreakMatcher = DODGY_BREAK_PATTERN.matcher(message);
			Matcher xericRechargeMatcher = XERIC_CHECK_CHARGE_PATTERN.matcher(message);
			Matcher xericOutOfChargesMatcher = XERIC_OUT_OF_CHARGES.matcher(message);
			Matcher soulbearerCheckMatcher = SOULBEARER_CHECK_CHARGE_PATTERN.matcher(message);

			if (config.recoilNotification() && message.contains(RING_OF_RECOIL_BREAK_MESSAGE))
			{
				notifier.notify("Your Ring of Recoil has shattered");
			}
			else if (dodgyBreakMatcher.find())
			{
				if (config.dodgyNotification())
				{
					notifier.notify("Your dodgy necklace has crumbled to dust.");
				}

				setDodgyCharges(MAX_DODGY_CHARGES);
			}
			else if (dodgyCheckMatcher.find())
			{
				setDodgyCharges(Integer.parseInt(dodgyCheckMatcher.group(1)));
			}
			else if (dodgyProtectMatcher.find())
			{
				setDodgyCharges(Integer.parseInt(dodgyProtectMatcher.group(1)));
			}
			else if (xericRechargeMatcher.find())
			{
				xericCharges = xericRechargeMatcher.group(1).equals("one") ? 1 : (Integer.parseInt(xericRechargeMatcher.group(1)));
				setXericCharges(xericCharges);
			}
			else if (xericOutOfChargesMatcher.find())
			{
				xericCharges = 0;
				setXericCharges(xericCharges);
			}
			else if (soulbearerCheckMatcher.find())
			{
				soulbearerCharges = soulbearerCheckMatcher.group(1).equals("one") ? 1 : (Integer.parseInt(soulbearerCheckMatcher.group(1)));
				setSoulBearerCharges(soulbearerCharges);
			}
		}
	}

	private void setDodgyCharges(int dodgyCharges)
	{
		this.dodgyCharges = dodgyCharges;
		config.dodgyNecklace(dodgyCharges);
	}

	private void setXericCharges(int xericCharges)
	{
		this.xericCharges = xericCharges;
		config.xericTalisman(xericCharges);
	}

	private void setSoulBearerCharges(int soulBearerCharges)
	{
		this.soulbearerCharges = soulBearerCharges;
		config.soulBearer(soulbearerCharges);
	}

	@Subscribe
	public void onGraphicChanged(GraphicChanged event)
	{
		if (event.getActor() == client.getLocalPlayer())
		{
			if (client.getLocalPlayer().getGraphic() == GraphicID.XERIC_TELEPORT)
			{
				xericCharges = Math.max(xericCharges - 1, 0);
				setXericCharges(xericCharges);
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		Widget dialog1 = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
		Widget dialog2 = client.getWidget(WidgetInfo.DIALOG2_SPRITE_TEXT);
		if (dialog1 != null)
		{
			String widgetText = Text.removeTags(dialog1.getText());
			Matcher xericRechargeMatcher = XERIC_RECHARGEWIDGET_PATTERN.matcher(widgetText);
			Matcher soulbearerRechargeMatcher = SOULBEARER_RECHARGE_PATTERN.matcher(widgetText);
			Matcher soulbearerRecharge2Matcher = SOULBEARER_RECHARGE_PATTERN2.matcher(widgetText);
			if (xericRechargeMatcher.find())
			{
				xericCharges = xericRechargeMatcher.group(1).equals("one") ? 1 : (Integer.parseInt(xericRechargeMatcher.group(1)));
				setXericCharges(xericCharges);
			}
			else if (soulbearerRechargeMatcher.find())
			{
				soulbearerCharges = soulbearerRechargeMatcher.group(2).equals("one") ? 1 : (Integer.parseInt(soulbearerRechargeMatcher.group(2)));
				setSoulBearerCharges(soulbearerCharges);
			}
			else if (soulbearerRecharge2Matcher.find())
			{
				soulbearerCharges = 1;
				setSoulBearerCharges(soulbearerCharges);
			}
		}
		if (dialog2 != null)
		{
			String widgetText = Text.removeTags(dialog2.getText());
			Matcher xericUnchargeMatcher = XERIC_UNCHARGE_PATTERN.matcher(widgetText);
			Matcher soulbearerUnchargeMatcher = SOULBEARER_UNCHARGE_PATTERN.matcher(widgetText);
			Matcher soulbearerBankHeadsMatcher = SOULBEARER_BANKHEADS_PATTERN.matcher(widgetText);
			Matcher soulbearerOutOfCharges = SOULBEARER_OUT_OF_CHARGES.matcher(widgetText);

			if (xericUnchargeMatcher.find())
			{
				xericCharges = 0;
				setXericCharges(xericCharges);
			}
			else if (soulbearerUnchargeMatcher.find() || soulbearerOutOfCharges.find())
			{
				soulbearerCharges = 0;
				setSoulBearerCharges(soulbearerCharges);
			}
			else if (soulbearerBankHeadsMatcher.find())
			{
				soulbearerCharges = soulbearerBankHeadsMatcher.group(1).equals("one") ? 1 : (Integer.parseInt(soulbearerBankHeadsMatcher.group(1)));
				setSoulBearerCharges(soulbearerCharges);
			}
		}
	}
}