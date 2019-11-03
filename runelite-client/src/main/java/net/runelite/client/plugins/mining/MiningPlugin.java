/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, Pinibot <https://github.com/Pinibot>
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
package net.runelite.client.plugins.mining;

import com.google.inject.Provides;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import static net.runelite.api.AnimationID.DENSE_ESSENCE_CHIPPING;
import static net.runelite.api.AnimationID.MINING_3A_PICKAXE;
import static net.runelite.api.AnimationID.MINING_ADAMANT_PICKAXE;
import static net.runelite.api.AnimationID.MINING_BLACK_PICKAXE;
import static net.runelite.api.AnimationID.MINING_BRONZE_PICKAXE;
import static net.runelite.api.AnimationID.MINING_CRYSTAL_PICKAXE;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE_OR;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE_UPGRADED;
import static net.runelite.api.AnimationID.MINING_INFERNAL_PICKAXE;
import static net.runelite.api.AnimationID.MINING_IRON_PICKAXE;
import static net.runelite.api.AnimationID.MINING_MITHRIL_PICKAXE;
import static net.runelite.api.AnimationID.MINING_RUNE_PICKAXE;
import static net.runelite.api.AnimationID.MINING_STEEL_PICKAXE;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import static net.runelite.api.NullObjectID.NULL_8981;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26665;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26666;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26667;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26668;
import static net.runelite.api.ObjectID.EMPTY_WALL;
import static net.runelite.api.ObjectID.ORE_VEIN_26661;
import static net.runelite.api.ObjectID.ORE_VEIN_26662;
import static net.runelite.api.ObjectID.ORE_VEIN_26663;
import static net.runelite.api.ObjectID.ORE_VEIN_26664;
import net.runelite.api.Player;
import net.runelite.api.TileObject;
import net.runelite.api.Varbits;
import net.runelite.api.WallObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Mining",
	description = "Show ore respawn timers",
	tags = {"overlay", "skilling", "timers"},
	enabledByDefault = false
)
public class MiningPlugin extends Plugin
{
	private static final int DENSE_RUNESTONE_MINE_REGION_ID = 6972;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MiningOverlay overlay;

	@Inject
	private DenseRunestoneMineOverlay denseRunestoneMineOverlay;

	@Getter(AccessLevel.PACKAGE)
	private final List<RockRespawn> respawns = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private final Set<DenseRunestone> runestones = new HashSet<>();

	private boolean recentlyLoggedIn;
	private List<Integer> miningAnimations = new ArrayList<>();

	public MiningPlugin()
	{
		populateMiningAnimations();
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlayManager.add(denseRunestoneMineOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(denseRunestoneMineOverlay);
		respawns.clear();
		runestones.clear();
	}

	@Provides
	MiningConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MiningConfig.class);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOADING:
			case HOPPING:
				respawns.clear();
				runestones.clear();
				break;
			case LOGGED_IN:
				// After login rocks that are depleted will be changed,
				// so wait for the next game tick before watching for
				// rocks to deplete
				recentlyLoggedIn = true;
				break;
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		recentlyLoggedIn = false;
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject object = event.getGameObject();

		Rock rock = Rock.getRock(object.getId());
		if (rock != null)
		{
			if (rock == Rock.DENSE_RUNESTONE)
			{
				Varbits depletionVarbit = object.getId() == NULL_8981 ? Varbits.DENSE_RUNESTONE_NORTH_DEPLETED
					: Varbits.DENSE_RUNESTONE_SOUTH_DEPLETED;
				boolean isDepleted = client.getVar(depletionVarbit) == 1;

				// Add the newly spawned Dense Runestone to the list
				DenseRunestone denseRunestone = new DenseRunestone(isDepleted, object, depletionVarbit);
				runestones.add(denseRunestone);
			}
		}

	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (client.getGameState() != GameState.LOGGED_IN || recentlyLoggedIn)
		{
			return;
		}

		final GameObject object = event.getGameObject();
		final int region = client.getLocalPlayer().getWorldLocation().getRegionID();

		Rock rock = Rock.getRock(object.getId());
		if (rock != null)
		{
			if (rock == Rock.DENSE_RUNESTONE)
			{
				runestones.removeIf(r -> r.getGameObject().getId() == object.getId());
			}
			addRockToRespawns(rock, object, region);
		}
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final WallObject object = event.getWallObject();
		final int region = client.getLocalPlayer().getWorldLocation().getRegionID();

		switch (object.getId())
		{
			case EMPTY_WALL:
			{
				Rock rock = Rock.AMETHYST;
				addRockToRespawns(rock, object, region);
				break;
			}
			case DEPLETED_VEIN_26665: // Depleted motherlode vein
			case DEPLETED_VEIN_26666: // Depleted motherlode vein
			case DEPLETED_VEIN_26667: // Depleted motherlode vein
			case DEPLETED_VEIN_26668: // Depleted motherlode vein
			{
				Rock rock = Rock.ORE_VEIN;
				addRockToRespawns(rock, object, region);
				break;
			}
			case ORE_VEIN_26661: // Motherlode vein
			case ORE_VEIN_26662: // Motherlode vein
			case ORE_VEIN_26663: // Motherlode vein
			case ORE_VEIN_26664: // Motherlode vein
			{
				// If the vein respawns before the timer is up, remove it
				final WorldPoint point = object.getWorldLocation();
				respawns.removeIf(rockRespawn -> rockRespawn.getWorldPoint().equals(point));
				break;
			}
		}
	}


	protected boolean isMining()
	{
		Player local = client.getLocalPlayer();

		// Check to see if the player is currently mining
		int playerAnimationId = local.getAnimation();
		return miningAnimations.contains(playerAnimationId);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		checkRunestoneDepletion();
	}

	private void checkRunestoneDepletion()
	{
		// Return early if we've just logged in
		if (client.getGameState() != GameState.LOGGED_IN || recentlyLoggedIn)
		{
			return;
		}

		// Check to see if the player is in the same region as the dense runestones
		final int region = client.getLocalPlayer().getWorldLocation().getRegionID();
		if (region == DENSE_RUNESTONE_MINE_REGION_ID)
		{
			runestones.forEach(r ->
			{
				r.setDepleted(client.getVar(r.getDepletionVarbit()) == 1);
				if (r.isDepleted())
				{
					Rock rock = Rock.getRock(r.getGameObject().getId());
					addRockToRespawns(rock, r.getGameObject(), region);
				}
				else
				{
					final WorldPoint point = r.getGameObject().getWorldLocation();
					respawns.removeIf(rockRespawn -> rockRespawn.getWorldPoint().equals(point));
				}
			});
		}
	}

	private boolean addRockToRespawns(Rock rock, TileObject object, int region)
	{
		RockRespawn rockRespawn = new RockRespawn(rock, object.getWorldLocation(), Instant.now(),
			(int) rock.getRespawnTime(region).toMillis(), rock.getZOffset());
		return respawns.add(rockRespawn);
	}

	private void populateMiningAnimations()
	{
		this.miningAnimations.add(MINING_BRONZE_PICKAXE);
		this.miningAnimations.add(MINING_IRON_PICKAXE);
		this.miningAnimations.add(MINING_STEEL_PICKAXE);
		this.miningAnimations.add(MINING_BLACK_PICKAXE);
		this.miningAnimations.add(MINING_MITHRIL_PICKAXE);
		this.miningAnimations.add(MINING_ADAMANT_PICKAXE);
		this.miningAnimations.add(MINING_BRONZE_PICKAXE);
		this.miningAnimations.add(MINING_RUNE_PICKAXE);
		this.miningAnimations.add(MINING_DRAGON_PICKAXE);
		this.miningAnimations.add(MINING_DRAGON_PICKAXE_UPGRADED);
		this.miningAnimations.add(MINING_DRAGON_PICKAXE_OR);
		this.miningAnimations.add(MINING_INFERNAL_PICKAXE);
		this.miningAnimations.add(MINING_3A_PICKAXE);
		this.miningAnimations.add(MINING_CRYSTAL_PICKAXE);
		this.miningAnimations.add(DENSE_ESSENCE_CHIPPING);
	}
}
