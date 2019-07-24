/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.plugins.timers;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;
import net.runelite.api.widgets.WidgetInfo;

enum TeleportWidget
{
	HOME_TELEPORT,
	MINIGAME_TELEPORT;

	private static final Collection HOME_TELEPORT_IDS = ImmutableList.of(
		WidgetInfo.SPELL_LUMBRIDGE_HOME_TELEPORT.getId(),
		WidgetInfo.SPELL_EDGEVILLE_HOME_TELEPORT.getId(),
		WidgetInfo.SPELL_LUNAR_HOME_TELEPORT.getId(),
		WidgetInfo.SPELL_ARCEUUS_HOME_TELEPORT.getId()
	);
	private static final Collection MINIGAME_TELEPORT_IDS = ImmutableList.of(
		WidgetInfo.MINIGAME_TELEPORT_BUTTON.getId()
	);

	@Nullable
	static TeleportWidget of(int widgetId)
	{
		if (HOME_TELEPORT_IDS.contains(widgetId))
		{
			return HOME_TELEPORT;
		}
		else if (MINIGAME_TELEPORT_IDS.contains(widgetId))
		{
			return MINIGAME_TELEPORT;
		}
		return null;
	}
}