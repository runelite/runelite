/*
 * Copyright (c) 2019, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.cluescrolls.clues;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.WidgetID;

@Getter
public class BeginnerMapClue extends MapClue implements LocationClueScroll
{
	private static final ImmutableList<BeginnerMapClue> CLUES = ImmutableList.of(
		new BeginnerMapClue(WidgetID.BEGINNER_CLUE_MAP_CHAMPIONS_GUILD, new WorldPoint(3166, 3361, 0), MapClue.CHAMPIONS_GUILD),
		new BeginnerMapClue(WidgetID.BEGINNER_CLUE_MAP_VARROCK_EAST_MINE, new WorldPoint(3290, 3374, 0), MapClue.VARROCK_EAST_MINE),
		new BeginnerMapClue(WidgetID.BEGINNER_CLUE_MAP_DRAYNOR, new WorldPoint(3093, 3226, 0), MapClue.SOUTH_OF_DRAYNOR_BANK),
		new BeginnerMapClue(WidgetID.BEGINNER_CLUE_MAP_NORTH_OF_FALADOR, new WorldPoint(3043, 3398, 0), MapClue.STANDING_STONES),
		new BeginnerMapClue(WidgetID.BEGINNER_CLUE_MAP_WIZARDS_TOWER, new WorldPoint(3110, 3152, 0), MapClue.WIZARDS_TOWER_DIS)
	);

	private final int widgetGroupID;

	private BeginnerMapClue(int widgetGroupID, WorldPoint location, String description)
	{
		super(-1, location, description);
		this.widgetGroupID = widgetGroupID;
		setRequiresSpade(true);
	}

	// Beginner Map Clues all use the same ItemID, but the WidgetID used to display them is unique
	public static BeginnerMapClue forWidgetID(int widgetGroupID)
	{
		for (BeginnerMapClue clue : CLUES)
		{
			if (clue.widgetGroupID == widgetGroupID)
			{
				return clue;
			}
		}

		return null;
	}
}

