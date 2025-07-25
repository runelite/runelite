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
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;

@AllArgsConstructor
@Getter
public enum FletchingAction implements NamedSkillAction
{
	ARROW_SHAFT("Arrow shaft", 1, 0.33f, ItemID.ARROW_SHAFT),
	HEADLESS_ARROW("Headless arrow", 1, 1, ItemID.HEADLESS_ARROW),
	BRONZE_ARROW("Bronze arrow", 1, 1.3f, ItemID.BRONZE_ARROW),
	BRONZE_JAVELIN("Bronze javelin", 3, 1, ItemID.BRONZE_JAVELIN),
	OGRE_ARROW("Ogre arrow", 5, 1, ItemID.OGRE_ARROW),
	SHORTBOW("Shortbow", 5, 5, ItemID.SHORTBOW),
	SHORTBOW_U("Shortbow (u)", 5, 5, ItemID.UNSTRUNG_SHORTBOW),
	BRONZE_BOLTS("Bronze bolts", 9, 0.5f, ItemID.BOLT),
	BRONZE_CROSSBOW("Bronze crossbow", 9, 6, ItemID.XBOWS_CROSSBOW_BRONZE),
	WOODEN_STOCK("Wooden stock", 9, 6, ItemID.XBOWS_CROSSBOW_STOCK_WOOD),
	BRONZE_CROSSBOW_U("Bronze crossbow (u)", 9, 12, ItemID.XBOWS_CROSSBOW_UNSTRUNG_BRONZE),
	BRONZE_DART("Bronze dart", 10, 1.8f, ItemID.BRONZE_DART),
	LONGBOW("Longbow", 10, 10, ItemID.LONGBOW),
	LONGBOW_U("Longbow (u)", 10, 10, ItemID.UNSTRUNG_LONGBOW),
	OPAL_BOLTS("Opal bolts", 11, 1.6f, ItemID.OPAL_BOLT),
	IRON_ARROW("Iron arrow", 15, 2.5f, ItemID.IRON_ARROW),
	IRON_JAVELIN("Iron javelin", 17, 2, ItemID.IRON_JAVELIN),
	OAK_SHORTBOW("Oak shortbow", 20, 16.5f, ItemID.OAK_SHORTBOW),
	OAK_SHORTBOW_U("Oak shortbow (u)", 20, 16.5f, ItemID.UNSTRUNG_OAK_SHORTBOW),
	OAK_VALE_TOTEM("Oak vale totem", 20, 255, ItemID.ENT_TOTEMS_LOOT),
	IRON_DART("Iron dart", 22, 3.8f, ItemID.IRON_DART),
	BLURITE_CROSSBOW("Blurite crossbow", 24, 16, ItemID.XBOWS_CROSSBOW_BLURITE),
	OAK_STOCK("Oak stock", 24, 16, ItemID.XBOWS_CROSSBOW_STOCK_OAK),
	BLURITE_CROSSBOW_U("Blurite crossbow (u)", 24, 32, ItemID.XBOWS_CROSSBOW_UNSTRUNG_BLURITE),
	OAK_LONGBOW("Oak longbow", 25, 25, ItemID.OAK_LONGBOW),
	OAK_LONGBOW_U("Oak longbow (u)", 25, 25, ItemID.UNSTRUNG_OAK_LONGBOW),
	OAK_SHIELD("Oak shield", 27, 50, ItemID.OAK_SHIELD),
	STEEL_ARROW("Steel arrow", 30, 5, ItemID.STEEL_ARROW),
	KEBBIT_BOLTS("Kebbit bolts", 32, 1, ItemID.HUNTINGBOW_BOLTS),
	STEEL_JAVELIN("Steel javelin", 32, 5, ItemID.STEEL_JAVELIN),
	WILLOW_SHORTBOW("Willow shortbow", 35, 33.3f, ItemID.WILLOW_SHORTBOW),
	WILLOW_SHORTBOW_U("Willow shortbow (u)", 35, 33.3f, ItemID.UNSTRUNG_WILLOW_SHORTBOW),
	WILLOW_VALE_TOTEM("Willow vale totem", 35, 628, ItemID.ENT_TOTEMS_LOOT),
	STEEL_DART("Steel dart", 37, 7.5f, ItemID.STEEL_DART),
	IRON_BOLTS("Iron bolts", 39, 1.5f, ItemID.XBOWS_CROSSBOW_BOLTS_IRON),
	IRON_CROSSBOW("Iron crossbow", 39, 22, ItemID.XBOWS_CROSSBOW_IRON),
	WILLOW_STOCK("Willow stock", 39, 22, ItemID.XBOWS_CROSSBOW_STOCK_WILLOW),
	IRON_CROSSBOW_U("Iron crossbow (u)", 39, 44, ItemID.XBOWS_CROSSBOW_UNSTRUNG_IRON),
	WILLOW_LONGBOW("Willow longbow", 40, 41.5f, ItemID.WILLOW_LONGBOW),
	WILLOW_LONGBOW_U("Willow longbow (u)", 40, 41.5f, ItemID.UNSTRUNG_WILLOW_LONGBOW),
	BATTLESTAFF("Battlestaff", 40, 80, ItemID.BATTLESTAFF),
	PEARL_BOLTS("Pearl bolts", 41, 3.2f, ItemID.PEARL_BOLT),
	LONG_KEBBIT_BOLTS("Long kebbit bolts", 42, 1.3f, ItemID.HUNTINGBOW_BIGBOLTS),
	WILLOW_SHIELD("Willow shield", 42, 83, ItemID.WILLOW_SHIELD),
	SILVER_BOLTS("Silver bolts", 43, 2.5f, ItemID.XBOWS_CROSSBOW_BOLTS_SILVER),
	MITHRIL_ARROW("Mithril arrow", 45, 7.5f, ItemID.MITHRIL_ARROW),
	STEEL_BOLTS("Steel bolts", 46, 3.5f, ItemID.XBOWS_CROSSBOW_BOLTS_STEEL),
	STEEL_CROSSBOW("Steel crossbow", 46, 27, ItemID.XBOWS_CROSSBOW_STEEL),
	TEAK_STOCK("Teak stock", 46, 27, ItemID.XBOWS_CROSSBOW_STOCK_TEAK),
	STEEL_CROSSBOW_U("Steel crossbow (u)", 46, 54, ItemID.XBOWS_CROSSBOW_UNSTRUNG_STEEL),
	MITHRIL_JAVELIN("Mithril javelin", 47, 8, ItemID.MITHRIL_JAVELIN),
	MAPLE_SHORTBOW("Maple shortbow", 50, 50, ItemID.MAPLE_SHORTBOW),
	MAPLE_SHORTBOW_U("Maple shortbow (u)", 50, 50, ItemID.UNSTRUNG_MAPLE_SHORTBOW),
	MAPLE_VALE_TOTEM("Maple vale totem", 50, 1008, ItemID.ENT_TOTEMS_LOOT),
	BARBED_BOLTS("Barbed bolts", 51, 9.5f, ItemID.BARBED_BOLT),
	BROAD_ARROWS("Broad arrows", 52, 10, ItemID.SLAYERGUIDE_BROAD_ARROWS),
	MITHRIL_DART("Mithril dart", 52, 11.2f, ItemID.MITHRIL_DART),
	MITHRIL_BOLTS("Mithril bolts", 54, 5, ItemID.XBOWS_CROSSBOW_BOLTS_MITHRIL),
	MAPLE_STOCK("Maple stock", 54, 32, ItemID.XBOWS_CROSSBOW_STOCK_MAPLE),
	MITHRIL_CROSSBOW("Mithril crossbow", 54, 32, ItemID.XBOWS_CROSSBOW_MITHRIL),
	MITHRIL_CROSSBOW_U("Mithril crossbow (u)", 54, 64, ItemID.XBOWS_CROSSBOW_UNSTRUNG_MITHRIL),
	BROAD_BOLTS("Broad bolts", 55, 3, ItemID.SLAYER_BROAD_BOLT),
	MAPLE_LONGBOW("Maple longbow", 55, 58.2f, ItemID.MAPLE_LONGBOW),
	MAPLE_LONGBOW_U("Maple longbow (u)", 55, 58.3f, ItemID.UNSTRUNG_MAPLE_LONGBOW),
	SAPPHIRE_BOLTS("Sapphire bolts", 56, 4.7f, ItemID.XBOWS_CROSSBOW_BOLTS_MITHRIL_TIPPED_SAPPHIRE),
	MAPLE_SHIELD("Maple shield", 57, 116.5f, ItemID.MAPLE_SHIELD),
	EMERALD_BOLTS("Emerald bolts", 58, 5.5f, ItemID.XBOWS_CROSSBOW_BOLTS_MITHRIL_TIPPED_EMERALD),
	HUNTERS_SPEAR("Hunters spear", 60, 9.5f, ItemID.HG_HUNTER_SPEAR),
	ADAMANT_ARROW("Adamant arrow", 60, 10, ItemID.ADAMANT_ARROW),
	ADAMANT_BOLTS("Adamant bolts", 61, 7, ItemID.XBOWS_CROSSBOW_BOLTS_ADAMANTITE),
	ADAMANT_CROSSBOW("Adamant crossbow", 61, 41, ItemID.XBOWS_CROSSBOW_ADAMANTITE),
	MAHOGANY_STOCK("Mahogany stock", 61, 41, ItemID.XBOWS_CROSSBOW_STOCK_MAHOGANY),
	ADAMANT_CROSSBOW_U("Adamant crossbow (u)", 61, 82, ItemID.XBOWS_CROSSBOW_UNSTRUNG_ADAMANTITE),
	ADAMANT_JAVELIN("Adamant javelin", 62, 10, ItemID.ADAMANT_JAVELIN),
	RUBY_BOLTS("Ruby bolts", 63, 6.3f, ItemID.XBOWS_CROSSBOW_BOLTS_ADAMANTITE_TIPPED_RUBY),
	DIAMOND_BOLTS("Diamond bolts", 65, 7, ItemID.XBOWS_CROSSBOW_BOLTS_ADAMANTITE_TIPPED_DIAMOND),
	YEW_SHORTBOW("Yew shortbow", 65, 67.5f, ItemID.YEW_SHORTBOW),
	YEW_SHORTBOW_U("Yew shortbow (u)", 65, 67.5f, ItemID.UNSTRUNG_YEW_SHORTBOW),
	YEW_VALE_TOTEM("Yew vale totem", 65, 1632, ItemID.ENT_TOTEMS_LOOT),
	ADAMANT_DART("Adamant dart", 67, 15, ItemID.ADAMANT_DART),
	RUNITE_BOLTS("Runite bolts", 69, 10, ItemID.XBOWS_CROSSBOW_BOLTS_RUNITE),
	RUNE_CROSSBOW("Rune crossbow", 69, 50, ItemID.XBOWS_CROSSBOW_RUNITE),
	YEW_STOCK("Yew stock", 69, 50, ItemID.XBOWS_CROSSBOW_STOCK_YEW),
	RUNITE_CROSSBOW_U("Runite crossbow (u)", 69, 100, ItemID.XBOWS_CROSSBOW_UNSTRUNG_RUNITE),
	YEW_LONGBOW("Yew longbow", 70, 75, ItemID.YEW_LONGBOW),
	YEW_LONGBOW_U("Yew longbow (u)", 70, 75, ItemID.UNSTRUNG_YEW_LONGBOW),
	DRAGONSTONE_BOLTS("Dragonstone bolts", 71, 8.2f, ItemID.XBOWS_CROSSBOW_BOLTS_RUNITE_TIPPED_DRAGONSTONE),
	YEW_SHIELD("Yew shield", 72, 150, ItemID.YEW_SHIELD),
	ONYX_BOLTS("Onyx bolts", 73, 9.4f, ItemID.XBOWS_CROSSBOW_BOLTS_RUNITE_TIPPED_ONYX),
	ATLATL_DART_TIPS("Atlatl dart tips", 74, 10, ItemID.ATLATL_DART_TIPS),
	HEADLESS_ATLATL_DART("Headless atlatl dart", 74, 20, ItemID.HEADLESS_ATLATL_DART),
	ATLATL_DART_SHAFT("Atlatl dart shaft", 74, 30, ItemID.ATLATL_DART_SHAFT),
	ATLATL_DART("Atlatl dart", 74, 190, ItemID.ATLATL_DART),
	RUNE_ARROW("Rune arrow", 75, 12.5f, ItemID.RUNE_ARROW),
	AMETHYST_BROAD_BOLTS("Amethyst broad bolts", 76, 10.6f, ItemID.SLAYER_BROAD_BOLT_AMETHYST),
	RUNE_JAVELIN("Rune javelin", 77, 12.4f, ItemID.RUNE_JAVELIN),
	DRAGON_CROSSBOW("Dragon crossbow", 78, 70, ItemID.XBOWS_CROSSBOW_DRAGON),
	MAGIC_STOCK("Magic stock", 78, 70, ItemID.XBOWS_CROSSBOW_STOCK_MAGIC),
	TOXIC_BLOWPIPE("Toxic blowpipe", 78, 120, ItemID.TOXIC_BLOWPIPE_LOADED),
	DRAGON_CROSSBOW_U("Dragon crossbow (u)", 78, 135, ItemID.XBOWS_CROSSBOW_UNSTRUNG_DRAGON),
	MAGIC_SHORTBOW("Magic shortbow", 80, 83.3f, ItemID.MAGIC_SHORTBOW),
	MAGIC_SHORTBOW_U("Magic shortbow (u)", 80, 83.3f, ItemID.UNSTRUNG_MAGIC_SHORTBOW),
	MAGIC_VALE_TOTEM("Magic vale totem", 80, 3104, ItemID.ENT_TOTEMS_LOOT),
	RUNE_DART("Rune dart", 81, 18.8f, ItemID.RUNE_DART),
	AMETHYST_ARROW("Amethyst arrow", 82, 13.5f, ItemID.AMETHYST_ARROW),
	DRAGON_BOLTS("Dragon bolts", 84, 12, ItemID.DRAGON_BOLTS_UNFEATHERED),
	AMETHYST_JAVELIN("Amethyst javelin", 84, 13.5f, ItemID.AMETHYST_JAVELIN),
	MAGIC_LONGBOW("Magic longbow", 85, 91.5f, ItemID.MAGIC_LONGBOW),
	MAGIC_LONGBOW_U("Magic longbow (u)", 85, 91.5f, ItemID.UNSTRUNG_MAGIC_LONGBOW),
	MAGIC_SHIELD("Magic shield", 87, 183, ItemID.MAGIC_SHIELD),
	REDWOOD_HIKING_STAFF("Redwood hiking staff", 90, 10.5f, ItemID.REDWOOD_HIKING_STAFF),
	DRAGON_ARROW("Dragon arrow", 90, 15, ItemID.DRAGON_ARROW),
	AMETHYST_DART("Amethyst dart", 90, 21, ItemID.AMETHYST_DART),
	REDWOOD_VALE_TOTEM("Redwood vale totem", 90, 3788, ItemID.ENT_TOTEMS_LOOT),
	DRAGON_JAVELIN("Dragon javelin", 92, 15, ItemID.DRAGON_JAVELIN),
	REDWOOD_SHIELD("Redwood shield", 92, 216, ItemID.REDWOOD_SHIELD),
	DRAGON_DART("Dragon dart", 95, 25, ItemID.DRAGON_DART),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;

	@Override
	public boolean isMembers(final ItemManager itemManager)
	{
		return true;
	}
}
