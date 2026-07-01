/*
 * Copyright (c) 2020 Cyborger1
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

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.SummaryState;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FarmingContractManagerTest
{
	private Map<Integer, FarmingPatch> farmingGuildPatches = new HashMap<>();

	@Inject
	private FarmingContractManager farmingContractManager;

	@Inject
	private FarmingWorld farmingWorld;

	@Mock
	@Bind
	private TimeTrackingConfig config;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private FarmingTracker farmingTracker;

	@Mock
	@Bind
	private ConfigManager configManager;

	@Mock
	@Bind
	private Notifier notifier;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	private ScheduledExecutorService executor;

	@Mock
	@Bind
	private ClientToolbar clientToolbar;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		for (FarmingPatch p : farmingWorld.getFarmingGuildRegion().getPatches())
		{
			farmingGuildPatches.put(p.getVarbit(), p);
		}

		// Consider all patches to be empty by default
		when(farmingTracker.predictPatch(any(FarmingPatch.class)))
			.thenReturn(new PatchPrediction(null, null, 0, 0, 0));
	}

	@Test
	public void cabbageContractOnionHarvestableAndCabbageHarvestable()
	{
		final long unixNow = Instant.now().getEpochSecond();

		// Get the two allotment patches
		final FarmingPatch patch1 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);
		final FarmingPatch patch2 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_D);

		assertNotNull(patch1);
		assertNotNull(patch2);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch1))
			.thenReturn(new PatchPrediction(Produce.ONION, CropState.HARVESTABLE, unixNow, 3, 3));
		when(farmingTracker.predictPatch(patch2))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.HARVESTABLE, unixNow, 3, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.COMPLETED, farmingContractManager.getSummary());
	}

	@Test
	public void cabbageContractOnionHarvestableAndPotatoHarvestable()
	{
		final long unixNow = Instant.now().getEpochSecond();

		// Get the two allotment patches
		final FarmingPatch patch1 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);
		final FarmingPatch patch2 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_D);

		assertNotNull(patch1);
		assertNotNull(patch2);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch1))
			.thenReturn(new PatchPrediction(Produce.ONION, CropState.HARVESTABLE, unixNow, 3, 3));
		when(farmingTracker.predictPatch(patch2))
			.thenReturn(new PatchPrediction(Produce.POTATO, CropState.HARVESTABLE, unixNow, 3, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.OCCUPIED, farmingContractManager.getSummary());
	}

	@Test
	public void cabbageContractOnionHarvestableAndEmptyPatch()
	{
		final long unixNow = Instant.now().getEpochSecond();

		// Get the two allotment patches
		final FarmingPatch patch = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);

		assertNotNull(patch);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch))
			.thenReturn(new PatchPrediction(Produce.ONION, CropState.HARVESTABLE, unixNow, 3, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.EMPTY, farmingContractManager.getSummary());
	}

	@Test
	public void cabbageContractOnionHarvestableAndCabbageGrowing()
	{
		final long unixNow = Instant.now().getEpochSecond();
		final long expectedTime = unixNow + 60;

		// Get the two allotment patches
		final FarmingPatch patch1 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);
		final FarmingPatch patch2 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_D);

		assertNotNull(patch1);
		assertNotNull(patch2);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch1))
			.thenReturn(new PatchPrediction(Produce.ONION, CropState.HARVESTABLE, unixNow, 3, 3));
		when(farmingTracker.predictPatch(patch2))
			.thenReturn(new PatchPrediction(
				Produce.CABBAGE, CropState.GROWING, expectedTime, 2, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		assertEquals(CropState.GROWING, farmingContractManager.getContractCropState());
		assertEquals(expectedTime, farmingContractManager.getCompletionTime());
	}

	@Test
	public void cabbageContractOnionHarvestableAndCabbageDiseased()
	{
		final long unixNow = Instant.now().getEpochSecond();

		// Get the two allotment patches
		final FarmingPatch patch1 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);
		final FarmingPatch patch2 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_D);

		assertNotNull(patch1);
		assertNotNull(patch2);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch1))
			.thenReturn(new PatchPrediction(Produce.ONION, CropState.HARVESTABLE, unixNow, 3, 3));
		when(farmingTracker.predictPatch(patch2))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.DISEASED, 0, 2, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		assertEquals(CropState.DISEASED, farmingContractManager.getContractCropState());
	}

	@Test
	public void cabbageContractOnionHarvestableAndCabbageDead()
	{
		final long unixNow = Instant.now().getEpochSecond();

		// Get the two allotment patches
		final FarmingPatch patch1 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);
		final FarmingPatch patch2 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_D);

		assertNotNull(patch1);
		assertNotNull(patch2);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch1))
			.thenReturn(new PatchPrediction(Produce.ONION, CropState.HARVESTABLE, unixNow, 3, 3));
		when(farmingTracker.predictPatch(patch2))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.DEAD, 0, 2, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		assertEquals(CropState.DEAD, farmingContractManager.getContractCropState());
	}

	@Test
	public void cabbageContractCabbageGrowingAndCabbageDead()
	{
		final long unixNow = Instant.now().getEpochSecond();
		final long expected = unixNow + 60;

		// Get the two allotment patches
		final FarmingPatch patch1 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);
		final FarmingPatch patch2 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_D);

		assertNotNull(patch1);
		assertNotNull(patch2);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch1))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.GROWING, expected, 2, 3));
		when(farmingTracker.predictPatch(patch2))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.DEAD, 0, 2, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
	}

	@Test
	public void cabbageContractCabbageHarvestableAndCabbageDead()
	{
		final long unixNow = Instant.now().getEpochSecond();

		// Get the two allotment patches
		final FarmingPatch patch1 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);
		final FarmingPatch patch2 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_D);

		assertNotNull(patch1);
		assertNotNull(patch2);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch1))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.DEAD, 0, 2, 3));
		when(farmingTracker.predictPatch(patch2))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.HARVESTABLE, unixNow, 3, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.COMPLETED, farmingContractManager.getSummary());
	}

	@Test
	public void cabbageContractTwoCabbagesGrowing()
	{
		final long unixNow = Instant.now().getEpochSecond();
		final long expected1 = unixNow + 60;
		final long expected2 = unixNow + 120;

		// Get the two allotment patches
		final FarmingPatch patch1 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);
		final FarmingPatch patch2 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_D);

		assertNotNull(patch1);
		assertNotNull(patch2);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch1))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.GROWING, expected1, 2, 3));
		when(farmingTracker.predictPatch(patch2))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.GROWING, expected2, 1, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		assertEquals(CropState.GROWING, farmingContractManager.getContractCropState());
		// Prefer closest estimated time
		assertEquals(expected1, farmingContractManager.getCompletionTime());
	}

	@Test
	public void cabbageContractCabbageGrowingAndCabbageDiseased()
	{
		final long unixNow = Instant.now().getEpochSecond();
		final long expectedTime = unixNow + 60;

		// Get the two allotment patches
		final FarmingPatch patch1 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);
		final FarmingPatch patch2 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_D);

		assertNotNull(patch1);
		assertNotNull(patch2);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch1))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.DISEASED, 0, 2, 3));
		when(farmingTracker.predictPatch(patch2))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.GROWING, expectedTime, 2, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		// Prefer healthy cabbages
		assertEquals(CropState.GROWING, farmingContractManager.getContractCropState());
		assertEquals(expectedTime, farmingContractManager.getCompletionTime());
	}

	@Test
	public void cabbageContractCabbageDiseasedAndCabbageGrowing()
	{
		final long unixNow = Instant.now().getEpochSecond();
		final long expectedTime = unixNow + 60;

		// Get the two allotment patches
		final FarmingPatch patch1 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);
		final FarmingPatch patch2 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_D);

		assertNotNull(patch1);
		assertNotNull(patch2);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch1))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.GROWING, expectedTime, 2, 3));
		when(farmingTracker.predictPatch(patch2))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.DISEASED, 0, 2, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		// Prefer healthy cabbages
		assertEquals(CropState.GROWING, farmingContractManager.getContractCropState());
		assertEquals(expectedTime, farmingContractManager.getCompletionTime());
	}

	@Test
	public void cabbageContractCabbageDeadAndCabbageDiseased()
	{
		// Get the two allotment patches
		final FarmingPatch patch1 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);
		final FarmingPatch patch2 = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_D);

		assertNotNull(patch1);
		assertNotNull(patch2);

		// Specify the two allotment patches
		when(farmingTracker.predictPatch(patch1))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.DISEASED, 0, 2, 3));
		when(farmingTracker.predictPatch(patch2))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.DEAD, 0, 2, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		// Prefer diseased cabbages
		assertEquals(CropState.DISEASED, farmingContractManager.getContractCropState());
	}

	@Test
	public void cabbageContractCabbageHarvestableAndEmptyPatch()
	{
		final long unixNow = Instant.now().getEpochSecond();

		final FarmingPatch patch = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);

		assertNotNull(patch);

		when(farmingTracker.predictPatch(patch))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.HARVESTABLE, unixNow, 3, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.COMPLETED, farmingContractManager.getSummary());
	}

	@Test
	public void cabbageContractCabbageDiseasedAndEmptyPatch()
	{
		final FarmingPatch patch = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);

		assertNotNull(patch);

		when(farmingTracker.predictPatch(patch))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.DISEASED, 0, 2, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		assertEquals(CropState.DISEASED, farmingContractManager.getContractCropState());
	}

	@Test
	public void cabbageContractCabbageDeadAndEmptyPatch()
	{
		final FarmingPatch patch = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_C);

		assertNotNull(patch);

		when(farmingTracker.predictPatch(patch))
			.thenReturn(new PatchPrediction(Produce.CABBAGE, CropState.DEAD, 0, 2, 3));

		farmingContractManager.setContract(Produce.CABBAGE);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		assertEquals(CropState.DEAD, farmingContractManager.getContractCropState());
	}

	@Test
	public void redberriesContractRedberriesHarvestable()
	{
		final long unixNow = Instant.now().getEpochSecond();

		// Get the bush patch
		final FarmingPatch patch = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_B);

		assertNotNull(patch);

		// For berries, Harvestable means already checked
		when(farmingTracker.predictPatch(patch))
			.thenReturn(new PatchPrediction(Produce.REDBERRIES, CropState.HARVESTABLE, unixNow, 3, 3));

		farmingContractManager.setContract(Produce.REDBERRIES);

		assertEquals(SummaryState.OCCUPIED, farmingContractManager.getSummary());
	}

	@Test
	public void redberriesContractRedberriesGrown()
	{
		final long unixNow = Instant.now().getEpochSecond();

		// Get the bush patch
		final FarmingPatch patch = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_B);

		assertNotNull(patch);

		// For berries, Growing on the last stage is ready to be checked
		when(farmingTracker.predictPatch(patch))
			.thenReturn(new PatchPrediction(Produce.REDBERRIES, CropState.GROWING, unixNow, 3, 3));

		farmingContractManager.setContract(Produce.REDBERRIES);

		assertEquals(SummaryState.COMPLETED, farmingContractManager.getSummary());
	}

	@Test
	public void redberriesContractRedberriesGrowing()
	{
		final long unixNow = Instant.now().getEpochSecond();
		final long expectedCompletion = unixNow + 60;

		// Get the bush patch
		final FarmingPatch patch = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_B);

		assertNotNull(patch);

		// Not ready to check
		when(farmingTracker.predictPatch(patch))
			.thenReturn(new PatchPrediction(Produce.REDBERRIES, CropState.GROWING, expectedCompletion, 2, 3));

		farmingContractManager.setContract(Produce.REDBERRIES);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		assertEquals(CropState.GROWING, farmingContractManager.getContractCropState());
		assertEquals(expectedCompletion, farmingContractManager.getCompletionTime());
	}

	@Test
	public void redberriesContractRedberriesDiseased()
	{
		// Get the bush patch
		final FarmingPatch patch = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_B);

		assertNotNull(patch);

		when(farmingTracker.predictPatch(patch))
			.thenReturn(new PatchPrediction(Produce.REDBERRIES, CropState.DISEASED, 0, 2, 3));

		farmingContractManager.setContract(Produce.REDBERRIES);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		assertEquals(CropState.DISEASED, farmingContractManager.getContractCropState());
	}

	@Test
	public void redberriesContractRedberriesDead()
	{
		// Get the bush patch
		final FarmingPatch patch = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_B);

		assertNotNull(patch);

		when(farmingTracker.predictPatch(patch))
			.thenReturn(new PatchPrediction(Produce.REDBERRIES, CropState.DEAD, 0, 2, 3));

		farmingContractManager.setContract(Produce.REDBERRIES);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		assertEquals(CropState.DEAD, farmingContractManager.getContractCropState());
	}

	@Test
	public void redberriesContractCadavaDead()
	{
		// Get the bush patch
		final FarmingPatch patch = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_B);

		assertNotNull(patch);

		when(farmingTracker.predictPatch(patch))
			.thenReturn(new PatchPrediction(Produce.CADAVABERRIES, CropState.DEAD, 0, 2, 3));

		farmingContractManager.setContract(Produce.REDBERRIES);
		assertEquals(SummaryState.OCCUPIED, farmingContractManager.getSummary());
	}

	@Test
	public void guamContractGuamDead()
	{
		// Get the bush patch
		final FarmingPatch patch = farmingGuildPatches.get(VarbitID.FARMING_TRANSMIT_E);

		assertNotNull(patch);

		when(farmingTracker.predictPatch(patch))
			.thenReturn(new PatchPrediction(Produce.GUAM, CropState.DEAD, 0, 2, 3));

		farmingContractManager.setContract(Produce.GUAM);

		assertEquals(SummaryState.IN_PROGRESS, farmingContractManager.getSummary());
		assertEquals(CropState.DEAD, farmingContractManager.getContractCropState());
	}
}
