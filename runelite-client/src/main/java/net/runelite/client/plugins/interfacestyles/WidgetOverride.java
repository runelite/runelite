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
enum WidgetOverride
{
	FIXED_CORNER_TOP_LEFT_2005(Skin.AROUND_2005, "1026", InterfaceID.Toplevel.STONE0),
	FIXED_CORNER_TOP_RIGHT_2005(Skin.AROUND_2005, "1027", InterfaceID.Toplevel.STONE6),
	FIXED_CORNER_BOTTOM_LEFT_2005(Skin.AROUND_2005, "1028", InterfaceID.Toplevel.STONE7),
	FIXED_CORNER_BOTTOM_RIGHT_2005(Skin.AROUND_2005, "1029", InterfaceID.Toplevel.STONE13),
	FIXED_TOP_LEFT_2005(Skin.AROUND_2005, "1030_top_left", InterfaceID.Toplevel.STONE1, InterfaceID.Toplevel.STONE2),
	FIXED_TOP_RIGHT_2005(Skin.AROUND_2005, "1030_top_right", InterfaceID.Toplevel.STONE4, InterfaceID.Toplevel.STONE5),
	FIXED_TOP_MIDDLE_2005(Skin.AROUND_2005, "1030_top_middle", InterfaceID.Toplevel.STONE3),
	FIXED_BOTTOM_LEFT_2005(Skin.AROUND_2005, "1030_bottom_left", InterfaceID.Toplevel.STONE9, InterfaceID.Toplevel.STONE8),
	FIXED_BOTTOM_RIGHT_2005(Skin.AROUND_2005, "1030_bottom_middle", InterfaceID.Toplevel.STONE10),
	FIXED_BOTTOM_MIDDLE_2005(Skin.AROUND_2005, "1030_bottom_right", InterfaceID.Toplevel.STONE11, InterfaceID.Toplevel.STONE12);

	private final Skin skin;
	private final String name;
	@Component
	private final int[] widgetInfo;

	WidgetOverride(Skin skin, String name, @Component int... widgetInfo)
	{
		this.skin = skin;
		this.name = name;
		this.widgetInfo = widgetInfo;
	}
}