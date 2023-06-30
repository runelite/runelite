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

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.Angle;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.woodcutting.config.ClueNestTier;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Woodcutting",
	description = "Show woodcutting statistics and/or bird nest notifications",
	tags = {"birds", "nest", "notifications", "overlay", "skilling", "wc", "forestry"},
	enabledByDefault = false
)
@PluginDependency(XpTrackerPlugin.class)
@Slf4j
public class WoodcuttingPlugin extends Plugin
{
	private static final Pattern WOOD_CUT_PATTERN = Pattern.compile("You get (?:some|an)[\\w ]+(?:logs?|mushrooms)\\.");

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private WoodcuttingOverlay overlay;

	@Inject
	private WoodcuttingTreesOverlay treesOverlay;

	@Inject
	private WoodcuttingConfig config;

	@Getter
	@Nullable
	@Setter(AccessLevel.PACKAGE)
	private WoodcuttingSession session;

	@Getter
	@Nullable
	private Axe axe;

	@Getter
	private final Set<GameObject> treeObjects = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private final Map<GameObject, Integer> treeMap = new HashMap<>();
	private final Map<Player, GameObject> playerMap = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final List<GameObject> roots = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private final List<GameObject> saplingIngredients = new ArrayList<>(5);
	@Getter(AccessLevel.PACKAGE)
	private final GameObject[] saplingOrder = new GameObject[3];
	private int saplingIngredientsStage;

	@Getter(AccessLevel.PACKAGE)
	private final Set<NPC> bushes = new HashSet<>();
	private boolean sentBushNotification; // Workaround

	@Getter(AccessLevel.PACKAGE)
	private NPC leprechaun;

	@Getter(AccessLevel.PACKAGE)
	private final List<TreeRespawn> respawns = new ArrayList<>();
	private boolean recentlyLoggedIn;
	private int previousPlane;
	private int currentPlane;
	private ClueNestTier clueTierSpawned;

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
		treeObjects.clear();
		roots.clear();
		saplingIngredients.clear();
		Arrays.fill(saplingOrder, null);
		bushes.clear();
		treeMap.clear();
		playerMap.clear();
		leprechaun = null;
		session = null;
		axe = null;
		clueTierSpawned = null;
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		recentlyLoggedIn = false;
		clueTierSpawned = null;
		currentPlane = client.getPlane();
		if (previousPlane != currentPlane)
		{
			// Only clear values because sometimes the trees are still there when changing planes (Top of Seer's Bank)
			treeMap.replaceAll((k, v) -> 0);
			playerMap.clear();
			bushes.clear();
			leprechaun = null;
			previousPlane = currentPlane;
		}

		respawns.removeIf(TreeRespawn::isExpired);

		if (session == null || session.getLastChopping() == null)
		{
			return;
		}

		if (axe != null && axe.matchesChoppingAnimation(client.getLocalPlayer()))
		{
			session.setLastChopping();
			return;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCut = Duration.between(session.getLastChopping(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			session = null;
			axe = null;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM && event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (WOOD_CUT_PATTERN.matcher(event.getMessage()).matches())
		{
			if (session == null)
			{
				session = new WoodcuttingSession();
			}

			session.setLastChopping();
		}

		var msg = event.getMessage();
		if (msg.contains("A bird's nest falls out of the tree") && config.showNestNotification())
		{
			if (clueTierSpawned == null || clueTierSpawned.ordinal() >= config.clueNestNotifyTier().ordinal())
			{
				notifier.notify("A bird nest has spawned!");
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
		Tree tree = Tree.findTree(gameObject.getId());

		if (tree != null)
		{
			log.debug("Tree {} spawned at {}", tree, gameObject.getLocalLocation());
			treeMap.put(gameObject, 0);
		}

		if (tree == Tree.REDWOOD)
		{
			treeObjects.add(gameObject);
		}

		switch (gameObject.getId())
		{
			case ObjectID.TREE_ROOTS:
			case ObjectID.TREE_ROOTS_47483: // glowing roots
				if (roots.isEmpty() && config.forestryRisingRootsNotification())
				{
					notifier.notify("A Rising Roots Forestry event spawned!");
				}

				roots.add(gameObject);
				break;
			case ObjectID.STRUGGLING_SAPLING:
			case ObjectID.STRUGGLING_SAPLING_47485:
			case ObjectID.STRUGGLING_SAPLING_47487:
			case ObjectID.STRUGGLING_SAPLING_47488:
			case ObjectID.STRUGGLING_SAPLING_47490:
			case ObjectID.STRUGGLING_SAPLING_47491:
				if (config.forestryStrugglingSaplingNotification())
				{
					notifier.notify("A Struggling Sapling Forestry event spawned!");
				}
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
		}
	}

	@Subscribe
	public void onGameObjectDespawned(final GameObjectDespawned event)
	{
		final GameObject object = event.getGameObject();

		Tree tree = Tree.findTree(object.getId());
		if (tree != null)
		{
			// Group chopping
			if (treeMap.containsKey(object))
			{
				treeMap.remove(object);
			}

			if (tree.getRespawnTime() != null && !recentlyLoggedIn && currentPlane == object.getPlane())
			{
				log.debug("Adding respawn timer for {} tree at {}", tree, object.getLocalLocation());

				Point min = object.getSceneMinLocation();
				WorldPoint base = WorldPoint.fromScene(client, min.getX(), min.getY(), client.getPlane());
				TreeRespawn treeRespawn = new TreeRespawn(tree, object.sizeX() - 1, object.sizeY() - 1,
					base, Instant.now(), (int) tree.getRespawnTime(base.getRegionID()).toMillis());
				respawns.add(treeRespawn);
			}

			if (tree == Tree.REDWOOD)
			{
				treeObjects.remove(event.getGameObject());
			}
		}

		switch (object.getId())
		{
			case ObjectID.TREE_ROOTS:
			case ObjectID.TREE_ROOTS_47483:
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
		}
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
				respawns.clear();
			case LOADING:
				treeObjects.clear();
				roots.clear();
				saplingIngredients.clear();
				Arrays.fill(saplingOrder, null);
				treeMap.clear();
				playerMap.clear();
				bushes.clear();
				saplingIngredients.clear();
				sentBushNotification = false;
				leprechaun = null;
				break;
			case LOGGED_IN:
				// After login trees that are depleted will be changed,
				// wait for the next game tick before watching for
				// trees to despawn
				recentlyLoggedIn = true;
				sentBushNotification = false;
				break;
		}
	}

	@Subscribe
	public void onAnimationChanged(final AnimationChanged event)
	{
		// Group chopping
		if (event.getActor() instanceof Player)
		{
			Player player = (Player) event.getActor();
			if (isWoodcutting(player) && !treeMap.isEmpty())
			{
				// Now we have to find the closest tree to the player that we are facing
				// Orientation: N=1024, E=1536, S=0, W=512, where we would filter tile loc N = y+1, E= x+1, S=y-1, W=x-1
				GameObject closestTree = findClosestFacingTree(player);
				if (closestTree == null)
				{
					return;
				}
				playerMap.put(player, closestTree);
				int choppers = treeMap.getOrDefault(closestTree, 0) + 1;
				treeMap.put(closestTree, choppers);
//				log.debug("There is now {} people chopping {}", choppers.size(), closestTree);
			}
			else if (player.getAnimation() == AnimationID.LOOKING_INTO && event.getActor().getInteracting() != null)
			{
				if (bushes.size() == 2 && !bushes.contains(event.getActor().getInteracting()))
				{
					bushes.clear();
				}
				else if (bushes.size() < 2 && !bushes.contains(event.getActor().getInteracting()))
				{
					bushes.add((NPC) event.getActor().getInteracting());
				}
			}
			else if (player.getAnimation() == -1)
			{
				if (!playerMap.isEmpty() && playerMap.containsKey(player))
				{
					GameObject tree = playerMap.get(player);
					playerMap.remove(player);
					if (treeMap.containsKey(tree))
					{
						int choppers = treeMap.getOrDefault(tree, 1) - 1;
						treeMap.put(tree, choppers);
//						log.debug("There is now {} people chopping {}", choppers.size(), tree);
					}
				}
			}
			else if (player == client.getLocalPlayer() && player.getAnimation() == AnimationID.BURYING_BONES && player.getInteracting() == null)
			{
				if (foundIngredientOrder())
				{
					if (saplingIngredientsStage == 3)
					{
						saplingIngredientsStage = 0;
					}
				}
			}
		}

		Player local = client.getLocalPlayer();

		if (event.getActor() != local)
		{
			return;
		}

		int animId = local.getAnimation();
		Axe axe = Axe.findAxeByAnimId(animId);
		if (axe != null)
		{
			this.axe = axe;
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();
		if (npc.getId() == NpcID.FLOWERING_BUSH)
		{
			if (!sentBushNotification && config.forestryFloweringTreeNotification())
			{
				notifier.notify("A Flowering Tree Forestry event spawned!");
				sentBushNotification = true;
			}
		}
		else if (npc.getId() == NpcID.WOODCUTTING_LEPRECHAUN)
		{
			leprechaun = npc;
			if (config.forestryLeprechaunNotification())
			{
				notifier.notify("A Leprechaun event spawned!");
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		NPC npc = event.getNpc();

		switch (npc.getId())
		{
			case NpcID.WOODCUTTING_LEPRECHAUN:
				leprechaun = null;
				break;
			case NpcID.FRIENDLY_BEES:
				bushes.clear();
				sentBushNotification = false;
				break;
		}

		if (bushes.contains(event.getNpc()))
		{
			bushes.remove(event.getNpc());
		}
	}

	@Subscribe
	public void onNpcChanged(final NpcChanged event)
	{
		if (event.getOld().getId() == NpcID.FLOWERING_BUSH)
		{
//			bushes.clear();
		}
	}

	@Subscribe
	public void onPlayerDespawned(final PlayerDespawned event)
	{
		GameObject tree = playerMap.get(event.getPlayer());
		if (playerMap.containsKey(event.getPlayer()))
		{
			playerMap.remove(event.getPlayer());
			if (treeMap.containsKey(tree))
			{
				int choppers = treeMap.getOrDefault(tree, 1) - 1;
				treeMap.put(tree, choppers);
			}
		}
	}

	@Subscribe
	public void onPlayerSpawned(final PlayerSpawned event)
	{
//		log.debug("Tree map size: {}", treeMap.size());
		Player player = event.getPlayer();
		if (isWoodcutting(player) && !treeMap.isEmpty())
		{
			// Now we have to find the closest tree to the player that we are facing
			// Orientation: N=1024, E=1536, S=0, W=512, where we would filter tile loc N = y+1, E= x+1, S=y-1, W=x-1
			GameObject closestTree = findClosestFacingTree(player);
			if (closestTree == null)
			{
				return;
			}
			playerMap.put(player, closestTree);
			int choppers = treeMap.getOrDefault(closestTree, 0) + 1;
			treeMap.put(closestTree, choppers);
//				log.debug("There is now {} people chopping {}", choppers.size(), closestTree);
		}
	}

	private boolean isWoodcutting(Actor actor)
	{
		return Axe.findAxeByAnimId(actor.getAnimation()) != null;
	}

	private GameObject findClosestFacingTree(Actor actor)
	{
		// First we filter out all trees whose tile is not in the direction we are facing
		// Orientation: N=1024, E=1536, S=0, W=512, where we would filter tile loc N = y+1, E= x+1, S=y-1, W=x-1
		int orientation = actor.getCurrentOrientation();
		WorldPoint actorLocation = actor.getWorldLocation();
		Optional<Map.Entry<GameObject, Integer>> closestTreeEntry = treeMap.entrySet().stream().filter((entry) ->
			{
				GameObject tree = entry.getKey();
				WorldPoint treeLocation = tree.getWorldLocation();
				switch (new Angle(orientation).getNearestDirection())
				{
					case NORTH: // North, filter out trees that are not north of us
						return treeLocation.getY() > actorLocation.getY();
					case EAST: // East, filter out trees that are not east of us
						return treeLocation.getX() > actorLocation.getX();
					case SOUTH: // South, filter out trees that are not south of us
						return treeLocation.getY() < actorLocation.getY();
					case WEST: // West, filter out trees that are not west of us
						return treeLocation.getX() < actorLocation.getX();
				}
				log.debug("Orientation {} not found", orientation);
				return false;
			}
		).sorted((entry1, entry2) ->
			{
				// Get closest tree with relation to our player's location
				GameObject tree1 = entry1.getKey();
				GameObject tree2 = entry2.getKey();
				WorldPoint treeLocation1 = tree1.getWorldLocation();
				WorldPoint treeLocation2 = tree2.getWorldLocation();
				return actorLocation.distanceTo(treeLocation1) - actorLocation.distanceTo(treeLocation2);
			}
		).findFirst();

		if (closestTreeEntry.isPresent())
		{
//			log.debug("Closest tree is {}", closestTreeEntry.get().getKey().getWorldLocation());
			return closestTreeEntry.get().getKey();
		}
		else
		{
			log.debug("No closest tree found");
			return null;
		}
	}

	private boolean foundIngredientOrder()
	{
		return saplingOrder[0] != null && saplingOrder[1] != null && saplingOrder[2] != null;
	}
}
