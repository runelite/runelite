/*
 * Copyright (c) 2026, Eambo
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
package net.runelite.client.plugins.regenmeter;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Skill;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.client.Notifier;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RegenMeterPluginTest
{
	private static final int BR_LIGHTBEARER = 27870;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private Notifier notifier;

	@Mock
	@Bind
	private RegenMeterOverlay overlay;

	@Mock
	@Bind
	private RegenMeterConfig config;

	@Inject
	private RegenMeterPlugin plugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.getBoostedSkillLevel(Skill.HITPOINTS)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(99);
		when(config.showWhenNoChange()).thenReturn(true);
	}

	@Test
	public void resetsSpecMeterWhenSpecEnergyRegens()
	{
		when(client.getVarpValue(VarPlayerID.SA_ENERGY)).thenReturn(600);

		for (int i = 0; i < 25; i++)
		{
			plugin.onGameTick(new GameTick());
		}

		assertEquals(0.5d, plugin.getSpecialPercentage(), 0.001d);

		when(client.getVarpValue(VarPlayerID.SA_ENERGY)).thenReturn(700);
		plugin.onGameTick(new GameTick());

		assertEquals(0d, plugin.getSpecialPercentage(), 0.001d);
	}

	@Test
	public void recognizesLightbearerVariation()
	{
		ItemContainer equipment = mock(ItemContainer.class);
		when(equipment.getItem(EquipmentInventorySlot.RING.getSlotIdx())).thenReturn(new Item(BR_LIGHTBEARER, 1));
		plugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.WORN, equipment));

		when(client.getVarpValue(VarPlayerID.SA_ENERGY)).thenReturn(0);
		plugin.onGameTick(new GameTick());

		assertEquals(1d / 25d, plugin.getSpecialPercentage(), 0.001d);
	}
}
