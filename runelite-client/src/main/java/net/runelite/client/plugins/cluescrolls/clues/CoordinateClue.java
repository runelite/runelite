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

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ItemID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.plugins.cluescrolls.clues.emote.ItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.emote.SingleItemRequirement;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;

@Getter
@AllArgsConstructor
@Slf4j
public class CoordinateClue extends ClueScroll implements TextClueScroll, LocationClueScroll
{
	public static final Map<WorldPoint, String> DESCRIPTIONS = new HashMap<WorldPoint, String>()
	{{
		// MEDIUM
		put(new WorldPoint(2479, 3158, 0), "West of the Tree Gnome Village, almost directly south of the fruit tree patch. On the east side of the river from the Observatory.");
		put(new WorldPoint(2887, 3154, 0), "On Karamja, west of the general store in the free-to-play section of the island, in the middle of the two small lakes.");
		put(new WorldPoint(2743, 3151, 0), "South-west of Brimhaven at the gold mine near the entrance to the Brimhaven Dungeon.");
		put(new WorldPoint(3184, 3150, 0), "South of the Water altar ruins.");
		put(new WorldPoint(3217, 3177, 0), "North-east of the Zanaris shed entrance located in the Lumbridge Swamp.");
		put(new WorldPoint(3007, 3144, 0), "South of Port Sarim, just south of the ladder to the Asgarnian Ice Dungeon, on the edge of the cliff. Close to fairy ring aiq.");
		put(new WorldPoint(2896, 3119, 0), "Across the water from Musa Point, on the western seaweed spawn next to the river. Use the gnome glider transport to Karamja.");
		put(new WorldPoint(2697, 3207, 0), "In the centre of Moss Giant Island west of Brimhaven. The island can be found by swinging on the rope swings west of Brimhaven.");
		put(new WorldPoint(2679, 3110, 0), "On the penisula to Hazelmere's house, directly east of Yanille. Use the fairy ring code cls and run north.");
		put(new WorldPoint(3510, 3074, 0), "Directly north of the teak tree south-east of Uzer.");
		put(new WorldPoint(3160, 3251, 0), "Just west of the trapdoor leading to the H.A.M. Hideout.");
		put(new WorldPoint(2643, 3252, 0), "South of Ardougne Zoo, on a small cape. Can be reached easily via djp next to the Tower of Life.");
		put(new WorldPoint(2322, 3061, 0), "Just south-west of Castle Wars, fairy ring code bkp.");
		put(new WorldPoint(2875, 3046, 0), "On Karamja, north of the nature altar.");
		put(new WorldPoint(2849, 3033, 0), "In the centre of the mine, north of Shilo Village. You can use fairy ring code ckr and run north.");
		put(new WorldPoint(2848, 3296, 0), "North side of Crandor.");
		put(new WorldPoint(2583, 2990, 0), "Feldip Hills, south-east of Gu'Tanoth and north of fairy ring code aks.");
		put(new WorldPoint(3179, 3344, 0), "Just south of the Champions' Guild, opposite side of the River Lum in Lumbridge");
		put(new WorldPoint(2383, 3370, 0), "Travel south-west of the Tree Gnome Stronghold, in the midst of three ponds.");
		put(new WorldPoint(3312, 3375, 0), "Dig on the hill north-west of the Exam Centre.");
		put(new WorldPoint(3121, 3384, 0), "Located at the north-east fence outside of Draynor Manor, on the southern side of the River Lum.");
		put(new WorldPoint(3430, 3388, 0), "In Mort Myre Swamp, north of the Nature Grotto. One can use fairy ring bkr and run south-west.");
		put(new WorldPoint(2920, 3403, 0), "South-east of Taverley, on the peninsula with the Lady of the Lake.");
		put(new WorldPoint(2594, 2899, 0), "South-east edge of Feldip Hills, by the crimson swifts. South-east of fairy ring aks.");
		put(new WorldPoint(2387, 3435, 0), "At Tree Gnome Stronghold, in the south-western section near a pen containing terrorbirds.");
		put(new WorldPoint(2512, 3467, 0), "Baxtorian Falls, board the log raft, use a rope with the rock to get to the second island with the dead tree.");
		put(new WorldPoint(2381, 3468, 0), "This is on the west side of the river in the Gnome Stronghold. Walk north of the terrorbird pen and dig right above the rock.");
		put(new WorldPoint(3005, 3475, 0), "Ice Mountain, located north of Barbarian Village.");
		put(new WorldPoint(2585, 3505, 0), "By the shore line north of the Coal Trucks.");
		put(new WorldPoint(3443, 3515, 0), "South of the big roots that are found east of the path to the Slayer Tower. North of the fairy ring code cks.");
		put(new WorldPoint(2416, 3516, 0), "In the swamp located in the north-west corner of the Tree Gnome Stronghold, west of the Grand Tree, directly south of the tortoise pen.");
		put(new WorldPoint(3429, 3523, 0), "On the path to the Slayer Tower, just before the entrance. Easily reached by teleporting with fairy ring code cks.");
		put(new WorldPoint(2363, 3531, 0), "North-east of Eagles' Peak. Dig on the eastern side of the fence just slightly south of the coniferous tree. Easily reached by teleporting with the fairy rings with code akq.");
		put(new WorldPoint(2919, 3535, 0), "Immediately north of a table in Burthorpe located east of the pub and west of Turael's house.");
		put(new WorldPoint(3548, 3560, 0), "In the castle grounds of Fenkenstrain's Castle in Morytania.");
		put(new WorldPoint(1456, 3620, 0), "Dig in the graveyard just east of the hill giants west of the Shayzien bank. Easily reached by teleporting with the fairy rings with code djr.");
		put(new WorldPoint(2735, 3638, 0), "Two paces west of the Swaying tree, located east of Rellekka. Easily reached by using the fairy ring code ajr.");
		put(new WorldPoint(2681, 3653, 0), "In Pontak's garden in south-eastern Rellekka, between the cabbages and the potatoes. Easily reached by teleporting with the lyre or Fremennik sea boots.");
		put(new WorldPoint(2537, 3881, 0), "At the end of the path leading to the mining area on Miscellania. Accessible via fairy ring code cip or teleporting with the Ring of wealth.");
		// HARD
		put(new WorldPoint(2209, 3161, 0), "In Tirannwn, dig by the western spawn point of the roving elves south-east of the catapult, near the Tyras Camp.");
		put(new WorldPoint(2181, 3206, 0), "In the hunter area directly south of the Elf Camp, past a stick trap, dig by the north-east edge of the pond.");
		put(new WorldPoint(3081, 3209, 0), "Located on a small island that can only be accessed via fairy ring code clp.");
		put(new WorldPoint(3374, 3250, 0), "Duel Arena in combat area. You will need to duel another player to get to this spot. Make sure that the Obstacles option is on.");
		put(new WorldPoint(2699, 3251, 0), "Little island, fairy ring code air.");
		put(new WorldPoint(3546, 3251, 0), "North-east of Burgh de Rott, south of the Barrows.");
		put(new WorldPoint(3544, 3256, 0), "North-east of Burgh de Rott, south of the Barrows.");
		put(new WorldPoint(2841, 3267, 0), "Crandor, centre of the island.");
		put(new WorldPoint(3168, 3041, 0), "In the Bedabin Camp in the Kharidian Desert, just south-west of the Shantay Pass.");
		put(new WorldPoint(2542, 3031, 0), "In Gu'Tanoth. You need 20gp to pay the guard to cross the bridge.");
		put(new WorldPoint(2581, 3030, 0), "On the island where Gorad is located. At the south-western side of Gu'Tanoth is a cave; enter this cave, and you will end up on the island.");
		put(new WorldPoint(2961, 3024, 0), "Outside the east wall of the Ship yard building with G.L.O. Caranock, use the gnome glider and dig directly by the window.");
		put(new WorldPoint(2339, 3311, 0), "Located near the Red spiders' eggs on the Arandar mountain pass leading to Tirannwn.");
		put(new WorldPoint(3440, 3341, 0), "In Mort Myre Swamp, over Nature Spirit's grotto. Near fairy ring bip.");
		put(new WorldPoint(2763, 2974, 0), "On Cairn Isle, Karamja. South-west of fairy ring ckr.");
		put(new WorldPoint(3138, 2969, 0), "West of the Bandit Camp in the Kharidian Desert, at the small peninsula.");
		put(new WorldPoint(2924, 2963, 0), "On the southern part of eastern Karamja, just north of some stepping stones across a waterfall.");
		put(new WorldPoint(2838, 2914, 0), "In the middle of the Kharazi Jungle, next to the water pool.");
		put(new WorldPoint(3441, 3419, 0), "Mort Myre swamp, south-west of fairy ring code bkr.");
		put(new WorldPoint(2950, 2902, 0), "South-east of the easternmost mahogany tree in the Kharazi Jungle.");
		put(new WorldPoint(2775, 2891, 0), "In the south-west peninsula of the Kharazi Jungle on Karamja.");
		put(new WorldPoint(3113, 3602, 0), "Just north of the Edgeville level 11 Wilderness, near horseshoe-shaped mushroom patch.");
		put(new WorldPoint(2892, 3675, 0), "On the summit of Trollheim, near the entrance to Eadgar's cave.");
		put(new WorldPoint(3168, 3677, 0), "In the Graveyard of Shadows in the Wilderness.");
		put(new WorldPoint(2853, 3690, 0), "At the entrance to the Troll Stronghold, next to the sleeping troll called Mushroom.");
		put(new WorldPoint(3305, 3692, 0), "In level 22 Wilderness, past the Black Salamanders.");
		put(new WorldPoint(3055, 3696, 0), "In the northern section of the Bandit Camp in level 23 Wilderness.");
		put(new WorldPoint(3302, 3696, 0), "In the black salamander hunting area in the level 23 Wilderness.");
		put(new WorldPoint(1479, 3696, 0), "In the west end of the Lizardman Canyon between Lovakengj and Shayzien. Entering the Canyon requires 5% Shayzien favour. Use fairy ring code djr to get there quickly.");
		put(new WorldPoint(2712, 3732, 0), "North-east of Rellekka, immediately east of Larry and his boat, north of the rock crabs, and north-west of fairy ring code dks.");
		put(new WorldPoint(2970, 3749, 0), "In the south-west section of the Forgotten Cemetery in level 29 Wilderness.");
		put(new WorldPoint(3094, 3764, 0), "In the Bandit camp mining site in level 31 Wilderness.");
		put(new WorldPoint(3311, 3769, 0), "In level 32 Wilderness, north of Venenatis. Dig in the area wherein there are several Black Knights.");
		put(new WorldPoint(1460, 3782, 0), "In Lovakengj, dig south of the burning man located south-east of the lovakite mine.");
		put(new WorldPoint(3244, 3792, 0), "In level 35 Wilderness just a little south-east of the Lava Dragon Isle by some Chaos dwarves.");
		put(new WorldPoint(3140, 3804, 0), "In level 36 Wilderness, just north of a pond by some moss giants.");
		put(new WorldPoint(2946, 3819, 0), "North-west of The Forgotten Cemetery, at level 38 Wilderness, south of the Chaos Altar.");
		put(new WorldPoint(3771, 3825, 0), "On Fossil Island, east of the Museum Camp.");
		put(new WorldPoint(3013, 3846, 0), "Level 41 Wilderness, in the area with the lesser demons, west of the Lava Maze.");
		put(new WorldPoint(3058, 3884, 0), "In the Wilderness near the two runite rocks located north of the Lava Maze.");
		put(new WorldPoint(3290, 3889, 0), "In the Demonic Ruins in level 44 Wilderness.");
		put(new WorldPoint(3770, 3897, 0), "Small island located north of Fossil island. Only reachable via the rowboat found in the north-east corner of the Mushroom Forest. Select 'Row to Sea'.");
		put(new WorldPoint(2505, 3899, 0), "Small island filled with penguins located north of Miscellania. Only reachable via fairy ring code ajs.");
		put(new WorldPoint(3285, 3942, 0), "In the northern area of the Rogues' Castle in the Wilderness. ");
		put(new WorldPoint(3159, 3959, 0), "North of the Deserted Keep in the Wilderness. This area can be reached via the teleport lever.");
		put(new WorldPoint(3039, 3960, 0), "One step north and then one step west of the northern door of the Pirates' Hideout in the Wilderness.");
		put(new WorldPoint(2987, 3963, 0), "North-west of the Wilderness Agility Course in level 56 Wilderness.");
		put(new WorldPoint(3189, 3963, 0), "Immediately north of the magic axe hut, which is located north-east of the Deserted Keep in the Wilderness.");
		// ELITE
		put(new WorldPoint(2357, 3151, 0), "Flax field south of the Lletya bank.");
		put(new WorldPoint(3587, 3180, 0), "Beneath the western wall of Meiyerditch.");
		put(new WorldPoint(2820, 3078, 0), "Inside the Hardwood Grove at Tai Bwo Wannai. You will need 100 trading sticks for this.");
		put(new WorldPoint(3811, 3060, 0), "Small island located north-east of Mos Le'Harmless, accessible through the western staircase located at the north-east corner of the Mos Le'Harmless Caves.");
		put(new WorldPoint(2180, 3282, 0), "North-west of Elf Camp near some rabbits. East of Shark fishing spot.");
		put(new WorldPoint(2870, 2997, 0), "North-east Shilo Village, dig in the centre of the bamboo pillars.");
		put(new WorldPoint(3302, 2988, 0), "On top of a cliff to the west of Pollnivneach.");
		put(new WorldPoint(2511, 2980, 0), "Just south of Gu'Tanoth, west of Gnormadium Avlafrim's gnome glider.");
		put(new WorldPoint(2732, 3372, 0), "Outside the Legends' Guild, north of the fountain.");
		put(new WorldPoint(3573, 3425, 0), "North of Dessous's tomb from Desert Treasure.");
		put(new WorldPoint(3828, 2848, 0), "East side of Harmony Island.");
		put(new WorldPoint(3225, 2838, 0), "South of the Desert Treasure pyramid.");
		put(new WorldPoint(1773, 3510, 0), "Between the magic trees north of Logava Gricoller's Cooking Supplies.");
		put(new WorldPoint(3822, 3562, 0), "Dig south-east of the evergreen tree on the northeastern portion of Dragontooth Island. ");
		put(new WorldPoint(3603, 3564, 0), "Dig on the rocks, north of the wrecked ship, outside of Port Phasmatys.");
		put(new WorldPoint(2936, 2721, 0), "Eastern shore of Crash Island, visited during the Monkey Madness I quest.");
		put(new WorldPoint(2697, 2705, 0), "Dig on top of the starfish on the south-westernmost shore of Ape Atoll.");
		put(new WorldPoint(2778, 3678, 0), "By the lake north of the Mountain Camp in the Fremennik Province.");
		put(new WorldPoint(2827, 3740, 0), "West of the entrance to the Ice Path, where the Troll child resides.");
		put(new WorldPoint(2359, 3799, 0), "At the very southeastern part of Neitiznot. Dig 4 spaces west of the ladder.");
		put(new WorldPoint(2194, 3807, 0), "In the southwestern area of the Pirates' Cove, near the windswept tree.");
		put(new WorldPoint(2700, 3808, 0), "In the northwestern part of the Trollweiss and Rellekka Hunter area. The fairy ring code dks can be used to teleport nearby.");
		put(new WorldPoint(3215, 3835, 0), "Level 40 Wilderness, in the Lava Dragon Isle.");
		put(new WorldPoint(3369, 3894, 0), "At the Fountain of Rune in the north-eastern Wilderness, in the small 'C' shaped wall.");
		put(new WorldPoint(2065, 3923, 0), "Outside the western wall on Lunar Isle.");
		put(new WorldPoint(3188, 3933, 0), "Inside the Wilderness Resource Area. Requires 7,500 coins to enter.");
		put(new WorldPoint(2997, 3953, 0), "In the Wilderness Agility Course in level 55 Wilderness.");
		put(new WorldPoint(3380, 3963, 0), "On the peninsula in the north-easternmost corner of the Wilderness, north of the Wilderness Volcano.");
		// MASTER
		put(new WorldPoint(2178, 3209, 0), "In the hunter area directly south of the Elf Camp, past a stick trap.");
		put(new WorldPoint(2155, 3100, 0), "South of Port Tyras, easily accessible by charter ship or fairy ring code bjs (requires 76 Agility).");
		put(new WorldPoint(2217, 3092, 0), "Fairy ring dlr at the Poison Waste.");
		put(new WorldPoint(3830, 3060, 0), "Small island located north-east of Mos Le'Harmless, accessible through the eastern staircase located at the north-east corner of the Mos Le'Harmless Caves.");
		put(new WorldPoint(2834, 3271, 0), "Crandor, centre of the island.");
		put(new WorldPoint(2732, 3284, 0), "Witchaven, east from the chapel.");
		put(new WorldPoint(3622, 3320, 0), "Located outside the entrance to the Meiyerditch Mine. ");
		put(new WorldPoint(2303, 3328, 0), "East of the eastern entrance to Prifddinas.");
		put(new WorldPoint(3570, 3405, 0), "The graveyard where players fight Dessous during Desert Treasure.");
		put(new WorldPoint(2840, 3423, 0), "Next to the ladder on the Water Obelisk Island.");
		put(new WorldPoint(3604, 3564, 0), "Dig on the rocks, north of the wrecked ship, outside of Port Phasmatys.");
		put(new WorldPoint(3085, 3569, 0), "By the Obelisk of Air in the Wilderness. Must be accessed through the Edgeville Dungeon.");
		put(new WorldPoint(2934, 2727, 0), "Eastern shore of Crash Island.");
		put(new WorldPoint(1451, 3695, 0), "By the lizardman shaman area west of Lizardman Canyon.");
		put(new WorldPoint(2538, 3739, 0), "On top of Waterbirth Island. Must be accessed through the dungeon. A pet rock/another player and a rune thrownaxe are required to reach the island's summit.");
		put(new WorldPoint(1248, 3751, 0), "In the north wing of the Farming Guild.");
		put(new WorldPoint(1698, 3792, 0), "In the crypt of the Arceuus church. To reach the crypt, head to the church and climb up the stairs, and then, climb down the stairs that follow.");
		put(new WorldPoint(2951, 3820, 0), "North-west of The Forgotten Cemetery, at level 38 Wilderness, inside the Chaos Temple.");
		put(new WorldPoint(2202, 3825, 0), "Pirates' Cove");
		put(new WorldPoint(1761, 3853, 0), "In the Arceuus essence mine. Easily reached with the fairy ring code cis.");
		put(new WorldPoint(2090, 3863, 0), "On Lunar Isle, dig on the island west of the astral altar.");
		put(new WorldPoint(1442, 3878, 0), "Northern area of the sulphur mine in Lovakengj.");
		put(new WorldPoint(3380, 3929, 0), "Wilderness Volcano at level 51 Wilderness.");
		put(new WorldPoint(3188, 3939, 0), "Inside the Wilderness Resource Area, near the anvil. Requires 7,500 coins to enter.");
		put(new WorldPoint(3304, 3941, 0), "Outside Rogues' Castle, north of the Wilderness Obelisk.");
		put(new WorldPoint(2994, 3961, 0), "Inside the Wilderness Agility course, just south of the lava hop.");
	}};

	private String text;
	private WorldPoint location;
	private static final ItemRequirement HAS_SPADE = new SingleItemRequirement(ItemID.SPADE);
	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Coordinate Clue").build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Click the clue scroll along the edge of your world map to see where you should dig.")
			.build());

		String description = DESCRIPTIONS.get(location);
		if (description != null)
		{
			panelComponent.getChildren().add(LineComponent.builder().left("Location:").build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(description)
				.leftColor(TITLED_CONTENT_COLOR)
				.build());
		}

		if (plugin.getInventoryItems() != null)
		{
			if (!HAS_SPADE.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("").build());
				panelComponent.getChildren().add(LineComponent.builder().left("Requires Spade!").leftColor(Color.RED).build());
			}
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), getLocation());

		if (localLocation == null)
		{
			return;
		}

		OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
	}
}
