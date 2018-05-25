/*
 * Copyright (c) 2018, Danny <DannysPVM@gmail.com>
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
package net.runelite.client.plugins.deathindicator;

import java.awt.Graphics;
import net.runelite.api.Point;
import java.awt.image.BufferedImage;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;

class DeathWorldMapPoint extends WorldMapPoint
{
	private static final BufferedImage WORLDMAP_HINT_ARROW;
	private static final Point WORLDMAP_HINT_ARROW_POINT;

	static
	{
		WORLDMAP_HINT_ARROW = new BufferedImage(DeathIndicatorPlugin.WORLDMAP_ARROW.getWidth(), DeathIndicatorPlugin.WORLDMAP_ARROW.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics graphics = WORLDMAP_HINT_ARROW.getGraphics();
		graphics.drawImage(DeathIndicatorPlugin.WORLDMAP_ARROW, 0, 0, null);
		graphics.drawImage(DeathIndicatorPlugin.BONES, 3, 7, null);
		WORLDMAP_HINT_ARROW_POINT = new Point(WORLDMAP_HINT_ARROW.getWidth() / 2, WORLDMAP_HINT_ARROW.getHeight());
	}

	DeathWorldMapPoint(final WorldPoint worldPoint)
	{
		super(worldPoint, null);
		this.setSnapToEdge(true);
		this.setJumpOnClick(true);
		this.setImage(WORLDMAP_HINT_ARROW);
		this.setImagePoint(WORLDMAP_HINT_ARROW_POINT);
		this.setTooltip("Death Location");
	}

	@Override
	public void onEdgeSnap()
	{
		this.setImage(DeathIndicatorPlugin.BONES);
		this.setImagePoint(null);
		this.setTooltip(null);
	}

	@Override
	public void onEdgeUnsnap()
	{
		this.setImage(WORLDMAP_HINT_ARROW);
		this.setImagePoint(WORLDMAP_HINT_ARROW_POINT);
		this.setTooltip("Death Location");
	}
}
