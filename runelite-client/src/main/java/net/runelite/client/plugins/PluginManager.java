/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.boosts.Boosts;
import net.runelite.client.plugins.bosstimer.BossTimers;
import net.runelite.client.plugins.debug.Debug;
import net.runelite.client.plugins.devtools.DevTools;
import net.runelite.client.plugins.fpsinfo.FPS;
import net.runelite.client.plugins.gronditems.GroundItems;
import net.runelite.client.plugins.hiscore.Hiscore;
import net.runelite.client.plugins.idlenotifier.IdleNotifier;
import net.runelite.client.plugins.opponentinfo.OpponentInfo;
import net.runelite.client.plugins.xtea.Xtea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginManager
{
	private static final Logger logger = LoggerFactory.getLogger(PluginManager.class);

	private final RuneLite runelite;
	private final List<Plugin> plugins = new ArrayList<>();

	public PluginManager(RuneLite runelite)
	{
		this.runelite = runelite;
	}

	public void loadAll()
	{
		load(new Boosts());
		load(new OpponentInfo());
		load(new FPS());
		load(new Hiscore());
		load(new BossTimers());
		load(new Xtea());
		load(new IdleNotifier());

		if (RuneLite.getOptions().has("developer-mode"))
		{
			logger.info("Loading developer plugins");

			load(new Debug());
			load(new GroundItems());
			load(new DevTools());
		}
	}

	private void load(Plugin plugin)
	{
		plugins.add(plugin);
		runelite.getEventBus().register(plugin);
	}

	public Collection<Plugin> getPlugins()
	{
		return plugins;
	}
}
