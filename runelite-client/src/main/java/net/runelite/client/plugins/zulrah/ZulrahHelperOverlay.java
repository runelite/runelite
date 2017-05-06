/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.zulrah;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPattern;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternA;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternB;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternC;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternD;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ZulrahHelperOverlay extends Overlay
{
	private static final Logger logger = LoggerFactory.getLogger(ZulrahHelperOverlay.class);

	private final Client client = RuneLite.getClient();

	private final ZulrahPattern[] patterns = new ZulrahPattern[]
	{
		new ZulrahPatternA(),
		new ZulrahPatternB(),
		new ZulrahPatternC(),
		new ZulrahPatternD()
	};

	private Fight fight;

	ZulrahHelperOverlay()
	{
		super(OverlayPosition.DYNAMIC);
	}

	@Override
	public synchronized Dimension render(Graphics2D graphics)
	{

		if (client.getGameState() != GameState.LOGGED_IN || fight == null)
		{
			return null;
		}

		//TODO: Add prayer checking and health warning
		graphics.setColor(Color.WHITE);

		ZulrahPattern pattern = fight.getPattern();
		if (pattern == null)
		{
			// can draw at least the starting place here?
			graphics.drawString("Unknown Pattern", 200, 200);
		}
		else
		{
			pattern.render(client, graphics, fight.getStartLocationWorld(), fight.getStage());
		}

		return null;
	}

	synchronized void update()
	{
		try
		{
			NPC zulrah = findZulrah();

			if (zulrah == null)
			{
				if (fight != null)
				{
					logger.debug("Fight has ended!");

					fight = null;
				}
				return;
			}

			if (fight == null)
			{
				Point startTile = zulrah.getLocalLocation();
				startTile = Perspective.localToWorld(client, startTile);

				// Render thread starts once this is assigned
				fight = new Fight(startTile);

				logger.debug("Fight has begun!");
			}

			ZulrahInstance currentZulrah = ZulrahInstance.of(zulrah, fight.getStartLocationWorld());

			if (fight.getZulrah() == null)
			{
				fight.setZulrah(currentZulrah);
			}
			else if (!fight.getZulrah().equals(currentZulrah))
			{
				ZulrahInstance previousInstance = fight.getZulrah();
				fight.setZulrah(currentZulrah);
				fight.nextStage();

				logger.debug("Zulrah has moved from {} -> {}, index now {}",
					previousInstance, currentZulrah, fight.getStage());
			}

			ZulrahPattern pattern = fight.getPattern();
			if (pattern == null)
			{
				int potential = 0;
				ZulrahPattern potentialPattern = null;

				for (ZulrahPattern p : patterns)
				{
					if (p.stageMatches(fight.getStage(), fight.getZulrah()))
					{
						potential++;
						potentialPattern = p;
					}
				}

				if (potential == 1)
				{
					logger.debug("Zulrah pattern identified: {}", potentialPattern);

					fight.setPattern(potentialPattern);
				}
			}
			else
			{
				if (pattern.canReset(fight.getStage()))
				{
					if (fight.getZulrah().equals(pattern.get(0)))
					{
						logger.debug("Fight has reset");

						fight.reset();
					}
				}
			}

		}
		catch (Exception ex)
		{
			logger.debug(null, ex);
		}

	}

	private NPC findZulrah()
	{
		NPC[] npcs = client.getNpcs();

		for (NPC npc : npcs)
		{
			if (npc == null)
			{
				continue;
			}
			if (npc.getName().equals("Zulrah"))
			{
				return npc;
			}
		}
		return null;
	}
}
