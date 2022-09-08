/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
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

package net.runelite.client.plugins.gauntletextended.resource;

import java.awt.image.BufferedImage;
import net.runelite.client.plugins.gauntletextended.GauntletExtendedPlugin;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.ui.overlay.infobox.InfoBoxPriority;

class ResourceCounter extends Counter
{
	private final Resource resource;

	private int count;
	private String text;

	ResourceCounter(final GauntletExtendedPlugin plugin, final Resource resource, final BufferedImage bufferedImage, final int count)
	{
		super(bufferedImage, plugin, count);

		this.resource = resource;
		this.count = count;
		this.text = String.valueOf(count);

		setPriority(getPriority(resource));
	}

	@Override
	public String getText()
	{
		return text;
	}

	public void incrementCount(int count)
	{
		this.count += Math.max(0, count);
		this.text = String.valueOf(this.count);
	}

	public void decrementCount(int count)
	{
		this.count -= Math.max(0, count);
		this.text = String.valueOf(this.count);
	}

	private static InfoBoxPriority getPriority(final Resource resource)
	{
		switch (resource)
		{
			case CRYSTAL_ORE:
			case CORRUPTED_ORE:
			case PHREN_BARK:
			case CORRUPTED_PHREN_BARK:
			case LINUM_TIRINUM:
			case CORRUPTED_LINUM_TIRINUM:
				return InfoBoxPriority.HIGH;
			case GRYM_LEAF:
			case CORRUPTED_GRYM_LEAF:
				return InfoBoxPriority.MED;
			case CRYSTAL_SHARDS:
			case CORRUPTED_SHARDS:
			case RAW_PADDLEFISH:
				return InfoBoxPriority.NONE;
			default:
				return InfoBoxPriority.LOW;
		}
	}
}
