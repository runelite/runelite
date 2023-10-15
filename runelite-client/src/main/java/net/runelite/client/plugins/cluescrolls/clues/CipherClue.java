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
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.NpcID;
import net.runelite.api.NullNpcID;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public class CipherClue extends ClueScroll implements NpcClueScroll, LocationClueScroll
{
	static final List<CipherClue> CLUES = ImmutableList.of(
		new CipherClue("BMJ UIF LFCBC TFMMFS", /* base npc for Ali or Isma'il the Kebab seller */ NullNpcID.NULL_11875, new WorldPoint(3354, 2974, 0), "Pollnivneach", "How many coins would you need to purchase 133 kebabs from me?", "399"),
		new CipherClue("GUHCHO", NpcID.DREZEL, new WorldPoint(3440, 9895, 0), "Paterdomus", "Please solve this for x: 7x - 28=21", "7"),
		new CipherClue("HQNM LZM STSNQ", NpcID.IRON_MAN_TUTOR, new WorldPoint(3227, 3227, 0), "Outside Lumbridge castle", "How many snakeskins are needed in order to craft 44 boots, 29 vambraces and 34 bandanas?", "666"),
		new CipherClue("ZHLUG ROG PDQ", NpcID.WEIRD_OLD_MAN, new WorldPoint(3224, 3112, 0), "Kalphite Lair entrance. Fairy ring BIQ", "SIX LEGS! All of them have 6! There are 25 of them! How many legs?", "150"),
		new CipherClue("ECRVCKP MJCNGF", NpcID.CAPTAIN_KHALED, new WorldPoint(1845, 3754, 0), "Large eastern building in Port Piscarilius", "How many fishing cranes can you find around here?", "5"),
		new CipherClue("OVEXON", NpcID.ELUNED, new WorldPoint(2289, 3144, 0), "Outside Lletya or in Prifddinas after Song of the Elves", "A question on elven crystal math. I have 5 and 3 crystals, large and small respectively. A large crystal is worth 10,000 coins and a small is worth but 1,000. How much are all my crystals worth?", "53,000"),
		new CipherClue("VTYR APCNTGLW", NpcID.KING_PERCIVAL, new WorldPoint(2634, 4682, 1), "Fisher Realm, first floor. Fairy ring BJR", "How many cannons are on this here castle?", "5"),
		new CipherClue("UZZU MUJHRKYYKJ", NpcID.OTTO_GODBLESSED, new WorldPoint(2501, 3487, 0), "Otto's Grotto", "How many pyre sites are found around this lake?", "3"),
		new CipherClue("XJABSE USBJCPSO", NpcID.WIZARD_TRAIBORN, new WorldPoint(3112, 3162, 0), "First floor of Wizards Tower. Fairy ring DIS", "How many air runes would I need to cast 630 wind waves?", "3150"),
		new CipherClue("HCKTA IQFHCVJGT", NpcID.FAIRY_GODFATHER, new WorldPoint(2446, 4428, 0), "Zanaris throne room", "There are 3 inputs and 4 letters on each ring How many total individual fairy ring codes are possible?", "64"),
		new CipherClue("ZSBKDO ZODO", NpcID.PIRATE_PETE, new WorldPoint(3680, 3537, 0), "Dock northeast of the Ectofuntus"),
		new CipherClue("GBJSZ RVFFO", NpcID.FAIRY_QUEEN, new WorldPoint(2347, 4435, 0), "Fairy Resistance Hideout"),
		new CipherClue("QSPGFTTPS HSBDLMFCPOF", NpcID.PROFESSOR_GRACKLEBONE, new WorldPoint(1625, 3802, 0), "Ground floor of Arceuus Library", "How many round tables can be found on this floor of the library?", "9"),
		new CipherClue("IWPPLQTP", NpcID.GUNNJORN, new WorldPoint(2541, 3548, 0), "Barbarian Outpost Agility course"),
		new CipherClue("BSOPME MZETQPS", NpcID.ARNOLD_LYDSPOR, new WorldPoint(2329, 3689, 0), "Piscatoris Fishing Colony general store/bank"),
		new CipherClue("ESBZOPS QJH QFO", new WorldPoint(3077, 3260, 0), "Inside of Martin the Master Gardener's pig pen in Draynor Village.")
	);

	private final String text;
	private final int npcId;
	@Getter(AccessLevel.PRIVATE)
	private final WorldPoint location;
	private final String area;
	@Nullable
	private final String question;
	@Nullable
	private final String answer;

	private CipherClue(String text, WorldPoint location, String area)
	{
		this.text = "The cipher reveals where to dig next: " + text;
		this.npcId = -1;
		this.location = location;
		this.area = area;
		this.question = null;
		this.answer = null;
	}

	private CipherClue(String text, int npcId, WorldPoint location, String area)
	{
		this(text, npcId, location, area, null, null);
	}

	private CipherClue(String text, int npcId, WorldPoint location, String area, @Nullable String question, @Nullable String answer)
	{
		this.text = "The cipher reveals who to speak to next: " + text;
		this.npcId = npcId;
		this.location = location;
		this.area = area;
		this.question = question;
		this.answer = answer;
	}

	@Override
	public WorldPoint getLocation(ClueScrollPlugin plugin)
	{
		return location;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Cipher Clue").build());

		final NPCComposition npc = getNpcComposition(plugin);
		if (npc != null)
		{
			panelComponent.getChildren().add(LineComponent.builder().left("NPC:").build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(npc.getName())
				.leftColor(TITLED_CONTENT_COLOR)
				.build());
		}

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

		renderOverlayNote(panelComponent, plugin);
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
			if (text.equalsIgnoreCase(clue.text) || text.equalsIgnoreCase(clue.question))
			{
				return clue;
			}
		}

		return null;
	}

	@Override
	public String[] getNpcs(ClueScrollPlugin plugin)
	{
		NPCComposition comp = getNpcComposition(plugin);
		return new String[]{comp == null ? null : comp.getName()};
	}

	@Override
	public int[] getConfigKeys()
	{
		return new int[]{text.hashCode()};
	}

	private NPCComposition getNpcComposition(ClueScrollPlugin plugin)
	{
		if (npcId == -1)
		{
			return null;
		}

		NPCComposition composition = plugin.getClient().getNpcDefinition(npcId);
		if (composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition;
	}
}
