/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import java.util.EnumSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;
import static net.runelite.client.plugins.skillcalculator.skills.AgilityBonus.DESERT_HARD_DIARY;
import static net.runelite.client.plugins.skillcalculator.skills.AgilityBonus.FREMENNIK_HARD_DIARY;
import static net.runelite.client.plugins.skillcalculator.skills.AgilityBonus.WILDERNESS_AGILITY_TICKET_101_PLUS;
import static net.runelite.client.plugins.skillcalculator.skills.AgilityBonus.WILDERNESS_AGILITY_TICKET_11_TO_50;
import static net.runelite.client.plugins.skillcalculator.skills.AgilityBonus.WILDERNESS_AGILITY_TICKET_51_TO_100;

@AllArgsConstructor
@Getter
public enum AgilityAction implements NamedSkillAction
{
	GNOME_STRONGHOLD_COURSE("Gnome Stronghold", 1, 110.5f, ItemID.SWAMP_TOAD),
	DRAYNOR_VILLAGE_ROOFTOP("Draynor Village Rooftop", 1, 120, ItemID.MARK_OF_GRACE),
	SHAYZIEN_BASIC_COURSE("Shayzien Basic Course", 1, 153.5f, ItemID.SHAYZIEN_HELM_1),
	LEAPING_TROUT("Leaping trout", 15, 5, ItemID.LEAPING_TROUT),
	AL_KHARID_ROOFTOP("Al Kharid Rooftop", 20, 216, ItemID.MARK_OF_GRACE),
	LEAPING_SALMON("Leaping salmon", 30, 6, ItemID.LEAPING_SALMON),
	VARROCK_ROOFTOP("Varrock Rooftop", 30, 269.7f, ItemID.MARK_OF_GRACE),
	PENGUIN_AGILITY_COURSE("Penguin Agility Course", 30, 540, ItemID.CLOCKWORK_SUIT),
	BARBARIAN_OUTPOST("Barbarian Outpost", 35, 152.5f, ItemID.STEEL_BATTLEAXE),
	CANIFIS_ROOFTOP("Canifis Rooftop", 40, 240, ItemID.MARK_OF_GRACE),
	LEAPING_STURGEON("Leaping sturgeon", 45, 7, ItemID.LEAPING_STURGEON),
	SHAYZIEN_ADVANCED_COURSE("Shayzien Advanced Course", 45, 508, ItemID.SHAYZIEN_HELM_5),
	APE_ATOLL_COURSE("Ape Atoll", 48, 580, ItemID.GORILLA_GREEGREE),
	FALADOR_ROOFTOP("Falador Rooftop", 50, 586, ItemID.MARK_OF_GRACE),
	WILDERNESS_AGILITY_COURSE_TICKET("Wilderness Agility Ticket", 52, 200, ItemID.WILDERNESS_AGILITY_TICKET),
	WILDERNESS_AGILITY_COURSE("Wilderness Agility Course", 52, 571.4f, ItemID.SKULL),
	HALLOWED_SEPULCHRE_FLOOR_1("Hallowed Sepulchre Floor 1", 52, 575, ItemID.RING_OF_ENDURANCE),
	SEERS_VILLAGE_ROOFTOP("Seers' Village Rooftop", 60, 570, ItemID.MARK_OF_GRACE),
	WEREWOLF_AGILITY_COURSE("Werewolf Agility Course", 60, 730, ItemID.STICK),
	HALLOWED_SEPULCHRE_FLOOR_2("Hallowed Sepulchre Floor 2", 62, 925, ItemID.RING_OF_ENDURANCE),
	POLLNIVNEACH_ROOFTOP("Pollnivneach Rooftop", 70, 890, ItemID.MARK_OF_GRACE),
	DORGESH_KAAN_AGILITY_COURSE("Dorgesh-Kaan Agility Course", 70, 2750, ItemID.POWERBOX),
	HALLOWED_SEPULCHRE_FLOOR_3("Hallowed Sepulchre Floor 3", 72, 1600, ItemID.RING_OF_ENDURANCE),
	PRIFDDINAS_AGILITY_COURSE("Prifddinas Agility Course", 75, 1337, ItemID.CRYSTAL_SHARD),
	RELLEKKA_ROOFTOP("Rellekka Rooftop", 80, 780, ItemID.MARK_OF_GRACE),
	HALLOWED_SEPULCHRE_FLOOR_4("Hallowed Sepulchre Floor 4", 82, 2875, ItemID.RING_OF_ENDURANCE),
	ARDOUGNE_ROOFTOP("Ardougne Rooftop", 90, 889, ItemID.MARK_OF_GRACE),
	HALLOWED_SEPULCHRE_FLOOR_5("Hallowed Sepulchre Floor 5", 92, 5725, ItemID.RING_OF_ENDURANCE),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;

	@Override
	public boolean isMembers(final ItemManager itemManager)
	{
		return true;
	}

	@Override
	public Set<AgilityBonus> getExcludedSkillBonuses()
	{
		final EnumSet<AgilityBonus> others = EnumSet.allOf(AgilityBonus.class);

		switch (this)
		{
			case WILDERNESS_AGILITY_COURSE_TICKET:
				others.remove(WILDERNESS_AGILITY_TICKET_11_TO_50);
				others.remove(WILDERNESS_AGILITY_TICKET_51_TO_100);
				others.remove(WILDERNESS_AGILITY_TICKET_101_PLUS);
				break;
			case POLLNIVNEACH_ROOFTOP:
				others.remove(DESERT_HARD_DIARY);
				break;
			case RELLEKKA_ROOFTOP:
				others.remove(FREMENNIK_HARD_DIARY);
				break;
		}

		return others;
	}
}
