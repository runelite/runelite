/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
 * Copyright (c) 2020, Sean 'Furret' Hill <https://github.com/hisean1>
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
package net.runelite.client.plugins.barbarianassault;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("barbarianAssault")
public interface BarbarianAssaultConfig extends Config
{
	@ConfigItem(
		keyName = "showTimer",
		name = "Show call change timer",
		description = "Show time to next call change",
		position = 0
	)
	default boolean showTimer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showHealerBars",
		name = "Show health bars for teammates when healer",
		description = "Displays team health for healer",
		position = 1
	)
	default boolean showHealerBars()
	{
		return true;
	}

	@ConfigItem(
		keyName = "waveTimes",
		name = "Show wave and game duration",
		description = "Displays wave and game duration",
		position = 2
	)
	default boolean waveTimes()
	{
		return true;
	}

	@ConfigItem(
			keyName = "waveCompare",
			name = "Compare wave times against goal",
			description = "Displays goal wave end times",
			position = 3
	)
	default boolean waveCompare() { return false; }

	@ConfigItem(
			keyName = "waveSplits",
			name = "Show wave end splits",
			description = "Makes you better",
			position = 4
	)
	default boolean waveSplits()
	{
		return false;
	}

	@ConfigItem(
			keyName = "pointBreakdown",
			name = "Show point breakdown",
			description = "Provides a detailed point breakdown for each role after every wave",
			position = 5
	)
	default boolean pointBreakdown() { return false; }

	@ConfigSection(
			name = "Split Comparisons",
			description = "Choose which splits to compare against",
			position = 6
	)
	String splitComparison = "splitComparison";
/*
	@ConfigItem(
			keyName = "soloWR",
			name = "Solo Heal WR",
			description = "Compare against the solo heal WR times",
			position = 0,
			section = splitComparison
	)
	default boolean soloHealWR()
	{
		return false;
	}

	@ConfigItem(
			keyName = "duoWR",
			name = "Duo Heal WR",
			description = "Compare against the duo heal WR times",
			position = 1,
			section = splitComparison
	)
	default boolean duoHealWR()
	{
		return false;
	}

	@ConfigItem(
			keyName = "leechWR",
			name = "Leech WR",
			description = "Compare against the leech heal WR times",
			position = 2,
			section = splitComparison
	)
	default boolean leechWR()
	{
		return false;
	}

	@ConfigItem(
			keyName = "soloPB",
			name = "Solo Heal PB",
			description = "Compare against your solo heal personal best",
			position = 3,
			section = splitComparison
	)
	default boolean soloHealPB()
	{
		return false;
	}

	@ConfigItem(
			keyName = "duoPB",
			name = "Duo Heal PB",
			description = "Compare against your duo heal personal best",
			position = 4,
			section = splitComparison
	)
	default boolean duoHealPB()
	{
		return false;
	}

	@ConfigItem(
			keyName = "leechPB",
			name = "Leech PB",
			description = "Compare against your leech personal best",
			position = 5,
			section = splitComparison
	)
	default boolean leechPB()
	{
		return false;
	}

	@ConfigItem(
			keyName = "custom",
			name = "Custom Compare",
			description = "Compare against custom splits, entered below",
			position = 6,
			section = splitComparison
	)
	default boolean custom()
	{
		return false;
	}
*/
	@ConfigItem(
			keyName = "category",
			name = "Run Category",
			description = "Run category to compare against",
			position = 7,
			section = splitComparison
	)
	default RunCategory category() { return RunCategory.SOLOHEALWR; }

	@ConfigItem(
			keyName = "waveEndTimes",
			name = "Wave End Times",
			description = "Enter your desired wave end times (time for this specific wave)",
			position = 7,
			section = splitComparison
	)
	default String getDesiredWaveTimes()
	{
		return "";
	}

	@ConfigItem(
			keyName = "waveEndTimes",
			name = "",
			description = "",
			section = splitComparison
	)
	void setDesiredWaveTimes(String key);

	@ConfigItem(
			keyName = "waveEndSplits",
			name = "Wave Splits",
			description = "Enter your desired wave splits (total time from start to wave finish)",
			position = 8,
			section = splitComparison
	)
	default String getDesiredWaveSplits()
	{
		return "";
	}

	@ConfigItem(
			keyName = "waveSplits",
			name = "",
			description = "",
			section = splitComparison
	)
	void setDesiredWaveSplits(String key);
}
