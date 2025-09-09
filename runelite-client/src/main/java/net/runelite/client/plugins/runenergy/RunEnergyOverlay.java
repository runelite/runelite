/*
 * Copyright (c) 2018, Sean Dewar <https://github.com/seandewar>
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
package net.runelite.client.plugins.runenergy;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import org.apache.commons.lang3.StringUtils;

class RunEnergyOverlay extends Overlay
{
	private final RunEnergyPlugin plugin;
	private final Client client;
	private final RunEnergyConfig config;
	private final TooltipManager tooltipManager;

	@Inject
	private RunEnergyOverlay(final RunEnergyPlugin plugin, final Client client, final RunEnergyConfig config, final TooltipManager tooltipManager)
	{
		this.plugin = plugin;
		this.client = client;
		this.config = config;
		this.tooltipManager = tooltipManager;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget runOrb = client.getWidget(InterfaceID.Orbs.RUNBUTTON);

		if (runOrb == null || runOrb.isHidden())
		{
			return null;
		}

		final Rectangle bounds = runOrb.getBounds();

		if (bounds.getX() <= 0)
		{
			return null;
		}

		final Point mousePosition = client.getMouseCanvasPosition();

		if (bounds.contains(mousePosition.getX(), mousePosition.getY()))
		{
			StringBuilder sb = new StringBuilder();
			sb.append("Weight: ").append(client.getWeight()).append(" kg</br>");

			if (config.replaceOrbText())
			{
				sb.append("Run Energy: ").append(client.getEnergy() / 100).append('%');
			}
			else
			{
				sb.append("Run Time Remaining: ").append(plugin.getEstimatedRunTimeRemaining(false));
			}

			if (client.getVarbitValue(VarbitID.STAMINA_ACTIVE) == 0
				&& plugin.isRingOfEnduranceEquipped()
				&& plugin.getRingOfEnduranceCharges() == null)
			{
				sb.append("</br>Check your Ring of endurance to get the time remaining.");
			}

			int secondsUntil100 = plugin.getEstimatedRecoverTimeRemaining();
			if (secondsUntil100 > 0)
			{
				final int minutes = (int) Math.floor(secondsUntil100 / 60.0);
				final int seconds = (int) Math.floor(secondsUntil100 - (minutes * 60.0));

				sb.append("</br>").append("100% Energy In: ").append(minutes).append(':').append(StringUtils.leftPad(Integer.toString(seconds), 2, "0"));
			}

			tooltipManager.add(new Tooltip(sb.toString()));
		}

		return null;
	}
}
