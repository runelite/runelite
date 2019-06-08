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
package net.runelite.mixins;

import net.runelite.api.MenuAction;
import net.runelite.api.World;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.rs.api.RSClient;

@Mixin(RSClient.class)
public abstract class WorldHoppingMixin implements RSClient
{
	@Inject
	@Override
	public void openWorldHopper()
	{
		// The clicked x & y coordinates (the last arguments) are not processed in the game or sent to Jagex, so they don't have to be real.
		menuAction(-1, WidgetInfo.WORLD_SWITCHER_BUTTON.getId(), MenuAction.WIDGET_DEFAULT.getId(), 1, "World Switcher", "", 658, 384);
	}

	@Inject
	@Override
	public void hopToWorld(World world)
	{
		final int worldId = world.getId();
		menuAction(worldId, WidgetInfo.WORLD_SWITCHER_LIST.getId(), MenuAction.WIDGET_DEFAULT.getId(), 1, "Switch", "<col=ff9040>" + (worldId - 300) +  "</col>", 683, 244);
	}
}
