/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSTexture;

@Mixin(RSTexture.class)
public abstract class RSTextureMixin implements RSTexture
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private float rl$u;

	@Inject
	private float rl$v;

	@Copy("animate")
	public abstract void rs$animate(int diff);

	@Replace("animate")
	public void rl$animate(int diff)
	{
		// The client animates textures by cycling the backing pixels of the texture each fram
		// based on how long it was since the last tick. On GPU we let the plugin manage this
		// which will calculate uvs instead.
		if (!client.isGpu())
		{
			rs$animate(diff);
			return;
		}

		client.getDrawCallbacks().animate(this, diff);
	}

	@Inject
	@Override
	public float getU()
	{
		return rl$u;
	}

	@Inject
	@Override
	public void setU(float u)
	{
		this.rl$u = u;
	}

	@Inject
	@Override
	public float getV()
	{
		return rl$v;
	}

	@Inject
	@Override
	public void setV(float v)
	{
		this.rl$v = v;
	}
}
