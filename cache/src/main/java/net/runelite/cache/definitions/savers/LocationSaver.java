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
package net.runelite.cache.definitions.savers;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.runelite.cache.definitions.LocationsDefinition;
import net.runelite.cache.io.OutputStream;
import net.runelite.cache.region.Location;

public class LocationSaver
{
	public byte[] save(LocationsDefinition locs)
	{
		Multimap<Integer, Location> locById = LinkedListMultimap.create();
		List<Location> sortedLocs = new ArrayList<>(locs.getLocations());
		sortedLocs.sort((l1, l2) -> Integer.compare(l1.getId(), l2.getId()));
		for (Location loc : sortedLocs)
		{
			locById.put(loc.getId(), loc);
		}
		OutputStream out = new OutputStream();
		int prevId = -1;
		for (Integer id : locById.keySet())
		{
			int diffId = id - prevId;
			prevId = id;

			out.writeShortSmart(diffId);

			Collection<Location> locations = locById.get(id);
			int position = 0;
			for (Location loc : locations)
			{
				int packedPosition = (loc.getPosition().getZ() << 12)
					| (loc.getPosition().getX() << 6)
					| (loc.getPosition().getY());

				int diffPos = packedPosition - position;
				position = packedPosition;

				out.writeShortSmart(diffPos + 1);

				int packedAttributes = (loc.getType() << 2) | loc.getOrientation();
				out.writeByte(packedAttributes);
			}

			out.writeShortSmart(0);
		}
		out.writeShortSmart(0);
		return out.flip();
	}
}
