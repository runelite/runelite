/*
 * Copyright (c) 2018, https://runelitepl.us
 * Copyright (c) 2019, Infinitay <https://github.com/Infinitay>
 *
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
package net.runelite.client.plugins.vorkath;

import com.google.inject.Inject;
import java.awt.image.BufferedImage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Vorkath Helper",
	description = "Count vorkath attacks, and which phase is coming next",
	tags = {"combat", "overlay", "pve", "pvm"},
	type = PluginType.PVM,
	enabledByDefault = false
)
@Slf4j
public class VorkathPlugin extends Plugin
{
	private static final int VORKATH_REGION = 9023;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private VorkathOverlay overlay;

	@Inject
	private ZombifiedSpawnOverlay SpawnOverlay;

	@Getter
	private Vorkath vorkath;

	@Getter
	private NPC zombifiedSpawn;

	/**
	 * The last projectile's starting movement cycle
	 */
	private int lastProjectileCycle;

	static final BufferedImage UNKNOWN;
	static final BufferedImage ACID;
	static final BufferedImage FIRE_BALL;
	static final BufferedImage SPAWN;

	static
	{
		UNKNOWN = ImageUtil.getResourceStreamFromClass(VorkathPlugin.class, "magerange.png");
		ACID = ImageUtil.getResourceStreamFromClass(VorkathPlugin.class, "acid.png");
		FIRE_BALL = ImageUtil.getResourceStreamFromClass(VorkathPlugin.class, "fire_strike.png");
		SPAWN = ImageUtil.getResourceStreamFromClass(VorkathPlugin.class, "ice.png");
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (isAtVorkath())
		{
			if (isVorkath(event.getNpc().getId()))
			{
				vorkath = new Vorkath(event.getNpc());
				lastProjectileCycle = -1;
				overlayManager.add(overlay);
			}
			else if (isZombifiedSpawn(event.getNpc().getId()))
			{
				zombifiedSpawn = event.getNpc();
				overlayManager.add(SpawnOverlay);
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (isAtVorkath())
		{
			if (isVorkath(event.getNpc().getId()))
			{
				vorkath = null;
				lastProjectileCycle = -1;
				overlayManager.remove(overlay);
			}
			else if (isZombifiedSpawn(event.getNpc().getId()))
			{
				zombifiedSpawn = null;
				overlayManager.remove(SpawnOverlay);
			}
		}
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		// Only capture initial projectile
		if (!isAtVorkath() || event.getProjectile().getStartMovementCycle() == lastProjectileCycle)
		{
			return;
		}

		VorkathAttack vorkathAttack = VorkathAttack.getVorkathAttack(event.getProjectile().getId());
		if (vorkathAttack != null)
		{
			/*log.debug("[Projectile ({})] Game Tick: {}, Game Cycle: {}, Starting Cyle: {} Last Cycle: {}, Initial Projectile?: {}",
				vorkathAttack, client.getTickCount(), client.getGameCycle(), event.getProjectile().getStartMovementCycle(),
				lastProjectileCycle, event.getProjectile().getStartMovementCycle() == client.getGameCycle());*/
			if (VorkathAttack.isBasicAttack(vorkathAttack.getProjectileID()) && vorkath.getAttacksLeft() > 0)
			{
				vorkath.setAttacksLeft(vorkath.getAttacksLeft() - 1);
			}
			else if (vorkathAttack == VorkathAttack.ACID)
			{
				vorkath.updatePhase(Vorkath.Phase.ACID);
				// Sets the phase's progress indicator to done
				vorkath.setAttacksLeft(0);
			}
			else if (vorkathAttack == VorkathAttack.FIRE_BALL)
			{
				vorkath.updatePhase(Vorkath.Phase.FIRE_BALL);
				// Decrement to account for this fire ball
				vorkath.setAttacksLeft(vorkath.getAttacksLeft() - 1);
			}
			else if (vorkathAttack == VorkathAttack.FREEZE_BREATH && vorkath.getLastAttack() != VorkathAttack.ZOMBIFIED_SPAWN)
			{
				// Filters out second invisible freeze attack that is immediately after the Zombified Spawn
				vorkath.updatePhase(Vorkath.Phase.SPAWN);
				// Sets progress of the phase to half
				vorkath.setAttacksLeft(vorkath.getAttacksLeft() - (vorkath.getAttacksLeft() / 2));
			}
			else if (vorkathAttack == VorkathAttack.ZOMBIFIED_SPAWN || (vorkath.getLastAttack() == VorkathAttack.ZOMBIFIED_SPAWN))
			{
				// Also consumes the second invisible freeze attack that is immediately after the Zombified Spawn
				// Sets progress of the phase to done as there are no more attacks within this phase
				vorkath.setAttacksLeft(0);
			}
			else
			{
				// Vorkath fired a basic attack AND there are no more attacks left, typically after phases are over
				vorkath.updatePhase(vorkath.getNextPhase());
				// Decrement to account for this basic attack
				vorkath.setAttacksLeft(vorkath.getAttacksLeft() - 1);
			}

			log.debug("[Vorkath ({})] {}", vorkathAttack, vorkath);
			vorkath.setLastAttack(vorkathAttack);
			lastProjectileCycle = event.getProjectile().getStartMovementCycle();
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		if (isAtVorkath() && vorkath != null && event.getActor().equals(vorkath.getVorkath())
			&& event.getActor().getAnimation() == VorkathAttack.SLASH_ATTACK.getVorkathAnimationID())
		{
			if (vorkath.getAttacksLeft() > 0)
			{
				vorkath.setAttacksLeft(vorkath.getAttacksLeft() - 1);
			}
			else
			{
				// No more attacks left, typically after phases are over
				vorkath.updatePhase(vorkath.getNextPhase());
				// Decrement to account for this basic attack
				vorkath.setAttacksLeft(vorkath.getAttacksLeft() - 1);
			}
			log.debug("[Vorkath (SLASH_ATTACK)] {}", vorkath);
		}
	}

	/**
	 * @return true if the player is in the Vorkath region, false otherwise
	 */
	private boolean isAtVorkath()
	{
		return ArrayUtils.contains(client.getMapRegions(), VORKATH_REGION);
	}

	/**
	 * @param npcID
	 * @return true if the npc is Vorkath, false otherwise
	 */
	private boolean isVorkath(int npcID)
	{
		// Could be done with a a simple name check instead...
		return npcID == NpcID.VORKATH ||
			npcID == NpcID.VORKATH_8058 ||
			npcID == NpcID.VORKATH_8059 ||
			npcID == NpcID.VORKATH_8060 ||
			npcID == NpcID.VORKATH_8061;
	}

	/**
	 * @param npcID
	 * @return true if the npc is a Zombified Spawn, otherwise false
	 */
	private boolean isZombifiedSpawn(int npcID)
	{
		// Could be done with a a simple name check instead...
		return npcID == NpcID.ZOMBIFIED_SPAWN ||
			npcID == NpcID.ZOMBIFIED_SPAWN_8063;
	}
}
