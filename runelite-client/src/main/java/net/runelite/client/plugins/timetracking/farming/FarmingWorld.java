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

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lombok.Getter;
import net.runelite.api.NpcID;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.timetracking.Tab;

@Singleton
class FarmingWorld
{
	@SuppressWarnings("PMD.ImmutableField")
	private Multimap<Integer, FarmingRegion> regions = HashMultimap.create();
	private Map<Integer, FarmingPatch> patchByJagexID = new HashMap<>();

	@Getter
	private Map<Tab, Set<FarmingPatch>> tabs = new HashMap<>();

	private final Comparator<FarmingPatch> tabSorter = Comparator
		.comparing(FarmingPatch::getImplementation)
		.thenComparing((FarmingPatch p) -> p.getRegion().getName())
		.thenComparing(FarmingPatch::getName);

	@Getter
	private final FarmingRegion farmingGuildRegion;

	FarmingWorld()
	{
		// Some of these patches get updated in multiple regions.
		// It may be worth it to add a specialization for these patches
		add(new FarmingRegion("Al Kharid", 13106, false,
				new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.CACTUS, 36, NpcID.AYESHA)), 13362,
			13105);

		add(new FarmingRegion("Ardougne", 10290, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH, 23, NpcID.TORRELL)), 10546);
		add(new FarmingRegion("Ardougne", 10548, false,
			new FarmingPatch("North", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT, 12, NpcID.KRAGEN),
			new FarmingPatch("South", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT, 13, NpcID.KRAGEN),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER, 29),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB, 45),
			new FarmingPatch("", Varbits.FARMING_4775, PatchImplementation.COMPOST, 42)));

		add(new FarmingRegion("Brimhaven", 11058, false,
				new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE, 6, NpcID.GARTH),
				new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.SPIRIT_TREE, 26, NpcID.PRAISTAN_EBOLA)),
			11057);

		add(new FarmingRegion("Catherby", 11062, false,
			new FarmingPatch("North", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT, 10, NpcID.DANTAERA),
			new FarmingPatch("South", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT, 11, NpcID.DANTAERA),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER, 28),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB, 44),
			new FarmingPatch("", Varbits.FARMING_4775, PatchImplementation.COMPOST, 40))
		{
			@Override
			public boolean isInBounds(WorldPoint loc)
			{
				if (loc.getX() >= 2816 && loc.getY() < 3456)
				{
					// Upstairs sends different varbits
					return loc.getX() < 2840 && loc.getY() >= 3440 && loc.getPlane() == 0;
				}
				return true;
			}
		}, 11061, 11318, 11317);
		add(new FarmingRegion("Catherby", 11317, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE, 7, NpcID.ELLENA))
		{
			// The fruit tree patch is always sent when upstairs in 11317
			@Override
			public boolean isInBounds(WorldPoint loc)
			{
				return loc.getX() >= 2840 || loc.getY() < 3440 || loc.getPlane() == 1;
			}
		});

		add(new FarmingRegion("Champions' Guild", 12596, true,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH, 20, NpcID.DREVEN)));

		add(new FarmingRegion("Draynor Manor", 12340, false,
			new FarmingPatch("Belladonna", Varbits.FARMING_4771, PatchImplementation.BELLADONNA, 38)));

		add(new FarmingRegion("Entrana", 11060, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS, 17, NpcID.FRANCIS)), 11316);

		add(new FarmingRegion("Etceteria", 10300, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH, 22, NpcID.RHAZIEN),
			new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.SPIRIT_TREE, 25, NpcID.YULF_SQUECKS)));

		add(new FarmingRegion("Falador", 11828, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE, 1, NpcID.HESKEL)), 12084);
		add(new FarmingRegion("Falador", 12083, false,
			new FarmingPatch("North West", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT, 8, NpcID.ELSTAN),
			new FarmingPatch("South East", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT, 9, NpcID.ELSTAN),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER, 27),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB, 43),
			new FarmingPatch("", Varbits.FARMING_4775, PatchImplementation.COMPOST, 39))
		{
			@Override
			public boolean isInBounds(WorldPoint loc)
			{
				// Not on region boundary due to Port Sarim Spirit Tree patch
				return loc.getY() >= 3272;
			}
		});

		add(new FarmingRegion("Fossil Island", 14651, false,
			new FarmingPatch("East", Varbits.FARMING_4771, PatchImplementation.HARDWOOD_TREE, 149,
				NpcID.SQUIRREL_7754),
			new FarmingPatch("Middle", Varbits.FARMING_4772, PatchImplementation.HARDWOOD_TREE, 150,
				NpcID.SQUIRREL_7755),
			new FarmingPatch("West", Varbits.FARMING_4773, PatchImplementation.HARDWOOD_TREE, 151,
				NpcID.SQUIRREL_7756))
		{
			@Override
			public boolean isInBounds(WorldPoint loc)
			{
				// Hardwood tree varbits are sent anywhere on plane 0 of fossil island.
				// Varbits get sent 1 tick earlier than expected when climbing certain ladders
				// and stairs

				// Stairs to house on the hill
				if (loc.getX() == 3753 && loc.getY() >= 3868 && loc.getY() <= 3870)
				{
					return false;
				}

				// East and west ladders to rope bridge
				if ((loc.getX() == 3729 || loc.getX() == 3728 || loc.getX() == 3747 || loc.getX() == 3746)
					&& loc.getY() <= 3832 && loc.getY() >= 3830)
				{
					return false;
				}

				return loc.getPlane() == 0;
			}
		}, 14907, 14908, 15164, 14652, 14906, 14650, 15162, 15163);
		add(new FarmingRegion("Seaweed", 15008, false,
			new FarmingPatch("North", Varbits.FARMING_4771, PatchImplementation.SEAWEED, 147, NpcID.MERNIA),
			new FarmingPatch("South", Varbits.FARMING_4772, PatchImplementation.SEAWEED, 148, NpcID.MERNIA)));

		add(new FarmingRegion("Gnome Stronghold", 9781, true,
				new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE, 48, NpcID.PRISSY_SCILLA),
				new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.FRUIT_TREE, 4, NpcID.BOLONGO)), 9782,
			9526, 9525);

		add(new FarmingRegion("Harmony", 15148, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT, 142),
			new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.HERB, 143)));

		add(new FarmingRegion("Kourend", 6967, false,
				new FarmingPatch("North East", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT, 51, NpcID.MARISI),
				new FarmingPatch("South West", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT, 52, NpcID.MARISI),
				new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER, 53),
				new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB, 54),
				new FarmingPatch("", Varbits.FARMING_4775, PatchImplementation.COMPOST, 55),
				new FarmingPatch("", Varbits.FARMING_7904, PatchImplementation.SPIRIT_TREE, 50, NpcID.LAMMY_LANGLE)),
			6711);
		add(new FarmingRegion("Kourend", 7223, false,
			new FarmingPatch("East 1", Varbits.GRAPES_4953, PatchImplementation.GRAPES, 62),
			new FarmingPatch("East 2", Varbits.GRAPES_4954, PatchImplementation.GRAPES, 63),
			new FarmingPatch("East 3", Varbits.GRAPES_4955, PatchImplementation.GRAPES, 64),
			new FarmingPatch("East 4", Varbits.GRAPES_4956, PatchImplementation.GRAPES, 65),
			new FarmingPatch("East 5", Varbits.GRAPES_4957, PatchImplementation.GRAPES, 66),
			new FarmingPatch("East 6", Varbits.GRAPES_4958, PatchImplementation.GRAPES, 67),
			new FarmingPatch("West 1", Varbits.GRAPES_4959, PatchImplementation.GRAPES, 56),
			new FarmingPatch("West 2", Varbits.GRAPES_4960, PatchImplementation.GRAPES, 57),
			new FarmingPatch("West 3", Varbits.GRAPES_4961, PatchImplementation.GRAPES, 58),
			new FarmingPatch("West 4", Varbits.GRAPES_4962, PatchImplementation.GRAPES, 59),
			new FarmingPatch("West 5", Varbits.GRAPES_4963, PatchImplementation.GRAPES, 60),
			new FarmingPatch("West 6", Varbits.GRAPES_4964, PatchImplementation.GRAPES, 61)));

		add(new FarmingRegion("Lletya", 9265, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE, 49, NpcID.LILIWEN)), 11103);

		add(new FarmingRegion("Lumbridge", 12851, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS, 18, NpcID.VASQUEN)));
		add(new FarmingRegion("Lumbridge", 12594, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE, 3, NpcID.FAYETH)), 12850);

		add(new FarmingRegion("Morytania", 13622, false,
			new FarmingPatch("Mushroom", Varbits.FARMING_4771, PatchImplementation.MUSHROOM, 37)), 13878);
		add(new FarmingRegion("Morytania", 14391, false,
			new FarmingPatch("North West", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT, 14, NpcID.LYRA),
			new FarmingPatch("South East", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT, 15, NpcID.LYRA),
			new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER, 30),
			new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.HERB, 46),
			new FarmingPatch("", Varbits.FARMING_4775, PatchImplementation.COMPOST, 41)), 14390);

		add(new FarmingRegion("Port Sarim", 12082, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.SPIRIT_TREE, 24, NpcID.FRIZZY_SKERNIP))
		{
			@Override
			public boolean isInBounds(WorldPoint loc)
			{
				return loc.getY() < 3272;
			}
		}, 12083);

		add(new FarmingRegion("Rimmington", 11570, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.BUSH, 21, NpcID.TARIA)), 11826);

		add(new FarmingRegion("Seers' Village", 10551, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS, 19, NpcID.RHONEN)), 10550);

		add(new FarmingRegion("Tai Bwo Wannai", 11056, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.CALQUAT, 31, NpcID.IMIAGO)));

		add(new FarmingRegion("Taverley", 11573, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE, 0, NpcID.ALAIN)), 11829);

		add(new FarmingRegion("Tree Gnome Village", 9777, true,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.FRUIT_TREE, 5, NpcID.GILETH)), 10033);

		add(new FarmingRegion("Troll Stronghold", 11321, true,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HERB, 47)));

		add(new FarmingRegion("Varrock", 12854, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.TREE, 2, NpcID.TREZNOR_11957)), 12853);

		add(new FarmingRegion("Yanille", 10288, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HOPS, 16, NpcID.SELENA)));

		add(new FarmingRegion("Weiss", 11325, false,
			new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.HERB, 152)));

		add(new FarmingRegion("Farming Guild", 5021, true,
			new FarmingPatch("Hespori", Varbits.FARMING_7908, PatchImplementation.HESPORI, 164)));

		// Full 3x3 region area centered on farming guild
		add(farmingGuildRegion = new FarmingRegion("Farming Guild", 4922, true,
				new FarmingPatch("", Varbits.FARMING_7905, PatchImplementation.TREE, 160, NpcID.ROSIE),
				new FarmingPatch("", Varbits.FARMING_4775, PatchImplementation.HERB, 158),
				new FarmingPatch("", Varbits.FARMING_4772, PatchImplementation.BUSH, 155, NpcID.ALAN),
				new FarmingPatch("", Varbits.FARMING_7906, PatchImplementation.FLOWER, 161),
				new FarmingPatch("North", Varbits.FARMING_4773, PatchImplementation.ALLOTMENT, 156, NpcID.ALAN),
				new FarmingPatch("South", Varbits.FARMING_4774, PatchImplementation.ALLOTMENT, 157, NpcID.ALAN),
				new FarmingPatch("", Varbits.FARMING_7912, PatchImplementation.GIANT_COMPOST, 141),
				new FarmingPatch("", Varbits.FARMING_7904, PatchImplementation.CACTUS, 159, NpcID.ALAN),
				new FarmingPatch("", Varbits.FARMING_4771, PatchImplementation.SPIRIT_TREE, 154,
					NpcID.LATLINK_FASTBELL),
				new FarmingPatch("", Varbits.FARMING_7909, PatchImplementation.FRUIT_TREE, 153, NpcID.NIKKIE),
				new FarmingPatch("Anima", Varbits.FARMING_7911, PatchImplementation.ANIMA, 165),
				new FarmingPatch("", Varbits.FARMING_7910, PatchImplementation.CELASTRUS, 163, NpcID.TAYLOR),
				new FarmingPatch("", Varbits.FARMING_7907, PatchImplementation.REDWOOD, 162, NpcID.ALEXANDRA)), 5177,
			5178, 5179, 4921, 4923, 4665, 4666, 4667);

		// All of Prifddinas, and all of Prifddinas Underground
		add(new FarmingRegion("Prifddinas", 13151, false,
				new FarmingPatch("North", Varbits.FARMING_4771, PatchImplementation.ALLOTMENT, 166, NpcID.OSWALLT),
				new FarmingPatch("South", Varbits.FARMING_4772, PatchImplementation.ALLOTMENT, 167, NpcID.OSWALLT),
				new FarmingPatch("", Varbits.FARMING_4773, PatchImplementation.FLOWER, 168),
				new FarmingPatch("", Varbits.FARMING_4775, PatchImplementation.CRYSTAL_TREE, 170),
				new FarmingPatch("", Varbits.FARMING_4774, PatchImplementation.COMPOST, 169) // TODO: Find correct
				// varbit
			), 12895, 12894, 13150,
			/* Underground */ 12994, 12993, 12737, 12738, 12126, 12127, 13250);

		// Finalize
		this.regions = Multimaps.unmodifiableMultimap(this.regions);
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
			patchByJagexID.put(p.getJagexID(), p);
		}
	}

	Collection<FarmingRegion> getRegionsForLocation(WorldPoint location)
	{
		return this.regions.get(location.getRegionID()).stream()
			.filter(region -> region.isInBounds(location))
			.collect(Collectors.toSet());
	}

	FarmingPatch getPatchByJagexID(int jagexID)
	{
		return this.patchByJagexID.get(jagexID);
	}
}
