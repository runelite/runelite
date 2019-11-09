/*
 * Copyright (c) 2018, Jasper Ketelaar <Jasper0781@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.mta.alchemy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Objects;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import static net.runelite.api.ObjectID.*;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.mta.MTAConfig;
import net.runelite.client.plugins.mta.MTAPlugin;
import net.runelite.client.plugins.mta.MTARoom;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@Slf4j
public class AlchemyRoom extends MTARoom
{
	private static final int MTA_ALCH_REGION = 13462;

	private static final int IMAGE_Z_OFFSET = 150;
	private static final int NUM_CUPBOARDS = 8;
	private static final int INFO_ITEM_START = 8;
	private static final int INFO_POINT_START = 13;
	private static final int INFO_LENGTH = 5;
	private static final int BEST_POINTS = 30;

	private static final String YOU_FOUND = "You found:";
	private static final String EMPTY = "The cupboard is empty.";

	private final Cupboard[] cupboards = new Cupboard[NUM_CUPBOARDS];

	private final MTAPlugin plugin;
	private final Client client;
	private final ItemManager itemManager;
	private final InfoBoxManager infoBoxManager;
	private final EventBus eventBus;

	private AlchemyItem best;
	private Cupboard suggestion;

	private boolean alchemy;

	@Inject
	private AlchemyRoom(final Client client, final MTAConfig config, final MTAPlugin plugin, final ItemManager itemManager, final InfoBoxManager infoBoxManager, final EventBus eventBus)
	{
		super(config);
		this.client = client;
		this.plugin = plugin;
		this.itemManager = itemManager;
		this.infoBoxManager = infoBoxManager;
		this.eventBus = eventBus;

		this.alchemy = config.alchemy();

		addSubscriptions();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(GameObjectSpawned.class, this, this::onGameObjectSpawned);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
	}

	private void onGameTick(GameTick event)
	{
		if (!inside() || !this.alchemy)
		{
			return;
		}

		AlchemyItem bestItem = getBest();
		if (best == null || !best.equals(bestItem))
		{
			if (best != null)
			{
				infoBoxManager.removeIf(e -> e instanceof AlchemyRoomTimer);
				infoBoxManager.addInfoBox(new AlchemyRoomTimer(plugin));
			}

			log.debug("Item change to {}!", best);

			best = bestItem;
			// Reset items to unknown
			Arrays.stream(cupboards)
				.filter(Objects::nonNull)
				.forEach(e -> e.alchemyItem = AlchemyItem.UNKNOWN);
		}

		Cupboard newSuggestion = getSuggestion();
		if (suggestion == null || newSuggestion == null || suggestion.alchemyItem != newSuggestion.alchemyItem)
		{
			suggestion = newSuggestion;
		}
	}

	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (!inside())
		{
			return;
		}

		GameObject spawn = event.getGameObject();
		int cupboardId;

		switch (spawn.getId())
		{
			// Closed and opened versions of each
			case CUPBOARD_23678:
			case CUPBOARD_23679:
				cupboardId = 0;
				break;

			case CUPBOARD_23680:
			case CUPBOARD_23681:
				cupboardId = 1;
				break;

			case CUPBOARD_23682:
			case CUPBOARD_23683:
				cupboardId = 2;
				break;

			case CUPBOARD_23684:
			case CUPBOARD_23685:
				cupboardId = 3;
				break;

			case CUPBOARD_23686:
			case CUPBOARD_23687:
				cupboardId = 4;
				break;

			case CUPBOARD_23688:
			case CUPBOARD_23689:
				cupboardId = 5;
				break;

			case CUPBOARD_23690:
			case CUPBOARD_23691:
				cupboardId = 6;
				break;

			case CUPBOARD_23692:
			case CUPBOARD_23693:
				cupboardId = 7;
				break;

			default:
				return;

		}
		Cupboard cupboard = cupboards[cupboardId];
		if (cupboard != null)
		{
			cupboard.gameObject = spawn;
		}
		else
		{
			cupboard = new Cupboard();
			cupboard.gameObject = spawn;
			cupboard.alchemyItem = AlchemyItem.UNKNOWN;
			cupboards[cupboardId] = cupboard;
		}
	}

	private void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			if (!inside())
			{
				reset();
			}
		}
	}

	private void onChatMessage(ChatMessage wrapper)
	{
		if (!inside() || !config.alchemy())
		{
			return;
		}

		String message = wrapper.getMessage();

		if (wrapper.getType() == ChatMessageType.GAMEMESSAGE && message.contains(YOU_FOUND))
		{
			String item = message.replace(YOU_FOUND, "").trim();
			AlchemyItem alchemyItem = AlchemyItem.find(item);
			Cupboard clicked = getClicked();
			if (clicked.alchemyItem != alchemyItem && alchemyItem != null)
			{
				fill(clicked, alchemyItem);
			}
		}
		else if (message.equals(EMPTY))
		{
			Cupboard clicked = getClicked();

			int idx = Arrays.asList(cupboards).indexOf(clicked);
			for (int i = -2; i <= 2; ++i)
			{
				int j = (idx + i) % 8;
				if (j < 0)
				{
					j = 8 + j;
				}

				Cupboard cupboard = cupboards[j];
				if (cupboard != null && cupboard.alchemyItem == AlchemyItem.UNKNOWN)
				{
					cupboard.alchemyItem = AlchemyItem.POSSIBLY_EMPTY;
				}
			}

			clicked.alchemyItem = AlchemyItem.EMPTY;
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("mta") || !event.getKey().equals("alchemy"))
		{
			return;
		}

		this.alchemy = config.alchemy();
	}


	private void reset()
	{
		Arrays.fill(cupboards, null);
	}

	@Override
	public boolean inside()
	{
		Player player = client.getLocalPlayer();
		return player != null && player.getWorldLocation().getRegionID() == MTA_ALCH_REGION
			&& player.getWorldLocation().getPlane() == 2;
	}

	@Override
	public void under(Graphics2D graphics)
	{
		if (!getConfig().alchemy() || best == null || !inside())
		{
			return;
		}

		boolean found = false;

		for (Cupboard cupboard : cupboards)
		{
			if (cupboard == null)
			{
				continue;
			}

			GameObject object = cupboard.gameObject;
			AlchemyItem alchemyItem = cupboard.alchemyItem;

			if (alchemyItem == AlchemyItem.EMPTY)
			{
				continue;
			}

			if (alchemyItem.equals(best))
			{
				client.setHintArrow(object.getWorldLocation());
				found = true;
			}

			BufferedImage image = itemManager.getImage(alchemyItem.getId());
			Point canvasLoc = Perspective.getCanvasImageLocation(client, object.getLocalLocation(), image, IMAGE_Z_OFFSET);

			if (canvasLoc != null)
			{
				graphics.drawImage(image, canvasLoc.getX(), canvasLoc.getY(), null);
			}
		}

		if (!found && suggestion != null)
		{
			client.setHintArrow(suggestion.gameObject.getWorldLocation());
		}

	}

	@Override
	public void over(Graphics2D graphics)
	{
		if (!inside() || !config.alchemy() || best == null)
		{
			return;
		}

		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);
		if (inventory.isHidden())
		{
			return;
		}

		for (WidgetItem item : inventory.getWidgetItems())
		{
			if (item.getId() != best.getId())
			{
				continue;
			}

			drawItem(graphics, item);
		}
	}

	private AlchemyItem getBest()
	{
		for (int i = 0; i < INFO_LENGTH; i++)
		{
			Widget textWidget = client.getWidget(WidgetID.MTA_ALCHEMY_GROUP_ID, INFO_ITEM_START + i);
			if (textWidget == null)
			{
				return null;
			}

			String item = textWidget.getText();
			Widget pointsWidget = client.getWidget(WidgetID.MTA_ALCHEMY_GROUP_ID, INFO_POINT_START + i);
			int points = Integer.parseInt(pointsWidget.getText());

			if (points == BEST_POINTS)
			{
				return AlchemyItem.find(item);
			}
		}

		return null;
	}

	private Cupboard getClicked()
	{
		Cupboard nearest = null;
		double distance = Double.MAX_VALUE;

		WorldPoint mine = client.getLocalPlayer().getWorldLocation();

		for (Cupboard cupboard : cupboards)
		{
			if (cupboard == null)
			{
				continue;
			}

			double objectDistance = cupboard.gameObject.getWorldLocation().distanceTo(mine);

			if (nearest == null || objectDistance < distance)
			{
				nearest = cupboard;
				distance = objectDistance;
			}
		}

		return nearest;
	}

	private void fill(Cupboard cupboard, AlchemyItem alchemyItem)
	{
		int idx = Arrays.asList(cupboards).indexOf(cupboard);
		assert idx != -1;

		int itemIdx = alchemyItem.ordinal();

		log.debug("Filling cupboard {} with {}", idx, alchemyItem);

		for (int i = 0; i < NUM_CUPBOARDS; ++i)
		{
			int cupIdx = (idx + i) % NUM_CUPBOARDS;
			int itemIndex = (itemIdx + i) % NUM_CUPBOARDS;
			cupboards[cupIdx].alchemyItem = itemIndex <= 4 ? AlchemyItem.values()[itemIndex] : AlchemyItem.EMPTY;
		}
	}

	private Cupboard getSuggestion()
	{
		// check if a cupboard has the best item in it
		if (best != null)
		{
			for (Cupboard cupboard : cupboards)
			{
				if (cupboard != null && cupboard.alchemyItem == best)
				{
					return cupboard;
				}
			}
		}

		// otherwise find the closest cupboard which can not be empty
		Cupboard nearest = null;
		int distance = -1;

		WorldPoint mine = client.getLocalPlayer().getWorldLocation();

		for (Cupboard cupboard : cupboards)
		{
			if (cupboard == null || cupboard.alchemyItem == AlchemyItem.EMPTY || cupboard.alchemyItem == AlchemyItem.POSSIBLY_EMPTY)
			{
				continue;
			}

			int objectDistance = cupboard.gameObject.getWorldLocation().distanceTo(mine);

			if (nearest == null || objectDistance < distance)
			{
				nearest = cupboard;
				distance = objectDistance;
			}
		}

		return nearest;
	}

	private void drawItem(Graphics2D graphics, WidgetItem item)
	{
		Rectangle bounds = item.getCanvasBounds();
		graphics.setColor(Color.GREEN);
		graphics.draw(bounds);
	}

}
