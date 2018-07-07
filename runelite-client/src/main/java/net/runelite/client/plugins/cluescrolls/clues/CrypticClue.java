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
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.ObjectComposition;
import static net.runelite.api.ObjectID.*;
import static net.runelite.api.NullObjectID.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollPlugin.CLUE_SCROLL_IMAGE;
import static net.runelite.client.plugins.cluescrolls.ClueScrollPlugin.SPADE_IMAGE;
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
	private static final Set<CrypticClue> CLUES = ImmutableSet.of(
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2733, 3415, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3045, 3256, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3068, 3516, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3444, 3461, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_357, new WorldPoint(2636, 3453, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3242, 3207, 0), "It's coming home"),
		new CrypticClue("It's coming home", BUCKET_9568, new WorldPoint(3013, 3179, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_5107, new WorldPoint(3187, 9825, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2689, 3550, 0), "It's coming home"),
		new CrypticClue("It's coming home", BOOKCASE_12539, new WorldPoint(3113, 3159, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2527, 3891, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2490, 3488, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2799, 3438, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3038, 3292, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_25775, new WorldPoint(2699, 3470, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3211, 3219, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2759, 3497, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2745, 3151, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_354, new WorldPoint(2614, 3204, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3376, 3284, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", DRAWERS, new WorldPoint(2611, 3324, 1), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3499, 3503, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2598, 3267, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_24344, new WorldPoint(3498, 3507, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2042, 4630, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_366, new WorldPoint(2660, 3149, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3226, 3399, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2846, 1749, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_355, new WorldPoint(2617, 3347, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(1697, 3574, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_354, new WorldPoint(2913, 3536, 0), "It's coming home"),
		new CrypticClue("It's coming home", CLOSED_CHEST_375, new WorldPoint(3016, 3205, 1), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3410, 3324, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", 375, new WorldPoint(3353, 3332, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_5618, new WorldPoint(3213, 3216, 1), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3089, 3468, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATES_24088, new WorldPoint(3029, 3355, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3146, 9913, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_11485, new WorldPoint(3106, 3369, 2), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_5107, new WorldPoint(3226, 3452, 0), "It's coming home"),
		new CrypticClue("It's coming home", STONES_26633, new WorldPoint(2922, 3484, 0), "It's coming home"),
		new CrypticClue("It's coming home", BOXES_5111, new WorldPoint(3203, 3384, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_354, new WorldPoint(3478, 3091, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3026, 3216, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3081, 3421, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3079, 3493, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3098, 3258, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3211, 3219, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_24344, new WorldPoint(3509, 3497, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_357, new WorldPoint(3035, 9849, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_357, new WorldPoint(2612, 3304, 1), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3488, 3289, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3174, 3663, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3143, 3445, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2204, 3050, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2860, 3431, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3040, 3399, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2979, 3435, 0), "It's coming home"),
		new CrypticClue("It's coming home", WARDROBE_5622, new WorldPoint(3087, 3261, 0), "It's coming home"),
		new CrypticClue("It's coming home", NULL_1293, new WorldPoint(2544, 3170, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2845, 3539, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", 375, new WorldPoint(2593, 3108, 1), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", DRAWERS_350, new WorldPoint(3116, 9562, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_26635, new WorldPoint(2707, 3488, 2), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3026, 3378, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home" , CLOSED_CHEST_5108, new WorldPoint(3256, 3487, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2979, 3340, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2832, 9586, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_5113, new WorldPoint(3224, 3492, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2591, 3879, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2743, 3578, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATES_11600, new WorldPoint(3073, 3430, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATES_24088, new WorldPoint(2955, 3390, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_356, new WorldPoint(2800, 3074, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_18889, new WorldPoint(3289, 3022, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3195, 3357, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", 348, new WorldPoint(2574, 3326, 1), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_12963, new WorldPoint(3166, 3309, 2), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_352, new WorldPoint(2970, 3214, 1), "It's coming home"),
		new CrypticClue("It's coming home", BOOKCASE_380, new WorldPoint(3096, 9572, 0), "It's coming home"),
		new CrypticClue("It's coming home", HAYSTACK, new WorldPoint(2672, 3416, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_357, new WorldPoint(3228, 3212, 1), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2476, 3428, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3371, 9320, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3170, 3885, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2780, 3783, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3046, 3382, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2570, 3250, 0), "It's coming home"),
		new CrypticClue("It's coming home", BOXES, new WorldPoint(2523, 3493, 1), "It's coming home"),
		new CrypticClue("It's coming home", COFFIN, new WorldPoint(3091, 3477, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_350, new WorldPoint(2818, 3351, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_357, new WorldPoint(2598, 3105, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2736, 3578, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3191, 9825, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2791, 3183, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2779, 3211, 0), "It's coming home"),
		new CrypticClue("It's coming home", BOXES_6176, new WorldPoint(2576, 3464, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3164, 9913, 0), "It's coming home"),
		new CrypticClue("It's coming home", BOOKCASE_380, new WorldPoint(2703, 3409, 1), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_9534, new WorldPoint(3012, 3222, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2924, 3405, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3547, 3183, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(1934, 4427, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3049, 4839, 0), "It's coming home"),
		new CrypticClue("It's coming home", BOXES, new WorldPoint(3245, 3245, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2867, 3546, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2205, 3252, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2983, 3338, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3221, 3435, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2898, 3428, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2884, 3450, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3014, 3222, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS, new WorldPoint(2969, 3311, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2945, 3379, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3362, 3341, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2957, 3511, 0), "It's coming home"),
		new CrypticClue("It's coming home", BUSH_2357, new WorldPoint(3345, 3378, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3360, 3242, 0), "It's coming home"),
		new CrypticClue("It's coming home", MINE_CART_6045, new WorldPoint(3041, 9820, 0), "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", CRATE_357, new WorldPoint(2576, 9583, 0), "It's coming home"),
		new CrypticClue("It's coming home", BOOKCASE_380, new WorldPoint(3054, 3484, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3205, 3474, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_25766, new WorldPoint(2716, 3471, 1), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2336, 3799, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2803, 3430, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2951, 3451, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3388, 3152, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2608, 3116, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_18204, new WorldPoint(2764, 3273, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_354, new WorldPoint(3178, 2987, 0), "It's coming home"),
		new CrypticClue("It's coming home", BOOKCASE_394, new WorldPoint(2833, 2992, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2635, 3310, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3103, 3163, 2), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3085, 3255, 0), "It's coming home"),
		new CrypticClue("It's coming home", CLOSED_CHEST_375, new WorldPoint(3085, 3429, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_357, new WorldPoint(2914, 3433, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2488, 3409, 1), "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", CLOSED_CHEST_375, new WorldPoint(3041, 3364, 1), "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", BOOKCASE_9523, new WorldPoint(3146, 3177, 0), "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3043, 4974, 1), "It's coming home"),
		new CrypticClue("It's coming home",  "It's coming home", new WorldPoint(1310, 1251, 0), "It's coming home"),
		new CrypticClue("It's coming home", BOXES_361, new WorldPoint(3308, 3206, 0), "It's coming home"),
		new CrypticClue("It's coming home",  "It's coming home", new WorldPoint(3186, 3936, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_352, new WorldPoint(2657, 3322, 1), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3058, 3487, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS, new WorldPoint(2971, 3386, 1), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", DRAWERS_350 , new WorldPoint(2512, 3641, 1), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2458, 3504, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3297, 3890, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_7194, new WorldPoint(3206, 3419, 1), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_7194, new WorldPoint(3156, 3406, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(1756, 4940, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3045, 10265, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3161, 9904, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3203, 3424, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2386, 3487, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_356, new WorldPoint(2671, 3437, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS, new WorldPoint(3024, 3259, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2759, 2775, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3194, 3403, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3673, 3492, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_357, new WorldPoint(3219, 9617, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_350, new WorldPoint(2894, 3418, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3058, 3487, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3221, 3219, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", CLOSED_CHEST_375, new WorldPoint(2288, 4702, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(1910, 4367, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(1646, 3631, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3252, 9517, 2), "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3139, 4554, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2975, 3383, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3055, 10338, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2410, 4714, 0), "It's coming home"),
		new CrypticClue("It's coming home", BOXES_3686, new WorldPoint(2885, 3540, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(1863, 4639, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2638, 2656, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2523, 3739, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_350, new WorldPoint(2570, 3085, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS, new WorldPoint(2929, 3570, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3260, 3385, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_356, new WorldPoint(2645, 3338, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", DRAWERS_350, new WorldPoint(2921, 3577, 0), "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(1486, 3834, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2874, 3757, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3494, 3474, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_350, new WorldPoint(3035, 3347, 1), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS, new WorldPoint(2574, 3326, 1), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2744, 5116, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_350, new WorldPoint(3097, 3277, 0), "It's coming home"),
		new CrypticClue("It's coming home", BOXES_360, new WorldPoint(2886, 3449, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2914, 5300, 1), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", 348, new WorldPoint(2809, 3165, 1), "It's coming home"),
		new CrypticClue("It's coming home", CLOSED_CHEST_375, new WorldPoint(3209, 3218, 1), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3232, 3228, 0), "It's coming home"),
		new CrypticClue("It's coming home", CLOSED_CHEST_375, new WorldPoint(3301, 3169, 1), "It's coming home"),
		new CrypticClue("It's coming home", BOXES_361, new WorldPoint(2654, 3299, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2945, 3335, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_350, new WorldPoint(1742, 3490, 1), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_350, new WorldPoint(2825, 3442, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3019, 3232, 0), "It's coming home"),
		new CrypticClue("It's coming home", CLOSED_CHEST_25592, new WorldPoint(2748, 3495, 2), "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3042, 3236, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2857, 2966, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2977, 3343, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(1836, 3786, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", DRAWERS_25766, new WorldPoint(2709, 3478, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3356, 3507, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_357, new WorldPoint(2615, 3291, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2671, 10396, 0), "It's coming home"),
		new CrypticClue("It's coming home", WHEELBARROW_9625, new WorldPoint(2978, 3239, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3088, 3357, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3059, 3486, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_5106, new WorldPoint(3228, 3433, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2878, 3546, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(1633, 3808, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3287, 3190, 0),  "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3069, 3935, 0), "It's coming home"),
		new CrypticClue("It's coming home", DRAWERS_350, new WorldPoint(2809, 3451, 1), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_27532, new WorldPoint(1720, 3652, 1), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3307, 9505, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_358, new WorldPoint(3289, 3202, 0), "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2927, 3761, 0), "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(3276, 3191, 0), "It's coming home"),
		new CrypticClue("It's coming home", CLOSED_CHEST_375, new WorldPoint(3000, 9798, 0), "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2682, 3325, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_18506, new WorldPoint(2723, 9891, 0), "It's coming home"),
		new CrypticClue("It's coming home", null, "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(1639, 3673, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2982, 3336, 2), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2342, 3677, 0), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home",  new WorldPoint(1633, 3825, 2), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2932, 3212, 0), "It's coming home"),
		new CrypticClue("It's coming home",  "It's coming home", new WorldPoint(2677, 3088, 1), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3816, 3810, 0), "It's coming home"),
		new CrypticClue("It's coming home", CRATE_27533, new WorldPoint(1687, 3628, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(2529, 2838, 0), "It's coming home"),
		new CrypticClue("It's coming home", new WorldPoint(3250, 3420, 1), "It's coming home"),
		new CrypticClue("It's coming home", "It's coming home", new WorldPoint(2677, 3088, 1), "It's coming home")
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
		panelComponent.getChildren().add(TitleComponent.builder().text("It's coming home").build());
		panelComponent.getChildren().add(LineComponent.builder().left("It's coming home").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getText())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		if (getNpc() != null)
		{
			panelComponent.getChildren().add(LineComponent.builder().left("It's coming home").build());
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
				panelComponent.getChildren().add(LineComponent.builder().left("It's coming home").build());
				panelComponent.getChildren().add(LineComponent.builder()
					.left(object.getName())
					.leftColor(TITLED_CONTENT_COLOR)
					.build());
			}
		}

		panelComponent.getChildren().add(LineComponent.builder().left("It's coming home").build());
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
				OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, SPADE_IMAGE, Color.ORANGE);
			}
		}

		// Mark NPC
		if (plugin.getNpcsToMark() != null)
		{
			for (NPC npc : plugin.getNpcsToMark())
			{
				OverlayUtil.renderActorOverlayImage(graphics, npc, CLUE_SCROLL_IMAGE, Color.ORANGE, IMAGE_Z_OFFSET);
			}
		}

		// Mark game object
		if (objectId != -1)
		{
			net.runelite.api.Point mousePosition = plugin.getClient().getMouseCanvasPosition();

			if (plugin.getObjectsToMark() != null)
			{
				for (GameObject gameObject : plugin.getObjectsToMark())
				{
					OverlayUtil.renderHoverableArea(graphics, gameObject.getClickbox(), mousePosition,
							CLICKBOX_FILL_COLOR, CLICKBOX_BORDER_COLOR, CLICKBOX_HOVER_BORDER_COLOR);

					OverlayUtil.renderImageLocation(plugin.getClient(), graphics, gameObject.getLocalLocation(), CLUE_SCROLL_IMAGE, IMAGE_Z_OFFSET);
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
}
