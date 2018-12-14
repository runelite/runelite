/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
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
package net.runelite.client.plugins.banktags.tabs;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.SpritePixels;
import net.runelite.client.util.ImageUtil;

@Slf4j
public enum TabSprites
{
	INCINERATOR(-200, "incinerator.png"),
	TAB_BACKGROUND(-201, "tag-tab.png"),
	TAB_BACKGROUND_ACTIVE(-202, "tag-tab-active.png"),
	UP_ARROW(-203, "up-arrow.png"),
	DOWN_ARROW(-204, "down-arrow.png"),
	NEW_TAB(-205, "new-tab.png");

	@Getter
	private final int spriteId;
	private final BufferedImage image;

	TabSprites(final int spriteId, final String imageName)
	{
		this.spriteId = spriteId;
		this.image = ImageUtil.getResourceStreamFromClass(this.getClass(), imageName);
	}

	public static Map<Integer, SpritePixels> toMap(Client client)
	{
		final Map<Integer, SpritePixels> map = new HashMap<>();

		for (TabSprites value : values())
		{
			map.put(value.spriteId, getSpritePixels(client, value.image));
		}

		return map;
	}

	private static SpritePixels getSpritePixels(Client client, BufferedImage image)
	{
		int[] pixels = new int[image.getWidth() * image.getHeight()];

		try
		{
			new PixelGrabber(image, 0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth())
				.grabPixels();
		}
		catch (InterruptedException ex)
		{
			log.debug("PixelGrabber was interrupted: ", ex);
		}

		return client.createSpritePixels(pixels, image.getWidth(), image.getHeight());
	}
}
