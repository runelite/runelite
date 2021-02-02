/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package net.runelite.client.ui.overlay.worldmap;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.annotation.Nullable;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;

@Data
@SuperBuilder
public class WorldMapPoint
{
	private BufferedImage image;

	private WorldPoint worldPoint;

	/**
	 * The WorldPoint which the worldmap will jump to when clicked
	 */
	@Nullable
	private WorldPoint target;

	/**
	 * The point on the image that will be drawn at WorldPoint
	 * WorldMapPointManager will center the image if imagePoint is null
	 */
	private Point imagePoint;

	private Rectangle clickbox;

	private boolean snapToEdge;

	private boolean currentlyEdgeSnapped;

	/**
	 * Whether or not the map jumps to target, or worldPoint when the overlay is clicked
	 */
	private boolean jumpOnClick;

	private boolean tooltipVisible;

	private String tooltip;

	public WorldMapPoint(WorldPoint worldPoint, BufferedImage image)
	{
		this.worldPoint = worldPoint;
		this.image = image;
	}

	public MouseEvent onClick(MouseEvent e)
	{
		return e;
	}

	public void onEdgeSnap()
	{
	}

	public void onEdgeUnsnap()
	{
	}
}
