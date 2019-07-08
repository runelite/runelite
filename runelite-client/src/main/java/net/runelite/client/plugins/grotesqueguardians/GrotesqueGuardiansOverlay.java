/*
 * Copyright (c) 2018, Damen <https://github.com/basicDamen>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.grotesqueguardians;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.TextComponent;

@Singleton
class GrotesqueGuardiansOverlay extends Overlay
{
	private static final int GROTESQUE_GUARDIANS_REGION_ID = 6727;
	private final Client client;
	private final GrotesqueGuardiansPlugin plugin;
	private static final int GROTESQUE_GUARDIANS_LIGHTNING_START = 1416;
	private static final int GROTESQUE_GUARDIANS_LIGHTNING_END = 1431;
	private static final int GROTESQUE_GUARDIANS_FALLING_ROCKS = 1436;
	private static final int GROTESQUE_GUARDIANS_STONE_ORB = 160;

	@Inject
	private GrotesqueGuardiansOverlay(final Client client, final GrotesqueGuardiansPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPriority(OverlayPriority.LOW);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!client.isInInstancedRegion() || client.getMapRegions()[0] != GROTESQUE_GUARDIANS_REGION_ID)
		{
			return null;
		}

		// TODO: Awaiting GraphicsObjectDespawn event to be tracked to make this more efficient.
		for (GraphicsObject graphicsObject : client.getGraphicsObjects())
		{
			Color color;

			if (graphicsObject.getId() >= GROTESQUE_GUARDIANS_LIGHTNING_START && graphicsObject.getId() <= GROTESQUE_GUARDIANS_LIGHTNING_END)
			{
				color = Color.ORANGE;
			}
			else if (graphicsObject.getId() == GROTESQUE_GUARDIANS_STONE_ORB)
			{
				color = Color.GRAY;
			}
			else if (graphicsObject.getId() == GROTESQUE_GUARDIANS_FALLING_ROCKS)
			{
				color = Color.YELLOW;
			}
			else
			{
				continue;
			}

			LocalPoint lp = graphicsObject.getLocation();
			Polygon poly = Perspective.getCanvasTilePoly(client, lp);

			if (poly != null)
			{
				OverlayUtil.renderPolygon(graphics, poly, color);
			}
			if (plugin.isInGargs() && plugin.isNeedingToRun() && plugin.getDusk() != null && plugin.getDusk().getLocalLocation() != null)
			{
				TextComponent textComponent = new TextComponent();
				LocalPoint duskPoint;

				duskPoint = new LocalPoint(plugin.getDusk().getLocalLocation().getX() + 128 * (Objects.requireNonNull(plugin.getDusk().getTransformedDefinition()).getSize() - 1) / 2, plugin.getDusk().getLocalLocation().getY() + 128 * (plugin.getDusk().getTransformedDefinition().getSize() - 1) / 2);
				net.runelite.api.Point duskLoc = Perspective.getCanvasTextLocation(client, graphics, duskPoint, "RUN AWAY", 500);
				if (duskLoc != null)
				{
					textComponent.setText("RUN AWAY");
					textComponent.setPosition(new java.awt.Point(duskLoc.getX(), duskLoc.getY()));
					textComponent.setColor(Color.red);
					textComponent.render(graphics);
				}
			}
		}
		return null;
	}
}
