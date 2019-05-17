/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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
package net.runelite.client.plugins.bankPrayer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("bankPrayer")
public interface BankPrayerConfig extends Config
{
	enum PrayerBoosts {
		NONE,
		GILDED_ALTAR,
		ECTOFUNTUS;
	}

	@ConfigItem(
			keyName = "showEnsouled",
			name = "Show ensouled heads",
			description = "Show experience from ensouled heads.",
			position = 1
	)
	default boolean showEnsouled()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showBones",
			name = "Show bones",
			description = "Show experience from bones.",
			position = 2
	)
	default boolean showBones() { return true; }

	@ConfigItem(
			keyName = "prayerBoost",
			name = "Prayer boost",
			description = "Select appropriate option for your training.",
			position = 3
	)
	default PrayerBoosts prayerBoost() {
		return PrayerBoosts.ECTOFUNTUS;
	}

	@ConfigItem(
			keyName = "targetLevel",
			name = "Target level",
			description = "This will let the plugin show how far you've come towards your goal.",
			position = 4
	)
	default int targetLevel() {return 0;}
}
