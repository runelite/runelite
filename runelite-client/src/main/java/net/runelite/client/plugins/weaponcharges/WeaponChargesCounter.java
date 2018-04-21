/*
 * Copyright (c) 2018, JerwuQu <marcus@ramse.se>
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

package net.runelite.client.plugins.weaponcharges;

import java.awt.Color;
import java.awt.image.BufferedImage;
import lombok.Getter;
import net.runelite.client.ui.overlay.infobox.Counter;

public class WeaponChargesCounter extends Counter
{
	private final WeaponChargesPlugin plugin;

	@Getter
	private final ChargedWeapon chargedWeapon;

	WeaponChargesCounter(BufferedImage image, WeaponChargesPlugin plugin, final ChargedWeapon chargedWeapon)
	{
		super(image, plugin, String.valueOf(plugin.getCharges(chargedWeapon)));
		this.plugin = plugin;
		this.chargedWeapon = chargedWeapon;
	}

	@Override
	public String getText()
	{
		Integer charges = plugin.getCharges(chargedWeapon);
		return charges == null ? "?" : String.valueOf(charges);
	}

	@Override
	public Color getTextColor()
	{
		return plugin.getChargesColor(plugin.getCharges(chargedWeapon));
	}

	@Override
	public String getTooltip()
	{
		if (plugin.getCharges(chargedWeapon) == null)
		{
			return "<col=ff0000>Please Check charges on your weapon";
		}
		else
		{
			return "Weapon Charges";
		}
	}
}
