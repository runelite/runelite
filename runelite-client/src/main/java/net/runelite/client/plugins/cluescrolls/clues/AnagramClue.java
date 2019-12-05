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
import net.runelite.api.ObjectID;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_BORDER_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_FILL_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_HOVER_BORDER_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter(AccessLevel.PUBLIC)
public class AnagramClue extends ClueScroll implements TextClueScroll, NpcClueScroll, ObjectClueScroll
{
	private static final String ANAGRAM_TEXT = "This anagram reveals who to speak to next: ";
	private static final String ANAGRAM_TEXT_BEGINNER = "The anagram reveals who to speak to next: ";

	private static final Set<AnagramClue> CLUES = ImmutableSet.of(
		new AnagramClue("A BAKER", "Baraek", new WorldPoint(3217, 3434, 0), "Varrock square", "How many stalls are there in Varrock Square?", "5"),
		new AnagramClue("A BASIC ANTI POT", "Captain Tobias", new WorldPoint(3026, 3216, 0), "Port Sarim", "How many ships are there docked at Port Sarim currently?", "6"),
		new AnagramClue("A ELF KNOWS", "Snowflake", new WorldPoint(2872, 3934, 0), "Weiss"),
		new AnagramClue("A HEART", "Aretha", new WorldPoint(1814, 3851, 0), "Soul altar", "32 - 5x = 22, what is x?", "2"),
		new AnagramClue("A ZEN SHE", "Zenesha", new WorldPoint(2652, 3295, 0), "Platebody Southern Ardougne centre square"),
		new AnagramClue("ACE MATCH ELM", "Cam The Camel", new WorldPoint(3300, 3231, 0), "North of the glider in Al Kharid"),
		new AnagramClue("AHA JAR", "Jaraah", new WorldPoint(3359, 3276, 0), "Duel Arena hospital"),
		new AnagramClue("AN PAINT TONIC", "Captain Ninto", new WorldPoint(2865, 9877, 0), "Bar under White Wolf Mountain"),
		new AnagramClue("ARC O LINE", "Caroline", new WorldPoint(2715, 3302, 0), "North Witchaven next to the row boat", "How many fishermen are there on the fishing platform?", "11"),
		new AnagramClue("ARE COL", "Oracle", new WorldPoint(3013, 3501, 0), "Ice Mountain West of Edgeville", "If x is 15 and y is 3 what is 3x + y?", "48"),
		new AnagramClue("ARMCHAIR THE PELT", "Charlie the Tramp", new WorldPoint(3209, 3392, 0), "South entrance of Varrock", "How many coins would I have if I had 0 coins and attempted to buy 3 loaves of bread?", "0"),
		new AnagramClue("ARR! SO I AM A CRUST, AND?", "Ramara du Croissant", new WorldPoint(2339, 3677, 0), "Piscatoris Fishing Colony"),
		new AnagramClue("AT HERG", "Regath", new WorldPoint(1719, 3723, 0), "General Store, Arceuus, Zeah", "What is -5 to the power of 2?", "25"),
		new AnagramClue("A BAS", "Saba", new WorldPoint(2858, 3577, 0), "Death Plateau"),
		new AnagramClue("AREA CHEF TREK", "Father Aereck", new WorldPoint(3243, 3208, 0), "Lumbridge Church", "How many gravestones are in the church graveyard?", "19 or 20"),
		new AnagramClue("BAIL TRIMS", "Brimstail", new WorldPoint(2402, 3419, 0), "West of Stronghold Slayer Cave"),
		new AnagramClue("BAKER CLIMB", "Brambickle", new WorldPoint(2783, 3861, 0), "Trollweiss mountain"),
		new AnagramClue("BLUE GRIM GUIDED", "Lumbridge Guide", new WorldPoint(3232, 3232, 0), "Lumbridge"),
		new AnagramClue("BY LOOK", "Bolkoy", new WorldPoint(2529, 3162, 0), "Tree Gnome Village general store", "How many flowers are there in the clearing below this platform?", "13"),
		new AnagramClue("CALAMARI MADE MUD", "Madame Caldarium", new WorldPoint(2553, 2868, 0), "Corsair Cove", "What is 3(5-3)?", "6"),
		new AnagramClue("CAR IF ICES", "Sacrifice", new WorldPoint(2209, 3056, 0), "Zul-Andra"),
		new AnagramClue("CAREER IN MOON", "Oneiromancer", new WorldPoint(2150, 3866, 0), "Astral altar", "How many Suqah inhabit Lunar isle?", "25"),
		new AnagramClue("CLASH ION", "Nicholas", new WorldPoint(1841, 3803, 0), "North of Port Piscarilius fishing shop", "How many windows are in Tynan's shop?", "4"),
		new AnagramClue("C ON GAME HOC", "Gnome Coach", new WorldPoint(2395, 3486, 0), "Gnome Ball course", "How many gnomes on the Gnome ball field have red patches on their uniforms?", "6"),
		new AnagramClue("COOL NERD", "Old crone", new WorldPoint(3462, 3557, 0), "East of the Slayer Tower", "What is the combined combat level of each species that live in Slayer tower?", "619"),
		new AnagramClue("COPPER ORE CRYPTS", "Prospector Percy", new WorldPoint(3061, 3377, 0), "Motherlode Mine", "During a party, everyone shook hands with everyone else. There were 66 handshakes. How many people were at the party?", "12"),
		new AnagramClue("DED WAR", "Edward", new WorldPoint(3284, 3943, 0), "Inside Rogue's Castle"),
		new AnagramClue("DEKAGRAM", "Dark mage", new WorldPoint(3039, 4835, 0), "Centre of the Abyss", "How many rifts are found here in the abyss?", "13"),
		new AnagramClue("DO SAY MORE", "Doomsayer", new WorldPoint(3230, 3230, 0), "East of Lumbridge Castle", "What is 40 divided by 1/2 plus 15?", "95"),
		new AnagramClue("DIM THARN", "Mandrith", new WorldPoint(3182, 3946, 0), "Wilderness Resource Area"),
		new AnagramClue("DR HITMAN", "Mandrith", new WorldPoint(3182, 3946, 0), "Wilderness Resource Area", "How many scorpions live under the pit?", "28"),
		new AnagramClue("DR WARDEN FUNK", "Drunken Dwarf", new WorldPoint(2913, 10221, 0), "East Side of Keldagrim"),
		new AnagramClue("DRAGONS LAMENT", "Strange Old Man", new WorldPoint(3564, 3288, 0), "Barrows", "One pipe fills a barrel in 1 hour while another pipe can fill the same barrel in 2 hours. How many minutes will it take to fill the take if both pipes are used?", "40"),
		new AnagramClue("DT RUN B", "Brundt the Chieftain", new WorldPoint(2658, 3670, 0), "Rellekka, main hall", "How many people are waiting for the next bard to perform?", "4"),
		new AnagramClue("DUO PLUG", "Dugopul", new WorldPoint(2803, 2744, 0), "Graveyard on Ape Atoll"),
		new AnagramClue("EEK ZERO OP", "Zoo keeper", new WorldPoint(2613, 3269, 0), "Ardougne Zoo", "How many animals are in the Ardougne Zoo?", "40"),
		new AnagramClue("EL OW", "Lowe", new WorldPoint(3233, 3423, 0), "Varrock archery store"),
		new AnagramClue("ERR CURE IT", "Recruiter", new WorldPoint(2541, 3305, 0), "West Ardougne centre square", "How many houses have a cross on the door?", "20"),
		new AnagramClue("FORLUN", "Runolf", new WorldPoint(2512, 10256, 0), "Miscellania & Etceteria Dungeon"),
		new AnagramClue("GOBLIN KERN", "King Bolren", new WorldPoint(2541, 3170, 0), "Tree Gnome Village"),
		new AnagramClue("GOT A BOY", "Gabooty", new WorldPoint(2790, 3066, 0), "Centre of Tai Bwo Wannai", "How many buildings in the village?", "11"),
		new AnagramClue("GULAG RUN", "Uglug Nar", new WorldPoint(2442, 3051, 0), "West of Jiggig"),
		new AnagramClue("GOBLETS ODD TOES", "Otto Godblessed", new WorldPoint(2501, 3487, 0), "Otto's Grotto", "How many types of dragon are there beneath the whirlpool's cavern?", "2"),
		new AnagramClue("HALT US", "Luthas", new WorldPoint(2938, 3152, 0), "Banana plantation, Karamja"),
		new AnagramClue("HE DO POSE. IT IS CULTRRL, MK?", "Riki the sculptor's model", new WorldPoint(2904, 10206, 0), "East Keldagrim, south of kebab seller."),
		new AnagramClue("HEORIC", "Eohric", new WorldPoint(2900, 3565, 0), "Top floor of Burthorpe Castle", "King Arthur and Merlin sit down at the Round Table with 8 knights. How many degrees does each get?", "36"),
		new AnagramClue("HIS PHOR", "Horphis", new WorldPoint(1639, 3812, 0), "Arceuus Library, Zeah", "On a scale of 1-10, how helpful is Logosia?", "1"),
		new AnagramClue("I AM SIR", "Marisi", new WorldPoint(1737, 3557, 0), "Allotment patch, South of Hosidius chapel", "How many cities form the Kingdom of Great Kourend?", "5"),
		new AnagramClue("ICY FE", "Fycie", new WorldPoint(2630, 2997, 0), "East Feldip Hills"),
		new AnagramClue("I DOOM ICON INN", "Dominic Onion", new WorldPoint(2609, 3116, 0), "Nightmare Zone", "How many reward points does a herb box cost?", "9,500"),
		new AnagramClue("I EAT ITS CHART HINTS DO U", "Shiratti the Custodian", new WorldPoint(3427, 2927, 0), "North of fountain, Nardah"),
		new AnagramClue("I EVEN", "Nieve", new WorldPoint(2432, 3422, 0), "The slayer master in Gnome Stronghold", "How many farming patches are there in Gnome stronghold?", "2"),
		new AnagramClue("I FAFFY RUN", "Fairy Nuff", new WorldPoint(3201, 3169, 0), "North of the bank in Zanaris"),
		new AnagramClue("IM N ZEZIM", "Impling", new WorldPoint(2592, 4324, 0), "The Imp inside Puro-Puro"),
		new AnagramClue("KAY SIR", "Sir Kay", new WorldPoint(2760, 3496, 0), "The courtyard in Camelot Castle", "How many fountains are there within the grounds of Camelot castle.", "6"),
		new AnagramClue("LEAKEY", "Kaylee", new WorldPoint(2957, 3370, 0), "Rising Sun Inn in Falador", "How many chairs are there in the Rising Sun?", "18"),
		new AnagramClue("LAND DOOMD", "Odd Old Man", new WorldPoint(3359, 3506, 0), "Limestone mine northeast of Varrock"),
		new AnagramClue("LARK IN DOG", "King Roald", new WorldPoint(3220, 3476, 0), "Ground floor of Varrock castle", "How many bookcases are there in the Varrock palace library?", "24"),
		new AnagramClue("LOW LAG", "Gallow", new WorldPoint(1805, 3566, 0), "Vinery in the Great Kourend", "How many vine patches can you find in this vinery?", "12"),
		new AnagramClue("LADDER MEMO GUV", "Guard Vemmeldo", new WorldPoint(2447, 3418, 1), "Gnome Stronghold Bank", "How many magic trees can you find inside the Gnome Stronghold?", "3"),
		new AnagramClue("MAL IN TAU", "Luminata", new WorldPoint(3508, 3237, 0), "Near Burgh de Rott entrance"),
		new AnagramClue("ME AM THE CALC", "Cam the Camel", new WorldPoint(3300, 3231, 0), "Outside Duel Arena"),
		new AnagramClue("MACHETE CLAM", "Cam the Camel", new WorldPoint(3300, 3231, 0), "Outside Duel Arena", "How many items can carry water in RuneScape?", "6"),
		new AnagramClue("ME IF", "Femi", new WorldPoint(2461, 3382, 0), "Gates of Tree Gnome Stronghold"),
		new AnagramClue("MOLD LA RAN", "Old Man Ral", new WorldPoint(3602, 3209, 0), "Meiyerditch"),
		new AnagramClue("MOTHERBOARD", "Brother Omad", new WorldPoint(2606, 3211, 0), "Monastery south of Ardougne", "What is the next number? 12, 13, 15, 17, 111, 113, 117, 119, 123....?", "129"),
		new AnagramClue("MUS KIL READER", "Radimus Erkle", new WorldPoint(2726, 3368, 0), "Legends' Guild"),
		new AnagramClue("MY MANGLE LAL", "Lammy Langle", new WorldPoint(1688, 3540, 0), "Hosidius spirit tree patch"),
		new AnagramClue("NO OWNER", "Oronwen", new WorldPoint(1162, 3178, 0), "Lletya Seamstress shop in Lletya", "What is the minimum amount of quest points required to reach Lletya?", "20"),
		new AnagramClue("NOD MED", "Edmond", new WorldPoint(2566, 3332, 0), "Behind the most NW house in East Ardougne", "How many pigeon cages are there around the back of Jerico's house?", "3"),
		new AnagramClue("O BIRDZ A ZANY EN PC", "Cap'n Izzy No-Beard", new WorldPoint(2807, 3191, 0), "Brimhaven Agility Arena", "How many Banana Trees are there in the plantation?", "33"),
		new AnagramClue("OK CO", "Cook", new WorldPoint(3207, 3214, 0), "Ground floor of Lumbridge Castle", "How many cannons does Lumbridge Castle have?", "9"),
		new AnagramClue("OR ZINC FUMES WARD", "Wizard Frumscone", new WorldPoint(2594, 3086, 0), "Downstairs in the Wizards' Guild"),
		new AnagramClue("OUR OWN NEEDS", "Nurse Wooned", new WorldPoint(1575, 3590, 0), "Shayzien Infirmary", "How many injured soldiers are in this tent?", "19"),
		new AnagramClue("PACINNG A TAIE", "Captain Ginea", new WorldPoint(1561, 3602, 0), "Building east of Shayzien combat ring", "1 soldier can deal with 6 lizardmen. How many soldiers do we need for an army of 678 lizardmen?", "113"),
		new AnagramClue("PEAK REFLEX", "Flax keeper", new WorldPoint(2744, 3444, 0), "Flax field south of Seers Village", "If I have 1014 flax, and I spin a third of them into bowstring, how many flax do I have left?", "676"),
		new AnagramClue("PEATY PERT", "Party Pete", new WorldPoint(3047, 3376, 0), "Falador Party Room"),
		new AnagramClue("PROFS LOSE WRONG PIE", "Professor Onglewip", new WorldPoint(3113, 3162, 0), "Ground floor of Wizards Tower"),
		new AnagramClue("QUIT HORRIBLE TYRANT", "Brother Tranquility", new WorldPoint(3681, 2963, 0), "Mos Le'Harmless or Harmony Island", "If I have 49 bottles of rum to share between 7 pirates, how many would each pirate get?", "7"),
		new AnagramClue("QUE SIR", "Squire", new WorldPoint(2975, 3343, 0), "Falador Castle Courtyard", "White knights are superior to black knights. 2 white knights can handle 3 black knights. How many knights do we need for an army of 981 black knights?", "654"),
		new AnagramClue("R AK MI", "Karim", new WorldPoint(3273, 3181, 0), "Al Kharid Kebab shop", "I have 16 kebabs, I eat one myself and share the rest equally between 3 friends. How many do they have each?", "5"),
		new AnagramClue("RAT MAT WITHIN", "Martin Thwait", new WorldPoint(2906, 3537, 0), "Rogues' Den", "How many natural fires burn in Rogue's Den?", "2"),
		new AnagramClue("RED ART TANS", "Trader Stan", new WorldPoint(3041, 3193, 0), "Port Sarim Charter ship"),
		new AnagramClue("RATAI", "Taria", new WorldPoint(2940, 3223, 0), "Rimmington bush patch", "How many buildings are there in Rimmington?", "7"),
		new AnagramClue("R SLICER", "Clerris", new WorldPoint(1761, 3850, 0), "Arceuus mine, Zeah", "If I have 1,000 blood runes, and cast 131 ice barrage spells, how many blood runes do I have left?", "738"),
		new AnagramClue("RIP MAUL", "Primula", new WorldPoint(2454, 2853, 1), "Myth's Guild, first floor"),
		new AnagramClue("SAND NUT", "Dunstan", new WorldPoint(2919, 3574, 0), "Anvil in north east Burthorpe", "How much smithing experience does one receive for smelting a blurite bar?", "8"),
		new AnagramClue("SEQUIN DIRGE", "Queen Sigrid", new WorldPoint(2612, 3867, 0), "Throne room of Etceteria Castle."),
		new AnagramClue("SLAM DUSTER GRAIL", "Guildmaster Lars", new WorldPoint(1649, 3498, 0), "Woodcutting guild, Zeah"),
		new AnagramClue("SLIDE WOMAN", "Wise Old Man", new WorldPoint(3088, 3253, 0), "Draynor Village", "How many bookcases are in the Wise Old Man's house?", "28"),
		new AnagramClue("SNAH", "Hans", new WorldPoint(3218, 3219, 0), "Lumbridge Castle courtyard"),
		new AnagramClue("SNAKES SO I SAIL", "Lisse Isaakson", new WorldPoint(2351, 3801, 0), "Neitiznot", "How many arctic logs are required to make a large fremennik round shield?", "2"),
		new AnagramClue("TAMED ROCKS", "Dockmaster", new WorldPoint(1822, 3739, 0), "Port Piscarilius, NE of General store", "What is the cube root of 125?", "5"),
		new AnagramClue("TEN WIGS ON", "Wingstone", new WorldPoint(3389, 2877, 0), "Between Nardah & Agility Pyramid"),
		new AnagramClue("THEM CAL CAME", "Cam the Camel", new WorldPoint(3300, 3231, 0), "Just outside of the Duel Arena"),
		new AnagramClue("THICKNO", "Hickton", new WorldPoint(2822, 3442, 0), "Catherby fletching shop", "How many ranges are there in Catherby?", "2"),
		new AnagramClue("TWENTY CURE IRON", "New recruit Tony", new WorldPoint(1498, 3544, 0), "Shayzien Graveyard"),
		new AnagramClue("UNLEASH NIGHT MIST", "Sigli the Huntsman", new WorldPoint(2660, 3654, 0), "Rellekka", "What is the combined slayer requirement of every monster in the slayer cave?", "302"),
		new AnagramClue("VESTE", "Steve", new WorldPoint(2432, 3423, 0), "Upstairs Wyvern Area or Stronghold Slayer Cave", "How many farming patches are there in Gnome stronghold?", "2"),
		new AnagramClue("VEIL VEDA", "Evil Dave", new WorldPoint(3079, 9892, 0), "Doris' basement, Edgeville", "What is 333 multiplied by 2?", "666"),
		new AnagramClue("WOO AN EGG KIWI", "Awowogei", ObjectID.AWOWOGEI, new WorldPoint(2802, 2765, 0), "Ape Atoll", "If I have 303 bananas, and share them between 31 friends evenly, only handing out full bananas. How many will I have left over?", "24"),
		new AnagramClue("YAWNS GY", "Ysgawyn", new WorldPoint(2340, 3167, 0), "Lletya"),
		new AnagramClue("MAJORS LAVA BADS AIR", "Ambassador Alvijar", new WorldPoint(2736, 5351, 1), "Dorgesh-Kaan, NE Middle Level", "Double the miles before the initial Dorgeshuun veteran.", "2505"),
		new AnagramClue("AN EARL", "Ranael", new WorldPoint(3315, 3163, 0), "Al Kharid skirt shop"),
		new AnagramClue("CARPET AHOY", "Apothecary", new WorldPoint(3195, 3404, 0), "Southwest Varrock"),
		new AnagramClue("DISORDER", "Sedridor", new WorldPoint(3102, 9570, 0), "Wizards' Tower basement"),
		new AnagramClue("I CORD", "Doric", new WorldPoint(2951, 3450, 0), "North of Falador"),
		new AnagramClue("IN BAR", "Brian", new WorldPoint(3026, 3246, 0), "Port Sarim battleaxe shop"),
		new AnagramClue("RAIN COVE", "Veronica", new WorldPoint(3110, 3330, 0), "Outside Draynor Manor"),
		new AnagramClue("RUG DETER", "Gertrude", new WorldPoint(3151, 3412, 0), "West of Varrock, south of the Cooks' Guild"),
		new AnagramClue("SIR SHARE RED", "Hairdresser", new WorldPoint(2944, 3381, 0), "Western Falador"),
		new AnagramClue("TAUNT ROOF", "Fortunato", new WorldPoint(3080, 3250, 0), "Draynor Village Market"),
		new AnagramClue("HICK JET", "Jethick", new WorldPoint(2541, 3305, 0), "West Ardougne", "How many graves are there in the city graveyard?", "38"),
		new AnagramClue("RUE GO", "Goreu", new WorldPoint(2335, 3162, 0), "Lletya")
	);

	private final String text;
	private final String npc;
	private final WorldPoint location;
	private final String area;
	private final String question;
	private final String answer;
	private int objectId;

	private AnagramClue(String text, String npc, WorldPoint location, String area)
	{
		this(text, npc, location, area, "", null);
	}

	private AnagramClue(String text, String npc, WorldPoint location, String area, String question, String answer)
	{
		this.text = text;
		this.npc = npc;
		this.location = location;
		this.area = area;
		this.question = question;
		this.answer = answer;
		this.objectId = -1;
	}

	private AnagramClue(String text, String npc, int objectId, WorldPoint location, String area, String question, String answer)
	{
		this(text, npc, location, area, question, answer);
		this.objectId = objectId;
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

		// Mark NPC
		if (objectId == -1 && plugin.getNpcsToMark() != null)
		{
			for (NPC npc : plugin.getNpcsToMark())
			{
				OverlayUtil.renderActorOverlayImage(graphics, npc, plugin.getClueScrollImage(), Color.ORANGE, IMAGE_Z_OFFSET);
			}
		}

		// Mark game object
		if (objectId != -1)
		{
			net.runelite.api.Point mousePosition = plugin.getClient().getMouseCanvasPosition();

			for (TileObject gameObject : plugin.getObjectsToMark())
			{
				OverlayUtil.renderHoverableArea(graphics, gameObject.getClickbox(), mousePosition,
					CLICKBOX_FILL_COLOR, CLICKBOX_BORDER_COLOR, CLICKBOX_HOVER_BORDER_COLOR);

				OverlayUtil.renderImageLocation(plugin.getClient(), graphics, gameObject.getLocalLocation(), plugin.getClueScrollImage(), IMAGE_Z_OFFSET);
			}
		}
	}

	public static AnagramClue forText(String text)
	{
		for (AnagramClue clue : CLUES)
		{
			if (text.equalsIgnoreCase(ANAGRAM_TEXT + clue.text)
				|| text.equalsIgnoreCase(ANAGRAM_TEXT_BEGINNER + clue.text)
				|| text.equalsIgnoreCase(clue.question))
			{
				return clue;
			}
		}

		return null;
	}

	@Override
	public String[] getNpcs()
	{
		return new String[]{npc};
	}

	@Override
	public int[] getObjectIds()
	{
		return new int[]{objectId};
	}
}
