/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@AllArgsConstructor
@Getter
public enum FletchingAction implements SkillAction
{
	ARROW_SHAFT("Arrow shaft", 1, 0.33f, ItemID.ARROW_SHAFT),
	HEADLESS_ARROW("Headless arrow", 1, 1, ItemID.HEADLESS_ARROW),
	BRONZE_ARROW("Bronze arrow", 1, 1.3f, ItemID.BRONZE_ARROW),
	OGRE_ARROW("Ogre arrow", 5, 1, ItemID.OGRE_ARROW),
	SHORTBOW_U("Shortbow (u)", 5, 5, ItemID.SHORTBOW_U),
	SHORTBOW("Shortbow", 5, 5, ItemID.SHORTBOW),
	BRONZE_BOLTS("Bronze bolts", 9, 0.5f, ItemID.BRONZE_BOLTS),
	WOODEN_STOCK("Wooden stock", 9, 6, ItemID.WOODEN_STOCK),
	BRONZE_CROSSBOW_U("Bronze crossbow (u)", 9, 12, ItemID.BRONZE_CROSSBOW_U),
	BRONZE_CROSSBOW("Bronze crossbow", 9, 6, ItemID.BRONZE_CROSSBOW),
	BRONZE_DART("Bronze dart", 10, 1.8f, ItemID.BRONZE_DART),
	LONGBOW("Longbow", 10, 10, ItemID.LONGBOW),
	LONGBOW_U("Longbow (u)", 10, 10, ItemID.LONGBOW_U),
	OPAL_BOLTS("Opal bolts", 11, 1.6f, ItemID.OPAL_BOLTS),
	IRON_ARROW("Iron arrow", 15, 2.5f, ItemID.IRON_ARROW),
	OAK_SHORTBOW_U("Oak shortbow (u)", 20, 16.5f, ItemID.OAK_SHORTBOW_U),
	OAK_SHORTBOW("Oak shortbow", 20, 16.5f, ItemID.OAK_SHORTBOW),
	IRON_DART("Iron dart", 22, 3.8f, ItemID.IRON_DART),
	OAK_STOCK("Oak stock", 24, 16, ItemID.OAK_STOCK),
	BLURITE_CROSSBOW_U("Blurite crossbow (u)", 24, 32, ItemID.BLURITE_CROSSBOW_U),
	BLURITE_CROSSBOW("Blurite crossbow", 24, 16, ItemID.BLURITE_CROSSBOW),
	OAK_LONGBOW_U("Oak longbow (u)", 25, 25, ItemID.OAK_LONGBOW_U),
	OAK_LONGBOW("Oak longbow", 25, 25, ItemID.OAK_LONGBOW),
	OAK_SHIELD("Oak shield", 27, 50, ItemID.OAK_SHIELD),
	STEEL_ARROW("Steel arrow", 30, 5, ItemID.STEEL_ARROW),
	KEBBIT_BOLTS("Kebbit bolts", 32, 1, ItemID.KEBBIT_BOLTS),
	WILLOW_SHORTBOW_U("Willow shortbow (u)", 35, 33.3f, ItemID.WILLOW_SHORTBOW_U),
	WILLOW_SHORTBOW("Willow shortbow", 35, 33.3f, ItemID.WILLOW_SHORTBOW),
	STEEL_DART("Steel dart", 37, 7.5f, ItemID.STEEL_DART),
	IRON_BOLTS("Iron bolts", 39, 1.5f, ItemID.IRON_BOLTS),
	WILLOW_STOCK("Willow stock", 39, 22, ItemID.WILLOW_STOCK),
	IRON_CROSSBOW_U("Iron crossbow (u)", 39, 44, ItemID.IRON_CROSSBOW_U),
	IRON_CROSSBOW("Iron crossbow", 39, 22, ItemID.IRON_CROSSBOW),
	WILLOW_LONGBOW_U("Willow longbow (u)", 40, 41.5f, ItemID.WILLOW_LONGBOW_U),
	WILLOW_LONGBOW("Willow longbow", 40, 41.5f, ItemID.WILLOW_LONGBOW),
	BATTLESTAFF("Battlestaff", 40, 80, ItemID.BATTLESTAFF),
	PEARL_BOLTS("Pearl bolts", 41, 3.2f, ItemID.PEARL_BOLTS),
	WILLOW_SHIELD("Willow shield", 42, 83, ItemID.WILLOW_SHIELD),
	LONG_KEBBIT_BOLTS("Long kebbit bolts", 42, 1.3f, ItemID.LONG_KEBBIT_BOLTS),
	SILVER_BOLTS("Silver bolts", 43, 2.5f, ItemID.SILVER_BOLTS),
	MITHRIL_ARROW("Mithril arrow", 45, 7.5f, ItemID.MITHRIL_ARROW),
	STEEL_BOLTS("Steel bolts", 46, 3.5f, ItemID.STEEL_BOLTS),
	TEAK_STOCK("Teak stock", 46, 27, ItemID.TEAK_STOCK),
	STEEL_CROSSBOW_U("Steel crossbow (u)", 46, 54, ItemID.STEEL_CROSSBOW_U),
	STEEL_CROSSBOW("Steel crossbow", 46, 27, ItemID.STEEL_CROSSBOW),
	MAPLE_SHORTBOW_U("Maple shortbow (u)", 50, 50, ItemID.MAPLE_SHORTBOW_U),
	MAPLE_SHORTBOW("Maple shortbow", 50, 50, ItemID.MAPLE_SHORTBOW),
	BARBED_BOLTS("Barbed bolts", 51, 9.5f, ItemID.BARBED_BOLTS),
	MITHRIL_DART("Mithril dart", 52, 11.2f, ItemID.MITHRIL_DART),
	BROAD_ARROWS("Broad arrows", 52, 10, ItemID.BROAD_ARROWS),
	TOXIC_BLOWPIPE("Toxic blowpipe", 53, 120, ItemID.TOXIC_BLOWPIPE),
	MITH_CROSSBOW("Mith crossbow", 54, 32, ItemID.MITHRIL_CROSSBOW),
	MAPLE_STOCK("Maple stock", 54, 32, ItemID.MAPLE_STOCK),
	MITHRIL_BOLTS("Mithril bolts", 54, 5, ItemID.MITHRIL_BOLTS),
	MITHRIL_CROSSBOW_U("Mithril crossbow (u)", 54, 64f, ItemID.MITHRIL_CROSSBOW_U),
	MAPLE_LONGBOW_U("Maple longbow (u)", 55, 58.3f, ItemID.MAPLE_LONGBOW_U),
	BROAD_BOLTS("Broad bolts", 55, 3, ItemID.BROAD_BOLTS),
	MAPLE_LONGBOW("Maple longbow", 55, 58, ItemID.MAPLE_LONGBOW),
	SAPPHIRE_BOLTS("Sapphire bolts", 56, 4.7f, ItemID.SAPPHIRE_BOLTS),
	MAPLE_SHIELD("Maple shield", 57, 116.5f, ItemID.MAPLE_SHIELD),
	EMERALD_BOLTS("Emerald bolts", 58, 5.5f, ItemID.EMERALD_BOLTS),
	ADAMANT_ARROW("Adamant arrow", 60, 10, ItemID.ADAMANT_ARROW),
	ADAMANT_BOLTS("Adamant bolts", 61, 7, ItemID.ADAMANT_BOLTS),
	MAHOGANY_STOCK("Mahogany stock", 61, 41, ItemID.MAHOGANY_STOCK),
	ADAMANT_CROSSBOW_U("Adamant crossbow (u)", 61, 82, ItemID.ADAMANT_CROSSBOW_U),
	ADAMANT_CROSSBOW("Adamant crossbow", 61, 41, ItemID.ADAMANT_CROSSBOW),
	RUBY_BOLTS("Ruby bolts", 63, 6.3f, ItemID.RUBY_BOLTS),
	DIAMOND_BOLTS("Diamond bolts", 65, 7, ItemID.DIAMOND_BOLTS),
	YEW_SHORTBOW("Yew shortbow", 65, 67.5f, ItemID.YEW_SHORTBOW),
	YEW_SHORTBOW_U("Yew shortbow (u)", 65, 67.5f, ItemID.YEW_SHORTBOW_U),
	ADAMANT_DART("Adamant dart", 67, 15, ItemID.ADAMANT_DART),
	RUNITE_CROSSBOW_U("Runite crossbow (u)", 69, 100, ItemID.RUNITE_CROSSBOW_U),
	RUNE_CROSSBOW("Rune crossbow", 69, 50, ItemID.RUNE_CROSSBOW),
	YEW_STOCK("Yew stock", 69, 50, ItemID.YEW_STOCK),
	RUNITE_BOLTS("Runite bolts", 69, 10, ItemID.RUNITE_BOLTS),
	YEW_LONGBOW("Yew longbow", 70, 75, ItemID.YEW_LONGBOW),
	YEW_LONGBOW_U("Yew longbow (u)", 70, 75, ItemID.YEW_LONGBOW_U),
	DRAGONSTONE_BOLTS("Dragonstone bolts", 71, 8.2f, ItemID.DRAGONSTONE_BOLTS),
	YEW_SHIELD("Yew shield", 72, 150, ItemID.YEW_SHIELD),
	ONYX_BOLTS("Onyx bolts", 73, 9.4f, ItemID.ONYX_BOLTS),
	RUNE_ARROW("Rune arrow", 75, 12.5f, ItemID.RUNE_ARROW),
	AMETHYST_BROAD_BOLTS("Amethyst broad bolts", 76, 10.6f, ItemID.AMETHYST_BROAD_BOLTS),
	MAGIC_STOCK("Magic stock", 78, 70, ItemID.MAGIC_STOCK),
	DRAGON_CROSSBOW_U("Dragon crossbow (u)", 78, 135, ItemID.DRAGON_CROSSBOW_U),
	DRAGON_CROSSBOW("Dragon crossbow", 78, 70, ItemID.DRAGON_CROSSBOW),
	MAGIC_SHORTBOW("Magic shortbow", 80, 83.3f, ItemID.MAGIC_SHORTBOW),
	MAGIC_SHORTBOW_U("Magic shortbow (u)", 80, 83.3f, ItemID.MAGIC_SHORTBOW_U),
	RUNE_DART("Rune dart", 81, 18.8f, ItemID.RUNE_DART),
	AMETHYST_ARROW("Amethyst arrow", 82, 13.5f, ItemID.AMETHYST_ARROW),
	DRAGON_BOLTS("Dragon bolts", 84, 12, ItemID.DRAGON_BOLTS_UNF),
	AMETHYST_JAVELIN("Amethyst javelin", 84, 13.5f, ItemID.AMETHYST_JAVELIN),
	MAGIC_LONGBOW("Magic longbow", 85, 91.5f, ItemID.MAGIC_LONGBOW),
	MAGIC_LONGBOW_U("Magic longbow (u)", 85, 91.5f, ItemID.MAGIC_LONGBOW_U),
	MAGIC_SHIELD("Magic shield", 87, 183, ItemID.MAGIC_SHIELD),
	AMETHYST_DART("Amethyst dart", 90, 21, ItemID.AMETHYST_DART),
	DRAGON_ARROW("Dragon arrow", 90, 15, ItemID.DRAGON_ARROW),
	REDWOOD_SHIELD("Redwood shield", 92, 216, ItemID.REDWOOD_SHIELD),
	DRAGON_DART("Dragon dart", 95, 25, ItemID.DRAGON_DART),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;
}
