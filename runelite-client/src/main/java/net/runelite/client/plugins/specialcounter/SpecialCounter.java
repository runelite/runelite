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
import net.runelite.client.ui.overlay.infobox.Counter;

class SpecialCounter extends Counter
{
	private SpecialWeapon weapon;
	private Map<String, Integer> counts = new HashMap<>();

	SpecialCounter(BufferedImage image, SpecialCounterPlugin plugin, String name, int hitValue, SpecialWeapon weapon)
	{
		super(image, plugin, 0);
		this.weapon = weapon;
		addHits(name, hitValue);
	}

	void addHits(String name, int hit)
	{
		if (name != null)
		{
			if (counts.containsKey(name))
			{
				counts.put(name, counts.get(name) + hit);
			}
			else
			{
				counts.put(name, hit);
			}
		}
		else
		{
			setCount(getCount() + hit);
		}
	}

	@Override
	public String getText()
	{
		int count = getCount();
		for (int hits : counts.values())
		{
			count += hits;
		}
		return String.valueOf(count);
	}

	@Override
	public String getTooltip()
	{
		String tooltip = "";
		int hitValue = getCount();
		if (hitValue != 0)
		{
			if (!weapon.isDamage())
			{
				if (hitValue == 1)
				{
					tooltip += "You have hit " + hitValue + " " + weapon.getName() + " spec.";
				}
				else
				{
					tooltip += "You have hit " + hitValue + " " + weapon.getName() + " specs.";
				}
			}
			else
			{
				tooltip += tooltip += "You have hit " + hitValue + " " + weapon.getName() + " spec damage.";
			}
			tooltip += "</br>";
		}

		for (String name : counts.keySet())
		{
			hitValue = counts.get(name);
			if (!weapon.isDamage())
			{
				if (hitValue == 1)
				{
					tooltip += name + " has hit " + hitValue + " " + weapon.getName() + " spec.";
				}
				else
				{
					tooltip += name + " has hit " + hitValue + " " + weapon.getName() + " specs.";
				}
			}
			else
			{
				tooltip += tooltip += name + " has hit " + hitValue + " " + weapon.getName() + " spec damage.";
			}
			tooltip += "</br>";
		}
		tooltip = tooltip.substring(0, tooltip.length() - 5);
		return tooltip;
	}
}