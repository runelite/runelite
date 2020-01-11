/*
 * Copyright (c) 2016-2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.cannon;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.awt.Color;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CannonChanged;
import net.runelite.api.events.CannonPlaced;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ItemUtil;

@PluginDescriptor(
	name = "Cannon",
	description = "Show information about cannon placement and/or amount of cannonballs",
	tags = {"combat", "notifications", "ranged", "overlay"},
	type = PluginType.UTILITY
)
public class CannonPlugin extends Plugin
{
	private static final ImmutableSet<Integer> CANNON_PARTS = ImmutableSet.of(
		ItemID.CANNON_BASE, ItemID.CANNON_STAND, ItemID.CANNON_BARRELS, ItemID.CANNON_FURNACE
	);
	private CannonCounter counter;

	@Getter(AccessLevel.PACKAGE)
	private int cballsLeft;

	@Getter(AccessLevel.PACKAGE)
	private boolean cannonPlaced;

	@Getter(AccessLevel.PACKAGE)
	private WorldPoint cannonPosition;

	@Getter(AccessLevel.PACKAGE)
	private GameObject cannon;

	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> spotPoints = new ArrayList<>();

	@Inject
	private ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private Notifier notifier;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private CannonOverlay cannonOverlay;

	@Inject
	private CannonSpotOverlay cannonSpotOverlay;

	@Inject
	private CannonConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	private boolean lock;
	private boolean showEmptyCannonNotification;
	private boolean showInfobox;
	@Getter(AccessLevel.PACKAGE)
	private boolean showDoubleHitSpot;
	@Getter(AccessLevel.PACKAGE)
	private Color highlightDoubleHitColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean showCannonSpots;
	private int ammoAmount;
	private boolean notifyAmmoLeft;

	@Provides
	CannonConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CannonConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();

		overlayManager.add(cannonOverlay);
		overlayManager.add(cannonSpotOverlay);
		lock = false;
	}

	@Override
	protected void shutDown()
	{
		cannonSpotOverlay.setHidden(true);
		overlayManager.remove(cannonOverlay);
		overlayManager.remove(cannonSpotOverlay);
		cannonPlaced = false;
		cannonPosition = null;
		lock = false;
		cballsLeft = 0;
		removeCounter();
		spotPoints.clear();
	}

	@Subscribe
	private void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
		{
			return;
		}

		cannonSpotOverlay.setHidden(!ItemUtil.containsAllItemIds(event.getItemContainer().getItems(), CANNON_PARTS));
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("cannon"))
		{
			updateConfig();

			if (!this.showInfobox)
			{
				removeCounter();
			}
			else
			{
				if (cannonPlaced)
				{
					clientThread.invoke(this::addCounter);
				}
			}
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void checkSpots()
	{
		if (!config.showCannonSpots())
		{
			return;
		}

		spotPoints.clear();
		for (WorldPoint spot : CannonSpots.getCannonSpots())
		{
			if (spot.getPlane() != client.getPlane() || !spot.isInScene(client))
			{
				continue;
			}

			spotPoints.add(spot);
		}
	}

	@Subscribe
	private void onCannonPlaced(CannonPlaced cannonPlacedEvent)
	{
		cannonPlaced = cannonPlacedEvent.isPlaced();
		cannonPosition = cannonPlacedEvent.getCannonLocation();
		cannon = cannonPlacedEvent.getCannon();
	}

	@Subscribe
	private void onCannonballFired(CannonChanged cannonChangedEvent)
	{
		cballsLeft = cannonChangedEvent.getCannonballs();
	}

	@Subscribe
	private void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM && event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (event.getMessage().equals("You add the furnace."))
		{
			addCounter();
		}

		if (event.getMessage().contains("You pick up the cannon")
			|| event.getMessage().contains("Your cannon has decayed. Speak to Nulodion to get a new one!"))
		{
			removeCounter();
		}
	}

	Color getStateColor()
	{
		if (cballsLeft > 15)
		{
			lock = false;
			return Color.green;
		}
		else if (cballsLeft > 5)
		{
			return Color.orange;
		}
		else if (cballsLeft <= this.ammoAmount && this.notifyAmmoLeft && !lock)
		{
			notifier.notify("Your cannon has " + this.ammoAmount + " balls left!");
			lock = true;
		}

		return Color.red;
	}

	private void addCounter()
	{
		if (!this.showInfobox || counter != null)
		{
			return;
		}

		counter = new CannonCounter(itemManager.getImage(ItemID.CANNONBALL), this);
		counter.setTooltip("Cannonballs");

		infoBoxManager.addInfoBox(counter);
	}

	private void removeCounter()
	{
		if (counter == null)
		{
			return;
		}

		infoBoxManager.removeInfoBox(counter);
		counter = null;
	}

	private void updateConfig()
	{
		this.showEmptyCannonNotification = config.showEmptyCannonNotification();
		this.showInfobox = config.showInfobox();
		this.showDoubleHitSpot = config.showDoubleHitSpot();
		this.highlightDoubleHitColor = config.highlightDoubleHitColor();
		this.showCannonSpots = config.showCannonSpots();
		this.ammoAmount = config.ammoAmount();
		this.notifyAmmoLeft = config.notifyAmmoLeft();
	}
}
