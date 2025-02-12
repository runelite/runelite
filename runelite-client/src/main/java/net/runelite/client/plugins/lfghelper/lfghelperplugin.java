/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.lfghelper;

import com.google.inject.Provides;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.ClientToolbar;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@PluginDescriptor(
	name = "LFG Helper",
	description = "Helps organize LFG posts for Discord",
	tags = {"lfg", "discord", "group"},
	enabledByDefault = false // This should disable it by default
)
public class lfghelperplugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar; // Inject the client toolbar

	@Inject
	private lfghelperconfig config;

	private lfghelperpanel panel;
	private NavigationButton navButton; // Sidebar button

	@Override
	protected void startUp() throws Exception
	{
		// Initialize the panel with the required config
		panel = new lfghelperpanel(config, client);  // Pass config object here

		// Load the image as BufferedImage
		try
		{
			BufferedImage originalImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/net/runelite/client/plugins/lfghelper/swords.png")));

			if (originalImage == null)
			{
				log.error("Failed to load image!");
				return;
			}

			log.info("Icon loaded successfully.");

			int width = originalImage.getWidth();
			int height = originalImage.getHeight();
			log.info("Original image dimensions: width = " + width + ", height = " + height);

			Image resizedImage = originalImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);

			int resizedWidth = resizedImage.getWidth(null);
			int resizedHeight = resizedImage.getHeight(null);
			log.info("Resized image dimensions: width = " + resizedWidth + ", height = " + resizedHeight);

			if (resizedWidth <= 0 || resizedHeight <= 0)
			{
				log.error("Resized image has invalid dimensions.");
				return;
			}

			BufferedImage bufferedImage = new BufferedImage(resizedWidth, resizedHeight, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(resizedImage, 0, 0, null);
			g.dispose();

			// Create the navigation button using the BufferedImage
			navButton = NavigationButton.builder()
				.tooltip("LFG Helper")
				.icon(bufferedImage) // Pass the BufferedImage wrapped in ImageIcon
				.panel(panel) // Assign the panel to the button
				.build();

			// Add the button to the client toolbar
			clientToolbar.addNavigation(navButton);

			log.info("LFG Helper started!");
		}
		catch (IOException e)
		{
			log.error("Error loading image: " + e.getMessage(), e);
		}
	}


	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton); // Remove the sidebar button on shutdown
	}

	@Provides
	lfghelperconfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(lfghelperconfig.class);
	}
}
