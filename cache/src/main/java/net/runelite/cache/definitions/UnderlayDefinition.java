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

@Data
public class UnderlayDefinition
{
	private int id;
	private int color;

	private transient int hue;
	private transient int saturation;
	private transient int lightness;
	private transient int hueMultiplier;

	public void calculateHsl()
	{
		int var1 = color;
		double var2 = (double) (var1 >> 16 & 255) / 256.0D;
		double var4 = (double) (var1 >> 8 & 255) / 256.0D;
		double var6 = (double) (var1 & 255) / 256.0D;
		double var8 = var2;
		if (var4 < var2)
		{
			var8 = var4;
		}

		if (var6 < var8)
		{
			var8 = var6;
		}

		double var10 = var2;
		if (var4 > var2)
		{
			var10 = var4;
		}

		if (var6 > var10)
		{
			var10 = var6;
		}

		double var12 = 0.0D;
		double var14 = 0.0D;
		double var16 = (var10 + var8) / 2.0D;
		if (var8 != var10)
		{
			if (var16 < 0.5D)
			{
				var14 = (var10 - var8) / (var8 + var10);
			}

			if (var16 >= 0.5D)
			{
				var14 = (var10 - var8) / (2.0D - var10 - var8);
			}

			if (var2 == var10)
			{
				var12 = (var4 - var6) / (var10 - var8);
			}
			else if (var10 == var4)
			{
				var12 = 2.0D + (var6 - var2) / (var10 - var8);
			}
			else if (var10 == var6)
			{
				var12 = 4.0D + (var2 - var4) / (var10 - var8);
			}
		}

		var12 /= 6.0D;
		this.saturation = (int) (var14 * 256.0D);
		this.lightness = (int) (var16 * 256.0D);
		if (this.saturation < 0)
		{
			this.saturation = 0;
		}
		else if (this.saturation > 255)
		{
			this.saturation = 255;
		}

		if (this.lightness < 0)
		{
			this.lightness = 0;
		}
		else if (this.lightness > 255)
		{
			this.lightness = 255;
		}

		if (var16 > 0.5D)
		{
			this.hueMultiplier = (int) (var14 * (1.0D - var16) * 512.0D);
		}
		else
		{
			this.hueMultiplier = (int) (var14 * var16 * 512.0D);
		}

		if (this.hueMultiplier < 1)
		{
			this.hueMultiplier = 1;
		}

		this.hue = (int) ((double) this.hueMultiplier * var12);
	}
}
