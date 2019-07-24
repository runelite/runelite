/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.zulrah.overlays;

import java.awt.image.BufferedImage;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Prayer;
import net.runelite.client.plugins.zulrah.ZulrahPlugin;
import net.runelite.client.plugins.zulrah.phase.ZulrahType;
import net.runelite.client.util.ImageUtil;

@Slf4j
class ZulrahImageManager
{
	private static final BufferedImage[] zulrahBufferedImages = new BufferedImage[3];
	private static final BufferedImage[] smallZulrahBufferedImages = new BufferedImage[3];
	private static final BufferedImage[] prayerBufferedImages = new BufferedImage[2];

	static BufferedImage getZulrahBufferedImage(ZulrahType type)
	{
		switch (type)
		{
			case RANGE:
				if (zulrahBufferedImages[0] == null)
				{
					zulrahBufferedImages[0] = getBufferedImage("zulrah_range.png");
				}
				return zulrahBufferedImages[0];
			case MAGIC:
				if (zulrahBufferedImages[1] == null)
				{
					zulrahBufferedImages[1] = getBufferedImage("zulrah_magic.png");
				}
				return zulrahBufferedImages[1];
			case MELEE:
				if (zulrahBufferedImages[2] == null)
				{
					zulrahBufferedImages[2] = getBufferedImage("zulrah_melee.png");
				}
				return zulrahBufferedImages[2];
		}
		return null;
	}

	static BufferedImage getSmallZulrahBufferedImage(ZulrahType type)
	{
		switch (type)
		{
			case RANGE:
				if (smallZulrahBufferedImages[0] == null)
				{
					smallZulrahBufferedImages[0] = getBufferedImage("zulrah_range.png");
				}
				return smallZulrahBufferedImages[0];
			case MAGIC:
				if (smallZulrahBufferedImages[1] == null)
				{
					smallZulrahBufferedImages[1] = getBufferedImage("zulrah_magic.png");
				}
				return smallZulrahBufferedImages[1];
			case MELEE:
				if (smallZulrahBufferedImages[2] == null)
				{
					smallZulrahBufferedImages[2] = getBufferedImage("zulrah_melee.png");
				}
				return smallZulrahBufferedImages[2];
		}
		return null;
	}

	static BufferedImage getProtectionPrayerBufferedImage(Prayer prayer)
	{
		switch (prayer)
		{
			case PROTECT_FROM_MAGIC:
				if (prayerBufferedImages[0] == null)
				{
					prayerBufferedImages[0] = getBufferedImage("protect_from_magic.png");
				}
				return prayerBufferedImages[0];
			case PROTECT_FROM_MISSILES:
				if (prayerBufferedImages[1] == null)
				{
					prayerBufferedImages[1] = getBufferedImage("protect_from_missiles.png");
				}
				return prayerBufferedImages[1];
		}
		return null;
	}

	private static BufferedImage getBufferedImage(String path)
	{
		return ImageUtil.getResourceStreamFromClass(ZulrahPlugin.class, path);
	}
}
