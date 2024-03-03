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
	 * The WorldPoint that {@link #worldPoint} should map to on the world map to be located correctly
	 */
	@Nullable
	private WorldPoint mapWorldPoint;

	/**
	 * The {@link WorldMapArea} the WorldMapPoint should appear in on the world map
	 */
	private WorldMapArea worldMapArea;

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

	private boolean snapToEdge;

	private boolean currentlyEdgeSnapped;

	/**
	 * Whether or not the map jumps to target, or worldPoint when the overlay is clicked
	 */
	private boolean jumpOnClick;

	/**
	 * Name in menu option when {@link #jumpOnClick} is set
	 */
	private String name;

	private String tooltip;

	public WorldMapPoint(WorldPoint worldPoint, BufferedImage image)
	{
		setWorldPoint(worldPoint);
		this.image = image;
	}

	/**
	 * Gets the {@link WorldPoint} that this WorldMapPoint should map to on the world map.
	 *
	 * @return The WorldPoint that this WorldMapPoint maps to on the world map.
	 */
	public WorldPoint getMapWorldPoint()
	{
		ensureMapPointAndAreaCalculated();
		return mapWorldPoint;
	}

	/**
	 * Gets the {@link WorldMapArea} that this WorldMapPoint should be associated with on the world map.
	 *
	 * @return The WorldMapArea that this WorldMapPoint maps to on the world map.
	 */
	public WorldMapArea getWorldMapArea()
	{
		ensureMapPointAndAreaCalculated();
		return worldMapArea;
	}

	/**
	 * Ensures the {@link #mapWorldPoint} and {@link #worldMapArea} are updated based on the current {@link #worldPoint}.
	 * This method acts as a lazy loader, only recalculating mapWorldPoint and worldMapArea when necessary.
	 */
	private void ensureMapPointAndAreaCalculated()
	{
		if (mapWorldPoint == null)
		{
			WorldPointWithWorldMapArea wpWithArea = WorldPointMapper.getMapWorldPointFromRealWorldPoint(worldPoint);
			this.mapWorldPoint = wpWithArea.getWorldPoint();
			this.worldMapArea = wpWithArea.getWorldMapArea();
		}
	}

	/**
	 * Sets the world point and invalidates the cached mapWorldPoint and worldMapArea to ensure they are recalculated.
	 *
	 * @param worldPoint The new WorldPoint to set.
	 */
	public void setWorldPoint(WorldPoint worldPoint)
	{
		this.worldPoint = worldPoint;
		this.mapWorldPoint = null;
		this.worldMapArea = WorldMapArea.ANY;
	}

	public void onEdgeSnap()
	{
	}

	public void onEdgeUnsnap()
	{
	}
}
