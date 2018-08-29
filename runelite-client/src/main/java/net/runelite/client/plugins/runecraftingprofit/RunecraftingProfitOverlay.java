/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Dalton <delps1001@gmail.com>
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
package net.runelite.client.plugins.runecraftingprofit;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;


public class RunecraftingProfitOverlay extends Overlay
{
	private static final NavigableMap<Long, String> suffixes = new TreeMap<>();

	static
	{
		suffixes.put(1_000L, "k");
		suffixes.put(1_000_000L, "M");
		suffixes.put(1_000_000_000L, "G");
		suffixes.put(1_000_000_000_000L, "T");
		suffixes.put(1_000_000_000_000_000L, "P");
		suffixes.put(1_000_000_000_000_000_000L, "E");
	}

	private final Client client;
	private final RunecraftingProfitPlugin plugin;
	private final RunecraftingProfitConfig config;
	private final PanelComponent panelComponent = new PanelComponent();
	RunecraftingProfitSession session;

	@Inject
	RunecraftingProfitOverlay(Client client, RunecraftingProfitPlugin plugin, RunecraftingProfitConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.session = plugin.getSession();
	}

	public static String format(long value)
	{
		if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
		if (value < 0) return "-" + format(-value);
		if (value < 1000) return Long.toString(value); //deal with easy case

		Map.Entry<Long, String> e = suffixes.floorEntry(value);
		Long divideBy = e.getKey();
		String suffix = e.getValue();

		long truncated = value / (divideBy / 10); //the number part of the output times 10
		boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
		return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		//only display the overlay after the first RC animation occurs...
		if (!plugin.isFirstRunecraft())
		{
			return null;
		}

		//only display the UI if the player has done the RC animation in the last TIMEOUT_INTERVAL minutes
		if (!plugin.displayOverlay)
		{
			return null;
		}

		panelComponent.getChildren().clear();


		if (plugin.displayProfit)
		{
			if (config.displayIndividualRuneTypes())
			{
				for (Runes rune : Runes.values())
				{
					int profitForRuneType = session.getProfitPerRuneType().get(rune);
					if (profitForRuneType > 0)
					{
						panelComponent.getChildren().add(LineComponent.builder()
								.left(rune.getName() + ":")
								.right(format(profitForRuneType) + " gp")
								.build());
					}
				}
			}

			panelComponent.getChildren().add(LineComponent.builder()
					.left("Total: ")
					.right(format(session.getTotalProfit()) + " gp")
					.build());
		}
		else
		{
			if (config.displayIndividualRuneTypes())
			{
				for (Runes rune : Runes.values())
				{
					int totalForRuneType = session.getNumberOfTotalRunesCrafted().get(rune.getItemId());
					if (totalForRuneType > 0)
					{
						panelComponent.getChildren().add(LineComponent.builder()
								.left(rune.getName() + ":")
								.right(Integer.toString(totalForRuneType))
								.build());
					}

				}
			}

			panelComponent.getChildren().add(LineComponent.builder()
					.left("Total: ")
					.right(Integer.toString(session.getTotalRunesCrafted()))
					.build());
		}

		//display profit per hour if enabled
		if (config.displayProfitPerHour())
		{
			panelComponent.getChildren().add(LineComponent.builder()
					.left("Profit/hr: ")
					.right(format((long) session.getTotalProfitPerHour()))
					.build());
		}


		return panelComponent.render(graphics);
	}
}
