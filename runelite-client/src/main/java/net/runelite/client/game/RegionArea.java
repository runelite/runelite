/*
 * Copyright (c) 2025, Jordan Atwood <nightfirecat@nightfirec.at>
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
package net.runelite.client.game;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.ToString;
import net.runelite.api.Constants;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;

/**
 * An area of the game contained within a given region, which may encompass the entire region or be limited to a
 * specific {@link WorldArea}'s rectangle and/or planes within that region.
 */
@Getter
@ToString
public class RegionArea
{
	private final int region;
	@Nullable
	private final WorldArea area;
	@Nullable
	private final Range<Integer> planes;

	/**
	 * Create a {@link RegionArea} in a given region encompassing the entire region, e.g. a full-region area.
	 *
	 * @param region Region the area is within
	 */
	public RegionArea(final int region)
	{
		this(region, (WorldArea) null, null);
	}

	/**
	 * Create a {@link RegionArea} in a given region encompassing the 2-dimensional rectangle with the given southwest
	 * and northeast {@link WorldPoint WorldPoints} as corners, spanning all planes. (The
	 * {@link WorldPoint#getPlane() plane} of the given points will be ignored.)
	 *
	 * @param region   Region the area is within
	 * @param swCorner Southwest corner of the area
	 * @param neCorner Northeast corner of the area
	 */
	public RegionArea(final int region, final WorldPoint swCorner, final WorldPoint neCorner)
	{
		this(region, swCorner, neCorner, null);
	}

	/**
	 * Create a {@link RegionArea} in a given region encompassing the given area, spanning all planes. (The
	 * {@link WorldArea#getPlane() plane} of the given points will be ignored.)
	 *
	 * @param region Region the area is within
	 * @param area   The area within the region to be covered
	 */
	public RegionArea(final int region, @Nullable final WorldArea area)
	{
		this(region, area, null);
	}

	/**
	 * Create a {@link RegionArea} in a given region encompassing the entire region, spanning the given range of planes.
	 *
	 * @param region Region the area is within
	 * @param planes A {@link Range} of planes to be spanned. (This should be within the range 0-3, inclusive. See
	 *               {@link net.runelite.api.Constants#MAX_Z})
	 */
	public RegionArea(final int region, @Nullable final Range<Integer> planes)
	{
		this(region, null, planes);
	}

	/**
	 * Create a {@link RegionArea} in a given region encompassing the 2-dimensional rectangle with the given southwest
	 * and northeast {@link WorldPoint WorldPoints} as corners, spanning the given range of planes. (The
	 * {@link WorldPoint#getPlane() plane} of the given points will be ignored in favor of the given range of planes.)
	 *
	 * @param region   Region the area is within
	 * @param swCorner Southwest corner of the area
	 * @param neCorner Northeast corner of the area
	 * @param planes   A {@link Range} of planes to be spanned. (This should be within the range 0-3, inclusive. See
	 *                 {@link net.runelite.api.Constants#MAX_Z})
	 */
	public RegionArea(final int region, final WorldPoint swCorner, final WorldPoint neCorner, @Nullable final Range<Integer> planes)
	{
		this(region, new WorldArea(swCorner, neCorner.getX() - swCorner.getX() + 1, neCorner.getY() - swCorner.getY() + 1), planes);
	}

	/**
	 * Create a {@link RegionArea} in a given region encompassing the given area and spanning the given range of planes.
	 * (The {@link WorldArea#getPlane() plane} of the given area will be ignored in favor of the given range of planes.)
	 *
	 * @param region Region the area is within
	 * @param area   The area within the region to be covered
	 * @param planes A {@link Range} of planes to be spanned. (This should be within the range 0-3, inclusive. See
	 *               {@link net.runelite.api.Constants#MAX_Z})
	 */
	public RegionArea(final int region, @Nullable final WorldArea area, @Nullable final Range<Integer> planes)
	{
		if (area != null)
		{
			final WorldPoint swCorner = area.toWorldPoint();
			final WorldPoint neCorner = swCorner.dx(area.getWidth() - 1).dy(area.getHeight() - 1);
			Preconditions.checkArgument(swCorner.getRegionID() == region && neCorner.getRegionID() == region,
				"Area corners ({}, {}) must both be in the given region (id: {})", swCorner, neCorner, region);
		}

		this.region = region;
		this.area = area;
		this.planes = planes;
	}

	/**
	 * Tests if the area contained in the {@link RegionArea} intersects the area contained in the given
	 * {@link RegionArea}. If either {@link RegionArea} covers a full region, or if both cover full, complete regions this
	 * will return {@code false}, as the class is intended to support "overlaying" sub-region areas on top of
	 * full-region areas, and thus should not consider them overlapping.
	 *
	 * @param other The given {@link RegionArea}
	 * @return {@code true} if each given {@link RegionArea} has a sub-region area which intersect, {@code false}
	 *         otherwise.
	 */
	public boolean subRegionIntersects(final RegionArea other)
	{
		if (getRegion() != other.getRegion())
		{
			return false;
		}

		final boolean fullRegion = getArea() == null && getPlanes() == null;
		final boolean otherFullRegion = other.getArea() == null && other.getPlanes() == null;
		if (fullRegion || otherFullRegion)
		{
			return fullRegion && otherFullRegion;
		}

		final WorldArea thisArea = getArea() != null ? getArea() : new WorldArea(WorldPoint.fromRegion(getRegion(), 0, 0, 0), Constants.REGION_SIZE, Constants.REGION_SIZE);
		final WorldArea otherArea = other.getArea() != null ? other.getArea() : new WorldArea(WorldPoint.fromRegion(other.getRegion(), 0, 0, 0), Constants.REGION_SIZE, Constants.REGION_SIZE);
		final Range<Integer> thisPlanes = getPlanes() != null ? getPlanes() : Range.closed(0, 3);
		final Range<Integer> otherPlanes = other.getPlanes() != null ? other.getPlanes() : Range.closed(0, 3);

		return thisArea.intersectsWith2D(otherArea) && rangesOverlap(thisPlanes, otherPlanes);
	}

	private static <T extends Comparable<T>> boolean rangesOverlap(final Range<T> range1, final Range<T> range2)
	{
		return range1.isConnected(range2) && !range1.intersection(range2).isEmpty();
	}

	/**
	 * Tests if a given {@link WorldPoint} is inside the {@link RegionArea}.
	 *
	 * @param point The given {@link WorldPoint} to be tested
	 * @return {@code true} if the given {@link WorldPoint} is inside the {@link RegionArea}, {@code false} otherwise.
	 */
	public boolean contains(final WorldPoint point)
	{
		if (getPlanes() != null && !getPlanes().contains(point.getPlane()))
		{
			return false;
		}

		if (getArea() != null && !getArea().contains2D(point))
		{
			return false;
		}

		return getRegion() == point.getRegionID();
	}
}
