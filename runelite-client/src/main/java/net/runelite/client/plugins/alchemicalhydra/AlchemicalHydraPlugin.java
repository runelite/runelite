/*
 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
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
package net.runelite.client.plugins.alchemicalhydra;

import com.google.inject.Provides;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.DynamicObject;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.ObjectID;
import net.runelite.api.Projectile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.alchemicalhydra.entity.Hydra;
import net.runelite.client.plugins.alchemicalhydra.entity.Hydra.AttackStyle;
import net.runelite.client.plugins.alchemicalhydra.entity.HydraPhase;
import net.runelite.client.plugins.alchemicalhydra.overlay.AttackOverlay;
import net.runelite.client.plugins.alchemicalhydra.overlay.PrayerOverlay;
import net.runelite.client.plugins.alchemicalhydra.overlay.SceneOverlay;
import net.runelite.client.ui.overlay.OverlayManager;

@Singleton
@PluginDescriptor(
	name = "Alchemical Hydra",
	enabledByDefault = false,
	description = "A plugin for the Alchemical Hydra boss.",
	tags = {"alchemical", "hydra"}
)
public class AlchemicalHydraPlugin extends Plugin
{
	private static final String MESSAGE_NEUTRALIZE = "The chemicals neutralise the Alchemical Hydra's defences!";
	private static final String MESSAGE_STUN = "The Alchemical Hydra temporarily stuns you.";

	private static final int[] HYDRA_REGIONS = {5279, 5280, 5535, 5536};

	@Inject
	private Client client;
	
	@Getter
	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private AttackOverlay attackOverlay;

	@Inject
	private SceneOverlay sceneOverlay;

	@Inject
	private PrayerOverlay prayerOverlay;

	private boolean atHydra;

	@Getter
	private Hydra hydra;

	public static final int HYDRA_1_1 = 8237;
	public static final int HYDRA_1_2 = 8238;
	public static final int HYDRA_LIGHTNING = 8241;
	public static final int HYDRA_2_1 = 8244;
	public static final int HYDRA_2_2 = 8245;
	public static final int HYDRA_FIRE = 8248;
	public static final int HYDRA_3_1 = 8251;
	public static final int HYDRA_3_2 = 8252;
	public static final int HYDRA_4_1 = 8257;
	public static final int HYDRA_4_2 = 8258;

	@Getter
	int fountainTicks = -1;
	int lastFountainAnim = -1;

	@Getter
	private final Map<LocalPoint, Projectile> poisonProjectiles = new HashMap<>();

	private int lastAttackTick = -1;

	@Getter
	private final Set<GameObject> vents = new HashSet<>();

	@Provides
	AlchemicalHydraConfig provideConfig(final ConfigManager configManager)
	{
		return configManager.getConfig(AlchemicalHydraConfig.class);
	}

	@Override
	protected void startUp()
	{
		if (client.getGameState() == GameState.LOGGED_IN && isInHydraRegion())
		{
			init();
		}
	}

	private void init()
	{
		atHydra = true;

		addOverlays();

		for (final NPC npc : client.getNpcs())
		{
			onNpcSpawned(new NpcSpawned(npc));
		}
	}

	@Override
	protected void shutDown()
	{
		atHydra = false;

		removeOverlays();

		hydra = null;
		poisonProjectiles.clear();
		lastAttackTick = -1;
		fountainTicks = -1;
		vents.clear();
		lastFountainAnim = -1;
	}

	@Subscribe
	private void onGameStateChanged(final GameStateChanged event)
	{
		final GameState gameState = event.getGameState();

		switch (gameState)
		{
			case LOGGED_IN:
				if (isInHydraRegion())
				{
					if (!atHydra)
					{
						init();
					}
				}
				else
				{
					if (atHydra)
					{
						shutDown();
					}
				}
				break;
			case HOPPING:
			case LOGIN_SCREEN:
				if (atHydra)
				{
					shutDown();
				}
			default:
				break;
		}
	}

	@Subscribe
	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (!isInHydraRegion())
		{
			return;
		}
		GameObject gameobject = event.getGameObject();
		int id = gameobject.getId();
		if (id == ObjectID.CHEMICAL_VENT_RED || id == ObjectID.CHEMICAL_VENT_GREEN || id == ObjectID.CHEMICAL_VENT_BLUE)
		{
			vents.add(gameobject);
		}
	}

	@Subscribe
	private void onGameObjectDespawned(GameObjectDespawned event)
	{
		GameObject gameobject = event.getGameObject();
		vents.remove(gameobject);
	}


	@Subscribe
	private void onGameTick(final GameTick event)
	{
		attackOverlay.decrementStunTicks();
		updateVentTicks();
	}

	private void updateVentTicks()
	{
		if (fountainTicks > 0)
		{
			fountainTicks--;
			if (fountainTicks == 0)
			{
				fountainTicks = 8;
			}
		}

		if (!vents.isEmpty())
		{
			for (final GameObject vent : vents)
			{
				int animation = getAnimation(vent);
				if (animation == 8279 && lastFountainAnim == 8280)
				{
					fountainTicks = 2;
				}
				lastFountainAnim = animation;
				break; // all vents trigger at same time so dont bother going through them all
			}
		}

	}

	int getAnimation(GameObject gameObject)
	{
		final DynamicObject dynamicObject = (DynamicObject) gameObject.getRenderable();
		return dynamicObject.getAnimationID();
	}

	@Subscribe
	private void onNpcSpawned(final NpcSpawned event)
	{
		final NPC npc = event.getNpc();

		if (npc.getId() == NpcID.ALCHEMICAL_HYDRA)
		{
			hydra = new Hydra(npc);
			if (client.isInInstancedRegion() && fountainTicks == -1) //handles the initial hydra spawn when your in the lobby but havent gone through the main doors
			{
				fountainTicks = 11;
			}
		}
	}

	@Subscribe
	private void onAnimationChanged(final AnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (hydra == null || actor != hydra.getNpc())
		{
			return;
		}

		final HydraPhase phase = hydra.getPhase();

		final int animationId = actor.getAnimation();

		if ((animationId == phase.getDeathAnimation2() && phase != HydraPhase.FLAME)
			|| (animationId == phase.getDeathAnimation1() && phase == HydraPhase.FLAME))
		{
			switch (phase)
			{
				case POISON:
					hydra.changePhase(HydraPhase.LIGHTNING);
					break;
				case LIGHTNING:
					hydra.changePhase(HydraPhase.FLAME);
					break;
				case FLAME:
					hydra.changePhase(HydraPhase.ENRAGED);
					break;
				case ENRAGED:
					// NpcDespawned event does not fire for Hydra inbetween kills; must use death animation.
					hydra = null;

					if (!poisonProjectiles.isEmpty())
					{
						poisonProjectiles.clear();
					}
					break;
			}

			return;
		}
		else if (animationId == phase.getSpecialAnimationId() && phase.getSpecialAnimationId() != 0)
		{
			hydra.setNextSpecial();
		}

		if (!poisonProjectiles.isEmpty())
		{
			poisonProjectiles.values().removeIf(p -> p.getEndCycle() < client.getGameCycle());
		}
	}


	@Subscribe
	private void onProjectileMoved(final ProjectileMoved event)
	{
		final Projectile projectile = event.getProjectile();

		if (hydra == null || client.getGameCycle() >= projectile.getStartCycle())
		{
			return;
		}

		final int projectileId = projectile.getId();

		if (hydra.getPhase().getSpecialProjectileId() == projectileId)
		{
			if (hydra.getAttackCount() >= hydra.getNextSpecial())
			{
				hydra.setNextSpecial();
			}

			poisonProjectiles.put(event.getPosition(), projectile);
		}
		else if (client.getTickCount() != lastAttackTick
			&& (projectileId == AttackStyle.MAGIC.getProjectileID() || projectileId == AttackStyle.RANGED.getProjectileID()))
		{
			hydra.handleProjectile(projectileId);

			lastAttackTick = client.getTickCount();
		}
	}

	@Subscribe
	private void onChatMessage(final ChatMessage event)
	{
		final ChatMessageType chatMessageType = event.getType();

		if (chatMessageType != ChatMessageType.SPAM && chatMessageType != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		final String message = event.getMessage();

		if (message.equals(MESSAGE_NEUTRALIZE))
		{
			clientThread.invokeLater(() ->
			{
				hydra.setImmunity(false);
			});
		}
		else if (message.equals(MESSAGE_STUN))
		{
			attackOverlay.setStunTicks();
		}
	}

	private void addOverlays()
	{
		overlayManager.add(sceneOverlay);
		overlayManager.add(attackOverlay);
		overlayManager.add(prayerOverlay);
	}

	private void removeOverlays()
	{
		overlayManager.remove(sceneOverlay);
		overlayManager.remove(attackOverlay);
		overlayManager.remove(prayerOverlay);
	}

	private boolean isInHydraRegion()
	{
		return client.isInInstancedRegion() && Arrays.equals(client.getMapRegions(), HYDRA_REGIONS);
	}
}
