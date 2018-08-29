/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Dalton <delps1001@gmail.com>
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
package net.runelite.client.plugins.runecraftingprofit;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import javax.inject.Inject;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static net.runelite.client.callback.Hooks.log;

@PluginDescriptor(
		name = "Runecrafting Profit",
		enabledByDefault = false
)
public class RunecraftingProfitPlugin extends Plugin
{

	boolean displayProfit = false;
	boolean displayOverlay = false;
	private boolean lastTickAnimationWasRunecrafting = false;
	private boolean firstRunecraft = false;
	private Instant lastRunecraftingAnimation;
	private Instant startTime;

	@Inject
	private Client client;

	@Inject
	private RunecraftingProfitSession session;

	@Inject
	private RunecraftingProfitOverlay overlay;

	@Inject
	private RunecraftingProfitConfig config;

	@Provides
	RunecraftingProfitConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RunecraftingProfitConfig.class);
	}

	@Override
	protected void startUp()
	{
		lastRunecraftingAnimation = Instant.now();
	}

	@Override
	protected void shutDown()
	{
		session.clearSession();
		this.firstRunecraft = false;
		this.displayOverlay = false;
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (ChronoUnit.MINUTES.between(this.lastRunecraftingAnimation, Instant.now()) >= config.overlayTimeout())
		{
			displayOverlay = false;
			return;
		}
		else
		{
			displayOverlay = true;
		}
		Player localPlayer = client.getLocalPlayer();
		lastTickAnimationWasRunecrafting = localPlayer.getAnimation() == AnimationID.RUNECRAFTING_ANIMATION;
	}


	@Subscribe
	private void onAnimationChanged(AnimationChanged anim)
	{
		if (anim.getActor() == client.getLocalPlayer() && anim.getActor().getAnimation() == AnimationID.RUNECRAFTING_ANIMATION)
		{
			this.lastRunecraftingAnimation = Instant.now();
			if (!this.firstRunecraft)
			{
				startTime = Instant.now();
				this.firstRunecraft = true;
			}
			try
			{
				ArrayList<Item> items = getInventoryContents();
				session.updatePreviousRunesInInventory(items);
			}
			catch (NullPointerException e)
			{
				log.debug("inventory is empty...");
			}

		}
		else if (anim.getActor() == client.getLocalPlayer() && (anim.getActor().getAnimation() != AnimationID.RUNECRAFTING_ANIMATION) && lastTickAnimationWasRunecrafting)
		{
			session.updateTotalCraftedRunes(getInventoryContents());
		}
	}

	private ArrayList<Item> getInventoryContents() throws NullPointerException
	{
		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		Item[] itemsArray = inventory.getItems();
		if (itemsArray != null)
		{
			return new ArrayList<>(Arrays.asList(itemsArray));
		}
		else
		{
			return null;
		}
	}

	@Schedule(
			period = 5,
			unit = ChronoUnit.SECONDS
	)
	public void alternateProfitAndRunesCrafted()
	{
		this.displayProfit = !this.displayProfit;
	}

	public Instant getStartTime()
	{
		return startTime;
	}

	public Client getClient()
	{
		return client;
	}

	public void setClient(Client client)
	{
		this.client = client;
	}

	boolean isFirstRunecraft()
	{
		return firstRunecraft;
	}

	public Instant getLastRunecraftingAnimation()
	{
		return lastRunecraftingAnimation;
	}

	public RunecraftingProfitSession getSession()
	{
		return session;
	}

	public void setSession(RunecraftingProfitSession session)
	{
		this.session = session;
	}

}
