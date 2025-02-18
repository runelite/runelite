/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.woodcutting;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_3A;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_ADAMANT;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_BLACK;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_BRONZE;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_CRYSTAL;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_CRYSTAL_INACTIVE;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_DRAGON;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_IRON;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_MITHRIL;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_RUNE;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_STEEL;
import static net.runelite.api.AnimationID.WOODCUTTING_3A_AXE;
import static net.runelite.api.AnimationID.WOODCUTTING_ADAMANT;
import static net.runelite.api.AnimationID.WOODCUTTING_BLACK;
import static net.runelite.api.AnimationID.WOODCUTTING_BRONZE;
import static net.runelite.api.AnimationID.WOODCUTTING_CRYSTAL;
import static net.runelite.api.AnimationID.WOODCUTTING_DRAGON;
import static net.runelite.api.AnimationID.WOODCUTTING_DRAGON_OR;
import static net.runelite.api.AnimationID.WOODCUTTING_GILDED;
import static net.runelite.api.AnimationID.WOODCUTTING_INFERNAL;
import static net.runelite.api.AnimationID.WOODCUTTING_IRON;
import static net.runelite.api.AnimationID.WOODCUTTING_MITHRIL;
import static net.runelite.api.AnimationID.WOODCUTTING_RUNE;
import static net.runelite.api.AnimationID.WOODCUTTING_STEEL;
import static net.runelite.api.AnimationID.WOODCUTTING_TRAILBLAZER;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameObject;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.NullObjectID;
import net.runelite.api.ObjectID;
import net.runelite.api.ScriptID;
import net.runelite.api.Tile;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.woodcutting.config.ClueNestTier;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Woodcutting",
	description = "Show woodcutting statistics and/or bird nest notifications",
	tags = {"birds", "nest", "notifications", "overlay", "skilling", "wc", "forestry"},
	enabledByDefault = false
)
@Slf4j
public class WoodcuttingPlugin extends Plugin
{
	static final Set<Integer> WOODCUTTING_ANIMS = ImmutableSet.of(
		WOODCUTTING_BRONZE, WOODCUTTING_IRON, WOODCUTTING_STEEL, WOODCUTTING_BLACK, WOODCUTTING_MITHRIL,
		WOODCUTTING_ADAMANT, WOODCUTTING_RUNE, WOODCUTTING_GILDED, WOODCUTTING_DRAGON, WOODCUTTING_DRAGON_OR,
		WOODCUTTING_INFERNAL, WOODCUTTING_3A_AXE, WOODCUTTING_CRYSTAL, WOODCUTTING_TRAILBLAZER,
		WOODCUTTING_2H_BRONZE, WOODCUTTING_2H_IRON, WOODCUTTING_2H_STEEL, WOODCUTTING_2H_BLACK,
		WOODCUTTING_2H_MITHRIL, WOODCUTTING_2H_ADAMANT, WOODCUTTING_2H_RUNE, WOODCUTTING_2H_DRAGON,
		WOODCUTTING_2H_CRYSTAL, WOODCUTTING_2H_CRYSTAL_INACTIVE, WOODCUTTING_2H_3A
	);

	private static final Pattern WOOD_CUT_PATTERN = Pattern.compile("You get (?:some|an)[\\w ]+(?:logs?|mushrooms)\\.");
	private static final Pattern ANIMA_BARK_PATTERN = Pattern.compile("You've been awarded <col=[0-9a-f]+>(\\d+) Anima-infused bark</col>\\.");

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private WoodcuttingOverlay overlay;

	@Inject
	private WoodcuttingSceneOverlay treesOverlay;

	@Inject
	private WoodcuttingConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Getter
	@Nullable
	private WoodcuttingSession session;

	@Getter
	private final Set<GameObject> redwoods = new HashSet<>();

	// Forestry
	@Getter(AccessLevel.PACKAGE)
	private final List<GameObject> roots = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private final List<NPC> flowers = new ArrayList<>();
	private NPC lastInteractFlower;
	@Getter(AccessLevel.PACKAGE)
	private final List<NPC> activeFlowers = new ArrayList<>(2);
	@Getter(AccessLevel.PACKAGE)
	private final List<GameObject> saplingIngredients = new ArrayList<>(5);
	@Getter(AccessLevel.PACKAGE)
	private final GameObject[] saplingOrder = new GameObject[3];
	@Getter(AccessLevel.PACKAGE)
	private NPC foxTrap;
	@Getter(AccessLevel.PACKAGE)
	private final List<GameObject> pheasantNests = new ArrayList<>(4);
	@Getter(AccessLevel.PACKAGE)
	private final List<GameObject> endOfRainbows = new ArrayList<>(1);
	@Getter(AccessLevel.PACKAGE)
	private NPC freakyForester;
	@Getter(AccessLevel.PACKAGE)
	private NPC unfinishedBeeHive;
	private final List<NPC> circles = new ArrayList<>(5);
	private final List<NPC> entlings = new ArrayList<>(0);

	@Getter(AccessLevel.PACKAGE)
	private final List<TreeRespawn> respawns = new ArrayList<>();
	private ClueNestTier clueTierSpawned;

	private Counter leprechaunsLuckInfoBox;

	void resetSession()
	{
		session = null;

		infoBoxManager.removeInfoBox(leprechaunsLuckInfoBox);
		leprechaunsLuckInfoBox = null;
	}

	@Provides
	WoodcuttingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WoodcuttingConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(treesOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(treesOverlay);
		respawns.clear();
		redwoods.clear();
		roots.clear();
		flowers.clear();
		saplingIngredients.clear();
		Arrays.fill(saplingOrder, null);
		session = null;
		clueTierSpawned = null;
		infoBoxManager.removeInfoBox(leprechaunsLuckInfoBox);
		leprechaunsLuckInfoBox = null;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("woodcutting"))
		{
			clientThread.invokeLater(this::updateLeprechaunsLuck);
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		clueTierSpawned = null;

		respawns.removeIf(TreeRespawn::isExpired);

		if (session == null || session.getLastChopping() == null)
		{
			return;
		}

		if (WOODCUTTING_ANIMS.contains(client.getLocalPlayer().getAnimation()))
		{
			session.setLastChopping();
			return;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCut = Duration.between(session.getLastChopping(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			session.setActive(false);

			infoBoxManager.removeInfoBox(leprechaunsLuckInfoBox);
			leprechaunsLuckInfoBox = null;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM
			&& event.getType() != ChatMessageType.GAMEMESSAGE
			&& event.getType() != ChatMessageType.MESBOX)
		{
			return;
		}

		final var msg = event.getMessage();

		if (WOOD_CUT_PATTERN.matcher(msg).matches())
		{
			if (session == null)
			{
				session = new WoodcuttingSession();
			}

			session.setLastChopping();
			session.incrementLogsCut();
		}

		var matcher = ANIMA_BARK_PATTERN.matcher(msg);
		if (matcher.matches())
		{
			if (session == null)
			{
				session = new WoodcuttingSession();
			}

			session.setLastChopping();

			int num = Integer.parseInt(matcher.group(1));
			session.incrementBark(num);
		}

		if (msg.contains("A bird's nest falls out of the tree"))
		{
			if (clueTierSpawned == null || clueTierSpawned.ordinal() >= config.clueNestNotifyTier().ordinal())
			{
				notifier.notify(config.showNestNotification(), "A bird nest has spawned!");
			}
			// Clear the clue tier that has previously spawned
			clueTierSpawned = null;
		}

		if (msg.startsWith("The sapling seems to love"))
		{
			int ingredientNum = msg.contains("first") ? 1 : (msg.contains("second") ? 2 : (msg.contains("third") ? 3 : -1));
			if (ingredientNum == -1)
			{
				log.debug("unable to find ingredient index from message: {}", msg);
				return;
			}

			GameObject ingredientObj = saplingIngredients.stream()
				.filter(obj -> msg.contains(client.getObjectDefinition(obj.getId()).getName().toLowerCase()))
				.findAny()
				.orElse(null);
			if (ingredientObj == null)
			{
				log.debug("unable to find ingredient from message: {}", msg);
				return;
			}

			saplingOrder[ingredientNum - 1] = ingredientObj;
		}

		if (msg.equals("There are no open, unpollinated flowers on this bush yet.")
			|| msg.equals("The flowers on this bush have not yet opened enough to harvest pollen.")
			|| msg.equals("<col=06600c>The bush is already fruiting and won't benefit from <col=06600c>any more pollen.</col>"))
		{
			if (activeFlowers.contains(lastInteractFlower))
			{
				log.debug("Flowers reset");
				activeFlowers.clear();
			}
		}
	}

	@Subscribe
	public void onItemSpawned(ItemSpawned itemSpawned)
	{
		if (clueTierSpawned == null)
		{
			// This will be set only if one of the clue nests has spawned. It will then be reset the next game tick.
			clueTierSpawned = ClueNestTier.getTierFromItem(itemSpawned.getItem().getId());
		}
	}

	@Subscribe
	public void onGameObjectSpawned(final GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();

		switch (gameObject.getId())
		{
			/* redwood trees */
			case ObjectID.REDWOOD_TREE:
			case ObjectID.REDWOOD_TREE_29670:
			case NullObjectID.NULL_34633:
			case NullObjectID.NULL_34635:
			case NullObjectID.NULL_34637:
			case NullObjectID.NULL_34639:
			case ObjectID.REDWOOD_TREE_34284:
			case ObjectID.REDWOOD_TREE_34286:
			case ObjectID.REDWOOD_TREE_34288:
			case ObjectID.REDWOOD_TREE_34290:
				redwoods.add(gameObject);
				break;

			case ObjectID.TREE_ROOTS:
			case ObjectID.ANIMAINFUSED_TREE_ROOTS:
				if (roots.isEmpty())
				{
					notifier.notify(config.forestryRisingRootsNotification(), "A Rising Roots Forestry event spawned!");
				}

				roots.add(gameObject);
				break;
			case ObjectID.STRUGGLING_SAPLING:
			case ObjectID.STRUGGLING_SAPLING_47485:
			case ObjectID.STRUGGLING_SAPLING_47487:
			case ObjectID.STRUGGLING_SAPLING_47488:
			case ObjectID.STRUGGLING_SAPLING_47490:
			case ObjectID.STRUGGLING_SAPLING_47491:
				notifier.notify(config.forestryStrugglingSaplingNotification(), "A Struggling Sapling Forestry event spawned!");
				break;
			case ObjectID.ROTTING_LEAVES:
			case ObjectID.GREEN_LEAVES:
			case ObjectID.DROPPINGS:
			case ObjectID.WILD_MUSHROOMS:
			case ObjectID.WILD_MUSHROOMS_47497:
			case ObjectID.WILD_MUSHROOMS_47498:
			case ObjectID.SPLINTERED_BARK:
				saplingIngredients.add(gameObject);
				break;
			case ObjectID.PHEASANT_NEST:
			case ObjectID.PHEASANT_NEST_49937:
				pheasantNests.add(gameObject);
				break;
			case ObjectID.END_OF_RAINBOW:
				endOfRainbows.add(gameObject);
				break;
		}
	}

	@Subscribe
	public void onGameObjectDespawned(final GameObjectDespawned event)
	{
		final GameObject object = event.getGameObject();

		switch (object.getId())
		{
			/* redwood trees */
			case ObjectID.REDWOOD_TREE:
			case ObjectID.REDWOOD_TREE_29670:
			case NullObjectID.NULL_34633:
			case NullObjectID.NULL_34635:
			case NullObjectID.NULL_34637:
			case NullObjectID.NULL_34639:
			case ObjectID.REDWOOD_TREE_34284:
			case ObjectID.REDWOOD_TREE_34286:
			case ObjectID.REDWOOD_TREE_34288:
			case ObjectID.REDWOOD_TREE_34290:
				redwoods.remove(object);
				break;

			case ObjectID.TREE_ROOTS:
			case ObjectID.ANIMAINFUSED_TREE_ROOTS:
				roots.remove(object);
				break;
			case ObjectID.ROTTING_LEAVES:
			case ObjectID.GREEN_LEAVES:
			case ObjectID.DROPPINGS:
			case ObjectID.WILD_MUSHROOMS:
			case ObjectID.WILD_MUSHROOMS_47497:
			case ObjectID.WILD_MUSHROOMS_47498:
			case ObjectID.SPLINTERED_BARK:
				saplingIngredients.remove(object);
				if (saplingIngredients.isEmpty())
				{
					Arrays.fill(saplingOrder, null);
					log.debug("Struggling Sapling event is over");
				}
				break;
			case ObjectID.PHEASANT_NEST:
			case ObjectID.PHEASANT_NEST_49937:
				pheasantNests.remove(object);
				if (pheasantNests.isEmpty())
				{
					log.debug("Pheasant event is over");
				}
				break;
			case ObjectID.END_OF_RAINBOW:
				endOfRainbows.remove(object);
				break;
		}
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired scriptPreFired)
	{
		if (scriptPreFired.getScriptId() == ScriptID.ADD_OVERLAYTIMER_LOC)
		{
			var args = scriptPreFired.getScriptEvent().getArguments();
			int locCoord = (int) args[1];
			int locId = (int) args[2];
			int ticks = (int) args[5];

			log.debug("Add overlay loc={} coord={} ticks={}", locId, locCoord, ticks);

			switch (locId)
			{
				case ObjectID.TREE_STUMP:
				case ObjectID.TREE_STUMP_1342: // regular
				case ObjectID.TREE_STUMP_1343:
				case ObjectID.TREE_STUMP_1344:
				case ObjectID.TREE_STUMP_1345:
				case ObjectID.TREE_STUMP_1346:
				case ObjectID.TREE_STUMP_1347:
				case ObjectID.TREE_STUMP_1348:
				case ObjectID.TREE_STUMP_1349:
				case ObjectID.TREE_STUMP_1350:
				case ObjectID.TREE_STUMP_1351:
				case ObjectID.TREE_STUMP_1352:
				case ObjectID.TREE_STUMP_1353:
				case ObjectID.TREE_STUMP_1354:
				case ObjectID.TREE_STUMP_1355:
				case ObjectID.TREE_STUMP_1356: // oak
				case ObjectID.TREE_STUMP_1357:
				case ObjectID.TREE_STUMP_1358:
				case ObjectID.TREE_STUMP_1359:
				case ObjectID.TREE_STUMP_2310:
				case ObjectID.TREE_STUMP_2891:
				case ObjectID.ACHEY_TREE_STUMP:
				case ObjectID.DYING_TREE_STUMP:
				case ObjectID.TREE_STUMP_3880:
				case ObjectID.TREE_STUMP_3884:
				case ObjectID.TREE_STUMP_4061:
				case ObjectID.TREE_STUMP_4328:
				case ObjectID.TREE_STUMP_4329:
				case ObjectID.JUNGLE_TREE_STUMP:
				case ObjectID.JUNGLE_TREE_STUMP_4821:
				case ObjectID.TREE_STUMP_4822:
				case ObjectID.TREE_STUMP_5905:
				case ObjectID.TREE_STUMP_6212:
				case ObjectID.APPLE_TREE_STUMP:
				case ObjectID.BANANA_TREE_STUMP:
				case ObjectID.CURRY_TREE_STUMP:
				case ObjectID.ORANGE_TREE_STUMP:
				case ObjectID.PALM_TREE_STUMP:
				case ObjectID.PAPAYA_TREE_STUMP:
				case ObjectID.SPIRIT_TREE_STUMP:
				case ObjectID.MAGIC_TREE_STUMP:
				case ObjectID.TREE_STUMP_8445:
				case ObjectID.OAK_TREE_STUMP:
				case ObjectID.WILLOW_TREE_STUMP:
				case ObjectID.YEW_TREE_STUMP:
				case ObjectID.TREE_STUMP_9035:
				case ObjectID.TREE_STUMP_9037:
				case ObjectID.TREE_STUMP_9471: // willow
				case ObjectID.TREE_STUMP_9661:
				case ObjectID.TREE_STUMP_9711:
				case ObjectID.TREE_STUMP_9712:
				case ObjectID.TREE_STUMP_9713:
				case ObjectID.TREE_STUMP_9714: // yew
				case ObjectID.TREE_STUMP_10057:
				case ObjectID.TREE_STUMP_12894:
				case ObjectID.TREE_STUMP_14516:
				case ObjectID.TREE_STUMP_14517:
				case ObjectID.TREE_STUMP_14567:
				case ObjectID.TREE_STUMP_14596:
				case ObjectID.TREE_STUMP_14638:
				case ObjectID.TREE_STUMP_14667:
				case ObjectID.TREE_STUMP_14697:
				case ObjectID.TREE_STUMP_16266:
				case ObjectID.DREAM_TREE_STUMP:
				case ObjectID.TREE_STUMP_21274:
				case ObjectID.TREE_STUMP_23054:
				case ObjectID.TREE_STUMP_25186:
				case ObjectID.TREE_STUMP_26834:
				case ObjectID.TREE_STUMP_27061:
				case ObjectID.MAHOGANY_TREE_STUMP:
				case ObjectID.TREE_STUMP_30446:
				case ObjectID.DEAD_TREE_STUMP:
				case ObjectID.DEAD_TREE_STUMP_30856:
				case ObjectID.TREE_STUMP_33583:
				case ObjectID.TREE_STUMP_33584:
				case ObjectID.CELASTRUS_TREE_STUMP:
				case ObjectID.DRAGONFRUIT_TREE_STUMP:
				case ObjectID.TREE_STUMP_36673:
				case ObjectID.TREE_STUMP_36675:
				case ObjectID.TREE_STUMP_36678:
				case ObjectID.TREE_STUMP_36680:
				case ObjectID.TREE_STUMP_36684:
				case ObjectID.TREE_STUMP_36687:
				case ObjectID.TREE_STUMP_36689:
				case ObjectID.TREE_STUMP_40751:
				case ObjectID.TREE_STUMP_40753:
				case ObjectID.TREE_STUMP_40757:
				case ObjectID.TREE_STUMP_40759:
				case ObjectID.TREE_STUMP_40761:
				case ObjectID.TREE_STUMP_42392:
				case ObjectID.TREE_STUMP_42394:
				case ObjectID.TREE_STUMP_42396:
				case ObjectID.TREE_STUMP_46582:
				case ObjectID.TREE_STUMP_46583:
				case ObjectID.TREE_STUMP_50035:

				// depleted redwood
				case ObjectID.REDWOOD_TREE_29669:
				case ObjectID.REDWOOD_TREE_29670:
				case ObjectID.REDWOOD_TREE_29671:

				// farming guild redwood
				case NullObjectID.NULL_34633:
				case NullObjectID.NULL_34635:
				case NullObjectID.NULL_34637:
				case NullObjectID.NULL_34639:
				{
					WorldPoint worldPoint = WorldPoint.fromCoord(locCoord);
					GameObject gameObject = findObject(worldPoint);
					if (gameObject == null)
					{
						return;
					}

					TreeRespawn treeRespawn = new TreeRespawn(worldPoint, gameObject.sizeX() - 1, gameObject.sizeY() - 1, Instant.now(), ticks * Constants.GAME_TICK_LENGTH);
					respawns.add(treeRespawn);
				}
			}
		}
	}

	private GameObject findObject(WorldPoint point)
	{
		LocalPoint localPoint = LocalPoint.fromWorld(client, point);
		if (localPoint == null)
		{
			return null;
		}

		Tile tile = client.getScene()
			.getTiles()[point.getPlane()][localPoint.getSceneX()][localPoint.getSceneY()];
		if (tile == null)
		{
			return null;
		}

		for (GameObject gameObject : tile.getGameObjects())
		{
			// the id passed to the script is the stump, not the tree, but it is prior to the tree
			// despawning, so we can't match by id. Probably this is good enough.
			if (gameObject != null)
			{
				return gameObject;
			}
		}

		return null;
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
			case HOPPING:
				respawns.clear();
				flowers.clear();
				activeFlowers.clear();
				foxTrap = null;
				freakyForester = null;
				unfinishedBeeHive = null;
				circles.clear();
				entlings.clear();
				// fallthrough
			case LOADING:
				redwoods.clear();
				roots.clear();
				saplingIngredients.clear();
				Arrays.fill(saplingOrder, null);
				pheasantNests.clear();
				endOfRainbows.clear();
				break;
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (event.getVarbitId() == Varbits.LEPRECHAUNS_LUCK)
		{
			updateLeprechaunsLuck();
		}
	}

	private void updateLeprechaunsLuck()
	{
		// Leprechaun's Luck is drained in intervals of 5
		final int leprechaunsLuck = client.getVarbitValue(Varbits.LEPRECHAUNS_LUCK) / 5;

		// avoid adding the infobox if not actively woodcutting
		if (leprechaunsLuck < 1 || session == null || !session.isActive() || !config.showLeprechaunLuck())
		{
			if (leprechaunsLuckInfoBox != null)
			{
				infoBoxManager.removeInfoBox(leprechaunsLuckInfoBox);
				leprechaunsLuckInfoBox = null;
			}
			return;
		}

		if (leprechaunsLuckInfoBox == null)
		{
			leprechaunsLuckInfoBox = new Counter(itemManager.getImage(ItemID.CLOVER_INSIGNIA), this, leprechaunsLuck);
			infoBoxManager.addInfoBox(leprechaunsLuckInfoBox);
		}

		leprechaunsLuckInfoBox.setCount(leprechaunsLuck);
		leprechaunsLuckInfoBox.setTooltip("Leprechaun's Luck: " + leprechaunsLuck);
	}

	@Subscribe
	public void onAnimationChanged(final AnimationChanged event)
	{
		var actor = event.getActor();
		if (actor.getAnimation() == AnimationID.LOOKING_INTO && flowers.contains(actor.getInteracting()))
		{
			var flower = (NPC) actor.getInteracting();
			if (!activeFlowers.contains(flower))
			{
				if (activeFlowers.size() == 2)
				{
					log.debug("Flowers reset");
					activeFlowers.clear();
				}

				log.debug("Tracked flower {}", flower);
				activeFlowers.add(flower);
			}
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();
		var id = npc.getId();
		if (isFloweringBush(id))
		{
			if (flowers.isEmpty())
			{
				notifier.notify(config.forestryFloweringTreeNotification(), "A Flowering Tree Forestry event spawned!");
			}

			flowers.add(npc);
		}
		else if (id == NpcID.WOODCUTTING_LEPRECHAUN)
		{
			notifier.notify(config.forestryLeprechaunNotification(), "A Leprechaun event spawned!");
		}
		else if ((id == NpcID.FRIGHTENED_FOX || id == NpcID.FRIGHTENED_FOX_12560))
		{
			notifier.notify(config.forestryPoachersNotification(), "A Poachers event spawned!");
		}
		else if (id == NpcID.FOX_TRAP)
		{
			foxTrap = npc;
		}
		else if (id == NpcID.FREAKY_FORESTER_12536)
		{
			freakyForester = npc;

			notifier.notify(config.forestryPheasantControlNotification(), "A Pheasant Control event has spawned!");
		}
		else if (id == NpcID.WILD_BEEHIVE)
		{
			notifier.notify(config.forestryBeeHiveNotification(), "A Bee Hive event has spawned!");
		}
		else if (id == NpcID.UNFINISHED_BEEHIVE || id == NpcID.UNFINISHED_BEEHIVE_12516)
		{
			unfinishedBeeHive = npc;
		}
		else if (id >= NpcID.RITUAL_CIRCLE_GREEN && id <= NpcID.RITUAL_CIRCLE_RED_12535)
		{
			circles.add(npc);
		}
		else if (id == NpcID.DRYAD_12519)
		{
			notifier.notify(config.forestryEnchantmentRitualNotification(), "An Enchantment Ritual event has spawned!");
		}
		else if (id == NpcID.ENTLING)
		{
			entlings.add(npc);
			if (entlings.size() == 1)
			{
				notifier.notify(config.forestryFriendlyEntNotification(), "A Friendly Ent event has spawned!");
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		NPC npc = event.getNpc();
		if (flowers.remove(npc))
		{
			if (activeFlowers.remove(npc))
			{
				activeFlowers.clear();
			}
			if (npc == lastInteractFlower)
			{
				lastInteractFlower = null;
			}
		}
		if (foxTrap == npc)
		{
			foxTrap = null;
		}
		if (freakyForester == npc)
		{
			freakyForester = null;
		}
		if (unfinishedBeeHive == npc)
		{
			unfinishedBeeHive = null;
		}
		circles.remove(npc);
		entlings.remove(npc);
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		if (event.getSource() != client.getLocalPlayer()
			|| !(event.getTarget() instanceof NPC)
			|| !isFloweringBush(((NPC) event.getTarget()).getId()))
		{
			return;
		}

		lastInteractFlower = (NPC) event.getTarget();
	}

	private static boolean isFloweringBush(int npcId)
	{
		return npcId == NpcID.FLOWERING_BUSH_LILAC ||
			npcId == NpcID.FLOWERING_BUSH_PINK ||
			npcId == NpcID.FLOWERING_BUSH_RED ||
			npcId == NpcID.FLOWERING_BUSH_ORANGE ||
			npcId == NpcID.FLOWERING_BUSH_YELLOW ||
			npcId == NpcID.FLOWERING_BUSH_WHITE ||
			npcId == NpcID.FLOWERING_BUSH_GREEN ||
			npcId == NpcID.FLOWERING_BUSH_BLUE;
	}

	NPC solveCircles()
	{
		if (circles.size() != 5)
		{
			return null;
		}

		int s = 0;
		for (var npc : circles)
		{
			int off = npc.getId() - NpcID.RITUAL_CIRCLE_GREEN;
			int shape = off / 4;
			int color = off % 4;
			int id = (16 << shape) | (1 << color);
			s ^= id;
		}
		for (var npc : circles)
		{
			int off = npc.getId() - NpcID.RITUAL_CIRCLE_GREEN;
			int shape = off / 4;
			int color = off % 4;
			int id = (16 << shape) | (1 << color);
			if ((id & s) == id)
			{
				return npc;
			}
		}
		return null;
	}
}
