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
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.NPC;
import net.runelite.api.ObjectComposition;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.ObjectID;
import net.runelite.api.gameval.VarbitID;
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
@Slf4j
@ToString
public class CrypticClue extends ClueScroll implements NpcClueScroll, ObjectClueScroll
{
	static final List<CrypticClue> CLUES = ImmutableList.of(
		CrypticClue.builder()
			.itemIds(Set.of(ItemID.TRAIL_ELITE_SKILL_EXP1, ItemID.TRAIL_ELITE_SKILL_EXP2, ItemID.TRAIL_ELITE_SKILL_EXP3, ItemID.TRAIL_ELITE_SKILL_EXP4, ItemID.TRAIL_ELITE_SKILL_EXP5, ItemID.TRAIL_ELITE_SKILL_EXP6, ItemID.TRAIL_ELITE_SKILL_EXP7, ItemID.TRAIL_ELITE_SKILL_EXP8, ItemID.TRAIL_ELITE_SKILL_EXP9, ItemID.TRAIL_ELITE_SKILL_EXP10, ItemID.TRAIL_ELITE_SKILL_EXP11, ItemID.TRAIL_ELITE_SKILL_EXP12, ItemID.TRAIL_ELITE_SKILL_EXP13, ItemID.TRAIL_ELITE_SKILL_EXP14, ItemID.TRAIL_ELITE_SKILL_EXP15))
			.text("Show this to Sherlock.")
			.location(new WorldPoint(2733, 3415, 0))
			.npc("Sherlock")
			.solution("Sherlock is located to the east of the Sorcerer's tower in Seers' Village.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE020)
			.text("Talk to the bartender of the Rusty Anchor in Port Sarim.")
			.location(new WorldPoint(3045, 3256, 0))
			.npc("Bartender")
			.npcRegion(12082)
			.solution("The Rusty Anchor is located in the north of Port Sarim.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE014)
			.text("The keeper of Melzars... Spare? Skeleton? Anar?")
			.location(new WorldPoint(3068, 3516, 0))
			.npc("Oziach")
			.solution("Speak to Oziach in Edgeville.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_ANAGRAM016)
			.text("Speak to Ulizius.")
			.location(new WorldPoint(3444, 3461, 0))
			.npc("Ulizius")
			.solution("Ulizius is the monk who guards the gate into Mort Myre Swamp. South of fairy ring CKS.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE022)
			.text("Search for a crate in a building in Hemenster.")
			.location(new WorldPoint(2636, 3453, 0))
			.objectId(ObjectID.CRATE2_OLD)
			.solution("House northwest of the Ranging Guild. West of Grandpa Jack.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP12)
			.text("A reck you say; let's pray there aren't any ghosts.")
			.location(new WorldPoint(3242, 3207, 0))
			.npc("Father Aereck")
			.solution("Speak to Father Aereck in Lumbridge.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP12)
			.text("Search the bucket in the Port Sarim jail.")
			.location(new WorldPoint(3013, 3179, 0))
			.objectId(ObjectID.PRISON_BUCKET)
			.solution("Talk to Shantay & identify yourself as an outlaw, refuse to pay the 5gp fine twice and you will be sent to the Port Sarim jail.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP10)
			.text("Search the crates in a bank in Varrock.")
			.location(new WorldPoint(3187, 9825, 0))
			.objectId(ObjectID.FAI_VARROCK_LARGE_CRATES)
			.solution("Search in the basement of the West Varrock bank.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Falo the bard wants to see you.")
			.location(new WorldPoint(2689, 3550, 0))
			.npc("Falo the Bard")
			.solution("Speak to Falo the Bard located between Seers' Village and Rellekka. Southwest of fairy ring CJR.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP2)
			.text("Search a bookcase in the Wizards tower.")
			.location(new WorldPoint(3113, 3159, 0))
			.objectId(ObjectID.FAI_WIZTOWER_BOOKCASE)
			.solution("The bookcase located on the ground floor of the Wizards' Tower. Fairy ring DIS.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP6)
			.text("Come have a cip with this great soot covered denizen.")
			.location(new WorldPoint(2527, 3891, 0))
			.npc("Miner Magnus")
			.solution("Talk to Miner Magnus on Miscellania, east of the fairy ring CIP.")
			.questionText("How many coal rocks are around here?")
			.answer("8")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE025)
			.text("Citric cellar.")
			.location(new WorldPoint(2490, 3488, 0))
			.npc("Heckel Funch")
			.solution("Speak to Heckel Funch on the first floor in the Grand Tree.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP13)
			.text("I burn between heroes and legends.")
			.location(new WorldPoint(2799, 3438, 0))
			.npc("Candle maker")
			.solution("Speak to the Candle maker in Catherby.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP6)
			.text("Speak to Sarah at Falador farm.")
			.location(new WorldPoint(3038, 3292, 0))
			.npc("Sarah")
			.npcRegion(12083)
			.solution("Talk to Sarah at Falador farm, north of Port Sarim.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE025)
			.text("Search for a crate on the ground floor of a house in Seers' Village.")
			.location(new WorldPoint(2699, 3470, 0))
			.objectId(ObjectID.KR_CRATE)
			.solution("Search inside Phantuwti Fanstuwi Farsight's house, located south of the pub in Seers' Village.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE012)
			.text("Snah? I feel all confused, like one of those cakes...")
			.location(new WorldPoint(3211, 3219, 0))
			.npc("Hans")
			.solution("Talk to Hans roaming around Lumbridge Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE026)
			.text("Speak to Sir Kay in Camelot Castle.")
			.location(new WorldPoint(2759, 3497, 0))
			.npc("Sir Kay")
			.solution("Sir Kay can be found in the courtyard at Camelot castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP1)
			.text("Gold I see, yet gold I require. Give me 875 if death you desire.")
			.location(new WorldPoint(2745, 3151, 0))
			.npc("Saniboch")
			.solution("Speak to Saniboch at the Brimhaven Dungeon entrance.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE010)
			.text("Find a crate close to the monks that like to paaarty!")
			.location(new WorldPoint(2614, 3204, 0))
			.objectId(ObjectID.CRATE2)
			.solution("The crate is in the east side of the Ardougne monastery, near Brother Omad.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE020)
			.text("Identify the back of this over-acting brother. (He's a long way from home.)")
			.location(new WorldPoint(3376, 3284, 0))
			.npc("Hamid")
			.solution("Talk to Hamid, the monk at the altar in Emir's Arena.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE003)
			.text("In a town where thieves steal from stalls, search for some drawers in the upstairs of a house near the bank.")
			.location(new WorldPoint(2611, 3324, 1))
			.npc("Guard")
			.npcRegion(10291)
			.npcRegion(10292)
			.npcRegion(10547)
			.npcRegion(10548)
			.objectId(ObjectID.DRAWERS1)
			.solution("Kill any Guard located around East Ardougne for a medium key. Then search the drawers in the upstairs hallway of Jerico's house, which is the house with pigeon cages located south of the northern East Ardougne bank.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP16)
			.text("His bark is worse than his bite.")
			.location(new WorldPoint(3499, 3503, 0))
			.npc("Barker")
			.solution("Speak to Barker at Canifis's Barkers' Haberdashery.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE007)
			.text("The beasts to my east snap claws and tails, The rest to my west can slide and eat fish. The force to my north will jump and they'll wail, Come dig by my fire and make a wish.")
			.location(new WorldPoint(2598, 3267, 0))
			.solution("Dig by the torch in the Ardougne Zoo, between the penguins and the scorpions.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE009)
			.text("A town with a different sort of night-life is your destination. Search for some crates in one of the houses.")
			.location(new WorldPoint(3498, 3507, 0))
			.objectId(ObjectID.CANAFIS_CRATE)
			.solution("Search the crate inside of the clothes shop in Canifis.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE020)
			.text("Search the crate near the southern general store in Port Khazard.")
			.location(new WorldPoint(2660, 3149, 0))
			.objectId(ObjectID.CRATE)
			.solution("Search by the southern Khazard General Store in Port Khazard.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE010)
			.text("Speak to the bartender of the Blue Moon Inn in Varrock.")
			.location(new WorldPoint(3226, 3399, 0))
			.npc("Bartender")
			.npcRegion(12853)
			.solution("Talk to the bartender in Blue Moon Inn in Varrock.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE021)
			.text("This aviator is at the peak of his profession.")
			.location(new WorldPoint(2847, 3499, 0))
			.npc("Captain Bleemadge")
			.solution("Captain Bleemadge, the gnome glider pilot, is found at the top of White Wolf Mountain.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE031)
			.text("Search the crates in the shed just north of East Ardougne.")
			.location(new WorldPoint(2617, 3347, 0))
			.objectId(ObjectID.CRATE3)
			.solution("The crates in the shed north of the northern Ardougne bank.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP18)
			.text("I wouldn't wear this jean on my legs.")
			.location(new WorldPoint(1734, 3576, 0))
			.npc("Father Jean")
			.solution("Talk to father Jean in the Hosidius church.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP5)
			.text("Search the crate in the Toad and Chicken pub.")
			.location(new WorldPoint(2913, 3536, 0))
			.objectId(ObjectID.CRATE2)
			.solution("The Toad and Chicken pub is located in Burthorpe.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE011)
			.text("Search chests found in the upstairs of shops in Port Sarim.")
			.location(new WorldPoint(3016, 3205, 1))
			.objectId(ObjectID.CHESTCLOSED)
			.solution("Search the chest on the east wall found upstairs of Wydin's Food Store in Port Sarim.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP7)
			.text("Right on the blessed border, cursed by the evil ones. On the spot inaccessible by both; I will be waiting. The bugs' imminent possession holds the answer.")
			.location(new WorldPoint(3410, 3324, 0))
			.solution("Dig right under the fairy ring BIP.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE011)
			.text("The dead, red dragon watches over this chest. He must really dig the view.")
			.location(new WorldPoint(3353, 3332, 0))
			.npc("Barbarian")
			.objectId(ObjectID.CHESTCLOSED)
			.solution("Search the chest underneath the Red Dragon's head in the Exam Centre. Kill a Barbarian in Barbarian Village or Barbarian Outpost to receive the key.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE006)
			.text("My home is grey, and made of stone; A castle with a search for a meal. Hidden in some drawers I am, across from a wooden wheel.")
			.location(new WorldPoint(3213, 3216, 1))
			.objectId(ObjectID.DRAWERS4)
			.solution("Open the drawers inside the room with the spinning wheel on the first floor of Lumbridge Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE002)
			.text("Come to the evil ledge, Yew know yew want to. Try not to get stung.")
			.location(new WorldPoint(3089, 3468, 0))
			.solution("Dig in Edgeville, just east of the Southern Yew tree.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE005)
			.text("Look in the ground floor crates of houses in Falador.")
			.location(new WorldPoint(3029, 3355, 0))
			.objectId(ObjectID.FAI_FALADOR_SMALL_CRATES)
			.solution("The house east of the eastern bank in Falador.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP8)
			.text("You were 3 and I was the 6th. Come speak to me.")
			.location(new WorldPoint(3146, 9913, 0))
			.npc("Vannaka")
			.solution("Speak to Vannaka in Edgeville Dungeon.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE018)
			.text("Search the crates in Draynor Manor.")
			.location(new WorldPoint(3106, 3369, 2))
			.objectId(ObjectID.DRAYNOR_CRATE)
			.solution("Top floor of the Draynor Manor.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE002)
			.text("Search the crates near a cart in Varrock.")
			.location(new WorldPoint(3226, 3452, 0))
			.objectId(ObjectID.FAI_VARROCK_LARGE_CRATES)
			.solution("South east of Varrock Palace, south of the tree farming patch.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP17)
			.text("A Guthixian ring lies between two peaks. Search the stones and you'll find what you seek.")
			.location(new WorldPoint(2922, 3484, 0))
			.objectId(ObjectID.BOULDER4_SEARCH)
			.solution("Search the stones several steps west of the Guthixian stone circle in Taverley.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE009)
			.text("Search the boxes in the house near the south entrance to Varrock.")
			.location(new WorldPoint(3203, 3384, 0))
			.objectId(ObjectID.FAI_VARROCK_BOXES)
			.solution("The first house on the left when entering Varrock from the southern entrance.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE037)
			.text("His head might be hollow, but the crates nearby are filled with surprises.")
			.location(new WorldPoint(3478, 3091, 0))
			.objectId(ObjectID.CRATE2)
			.solution("Search the crates near the Clay golem in the ruins of Uzer.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE012)
			.text("One of the sailors in Port Sarim is your next destination.")
			.location(new WorldPoint(3026, 3216, 0))
			.npc("Captain Tobias")
			.solution("Speak to Captain Tobias on the docks of Port Sarim.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP5)
			.text("THEY'RE EVERYWHERE!!!! But they were here first. Dig for treasure where the ground is rich with ore.")
			.location(new WorldPoint(3081, 3421, 0))
			.solution("Dig at Barbarian Village, next to the Stronghold of Security.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP7)
			.text("Talk to the mother of a basement dwelling son.")
			.location(new WorldPoint(3079, 3493, 0))
			.npc("Doris")
			.solution("Evil Dave's mother, Doris, is located in the house west of Edgeville bank.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE021)
			.text("Speak to Ned in Draynor Village.")
			.location(new WorldPoint(3098, 3258, 0))
			.npc("Ned")
			.solution("Ned is found north of the Draynor bank.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE005)
			.text("Speak to Hans to solve the clue.")
			.location(new WorldPoint(3211, 3219, 0))
			.npc("Hans")
			.solution("Hans can be found at Lumbridge Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE031)
			.text("Search the crates in Canifis.")
			.location(new WorldPoint(3509, 3497, 0))
			.objectId(ObjectID.CANAFIS_CRATE)
			.solution("Search inside Rufus' Meat Emporium in Canifis.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP12)
			.text("Search the crates in the Dwarven mine.")
			.location(new WorldPoint(3035, 9849, 0))
			.objectId(ObjectID.CRATE2_OLD)
			.solution("Search the crate in the room east of the Ice Mountain ladder entrance in the Drogo's Mining Emporium in the Dwarven Mine.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE004)
			.text("A crate found in the tower of a church is your next location.")
			.location(new WorldPoint(2612, 3304, 1))
			.objectId(ObjectID.CRATE2_OLD)
			.solution("Climb the ladder and search the crates on the first floor in the Church in Ardougne.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE030)
			.text("Covered in shadows, the centre of the circle is where you will find the answer.")
			.location(new WorldPoint(3488, 3289, 0))
			.solution("Dig in the centre of Mort'ton, where the roads intersect.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE009)
			.text("I lie lonely and forgotten in mid wilderness, where the dead rise from their beds. Feel free to quarrel and wind me up, and dig while you shoot their heads.")
			.location(new WorldPoint(3174, 3663, 0))
			.solution("Directly under the crossbow respawn in the Graveyard of Shadows in level 18 Wilderness.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP10)
			.text("In the city where merchants are said to have lived, talk to a man with a splendid cape, but a hat dropped by goblins.")
			.location(new WorldPoint(3143, 3445, 0))
			.npc("Head chef")
			.solution("Talk to the Head chef in Cooks' Guild west of Varrock. You will need a chef's hat, Varrock armour 3 or 4, or the Cooking cape to enter.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP9)
			.text("The mother of the reptilian sacrifice.")
			.location(new WorldPoint(2204, 3050, 0))
			.npc("Zul-Cheray")
			.solution("Talk to Zul-Cheray in a house near the sacrificial boat at Zul-Andra.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP2)
			.text("I watch the sea. I watch you fish. I watch your tree.")
			.location(new WorldPoint(2860, 3431, 0))
			.npc("Ellena")
			.solution("Speak to Ellena at Catherby fruit tree patch.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP5)
			.text("Dig between some ominous stones in Falador.")
			.location(new WorldPoint(3040, 3399, 0))
			.solution("Three standing stones inside a walled area. East of the northern Falador gate.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP7)
			.text("Speak to Rusty north of Falador.")
			.location(new WorldPoint(2979, 3435, 0))
			.npc("Rusty")
			.solution("Rusty can be found northeast of Falador on the way to the Mind altar.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP3)
			.text("Search a wardrobe in Draynor.")
			.location(new WorldPoint(3087, 3261, 0))
			.objectId(ObjectID.DRAYNOR_WARDROBE)
			.solution("Go to Aggie's house in Draynor Village and search the wardrobe in northern wall.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP14)
			.text("I have many arms but legs, I have just one. I have little family but my seed you can grow on, I am not dead, yet I am but a spirit, and my power, on your quests, you will earn the right to free it.")
			.location(new WorldPoint(2544, 3170, 0))
			.objectId(ObjectID.ENT)
			.solution("Spirit Tree in Tree Gnome Village.")
			.questionText("What is the next number in the sequence? 1, 11, 21, 1211, 111221, 312211")
			.answer("13112221")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP5)
			.text("I am the one who watches the giants. The giants in turn watch me. I watch with two while they watch with one. Come seek where I may be.")
			.location(new WorldPoint(2840, 3538, 0))
			.npc("Kamfreena")
			.solution("Speak to Kamfreena on the top floor of the Warriors' Guild.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE005)
			.text("In a town where wizards are known to gather, search upstairs in a large house to the north.")
			.location(new WorldPoint(2593, 3108, 1))
			.npc("Man")
			.npcRegion(10288)
			.objectId(ObjectID.CHESTCLOSED)
			.solution("Search the chest upstairs in the house north of Yanille Wizards' Guild. Kill a man for the key.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE014)
			.text("Probably filled with wizards socks.")
			.location(new WorldPoint(3116, 9562, 0))
			.npc("Wizard")
			.npcRegion(12337)
			.npcRegion(12437)
			.objectId(ObjectID.DRAWERS2)
			.solution("Search the drawers in the basement of the Wizards' Tower south of Draynor Village. Kill one of the Wizards for the key. Fairy ring DIS.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP6)
			.text("Even the seers say this clue goes right over their heads.")
			.location(new WorldPoint(2707, 3488, 2))
			.objectId(ObjectID.ROOFTOPS_SEERS_CRATE)
			.solution("Search the crate on the Seers Agility Course in Seers Village")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP20)
			.text("Speak to a Wyse man.")
			.location(new WorldPoint(3026, 3378, 0))
			.npc("Wyson the gardener")
			.solution("Talk to Wyson the gardener at Falador Park.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE001)
			.text("You'll need to look for a town with a central fountain. Look for a locked chest in the town's chapel.")
			.location(new WorldPoint(3256, 3487, 0))
			.npc("Monk")
			.npcRegion(10290)
			.objectId(ObjectID.FAI_VARROCK_CHEST_CLOSED)
			.solution("Search the chest by the stairs in the Varrock church. Kill a Monk in Ardougne Monastery to obtain the key.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP2)
			.text("Talk to Ambassador Spanfipple in the White Knights Castle.")
			.location(new WorldPoint(2979, 3340, 0))
			.npc("Ambassador Spanfipple")
			.solution("Ambassador Spanfipple can be found roaming on the first floor of the White Knights Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE028)
			.text("Mine was the strangest birth under the sun. I left the crimson sack, yet life had not begun. Entered the world, and yet was seen by none.")
			.location(new WorldPoint(2832, 9586, 0))
			.solution("Inside Karamja Volcano, dig directly underneath the Red spiders' eggs respawn.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE030)
			.text("Search for a crate in Varrock Castle.")
			.location(new WorldPoint(3224, 3492, 0))
			.objectId(ObjectID.FAI_VARROCK_RED_CRATE)
			.solution("Search the crate in the corner of the kitchen in Varrock Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE029)
			.text("And so on, and so on, and so on. Walking from the land of many unimportant things leads to a choice of paths.")
			.location(new WorldPoint(2591, 3879, 0))
			.solution("Dig on Etceteria next to the Evergreen tree in front of the castle walls.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_ANAGRAM009)
			.text("Speak to Donovan, the Family Handyman.")
			.location(new WorldPoint(2737, 3580, 0))
			.npc("Donovan the Family Handyman")
			.solution("Donovan the Family Handyman is found on the top floor of Sinclair Mansion, north of Seers' Village. Fairy ring CJR.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE014)
			.text("Search the crates in the Barbarian Village helmet shop.")
			.location(new WorldPoint(3073, 3430, 0))
			.objectId(ObjectID.FAI_BARBARIAN_SMALL_CRATES)
			.solution("Peksa's Helmet Shop in Barbarian Village.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE016)
			.text("Search the boxes of Falador's general store.")
			.location(new WorldPoint(2955, 3390, 0))
			.objectId(ObjectID.FAI_FALADOR_SMALL_CRATES)
			.solution("Falador general store.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE006)
			.text("In a village made of bamboo, look for some crates under one of the houses.")
			.location(new WorldPoint(2800, 3074, 0))
			.objectId(ObjectID.CRATE_OLD)
			.solution("Search the crate by the house at the northern point of the broken jungle fence in Tai Bwo Wannai.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE015)
			.text("This crate is mine, all mine, even if it is in the middle of the desert.")
			.location(new WorldPoint(3289, 3022, 0))
			.objectId(ObjectID.TOURTRAP_QIP_CRATE_SINGLE)
			.solution("Center of desert Mining Camp. Search the crates. Requires the metal key from Tourist Trap to enter.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP7)
			.text("Dig where 4 siblings and I all live with our evil overlord.")
			.location(new WorldPoint(3195, 3357, 0))
			.solution("Dig in the chicken pen inside the Champions' Guild")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE002)
			.text("In a town where the guards are armed with maces, search the upstairs rooms of the Public House.")
			.location(new WorldPoint(2574, 3326, 1))
			.npc("Guard dog")
			.npcRegion(10547)
			.npcRegion(10548)
			.objectId(ObjectID.DRAWERS1)
			.solution("Search the drawers upstairs in the pub north of Ardougne Castle. Kill a Guard dog at Handelmort Mansion to obtain the key.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE008)
			.text("Four blades I have, yet draw no blood; Still I turn my prey to powder. If you are brave, come search my roof; It is there my blades are louder.")
			.location(new WorldPoint(3166, 3309, 2))
			.objectId(ObjectID.QIP_COOK_CRATE_STACKED)
			.solution("Lumbridge windmill, search the crates on the top floor.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE010)
			.text("Search through some drawers in the upstairs of a house in Rimmington.")
			.location(new WorldPoint(2970, 3214, 1))
			.objectId(ObjectID.DRAWERS3)
			.solution("On the first floor of the house north of Hetty the Witch's house in Rimmington.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE033)
			.text("Probably filled with books on magic.")
			.location(new WorldPoint(3096, 9572, 0))
			.objectId(ObjectID.BOOKCASE)
			.solution("Search the bookcase in the basement of Wizards' Tower. Fairy ring DIS.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE038)
			.text("If you look closely enough, it seems that the archers have lost more than their needles.")
			.location(new WorldPoint(2672, 3416, 0))
			.objectId(ObjectID.HAYSTACK3)
			.solution("Search the haystack by the south corner of the Ranging Guild.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE002)
			.text("Search the crate in the left-hand tower of Lumbridge Castle.")
			.location(new WorldPoint(3228, 3212, 1))
			.objectId(ObjectID.CRATE2_OLD)
			.solution("Located on the first floor of the southern tower at the Lumbridge Castle entrance.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE026)
			.text("'Small shoe.' Often found with rod on mushroom.")
			.location(new WorldPoint(2476, 3428, 0))
			.npc("Gnome trainer")
			.solution("Talk to any Gnome trainer in the agility area of the Tree Gnome Stronghold.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP14)
			.text("I live in a deserted crack collecting soles.")
			.location(new WorldPoint(3371, 9320, 0))
			.npc("Genie")
			.npcRegion(13457)
			.solution("Enter the crack west of Nardah Rug merchant, and talk to the Genie. You'll need a light source and a rope.")
			.requiresLight(true)
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE010)
			.text("46 is my number. My body is the colour of burnt orange and crawls among those with eight. Three mouths I have, yet I cannot eat. My blinking blue eye hides my grave.")
			.location(new WorldPoint(3170, 3885, 0))
			.solution("Sapphire respawn in the Spider's Nest, lvl 46 Wilderness. Dig under the sapphire spawn.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP2)
			.text("Green is the colour of my death as the winter-guise, I swoop towards the ground.")
			.location(new WorldPoint(2780, 3783, 0))
			.solution("Slide down to where Trollweiss grows on Trollweiss Mountain. Bring a sled.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP4)
			.text("Talk to a party-goer in Falador.")
			.location(new WorldPoint(3046, 3382, 0))
			.npc("Lucy")
			.solution("Lucy is the bartender on the first floor of the Falador party room.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP11)
			.text("He knows just how easy it is to lose track of time.")
			.location(new WorldPoint(2570, 3250, 0))
			.npc("Brother Kojo")
			.solution("Speak to Brother Kojo in the Clock Tower.")
			.questionText("On a clock, how many times a day do the minute hand and the hour hand overlap?")
			.answer("22")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE023)
			.text("A great view - watch the rapidly drying hides get splashed. Check the box you are sitting on.")
			.location(new WorldPoint(2523, 3493, 1))
			.objectId(ObjectID.BOXES)
			.solution("Almera's House north of Baxtorian Falls, search boxes on the first floor.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP8)
			.text("Search the Coffin in Edgeville.")
			.location(new WorldPoint(3091, 3477, 0))
			.objectId(ObjectID.COFFIN)
			.solution("Search the coffin located by the Edgeville Wilderness teleport lever.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE027)
			.text("When no weapons are at hand, then is the time to reflect. In Saradomin's name, redemption draws closer...")
			.location(new WorldPoint(2818, 3351, 0))
			.objectId(ObjectID.DRAWERS2)
			.solution("On Entrana, search the southern drawer in the house with the cooking range.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE007)
			.text("Search the crates in a house in Yanille that has a piano.")
			.location(new WorldPoint(2598, 3105, 0))
			.objectId(ObjectID.CRATE2_OLD)
			.solution("The house is located northwest of the bank in Yanille.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE028)
			.text("Speak to the staff of Sinclair mansion.")
			.location(new WorldPoint(2736, 3578, 0))
			.npc("Louisa")
			.solution("Speak to Louisa, on the ground floor, found at the Sinclair Mansion. Fairy ring CJR.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE003)
			.text("I am a token of the greatest love. I have no beginning or end. My eye is red, I can fit like a glove. Go to the place where it's money they lend, And dig by the gate to be my friend.")
			.location(new WorldPoint(3191, 9825, 0))
			.solution("Dig by the gate in the basement of the West Varrock bank.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_ANAGRAM019)
			.text("Speak to Kangai Mau.")
			.location(new WorldPoint(2791, 3183, 0))
			.npc("Kangai Mau")
			.solution("Kangai Mau is found in the Shrimp and Parrot in Brimhaven.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_ANAGRAM005)
			.text("Speak to Hajedy.")
			.location(new WorldPoint(2779, 3211, 0))
			.npc("Hajedy")
			.solution("Hajedy is found by the cart, located just south of the Brimhaven docks.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE024)
			.text("Must be full of railings.")
			.location(new WorldPoint(2576, 3464, 0))
			.objectId(ObjectID.DWARF_KELDAGRIM_WOODEN_BOXES)
			.solution("Search the boxes around the hut where the broken Dwarf Cannon is, close to the start of the Dwarf Cannon quest.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP14)
			.text("I wonder how many bronze swords he has handed out.")
			.location(new WorldPoint(3146, 9913, 0))
			.npc("Vannaka")
			.solution("Talk to Vannaka. He can be found in Edgeville Dungeon.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE022)
			.text("Read 'How to breed scorpions.' By O.W.Thathurt.")
			.location(new WorldPoint(2703, 3409, 1))
			.objectId(ObjectID.BOOKCASE)
			.solution("Search the northern bookcase on the first floor of the Sorcerer's Tower.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE019)
			.text("Search the crates in the Port Sarim Fishing shop.")
			.location(new WorldPoint(3012, 3222, 0))
			.objectId(ObjectID.SARIM_CRATE2)
			.solution("Search the crates, by the door, in Gerrant's Fishy Business in Port Sarim.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP10)
			.text("Speak to The Lady of the Lake.")
			.location(new WorldPoint(2924, 3405, 0))
			.npc("The Lady of the Lake")
			.solution("Talk to The Lady of the Lake in Taverley.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP8)
			.text("Rotting next to a ditch. Dig next to the fish.")
			.location(new WorldPoint(3547, 3183, 0))
			.solution("Dig next to a fishing spot on the south-east side of Burgh de Rott.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP4)
			.text("The King's magic shouldn't be wasted by me.")
			.location(new WorldPoint(1934, 4427, 0))
			.npc("Guardian mummy")
			.solution("Talk to the Guardian mummy inside the Pyramid Plunder minigame in Sophanem.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP11)
			.text("Dig where the forces of Zamorak and Saradomin collide.")
			.location(new WorldPoint(3049, 4839, 0))
			.solution("Dig next to the law rift in the Abyss.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE003)
			.text("Search the boxes in the goblin house near Lumbridge.")
			.location(new WorldPoint(3245, 3245, 0))
			.objectId(ObjectID.BOXES)
			.solution("Goblin house on the eastern side of the river outside of Lumbridge.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP9)
			.text("W marks the spot.")
			.location(new WorldPoint(2867, 3546, 0))
			.solution("Dig in the middle of the Warriors' Guild entrance hall.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP3)
			.text("Surviving.")
			.location(new WorldPoint(2983, 3338, 0))
			.npc("Sir Vyvin")
			.solution("Talk to Sir Vyvin on the second floor of Falador castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE016)
			.text("My name is like a tree, yet it is spelt with a 'g'. Come see the fur which is right near me.")
			.location(new WorldPoint(3221, 3435, 0))
			.npc("Wilough")
			.solution("Speak to Wilough, next to the Fur Merchant in Varrock Square.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP4)
			.text("Speak to Jatix in Taverley.")
			.location(new WorldPoint(2898, 3428, 0))
			.npc("Jatix")
			.solution("Jatix is found in the middle of Taverley.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE023)
			.text("Speak to Gaius in Taverley.")
			.location(new WorldPoint(2884, 3450, 0))
			.npc("Gaius")
			.solution("Gaius is found at the northwest corner in Taverley.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE004)
			.text("If a man carried my burden, he would break his back. I am not rich, but leave silver in my track. Speak to the keeper of my trail.")
			.location(new WorldPoint(3014, 3222, 0))
			.npc("Gerrant")
			.solution("Speak to Gerrant in the fish shop in Port Sarim.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE018)
			.text("Search the drawers in Falador's chain mail shop.")
			.location(new WorldPoint(2969, 3311, 0))
			.objectId(ObjectID.DRAWERS1)
			.solution("Wayne's Chains - Chainmail Specialist store at the southern Falador walls.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP3)
			.text("Talk to the barber in the Falador barber shop.")
			.location(new WorldPoint(2945, 3379, 0))
			.npc("Hairdresser")
			.solution("The Hairdresser can be found in the barber shop, north of the west Falador bank.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE019)
			.text("Often sought out by scholars of histories past, find me where words of wisdom speak volumes.")
			.location(new WorldPoint(3362, 3341, 0))
			.npc("Examiner")
			.solution("Speak to an examiner at the Exam Centre.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE017)
			.text("Generally speaking, his nose was very bent.")
			.location(new WorldPoint(2957, 3511, 0))
			.npc("General Bentnoze")
			.solution("Talk to General Bentnoze in the Goblin Village north of Falador.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP9)
			.text("Search the bush at the digsite centre.")
			.location(new WorldPoint(3345, 3378, 0))
			.objectId(ObjectID.DIGSITEBUSH)
			.solution("The bush is on the east side of the first pathway towards the digsite from the Exam Centre.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE029)
			.text("Someone watching the fights at the Emir's Arena is your next destination.")
			.location(new WorldPoint(3367, 3221, 0))
			.npc("Jeed")
			.solution("Talk to Jeed, found on the upper floors at Emir's Arena.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE035)
			.text("It seems to have reached the end of the line, and it's still empty.")
			.location(new WorldPoint(3041, 9820, 0))
			.objectId(ObjectID.DWARFROCK_BOOK_CART)
			.solution("Search the carts in the northern part of the Dwarven Mine.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP27)
			.text("You'll have to plug your nose if you use this source of herbs.")
			.solution("Kill an Aberrant or Deviant spectre.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE036)
			.text("When you get tired of fighting, go deep, deep down until you need an antidote.")
			.location(new WorldPoint(2576, 9583, 0))
			.objectId(ObjectID.CRATE2_OLD)
			.solution("Go to Yanille Agility dungeon and fall into the place with the poison spiders by praying at the Chaos altar. Search the crate by the stairs leading up.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP11)
			.text("Search the bookcase in the monastery.")
			.location(new WorldPoint(3054, 3484, 0))
			.objectId(ObjectID.BOOKCASE)
			.solution("Search the southeastern bookcase at Edgeville Monastery.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE015)
			.text("Surprising? I bet he is...")
			.location(new WorldPoint(3205, 3474, 0))
			.npc("Sir Prysin")
			.solution("Talk to Sir Prysin in Varrock Palace.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE024)
			.text("Search upstairs in the houses of Seers' Village for some drawers.")
			.location(new WorldPoint(2716, 3471, 1))
			.objectId(ObjectID.KR_SEERS_VILLAGE_DRAWERS1)
			.solution("Located in the house with the spinning wheel. South of the Seers' Village bank.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP12)
			.text("Leader of the Yak City.")
			.location(new WorldPoint(2336, 3799, 0))
			.npc("Mawnis Burowgar")
			.solution("Talk to Mawnis Burowgar in Neitiznot.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE025)
			.text("Speak to Arhein in Catherby.")
			.location(new WorldPoint(2803, 3430, 0))
			.npc("Arhein")
			.solution("Arhein is just south of the Catherby bank.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE022)
			.text("Speak to Doric, who lives north of Falador.")
			.location(new WorldPoint(2951, 3451, 0))
			.npc("Doric")
			.solution("Doric is found north of Falador and east of the Taverley gate.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP15)
			.text("Where the best are commemorated, and a celebratory cup, not just for beer.")
			.location(new WorldPoint(3388, 3152, 0))
			.solution("Dig at the Clan Cup Trophy south-west of Citharede Abbey.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP18)
			.text("'See you in your dreams' said the vegetable man.")
			.location(new WorldPoint(2608, 3116, 0))
			.npc("Dominic Onion")
			.solution("Speak to Dominic Onion at the Nightmare Zone teleport spot.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE013)
			.text("Try not to step on any aquatic nasties while searching this crate.")
			.location(new WorldPoint(2764, 3273, 0))
			.objectId(ObjectID.SLUG2_CRATE_SINGLE)
			.solution("Search the crate in Bailey's house on the Fishing Platform.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE032)
			.text("The cheapest water for miles around, but they react badly to religious icons.")
			.location(new WorldPoint(3178, 2987, 0))
			.objectId(ObjectID.CRATE2)
			.solution("Search the crates in the General Store tent in the Desert Bandit Camp.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE031)
			.text("This village has a problem with cartloads of the undead. Try checking the bookcase to find an answer.")
			.location(new WorldPoint(2833, 2992, 0))
			.objectId(ObjectID.SHELVES_BAMBOO)
			.solution("Search the bookcase by the doorway of the building just south east of the Shilo Village Gem Mine.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP15)
			.text("Dobson is my last name, and with gardening I seek fame.")
			.location(new WorldPoint(2635, 3310, 0))
			.npc("Horacio")
			.solution("Horacio, located in the garden of the Handelmort Mansion in East Ardougne.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP13)
			.text("The magic of 4 colours, an early experience you could learn. The large beast caged up top, rages, as his demised kin's loot now returns.")
			.location(new WorldPoint(3103, 3163, 2))
			.npc("Wizard Mizgog")
			.solution("Speak to Wizard Mizgog at the top of the Wizards' Tower south of Draynor.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE005)
			.text("Aggie I see. Lonely and southern I feel. I am neither inside nor outside the house, yet no home would be complete without me. The treasure lies beneath me!")
			.location(new WorldPoint(3085, 3255, 0))
			.solution("Dig outside the window of Aggie's house in Draynor Village.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP6)
			.text("Search the chest in Barbarian Village.")
			.location(new WorldPoint(3085, 3429, 0))
			.objectId(ObjectID.CHESTCLOSED)
			.solution("The chest located in the house with a spinning wheel in Barbarian Village.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP11)
			.text("Search the crates in the outhouse of the long building in Taverley.")
			.location(new WorldPoint(2914, 3433, 0))
			.objectId(ObjectID.CRATE2_OLD)
			.solution("Located in the small building attached by a fence to the main building in Taverley. Climb over the stile.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP13)
			.text("Talk to Ermin.")
			.location(new WorldPoint(2488, 3409, 1))
			.npc("Ermin")
			.solution("Ermin can be found on the first floor of the tree house south-east of the Gnome Agility Course.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP30)
			.text("Ghostly bones.")
			.solution("Kill an Ankou.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE013)
			.text("Search through chests found in the upstairs of houses in eastern Falador.")
			.location(new WorldPoint(3041, 3364, 1))
			.objectId(ObjectID.CHESTCLOSED)
			.solution("The house is located southwest of the Falador Party Room. There are two chests in the room, search the northern chest.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP23)
			.text("Let's hope you don't meet a watery death when you encounter this fiend.")
			.solution("Kill a waterfiend.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP25)
			.text("Reflection is the weakness for these eyes of evil.")
			.solution("Kill a basilisk.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP1)
			.text("Search a bookcase in Lumbridge Swamp.")
			.location(new WorldPoint(3146, 3177, 0))
			.objectId(ObjectID.SARIM_BOOKCASE2)
			.solution("Located in Father Urhney's house in Lumbridge Swamp.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP31)
			.text("Surround my bones in fire, ontop the wooden pyre. Finally lay me to rest, before my one last test.")
			.solution("Kill a Confused or Lost barbarian in the Ancient Cavern to receive mangled bones. Construct and burn a pyre ship with logs, a tinderbox, and an axe. Kill the Ferocious barbarian spirit that spawns.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Fiendish cooks probably won't dig the dirty dishes.")
			.location(new WorldPoint(3043, 4974, 1))
			.solution("Dig by the fire in the Rogues' Den.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("My life was spared but these voices remain, now guarding these iron gates is my bane.")
			.location(new WorldPoint(1310, 1251, 0))
			.npc("Key Master")
			.solution("Speak to the Key Master in Cerberus' Lair.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE017)
			.text("Search the boxes in one of the tents in Al Kharid.")
			.location(new WorldPoint(3308, 3206, 0))
			.objectId(ObjectID.BOXES3)
			.solution("Search the boxes in the tent east of the Al Kharid Silk trader.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("One of several rhyming brothers, in business attire with an obsession for paper work.")
			.location(new WorldPoint(3186, 3936, 0))
			.npc("Piles")
			.solutionProvider((plugin) -> "Speak to Piles in the Wilderness Resource Area." + getResourceAreaCost(plugin))
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE021)
			.text("Search the drawers on the ground floor of a building facing Ardougne's market.")
			.location(new WorldPoint(2653, 3320, 0))
			.objectId(ObjectID.DRAWERS2)
			.solution("Inside Noella's house north of the East Ardougne market.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE013)
			.text("'A bag belt only?', he asked his balding brothers.")
			.location(new WorldPoint(3058, 3487, 0))
			.npc("Abbot Langley")
			.solution("Talk-to Abbot Langley in Monastery west of Edgeville")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE015)
			.text("Search the drawers upstairs in Falador's shield shop.")
			.location(new WorldPoint(2971, 3386, 1))
			.objectId(ObjectID.DRAWERS1)
			.solution("Cassie's Shield Shop at the northern Falador entrance.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE012)
			.text("Go to this building to be illuminated, and check the drawers while you are there.")
			.location(new WorldPoint(2512, 3641, 1))
			.npc("Market Guard")
			.npcRegion(10553)
			.objectId(ObjectID.DRAWERS2)
			.solution("Search the drawers in the first floor of the Lighthouse. Kill a Rellekka marketplace guard to obtain the key.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE026)
			.text("Dig near some giant mushrooms, behind the Grand Tree.")
			.location(new WorldPoint(2458, 3504, 0))
			.solution("Dig near the red mushrooms northwest of the Grand Tree.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Pentagrams and demons, burnt bones and remains, I wonder what the blood contains.")
			.location(new WorldPoint(3297, 3890, 0))
			.solution("Dig under the blood rune spawn next to the Demonic Ruins.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE001)
			.text("Search the drawers above Varrock's shops.")
			.location(new WorldPoint(3206, 3419, 1))
			.objectId(ObjectID.FAI_VARROCK_DRAWERS)
			.solution("Located upstairs in Thessalia's Fine Clothes shop in Varrock.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE013)
			.text("Search the drawers in one of Gertrude's bedrooms.")
			.location(new WorldPoint(3156, 3406, 0))
			.objectId(ObjectID.FAI_VARROCK_DRAWERS)
			.solution("Kanel's bedroom (southeastern room), in Gertrude's house south of the Cooking Guild.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Under a giant robotic bird that cannot fly.")
			.location(new WorldPoint(1756, 4940, 0))
			.solution("Dig next to the terrorbird display in the south exhibit of Varrock Museum's basement.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Great demons, dragons and spiders protect this blue rock, beneath which, you may find what you seek.")
			.location(new WorldPoint(3045, 10265, 0))
			.solution("Dig by the runite rock in the Lava Maze Dungeon.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE011)
			.text("My giant guardians below the market streets would be fans of rock and roll, if only they could grab hold of it. Dig near my green bubbles!")
			.location(new WorldPoint(3161, 9904, 0))
			.solution("Dig near the cauldron by Moss Giants under Varrock Sewers")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP10)
			.text("Varrock is where I reside, not the land of the dead, but I am so old, I should be there instead. Let's hope your reward is as good as it says, just 1 gold one and you can have it read.")
			.location(new WorldPoint(3203, 3424, 0))
			.npc("Aris")
			.solution("Talk to Aris, West of Varrock main square.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_ANAGRAM008)
			.text("Speak to a referee.")
			.location(new WorldPoint(2386, 3487, 0))
			.npc("Gnome ball referee")
			.solution("Talk to a Gnome ball referee found on the Gnome ball field in the Gnome Stronghold.")
			.questionText("What is 57 x 89 + 23?")
			.answer("5096")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE016)
			.text("This crate holds a better reward than a broken arrow.")
			.location(new WorldPoint(2671, 3437, 0))
			.objectId(ObjectID.CRATE_OLD)
			.solution("Inside the Ranging Guild. Search the crate behind the northern most building.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP8)
			.text("Search the drawers in the house next to the Port Sarim mage shop.")
			.location(new WorldPoint(3024, 3259, 0))
			.objectId(ObjectID.DRAWERS1)
			.solution("House east of Betty's Mage shop in Port Sarim. Contains a cooking sink.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP33)
			.text("With a name like that, you'd expect a little more than just a few scimitars.")
			.location(new WorldPoint(2759, 2775, 0))
			.npc("Daga")
			.solution("Speak to Daga on Ape Atoll.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP15)
			.text("Strength potions with red spiders' eggs? He is quite a herbalist.")
			.location(new WorldPoint(3194, 3403, 0))
			.npc("Apothecary")
			.solution("Talk to the Apothecary in south-west Varrock, just north-west of the Varrock Swordshop.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Robin wishes to see your finest ranged equipment.")
			.location(new WorldPoint(3673, 3492, 0))
			.npc("Robin")
			.solution("Robin at the inn in Port Phasmatys. Speak to him with +180 in ranged attack bonus. Bonus granted by the toxic blowpipe is ignored.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE001)
			.text("You will need to under-cook to solve this one.")
			.location(new WorldPoint(3219, 9617, 0))
			.objectId(ObjectID.CRATE2_OLD)
			.solution("Search the crate in the Lumbridge basement.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE016)
			.text("Search through some drawers found in Taverley's houses.")
			.location(new WorldPoint(2894, 3418, 0))
			.objectId(ObjectID.DRAWERS2)
			.solution("The south-eastern most house in Taverley, south of Jatix's Herblore Shop.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Anger Abbot Langley.")
			.location(new WorldPoint(3058, 3487, 0))
			.npc("Abbot Langley")
			.solution("Speak to Abbot Langley in the Edgeville Monastery while you have a negative prayer bonus (currently only possible with an Ancient staff or Ancient sceptre).")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP13)
			.text("Dig where only the skilled, the wealthy, or the brave can choose not to visit again.")
			.location(new WorldPoint(3221, 3219, 0))
			.solution("Dig at Lumbridge spawn")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP32)
			.text("Scattered coins and gems fill the floor. The chest you seek is in the north east.")
			.location(new WorldPoint(2288, 4702, 0))
			.npc("King Black Dragon")
			.objectId(ObjectID.CHESTCLOSED)
			.solution("Kill the King Black Dragon for a key (elite), and then open the closed chest in the NE corner of the lair.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP34)
			.text("A ring of water surrounds 4 powerful rings, dig above the ladder located there.")
			.location(new WorldPoint(1910, 4367, 0))
			.solution("Dig by the ladder leading to the Dagannoth Kings room in the Waterbirth Island Dungeon. Bring a pet rock and rune thrownaxe OR have 85 agility.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("This place sure is a mess.")
			.location(new WorldPoint(1646, 3631, 0))
			.npc("Ewesey")
			.solution("Ewesey is located in the mess hall in Hosidius.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Here, there are tears, but nobody is crying. Speak to the guardian and show off your alignment to balance.")
			.location(new WorldPoint(3252, 9517, 2))
			.npc("Juna")
			.objectId(ObjectID.TOG_JUNA_1OP)
			.solution("Talk to Juna while wearing three Guthix related items.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP21)
			.text("You might have to turn over a few stones to progress.")
			.solution("Kill a rock crab.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP35)
			.text("Dig under Razorlor's toad batta.")
			.location(new WorldPoint(3139, 4554, 0))
			.solution("Dig on the toad batta spawn in Tarn's Lair.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP1)
			.text("Talk to Cassie in Falador.")
			.location(new WorldPoint(2975, 3383, 0))
			.npc("Cassie")
			.solution("Cassie is found just south-east of the northern Falador gate.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Faint sounds of 'Arr', fire giants found deep, the eastern tip of a lake, are the rewards you could reap.")
			.location(new WorldPoint(3055, 10338, 0))
			.solution("Dig south of the pillar in the Deep Wilderness Dungeon in the room with the fire giants.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("If you're feeling brave, dig beneath the dragon's eye.")
			.location(new WorldPoint(2410, 4714, 0))
			.solution("Dig below the mossy rock under the Viyeldi caves (Legend's Quest). Items needed: Pickaxe, unpowered orb, lockpick, spade, any charge orb spell, and either 79 agility or an axe and machete. With 96 agility no items are needed.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE019)
			.text("Search the tents in the Imperial Guard camp in Burthorpe for some boxes.")
			.location(new WorldPoint(2885, 3540, 0))
			.objectId(ObjectID.DEATH_BOXES_2)
			.solution("Search in the tents in the northwest corner of the soldiers' camp in Burthorpe.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("A dwarf, approaching death, but very much in the light.")
			.location(new WorldPoint(1863, 4639, 0))
			.npc("Thorgel")
			.solution("Speak to Thorgel at the entrance to the Death altar.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP36)
			.text("You must be 100 to play with me.")
			.location(new WorldPoint(2638, 2656, 0))
			.npc("Squire (Veteran)")
			.solution("Speak to the Veteran boat squire at Pest Control.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP3)
			.text("Three rule below and three sit at top. Come dig at my entrance.")
			.location(new WorldPoint(2523, 3739, 0))
			.solution("Dig in front of the entrance to the Waterbirth Island Dungeon.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE008)
			.text("Search the drawers in the ground floor of a shop in Yanille.")
			.location(new WorldPoint(2570, 3085, 0))
			.objectId(ObjectID.DRAWERS2)
			.solution("Search the drawers in Yanille's hunting shop.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE006)
			.text("Search the drawers of houses in Burthorpe.")
			.location(new WorldPoint(2929, 3570, 0))
			.objectId(ObjectID.DRAWERS1)
			.solution("Inside Hild's house in the northeast corner of Burthorpe.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Where safe to speak, the man who offers the pouch of smallest size wishes to see your alignment.")
			.location(new WorldPoint(3260, 3385, 0))
			.npc("Mage of Zamorak")
			.npcRegion(12852)
			.solution("Speak to the Mage of Zamorak south of the Rune Shop in Varrock while wearing three Zamorakian items.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE028)
			.text("Search the crates in the guard house of the northern gate of East Ardougne.")
			.location(new WorldPoint(2645, 3338, 0))
			.objectId(ObjectID.CRATE_OLD)
			.solution("The guard house northwest of the East Ardougne market.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE008)
			.text("Go to the village being attacked by trolls, search the drawers in one of the houses.")
			.location(new WorldPoint(2921, 3577, 0))
			.npc("Penda")
			.objectId(ObjectID.DRAWERS2)
			.solution("Go to Dunstan's house in the northeast corner of Burthorpe. Kill Penda in the Toad and Chicken to obtain the key.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP26)
			.text("You'll get licked.")
			.solution("Kill a Bloodveld.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("She's small but can build both literally and figuratively.")
			.location(new WorldPoint(1486, 3834, 0))
			.npc("Lovada")
			.solution("Speak to Lovada by the entrance to the blast mine in Lovakengj.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Dig in front of the icy arena where 1 of 4 was fought.")
			.location(new WorldPoint(2874, 3757, 0))
			.solution("Dig North of Trollheim, where you fought Kamil from Desert Treasure.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_ANAGRAM017)
			.text("Speak to Roavar.")
			.location(new WorldPoint(3494, 3474, 0))
			.npc("Roavar")
			.solution("Talk to Roavar in the Canifis tavern.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE014)
			.text("Search the drawers downstairs of houses in the eastern part of Falador.")
			.location(new WorldPoint(3039, 3342, 0))
			.objectId(ObjectID.DRAWERS2)
			.solution("House is located east of the eastern Falador bank and south of the fountain. The house is indicated by a cooking range icon on the minimap.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE003)
			.text("Search the drawers found upstairs in East Ardougne's houses.")
			.location(new WorldPoint(2574, 3326, 1))
			.objectId(ObjectID.DRAWERS1)
			.solution("Upstairs of the pub north of the Ardougne Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("The far north eastern corner where 1 of 4 was defeated, the shadows still linger.")
			.location(new WorldPoint(2744, 5116, 0))
			.solution("Dig on the northeastern-most corner of the Shadow Dungeon. Bring a ring of visibility.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE027)
			.text("Search the drawers in a house in Draynor Village.")
			.location(new WorldPoint(3097, 3277, 0))
			.objectId(ObjectID.DRAWERS2)
			.solution("The drawer is located in the northernmost house in Draynor Village.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE015)
			.text("Search the boxes in a shop in Taverley.")
			.location(new WorldPoint(2886, 3449, 0))
			.objectId(ObjectID.BOXES2)
			.solution("The box inside Gaius' Two Handed Shop in Taverley.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("I lie beneath the first descent to the holy encampment.")
			.location(new WorldPoint(2914, 5300, 1))
			.solution("Dig immediately after climbing down the first set of rocks towards Saradomin's encampment within the God Wars Dungeon.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE007)
			.text("Search the upstairs drawers of a house in a village where pirates are known to have a good time.")
			.location(new WorldPoint(2809, 3165, 1))
			.npc("Pirate")
			.objectId(ObjectID.DRAWERS1)
			.solution("The house in the southeast corner of Brimhaven, northeast of Davon's Amulet Store. Kill any Pirate located around Brimhaven to obtain the key.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE001)
			.text("Search the chest in the Duke of Lumbridge's bedroom.")
			.location(new WorldPoint(3209, 3218, 1))
			.objectId(ObjectID.CHESTCLOSED)
			.solution("The Duke's room is on the first floor in Lumbridge Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP15)
			.text("Talk to the Doomsayer.")
			.location(new WorldPoint(3232, 3228, 0))
			.npc("Doomsayer")
			.solution("Doomsayer can be found just north of Lumbridge Castle entrance.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE004)
			.text("Search the chests upstairs in Al Kharid Palace.")
			.location(new WorldPoint(3301, 3169, 1))
			.objectId(ObjectID.CHESTCLOSED)
			.solution("The chest is located, in the northeast corner, on the first floor of the Al Kharid Palace.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE029)
			.text("Search the boxes just outside the Armour shop in East Ardougne.")
			.location(new WorldPoint(2654, 3299, 0))
			.objectId(ObjectID.BOXES3)
			.solution("Outside Zenesha's Plate Mail Body Shop in East Ardougne.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP17)
			.text("Surrounded by white walls and gems.")
			.location(new WorldPoint(2945, 3335, 0))
			.npc("Herquin")
			.solution("Talk to Herquin, the gem store owner in Falador.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP16)
			.text("Monk's residence in the far west. See robe storage device.")
			.location(new WorldPoint(1746, 3490, 0))
			.objectId(ObjectID.DRAWERS2)
			.solution("Search the drawers in the south tent of the monk's camp on the southern coast of Hosidius, directly south of the player-owned house portal.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE024)
			.text("Search the drawers in Catherby's Archery shop.")
			.location(new WorldPoint(2825, 3442, 0))
			.objectId(ObjectID.DRAWERS2)
			.solution("Hickton's Archery Emporium in Catherby.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP22)
			.text("The hand ain't listening.")
			.location(new WorldPoint(3019, 3232, 0))
			.npc("The Face")
			.solution("Talk to The Face located by the manhole just north of the Port Sarim fishing shop.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE027)
			.text("Search the chest in the left-hand tower of Camelot Castle.")
			.location(new WorldPoint(2748, 3495, 2))
			.objectId(ObjectID.KR_CAMELOT_CHESTCLOSED)
			.solution("Located on the second floor of the western tower of Camelot.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Anger those who adhere to Saradomin's edicts to prevent travel.")
			.location(new WorldPoint(3042, 3236, 0))
			.npc("Monk of Entrana")
			.npcRegion(12082)
			.solution("Port Sarim Docks, try to charter a ship to Entrana with armour or weapons equipped.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("South of a river in a town surrounded by the undead, what lies beneath the furnace?")
			.location(new WorldPoint(2857, 2966, 0))
			.solution("Dig in front of the Shilo Village furnace.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE017)
			.text("Talk to the Squire in the White Knights' castle in Falador.")
			.location(new WorldPoint(2977, 3343, 0))
			.npc("Squire")
			.npcRegion(11828)
			.solution("The squire is located in the courtyard of the White Knights' Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP19)
			.text("Thanks, Grandma!")
			.location(new WorldPoint(1836, 3786, 0))
			.npc("Tynan")
			.solution("Tynan can be found in the north-east corner of Port Piscarilius.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE004)
			.text("In a town where everyone has perfect vision, seek some locked drawers in a house that sits opposite a workshop.")
			.location(new WorldPoint(2709, 3478, 0))
			.npc("Chicken")
			.objectId(ObjectID.KR_SEERS_VILLAGE_DRAWERS1)
			.solution("The Seers' Village house south of the Elemental Workshop entrance. Kill any Chicken to obtain a key.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE030)
			.text("Search the crates in East Ardougne's general store.")
			.location(new WorldPoint(2615, 3291, 0))
			.objectId(ObjectID.CRATE2_OLD)
			.solution("Located south of the Ardougne church.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Come brave adventurer, your sense is on fire. If you talk to me, it's an old god you desire.")
			.locationProvider(CrypticClue::getViggoraLocation)
			.npc("Viggora")
			.solutionProvider(p -> "Speak to Viggora in " + getViggoraLocationString(p) + " while wearing a ring of visibility or ring of shadows, and a Ghostspeak amulet.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("2 musical birds. Dig in front of the spinning light.")
			.location(new WorldPoint(2671, 10396, 0))
			.solution("Dig in front of the spinning light in Ping and Pong's room inside the Iceberg")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP9)
			.text("Search the wheelbarrow in Rimmington mine.")
			.location(new WorldPoint(2978, 3239, 0))
			.objectId(ObjectID.RIMMINGTON_WHEEL_BARROW)
			.solution("The Rimmington mining site is located north of Rimmington.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP21)
			.text("Belladonna, my dear. If only I had gloves, then I could hold you at last.")
			.location(new WorldPoint(3088, 3357, 0))
			.npc("Tool Leprechaun")
			.npcRegion(12340)
			.solution("Talk to Tool Leprechaun at Draynor Manor.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE012)
			.text("Search the crates in Horvik's armoury.")
			.location(new WorldPoint(3228, 3433, 0))
			.objectId(ObjectID.FAI_VARROCK_LARGE_CRATE)
			.solution("Horvik's in Varrock.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("The doorman of the Warriors' Guild wishes to be impressed by how strong your equipment is.")
			.location(new WorldPoint(2878, 3546, 0))
			.npcProvider(CrypticClue::getWarriorsGuildDoorman)
			.solutionProvider((plugin) -> "Speak to " +  getWarriorsGuildDoorman(plugin) + " with a total Melee Strength bonus of over 100.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Shhhh!")
			.location(new WorldPoint(1633, 3808, 0))
			.npc("Logosia")
			.solution("Speak to Logosia in the Arceuus Library's ground floor.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP23)
			.text("Salty peter.")
			.location(new WorldPoint(1703, 3524, 0))
			.npc("Konoo")
			.solution("Talk to Konoo who is digging saltpetre in Hosidius, north-east of the Woodcutting Guild.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE007)
			.text("Talk to Zeke in Al Kharid.")
			.location(new WorldPoint(3287, 3190, 0))
			.npc("Zeke")
			.solution("Zeke is the owner of the scimitar shop in Al Kharid.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Guthix left his mark in a fiery lake, dig at the tip of it.")
			.location(new WorldPoint(3069, 3935, 0))
			.solution("Dig at the tip of the lava lake that is shaped like a Guthixian symbol, west of the Mage Arena.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE023)
			.text("Search the drawers in the upstairs of a house in Catherby.")
			.location(new WorldPoint(2809, 3451, 1))
			.objectId(ObjectID.DRAWERS2)
			.solution("Perdu's house in Catherby.")
			.build(),
		CrypticClue.builder()
			.text("Search a crate in the Haymaker's arms.")
			.location(new WorldPoint(1720, 3652, 1))
			.objectId(ObjectID.HOS_CRATE_01)
			.solution("Search the crate in the north-east corner of The Haymaker's Arms tavern east of Kourend Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP19)
			.text("Desert insects is what I see. Taking care of them was my responsibility. Your solution is found by digging near me.")
			.location(new WorldPoint(3307, 9505, 0))
			.solution("Dig next to the Entomologist, Kalphite Cave, east of Shantay Pass.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE006)
			.text("Search the crates in the most north-western house in Al Kharid.")
			.location(new WorldPoint(3289, 3202, 0))
			.objectId(ObjectID.CRATE3_OLD)
			.solution("Search the crates in the house, marked with a cooking range icon, southeast of the gem stall in Al Kharid.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP28)
			.text("You will have to fly high where a sword cannot help you.")
			.solution("Kill an Aviansie.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("A massive battle rages beneath so be careful when you dig by the large broken crossbow.")
			.location(new WorldPoint(2927, 3761, 0))
			.solution("NE of the God Wars Dungeon entrance, climb the rocky handholds & dig by large crossbow.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP24)
			.text("Mix yellow with blue and add heat, make sure you bring protection.")
			.solution("Kill a green or brutal green dragon.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE008)
			.text("Speak to Ellis in Al Kharid.")
			.location(new WorldPoint(3276, 3191, 0))
			.npc("Ellis")
			.solution("Ellis is tanner just north of Al Kharid bank.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_VAGUE009)
			.text("Search the chests in the Dwarven Mine.")
			.location(new WorldPoint(3000, 9798, 0))
			.objectId(ObjectID.CHESTCLOSED)
			.solution("The chest is on the western wall, where Hura's Crossbow Shop is, in the Dwarven Mine.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP29)
			.text("In a while...")
			.solution("Kill a crocodile.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("A chisel and hammer reside in his home, strange for one of magic. Impress him with your magical equipment.")
			.location(new WorldPoint(2682, 3325, 0))
			.npc("Wizard Cromperty")
			.solution("Wizard Cromperty, NE corner of East Ardougne. +100 magic attack bonus needed")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE034)
			.text("You have all of the elements available to solve this clue. Fortunately you do not have to go as far as to stand in a draft.")
			.location(new WorldPoint(2723, 9891, 0))
			.objectId(ObjectID.ELEM_CRATE_1)
			.solution("Search the crate, west of the Air Elementals, inside the Elemental Workshop.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP22)
			.text("A demon's best friend holds the next step of this clue.")
			.solution("Kill a hellhound.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP24)
			.text("Dig in the centre of a great kingdom of 5 cities.")
			.location(new WorldPoint(1639, 3673, 0))
			.solution("Dig in front of the large statue in the centre of Great Kourend.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Hopefully this set of armour will help you to keep surviving.")
			.location(new WorldPoint(2982, 3336, 2))
			.npc("Sir Vyvin")
			.solution("Speak to Sir Vyvin, located in the White Knight's Castle, while wearing a white platebody and platelegs.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP4)
			.text("The beasts retreat, for their Queen is gone; the song of this town still plays on. Dig near the birthplace of a blade, be careful not to melt your spade.")
			.location(new WorldPoint(2342, 3677, 0))
			.solution("Dig in front of the small furnace in the Piscatoris Fishing Colony.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Darkness wanders around me, but fills my mind with knowledge.")
			.location(new WorldPoint(1633, 3825, 2))
			.npc("Biblia")
			.solution("Speak to Biblia on the Arceuus Library's top floor.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP20)
			.text("I would make a chemistry joke, but I'm afraid I wouldn't get a reaction.")
			.location(new WorldPoint(2932, 3212, 0))
			.npc("Chemist")
			.solution("Talk to the Chemist in Rimmington")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP37)
			.text("Does one really need a fire to stay warm here?")
			.location(new WorldPoint(3816, 3810, 0))
			.solution("Dig next to the fire near the Volcanic Mine entrance on Fossil Island.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP14)
			.text("Search the open crate found in the Hosidius kitchens.")
			.location(new WorldPoint(1683, 3616, 0))
			.objectId(ObjectID.HOS_CRATE_02)
			.solution("The kitchens are north-west of the town in Hosidius.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP25)
			.text("Dig under Ithoi's cabin.")
			.location(new WorldPoint(2529, 2838, 0))
			.solution("Dig under Ithoi's cabin in the Corsair Cove.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_EASY_SIMPLE011)
			.text("Search the drawers, upstairs in the bank to the East of Varrock.")
			.location(new WorldPoint(3250, 3420, 1))
			.objectId(ObjectID.FAI_VARROCK_DRAWERS)
			.solution("Search the drawers upstairs in Varrock east bank.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_ANAGRAM001)
			.text("Speak to Uglug Nar.")
			.location(new WorldPoint(2444, 3049, 0))
			.npc("Uglug Nar")
			.solution("Outside Jiggig, south of Castle Wars.")
			.questionText("What is 19 to the power of 3?")
			.answer("6859")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP16)
			.text("The effects of this fire are magnified.")
			.location(new WorldPoint(1179, 3626, 0))
			.solution("Dig by the fire beside Ket'sal K'uk in the westernmost part of the Kebos Swamp.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_BEGINNER)
			.text("Always walking around the castle grounds and somehow knows everyone's age.")
			.location(new WorldPoint(3221, 3218, 0))
			.npc("Hans")
			.solution("Talk to Hans walking around Lumbridge Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_BEGINNER)
			.text("In the place Duke Horacio calls home, talk to a man with a hat dropped by goblins.")
			.location(new WorldPoint(3208, 3213, 0))
			.npc("Cook")
			.npcRegion(12850)
			.solution("Talk to the Cook in Lumbridge Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_BEGINNER)
			.text("In a village of barbarians, I am the one who guards the village from up high.")
			.location(new WorldPoint(3097, 3432, 2))
			.npc("Hunding")
			.solution("Talk to Hunding atop the tower on the east side of Barbarian Village.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_BEGINNER)
			.text("Talk to Charlie the Tramp in Varrock.")
			.location(new WorldPoint(3209, 3390, 0))
			.npc("Charlie the Tramp")
			.solution("Talk to Charlie the Tramp by the southern entrance to Varrock. He will give you a task.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_BEGINNER)
			.text("Near the open desert I reside, to get past me you must abide. Go forward if you dare, for when you pass me, you'll be sweating by your hair.")
			.location(new WorldPoint(3303, 3123, 0))
			.npc("Shantay")
			.solution("Talk to Shantay at the Shantay Pass south of Al Kharid.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP28)
			.text("Search the chest in Fred the Farmer's bedroom.")
			.location(new WorldPoint(3185, 3274, 0))
			.objectId(ObjectID.CHESTCLOSED)
			.solution("Search the chest by Fred the Farmer's bed in his house north-west of Lumbridge.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP27)
			.text("Search the eastern bookcase in Father Urhney's house.")
			.location(new WorldPoint(3149, 3177, 0))
			.objectId(ObjectID.SARIM_BOOKCASE2)
			.solution("Father Urhney's house is found in the western end of the Lumbridge Swamp.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP17)
			.text("Talk to Morgan in his house at Draynor Village.")
			.location(new WorldPoint(3098, 3268, 0))
			.npc("Morgan")
			.solution("Morgan can be found in the house with the quest start map icon in Northern Draynor Village.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP16)
			.text("Talk to Charles at Port Piscarilius.")
			.location(new WorldPoint(1821, 3690, 0))
			.npc("Charles")
			.npcRegion(7225)
			.solution("Charles is found by Veos' ship in Port Piscarilius.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP30)
			.text("Search the crate in Rommiks crafting shop in Rimmington.")
			.location(new WorldPoint(2946, 3207, 0))
			.objectId(ObjectID.SARIM_CRATE)
			.solution("The crates in Rommik's Crafty Supplies in Rimmington.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP19)
			.text("Talk to Ali the Leaflet Dropper north of the Al Kharid mine.")
			.location(new WorldPoint(3283, 3329, 0))
			.npc("Ali the Leaflet Dropper")
			.solution("Ali the Leaflet Dropper can be found roaming north of the Al Kharid mine.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP21)
			.text("Talk to the cook in the Blue Moon Inn in Varrock.")
			.location(new WorldPoint(3230, 3401, 0))
			.npc("Cook")
			.npcRegion(12853)
			.solution("The Blue Moon Inn can be found by the southern entrance to Varrock.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP29)
			.text("Search the single crate in Horvik's smithy in Varrock.")
			.location(new WorldPoint(3228, 3433, 0))
			.objectId(ObjectID.FAI_VARROCK_LARGE_CRATE)
			.solution("Horvik's Smithy is found north-east of of Varrock Square.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP31)
			.text("Search the crates in Falador General store.")
			.location(new WorldPoint(2955, 3390, 0))
			.objectId(ObjectID.FAI_FALADOR_SMALL_CRATES)
			.solution("The Falador General Store can be found by the northern entrance to the city.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP18)
			.text("Talk to Wayne at Wayne's Chains in Falador.")
			.location(new WorldPoint(2972, 3312, 0))
			.npc("Wayne")
			.solution("Wayne's shop is found directly south of the White Knights' Castle.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP26)
			.text("Search the boxes next to a chest that needs a crystal key.")
			.location(new WorldPoint(2915, 3452, 0))
			.objectId(ObjectID.BOXES2)
			.solution("The Crystal chest can be found in the house directly south of the Witch's house in Taverley.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP20)
			.text("Talk to the Slayer Master in Burthorpe.")
			.location(new WorldPoint(2930, 3536, 0))
			.npcProvider(CrypticClue::getBurthorpeSlayerMaster)
			.solutionProvider((plugin) -> getBurthorpeSlayerMaster(plugin) + " is located in the small house east of the Toad and Chicken inn in Burthorpe.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP38)
			.text("More resources than I can handle, but in a very dangerous area. Can't wait to strike gold!")
			.location(new WorldPoint(3183, 3941, 0))
			.solutionProvider((plugin) -> "Dig between the three gold ores in the Wilderness Resource Area." + getResourceAreaCost(plugin))
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP39)
			.text("Observing someone in a swamp, under the telescope lies treasure.")
			.location(new WorldPoint(2221, 3091, 0))
			.solution("Dig next to the telescope on Broken Handz's island in the poison wastes. Fairy ring DLR.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE018)
			.text("A general who sets a 'shining' example.")
			.location(new WorldPoint(2186, 3148, 0))
			.npc("General Hining")
			.solution("Talk to General Hining in Tyras Camp. Fairy ring BJS (with 76 agility).")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_EXP1)
			.text("Has no one told you it is rude to ask a lady her age?")
			.location(new WorldPoint(2333, 3165, 0))
			.npc("Mawrth")
			.solution("Talk to Mawrth in Lletya.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MASTER)
			.text("Elvish onions.")
			.location(new WorldPoint(3303, 6092, 0))
			.solution("Dig in the onion patch east of the Prifddinas allotments.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_EXP32)
			.text("Dig by the Giant's Den entrance, looking out over Lake Molch.")
			.location(new WorldPoint(1418, 3591, 0))
			.solution("South-east of Lake Molch in Zeah, outside the cave entrance.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_EXP22)
			.text("Search the crates in the fruit store just east of the Hosidius town centre.")
			.location(new WorldPoint(1799, 3613, 0))
			.objectId(ObjectID.HOS_CRATE_02)
			.solution("Search the crates in the back room of the Hosidius fruit store.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE017)
			.text("A graceful man of many colours, his crates must be full of many delights.")
			.location(new WorldPoint(1506, 3590, 2))
			.npc("Hill Giant")
			.objectId(ObjectID.SHAYZIEN_CRATE_01_DARK_OP)
			.solution("Kill any Hill Giant for a medium key. Then search the crate on the top floor of Osten's clothing shop in Shayzien.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE018)
			.text("Search the basket of apples in an orchard, south of the unknown grave surrounded by white roses.")
			.location(new WorldPoint(1718, 3626, 0))
			.objectId(ObjectID.HOS_BASKET_APPLE)
			.solution("Search the middle apple basket in the apple orchard north of Hosidius.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP17)
			.text("Dig in the lair of red wings, within the temple of the Sun and Moon.")
			.location(new WorldPoint(1820, 9935, 0))
			.solution("Forthos Dungeon. In the center of the red dragons.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.CLUEQUEST_CLUE1)
			.text("Within the town of Lumbridge lives a man named Bob. He walks out of his door and takes 1 step east, 7 steps north, 5 steps west and 1 step south. Once he arrives, he digs a hole and buries his treasure.")
			.location(new WorldPoint(3230, 3209, 0))
			.solution("Just west of the bush outside Bob's axe shop in Lumbridge.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_HARD_RIDDLE039)
			.text("Try not to let yourself be dazzled when you search these drawers.")
			.location(new WorldPoint(2561, 3323, 0))
			.objectId(ObjectID.DRAWERS2)
			.solution("Search the western drawers in Jimmy Dazzler's home near the East Ardougne Rat Pits.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_EXP18)
			.text("The Big High War God left his mark on this place.")
			.location(new WorldPoint(3572, 4372, 0))
			.solution("Dig anywhere in Yu'biusk. Fairy ring BLQ.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_SIMPLE_VM01)
			.text("Search the food barrel at the top of the Hunter Guild.")
			.location(new WorldPoint(1560, 3048, 2))
			.objectId(ObjectID.HG_BARREL_CLAY01_FOOD01_CLUE)
			.solution("Search the food pot at the top of the Hunter Guild.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_MEDIUM_RIDDLE_VM01)
			.text("Are you somewhat entertained?")
			.location(new WorldPoint(1802, 9504, 0))
			.npc("Gloria")
			.solution("Speak to Gloria inside the Fortis Colosseum")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_VM01)
			.text("With drinks and dwarves I make my way, upon my head a glass will stay.")
			.location(new WorldPoint(1432, 9584, 1))
			.npc("Funbo")
			.solution("Speak to Funbo inside Cam Torum's pub.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_VM2)
			.text("Dig at a waterfall by the pines in the serpent's shadow.")
			.location(new WorldPoint(1490, 3257, 0))
			.solution("Dig by the waterfall in Quetzacalli Gorge.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_VM02)
			.text("Banish a chilling spirit.")
			.npc("Frost Nagua")
			.solution("Kill a frost nagua.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_VM1)
			.text("Dig outside the bank on Aldarin.")
			.location(new WorldPoint(1390, 2926, 0))
			.solution("Dig outside the bank on Aldarin. Fairy ring CKQ.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_EASY_VAGUE_VM3)
			.text("He's been studying unusual tree migrations.")
			.npc("Ranulph")
			.location(new WorldPoint(1367, 3367, 0))
			.solution("Talk to Ranulph in Auburnvale.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_VM03)
			.text("Crush the spirited earth.")
			.npc("Earthen Nagua")
			.solution("Kill an earthen nagua.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_CLUE_MEDIUM_RIDDLE_VM02)
			.text("Search the crate abandoned in the shadow of a mountain's grace.")
			.location(new WorldPoint(1388, 3216, 0))
			.objectId(ObjectID.TLATI_CRATE_01_DARK_CLUE)
			.solution("Search the crate south of the Auburn Forest.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_ELITE_RIDDLE_SAIL)
			.text("Their bane awaits, but don't be going in there without permission.")
			.location(new WorldPoint(3176, 2478, 0))
			.npc("Shellbane gryphon")
			.solution("Kill the shellbane gryphon.")
			.build(),
		CrypticClue.builder()
			.itemId(ItemID.TRAIL_HARD_RIDDLE_SAIL)
			.text("I sit on the beach and cry for those that have passed on.")
			.location(new WorldPoint(2324, 2772, 0))
			.solution("Dig on the beach of the Tear of the Soul")
			.build()
	);

	private static final WorldPoint VIGGORA_ROGUES_CASTLE = new WorldPoint(3295, 3934, 1);
	private static final WorldPoint VIGGORA_SLAYER_TOWER = new WorldPoint(3447, 3547, 1);
	private static final WorldPoint VIGGORA_EDGEVILLE_DUNGEON = new WorldPoint(3121, 9995, 0);

	private static final int DEFAULT_RESOURCE_AREA_COST = 7500;

	private final Set<Integer> itemIds;
	private final String text;
	@Nullable
	@Getter(AccessLevel.PRIVATE)
	private final Function<ClueScrollPlugin, String> npcProvider;
	private final int objectId;
	@Getter(AccessLevel.NONE)
	private final String solution;
	@Nullable
	private final String questionText;
	@Nullable
	@Getter(AccessLevel.PRIVATE)
	private final Function<ClueScrollPlugin, WorldPoint> locationProvider;
	@Getter(AccessLevel.PRIVATE)
	private final Function<ClueScrollPlugin, String> solutionProvider;
	@Nullable
	private final String answer;
	private final List<Integer> npcRegions;

	@Builder
	private CrypticClue(
		@Nullable Set<Integer> itemIds,
		@Nullable Integer itemId,
		String text,
		@Nullable String npc,
		@Nullable Function<ClueScrollPlugin, String> npcProvider,
		int objectId,
		@Nullable WorldPoint location,
		@Nullable Function<ClueScrollPlugin, WorldPoint> locationProvider,
		@Nullable Function<ClueScrollPlugin, String> solutionProvider,
		String solution,
		@Nullable String questionText,
		@Nullable String answer,
		boolean requiresLight,
		@Singular List<Integer> npcRegions
	)
	{
		this.itemIds = itemIds != null ? itemIds : (itemId != null ? Set.of(itemId) : Set.of(-1));
		this.text = text;
		this.npcProvider = npcProvider != null ? npcProvider : (npc != null ? (plugin) -> npc : null);
		this.objectId = objectId > 0 ? objectId : -1;
		this.locationProvider = locationProvider != null ? locationProvider : (location != null ? (plugin) -> location : null);
		this.solutionProvider = solutionProvider != null ? solutionProvider : (plugin) -> solution;
		this.solution = solution;
		this.questionText = questionText;
		this.answer = answer;
		this.npcRegions = npcRegions;
		setRequiresSpade(this.locationProvider != null && this.npcProvider == null && this.objectId == -1);
		setRequiresLight(requiresLight);
	}

	@Nullable
	public String getNpc(ClueScrollPlugin plugin)
	{
		return npcProvider == null ? null : npcProvider.apply(plugin);
	}

	@Nullable
	@Override
	public WorldPoint getLocation(ClueScrollPlugin plugin)
	{
		return locationProvider == null ? null : locationProvider.apply(plugin);
	}

	public String getSolution(ClueScrollPlugin plugin)
	{
		return solutionProvider.apply(plugin);
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Cryptic Clue").build());

		final String npc = getNpc(plugin);
		if (npc != null)
		{
			panelComponent.getChildren().add(LineComponent.builder().left("NPC:").build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(npc)
				.leftColor(TITLED_CONTENT_COLOR)
				.build());
		}

		if (objectId != -1)
		{
			ObjectComposition object = plugin.getClient().getObjectDefinition(objectId);

			if (object != null && object.getImpostorIds() != null)
			{
				object = object.getImpostor();
			}

			if (object != null)
			{
				panelComponent.getChildren().add(LineComponent.builder().left("Object:").build());
				panelComponent.getChildren().add(LineComponent.builder()
					.left(object.getName())
					.leftColor(TITLED_CONTENT_COLOR)
					.build());
			}
		}

		panelComponent.getChildren().add(LineComponent.builder().left("Solution:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getSolution(plugin))
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
		// Mark dig location
		WorldPoint location = getLocation(plugin);
		if (location != null && getNpc(plugin) == null && objectId == -1)
		{
			LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), location);

			if (localLocation != null)
			{
				OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
			}
		}

		// Mark NPC
		if (plugin.getNpcsToMark() != null)
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

			if (plugin.getObjectsToMark() != null)
			{
				for (TileObject gameObject : plugin.getObjectsToMark())
				{
					OverlayUtil.renderHoverableArea(graphics, gameObject.getClickbox(), mousePosition,
						CLICKBOX_FILL_COLOR, CLICKBOX_BORDER_COLOR, CLICKBOX_HOVER_BORDER_COLOR);

					OverlayUtil.renderImageLocation(plugin.getClient(), graphics, gameObject.getLocalLocation(), plugin.getClueScrollImage(), IMAGE_Z_OFFSET);
				}
			}
		}
	}

	public static CrypticClue forItemId(int itemId)
	{
		for (CrypticClue clue : CLUES)
		{
			if (clue.itemIds.contains(itemId))
			{
				return clue;
			}
		}

		return null;
	}

	public static CrypticClue forText(String text)
	{
		for (CrypticClue clue : CLUES)
		{
			if (text.equalsIgnoreCase(clue.text) || text.equalsIgnoreCase(clue.questionText))
			{
				return clue;
			}
		}

		return null;
	}

	@Override
	public int[] getObjectIds()
	{
		return new int[]{objectId};
	}

	@Override
	public String[] getNpcs(ClueScrollPlugin plugin)
	{
		return new String[]{getNpc(plugin)};
	}

	@Override
	public Collection<Integer> getNpcRegions()
	{
		return npcRegions;
	}

	@Override
	public int[] getConfigKeys()
	{
		return new int[]{text.hashCode()};
	}

	@SuppressWarnings("PMD.UnusedPrivateMethod")
	private static WorldPoint getViggoraLocation(ClueScrollPlugin plugin)
	{
		int varb = plugin.getClient().getVarbitValue(VarbitID.SECRET_GHOST_RANDOMISER);
		switch (varb)
		{
			case 1:
				return VIGGORA_ROGUES_CASTLE;

			case 2:
				return VIGGORA_SLAYER_TOWER;

			case 3:
				return VIGGORA_EDGEVILLE_DUNGEON;

			default:
				log.warn("Unknown viggora location for unexpected varb value {}", varb);
				return null;
		}
	}

	private static String getViggoraLocationString(ClueScrollPlugin plugin)
	{
		int varb = plugin.getClient().getVarbitValue(VarbitID.SECRET_GHOST_RANDOMISER);
		switch (varb)
		{
			case 1:
				return "the Rogue's Castle";
			case 2:
				return "the Slayer tower";
			case 3:
				return "the Edgeville dungeon";
			default:
				return "?";
		}
	}

	private static String getResourceAreaCost(ClueScrollPlugin plugin)
	{
		if (plugin.getClient().getVarbitValue(VarbitID.WILDERNESS_DIARY_ELITE_COMPLETE) == 1)
		{
			return "";
		}

		int resourceAreaCost = DEFAULT_RESOURCE_AREA_COST;

		if (plugin.getClient().getVarbitValue(VarbitID.WILDERNESS_DIARY_HARD_COMPLETE) == 1)
		{
			resourceAreaCost = (int) (DEFAULT_RESOURCE_AREA_COST * 0.5);
		}
		else if (plugin.getClient().getVarbitValue(VarbitID.WILDERNESS_DIARY_MEDIUM_COMPLETE) == 1)
		{
			resourceAreaCost = (int) (DEFAULT_RESOURCE_AREA_COST * 0.8);
		}

		return String.format(" An entry fee of %,d coins is required.", resourceAreaCost);
	}

	private static String getBurthorpeSlayerMaster(ClueScrollPlugin plugin)
	{
		return plugin.getClient().getVarbitValue(VarbitID.WGS_HERO_PART_1_VIS) == 0 ? "Turael" : "Aya";
	}

	private static String getWarriorsGuildDoorman(ClueScrollPlugin plugin)
	{
		return plugin.getClient().getVarbitValue(VarbitID.WGS_HERO_PART_1_VIS) == 0 ? "Ghommal" : "Laidee Gnonock";
	}
}
