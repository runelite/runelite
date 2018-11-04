/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.aprilfirst;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;

@Slf4j
public class AprilFirstOverlay extends Overlay
{
	private static final String MESSAGE_SUFFIX = "<col=9090ff>*</col>";
	private static final Pattern MESSAGE_PARSER = Pattern.compile(".*: (.*)<col=.*>\\*</col>");

	private final Client client;
	private final AprilFirstPlugin plugin;

	private String fakeName;
	private String fakeMessage;

	private int defenceLevel;

	@Inject
	AprilFirstOverlay(Client client, AprilFirstPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;

		fakeName = plugin.getFakeName();
		defenceLevel = plugin.getDefenceLevel();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Widget w = client.getWidget(WidgetInfo.CHATBOX_INPUT);

		if (w != null && !w.getText().equals(fakeMessage))
		{
			fakeName = plugin.getFakeName();

			String message = "";
			Matcher m = MESSAGE_PARSER.matcher(w.getText());
			if (m.matches())
			{
				message = m.group(1);
			}

			log.info("Reapplying fake name...");
			fakeMessage = fakeName + message + MESSAGE_SUFFIX;
			w.setText(fakeMessage);
		}

		if (defenceLevel == -1)
		{
			defenceLevel = plugin.getDefenceLevel();
		}
		if (defenceLevel == 1)
		{
			Widget w2 = client.getWidget(WidgetInfo.DEFENCE_SKILL_ICON);
			Widget[] entries = w2.getChildren();
			entries[3].setText("2");
			entries[4].setText("2");
			w2.setChildren(entries);
		}

		return null;
	}
}
