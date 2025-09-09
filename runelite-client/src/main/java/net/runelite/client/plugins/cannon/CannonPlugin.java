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

import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Cannon",
	description = "Show information about cannon placement and/or amount of cannonballs",
	tags = {"combat", "notifications", "ranged", "overlay"}
)
@Slf4j
public class CannonPlugin extends Plugin
{
	static final int MAX_OVERLAY_DISTANCE = 4100;

	private CannonCounter counter;
	private boolean cannonBallNotificationSent;

	@Getter
	private int cballsLeft;

	@Getter
	private boolean cannonPlaced;

	@Getter
	private WorldArea cannonPosition;

	@Getter
	private int cannonWorld = -1;

	@Getter
	private final List<WorldPoint> spotPoints = new ArrayList<>();

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

	@Provides
	CannonConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CannonConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(cannonOverlay);
		overlayManager.add(cannonSpotOverlay);
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			cballsLeft = client.getVarpValue(VarPlayerID.ROCKTHROWER);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		cannonSpotOverlay.setHidden(true);
		overlayManager.remove(cannonOverlay);
		overlayManager.remove(cannonSpotOverlay);
		cannonPlaced = false;
		cannonWorld = -1;
		cannonPosition = null;
		cannonBallNotificationSent = false;
		cballsLeft = 0;
		removeCounter();
		spotPoints.clear();
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.INV))
		{
			return;
		}

		boolean hasBase = false;
		boolean hasStand = false;
		boolean hasBarrels = false;
		boolean hasFurnace = false;
		boolean hasAll = false;

		if (!cannonPlaced)
		{
			for (Item item : event.getItemContainer().getItems())
			{
				if (item == null)
				{
					continue;
				}

				switch (item.getId())
				{
					case ItemID.TWPART1:
					case ItemID.LEAGUE_3_MULTICANNON_BASE:
						hasBase = true;
						break;
					case ItemID.TWPART2:
					case ItemID.LEAGUE_3_MULTICANNON_STAND:
						hasStand = true;
						break;
					case ItemID.TWPART3:
					case ItemID.LEAGUE_3_MULTICANNON_BARRELS:
						hasBarrels = true;
						break;
					case ItemID.TWPART4:
					case ItemID.LEAGUE_3_MULTICANNON_FURNACE:
						hasFurnace = true;
						break;
				}

				if (hasBase && hasStand && hasBarrels && hasFurnace)
				{
					hasAll = true;
					break;
				}
			}
		}

		cannonSpotOverlay.setHidden(!hasAll);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("cannon"))
		{
			if (!config.showInfobox())
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

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		spotPoints.clear();
		for (WorldPoint spot : CannonSpots.getCannonSpots())
		{
			if (WorldPoint.isInScene(client, spot.getX(), spot.getY()))
			{
				spotPoints.add(spot);
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		if (varbitChanged.getVarpId() == VarPlayerID.ROCKTHROWER)
		{
			int old = cballsLeft;
			cballsLeft = varbitChanged.getValue();

			if (cballsLeft > old)
			{
				cannonBallNotificationSent = false;
			}

			if (!cannonBallNotificationSent && cballsLeft > 0 && config.lowWarningThreshold() >= cballsLeft)
			{
				notifier.notify(config.showCannonNotifications(), String.format("Your cannon has %d cannon balls remaining!", cballsLeft));
				cannonBallNotificationSent = true;
			}
		}
		else if (varbitChanged.getVarpId() == VarPlayerID.OWNEDMCANNON)
		{
			WorldPoint c = WorldPoint.fromCoord(varbitChanged.getValue());
			cannonPosition = buildCannonWorldArea(c);
		}
		else if (varbitChanged.getVarpId() == VarPlayerID.DROPCANNON)
		{
			cannonPlaced = varbitChanged.getValue() == 4;

			if (cannonPlaced)
			{
				addCounter();
			}
			else
			{
				removeCounter();
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM && event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (event.getMessage().equals("You add the furnace."))
		{
			cannonWorld = client.getWorld();
		}
		else if (event.getMessage().contains("Your cannon is out of ammo!"))
		{
			notifier.notify(config.showCannonNotifications(), "Your cannon is out of ammo!");
		}
	}

	Color getStateColor()
	{
		if (cballsLeft > 15)
		{
			return Color.green;
		}
		else if (cballsLeft > 5)
		{
			return Color.orange;
		}

		return Color.red;
	}

	private void addCounter()
	{
		if (!config.showInfobox() || counter != null)
		{
			return;
		}

		counter = new CannonCounter(itemManager.getImage(ItemID.MCANNONBALL), this);
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

	private static WorldArea buildCannonWorldArea(WorldPoint worldPoint)
	{
		return new WorldArea(worldPoint.getX(), worldPoint.getY(), 3, 3, worldPoint.getPlane());
	}
}
