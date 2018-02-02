/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.jewellery;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.Getter;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

import java.util.Arrays;
import java.util.Collection;

@PluginDescriptor(
	name = "Jewellery plugin"
)
public class JewelleryPlugin extends Plugin
{
	@Getter
	private boolean enchantedClicked;

	@Getter
	private String enchantType;

	@Inject
	private EnchantOverlay enchantOverlay;

	@Inject
	JewelleryConfig config;

	@Inject
	JewelleryCountOverlay overlay;

	@Override
	public void configure(Binder binder)
	{
		binder.bind(JewelleryCountOverlay.class);
	}

	@Provides
	JewelleryConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(JewelleryConfig.class);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, enchantOverlay);
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!config.showEnchant())
		{
			return;
		}

		if (event.getMenuOption().equals("Cast") && event.getMenuTarget().endsWith("Enchant"))
		{
			//Remove unnecessary text
			enchantType = event.getMenuTarget().replace(" Enchant", "").replace("<col=00ff00>", "");
			enchantedClicked = true;
		}
		else
		{
			enchantType = "";
			enchantedClicked = false;
		}
	}
}
