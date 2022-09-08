/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
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

package net.runelite.client.plugins.gauntletextended.entity;

import lombok.Getter;
import net.runelite.api.GameObject;
import net.runelite.api.ObjectID;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;

public class Resource
{
	@Getter
	private final GameObject gameObject;

	private final BufferedImage originalIcon;

	private BufferedImage icon;

	private int iconSize;

	public Resource(final GameObject gameObject, final SkillIconManager skillIconManager, final int iconSize)
	{
		this.gameObject = gameObject;
		this.iconSize = iconSize;

		this.originalIcon = getOriginalIcon(skillIconManager, gameObject.getId());
	}

	public void setIconSize(final int iconSize)
	{
		this.iconSize = iconSize;
		icon = ImageUtil.resizeImage(originalIcon, iconSize, iconSize);
	}

	public BufferedImage getIcon()
	{
		if (icon == null)
		{
			icon = ImageUtil.resizeImage(originalIcon, iconSize, iconSize);
		}

		return icon;
	}

	private static BufferedImage getOriginalIcon(final SkillIconManager skillIconManager, final int objectId)
	{
		switch (objectId)
		{
			case ObjectID.CRYSTAL_DEPOSIT:
			case ObjectID.CORRUPT_DEPOSIT:
				return skillIconManager.getSkillImage(Skill.MINING);
			case ObjectID.PHREN_ROOTS:
			case ObjectID.PHREN_ROOTS_36066:
				return skillIconManager.getSkillImage(Skill.WOODCUTTING);
			case ObjectID.FISHING_SPOT_36068:
			case ObjectID.FISHING_SPOT_35971:
				return skillIconManager.getSkillImage(Skill.FISHING);
			case ObjectID.GRYM_ROOT:
			case ObjectID.GRYM_ROOT_36070:
				return skillIconManager.getSkillImage(Skill.HERBLORE);
			case ObjectID.LINUM_TIRINUM:
			case ObjectID.LINUM_TIRINUM_36072:
				return skillIconManager.getSkillImage(Skill.FARMING);
			default:
				throw new IllegalArgumentException("Unsupported gauntlet resource gameobject id: " + objectId);
		}
	}
}
