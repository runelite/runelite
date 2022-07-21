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
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.VarPlayer;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
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
	static final int MAX_CBALLS = 30;

	private CannonCounter counter;
	private boolean cannonBallNotificationSent;
	private WorldPoint clickedCannonLocation;
	private boolean firstCannonLoad;

	@Getter
	private int cballsLeft;

	@Getter
	private boolean cannonPlaced;

	@Getter
	private WorldArea cannonPosition;

	@Getter
	private int cannonWorld = -1;

	@Getter
	private GameObject cannon;

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
		clientThread.invoke(() -> cballsLeft = client.getVar(VarPlayer.CANNON_AMMO));
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
		if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
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
					case ItemID.CANNON_BASE:
					case ItemID.CANNON_BASE_OR:
						hasBase = true;
						break;
					case ItemID.CANNON_STAND:
					case ItemID.CANNON_STAND_OR:
						hasStand = true;
						break;
					case ItemID.CANNON_BARRELS:
					case ItemID.CANNON_BARRELS_OR:
						hasBarrels = true;
						break;
					case ItemID.CANNON_FURNACE:
					case ItemID.CANNON_FURNACE_OR:
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
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();

		Player localPlayer = client.getLocalPlayer();
		if ((gameObject.getId() == ObjectID.CANNON_BASE || gameObject.getId() == ObjectID.CANNON_BASE_43029) && !cannonPlaced)
		{
			if (localPlayer.getWorldLocation().distanceTo(gameObject.getWorldLocation()) <= 2
				&& localPlayer.getAnimation() == AnimationID.BURYING_BONES)
			{
				cannonPosition = buildCannonWorldArea(gameObject.getWorldLocation());
				cannonWorld = client.getWorld();
				cannon = gameObject;
			}
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (cannonPosition != null || (event.getId() != ObjectID.DWARF_MULTICANNON && event.getId() != ObjectID.DWARF_MULTICANNON_43027))
		{
			return;
		}

		// Check if cannonballs are being used on the cannon
		if (event.getMenuAction() == MenuAction.WIDGET_TARGET_ON_GAME_OBJECT && client.getSelectedWidget().getId() == WidgetInfo.INVENTORY.getId())
		{
			final Widget selected = client.getSelectedWidget();
			final int itemId = selected.getItemId();
			if (itemId != ItemID.CANNONBALL && itemId != ItemID.GRANITE_CANNONBALL)
			{
				return;
			}
		}
		// Check for the Fire option being selected on the cannon.
		else if (event.getMenuAction() != MenuAction.GAME_OBJECT_FIRST_OPTION)
		{
			return;
		}

		// Store the click location as a WorldPoint to avoid issues with scene loads
		clickedCannonLocation = WorldPoint.fromScene(client, event.getParam0(), event.getParam1(), client.getPlane());
		log.debug("Updated cannon location: {}", clickedCannonLocation);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		if (varbitChanged.getIndex() == VarPlayer.CANNON_AMMO.getId())
		{
			cballsLeft = client.getVar(VarPlayer.CANNON_AMMO);

			if (config.showCannonNotifications() && !cannonBallNotificationSent && cballsLeft > 0 && config.lowWarningThreshold() >= cballsLeft)
			{
				notifier.notify(String.format("Your cannon has %d cannon balls remaining!", cballsLeft));
				cannonBallNotificationSent = true;
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
			cannonPlaced = true;
			addCounter();
			firstCannonLoad = true;
		}
		else if (event.getMessage().contains("You pick up the cannon")
			|| event.getMessage().contains("Your cannon has decayed. Speak to Nulodion to get a new one!")
			|| event.getMessage().contains("Your cannon has been destroyed!"))
		{
			cannonPlaced = false;
			removeCounter();
			cannonPosition = null;
		}
		else if (event.getMessage().startsWith("You load the cannon with"))
		{
			// Set the cannon's position and object if the player's animation was interrupted during setup
			if (cannonPosition == null && clickedCannonLocation != null)
			{
				// There is a window of 1 tick where the player can add the furnace, click on another cannon, and then
				// the initial cannon load message arrives. This can cause the client to confuse the other cannon with
				// the player's, so ignore that first message when deciding the cannon's location.
				if (firstCannonLoad)
				{
					firstCannonLoad = false;
				}
				else
				{
					LocalPoint lp = LocalPoint.fromWorld(client, clickedCannonLocation);
					if (lp != null)
					{
						GameObject[] objects = client.getScene().getTiles()[client.getPlane()][lp.getSceneX()][lp.getSceneY()].getGameObjects();
						if (objects.length > 0 && client.getLocalPlayer().getWorldLocation().distanceTo(objects[0].getWorldLocation()) <= 2)
						{
							cannonPlaced = true;
							cannonWorld = client.getWorld();
							cannon = objects[0];
							cannonPosition = buildCannonWorldArea(cannon.getWorldLocation());
						}
					}
				}
				clickedCannonLocation = null;
			}

			cannonBallNotificationSent = false;
		}
		else if (event.getMessage().contains("Your cannon is out of ammo!"))
		{
			if (config.showCannonNotifications())
			{
				notifier.notify("Your cannon is out of ammo!");
			}
		}
		else if (event.getMessage().equals("This isn't your cannon!") || event.getMessage().equals("This is not your cannon."))
		{
			clickedCannonLocation = null;
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

	private static WorldArea buildCannonWorldArea(WorldPoint worldPoint)
	{
		return new WorldArea(worldPoint.getX() - 1, worldPoint.getY() - 1, 3, 3, worldPoint.getPlane());
	}
}
