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
package net.runelite.cache.item;

import net.runelite.cache.definitions.TextureDefinition;
import net.runelite.cache.definitions.providers.SpriteProvider;
import net.runelite.cache.definitions.providers.TextureProvider;

public class RSTextureProvider
{
	private final SpriteProvider spriteProvider;
	TextureDefinition[] textures;
	int maxSize;
	int size;
	double brightness;
	int width;

	public RSTextureProvider(TextureProvider textureProvider, SpriteProvider spriteProvider)
	{
		this.spriteProvider = spriteProvider;
		this.size = 0;
		this.brightness = 1.0D;
		this.width = 128;
		this.maxSize = 20;
		this.size = this.maxSize;
		this.brightness = 0.8D;
		this.width = 128;

		int max = -1;
		for (TextureDefinition textureDefinition : textureProvider.provide())
		{
			if (textureDefinition.getId() > max)
			{
				max = textureDefinition.getId();
			}
		}

		textures = new TextureDefinition[max + 1];
		for (TextureDefinition textureDefinition : textureProvider.provide())
		{
			textures[textureDefinition.getId()] = textureDefinition;
		}
	}

	public int[] load(int var1)
	{
		TextureDefinition var2 = this.textures[var1];
		if (var2 != null)
		{
			if (var2.pixels != null)
			{
				return var2.pixels;
			}

			boolean var3 = var2.method2680(this.brightness, this.width, spriteProvider);
			return var2.pixels;
		}

		return null;
	}


	public int getAverageTextureRGB(int var1)
	{
		return this.textures[var1] != null ? this.textures[var1].field1777 : 0;
	}


	public boolean vmethod3057(int var1)
	{
		return this.textures[var1].field1778;
	}


	public boolean vmethod3066(int var1)
	{
		return this.width == 64;
	}
}
