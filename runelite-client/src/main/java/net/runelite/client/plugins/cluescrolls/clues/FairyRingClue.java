/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class FairyRingClue extends ClueScroll implements LocationClueScroll
{
	static final List<FairyRingClue> CLUES = ImmutableList.of(
		new FairyRingClue(ItemID.TRAIL_CLUE_HARD_FAIRY002, "A I R 2 3 3 1", new WorldPoint(2702, 3246, 0)),
		new FairyRingClue(ItemID.TRAIL_CLUE_HARD_FAIRY001, "A I Q 0 4 4 0", new WorldPoint(3000, 3110, 0)),
		new FairyRingClue(ItemID.TRAIL_HARD_FAIRY_VM01, "A J P 3 0 1 5", new WorldPoint(1646, 3012, 0)),
		new FairyRingClue(ItemID.TRAIL_CLUE_HARD_FAIRY003, "A L P 1 1 4 0", new WorldPoint(2504, 3633, 0)),
		new FairyRingClue(ItemID.TRAIL_CLUE_HARD_FAIRY006, "B L P 6 2 0 0", new WorldPoint(2439, 5132, 0)),
		new FairyRingClue(ItemID.TRAIL_CLUE_HARD_FAIRY005, "B J R 1 1 2 3", new WorldPoint(2648, 4729, 0)),
		new FairyRingClue(ItemID.TRAIL_CLUE_HARD_FAIRY004, "B I P 7 0 1 3", new WorldPoint(3407, 3330, 0)),
		new FairyRingClue(ItemID.TRAIL_CLUE_HARD_FAIRY010, "C I S 0 0 0 9", new WorldPoint(1630, 3868, 0)),
		new FairyRingClue(ItemID.TRAIL_CLUE_HARD_FAIRY007, "C K P 0 2 2 4", new WorldPoint(2073, 4846, 0)),
		new FairyRingClue(ItemID.TRAIL_CLUE_HARD_FAIRY008, "D I P 8 5 1 1", new WorldPoint(3041, 4770, 0)),
		new FairyRingClue(ItemID.TRAIL_CLUE_HARD_FAIRY009, "D K S 2 3 1 0", new WorldPoint(2747, 3720, 0))
	);

	@Getter(AccessLevel.PACKAGE)
	private final int itemId;
	@Getter
	private final String text;
	private final WorldPoint location;

	private FairyRingClue(int itemId, String text, WorldPoint location)
	{
		this.itemId = itemId;
		this.text = text;
		this.location = location;
		setRequiresSpade(true);
	}

	@Override
	public WorldPoint getLocation(ClueScrollPlugin plugin)
	{
		return location;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Fairy Ring Clue").build());
		panelComponent.getChildren().add(LineComponent.builder().left("Code:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getText().substring(0, 5))
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Travel to the fairy ring to see where to dig.")
			.build());

		renderOverlayNote(panelComponent, plugin);
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), getLocation(plugin));

		if (localLocation == null)
		{
			return;
		}

		OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
	}

	public static FairyRingClue forItemId(int itemId)
	{
		for (FairyRingClue clue : CLUES)
		{
			if (clue.itemId == itemId)
			{
				return clue;
			}
		}

		return null;
	}

	@Override
	public int[] getConfigKeys()
	{
		return new int[]{text.hashCode()};
	}

	public static FairyRingClue forText(String text)
	{
		for (FairyRingClue clue : CLUES)
		{
			if (clue.text.equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		return null;
	}
}
