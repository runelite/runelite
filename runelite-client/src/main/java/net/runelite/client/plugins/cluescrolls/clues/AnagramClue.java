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
import lombok.Builder;
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

@Getter
@Builder
public class AnagramClue extends ClueScroll implements NpcClueScroll, ObjectClueScroll
{
	private static final String ANAGRAM_TEXT = "This anagram reveals who to speak to next: ";
	private static final String ANAGRAM_TEXT_BEGINNER = "The anagram reveals who to speak to next: ";

	static final List<AnagramClue> CLUES = ImmutableList.of(
		AnagramClue.builder()
			.text("A BAKER")
			.npc("Baraek")
			.location(new WorldPoint(3217, 3434, 0))
			.area("Varrock square")
			.question("How many stalls are there in Varrock Square?")
			.answer("5")
			.build(),
		AnagramClue.builder()
			.text("A BASIC ANTI POT")
			.npc("Captain Tobias")
			.location(new WorldPoint(3026, 3216, 0))
			.area("Port Sarim")
			.question("How many ships are there docked at Port Sarim currently?")
			.answer("6")
			.build(),
		AnagramClue.builder()
			.text("A ELF KNOWS")
			.npc("Snowflake")
			.location(new WorldPoint(2872, 3934, 0))
			.area("Weiss")
			.build(),
		AnagramClue.builder()
			.text("A HEART")
			.npc("Aretha")
			.location(new WorldPoint(1814, 3851, 0))
			.area("Soul altar")
			.question("32 - 5x = 22, what is x?")
			.answer("2")
			.build(),
		AnagramClue.builder()
			.text("AHA JAR")
			.npc("Jaraah")
			.location(new WorldPoint(3359, 3276, 0))
			.area("PvP Arena hospital")
			.build(),
		AnagramClue.builder()
			.text("ARC O LINE")
			.npc("Caroline")
			.location(new WorldPoint(2715, 3302, 0))
			.area("North Witchaven next to the row boat")
			.question("How many fishermen are there on the fishing platform?")
			.answer("11")
			.build(),
		AnagramClue.builder()
			.text("ARE COL")
			.npc("Oracle")
			.location(new WorldPoint(3013, 3501, 0))
			.area("Ice Mountain West of Edgeville")
			.question("If x is 15 and y is 3 what is 3x + y?")
			.answer("48")
			.build(),
		AnagramClue.builder()
			.text("ARMCHAIR THE PELT")
			.npc("Charlie the Tramp")
			.location(new WorldPoint(3209, 3392, 0))
			.area("South entrance of Varrock")
			.question("How many coins would I have if I have 0 coins and attempt to buy 10 loaves of bread for 3 coins each?")
			.answer("0")
			.build(),
		AnagramClue.builder()
			.text("AT HERG")
			.npc("Regath")
			.location(new WorldPoint(1719, 3723, 0))
			.area("General Store, Arceuus, Zeah")
			.question("What is -5 to the power of 2?")
			.answer("25")
			.build(),
		AnagramClue.builder()
			.text("A BAS")
			.npc("Saba")
			.location(new WorldPoint(2858, 3577, 0))
			.area("Death Plateau")
			.build(),
		AnagramClue.builder()
			.text("AREA CHEF TREK")
			.npc("Father Aereck")
			.location(new WorldPoint(3243, 3208, 0))
			.area("Lumbridge Church")
			.question("How many gravestones are in the church graveyard?")
			.answer("19 or 20")
			.build(),
		AnagramClue.builder()
			.text("BAIL TRIMS")
			.npc("Brimstail")
			.location(new WorldPoint(2402, 3419, 0))
			.area("West of Stronghold Slayer Cave")
			.build(),
		AnagramClue.builder()
			.text("BAKER CLIMB")
			.npc("Brambickle")
			.location(new WorldPoint(2783, 3861, 0))
			.area("Trollweiss mountain")
			.build(),
		AnagramClue.builder()
			.text("BLUE GRIM GUIDED")
			.npc("Lumbridge Guide")
			.location(new WorldPoint(3238, 3220, 0))
			.area("Lumbridge")
			.build(),
		AnagramClue.builder()
			.text("BY LOOK")
			.npc("Bolkoy")
			.location(new WorldPoint(2526, 3162, 0))
			.area("Tree Gnome Village general store")
			.question("How many flowers are there in the clearing below this platform?")
			.answer("13")
			.build(),
		AnagramClue.builder()
			.text("CALAMARI MADE MUD")
			.npc("Madame Caldarium")
			.location(new WorldPoint(2553, 2868, 0))
			.area("Corsair Cove")
			.question("What is 3(5-3)?")
			.answer("6")
			.build(),
		AnagramClue.builder()
			.text("CAR IF ICES")
			.npc("Sacrifice")
			.location(new WorldPoint(2209, 3056, 0))
			.area("Zul-Andra")
			.build(),
		AnagramClue.builder()
			.text("CAREER IN MOON")
			.npc("Oneiromancer")
			.location(new WorldPoint(2150, 3866, 0))
			.area("Astral altar")
			.question("How many Suqah inhabit Lunar isle?")
			.answer("25")
			.build(),
		AnagramClue.builder()
			.text("CLASH ION")
			.npc("Nicholas")
			.location(new WorldPoint(1841, 3803, 0))
			.area("North of Port Piscarilius fishing shop")
			.question("How many windows are in Tynan's shop?")
			.answer("4")
			.build(),
		AnagramClue.builder()
			.text("C ON GAME HOC")
			.npc("Gnome Coach")
			.location(new WorldPoint(2395, 3486, 0))
			.area("Gnome Ball course")
			.question("How many gnomes on the Gnome ball field have red patches on their uniforms?")
			.answer("6")
			.build(),
		AnagramClue.builder()
			.text("COOL NERD")
			.npc("Old crone")
			.location(new WorldPoint(3462, 3557, 0))
			.area("East of the Slayer Tower")
			.question("What is the combined combat level of each species that live in Slayer tower?")
			.answer("619")
			.build(),
		AnagramClue.builder()
			.text("COPPER ORE CRYPTS")
			.npc("Prospector Percy")
			.location(new WorldPoint(3061, 3377, 0))
			.area("Motherlode Mine")
			.question("During a party, everyone shook hands with everybody else. There were 66 handshakes. How many people were at the party?")
			.answer("12")
			.build(),
		AnagramClue.builder()
			.text("DARN DRAKE")
			.npc("Daer Krand")
			.location(new WorldPoint(3728, 3302, 0))
			.area("Sisterhood Sanctuary (Slepe Dungeon, northeast of Nightmare Arena)")
			.build(),
		AnagramClue.builder()
			.text("DED WAR")
			.npc("Edward")
			.location(new WorldPoint(3284, 3943, 0))
			.area("Inside Rogue's Castle")
			.build(),
		AnagramClue.builder()
			.text("DEKAGRAM")
			.npc("Dark Mage")
			.location(new WorldPoint(3039, 4834, 0))
			.area("Centre of the Abyss")
			.question("How many rifts are found here in the abyss?")
			.answer("13")
			.build(),
		AnagramClue.builder()
			.text("DO SAY MORE")
			.npc("Doomsayer")
			.location(new WorldPoint(3230, 3230, 0))
			.area("East of Lumbridge Castle")
			.question("What is 40 divided by 1/2 plus 15?")
			.answer("95")
			.build(),
		AnagramClue.builder()
			.text("DIM THARN")
			.npc("Mandrith")
			.location(new WorldPoint(3182, 3946, 0))
			.area("Wilderness Resource Area")
			.build(),
		AnagramClue.builder()
			.text("DR HITMAN")
			.npc("Mandrith")
			.location(new WorldPoint(3182, 3946, 0))
			.area("Wilderness Resource Area")
			.question("How many scorpions live under the pit?")
			.answer("28")
			.build(),
		AnagramClue.builder()
			.text("DR WARDEN FUNK")
			.npc("Drunken Dwarf")
			.location(new WorldPoint(2913, 10221, 0))
			.area("East Side of Keldagrim")
			.build(),
		AnagramClue.builder()
			.text("DRAGONS LAMENT")
			.npc("Strange Old Man")
			.location(new WorldPoint(3564, 3288, 0))
			.area("Barrows")
			.question("One pipe fills a barrel in 1 hour while another pipe can fill the same barrel in 2 hours. How many minutes will it take to fill the tank if both pipes are used?")
			.answer("40")
			.build(),
		AnagramClue.builder()
			.text("DT RUN B")
			.npc("Brundt the Chieftain")
			.location(new WorldPoint(2658, 3670, 0))
			.area("Rellekka, main hall")
			.question("How many people are waiting for the next bard to perform?")
			.answer("4")
			.build(),
		AnagramClue.builder()
			.text("DUO PLUG")
			.npc("Dugopul")
			.location(new WorldPoint(2803, 2744, 0))
			.area("Graveyard on Ape Atoll")
			.build(),
		AnagramClue.builder()
			.text("EEK ZERO OP")
			.npc("Zoo keeper")
			.location(new WorldPoint(2613, 3269, 0))
			.area("Ardougne Zoo")
			.question("How many animals in total are there in the zoo?")
			.answer("40")
			.build(),
		AnagramClue.builder()
			.text("EL OW")
			.npc("Lowe")
			.location(new WorldPoint(3233, 3423, 0))
			.area("Varrock archery store")
			.build(),
		AnagramClue.builder()
			.text("FORLUN")
			.npc("Runolf")
			.location(new WorldPoint(2512, 10256, 0))
			.area("Miscellania & Etceteria Dungeon")
			.build(),
		AnagramClue.builder()
			.text("GOBLIN KERN")
			.npc("King Bolren")
			.location(new WorldPoint(2541, 3170, 0))
			.area("Tree Gnome Village")
			.build(),
		AnagramClue.builder()
			.text("GOT A BOY")
			.npc("Gabooty")
			.location(new WorldPoint(2790, 3066, 0))
			.area("Centre of Tai Bwo Wannai")
			.question("How many buildings are in the village?")
			.answer("11")
			.build(),
		AnagramClue.builder()
			.text("GOBLETS ODD TOES")
			.npc("Otto Godblessed")
			.location(new WorldPoint(2501, 3487, 0))
			.area("Otto's Grotto")
			.question("How many types of dragon are there beneath the whirlpool's cavern?")
			.answer("2")
			.build(),
		AnagramClue.builder()
			.text("HALT US")
			.npc("Luthas")
			.location(new WorldPoint(2938, 3152, 0))
			.area("Banana plantation, Karamja")
			.build(),
		AnagramClue.builder()
			.text("HEORIC")
			.npc("Eohric")
			.location(new WorldPoint(2897, 3565, 0))
			.area("Top floor of Burthorpe Castle")
			.question("King Arthur and Merlin sit down at the Round Table with 8 knights. How many degrees does each get?")
			.answer("36")
			.build(),
		AnagramClue.builder()
			.text("HIS PHOR")
			.npc("Horphis")
			.location(new WorldPoint(1639, 3812, 0))
			.area("Arceuus Library, Zeah")
			.question("On a scale of 1-10, how helpful is Logosia?")
			.answer("1")
			.build(),
		AnagramClue.builder()
			.text("I AM SIR")
			.npc("Marisi")
			.location(new WorldPoint(1737, 3557, 0))
			.area("Allotment patch, South of Hosidius chapel")
			.question("How many cities form the Kingdom of Great Kourend?")
			.answer("5")
			.build(),
		AnagramClue.builder()
			.text("ICY FE")
			.npc("Fycie")
			.location(new WorldPoint(2630, 2997, 0))
			.area("East Feldip Hills")
			.build(),
		AnagramClue.builder()
			.text("I DOOM ICON INN")
			.npc("Dominic Onion")
			.location(new WorldPoint(2609, 3116, 0))
			.area("Nightmare Zone")
			.question("How many reward points does a herb box cost?")
			.answer("9,500")
			.build(),
		AnagramClue.builder()
			.text("I EVEN")
			.npc("Nieve")
			.location(new WorldPoint(2432, 3422, 0))
			.area("The slayer master in Gnome Stronghold")
			.question("How many farming patches are there in Gnome stronghold?")
			.answer("2")
			.build(),
		AnagramClue.builder()
			.text("IM N ZEZIM")
			.npc("Immenizz")
			.location(new WorldPoint(2592, 4324, 0))
			.area("The Imp inside Puro-Puro")
			.build(),
		AnagramClue.builder()
			.text("KAY SIR")
			.npc("Sir Kay")
			.location(new WorldPoint(2760, 3496, 0))
			.area("The courtyard in Camelot Castle")
			.question("How many fountains are there within the grounds of Camelot castle?")
			.answer("6")
			.build(),
		AnagramClue.builder()
			.text("LEAKEY")
			.npc("Kaylee")
			.location(new WorldPoint(2957, 3370, 0))
			.area("Rising Sun Inn in Falador")
			.question("How many chairs are there in the Rising Sun?")
			.answer("18")
			.build(),
		AnagramClue.builder()
			.text("LARK IN DOG")
			.npc("King Roald")
			.location(new WorldPoint(3220, 3476, 0))
			.area("Ground floor of Varrock castle")
			.question("How many bookcases are there in the palace library?")
			.answer("24")
			.build(),
		AnagramClue.builder()
			.text("LOW LAG")
			.npc("Gallow")
			.location(new WorldPoint(1805, 3566, 0))
			.area("Vinery southeast of Hosidius")
			.question("How many vine patches can you find in this vinery?")
			.answer("12")
			.build(),
		AnagramClue.builder()
			.text("LADDER MEMO GUV")
			.npc("Guard Vemmeldo")
			.location(new WorldPoint(2447, 3418, 1))
			.area("Gnome Stronghold Bank")
			.question("How many magic trees can you find inside the Gnome Stronghold?")
			.answer("3")
			.build(),
		AnagramClue.builder()
			.text("MAL IN TAU")
			.npc("Luminata")
			.location(new WorldPoint(3508, 3237, 0))
			.area("Near Burgh de Rott entrance")
			.build(),
		AnagramClue.builder()
			.text("MACHETE CLAM")
			.npc("Cam the Camel")
			.location(new WorldPoint(3300, 3231, 0))
			.area("Outside PvP Arena")
			.question("How many items can carry water in Gielinor?")
			.answer("6")
			.build(),
		AnagramClue.builder()
			.text("ME IF")
			.npc("Femi")
			.location(new WorldPoint(2461, 3382, 0))
			.area("Gates of Tree Gnome Stronghold")
			.build(),
		AnagramClue.builder()
			.text("MOLD LA RAN")
			.npc("Old Man Ral")
			.location(new WorldPoint(3602, 3209, 0))
			.area("Meiyerditch")
			.build(),
		AnagramClue.builder()
			.text("MOTHERBOARD")
			.npc("Brother Omad")
			.location(new WorldPoint(2606, 3211, 0))
			.area("Monastery south of Ardougne")
			.question("What is the next number? 12, 13, 15, 17, 111, 113, 117, 119, 123....?")
			.answer("129")
			.build(),
		AnagramClue.builder()
			.text("MUS KIL READER")
			.npc("Radimus Erkle")
			.location(new WorldPoint(2726, 3368, 0))
			.area("Legends' Guild")
			.build(),
		AnagramClue.builder()
			.text("MY MANGLE LAL")
			.npc("Lammy Langle")
			.location(new WorldPoint(1688, 3540, 0))
			.area("Hosidius spirit tree patch")
			.build(),
		AnagramClue.builder()
			.text("NO OWNER")
			.npc("Oronwen")
			.location(new WorldPoint(1162, 3178, 0))
			.area("Lletya Seamstress shop in Lletya")
			.question("What is the minimum amount of quest points required to reach Lletya?")
			.answer("20")
			.build(),
		AnagramClue.builder()
			.text("NOD MED")
			.npc("Edmond")
			.location(new WorldPoint(2566, 3332, 0))
			.area("Behind the most NW house in East Ardougne")
			.question("How many pigeon cages are there around the back of Jerico's house?")
			.answer("3")
			.build(),
		AnagramClue.builder()
			.text("O BIRDZ A ZANY EN PC")
			.npc("Cap'n Izzy No-Beard")
			.location(new WorldPoint(2807, 3191, 0))
			.area("Brimhaven Agility Arena")
			.question("How many Banana Trees are there in the plantation?")
			.answer("33")
			.build(),
		AnagramClue.builder()
			.text("OK CO")
			.npc("Cook")
			.location(new WorldPoint(3207, 3214, 0))
			.area("Ground floor of Lumbridge Castle")
			.question("How many cannons does Lumbridge Castle have?")
			.answer("9")
			.build(),
		AnagramClue.builder()
			.text("OUR OWN NEEDS")
			.npc("Nurse Wooned")
			.location(new WorldPoint(1511, 3619, 0))
			.area("Shayzien Infirmary")
			.question("How many wounded soldiers are there in the camp?")
			.answer("16")
			.build(),
		AnagramClue.builder()
			.text("PACINNG A TAIE")
			.npc("Captain Ginea")
			.location(new WorldPoint(1504, 3632, 0))
			.area("Tent east of Shayzien Encampment war tent")
			.question("1 soldier can deal with 6 lizardmen. How many soldiers do we need for an army of 678 lizardmen?")
			.answer("113")
			.build(),
		AnagramClue.builder()
			.text("PEAK REFLEX")
			.npc("Flax keeper")
			.location(new WorldPoint(2744, 3444, 0))
			.area("Flax field south of Seers Village")
			.question("If I have 1014 flax, and I spin a third of them into bowstring, how many flax do I have left?")
			.answer("676")
			.build(),
		AnagramClue.builder()
			.text("PEATY PERT")
			.npc("Party Pete")
			.location(new WorldPoint(3047, 3376, 0))
			.area("Falador Party Room")
			.build(),
		AnagramClue.builder()
			.text("QUIT HORRIBLE TYRANT")
			.npc("Brother Tranquility")
			.location(new WorldPoint(3681, 2963, 0))
			.area("Mos Le'Harmless or Harmony Island")
			.question("If I have 49 bottles of rum to share between 7 pirates, how many would each pirate get?")
			.answer("7")
			.build(),
		AnagramClue.builder()
			.text("QUE SIR")
			.npc("Squire")
			.location(new WorldPoint(2975, 3343, 0))
			.area("Falador Castle Courtyard")
			.question("White knights are superior to black knights. 2 white knights can handle 3 black knights. How many knights do we need for an army of 981 black knights?")
			.answer("654")
			.build(),
		AnagramClue.builder()
			.text("R AK MI")
			.npc("Karim")
			.location(new WorldPoint(3273, 3181, 0))
			.area("Al Kharid Kebab shop")
			.question("I have 16 kebabs, I eat one myself and then share the rest equally between 3 friends. How many do they have each?")
			.answer("5")
			.build(),
		AnagramClue.builder()
			.text("RAT MAT WITHIN")
			.npc("Martin Thwait")
			.location(new WorldPoint(2906, 3537, 0))
			.area("Rogues' Den")
			.question("How many natural fires burn in Rogue's Den?")
			.answer("2")
			.build(),
		AnagramClue.builder()
			.text("RATAI")
			.npc("Taria")
			.location(new WorldPoint(2940, 3223, 0))
			.area("Rimmington bush patch")
			.question("How many buildings are there in Rimmington?")
			.answer("7")
			.build(),
		AnagramClue.builder()
			.text("R SLICER")
			.npc("Clerris")
			.location(new WorldPoint(1761, 3850, 0))
			.area("Arceuus mine, Zeah")
			.question("If I have 1,000 blood runes, and cast 131 ice barrage spells, how many blood runes do I have left?")
			.answer("738")
			.build(),
		AnagramClue.builder()
			.text("RIP MAUL")
			.npc("Primula")
			.location(new WorldPoint(2454, 2853, 1))
			.area("Myth's Guild, first floor")
			.build(),
		AnagramClue.builder()
			.text("SAND NUT")
			.npc("Dunstan")
			.location(new WorldPoint(2919, 3574, 0))
			.area("Anvil in north east Burthorpe")
			.question("How much smithing experience does one receive for smelting a blurite bar?")
			.answer("8")
			.build(),
		AnagramClue.builder()
			.text("SLAM DUSTER GRAIL")
			.npc("Guildmaster Lars")
			.location(new WorldPoint(1649, 3498, 0))
			.area("Woodcutting guild, Zeah")
			.build(),
		AnagramClue.builder()
			.text("SLIDE WOMAN")
			.npc("Wise Old Man")
			.location(new WorldPoint(3088, 3253, 0))
			.area("Draynor Village")
			.question("How many bookcases are in the Wise Old Man's house?")
			.answer("28")
			.build(),
		AnagramClue.builder()
			.text("SNAKES SO I SAIL")
			.npc("Lisse Isaakson")
			.location(new WorldPoint(2351, 3801, 0))
			.area("Neitiznot")
			.question("How many arctic logs are required to make a large fremennik round shield?")
			.answer("2")
			.build(),
		AnagramClue.builder()
			.text("TAMED ROCKS")
			.npc("Dockmaster")
			.location(new WorldPoint(1822, 3739, 0))
			.area("Port Piscarilius, NE of General store")
			.question("What is the cube root of 125?")
			.answer("5")
			.build(),
		AnagramClue.builder()
			.text("TEN WIGS ON")
			.npc("Wingstone")
			.location(new WorldPoint(3389, 2877, 0))
			.area("Between Nardah & Agility Pyramid")
			.build(),
		AnagramClue.builder()
			.text("THICKNO")
			.npc("Hickton")
			.location(new WorldPoint(2822, 3442, 0))
			.area("Catherby fletching shop")
			.question("How many ranges are there in Catherby?")
			.answer("2")
			.build(),
		AnagramClue.builder()
			.text("TWENTY CURE IRON")
			.npc("New Recruit Tony")
			.location(new WorldPoint(1503, 3553, 0))
			.area("Shayzien Graveyard")
			.build(),
		AnagramClue.builder()
			.text("UNLEASH NIGHT MIST")
			.npc("Sigli the Huntsman")
			.location(new WorldPoint(2660, 3654, 0))
			.area("Rellekka")
			.question("What is the combined slayer requirement of every monster in the slayer cave?")
			.answer("302")
			.build(),
		AnagramClue.builder()
			.text("VESTE")
			.npc("Steve")
			.location(new WorldPoint(2432, 3423, 0))
			.area("Upstairs Wyvern Area or Stronghold Slayer Cave")
			.question("How many farming patches are there in Gnome stronghold?")
			.answer("2")
			.build(),
		AnagramClue.builder()
			.text("VEIL VEDA")
			.npc("Evil Dave")
			.location(new WorldPoint(3079, 9892, 0))
			.area("Doris' basement, Edgeville")
			.question("What is 333 multiplied by 2?")
			.answer("666")
			.build(),
		AnagramClue.builder()
			.text("WOO AN EGG KIWI")
			.npc("Awowogei")
			.objectId(ObjectID.AWOWOGEI)
			.location(new WorldPoint(2802, 2765, 0))
			.area("Ape Atoll")
			.question("If I have 303 bananas, and share them between 31 friends evenly, only handing out full bananas. How many will I have left over?")
			.answer("24")
			.build(),
		AnagramClue.builder()
			.text("MAJORS LAVA BADS AIR")
			.npc("Ambassador Alvijar")
			.location(new WorldPoint(2736, 5351, 1))
			.area("Dorgesh-Kaan, NE Middle Level")
			.question("Double the miles before the initial Dorgeshuun veteran.")
			.answer("2505")
			.build(),
		AnagramClue.builder()
			.text("AN EARL")
			.npc("Ranael")
			.location(new WorldPoint(3315, 3163, 0))
			.area("Al Kharid skirt shop")
			.build(),
		AnagramClue.builder()
			.text("CARPET AHOY")
			.npc("Apothecary")
			.location(new WorldPoint(3195, 3404, 0))
			.area("Southwest Varrock")
			.build(),
		AnagramClue.builder()
			.text("CHAR GAME DISORDER")
			.npc("Archmage Sedridor")
			.location(new WorldPoint(3102, 9570, 0))
			.area("Wizards' Tower basement")
			.build(),
		AnagramClue.builder()
			.text("I CORD")
			.npc("Doric")
			.location(new WorldPoint(2951, 3450, 0))
			.area("North of Falador")
			.build(),
		AnagramClue.builder()
			.text("IN BAR")
			.npc("Brian")
			.location(new WorldPoint(3026, 3246, 0))
			.area("Port Sarim battleaxe shop")
			.build(),
		AnagramClue.builder()
			.text("RAIN COVE")
			.npc("Veronica")
			.location(new WorldPoint(3110, 3330, 0))
			.area("Outside Draynor Manor")
			.build(),
		AnagramClue.builder()
			.text("RUG DETER")
			.npc("Gertrude")
			.location(new WorldPoint(3151, 3412, 0))
			.area("West of Varrock, south of the Cooks' Guild")
			.build(),
		AnagramClue.builder()
			.text("SIR SHARE RED")
			.npc("Hairdresser")
			.location(new WorldPoint(2944, 3381, 0))
			.area("Western Falador")
			.build(),
		AnagramClue.builder()
			.text("TAUNT ROOF")
			.npc("Fortunato")
			.location(new WorldPoint(3080, 3250, 0))
			.area("Draynor Village Market")
			.build(),
		AnagramClue.builder()
			.text("HICK JET")
			.npc("Jethick")
			.location(new WorldPoint(2541, 3305, 0))
			.area("West Ardougne")
			.question("How many graves are there in the city graveyard?")
			.answer("38")
			.build(),
		AnagramClue.builder()
			.text("RUE GO")
			.npc("Goreu")
			.location(new WorldPoint(2335, 3162, 0))
			.area("Lletya")
			.build(),
		AnagramClue.builder()
			.text("BRUCIE CATNAP")
			.npc("Captain Bruce")
			.location(new WorldPoint(1520, 3558, 0))
			.area("Graveyard of Heroes")
			.build(),
		AnagramClue.builder()
			.text("UESNKRL NRIEDDO")
			.npc("Drunken soldier")
			.location(new WorldPoint(1551, 3565, 0))
			.area("Shayzien pub")
			.question("If 13 Shayzien Soldiers kill 46 Lizardmen each in a day, how many Lizardmen have they killed in total in a single day?")
			.answer("598")
			.build()
	);

	private final String text;
	private final String npc;
	@Getter(AccessLevel.PRIVATE)
	private final WorldPoint location;
	private final String area;
	@Nullable
	private final String question;
	@Nullable
	private final String answer;
	@Builder.Default
	private final int objectId = -1;

	@Override
	public WorldPoint getLocation(ClueScrollPlugin plugin)
	{
		return location;
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

		renderOverlayNote(panelComponent, plugin);
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		if (!getLocation(plugin).isInScene(plugin.getClient()))
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
	public String[] getNpcs(ClueScrollPlugin plugin)
	{
		return new String[]{npc};
	}

	@Override
	public int[] getObjectIds()
	{
		return new int[]{objectId};
	}

	@Override
	public int[] getConfigKeys()
	{
		return new int[]{text.hashCode()};
	}
}
