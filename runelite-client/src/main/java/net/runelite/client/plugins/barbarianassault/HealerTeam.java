/*
 * Copyright (c) 2018, whartd <github.com/whartd>
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
package net.runelite.client.plugins.barbarianassault;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Point;
import net.runelite.api.widgets.WidgetInfo;

@Getter
@AllArgsConstructor
enum HealerTeam
{
	TEAMMATE1(WidgetInfo.BA_HEAL_TEAMMATE1, new Point(28, 2), 115),
	TEAMMATE2(WidgetInfo.BA_HEAL_TEAMMATE2, new Point(26, 2), 115),
	TEAMMATE3(WidgetInfo.BA_HEAL_TEAMMATE3, new Point(26, 2), 115),
	TEAMMATE4(WidgetInfo.BA_HEAL_TEAMMATE4, new Point(25, 2), 115);

	private WidgetInfo teammate;
	private Point offset;
	private int width;
}
