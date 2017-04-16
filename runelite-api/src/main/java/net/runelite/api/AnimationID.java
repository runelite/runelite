/*
 * Copyright (c) 2016-2017, Abel Briggs
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
package net.runelite.api;

// Note: This class is not complete: these animations were manually gathered
// through getAnimation(). Please add animations as you happen to use them.
public final class AnimationID
{
	public static final int IDLE = -1;
	public static final int WOODCUTTING = 879;
	public static final int CONSUMING = 829; // consuming consumables
	public static final int FIREMAKING = 733;
	public static final int COOKING_FIRE = 897;
	public static final int COOKING_RANGE = 896;
	public static final int FLETCHING_BOW_CUTTING = 1248;
	public static final int FLETCHING_BOW_STRINGING = 6684;
	public static final int CRAFTING_GEM_CUTTING = 888;
	public static final int CRAFTING_LEATHER = 1249;
	public static final int SMITHING_SMELTING = 899;
	public static final int SMITHING_CANNONBALL = 827; //cball smithing uses this and SMITHING_SMELTING
	public static final int SMITHING_ANVIL = 898;
	public static final int FISHING_NET = 621;
	public static final int FISHING_POLE_INITIAL = 622; //initial swing of pole
	public static final int FISHING_POLE_CAST = 623; // pole is in the water
	public static final int FISHING_CAGE = 619;
	public static final int FISHING_HARPOON = 618;
	public static final int MINING_NORMAL_VEIN_1 = 624;
	public static final int MINING_NORMAL_VEIN_2 = 625;
	public static final int MINING_MOTHERLODE_VEIN = 6752;
	public static final int HERBLORE_POTIONMAKING = 363; //used for both herb and secondary
	public static final int MAGIC_CHARGING_ORBS = 726;

}
