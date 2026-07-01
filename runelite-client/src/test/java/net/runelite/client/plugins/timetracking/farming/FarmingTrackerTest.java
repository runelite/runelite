/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.timetracking.farming;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.EnumSet;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.WorldType;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneScapeProfile;
import net.runelite.client.config.RuneScapeProfileType;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FarmingTrackerTest
{
	@Inject
	private FarmingTracker farmingTracker;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private ConfigManager configManager;

	@Mock
	@Bind
	private TimeTrackingConfig config;

	@Mock
	@Bind
	private FarmingWorld farmingWorld;

	@Mock
	@Bind
	private Notifier notifier;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		when(client.getWorldType()).thenReturn(EnumSet.noneOf(WorldType.class));

		Player player = mock(Player.class);
		when(player.getName()).thenReturn("Adam");
		when(client.getLocalPlayer()).thenReturn(player);
	}

	@Test(expected = IllegalStateException.class)
	public void testEmptyNotification()
	{
		RuneScapeProfile runeScapeProfile = new RuneScapeProfile("Adam", RuneScapeProfileType.STANDARD, -1, null);

		PatchPrediction patchPrediction = new PatchPrediction(Produce.EMPTY_COMPOST_BIN, CropState.EMPTY, 0L, 0, 0);
		FarmingRegion region = new FarmingRegion("Ardougne", 10548, false,
			new FarmingPatch("North", VarbitID.FARMING_TRANSMIT_A, PatchImplementation.ALLOTMENT),
			new FarmingPatch("South", VarbitID.FARMING_TRANSMIT_B, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", VarbitID.FARMING_TRANSMIT_C, PatchImplementation.FLOWER),
			new FarmingPatch("", VarbitID.FARMING_TRANSMIT_D, PatchImplementation.HERB),
			new FarmingPatch("", VarbitID.FARMING_TRANSMIT_E, PatchImplementation.COMPOST)
		);
		FarmingPatch patch = region.getPatches()[4];
		patch.setRegion(region);
		farmingTracker.sendNotification(runeScapeProfile, patchPrediction, patch);
	}

	@Test
	public void testHarvestableNotification()
	{
		RuneScapeProfile runeScapeProfile = new RuneScapeProfile("Adam", RuneScapeProfileType.STANDARD, -1, null);

		PatchPrediction patchPrediction = new PatchPrediction(Produce.RANARR, CropState.HARVESTABLE, 0L, 0, 0);
		FarmingRegion region = new FarmingRegion("Ardougne", 10548, false,
			new FarmingPatch("North", VarbitID.FARMING_TRANSMIT_A, PatchImplementation.ALLOTMENT),
			new FarmingPatch("South", VarbitID.FARMING_TRANSMIT_B, PatchImplementation.ALLOTMENT),
			new FarmingPatch("", VarbitID.FARMING_TRANSMIT_C, PatchImplementation.FLOWER),
			new FarmingPatch("", VarbitID.FARMING_TRANSMIT_D, PatchImplementation.HERB),
			new FarmingPatch("", VarbitID.FARMING_TRANSMIT_E, PatchImplementation.COMPOST)
		);
		FarmingPatch patch = region.getPatches()[3];
		patch.setRegion(region);
		farmingTracker.sendNotification(runeScapeProfile, patchPrediction, patch);

		verify(notifier).notify("Your Ranarr is ready to harvest in Ardougne.");
	}
}