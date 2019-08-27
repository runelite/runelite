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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import static net.runelite.api.ItemID.TORN_CLUE_SCROLL_PART_1;
import static net.runelite.api.ItemID.TORN_CLUE_SCROLL_PART_2;
import static net.runelite.api.ItemID.TORN_CLUE_SCROLL_PART_3;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.game.ItemManager;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.api.util.Text;

@Getter
@RequiredArgsConstructor
public class ThreeStepCrypticClue extends ClueScroll implements TextClueScroll, ObjectClueScroll, NpcClueScroll, LocationsClueScroll
{
	public static ThreeStepCrypticClue forText(String plainText, String text)
	{
		final String[] split = text.split("<br>\\s*<br>");
		final List<Map.Entry<CrypticClue, Boolean>> steps = new ArrayList<>(split.length);

		for (String part : split)
		{
			boolean isDone = part.contains("<str>");
			final String rawText = Text.sanitizeMultilineText(part);

			for (CrypticClue clue : CrypticClue.CLUES)
			{
				if (!rawText.equalsIgnoreCase(clue.getText()))
				{
					continue;
				}

				steps.add(new AbstractMap.SimpleEntry<>(clue, isDone));
				break;
			}
		}

		if (steps.isEmpty() || steps.size() < 3)
		{
			return null;
		}

		return new ThreeStepCrypticClue(steps, plainText);
	}

	private final List<Map.Entry<CrypticClue, Boolean>> clueSteps;
	private final String text;

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.setPreferredSize(new Dimension(200, 0));

		for (int i = 0; i < clueSteps.size(); i++)
		{
			final Map.Entry<CrypticClue, Boolean> e = clueSteps.get(i);

			if (!e.getValue())
			{
				CrypticClue c = e.getKey();

				panelComponent.getChildren().add(TitleComponent.builder().text("Cryptic Clue #" + (i + 1)).build());
				panelComponent.getChildren().add(LineComponent.builder().left("Solution:").build());
				panelComponent.getChildren().add(LineComponent.builder()
					.left(c.getSolution())
					.leftColor(TITLED_CONTENT_COLOR)
					.build());
			}
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		for (Map.Entry<CrypticClue, Boolean> e : clueSteps)
		{
			if (!e.getValue())
			{
				e.getKey().makeWorldOverlayHint(graphics, plugin);
			}
		}
	}

	public boolean update(Client client, final ItemContainerChanged event, ItemManager itemManager)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{
			boolean success = false;
			success |= checkForPart(event, itemManager, TORN_CLUE_SCROLL_PART_1, 0);
			success |= checkForPart(event, itemManager, TORN_CLUE_SCROLL_PART_2, 1);
			success |= checkForPart(event, itemManager, TORN_CLUE_SCROLL_PART_3, 2);
			return success;
		}

		return false;
	}

	private boolean checkForPart(final ItemContainerChanged event, ItemManager itemManager, int clueScrollPart, int index)
	{
		final Stream<Item> items = Arrays.stream(event.getItemContainer().getItems());

		// If we have the part then that step is done
		if (items.anyMatch(item -> itemManager.getItemDefinition(item.getId()).getId() == clueScrollPart))
		{
			final Map.Entry<CrypticClue, Boolean> entry = clueSteps.get(index);

			if (!entry.getValue())
			{
				entry.setValue(true);
				return true;
			}
		}

		return false;
	}

	@Override
	public void reset()
	{
		for (Map.Entry<CrypticClue, Boolean> clueStep : clueSteps)
		{
			clueStep.setValue(false);
		}
	}

	@Override
	public WorldPoint getLocation()
	{
		return null;
	}

	@Override
	public WorldPoint[] getLocations()
	{
		return clueSteps.stream()
			.filter(s -> !s.getValue())
			.map(s -> s.getKey().getLocation())
			.toArray(WorldPoint[]::new);
	}

	@Override
	public String[] getNpcs()
	{
		return clueSteps.stream()
			.filter(s -> !s.getValue())
			.map(s -> s.getKey().getNpc())
			.toArray(String[]::new);
	}

	@Override
	public int[] getObjectIds()
	{
		return clueSteps.stream()
			.filter(s -> !s.getValue())
			.mapToInt(s -> s.getKey().getObjectId())
			.toArray();
	}
}
