/*
 * Copyright (c) 2018, Kristian <https://github.com/kristian-welsh>
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
package net.runelite.client.plugins.birdhouses;

import com.google.common.eventbus.Subscribe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Birdhouses",
	description = "highlights the positions of empty birdhouses",
	tags = {"birdhouse", "fosil island", "highlight"}
)
public class BirdhousesPlugin extends Plugin
{
	private static final int[] BIRDHOUSE_REGIONS = {
		14906,
		14652,
		14651
	};
	
	private static final List<Integer> BIRDHOUSE_IDS = Arrays.asList(
		30565,
		30566,
		30567,
		30568
	);
	
	@Getter
	private List<TileObject> emptyBirdhouses;
	
	@Getter
	private boolean nearBirdhouses;
	
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BirdhousesOverlay overlay;
	
	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlay.setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}
	
	// may be worthwhile to only calculate this when it could change and cache result
	public boolean isNearBirdhouses()
	{
		return client.getMapRegions() != null && Arrays.stream(client.getMapRegions())
				.filter(x -> Arrays.stream(BIRDHOUSE_REGIONS).anyMatch(y -> y == x))
				.toArray().length > 0;
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGGING_IN:
				emptyBirdhouses = new ArrayList<>();
				break;
			case LOADING:
				emptyBirdhouses.clear();
				break;
			default:
				break;
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if(BIRDHOUSE_IDS.contains(event.getGameObject().getId()))
		{
			System.out.println("--- birdhouse spawned");
		}
		onGameObject(event.getTile(), null, event.getGameObject());
	}

	@Subscribe
	public void onGameObjectChanged(GameObjectChanged event)
	{
		if(BIRDHOUSE_IDS.contains(event.getGameObject().getId()))
		{
			System.out.println("--- birdhouse changed");
		}
		onGameObject(event.getTile(), event.getPrevious(), event.getGameObject());
	}

	@Subscribe
	public void onGameObjectDeSpawned(GameObjectDespawned event)
	{
		if(BIRDHOUSE_IDS.contains(event.getGameObject().getId()))
		{
			System.out.println("--- birdhouse despawned");
		}
		onGameObject(event.getTile(), event.getGameObject(), null);
	}

	private void onGameObject(Tile tile, TileObject oldObject, TileObject newObject)
	{
		if(oldObject != null && emptyBirdhouses.contains(oldObject))
		{
			System.out.println("--- birdhouse removed");
			emptyBirdhouses.remove(oldObject);
		}
		
		if (newObject == null)
		{
			return;
		}
		
		if(BIRDHOUSE_IDS.contains(newObject.getId()))
		{
			if(true)//is empty
			{
				System.out.println("--- birdhouse added");
				System.out.println(newObject.getId());
				emptyBirdhouses.add(newObject);
			}
		}
	}
}
