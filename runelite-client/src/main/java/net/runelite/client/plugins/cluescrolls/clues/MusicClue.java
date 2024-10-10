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
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MusicClue extends ClueScroll implements NpcClueScroll, LocationClueScroll
{
	private static final WorldPoint LOCATION = new WorldPoint(2990, 3384, 0);
	private static final String CECILIA = "Cecilia";
	private static final Pattern SONG_PATTERN = Pattern.compile("<col=ffffff>([A-Za-z !&',.]+)</col>");

	static final List<MusicClue> CLUES = ImmutableList.of(
		new MusicClue(ItemID.CLUE_SCROLL_EASY_23155, "Vision"),
		new MusicClue(ItemID.CLUE_SCROLL_EASY_23156, "The Forlorn Homestead"),
		new MusicClue(ItemID.CLUE_SCROLL_EASY_23157, "Tiptoe"),
		new MusicClue(ItemID.CLUE_SCROLL_EASY_23158, "Rugged Terrain"),
		new MusicClue(ItemID.CLUE_SCROLL_EASY_23159, "On the Shore"),
		new MusicClue(ItemID.CLUE_SCROLL_EASY_23160, "Alone"),
		new MusicClue(ItemID.CLUE_SCROLL_MEDIUM_23138, "Karamja Jam"),
		new MusicClue(ItemID.CLUE_SCROLL_MEDIUM_23139, "Faerie"),
		new MusicClue(ItemID.CLUE_SCROLL_MEDIUM_23140, "Forgotten"),
		new MusicClue(ItemID.CLUE_SCROLL_MEDIUM_23141, "Catch Me If You Can"),
		new MusicClue(ItemID.CLUE_SCROLL_MEDIUM_23142, "Cave of Beasts"),
		new MusicClue(ItemID.CLUE_SCROLL_MEDIUM_23143, "Devils May Care"),
		new MusicClue(ItemID.CLUE_SCROLL_HARD_23174, "Scorpia Dances"),
		new MusicClue(ItemID.CLUE_SCROLL_HARD_23175, "Complication"),
		new MusicClue(ItemID.CLUE_SCROLL_HARD_23176, "Subterranea"),
		new MusicClue(ItemID.CLUE_SCROLL_HARD_23177, "Little Cave of Horrors"),
		new MusicClue(ItemID.CLUE_SCROLL_HARD_23178, "Roc and Roll"),
		new MusicClue(ItemID.CLUE_SCROLL_HARD_23179, "La Mort"),
		new MusicClue(ItemID.CLUE_SCROLL_HARD_23180, "Fossilised"),
		new MusicClue(ItemID.CLUE_SCROLL_HARD_23181, "Hells Bells"),
		new MusicClue(ItemID.CLUE_SCROLL_HARD_25792, "Regal Pomp"),
		new MusicClue(ItemID.CLUE_SCROLL_HARD_28918, "The Moons of Ruin"),
		new MusicClue(ItemID.CLUE_SCROLL_ELITE_24773, "Lament for the Hallowed"),
		new MusicClue(ItemID.CLUE_SCROLL_ELITE_26943, "The Pharaoh")
		);

	private final int itemId;
	private final String song;

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Music Clue").build());
		panelComponent.getChildren().add(LineComponent.builder().left("NPC:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(CECILIA)
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		panelComponent.getChildren().add(LineComponent.builder().left("Location:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Falador Park")
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		panelComponent.getChildren().add(LineComponent.builder().left("Song:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(song)
			.leftColor(TITLED_CONTENT_COLOR)
			.build());
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		if (!LOCATION.isInScene(plugin.getClient()))
		{
			return;
		}

		for (NPC npc : plugin.getNpcsToMark())
		{
			OverlayUtil.renderActorOverlayImage(graphics, npc, plugin.getClueScrollImage(), Color.ORANGE, IMAGE_Z_OFFSET);
		}
	}

	public static MusicClue forItemId(int itemId)
	{
		for (MusicClue clue : CLUES)
		{
			if (clue.itemId == itemId)
			{
				return clue;
			}
		}

		return null;
	}

	public static MusicClue forSong(String song)
	{
		for (MusicClue clue : CLUES)
		{
			if (clue.song.equals(song))
			{
				return clue;
			}
		}

		return null;
	}

	@Override
	public String[] getNpcs(ClueScrollPlugin plugin)
	{
		return new String[] {CECILIA};
	}

	public static MusicClue forText(String text)
	{
		final Matcher m = SONG_PATTERN.matcher(text);
		if (m.find())
		{
			final String song = m.group(1);
			return forSong(song);
		}
		return null;
	}

	@Override
	public WorldPoint getLocation(ClueScrollPlugin plugin)
	{
		return LOCATION;
	}
}
