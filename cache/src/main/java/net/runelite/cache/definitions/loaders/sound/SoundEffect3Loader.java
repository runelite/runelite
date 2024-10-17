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
import net.runelite.cache.definitions.sound.SoundEffect3Definition;
import net.runelite.cache.io.InputStream;

public class SoundEffect3Loader
{
	private final SoundEffect2Loader se2Loader = new SoundEffect2Loader();

	public SoundEffect3Definition load(InputStream in, SoundEffect2Definition var2)
	{
		SoundEffect3Definition se = new SoundEffect3Definition();

		load(se, in, var2);

		return se;
	}

	private void load(SoundEffect3Definition se, InputStream var1, SoundEffect2Definition var2)
	{
		int var3 = var1.readUnsignedByte();
		se.field1155[0] = var3 >> 4;
		se.field1155[1] = var3 & 15;
		if (var3 != 0)
		{
			se.field1156[0] = var1.readUnsignedShort();
			se.field1156[1] = var1.readUnsignedShort();
			int var4 = var1.readUnsignedByte();

			int var5;
			int var6;
			for (var5 = 0; var5 < 2; ++var5)
			{
				for (var6 = 0; var6 < se.field1155[var5]; ++var6)
				{
					se.field1154[var5][0][var6] = var1.readUnsignedShort();
					se.field1159[var5][0][var6] = var1.readUnsignedShort();
				}
			}

			for (var5 = 0; var5 < 2; ++var5)
			{
				for (var6 = 0; var6 < se.field1155[var5]; ++var6)
				{
					if ((var4 & 1 << var5 * 4 << var6) != 0)
					{
						se.field1154[var5][1][var6] = var1.readUnsignedShort();
						se.field1159[var5][1][var6] = var1.readUnsignedShort();
					}
					else
					{
						se.field1154[var5][1][var6] = se.field1154[var5][0][var6];
						se.field1159[var5][1][var6] = se.field1159[var5][0][var6];
					}
				}
			}

			if (var4 != 0 || se.field1156[1] != se.field1156[0])
			{
				se2Loader.method1144(var2, var1);
			}
		}
		else
		{
			int[] var7 = se.field1156;
			se.field1156[1] = 0;
			var7[0] = 0;
		}
	}
}
