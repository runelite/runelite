/*
 * Copyright (c) 2019, kThisIsCvpv <https://github.com/kThisIsCvpv>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/Kyleeld>
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

package net.runelite.client.plugins.gauntlet;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.HeadIcon;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.NpcID;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.Projectile;
import net.runelite.api.ProjectileID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.Varbits;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import static net.runelite.client.plugins.gauntlet.Hunllef.BossAttack.LIGHTNING;
import static net.runelite.client.plugins.gauntlet.Hunllef.BossAttack.MAGIC;
import static net.runelite.client.plugins.gauntlet.Hunllef.BossAttack.PRAYER;
import static net.runelite.client.plugins.gauntlet.Hunllef.BossAttack.RANGE;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Gauntlet",
	description = "All-in-one plugin for the Gauntlet.",
	tags = {"Gauntlet"},
	enabledByDefault = false,
	type = PluginType.PVM
)
@Getter(AccessLevel.PACKAGE)
public class GauntletPlugin extends Plugin
{
	private static final int BOW_ATTACK = 426;
	private static final int STAFF_ATTACK = 1167;
	private static final int LIGHTNING_ANIMATION = 8418;
	private static final Set<Integer> TORNADO_NPC_IDS = ImmutableSet.of(9025, 9039);
	private static final Set<Integer> MELEE_ANIMATIONS = ImmutableSet.of(395, 401, 400, 401, 386, 390, 422, 423, 401, 428, 440);
	private static final Set<Integer> PLAYER_ANIMATIONS = ImmutableSet.of(395, 401, 400, 401, 386, 390, 422, 423, 401, 428, 440, 426, 1167);
	private static final Set<Integer> HUNLLEF_MAGE_PROJECTILES = ImmutableSet.of(ProjectileID.HUNLLEF_MAGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_MAGE_ATTACK);
	private static final Set<Integer> HUNLLEF_RANGE_PROJECTILES = ImmutableSet.of(ProjectileID.HUNLLEF_RANGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_RANGE_ATTACK);
	private static final Set<Integer> HUNLLEF_PRAYER_PROJECTILES = ImmutableSet.of(ProjectileID.HUNLLEF_PRAYER_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_PRAYER_ATTACK);
	private static final Set<Integer> HUNLLEF_PROJECTILES = ImmutableSet.of(ProjectileID.HUNLLEF_PRAYER_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_PRAYER_ATTACK,
		ProjectileID.HUNLLEF_RANGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_RANGE_ATTACK, ProjectileID.HUNLLEF_MAGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_MAGE_ATTACK
	);
	private static final Set<Integer> HUNLLEF_NPC_IDS = ImmutableSet.of(NpcID.CRYSTALLINE_HUNLLEF, NpcID.CRYSTALLINE_HUNLLEF_9022, NpcID.CRYSTALLINE_HUNLLEF_9023,
		NpcID.CRYSTALLINE_HUNLLEF_9024, NpcID.CORRUPTED_HUNLLEF, NpcID.CORRUPTED_HUNLLEF_9036, NpcID.CORRUPTED_HUNLLEF_9037, NpcID.CORRUPTED_HUNLLEF_9038
	);
	private static final Set<Integer> RESOURCES = ImmutableSet.of(ObjectID.CRYSTAL_DEPOSIT, ObjectID.CORRUPT_DEPOSIT, ObjectID.PHREN_ROOTS,
		ObjectID.PHREN_ROOTS_36066, ObjectID.FISHING_SPOT_36068, ObjectID.FISHING_SPOT_35971, ObjectID.GRYM_ROOT, ObjectID.GRYM_ROOT_36070,
		ObjectID.LINUM_TIRINUM, ObjectID.LINUM_TIRINUM_36072
	);

	@Inject
	@Getter(AccessLevel.NONE)
	private Client client;
	@Inject
	@Getter(AccessLevel.NONE)
	private ClientThread clientThread;
	@Inject
	@Getter(AccessLevel.NONE)
	private OverlayManager overlayManager;
	@Inject
	@Getter(AccessLevel.NONE)
	private GauntletOverlay overlay;
	@Inject
	@Getter(AccessLevel.NONE)
	private GauntletInfoBoxOverlay infoboxoverlay;
	@Inject
	@Getter(AccessLevel.NONE)
	private GauntletConfig config;
	@Inject
	@Getter(AccessLevel.NONE)
	private EventBus eventBus;
	@Inject
	@Getter(AccessLevel.NONE)
	private GauntletTimer timer;
	@Inject
	@Getter(AccessLevel.NONE)
	private SkillIconManager skillIconManager;
	@Inject
	@Getter(AccessLevel.NONE)
	private GauntletCounter GauntletCounter;
	@Setter(AccessLevel.PACKAGE)
	@Nullable
	private Hunllef hunllef;
	private boolean attackVisualOutline;
	private boolean completeStartup = false;
	private boolean displayTimerChat;
	private boolean displayTimerWidget;
	@Setter(AccessLevel.PACKAGE)
	private boolean flash;
	private boolean flashOnWrongAttack;
	private boolean highlightPrayerInfobox;
	private boolean highlightResources;
	private boolean highlightResourcesIcons;
	private boolean highlightWidget;
	private boolean overlayBoss;
	private boolean overlayBossPrayer;
	private boolean overlayTornadoes;
	private boolean timerVisible = true;
	private boolean uniqueAttackVisual;
	private boolean uniquePrayerAudio;
	private boolean uniquePrayerVisual;
	private Color highlightResourcesColor;
	private final Map<String, Integer> items = new HashMap<>();
	private final Set<Missiles> projectiles = new HashSet<>();
	private final Set<Resources> resources = new HashSet<>();
	private GauntletConfig.CounterDisplay countAttacks;
	private int resourceIconSize;
	private Set<Tornado> tornadoes = new HashSet<>();
	private int projectileIconSize;


	@Provides
	GauntletConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GauntletConfig.class);
	}

	@Override
	protected void startUp()
	{
		addSubscriptions();
		updateConfig();
		overlayManager.add(overlay);
		overlayManager.add(infoboxoverlay);
		overlayManager.add(GauntletCounter);
		timerVisible = this.displayTimerWidget;
		timer.resetStates();
		if (timerVisible)
		{
			overlayManager.add(timer);
		}
		if (client.getGameState() != GameState.STARTING && client.getGameState() != GameState.UNKNOWN)
		{
			completeStartup = false;
			clientThread.invoke(() -> {
				timer.initStates();
				completeStartup = true;
			});
		}
		else
		{
			completeStartup = true;
		}
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);
		timer.resetStates();
		if (timerVisible)
		{
			overlayManager.remove(timer);
			timerVisible = false;
		}
		overlayManager.remove(overlay);
		overlayManager.remove(infoboxoverlay);
		overlayManager.remove(GauntletCounter);
		resources.clear();
		projectiles.clear();
		tornadoes.clear();
		setHunllef(null);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameObjectDespawned.class, this, this::onGameObjectDespawned);
		eventBus.subscribe(GameObjectSpawned.class, this, this::onGameObjectSpawned);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(ProjectileSpawned.class, this, this::onProjectileSpawned);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		if (hunllef == null)
		{
			return;
		}

		final Actor actor = event.getActor();

		// This section handles the player counter.
		if (actor instanceof Player && fightingBoss())
		{
			final Player player = (Player) actor;
			final int anim = player.getAnimation();

			if (!player.getName().equals(client.getLocalPlayer().getName()) || anim == -1 || !PLAYER_ANIMATIONS.contains(anim))
			{
				return;
			}

			NPCDefinition comp = hunllef.getNpc().getDefinition();

			if (comp == null || comp.getOverheadIcon() == null)
			{
				return;
			}

			final HeadIcon prayer = comp.getOverheadIcon();

			switch (prayer)
			{
				case MELEE:
					if (MELEE_ANIMATIONS.contains(anim))
					{
						setFlash(true);
						return;
					}
					hunllef.updatePlayerAttack();
					break;
				case RANGED:
					if (BOW_ATTACK == anim)
					{
						setFlash(true);
						return;
					}
					hunllef.updatePlayerAttack();
					break;
				case MAGIC:
					if (STAFF_ATTACK == anim)
					{
						setFlash(true);
						return;
					}
					hunllef.updatePlayerAttack();
					break;
			}
		}

		// This section handles the boss attack counter if they perform a lightning attack.
		if (actor instanceof NPC)
		{
			final NPC npc = (NPC) actor;

			if (npc.getAnimation() == LIGHTNING_ANIMATION)
			{
				hunllef.updateAttack(LIGHTNING);
			}
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("Gauntlet"))
		{
			return;
		}

		updateConfig();

		if (event.getKey().equals("displayTimerWidget"))
		{
			if (this.displayTimerWidget && !timerVisible)
			{
				overlayManager.add(timer);
				timerVisible = true;
			}
			else if (!this.displayTimerWidget && timerVisible)
			{
				overlayManager.remove(timer);
				timerVisible = false;
			}
		}
	}

	private void onGameObjectDespawned(GameObjectDespawned event)
	{
		final GameObject obj = event.getGameObject();
		if (RESOURCES.contains(obj.getId()))
		{
			resources.removeIf(object -> object.getGameObject() == obj);
		}
	}

	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		final GameObject obj = event.getGameObject();
		if (RESOURCES.contains(obj.getId()))
		{
			resources.add(new Resources(obj, event.getTile(), skillIconManager));
		}
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			resources.clear();
		}
	}

	private void onGameTick(GameTick event)
	{
		// This handles the timer based on player health.
		if (this.completeStartup)
		{
			timer.checkStates(false);
		}
		if (!tornadoes.isEmpty())
		{
			tornadoes.forEach(Tornado::updateTimeLeft);
		}
		if (hunllef != null)
		{
			if (hunllef.getTicksUntilAttack() > 0)
			{
				hunllef.setTicksUntilAttack(hunllef.getTicksUntilAttack() - 1);
			}
		}
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		final NPC npc = event.getNpc();
		if (HUNLLEF_NPC_IDS.contains(npc.getId()))
		{
			setHunllef(null);
		}
		else if (TORNADO_NPC_IDS.contains(npc.getId()))
		{
			tornadoes.removeIf(tornado -> tornado.getNpc() == npc);
		}
	}

	private void onNpcSpawned(NpcSpawned event)
	{
		final NPC npc = event.getNpc();
		if (HUNLLEF_NPC_IDS.contains(npc.getId()))
		{
			setHunllef(new Hunllef(npc, skillIconManager));
		}
		else if (TORNADO_NPC_IDS.contains(npc.getId()))
		{
			tornadoes.add(new Tornado(npc));
		}
	}

	private void onProjectileSpawned(ProjectileSpawned event)
	{
		if (hunllef == null)
		{
			return;
		}

		final Projectile proj = event.getProjectile();

		if (HUNLLEF_PROJECTILES.contains(proj.getId()))
		{
			projectiles.add(new Missiles(proj, skillIconManager));
			if (HUNLLEF_MAGE_PROJECTILES.contains(proj.getId()))
			{
				hunllef.updateAttack(MAGIC);
			}
			else if (HUNLLEF_PRAYER_PROJECTILES.contains(proj.getId()))
			{
				hunllef.updateAttack(PRAYER);
				if (this.uniquePrayerAudio)
				{
					client.playSoundEffect(SoundEffectID.MAGIC_SPLASH_BOING);
				}
			}
			else if (HUNLLEF_RANGE_PROJECTILES.contains(proj.getId()))
			{
				hunllef.updateAttack(RANGE);
			}
		}
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		if (this.completeStartup)
		{
			timer.checkStates(true);
		}
	}

	boolean fightingBoss()
	{
		return client.getVar(Varbits.GAUNTLET_FINAL_ROOM_ENTERED) == 1;
	}

	boolean startedGauntlet()
	{
		return client.getVar(Varbits.GAUNTLET_ENTERED) == 1;
	}

	private void updateConfig()
	{
		this.highlightResources = config.highlightResources();
		this.highlightResourcesColor = config.highlightResourcesColor();
		this.highlightResourcesIcons = config.highlightResourcesIcons();
		this.flashOnWrongAttack = config.flashOnWrongAttack();
		this.highlightWidget = config.highlightWidget();
		this.resourceIconSize = config.resourceIconSize();
		this.projectileIconSize = config.projectileIconSize();
		this.countAttacks = config.countAttacks();
		this.uniquePrayerAudio = config.uniquePrayerAudio();
		this.uniquePrayerVisual = config.uniquePrayerVisual();
		this.uniqueAttackVisual = config.uniqueAttackVisual();
		this.overlayBoss = config.overlayBoss();
		this.overlayBossPrayer = config.overlayBossPrayer();
		this.overlayTornadoes = config.overlayTornadoes();
		this.displayTimerWidget = config.displayTimerWidget();
		this.displayTimerChat = config.displayTimerChat();
		this.attackVisualOutline = config.attackVisualOutline();
		this.highlightPrayerInfobox = config.highlightPrayerInfobox();
	}
}
