/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.prayerflicker;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.cannon.CannonConfig;
import net.runelite.client.plugins.prayerflicker.*;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.HotkeyListener;

import javax.inject.Inject;

@PluginDescriptor(
	name = "Auto Prayer Flicker",
	description = "Auto prayer flicker",
	tags = {"combat", "flicking", "overlay"}
)
public class PrayerFlickerPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private boolean prayersActive = false;
	boolean PluginOn = false;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private net.runelite.client.plugins.prayerflicker.PrayerFlicker prayFlick;

	@Inject
	private PrayerFlickerConfig config;

	@Inject
	private ItemManager itemManager;

	@Inject
	private KeyManager keyManager;

	private final HotkeyListener hotkeyListener = new HotkeyListener(()->this.config.hotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			if ( PluginOn == true )
			{
				prayFlick.DeactivatePrayers();
			}
			prayFlick.SwitchFlickingState( !PluginOn );
		}
	};

	@Provides
	PrayerFlickerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PrayerFlickerConfig.class);
	}

	@Override
	protected void startUp()
	{
		keyManager.registerKeyListener(hotkeyListener);
		overlayManager.add(prayFlick);
		PluginOn = false;
	}

	@Override
	protected void shutDown()
	{
		keyManager.unregisterKeyListener(hotkeyListener);
		overlayManager.remove(prayFlick);
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		prayersActive = isAnyPrayerActive();

		if ( PluginOn )
		{
			prayFlick.onTick( prayersActive );
		}
	}

	private boolean isAnyPrayerActive()
	{
		for ( Prayer pray : Prayer.values() ) //Check if any prayers are active
		{
			if ( client.isPrayerActive(pray) )
			{
				return true;
			}
		}
		return false;
	}
}
