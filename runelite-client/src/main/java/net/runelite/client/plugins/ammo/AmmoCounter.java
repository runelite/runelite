/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.ammo;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.util.QuantityFormatter;

class AmmoCounter extends Counter
{
	@Getter(AccessLevel.PACKAGE)
	private int itemID;
	private final String name;
	private final int total;
	private final Instant time;
	private BigDecimal ammoPerHour;

	AmmoCounter(Plugin plugin, int itemID, int count, String name, BufferedImage image)
	{
		super(image, plugin, count);
		this.total = count;
		this.itemID = itemID;
		this.name = name;
		this.time = Instant.now();
	}

	@Override
	public String getText()
	{
		return QuantityFormatter.quantityToRSDecimalStack(getCount());
	}

	@Override
	public String getTooltip()
	{
		if (lossRate() >= 1)
		{
			return String.format("%s</br>Loss Rate: %s/h", name, lossRate());
		}
		else
		{
			return "Need more data";
		}
	}

	private int lossRate()
	{
		BigDecimal diff = BigDecimal.valueOf(total).subtract(BigDecimal.valueOf(getCount()));
		BigDecimal timeSinceStart = BigDecimal.valueOf(Duration.between(time, Instant.now()).getSeconds())
			.setScale(6, RoundingMode.UP);
		if (timeSinceStart.compareTo(BigDecimal.ZERO) != 0)
		{
			BigDecimal timeSinceStartInHours = timeSinceStart.divide(BigDecimal.valueOf(3600), RoundingMode.UP);
			ammoPerHour = diff.divide(timeSinceStartInHours, RoundingMode.HALF_UP);
		}
		if (ammoPerHour != null)
		{
			return ammoPerHour.intValue();
		}
		else
		{
			return 0;
		}
	}
}
