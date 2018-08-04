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
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Hitsplat;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.itemcharges.recoil.RecoilManager;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Item Charges",
	description = "Show number of item charges remaining",
	tags = {"inventory", "notifications", "overlay"}
)
public class ItemChargePlugin extends Plugin
{

	private static final String DODGY_CRUMBLE = "Your dodgy necklace protects you. <col=ff0000>It then crumbles to dust.</col>";
	private static final String DODGY_BREAK = "The necklace shatters. Your next dodgy necklace will<br>start afresh from 10 charges.";
	private static final String RECOIL_SHATTER = "<col=7f007f>Your Ring of Recoil has shattered.</col>";
	private static final String RECOIL_BREAK = "The ring shatters. Your next ring of recoil will start<br>afresh from 40 damage points.";

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemChargeOverlay overlay;

	@Inject
	private ItemConfigRegistry registry;

	@Inject
	private RecoilManager recoilManager;

	/**
	 * Charge reduction is about 90% accurate, a shatter chat message is 100% accurate.
	 * Therefore, recoil shatter is checked by chat message instead of regular charge reduction.
	 * In the 90% we do calculate it correctly when it breaks, we want to ignore it.
	 * Which is why a guard flag is used which doesn't update the charges.
	 */
	private boolean recoilShattered;

	@Provides
	ItemChargeConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemChargeConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied event)
	{
		final Hitsplat eventHitsplat = event.getHitsplat();
		final Actor eventActor = event.getActor();

		updateRingOfRecoilCharges(eventHitsplat, eventActor);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		final Widget breakText = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
		if (breakText == null || breakText.getText() == null)
		{
			return;
		}

		updateItemOnBreak(breakText.getText());
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		final String message = event.getMessage();
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		ItemWithVarCharge.forOnCheckMessage(message)
			.ifPresent(item ->
			{
				final int charges = item.getCharges(message);
				registry.setCharges(item, charges);
			});

		updateItemOnDepletion(message);
	}

	private void updateRingOfRecoilCharges(Hitsplat eventHitsplat, Actor eventActor)
	{
		if (eventActor == null)
		{
			return;
		}

		if (eventActor.equals(client.getLocalPlayer()))
		{
			recoilManager.addPlayerHitsplat(eventHitsplat);
		}
		else
		{
			recoilManager.reduceChargesForOpponentHitsplat(eventActor, eventHitsplat)
				.ifPresent(chargeReduction ->
				{
					final ItemWithVarCharge ringOfRecoil = ItemWithVarCharge.RING_OF_RECOIL;
					final int currentCharges = registry.getCharges(ringOfRecoil);
					final int finalCharges = (currentCharges - chargeReduction);

					log.debug("Reducing [{}] charges after actor [{}] was hit for [{}].",
						chargeReduction, eventActor.getName(), eventHitsplat.getAmount());

					// 1. Player receives hitsplat
					// 2. Ring shatter notification happens
					// 3. Hitsplat applied on enemy
					// We use a guard flag to consume the reduction which was handled by the chat message.
					// This is so we don't reduce the charges of a full ring.
					if (!recoilShattered || currentCharges != ringOfRecoil.getChargesOnDepletion())
					{
						registry.setCharges(ringOfRecoil, finalCharges);
					}
					recoilShattered = false;
				});
		}
	}

	private void updateItemOnBreak(String breakText)
	{
		if (RECOIL_BREAK.equals(breakText))
		{
			registry.setCharges(ItemWithVarCharge.RING_OF_RECOIL, ItemWithVarCharge.RING_OF_RECOIL.getChargesOnDepletion());
		}
		else if (DODGY_BREAK.equals(breakText))
		{
			registry.setCharges(ItemWithVarCharge.DODGY_NECKLACE, ItemWithVarCharge.DODGY_NECKLACE.getChargesOnDepletion());
		}
	}

	private void updateItemOnDepletion(String depletionMessage)
	{
		if (DODGY_CRUMBLE.equals(depletionMessage))
		{
			notifyDepletion(ItemWithVarCharge.DODGY_NECKLACE, "Your Dodgy Necklace has crumbled to dust.");
		}
		else if (RECOIL_SHATTER.equals(depletionMessage))
		{
			recoilShattered = true;
			notifyDepletion(ItemWithVarCharge.RING_OF_RECOIL, "Your Ring of Recoil has shattered.");
		}
	}

	private void notifyDepletion(ItemWithVarCharge item, String notifyMessage)
	{
		registry.setCharges(item, item.getChargesOnDepletion());
		registry.sendNotificationIfEnabled(item, notifyMessage);
	}
}
