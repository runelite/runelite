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
		new AnagramClue("This anagram reveals who to speak to next: A BAKER", "Baraek", new WorldPoint(3217, 3434, 0), "Varrock square", "5"),
		new AnagramClue("This anagram reveals who to speak to next: A BASIC ANTI POT", "Captain Tobias", new WorldPoint(3026, 3216, 0), "Port Sarim", "7"),
		new AnagramClue("This anagram reveals who to speak to next: A HEART", "Aretha", new WorldPoint(1814, 3851, 0), "Soul altar", "2"),
		new AnagramClue("This anagram reveals who to speak to next: A ZEN SHE", "Zenesha", new WorldPoint(2652, 3295, 0), "Platebody Southern Ardougne centre square"),
		new AnagramClue("This anagram reveals who to speak to next: ACE MATCH ELM", "Cam The Camel", new WorldPoint(3300, 3231, 0), "North of the glider in Al Kharid"),
		new AnagramClue("This anagram reveals who to speak to next: AHA JAR", "Jaraah", new WorldPoint(3359, 3276, 0), "Duel Arena hosptial"),
		new AnagramClue("This anagram reveals who to speak to next: AN PAINT TONIC", "Captain Ninto", new WorldPoint(2865, 9877, 0), "Bar under White Wolf Mountain"),
		new AnagramClue("This anagram reveals who to speak to next: ARC O LINE", "Caroline", new WorldPoint(2715, 3302, 0), "North Witchaven next to the row boat", "11"),
		new AnagramClue("This anagram reveals who to speak to next: ARE COL", "Oracle", new WorldPoint(3013, 3501, 0), "Ice Mountain West of Edgeville", "48"),
		new AnagramClue("This anagram reveals who to speak to next: ARMCHAIR THE PELT", "Charlie the Tramp", new WorldPoint(3209, 3392, 0), "South entrance of Varrock", "0"),
		new AnagramClue("This anagram reveals who to speak to next: ARR! SO I AM A CRUST, AND?", "Ramara du Croissant", new WorldPoint(2339, 3677, 0), "Piscatoris Fishing Colony"),
		new AnagramClue("This anagram reveals who to speak to next: AT HERG", "Regath", new WorldPoint(1719, 3723, 0), "General Store, Arceuus, Zeah", "25"),
		new AnagramClue("This anagram reveals who to speak to next: A BAS", "Saba", new WorldPoint(2858, 3577, 0), "Death Plateau"),
		new AnagramClue("This anagram reveals who to speak to next: AREA CHEF TREK", "Father Aereck", new WorldPoint(3243, 3208, 0), "Lumbridge Church", "19 or 20"),
		new AnagramClue("This anagram reveals who to speak to next: BAIL TRIMS", "Brimstail", new WorldPoint(2402, 3419, 0), "West of Stronghold Slayer Cave"),
		new AnagramClue("This anagram reveals who to speak to next: BAKER CLIMB", "Brambickle", new WorldPoint(2783, 3861, 0), "Trollweiss mountain"),
		new AnagramClue("This anagram reveals who to speak to next: BLUE GRIM GUIDED", "Lumbridge Guide", new WorldPoint(3232, 3232, 0), "Lumbridge"),
		new AnagramClue("This anagram reveals who to speak to next: BY LOOK", "Bolkoy", new WorldPoint(2529, 3162, 0), "Tree Gnome Village general store", "13"),
		new AnagramClue("This anagram reveals who to speak to next: CAR IF ICES", "Sacrifice", new WorldPoint(2209, 3056, 0), "Zul-Andra"),
		new AnagramClue("This anagram reveals who to speak to next: CAREER IN MOON", "Oneiromancer", new WorldPoint(2150, 3866, 0), "Astral altar", "25"),
		new AnagramClue("This anagram reveals who to speak to next: C ON GAME HOC", "Gnome Coach", new WorldPoint(2395, 3486, 0), "Gnome Ball course", "6"),
		new AnagramClue("This anagram reveals who to speak to next: COOL NERD", "Old crone", new WorldPoint(3462, 3557, 0), "East of the Slayer Tower", "619"),
		new AnagramClue("This anagram reveals who to speak to next: COPPER ORE CRYPTS", "Prospector Percy", new WorldPoint(3061, 3377, 0), "Motherlode Mine", "12"),
		new AnagramClue("This anagram reveals who to speak to next: DED WAR", "Edward", new WorldPoint(3284, 3943, 0), "Inside Rogue's Castle"),
		new AnagramClue("This anagram reveals who to speak to next: DEKAGRAM", "Dark Mage", new WorldPoint(3039, 4835, 0), "Centre of the Abyss", "13"),
		new AnagramClue("This anagram reveals who to speak to next: DO SAY MORE", "Doomsayer", new WorldPoint(3230, 3230, 0), "East of Lumbridge Castle", "95"),
		new AnagramClue("This anagram reveals who to speak to next: DIM THARN", "Mandrith", new WorldPoint(3182, 3946, 0), "Wilderness Resource Area", "28 or Puzzle box"),
		new AnagramClue("This anagram reveals who to speak to next: DR HITMAN", "Mandrith", new WorldPoint(3182, 3946, 0), "Wilderness Resource Area", "28, Light box or Puzzle box"),
		new AnagramClue("This anagram reveals who to speak to next: DR WARDEN FUNK", "Drunken Dwarf", new WorldPoint(2913, 10221, 0), "East Side of Keldagrim", "Puzzle box"),
		new AnagramClue("This anagram reveals who to speak to next: DRAGONS LAMENT", "Strange old Man", new WorldPoint(3564, 3288, 0), "Barrows", "40"),
		new AnagramClue("This anagram reveals who to speak to next: DT RUN B", "Brundt the Chieftain", new WorldPoint(2658, 3670, 0), "Rellekka, main hall", "4"),
		new AnagramClue("This anagram reveals who to speak to next: DUO PLUG", "Dugopul", new WorldPoint(2803, 2744, 0), "Graveyard on Ape Atoll"),
		new AnagramClue("This anagram reveals who to speak to next: EEK ZERO OP", "Zoo keeper", new WorldPoint(2613, 3269, 0), "Ardougne Zoo", "40"),
		new AnagramClue("This anagram reveals who to speak to next: EL OW", "Lowe", new WorldPoint(3233, 3423, 0), "Varrock archery store"),
		new AnagramClue("This anagram reveals who to speak to next: ERR CURE IT", "Recruiter", new WorldPoint(2541, 3305, 0), "West Ardougne centre square", "20"),
		new AnagramClue("This anagram reveals who to speak to next: FORLUN", "Runolf", new WorldPoint(2512, 10256, 0), "Miscellania & Etceteria Dungeon"),
		new AnagramClue("This anagram reveals who to speak to next: GOBLIN KERN", "King Bolren", new WorldPoint(2541, 3170, 0), "Tree Gnome Village"),
		new AnagramClue("This anagram reveals who to speak to next: GOT A BOY", "Gabooty", new WorldPoint(2790, 3066, 0), "Centre of Tai Bwo Wannai", "11"),
		new AnagramClue("This anagram reveals who to speak to next: GULAG RUN", "Uglug Nar", new WorldPoint(2442, 3051, 0), "West of Jiggig"),
		new AnagramClue("This anagram reveals who to speak to next: GOBLETS ODD TOES", "Otto Godblessed", new WorldPoint(2501, 3487, 0), "Otto's Grotto", "2"),
		new AnagramClue("This anagram reveals who to speak to next: HALT US", "Luthas", new WorldPoint(2938, 3152, 0), "Banana plantation, Karamja", "33 (or none)"),
		new AnagramClue("This anagram reveals who to speak to next: HE DO POSE. IT IS CULTRRL, MK?", "Riki the sculptor's model", new WorldPoint(2904, 10206, 0), "East Keldagrim, south of kebab seller."),
		new AnagramClue("This anagram reveals who to speak to next: HEORIC", "Eohric", new WorldPoint(2900, 3565, 0), "Top floor of Burthorpe Castle", "36"),
		new AnagramClue("This anagram reveals who to speak to next: HIS PHOR", "Horphis", new WorldPoint(1639, 3812, 0), "Arceuus Library, Zeah", "1"),
		new AnagramClue("This anagram reveals who to speak to next: I AM SIR", "Marisi", new WorldPoint(1813, 3488, 0), "Allotment patch, South coast Zeah", "5"),
		new AnagramClue("This anagram reveals who to speak to next: ICY FE", "Fycie", new WorldPoint(2630, 2997, 0), "East Feldip Hills"),
		new AnagramClue("This anagram reveals who to speak to next: I DOOM ICON INN", "Dominic Onion", new WorldPoint(2609, 3116, 0), "Nightmare Zone", "9,500"),
		new AnagramClue("This anagram reveals who to speak to next: I EAT ITS CHART HINTS DO U", "Shiratti the Custodian", new WorldPoint(3427, 2927, 0), "North of fountain, Nardah"),
		new AnagramClue("This anagram reveals who to speak to next: I EVEN", "Nieve", new WorldPoint(2432, 3422, 0), "The slayer master in Gnome Stronghold", "2"),
		new AnagramClue("This anagram reveals who to speak to next: I FAFFY RUN", "Fairy Nuff", new WorldPoint(3201, 3169, 0), "North of the bank in Zanaris"),
		new AnagramClue("This anagram reveals who to speak to next: IM N ZEZIM", "Impling", new WorldPoint(2592, 4324, 0), "The Imp inside Puro-Puro"),
		new AnagramClue("This anagram reveals who to speak to next: KAY SIR", "Sir Kay", new WorldPoint(2760, 3496, 0), "The courtyard in Camelot Castle", "6"),
		new AnagramClue("This anagram reveals who to speak to next: LEAKEY", "Kaylee", new WorldPoint(2957, 3370, 0), "Rising Sun Inn in Falador", "18"),
		new AnagramClue("This anagram reveals who to speak to next: LAND DOOMD", "Odd Old Man", new WorldPoint(3359, 3506, 0), "Limestone mine northeast of Varrock"),
		new AnagramClue("This anagram reveals who to speak to next: LARK IN DOG", "King Roald", new WorldPoint(3220, 3476, 0), "Ground floor of Varrock castle", "24"),
		new AnagramClue("This anagram reveals who to speak to next: LOW LAG", "Gallow", new WorldPoint(1805, 3566, 0), "Vinery in the Great Kourend", "12"),
		new AnagramClue("This anagram reveals who to speak to next: LADDER MEMO GUV", "Guard Vemmeldo", new WorldPoint(2447, 3418, 0), "Gnome Stronghold Bank", "3"),
		new AnagramClue("This anagram reveals who to speak to next: MAL IN TAU", "Luminata", new WorldPoint(3508, 3237, 0), "Near Burgh de Rott entrance"),
		new AnagramClue("This anagram reveals who to speak to next: ME AM THE CALC", "Cam the Camel", new WorldPoint(3300, 3231, 0), "Outside Duel Arena"),
		new AnagramClue("This anagram reveals who to speak to next: MACHETE CLAM", "Cam the Camel", new WorldPoint(3300, 3231, 0), "Outside Duel Arena", "6"),
		new AnagramClue("This anagram reveals who to speak to next: ME IF", "Femi", new WorldPoint(2461, 3382, 0), "Gates of Tree Gnome Stronghold"),
		new AnagramClue("This anagram reveals who to speak to next: MOLD LA RAN", "Old Man Ral", new WorldPoint(3602, 3209, 0), "Meiyerditch"),
		new AnagramClue("This anagram reveals who to speak to next: MOTHERBOARD", "Brother Omad", new WorldPoint(2606, 3211, 0), "Monastery south of Ardougne", "129"),
		new AnagramClue("This anagram reveals who to speak to next: MUS KIL READER", "Radimus Erkle", new WorldPoint(2726, 3368, 0), "Legends' Guild"),
		new AnagramClue("This anagram reveals who to speak to next: MY MANGLE LAL", "Lammy Langle", new WorldPoint(1688, 3540, 0), "Hosidius House spirit tree patch"),
		new AnagramClue("This anagram reveals who to speak to next: NO OWNER", "Oronwen", new WorldPoint(1162, 3178, 0), "Lletya Seamstress shop in Lletya", "20"),
		new AnagramClue("This anagram reveals who to speak to next: NOD MED", "Edmond", new WorldPoint(2566, 3332, 0), "Behind the most NW house in East Ardougne", "3"),
		new AnagramClue("This anagram reveals who to speak to next: O BIRDZ A ZANY EN PC", "Cap'n Izzy no Beard", new WorldPoint(2807, 3191, 0), "Brimhaven Agility Arena", "33"),
		new AnagramClue("This anagram reveals who to speak to next: OK CO", "Cook", new WorldPoint(3207, 3214, 0), "Ground floor of Lumbridge Castle", "9"),
		new AnagramClue("This anagram reveals who to speak to next: OR ZINC FUMES WARD", "Wizard Frumscone", new WorldPoint(2594, 3086, 0), "Downstairs in the Wizards' Guild"),
		new AnagramClue("This anagram reveals who to speak to next: OUR OWN NEEDS", "Nurse Wooned", new WorldPoint(1575, 3590, 0), "Shayzien House Infirmary", "19"),
		new AnagramClue("This anagram reveals who to speak to next: PACINNG A TAIE", "Captain Ginea", new WorldPoint(1561, 3602, 0), "Building east of Shayzien combat ring", "113"),
		new AnagramClue("This anagram reveals who to speak to next: PEAK REFLEX", "Flax keeper", new WorldPoint(2744, 3444, 0), "Flax field south of Seers Village", "676"),
		new AnagramClue("This anagram reveals who to speak to next: PEATY PERT", "Party Pete", new WorldPoint(3047, 3376, 0), "Falador Party Room"),
		new AnagramClue("This anagram reveals who to speak to next: PROFS LOSE WRONG PIE", "Professor Onglewip", new WorldPoint(3113, 3162, 0), "Ground floor of Wizards Tower"),
		new AnagramClue("This anagram reveals who to speak to next: QUIT HORRIBLE TYRANT", "Brother Tranquility", new WorldPoint(3681, 2963, 0), "Mos Le'Harmless or Harmony Island", "7"),
		new AnagramClue("This anagram reveals who to speak to next: QUE SIR", "Squire", new WorldPoint(2975, 3343, 0), "Falador Castle Courtyard", "654"),
		new AnagramClue("This anagram reveals who to speak to next: R AK MI", "Karim", new WorldPoint(3273, 3181, 0), "Al Kharid Kebab shop", "5"),
		new AnagramClue("This anagram reveals who to speak to next: RAT MAT WITHIN", "Martin Thwait", new WorldPoint(2906, 3537, 0), "Rogues' Den", "2"),
		new AnagramClue("This anagram reveals who to speak to next: RED ART TANS", "Trader Stan", new WorldPoint(3041, 3193, 0), "Port Sarim Charter ship"),
		new AnagramClue("This anagram reveals who to speak to next: RATAI", "Taria", new WorldPoint(2940, 3223, 0), "Rimmington bush patch", "7"),
		new AnagramClue("This anagram reveals who to speak to next: R SLICER", "Clerris", new WorldPoint(1761, 3850, 0), "Arceuus mine, Zeah", "738"),
		new AnagramClue("This anagram reveals who to speak to next: SAND NUT", "Dunstan", new WorldPoint(2919, 3574, 0), "Anvil in north east Burthorpe", "8"),
		new AnagramClue("This anagram reveals who to speak to next: SEQUIN DIRGE", "Queen Sigrid", new WorldPoint(2612, 3867, 0), "Throne room of Etceteria Castle."),
		new AnagramClue("This anagram reveals who to speak to next: SLAM DUSTER GRAIL", "Guildmaster Lars", new WorldPoint(1649, 3498, 0), "Woodcutting guild, Zeah"),
		new AnagramClue("This anagram reveals who to speak to next: SLIDE WOMAN", "Wise Old Man", new WorldPoint(3088, 3253, 0), "Draynor Village", "28"),
		new AnagramClue("This anagram reveals who to speak to next: SNAH", "Hans", new WorldPoint(3218, 3219, 0), "Lumbridge Castle courtyard"),
		new AnagramClue("This anagram reveals who to speak to next: SNAKES SO I SAIL", "Lisse Isaakson", new WorldPoint(2351, 3801, 0), "Neitiznot", "2"),
		new AnagramClue("This anagram reveals who to speak to next: TAMED ROCKS", "Dockmaster", new WorldPoint(1822, 3739, 0), "Piscarilius House, NE of General store", "5"),
		new AnagramClue("This anagram reveals who to speak to next: TEN WIGS ON", "Wingstone", new WorldPoint(3389, 2877, 0), "Between Nardah & Agility Pyramid"),
		new AnagramClue("This anagram reveals who to speak to next: THEM CAL CAME", "Cam the Camel", new WorldPoint(3300, 3231, 0), "Just outside of the Duel Arena"),
		new AnagramClue("This anagram reveals who to speak to next: THICKNO", "Hickton", new WorldPoint(2822, 3442, 0), "Catherby fletching shop", "2"),
		new AnagramClue("This anagram reveals who to speak to next: TWENTY CURE IRON", "New recruit Tony", new WorldPoint(1498, 3544, 0), "Shayzien House's Graveyard"),
		new AnagramClue("This anagram reveals who to speak to next: UNLEASH NIGHT MIST", "Sigli the Huntsman", new WorldPoint(2660, 3654, 0), "Rellekka", "302"),
		new AnagramClue("This anagram reveals who to speak to next: VESTE", "Steve", new WorldPoint(2432, 3423, 0), "Upstairs Wyvern Area or Stronghold Slayer Cave", "2"),
		new AnagramClue("This anagram reveals who to speak to next: VEIL VEDA", "Evil Dave", new WorldPoint(3079, 9892, 0), "Doris' basement, Edgeville", "666"),
		new AnagramClue("This anagram reveals who to speak to next: WOO AN EGG KIWI", "Awowogei", new WorldPoint(2802, 2764, 0), "Ape Atoll", "24"),
		new AnagramClue("This anagram reveals who to speak to next: YAWNS GY", "Ysgawyn", new WorldPoint(2340, 3167, 0), "Lletya"),
		new AnagramClue("This anagram reveals who to speak to next: MAJORS LAVA BADS AIR", "Ambassador Alvijar", new WorldPoint(2736, 5351, 1), "Dorgesh-Kaan, NE Middle Level", "2505")
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
		panelComponent.getChildren().add(TitleComponent.builder().text("Anagram Clue").build());
		panelComponent.getChildren().add(LineComponent.builder().left("NPC:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getNpc())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		panelComponent.getChildren().add(LineComponent.builder().left("Area:").build());
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
