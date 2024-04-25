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
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
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
	enum Cannon
	{
		NULL,
		INCOMPLETE,
		COMPLETE
	}

	static final int MAX_OVERLAY_DISTANCE = 4100;

	private CannonCounter counter;
	private boolean broken;

	@Getter
	private int cballsLeft;

	@Getter
	private Cannon state = Cannon.NULL;

	@Getter
	@Setter
	private WorldPoint cannonWorldPoint;

	@Getter
	private int cannonWorld = -1;

	@Getter
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
			clientThread.invoke(this::setFields);
			clientThread.invokeLater(this::addCounter);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		cannonSpotOverlay.setHidden(true);
		overlayManager.remove(cannonOverlay);
		overlayManager.remove(cannonSpotOverlay);
		cannonWorld = -1;
		cballsLeft = 0;
		removeCounter();
		spotPoints.clear();
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
				if (state == Cannon.COMPLETE)
				{
					addCounter();
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
		if (varbitChanged.getVarpId() == VarPlayer.CANNON_AMMO)
		{
			int previousAmmoCount = cballsLeft;
			cballsLeft = varbitChanged.getValue();

			// VarPlayer.DWARF_CANNON_LOCATION is fired before VarPlayer.CANNON_AMMO when the cannon is picked up
			// The location will be null before the cannon ammo is emptied to zero, preventing a false empty notification
			if (!config.showCannonNotifications() || cannonWorldPoint == null || previousAmmoCount != cballsLeft + 1)
			{
				return;
			}

			if (cballsLeft == 0 && previousAmmoCount == 1)
			{
				notifier.notify("Your cannon is out of ammo!");
			}
			else if (cballsLeft <= config.lowWarningThreshold() && previousAmmoCount > config.lowWarningThreshold())
			{
				notifier.notify(String.format("Your cannon has %d cannon balls remaining!", cballsLeft));
			}
		}

		if (varbitChanged.getVarpId() == VarPlayer.DWARF_CANNON_PARTS_ASSEMBLED)
		{
			int partsAssembled = varbitChanged.getValue();

			if (partsAssembled == 0)
			{
				state = Cannon.NULL;
				removeCounter();
			}
			else if (partsAssembled == 4)
			{
				state = Cannon.COMPLETE;
				addCounter();
			}
			else
			{
				state = Cannon.INCOMPLETE;
			}
		}

		if (varbitChanged.getVarpId() == VarPlayer.DWARF_CANNON_LOCATION)
		{
			cannonWorldPoint = worldPointFromVar();

			if (cannonWorldPoint != null)
			{
				cannonWorld = client.getWorld();
				log.debug("Updated cannon location: {}", cannonWorldPoint);
			}
		}

		if (varbitChanged.getVarbitId() == Varbits.DWARF_CANNON_STATE)
		{
			broken = varbitChanged.getValue() == 1;

			if (broken)
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

		if (event.getMessage().contains("Your cannon has decayed. Speak to Nulodion to get a new one!")
			|| event.getMessage().contains("Your cannon has been destroyed!"))
		{
			state = Cannon.NULL;
			cannonWorldPoint = null;
			removeCounter();
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
		if (!config.showInfobox() || counter != null || state != Cannon.COMPLETE || broken)
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

	private WorldPoint worldPointFromVar()
	{
		int var = client.getVarpValue(VarPlayer.DWARF_CANNON_LOCATION);

		if (var == -1)
		{
			return null;
		}

		// See VarPlayer#DWARF_CANNON_LOCATION
		int x = (var & ((1 << 28) - 1)) >> 14;
		int y = var & ((1 << 14) - 1);
		int z = var >> 28;

		return new WorldPoint(x, y, z);
	}

	private void setFields()
	{
		cballsLeft = client.getVarpValue(VarPlayer.CANNON_AMMO);
		cannonWorldPoint = worldPointFromVar();
		cannonWorld = cannonWorldPoint == null ? -1 : client.getWorld();

		int parts = client.getVarpValue(VarPlayer.DWARF_CANNON_PARTS_ASSEMBLED);

		state = parts == 4
				? Cannon.COMPLETE
				: parts == 0
						? Cannon.NULL
						: Cannon.INCOMPLETE;
	}
}