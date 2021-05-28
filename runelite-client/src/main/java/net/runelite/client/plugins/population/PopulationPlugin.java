/*
 * Copyright (c) 2017, Levi <me@levischuck.com>
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
package net.runelite.client.plugins.population;

import com.google.inject.Inject;
import net.runelite.api.events.FocusChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.overlay.OverlayManager;

/**
 * If you're doing something that requires quality server performance
 * you're going to want ~500 or less people on your world. This will
 * display your current world population as often as we can grab it
 * color coded for low, medium, and high pop's.
 *
 * low (green): <500 ppl
 * medium (yellow): Between 500 and 900 ppl
 * high (red): >900 ppl
 */
@PluginDescriptor(
	name = "Population Display",
	description = "Show current world population, color  coded to performance.",
	tags = {"world", "population", "performance"},
	enabledByDefault = false
)
public class PopulationPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PopulationDisplay overlay;

	@Inject
	private PopulationDrawListener drawListener;

	@Inject
	private DrawManager drawManager;

	@Subscribe
	public void onFocusChanged(FocusChanged event)
	{
		drawListener.onFocusChanged(event);
		overlay.onFocusChanged(event);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		drawManager.registerEveryFrameListener(drawListener);
		drawListener.reloadConfig();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		drawManager.unregisterEveryFrameListener(drawListener);
	}
}
