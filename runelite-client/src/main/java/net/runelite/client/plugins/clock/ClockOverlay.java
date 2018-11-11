/*
 * Copyright (c) 2017, c01dc0ffee <https://github.com/c01dc0ffee>
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
package net.runelite.client.plugins.clock;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.inject.Inject;
import net.runelite.client.plugins.clock.config.HourFormat;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class ClockOverlay extends Overlay
{
	private final ClockConfig config;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	public ClockOverlay(ClockConfig config)
	{
		setPreferredPosition(OverlayPosition.BOTTOM_LEFT);
		setPriority(OverlayPriority.HIGH);

		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();

		String timeFormat = "";

		if (config.hourFormat() == HourFormat.TWELVE)
		{
			timeFormat += "hh:mm:ss";

			if (config.showMilliseconds())
			{
				timeFormat += ".S";
			}

			timeFormat += " a";
		}
		else
		{
			timeFormat += "HH:mm:ss";

			if (config.showMilliseconds())
			{
				timeFormat += ".S";
			}
		}

		String time = new SimpleDateFormat(timeFormat).format(
			Calendar.getInstance().getTime()
		);

		switch (config.font())
		{
			case SMALL:
				graphics.setFont(FontManager.getRunescapeSmallFont());
				break;
			case REGULAR:
				graphics.setFont(FontManager.getRunescapeFont());
				break;
			case BOLD:
				graphics.setFont(FontManager.getRunescapeBoldFont());
				break;
		}

		// Clock Title
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Clock")
			.build());

		// Clock Time
		panelComponent.getChildren().add(TitleComponent.builder()
			.text(time)
			.build());

		return panelComponent.render(graphics);
	}
}
