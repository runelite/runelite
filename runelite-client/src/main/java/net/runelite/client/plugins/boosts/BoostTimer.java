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
	COMBAT_BUFFED("Next combat buff change", "buffed_cb.png", "Next cb + restore"),
	NON_COMBAT_BUFFED("Next non-combat buff change", "buffed_non_cb.png", "Next non-cb + restore"),
	DEBUFFED("Next debuff change", "debuffed.png", "Next - restore");

	final String indicatorTooltipText;
	final String indicatorImagePath;
	final String overlayText;

	BufferedImage indicatorImage()
	{
		return ImageUtil.loadImageResource(BoostsPlugin.class, indicatorImagePath);
	}

	BufferedImage compactImage()
	{
		String extension = ".png";
		String path = indicatorImagePath.substring(0, indicatorImagePath.indexOf(extension)) + "_small" + extension;
		return ImageUtil.loadImageResource(BoostsPlugin.class, path);
	}
}