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

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.menus.BaseComparableEntry;
import static net.runelite.client.menus.ComparableEntries.newBaseComparableEntry;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.menuentryswapper.BankComparableEntry;
import net.runelite.client.plugins.menuentryswapper.EquipmentComparableEntry;
import net.runelite.client.ui.overlay.OverlayManager;


@PluginDescriptor(
	name = "Runecraft",
	description = "Show minimap icons and clickboxes for abyssal rifts",
	tags = {"abyssal", "minimap", "overlay", "rifts", "rc", "runecrafting"}
)
@Singleton
@Getter(AccessLevel.PACKAGE)
public class RunecraftPlugin extends Plugin
{
	private static final BankComparableEntry POUCH = new BankComparableEntry("fill", "pouch", false);
	private static final BaseComparableEntry EMPTY_SMALL = newBaseComparableEntry("empty", "small pouch");
	private static final BaseComparableEntry EMPTY_MEDIUM = newBaseComparableEntry("empty", "medium pouch");
	private static final BaseComparableEntry EMPTY_LARGE = newBaseComparableEntry("empty", "large pouch");
	private static final BaseComparableEntry EMPTY_GIANT = newBaseComparableEntry("empty", "giant pouch");
	private static final EquipmentComparableEntry CASTLE_WARS = new EquipmentComparableEntry("castle wars", "ring of dueling");
	private static final EquipmentComparableEntry DUEL_ARENA = new EquipmentComparableEntry("duel arena", "ring of dueling");
	private static final String POUCH_DECAYED_MESSAGE = "Your pouch has decayed through use.";
	private static final String POUCH_DECAYED_NOTIFICATION_MESSAGE = "Your rune pouch has decayed.";
	private static final int FIRE_ALTAR = 10315;
	private static final Set<Integer> DEGRADED_POUCHES = ImmutableSet.of(
		ItemID.MEDIUM_POUCH_5511,
		ItemID.LARGE_POUCH_5513,
		ItemID.GIANT_POUCH_5515
	);
	@Inject
	@Getter(AccessLevel.NONE)
	private Client client;
	@Inject
	@Getter(AccessLevel.NONE)
	private OverlayManager overlayManager;
	@Inject
	@Getter(AccessLevel.NONE)
	private AbyssOverlay abyssOverlay;
	@Inject
	@Getter(AccessLevel.NONE)
	private RunecraftOverlay runecraftOverlay;
	@Inject
	@Getter(AccessLevel.NONE)
	private RunecraftConfig config;
	@Inject
	@Getter(AccessLevel.NONE)
	private Notifier notifier;
	@Inject
	@Getter(AccessLevel.NONE)
	private MenuManager menuManager;
	@Inject
	@Getter(AccessLevel.NONE)
	private EventBus eventBus;

	private final Set<DecorativeObject> abyssObjects = new HashSet<>();
	private boolean degradedPouchInInventory;
	private boolean degradingNotification;
	private boolean essPouch;
	private boolean hightlightDarkMage;
	private boolean lavas;
	private boolean showAir;
	private boolean showBlood;
	private boolean showBody;
	private boolean showChaos;
	private boolean showClickBox;
	private boolean showCosmic;
	private boolean showDeath;
	private boolean showEarth;
	private boolean showFire;
	private boolean showLaw;
	private boolean showMind;
	private boolean showNature;
	private boolean showRifts;
	private boolean showSoul;
	private boolean showWater;
	private NPC darkMage;

	@Provides
	RunecraftConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RunecraftConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();
		abyssOverlay.updateConfig();
		overlayManager.add(abyssOverlay);
		overlayManager.add(runecraftOverlay);
		handleSwaps();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		abyssObjects.clear();
		darkMage = null;
		degradedPouchInInventory = false;
		overlayManager.remove(abyssOverlay);
		overlayManager.remove(runecraftOverlay);
		removeSwaps();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(DecorativeObjectSpawned.class, this, this::onDecorativeObjectSpawned);
		eventBus.subscribe(DecorativeObjectDespawned.class, this, this::onDecorativeObjectDespawned);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("runecraft"))
		{
			return;
		}

		updateConfig();
		abyssOverlay.updateConfig();

		if (event.getKey().equals("essPouch") || event.getKey().equals("Lavas"))
		{
			removeSwaps();
			handleSwaps();
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (this.degradingNotification && event.getMessage().contains(POUCH_DECAYED_MESSAGE))
		{
			notifier.notify(POUCH_DECAYED_NOTIFICATION_MESSAGE);
		}
	}

	private void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		final DecorativeObject decorativeObject = event.getDecorativeObject();
		if (AbyssRifts.getRift(decorativeObject.getId()) != null)
		{
			abyssObjects.add(decorativeObject);
		}
	}

	private void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		final DecorativeObject decorativeObject = event.getDecorativeObject();
		abyssObjects.remove(decorativeObject);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		final GameState gameState = event.getGameState();

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
			case LOGGED_IN:
				removeSwaps();
				handleSwaps();
				break;
		}
	}

	private void onItemContainerChanged(ItemContainerChanged event)
	{
		final ItemContainer container = event.getItemContainer();

		if (container == client.getItemContainer(InventoryID.INVENTORY))
		{
			final Item[] items = container.getItems();
			degradedPouchInInventory = Stream.of(items).anyMatch(i -> DEGRADED_POUCHES.contains(i.getId()));
		}
	}

	private void onNpcSpawned(NpcSpawned event)
	{
		final NPC npc = event.getNpc();

		if (npc.getId() == NpcID.DARK_MAGE)
		{
			darkMage = npc;
		}
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		final NPC npc = event.getNpc();

		if (npc != null && npc == darkMage)
		{
			darkMage = null;
		}
	}

	private void handleSwaps()
	{
		if (this.essPouch)
		{
			menuManager.addPriorityEntry(POUCH).setPriority(100);
			menuManager.addPriorityEntry(EMPTY_SMALL).setPriority(10);
			menuManager.addPriorityEntry(EMPTY_MEDIUM).setPriority(10);
			menuManager.addPriorityEntry(EMPTY_LARGE).setPriority(10);
			menuManager.addPriorityEntry(EMPTY_GIANT).setPriority(10);
		}
		else
		{
			menuManager.removePriorityEntry(POUCH);
			menuManager.removePriorityEntry(EMPTY_SMALL);
			menuManager.removePriorityEntry(EMPTY_MEDIUM);
			menuManager.removePriorityEntry(EMPTY_LARGE);
			menuManager.removePriorityEntry(EMPTY_GIANT);
		}

		if (client.getLocalPlayer() == null || !this.lavas)
		{
			menuManager.removeHiddenEntry("craft", "altar", false, false);
			menuManager.removeHiddenEntry("use", "pure essence", false, true);
			return;
		}

		if (client.getLocalPlayer().getWorldLocation().getRegionID() != FIRE_ALTAR)
		{
			menuManager.removeHiddenEntry("craft", "altar", false, false);
			menuManager.removeHiddenEntry("use", "Pure essence", false, true);
			menuManager.addPriorityEntry(DUEL_ARENA).setPriority(100);
			menuManager.removePriorityEntry(CASTLE_WARS);
		}
		else if (client.getLocalPlayer().getWorldLocation().getRegionID() == FIRE_ALTAR)
		{
			menuManager.addHiddenEntry("craft", "altar", false, false);
			menuManager.addHiddenEntry("use", "Pure essence", false, true);
			menuManager.addPriorityEntry(CASTLE_WARS).setPriority(100);
			menuManager.removePriorityEntry(DUEL_ARENA);
		}
	}

	private void removeSwaps()
	{
		menuManager.removeHiddenEntry("craft", "altar", false, false);
		menuManager.removeHiddenEntry("use", "Pure essence", false, true);
		menuManager.removePriorityEntry(POUCH);
		menuManager.removePriorityEntry(EMPTY_SMALL);
		menuManager.removePriorityEntry(EMPTY_MEDIUM);
		menuManager.removePriorityEntry(EMPTY_LARGE);
		menuManager.removePriorityEntry(EMPTY_GIANT);
		menuManager.removePriorityEntry(CASTLE_WARS);
		menuManager.removePriorityEntry(DUEL_ARENA);
	}

	private void updateConfig()
	{
		this.lavas = config.lavas();
		this.essPouch = config.essPouch();
		this.hightlightDarkMage = config.hightlightDarkMage();
		this.degradingNotification = config.degradingNotification();
		this.showRifts = config.showRifts();
		this.showAir = config.showAir();
		this.showBlood = config.showBlood();
		this.showBody = config.showBody();
		this.showChaos = config.showChaos();
		this.showCosmic = config.showCosmic();
		this.showDeath = config.showDeath();
		this.showEarth = config.showEarth();
		this.showFire = config.showFire();
		this.showLaw = config.showLaw();
		this.showMind = config.showMind();
		this.showNature = config.showNature();
		this.showSoul = config.showSoul();
		this.showWater = config.showWater();
		this.showClickBox = config.showClickBox();
	}
}
