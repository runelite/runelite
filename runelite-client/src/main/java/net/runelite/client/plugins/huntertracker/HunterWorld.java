/*
 * Copyright (c) 2018, NotFoxtrot <https://github.com/NotFoxtrot>
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Jeff LaJoie
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.huntertracker;

import com.google.inject.Singleton;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import lombok.Getter;

@Singleton
public class HunterWorld
{
	@Getter
	private Map<Integer, BirdhouseRegion> regions = new HashMap<>();

	@Getter
	private Map<Tab, Set<BirdhouseSpace>> tabs = new HashMap<>();

	private final Comparator<BirdhouseSpace> tabSorter = Comparator
			.comparing(BirdhouseSpace::getImplementation)
			.thenComparing((BirdhouseSpace p) -> p.getRegion().getName())
			.thenComparing(BirdhouseSpace::getName);

	public HunterWorld()
	{
		add(BirdhouseRegion.VERDANT_VALLEY);
		add(BirdhouseRegion.MUSHROOM_MEADOW_NORTH);
		add(BirdhouseRegion.MUSHROOM_MEADOW_SOUTH);

		// Finalize
		this.regions = Collections.unmodifiableMap(regions);
		Map<Tab, Set<BirdhouseSpace>> umtabs = new TreeMap<>();
		for (Map.Entry<Tab, Set<BirdhouseSpace>> e : tabs.entrySet())
		{
			umtabs.put(e.getKey(), Collections.unmodifiableSet(e.getValue()));
		}
		this.tabs = Collections.unmodifiableMap(umtabs);
	}

	private void add(BirdhouseRegion r, int... extraRegions)
	{
		regions.put(r.getRegionID(), r);
		for (int er : extraRegions)

		{
			regions.put(er, r);
		}
		for (BirdhouseSpace s : r.getSpaces())
		{
			tabs
				.computeIfAbsent(s.getImplementation().getTab(), k -> new TreeSet<>(tabSorter))
				.add(s);
		}
	}
}
