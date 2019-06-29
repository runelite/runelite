/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
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
package net.runelite.client.plugins.spellbook;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
public class SpellbookDragOverlay extends Overlay
{
	private SpellbookPlugin plugin;
	private Client client;
	private SpriteManager spriteManager;

	@Inject
	private SpellbookDragOverlay(SpellbookPlugin plugin, Client client, SpriteManager spriteManager)
	{
		this.plugin = plugin;
		this.client = client;
		this.spriteManager = spriteManager;
		setPosition(OverlayPosition.TOOLTIP);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		if (!plugin.isDragging())
		{
			return null;
		}

		final net.runelite.api.Point mouseCanvasPosition = client.getMouseCanvasPosition();
		final net.runelite.api.Point draggingLocation = plugin.getDraggingLocation();

		final int size = plugin.getDraggingWidget().getWidth();
		final int sprite = plugin.getDraggingWidget().getSpriteId();
		final BufferedImage image = spriteManager.getSprite(sprite, 0);

		final Point mousePosition = new Point(mouseCanvasPosition.getX() - draggingLocation.getX(), mouseCanvasPosition.getY() - draggingLocation.getY());
		final Rectangle bounds = new Rectangle(mousePosition.x, mousePosition.y, size, size);

		g.drawImage(image, mousePosition.x, mousePosition.y, size, size, null);

		return bounds.getSize();
	}
}
