/*
 * Copyright (c) 2016-2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.runecraft;

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.Point;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class AbyssOverlay extends Overlay
{
	private static final Dimension IMAGE_SIZE = new Dimension(25, 25);

	private final Map<AbyssRifts, BufferedImage> abyssIcons = new HashMap<>();
	private final Client client;
	private final RunecraftPlugin plugin;
	private final RunecraftConfig config;
	private final ItemManager itemManager;

	@Inject
	AbyssOverlay(Client client, RunecraftPlugin plugin, RunecraftConfig config, ItemManager itemManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.itemManager = itemManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Set<DecorativeObject> abyssObjects = plugin.getAbyssObjects();
		if (abyssObjects.isEmpty())
		{
			return null;
		}

		for (DecorativeObject object : abyssObjects)
		{
			if (config.showRifts() && config.showClickBox())
			{
				renderRift(graphics, object);
			}

			if (config.showIcons())
			{
				renderIcon(graphics, object);
			}
		}

		return null;
	}

	private void renderRift(Graphics2D graphics, DecorativeObject object)
	{
		AbyssRifts rift = AbyssRifts.getRift(object.getId());
		if (rift == null || !rift.getConfigEnabled().test(config))
		{
			return;
		}

		Point mousePosition = client.getMouseCanvasPosition();
		Shape objectClickbox = object.getClickbox();
		if (objectClickbox != null)
		{
			if (objectClickbox.contains(mousePosition.getX(), mousePosition.getY()))
			{
				graphics.setColor(Color.MAGENTA.darker());
			}
			else
			{
				graphics.setColor(Color.MAGENTA);
			}
			graphics.draw(objectClickbox);
			graphics.setColor(new Color(255, 0, 255, 20));
			graphics.fill(objectClickbox);
		}
	}

	private void renderIcon(Graphics2D graphics, DecorativeObject object)
	{
		AbyssRifts rift = AbyssRifts.getRift(object.getId());
		BufferedImage image = getImage(rift);
		if (rift == null)
		{
			return;
		}

		OverlayUtil.renderImageLocation(client, graphics, object.getLocalLocation(), image, 0);
	}

	private BufferedImage getImage(AbyssRifts rift)
	{
		BufferedImage image = abyssIcons.get(rift);
		if (image != null)
		{
			return image;
		}

		// Since item image is too big, we must resize it first.
		image = itemManager.getImage(rift.getItemId());
		BufferedImage resizedImage = new BufferedImage(IMAGE_SIZE.width, IMAGE_SIZE.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(image, 0, 0, IMAGE_SIZE.width, IMAGE_SIZE.height, null);
		g.dispose();

		abyssIcons.put(rift, resizedImage);
		return resizedImage;
	}
}
