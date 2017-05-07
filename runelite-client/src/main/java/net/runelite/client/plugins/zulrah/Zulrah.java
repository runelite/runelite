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

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Query;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPattern;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternA;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternB;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternC;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternD;
import net.runelite.client.ui.overlay.Overlay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Zulrah extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(Zulrah.class);

	private static final String ZULRAH = "Zulrah";

	private final Client client = RuneLite.getClient();

	private final StatusOverlay overlay = new StatusOverlay(this);
	private final TileOverlay tileOverlay = new TileOverlay(this);

	private final ZulrahPattern[] patterns = new ZulrahPattern[]
	{
		new ZulrahPatternA(),
		new ZulrahPatternB(),
		new ZulrahPatternC(),
		new ZulrahPatternD()
	};

	private Fight fight;

	private ScheduledFuture<?> future;

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, tileOverlay);
	}

	@Override
	protected void startUp() throws Exception
	{
		ScheduledExecutorService executor = RuneLite.getRunelite().getExecutor();
		future = executor.scheduleAtFixedRate(this::update, 100, 100, TimeUnit.MILLISECONDS);
	}

	@Override
	protected void shutDown() throws Exception
	{
		future.cancel(true);
	}

	private synchronized void update()
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
		Query query = new NPCQuery()
			.nameEquals(ZULRAH);
		NPC[] result = client.runQuery(query);
		return result.length == 1 ? result[0] : null;
	}

	public Fight getFight()
	{
		return fight;
	}
}
