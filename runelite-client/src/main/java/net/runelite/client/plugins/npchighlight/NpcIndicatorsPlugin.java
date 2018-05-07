/*
 * Copyright (c) 2018, James Swindle <wilingua@gmail.com>
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
package net.runelite.client.plugins.npchighlight;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.GraphicsObject;
import net.runelite.api.GraphicsObjectID;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.WildcardMatcher;

@PluginDescriptor(name = "NPC Indicators")
public class NpcIndicatorsPlugin extends Plugin
{
	private static final int MAX_ACTOR_VIEW_RANGE = 15;

	// Option added to NPC menu
	private static final String TAG = "Tag";

	// Regex for splitting the hidden items in the config.
	private static final String DELIMITER_REGEX = "\\s*,\\s*";

	@Inject
	private Client client;

	@Inject
	private MenuManager menuManager;

	@Inject
	private NpcIndicatorsConfig config;

	@Inject
	private NpcSceneOverlay npcSceneOverlay;

	@Inject
	private NpcMinimapOverlay npcMinimapOverlay;

	@Inject
	private NpcIndicatorsInput inputListener;

	@Inject
	private KeyManager keyManager;

	@Getter(AccessLevel.PACKAGE)
	private Set<Integer> npcTags;

	@Getter(AccessLevel.PACKAGE)
	private Set<NPC> taggedNpcs;

	@Getter(AccessLevel.PACKAGE)
	private Set<NPC> highlightedNpcs;

	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, MemorizedNpc> highlightedMemorizedNpcs;

	@Getter(AccessLevel.PACKAGE)
	private Instant lastTickUpdate;

	@Getter(AccessLevel.PACKAGE)
	private int tickCounter;

	private Map<Integer, MemorizedNpc> memorizedNpcs;

	private List<NPC> spawnedNpcsThisTick;

	private List<NPC> despawnedNpcsThisTick;

	private Set<WorldPoint> teleportGraphicsObjectSpawnedThisTick;

	private List<String> npcStringsToMatch;

	private WorldPoint lastPlayerLocation;

	private boolean skipNextSpawnCheck = false;

	private boolean hotKeyPressed = false;

	private void memorizeNpc(NPC npc)
	{
		int npcIndex = npc.getIndex();
		if (memorizedNpcs.get(npcIndex) == null)
		{
			memorizedNpcs.put(npcIndex, new MemorizedNpc(npc));
		}
	}

	private void toggleTag(int npcId)
	{
		boolean removed = npcTags.remove(npcId);
		NPC npc = client.getCachedNPCs()[npcId];
		if (removed)
		{
			if (npc != null)
			{
				taggedNpcs.remove(npc);
				memorizedNpcs.get(npc.getIndex()).setTagged(false);
			}
		}
		else
		{
			if (npc != null)
			{
				memorizeNpc(npc);
				taggedNpcs.add(npc);
				memorizedNpcs.get(npc.getIndex()).setTagged(true);
			}
			npcTags.add(npcId);
		}
	}

	@Provides
	NpcIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(NpcIndicatorsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		this.npcTags = new HashSet<>();
		this.taggedNpcs = new HashSet<>();
		this.highlightedNpcs = new HashSet<>();
		this.memorizedNpcs = new HashMap<>();
		this.npcStringsToMatch = new ArrayList<>();
		this.highlightedMemorizedNpcs = new HashMap<>();
		this.spawnedNpcsThisTick = new ArrayList<>();
		this.despawnedNpcsThisTick = new ArrayList<>();
		this.teleportGraphicsObjectSpawnedThisTick = new HashSet<>();
		keyManager.registerKeyListener(inputListener);
		this.updateStringsToMatch();
	}

	@Override
	protected void shutDown() throws Exception
	{
		this.npcTags = null;
		this.taggedNpcs = null;
		this.highlightedNpcs = null;
		this.memorizedNpcs = null;
		this.npcStringsToMatch = null;
		this.highlightedMemorizedNpcs = null;
		this.spawnedNpcsThisTick = null;
		this.despawnedNpcsThisTick = null;
		this.teleportGraphicsObjectSpawnedThisTick = null;
		keyManager.unregisterKeyListener(inputListener);
	}

	private void updateStringsToMatch()
	{
		String configNpcs = config.getNpcToHighlight().toLowerCase();
		if (configNpcs.isEmpty())
		{
			npcStringsToMatch = Collections.EMPTY_LIST;
		}
		else
		{
			npcStringsToMatch = Arrays.asList(configNpcs.split(DELIMITER_REGEX));
		}
		resetHighlightedNpcs();
	}

	private void resetHighlightedNpcs()
	{
		if (config.isTagEnabled())
		{
			taggedNpcs = buildNpcsToTag();
			taggedNpcs.forEach(this::memorizeNpc);
		}
		else
		{
			taggedNpcs = Collections.EMPTY_SET;
		}
		highlightedNpcs = buildNpcsToHighlight();
		highlightedNpcs.forEach(this::memorizeNpc);
	}

	private boolean wasNpcInViewRangeForSure(WorldPoint wp1, WorldPoint wp2)
	{
		int distance = wp1.distanceTo(wp2);
		return distance < MAX_ACTOR_VIEW_RANGE;
	}

	private void addHighlightedMemorizedNpc(MemorizedNpc mn, NPC npc)
	{
		if (mn != null)
		{
			mn.setDiedOnTick(tickCounter + 1); // This rune before tickCounter updates, so we add 1
			if (!mn.getPossibleRespawnLocations().isEmpty())
			{
				highlightedMemorizedNpcs.put(mn.getNpcIndex(), mn);
			}
		}
	}

	private WorldPoint getWorldLocationBehind(NPC npc)
	{
		int dx = 0, dy = 0;
		int orientation = npc.getOrientation() / 256;
		switch (orientation)
		{
			case 0: // South
				dy = -1;
				break;
			case 1: // Southwest
				dx = -1;
				dy = -1;
				break;
			case 2: // West
				dx = -1;
				break;
			case 3: // Northwest
				dx = -1;
				dy = 1;
				break;
			case 4: // North
				dy = 1;
				break;
			case 5: // Northeast
				dx = 1;
				dy = 1;
				break;
			case 6: // East
				dx = 1;
				break;
			case 7: // Southeast
				dx = 1;
				dy = -1;
				break;
		}

		WorldPoint currWP = npc.getWorldLocation();
		return new WorldPoint(currWP.getX() - dx, currWP.getY() - dy, currWP.getPlane());
	}

	private void validateSpawnedNpcs()
	{
		if (skipNextSpawnCheck)
		{
			skipNextSpawnCheck = false;
		}
		else
		{
			for (NPC npc : despawnedNpcsThisTick)
			{
				if (teleportGraphicsObjectSpawnedThisTick.size() > 0)
				{
					if (teleportGraphicsObjectSpawnedThisTick.contains(npc.getWorldLocation()))
					{
						// NPC teleported away, so we don't want to add the respawn timer
						continue;
					}
				}

				if (wasNpcInViewRangeForSure(client.getLocalPlayer().getWorldLocation(), npc.getWorldLocation()))
				{
					addHighlightedMemorizedNpc(memorizedNpcs.get(npc.getIndex()), npc);
				}
			}
			for (NPC npc : spawnedNpcsThisTick)
			{
				if (teleportGraphicsObjectSpawnedThisTick.size() > 0)
				{
					if (teleportGraphicsObjectSpawnedThisTick.contains(npc.getWorldLocation()) ||
						teleportGraphicsObjectSpawnedThisTick.contains(getWorldLocationBehind(npc)))
					{
						// NPC teleported here, so we don't want to update the respawn timer
						continue;
					}
				}

				if (wasNpcInViewRangeForSure(lastPlayerLocation, npc.getWorldLocation()))
				{
					MemorizedNpc mn = memorizedNpcs.get(npc.getIndex());
					if (mn.getDiedOnTick() != -1)
					{
						mn.setRespawnTime(tickCounter + 1 - mn.getDiedOnTick());
						mn.setDiedOnTick(-1);
					}

					WorldPoint npcLocation = npc.getWorldLocation();

					// An NPC can move in the same tick as it spawns, so we also have
					// to consider whatever tile is behind the npc
					WorldPoint possibleOtherNpcLocation = getWorldLocationBehind(npc);

					mn.getPossibleRespawnLocations().removeIf(x ->
						x.distanceTo(npcLocation) != 0 && x.distanceTo(possibleOtherNpcLocation) != 0);

					if (mn.getPossibleRespawnLocations().isEmpty())
					{
						mn.getPossibleRespawnLocations().add(npcLocation);
						mn.getPossibleRespawnLocations().add(possibleOtherNpcLocation);
					}
				}
			}
		}

		spawnedNpcsThisTick.clear();;
		despawnedNpcsThisTick.clear();
		teleportGraphicsObjectSpawnedThisTick.clear();
	}

	private void removeOldHighlightedRespawns()
	{
		Iterator<Map.Entry<Integer, MemorizedNpc>> it = highlightedMemorizedNpcs.entrySet().iterator();
		while (it.hasNext())
		{
			MemorizedNpc mn = it.next().getValue();
			if (mn.getDiedOnTick() + mn.getRespawnTime() <= tickCounter + 1)
			{
				it.remove();
			}
		}
	}

	private boolean shouldHighlightNpc(String name)
	{
		if (name == null)
		{
			return false;
		}

		for (String highlight : npcStringsToMatch)
		{
			if (WildcardMatcher.matches(highlight, name))
			{
				return true;
			}
		}
		return false;
	}

	private Set<NPC> buildNpcsToHighlight()
	{
		Set<NPC> npcSet = new HashSet<>();

		for (NPC npc : client.getNpcs())
		{
			String npcName = npc.getName();

			if (npcName == null)
			{
				continue;
			}

			if (shouldHighlightNpc(npcName))
			{
				npcSet.add(npc);
			}
		}

		return npcSet;
	}

	private Set<NPC> buildNpcsToTag()
	{
		Set<NPC> npcSet = new HashSet<>();

		for (NPC npc : client.getNpcs())
		{
			if (npcTags.contains(npc.getIndex()))
			{
				npcSet.add(npc);
			}
		}

		return npcSet;
	}

	void updateNpcMenuOptions(boolean pressed)
	{
		if (!config.isTagEnabled())
		{
			return;
		}

		if (pressed)
		{
			menuManager.addNpcMenuOption(TAG);
		}
		else
		{
			menuManager.removeNpcMenuOption(TAG);
		}

		hotKeyPressed = pressed;
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		// If you somehow manage to right click while holding shift, then click off screen
		if (!focusChanged.isFocused() && hotKeyPressed)
		{
			updateNpcMenuOptions(false);
		}
	}

	@Subscribe
	public void onMenuObjectClicked(MenuOptionClicked click)
	{
		if (click.getMenuOption().equals(TAG))
		{
			toggleTag(click.getId());
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		updateStringsToMatch();
	}

	@Subscribe
	public void onGraphicsObjectCreated(GraphicsObjectCreated event)
	{
		GraphicsObject go = event.getGraphicsObject();
		if (go.getId() == GraphicsObjectID.GREY_BUBBLE_TELEPORT)
		{
			WorldPoint wp = WorldPoint.fromLocal(client, go.getLocation());
			teleportGraphicsObjectSpawnedThisTick.add(wp);
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		NPC npc = event.getNpc();

		if (taggedNpcs.remove(npc))
		{
			int npcIndex = npc.getIndex();
			if (npcTags.contains(npcIndex))
			{
				MemorizedNpc mn = memorizedNpcs.get(npcIndex);
				if (mn != null)
				{
					despawnedNpcsThisTick.add(npc);
				}
			}
		}
		if (highlightedNpcs.remove(npc))
		{
			MemorizedNpc mn = memorizedNpcs.get(npc.getIndex());
			if (mn != null && shouldHighlightNpc(mn.getNpcName()))
			{
				despawnedNpcsThisTick.add(npc);
			}
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();

		if (config.isTagEnabled())
		{
			int npcIndex = npc.getIndex();
			highlightedMemorizedNpcs.remove(npcIndex);

			if (npcTags.contains(npc.getIndex()))
			{
				memorizeNpc(npc);
				taggedNpcs.add(npc);
				if (lastPlayerLocation != null)
				{
					spawnedNpcsThisTick.add(npc);
				}
			}
		}

		String npcName = npc.getName();
		if (shouldHighlightNpc(npcName))
		{
			highlightedNpcs.add(npc);
			memorizeNpc(npc);
			if (lastPlayerLocation != null)
			{
				spawnedNpcsThisTick.add(npc);
			}
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN ||
			event.getGameState() == GameState.CONNECTION_LOST ||
			event.getGameState() == GameState.HOPPING)
		{
			resetHighlightedNpcs();
			highlightedMemorizedNpcs.clear();
			memorizedNpcs.values().forEach(x -> x.setDiedOnTick(-1));
			lastPlayerLocation = null;
			skipNextSpawnCheck = true;
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		removeOldHighlightedRespawns();
		validateSpawnedNpcs();
		this.lastTickUpdate = Instant.now();
		this.lastPlayerLocation = client.getLocalPlayer().getWorldLocation();
		tickCounter++;
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(npcSceneOverlay, npcMinimapOverlay);
	}
}
