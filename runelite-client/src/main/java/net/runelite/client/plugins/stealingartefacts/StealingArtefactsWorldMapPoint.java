/*
 * Copyright (c) 2020, Dutta64 <https://github.com/dutta64>
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
package net.runelite.client.plugins.stealingartefacts;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.util.ImageUtil;

class StealingArtefactsWorldMapPoint extends WorldMapPoint
{
	private static BufferedImage cachedMapArrowImage;

	private final BufferedImage hairClipImage;
	private final BufferedImage artefactWorldMapImage;

	private final Point artefactWorldMapPoint;

	StealingArtefactsWorldMapPoint(WorldPoint worldPoint, BufferedImage bufferedImage)
	{
		super(worldPoint, null);

		hairClipImage = bufferedImage;

		BufferedImage mapArrowImage = getCachedMapArrowImage();

		artefactWorldMapImage = new BufferedImage(mapArrowImage.getWidth(), mapArrowImage.getHeight(),
			BufferedImage.TYPE_INT_ARGB);

		Graphics graphics = artefactWorldMapImage.getGraphics();
		graphics.drawImage(mapArrowImage, 0, 0, null);
		graphics.drawImage(hairClipImage, 0, 0, null);

		artefactWorldMapPoint = new Point(artefactWorldMapImage.getWidth() / 2, artefactWorldMapImage.getHeight());

		this.setSnapToEdge(true);
		this.setJumpOnClick(true);
		this.setImage(artefactWorldMapImage);
		this.setImagePoint(artefactWorldMapPoint);
	}

	@Override
	public void onEdgeSnap()
	{
		this.setImage(hairClipImage);
		this.setImagePoint(null);
	}

	@Override
	public void onEdgeUnsnap()
	{
		this.setImage(artefactWorldMapImage);
		this.setImagePoint(artefactWorldMapPoint);
	}

	private static BufferedImage getCachedMapArrowImage()
	{
		if (cachedMapArrowImage == null)
		{
			cachedMapArrowImage = ImageUtil.getResourceStreamFromClass(StealingArtefactsWorldMapPoint.class, "/util" +
				"/clue_arrow.png");
		}

		return cachedMapArrowImage;
	}
}
