/*
 * Copyright (c) 2019, Alex <https://github.com/Barragek0>
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
package net.runelite.client.plugins.hamstoreroom;

import java.awt.Color;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.client.ui.overlay.OverlayUtil;

class HamOverlay extends Overlay
{
	private final Client client;
	private final HamPlugin hamPlugin;

	@Inject
	private HamOverlay(Client client, HamPlugin hamPlugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.hamPlugin = hamPlugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getLocalPlayer().getWorldLocation().getRegionID() != 10321)
		{
			return null;
		}

		if (hamPlugin.getSteelObject().getCanvasTilePoly() != null)
		{
			OverlayUtil.renderPolygon(graphics, hamPlugin.getSteelObject().getCanvasTilePoly(), hamPlugin.isDrawSteel() ? Color.GREEN.brighter() : Color.RED.brighter());
		}
		if (hamPlugin.getIronObject().getCanvasTilePoly() != null)
		{
			OverlayUtil.renderPolygon(graphics, hamPlugin.getIronObject().getCanvasTilePoly(), hamPlugin.isDrawIron() ? Color.GREEN.brighter() : Color.RED.brighter());
		}
		if (hamPlugin.getSilverObject().getCanvasTilePoly() != null)
		{
			OverlayUtil.renderPolygon(graphics, hamPlugin.getSilverObject().getCanvasTilePoly(), hamPlugin.isDrawSilver() ? Color.GREEN.brighter() : Color.RED.brighter());
		}
		if (hamPlugin.getBronzeObject().getCanvasTilePoly() != null)
		{
			OverlayUtil.renderPolygon(graphics, hamPlugin.getBronzeObject().getCanvasTilePoly(), hamPlugin.isDrawBronze() ? Color.GREEN.brighter() : Color.RED.brighter());
		}
		return null;
	}


}
