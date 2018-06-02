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

package net.runelite.cache.definitions;

import lombok.Data;
import net.runelite.cache.definitions.providers.SpriteProvider;

@Data
public class TextureDefinition
{
	public int field1777;
	public boolean field1778;
	private int id;
	private int[] fileIds;
	public int[] field1780;
	public int[] field1781;
	public int[] field1786;
	public int field1782;
	public int field1783;

	public transient int[] pixels;

	public boolean method2680(double var1, int var3, SpriteProvider spriteProvider)
	{
		int var5 = var3 * var3;
		this.pixels = new int[var5];

		for (int var6 = 0; var6 < this.fileIds.length; ++var6)
		{
			SpriteDefinition var7 = spriteProvider.provide(fileIds[var6], 0);
			var7.normalize();
			byte[] var8 = var7.pixelIdx;
			int[] var9 = var7.palette;
			int var10 = this.field1786[var6];

			int var11;
			int var12;
			int var13;
			int var14;
			if ((var10 & -16777216) == 50331648)
			{
				var11 = var10 & 16711935;
				var12 = var10 >> 8 & 255;

				for (var13 = 0; var13 < var9.length; ++var13)
				{
					var14 = var9[var13];
					if (var14 >> 8 == (var14 & 65535))
					{
						var14 &= 255;
						var9[var13] = var11 * var14 >> 8 & 16711935 | var12 * var14 & 65280;
					}
				}
			}

			for (var11 = 0; var11 < var9.length; ++var11)
			{
				var9[var11] = adjustRGB(var9[var11], var1);
			}

			if (var6 == 0)
			{
				var11 = 0;
			}
			else
			{
				var11 = this.field1780[var6 - 1];
			}

			if (var11 == 0)
			{
				if (var3 == var7.getMaxWidth())
				{
					for (var12 = 0; var12 < var5; ++var12)
					{
						this.pixels[var12] = var9[var8[var12] & 255];
					}
				}
				else if (var7.getMaxWidth() == 64 && var3 == 128)
				{
					var12 = 0;

					for (var13 = 0; var13 < var3; ++var13)
					{
						for (var14 = 0; var14 < var3; ++var14)
						{
							this.pixels[var12++] = var9[var8[(var13 >> 1 << 6) + (var14 >> 1)] & 255];
						}
					}
				}
				else
				{
					if (var7.getMaxWidth() != 128 || var3 != 64)
					{
						throw new RuntimeException();
					}

					var12 = 0;

					for (var13 = 0; var13 < var3; ++var13)
					{
						for (var14 = 0; var14 < var3; ++var14)
						{
							this.pixels[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
						}
					}
				}
			}
		}

		return true;
	}

	static int adjustRGB(int var0, double var1)
	{
		double var3 = (double) (var0 >> 16) / 256.0D;
		double var5 = (double) (var0 >> 8 & 255) / 256.0D;
		double var7 = (double) (var0 & 255) / 256.0D;
		var3 = Math.pow(var3, var1);
		var5 = Math.pow(var5, var1);
		var7 = Math.pow(var7, var1);
		int var9 = (int) (var3 * 256.0D);
		int var10 = (int) (var5 * 256.0D);
		int var11 = (int) (var7 * 256.0D);
		return var11 + (var10 << 8) + (var9 << 16);
	}
}
