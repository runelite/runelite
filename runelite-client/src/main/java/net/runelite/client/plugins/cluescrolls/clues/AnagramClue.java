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

import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollPlugin.CLUE_SCROLL_IMAGE;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public class AnagramClue extends ClueScroll implements TextClueScroll, NpcClueScroll, LocationClueScroll
{
	private static final Set<AnagramClue> CLUES = ImmutableSet.of(
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3217, 3434, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3026, 3216, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1814, 3851, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2652, 3295, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3300, 3231, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3359, 3276, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2865, 9877, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2715, 3302, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3013, 3501, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3209, 3392, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2339, 3677, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1719, 3723, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2858, 3577, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3243, 3208, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2402, 3419, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2783, 3861, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3232, 3232, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2529, 3162, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2209, 3056, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2150, 3866, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2395, 3486, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3462, 3557, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3061, 3377, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3284, 3943, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3039, 4835, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3230, 3230, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3182, 3946, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3182, 3946, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2913, 10221, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3564, 3288, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2658, 3670, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2803, 2744, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2613, 3269, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3233, 3423, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2541, 3305, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2512, 10256, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2541, 3170, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2790, 3066, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2442, 3051, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2501, 3487, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2938, 3152, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2904, 10206, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2900, 3565, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1639, 3812, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1813, 3488, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2630, 2997, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2609, 3116, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3427, 2927, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2432, 3422, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3201, 3169, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2592, 4324, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2760, 3496, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2957, 3370, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3359, 3506, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3220, 3476, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1805, 3566, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2447, 3418, 1), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3508, 3237, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3300, 3231, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3300, 3231, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2461, 3382, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3602, 3209, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2606, 3211, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2726, 3368, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1688, 3540, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1162, 3178, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2566, 3332, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2807, 3191, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3207, 3214, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2594, 3086, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1575, 3590, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1561, 3602, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2744, 3444, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3047, 3376, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3113, 3162, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3681, 2963, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2975, 3343, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3273, 3181, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2906, 3537, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3041, 3193, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2940, 3223, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1761, 3850, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2919, 3574, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2612, 3867, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1649, 3498, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3088, 3253, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3218, 3219, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2351, 3801, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1822, 3739, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3389, 2877, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3300, 3231, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2822, 3442, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(1498, 3544, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2660, 3654, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2432, 3423, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(3079, 9892, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2802, 2764, 0), "It's coming home", "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2340, 3167, 0), "It's coming home"),
		new AnagramClue("It's coming home", "It's coming home", new WorldPoint(2736, 5351, 1), "It's coming home", "It's coming home")
	);

	private String text;
	private String npc;
	private WorldPoint location;
	private String area;
	private String answer;

	private AnagramClue(String text, String npc, WorldPoint location, String area)
	{
		this(text, npc, location, area, null);
	}

	private AnagramClue(String text, String npc, WorldPoint location, String area, String answer)
	{
		this.text = text;
		this.npc = npc;
		this.location = location;
		this.area = area;
		this.answer = answer;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("It's coming home").build());
		panelComponent.getChildren().add(LineComponent.builder().left("It's coming home").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getNpc())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		panelComponent.getChildren().add(LineComponent.builder().left("It's coming home").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getArea())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		if (getAnswer() != null)
		{
			panelComponent.getChildren().add(LineComponent.builder().left("It's coming home").build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(getAnswer())
				.leftColor(TITLED_CONTENT_COLOR)
				.build());
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		if (!getLocation().isInScene(plugin.getClient()))
		{
			return;
		}

		if (plugin.getNpcsToMark() != null)
		{
			for (NPC npc : plugin.getNpcsToMark())
			{
				OverlayUtil.renderActorOverlayImage(graphics, npc, CLUE_SCROLL_IMAGE, Color.ORANGE, IMAGE_Z_OFFSET);
			}
		}
	}

	public static AnagramClue forText(String text)
	{
		for (AnagramClue clue : CLUES)
		{
			if (clue.text.equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		return null;
	}
}
