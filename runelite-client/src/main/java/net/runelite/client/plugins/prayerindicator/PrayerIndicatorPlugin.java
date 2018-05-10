/*
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
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
package net.runelite.client.plugins.prayerindicator;

import com.google.common.eventbus.Subscribe;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Prayer Indicator",
	enabledByDefault = false
)
public class PrayerIndicatorPlugin extends Plugin
{
	private PrayerCounter[] prayerCounter = new PrayerCounter[PrayerType.values().length];

	@Inject
	private Client client;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private SpriteManager spriteManager;

	@Override
	protected void startUp()
	{
		for (PrayerType prayerType : PrayerType.values())
		{
			prayerCounter[prayerType.ordinal()] = new PrayerCounter(this, prayerType);
			spriteManager.getSpriteAsync(prayerType.getSpriteID(), 0,
				prayerCounter[prayerType.ordinal()].imageConsumer);
		}
	}

	@Override
	protected void shutDown()
	{
		removeIndicators();
	}

	@Subscribe
	public void onPrayerChanged(VarbitChanged event)
	{
		removeIndicators();

		for (Prayer prayer : Prayer.values())
		{
			if (client.isPrayerActive(prayer))
			{
				int index = PrayerType.getPrayerType(prayer).ordinal();
				infoBoxManager.addInfoBox(prayerCounter[index]);
			}
		}
	}

	private void removeIndicators()
	{
		infoBoxManager.removeIf(entry -> entry instanceof PrayerCounter);
	}
}