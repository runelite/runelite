/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.mixins;

import java.util.HashMap;
import java.util.Map;
import net.runelite.api.SpritePixels;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSIndexDataBase;
import net.runelite.rs.api.RSSpritePixels;

@Mixin(RSClient.class)
public abstract class SpriteMixin implements RSClient
{
	@Inject
	private static final Map<Integer, SpritePixels> spriteOverrides = new HashMap<Integer, SpritePixels>();

	@Inject
	private static final Map<Integer, SpritePixels> widgetSpriteOverrides = new HashMap<Integer, SpritePixels>();

	@Inject
	@Override
	public Map<Integer, SpritePixels> getSpriteOverrides()
	{
		return spriteOverrides;
	}

	@Inject
	@Override
	public Map<Integer, SpritePixels> getWidgetSpriteOverrides()
	{
		return widgetSpriteOverrides;
	}

	@Copy("getSpriteAsSpritePixels")
	public static RSSpritePixels rs$loadSprite(RSIndexDataBase var0, int var1, int var2)
	{
		throw new RuntimeException();
	}

	@Replace("getSpriteAsSpritePixels")
	public static RSSpritePixels rl$loadSprite(RSIndexDataBase var0, int var1, int var2)
	{
		SpritePixels sprite = spriteOverrides.get(var1);

		if (sprite != null)
		{
			return (RSSpritePixels) sprite;
		}

		return rs$loadSprite(var0, var1, var2);
	}
}