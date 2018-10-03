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
import static net.runelite.api.NpcID.*;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public class AnagramClue extends ClueScroll implements TextClueScroll, NpcClueScroll, LocationClueScroll
{
	private static final Set<AnagramClue> CLUES = ImmutableSet.of(
		new AnagramClue("A BAKER", BARAEK, new WorldPoint(3217, 3434, 0), "Varrock square", "5"),
		new AnagramClue("A BASIC ANTI POT", CAPTAIN_TOBIAS, new WorldPoint(3026, 3216, 0), "Port Sarim", "7"),
		new AnagramClue("A HEART", ARETHA, new WorldPoint(1814, 3851, 0), "Soul altar", "2"),
		new AnagramClue("A ZEN SHE", ZENESHA, new WorldPoint(2652, 3295, 0), "Platebody Southern Ardougne centre square"),
		new AnagramClue("ACE MATCH ELM", CAM_THE_CAMEL, new WorldPoint(3300, 3231, 0), "North of the glider in Al Kharid"),
		new AnagramClue("AHA JAR", JARAAH, new WorldPoint(3359, 3276, 0), "Duel Arena hospital"),
		new AnagramClue("AN PAINT TONIC", CAPTAIN_NINTO, new WorldPoint(2865, 9877, 0), "Bar under White Wolf Mountain"),
		new AnagramClue("ARC O LINE", CAROLINE, new WorldPoint(2715, 3302, 0), "North Witchaven next to the row boat", "11"),
		new AnagramClue("ARE COL", ORACLE, new WorldPoint(3013, 3501, 0), "Ice Mountain West of Edgeville", "48"),
		new AnagramClue("ARMCHAIR THE PELT", CHARLIE_THE_TRAMP, new WorldPoint(3209, 3392, 0), "South entrance of Varrock", "0"),
		new AnagramClue("ARR! SO I AM A CRUST, AND?", RAMARA_DU_CROISSANT, new WorldPoint(2339, 3677, 0), "Piscatoris Fishing Colony"),
		new AnagramClue("AT HERG", REGATH, new WorldPoint(1719, 3723, 0), "General Store, Arceuus, Zeah", "25"),
		new AnagramClue("A BAS", SABA, new WorldPoint(2858, 3577, 0), "Death Plateau"),
		new AnagramClue("AREA CHEF TREK", FATHER_AERECK, new WorldPoint(3243, 3208, 0), "Lumbridge Church", "19 or 20"),
		new AnagramClue("BAIL TRIMS", BRIMSTAIL, new WorldPoint(2402, 3419, 0), "West of Stronghold Slayer Cave"),
		new AnagramClue("BAKER CLIMB", BRAMBICKLE, new WorldPoint(2783, 3861, 0), "Trollweiss mountain"),
		new AnagramClue("BLUE GRIM GUIDED", LUMBRIDGE_GUIDE, new WorldPoint(3232, 3232, 0), "Lumbridge"),
		new AnagramClue("BY LOOK", BOLKOY, new WorldPoint(2529, 3162, 0), "Tree Gnome Village general store", "13"),
		new AnagramClue("CAR IF ICES", SACRIFICE, new WorldPoint(2209, 3056, 0), "Zul-Andra"),
		new AnagramClue("CAREER IN MOON", ONEIROMANCER, new WorldPoint(2150, 3866, 0), "Astral altar", "25"),
		new AnagramClue("C ON GAME HOC", GNOME_COACH, new WorldPoint(2395, 3486, 0), "Gnome Ball course", "6"),
		new AnagramClue("COOL NERD", OLD_CRONE, new WorldPoint(3462, 3557, 0), "East of the Slayer Tower", "619"),
		new AnagramClue("COPPER ORE CRYPTS", PROSPECTOR_PERCY, new WorldPoint(3061, 3377, 0), "Motherlode Mine", "12"),
		new AnagramClue("DED WAR", EDWARD, new WorldPoint(3284, 3943, 0), "Inside Rogue's Castle"),
		new AnagramClue("DEKAGRAM", DARK_MAGE, new WorldPoint(3039, 4835, 0), "Centre of the Abyss", "13"),
		new AnagramClue("DO SAY MORE", DOOMSAYER, new WorldPoint(3230, 3230, 0), "East of Lumbridge Castle", "95"),
		new AnagramClue("DIM THARN", MANDRITH, new WorldPoint(3182, 3946, 0), "Wilderness Resource Area", "28 or Puzzle box"),
		new AnagramClue("DR HITMAN", MANDRITH, new WorldPoint(3182, 3946, 0), "Wilderness Resource Area", "28, Light box or Puzzle box"),
		new AnagramClue("DR WARDEN FUNK", DRUNKEN_DWARF, new WorldPoint(2913, 10221, 0), "East Side of Keldagrim", "Puzzle box"),
		new AnagramClue("DRAGONS LAMENT", STRANGE_OLD_MAN, new WorldPoint(3564, 3288, 0), "Barrows", "40"),
		new AnagramClue("DT RUN B", BRUNDT_THE_CHIEFTAIN, new WorldPoint(2658, 3670, 0), "Rellekka, main hall", "4"),
		new AnagramClue("DUO PLUG", DUGOPUL, new WorldPoint(2803, 2744, 0), "Graveyard on Ape Atoll"),
		new AnagramClue("EEK ZERO OP", ZOO_KEEPER, new WorldPoint(2613, 3269, 0), "Ardougne Zoo", "40"),
		new AnagramClue("EL OW", LOWE, new WorldPoint(3233, 3423, 0), "Varrock archery store"),
		new AnagramClue("ERR CURE IT", RECRUITER, new WorldPoint(2541, 3305, 0), "West Ardougne centre square", "20"),
		new AnagramClue("FORLUN", RUNOLF, new WorldPoint(2512, 10256, 0), "Miscellania & Etceteria Dungeon"),
		new AnagramClue("GOBLIN KERN", KING_BOLREN, new WorldPoint(2541, 3170, 0), "Tree Gnome Village"),
		new AnagramClue("GOT A BOY", GABOOTY, new WorldPoint(2790, 3066, 0), "Centre of Tai Bwo Wannai", "11"),
		new AnagramClue("GULAG RUN", UGLUG_NAR, new WorldPoint(2442, 3051, 0), "West of Jiggig"),
		new AnagramClue("GOBLETS ODD TOES", OTTO_GODBLESSED, new WorldPoint(2501, 3487, 0), "Otto's Grotto", "2"),
		new AnagramClue("HALT US", LUTHAS, new WorldPoint(2938, 3152, 0), "Banana plantation, Karamja", "33 (or none)"),
		new AnagramClue("HE DO POSE. IT IS CULTRRL, MK?", RIKI_THE_SCULPTORS_MODEL, new WorldPoint(2904, 10206, 0), "East Keldagrim, south of kebab seller."),
		new AnagramClue("HEORIC", EOHRIC, new WorldPoint(2900, 3565, 0), "Top floor of Burthorpe Castle", "36"),
		new AnagramClue("HIS PHOR", HORPHIS, new WorldPoint(1639, 3812, 0), "Arceuus Library, Zeah", "1"),
		new AnagramClue("I AM SIR", MARISI, new WorldPoint(1813, 3488, 0), "Allotment patch, South coast Zeah", "5"),
		new AnagramClue("ICY FE", FYCIE, new WorldPoint(2630, 2997, 0), "East Feldip Hills"),
		new AnagramClue("I DOOM ICON INN", DOMINIC_ONION, new WorldPoint(2609, 3116, 0), "Nightmare Zone", "9,500"),
		new AnagramClue("I EAT ITS CHART HINTS DO U", SHIRATTI_THE_CUSTODIAN, new WorldPoint(3427, 2927, 0), "North of fountain, Nardah"),
		new AnagramClue("I EVEN", NIEVE, new WorldPoint(2432, 3422, 0), "The slayer master in Gnome Stronghold", "2"),
		new AnagramClue("I FAFFY RUN", FAIRY_NUFF, new WorldPoint(3201, 3169, 0), "North of the bank in Zanaris"),
		new AnagramClue("IM N ZEZIM", IMPLING, new WorldPoint(2592, 4324, 0), "The Imp inside Puro-Puro"),
		new AnagramClue("KAY SIR", SIR_KAY, new WorldPoint(2760, 3496, 0), "The courtyard in Camelot Castle", "6"),
		new AnagramClue("LEAKEY", KAYLEE, new WorldPoint(2957, 3370, 0), "Rising Sun Inn in Falador", "18"),
		new AnagramClue("LAND DOOMD", ODD_OLD_MAN, new WorldPoint(3359, 3506, 0), "Limestone mine northeast of Varrock"),
		new AnagramClue("LARK IN DOG", KING_ROALD, new WorldPoint(3220, 3476, 0), "Ground floor of Varrock castle", "24"),
		new AnagramClue("LOW LAG", GALLOW, new WorldPoint(1805, 3566, 0), "Vinery in the Great Kourend", "12"),
		new AnagramClue("LADDER MEMO GUV", GUARD_VEMMELDO, new WorldPoint(2447, 3418, 1), "Gnome Stronghold Bank", "3"),
		new AnagramClue("MAL IN TAU", LUMINATA, new WorldPoint(3508, 3237, 0), "Near Burgh de Rott entrance"),
		new AnagramClue("ME AM THE CALC", CAM_THE_CAMEL, new WorldPoint(3300, 3231, 0), "Outside Duel Arena"),
		new AnagramClue("MACHETE CLAM", CAM_THE_CAMEL, new WorldPoint(3300, 3231, 0), "Outside Duel Arena", "6"),
		new AnagramClue("ME IF", FEMI, new WorldPoint(2461, 3382, 0), "Gates of Tree Gnome Stronghold"),
		new AnagramClue("MOLD LA RAN", OLD_MAN_RAL, new WorldPoint(3602, 3209, 0), "Meiyerditch"),
		new AnagramClue("MOTHERBOARD", BROTHER_OMAD, new WorldPoint(2606, 3211, 0), "Monastery south of Ardougne", "129"),
		new AnagramClue("MUS KIL READER", RADIMUS_ERKLE, new WorldPoint(2726, 3368, 0), "Legends' Guild"),
		new AnagramClue("MY MANGLE LAL", LAMMY_LANGLE, new WorldPoint(1688, 3540, 0), "Hosidius House spirit tree patch"),
		new AnagramClue("NO OWNER", ORONWEN, new WorldPoint(1162, 3178, 0), "Lletya Seamstress shop in Lletya", "20"),
		new AnagramClue("NOD MED", EDMOND, new WorldPoint(2566, 3332, 0), "Behind the most NW house in East Ardougne", "3"),
		new AnagramClue("O BIRDZ A ZANY EN PC", CAPN_IZZY_NOBEARD, new WorldPoint(2807, 3191, 0), "Brimhaven Agility Arena", "33"),
		new AnagramClue("OK CO", COOK, new WorldPoint(3207, 3214, 0), "Ground floor of Lumbridge Castle", "9"),
		new AnagramClue("OR ZINC FUMES WARD", WIZARD_FRUMSCONE, new WorldPoint(2594, 3086, 0), "Downstairs in the Wizards' Guild"),
		new AnagramClue("OUR OWN NEEDS", NURSE_WOONED, new WorldPoint(1575, 3590, 0), "Shayzien House Infirmary", "19"),
		new AnagramClue("PACINNG A TAIE", CAPTAIN_GINEA, new WorldPoint(1561, 3602, 0), "Building east of Shayzien combat ring", "113"),
		new AnagramClue("PEAK REFLEX", FLAX_KEEPER, new WorldPoint(2744, 3444, 0), "Flax field south of Seers Village", "676"),
		new AnagramClue("PEATY PERT", PARTY_PETE, new WorldPoint(3047, 3376, 0), "Falador Party Room"),
		new AnagramClue("PROFS LOSE WRONG PIE", PROFESSOR_ONGLEWIP, new WorldPoint(3113, 3162, 0), "Ground floor of Wizards Tower"),
		new AnagramClue("QUIT HORRIBLE TYRANT", BROTHER_TRANQUILITY, new WorldPoint(3681, 2963, 0), "Mos Le'Harmless or Harmony Island", "7"),
		new AnagramClue("QUE SIR", SQUIRE, new WorldPoint(2975, 3343, 0), "Falador Castle Courtyard", "654"),
		new AnagramClue("R AK MI", KARIM, new WorldPoint(3273, 3181, 0), "Al Kharid Kebab shop", "5"),
		new AnagramClue("RAT MAT WITHIN", MARTIN_THWAIT, new WorldPoint(2906, 3537, 0), "Rogues' Den", "2"),
		new AnagramClue("RED ART TANS", TRADER_STAN, new WorldPoint(3041, 3193, 0), "Port Sarim Charter ship"),
		new AnagramClue("RATAI", TARIA, new WorldPoint(2940, 3223, 0), "Rimmington bush patch", "7"),
		new AnagramClue("R SLICER", CLERRIS, new WorldPoint(1761, 3850, 0), "Arceuus mine, Zeah", "738"),
		new AnagramClue("SAND NUT", DUNSTAN, new WorldPoint(2919, 3574, 0), "Anvil in north east Burthorpe", "8"),
		new AnagramClue("SEQUIN DIRGE", QUEEN_SIGRID, new WorldPoint(2612, 3867, 0), "Throne room of Etceteria Castle."),
		new AnagramClue("SLAM DUSTER GRAIL", GUILDMASTER_LARS, new WorldPoint(1649, 3498, 0), "Woodcutting guild, Zeah"),
		new AnagramClue("SLIDE WOMAN", WISE_OLD_MAN, new WorldPoint(3088, 3253, 0), "Draynor Village", "28"),
		new AnagramClue("SNAH", HANS, new WorldPoint(3218, 3219, 0), "Lumbridge Castle courtyard"),
		new AnagramClue("SNAKES SO I SAIL", LISSE_ISAAKSON, new WorldPoint(2351, 3801, 0), "Neitiznot", "2"),
		new AnagramClue("TAMED ROCKS", DOCKMASTER, new WorldPoint(1822, 3739, 0), "Piscarilius House, NE of General store", "5"),
		new AnagramClue("TEN WIGS ON", WINGSTONE, new WorldPoint(3389, 2877, 0), "Between Nardah & Agility Pyramid"),
		new AnagramClue("THEM CAL CAME", CAM_THE_CAMEL, new WorldPoint(3300, 3231, 0), "Just outside of the Duel Arena"),
		new AnagramClue("THICKNO", HICKTON, new WorldPoint(2822, 3442, 0), "Catherby fletching shop", "2"),
		new AnagramClue("TWENTY CURE IRON", NEW_RECRUIT_TONY, new WorldPoint(1498, 3544, 0), "Shayzien House's Graveyard"),
		new AnagramClue("UNLEASH NIGHT MIST", SIGLI_THE_HUNTSMAN, new WorldPoint(2660, 3654, 0), "Rellekka", "302"),
		new AnagramClue("VESTE", STEVE, new WorldPoint(2432, 3423, 0), "Upstairs Wyvern Area or Stronghold Slayer Cave", "2"),
		new AnagramClue("VEIL VEDA", EVIL_DAVE, new WorldPoint(3079, 9892, 0), "Doris' basement, Edgeville", "666"),
		new AnagramClue("WOO AN EGG KIWI", AWOWOGEI, new WorldPoint(2802, 2764, 0), "Ape Atoll", "24"),
		new AnagramClue("YAWNS GY", YSGAWYN, new WorldPoint(2340, 3167, 0), "Lletya"),
		new AnagramClue("MAJORS LAVA BADS AIR", AMBASSADOR_ALVIJAR, new WorldPoint(2736, 5351, 1), "Dorgesh-Kaan, NE Middle Level", "2505")
	);

	private String text;
	private Integer npc;
	private WorldPoint location;
	private String area;
	private String answer;

	private AnagramClue(String text, int npc, WorldPoint location, String area)
	{
		this(text, npc, location, area, null);
	}

	private AnagramClue(String text, int npc, WorldPoint location, String area, String answer)
	{
		this.text = "This anagram reveals who to speak to next: " + text;
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
			.left(plugin.getClient().getNpcDefinition(getNpc()).getName())
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
				OverlayUtil.renderActorOverlayImage(graphics, npc, plugin.getClueScrollImage(), Color.ORANGE, IMAGE_Z_OFFSET);
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
