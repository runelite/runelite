/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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
package net.runelite.client.plugins.kingdomofmiscellania;

import java.awt.Color;
import java.awt.image.BufferedImage;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.util.StackFormatter;
import net.runelite.client.util.ColorUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class KingdomCounter extends Counter
{
	private final KingdomPlugin plugin;

	public KingdomCounter(BufferedImage image, KingdomPlugin plugin)
	{
		super(image, plugin, plugin.getFavor());
		this.plugin = plugin;
	}

	@Override
	public String getText()
	{
		return KingdomPlugin.getFavorPercent(plugin.getFavor()) + "%";
	}

	@Override
	public String getTooltip()
	{

		String currentRewards = ColorUtil.wrapWithColorTag("Personal Profit: ", Color.YELLOW)
			+ StackFormatter.formatNumber(plugin.getPersonal().getNetProfit()) + "</br>";

		HashMap <String, String> rewardSummary = plugin.getPersonal().getRewardSummary();


		if (rewardSummary != null)
		{
			Iterator it = plugin.getPersonal().getRewardSummary().entrySet().iterator();
			while (it.hasNext())
			{
				Map.Entry pairs = (Map.Entry) it.next();
				currentRewards += pairs.getValue() + "</br>";
			}
		}

		return ColorUtil.wrapWithColorTag("Favor: ", Color.YELLOW)
				+ plugin.getFavor() + "/127" + "</br>"
				+ ColorUtil.wrapWithColorTag("Coffer: ", Color.YELLOW)
				+ StackFormatter.quantityToRSStackSize(plugin.getCoffer()) + "</br>"
				+ ColorUtil.wrapWithColorTag("Highest Profit:  ", Color.YELLOW)
				+ ColorUtil.wrapWithColorTag(plugin.getMax().getPrimaryResource().getType(), Color.CYAN)
				+ "  " + StackFormatter.formatNumber(plugin.getMax().getPrimaryAmount()) + "</br>"
				+ ColorUtil.wrapWithColorTag("Second Highest:  ", Color.YELLOW)
				+ ColorUtil.wrapWithColorTag(plugin.getMax().getSecondaryResource().getType(), Color.CYAN)
				+ "  " + StackFormatter.formatNumber(plugin.getMax().getSecondaryAmount()) + "</br>"
				+ currentRewards;
	}
}
