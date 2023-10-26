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
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_3A;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_ADAMANT;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_BLACK;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_BRONZE;
import static net.runelite.api.AnimationID.WOODCUTTING_2H_CRYSTAL;
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
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.ObjectID;
import net.runelite.api.Point;
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
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.woodcutting.config.ClueNestTier;
import net.runelite.client.ui.overlay.OverlayManager;

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
		WOODCUTTING_2H_CRYSTAL, WOODCUTTING_2H_3A
	);

	private static final Pattern WOOD_CUT_PATTERN = Pattern.compile("You get (?:some|an)[\\w ]+(?:logs?|mushrooms)\\.");
	private static final Pattern ANIMA_BARK_PATTERN = Pattern.compile("You've been awarded <col=[0-9a-f]+>(\\d+) Anima-infused bark</col>\\.");

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private WoodcuttingOverlay overlay;

	@Inject
	private WoodcuttingSceneOverlay treesOverlay;

	@Inject
	private WoodcuttingConfig config;

	@Getter
	@Nullable
	@Setter(AccessLevel.PACKAGE)
	private WoodcuttingSession session;

	@Getter
	private final Set<GameObject> treeObjects = new HashSet<>();

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
	private NPC freakyForester;
	@Getter(AccessLevel.PACKAGE)
	private NPC unfinishedBeeHive;
	private final List<NPC> circles = new ArrayList<>(5);
	private final List<NPC> entlings = new ArrayList<>(0);

	@Getter(AccessLevel.PACKAGE)
	private final List<TreeRespawn> respawns = new ArrayList<>();
	private boolean recentlyLoggedIn;
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
		flowers.clear();
		saplingIngredients.clear();
		Arrays.fill(saplingOrder, null);
		session = null;
		clueTierSpawned = null;
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		recentlyLoggedIn = false;
		clueTierSpawned = null;
		currentPlane = client.getPlane();

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
		Tree tree = Tree.findTree(gameObject.getId());

		if (tree == Tree.REDWOOD)
		{
			treeObjects.add(gameObject);
		}

		switch (gameObject.getId())
		{
			case ObjectID.TREE_ROOTS:
			case ObjectID.ANIMAINFUSED_TREE_ROOTS:
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
			case ObjectID.PHEASANT_NEST:
			case ObjectID.PHEASANT_NEST_49937:
				pheasantNests.add(gameObject);
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
		}
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
				treeObjects.clear();
				roots.clear();
				saplingIngredients.clear();
				Arrays.fill(saplingOrder, null);
				pheasantNests.clear();
				break;
			case LOGGED_IN:
				// After login trees that are depleted will be changed,
				// wait for the next game tick before watching for
				// trees to despawn
				recentlyLoggedIn = true;
				break;
		}
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
			if (flowers.isEmpty() && config.forestryFloweringTreeNotification())
			{
				notifier.notify("A Flowering Tree Forestry event spawned!");
			}

			flowers.add(npc);
		}
		else if (id == NpcID.WOODCUTTING_LEPRECHAUN && config.forestryLeprechaunNotification())
		{
			notifier.notify("A Leprechaun event spawned!");
		}
		else if (id == NpcID.FRIGHTENED_FOX && config.forestryPoachersNotification())
		{
			notifier.notify("A Poachers event spawned!");
		}
		else if (id == NpcID.FOX_TRAP)
		{
			foxTrap = npc;
		}
		else if (id == NpcID.FREAKY_FORESTER_12536)
		{
			freakyForester = npc;

			if (config.forestryPheasantControlNotification())
			{
				notifier.notify("A Pheasant Control event has spawned!");
			}
		}
		else if (id == NpcID.WILD_BEE_HIVE)
		{
			if (config.forestryBeeHiveNotification())
			{
				notifier.notify("A Bee Hive event has spawned!");
			}
		}
		else if (id == NpcID.UNFINISHED_BEE_HIVE || id == NpcID.UNFINISHED_BEE_HIVE_12516)
		{
			unfinishedBeeHive = npc;
		}
		else if (id >= NpcID.RITUAL_CIRCLE_GREEN && id <= NpcID.RITUAL_CIRCLE_RED_12535)
		{
			circles.add(npc);
		}
		else if (id == NpcID.DRYAD_12519)
		{
			if (config.forestryEnchantmentRitualNotification())
			{
				notifier.notify("An Enchantment Ritual event has spawned!");
			}
		}
		else if (id == NpcID.ENTLING)
		{
			entlings.add(npc);
			if (entlings.size() == 1 && config.forestryFriendlyEntNotification())
			{
				notifier.notify("A Friendly Ent event has spawned!");
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
