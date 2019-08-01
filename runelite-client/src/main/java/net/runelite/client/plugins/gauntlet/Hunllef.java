/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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

import java.awt.Color;
import java.awt.image.BufferedImage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;

@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
public class Hunllef
{
	private NPC npc;
	private int bossAttacks;
	private int playerAttacks;
	private int ticksUntilAttack;
	private BufferedImage mage;
	private BufferedImage range;
	private BossAttackPhase currentPhase;

	Hunllef(NPC npc, SkillIconManager skillIconManager)
	{
		this.npc = npc;
		this.bossAttacks = 0;
		this.playerAttacks = 6;
		this.ticksUntilAttack = 0;
		this.mage = skillIconManager.getSkillImage(Skill.MAGIC);
		this.range = skillIconManager.getSkillImage(Skill.RANGED);
		this.currentPhase = BossAttackPhase.UNKNOWN;
	}

	void updatePlayerAttack()
	{
		playerAttacks--;
		if (playerAttacks <= 0)
		{
			playerAttacks = 6;
		}
	}

	void updateAttack(BossAttack style)
	{
		ticksUntilAttack = 6;
		if (style == BossAttack.PRAYER)
		{
			style = BossAttack.MAGIC;
		}

		if (style == BossAttack.LIGHTNING)
		{
			bossAttacks--;
		}
		else if (style == BossAttack.RANGE)
		{
			if (currentPhase != BossAttackPhase.RANGE)
			{
				currentPhase = BossAttackPhase.RANGE;
				bossAttacks = 3;
			}
			else
			{
				bossAttacks--;
			}
		}
		else if (style == BossAttack.MAGIC)
		{
			if (currentPhase != BossAttackPhase.MAGIC)
			{
				currentPhase = BossAttackPhase.MAGIC;
				bossAttacks = 3;
			}
			else
			{
				bossAttacks--;
			}
		}

		if (bossAttacks <= 0)
		{
			BossAttackPhase nextPhase;

			switch (currentPhase)
			{
				case MAGIC:
					bossAttacks = 4;
					nextPhase = BossAttackPhase.RANGE;
					break;
				case RANGE:
					bossAttacks = 4;
					nextPhase = BossAttackPhase.MAGIC;
					break;
				default:
					bossAttacks = 0;
					nextPhase = BossAttackPhase.UNKNOWN;
					break;
			}
			currentPhase = nextPhase;
		}
	}

	@AllArgsConstructor
	@Getter(AccessLevel.PACKAGE)
	enum BossAttackPhase
	{
		MAGIC(Color.CYAN, Prayer.PROTECT_FROM_MAGIC),
		RANGE(Color.GREEN, Prayer.PROTECT_FROM_MISSILES),
		UNKNOWN(Color.WHITE, null);

		private Color color;
		private Prayer prayer;
	}

	enum BossAttack
	{
		MAGIC,
		RANGE,
		PRAYER,
		LIGHTNING
	}
}
