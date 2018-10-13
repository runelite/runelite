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

import java.awt.Polygon;
import java.awt.geom.Area;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.Angle;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSGameObject;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSRenderable;

@Mixin(RSGameObject.class)
public abstract class RSGameObjectMixin implements RSGameObject
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	@Override
	public Point getSceneMinLocation()
	{
		return new Point(getRelativeX(), getRelativeY());
	}

	@Inject
	@Override
	public Point getSceneMaxLocation()
	{
		return new Point(getOffsetX(), getOffsetY());
	}

	@Inject
	private RSModel getModel()
	{
		RSRenderable renderable = getRenderable();
		if (renderable == null)
		{
			return null;
		}

		if (renderable instanceof RSModel)
		{
			return (RSModel) renderable;
		}
		else
		{
			return renderable.getModel();
		}
	}

	@Inject
	@Override
	public Area getClickbox()
	{
		return Perspective.getClickbox(client, getModel(), getRsOrientation(), getLocalLocation());
	}

	@Inject
	@Override
	public Polygon getConvexHull()
	{
		RSModel model = getModel();

		if (model == null)
		{
			return null;
		}

		return model.getConvexHull(getX(), getY(), getRsOrientation());
	}

	@Override
	@Inject
	public Angle getOrientation()
	{
		int orientation = getRsOrientation();
		int rotation = (getFlags() >> 6) & 3;
		return new Angle(rotation * 512 + orientation);
	}
}
