/*
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.cluescrolls.clues.hotcold;

import com.google.common.collect.Sets;
import java.awt.Rectangle;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;
import static junit.framework.TestCase.assertTrue;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdSolver.isFirstPointCloser;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdSolver.isFirstPointCloserRect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class HotColdSolverTest
{
	private static final String RESPONSE_TEXT_ICE_COLD_COLDER = "The device is ice cold, but colder than last time.";
	private static final String RESPONSE_TEXT_VERY_COLD_WARMER = "The device is very cold, and warmer than last time.";
	private static final String RESPONSE_TEXT_COLD = "The device is cold.";
	private static final String RESPONSE_TEXT_COLD_COLDER = "The device is cold, but colder than last time.";
	private static final String RESPONSE_TEXT_COLD_WARMER = "The device is cold, and warmer than last time.";
	private static final String RESPONSE_TEXT_COLD_SAME_TEMP = "The device is cold, and the same temperature as last time.";
	private static final String RESPONSE_TEXT_WARM = "The device is warm.";
	private static final String RESPONSE_TEXT_WARM_SAME_TEMP = "The device is warm, and the same temperature as last time.";
	private static final String RESPONSE_TEXT_VERY_HOT = "The device is very hot.";
	private static final String RESPONSE_TEXT_VERY_HOT_COLDER = "The device is very hot, but colder than last time.";
	private static final String RESPONSE_TEXT_VERY_HOT_WARMER = "The device is very hot, and warmer than last time.";
	private static final String RESPONSE_TEXT_VERY_HOT_SAME_TEMP = "The device is very hot, and the same temperature as last time.";

	@Test
	public void testOneStepSolution()
	{
		final Set<HotColdLocation> foundLocation = Sets.immutableEnumSet(HotColdLocation.KARAMJA_KHARAZI_NE);

		testSolver(createHotColdSolver(), new WorldPoint(2852, 2992, 0), RESPONSE_TEXT_VERY_HOT, foundLocation);
	}

	@Test
	public void testIgnoreStartingTemperatureDifference()
	{
		final WorldPoint testedPoint = new WorldPoint(2852, 2992, 0);
		final Set<HotColdLocation> foundLocations = Sets.immutableEnumSet(HotColdLocation.KARAMJA_KHARAZI_NE);

		testSolver(createHotColdSolver(), testedPoint, RESPONSE_TEXT_VERY_HOT, foundLocations);
		testSolver(createHotColdSolver(), testedPoint, RESPONSE_TEXT_VERY_HOT_COLDER, foundLocations);
		testSolver(createHotColdSolver(), testedPoint, RESPONSE_TEXT_VERY_HOT_WARMER, foundLocations);
		testSolver(createHotColdSolver(), testedPoint, RESPONSE_TEXT_VERY_HOT_SAME_TEMP, foundLocations);
	}

	@Test
	public void testSameTempNoChanges()
	{
		final HotColdSolver solver = createHotColdSolver();
		final WorldPoint testedPoint = new WorldPoint(2851, 2955, 0);
		final Set<HotColdLocation> foundLocations = Sets.immutableEnumSet(
			HotColdLocation.KARAMJA_KHARAZI_NE,
			HotColdLocation.KARAMJA_KHARAZI_SW);

		testSolver(solver, testedPoint, RESPONSE_TEXT_VERY_HOT, foundLocations);
		testSolver(solver, testedPoint, RESPONSE_TEXT_VERY_HOT_SAME_TEMP, foundLocations);
	}

	@Test
	public void testNoChangesAfterSolutionFound()
	{
		final HotColdSolver solver = createHotColdSolver();
		final Set<HotColdLocation> intermediateFoundLocations = Sets.immutableEnumSet(
			HotColdLocation.KARAMJA_KHARAZI_NE,
			HotColdLocation.KARAMJA_KHARAZI_SW);
		final Set<HotColdLocation> finalLocation = Sets.immutableEnumSet(HotColdLocation.KARAMJA_KHARAZI_NE);

		testSolver(solver, new WorldPoint(2851, 2955, 0), RESPONSE_TEXT_VERY_HOT, intermediateFoundLocations);
		testSolver(solver, new WorldPoint(2852, 2955, 0), RESPONSE_TEXT_VERY_HOT_WARMER, finalLocation);
		testSolver(solver, new WorldPoint(2851, 2955, 0), RESPONSE_TEXT_VERY_HOT_COLDER, finalLocation);
		testSolver(solver, new WorldPoint(2465, 3495, 0), RESPONSE_TEXT_ICE_COLD_COLDER, finalLocation);
		testSolver(solver, new WorldPoint(3056, 3291, 0), RESPONSE_TEXT_VERY_COLD_WARMER, finalLocation);
		testSolver(solver, new WorldPoint(2571, 2956, 0), RESPONSE_TEXT_VERY_COLD_WARMER, finalLocation);
	}

	@Test
	public void testNarrowToFindSolutions()
	{
		final HotColdSolver solver = createHotColdSolver();
		final Set<HotColdLocation> firstLocationsSet = Sets.immutableEnumSet(
			HotColdLocation.FELDIP_HILLS_GNOME_GLITER,
			HotColdLocation.FELDIP_HILLS_RED_CHIN,
			HotColdLocation.KARAMJA_KHARAZI_NE,
			HotColdLocation.KARAMJA_CRASH_ISLAND);
		final Set<HotColdLocation> secondLocationsSet = firstLocationsSet.stream()
			.filter(location -> location != HotColdLocation.FELDIP_HILLS_GNOME_GLITER)
			.collect(Collectors.toSet());
		final Set<HotColdLocation> thirdLocationSet = secondLocationsSet.stream()
			.filter(location -> location != HotColdLocation.FELDIP_HILLS_RED_CHIN)
			.collect(Collectors.toSet());
		final Set<HotColdLocation> finalLocation = thirdLocationSet.stream()
			.filter(location -> location != HotColdLocation.KARAMJA_CRASH_ISLAND)
			.collect(Collectors.toSet());

		testSolver(solver, new WorldPoint(2711, 2803, 0), RESPONSE_TEXT_COLD, firstLocationsSet);
		testSolver(solver, new WorldPoint(2711, 2802, 0), RESPONSE_TEXT_COLD_SAME_TEMP, secondLocationsSet);
		testSolver(solver, new WorldPoint(2716, 2802, 0), RESPONSE_TEXT_COLD_WARMER, thirdLocationSet);
		testSolver(solver, new WorldPoint(2739, 2808, 0), RESPONSE_TEXT_COLD_WARMER, thirdLocationSet);
		testSolver(solver, new WorldPoint(2810, 2757, 0), RESPONSE_TEXT_COLD_COLDER, finalLocation);
	}

	@Test
	public void testSomewhatDistantLocations()
	{
		// Activate device on Ape Atoll when solution point is HotColdLocation.KARAMJA_KHARAZI_NE
		testSolver(createHotColdSolver(), new WorldPoint(2723, 2743, 0), RESPONSE_TEXT_COLD,
			Sets.immutableEnumSet(
				HotColdLocation.KARAMJA_KHARAZI_NE,
				HotColdLocation.KARAMJA_KHARAZI_SW,
				HotColdLocation.KARAMJA_CRASH_ISLAND,
				HotColdLocation.FELDIP_HILLS_SW,
				HotColdLocation.FELDIP_HILLS_RANTZ,
				HotColdLocation.FELDIP_HILLS_RED_CHIN,
				HotColdLocation.FELDIP_HILLS_SE));

		// Activate device near fairy ring DKP when solution point is HotColdLocation.KARAMJA_KHARAZI_NE
		testSolver(createHotColdSolver(), new WorldPoint(2900, 3111, 0), RESPONSE_TEXT_COLD,
			Sets.immutableEnumSet(
				HotColdLocation.KARAMJA_WEST_BRIMHAVEN,
				HotColdLocation.KARAMJA_KHARAZI_NE,
				HotColdLocation.ASGARNIA_COW,
				HotColdLocation.ASGARNIA_CRAFT_GUILD,
				HotColdLocation.KANDARIN_WITCHHAVEN,
				HotColdLocation.MISTHALIN_DRAYNOR_BANK));

		// Activate device on Mudskipper Point when solution point is HotColdLocation.KARAMJA_KHARAZI_NE
		testSolver(createHotColdSolver(), new WorldPoint(2985, 3106, 0), RESPONSE_TEXT_COLD,
			Sets.immutableEnumSet(
				HotColdLocation.KARAMJA_BRIMHAVEN_FRUIT_TREE,
				HotColdLocation.KARAMJA_KHARAZI_NE,
				HotColdLocation.ASGARNIA_COW,
				HotColdLocation.ASGARNIA_CRAFT_GUILD,
				HotColdLocation.MISTHALIN_LUMBRIDGE_2,
				HotColdLocation.DESERT_BEDABIN_CAMP));
	}

	@Test
	public void testZeahLocationNarrowing()
	{
		// Start with western Lovakengj sulphur mine and west of farming guild locations remaining
		HotColdSolver solver = new HotColdSolver(EnumSet.of(
			HotColdLocation.ZEAH_SULPHR_MINE,
			HotColdLocation.ZEAH_FARMING_GUILD_W
		));

		testSolver(solver, new WorldPoint(1348, 3740, 0), RESPONSE_TEXT_WARM,
			Sets.immutableEnumSet(
				HotColdLocation.ZEAH_SULPHR_MINE,
				HotColdLocation.ZEAH_FARMING_GUILD_W));
		testSolver(solver, new WorldPoint(1347, 3740, 0), RESPONSE_TEXT_WARM_SAME_TEMP,
			Sets.immutableEnumSet(HotColdLocation.ZEAH_SULPHR_MINE));
	}

	@Test
	public void testIsFirstPointCloserRect()
	{
		assertFalse(isFirstPointCloserRect(new WorldPoint(0, 0, 0), new WorldPoint(0, 0, 0), new Rectangle(0, 0, 1, 1)));
		assertFalse(isFirstPointCloserRect(new WorldPoint(1, 0, 0), new WorldPoint(5, 0, 0), new Rectangle(2, 1, 5, 5)));
		assertFalse(isFirstPointCloserRect(new WorldPoint(1, 0, 0), new WorldPoint(0, 0, 0), new Rectangle(2, 0, 1, 2)));
		assertFalse(isFirstPointCloserRect(new WorldPoint(0, 0, 0), new WorldPoint(1, 1, 1), new Rectangle(2, 2, 2, 2)));
		assertFalse(isFirstPointCloserRect(new WorldPoint(0, 0, 0), new WorldPoint(4, 4, 4), new Rectangle(1, 1, 2, 2)));
		assertFalse(isFirstPointCloserRect(new WorldPoint(3, 2, 0), new WorldPoint(1, 5, 0), new Rectangle(0, 0, 4, 4)));

		assertTrue(isFirstPointCloserRect(new WorldPoint(1, 1, 0), new WorldPoint(0, 1, 0), new Rectangle(2, 0, 3, 2)));
		assertTrue(isFirstPointCloserRect(new WorldPoint(4, 4, 0), new WorldPoint(1, 1, 0), new Rectangle(3, 3, 2, 2)));
		assertTrue(isFirstPointCloserRect(new WorldPoint(3, 2, 0), new WorldPoint(7, 0, 0), new Rectangle(1, 3, 4, 2)));

	}

	@Test
	public void testIsFirstPointCloser()
	{
		assertFalse(isFirstPointCloser(new WorldPoint(0, 0, 0), new WorldPoint(0, 0, 0), new WorldPoint(0, 0, 0)));
		assertFalse(isFirstPointCloser(new WorldPoint(0, 0, 0), new WorldPoint(0, 0, 1), new WorldPoint(0, 0, 0)));
		assertFalse(isFirstPointCloser(new WorldPoint(1, 0, 0), new WorldPoint(0, 0, 0), new WorldPoint(1, 1, 0)));
		assertFalse(isFirstPointCloser(new WorldPoint(2, 2, 0), new WorldPoint(0, 0, 0), new WorldPoint(1, 1, 0)));

		assertTrue(isFirstPointCloser(new WorldPoint(1, 0, 0), new WorldPoint(0, 0, 0), new WorldPoint(2, 0, 0)));
		assertTrue(isFirstPointCloser(new WorldPoint(1, 1, 0), new WorldPoint(1, 0, 0), new WorldPoint(2, 2, 0)));
		assertTrue(isFirstPointCloser(new WorldPoint(1, 1, 1), new WorldPoint(0, 1, 0), new WorldPoint(1, 1, 0)));
	}

	/**
	 * Tests a hot-cold solver by signalling a test point, temperature, and temperature change to it and asserting the
	 * resulting possible location set is equal to that of a given set of expected locations.
	 *
	 * @param solver                             The hot-cold solver to signal to.
	 *                                           <br>
	 *                                           Note: This will mutate the passed solver, which is helpful for testing
	 *                                           multiple sequential steps.
	 * @param testPoint                          The {@link WorldPoint} where the signal occurs.
	 * @param deviceResponse                     The string containing the temperature and temperature change which is
	 *                                           given when the hot-cold checking device is activated.
	 * @param expectedRemainingPossibleLocations A {@link Set} of {@link HotColdLocation}s which is expected to be
	 *                                           given by {@link HotColdSolver#getPossibleLocations()} after it receives
	 *                                           the signal formed by the other given arguments.
	 */
	private static void testSolver(final HotColdSolver solver, final WorldPoint testPoint, final String deviceResponse, final Set<HotColdLocation> expectedRemainingPossibleLocations)
	{
		final HotColdTemperature temperature = HotColdTemperature.getFromTemperatureSet(HotColdTemperature.MASTER_HOT_COLD_TEMPERATURES, deviceResponse);
		final HotColdTemperatureChange temperatureChange = HotColdTemperatureChange.of(deviceResponse);

		assertNotNull(temperature);
		assertEquals(expectedRemainingPossibleLocations, solver.signal(testPoint, temperature, temperatureChange));
	}

	/**
	 * @return A hot-cold solver with a starting set of master hot-cold locations nearby the KARAMJA_KHARAZI_NE
	 *         location. {@link HotColdLocation#values()} is not used as it may change with future game updates, and
	 *         such changes would break this test suite.
	 */
	private static HotColdSolver createHotColdSolver()
	{
		final Set<HotColdLocation> hotColdLocations = EnumSet.of(
			HotColdLocation.KARAMJA_KHARAZI_NE,
			HotColdLocation.KARAMJA_KHARAZI_SW,
			HotColdLocation.KARAMJA_GLIDER,
			HotColdLocation.KARAMJA_MUSA_POINT,
			HotColdLocation.KARAMJA_BRIMHAVEN_FRUIT_TREE,
			HotColdLocation.KARAMJA_WEST_BRIMHAVEN,
			HotColdLocation.KARAMJA_CRASH_ISLAND,
			HotColdLocation.DESERT_BEDABIN_CAMP,
			HotColdLocation.DESERT_MENAPHOS_GATE,
			HotColdLocation.DESERT_POLLNIVNEACH,
			HotColdLocation.DESERT_SHANTY,
			HotColdLocation.MISTHALIN_LUMBRIDGE,
			HotColdLocation.MISTHALIN_LUMBRIDGE_2,
			HotColdLocation.MISTHALIN_DRAYNOR_BANK,
			HotColdLocation.ASGARNIA_COW,
			HotColdLocation.ASGARNIA_PARTY_ROOM,
			HotColdLocation.ASGARNIA_CRAFT_GUILD,
			HotColdLocation.ASGARNIA_RIMMINGTON,
			HotColdLocation.ASGARNIA_MUDSKIPPER,
			HotColdLocation.KANDARIN_WITCHHAVEN,
			HotColdLocation.KANDARIN_NECRO_TOWER,
			HotColdLocation.KANDARIN_FIGHT_ARENA,
			HotColdLocation.KANDARIN_TREE_GNOME_VILLAGE,
			HotColdLocation.FELDIP_HILLS_GNOME_GLITER,
			HotColdLocation.FELDIP_HILLS_JIGGIG,
			HotColdLocation.FELDIP_HILLS_RANTZ,
			HotColdLocation.FELDIP_HILLS_RED_CHIN,
			HotColdLocation.FELDIP_HILLS_SE,
			HotColdLocation.FELDIP_HILLS_SOUTH,
			HotColdLocation.FELDIP_HILLS_SW
		);
		return new HotColdSolver(hotColdLocations);
	}
}
