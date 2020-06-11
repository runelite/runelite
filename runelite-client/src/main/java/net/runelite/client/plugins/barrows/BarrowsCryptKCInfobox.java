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
package net.runelite.client.plugins.barrows;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxPriority;

public class BarrowsCryptKCInfobox extends InfoBox
{
	private final Client client;
	private final BarrowsConfig config;
	private final BarrowsPlugin plugin;
	private static final int CRYPT_PLANE_ID = 0;

	@Inject
	BarrowsCryptKCInfobox(BufferedImage image, BarrowsPlugin plugin, Client client, BarrowsConfig config)
	{
		super(image, plugin);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
		setTooltip(initializeTooltip());
		setPriority(InfoBoxPriority.HIGH);
	}

	@Override
	public String getText()
	{
		return Integer.toString(plugin.getMonstersKilled().values().stream().mapToInt(Integer::intValue).sum());
	}

	@Override
	public Color getTextColor()
	{
		return Color.WHITE;
	}


	@Override
	public boolean render()
	{
		return config.showCryptMonsterKills() && isInCrypt();
	}

	String initializeTooltip()
	{
		StringBuilder tooltipBuilder = new StringBuilder();
		Map<String, Integer> monstersKilled = plugin.getMonstersKilled();
		for (CryptMonsters monster : CryptMonsters.values())
		{
			String monsterName = monster.getName();
			Integer numKilled = monstersKilled.get(monsterName);
			if (numKilled == null)
			{
				numKilled = 0;
			}
			tooltipBuilder.append(monsterName).append(": ").append(numKilled).append("</br>");
		}
		return tooltipBuilder.toString();
	}

	void updateTooltip()
	{
		String tooltip = this.initializeTooltip();
		this.setTooltip(tooltip);
	}

	// Reusing BarrowsPlugin's isInCrypt to decide whether or not to show this overlay
	// Also added plane checking to limit tracker to only appearing the maze portion, not in each barrow.
	private boolean isInCrypt()
	{
		boolean cryptRegion = client.getLocalPlayer().getWorldLocation().getRegionID() == plugin.CRYPT_REGION_ID;
		boolean cryptPlane = client.getLocalPlayer().getWorldLocation().getPlane() == CRYPT_PLANE_ID;
		return cryptRegion && cryptPlane;
	}
}
