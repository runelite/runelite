/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.grandexchange;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(GrandExchangeConfig.CONFIG_GROUP)
public interface GrandExchangeConfig extends Config
{
	String CONFIG_GROUP = "grandexchange";

	@ConfigItem(
		position = 1,
		keyName = "quickLookup",
		name = "Hotkey lookup (Alt + Left click)",
		description = "Configures whether to enable the hotkey lookup for GE searches"
	)
	default boolean quickLookup()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "enableNotifications",
		name = "Notify on offer update",
		description = "Configures whether to enable notifications when an offer updates"
	)
	default boolean enableNotifications()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "notifyOnOfferComplete",
		name = "Notify on offer complete",
		description = "Configures whether to enable notifications when an offer completes"
	)
	default boolean notifyOnOfferComplete()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "showActivelyTradedPrice",
		name = "Enable actively traded prices",
		description = "Shows the actively traded price on the GE buy interface, sourced from the RuneScape wiki"
	)
	default boolean showActivelyTradedPrice()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "enableGeLimits",
		name = "Enable GE Limits on GE",
		description = "Shows the GE Limits on the GE"
	)
	default boolean enableGELimits()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "enableGELimitReset",
		name = "Enable GE Limit Reset Timer",
		description = "Shows when GE Trade limits reset (H:MM)"
	)

	default boolean enableGELimitReset()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "showTotal",
		name = "Show GE total",
		description = "Display the total value of all trades at the top of the GE interface"
	)
	default boolean showTotal()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "showExact",
		name = "Show exact total value",
		description = "When enabled along with the ‘Show GE total’ option, the unabbreviated value will be displayed"
	)
	default boolean showExact()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "highlightSearchMatch",
		name = "Highlight Search Match",
		description = "Highlights the search match with an underline"
	)
	default boolean highlightSearchMatch()
	{
		return true;
	}

	@ConfigItem(
		position = 9,
		keyName = "geSearchMode",
		name = "Search Mode",
		description = "The search mode to use for the GE<br>"
			+ "Default - Matches exact text only<br>"
			+ "Fuzzy Only - Matches inexact text such as 'sara sword'<br>"
			+ "Fuzzy Fallback - Uses default search, falling back to fuzzy search if no results were found"
	)
	default GrandExchangeSearchMode geSearchMode()
	{
		return GrandExchangeSearchMode.DEFAULT;
	}
}
