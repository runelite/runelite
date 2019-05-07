/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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
package net.runelite.client.plugins.customcursor;

import com.google.inject.Provides;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@PluginDescriptor(
	name = "Custom Cursor",
	description = "Replaces your mouse cursor image",
	enabledByDefault = false
)
public class CustomCursorPlugin extends Plugin
{
	@Inject
	private ClientUI clientUI;

	@Inject
	private CustomCursorConfig config;

	@Provides
	CustomCursorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CustomCursorConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateCursor();
	}

	@Override
	protected void shutDown()
	{
		clientUI.resetCursor();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("customcursor"))
		{
			if (event.getKey().equals("cursorStyle"))
			{
				useSelectedCursor();
			}
			else if (event.getKey().equals("customImage"))
			{
				updateCursor();
			}
		}
	}

	private void updateCursor()
	{
		// Custom image file takes precedent
		File customImageFile = config.customImageFile();
		if (customImageFile.exists() && !customImageFile.isDirectory())
		{
			try
			{
				BufferedImage image = ImageIO.read(customImageFile);
				clientUI.setCursor(image, "Custom");
			}
			catch (IOException e)
			{
				useSelectedCursor();
			}
		}
		else
		{
			useSelectedCursor();
		}
	}

	private void useSelectedCursor()
	{
		CustomCursor selectedCursor = config.selectedCursor();
		clientUI.setCursor(selectedCursor.getCursorImage(), selectedCursor.toString());
	}
}