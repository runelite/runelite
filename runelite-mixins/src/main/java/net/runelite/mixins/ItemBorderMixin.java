/*
 * Copyright (c) 2018, Abex
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

import java.util.HashMap;
import java.util.Map;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSSpritePixels;

@Mixin(RSClient.class)
public abstract class ItemBorderMixin implements RSClient
{
	@Inject
	private static Map<Integer, Integer> itemBorderColors;

	@Inject
	@Override
	public void setItemBorderColor(int itemId, int rgb)
	{
		if (itemBorderColors == null)
		{
			itemBorderColors = new HashMap<Integer, Integer>();
		}
		itemBorderColors.put(itemId, rgb);
	}

	@Inject
	@Override
	public void clearItemBorderColors()
	{
		if (itemBorderColors != null)
		{
			itemBorderColors.clear();
		}
	}

	@Copy("createSprite")
	private static RSSpritePixels rs$createSprite(int itemId, int quantity, int borderColorIndex, int dropShadowRGB, int stackable, boolean noted, int garbage)
	{
		throw new RuntimeException();
	}

	@Replace("createSprite")
	public static RSSpritePixels rl$createSprite(int itemId, int quantity, int borderColorIndex, int dropShadowRGB, int stackable, boolean noted, int garbage)
	{
		if (borderColorIndex == 2 || itemBorderColors == null) // Selected item, white border always
		{
			return rs$createSprite(itemId, quantity, borderColorIndex, dropShadowRGB, stackable, noted, garbage);
		}
		Integer boxNewColor = itemBorderColors.get(itemId);
		if (boxNewColor == null)
		{
			return rs$createSprite(itemId, quantity, borderColorIndex, dropShadowRGB, stackable, noted, garbage);
		}
		int newColor = boxNewColor;
		// we have from bit 42 through 63 to share with dropShadow, but can only pass, so in an attempt to reduce false cache hits we have
		// a very rudimentary hash function and carefully lie to rs$createSprite
		long colorHash = (newColor << 32) | dropShadowRGB;
		colorHash = (colorHash >> 21) ^ (colorHash >> 42) ^ colorHash;
		// subtract from dropShadowDelta because it is added later
		int dropShadowDelta = (dropShadowRGB & 0x3FFFFF) - (int) (colorHash & 0x3FFFFF);
		// 0x8000003 is used because it is negative for the check, but 3 for the hash.
		// (dropShadowDelta<<4) is to shift hash into the the dropShadow spot
		borderColorIndex = 0x80000003 | (dropShadowDelta << 4);
		RSSpritePixels sp = rs$createSprite(itemId, quantity, borderColorIndex, dropShadowRGB, stackable, noted, garbage);
		// If we have already modified this sprite it has came out of the cache
		if (!sp.getHasBeenModified())
		{
			sp.drawOutline(newColor);
			sp.setHasBeenModified(true);
		}
		return sp;
	}
}
