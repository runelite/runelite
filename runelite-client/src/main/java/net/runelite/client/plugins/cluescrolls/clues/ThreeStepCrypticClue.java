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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.Getter;
import net.runelite.api.ItemContainer;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.Text;

@Getter
public class ThreeStepCrypticClue extends ClueScroll implements ObjectClueScroll, NpcClueScroll, LocationsClueScroll
{
	@VisibleForTesting
	static final Map<Integer, Integer> STEP_TO_CLUE_PART = ImmutableMap.of(
		1, ItemID.TRAIL_MASTER_PART1,
		2, ItemID.TRAIL_MASTER_PART2,
		3, ItemID.TRAIL_MASTER_PART3
	);

	@VisibleForTesting
	final List<ThreeStepCrypticClueStep> clueSteps;
	private final String text;

	private ThreeStepCrypticClue(List<ThreeStepCrypticClueStep> clueSteps, String text)
	{
		this.clueSteps = clueSteps;
		this.text = text;

		clueSteps.forEach(this::propagateRequirements);
	}

	public static ThreeStepCrypticClue forText(String plainText, String text)
	{
		final String[] split = text.split("<br>\\s*<br>");
		final List<ThreeStepCrypticClueStep> steps = new ArrayList<>(split.length);

		for (String part : split)
		{
			boolean isDone = part.contains("<str>");
			final String rawText = Text.sanitizeMultilineText(part);

			final CrypticClue crypticClue = getCrypticFromText(rawText);
			if (crypticClue == null)
			{
				continue;
			}

			steps.add(new ThreeStepCrypticClueStep(crypticClue, isDone));
		}

		if (steps.isEmpty() || steps.size() < 3)
		{
			return null;
		}

		return new ThreeStepCrypticClue(steps, plainText);
	}

	@Nullable
	@VisibleForTesting
	static CrypticClue getCrypticFromText(final String rawText)
	{
		for (CrypticClue clue : CrypticClue.CLUES)
		{
			if (!rawText.equalsIgnoreCase(clue.getText()))
			{
				continue;
			}

			return clue;
		}
		return null;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.setPreferredSize(new Dimension(200, 0));

		for (int i = 0; i < clueSteps.size(); i++)
		{
			final ThreeStepCrypticClueStep step = clueSteps.get(i);

			if (!step.isCompleted())
			{
				CrypticClue c = step.getClue();

				panelComponent.getChildren().add(TitleComponent.builder().text("Cryptic Clue #" + (i + 1)).build());
				panelComponent.getChildren().add(LineComponent.builder().left("Solution:").build());
				panelComponent.getChildren().add(LineComponent.builder()
					.left(c.getSolution(plugin))
					.leftColor(TITLED_CONTENT_COLOR)
					.build());

				c.renderOverlayNote(panelComponent, plugin);
			}
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		for (ThreeStepCrypticClueStep step : clueSteps)
		{
			if (!step.isCompleted())
			{
				step.getClue().makeWorldOverlayHint(graphics, plugin);
			}
		}
	}

	public boolean update(int containerId, final ItemContainer itemContainer)
	{
		if (containerId == InventoryID.INV)
		{
			resetRequirements();
			final boolean inventoryContainsTornScroll = STEP_TO_CLUE_PART.entrySet().stream()
				.anyMatch(entry ->
				{
					final int index = entry.getKey() - 1;
					final int itemId = entry.getValue();
					return checkForPart(itemContainer, itemId, index);
				});
			clueSteps.forEach(this::propagateRequirements);

			return inventoryContainsTornScroll;
		}

		return false;
	}

	private boolean checkForPart(final ItemContainer itemContainer, int clueScrollPart, int index)
	{
		// If we have the part then that step is done
		if (itemContainer.contains(clueScrollPart))
		{
			final ThreeStepCrypticClueStep step = clueSteps.get(index);

			if (!step.isCompleted())
			{
				step.setCompleted(true);
				return true;
			}
		}

		return false;
	}

	private void propagateRequirements(final ThreeStepCrypticClueStep clueStep)
	{
		// Don't consider requirements of completed steps
		if (clueStep.isCompleted())
		{
			return;
		}

		final CrypticClue clue = clueStep.getClue();
		if (clue.isRequiresLight())
		{
			setRequiresLight(true);
		}
		if (clue.isRequiresSpade())
		{
			setRequiresSpade(true);
		}
		if (getFirePitVarbitId() < clue.getFirePitVarbitId())
		{
			setFirePitVarbitId(clue.getFirePitVarbitId());
		}
	}

	private void resetRequirements()
	{
		setRequiresLight(false);
		setRequiresSpade(false);
		setFirePitVarbitId(-1);
	}

	@Override
	public void reset()
	{
		for (ThreeStepCrypticClueStep clueStep : clueSteps)
		{
			clueStep.setCompleted(false);
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
			.filter(s -> !s.isCompleted())
			.map(s -> s.getClue().getLocation(plugin))
			.filter(Objects::nonNull)
			.toArray(WorldPoint[]::new);
	}

	@Override
	public String[] getNpcs(ClueScrollPlugin plugin)
	{
		return clueSteps.stream()
			.filter(s -> !s.isCompleted())
			.map(s -> s.getClue().getNpc(plugin))
			.toArray(String[]::new);
	}

	@Override
	public int[] getObjectIds()
	{
		return clueSteps.stream()
			.filter(s -> !s.isCompleted())
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
