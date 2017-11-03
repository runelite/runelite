/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Query;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPattern;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternA;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternB;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternC;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPatternD;
import net.runelite.client.plugins.zulrah.phase.ZulrahPhase;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.temporal.ChronoUnit;

@PluginDescriptor(
	name = "Zulrah plugin"
)
public class Zulrah extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(Zulrah.class);

	private final RuneLite runelite = RuneLite.getRunelite();
	private final ZulrahConfig config = RuneLite.getRunelite().getConfigManager().getConfig(ZulrahConfig.class);
	private final Client client = RuneLite.getClient();
	private final ZulrahOverlay overlay = new ZulrahOverlay(this);
	private final ZulrahPattern[] patterns = new ZulrahPattern[]{
			new ZulrahPatternA(),
			new ZulrahPatternB(),
			new ZulrahPatternC(),
			new ZulrahPatternD()
	};

	private ZulrahInstance instance;

	@Override
	protected void startUp() throws Exception
	{

	}

	@Override
	protected void shutDown() throws Exception
	{

	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Schedule(
		period = 600,
		unit = ChronoUnit.MILLIS
	)
	public void update()
	{
		if (!config.enabled() || client == null || client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		NPC zulrah = findZulrah();
		if (zulrah == null)
		{
			if (instance != null)
			{
				logger.debug("Zulrah encounter has ended.");
				instance = null;
			}
			return;
		}

		if (instance == null)
		{
			instance = new ZulrahInstance(zulrah);
			logger.debug("Zulrah encounter has started.");
		}

		ZulrahPhase currentPhase = ZulrahPhase.valueOf(zulrah, instance.getStartLocation());
		if (instance.getPhase() == null)
		{
			instance.setPhase(currentPhase);
		}
		else if (!instance.getPhase().equals(currentPhase))
		{
			ZulrahPhase previousPhase = instance.getPhase();
			instance.setPhase(currentPhase);
			instance.nextStage();

			logger.debug("Zulrah phase has moved from {} -> {}, stage: {}", previousPhase, currentPhase, instance.getStage());
		}

		ZulrahPattern pattern = instance.getPattern();
		if (pattern == null)
		{
			int potential = 0;
			ZulrahPattern potentialPattern = null;

			for (ZulrahPattern p : patterns)
			{
				if (p.stageMatches(instance.getStage(), instance.getPhase()))
				{
					potential++;
					potentialPattern = p;
				}
			}

			if (potential == 1)
			{
				logger.debug("Zulrah pattern identified: {}", potentialPattern);

				instance.setPattern(potentialPattern);
			}
		}
		else if (pattern.canReset(instance.getStage()) && (instance.getPhase() == null || instance.getPhase().equals(pattern.get(0))))
		{
			logger.debug("Zulrah pattern has reset.");

			instance.reset();
		}
	}

	private NPC findZulrah()
	{
		Query query = new NPCQuery().nameEquals("Zulrah");
		NPC[] result = runelite.runQuery(query);
		return result.length == 1 ? result[0] : null;
	}

	public ZulrahInstance getInstance()
	{
		return instance;
	}
}
