/*
 * Copyright (c) 2018, Tim Lehner <Timothy.Lehner.2011@live.rhul.ac.uk>
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
package net.runelite.client.plugins.raidsthieving.BatSolver;

import static net.runelite.client.plugins.raidsthieving.BatSolver.Matrix2D.MatrixMultiple2D;

public class ChestIdentifier
{
	public ChestIdentifier(ThievingRoomType type, int[][] rotation)
	{
		this.type = type;
		this.rotation = rotation;
	}

	private ThievingRoomType type;
	private int[][] rotation;

	public int findChestId(int dx, int dy)
	{
		for (ChestIdMapping mapping : ChestIdMapping.CHEST_ID_MAPPINGS)
		{
			if (mapping.getRoomType() == type)
			{
				int[][] mappingDelta = {{mapping.getDx()}, {mapping.getDy()}};
				int[][] rotatedDelta = MatrixMultiple2D(rotation, mappingDelta);

				if (dx == rotatedDelta[0][0] && dy == rotatedDelta[1][0])
				{
					return mapping.getId();
				}
			}

		}
		return -1;
	}
}
