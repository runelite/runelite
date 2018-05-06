/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
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
package net.runelite.client.plugins.attackstyles;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;

@Getter
@Slf4j
public enum AttackStyle
{
	ACCURATE("Accurate", SpriteID.SKILL_ATTACK, Skill.ATTACK),
	AGGRESSIVE("Aggressive", SpriteID.SKILL_STRENGTH, Skill.STRENGTH),
	DEFENSIVE("Defensive", SpriteID.SKILL_DEFENCE, Skill.DEFENCE),
	CONTROLLED("Controlled", SpriteID.SKILL_DEFENCE_SQUASHED, Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE),
	RANGING("Ranging", SpriteID.SKILL_RANGED, Skill.RANGED),
	LONGRANGE("Longrange", SpriteID.SKILL_DEFENCE_SQUASHED, Skill.RANGED, Skill.DEFENCE),
	CASTING("Casting", SpriteID.SKILL_MAGIC, Skill.MAGIC),
	DEFENSIVE_CASTING("Defensive Casting", SpriteID.SKILL_DEFENCE_SQUASHED, Skill.MAGIC, Skill.DEFENCE),
	OTHER("Other", SpriteID.SKILL_DEFENCE_SQUASHED);

	private final String name;
	private final int spriteID;
	private final Skill[] skills;

	AttackStyle(String name, int spriteID, Skill... skills)
	{
		this.name = name;
		this.spriteID = spriteID;
		this.skills = skills;
	}

	public BufferedImage getImage()
	{
		switch (name)
		{
			case "Controlled":
			case "Longrange":
			case "Defensive Casting":
			case "Other":
				return getImageFile("defensive.png");
			default:
				return getImageFile(getName() + ".png");
		}
	}

	private BufferedImage getImageFile(String fileName)
	{
		try
		{
			synchronized (ImageIO.class)
			{
				BufferedImage bufferedImageSource = ImageIO.read(this.getClass().getResourceAsStream(fileName));

				if (bufferedImageSource != null)
				{
					return bufferedImageSource;
				}
			}
		}
		catch (IOException e)
		{
			log.warn("unable to load image", e);
		}
		return new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);
	}
}