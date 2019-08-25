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

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.widgets.WidgetInfo;

@Getter(AccessLevel.PACKAGE)
enum WidgetOverride
{
	FIXED_CORNER_TOP_LEFT_2005(Skin.AROUND_2005, "1026", WidgetInfo.FIXED_VIEWPORT_COMBAT_TAB),
	FIXED_CORNER_TOP_RIGHT_2005(Skin.AROUND_2005, "1027", WidgetInfo.FIXED_VIEWPORT_MAGIC_TAB),
	FIXED_CORNER_BOTTOM_LEFT_2005(Skin.AROUND_2005, "1028", WidgetInfo.FIXED_VIEWPORT_CLAN_CHAT_TAB),
	FIXED_CORNER_BOTTOM_RIGHT_2005(Skin.AROUND_2005, "1029", WidgetInfo.FIXED_VIEWPORT_MUSIC_TAB),
	FIXED_TOP_LEFT_2005(Skin.AROUND_2005, "1030_top_left", WidgetInfo.FIXED_VIEWPORT_STATS_TAB, WidgetInfo.FIXED_VIEWPORT_QUESTS_TAB),
	FIXED_TOP_RIGHT_2005(Skin.AROUND_2005, "1030_top_right", WidgetInfo.FIXED_VIEWPORT_EQUIPMENT_TAB, WidgetInfo.FIXED_VIEWPORT_PRAYER_TAB),
	FIXED_TOP_MIDDLE_2005(Skin.AROUND_2005, "1030_top_middle", WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB),
	FIXED_BOTTOM_LEFT_2005(Skin.AROUND_2005, "1030_bottom_left", WidgetInfo.FIXED_VIEWPORT_FRIENDS_TAB, WidgetInfo.FIXED_VIEWPORT_IGNORES_TAB),
	FIXED_BOTTOM_RIGHT_2005(Skin.AROUND_2005, "1030_bottom_middle", WidgetInfo.FIXED_VIEWPORT_LOGOUT_TAB),
	FIXED_BOTTOM_MIDDLE_2005(Skin.AROUND_2005, "1030_bottom_right", WidgetInfo.FIXED_VIEWPORT_OPTIONS_TAB, WidgetInfo.FIXED_VIEWPORT_EMOTES_TAB);

	private Skin skin;
	private String name;
	private WidgetInfo[] widgetInfo;

	WidgetOverride(final Skin skin, final String name, final WidgetInfo... widgetInfo)
	{
		this.skin = skin;
		this.name = name;
		this.widgetInfo = widgetInfo;
	}
}