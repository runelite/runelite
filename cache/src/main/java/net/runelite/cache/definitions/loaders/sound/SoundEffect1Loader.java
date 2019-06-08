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

import net.runelite.cache.definitions.sound.SoundEffect1Definition;
import net.runelite.cache.definitions.sound.SoundEffect2Definition;
import net.runelite.cache.io.InputStream;

public class SoundEffect1Loader
{
	private final SoundEffect2Loader se2Loader = new SoundEffect2Loader();
	private final SoundEffect3Loader se3Loader = new SoundEffect3Loader();

	public SoundEffect1Definition load(InputStream in)
	{
		SoundEffect1Definition se = new SoundEffect1Definition();

		load(se, in);

		return se;
	}

	private void load(SoundEffect1Definition se, InputStream var1)
	{
		se.field1181 = se2Loader.load(var1);
		se.field1173 = se2Loader.load(var1);
		int var2 = var1.readUnsignedByte();
		if (var2 != 0)
		{
			var1.setOffset(var1.getOffset() - 1);
			se.field1174 = se2Loader.load(var1);
			se.field1193 = se2Loader.load(var1);
		}

		var2 = var1.readUnsignedByte();
		if (var2 != 0)
		{
			var1.setOffset(var1.getOffset() - 1);
			se.field1183 = se2Loader.load(var1);
			se.field1192 = se2Loader.load(var1);
		}

		var2 = var1.readUnsignedByte();
		if (var2 != 0)
		{
			var1.setOffset(var1.getOffset() - 1);
			se.field1178 = se2Loader.load(var1);
			se.field1175 = se2Loader.load(var1);
		}

		for (int var3 = 0; var3 < 10; ++var3)
		{
			int var4 = var1.readUnsignedShortSmart();
			if (var4 == 0)
			{
				break;
			}

			se.field1180[var3] = var4;
			se.field1179[var3] = var1.readShortSmart();
			se.field1177[var3] = var1.readUnsignedShortSmart();
		}

		se.field1187 = var1.readUnsignedShortSmart();
		se.field1184 = var1.readUnsignedShortSmart();
		se.field1176 = var1.readUnsignedShort();
		se.field1188 = var1.readUnsignedShort();
		se.field1186 = new SoundEffect2Definition();
		se.field1182 = se3Loader.load(var1, se.field1186);
	}
}
