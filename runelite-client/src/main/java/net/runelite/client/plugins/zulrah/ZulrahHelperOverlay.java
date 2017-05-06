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

	private Fight fight;
	private final ZulrahPattern[] patterns;

	ZulrahHelperOverlay()
	{
		super(OverlayPosition.DYNAMIC);

		patterns = new ZulrahPattern[4];
		patterns[0] = new ZulrahPatternA();
		patterns[1] = new ZulrahPatternB();
		patterns[2] = new ZulrahPatternC();
		patterns[3] = new ZulrahPatternD();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		if (client.getGameState() != GameState.LOGGED_IN || fight == null)
		{
			return null;
		}
		//TODO: Add prayer checking and health warning

		graphics.setColor(Color.WHITE);

		// XXX race on fight here
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

	void update()
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

			ZulrahInstance temp = new ZulrahInstance(zulrah, fight.getStartLocationWorld());

			if (fight.getZulrah() == null)
			{
				System.out.println("currentInstance set to temp");
				fight.setZulrah(temp);
			}

			if (!fight.getZulrah().equals(temp))
			{
				ZulrahInstance previousInstance = fight.getZulrah();
				fight.setZulrah(temp);
				fight.nextStage();

				logger.debug("Zulrah has moved from {} -> {}, index now {}",
					previousInstance, temp, fight.getStage());
			}

			ZulrahPattern pattern = fight.getPattern();
			if (pattern == null)
			{
				int potential = 0;
				ZulrahPattern potentialPattern = null;

				for (int i = 0; i < patterns.length; ++i)
				{
					if (patterns[i].accept(fight.getStage(), fight.getZulrah()))
					{
						//System.out.println("PATTERN POTENTIAL: " + i);
						potential++;
						potentialPattern = patterns[i];
					}
				}
				if (potential == 1)
				{
					fight.setPattern(potentialPattern);
				}
			}
			else
			{
				if (pattern.canReset(fight.getStage()))
				{
					if (fight.getZulrah().equals(pattern.get(0)))
					{
						fight.reset();
						fight.setZulrah(null);//?
					}
				}
			}

		}
		catch (NullPointerException e)
		{
			//I'm so sorry
			e.printStackTrace();
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
