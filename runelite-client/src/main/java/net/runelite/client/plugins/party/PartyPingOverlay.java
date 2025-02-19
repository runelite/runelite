/*
 * Copyright (c) 2019, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2022, kamielvf <code@kamiel.dev>
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
package net.runelite.client.plugins.party;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.util.Iterator;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.DynamicObject;
import net.runelite.api.GameObject;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.party.data.PartyPingData;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class PartyPingOverlay extends Overlay
{
	private static final int PING_START_ALPHA = 255;
	private static final double IMAGE_FLOAT_START_THRESHOLD = 0.3;
	private static final int IMAGE_BASE_FLOAT_HEIGHT = 10;
	private static final int IMAGE_END_FLOAT_HEIGHT = 25;
	private static final Polygon ARROW_HEAD = new Polygon(new int[]{0, -5, 5}, new int[]{0, -7, -7}, 3);

	private final Client client;
	private final PartyPlugin plugin;
	private final PartyConfig config;

	@Inject
	private PartyPingOverlay(final Client client, final PartyPlugin plugin, final PartyConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getPartyDataMap().isEmpty())
		{
			return null;
		}

		synchronized (plugin.getPendingPartyPings())
		{
			final Iterator<PartyPingData> iterator = plugin.getPendingPartyPings().iterator();

			while (iterator.hasNext())
			{
				PartyPingData next = iterator.next();
				long timeLeft = Duration.between(Instant.now(), next.getExpiresAt()).toMillis();

				if (timeLeft <= 0)
				{
					iterator.remove();
					continue;
				}

				double percentageLeft = timeLeft / next.getPingDuration();
				renderPing(graphics, next, percentageLeft);
				long elapsedTimeMillis = (System.nanoTime() - next.getCreationTime()) / 1000000;
				next.setAlpha((int) Math.max(0, 255 - (elapsedTimeMillis / 4)));
			}
		}

		return null;
	}

	private void renderPing(final Graphics2D graphics, final PartyPingData ping, double percentageLeft)
	{
		Polygon poly = null;
		LocalPoint localPoint = null;
		int targetHeight = 0;
		int imageFloatDistance = 0;

		switch (ping.getTargetType())
		{
			case TILE:
				localPoint = LocalPoint.fromWorld(client, ping.getPoint());
				poly = Perspective.getCanvasTilePoly(client, localPoint);
				imageFloatDistance = percentageLeft <= IMAGE_FLOAT_START_THRESHOLD ? (int) (IMAGE_END_FLOAT_HEIGHT - ((IMAGE_END_FLOAT_HEIGHT - IMAGE_BASE_FLOAT_HEIGHT) * (percentageLeft / IMAGE_FLOAT_START_THRESHOLD))) : IMAGE_BASE_FLOAT_HEIGHT;
				break;

			case NPC:
				localPoint = ping.getTargetActor().getLocalLocation();
				poly = ping.getTargetActor().getCanvasTilePoly();
				targetHeight = ping.getTargetActor().getLogicalHeight();
				break;

			case OBJECT:
				localPoint = ping.getTargetObject().getLocalLocation();
				poly = ping.getTargetObject().getCanvasTilePoly();
				targetHeight = determineObjectTargetHeight(ping.getTargetObject());
				break;
		}

		if (poly == null || localPoint == null)
		{
			return;
		}

		final Color color = new Color(ping.getColor().getRed(), ping.getColor().getGreen(), ping.getColor().getBlue(), (int) (PING_START_ALPHA * percentageLeft));

		OverlayUtil.renderPolygon(graphics, poly, color);

		if (ping.getPingType() == PartyPingType.DESTINATION && config.drawDestinationLine())
		{
			Player source = client.getPlayers().get(ping.getSourcePlayerIdx());
			if (source != null)
			{
				renderSourcePlayerLine(graphics, source, localPoint, color);
			}
		}

		if (ping.getTargetType() == PartyPingTargetType.TILE && ping.getPingType() == PartyPingType.TARGET)
		{
			return;
		}

		final BufferedImage image = ping.getPingType().getImage();
		final Point imageLocation = Perspective.localToCanvas(client, localPoint, client.getPlane(), targetHeight + image.getHeight());

		final Composite originalComposite = graphics.getComposite();
		if (percentageLeft <= IMAGE_FLOAT_START_THRESHOLD)
		{
			final AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) (percentageLeft / IMAGE_FLOAT_START_THRESHOLD));
			graphics.setComposite(alphaComposite);
		}

		graphics.drawImage(image, null, imageLocation.getX() - image.getWidth() / 2, imageLocation.getY() - image.getHeight() / 2 - imageFloatDistance);

		// if we don't set the composite back to original there will be issues when trying to draw 1+ pings at the same time
		graphics.setComposite(originalComposite);
	}

	private int determineObjectTargetHeight(TileObject object)
	{
		if (object instanceof GameObject)
		{
			GameObject gameObject = (GameObject) object;
			if (gameObject.getRenderable() instanceof DynamicObject)
			{
				// without recalculating the bounds cylinder, the height for the object seems to be inaccurate because we are possibly calling it after it is already drawn
				// this will cause the image we are trying to draw above the object to be drawn at some undesired height instead
				gameObject.getRenderable().getModel().calculateBoundsCylinder();
				return gameObject.getRenderable().getModel().getModelHeight();
			}

			return gameObject.getRenderable().getModelHeight();
		}

		int height1 = 0;
		int height2 = 0;

		if (object instanceof WallObject)
		{
			WallObject wallObject = (WallObject) object;
			height1 = wallObject.getRenderable1() != null ? wallObject.getRenderable1().getModelHeight() : 0;
			height2 = wallObject.getRenderable2() != null ? wallObject.getRenderable2().getModelHeight() : 0;
		}
		else if (object instanceof DecorativeObject)
		{
			DecorativeObject decorativeObject = (DecorativeObject) object;
			height1 = decorativeObject.getRenderable() != null ? decorativeObject.getRenderable().getModelHeight() : 0;
			height2 = decorativeObject.getRenderable2() != null ? decorativeObject.getRenderable2().getModelHeight() : 0;
		}

		return Math.max(height1, height2);
	}

	private void renderSourcePlayerLine(final Graphics2D graphics, final Player player, final LocalPoint destination, final Color color)
	{
		final LocalPoint playerLocation = player.getLocalLocation();
		final Point source = Perspective.localToCanvas(client, playerLocation, client.getPlane());
		if (source == null)
		{
			return;
		}

		final Point target = Perspective.localToCanvas(client, destination, client.getPlane());
		if (target == null)
		{
			return;
		}

		int sourceX = source.getX();
		int sourceY = source.getY();
		int targetX = target.getX();
		int targetY = target.getY();

		graphics.setColor(color);
		graphics.drawLine(sourceX, sourceY, targetX, targetY);

		AffineTransform t = new AffineTransform();
		t.translate(targetX, targetY);
		t.rotate(targetX - sourceX, targetY - sourceY);
		t.rotate(Math.PI / -2);
		AffineTransform ot = graphics.getTransform();
		graphics.setTransform(t);
		graphics.fill(ARROW_HEAD);
		graphics.setTransform(ot);
	}
}
