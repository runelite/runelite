/*
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.hydra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class BabyHydraOverlay extends Overlay
{
	private final BabyHydraPlugin plugin;

	@Inject
	private Client client;

	@Inject
	private BabyHydraOverlay(final BabyHydraPlugin plugin)
	{
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (NPC hydra : client.getNpcs())
		{
			if (hydra == null || hydra.getName() == null)
			{
				continue;
			}
			if (hydra.getName().equalsIgnoreCase("Hydra") && plugin.getHydras().containsKey(hydra.getIndex()))
			{
				int val = plugin.getHydras().get(hydra.getIndex());
				if (val != 0)
				{
					if (plugin.isBoldText())
					{
						graphics.setFont(FontManager.getRunescapeBoldFont());
					}
					if (plugin.getHydraattacks().containsKey(hydra.getIndex()))
					{
						int attack = plugin.getHydraattacks().get(hydra.getIndex());

						Point textLocation = hydra.getCanvasTextLocation(graphics, "TEMP!!", hydra.getLogicalHeight() + 100);

						if (textLocation != null && attack == 8261)
						{
							if (val == 3)
							{
								OverlayUtil.renderTextLocation(graphics, textLocation, "MAGE", Color.BLUE);
							}
							else
							{
								OverlayUtil.renderTextLocation(graphics, textLocation, "RANGE", Color.GREEN);
							}
						}
						else if (textLocation != null && attack == 8262)
						{
							if (val == 3)
							{
								OverlayUtil.renderTextLocation(graphics, textLocation, "RANGE", Color.GREEN);
							}
							else
							{
								OverlayUtil.renderTextLocation(graphics, textLocation, "MAGE", Color.BLUE);
							}
						}
					}
					Point hydraPoint = hydra.getCanvasTextLocation(graphics, Integer.toString(val), hydra.getLogicalHeight() + 40);
					if (hydraPoint != null)
					{
						OverlayUtil.renderTextLocation(graphics, hydraPoint, Integer.toString(val), Color.WHITE);
					}
				}
			}

		}
		graphics.setFont(FontManager.getRunescapeFont());
		return null;
	}
}
