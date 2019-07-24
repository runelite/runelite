/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
package net.runelite.client.plugins.motherlode;

import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.AnimationID;
import static net.runelite.api.AnimationID.IDLE;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_3A;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_ADAMANT;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_BLACK;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_BRONZE;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_DRAGON;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_DRAGON_ORN;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_INFERNAL;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_IRON;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_MITHRIL;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_RUNE;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_STEEL;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26665;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26666;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26667;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26668;
import static net.runelite.api.ObjectID.ORE_VEIN_26661;
import static net.runelite.api.ObjectID.ORE_VEIN_26662;
import static net.runelite.api.ObjectID.ORE_VEIN_26663;
import static net.runelite.api.ObjectID.ORE_VEIN_26664;
import static net.runelite.api.ObjectID.ROCKFALL;
import static net.runelite.api.ObjectID.ROCKFALL_26680;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.ScriptID;
import net.runelite.api.Varbits;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Motherlode Mine",
	description = "Show helpful information inside the Motherload Mine",
	tags = {"pay", "dirt", "mining", "mlm", "skilling", "overlay"},
	enabledByDefault = false
)
@Singleton
public class MotherlodePlugin extends Plugin
{
	private static final Set<Integer> MOTHERLODE_MAP_REGIONS = ImmutableSet.of(14679, 14680, 14681, 14935, 14936, 14937, 15191, 15192, 15193);
	private static final Set<Integer> MINE_SPOTS = ImmutableSet.of(ORE_VEIN_26661, ORE_VEIN_26662, ORE_VEIN_26663, ORE_VEIN_26664);
	private static final Set<Integer> DEPLETED_SPOTS = ImmutableSet.of(DEPLETED_VEIN_26665, DEPLETED_VEIN_26666, DEPLETED_VEIN_26667, DEPLETED_VEIN_26668);
	private static final Set<Integer> MLM_ORE_TYPES = ImmutableSet.of(ItemID.RUNITE_ORE, ItemID.ADAMANTITE_ORE,
		ItemID.MITHRIL_ORE, ItemID.GOLD_ORE, ItemID.COAL, ItemID.GOLDEN_NUGGET);
	private static final Set<Integer> ROCK_OBSTACLES = ImmutableSet.of(ROCKFALL, ROCKFALL_26680);

	private static final int MAX_INVENTORY_SIZE = 28;

	private static final int SACK_LARGE_SIZE = 162;
	private static final int SACK_SIZE = 81;

	private static final int UPPER_FLOOR_HEIGHT = -500;

	// The motherlode mining animation has gaps in it during which the animation switches to IDLE
	// so a minimum threshold is required before the idle animation will be registered as not mining
	private static final Duration ANIMATION_IDLE_DELAY = Duration.ofMillis(1800);

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MotherlodeOverlay overlay;

	@Inject
	private MotherlodeRocksOverlay rocksOverlay;

	@Inject
	private MotherlodeSackOverlay motherlodeSackOverlay;

	@Inject
	private MotherlodeGemOverlay motherlodeGemOverlay;

	@Inject
	private MotherlodeOreOverlay motherlodeOreOverlay;

	@Inject
	private MotherlodeConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private Notifier notifier;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private boolean inMlm;

	@Getter(AccessLevel.PACKAGE)
	private int curSackSize;
	@Getter(AccessLevel.PACKAGE)
	private int maxSackSize;
	@Getter(AccessLevel.PACKAGE)
	private Integer depositsLeft;

	@Inject
	private MotherlodeSession session;
	private boolean shouldUpdateOres;
	private Multiset<Integer> inventorySnapshot;

	@Getter(AccessLevel.PACKAGE)
	private final Set<WallObject> veins = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private final Set<GameObject> rocks = new HashSet<>();

	@Getter(AccessLevel.PACKAGE)
	private boolean isMining;
	@Getter(AccessLevel.PACKAGE)
	private WorldPoint targetVeinLocation = null;
	private boolean playerHasReachedTargetVein;
	private int lastAnimation = AnimationID.IDLE;
	private Instant lastAnimating;

	@Getter(AccessLevel.PACKAGE)
	private boolean showVeins;
	@Getter(AccessLevel.PACKAGE)
	private boolean showRockFalls;
	@Getter(AccessLevel.PACKAGE)
	private int statTimeout;
	@Getter(AccessLevel.PACKAGE)
	private boolean showSack;
	@Getter(AccessLevel.PACKAGE)
	private boolean showMiningStats;
	@Getter(AccessLevel.PACKAGE)
	private boolean showDepositsLeft;
	@Getter(AccessLevel.PACKAGE)
	private boolean showMiningState;
	@Getter(AccessLevel.PACKAGE)
	private boolean showGemsFound;
	@Getter(AccessLevel.PACKAGE)
	private boolean showOresFound;
	private boolean notifyOnIdle;
	@Getter(AccessLevel.PACKAGE)
	private boolean showTargetVein;
	private boolean payDirtMsg;

	@Provides
	MotherlodeConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MotherlodeConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
		overlayManager.add(rocksOverlay);
		overlayManager.add(motherlodeGemOverlay);
		overlayManager.add(motherlodeOreOverlay);
		overlayManager.add(motherlodeSackOverlay);

		inMlm = checkInMlm();

		if (inMlm)
		{
			clientThread.invokeLater(this::refreshSackValues);
		}
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		overlayManager.remove(rocksOverlay);
		overlayManager.remove(motherlodeGemOverlay);
		overlayManager.remove(motherlodeOreOverlay);
		overlayManager.remove(motherlodeSackOverlay);
		veins.clear();
		rocks.clear();

		Widget sack = client.getWidget(WidgetInfo.MOTHERLODE_MINE);

		clientThread.invokeLater(() ->
		{
			if (sack != null && sack.isHidden())
			{
				sack.setHidden(false);
			}
		});
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		eventBus.subscribe(WallObjectSpawned.class, this, this::onWallObjectSpawned);
		eventBus.subscribe(WallObjectChanged.class, this, this::onWallObjectChanged);
		eventBus.subscribe(WallObjectDespawned.class, this, this::onWallObjectDespawned);
		eventBus.subscribe(GameObjectSpawned.class, this, this::onGameObjectSpawned);
		eventBus.subscribe(GameObjectChanged.class, this, this::onGameObjectChanged);
		eventBus.subscribe(GameObjectDespawned.class, this, this::onGameObjectDespawned);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(OverheadTextChanged.class, this, this::onOverheadTextChanged);
	}

	void onVarbitChanged(VarbitChanged event)
	{
		if (inMlm)
		{
			int lastSackValue = curSackSize;
			refreshSackValues();
			shouldUpdateOres = curSackSize < lastSackValue;
			if (shouldUpdateOres)
			{
				// Take a snapshot of the inventory before the new ore is added.
				ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);
				if (itemContainer != null)
				{
					inventorySnapshot = HashMultiset.create();
					Arrays.stream(itemContainer.getItems())
						.filter(item -> MLM_ORE_TYPES.contains(item.getId()))
						.forEach(item -> inventorySnapshot.add(item.getId(), item.getQuantity()));
				}
			}
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (!inMlm || event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		String chatMessage = event.getMessage();

		switch (chatMessage)
		{
			case "You manage to mine some pay-dirt.":
				session.incrementPayDirtMined();
				break;

			case "You just found a Diamond!":
				session.incrementGemFound(ItemID.UNCUT_DIAMOND);
				break;

			case "You just found a Ruby!":
				session.incrementGemFound(ItemID.UNCUT_RUBY);
				break;

			case "You just found an Emerald!":
				session.incrementGemFound(ItemID.UNCUT_EMERALD);
				break;

			case "You just found a Sapphire!":
				session.incrementGemFound(ItemID.UNCUT_SAPPHIRE);
				break;
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	void checkMining()
	{
		if (!inMlm)
		{
			return;
		}


		depositsLeft = calculateDepositsLeft();

		Instant lastPayDirtMined = session.getLastPayDirtMined();
		if (lastPayDirtMined == null)
		{
			return;
		}

		// reset recentPayDirtMined if you haven't mined anything recently
		Duration statTimeout = Duration.ofMinutes(this.statTimeout);
		Duration sinceMined = Duration.between(lastPayDirtMined, Instant.now());

		if (sinceMined.compareTo(statTimeout) >= 0)
		{
			session.resetRecent();
		}
	}

	private void onMenuOptionClicked(MenuOptionClicked menu)
	{
		if (!inMlm)
		{
			return;
		}

		if (MINE_SPOTS.contains(menu.getIdentifier()) &&  menu.getMenuAction() == MenuAction.GAME_OBJECT_FIRST_OPTION)
		{
			resetIdleChecks();
			int veinX = menu.getActionParam0();
			int veinY = menu.getActionParam1();
			targetVeinLocation = WorldPoint.fromScene(client, veinX, veinY, client.getPlane());
		}
	}

	private void onGameTick(GameTick event)
	{
		if (!inMlm)
		{
			return;
		}

		checkDistanceToTargetVein();
		checkAnimationIdle();
	}

	private void checkDistanceToTargetVein()
	{
		if (targetVeinLocation == null)
		{
			return;
		}

		float distanceFromTargetVein = client.getLocalPlayer().getWorldLocation().distanceToHypotenuse(targetVeinLocation);
		// Player must reach the target vein first before we begin checking for the player moving away from it
		if (!playerHasReachedTargetVein && distanceFromTargetVein == 1)
		{
			isMining = true;
			playerHasReachedTargetVein = true;
		}
		else if (playerHasReachedTargetVein && distanceFromTargetVein > 1)
		{
			isMining = false;
			resetIdleChecks();
		}
	}

	private void onAnimationChanged (AnimationChanged event)
	{
		if (!inMlm)
		{
			return;
		}

		Player localPlayer = client.getLocalPlayer();
		if (localPlayer != event.getActor())
		{
			return;
		}

		int animation = localPlayer.getAnimation();

		switch (animation)
		{
			case MINING_MOTHERLODE_BRONZE:
			case MINING_MOTHERLODE_IRON:
			case MINING_MOTHERLODE_STEEL:
			case MINING_MOTHERLODE_BLACK:
			case MINING_MOTHERLODE_MITHRIL:
			case MINING_MOTHERLODE_ADAMANT:
			case MINING_MOTHERLODE_RUNE:
			case MINING_MOTHERLODE_DRAGON:
			case MINING_MOTHERLODE_DRAGON_ORN:
			case MINING_MOTHERLODE_INFERNAL:
			case MINING_MOTHERLODE_3A:
				lastAnimation = animation;
				lastAnimating = Instant.now();
				break;
			case IDLE:
				lastAnimating = Instant.now();
				break;
			default:
				// On unknown animation simply assume the animation is invalid
				lastAnimation = IDLE;
				lastAnimating = null;
		}
	}

	private void checkAnimationIdle()
	{
		if (lastAnimation == IDLE)
		{
			return;
		}

		final int animation = client.getLocalPlayer().getAnimation();

		if (animation == IDLE)
		{
			if (lastAnimating != null && Instant.now().compareTo(lastAnimating.plus(ANIMATION_IDLE_DELAY)) >= 0)
			{
				lastAnimation = IDLE;
				lastAnimating = null;
				isMining = false;
				resetIdleChecks();
				sendIdleNotification();
			}
		}
		else
		{
			lastAnimating = Instant.now();
		}
	}

	private void onWidgetLoaded(WidgetLoaded event)
	{
		if (!inMlm || targetVeinLocation == null)
		{
			return;
		}

		int widgetID = event.getGroupId();

		if (widgetID == WidgetID.MOTHERLODE_MINE_FULL_INVENTORY_GROUP_ID || widgetID == WidgetID.LEVEL_UP_GROUP_ID)
		{
			isMining = false;
			resetIdleChecks();
			sendIdleNotification();
		}
	}

	private void resetIdleChecks()
	{
		isMining = false;
		lastAnimation = IDLE;
		lastAnimating = null;
		playerHasReachedTargetVein = false;
		targetVeinLocation = null;
	}

	private void sendIdleNotification()
	{
		if (!this.notifyOnIdle)
		{
			return;
		}

		notifier.notify(client.getLocalPlayer().getName() + " has stopped mining!");
	}

	private void onWallObjectSpawned(WallObjectSpawned event)
	{
		if (!inMlm)
		{
			return;
		}

		WallObject wallObject = event.getWallObject();
		int wallObjectId = wallObject.getId();
		if (MINE_SPOTS.contains(wallObjectId))
		{
			veins.add(wallObject);
		}
		else if (DEPLETED_SPOTS.contains(wallObjectId) && wallObject.getWorldLocation().equals(targetVeinLocation))
		{
			isMining = false;
			resetIdleChecks();
			sendIdleNotification();
		}
	}

	private void onWallObjectChanged(WallObjectChanged event)
	{
		if (!inMlm)
		{
			return;
		}

		WallObject previous = event.getPrevious();
		WallObject wallObject = event.getWallObject();

		veins.remove(previous);
		if (MINE_SPOTS.contains(wallObject.getId()))
		{
			veins.add(wallObject);
		}
	}

	private void onWallObjectDespawned(WallObjectDespawned event)
	{
		if (!inMlm)
		{
			return;
		}

		WallObject wallObject = event.getWallObject();
		veins.remove(wallObject);
	}

	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (!inMlm)
		{
			return;
		}

		GameObject gameObject = event.getGameObject();
		if (ROCK_OBSTACLES.contains(gameObject.getId()))
		{
			rocks.add(gameObject);
		}
	}

	private void onGameObjectChanged(GameObjectChanged event)
	{
		if (!inMlm)
		{
			return;
		}

		GameObject previous = event.getPrevious();
		GameObject gameObject = event.getGameObject();

		rocks.remove(previous);
		if (ROCK_OBSTACLES.contains(gameObject.getId()))
		{
			rocks.add(gameObject);
		}

	}

	private void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (!inMlm)
		{
			return;
		}

		GameObject gameObject = event.getGameObject();
		rocks.remove(gameObject);
	}

	void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			// on region changes the tiles get set to null
			veins.clear();
			rocks.clear();

			inMlm = checkInMlm();
		}
		else if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			// Prevent code from running while logged out.
			inMlm = false;
		}
	}

	void onItemContainerChanged(ItemContainerChanged event)
	{
		final ItemContainer container = event.getItemContainer();

		if (!inMlm || !shouldUpdateOres || inventorySnapshot == null || container != client.getItemContainer(InventoryID.INVENTORY))
		{
			return;
		}

		// Build set of current inventory
		Multiset<Integer> current = HashMultiset.create();
		Arrays.stream(container.getItems())
			.filter(item -> MLM_ORE_TYPES.contains(item.getId()))
			.forEach(item -> current.add(item.getId(), item.getQuantity()));

		// Take the difference
		Multiset<Integer> delta = Multisets.difference(current, inventorySnapshot);

		// Update the session
		delta.forEachEntry(session::updateOreFound);
		inventorySnapshot = null;
		shouldUpdateOres = false;
	}

	private Integer calculateDepositsLeft()
	{
		if (maxSackSize == 0) // check if maxSackSize has been initialized
		{
			refreshSackValues();
		}

		double depositsLeft = 0;
		int nonPayDirtItems = 0;

		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		if (inventory == null)
		{
			return null;
		}

		Item[] result = inventory.getItems();
		assert result != null;

		for (Item item : result)
		{
			// Assume that MLM ores are being banked and exclude them from the check,
			// so the user doesn't see the Overlay switch between deposits left and N/A.
			//
			// Count other items at nonPayDirtItems so depositsLeft is calculated accordingly.
			if (item.getId() != ItemID.PAYDIRT && item.getId() != -1 && !MLM_ORE_TYPES.contains(item.getId()))
			{
				nonPayDirtItems += 1;
			}
		}

		double inventorySpace = MAX_INVENTORY_SIZE - nonPayDirtItems;
		double sackSizeRemaining = maxSackSize - curSackSize;

		if (inventorySpace > 0 && sackSizeRemaining > 0)
		{
			depositsLeft = Math.ceil(sackSizeRemaining / inventorySpace);
		}
		else if (inventorySpace == 0)
		{
			return null;
		}

		return (int) depositsLeft;
	}

	private boolean checkInMlm()
	{
		GameState gameState = client.getGameState();
		if (gameState != GameState.LOGGED_IN
			&& gameState != GameState.LOADING)
		{
			return false;
		}

		int[] currentMapRegions = client.getMapRegions();

		// Verify that all regions exist in MOTHERLODE_MAP_REGIONS
		for (int region : currentMapRegions)
		{
			if (!MOTHERLODE_MAP_REGIONS.contains(region))
			{
				return false;
			}
		}

		return true;
	}

	private void refreshSackValues()
	{
		curSackSize = client.getVar(Varbits.SACK_NUMBER);
		boolean sackUpgraded = client.getVar(Varbits.SACK_UPGRADED) == 1;
		maxSackSize = sackUpgraded ? SACK_LARGE_SIZE : SACK_SIZE;
	}

	/**
	 * Checks if the given point is "upstairs" in the mlm.
	 * The upper floor is actually on z=0.
	 */
	boolean isUpstairs(LocalPoint localPoint)
	{
		return Perspective.getTileHeight(client, localPoint, 0) < UPPER_FLOOR_HEIGHT;
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("motherlode"))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.showVeins = config.showVeins();
		this.showRockFalls = config.showRockFalls();
		this.statTimeout = config.statTimeout();
		this.showSack = config.showSack();
		this.showMiningStats = config.showMiningStats();
		this.showDepositsLeft = config.showDepositsLeft();
		this.showMiningState = config.showMiningState();
		this.showGemsFound = config.showGemsFound();
		this.showOresFound = config.showOresFound();
		this.notifyOnIdle = config.notifyOnIdle();
		this.showTargetVein = config.showTargetVein();
		this.payDirtMsg = config.payDirtMsg();
	}

	private void onOverheadTextChanged(OverheadTextChanged event)
	{
		if (!payDirtMsg || Strings.isNullOrEmpty(event.getOverheadText()) || !(event.getActor() instanceof NPC))
		{
			return;
		}

		switch (((NPC) event.getActor()).getId())
		{
			case NpcID.MINER_5606:
			case NpcID.MINER_5813:
			case NpcID.MINER_5814:
			case NpcID.MINER_6565:
			case NpcID.MINER_6567:
			case NpcID.MINER_6568:
			case NpcID.MINER_6569:
			case NpcID.MINER_6570:
			case NpcID.MINER_6571:
			case NpcID.MINER_6572:
			case NpcID.MINER_6645:
				break;
			default:
				return;
		}

		if ("pay-dirt!".equals(Text.standardize(event.getOverheadText())))
		{
			client.runScript(ScriptID.PUBLICMSG, "Pay-dirt!");
		}
	}
}