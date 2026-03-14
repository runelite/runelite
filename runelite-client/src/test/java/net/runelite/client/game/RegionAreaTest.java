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

import com.google.common.collect.Range;
import net.runelite.api.Constants;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RegionAreaTest
{
	@Test
	public void testSubRegionIntersects()
	{
		// Partial overlap
		assertTrue(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(5, 5, 0))
			.subRegionIntersects(new RegionArea(0, new WorldPoint(2, 2, 0), new WorldPoint(7, 7, 0))));
		assertTrue(new RegionArea(0, new WorldPoint(2, 2, 0), new WorldPoint(7, 7, 0))
			.subRegionIntersects(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(5, 5, 0))));

		// One fully contains the other
		assertTrue(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(5, 5, 0))
			.subRegionIntersects(new RegionArea(0, new WorldPoint(1, 1, 0), new WorldPoint(4, 4, 0))));
		assertTrue(new RegionArea(0, new WorldPoint(1, 1, 0), new WorldPoint(4, 4, 0))
			.subRegionIntersects(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(5, 5, 0))));

		// Shared edge, but no overlap
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(1, 2, 0))
			.subRegionIntersects(new RegionArea(0, new WorldPoint(2, 0, 0), new WorldPoint(3, 2, 0))));
		assertFalse(new RegionArea(0, new WorldPoint(2, 0, 0), new WorldPoint(3, 2, 0))
			.subRegionIntersects(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(1, 2, 0))));

		// Shared corner, but no overlap
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(1, 1, 0))
			.subRegionIntersects(new RegionArea(0, new WorldPoint(2, 2, 0), new WorldPoint(3, 3, 0))));
		assertFalse(new RegionArea(0, new WorldPoint(2, 2, 0), new WorldPoint(3, 3, 0))
			.subRegionIntersects(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(1, 1, 0))));

		// No overlap or shared edges/vertices
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(1, 1, 0))
			.subRegionIntersects(new RegionArea(0, new WorldPoint(2, 2, 0), new WorldPoint(3, 3, 0))));
		assertFalse(new RegionArea(0, new WorldPoint(2, 2, 0), new WorldPoint(3, 3, 0))
			.subRegionIntersects(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(1, 1, 0))));

		// Full region area does not overlap sub-region
		assertFalse(new RegionArea(0)
			.subRegionIntersects(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(5, 5, 0))));
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(5, 5, 0))
			.subRegionIntersects(new RegionArea(0)));

		// Full region area does not overlap other full region area
		assertFalse(new RegionArea(0).subRegionIntersects(new RegionArea(1)));
		assertFalse(new RegionArea(1).subRegionIntersects(new RegionArea(0)));

		// Full region area does overlap itself
		assertTrue(new RegionArea(0).subRegionIntersects(new RegionArea(0)));

		// Full region partial plane areas overlap
		assertTrue(new RegionArea(0, Range.atLeast(1))
			.subRegionIntersects(new RegionArea(0, Range.atMost(2))));
		assertTrue(new RegionArea(0, Range.atMost(2))
			.subRegionIntersects(new RegionArea(0, Range.atLeast(1))));

		// One region fully contains the others' planes
		assertTrue(new RegionArea(0, Range.closed(0, 3))
			.subRegionIntersects(new RegionArea(0, Range.singleton(2))));
		assertTrue(new RegionArea(0, Range.singleton(2))
			.subRegionIntersects(new RegionArea(0, Range.closed(0, 3))));

		// Full region areas with disjoint planes
		assertFalse(new RegionArea(0, Range.closed(0, 1))
			.subRegionIntersects(new RegionArea(0, Range.singleton(2))));
		assertFalse(new RegionArea(0, Range.singleton(2))
			.subRegionIntersects(new RegionArea(0, Range.closed(0, 1))));
	}

	@Test
	public void testContains()
	{
		// Full region area contains all points in that region, not those outside of it
		assertTrue(new RegionArea(0).contains(new WorldPoint(0, 0, 0)));
		assertTrue(new RegionArea(0).contains(new WorldPoint(0, 0, 2)));
		assertTrue(new RegionArea(0).contains(new WorldPoint(10, 10, 0)));
		assertTrue(new RegionArea(0).contains(new WorldPoint(10, 10, 3)));
		assertTrue(new RegionArea(0).contains(new WorldPoint(Constants.REGION_SIZE - 1, Constants.REGION_SIZE - 1, 0)));
		assertFalse(new RegionArea(0).contains(new WorldPoint(Constants.REGION_SIZE, 0, 0)));
		assertFalse(new RegionArea(0).contains(new WorldPoint(0, Constants.REGION_SIZE, 0)));
		assertFalse(new RegionArea(0).contains(new WorldPoint(Constants.REGION_SIZE, Constants.REGION_SIZE, 0)));

		// Sub-region areas behave similarly to WorldArea#contains(WorldPoint)
		assertTrue(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0))
			.contains(new WorldPoint(0, 0, 0)));
		assertTrue(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0))
			.contains(new WorldPoint(0, 0, 3)));
		assertTrue(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0))
			.contains(new WorldPoint(1, 1, 0)));
		assertTrue(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0))
			.contains(new WorldPoint(10, 10, 0)));
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0))
			.contains(new WorldPoint(11, 0, 0)));
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0))
			.contains(new WorldPoint(0, 11, 0)));
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0))
			.contains(new WorldPoint(11, 11, 0)));

		// Full region area constrained to planes contains all points on said planes
		assertTrue(new RegionArea(0, Range.closed(0, 1))
			.contains(new WorldPoint(0, 0, 0)));
		assertTrue(new RegionArea(0, Range.closed(0, 1))
			.contains(new WorldPoint(0, 0, 1)));
		assertTrue(new RegionArea(0, Range.closed(0, 1))
			.contains(new WorldPoint(Constants.REGION_SIZE - 1, Constants.REGION_SIZE - 1, 0)));
		assertTrue(new RegionArea(0, Range.singleton(3))
			.contains(new WorldPoint(0, 0, 3)));
		assertFalse(new RegionArea(0, Range.closed(0, 1))
			.contains(new WorldPoint(0, 0, 2)));
		assertFalse(new RegionArea(0, Range.closed(0, 1))
			.contains(new WorldPoint(0, 0, 3)));
		assertFalse(new RegionArea(0, Range.closed(2, 3))
			.contains(new WorldPoint(0, 0, 0)));

		// Sub-region areas constrained to planes also check point's plane
		assertTrue(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0), Range.closed(0, 1))
			.contains(new WorldPoint(0, 0, 0)));
		assertTrue(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0), Range.closed(0, 1))
			.contains(new WorldPoint(1, 1, 0)));
		assertTrue(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0), Range.closed(0, 1))
			.contains(new WorldPoint(10, 10, 0)));
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0), Range.closed(2, 3))
			.contains(new WorldPoint(0, 0, 0)));
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0), Range.closed(0, 1))
			.contains(new WorldPoint(0, 0, 3)));
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0), Range.closed(0, 1))
			.contains(new WorldPoint(11, 0, 0)));
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0), Range.closed(0, 1))
			.contains(new WorldPoint(0, 11, 0)));
		assertFalse(new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(10, 10, 0), Range.closed(0, 1))
			.contains(new WorldPoint(11, 11, 0)));
	}

	@Test
	public void testAreaWithinRegion()
	{
		new RegionArea(0, new WorldArea(new WorldPoint(0, 0, 0), Constants.REGION_SIZE, Constants.REGION_SIZE));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSwAreaCornerOutsideRegion()
	{
		new RegionArea(0, new WorldPoint(0, 0, 0), new WorldPoint(0, Constants.REGION_SIZE, 0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNeAreaCornerOutsideRegion()
	{
		new RegionArea(1, new WorldPoint(0, 0, 0), new WorldPoint(0, Constants.REGION_SIZE, 0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAreaCornersOutsideRegion()
	{
		new RegionArea(0, new WorldPoint(Constants.REGION_SIZE, Constants.REGION_SIZE, 0), new WorldPoint(Constants.REGION_SIZE * 2, Constants.REGION_SIZE * 2, 0));
	}
}
