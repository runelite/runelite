/*
 * Copyright (c) 2025, Adam <Adam@sigterm.info>
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
package net.runelite.client.callback;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Renderable;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;

@Singleton
@Slf4j
public class RenderCallbackManager
{
	private final List<RenderCallback> callbacks = new CopyOnWriteArrayList<>();

	public void register(RenderCallback cb)
	{
		callbacks.add(cb);
	}

	public void unregister(RenderCallback cb)
	{
		callbacks.remove(cb);
	}

	public boolean addEntity(Renderable renderable, boolean ui)
	{
		if (callbacks.isEmpty())
		{
			return true;
		}

		for (var cb : callbacks)
		{
			try
			{
				if (!cb.addEntity(renderable, ui))
				{
					return false;
				}
			}
			catch (Exception ex)
			{
				log.error("exception in render callback", ex);
			}
		}

		return true;
	}

	public boolean drawTile(Scene scene, Tile tile)
	{
		if (callbacks.isEmpty())
		{
			return true;
		}

		for (var cb : callbacks)
		{
			try
			{
				if (!cb.drawTile(scene, tile))
				{
					return false;
				}
			}
			catch (Exception ex)
			{
				log.error("exception in render callback", ex);
			}
		}

		return true;
	}

	public boolean drawObject(Scene scene, TileObject object)
	{
		if (callbacks.isEmpty())
		{
			return true;
		}

		for (var cb : callbacks)
		{
			try
			{
				if (!cb.drawObject(scene, object))
				{
					return false;
				}
			}
			catch (Exception ex)
			{
				log.error("exception in render callback", ex);
			}
		}

		return true;
	}
}
