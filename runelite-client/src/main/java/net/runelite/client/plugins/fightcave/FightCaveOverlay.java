/*
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
package net.runelite.client.plugins.fightcave;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ImagePanelComponent;

import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class FightCaveOverlay extends Overlay
{
	private final Client client;
	private final FightCavePlugin plugin;

	private BufferedImage protectFromMagicImg;
	private BufferedImage protectFromMissilesImg;

	@Inject
	FightCaveOverlay(@Nullable Client client, FightCavePlugin plugin)
	{
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setPriority(OverlayPriority.HIGH);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		JadAttack attack = plugin.getAttack();
		if (attack == null || client.isPrayerActive(attack.getPrayer()))
		{
			return null;
		}
		BufferedImage prayerImage = getPrayerImage(attack);
		ImagePanelComponent imagePanelComponent = new ImagePanelComponent();
		imagePanelComponent.setTitle("Switch!");
		imagePanelComponent.setImage(prayerImage);
		return imagePanelComponent.render(graphics, parent);
	}

	private BufferedImage getPrayerImage(JadAttack attack)
	{
		return attack == JadAttack.MAGIC ? getProtectFromMagicImage() : getProtectFromMissilesImage();
	}

	private BufferedImage getProtectFromMagicImage()
	{
		if (protectFromMagicImg == null)
		{
			String path = "/prayers/protect_from_magic.png";
			protectFromMagicImg = getImage(path);
		}
		return protectFromMagicImg;
	}

	private BufferedImage getProtectFromMissilesImage()
	{
		if (protectFromMissilesImg == null)
		{
			String path = "/prayers/protect_from_missiles.png";
			protectFromMissilesImg = getImage(path);
		}
		return protectFromMissilesImg;
	}

	private BufferedImage getImage(String path)
	{
		BufferedImage image = null;
		try
		{
			InputStream in = FightCaveOverlay.class.getResourceAsStream(path);
			image = ImageIO.read(in);
		}
		catch (IOException e)
		{
			log.warn("Error loading image", e);
		}
		return image;
	}
}
