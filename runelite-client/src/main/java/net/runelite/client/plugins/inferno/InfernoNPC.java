/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.inferno;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Prayer;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import org.apache.commons.lang3.ArrayUtils;

class InfernoNPC
{
	@Getter(AccessLevel.PACKAGE)
	private NPC npc;
	@Getter(AccessLevel.PACKAGE)
	private Type type;
	@Getter(AccessLevel.PACKAGE)
	private Attack nextAttack;
	@Getter(AccessLevel.PACKAGE)
	private int ticksTillNextAttack;
	private int lastAnimation;
	private boolean lastCanAttack;
	//0 = not in LOS, 1 = in LOS after move, 2 = in LOS
	private final Map<WorldPoint, Integer> safeSpotCache;

	InfernoNPC(NPC npc)
	{
		this.npc = npc;
		this.type = Type.typeFromId(npc.getId());
		this.nextAttack = type.getDefaultAttack();
		this.ticksTillNextAttack = 0;
		this.lastAnimation = -1;
		this.lastCanAttack = false;
		this.safeSpotCache = new HashMap<>();
	}

	void updateNextAttack(Attack nextAttack, int ticksTillNextAttack)
	{
		this.nextAttack = nextAttack;
		this.ticksTillNextAttack = ticksTillNextAttack;
	}

	private void updateNextAttack(Attack nextAttack)
	{
		this.nextAttack = nextAttack;
	}

	boolean canAttack(Client client, WorldPoint target)
	{
		if (safeSpotCache.containsKey(target))
		{
			return safeSpotCache.get(target) == 2;
		}

		boolean hasLos = new WorldArea(target, 1, 1).hasLineOfSightTo(client, this.getNpc().getWorldArea());
		boolean hasRange = this.getType().getDefaultAttack() == Attack.MELEE ? this.getNpc().getWorldArea().isInMeleeDistance(target)
			: this.getNpc().getWorldArea().distanceTo(target) <= this.getType().getRange();

		if (hasLos && hasRange)
		{
			safeSpotCache.put(target, 2);
		}

		return hasLos && hasRange;
	}

	boolean canMoveToAttack(Client client, WorldPoint target, List<WorldPoint> obstacles)
	{
		if (safeSpotCache.containsKey(target))
		{
			return safeSpotCache.get(target) == 1 || safeSpotCache.get(target) == 2;
		}

		final List<WorldPoint> realObstacles = new ArrayList<>();
		for (WorldPoint obstacle : obstacles)
		{
			if (this.getNpc().getWorldArea().toWorldPointList().contains(obstacle))
			{
				continue;
			}

			realObstacles.add(obstacle);
		}

		final WorldArea targetArea = new WorldArea(target, 1, 1);
		WorldArea currentWorldArea = this.getNpc().getWorldArea();

		int steps = 0;
		while (true)
		{
			// Prevent infinite loop in case of pathfinding failure
			steps++;
			if (steps > 30)
			{
				return false;
			}

			final WorldArea predictedWorldArea = currentWorldArea.calculateNextTravellingPoint(client, targetArea, true, x ->
			{
				for (WorldPoint obstacle : realObstacles)
				{
					if (new WorldArea(x, 1, 1).intersectsWith(new WorldArea(obstacle, 1, 1)))
					{
						return false;
					}
				}
				return true;
			});

			// Will only happen when NPC is underneath player or moving out of scene (but this will never show on overlay)
			if (predictedWorldArea == null)
			{
				safeSpotCache.put(target, 1);
				return true;
			}

			if (predictedWorldArea == currentWorldArea)
			{
				safeSpotCache.put(target, 0);
				return false;
			}

			boolean hasLos = new WorldArea(target, 1, 1).hasLineOfSightTo(client, predictedWorldArea);
			boolean hasRange = this.getType().getDefaultAttack() == Attack.MELEE ? predictedWorldArea.isInMeleeDistance(target)
				: predictedWorldArea.distanceTo(target) <= this.getType().getRange();

			if (hasLos && hasRange)
			{
				safeSpotCache.put(target, 1);
				return true;
			}

			currentWorldArea = predictedWorldArea;
		}
	}

	private boolean couldAttackPrevTick(Client client, WorldPoint lastPlayerLocation)
	{
		return new WorldArea(lastPlayerLocation, 1, 1).hasLineOfSightTo(client, this.getNpc().getWorldArea());
	}

	void gameTick(Client client, WorldPoint lastPlayerLocation, boolean finalPhase)
	{
		safeSpotCache.clear();

		if (ticksTillNextAttack > 0)
		{
			this.ticksTillNextAttack--;
		}

		//Jad animation detection
		if (this.getType() == Type.JAD && this.getNpc().getAnimation() != -1 && this.getNpc().getAnimation() != this.lastAnimation)
		{
			final InfernoNPC.Attack currentAttack = InfernoNPC.Attack.attackFromId(this.getNpc().getAnimation());

			if (currentAttack != null && currentAttack != Attack.UNKNOWN)
			{
				this.updateNextAttack(currentAttack, this.getType().getTicksAfterAnimation());
			}
		}

		if (ticksTillNextAttack <= 0)
		{
			switch (this.getType())
			{
				case ZUK:
					if (this.getNpc().getAnimation() == AnimationID.TZKAL_ZUK)
					{
						if (finalPhase)
						{
							this.updateNextAttack(this.getType().getDefaultAttack(), 7);
						}
						else
						{
							this.updateNextAttack(this.getType().getDefaultAttack(), 10);
						}
					}
					break;
				case JAD:
					if (this.getNextAttack() != Attack.UNKNOWN)
					{
						// Jad's cycle continuous after his animation + attack but there's no animation to alert it
						this.updateNextAttack(this.getType().getDefaultAttack(), 8);
					}
					break;
				case BLOB:
					//RS pathfinding + LOS = hell, so if it can attack you the tick you were on previously, start attack cycle
					if (!this.lastCanAttack && this.couldAttackPrevTick(client, lastPlayerLocation))
					{
						this.updateNextAttack(Attack.UNKNOWN, 3);
					}
					//If there's no animation when coming out of the safespot, the blob is detecting prayer
					else if (!this.lastCanAttack && this.canAttack(client, client.getLocalPlayer().getWorldLocation()))
					{
						this.updateNextAttack(Attack.UNKNOWN, 4);
					}
					//This will activate another attack cycle
					else if (this.getNpc().getAnimation() != -1)
					{
						this.updateNextAttack(this.getType().getDefaultAttack(), this.getType().getTicksAfterAnimation());
					}
					break;
				case BAT:
					// Range + LOS check for bat because it suffers from the defense animation bug, also dont activate on "stand" animation
					if (this.canAttack(client, client.getLocalPlayer().getWorldLocation())
						&& this.getNpc().getAnimation() != AnimationID.JAL_MEJRAH_STAND && this.getNpc().getAnimation() != -1)
					{
						this.updateNextAttack(this.getType().getDefaultAttack(), this.getType().getTicksAfterAnimation());
					}
					break;
				case MELEE:
				case RANGER:
				case MAGE:
					// For the meleer, ranger and mage the attack animation is always prioritized so only check for those
					// Normal attack animation, doesnt suffer from defense animation bug. Activate usual attack cycle
					if (this.getNpc().getAnimation() == AnimationID.JAL_IMKOT
						|| this.getNpc().getAnimation() == AnimationID.JAL_XIL_RANGE_ATTACK || this.getNpc().getAnimation() == AnimationID.JAL_XIL_MELEE_ATTACK
						|| this.getNpc().getAnimation() == AnimationID.JAL_ZEK_MAGE_ATTACK || this.getNpc().getAnimation() == AnimationID.JAL_ZEK_MELEE_ATTACK)
					{
						this.updateNextAttack(this.getType().getDefaultAttack(), this.getType().getTicksAfterAnimation());
					}
					// Burrow into ground animation for meleer
					else if (this.getNpc().getAnimation() == 7600)
					{
						this.updateNextAttack(this.getType().getDefaultAttack(), 12);
					}
					// Respawn enemy animation for mage
					else if (this.getNpc().getAnimation() == 7611)
					{
						this.updateNextAttack(this.getType().getDefaultAttack(), 8);
					}
					break;
				default:
					if (this.getNpc().getAnimation() != -1)
					{
						// This will activate another attack cycle
						this.updateNextAttack(this.getType().getDefaultAttack(), this.getType().getTicksAfterAnimation());
					}
					break;
			}
		}

		//Blob prayer detection
		if (this.getType() == Type.BLOB && this.getTicksTillNextAttack() == 3
			&& client.getLocalPlayer().getWorldLocation().distanceTo(this.getNpc().getWorldArea()) <= Type.BLOB.getRange())
		{
			InfernoNPC.Attack nextBlobAttack = InfernoNPC.Attack.UNKNOWN;
			if (client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES))
			{
				nextBlobAttack = InfernoNPC.Attack.MAGIC;
			}
			else if (client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC))
			{
				nextBlobAttack = InfernoNPC.Attack.RANGED;
			}

			this.updateNextAttack(nextBlobAttack);
		}

		// This is for jad (jad's animation lasts till after the attack is launched, which fucks up the attack cycle)
		lastAnimation = this.getNpc().getAnimation();
		// This is for blob (to check if player just came out of safespot)
		lastCanAttack = this.canAttack(client, client.getLocalPlayer().getWorldLocation());
	}

	@Getter(AccessLevel.PACKAGE)
	enum Attack
	{
		MELEE(Prayer.PROTECT_FROM_MELEE,
			Color.ORANGE,
			Color.RED,
			new int[]{
				AnimationID.JAL_NIB,
				AnimationID.JAL_AK_MELEE_ATTACK,
				AnimationID.JAL_IMKOT,
				AnimationID.JAL_XIL_MELEE_ATTACK,
				AnimationID.JAL_ZEK_MELEE_ATTACK, //TODO: Yt-HurKot attack animation
			}),
		RANGED(Prayer.PROTECT_FROM_MISSILES,
			Color.GREEN,
			new Color(0, 128, 0),
			new int[]{
				AnimationID.JAL_MEJRAH,
				AnimationID.JAL_AK_RANGE_ATTACK,
				AnimationID.JAL_XIL_RANGE_ATTACK,
				AnimationID.JALTOK_JAD_RANGE_ATTACK,
			}),
		MAGIC(Prayer.PROTECT_FROM_MAGIC,
			Color.CYAN,
			Color.BLUE,
			new int[]{
				AnimationID.JAL_AK_MAGIC_ATTACK,
				AnimationID.JAL_ZEK_MAGE_ATTACK,
				AnimationID.JALTOK_JAD_MAGE_ATTACK
			}),
		UNKNOWN(null, Color.WHITE, Color.GRAY, new int[]{});

		private final Prayer prayer;
		private final Color normalColor;
		private final Color criticalColor;
		private final int[] animationIds;

		Attack(Prayer prayer, Color normalColor, Color criticalColor, int[] animationIds)
		{
			this.prayer = prayer;
			this.normalColor = normalColor;
			this.criticalColor = criticalColor;
			this.animationIds = animationIds;
		}

		static Attack attackFromId(int animationId)
		{
			for (Attack attack : Attack.values())
			{
				if (ArrayUtils.contains(attack.getAnimationIds(), animationId))
				{
					return attack;
				}
			}

			return null;
		}
	}

	@Getter(AccessLevel.PACKAGE)
	enum Type
	{
		NIBBLER(new int[]{NpcID.JALNIB}, Attack.MELEE, 4, 99, 100),
		BAT(new int[]{NpcID.JALMEJRAH}, Attack.RANGED, 3, 4, 7),
		BLOB(new int[]{NpcID.JALAK}, Attack.UNKNOWN, 6, 15, 4),
		MELEE(new int[]{NpcID.JALIMKOT}, Attack.MELEE, 4, 1, 3),
		RANGER(new int[]{NpcID.JALXIL, NpcID.JALXIL_7702}, Attack.RANGED, 4, 98, 2),
		MAGE(new int[]{NpcID.JALZEK, NpcID.JALZEK_7703}, Attack.MAGIC, 4, 98, 1),
		JAD(new int[]{NpcID.JALTOKJAD, NpcID.JALTOKJAD_7704}, Attack.UNKNOWN, 3, 99, 0),
		HEALER_JAD(new int[]{NpcID.YTHURKOT, NpcID.YTHURKOT_7701, NpcID.YTHURKOT_7705}, Attack.MELEE, 4, 1, 6),
		ZUK(new int[]{NpcID.TZKALZUK}, Attack.UNKNOWN, 10, 99, 99),
		HEALER_ZUK(new int[]{NpcID.JALMEJJAK}, Attack.UNKNOWN, -1, 99, 100);

		private final int[] npcIds;
		private final Attack defaultAttack;
		private final int ticksAfterAnimation;
		private final int range;
		private final int priority;

		Type(int[] npcIds, Attack defaultAttack, int ticksAfterAnimation, int range, int priority)
		{
			this.npcIds = npcIds;
			this.defaultAttack = defaultAttack;
			this.ticksAfterAnimation = ticksAfterAnimation;
			this.range = range;
			this.priority = priority;
		}

		static Type typeFromId(int npcId)
		{
			for (Type type : Type.values())
			{
				if (ArrayUtils.contains(type.getNpcIds(), npcId))
				{
					return type;
				}
			}

			return null;
		}
	}
}

