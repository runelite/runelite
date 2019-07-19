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
import java.awt.Color;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.GraphicID;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NullObjectID;
import net.runelite.api.ObjectID;
import net.runelite.api.Projectile;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
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
@Singleton
@Slf4j
public class AoeWarningPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private final Map<WorldPoint, CrystalBomb> bombs = new HashMap<>();
	@Getter(AccessLevel.PACKAGE)
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
	@Inject
	private EventBus eventbus;
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

	// Config values
	private boolean aoeNotifyAll;
	@Getter(AccessLevel.PACKAGE)
	private Color overlayColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean configOutlineEnabled;
	private int delay;
	@Getter(AccessLevel.PACKAGE)
	private boolean configFadeEnabled;
	@Getter(AccessLevel.PACKAGE)
	private boolean tickTimers;
	@Getter(AccessLevel.PACKAGE)
	private int fontStyle;
	@Getter(AccessLevel.PACKAGE)
	private int textSize;
	@Getter(AccessLevel.PACKAGE)
	private boolean shadows;
	private boolean configShamansEnabled;
	private boolean configShamansNotifyEnabled;
	private boolean configArchaeologistEnabled;
	private boolean configArchaeologistNotifyEnabled;
	private boolean configIceDemonEnabled;
	private boolean configIceDemonNotifyEnabled;
	private boolean configVasaEnabled;
	private boolean configVasaNotifyEnabled;
	private boolean configTektonEnabled;
	private boolean configTektonNotifyEnabled;
	private boolean configVorkathEnabled;
	private boolean configVorkathNotifyEnabled;
	private boolean configGalvekEnabled;
	private boolean configGalvekNotifyEnabled;
	private boolean configGargBossEnabled;
	private boolean configGargBossNotifyEnabled;
	private boolean configVetionEnabled;
	private boolean configVetionNotifyEnabled;
	private boolean configChaosFanaticEnabled;
	private boolean configChaosFanaticNotifyEnabled;
	private boolean configOlmEnabled;
	private boolean configOlmNotifyEnabled;
	@Getter(AccessLevel.PACKAGE)
	private boolean configbombDisplay;
	private boolean configbombDisplayNotifyEnabled;
	private boolean configLightningTrail;
	private boolean configLightningTrailNotifyEnabled;
	private boolean configCorpEnabled;
	private boolean configCorpNotifyEnabled;
	private boolean configWintertodtEnabled;
	private boolean configWintertodtNotifyEnabled;
	private boolean configXarpusEnabled;
	private boolean configXarpusNotifyEnabled;
	private boolean configaddyDrags;
	private boolean configaddyDragsNotifyEnabled;
	private boolean configDrakeEnabled;
	private boolean configDrakeNotifyEnabled;
	private boolean configCerbFireEnabled;
	private boolean configCerbFireNotifyEnabled;
	private boolean configDemonicGorillaEnabled;
	private boolean configDemonicGorillaNotifyEnabled;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(coreOverlay);
		overlayManager.add(bombOverlay);
		reset();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventbus.unregister(this);

		overlayManager.remove(coreOverlay);
		overlayManager.remove(bombOverlay);
		reset();
	}

	private void addSubscriptions()
	{
		eventbus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventbus.subscribe(ProjectileMoved.class, this, this::onProjectileMoved);
		eventbus.subscribe(GameObjectSpawned.class, this, this::onGameObjectSpawned);
		eventbus.subscribe(GameObjectDespawned.class, this, this::onGameObjectDespawned);
		eventbus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventbus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("aoe"))
		{
			return;
		}

		updateConfig();
	}

	private void onProjectileMoved(ProjectileMoved event)
	{
		Projectile projectile = event.getProjectile();

		int projectileId = projectile.getId();
		int projectileLifetime = this.delay + (projectile.getRemainingCycles() * 20);
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

			if (this.aoeNotifyAll || isConfigEnabledForProjectileId(projectileId, true))
			{
				notifier.notify("AoE attack detected!");
			}
		}
	}

	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		final GameObject gameObject = event.getGameObject();
		final WorldPoint wp = gameObject.getWorldLocation();

		switch (gameObject.getId())
		{
			case ObjectID.CRYSTAL_BOMB:
				bombs.put(wp, new CrystalBomb(gameObject, client.getTickCount()));

				if (this.aoeNotifyAll || this.configbombDisplayNotifyEnabled)
				{
					notifier.notify("Bomb!");
				}
				break;
			case ObjectID.ACID_POOL:
				AcidTrail.add(wp);
				break;
			case ObjectID.SMALL_CRYSTALS:
				CrystalSpike.add(wp);
				break;
			case NullObjectID.NULL_26690:
				//Wintertodt Snowfall
				if (this.configWintertodtEnabled)
				{
					WintertodtSnowFall.add(wp);

					if (this.aoeNotifyAll || this.configWintertodtNotifyEnabled)
					{
						notifier.notify("Snow Fall!");
					}
				}
				break;
		}
	}

	private void onGameObjectDespawned(GameObjectDespawned event)
	{
		GameObject gameObject = event.getGameObject();
		WorldPoint wp = gameObject.getWorldLocation();
		switch (gameObject.getId())
		{
			case ObjectID.CRYSTAL_BOMB:
				purgeBombs(bombs);
				break;
			case ObjectID.ACID_POOL:
				AcidTrail.remove(wp);
				break;
			case ObjectID.SMALL_CRYSTALS:
				CrystalSpike.remove(wp);
				break;
			case NullObjectID.NULL_26690:
				//Wintertodt Snowfall
				if (this.configWintertodtEnabled)
				{
					WintertodtSnowFall.remove(wp);
				}
				break;
		}
	}

	private void onGameStateChanged(GameStateChanged delta)
	{
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			purgeBombs(bombs);
		}
	}

	private void onGameTick(GameTick event)
	{
		if (this.configLightningTrail)
		{
			LightningTrail.clear();
			for (GraphicsObject o : client.getGraphicsObjects())
			{
				if (o.getId() == GraphicID.OLM_LIGHTNING)
				{
					LightningTrail.add(WorldPoint.fromLocal(client, o.getLocation()));

					if (this.aoeNotifyAll || this.configLightningTrailNotifyEnabled)
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

			if (local == null)
			{
				return;
			}

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

		if (notify && this.aoeNotifyAll)
		{
			return true;
		}

		switch (projectileInfo)
		{
			case LIZARDMAN_SHAMAN_AOE:
				return notify ? this.configShamansNotifyEnabled : this.configShamansEnabled;
			case CRAZY_ARCHAEOLOGIST_AOE:
				return notify ? this.configArchaeologistNotifyEnabled : this.configArchaeologistEnabled;
			case ICE_DEMON_RANGED_AOE:
			case ICE_DEMON_ICE_BARRAGE_AOE:
				return notify ? this.configIceDemonNotifyEnabled : this.configIceDemonEnabled;
			case VASA_AWAKEN_AOE:
			case VASA_RANGED_AOE:
				return notify ? this.configVasaNotifyEnabled : this.configVasaEnabled;
			case TEKTON_METEOR_AOE:
				return notify ? this.configTektonNotifyEnabled : this.configTektonEnabled;
			case VORKATH_BOMB:
			case VORKATH_POISON_POOL:
			case VORKATH_SPAWN:
			case VORKATH_TICK_FIRE:
				return notify ? this.configVorkathNotifyEnabled : this.configVorkathEnabled;
			case VETION_LIGHTNING:
				return notify ? this.configVetionNotifyEnabled : this.configVetionEnabled;
			case CHAOS_FANATIC:
				return notify ? this.configChaosFanaticNotifyEnabled : this.configChaosFanaticEnabled;
			case GALVEK_BOMB:
			case GALVEK_MINE:
				return notify ? this.configGalvekNotifyEnabled : this.configGalvekEnabled;
			case DAWN_FREEZE:
			case DUSK_CEILING:
				return notify ? this.configGargBossNotifyEnabled : this.configGargBossEnabled;
			case OLM_FALLING_CRYSTAL:
			case OLM_BURNING:
			case OLM_FALLING_CRYSTAL_TRAIL:
			case OLM_ACID_TRAIL:
			case OLM_FIRE_LINE:
				return notify ? this.configOlmNotifyEnabled : this.configOlmEnabled;
			case CORPOREAL_BEAST:
			case CORPOREAL_BEAST_DARK_CORE:
				return notify ? this.configCorpNotifyEnabled : this.configCorpEnabled;
			case XARPUS_POISON_AOE:
				return notify ? this.configXarpusNotifyEnabled : this.configXarpusEnabled;
			case ADDY_DRAG_POISON:
				return notify ? this.configaddyDragsNotifyEnabled : this.configaddyDrags;
			case DRAKE_BREATH:
				return notify ? this.configDrakeNotifyEnabled : this.configDrakeEnabled;
			case CERB_FIRE:
				return notify ? this.configCerbFireNotifyEnabled : this.configCerbFireEnabled;
			case DEMONIC_GORILLA_BOULDER:
				return notify ? this.configDemonicGorillaNotifyEnabled : this.configDemonicGorillaEnabled;
		}

		return false;
	}

	private void updateConfig()
	{
		this.aoeNotifyAll = config.aoeNotifyAll();
		this.overlayColor = config.overlayColor();
		this.configOutlineEnabled = config.isOutlineEnabled();
		this.delay = config.delay();
		this.configFadeEnabled = config.isFadeEnabled();
		this.tickTimers = config.tickTimers();
		this.fontStyle = config.fontStyle().getFont();
		this.textSize = config.textSize();
		this.shadows = config.shadows();
		this.configShamansEnabled = config.isShamansEnabled();
		this.configShamansNotifyEnabled = config.isShamansNotifyEnabled();
		this.configArchaeologistEnabled = config.isArchaeologistEnabled();
		this.configArchaeologistNotifyEnabled = config.isArchaeologistNotifyEnabled();
		this.configIceDemonEnabled = config.isIceDemonEnabled();
		this.configIceDemonNotifyEnabled = config.isIceDemonNotifyEnabled();
		this.configVasaEnabled = config.isVasaEnabled();
		this.configVasaNotifyEnabled = config.isVasaNotifyEnabled();
		this.configTektonEnabled = config.isTektonEnabled();
		this.configTektonNotifyEnabled = config.isTektonNotifyEnabled();
		this.configVorkathEnabled = config.isVorkathEnabled();
		this.configVorkathNotifyEnabled = config.isVorkathNotifyEnabled();
		this.configGalvekEnabled = config.isGalvekEnabled();
		this.configGalvekNotifyEnabled = config.isGalvekNotifyEnabled();
		this.configGargBossEnabled = config.isGargBossEnabled();
		this.configGargBossNotifyEnabled = config.isGargBossNotifyEnabled();
		this.configVetionEnabled = config.isVetionEnabled();
		this.configVetionNotifyEnabled = config.isVetionNotifyEnabled();
		this.configChaosFanaticEnabled = config.isChaosFanaticEnabled();
		this.configChaosFanaticNotifyEnabled = config.isChaosFanaticNotifyEnabled();
		this.configOlmEnabled = config.isOlmEnabled();
		this.configOlmNotifyEnabled = config.isOlmNotifyEnabled();
		this.configbombDisplay = config.bombDisplay();
		this.configbombDisplayNotifyEnabled = config.bombDisplayNotifyEnabled();
		this.configLightningTrail = config.LightningTrail();
		this.configLightningTrailNotifyEnabled = config.LightningTrailNotifyEnabled();
		this.configCorpEnabled = config.isCorpEnabled();
		this.configCorpNotifyEnabled = config.isCorpNotifyEnabled();
		this.configWintertodtEnabled = config.isWintertodtEnabled();
		this.configWintertodtNotifyEnabled = config.isWintertodtNotifyEnabled();
		this.configXarpusEnabled = config.isXarpusEnabled();
		this.configXarpusNotifyEnabled = config.isXarpusNotifyEnabled();
		this.configaddyDrags = config.addyDrags();
		this.configaddyDragsNotifyEnabled = config.addyDragsNotifyEnabled();
		this.configDrakeEnabled = config.isDrakeEnabled();
		this.configDrakeNotifyEnabled = config.isDrakeNotifyEnabled();
		this.configCerbFireEnabled = config.isCerbFireEnabled();
		this.configCerbFireNotifyEnabled = config.isCerbFireNotifyEnabled();
		this.configDemonicGorillaEnabled = config.isDemonicGorillaEnabled();
		this.configDemonicGorillaNotifyEnabled = config.isDemonicGorillaNotifyEnabled();
	}

	private void reset()
	{
		LightningTrail.clear();
		AcidTrail.clear();
		CrystalSpike.clear();
		WintertodtSnowFall.clear();
		bombs.clear();
		projectiles.clear();
	}
}
