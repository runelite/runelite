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

import net.runelite.cache.definitions.sound.SoundEffect2Definition;
import net.runelite.cache.io.InputStream;

public class SoundEffect2Loader
{
	public SoundEffect2Definition load(InputStream in)
	{
		SoundEffect2Definition se = new SoundEffect2Definition();

		load(se, in);

		return se;
	}

	private void load(SoundEffect2Definition se, InputStream var1)
	{
		se.field1087 = var1.readUnsignedByte();
		se.field1088 = var1.readInt();
		se.field1089 = var1.readInt();
		this.method1144(se, var1);
	}

	final void method1144(SoundEffect2Definition se, InputStream var1)
	{
		se.field1092 = var1.readUnsignedByte();
		se.field1086 = new int[se.field1092];
		se.field1090 = new int[se.field1092];

		for (int var2 = 0; var2 < se.field1092; ++var2)
		{
			se.field1086[var2] = var1.readUnsignedShort();
			se.field1090[var2] = var1.readUnsignedShort();
		}

	}
}
