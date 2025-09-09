/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.interfacestyles;

import lombok.Getter;
import net.runelite.api.annotations.Component;
import net.runelite.api.gameval.InterfaceID;

@Getter
enum WidgetOffset
{
	RESIZABLE_2010_COMBAT_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE0, -4, 1, null, null),
	RESIZABLE_2010_COMBAT_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON0, 5, null, null, null),
	RESIZABLE_2010_STATS_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE1, 35, 1, null, null),
	RESIZABLE_2010_STATS_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON1, 35, null, null, null),
	RESIZABLE_2010_QUESTS_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE2, 69, 1, 33, null),
	RESIZABLE_2010_QUESTS_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON2, 70, 1, 33, null),
	RESIZABLE_2010_INVENTORY_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE3, 103, 1, null, null),
	RESIZABLE_2010_INVENTORY_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON3, null, null, null, null),
	RESIZABLE_2010_EQUIPMENT_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON4, null, 3, null, null),
	RESIZABLE_2010_EQUIPMENT_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE4, null, 1, null, null),
	RESIZABLE_2010_PRAYER_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE5, 171, 1, null, null),
	RESIZABLE_2010_PRAYER_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON5, 172, 1, null, null),
	RESIZABLE_2010_MAGIC_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE6, 205, 1, null, null),
	RESIZABLE_2010_MAGIC_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON6, 206, null, null, null),
	RESIZABLE_2010_FRENDS_CHAT_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE7, -4, 1, null, null),
	RESIZABLE_2010_FRIENDS_CHAT_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON7, 2, 1, null, null),
	RESIZABLE_2010_FRIENDS_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE9, 35, 1, null, null),
	RESIZABLE_2010_FRIENDS_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON9, 37, 1, null, null),
	RESIZABLE_2010_IGNORES_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE8, 69, 1, null, null),
	RESIZABLE_2010_IGNORES_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON8, 71, null, null, null),
	RESIZABLE_2010_LOGOUT_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE10, 103, 1, null, null),
	RESIZABLE_2010_LOGOUT_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON10, 104, 2, null, null),
	RESIZABLE_2010_OPTIONS_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE11, null, 1, null, null),
	RESIZABLE_2010_OPTIONS_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON11, 138, null, null, null),
	RESIZABLE_2010_EMOTES_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE12, 171, 1, null, null),
	RESIZABLE_2010_EMOTES_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON12, 172, 2, null, null),
	RESIZABLE_2010_MUSIC_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.STONE13, 205, 1, null, null),
	RESIZABLE_2010_MUSIC_ICON(Skin.AROUND_2010, InterfaceID.ToplevelOsrsStretch.ICON13, 204, 3, null, null),

	RESIZABLE_BOTTOM_2010_COMBAT_ICON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.ICON0, 2, null, null, null),
	RESIZABLE_BOTTOM_2010_STATS_ICON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.ICON1, 32, null, null, null),
	RESIZABLE_BOTTOM_2010_QUESTS_ICON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.ICON2, null, 1, null, null),
	RESIZABLE_BOTTOM_2010_EQUIPMENT_ICON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.ICON4, 132, 3, null, null),
	RESIZABLE_BOTTOM_2010_PRAYERS_ICON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.ICON5, 165, 1, null, null),
	RESIZABLE_BOTTOM_2010_LOGOUT_BUTTON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.STONE10, 185, null, null, null),
	RESIZABLE_BOTTOM_2010_MAGIC_ICON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.ICON6, null, 2, null, null),
	RESIZABLE_BOTTOM_2010_FRIEND_ICON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.ICON9, null, 3, null, null),
	RESIZABLE_BOTTOM_2010_FRIEND_CHAT_ICON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.ICON7, null, 2, null, null),
	RESIZABLE_BOTTOM_2010_OPTIONS_ICON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.ICON11, null, 2, null, null),
	RESIZABLE_BOTTOM_2010_EMOTES_ICON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.ICON12, null, 3, null, null),
	RESIZABLE_BOTTOM_2010_MUSIC_ICON(Skin.AROUND_2010, InterfaceID.ToplevelPreEoc.ICON13, null, 3, null, null),

	FIXED_2010_COMBAT_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE0, 2, 1, null, null),
	FIXED_2010_COMBAT_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON0, 11, null, null, null),
	FIXED_2010_STATS_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE1, 41, 1, null, null),
	FIXED_2010_STATS_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON1, 41, null, null, null),
	FIXED_2010_QUESTS_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE2, 75, 1, 33, null),
	FIXED_2010_QUESTS_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON2, 75, null, null, null),
	FIXED_2010_INVENTORY_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE3, 109, 1, null, null),
	FIXED_2010_INVENTORY_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON3, 111, -1, null, null),
	FIXED_2010_EQUIPMENT_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON4, 143, 2, null, null),
	FIXED_2010_PRAYER_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE5, 177, 1, null, null),
	FIXED_2010_PRAYER_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON5, 178, 1, null, null),
	FIXED_2010_MAGIC_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE6, 211, 1, null, null),
	FIXED_2010_MAGIC_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON6, 212, 1, null, null),
	FIXED_2010_FRIENDS_CHAT_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE7, null, 1, null, null),
	FIXED_2010_FRIENDS_CHAT_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON7, 5, null, null, null),
	FIXED_2010_FRIENDS_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE9, 38, 1, 33, null),
	FIXED_2010_FRIENDS_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON9, 40, null, null, null),
	FIXED_2010_IGNORES_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE8, 72, 1, null, null),
	FIXED_2010_IGNORES_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON8, 74, null, null, null),
	FIXED_2010_LOGOUT_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE10, 106, 1, null, null),
	FIXED_2010_LOGOUT_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON10, 107, 2, null, null),
	FIXED_2010_OPTIONS_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE11, 140, 1, null, null),
	FIXED_2010_OPTIONS_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON11, 143, null, null, null),
	FIXED_2010_EMOTES_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE12, 174, 1, null, null),
	FIXED_2010_EMOTES_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON12, 177, 2, null, null),
	FIXED_2010_MUSIC_HIGHLIGHT(Skin.AROUND_2010, InterfaceID.Toplevel.STONE13, 208, 1, null, null),
	FIXED_2010_MUSIC_ICON(Skin.AROUND_2010, InterfaceID.Toplevel.ICON13, 209, 2, null, null),

	RESIZABLE_2005_QUESTS_ICON(Skin.AROUND_2005, InterfaceID.ToplevelOsrsStretch.ICON2, 71, -1, null, null),
	RESIZABLE_2005_LOGOUT_ICON(Skin.AROUND_2005, InterfaceID.ToplevelOsrsStretch.ICON10, null, null, null, null),
	RESIZABLE_2005_OPTIONS_ICON(Skin.AROUND_2005, InterfaceID.ToplevelOsrsStretch.ICON11, 137, null, null, null),
	RESIZABLE_2005_EMOTE_ICON(Skin.AROUND_2005, InterfaceID.ToplevelOsrsStretch.ICON12, 171, 2, null, null),
	RESIZABLE_2005_INVENTORY_ICON(Skin.AROUND_2005, InterfaceID.ToplevelOsrsStretch.ICON3, 103, 1, null, null),
	RESIZABLE_2005_EQUIPMENT_ICON(Skin.AROUND_2005, InterfaceID.ToplevelOsrsStretch.ICON4, 136, 3, null, null),
	RESIZABLE_2005_MUSIC_ICON(Skin.AROUND_2005, InterfaceID.ToplevelOsrsStretch.ICON13, null, 3, null, null),
	RESIZABLE_2005_PRAYER_ICON(Skin.AROUND_2005, InterfaceID.ToplevelOsrsStretch.ICON5, 169, -1, null, null),
	RESIZABLE_2005_STATS_ICON(Skin.AROUND_2005, InterfaceID.ToplevelOsrsStretch.ICON1, 37, null, null, null),
	RESIZABLE_2005_FRIENDS_ICON(Skin.AROUND_2005, InterfaceID.ToplevelOsrsStretch.ICON9, 38, null, null, null),

	RESIZABLE_BOTTOM_2005_INVENTORY_ICON(Skin.AROUND_2005, InterfaceID.ToplevelPreEoc.ICON3, 98, 1, null, null),
	RESIZABLE_BOTTOM_2005_QUESTS_ICON(Skin.AROUND_2005, InterfaceID.ToplevelPreEoc.ICON2, 66, -1, null, null),
	RESIZABLE_BOTTOM_2005_EQUIPMENT_ICON(Skin.AROUND_2005, InterfaceID.ToplevelPreEoc.ICON4, 131, 3, null, null),
	RESIZABLE_BOTTOM_2005_MUSIC_ICON(Skin.AROUND_2005, InterfaceID.ToplevelPreEoc.ICON13, null, 3, null, null),
	RESIZABLE_BOTTOM_2005_EMOTE_ICON(Skin.AROUND_2005, InterfaceID.ToplevelPreEoc.ICON12, 133, 1, null, null),
	RESIZABLE_BOTTOM_2005_STATS_ICON(Skin.AROUND_2005, InterfaceID.ToplevelPreEoc.ICON1, 32, null, null, null),
	RESIZABLE_BOTTOM_2005_PRAYER_ICON(Skin.AROUND_2005, InterfaceID.ToplevelPreEoc.ICON5, null, -1, null, null),
	RESIZABLE_BOTTOM_2005_COMBAT_ICON(Skin.AROUND_2005, InterfaceID.ToplevelPreEoc.ICON0, 1, -1, null, null),

	FIXED_2005_ROOT_INTERFACE_CONTAINER(Skin.AROUND_2005, InterfaceID.Toplevel.SIDE, null, null, 197, null),
	FIXED_2005_INTERFACE_CONTAINER(Skin.AROUND_2005, InterfaceID.Toplevel.SIDE_PANELS, 7, null, null, null),
	FIXED_2005_BANK_CONTAINER(Skin.AROUND_2005, InterfaceID.Toplevel.SIDEMODAL, 7, null, null, null),
	FIXED_2005_COMBAT_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE0, 22, 1, 34, 36),
	FIXED_2005_COMBAT_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON0, 28, 1, null, null),
	FIXED_2005_STATS_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE1, 54, null, 30, 37),
	FIXED_2005_STATS_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON1, 51, null, null, null),
	FIXED_2005_QUESTS_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE2, 82, null, 30, 37),
	FIXED_2005_QUESTS_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON2, 80, null, null, null),
	FIXED_2005_INVENTORY_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE3, null, null, 45, 35),
	FIXED_2005_INVENTORY_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON3, 113, 1, null, null),
	FIXED_2005_EQUIPMENT_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE4, 153, null, 30, 37),
	FIXED_2005_EQUIPMENT_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON4, 151, 4, null, null),
	FIXED_2005_PRAYER_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE5, 181, null, 30, 37),
	FIXED_2005_PRAYER_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON5, 179, null, null, null),
	FIXED_2005_MAGIC_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE6, 209, 1, 32, 36),
	FIXED_2005_MAGIC_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON6, 206, 3, null, null),
	FIXED_2005_FRIENDS_CHAT_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE7, 19, null, 34, 36),
	FIXED_2005_FRIENDS_CHAT_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON7, 22, null, null, null),
	FIXED_2005_FRIENDS_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE9, 51, null, 30, 37),
	FIXED_2005_FRIENDS_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON9, 49, -1, null, null),
	FIXED_2005_IGNORES_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE8, 79, null, 30, 37),
	FIXED_2005_IGNORES_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON8, 78, null, null, null),
	FIXED_2005_LOGOUT_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE10, 107, 2, 45, 35),
	FIXED_2005_LOGOUT_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON10, 112, null, null, null),
	FIXED_2005_OPTIONS_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE11, 150, null, 30, 37),
	FIXED_2005_OPTIONS_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON11, 148, -1, null, null),
	FIXED_2005_EMOTES_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE12, 178, null, 30, 37),
	FIXED_2005_EMOTES_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON12, 178, 1, null, null),
	FIXED_2005_MUSIC_HIGHLIGHT(Skin.AROUND_2005, InterfaceID.Toplevel.STONE13, 206, null, 33, 36),
	FIXED_2005_MUSIC_ICON(Skin.AROUND_2005, InterfaceID.Toplevel.ICON13, 202, 2, null, null),

	FIXED_2006_ROOT_INTERFACE_CONTAINER(Skin.AROUND_2006, InterfaceID.Toplevel.SIDE, null, null, 197, null),
	FIXED_2006_INTERFACE_CONTAINER(Skin.AROUND_2006, InterfaceID.Toplevel.SIDE_PANELS, 7, null, null, null),
	FIXED_2006_BANK_CONTAINER(Skin.AROUND_2006, InterfaceID.Toplevel.SIDEMODAL, 7, null, null, null),
	FIXED_2006_COMBAT_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE0, 22, 1, 34, 36),
	FIXED_2006_COMBAT_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON0, 26, 1, null, null),
	FIXED_2006_STATS_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE1, 54, null, 30, 37),
	FIXED_2006_STATS_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON1, 54, null, null, null),
	FIXED_2006_QUESTS_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE2, 82, null, 30, 37),
	FIXED_2006_QUESTS_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON2, 81, null, null, null),
	FIXED_2006_INVENTORY_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE3, null, null, 45, 35),
	FIXED_2006_INVENTORY_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON3, 114, 2, null, null),
	FIXED_2006_EQUIPMENT_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE4, 153, null, 30, 37),
	FIXED_2006_EQUIPMENT_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON4, 152, 2, null, null),
	FIXED_2006_PRAYER_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE5, 181, null, 30, 37),
	FIXED_2006_PRAYER_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON5, 180, 2, null, null),
	FIXED_2006_MAGIC_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE6, 209, 1, 32, 36),
	FIXED_2006_MAGIC_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON6, 207, 4, null, null),
	FIXED_2006_FRIENDS_CHAT_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE7, 19, null, 34, 36),
	FIXED_2006_FRIENDS_CHAT_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON7, 22, -1, null, null),
	FIXED_2006_FRIENDS_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE9, 51, null, 30, 37),
	FIXED_2006_FRIENDS_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON9, 49, 1, null, null),
	FIXED_2006_IGNORES_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE8, 79, null, 30, 37),
	FIXED_2006_IGNORES_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON8, 76, null, null, null),
	FIXED_2006_LOGOUT_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE10, 107, 2, 45, 35),
	FIXED_2006_LOGOUT_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON10, 113, 2, null, null),
	FIXED_2006_OPTIONS_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE11, 150, null, 30, 37),
	FIXED_2006_OPTIONS_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON11, 147, null, null, null),
	FIXED_2006_EMOTES_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE12, 178, null, 30, 37),
	FIXED_2006_EMOTES_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON12, 177, null, null, null),
	FIXED_2006_MUSIC_HIGHLIGHT(Skin.AROUND_2006, InterfaceID.Toplevel.STONE13, 206, null, 33, 36),
	FIXED_2006_MUSIC_ICON(Skin.AROUND_2006, InterfaceID.Toplevel.ICON13, 202, -1, null, null);

	private final Skin skin;
	@Component
	private final int component;
	private final Integer offsetX;
	private final Integer offsetY;
	private final Integer width;
	private final Integer height;

	WidgetOffset(Skin skin, @Component int component, Integer offsetX, Integer offsetY, Integer width, Integer height)
	{
		this.skin = skin;
		this.component = component;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.width = width;
		this.height = height;
	}
}
