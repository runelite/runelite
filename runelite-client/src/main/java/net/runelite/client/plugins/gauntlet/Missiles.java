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
import lombok.Getter;
import net.runelite.api.Projectile;
import net.runelite.api.ProjectileID;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;

@Getter(AccessLevel.PACKAGE)
class Missiles
{
	private Projectile projectile;
	private int id;
	private BufferedImage image;
	private Color color;

	Missiles(Projectile projectile, SkillIconManager skillIconManager)
	{
		this.projectile = projectile;
		this.id = projectile.getId();
		this.image = assignedImage(skillIconManager, id);
		this.color = assignedColor(id);
	}

	private Color assignedColor(int id)
	{
		switch (id)
		{
			case ProjectileID.HUNLLEF_MAGE_ATTACK:
			case ProjectileID.HUNLLEF_CORRUPTED_MAGE_ATTACK:
				return Color.CYAN;
			case ProjectileID.HUNLLEF_RANGE_ATTACK:
			case ProjectileID.HUNLLEF_CORRUPTED_RANGE_ATTACK:
				return Color.GREEN;
			case ProjectileID.HUNLLEF_PRAYER_ATTACK:
			case ProjectileID.HUNLLEF_CORRUPTED_PRAYER_ATTACK:
				return Color.MAGENTA;
			default:
				return null;
		}
	}

	private BufferedImage assignedImage(SkillIconManager SkillIconManager, int id)
	{
		switch (id)
		{
			case ProjectileID.HUNLLEF_MAGE_ATTACK:
			case ProjectileID.HUNLLEF_CORRUPTED_MAGE_ATTACK:
				return SkillIconManager.getSkillImage(Skill.MAGIC);
			case ProjectileID.HUNLLEF_RANGE_ATTACK:
			case ProjectileID.HUNLLEF_CORRUPTED_RANGE_ATTACK:
				return SkillIconManager.getSkillImage(Skill.RANGED);
			case ProjectileID.HUNLLEF_PRAYER_ATTACK:
			case ProjectileID.HUNLLEF_CORRUPTED_PRAYER_ATTACK:
				return SkillIconManager.getSkillImage(Skill.PRAYER);
			default:
				return null;
		}
	}
}
