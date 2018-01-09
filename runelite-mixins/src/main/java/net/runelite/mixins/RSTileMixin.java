/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

import net.runelite.api.GameObject;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.events.GameObjectsChanged;
import static net.runelite.client.callback.Hooks.eventBus;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSTile;

@Mixin(RSTile.class)
public abstract class RSTileMixin implements RSTile
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	@Override
	public Point getWorldLocation()
	{
		Point regionLocation = getRegionLocation();
		return Perspective.regionToWorld(client, regionLocation);
	}

	@Inject
	@Override
	public Point getRegionLocation()
	{
		return new Point(getX(), getY());
	}

	@Inject
	@Override
	public Point getLocalLocation()
	{
		Point regionLocation = getRegionLocation();
		return Perspective.regionToLocal(client, regionLocation);
	}

	@FieldHook("objects")
	@Inject
	public void animationChanged(int idx)
	{
		if (idx != -1) // this happens from the field assignment
		{
			// GameObject that was changed.
			GameObject go = getGameObjects()[idx];
			if (go != null)
			{
				GameObjectsChanged gameObjectsChanged = new GameObjectsChanged();
				gameObjectsChanged.setGameObject(go);
				eventBus.post(gameObjectsChanged);
			}
		}
	}
}
