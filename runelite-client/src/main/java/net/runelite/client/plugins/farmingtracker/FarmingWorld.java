/*
 * Copyright (c) 2018, NotFoxtrot <https://github.com/NotFoxtrot>
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.farmingtracker;

import com.google.inject.Singleton;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import lombok.Getter;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;

@Singleton
public class FarmingWorld
{
	@Getter
	private Map<Integer, FarmingRegion> regions = new HashMap<>();

	@Getter
	private Map<Tab, Set<FarmingPatch>> tabs = new HashMap<>();

	private final Comparator<FarmingPatch> tabSorter = Comparator
		.comparing(FarmingPatch::getImplementation)
		.thenComparing((FarmingPatch p) -> p.getRegion().getName())
		.thenComparing(FarmingPatch::getName);

	public FarmingWorld()
	{
		// Some of these patches get updated in multiple regions.
		// It may be worth it to add a specialization for these patches
		add(new FarmingRegion("It's coming home", 13106,
			new FarmingPatch("It's coming home", Varbits.FARMING_4771, PatchImplementation.CACTUS)
		));

		add(new FarmingRegion("It's coming home", 10290,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH)
		));
		add(new FarmingRegion("It's coming home", 10548,
			new FarmingPatch("It's coming home", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("It's coming home", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB)
		));

		add(new FarmingRegion("It's coming home", 11058,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE),
			new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.SPIRIT_TREE)
		));

		add(new FarmingRegion("It's coming home", 11062,
			new FarmingPatch("It's coming home", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("It's coming home", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB)
		));
		add(new FarmingRegion("It's coming home", 11317,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE)
		));

		add(new FarmingRegion("It's coming home", 12596,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH)
		));

		add(new FarmingRegion("It's coming home", 12340,
			new FarmingPatch("It's coming home", Varbits.FARMING_4771, PatchImplementation.BELLADONNA)
		));

		add(new FarmingRegion("It's coming home", 11060,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS)
		));

		add(new FarmingRegion("It's coming home", 10300,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH),
			new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.SPIRIT_TREE)
		));

		add(new FarmingRegion("It's coming home", 11828,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE)
		));
		add(new FarmingRegion("It's coming home", 12083,
			new FarmingPatch("It's coming home", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("It's coming home", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB)
		)
		{
			@Override
			public boolean isInBounds(WorldPoint loc)
			{
				return loc.getY() > 3280;
			}
		});

		add(new FarmingRegion("It's coming home", 14651,
			new FarmingPatch("It's coming home", Varbits.FARMING_4771, PatchImplementation.HARDWOOD_TREE),
			new FarmingPatch("It's coming home", Varbits.FARMING_4772, PatchImplementation.HARDWOOD_TREE),
			new FarmingPatch("It's coming home", Varbits.FARMING_4773, PatchImplementation.HARDWOOD_TREE)
		), 14907);
		add(new FarmingRegion("It's coming home", 15008,
			new FarmingPatch("It's coming home", Varbits.FARMING_4771, PatchImplementation.SEAWEED),
			new FarmingPatch("It's coming home", Varbits.FARMING_4772, PatchImplementation.SEAWEED)
		));

		add(new FarmingRegion("It's coming home", 9781,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE),
			new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.FRUIT_TREE)
		));

		add(new FarmingRegion("It's coming home", 15148,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.HERB)
		));

		add(new FarmingRegion("It's coming home", 7222,
			new FarmingPatch("It's coming home", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("It's coming home", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB)
		));
		add(new FarmingRegion("It's coming home", 6711,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.SPIRIT_TREE)
		));
		add(new FarmingRegion("It's coming home", 7223,
			new FarmingPatch("It's coming home", Varbits.GRAPES_4953, PatchImplementation.GRAPES),
			new FarmingPatch("It's coming home", Varbits.GRAPES_4954, PatchImplementation.GRAPES),
			new FarmingPatch("It's coming home", Varbits.GRAPES_4955, PatchImplementation.GRAPES),
			new FarmingPatch("It's coming home", Varbits.GRAPES_4956, PatchImplementation.GRAPES),
			new FarmingPatch("It's coming home", Varbits.GRAPES_4957, PatchImplementation.GRAPES),
			new FarmingPatch("It's coming home", Varbits.GRAPES_4958, PatchImplementation.GRAPES),
			new FarmingPatch("It's coming home", Varbits.GRAPES_4959, PatchImplementation.GRAPES),
			new FarmingPatch("It's coming home", Varbits.GRAPES_4960, PatchImplementation.GRAPES),
			new FarmingPatch("It's coming home", Varbits.GRAPES_4961, PatchImplementation.GRAPES),
			new FarmingPatch("It's coming home", Varbits.GRAPES_4962, PatchImplementation.GRAPES),
			new FarmingPatch("It's coming home", Varbits.GRAPES_4963, PatchImplementation.GRAPES),
			new FarmingPatch("It's coming home", Varbits.GRAPES_4964, PatchImplementation.GRAPES)
		));

		add(new FarmingRegion("It's coming home", 9265,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE)
		));

		add(new FarmingRegion("It's coming home", 12851,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS)
		));
		add(new FarmingRegion("It's coming home", 12594,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE)
		));

		add(new FarmingRegion("It's coming home", 13622,
			new FarmingPatch("It's coming home", Varbits.FARMING_4771, PatchImplementation.MUSHROOM)
		));
		add(new FarmingRegion("It's coming home", 14391,
			new FarmingPatch("It's coming home", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("It's coming home", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB)
		));


		add(new FarmingRegion("It's coming home", 12082,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.SPIRIT_TREE)
		));

		add(new FarmingRegion("It's coming home", 11570,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH)
		), 11826);

		add(new FarmingRegion("It's coming home", 10551,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS)
		));

		add(new FarmingRegion("It's coming home", 11056,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.CALQUAT)
		));

		add(new FarmingRegion("It's coming home", 11573,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE)
		));

		add(new FarmingRegion("It's coming home", 9777,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE)
		));

		add(new FarmingRegion("It's coming home", 11321,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HERB)
		));

		add(new FarmingRegion("It's coming home", 12854,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE)
		), 12853);

		add(new FarmingRegion("It's coming home", 10288,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS)
		));

		// Finalize
		this.regions = Collections.unmodifiableMap(regions);
		Map<Tab, Set<FarmingPatch>> umtabs = new TreeMap<>();
		for (Map.Entry<Tab, Set<FarmingPatch>> e : tabs.entrySet())
		{
			umtabs.put(e.getKey(), Collections.unmodifiableSet(e.getValue()));
		}
		this.tabs = Collections.unmodifiableMap(umtabs);
	}

	private void add(FarmingRegion r, int... extraRegions)
	{
		regions.put(r.getRegionID(), r);
		for (int er : extraRegions)
		{
			regions.put(er, r);
		}
		for (FarmingPatch p : r.getPatches())
		{
			tabs
				.computeIfAbsent(p.getImplementation().getTab(), k -> new TreeSet<>(tabSorter))
				.add(p);
		}
	}
}
