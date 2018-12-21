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

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSSceneTilePaint;

@Mixin(RSSceneTilePaint.class)
public abstract class RSSceneTilePaintMixin implements RSSceneTilePaint
{
	@Inject
	private int rl$paintModelBufferOffset;

	@Inject
	private int rl$paintModelUvBufferOffset;

	@Inject
	private int rl$paintModelBufferLen;

	@Inject
	@Override
	public int getBufferOffset()
	{
		return rl$paintModelBufferOffset;
	}

	@Inject
	@Override
	public void setBufferOffset(int bufferOffset)
	{
		rl$paintModelBufferOffset = bufferOffset;
	}

	@Inject
	@Override
	public int getUvBufferOffset()
	{
		return rl$paintModelUvBufferOffset;
	}

	@Inject
	@Override
	public void setUvBufferOffset(int bufferOffset)
	{
		rl$paintModelUvBufferOffset = bufferOffset;
	}

	@Inject
	@Override
	public int getBufferLen()
	{
		return rl$paintModelBufferLen;
	}

	@Inject
	@Override
	public void setBufferLen(int bufferLen)
	{
		rl$paintModelBufferLen = bufferLen;
	}
}
