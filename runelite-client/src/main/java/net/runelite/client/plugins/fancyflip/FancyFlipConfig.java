/*
 * Copyright (c) 2025, Codex <codex@openai.com>
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
package net.runelite.client.plugins.fancyflip;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("fancyflip")
public interface FancyFlipConfig extends Config
{
    @ConfigItem(
            keyName = "taxRate",
            name = "Tax Rate (%)",
            description = "Grand Exchange tax percentage"
    )
    default int taxRatePct() { return 2; }

    @ConfigItem(
            keyName = "maxAlloc",
            name = "Max % per item",
            description = "Max percent of bank per item"
    )
    default int maxAllocationPct() { return 40; }

    @ConfigItem(
            keyName = "sellOnly",
            name = "Sell-only mode",
            description = "Only show sell offers"
    )
    default boolean sellOnly() { return false; }

    @ConfigItem(
            keyName = "f2pOnly",
            name = "F2P-only mode",
            description = "Only show free-to-play items"
    )
    default boolean f2pOnly() { return false; }

    @ConfigItem(
            keyName = "blocklistCsv",
            name = "Blocklist CSV",
            description = "Comma-separated item names to ignore"
    )
    default String blocklistCsv() { return ""; }

    @ConfigItem(
            keyName = "includeBankCoins",
            name = "Include bank coins",
            description = "Include bank coins in total wealth"
    )
    default boolean includeBankCoins() { return true; }
}
