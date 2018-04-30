/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.implings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.api.coords.WorldPoint;
	
public class ImplingPuroPuroSpawn
{
	private static Map<WorldPoint, String> puroPuroSpawns = new HashMap<>();

	public static Map<WorldPoint, String> getSpawns(List<String> hiddenSpawns)
	{
		setSpawn(new WorldPoint(2567, 4319, 0), "Eclectic", hiddenSpawns);
		setSpawn(new WorldPoint(2591, 4295, 0), "Eclectic", hiddenSpawns);
		setSpawn(new WorldPoint(2615, 4326, 0), "Eclectic", hiddenSpawns);
		setSpawn(new WorldPoint(2591, 4340, 0), "Eclectic", hiddenSpawns);

		return puroPuroSpawns;
	}

	private static void setSpawn(WorldPoint point, String imp, List<String> hiddenSpawns)
	{
		if(!hiddenSpawns.contains(imp.toLowerCase()))
		{
			puroPuroSpawns.put(point,imp);
		}
	}
}
