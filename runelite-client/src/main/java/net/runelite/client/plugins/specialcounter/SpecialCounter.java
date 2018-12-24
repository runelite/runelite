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
import net.runelite.client.ui.overlay.infobox.Counter;

class SpecialCounter extends Counter
{
	private int hitValue;
	private SpecialWeapon weapon;

	SpecialCounter(BufferedImage image, SpecialCounterPlugin plugin, int hitValue, SpecialWeapon weapon)
	{
		super(image, plugin, null);
		this.weapon = weapon;
		this.hitValue = hitValue;
	}

	void addHits(double hit)
	{
		this.hitValue += hit;
	}

	@Override
	public String getText()
	{
		return Integer.toString(hitValue);
	}

	@Override
	public String getTooltip()
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