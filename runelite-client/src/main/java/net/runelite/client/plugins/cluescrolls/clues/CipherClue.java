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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
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
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_CIPHER004)
			.text("BMJ UIF LFCBC TFMMFS")
			.npc(NpcID.FEUD_KEBABMAN_MULTI) // base npc for Ali or Isma'il the Kebab seller
			.location(new WorldPoint(3354, 2974, 0))
			.area("Pollnivneach")
			.question("How many coins would you need to purchase 133 kebabs from me?")
			.answer("399")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_CIPHER006)
			.text("GUHCHO")
			.npc(NpcID.PRIESTPERILTRAPPEDMONK_VIS)
			.location(new WorldPoint(3440, 9895, 0))
			.area("Paterdomus")
			.question("Please solve this for x: 7x - 28=21")
			.answer("7")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_CIPHER005)
			.text("HQNM LZM STSNQ")
			.npc(NpcID.IRONMAN_TUTOR_1)
			.location(new WorldPoint(3227, 3227, 0))
			.area("Outside Lumbridge castle")
			.question("How many snakeskins are needed in order to craft 44 boots, 29 vambraces and 34 bandanas?")
			.answer("666")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_CIPHER004)
			.text("ZHLUG ROG PDQ")
			.npc(NpcID.KALPHITE_OLDMAN)
			.location(new WorldPoint(3224, 3112, 0))
			.area("Kalphite Lair entrance. Fairy ring BIQ")
			.question("SIX LEGS! All of them have 6! There are 25 of them! How many legs?")
			.answer("150")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_CIPHER003)
			.text("ECRVCKP MJCNGF")
			.npc(NpcID.PISCARILIUS_CAPTAIN_KHALED_DEFAULT)
			.location(new WorldPoint(1845, 3754, 0))
			.area("Large eastern building in Port Piscarilius")
			.question("How many fishing cranes can you find around here?")
			.answer("5")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_CIPHER001)
			.text("OVEXON")
			.npc(NpcID.ROVING_FEMALE_WOODELF_TEMP_1)
			.locationProvider((plugin) -> isElunedInPrifddinas(plugin) ? new WorldPoint(3229, 6062, 0) : new WorldPoint(2289, 3144, 0))
			.areaProvider((plugin) -> isElunedInPrifddinas(plugin) ? "Prifddinas" : "Outside Lletya")
			.question("A question on elven crystal math. I have 5 and 3 crystals, large and small respectively. A large crystal is worth 10,000 coins and a small is worth but 1,000. How much are all my crystals worth?")
			.answer("53,000")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_CIPHER005)
			.text("VTYR APCNTGLW")
			.npc(NpcID.KING_PERCIVAL)
			.location(new WorldPoint(2634, 4682, 1))
			.area("Fisher Realm, first floor. Fairy ring BJR")
			.question("How many cannons are on this here castle?")
			.answer("5")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_CIPHER002)
			.text("UZZU MUJHRKYYKJ")
			.npc(NpcID.BRUT_OTTO)
			.location(new WorldPoint(2501, 3487, 0))
			.area("Otto's Grotto")
			.question("How many pyre sites are found around this lake?")
			.answer("3")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_CIPHER002)
			.text("XJABSE USBJCPSO")
			.npc(NpcID.TRAIBORN)
			.location(new WorldPoint(3112, 3162, 0))
			.area("First floor of Wizards Tower. Fairy ring DIS")
			.question("How many air runes would I need to cast 630 wind waves?")
			.answer("3150")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_CIPHER006)
			.text("HCKTA IQFHCVJGT")
			.npc(NpcID.FAIRY_GODFATHER2)
			.location(new WorldPoint(2446, 4428, 0))
			.area("Zanaris throne room")
			.question("There are 3 inputs and 4 letters on each ring How many total individual fairy ring codes are possible?")
			.answer("64")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_CIPHER003)
			.text("ZSBKDO ZODO")
			.npc(NpcID.DEAL_PETE)
			.location(new WorldPoint(3680, 3537, 0))
			.area("Dock northeast of the Ectofuntus")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_CIPHER007)
			.text("GBJSZ RVFFO")
			.npc(NpcID.FAIRY_QUEEN)
			.location(new WorldPoint(2347, 4435, 0))
			.area("Fairy Resistance Hideout")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_CIPHER001)
			.text("QSPGFTTPS HSBDLMFCPOF")
			.npc(NpcID.ARCEUUS_LIBRARY_CUSTOMER_3)
			.location(new WorldPoint(1625, 3802, 0))
			.area("Ground floor of Arceuus Library")
			.question("How many round tables can be found on this floor of the library?")
			.answer("9")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_CIPHER009)
			.text("IWPPLQTP")
			.npc(NpcID.GUNNJORN)
			.location(new WorldPoint(2541, 3548, 0))
			.area("Barbarian Outpost Agility course")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_CIPHER008)
			.text("BSOPME MZETQPS")
			.npc(NpcID.SWAN_ARNOLD)
			.location(new WorldPoint(2329, 3689, 0))
			.area("Piscatoris Fishing Colony general store/bank")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.CLUEQUEST_CLUE1)
			.text("ESBZOPS QJH QFO")
			.location(new WorldPoint(3077, 3260, 0))
			.area("Inside of Martin the Master Gardener's pig pen in Draynor Village.")
			.build(),
		CipherClue.builder()
			.itemId(ItemID.TRAIL_HARD_CIPHER_VM01)
			.text("BXJA UNJMNA YRCAR")
			.npc(NpcID.HUNTER_GUILD_PITRI)
			.location(new WorldPoint(1559, 3045, 0))
			.area("Top of the Hunter Guild")
			.build()
	);

	private final int itemId;
	private final String text;
	private final int npc;
	private final Function<ClueScrollPlugin, WorldPoint> locationProvider;
	private final Function<ClueScrollPlugin, String> areaProvider;
	@Nullable
	private final String question;
	@Nullable
	private final String answer;

	@Builder
	private CipherClue(
		@Nullable Integer itemId,
		String text,
		Integer npc,
		@Nullable WorldPoint location,
		@Nullable Function<ClueScrollPlugin, WorldPoint> locationProvider,
		@Nullable String area,
		@Nullable Function<ClueScrollPlugin, String> areaProvider,
		@Nullable String question,
		@Nullable String answer
	)
	{
		this.itemId = itemId != null ? itemId : -1;
		this.text = "The cipher reveals who to speak to next: " + text;
		this.npc = npc != null ? npc : -1;
		this.locationProvider = locationProvider != null ? locationProvider : (plugin) -> location;
		this.areaProvider = areaProvider != null ? areaProvider : (plugin) -> area;
		this.question = question;
		this.answer = answer;
	}

	@Override
	public WorldPoint getLocation(ClueScrollPlugin plugin)
	{
		return locationProvider.apply(plugin);
	}

	@VisibleForTesting
	String getArea(ClueScrollPlugin plugin)
	{
		return areaProvider.apply(plugin);
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
			.left(getArea(plugin))
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
		if (!getLocation(plugin).isInScene(plugin.getClient()))
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

	public static CipherClue forItemId(int itemId)
	{
		for (CipherClue clue : CLUES)
		{
			if (clue.itemId == itemId)
			{
				return clue;
			}
		}

		return null;
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
		if (npc == -1)
		{
			return null;
		}

		NPCComposition composition = plugin.getClient().getNpcDefinition(npc);
		if (composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition;
	}

	private static boolean isElunedInPrifddinas(ClueScrollPlugin plugin)
	{
		return Quest.SONG_OF_THE_ELVES.getState(plugin.getClient()) == QuestState.FINISHED;
	}
}
