/*
 * Copyright (c) 2019, Abiyaz C <chowdh2@cooper.edu>
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
package net.runelite.client.plugins.driftnet;

import com.google.inject.Provides;
import static java.lang.Math.abs;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import javax.inject.Inject;
import java.util.HashMap;

@PluginDescriptor(
	name = "DriftNet Helper",
	description = "Provides various overlays to assist with underwater driftnet fishing.",
	tags = {"overlay", "fishing"}
)
public class DriftNetPlugin extends Plugin
{
	private final int NORTH_NET_ID = 31433;
	private final int SOUTH_NET_ID = 31434;

	DriftNet northNet = new DriftNet();
	DriftNet southNet = new DriftNet();

	private NPC interacting = null;

	@Getter
	private HashMap<NPC, Long> fishes = new HashMap<>();

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private DriftNetConfig config;

	@Inject
	private DriftNetOverlay driftNetOverlay;

	@Inject
	private InfoBoxOverlay infoBoxOverlay;

	@Inject
	private Client client;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(driftNetOverlay);
		overlayManager.add(infoBoxOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(driftNetOverlay);
		overlayManager.remove(infoBoxOverlay);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN || event.getGameState() == GameState.HOPPING)
		{
			northNet = new DriftNet();
			southNet = new DriftNet();
			interacting = null;
			fishes.clear();
		}
	}

	@Provides
	DriftNetConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DriftNetConfig.class);
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();
		if (event.getGameObject().getId() == SOUTH_NET_ID)
		{
			southNet.setDriftNet(gameObject);
		}
		else if (event.getGameObject().getId() == NORTH_NET_ID)
		{
			northNet.setDriftNet(gameObject);
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		//setting the net state
		DriftNet[] nets = {northNet, southNet};
		Varbits[] net_varbits = {Varbits.NORTH_NET, Varbits.SOUTH_NET};
		Varbits[] fish_caught_varbits = {Varbits.NORTH_NET_FISH, Varbits.SOUTH_NET_FISH};
		for (int i = 0; i < nets.length; i++)
		{
			switch (client.getVar(net_varbits[i]))
			{
				case 0:
					nets[i].setNetStatus(DriftNet.DriftNetStatus.UNSET);
					break;
				case 1:
				case 2:
					nets[i].setNetStatus(DriftNet.DriftNetStatus.SET);
					break;
				case 3:
					nets[i].setNetStatus(DriftNet.DriftNetStatus.FULL);
					break;
			}
			if (nets[i].getNetStatus() != DriftNet.DriftNetStatus.UNSET)
			{
				nets[i].setNumFish(client.getVar(fish_caught_varbits[i]));
			}
		}
		System.out.println("North Net: " + client.getVar(Varbits.NORTH_NET));
		System.out.println("South Net: " + client.getVar(Varbits.SOUTH_NET));
		System.out.println("North Net Fish: " + client.getVar(Varbits.NORTH_NET_FISH));
		System.out.println("South Net Fish: " + client.getVar(Varbits.SOUTH_NET_FISH));
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (event.getGameObject().getId() == SOUTH_NET_ID)
		{
			southNet.setDriftNet(null);
		}
		else if (event.getGameObject().getId() == NORTH_NET_ID)
		{
			northNet.setDriftNet(null);
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();
		if (npc.getId() == NpcID.FISH_SHOAL)
		{
			fishes.put(npc, -1L);
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		NPC npc = event.getNpc();
		if (npc.getId() == NpcID.FISH_SHOAL)
		{
			fishes.remove(npc);
		}
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		if (event.getSource() == client.getLocalPlayer()
			&& event.getTarget() instanceof NPC
			&& ((NPC) event.getTarget()).getId() == NpcID.FISH_SHOAL)
		{
			interacting = (NPC) event.getTarget();
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		for (NPC fish : fishes.keySet())
		{
			if (fishes.get(fish) > 0
				&& System.currentTimeMillis() - fishes.get(fish) > 1000 * config.highlightDuration())
			{
				fishes.put(fish, -1L);
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
		if (event.getMessage().toLowerCase().contains("prod at"))
		{
			fishes.put(interacting, System.currentTimeMillis());
		}
	}

	private int supNorm(WorldPoint w1, WorldPoint w2)
	{
		int x = abs(w1.getX() - w2.getX());
		int y = abs(w1.getY() - w2.getY());
		return Math.max(x, y);
	}

	boolean isInDriftNetArea()
	{
		for (NPC fish : fishes.keySet())
		{
			if (fish != null
				&& client.getLocalPlayer().getWorldLocation().getPlane() == fish.getWorldLocation().getPlane()
				&& supNorm(client.getLocalPlayer().getWorldLocation(), fish.getWorldLocation()) < 25)
			{
				return true;
			}
		}
		return false;
	}
}