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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.TileObject;
import net.runelite.api.VarPlayer;
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
	
	public static final Map<Integer, VarPlayer> ID_TO_VAR = new HashMap<Integer, VarPlayer>()
	{{
		put(30565, VarPlayer.BIRDHOUSE_1);
		put(30566, VarPlayer.BIRDHOUSE_2);
		put(30567, VarPlayer.BIRDHOUSE_3);
		put(30568, VarPlayer.BIRDHOUSE_4);
	}};
	
	@Getter
	private List<TileObject> birdhouses;
	
	@Getter
	public boolean nearBirdhouses;
	
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
		nearBirdhouses = inBirdhouseArea();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}
	
	private boolean inBirdhouseArea()
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
				birdhouses = new ArrayList<>();
				break;
			case LOADING:
				nearBirdhouses = inBirdhouseArea();
				birdhouses.clear();
				break;
			default:
				break;
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		onGameObject(null, event.getGameObject());
	}

	@Subscribe
	public void onGameObjectChanged(GameObjectChanged event)
	{
		onGameObject(event.getPrevious(), event.getGameObject());
	}

	@Subscribe
	public void onGameObjectDeSpawned(GameObjectDespawned event)
	{
		onGameObject(event.getGameObject(), null);
	}

	private void onGameObject(TileObject oldObject, TileObject newObject)
	{
		birdhouses.remove(oldObject);
		if (newObject == null)
		{
			return;
		}
		
		if (ID_TO_VAR.keySet().contains(newObject.getId()))
		{
			birdhouses.add(newObject);
		}
	}
}
