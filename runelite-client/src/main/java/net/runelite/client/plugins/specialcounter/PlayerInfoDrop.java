/*
 * Copyright (c) 2022, Hexagon <hexagon@fking.work>
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
package net.runelite.client.plugins.specialcounter;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.runelite.client.ui.FontManager;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class PlayerInfoDrop
{
	private final int startCycle;
	private final int endCycle;
	private final int playerIdx;
	private final String text;
	private final int startHeightOffset;
	private final int endHeightOffset;
	private final Font font;
	private final Color color;
	private final BufferedImage image;

	public static Builder builder(int startCycle, int endCycle, int playerIdx, String text)
	{
		return new Builder(startCycle, endCycle, playerIdx, text);
	}

	@RequiredArgsConstructor
	@Accessors(fluent = true)
	@Setter
	static class Builder
	{
		private final int startCycle;
		private final int endCycle;
		private final int playerIdx;
		private final String text;
		private int startHeightOffset = 0;
		private int endHeightOffset = 200;
		private Font font = FontManager.getRunescapeBoldFont();
		private Color color = Color.WHITE;
		private BufferedImage image;

		public PlayerInfoDrop build()
		{
			if (startCycle > endCycle)
			{
				throw new IllegalArgumentException("endCycle must be after startCycle");
			}
			if (playerIdx < 0 || playerIdx > 2047)
			{
				throw new IllegalArgumentException("playerIdx must be between 0-2047");
			}
			return new PlayerInfoDrop(startCycle, endCycle, playerIdx, text, startHeightOffset, endHeightOffset, font, color, image);
		}
	}
}