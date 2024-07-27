/*
 * Copyright (c) 2020, Landy Chan <https://github.com/landychan>
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
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
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
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrayerPluginTest
{
	private static final ItemStats HIGH_PRAYER_BONUS_WEAPON = new ItemStats(false, 0, 0,
		ItemEquipmentStats.builder()
			.slot(EquipmentInventorySlot.WEAPON.getSlotIdx())
			.prayer(50)
			.build());

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
	private ItemManager itemManager;

	@Mock
	@Bind
	private ConfigManager configManager;

	@Mock
	@Bind
	private ChatMessageManager chatMessageManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testGetEstimatedTimeRemainingOverOneHour()
	{
		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{new Item(-1, 1)});
		when(itemManager.getItemStats(anyInt(), anyBoolean())).thenReturn(HIGH_PRAYER_BONUS_WEAPON);

		when(client.isPrayerActive(Prayer.PRESERVE)).thenReturn(true);
		when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);

		prayerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), itemContainer));

		assertEquals("1:19:12", prayerPlugin.getEstimatedTimeRemaining(false));
	}

	@Test
	public void testGetEstimatedTimeRemainingUnderOneHour()
	{
		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{});

		when(client.isPrayerActive(Prayer.PRESERVE)).thenReturn(true);
		when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);

		prayerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), itemContainer));

		assertEquals("29:42", prayerPlugin.getEstimatedTimeRemaining(false));
	}

	@Test
	public void testGetEstimatedTimeRemainingFormatForOrbUnderOneHour()
	{
		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{});

		when(client.isPrayerActive(Prayer.PRESERVE)).thenReturn(true);
		when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);

		prayerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), itemContainer));

		assertEquals("29m", prayerPlugin.getEstimatedTimeRemaining(true));
	}

	@Test
	public void testGetEstimatedTimeRemainingFormatForOrbOverOneHour()
	{
		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{new Item(-1, 1)});
		when(itemManager.getItemStats(anyInt(), anyBoolean())).thenReturn(HIGH_PRAYER_BONUS_WEAPON);

		when(client.isPrayerActive(Prayer.PRESERVE)).thenReturn(true);
		when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);

		prayerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), itemContainer));

		assertEquals("79m", prayerPlugin.getEstimatedTimeRemaining(true));
	}

	@Test
	public void testTimeRemaining()
	{
		prayerPlugin.setPrayerBonus(42);

		assertTime(PrayerType.THICK_SKIN, "2:22:33");
		assertTime(PrayerType.BURST_OF_STRENGTH, "2:22:33");
		assertTime(PrayerType.CLARITY_OF_THOUGHT, "2:22:33");
		assertTime(PrayerType.SHARP_EYE, "2:22:33");
		assertTime(PrayerType.MYSTIC_WILL, "2:22:33");
		assertTime(PrayerType.ROCK_SKIN, "23:45");
		assertTime(PrayerType.SUPERHUMAN_STRENGTH, "23:45");
		assertTime(PrayerType.IMPROVED_REFLEXES, "23:45");
		assertTime(PrayerType.RAPID_RESTORE, "2:22:33");
		assertTime(PrayerType.RAPID_HEAL, "1:11:16");
		assertTime(PrayerType.PROTECT_ITEM, "1:11:16");
		assertTime(PrayerType.HAWK_EYE, "23:45");
		assertTime(PrayerType.MYSTIC_LORE, "23:45");
		assertTime(PrayerType.STEEL_SKIN, "11:52");
		assertTime(PrayerType.ULTIMATE_STRENGTH, "11:52");
		assertTime(PrayerType.INCREDIBLE_REFLEXES, "11:52");
		assertTime(PrayerType.PROTECT_FROM_MAGIC, "11:52");
		assertTime(PrayerType.PROTECT_FROM_MISSILES, "11:52");
		assertTime(PrayerType.PROTECT_FROM_MELEE, "11:52");
		assertTime(PrayerType.EAGLE_EYE, "11:52");
		assertTime(PrayerType.MYSTIC_MIGHT, "11:52");
		assertTime(PrayerType.RETRIBUTION, "47:31");
		assertTime(PrayerType.REDEMPTION, "23:45");
		assertTime(PrayerType.SMITE, "7:55");
		assertTime(PrayerType.PRESERVE, "1:11:16");
		assertTime(PrayerType.CHIVALRY, "5:56");
		assertTime(PrayerType.PIETY, "5:56");
		assertTime(PrayerType.RIGOUR, "5:56");
		assertTime(PrayerType.AUGURY, "5:56");
	}

	private void assertTime(PrayerType prayer, String time)
	{
		reset(client);
		when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);
		when(client.isPrayerActive(prayer.getPrayer())).thenReturn(true);
		var est = prayerPlugin.getEstimatedTimeRemaining(false);
		assertEquals(time, est);
	}
}
