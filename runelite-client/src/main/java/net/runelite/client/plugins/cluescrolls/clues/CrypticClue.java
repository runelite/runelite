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
import static net.runelite.api.NullObjectID.NULL_1293;
import net.runelite.api.ObjectComposition;
import static net.runelite.api.ObjectID.*;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
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
public class CrypticClue extends ClueScroll implements TextClueScroll, NpcClueScroll, ObjectClueScroll
{
	public static final Set<CrypticClue> CLUES = ImmutableSet.of(
		new CrypticClue("Show this to Sherlock.", "Sherlock", new WorldPoint(2733, 3415, 0), "Sherlock is located to the east of the Sorcerer's tower in Seers' Village."),
		new CrypticClue("Talk to the bartender of the Rusty Anchor in Port Sarim.", "Bartender", new WorldPoint(3045, 3256, 0), "The Rusty Anchor is located in the north of Port Sarim."),
		new CrypticClue("The keeper of Melzars... Spare? Skeleton? Anar?", "Oziach", new WorldPoint(3068, 3516, 0), "Speak to Oziach in Edgeville"),
		new CrypticClue("Speak to Ulizius.", "Ulizius", new WorldPoint(3444, 3461, 0), "Ulizius is the monk who guards the gate into Mort Myre Swamp. South of fairy ring CKS"),
		new CrypticClue("Search for a crate in a building in Hemenster.", CRATE_357, new WorldPoint(2636, 3453, 0), "House north of the Fishing Contest quest area. West of Grandpa Jack."),
		new CrypticClue("A reck you say; let's pray there aren't any ghosts.", "Father Aereck", new WorldPoint(3242, 3207, 0), "Speak to Father Aereck in Lumbridge."),
		new CrypticClue("Search the bucket in the Port Sarim jail.", BUCKET_9568, new WorldPoint(3013, 3179, 0), "Talk to Shantay & identify yourself as an outlaw, refuse to pay the 5gp fine twice and you will be sent to the Port Sarim jail."),
		new CrypticClue("Search the crates in a bank in Varrock.", CRATE_5107, new WorldPoint(3187, 9825, 0), "Search in the basement of the West Varrock bank."),
		new CrypticClue("Falo the bard wants to see you.", "Falo the Bard", new WorldPoint(2689, 3550, 0), "Speak to Falo the Bard located between Seer's Village and Rellekka. Southwest of fairy ring CJR."),
		new CrypticClue("Search a bookcase in the Wizards tower.", BOOKCASE_12539, new WorldPoint(3113, 3159, 0), "The bookcase located on the ground floor."),
		new CrypticClue("Come have a cip with this great soot covered denizen.", "Miner Magnus", new WorldPoint(2527, 3891, 0), "Talk to Miner Magnus east of the fairy ring CIP. Answer: 8"),
		new CrypticClue("Citric cellar.", "Heckel Funch", new WorldPoint(2490, 3488, 0), "Speak to Heckel Funch on the first floor in the Grand Tree."),
		new CrypticClue("I burn between heroes and legends.", "Candle maker", new WorldPoint(2799, 3438, 0), "Speak to the Candle maker in Catherby."),
		new CrypticClue("Speak to Sarah at Falador farm.", "Sarah", new WorldPoint(3038, 3292, 0), "Talk to Sarah at Falador farm, north of Port Sarim."),
		new CrypticClue("Search for a crate on the ground floor of a house in Seers' Village.", CRATE_25775, new WorldPoint(2699, 3470, 0), "Search inside Phantuwti Fanstuwi Farsight's house, located south of the pub in Seers' Village."),
		new CrypticClue("Snah? I feel all confused, like one of those cakes...", "Hans", new WorldPoint(3211, 3219, 0), "Talk to Hans roaming around Lumbridge Castle."),
		new CrypticClue("Speak to Sir Kay in Camelot Castle.", "Sir Kay", new WorldPoint(2759, 3497, 0), "Sir Kay can be found in the courtyard at Camelot castle."),
		new CrypticClue("Gold I see, yet gold I require. Give me 875 if death you desire.", "Saniboch", new WorldPoint(2745, 3151, 0), "Speak to Saniboch at the Brimhaven Dungeon entrance."),
		new CrypticClue("Find a crate close to the monks that like to paaarty!", CRATE_354, new WorldPoint(2614, 3204, 0), "The crate is in the east side of the Kandarin monastery, near Brother Omad"),
		new CrypticClue("Identify the back of this over-acting brother. (He's a long way from home.)", "Hamid", new WorldPoint(3376, 3284, 0), "Talk to Hamid, the monk at the altar in the Duel Arena"),
		new CrypticClue("In a town where thieves steal from stalls, search for some drawers in the upstairs of a house near the bank.", "Guard", DRAWERS, new WorldPoint(2611, 3324, 1), "Kill any Guard located around East Ardougne for a medium key. Then search the drawers in the upstairs hallway of Jerico's house, which is the house with pigeon cages located south of the northern East Ardougne bank."),
		new CrypticClue("His bark is worse than his bite.", "Barker", new WorldPoint(3499, 3503, 0), "Speak to the Barker at Canifis's Barkers' Haberdashery."),
		new CrypticClue("The beasts to my east snap claws and tails, The rest to my west can slide and eat fish. The force to my north will jump and they'll wail, Come dig by my fire and make a wish.", new WorldPoint(2598, 3267, 0), "Dig by the torch in the Ardougne Zoo, between the penguins and the scorpions."),
		new CrypticClue("A town with a different sort of night-life is your destination. Search for some crates in one of the houses.", CRATE_24344, new WorldPoint(3498, 3507, 0), "Search the crate inside of the clothes shop in Canifis."),
		new CrypticClue("Stop crying! Talk to the head.", "Head mourner", new WorldPoint(2042, 4630, 0), "Talk to the Head mourner in the mourner headquarters in West Ardougne"),
		new CrypticClue("Search the crate near a cart in Port Khazard.", CRATE_366, new WorldPoint(2660, 3149, 0), "Search by the southern Khazard General Store in Port Khazard."),
		new CrypticClue("Speak to the bartender of the Blue Moon Inn in Varrock.", "Bartender", new WorldPoint(3226, 3399, 0), "Talk to the bartender in Blue Moon Inn in Varrock."),
		new CrypticClue("This aviator is at the peak of his profession.", "Captain Bleemadge", new WorldPoint(2846, 1749, 0), "Captain Bleemadge, the gnome glider pilot, is found at the top of White Wolf Mountain."),
		new CrypticClue("Search the crates in the shed just north of East Ardougne.", CRATE_355, new WorldPoint(2617, 3347, 0), "The crates in the shed north of the northern Ardougne bank."),
		new CrypticClue("I wouldn't wear this jean on my legs.", "Father Jean", new WorldPoint(1697, 3574, 0), "Talk to father Jean in the Hosidius church"),
		new CrypticClue("Search the crate in the Toad and Chicken pub.", CRATE_354, new WorldPoint(2913, 3536, 0), "The Toad and Chicken pub is located in Burthorpe."),
		new CrypticClue("Search chests found in the upstairs of shops in Port Sarim.", CLOSED_CHEST_375, new WorldPoint(3016, 3205, 1), "Search the chest in the upstairs of Wydin's Food Store, on the east wall."),
		new CrypticClue("Right on the blessed border, cursed by the evil ones. On the spot inaccessible by both; I will be waiting. The bugs' imminent possession holds the answer.", new WorldPoint(3410, 3324, 0), "B I P. Dig right under the fairy ring."),
		new CrypticClue("The dead, red dragon watches over this chest. He must really dig the view.", "Barbarian", 375, new WorldPoint(3353, 3332, 0), "Search the chest underneath the Red Dragon's head in the Exam Centre. Kill a MALE Barbarian in Barbarian Village or Barbarian Outpost to receive the key."),
		new CrypticClue("My home is grey, and made of stone; A castle with a search for a meal. Hidden in some drawers I am, across from a wooden wheel.", DRAWERS_5618, new WorldPoint(3213, 3216, 1), "Open the drawers inside the room with the spinning wheel on the first floor of Lumbridge Castle."),
		new CrypticClue("Come to the evil ledge, Yew know yew want to. Try not to get stung.", new WorldPoint(3089, 3468, 0), "Dig in Edgeville, just east of the Southern Yew tree."),
		new CrypticClue("Look in the ground floor crates of houses in Falador.", CRATES_24088, new WorldPoint(3029, 3355, 0), "The house east of the east bank."),
		new CrypticClue("You were 3 and I was the 6th. Come speak to me.", "Vannaka", new WorldPoint(3146, 9913, 0), "Speak to Vannaka in Edgeville Dungeon."),
		new CrypticClue("Search the crates in Draynor Manor.", CRATE_11485, new WorldPoint(3106, 3369, 2), "Top floor of the manor"),
		new CrypticClue("Search the crates near a cart in Varrock.", CRATE_5107, new WorldPoint(3226, 3452, 0), "South east of Varrock Palace, south of the tree farming patch."),
		new CrypticClue("A Guthixian ring lies between two peaks. Search the stones and you'll find what you seek.", STONES_26633, new WorldPoint(2922, 3484, 0), "Search the stones several steps west of the Guthixian stone circle in Taverley"),
		new CrypticClue("Search the boxes in the house near the south entrance to Varrock.", BOXES_5111, new WorldPoint(3203, 3384, 0), "The first house on the left when entering the city from the southern entrance."),
		new CrypticClue("His head might be hollow, but the crates nearby are filled with surprises.", CRATE_354, new WorldPoint(3478, 3091, 0), "Search the crates near the Clay golem in the ruins of Uzer."),
		new CrypticClue("One of the sailors in Port Sarim is your next destination.", "Captain Tobias", new WorldPoint(3026, 3216, 0), "Speak to Captain Tobias on the docks of Port Sarim."),
		new CrypticClue("THEY'RE EVERYWHERE!!!! But they were here first. Dig for treasure where the ground is rich with ore.", new WorldPoint(3081, 3421, 0), "Dig at Barbarian Village, next to the Stronghold of Security."),
		new CrypticClue("Talk to the mother of a basement dwelling son.", "Doris", new WorldPoint(3079, 3493, 0), "Evil Dave's mother, Doris is located in the house west of Edgeville bank."),
		new CrypticClue("Speak to Ned in Draynor Village.", "Ned", new WorldPoint(3098, 3258, 0), "Ned is found north of the Draynor bank."),
		new CrypticClue("Speak to Hans to solve the clue.", "Hans", new WorldPoint(3211, 3219, 0), "Hans can be found at Lumbridge Castle."),
		new CrypticClue("Search the crates in Canifis.", CRATE_24344, new WorldPoint(3509, 3497, 0), "Search inside the shop, Rufus' Meat Emporium."),
		new CrypticClue("Search the crates in the Dwarven mine.", CRATE_357, new WorldPoint(3035, 9849, 0), "Search the crate in the room east of the Ice Mountain ladder entrance in the Drogo's Mining Emporium."),
		new CrypticClue("A crate found in the tower of a church is your next location.", CRATE_357, new WorldPoint(2612, 3304, 1), "Climb the ladder and search the crates on the first floor in the Church in Ardougne"),
		new CrypticClue("Covered in shadows, the centre of the circle is where you will find the answer.", new WorldPoint(3488, 3289, 0), "Dig in the centre of Mort'ton, where the roads intersect"),
		new CrypticClue("I lie lonely and forgotten in mid wilderness, where the dead rise from their beds. Feel free to quarrel and wind me up, and dig while you shoot their heads.", new WorldPoint(3174, 3663, 0), "Directly under the crossbow respawn in the Graveyard of Shadows in level 18 Wilderness."),
		new CrypticClue("In the city where merchants are said to have lived, talk to a man with a splendid cape, but a hat dropped by goblins.", "Head chef", new WorldPoint(3143, 3445, 0), "Talk to the Head chef in Cooks' Guild west of Varrock."),
		new CrypticClue("The mother of the reptilian sacrifice.", "Zul-Cheray", new WorldPoint(2204, 3050, 0), "Talk to Zul-Cheray in a house near the sacrificial boat at Zul-Andra."),
		new CrypticClue("I watch the sea. I watch you fish. I watch your tree.", "Ellena", new WorldPoint(2860, 3431, 0), "Speak to Ellena at Catherby fruit tree patch."),
		new CrypticClue("Dig between some ominous stones in Falador.", new WorldPoint(3040, 3399, 0), "Three standing stones inside a walled area. East of the northern Falador gate."),
		new CrypticClue("Speak to Rusty north of Falador.", "Rusty", new WorldPoint(2979, 3435, 0), "Rusty can be found northeast of Falador on the way to the Mind altar."),
		new CrypticClue("Search a wardrobe in Draynor.", WARDROBE_5622, new WorldPoint(3087, 3261, 0), "Go to Aggie's house and search the wardrobe in northern wall."),
		new CrypticClue("I have many arms but legs, I have just one. I have little family but my seed you can grow on, I am not dead, yet I am but a spirit, and my power, on your quests, you will earn the right to free it.", NULL_1293, new WorldPoint(2544, 3170, 0), "Spirit Tree in Tree Gnome Village. Answer: 13112221"),
		new CrypticClue("I am the one who watches the giants. The giants in turn watch me. I watch with two while they watch with one. Come seek where I may be.", "Kamfreena", new WorldPoint(2845, 3539, 0), "Speak to Kamfreena on the top floor of the Warriors' Guild."),
		new CrypticClue("In a town where wizards are known to gather, search upstairs in a large house to the north.", "Man", 375, new WorldPoint(2593, 3108, 1), "Search the chest upstairs in the house north of Yanille Wizard's Guild. Kill a man for the key."),
		new CrypticClue("Probably filled with wizards socks.", "Wizard", DRAWERS_350, new WorldPoint(3116, 9562, 0), "Search the drawers in the basement of the Wizard's Tower south of Draynor Village. Kill one of the Wizards for the key. Fairy ring DIS"),
		new CrypticClue("Even the seers say this clue goes right over their heads.", CRATE_26635, new WorldPoint(2707, 3488, 2), "Search the crate on the Seers Agility Course in Seers Village"),
		new CrypticClue("Speak to a Wyse man.", "Wyson the gardener", new WorldPoint(3026, 3378, 0), "Talk to Wyson the gardener at Falador Park."),
		new CrypticClue("You'll need to look for a town with a central fountain. Look for a locked chest in the town's chapel.", "Monk" , CLOSED_CHEST_5108, new WorldPoint(3256, 3487, 0), "Search the chest by the stairs in the Varrock church. Kill a Monk in Ardougne Monastery to obtain the key."),
		new CrypticClue("Talk to Ambassador Spanfipple in the White Knights Castle.", "Ambassador Spanfipple", new WorldPoint(2979, 3340, 0), "Ambassador Spanfipple can be found roaming on the first floor of the White Knights Castle."),
		new CrypticClue("Mine was the strangest birth under the sun. I left the crimson sack, yet life had not begun. Entered the world, and yet was seen by none.", new WorldPoint(2832, 9586, 0), "Inside Karamja Volcano, dig directly underneath the Red spiders' eggs respawn."),
		new CrypticClue("Search for a crate in Varrock Castle.", CRATE_5113, new WorldPoint(3224, 3492, 0), "Search the crate in the corner of the kitchen in Varrock Castle."),
		new CrypticClue("And so on, and so on, and so on. Walking from the land of many unimportant things leads to a choice of paths.", new WorldPoint(2591, 3879, 0), "Dig on Etceteria next to the Evergreen tree in front of the castle walls."),
		new CrypticClue("Speak to Donovan, the Family Handyman.", "Donovan the Family Handyman", new WorldPoint(2743, 3578, 0), "Donovan the Family Handyman is found on the first floor of Sinclair Mansion."),
		new CrypticClue("Search the crates in the Barbarian Village helmet shop.", CRATES_11600, new WorldPoint(3073, 3430, 0), "Peksa's Helmet Shop in Barbarian Village."),
		new CrypticClue("Search the boxes of Falador's general store.", CRATES_24088, new WorldPoint(2955, 3390, 0), "Falador general store."),
		new CrypticClue("In a village made of bamboo, look for some crates under one of the houses.", CRATE_356, new WorldPoint(2800, 3074, 0), "Search the crate by the house at the northern point of the broken jungle fence in Tai Bwo Wannai."),
		new CrypticClue("This crate is mine, all mine, even if it is in the middle of the desert.", CRATE_18889, new WorldPoint(3289, 3022, 0), "Center of desert Mining Camp. Search the crates. Requires the metal key from Tourist Trap to enter."),
		new CrypticClue("Dig where 4 siblings and I all live with our evil overlord.", new WorldPoint(3195, 3357, 0), "Dig in the chicken pen inside the Champions' Guild"),
		new CrypticClue("In a town where the guards are armed with maces, search the upstairs rooms of the Public House.", "Guard dog", 348, new WorldPoint(2574, 3326, 1), "Search the drawers upstairs in the pub north of Ardougne Castle. Kill a Guard dog at Handelmort Mansion to obtain the key."),
		new CrypticClue("Four blades I have, yet draw no blood; Still I turn my prey to powder. If you are brave, come search my roof; It is there my blades are louder.", CRATE_12963, new WorldPoint(3166, 3309, 2), "Lumbridge windmill, search the crates on the top floor."),
		new CrypticClue("Search through some drawers in the upstairs of a house in Rimmington.", DRAWERS_352, new WorldPoint(2970, 3214, 1), "On the first floor of the house north of Hetty the Witch's house in Rimmington."),
		new CrypticClue("Probably filled with books on magic.", BOOKCASE_380, new WorldPoint(3096, 9572, 0), "Search the bookcase in the basement of Wizard's Tower. Fairy ring DIS"),
		new CrypticClue("If you look closely enough, it seems that the archers have lost more than their needles.", HAYSTACK, new WorldPoint(2672, 3416, 0), "Search the haystack by the south corner of the Rangers' Guild"),
		new CrypticClue("Search the crate in the left-hand tower of Lumbridge Castle.", CRATE_357, new WorldPoint(3228, 3212, 1), "Located on the first floor of the southern tower at the Lumbridge Castle entrance."),
		new CrypticClue("'Small shoe.' Often found with rod on mushroom.", "Gnome trainer", new WorldPoint(2476, 3428, 0), "Talk to any Gnome trainer in the agility area of the Tree Gnome Stronghold."),
		new CrypticClue("I live in a deserted crack collecting soles.", "Genie", new WorldPoint(3371, 9320, 0), "Enter the crack west of Nardah Rug merchant, and talk to the Genie. You'll need a light source and a rope."),
		new CrypticClue("46 is my number. My body is the colour of burnt orange and crawls among those with eight. Three mouths I have, yet I cannot eat. My blinking blue eye hides my grave.", new WorldPoint(3170, 3885, 0), "Sapphire respawn in the Spider's Nest, lvl 46 Wilderness. Dig under the sapphire spawn."),
		new CrypticClue("Green is the colour of my death as the winter-guise, I swoop towards the ground.", new WorldPoint(2780, 3783, 0), "Players need to slide down to where Trollweiss grows on Trollweiss Mountain."),
		new CrypticClue("Talk to a party-goer in Falador.", "Lucy", new WorldPoint(3046, 3382, 0), "Lucy is the bartender on the first floor of the party room."),
		new CrypticClue("He knows just how easy it is to lose track of time.", "Brother Kojo", new WorldPoint(2570, 3250, 0), "Speak to brother Kojo in the Clock Tower. Answer: 22"),
		new CrypticClue("A great view - watch the rapidly drying hides get splashed. Check the box you are sitting on.", BOXES, new WorldPoint(2523, 3493, 1), "Almera's House north of Baxtorian Falls, search boxes on the first floor."),
		new CrypticClue("Search the Coffin in Edgeville.", COFFIN, new WorldPoint(3091, 3477, 0), "Search the coffin located by the Wilderness teleport lever."),
		new CrypticClue("When no weapons are at hand, then is the time to reflect. In Saradomin's name, redemption draws closer...", DRAWERS_350, new WorldPoint(2818, 3351, 0), "On Entrana, search the southern drawer in the house with the cooking range."),
		new CrypticClue("Search the crates in a house in Yanille that has a piano.", CRATE_357, new WorldPoint(2598, 3105, 0), "The house is located northwest of the bank."),
		new CrypticClue("Speak to the staff of Sinclair mansion.", "Louisa", new WorldPoint(2736, 3578, 0), "Speak to Louisa, on the ground floor, found at the Sinclair Mansion. Fairy ring CJR"),
		new CrypticClue("I am a token of the greatest love. I have no beginning or end. My eye is red, I can fit like a glove. Go to the place where it's money they lend, And dig by the gate to be my friend.", new WorldPoint(3191, 9825, 0), "Dig by the gate in the basement of the West Varrock bank."),
		new CrypticClue("Speak to Kangai Mau.", "Kangai Mau", new WorldPoint(2791, 3183, 0), "Kangai Mau is found in the Shrimp and Parrot in Brimhaven."),
		new CrypticClue("Speak to Hajedy.", "Hajedy", new WorldPoint(2779, 3211, 0), "Hajedy is found by the cart, located just south of the Brimhaven docks."),
		new CrypticClue("Must be full of railings.", BOXES_6176, new WorldPoint(2576, 3464, 0), "Search the boxes around the hut where the broken Dwarf Cannon is, close to the start of the Dwarf Cannon quest."),
		new CrypticClue("I wonder how many bronze swords he has handed out.", "Vannaka", new WorldPoint(3164, 9913, 0), "Talk to Vannaka. He can be found in Edgeville Dungeon."),
		new CrypticClue("Read 'How to breed scorpions.' By O.W.Thathurt.", BOOKCASE_380, new WorldPoint(2703, 3409, 1), "Search the northern bookcase on the first floor of the Sorcerer's Tower."),
		new CrypticClue("Search the crates in the Port Sarim Fishing shop.", CRATE_9534, new WorldPoint(3012, 3222, 0), "Search the crates, by the door, in Gerrant's Fishy Business in Port Sarim."),
		new CrypticClue("Speak to The Lady of the Lake.", "The Lady of the Lake", new WorldPoint(2924, 3405, 0), "Talk to The Lady of the Lake in Taverley."),
		new CrypticClue("Rotting next to a ditch. Dig next to the fish.", new WorldPoint(3547, 3183, 0), "Dig next to a fishing spot on the south-east side of Burgh de Rott."),
		new CrypticClue("The King's magic won't be wasted by me.", "Guardian Mummy", new WorldPoint(1934, 4427, 0), "Talk to the Guardian mummy inside the Pyramid Plunder minigame in Sophanem"),
		new CrypticClue("Dig where the forces of Zamorak and Saradomin collide.", new WorldPoint(3049, 4839, 0), "Dig next to the law rift in the Abyss"),
		new CrypticClue("Search the boxes in the goblin house near Lumbridge.", BOXES, new WorldPoint(3245, 3245, 0), "Goblin house on the eastern side of the river."),
		new CrypticClue("W marks the spot.", new WorldPoint(2867, 3546, 0), "Dig in the middle of the Warriors' Guild entrance hall"),
		new CrypticClue("There is no 'worthier' lord.", "Lord Iorwerth", new WorldPoint(2205, 3252, 0), "Speak to Lord Iorwerth in the elven camp near Prifddinas"),
		new CrypticClue("Surviving.", "Sir Vyvin", new WorldPoint(2983, 3338, 0), "Talk to Sir Vyvin on the second floor of Falador castle."),
		new CrypticClue("My name is like a tree, yet it is spelt with a 'g'. Come see the fur which is right near me.", "Wilough", new WorldPoint(3221, 3435, 0), "Speak to Wilough, next to the Fur Merchant in Varrock Square."),
		new CrypticClue("Speak to Jatix in Taverley.", "Jatix", new WorldPoint(2898, 3428, 0), "Jatix is found in the middle of Taverley."),
		new CrypticClue("Speak to Gaius in Taverley.", "Gaius", new WorldPoint(2884, 3450, 0), "Gaius is found at the northwest corner in Taverley."),
		new CrypticClue("If a man carried my burden, he would break his back. I am not rich, but leave silver in my track. Speak to the keeper of my trail.", "Gerrant", new WorldPoint(3014, 3222, 0), "Speak to Gerrant in the fish shop in Port Sarim."),
		new CrypticClue("Search the drawers in Falador's chain mail shop.", DRAWERS, new WorldPoint(2969, 3311, 0), "Wayne's Chains - Chainmail Specialist store at the southern Falador walls."),
		new CrypticClue("Talk to the barber in the Falador barber shop.", "Hairdresser", new WorldPoint(2945, 3379, 0), "The Hairdresser can be found in the barber shop, north of the west Falador bank."),
		new CrypticClue("Often sought out by scholars of histories past, find me where words of wisdom speak volumes.", "Examiner", new WorldPoint(3362, 3341, 0), "Speak to an examiner at the Exam Centre."),
		new CrypticClue("Generally speaking, his nose was very bent.", "General Bentnoze", new WorldPoint(2957, 3511, 0), "Talk to General Bentnoze"),
		new CrypticClue("Search the bush at the digsite centre.", BUSH_2357, new WorldPoint(3345, 3378, 0), "The bush is on the east side of the first pathway towards the digsite from the Exam Centre."),
		new CrypticClue("Someone watching the fights in the Duel Arena is your next destination.", "Jeed", new WorldPoint(3360, 3242, 0), "Talk to Jeed, found on the upper floors, at the Duel Arena."),
		new CrypticClue("It seems to have reached the end of the line, and it's still empty.", MINE_CART_6045, new WorldPoint(3041, 9820, 0), "Search the carts in the northern part of the Dwarven Mine."),
		new CrypticClue("You'll have to plug your nose if you use this source of herbs.", null, "Kill an Aberrant spectre."),
		new CrypticClue("When you get tired of fighting, go deep, deep down until you need an antidote.", CRATE_357, new WorldPoint(2576, 9583, 0), "Go to Yanille Agility dungeon and fall into the place with the poison spiders. Search the crate by the stairs leading up."),
		new CrypticClue("Search the bookcase in the monastery.", BOOKCASE_380, new WorldPoint(3054, 3484, 0), "Search the southeastern bookcase at Edgeville Monastery."),
		new CrypticClue("Surprising? I bet he is...", "Sir Prysin", new WorldPoint(3205, 3474, 0), "Talk to Sir Prysin in Varrock Palace."),
		new CrypticClue("Search upstairs in the houses of Seers' Village for some drawers.", DRAWERS_25766, new WorldPoint(2716, 3471, 1), "Located in the house with the spinning wheel. South of the Seers' Village bank."),
		new CrypticClue("Leader of the Yak City.", "Mawnis Burowgar", new WorldPoint(2336, 3799, 0), "Talk to Mawnis Burowgar in Neitiznot."),
		new CrypticClue("Speak to Arhein in Catherby.", "Arhein", new WorldPoint(2803, 3430, 0), "Arhein is just south of the Catherby bank."),
		new CrypticClue("Speak to Doric, who lives north of Falador.", "Doric", new WorldPoint(2951, 3451, 0), "Doric is found north of Falador and east of the Taverley gate."),
		new CrypticClue("Between where the best are commemorated for a year, and a celebratory cup, not just for beer.", new WorldPoint(3388, 3152, 0), "Dig at the Clan Cup Trophy at Clan Wars."),
		new CrypticClue("'See you in your dreams' said the vegetable man.", "Dominic Onion", new WorldPoint(2608, 3116, 0), "Speak to Dominic Onion at the Nightmare Zone teleport spot."),
		new CrypticClue("Try not to step on any aquatic nasties while searching this crate.", CRATE_18204, new WorldPoint(2764, 3273, 0), "Search the crate in Bailey's house on the Fishing Platform."),
		new CrypticClue("The cheapest water for miles around, but they react badly to religious icons.", CRATE_354, new WorldPoint(3178, 2987, 0), "Search the crates in the General Store tent in the Bandit Camp"),
		new CrypticClue("This village has a problem with cartloads of the undead. Try checking the bookcase to find an answer.", BOOKCASE_394, new WorldPoint(2833, 2992, 0), "Search the bookcase by the doorway of the building just south east of the Shilo Village Gem Mine."),
		new CrypticClue("Dobson is my last name, and with gardening I seek fame.", "Horacio", new WorldPoint(2635, 3310, 0), "Horacio, located in the garden of the Handelmort Mansion in East Ardougne."),
		new CrypticClue("The magic of 4 colours, an early experience you could learn. The large beast caged up top, rages, as his demised kin's loot now returns.", "Wizard Mizgog", new WorldPoint(3103, 3163, 2), "Speak to Wizard Mizgog at the top of the Wizard's Tower south of Draynor."),
		new CrypticClue("Aggie I see. Lonely and southern I feel. I am neither inside nor outside the house, yet no home would be complete without me. The treasure lies beneath me!", new WorldPoint(3085, 3255, 0), "Dig outside the window of Aggie's house in Draynor Village."),
		new CrypticClue("Search the chest in Barbarian Village.", CLOSED_CHEST_375, new WorldPoint(3085, 3429, 0), "The chest located in the house with a spinning wheel."),
		new CrypticClue("Search the crates in the outhouse of the long building in Taverley.", CRATE_357, new WorldPoint(2914, 3433, 0), "Located in the small building attached by a fence to the main building. Climb over the stile."),
		new CrypticClue("Talk to Ermin.", "Ermin", new WorldPoint(2488, 3409, 1), "Ermin can be found on the first floor of the tree house south-east of the Gnome Agility Course."),
		new CrypticClue("Ghostly bones.", null, "Kill an Ankou."),
		new CrypticClue("Search through chests found in the upstairs of houses in eastern Falador.", CLOSED_CHEST_375, new WorldPoint(3041, 3364, 1), "The house is located southwest of the Falador Party Room. There are two chests in the room, search the northern chest."),
		new CrypticClue("Let's hope you don't meet a watery death when you encounter this fiend.", null, "Kill a waterfiend."),
		new CrypticClue("Reflection is the weakness for these eyes of evil.", null, "Kill a basilisk."),
		new CrypticClue("Search a bookcase in Lumbridge swamp.", BOOKCASE_9523, new WorldPoint(3146, 3177, 0), "Located in Father Urhney's house."),
		new CrypticClue("Surround my bones in fire, ontop the wooden pyre. Finally lay me to rest, before my one last test.", null, "Kill a confused/lost barbarian to receive mangled bones. Construct and burn a pyre ship. Kill the ferocious barbarian spirit that spawns to receive a clue casket."),
		new CrypticClue("Fiendish cooks probably won't dig the dirty dishes.", new WorldPoint(3043, 4974, 1), "Dig by the fire in the Rogues' Den."),
		new CrypticClue("My life was spared but these voices remain, now guarding these iron gates is my bane.",  "Key Master", new WorldPoint(1310, 1251, 0), "Speak to the Key Master in Cerberus' Lair."),
		new CrypticClue("Search the boxes in one of the tents in Al Kharid.", BOXES_361, new WorldPoint(3308, 3206, 0), "Search the boxes in the tent east of the Silk trader."),
		new CrypticClue("One of several rhyming brothers, in business attire with an obsession for paper work.",  "Piles", new WorldPoint(3186, 3936, 0), "Speak to Piles in the Wilderness Resource Area. An entry fee of 7,500 coins is required, or less if Wilderness Diaries have been completed."),
		new CrypticClue("Search the drawers on the first floor of a building overlooking Ardougne's Market.", DRAWERS_352, new WorldPoint(2657, 3322, 1), "Climb the ladder in the house north of the market."),
		new CrypticClue("'A bag belt only?', he asked his balding brothers.", "Abbot Langley", new WorldPoint(3058, 3487, 0), "Talk-to Abbot Langley in Monastery west of Edgeville"),
		new CrypticClue("Search the drawers upstairs in Falador's shield shop.", DRAWERS, new WorldPoint(2971, 3386, 1), "Cassie's Shield Shop at the northern Falador entrance."),
		new CrypticClue("Go to this building to be illuminated, and check the drawers while you are there.", "Market Guard", DRAWERS_350 , new WorldPoint(2512, 3641, 1), "Search the drawers in the first floor of the Lighthouse. Kill a Rellekka marketplace guard to obtain the key."),
		new CrypticClue("Dig near some giant mushrooms, behind the Grand Tree.", new WorldPoint(2458, 3504, 0), "Dig near the red mushrooms northwest of the Grand Tree."),
		new CrypticClue("Pentagrams and demons, burnt bones and remains, I wonder what the blood contains.", new WorldPoint(3297, 3890, 0), "Dig under the blood rune spawn next the the Demonic Ruins."),
		new CrypticClue("Search the drawers above Varrock's shops.", DRAWERS_7194, new WorldPoint(3206, 3419, 1), "Located upstairs in Thessalia's Fine Clothes shop in Varrock."),
		new CrypticClue("Search the drawers in one of Gertrude's bedrooms.", DRAWERS_7194, new WorldPoint(3156, 3406, 0), "Kanel's bedroom (southeastern room), outside of west Varrock."),
		new CrypticClue("Under a giant robotic bird that cannot fly.", new WorldPoint(1756, 4940, 0), "Dig next to the terrorbird display in the south exhibit of Varrock Museum's basement."),
		new CrypticClue("Great demons, dragons and spiders protect this blue rock, beneath which, you may find what you seek.", new WorldPoint(3045, 10265, 0), "Dig by the runite rock in the Lava Maze Dungeon"),
		new CrypticClue("My giant guardians below the market streets would be fans of rock and roll, if only they could grab hold of it. Dig near my green bubbles!", new WorldPoint(3161, 9904, 0), "Dig near the cauldron by Moss Giants under Varrock Sewers"),
		new CrypticClue("Varrock is where I reside, not the land of the dead, but I am so old, I should be there instead. Let's hope your reward is as good as it says, just 1 gold one and you can have it read.", "Gypsy Aris", new WorldPoint(3203, 3424, 0), "Talk to Gypsy Aris, West of varrock main square."),
		new CrypticClue("Speak to a referee.", "Gnome ball referee", new WorldPoint(2386, 3487, 0), "Talk to a Gnome ball referee found on the Gnome ball field in the Gnome Stronghold. Answer: 5096"),
		new CrypticClue("This crate holds a better reward than a broken arrow.", CRATE_356, new WorldPoint(2671, 3437, 0), "Inside the Ranging Guild. Search the crate behind the northern most building."),
		new CrypticClue("Search the drawers in the house next to the Port Sarim mage shop.", DRAWERS, new WorldPoint(3024, 3259, 0), "House east of Betty's. Contains a cooking sink."),
		new CrypticClue("With a name like that, you'd expect a little more than just a few scimitars.", "Daga", new WorldPoint(2759, 2775, 0), "Speak to Daga on Ape Atoll."),
		new CrypticClue("Strength potions with red spiders' eggs? He is quite a herbalist.", "Apothecary", new WorldPoint(3194, 3403, 0), "Talk to Apothecary in the South-western Varrock. (the) apothecary is just north-west of the Varrock Swordshop."),
		new CrypticClue("Robin wishes to see your finest ranged equipment.", "Robin", new WorldPoint(3673, 3492, 0), "Robin at the inn in Port Phasmatys. Speak to him with +182 in ranged attack bonus."),
		new CrypticClue("You will need to under-cook to solve this one.", CRATE_357, new WorldPoint(3219, 9617, 0), "Search the crate in the Lumbridge basement."),
		new CrypticClue("Search through some drawers found in Taverley's houses.", DRAWERS_350, new WorldPoint(2894, 3418, 0), "The south-eastern most house, south of Jatix's Herblore Shop."),
		new CrypticClue("Anger Abbot Langley.", "Abbot Langley", new WorldPoint(3058, 3487, 0), "Speak to Abbot Langley in the Edgeville Monastery while you have a negative prayer bonus (currently only possible with an Ancient staff)."),
		new CrypticClue("Dig where only the skilled, the wealthy, or the brave can choose not to visit again.", new WorldPoint(3221, 3219, 0), "Dig at Lumbridge spawn"),
		new CrypticClue("Scattered coins and gems fill the floor. The chest you seek is in the north east.", "King Black Dragon", CLOSED_CHEST_375, new WorldPoint(2288, 4702, 0), "Kill the King Black Dragon for a key (elite), and then open the closed chest in the NE corner of the lair."),
		new CrypticClue("A ring of water surrounds 4 powerful rings, dig above the ladder located there.", new WorldPoint(1910, 4367, 0), "Dig by the ladder leading to the Dagannoth Kings room in the Waterbirth Island Dungeon."),
		new CrypticClue("This place sure is a mess.", "Ewesey", new WorldPoint(1646, 3631, 0), "Ewesey is located in the Hosidius House mess hall in Great Kourend."),
		new CrypticClue("Here, there are tears, but nobody is crying. Speak to the guardian and show off your alignment to balance.", "Juna", JUNA, new WorldPoint(3252, 9517, 2), "Talk to Juna while wearing three Guthix related items."),
		new CrypticClue("You might have to turn over a few stones to progress.", null, "Kill a rock crab."),
		new CrypticClue("Dig under Razorlor's toad batta.", new WorldPoint(3139, 4554, 0), "Dig on the toad batta spawn in Tarn's Lair."),
		new CrypticClue("Talk to Cassie in Falador.", "Cassie", new WorldPoint(2975, 3383, 0), "Cassie is found just south-east of the northern Falador gate."),
		new CrypticClue("Faint sounds of 'Arr', fire giants found deep, the eastern tip of a lake, are the rewards you could reap.", new WorldPoint(3055, 10338, 0), "Dig south of the pillar at the end of the Deep Wilderness Dungeon."),
		new CrypticClue("If you're feeling brave, dig beneath the dragon's eye.", new WorldPoint(2410, 4714, 0), "Dig below the mossy rock under the Viyeldi caves (Legend's Quest). Items needed: Pickaxe, unpowered orb, lockpick, spade, and any charge orb spell."),
		new CrypticClue("Search the tents in the Imperial Guard camp in Burthorpe for some boxes.", BOXES_3686, new WorldPoint(2885, 3540, 0), "Search in the tents in northwest corner of the camp."),
		new CrypticClue("A dwarf, approaching death, but very much in the light.", "Thorgel", new WorldPoint(1863, 4639, 0), "Thorgel at the entrance to the Death altar"),
		new CrypticClue("You must be 100 to play with me.", "Squire (Veteran)", new WorldPoint(2638, 2656, 0), "Speak to the Veteran boat squire at Pest Control"),
		new CrypticClue("Three rule below and three sit at top. Come dig at my entrance.", new WorldPoint(2523, 3739, 0), "Dig in front of the entrance to the Waterbirth Island Dungeon."),
		new CrypticClue("Search the drawers in the ground floor of a shop in Yanille.", DRAWERS_350, new WorldPoint(2570, 3085, 0), "Search the drawers in Yanille's hunting shop."),
		new CrypticClue("Search the drawers of houses in Burthorpe.", DRAWERS, new WorldPoint(2929, 3570, 0), "Inside Hild's house in the northeast corner of Burthorpe."),
		new CrypticClue("Where safe to speak, the man who offers the pouch of smallest size wishes to see your alignment.", "Mage of Zamorak", new WorldPoint(3260, 3385, 0), "Speak to the Mage of Zamorak south of the Rune Shop in Varrock while wearing three zamorakian items"),
		new CrypticClue("Search the crates in the guard house of the northern gate of East Ardougne.", CRATE_356, new WorldPoint(2645, 3338, 0), "The guard house is northeast of the Handelmort Mansion."),
		new CrypticClue("Go to the village being attacked by trolls, search the drawers in one of the houses.", "Penda", DRAWERS_350, new WorldPoint(2921, 3577, 0), "Go to Dunstan's house in the northeast corner of Burthorpe. Kill Penda in the Toad and Chicken to obtain the key."),
		new CrypticClue("You'll get licked.", null, "Kill a Bloodveld."),
		new CrypticClue("She's small but can build both literally and figuratively, as long as you have their favour.", "Lovada", new WorldPoint(1486, 3834, 0), "Speak to Lovada south of the Lovakengj House blast mine"),
		new CrypticClue("Dig in front of the icy arena where 1 of 4 was fought.", new WorldPoint(2874, 3757, 0), "Where you fought Kamil from Desert Treasure."),
		new CrypticClue("Speak to Roavar.", "Roavar", new WorldPoint(3494, 3474, 0), "Talk to Roavar in the Canifis tavern."),
		new CrypticClue("Search the drawers upstairs of houses in the eastern part of Falador.", DRAWERS_350, new WorldPoint(3035, 3347, 1), "House is located east of the eastern Falador bank and south of the fountain. The house is indicated by the icon on the minimap."),
		new CrypticClue("Search the drawers found upstairs in East Ardougne's houses.", DRAWERS, new WorldPoint(2574, 3326, 1), "Upstairs of the pub north of the Ardougne Castle."),
		new CrypticClue("The far north eastern corner where 1 of 4 was defeated, the shadows still linger.", new WorldPoint(2744, 5116, 0), "Dig on the northeastern-most corner of the Shadow Dungeon. Bring a ring of visibility."),
		new CrypticClue("Search the drawers in a house in Draynor Village.", DRAWERS_350, new WorldPoint(3097, 3277, 0), "The drawer is located in the northernmost house in Draynor Village."),
		new CrypticClue("Search the boxes in a shop in Taverley.", BOXES_360, new WorldPoint(2886, 3449, 0), "The box inside Gaius' Two Handed Shop."),
		new CrypticClue("I lie beneath the first descent to the holy encampment.", new WorldPoint(2914, 5300, 1), "Dig immediately after climbing down the first set of rocks towards Saradomin's encampment within the God Wars Dungeon."),
		new CrypticClue("Search the upstairs drawers of a house in a village where pirates are known to have a good time.", "Pirate", 348, new WorldPoint(2809, 3165, 1), "The house in the southeast corner of Brimhaven, northeast of Davon's Amulet Store. Kill any Pirate located around Brimhaven to obtain the key."),
		new CrypticClue("Search the chest in the Duke of Lumbridge's bedroom.", CLOSED_CHEST_375, new WorldPoint(3209, 3218, 1), "The Duke's room is on the first floor in Lumbridge Castle."),
		new CrypticClue("Talk to the Doomsayer.", "Doomsayer", new WorldPoint(3232, 3228, 0), "Doomsayer can be found just north of Lumbridge Castle entrance."),
		new CrypticClue("Search the chests upstairs in Al Kharid Palace.", CLOSED_CHEST_375, new WorldPoint(3301, 3169, 1), "The chest is located, in the northeast corner, on the first floor of the Al Kharid Palace"),
		new CrypticClue("Search the boxes just outside the Armour shop in East Ardougne.", BOXES_361, new WorldPoint(2654, 3299, 0), "Outside Zenesha's Plate Mail Body Shop"),
		new CrypticClue("Surrounded by white walls and gems.", "Herquin", new WorldPoint(2945, 3335, 0), "Talk to Herquin, the gem store owner in Falador."),
		new CrypticClue("Monk's residence in the far west. See robe storage device.", DRAWERS_350, new WorldPoint(1742, 3490, 1), "Search the drawers upstairs in the chapel found on the southern coast of Great Kourend's Hosidius House. Directly south of the player-owned house portal."),
		new CrypticClue("Search the drawers in Catherby's Archery shop.", DRAWERS_350, new WorldPoint(2825, 3442, 0), "Hickton's Archery Emporium in Catherby."),
		new CrypticClue("The hand ain't listening.", "The Face", new WorldPoint(3019, 3232, 0), "Talk to The Face located by the manhole just north of the Port Sarim fishing shop."),
		new CrypticClue("Search the chest in the left-hand tower of Camelot Castle.", CLOSED_CHEST_25592, new WorldPoint(2748, 3495, 2), "Located on the second floor of the western tower of Camelot."),
		new CrypticClue("Kill the spiritual, magic and godly whilst representing their own god", null, "Kill a spiritual mage while wearing a corresponding god item."),
		new CrypticClue("Anger those who adhere to Saradomin's edicts to prevent travel.", "Monk of Entrana", new WorldPoint(3042, 3236, 0), "Port Sarim Docks, try to charter a ship to Entrana with armour or weapons equipped."),
		new CrypticClue("South of a river in a town surrounded by the undead, what lies beneath the furnace?", new WorldPoint(2857, 2966, 0), "Dig in front of the Shilo Village furnace."),
		new CrypticClue("Talk to the Squire in the White Knights' castle in Falador.", "Squire", new WorldPoint(2977, 3343, 0), "The squire is located in the courtyard of the White Knights' Castle."),
		new CrypticClue("Thanks, Grandma!", "Tynan", new WorldPoint(1836, 3786, 0), "Tynan can be found in the north-east corner of Piscarilius House in Great Kourend."),
		new CrypticClue("In a town where everyone has perfect vision, seek some locked drawers in a house that sits opposite a workshop.", "Chicken", DRAWERS_25766, new WorldPoint(2709, 3478, 0), "The Seers' Village house south of the Elemental Workshop entrance. Kill any Chicken to obtain a key."),
		new CrypticClue("The treasure is buried in a small building full of bones. Here is a hint: it's not near a graveyard.", new WorldPoint(3356, 3507, 0), "In the western building near the Limestone quarry east of Varrock. Dig south of the box of bones in the smaller building."),
		new CrypticClue("Search the crates in East Ardougne's general store.", CRATE_357, new WorldPoint(2615, 3291, 0), "Located south of the Ardounge church."),
		new CrypticClue("Come brave adventurer, your sense is on fire. If you talk to me, it's an old god you desire.", "Viggora", null, "Speak to Viggora"),
		new CrypticClue("2 musical birds. Dig in front of the spinning light.", new WorldPoint(2671, 10396, 0), "Dig in front of the spinning light in Ping and Pong's room inside the Iceberg"),
		new CrypticClue("Search the wheelbarrow in Rimmington mine.", WHEELBARROW_9625, new WorldPoint(2978, 3239, 0), "The Rimmington mining site is located north of Rimmington."),
		new CrypticClue("Belladonna, my dear. If only I had gloves, then I could hold you at last.", "Tool Leprechaun", new WorldPoint(3088, 3357, 0), "Talk to Tool Leprechaun at Draynor Manor"),
		new CrypticClue("Impossible to make angry", "Abbot Langley", new WorldPoint(3059, 3486, 0), "Speak to Abbot Langley at the Edgeville Monastery."),
		new CrypticClue("Search the crates in Horvik's armoury.", CRATE_5106, new WorldPoint(3228, 3433, 0), "Horvik's in Varrock"),
		new CrypticClue("Ghommal wishes to be impressed by how strong your equipment is.", "Ghommal", new WorldPoint(2878, 3546, 0), "Speak to Ghommal at the Warriors' Guild with a total Melee Strength bonus of over 100."),
		new CrypticClue("Shhhh!", "Logosia", new WorldPoint(1633, 3808, 0), "Speak to Logosia in the Arceuus House Library's ground floor."),
		new CrypticClue("Salty peter.", "Konoo", new WorldPoint(1703, 3524, 0), "Talk to Konoo who is digging saltpeter in the Hosidius district in Zeah."),
		new CrypticClue("Talk to Zeke in Al Kharid.", "Zeke", new WorldPoint(3287, 3190, 0),  "Zeke is the owner of the scimitar shop in Al Kharid."),
		new CrypticClue("Guthix left his mark in a fiery lake, dig at the tip of it.", new WorldPoint(3069, 3935, 0), "Dig at the tip of the lava lake that is shaped like a Guthixian symbol, west of the Mage Arena."),
		new CrypticClue("Search the drawers in the upstairs of a house in Catherby.", DRAWERS_350, new WorldPoint(2809, 3451, 1), "Perdu's house in Catherby."),
		new CrypticClue("Search a crate in the Haymaker's arms.", CRATE_27532, new WorldPoint(1720, 3652, 1), "Search the crate in the north-east corner of The Haymaker's Arms tavern east of Kourend Castle."),
		new CrypticClue("Desert insects is what I see. Taking care of them was my responsibility. Your solution is found by digging near me.", new WorldPoint(3307, 9505, 0), "Dig next to the Entomologist, Kalphite area, near Shantay Pass."),
		new CrypticClue("Search the crates in the most north-western house in Al Kharid.", CRATE_358, new WorldPoint(3289, 3202, 0), "Search the crates in the house, marked with a icon, southeast of the gem stall."),
		new CrypticClue("You will have to fly high where a sword cannot help you.", null, "Kill an Aviansie."),
		new CrypticClue("A massive battle rages beneath so be careful when you dig by the large broken crossbow.", new WorldPoint(2927, 3761, 0), "NE of the God Wars Dungeon entrance, climb the rocky handholds & dig by large crossbow."),
		new CrypticClue("Mix yellow with blue and add heat, make sure you bring protection.", null, "Kill a green dragon."),
		new CrypticClue("Speak to Ellis in Al Kharid.", "Ellis", new WorldPoint(3276, 3191, 0), "Ellis is tanner just north of Al Kharid bank."),
		new CrypticClue("Search the chests in the Dwarven Mine.", CLOSED_CHEST_375, new WorldPoint(3000, 9798, 0), "The chest is on the western wall, where Hura's Crossbow Shop is, in the Dwarven Mine."),
		new CrypticClue("In a while...", null, "Kill a crocodile."),
		new CrypticClue("A chisel and hammer reside in his home, strange for one of magic. Impress him with your magical equipment.", "Wizard Cromperty", new WorldPoint(2682, 3325, 0), "Wizard Cromperty, NE corner of East Ardougne. +100 magic attack bonus needed"),
		new CrypticClue("You have all of the elements available to solve this clue. Fortunately you do not have to go as far as to stand in a draft.", CRATE_18506, new WorldPoint(2723, 9891, 0), "Search the crate, west of the Air Elementals, inside the Elemental Workshop."),
		new CrypticClue("A demon's best friend holds the next step of this clue.", null, "Kill a hellhound."),
		new CrypticClue("Dig in the centre of a great city of 5 districts.", new WorldPoint(1639, 3673, 0), "Dig in front of the large statue in the centre of Great Kourend."),
		new CrypticClue("Hopefully this set of armour will help you to keep surviving.", "Sir Vyvin", new WorldPoint(2982, 3336, 2), "Speak to Sir Vyvin while wearing a white platebody, and platelegs."),
		new CrypticClue("The beasts retreat, for their Queen is gone; the song of this town still plays on. Dig near the birthplace of a blade, be careful not to melt your spade.", new WorldPoint(2342, 3677, 0), "Dig in front of the small furnace in the Piscatoris Fishing Colony."),
		new CrypticClue("Darkness wanders around me, but fills my mind with knowledge.", "Biblia",  new WorldPoint(1633, 3825, 2), "Speak to Biblia on the Arceuus House Library's top floor."),
		new CrypticClue("I would make a chemistry joke, but I'm afraid I wouldn't get a reaction.", "Chemist", new WorldPoint(2932, 3212, 0), "Talk to the Chemist in Rimmington"),
		new CrypticClue("Show this to Hazelmere.",  "Hazelmere", new WorldPoint(2677, 3088, 1), "Hazelmere is found upstairs on the island located just east of Yanille."),
		new CrypticClue("Does one really need a fire to stay warm here?", new WorldPoint(3816, 3810, 0), "Dig next to the fire near the Volcanic Mine entrance."),
		new CrypticClue("Search the open crate found in a small farmhouse in Hosidius. Cabbages grow outside.", CRATE_27533, new WorldPoint(1687, 3628, 0), "The house is east of the Mess in Great Kourend."),
		new CrypticClue("Dig under Ithoi's cabin.", new WorldPoint(2529, 2838, 0), "Dig under Ithoi's cabin in the Corsair Cove."),
		new CrypticClue("Search the drawers, upstairs in the bank to the East of Varrock.", new WorldPoint(3250, 3420, 1), "Search the drawers upstairs in Varrock east bank"),
		new CrypticClue("Speak to Hazelmere.", "Hazelmere", new WorldPoint(2677, 3088, 1), "Located upstairs in the house to the north of fairy ring CLS. Answer: 6859")
	);

	private String text;
	private String npc;
	private int objectId;
	private WorldPoint location;
	private String solution;

	private CrypticClue(String text, WorldPoint location, String solution)
	{
		this(text, null, -1, location, solution);
	}

	private CrypticClue(String text, int objectId, WorldPoint location, String solution)
	{
		this(text, null, objectId, location, solution);
	}

	private CrypticClue(String text, String npc, WorldPoint location, String solution)
	{
		this(text, npc, -1, location, solution);
	}

	private CrypticClue(String text, String npc, int objectId, WorldPoint location, String solution)
	{
		this.text = text;
		this.npc = npc;
		this.objectId = objectId;
		this.location = location;
		this.solution = solution;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Cryptic Clue").build());

		if (getNpc() != null)
		{
			panelComponent.getChildren().add(LineComponent.builder().left("NPC:").build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(getNpc())
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
			.left(getSolution())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		// Mark dig location
		if (getLocation() != null && getNpc() == null && objectId == -1)
		{
			LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), getLocation());

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

	public static CrypticClue forText(String text)
	{
		for (CrypticClue clue : CLUES)
		{
			if (clue.text.equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		return null;
	}

	public int[] getObjectIds()
	{
		return new int[] {objectId};
	}

	public String[] getNpcs()
	{
		return new String[] {npc};
	}
}
