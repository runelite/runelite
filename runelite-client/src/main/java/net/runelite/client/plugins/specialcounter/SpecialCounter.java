/*
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
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

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.ui.overlay.infobox.Counter;

class SpecialCounter extends Counter
{
	private final SpecialWeapon weapon;
	@Getter(AccessLevel.PACKAGE)
	private final Map<String, Integer> partySpecs = new HashMap<>();

	SpecialCounter(final BufferedImage image, final SpecialCounterPlugin plugin, final int hitValue, final SpecialWeapon weapon)
	{
		super(image, plugin, hitValue);
		this.weapon = weapon;
	}

	void addHits(double hit)
	{
		int count = getCount();
		setCount(count + (int) hit);
	}

	@Override
	public String getTooltip()
	{
		int hitValue = getCount();

		if (partySpecs.isEmpty())
		{
			return buildTooltip(hitValue);
		}

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(buildTooltip(hitValue));

		for (Map.Entry<String, Integer> entry : partySpecs.entrySet())
		{
			stringBuilder.append("</br>")
				.append(entry.getKey() == null ? "You" : entry.getKey()).append(": ")
				.append(buildTooltip(entry.getValue()));
		}

		return stringBuilder.toString();
	}

	private String buildTooltip(int hitValue)
	{
		if (!weapon.isDamage())
		{
			if (hitValue == 1)
			{
				return weapon.getName() + " special has hit " + hitValue + " time.";
			}
			else
			{
				return weapon.getName() + " special has hit " + hitValue + " times.";
			}
		}
		else
		{
			return weapon.getName() + " special has hit " + hitValue + " total.";
		}
	}
}