/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache.definitions.loaders.sound;

import net.runelite.cache.definitions.sound.SoundEffectDefinition;
import net.runelite.cache.definitions.sound.SoundEffect1Definition;
import net.runelite.cache.io.InputStream;

public class SoundEffectLoader
{
	public SoundEffectDefinition load(byte[] b)
	{
		SoundEffectDefinition se = new SoundEffectDefinition();
		InputStream in = new InputStream(b);

		load(se, in);

		return se;
	}

	private void load(SoundEffectDefinition se, InputStream var1)
	{
		for (int var2 = 0; var2 < 10; ++var2)
		{
			int var3 = var1.readUnsignedByte();
			if (var3 != 0)
			{
				var1.setOffset(var1.getOffset() - 1);

				SoundEffect1Loader se1Loader = new SoundEffect1Loader();
				SoundEffect1Definition se1 = se1Loader.load(var1);

				se.field1008[var2] = se1;
			}
		}

		se.field1006 = var1.readUnsignedShort();
		se.field1009 = var1.readUnsignedShort();
	}
}
