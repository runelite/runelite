/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package net.runelite.client.plugins.boosts;

import java.awt.Color;
import java.awt.image.BufferedImage;
import lombok.AllArgsConstructor;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxPriority;

class StatChangeIndicator extends InfoBox
{
	private final BoostType boostType;
	private final BoostsPlugin plugin;
	private final BoostsConfig config;

	StatChangeIndicator(BoostType boostType, BufferedImage image, BoostsPlugin plugin, BoostsConfig config)
	{
		super(image, plugin);
		this.boostType = boostType;
		this.plugin = plugin;
		this.config = config;
		setPriority(InfoBoxPriority.MED);
		setTooltip(boostType.tooltipText);
	}

	@Override
	public String getText()
	{
		return String.format("%02d", plugin.getChangeTime(ticksRemaining(boostType)));
	}

	@Override
	public Color getTextColor()
	{
		return ticksRemaining(boostType) < 10 ? Color.RED.brighter() : Color.WHITE;
	}

	@Override
	public boolean render()
	{
		return ticksRemaining(boostType) != -1 && config.displayInfoboxes();
	}

	private int ticksRemaining(BoostType boostType)
	{
		switch (boostType)
		{
			case COMBAT_BUFFED:
				return plugin.getCbBuffDrainTicks();
			case NON_COMBAT_BUFFED:
				return plugin.getNonCbBuffDrainTicks();
			case DEBUFFED:
				return plugin.getDebuffRestorationTicks();
		}
		return -1;
	}

	@AllArgsConstructor
	enum BoostType
	{
		COMBAT_BUFFED("Next combat buff change"),
		NON_COMBAT_BUFFED("Next non-combat buff change"),
		DEBUFFED("Next debuff change");

		final String tooltipText;
	}
}
