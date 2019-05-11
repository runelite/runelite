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

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.Area;
import static net.runelite.client.plugins.runecraft.AbyssRifts.AIR_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.BLOOD_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.BODY_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.CHAOS_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.COSMIC_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.DEATH_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.EARTH_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.FIRE_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.LAW_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.MIND_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.NATURE_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.SOUL_RIFT;
import static net.runelite.client.plugins.runecraft.AbyssRifts.WATER_RIFT;
import com.google.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class AbyssOverlay extends Overlay
{
	private static final Dimension IMAGE_SIZE = new Dimension(15, 14);

	private final Set<AbyssRifts> rifts = new HashSet<>();
	private final Map<AbyssRifts, BufferedImage> abyssIcons = new HashMap<>();

	private final Client client;
	private final RunecraftPlugin plugin;
	private final RunecraftConfig config;

	@Inject
	private ItemManager itemManager;

	@Inject
	AbyssOverlay(Client client, RunecraftPlugin plugin, RunecraftConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.showRifts())
		{
			for (DecorativeObject object : plugin.getAbyssObjects())
			{
				renderRifts(graphics, object);
			}
		}

		if (config.hightlightDarkMage())
		{
			highlightDarkMage(graphics);
		}

		return null;
	}

	private void highlightDarkMage(Graphics2D graphics)
	{
		if (!plugin.isDegradedPouchInInventory())
		{
			return;
		}

		NPC darkMage = plugin.getDarkMage();
		if (darkMage == null)
		{
			return;
		}

		Polygon tilePoly = darkMage.getCanvasTilePoly();
		if (tilePoly == null)
		{
			return;
		}

		OverlayUtil.renderPolygon(graphics, tilePoly, Color.green);
	}

	private void renderRifts(Graphics2D graphics, DecorativeObject object)
	{
		AbyssRifts rift = AbyssRifts.getRift(object.getId());
		if (rift == null || !rifts.contains(rift))
		{
			return;
		}

		if (config.showClickBox())
		{
			//Draw clickbox
			Point mousePosition = client.getMouseCanvasPosition();
			Area objectClickbox = object.getClickbox();
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

		//Draw minimap
		BufferedImage image = getImage(rift);
		Point miniMapImage = Perspective.getMiniMapImageLocation(client, object.getLocalLocation(), image);

		if (miniMapImage != null)
		{
			graphics.drawImage(image, miniMapImage.getX(), miniMapImage.getY(), null);
		}
	}

	public BufferedImage getImage(AbyssRifts rift)
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

	public void updateConfig()
	{
		rifts.clear();
		if (config.showAir())
		{
			rifts.add(AIR_RIFT);
		}
		if (config.showBlood())
		{
			rifts.add(BLOOD_RIFT);
		}
		if (config.showBody())
		{
			rifts.add(BODY_RIFT);
		}
		if (config.showChaos())
		{
			rifts.add(CHAOS_RIFT);
		}
		if (config.showCosmic())
		{
			rifts.add(COSMIC_RIFT);
		}
		if (config.showDeath())
		{
			rifts.add(DEATH_RIFT);
		}
		if (config.showEarth())
		{
			rifts.add(EARTH_RIFT);
		}
		if (config.showFire())
		{
			rifts.add(FIRE_RIFT);
		}
		if (config.showLaw())
		{
			rifts.add(LAW_RIFT);
		}
		if (config.showMind())
		{
			rifts.add(MIND_RIFT);
		}
		if (config.showNature())
		{
			rifts.add(NATURE_RIFT);
		}
		if (config.showSoul())
		{
			rifts.add(SOUL_RIFT);
		}
		if (config.showWater())
		{
			rifts.add(WATER_RIFT);
		}
	}
}
