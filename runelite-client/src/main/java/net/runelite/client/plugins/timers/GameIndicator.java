/*
 * Copyright (c) 2018, Tyler <https://github.com/tylerthardy>
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
package net.runelite.client.plugins.timers;

import java.awt.Color;
import java.awt.image.BufferedImage;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.SpriteID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;

enum GameIndicator
{
	VENGEANCE_ACTIVE(SpriteID.SPELL_VENGEANCE_OTHER, GameTimerImageType.SPRITE, "Vengeance active");

	@Getter(AccessLevel.PACKAGE)
	private final String description;
	@Getter(AccessLevel.PACKAGE)
	private String text;
	@Getter(AccessLevel.PACKAGE)
	private Color textColor;
	private final int imageId;
	private final GameTimerImageType imageType;

	GameIndicator(int imageId, GameTimerImageType idType, String description, String text, Color textColor)
	{
		this.imageId = imageId;
		this.imageType = idType;
		this.description = description;
		this.text = text;
		this.textColor = textColor;
	}

	GameIndicator(int imageId, GameTimerImageType idType, String description)
	{
		this(imageId, idType, description, "", null);
	}

	BufferedImage getImage(ItemManager itemManager, SpriteManager spriteManager)
	{
		switch (imageType)
		{
			case ITEM:
				return itemManager.getImage(imageId);
			case SPRITE:
				return spriteManager.getSprite(imageId, 0);
			default:
				return null;
		}
	}
}
