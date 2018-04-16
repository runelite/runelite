/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
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

package net.runelite.client.plugins.groundmarkers;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

public class GroundMarkerPoint
{
	@Getter(AccessLevel.PACKAGE)
	private WorldPoint point;

	@Getter(AccessLevel.PACKAGE)
	private boolean isInstanced = false;

	GroundMarkerPoint(WorldPoint point, Client client)
	{
		this.isInstanced = client.isInInstancedRegion();
		this.point = point;
	}

	GroundMarkerPoint(int[] intRaw)
	{
		fromRaw(intRaw);
	}

	public int[] toRaw()
	{
		return new int[] {point.getX(), point.getY(), point.getPlane()};
	}

	private void fromRaw(int[] intRaw)
	{
		this.point = new WorldPoint(intRaw[0], intRaw[1], intRaw[2]);
	}

	public LocalPoint toLocal(Client client)
	{
		return new LocalPoint(0, 0).fromWorld(client, this.point);
	}
}