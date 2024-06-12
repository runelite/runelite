/*
 * Copyright (c) 2024, 1Defence>
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

import lombok.Getter;
import net.runelite.client.ui.overlay.infobox.InfoBox;

import java.awt.*;
import java.awt.image.BufferedImage;

class SpecialCounterPercentage extends InfoBox
{
	private SpecialCounter dwhCounter;
	private SpecialCounter maulCounter;

	private int zeroCount;

	private final SpecialCounterConfig config;

	@Getter
	private double defenceDrainPercentage;

	SpecialCounterPercentage(BufferedImage image, SpecialCounterPlugin plugin, SpecialCounterConfig config, SpecialCounter initialCounter, int initialHit)
	{
		super(image, plugin);
		this.config = config;
		setCounter(initialCounter, initialHit);
	}

	public void setCounter(SpecialCounter counter, int initialHit)
	{
		switch (counter.getWeapon())
		{
			case DRAGON_WARHAMMER:
				dwhCounter = counter;
				break;
			case ELDER_MAUL:
				maulCounter = counter;
				break;
		}

		if (initialHit == 0)
		{
			incrementZeros();
		}

		recalculateSpecs();
	}

	public void recalculateSpecs()
	{
		int currentDefence = 100;
		if (dwhCounter != null && dwhCounter.getCount() > 0)
		{
			currentDefence *= Math.pow(0.7, dwhCounter.getCount());
		}
		if (maulCounter != null && maulCounter.getCount() > 0)
		{
			currentDefence *= Math.pow(0.65, maulCounter.getCount());
		}
		defenceDrainPercentage = 100 - (currentDefence * Math.pow(0.95, zeroCount));
	}

	public void incrementZeros()
	{
		zeroCount++;
	}

	@Override
	public String getTooltip()
	{
		return "Opponents defence has been reduced by " + getText() + ".";
	}

	@Override
	public Color getTextColor()
	{
		int threshold = config.defencePercentageThreshold();
		if (threshold > 0)
		{
			return defenceDrainPercentage >= threshold ? Color.GREEN : Color.RED;
		}
		return Color.WHITE;
	}

	@Override
	public String getText()
	{
		return (int) defenceDrainPercentage + "%";
	}
}