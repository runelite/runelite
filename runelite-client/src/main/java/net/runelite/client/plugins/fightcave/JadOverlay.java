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
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
public class JadOverlay extends Overlay
{
	private final Client client;
	private final FightCavePlugin plugin;
	private final FightCaveConfig config;
	private final PanelComponent imagePanelComponent = new PanelComponent();
	private BufferedImage protectFromMagicImg;
	private BufferedImage protectFromMissilesImg;
	private static final Color NOT_ACTIVATED_BACKGROUND_COLOR = new Color(150, 0, 0, 150);

	@Inject
	JadOverlay(Client client, FightCavePlugin plugin, FightCaveConfig config)
	{
		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		setPriority(OverlayPriority.HIGH);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		JadAttack attack = plugin.getAttack();
		int currentWave = plugin.getCurrentWave();
		if (currentWave == 0 || attack == null)
		{
			return null;
		}

		imagePanelComponent.getChildren().clear();
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		final BufferedImage prayerImage = getPrayerImage(attack);
		imagePanelComponent.getChildren().clear();
		imagePanelComponent.getChildren().add(new ImageComponent(prayerImage));
		imagePanelComponent.setBackgroundColor(client.isPrayerActive(attack.getPrayer())
					? ComponentConstants.STANDARD_BACKGROUND_COLOR
					: NOT_ACTIVATED_BACKGROUND_COLOR);
		imagePanelComponent.render(graphics);
		return imagePanelComponent.render(graphics);
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
			synchronized (ImageIO.class)
			{
				image = ImageIO.read(FightCaveOverlay.class.getResourceAsStream(path));
			}
		}
		catch (IOException e)
		{
			log.warn("Error loading image", e);
		}
		return image;
	}
}
