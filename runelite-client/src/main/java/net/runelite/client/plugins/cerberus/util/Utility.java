/*
 * Copyright (c) 2020 dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019 Im2be <https://github.com/Im2be>
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

package net.runelite.client.plugins.cerberus.util;

import java.awt.Color;
import java.awt.Font;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.runelite.api.Prayer;
import net.runelite.client.plugins.cerberus.CerberusConfig;
import net.runelite.client.plugins.cerberus.domain.Phase;
import net.runelite.client.ui.FontManager;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Utility
{
	private static final Color COLOR_DEFAULT = new Color(70, 61, 50, 225);
	private static final Color COLOR_GHOSTS = new Color(255, 255, 255, 225);
	private static final Color COLOR_TRIPLE_ATTACK = new Color(0, 15, 255, 225);
	private static final Color COLOR_LAVA = new Color(82, 0, 0, 225);

	public static int calculateNpcHp(final int ratio, final int health, final int maxHp)
	{
		if (ratio < 0 || health <= 0 || maxHp == -1)
		{
			return -1;
		}

		int exactHealth = 0;

		// This is the reverse of the calculation of healthRatio done by the server
		// which is: healthRatio = 1 + (healthScale - 1) * health / maxHealth (if health > 0, 0 otherwise)
		// It's able to recover the exact health if maxHealth <= healthScale.
		if (ratio > 0)
		{
			int minHealth = 1;
			int maxHealth;
			if (health > 1)
			{
				if (ratio > 1)
				{
					// This doesn't apply if healthRatio = 1, because of the special case in the server calculation that
					// health = 0 forces healthRatio = 0 instead of the expected healthRatio = 1
					minHealth = (maxHp * (ratio - 1) + health - 2) / (health - 1);
				}
				maxHealth = (maxHp * ratio - 1) / (health - 1);
				if (maxHealth > maxHp)
				{
					maxHealth = maxHp;
				}
			}
			else
			{
				// If healthScale is 1, healthRatio will always be 1 unless health = 0
				// so we know nothing about the upper limit except that it can't be higher than maxHealth
				maxHealth = maxHp;
			}
			// Take the average of min and max possible healths
			exactHealth = (minHealth + maxHealth + 1) / 2;
		}

		return exactHealth;
	}

	public static Font getFontFromInfoboxComponentSize(final CerberusConfig.InfoBoxComponentSize size)
	{
		final Font font;

		switch (size)
		{
			case LARGE:
			case MEDIUM:
			default:
				font = FontManager.getRunescapeFont();
				break;
			case SMALL:
				font = FontManager.getRunescapeSmallFont();
				break;
		}

		return font;
	}

	public static Color getColorFromPhase(final Phase phase)
	{
		final Color color;

		switch (phase)
		{
			case TRIPLE:
				color = COLOR_TRIPLE_ATTACK;
				break;
			case LAVA:
				color = COLOR_LAVA;
				break;
			case GHOSTS:
				color = COLOR_GHOSTS;
				break;
			case AUTO:
			default:
				color = COLOR_DEFAULT;
				break;
		}

		return color;
	}

	public static Color getColorFromPrayer(final Prayer prayer)
	{
		switch (prayer)
		{
			case PROTECT_FROM_MAGIC:
				return Color.BLUE;
			case PROTECT_FROM_MISSILES:
				return Color.GREEN;
			case PROTECT_FROM_MELEE:
				return Color.RED;
			default:
				return Color.WHITE;
		}
	}
}
