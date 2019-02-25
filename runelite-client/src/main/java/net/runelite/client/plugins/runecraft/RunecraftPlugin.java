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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Runecraft",
	description = "Show minimap icons and clickboxes for abyssal rifts",
	tags = {"abyssal", "minimap", "overlay", "rifts", "rc", "runecrafting"}
)
public class RunecraftPlugin extends Plugin
{
	private static Pattern bindNeckString = Pattern.compile("You have ([0-9]+|one) charges? left before your Binding necklace disintegrates.");
	private static final String POUCH_DECAYED_NOTIFICATION_MESSAGE = "Your rune pouch has decayed.";
	private static final String POUCH_DECAYED_MESSAGE = "Your pouch has decayed through use.";
	private static final int DESTROY_ITEM_WIDGET_ID = WidgetInfo.DESTROY_ITEM_YES.getId();
	private static final List<Integer> DEGRADED_POUCHES = ImmutableList.of(
		ItemID.MEDIUM_POUCH_5511,
		ItemID.LARGE_POUCH_5513,
		ItemID.GIANT_POUCH_5515
	);

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
	private BindNeckOverlay bindNeckOverlay;

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
		overlayManager.add(bindNeckOverlay);
		overlayManager.add(abyssOverlay);
		abyssOverlay.updateConfig();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(bindNeckOverlay);
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
		if (event.getType() != ChatMessageType.SERVER)
		{
			return;
		}

		if (config.showBindNeck())
		{
			Matcher match = bindNeckString.matcher(event.getMessage());
			if (match.find())
			{
				if (match.group(1).equals("one"))
				{
					bindNeckOverlay.bindingCharges = 1;
				}
				else
				{
					bindNeckOverlay.bindingCharges = Integer.parseInt(match.group(1));
				}

				return;
			}

			if (event.getMessage().contains("You bind the temple's power"))
			{
				if (event.getMessage().contains("mud")
					|| event.getMessage().contains("lava")
					|| event.getMessage().contains("steam")
					|| event.getMessage().contains("dust")
					|| event.getMessage().contains("smoke")
					|| event.getMessage().contains("mist"))
				{
					bindNeckOverlay.bindingCharges -= 1;
					return;
				}
			}

			if (event.getMessage().contains("Your Binding necklace has disintegrated."))
			{
				//set it to 17 because this message is triggered first before the above chat event
				bindNeckOverlay.bindingCharges = 17;
				return;
			}
		}
		if (config.degradingNotification())
		{
			if (event.getMessage().contains(POUCH_DECAYED_MESSAGE))
			{
				notifier.notify(POUCH_DECAYED_NOTIFICATION_MESSAGE);
				return;
			}
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getWidgetId() != DESTROY_ITEM_WIDGET_ID)
		{
			return;
		}

		Widget widgetDestroyItemName = client.getWidget(WidgetInfo.DESTROY_ITEM_NAME);
		if (widgetDestroyItemName == null || !widgetDestroyItemName.getText().equals("Binding necklace"))
		{
			return;
		}

		bindNeckOverlay.bindingCharges = 16;
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
		if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
		{
			return;
		}

		final Item[] items = event.getItemContainer().getItems();
		degradedPouchInInventory = Stream.of(items).anyMatch(i -> DEGRADED_POUCHES.contains(i.getId()));
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
}
