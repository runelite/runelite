/*
 * Copyright (c) 2018, NotFoxtrot <http://github.com/NotFoxtrot>
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
package net.runelite.client.plugins.pyramidplunder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class PyramidPlunderOverlay extends Overlay
{
	private final Client client;
	private final PanelComponent panelComponent = new PanelComponent();

	private PyramidTimer timer;

	@Inject
	PyramidPlunderOverlay(Client client)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Widget pyramidPlunderInfo = client.getWidget(WidgetInfo.PYRAMID_PLUNDER_DATA);

		if (pyramidPlunderInfo == null)
		{
			timer = null;
			return null;
		}

		panelComponent.getLines().clear();

		pyramidPlunderInfo.setHidden(true);

		if (timer == null)
		{
			startTimer();
		}

		panelComponent.getLines().add(new PanelComponent.Line(
			"Time left: ", Color.WHITE, timer.getText(), timer.getTextColor()
		));

		panelComponent.getLines().add(new PanelComponent.Line(
			"Room: ", String.valueOf(client.getSetting(Varbits.PYRAMID_PLUNDER_ROOM)) + "/8"
		));

		return panelComponent.render(graphics);
	}

	public void showWidget()
	{
		Widget pyramidPlunderInfo = client.getWidget(WidgetInfo.PYRAMID_PLUNDER_DATA);

		if (pyramidPlunderInfo != null)
		{
			pyramidPlunderInfo.setHidden(false);
		}
	}

	private void startTimer()
	{
		int plunderingTime = client.getSetting(Varbits.PYRAMID_PLUNDER_TIMER);
		int timeLeft = (int) ((505 - plunderingTime) * 0.6);

		timer = new PyramidTimer(timeLeft);
	}
}
