/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.runecraft;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.npcoverlay.HighlightedNpc;
import net.runelite.client.game.npcoverlay.NpcOverlayService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Runecraft",
	description = "Show minimap icons and clickboxes for abyssal rifts",
	tags = {"abyssal", "minimap", "overlay", "rifts", "rc", "runecrafting", "essence", "pouch"}
)
public class RunecraftPlugin extends Plugin
{
	private static final String POUCH_DECAYED_NOTIFICATION_MESSAGE = "Your rune pouch has decayed.";
	private static final String POUCH_DECAYED_MESSAGE = "Your pouch has decayed through use.";
	private static final List<Integer> DEGRADED_POUCHES = ImmutableList.of(
		ItemID.MEDIUM_POUCH_5511,
		ItemID.LARGE_POUCH_5513,
		ItemID.GIANT_POUCH_5515,
		ItemID.COLOSSAL_POUCH_26786
	);
	static final int ABYSS_REGION = 12107;

	@Getter(AccessLevel.PACKAGE)
	private final Set<DecorativeObject> abyssObjects = new HashSet<>();

	private boolean degradedPouchInInventory;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private AbyssOverlay abyssOverlay;

	@Inject
	private AbyssMinimapOverlay abyssMinimapOverlay;

	@Inject
	private EssencePouchOverlay essencePouchOverlay;

	@Inject
	private RunecraftConfig config;

	@Inject
	private Notifier notifier;

	@Inject
	private NpcOverlayService npcOverlayService;

	private final Function<NPC, HighlightedNpc> highlightDarkMage = this::highlightDarkMage;

	@Provides
	RunecraftConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RunecraftConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		npcOverlayService.registerHighlighter(highlightDarkMage);
		overlayManager.add(abyssOverlay);
		overlayManager.add(abyssMinimapOverlay);
		overlayManager.add(essencePouchOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		npcOverlayService.unregisterHighlighter(highlightDarkMage);
		overlayManager.remove(abyssOverlay);
		overlayManager.remove(abyssMinimapOverlay);
		overlayManager.remove(essencePouchOverlay);
		abyssObjects.clear();
		degradedPouchInInventory = false;
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (event.getMessage().contains(POUCH_DECAYED_MESSAGE))
		{
			notifier.notify(config.degradingNotification(), POUCH_DECAYED_NOTIFICATION_MESSAGE);
		}
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		DecorativeObject decorativeObject = event.getDecorativeObject();
		if (AbyssRifts.getRift(decorativeObject.getId()) != null)
		{
			abyssObjects.add(decorativeObject);
		}
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		DecorativeObject decorativeObject = event.getDecorativeObject();
		abyssObjects.remove(decorativeObject);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		GameState gameState = event.getGameState();
		if (gameState == GameState.LOADING)
		{
			abyssObjects.clear();
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getContainerId() != InventoryID.INVENTORY.getId())
		{
			return;
		}

		final Item[] items = event.getItemContainer().getItems();
		degradedPouchInInventory = Stream.of(items).anyMatch(i -> DEGRADED_POUCHES.contains(i.getId()));
	}

	private HighlightedNpc highlightDarkMage(NPC npc)
	{
		if (npc.getId() == NpcID.DARK_MAGE)
		{
			return HighlightedNpc.builder()
				.npc(npc)
				.tile(true)
				.highlightColor(Color.GREEN)
				.render(n -> config.hightlightDarkMage() && degradedPouchInInventory)
				.build();
		}
		return null;
	}
}
