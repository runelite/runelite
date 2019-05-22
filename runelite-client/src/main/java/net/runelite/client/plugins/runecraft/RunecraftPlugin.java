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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import static net.runelite.client.util.MenuUtil.swap;
import net.runelite.client.util.Text;


@PluginDescriptor(
	name = "Runecraft",
	description = "Show minimap icons and clickboxes for abyssal rifts",
	tags = {"abyssal", "minimap", "overlay", "rifts", "rc", "runecrafting"}
)
public class RunecraftPlugin extends Plugin
{
	private static final int FIRE_ALTAR = 10315;
	private static final String POUCH_DECAYED_NOTIFICATION_MESSAGE = "Your rune pouch has decayed.";
	private static final String POUCH_DECAYED_MESSAGE = "Your pouch has decayed through use.";
	private static final List<Integer> DEGRADED_POUCHES = ImmutableList.of(
		ItemID.MEDIUM_POUCH_5511,
		ItemID.LARGE_POUCH_5513,
		ItemID.GIANT_POUCH_5515
	);

	private boolean wearingTiara;
	private boolean wearingCape;

	@Getter(AccessLevel.PACKAGE)
	private final Set<DecorativeObject> abyssObjects = new HashSet<>();

	@Getter(AccessLevel.PACKAGE)
	private boolean degradedPouchInInventory;

	@Getter(AccessLevel.PACKAGE)
	private NPC darkMage;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private AbyssOverlay abyssOverlay;

	@Inject
	private RunecraftOverlay runecraftOverlay;

	@Inject
	private RunecraftConfig config;

	@Inject
	private Notifier notifier;

	@Inject
	private MenuManager menuManager;

	@Provides
	RunecraftConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RunecraftConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(abyssOverlay);
		abyssOverlay.updateConfig();
		overlayManager.add(runecraftOverlay);
		addSwaps();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(abyssOverlay);
		abyssObjects.clear();
		darkMage = null;
		degradedPouchInInventory = false;
		overlayManager.remove(runecraftOverlay);
		removeSwaps();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("runecraft"))
		{
			return;
		}

		if (event.getKey().equals("essPouch"))
		{
			addSwaps();
		}

		abyssOverlay.updateConfig();
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (config.degradingNotification())
		{
			if (event.getMessage().contains(POUCH_DECAYED_MESSAGE))
			{
				notifier.notify(POUCH_DECAYED_NOTIFICATION_MESSAGE);
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded entry)
	{
		if (wearingCape || wearingTiara)
		{
			final String option = Text.removeTags(entry.getOption()).toLowerCase();
			final String target = Text.removeTags(entry.getTarget()).toLowerCase();

			if (target.contains("ring of dueling") && option.contains("remove")) // Incompatible with easyscape
			{
				if (client.getLocalPlayer().getWorldLocation().getRegionID() != FIRE_ALTAR)
				{ //changes duel ring teleport options based on location
					swap(client, "duel arena", option, target);
				}
				else if (client.getLocalPlayer().getWorldLocation().getRegionID() == FIRE_ALTAR)
				{
					swap(client, "castle wars", option, target);
				}
			}
			else if (target.contains("altar") && option.contains("craft")) // Don't accidentally click the altar to craft
			{
				hide(option, target);
			}
			else if (target.contains("pure") && option.contains("use")) // Don't accidentally use pure essence on altar
			{
				hide("use", target);
				hide("drop", target);
			}
		}
	}
	
	private void hide(String option, String target)
	{
		final MenuEntry[] entries = client.getMenuEntries();
		int index = searchIndex(entries, option, target);
		if (index < 0)
		{
			return;
		}

		MenuEntry[] newEntries = new MenuEntry[entries.length - 1];
		int i2 = 0;

		for (int i = 0; i < entries.length - 1; i++)
		{
			if (i == index)
			{
				continue;
			}

			newEntries[i2] = entries[i];
			i2++;
		}

		client.setMenuEntries(newEntries);
	}

	private int searchIndex(MenuEntry[] entries, String option, String target)
	{
		for (int i = entries.length - 1; i >= 0; i--)
		{
			MenuEntry entry = entries[i];
			String entryOption = Text.removeTags(entry.getOption()).toLowerCase();
			String entryTarget = Text.removeTags(entry.getTarget()).toLowerCase();

			if (entryOption.contains(option.toLowerCase())
				&& (entryTarget.contains(target)))
			{
				return i;
			}
		}

		return -1;
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
		switch (gameState)
		{
			case LOADING:
				abyssObjects.clear();
				break;
			case CONNECTION_LOST:
			case HOPPING:
			case LOGIN_SCREEN:
				darkMage = null;
				break;
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{

			final Item[] items = event.getItemContainer().getItems();
			degradedPouchInInventory = Stream.of(items).anyMatch(i -> DEGRADED_POUCHES.contains(i.getId()));
		}
		else if (event.getItemContainer() == client.getItemContainer(InventoryID.EQUIPMENT))
		{
			final Item[] items = event.getItemContainer().getItems();
			wearingTiara = config.Lavas() && items[EquipmentInventorySlot.HEAD.getSlotIdx()].getId() == ItemID.FIRE_TIARA;
			wearingCape = config.Lavas() && items[EquipmentInventorySlot.CAPE.getSlotIdx()].getId() == ItemID.RUNECRAFT_CAPE || config.Lavas() && items[EquipmentInventorySlot.CAPE.getSlotIdx()].getId() == ItemID.RUNECRAFT_CAPET || config.Lavas() && items[EquipmentInventorySlot.CAPE.getSlotIdx()].getId() == ItemID.MAX_CAPE_13342;
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		final NPC npc = event.getNpc();
		if (npc.getId() == NpcID.DARK_MAGE)
		{
			darkMage = npc;
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		final NPC npc = event.getNpc();
		if (npc == darkMage)
		{
			darkMage = null;
		}
	}

	private void addSwaps()
	{
		if (config.essPouch())
		{
			menuManager.addSwap("deposit", "pouch", 2, 57, "fill", "pouch", 9, 1007);
			menuManager.addSwap("fill", "pouch", "empty", "pouch", true, false);
		}
		else
		{
			menuManager.removeSwap("deposit", "pouch", 2, 57, "fill", "pouch", 9, 1007);
			menuManager.removeSwap("fill", "pouch", "empty", "pouch", true, false);
		}
	}

	private void removeSwaps()
	{
		menuManager.removeSwap("deposit", "pouch", 2, 57, "fill", "pouch", 9, 1007);
		menuManager.removeSwap("fill", "pouch", "empty", "pouch", true, false);
	}
}
