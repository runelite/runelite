/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
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
package net.runelite.client.plugins.prayer;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemStats;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrayerPluginTest
{

	@Inject
	private PrayerPlugin prayerPlugin;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private PrayerConfig config;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	private SpriteManager spriteManager;

	@Mock
	@Bind
	private ScheduledExecutorService executor;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testGetEstimatedTimeRemainingOverOneHour()
	{
		ItemStats itemStats = new ItemStats(false, true, 1, 8,
			ItemEquipmentStats.builder()
				.slot(EquipmentInventorySlot.WEAPON.getSlotIdx())
				.prayer(50)
				.build());

		ItemContainer itemContainer = mock(ItemContainer.class);

		when(client.isPrayerActive(Prayer.PRESERVE)).thenReturn(true);
		when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(itemContainer);
		when(itemContainer.getItems()).thenReturn(new Item[]{new Item(99999, 1)});
		when(itemManager.getItemStats(anyInt(), anyBoolean())).thenReturn(itemStats);

		prayerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), itemContainer));
		String actualString = prayerPlugin.getEstimatedTimeRemaining(false);

		assertEquals("1:19:12", actualString);
	}

	@Test
	public void testGetEstimatedTimeRemainingUnderOneHour()
	{
		ItemContainer itemContainer = mock(ItemContainer.class);

		when(client.isPrayerActive(Prayer.PRESERVE)).thenReturn(true);
		when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(itemContainer);
		when(itemContainer.getItems()).thenReturn(new Item[]{});

		prayerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), itemContainer));
		String actualString = prayerPlugin.getEstimatedTimeRemaining(false);

		assertEquals("29:42", actualString);
	}

	@Test
	public void testGetEstimatedTimeRemainingFormatForOrbUnderOneHour()
	{
		ItemContainer itemContainer = mock(ItemContainer.class);

		when(client.isPrayerActive(Prayer.PRESERVE)).thenReturn(true);
		when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(itemContainer);
		when(itemContainer.getItems()).thenReturn(new Item[]{});

		prayerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), itemContainer));
		String actualString = prayerPlugin.getEstimatedTimeRemaining(true);

		assertEquals("29m", actualString);
	}

	@Test
	public void testGetEstimatedTimeRemainingFormatForOrbOverOneHour()
	{
		ItemStats itemStats = new ItemStats(false, true, 1, 8,
			ItemEquipmentStats.builder()
				.slot(EquipmentInventorySlot.WEAPON.getSlotIdx())
				.prayer(50)
				.build());

		ItemContainer itemContainer = mock(ItemContainer.class);

		when(client.isPrayerActive(Prayer.PRESERVE)).thenReturn(true);
		when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(itemContainer);
		when(itemContainer.getItems()).thenReturn(new Item[]{new Item(99999, 1)});
		when(itemManager.getItemStats(anyInt(), anyBoolean())).thenReturn(itemStats);

		prayerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), itemContainer));
		String actualString = prayerPlugin.getEstimatedTimeRemaining(true);

		assertEquals("79m", actualString);
	}

}
