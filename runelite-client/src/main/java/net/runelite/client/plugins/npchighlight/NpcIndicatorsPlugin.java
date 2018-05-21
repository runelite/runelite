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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
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
	private NpcClickboxOverlay npcClickboxOverlay;

	@Inject
	private NpcMinimapOverlay npcMinimapOverlay;

	@Inject
	private NpcIndicatorsInput inputListener;

	@Inject
	private KeyManager keyManager;

	/**
	 * NPCs tagged with the Tag option
	 */
	@Getter(AccessLevel.PACKAGE)
	private final Set<Integer> npcTags = new HashSet<>();

	/**
	 * NPCs tagged due to highlight in the config
	 */
	@Getter(AccessLevel.PACKAGE)
	private final Set<NPC> highlightedNpcs = new HashSet<>();

	/**
	 * Highlight strings from the configuration
	 */
	private List<String> highlights = new ArrayList<>();

	private boolean hotKeyPressed = false;

	private void toggleTag(int npcId)
	{
		boolean removed = npcTags.remove(npcId);
		if (!removed)
			npcTags.add(npcId);
	}

	@Provides
	NpcIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(NpcIndicatorsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(inputListener);
		highlights = getHighlights();
		rebuildNpcs();
	}

	@Override
	protected void shutDown() throws Exception
	{
		npcTags.clear();
		highlightedNpcs.clear();
		keyManager.unregisterKeyListener(inputListener);
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN || event.getGameState() == GameState.HOPPING)
		{
			highlightedNpcs.clear();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (!configChanged.getGroup().equals("npcindicators"))
		{
			return;
		}

		highlights = getHighlights();
		rebuildNpcs();
	}

	private List<String> getHighlights()
	{
		String configNpcs = config.getNpcToHighlight().toLowerCase();
		if (configNpcs.isEmpty())
			return Collections.emptyList();

		List<String> highlightedNpcs = Arrays.asList(configNpcs.split(DELIMITER_REGEX));
		return highlightedNpcs;
	}

	/**
	 * Rebuild highlighted npcs
	 */
	private void rebuildNpcs()
	{
		highlightedNpcs.clear();

		for (NPC npc : client.getNpcs())
		{
			String npcName = npc.getName();

			if (npcName == null)
			{
				continue;
			}

			for (String highlight : highlights)
			{
				if (WildcardMatcher.matches(highlight, npcName))
				{
					highlightedNpcs.add(npc);
					break;
				}
			}
		}
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
			toggleTag(click.getId());
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		String npcName = npc.getName();
		if (npcName != null)
		{
			for (String highlight : highlights)
			{
				if (WildcardMatcher.matches(highlight, npcName))
				{
					highlightedNpcs.add(npc);
					break;
				}
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();
		highlightedNpcs.remove(npc);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(npcClickboxOverlay, npcMinimapOverlay);
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
}
