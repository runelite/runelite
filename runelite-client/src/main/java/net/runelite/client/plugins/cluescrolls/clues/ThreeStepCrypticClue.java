/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import static net.runelite.api.ItemID.TORN_CLUE_SCROLL_PART_1;
import static net.runelite.api.ItemID.TORN_CLUE_SCROLL_PART_2;
import static net.runelite.api.ItemID.TORN_CLUE_SCROLL_PART_3;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.Text;

@Getter
@RequiredArgsConstructor
public class ThreeStepCrypticClue extends ClueScroll implements ObjectClueScroll, NpcClueScroll, LocationsClueScroll
{
	@Data
	@AllArgsConstructor
	private static class Step
	{
		final CrypticClue clue;
		final boolean unrecognized;
		boolean complete;

		public boolean shouldShowHelp()
		{
			return !complete && !unrecognized;
		}
	}

	public static ThreeStepCrypticClue forText(String plainText, String text)
	{
		final String[] split = text.split("<br>\\s*<br>");
		final List<Step> steps = new ArrayList<>(split.length);

		boolean atLeastOneMatch = false;
		for (String part : split)
		{
			boolean isDone = part.contains("<str>");
			final String rawText = Text.sanitizeMultilineText(part);

			boolean matchFound = false;
			for (CrypticClue clue : CrypticClue.CLUES)
			{
				if (!rawText.equalsIgnoreCase(clue.getText()))
				{
					continue;
				}

				steps.add(new Step(clue, false, isDone));
				atLeastOneMatch = true;
				matchFound = true;
				break;
			}
			if (!matchFound) steps.add(new Step(CrypticClue.builder().text(rawText).build(), true, isDone)); // The correct text allows notes to be set on it.
		}

		if (!atLeastOneMatch)
		{
			return null;
		}

		return new ThreeStepCrypticClue(steps, plainText);
	}

	private final List<Step> clueSteps;
	private final String text;

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.setPreferredSize(new Dimension(200, 0));

		for (int i = 0; i < clueSteps.size(); i++)
		{
			final Step step = clueSteps.get(i);

			if (step.isComplete())
			{
				continue;
			}

			panelComponent.getChildren().add(TitleComponent.builder().text("Cryptic Clue #" + (i + 1)).build());
			CrypticClue c = step.getClue();
			if (step.isUnrecognized())
			{
				panelComponent.getChildren().add(LineComponent.builder().left("This clue isn't supported yet.").leftColor(Color.RED).build());
			}
			else
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Solution:").build());
				panelComponent.getChildren().add(LineComponent.builder()
					.left(c.getSolution(plugin))
					.leftColor(TITLED_CONTENT_COLOR)
					.build());
			}
			c.renderOverlayNote(panelComponent, plugin);
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		for (Step step : clueSteps)
		{
			if (step.shouldShowHelp())
			{
				step.getClue().makeWorldOverlayHint(graphics, plugin);
			}
		}
	}

	public boolean update(int containerId, final ItemContainer itemContainer)
	{
		if (containerId == InventoryID.INVENTORY.getId())
		{
			return checkForPart(itemContainer, TORN_CLUE_SCROLL_PART_1, 0) ||
				checkForPart(itemContainer, TORN_CLUE_SCROLL_PART_2, 1) ||
				checkForPart(itemContainer, TORN_CLUE_SCROLL_PART_3, 2);
		}

		return false;
	}

	private boolean checkForPart(final ItemContainer itemContainer, int clueScrollPart, int index)
	{
		// If we have the part then that step is done
		if (itemContainer.contains(clueScrollPart))
		{
			final Step step = clueSteps.get(index);

			if (!step.isComplete())
			{
				step.setComplete(true);
				return true;
			}
		}

		return false;
	}

	@Override
	public void reset()
	{
		for (Step step : clueSteps)
		{
			step.setComplete(false);
		}
	}

	@Override
	public WorldPoint getLocation(ClueScrollPlugin plugin)
	{
		return null;
	}

	@Override
	public WorldPoint[] getLocations(ClueScrollPlugin plugin)
	{
		return clueSteps.stream()
			.filter(Step::shouldShowHelp)
			.map(s -> s.getClue().getLocation(plugin))
			.filter(Objects::nonNull)
			.toArray(WorldPoint[]::new);
	}

	@Override
	public String[] getNpcs(ClueScrollPlugin plugin)
	{
		return clueSteps.stream()
			.filter(Step::shouldShowHelp)
			.map(s -> s.getClue().getNpc())
			.toArray(String[]::new);
	}

	@Override
	public int[] getObjectIds()
	{
		return clueSteps.stream()
			.filter(Step::shouldShowHelp)
			.mapToInt(s -> s.getClue().getObjectId())
			.toArray();
	}

	@Override
	public int[] getConfigKeys()
	{
		return clueSteps.stream()
			.flatMapToInt(s -> Arrays.stream(s.getClue().getConfigKeys()))
			.toArray();
	}
}
