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
package net.runelite.cache.definitions.sound;

public class SoundEffectTrackDefinition
{
	public int start;
	public InstrumentDefinition[] instruments = new InstrumentDefinition[10];
	public int end;

	public final byte[] mix()
	{
		int var2;
		int var1 = 0;

		for (var2 = 0; var2 < 10; ++var2)
		{
			if (this.instruments[var2] == null || this.instruments[var2].duration + this.instruments[var2].offset <= var1)
			{
				continue;
			}

			var1 = this.instruments[var2].duration + this.instruments[var2].offset;
		}

		if (var1 == 0)
		{
			return new byte[0];
		}

		var2 = var1 * 22050 / 1000;

		byte[] var3 = new byte[var2];

		for (int i = 0; i < 10; ++i)
		{
			if (this.instruments[i] == null)
			{
				continue;
			}

			int var5 = this.instruments[i].duration * 22050 / 1000;
			int var6 = this.instruments[i].offset * 22050 / 1000;

			int[] var7 = this.instruments[i].synthesize(var5, this.instruments[i].duration);

			for (int j = 0; j < var5; ++j)
			{
				int var9 = (var7[j] >> 8) + var3[j + var6];

				if ((var9 + 128 & -256) != 0)
				{
					var9 = var9 >> 31 ^ 127;
				}

				var3[j + var6] = (byte) var9;
			}
		}

		return var3;
	}
}