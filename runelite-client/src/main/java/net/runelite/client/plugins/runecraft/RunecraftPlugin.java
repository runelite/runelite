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
import net.runelite.api.ItemContainer;
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
	private static final String POUCH_DECAYED_NOTIFICATION_MESSAGE = "Your rune pouch has decayed.";
	private static final String POUCH_DECAYED_MESSAGE = "Your pouch has decayed through use.";
	private static final List<Integer> DEGRADED_POUCHES = ImmutableList.of(
		ItemID.MEDIUM_POUCH_5511,
		ItemID.LARGE_POUCH_5513,
		ItemID.GIANT_POUCH_5515
	);
	private static final List<Integer> POUCHES = ImmutableList.of(
		ItemID.SMALL_POUCH,
		ItemID.MEDIUM_POUCH,
		ItemID.LARGE_POUCH,
		ItemID.GIANT_POUCH
	);
	private boolean wearingTiara;

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
	private RunecraftConfig config;

	@Inject
	private Notifier notifier;

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
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(abyssOverlay);
		abyssObjects.clear();
		darkMage = null;
		degradedPouchInInventory = false;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
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
		if (!wearingTiara)
		{
			return;
		}

		final String option = Text.removeTags(entry.getOption()).toLowerCase();
		final String target = Text.removeTags(entry.getTarget()).toLowerCase();
		final int id = entry.getIdentifier();
		final int type = entry.getType();

		if (target.contains("pouch") && !target.startsWith("rune"))
		{
			if (option.equals("deposit-all") && type == 57 && id == 2)
			{
				swap(client, "fill", option, target);
				swap(client, "cancel", option, "", target);
			}
			else  if (option.equals("fill") && id != 9)
			{
				swap(client, "empty", option, target);
			}
		}

		else if (target.contains("ring of dueling") && option.contains("remove"))
		{
			if (target.contains("7") || target.contains("5") || target.contains("3") || target.contains("1"))
			{
				swap(client, "castle wars", option, target);
			}
			else if (wearingBindingNeck())
			{
				swap(client, "duel arena", option, target);
			}
		}

		else if (target.contains("altar") && option.contains("craft")) // Don't accidentally click the altar to craft
		{
			hide(option, target, true);
		}
		else if (target.contains("pure") && option.contains("use")) // Don't accidentally use pure essence on altar
		{
			hide(option, target, true);
		}
	}

	private void hide(String option, String target, boolean contains)
	{
		final MenuEntry[] entries = client.getMenuEntries();
		int index = searchIndex(entries, option, target, contains);
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
		return searchIndex(entries, option, target, false);
	}
	private int searchIndex(MenuEntry[] entries, String option, String target, boolean contains)
	{
		for (int i = entries.length - 1; i >= 0; i--)
		{
			MenuEntry entry = entries[i];
			String entryOption = Text.removeTags(entry.getOption()).toLowerCase();
			String entryTarget = Text.removeTags(entry.getTarget()).toLowerCase();

			if (entryOption.contains(option.toLowerCase())
				&& (entryTarget.equals(target) || (entryTarget.contains(target) && contains)))
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
			wearingTiara = config.opLavas() && items[EquipmentInventorySlot.HEAD.getSlotIdx()].getId() == ItemID.FIRE_TIARA;
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
	private boolean wearingBindingNeck()
	{
		final ItemContainer worn = client.getItemContainer(InventoryID.EQUIPMENT);
		if (worn == null)
		{
			return false;
		}

		return worn.getItems()[EquipmentInventorySlot.AMULET.getSlotIdx()].getId() == ItemID.BINDING_NECKLACE;
	}
}
