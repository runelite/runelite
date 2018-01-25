/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.zoom;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Script;
import net.runelite.api.events.ScriptLoaded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Camera zoom unlimiter"
)
@Slf4j
public class ZoomPlugin extends Plugin
{
	@Inject
	private ZoomConfig zoomConfig;

	/*
	This edits the runescripts that handle scroll wheel zooming (42), and the zooming from the options interface
	Script 1048 is the click handler and 1049 is the class that moves the button in the options panel
	 */

	private static final int DEFAULT_RESIZABLE_ZOOM_LIMIT = 175;
	private final FindAndReplace resizable = new FindAndReplace(
		operand -> operand == DEFAULT_RESIZABLE_ZOOM_LIMIT,
		() -> zoomConfig.enabled() ? 70 : DEFAULT_RESIZABLE_ZOOM_LIMIT,
		42, 1048, 1049, 909);

	private static final int DEFAULT_FIXED_ZOOM_LIMIT = 195;
	private final FindAndReplace fixed = new FindAndReplace(
		operand -> operand == DEFAULT_FIXED_ZOOM_LIMIT,
		() -> zoomConfig.enabled() ? 95 : DEFAULT_FIXED_ZOOM_LIMIT,
		42, 1048, 1049, 909);

	@Provides
	ZoomConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ZoomConfig.class);
	}

	@Subscribe
	public void onScriptLoaded(ScriptLoaded l)
	{
		Script script = l.getScript();
		resizable.apply(script);
		fixed.apply(script);
	}
}
