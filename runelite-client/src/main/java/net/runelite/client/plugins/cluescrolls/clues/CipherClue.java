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
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter(AccessLevel.PUBLIC)
public class CipherClue extends ClueScroll implements TextClueScroll, NpcClueScroll, LocationClueScroll
{
	private static final Set<CipherClue> CLUES = ImmutableSet.of(
		new CipherClue("BMJ UIF LFCBC TFMMFS", "Ali the Kebab seller", new WorldPoint(3354, 2974, 0), "Pollnivneach", "How many coins would you need to purchase 133 kebabs from me?", "399"),
		new CipherClue("GUHCHO", "Drezel", new WorldPoint(3440, 9895, 0), "Paterdomus", "Please solve this for x: 7x - 28=21", "7"),
		new CipherClue("ZCZL", "Adam", new WorldPoint(3227, 3227, 0), "Outside Lumbridge castle", "How many snakeskins are needed in order to craft 44 boots, 29 vambraces and 34 bandanas?", "666"),
		new CipherClue("ZHLUG ROG PDQ", "Weird Old Man", new WorldPoint(3224, 3112, 0), "Kalphite Lair entrance. Fairy ring BIQ", "SIX LEGS! All of them have 6! There are 25 of them! How many legs?", "150"),
		new CipherClue("ECRVCKP MJCNGF", "Captain Khaled", new WorldPoint(1845, 3754, 0), "Large eastern building in Port Piscarilius", "How many fishing cranes can you find around here?", "5"),
		new CipherClue("OVEXON", "Eluned", new WorldPoint(2289, 3144, 0), "Outside Lletya", "A question on elven crystal math. I have 5 and 3 crystals, large and small respectively. A large crystal is worth 10,000 coins and a small is worth but 1,000. How much are all my crystals worth?", "53,000"),
		new CipherClue("VTYR APCNTGLW", "King Percival", new WorldPoint(2634, 4682, 1), "Fisher Realm, first floor. Fairy ring BJR", "How many cannons are on this here castle?", "5"),
		new CipherClue("UZZU MUJHRKYYKJ", "Otto Godblessed", new WorldPoint(2501, 3487, 0), "Otto's Grotto", "How many pyre sites are found around this lake?", "3"),
		new CipherClue("USBJCPSO", "Traiborn", new WorldPoint(3112, 3162, 0), "First floor of Wizards Tower", "How many air runes would I need to cast 630 wind waves?", "3150"),
		new CipherClue("HCKTA IQFHCVJGT", "Fairy Godfather", new WorldPoint(2446, 4428, 0), "Zanaris throne room", "There are 3 inputs and 4 letters on each ring How many total individual fairy ring codes are possible?", "64"),
		new CipherClue("ZSBKDO ZODO", "Pirate Pete", new WorldPoint(3680, 3537, 0), "Dock northeast of the Ectofunctus"),
		new CipherClue("GBJSZ RVFFO", "Fairy Queen", new WorldPoint(2347, 4435, 0), "Fairy Resistance Hideout"),
		new CipherClue("QSPGFTTPS HSBDLMFCPOF", "Professor Gracklebone", new WorldPoint(1625, 3802, 0), "Ground floor of Arceuus Library", "How many round tables can be found on this floor of the library?", "9"),
		new CipherClue("IWPPLQTP", "Gunnjorn", new WorldPoint(2541, 3548, 0), "Barbarian Outpost Agility course"),
		new CipherClue("BSOPME MZETQPS", "Arnold Lydspor", new WorldPoint(2329, 3689, 0), "Piscatoris Fishing Colony general store/bank")
	);

	private String text;
	private String npc;
	private WorldPoint location;
	private String area;
	private String question;
	private String answer;

	private CipherClue(String text, String npc, WorldPoint location, String area)
	{
		this(text, npc, location, area, "", null);
	}

	private CipherClue(String text, String npc, WorldPoint location, String area, String question, String answer)
	{
		this.text = "The cipher reveals who to speak to next: " + text;
		this.npc = npc;
		this.location = location;
		this.area = area;
		this.question = question;
		this.answer = answer;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Cipher Clue").build());
		panelComponent.getChildren().add(LineComponent.builder().left("NPC:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getNpc())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		panelComponent.getChildren().add(LineComponent.builder().left("Location:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getArea())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		if (getAnswer() != null)
		{
			panelComponent.getChildren().add(LineComponent.builder().left("Answer:").build());
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
				OverlayUtil.renderActorOverlayImage(graphics, npc, plugin.getClueScrollImage(), Color.ORANGE, IMAGE_Z_OFFSET);
			}
		}
	}

	public static CipherClue forText(String text)
	{
		for (CipherClue clue : CLUES)
		{
			if (clue.text.equalsIgnoreCase(text) || clue.question.equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		return null;
	}

	public String[] getNpcs()
	{
		return new String[]{npc};
	}
}
