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
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.ScriptID;
import net.runelite.api.Tile;
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
import net.runelite.api.gameval.AnimationID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.ObjectID;
import net.runelite.api.gameval.VarbitID;
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
		AnimationID.HUMAN_WOODCUTTING_BRONZE_AXE, AnimationID.HUMAN_WOODCUTTING_IRON_AXE, AnimationID.HUMAN_WOODCUTTING_STEEL_AXE, AnimationID.HUMAN_WOODCUTTING_BLACK_AXE, AnimationID.HUMAN_WOODCUTTING_MITHRIL_AXE,
		AnimationID.HUMAN_WOODCUTTING_ADAMANT_AXE, AnimationID.HUMAN_WOODCUTTING_RUNE_AXE, AnimationID.HUMAN_WOODCUTTING_GILDED_AXE, AnimationID.HUMAN_WOODCUTTING_DRAGON_AXE, AnimationID.HUMAN_WOODCUTTING_TRAILBLAZER_AXE_NO_INFERNAL,
		AnimationID.HUMAN_WOODCUTTING_INFERNAL_AXE, AnimationID.HUMAN_WOODCUTTING_3A_AXE, AnimationID.HUMAN_WOODCUTTING_CRYSTAL_AXE, AnimationID.HUMAN_OPENHEAVYCHEST,
		AnimationID.HUMAN_WOODCUTTING_TRAILBLAZER_RELOADED_AXE_NO_INFERNAL, AnimationID.HUMAN_WOODCUTTING_TRAILBLAZER_AXE, AnimationID.HUMAN_WOODCUTTING_TRAILBLAZER_RELOADED_AXE, AnimationID.FORESTRY_2H_AXE_CHOPPING_BRONZE,
		AnimationID.FORESTRY_2H_AXE_CHOPPING_IRON, AnimationID.FORESTRY_2H_AXE_CHOPPING_STEEL, AnimationID.FORESTRY_2H_AXE_CHOPPING_BLACK, AnimationID.FORESTRY_2H_AXE_CHOPPING_MITHRIL,
		AnimationID.FORESTRY_2H_AXE_CHOPPING_ADAMANT, AnimationID.FORESTRY_2H_AXE_CHOPPING_RUNE, AnimationID.FORESTRY_2H_AXE_CHOPPING_DRAGON, AnimationID.FORESTRY_2H_AXE_CHOPPING_CRYSTAL,
		AnimationID.FORESTRY_2H_AXE_CHOPPING_CRYSTAL_INACTIVE, AnimationID.FORESTRY_2H_AXE_CHOPPING_3A
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
			case ObjectID.REDWOODTREE_L:
			case ObjectID.REDWOODTREE_R:
			case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_2:
			case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_4:
			case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_6:
			case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_8:
			case ObjectID.REDWOOD_TREE_FULLYGROWN_1_2:
			case ObjectID.REDWOOD_TREE_FULLYGROWN_1_4:
			case ObjectID.REDWOOD_TREE_FULLYGROWN_1_6:
			case ObjectID.REDWOOD_TREE_FULLYGROWN_1_8:
				redwoods.add(gameObject);
				break;

			case ObjectID.GATHERING_EVENT_RISING_ROOTS:
			case ObjectID.GATHERING_EVENT_RISING_ROOTS_SPECIAL:
				if (roots.isEmpty())
				{
					notifier.notify(config.forestryRisingRootsNotification(), "A Rising Roots Forestry event spawned!");
				}

				roots.add(gameObject);
				break;
			case ObjectID.GATHERING_EVENT_SAPLING_1X1:
			case ObjectID.GATHERING_EVENT_SAPLING_WITHERING_1X1:
			case ObjectID.GATHERING_EVENT_SAPLING_2X2:
			case ObjectID.GATHERING_EVENT_SAPLING_WITHERING_2X2:
			case ObjectID.GATHERING_EVENT_SAPLING_3X3:
			case ObjectID.GATHERING_EVENT_SAPLING_WITHERING_3X3:
				notifier.notify(config.forestryStrugglingSaplingNotification(), "A Struggling Sapling Forestry event spawned!");
				break;
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_1:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_2:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_3:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_4A:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_4B:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_4C:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_5:
				saplingIngredients.add(gameObject);
				break;
			case ObjectID.GATHERING_EVENT_PHEASANT_NEST01:
			case ObjectID.GATHERING_EVENT_PHEASANT_NEST02:
				pheasantNests.add(gameObject);
				break;
			case ObjectID.GATHERING_EVENT_WOODCUTTING_LEPRECHAUN_RAINBOW:
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
			case ObjectID.REDWOODTREE_L:
			case ObjectID.REDWOODTREE_R:
			case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_2:
			case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_4:
			case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_6:
			case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_8:
			case ObjectID.REDWOOD_TREE_FULLYGROWN_1_2:
			case ObjectID.REDWOOD_TREE_FULLYGROWN_1_4:
			case ObjectID.REDWOOD_TREE_FULLYGROWN_1_6:
			case ObjectID.REDWOOD_TREE_FULLYGROWN_1_8:
				redwoods.remove(object);
				break;

			case ObjectID.GATHERING_EVENT_RISING_ROOTS:
			case ObjectID.GATHERING_EVENT_RISING_ROOTS_SPECIAL:
				roots.remove(object);
				break;
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_1:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_2:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_3:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_4A:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_4B:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_4C:
			case ObjectID.GATHERING_EVENT_SAPLING_INGREDIENT_5:
				saplingIngredients.remove(object);
				if (saplingIngredients.isEmpty())
				{
					Arrays.fill(saplingOrder, null);
					log.debug("Struggling Sapling event is over");
				}
				break;
			case ObjectID.GATHERING_EVENT_PHEASANT_NEST01:
			case ObjectID.GATHERING_EVENT_PHEASANT_NEST02:
				pheasantNests.remove(object);
				if (pheasantNests.isEmpty())
				{
					log.debug("Pheasant event is over");
				}
				break;
			case ObjectID.GATHERING_EVENT_WOODCUTTING_LEPRECHAUN_RAINBOW:
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
				case ObjectID.TREESTUMP:
				case ObjectID.TREESTUMP2: // regular
				case ObjectID.TREESTUMP2_LIGHT:
				case ObjectID.TREESTUMP2_GREEN:
				case ObjectID.TREESTUMP2_SMALL:
				case ObjectID.TREESTUMP2_BIG:
				case ObjectID.DEADTREE1_LARGE_STUMP:
				case ObjectID.DEADTREE1_STUMP:
				case ObjectID.DEADTREE1_LIGHT_STUMP:
				case ObjectID.DEADTREE1_SMALL_STUMP:
				case ObjectID.DEADTREE2_STUMP:
				case ObjectID.DEADTREE2_STUMP_SWAMP:
				case ObjectID.DEADTREE2_STUMP_DARK:
				case ObjectID.DEADTREE3_STUMP:
				case ObjectID.EVERGREEN_LARGE_STUMP:
				case ObjectID.OAKTREE_STUMP: // oak
				case ObjectID.YEWTREE_STUMP:
				case ObjectID.DEADTREE6_STUMP:
				case ObjectID.DEADTREE_BURNT_STUMP:
				case ObjectID.HOLLOW_TREE_STUMP:
				case ObjectID.JUNGLESTUMP_KHARAZI:
				case ObjectID.ACHEY_TREE_STUMP:
				case ObjectID.FAI_VARROCK_DEAD_TREE_STUMP:
				case ObjectID.REGICIDE_TREE_STUMP:
				case ObjectID.REGICIDE_TREE_STUMP_SMALL:
				case ObjectID.HOLLOW_TREE_STUMP_BIG:
				case ObjectID.VIKING_TREESTUMP:
				case ObjectID.VIKING_TREESTUMP2:
				case ObjectID.MM_BUSH_KHARAZI_JUNGLE_TREE1_STUMP:
				case ObjectID.MM_BUSH_KHARAZI_JUNGLE_TREE2_STUMP:
				case ObjectID.MM_BUSH_KHARAZI_JUNGLESTUMP:
				case ObjectID.MDAUGHTER_PASSABLE_TREE_STUMP:
				case ObjectID.DEADTREE4_STUMP:
				case ObjectID.APPLE_TREE_STUMP:
				case ObjectID.BANANA_TREE_STUMP:
				case ObjectID.CURRY_TREE_STUMP:
				case ObjectID.ORANGE_TREE_STUMP:
				case ObjectID.PALM_TREE_STUMP:
				case ObjectID.PAPAYA_TREE_STUMP:
				case ObjectID.SPIRIT_TREE_STUMP:
				case ObjectID.MAGIC_TREE_STUMP:
				case ObjectID.MAPLE_TREE_STUMP:
				case ObjectID.OAK_TREE_STUMP:
				case ObjectID.WILLOW_TREE_STUMP:
				case ObjectID.YEW_TREE_STUMP:
				case ObjectID.MAHOGANY_STUMP:
				case ObjectID.TEAK_STUMP:
				case ObjectID.WILLOW_TREE2OR3OR4_STUMP: // willow
				case ObjectID.TREESTUMP_MODELLED:
				case ObjectID.WILLOW_TREE_STUMP_NEW:
				case ObjectID.MAPLE_TREE_STUMP_NEW:
				case ObjectID.MAGIC_TREE_STUMP_NEW:
				case ObjectID.YEW_TREE_STUMP_NEW: // yew
				case ObjectID.MACRO_DIGGER_STUMP:
				case ObjectID.BURGH_TREE_STUMP:
				case ObjectID.WILD0_TREE_STUMP:
				case ObjectID.WILD1_TREE_STUMP:
				case ObjectID.WILD2_TREE_STUMP:
				case ObjectID.WILD3_TREE_STUMP:
				case ObjectID.WILD4_TREE_STUMP:
				case ObjectID.WILD5_TREE_STUMP:
				case ObjectID.WILD6_TREE_STUMP:
				case ObjectID.FAIRY2_PINE_TREE_STUMP:
				case ObjectID.LUNAR_DREAM_DREAM_TREE_STUMP:
				case ObjectID.ARCTIC_PINE_TREE_STUMP:
				case ObjectID.DEADTREE2_STUMP_SNOW:
				case ObjectID.DRAGON_SLAYER_QIP_WILD5_TREE_STUMP:
				case ObjectID.POH_MENAGERIE_HABITAT_FEATURE_1:
				case ObjectID.MAX_TREESTUMP:
				case ObjectID.MAHOGANY_TREE_STUMP:
				case ObjectID.TEAK_TREE_STUMP:
				case ObjectID.FOSSIL_DEADTREE_LARGE1_STUMP:
				case ObjectID.FOSSIL_DEADTREE_SMALL1_STUMP:
				case ObjectID.ARCQUEST_HUNTING_TREE_STUMP_OP:
				case ObjectID.ARCQUEST_HUNTING_TREE_STUMP_NOOP:
				case ObjectID.CELASTRUS_TREE_STUMP:
				case ObjectID.DRAGONFRUIT_TREE_STUMP:
				case ObjectID.PRIF_TREE_NORMAL_1_STUMP:
				case ObjectID.PRIF_TREE_NORMAL_2_STUMP:
				case ObjectID.PRIF_OUTSIDE_TREE_NORMAL_1_STUMP:
				case ObjectID.PRIF_OUTSIDE_TREE_NORMAL_2_STUMP:
				case ObjectID.PRIF_YEWTREE_STUMP:
				case ObjectID.PRIF_TEAK_STUMP:
				case ObjectID.PRIF_MAHOGANY_STUMP:
				case ObjectID.TREE_UPDATE_1_STUMP:
				case ObjectID.TREE_UPDATE_2_STUMP:
				case ObjectID.YEWTREE_UPDATE_STUMP:
				case ObjectID.TEAKTREE_UPDATE_STUMP:
				case ObjectID.MAHOGANYTREE_UPDATE_STUMP:
				case ObjectID.TREE_YEW_STUMP01:
				case ObjectID.TREE_NORMAL_STUMP01:
				case ObjectID.TREE_OAK_STUMP01:
				case ObjectID.SOTN_HUNTING_TREESTUMP_OP:
				case ObjectID.SOTN_HUNTING_TREESTUMP_NOOP:
				case ObjectID.XMAS18_STUMP_SNOW:

				// depleted redwood
				case ObjectID.REDWOODTREE_L_CUT:
				case ObjectID.REDWOODTREE_R:
				case ObjectID.REDWOODTREE_R_CUT:

				// farming guild redwood
				case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_2:
				case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_4:
				case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_6:
				case ObjectID.FARMING_REDWOOD_TREE_PATCH_1_8:

				// sailing trees
				case ObjectID.JATOBA_TREE_STUMP:
				case ObjectID.CAMPHOR_TREE_UPDATE_STUMP:
				case ObjectID.IRONWOOD_TREE_UPDATE_STUMP:
				case ObjectID.ROSEWOOD_TREE_UPDATE_STUMP:
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
		if (event.getVarbitId() == VarbitID.GATHERING_EVENT_WOODCUTTING_LEPRECHAUN_TOTAL_RAINBOWS)
		{
			updateLeprechaunsLuck();
		}
	}

	private void updateLeprechaunsLuck()
	{
		// Leprechaun's Luck is drained in intervals of 5
		final int leprechaunsLuck = client.getVarbitValue(VarbitID.GATHERING_EVENT_WOODCUTTING_LEPRECHAUN_TOTAL_RAINBOWS) / 5;

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
			leprechaunsLuckInfoBox = new Counter(itemManager.getImage(ItemID.GATHERING_EVENT_LEPRECHAUN_INSIGNIA), this, leprechaunsLuck);
			infoBoxManager.addInfoBox(leprechaunsLuckInfoBox);
		}

		leprechaunsLuckInfoBox.setCount(leprechaunsLuck);
		leprechaunsLuckInfoBox.setTooltip("Leprechaun's Luck: " + leprechaunsLuck);
	}

	@Subscribe
	public void onAnimationChanged(final AnimationChanged event)
	{
		var actor = event.getActor();
		if (actor.getAnimation() == AnimationID.HUMAN_PICKUPTABLE && flowers.contains(actor.getInteracting()))
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
		else if (id == NpcID.GATHERING_EVENT_WOODCUTTING_LEPRECHAUN)
		{
			notifier.notify(config.forestryLeprechaunNotification(), "A Leprechaun event spawned!");
		}
		else if ((id == NpcID.GATHERING_EVENT_POACHERS_FOX_OUTDOORS || id == NpcID.GATHERING_EVENT_POACHERS_FOX_INDOORS))
		{
			notifier.notify(config.forestryPoachersNotification(), "A Poachers event spawned!");
		}
		else if (id == NpcID.GATHERING_EVENT_POACHERS_TRAP)
		{
			foxTrap = npc;
		}
		else if (id == NpcID.GATHERING_EVENT_PHEASANT_FORESTER)
		{
			freakyForester = npc;

			notifier.notify(config.forestryPheasantControlNotification(), "A Pheasant Control event has spawned!");
		}
		else if (id == NpcID.GATHERING_EVENT_BEES_BEEBOX_4)
		{
			notifier.notify(config.forestryBeeHiveNotification(), "A Bee Hive event has spawned!");
		}
		else if (id == NpcID.GATHERING_EVENT_BEES_BEEBOX_1 || id == NpcID.GATHERING_EVENT_BEES_BEEBOX_2)
		{
			unfinishedBeeHive = npc;
		}
		else if (id >= NpcID.GATHERING_EVENT_ENCHANTED_RITUAL_A_1 && id <= NpcID.GATHERING_EVENT_ENCHANTED_RITUAL_D_4)
		{
			circles.add(npc);
		}
		else if (id == NpcID.GATHERING_EVENT_ENCHANTED_RITUAL_DRYAD)
		{
			notifier.notify(config.forestryEnchantmentRitualNotification(), "An Enchantment Ritual event has spawned!");
		}
		else if (id == NpcID.GATHERING_EVENT_ENTLINGS_NPC_01)
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
		return npcId == NpcID.GATHERING_EVENT_FLOWERING_TREE_BUSH_COL01 ||
			npcId == NpcID.GATHERING_EVENT_FLOWERING_TREE_BUSH_COL02 ||
			npcId == NpcID.GATHERING_EVENT_FLOWERING_TREE_BUSH_COL03 ||
			npcId == NpcID.GATHERING_EVENT_FLOWERING_TREE_BUSH_COL04 ||
			npcId == NpcID.GATHERING_EVENT_FLOWERING_TREE_BUSH_COL05 ||
			npcId == NpcID.GATHERING_EVENT_FLOWERING_TREE_BUSH_COL06 ||
			npcId == NpcID.GATHERING_EVENT_FLOWERING_TREE_BUSH_COL07 ||
			npcId == NpcID.GATHERING_EVENT_FLOWERING_TREE_BUSH_COL08;
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
			int off = npc.getId() - NpcID.GATHERING_EVENT_ENCHANTED_RITUAL_A_1;
			int shape = off / 4;
			int color = off % 4;
			int id = (16 << shape) | (1 << color);
			s ^= id;
		}
		for (var npc : circles)
		{
			int off = npc.getId() - NpcID.GATHERING_EVENT_ENCHANTED_RITUAL_A_1;
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
