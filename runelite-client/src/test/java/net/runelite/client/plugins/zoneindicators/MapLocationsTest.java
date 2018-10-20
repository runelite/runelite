/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.zoneindicators;

import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.PathIterator;
import net.runelite.api.Constants;
import org.junit.Assert;
import org.junit.Test;

public class MapLocationsTest
{
	private static final int AXIS_X = 1;
	private static final int AXIS_Y = 2;
	private static final int AXIS_XY = AXIS_X | AXIS_Y;

	private void validatePath(Area area)
	{
		PathIterator it = area.getPathIterator(new AffineTransform());
		int predictedAxis = 0;
		float[] prevCoords = new float[2];
		float[] coords = new float[2];
		float[] startCoords = new float[2];
		boolean movedLast = false;
		int requiredLinesLeft = 0;
		while (!it.isDone())
		{
			int type = it.currentSegment(coords);
			if (type == PathIterator.SEG_MOVETO)
			{
				Assert.assertTrue(requiredLinesLeft <= 0);
				movedLast = true;
				requiredLinesLeft = 4; // Each polygon has at least 4 corners
				prevCoords[0] = coords[0];
				prevCoords[1] = coords[1];
				startCoords[0] = coords[0];
				startCoords[1] = coords[1];
				predictedAxis = AXIS_XY;
			}
			else if (type == PathIterator.SEG_LINETO)
			{
				if (!movedLast)
				{
					if (predictedAxis == AXIS_XY &&
						(prevCoords[0] == coords[0] || prevCoords[1] == coords[1]) &&
						!(prevCoords[0] == coords[0] && prevCoords[1] == coords[1]))
					{
						// OK, one of dx == 0 or dy == 0 but not both
						if (prevCoords[0] == coords[0])
						{
							predictedAxis = AXIS_Y;
						}
						else if (prevCoords[1] == coords[1])
						{
							predictedAxis = AXIS_X;
						}
					}
					else if (predictedAxis == AXIS_X &&
							 prevCoords[0] == coords[0] && prevCoords[1] != coords[1])
					{
						// OK, dx == 0, dy != 0, not diagonal line
						predictedAxis = AXIS_Y;
					}
					else if (predictedAxis == AXIS_Y &&
							 prevCoords[1] == coords[1] && prevCoords[0] != coords[0])
					{
						// OK, dy == 0, dx != 0, not diagonal line
						predictedAxis = AXIS_X;
					}
					else
					{
						Assert.fail();
					}
				}

				movedLast = false;
				prevCoords[0] = coords[0];
				prevCoords[1] = coords[1];
				requiredLinesLeft--;
			}
			else if (type == PathIterator.SEG_CLOSE)
			{
				Assert.assertFalse(movedLast);

				if (predictedAxis == AXIS_X &&
					coords[0] == startCoords[0] && coords[1] != startCoords[1])
				{
					// OK, dx == 0, dy != 0, not diagonal line
					predictedAxis = AXIS_Y;
				}
				else if (predictedAxis == AXIS_Y &&
						 coords[1] == startCoords[1] && coords[0] != startCoords[0])
				{
					// OK, dy == 0, dx != 0, not diagonal line
					predictedAxis = AXIS_X;
				}
				else
				{
					Assert.fail();
				}

				movedLast = false;
				requiredLinesLeft--;
			}

			it.next();
		}
	}

	@Test
	public void validatePathsNotDiagonal()
	{
		for (int i = 0; i < Constants.MAX_Z; i++)
		{
			validatePath(MapLocations.getMulticombat(i));
			validatePath(MapLocations.getPvpSafeZones(i));
			validatePath(MapLocations.getDeadmanSafeZones(i));
			validatePath(MapLocations.getRoughWilderness(i));
		}
	}
}
