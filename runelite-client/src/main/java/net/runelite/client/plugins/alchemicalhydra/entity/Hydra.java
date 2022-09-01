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
package net.runelite.client.plugins.alchemicalhydra.entity;

import java.awt.image.BufferedImage;
import javax.annotation.Nullable;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.api.ProjectileID;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.alchemicalhydra.overlay.AttackOverlay;
import net.runelite.client.util.ImageUtil;

@Getter
@RequiredArgsConstructor
@Singleton
public class Hydra
{
	private static final int MAX_HP = 1100;

	@Nullable
	private final NPC npc;

	private HydraPhase phase = HydraPhase.POISON;

	private AttackStyle nextAttack = AttackStyle.MAGIC;

	private AttackStyle lastAttack = AttackStyle.MAGIC;

	@Setter
	private boolean immunity = true;

	private int nextSpecial = 3;

	private int attackCount;

	private int nextSwitch = phase.getAttacksPerSwitch();

	public void setNextSpecial()
	{
		nextSpecial += 9;
	}

	public int getNextSpecialRelative()
	{
		return nextSpecial - attackCount;
	}

	public void changePhase(final HydraPhase hydraPhase)
	{
		phase = hydraPhase;
		nextSpecial = 3;
		attackCount = 0;
		immunity = true;

		if (hydraPhase == HydraPhase.ENRAGED)
		{
			immunity = false;
			switchStyles();
			nextSwitch = phase.getAttacksPerSwitch();
		}
	}

	public void handleProjectile(final int projectileId)
	{
		if (projectileId != nextAttack.getProjectileID())
		{
			if (projectileId == lastAttack.getProjectileID())
			{
				// If the current attack isn't what was expected and we accidentally counted 1 too much
				return;
			}

			// If the current attack isn't what was expected and we should have switched prayers
			switchStyles();

			nextSwitch = phase.getAttacksPerSwitch() - 1;
		}
		else
		{
			nextSwitch--;
		}

		lastAttack = nextAttack;
		attackCount++;

		if (nextSwitch <= 0)
		{
			switchStyles();
			nextSwitch = phase.getAttacksPerSwitch();
		}
	}

	public int getHpUntilPhaseChange()
	{
		return Math.max(0, getHp() - phase.getHpThreshold());
	}

	private void switchStyles()
	{
		nextAttack = lastAttack == Hydra.AttackStyle.MAGIC
			? Hydra.AttackStyle.RANGED
			: Hydra.AttackStyle.MAGIC;
	}

	private int getHp()
	{
		final int ratio = npc.getHealthRatio();
		final int health = npc.getHealthScale();

		if (ratio < 0 || health <= 0)
		{
			return -1;
		}

		int exactHealth = 0;

		if (ratio > 0)
		{
			int minHealth = 1;
			int maxHealth;

			if (health > 1)
			{
				if (ratio > 1)
				{
					minHealth = (MAX_HP * (ratio - 1) + health - 2) / (health - 1);
				}

				maxHealth = (MAX_HP * ratio - 1) / (health - 1);

				if (maxHealth > MAX_HP)
				{
					maxHealth = MAX_HP;
				}
			}
			else
			{
				maxHealth = MAX_HP;
			}

			exactHealth = (minHealth + maxHealth + 1) / 2;
		}

		return exactHealth;
	}

	@Getter
	@RequiredArgsConstructor
	public enum AttackStyle
	{
		MAGIC(ProjectileID.HYDRA_MAGIC, Prayer.PROTECT_FROM_MAGIC, SpriteID.PRAYER_PROTECT_FROM_MAGIC),
		RANGED(ProjectileID.HYDRA_RANGED, Prayer.PROTECT_FROM_MISSILES, SpriteID.PRAYER_PROTECT_FROM_MISSILES);

		private final int projectileID;
		private final Prayer prayer;
		private final int spriteID;

		@Getter(AccessLevel.NONE)
		private BufferedImage image;

		public BufferedImage getImage(final SpriteManager spriteManager)
		{
			if (image == null)
			{
				final BufferedImage tmp = spriteManager.getSprite(spriteID, 0);
				image = tmp == null ? null : ImageUtil.resizeImage(tmp, AttackOverlay.IMAGE_SIZE, AttackOverlay.IMAGE_SIZE);
			}

			return image;
		}
	}
}
