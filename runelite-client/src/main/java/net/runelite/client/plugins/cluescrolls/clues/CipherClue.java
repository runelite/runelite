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
public class CipherClue extends ClueScroll implements TextClueScroll, NpcClueScroll, LocationClueScroll
{
	private static final Set<CipherClue> CLUES = ImmutableSet.of(
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(3354, 2974, 0), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(3440, 9895, 0), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(3227, 3227, 0), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(3224, 3112, 0), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(1845, 3754, 0), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(2289, 3144, 0), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(2634, 4682, 1), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(2501, 3487, 0), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(3112, 3162, 0), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(2446, 4428, 0), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(3680, 3537, 0), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(2347, 4435, 0), "It's coming home", "It's coming home"),
		new CipherClue("It's coming home", "It's coming home", new WorldPoint(1625, 3802, 0), "It's coming home", "It's coming home")
	);

	private String text;
	private String npc;
	private WorldPoint location;
	private String area;
	private String answer;

	private CipherClue(String text, String npc, WorldPoint location, String area, String answer)
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

	public static CipherClue forText(String text)
	{
		for (CipherClue clue : CLUES)
		{
			if (clue.text.equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		return null;
	}
}
