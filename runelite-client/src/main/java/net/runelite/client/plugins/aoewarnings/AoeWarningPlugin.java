/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Modified by farhan1666
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
package net.runelite.client.plugins.aoewarnings;


import com.google.inject.Provides;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NullObjectID;
import net.runelite.api.ObjectID;
import net.runelite.api.Projectile;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "AoE Warnings",
	description = "Shows the final destination for AoE Attack projectiles",
	tags = {"bosses", "combat", "pve", "overlay"},
	type = PluginType.PVM,
	enabledByDefault = false
)

@Slf4j
public class AoeWarningPlugin extends Plugin
{

	@Getter
	private final Map<WorldPoint, CrystalBomb> bombs = new HashMap<>();
	private final Map<Projectile, AoeProjectile> projectiles = new HashMap<>();

	@Inject
	public AoeWarningConfig config;

	@Inject
	private Notifier notifier;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private AoeWarningOverlay coreOverlay;

	@Inject
	private BombOverlay bombOverlay;

	@Inject
	private Client client;

	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> LightningTrail = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> AcidTrail = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> CrystalSpike = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> WintertodtSnowFall = new ArrayList<>();

	@Provides
	AoeWarningConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AoeWarningConfig.class);
	}

	Map<Projectile, AoeProjectile> getProjectiles()
	{
		return projectiles;
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(coreOverlay);
		overlayManager.add(bombOverlay);
		LightningTrail.clear();
		AcidTrail.clear();
		CrystalSpike.clear();
		WintertodtSnowFall.clear();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(coreOverlay);
		overlayManager.remove(bombOverlay);
		LightningTrail.clear();
		AcidTrail.clear();
		CrystalSpike.clear();
		WintertodtSnowFall.clear();
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		Projectile projectile = event.getProjectile();

		int projectileId = projectile.getId();
		int projectileLifetime = config.delay() + (projectile.getRemainingCycles() * 20);
		int ticksRemaining = projectile.getRemainingCycles() / 30;
		if (!isTickTimersEnabledForProjectileID(projectileId))
		{
			ticksRemaining = 0;
		}
		int tickCycle = client.getTickCount() + ticksRemaining;
		AoeProjectileInfo aoeProjectileInfo = AoeProjectileInfo.getById(projectileId);
		if (aoeProjectileInfo != null
			&& isConfigEnabledForProjectileId(projectileId, false))
		{
			LocalPoint targetPoint = event.getPosition();
			AoeProjectile aoeProjectile = new AoeProjectile(Instant.now(), targetPoint, aoeProjectileInfo, projectileLifetime, tickCycle);
			projectiles.put(projectile, aoeProjectile);

			if (config.aoeNotifyAll() || isConfigEnabledForProjectileId(projectileId, true))
			{
				notifier.notify("AoE attack detected!");
			}
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		final GameObject gameObject = event.getGameObject();
		final WorldPoint bombLocation = gameObject.getWorldLocation();

		switch (gameObject.getId())
		{
			case ObjectID.CRYSTAL_BOMB:
				bombs.put(bombLocation, new CrystalBomb(gameObject, client.getTickCount()));

				if (config.aoeNotifyAll() || config.bombDisplayNotifyEnabled())
				{
					notifier.notify("Bomb!");
				}
				break;
			case ObjectID.ACID_POOL:
				AcidTrail.add(bombLocation);
				break;
			case ObjectID.SMALL_CRYSTALS:
				//todo
				CrystalSpike.add(bombLocation);
				break;
			case NullObjectID.NULL_26690:
				//Wintertodt Snowfall
				if (config.isWintertodtEnabled())
				{
					WintertodtSnowFall.add(bombLocation);

					if (config.aoeNotifyAll() || config.isWintertodtNotifyEnabled())
					{
						notifier.notify("Snow Fall!");
					}
				}
				break;
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		GameObject gameObject = event.getGameObject();
		WorldPoint bombLocation = gameObject.getWorldLocation();
		switch (gameObject.getId())
		{
			case ObjectID.CRYSTAL_BOMB:
				//might as well check the ObjectID to save some time.
				purgeBombs(bombs);
				break;
			case ObjectID.ACID_POOL:
				AcidTrail.remove(bombLocation);
				break;
			case ObjectID.SMALL_CRYSTALS:
				//todo
				CrystalSpike.remove(bombLocation);
				break;
			case NullObjectID.NULL_26690:
				//Wintertodt Snowfall
				if (config.isWintertodtEnabled())
				{
					WintertodtSnowFall.remove(bombLocation);
				}
				break;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged delta)
	{
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			purgeBombs(bombs);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (config.LightningTrail())
		{
			LightningTrail.clear();
			for (GraphicsObject o : client.getGraphicsObjects())
			{
				if (o.getId() == 1356)
				{
					LightningTrail.add(WorldPoint.fromLocal(client, o.getLocation()));

					if (config.aoeNotifyAll() || config.LightningTrailNotifyEnabled())
					{
						notifier.notify("Lightning!");
					}
				}
			}
		}

		for (Map.Entry<WorldPoint, CrystalBomb> entry : bombs.entrySet())
		{
			CrystalBomb bomb = entry.getValue();
			bomb.bombClockUpdate();
			//bombClockUpdate smooths the shown timer; not using this results in 1.2 --> .6 vs. 1.2 --> 1.1, etc.
		}
	}

	private void purgeBombs(Map<WorldPoint, CrystalBomb> bombs)
	{
		Iterator<Map.Entry<WorldPoint, CrystalBomb>> it = bombs.entrySet().iterator();
		Tile[][][] tiles = client.getScene().getTiles();

		while (it.hasNext())
		{
			Map.Entry<WorldPoint, CrystalBomb> entry = it.next();
			WorldPoint world = entry.getKey();
			LocalPoint local = LocalPoint.fromWorld(client, world);
			Tile tile = tiles[world.getPlane()][local.getSceneX()][local.getSceneY()];
			GameObject[] objects = tile.getGameObjects();
			boolean containsObjects = false;

			for (GameObject object : objects)
			{
				if (object != null)
				{
					containsObjects = true;
				}
			}

			if (!containsObjects)
			{
				it.remove();
			}

		}
	}

	private boolean isTickTimersEnabledForProjectileID(int projectileId)
	{
		AoeProjectileInfo projectileInfo = AoeProjectileInfo.getById(projectileId);

		if (projectileInfo == null)
		{
			return false;
		}

		switch (projectileInfo)
		{
			case VASA_RANGED_AOE:
			case VORKATH_POISON_POOL:
			case VORKATH_SPAWN:
			case VORKATH_TICK_FIRE:
			case OLM_BURNING:
			case OLM_FALLING_CRYSTAL_TRAIL:
			case OLM_ACID_TRAIL:
			case OLM_FIRE_LINE:
				return false;
		}

		return true;
	}

	private boolean isConfigEnabledForProjectileId(int projectileId, boolean notify)
	{
		AoeProjectileInfo projectileInfo = AoeProjectileInfo.getById(projectileId);
		if (projectileInfo == null)
		{
			return false;
		}

		if (notify && config.aoeNotifyAll())
		{
			return true;
		}

		switch (projectileInfo)
		{
			case LIZARDMAN_SHAMAN_AOE:
				return notify ? config.isShamansNotifyEnabled() : config.isShamansEnabled();
			case CRAZY_ARCHAEOLOGIST_AOE:
				return notify ? config.isArchaeologistNotifyEnabled() : config.isArchaeologistEnabled();
			case ICE_DEMON_RANGED_AOE:
			case ICE_DEMON_ICE_BARRAGE_AOE:
				return notify ? config.isIceDemonNotifyEnabled() : config.isIceDemonEnabled();
			case VASA_AWAKEN_AOE:
			case VASA_RANGED_AOE:
				return notify ? config.isVasaNotifyEnabled() : config.isVasaEnabled();
			case TEKTON_METEOR_AOE:
				return notify ? config.isTektonNotifyEnabled() : config.isTektonEnabled();
			case VORKATH_BOMB:
			case VORKATH_POISON_POOL:
			case VORKATH_SPAWN:
			case VORKATH_TICK_FIRE:
				return notify ? config.isVorkathNotifyEnabled() : config.isVorkathEnabled();
			case VETION_LIGHTNING:
				return notify ? config.isVetionNotifyEnabled() : config.isVetionEnabled();
			case CHAOS_FANATIC:
				return notify ? config.isChaosFanaticNotifyEnabled() : config.isChaosFanaticEnabled();
			case GALVEK_BOMB:
			case GALVEK_MINE:
				return notify ? config.isGalvekNotifyEnabled() : config.isGalvekEnabled();
			case DAWN_FREEZE:
			case DUSK_CEILING:
				return notify ? config.isGargBossNotifyEnabled() : config.isGargBossEnabled();
			case OLM_FALLING_CRYSTAL:
			case OLM_BURNING:
			case OLM_FALLING_CRYSTAL_TRAIL:
			case OLM_ACID_TRAIL:
			case OLM_FIRE_LINE:
				return notify ? config.isOlmNotifyEnabled() : config.isOlmEnabled();
			case CORPOREAL_BEAST:
			case CORPOREAL_BEAST_DARK_CORE:
				return notify ? config.isCorpNotifyEnabled() : config.isCorpEnabled();
			case XARPUS_POISON_AOE:
				return notify ? config.isXarpusNotifyEnabled() : config.isXarpusEnabled();
			case ADDY_DRAG_POISON:
				return notify ? config.addyDragsNotifyEnabled() : config.addyDrags();
			case DRAKE_BREATH:
				return notify ? config.isDrakeNotifyEnabled() : config.isDrakeEnabled();
			case CERB_FIRE:
				return notify ? config.isCerbFireNotifyEnabled() : config.isCerbFireEnabled();
			case DEMONIC_GORILLA_BOULDER:
				return notify ? config.isDemonicGorillaNotifyEnabled() : config.isDemonicGorillaEnabled();
		}

		return false;
	}
}
