/*
 * Copyright (c) 2024, YvesW <https://github.com/YvesW>
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
package net.runelite.client.plugins.boosts;

import java.awt.image.BufferedImage;
import lombok.AllArgsConstructor;
import net.runelite.client.util.ImageUtil;

@AllArgsConstructor
enum BoostTimer
{
	COMBAT_BUFFED("Next combat buff change", "Next cb + restore", loadImage("buffed_cb.png"), loadImage("buffed_cb_small.png")),
	NON_COMBAT_BUFFED("Next non-combat buff change", "Next non-cb + restore", loadImage("buffed_non_cb.png"), loadImage("buffed_non_cb_small.png")),
	DEBUFFED("Next debuff change", "Next - restore", loadImage("debuffed.png"), loadImage("debuffed_small.png"));

	final String indicatorTooltipText;
	final String overlayText;
	final BufferedImage indicatorImage;
	final BufferedImage compactImage;

	private static BufferedImage loadImage(String path)
	{
		return ImageUtil.loadImageResource(BoostsPlugin.class, path);
	}
}