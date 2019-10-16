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
package net.runelite.client.plugins.timetracking.farming;

import com.google.common.collect.ImmutableMap;
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
import net.runelite.client.plugins.timetracking.Tab;

@Singleton
class FarmingWorld
{
	@Getter
	private final ImmutableMap<Integer, FarmingRegion> regions;

	@Getter
	private Map<Tab, Set<FarmingPatch>> tabs = new HashMap<>();

	private final Comparator<FarmingPatch> tabSorter = Comparator
		.comparing(FarmingPatch::getImplementation)
		.thenComparing((FarmingPatch p) -> p.getRegion().getName())
		.thenComparing(FarmingPatch::getName);

	FarmingWorld()
	{
		ImmutableMap.Builder<Integer, FarmingRegion> regionBuilder = ImmutableMap.builderWithExpectedSize(40);

		// Some of these patches get updated in multiple regions.
		// It may be worth it to add a specialization for these patches
		add(regionBuilder, new FarmingRegion("Al Kharid", 13106,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.CACTUS)
		));

		add(regionBuilder, new FarmingRegion("Ardougne", 10290,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH)
		));
		add(regionBuilder, new FarmingRegion("Ardougne", 10548,
			new FarmingPatch("North", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("South", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB)
		));

		add(regionBuilder, new FarmingRegion("Brimhaven", 11058,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE),
			new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.SPIRIT_TREE)
		));

		add(regionBuilder, new FarmingRegion("Catherby", 11062,
			new FarmingPatch("North", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("South", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB)
		));
		add(regionBuilder, new FarmingRegion("Catherby", 11317,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE)
		));

		add(regionBuilder, new FarmingRegion("Champions' Guild", 12596,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH)
		));

		add(regionBuilder, new FarmingRegion("Draynor Manor", 12340,
			new FarmingPatch("Belladonna", Varbits.FARMING_4771, PatchImplementation.BELLADONNA)
		));

		add(regionBuilder, new FarmingRegion("Entrana", 11060,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS)
		));

		add(regionBuilder, new FarmingRegion("Etceteria", 10300,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH),
			new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.SPIRIT_TREE)
		));

		add(regionBuilder, new FarmingRegion("Falador", 11828,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE)
		));
		add(regionBuilder, new FarmingRegion("Falador", 12083,
			new FarmingPatch("North West", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("South East", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT),
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

		add(regionBuilder, new FarmingRegion("Fossil Island", 14651,
			new FarmingPatch("East", Varbits.FARMING_4771, PatchImplementation.HARDWOOD_TREE),
			new FarmingPatch("Middle", Varbits.FARMING_4772, PatchImplementation.HARDWOOD_TREE),
			new FarmingPatch("West", Varbits.FARMING_4773, PatchImplementation.HARDWOOD_TREE)
		), 14907);
		add(regionBuilder, new FarmingRegion("Seaweed", 15008,
			new FarmingPatch("North", Varbits.FARMING_4771, PatchImplementation.SEAWEED),
			new FarmingPatch("South", Varbits.FARMING_4772, PatchImplementation.SEAWEED)
		));

		add(regionBuilder, new FarmingRegion("Gnome Stronghold", 9781,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE),
			new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.FRUIT_TREE)
		));

		add(regionBuilder, new FarmingRegion("Harmony", 15148,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.HERB)
		));

		add(regionBuilder, new FarmingRegion("Kourend", 6967,
			new FarmingPatch("North East", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("South West", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB)
		));
		add(regionBuilder, new FarmingRegion("Kourend", 6711,
			new FarmingPatch("", Varbits.FARMING_7904, PatchImplementation.SPIRIT_TREE)
		));
		add(regionBuilder, new FarmingRegion("Kourend", 7223,
			new FarmingPatch("East 1", Varbits.GRAPES_4953, PatchImplementation.GRAPES),
			new FarmingPatch("East 2", Varbits.GRAPES_4954, PatchImplementation.GRAPES),
			new FarmingPatch("East 3", Varbits.GRAPES_4955, PatchImplementation.GRAPES),
			new FarmingPatch("East 4", Varbits.GRAPES_4956, PatchImplementation.GRAPES),
			new FarmingPatch("East 5", Varbits.GRAPES_4957, PatchImplementation.GRAPES),
			new FarmingPatch("East 6", Varbits.GRAPES_4958, PatchImplementation.GRAPES),
			new FarmingPatch("West 1", Varbits.GRAPES_4959, PatchImplementation.GRAPES),
			new FarmingPatch("West 2", Varbits.GRAPES_4960, PatchImplementation.GRAPES),
			new FarmingPatch("West 3", Varbits.GRAPES_4961, PatchImplementation.GRAPES),
			new FarmingPatch("West 4", Varbits.GRAPES_4962, PatchImplementation.GRAPES),
			new FarmingPatch("West 5", Varbits.GRAPES_4963, PatchImplementation.GRAPES),
			new FarmingPatch("West 6", Varbits.GRAPES_4964, PatchImplementation.GRAPES)
		));

		add(regionBuilder, new FarmingRegion("Lletya", 9265,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE)
		));

		add(regionBuilder, new FarmingRegion("Lumbridge", 12851,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS)
		));
		add(regionBuilder, new FarmingRegion("Lumbridge", 12594,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE)
		));

		add(regionBuilder, new FarmingRegion("Morytania", 13622,
			new FarmingPatch("Mushroom", Varbits.FARMING_4771, PatchImplementation.MUSHROOM)
		));
		add(regionBuilder, new FarmingRegion("Morytania", 14391,
			new FarmingPatch("North West", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("South East", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB)
		));


		add(regionBuilder, new FarmingRegion("Port Sarim", 12082,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.SPIRIT_TREE)
		));

		add(regionBuilder, new FarmingRegion("Rimmington", 11570,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH)
		), 11826);

		add(regionBuilder, new FarmingRegion("Seers' Village", 10551,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS)
		));

		add(regionBuilder, new FarmingRegion("Tai Bwo Wannai", 11056,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.CALQUAT)
		));

		add(regionBuilder, new FarmingRegion("Taverley", 11573,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE)
		));

		add(regionBuilder, new FarmingRegion("Tree Gnome Village", 9777,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE)
		));

		add(regionBuilder, new FarmingRegion("Troll Stronghold", 11321,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HERB)
		));

		add(regionBuilder, new FarmingRegion("Varrock", 12854,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE)
		), 12853);

		add(regionBuilder, new FarmingRegion("Yanille", 10288,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS)
		));

		add(regionBuilder, new FarmingRegion("Weiss", 11325,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HERB)
		));

		add(regionBuilder, new FarmingRegion("Farming Guild", 5021,
			new FarmingPatch("Hespori", Varbits.FARMING_7908, PatchImplementation.HESPORI)
		));

		add(regionBuilder, new FarmingRegion("Farming Guild", 4922,
			new FarmingPatch("", Varbits.FARMING_7905, PatchImplementation.TREE),
			new FarmingPatch("", Varbits.FARMING_4775, PatchImplementation.HERB),
			new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.BUSH),
			new FarmingPatch("", Varbits.FARMING_7906, PatchImplementation.FLOWER),
			new FarmingPatch("North", Varbits.FARMING_4773, PatchImplementation.ALLOTMENT),
			new FarmingPatch("South", Varbits.FARMING_4774, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_7904, PatchImplementation.CACTUS),
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.SPIRIT_TREE),
			new FarmingPatch("", Varbits.FARMING_7909, PatchImplementation.FRUIT_TREE),
			new FarmingPatch("Anima", Varbits.FARMING_7911, PatchImplementation.ANIMA),
			new FarmingPatch("", Varbits.FARMING_7910, PatchImplementation.CELASTRUS),
			new FarmingPatch("", Varbits.FARMING_7907, PatchImplementation.REDWOOD)
		));

		add(regionBuilder, new FarmingRegion("Prifddinas", 13151,
			new FarmingPatch("North", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT),
			new FarmingPatch("South", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER),
			new FarmingPatch("", Varbits.FARMING_4775, PatchImplementation.CRYSTAL_TREE)
		));

		// Finalize
		this.regions = regionBuilder.build();

		Map<Tab, Set<FarmingPatch>> umtabs = new TreeMap<>();
		for (Map.Entry<Tab, Set<FarmingPatch>> e : tabs.entrySet())
		{
			umtabs.put(e.getKey(), Collections.unmodifiableSet(e.getValue()));
		}
		this.tabs = Collections.unmodifiableMap(umtabs);
	}

	private void add(ImmutableMap.Builder<Integer, FarmingRegion> builder, FarmingRegion r, int... extraRegions)
	{
		builder.put(r.getRegionID(), r);
		for (int er : extraRegions)
		{
			builder.put(er, r);
		}
		for (FarmingPatch p : r.getPatches())
		{
			tabs
				.computeIfAbsent(p.getImplementation().getTab(), k -> new TreeSet<>(tabSorter))
				.add(p);
		}
	}
}
