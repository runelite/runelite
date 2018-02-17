/*
 * Copyright (c) 2016-2017, Seth <Sethtroll3@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.runelite.client.plugins.cluescrolls;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class ClueScrollOverlay extends Overlay
{
	private static final Duration WAIT_DURATION = Duration.ofMinutes(4);

	private final Client client;
	private final PanelComponent panelComponent = new PanelComponent();

	ClueScroll clue;
	Instant clueTimeout;

	@Inject
	public ClueScrollOverlay(Client client)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if (clue == null)
		{
			return null;
		}

		if (clueTimeout == null || Instant.now().compareTo(clueTimeout.plus(WAIT_DURATION)) >= 0)
		{
			return null;
		}

		panelComponent.getLines().clear();
		panelComponent.setTitle("Required items");

		if (clue.getIds().length == 0)
		{
			panelComponent.getLines().add(new PanelComponent.Line("None", ""));
		}
		else
		{
			for (int id : clue.getIds())
			{
				ItemComposition clueItem = client.getItemDefinition(id);

				if (clueItem == null)
				{
					continue;
				}

				panelComponent.getLines().add(new PanelComponent.Line(clueItem.getName(), ""));
			}
		}

		return panelComponent.render(graphics, parent);
	}
}
