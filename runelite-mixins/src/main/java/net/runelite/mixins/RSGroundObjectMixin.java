/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
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

import java.awt.geom.Area;
import net.runelite.api.Model;
import net.runelite.api.Perspective;
import net.runelite.api.Renderable;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSGroundObject;

@Mixin(RSGroundObject.class)
public abstract class RSGroundObjectMixin implements RSGroundObject
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	private int groundObjectPlane;

	@Inject
	@Override
	public int getPlane()
	{
		return groundObjectPlane;
	}

	@Inject
	@Override
	public void setPlane(int plane)
	{
		this.groundObjectPlane = plane;
	}

	@Inject
	private Model getModel()
	{
		Renderable renderable = getRenderable();
		if (renderable == null)
		{
			return null;
		}

		if (renderable instanceof Model)
		{
			return (Model) renderable;
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
		return Perspective.getClickbox(client, getModel(), 0, getLocalLocation());
	}
}
