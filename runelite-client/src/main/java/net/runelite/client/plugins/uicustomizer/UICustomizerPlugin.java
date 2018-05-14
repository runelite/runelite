/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.uicustomizer;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.SpriteID;
import net.runelite.api.SpritePixels;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.ResizeableChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "UI Customizer",
	enabledByDefault = false
)
public class UICustomizerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private UICustomizerConfig config;

	@Inject
	private SpriteManager spriteManager;

	@Provides
	UICustomizerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(UICustomizerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		loadSkin();
	}

	@Override
	protected void shutDown() throws Exception
	{
		restoreDimensions();
		removeSkin();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged config)
	{
		if (config.getGroup().equals("uiCustomizer"))
		{
			loadSkin();
		}
	}

	@Subscribe
	public void onResizableChanged(ResizeableChanged event)
	{
		adjustDimensions();
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		adjustDimensions();
	}

	private void loadSkin()
	{
		removeSkin();

		Map<Integer, SpritePixels> overrides = new HashMap<>();

		for (SpriteOverride spriteOverride : SpriteOverride.values())
		{
			String path = config.skin().toString() + "/" + spriteOverride.getSpriteID() + ".png";

			if (spriteOverride.getSkin() == config.skin())
			{
				synchronized (ImageIO.class)
				{

					try
					{
						InputStream in = UICustomizerPlugin.class.getResourceAsStream(path);
						BufferedImage image = ImageIO.read(in);

						if (image != null)
						{
							SpritePixels spritePixels = fileToSpritePixels(image);

							if (spriteOverride.getSpriteID() == SpriteID.COMPASS_TEXTURE)
							{
								client.setCompass(spritePixels);
							}
							else
							{
								overrides.put(spriteOverride.getSpriteID(), spritePixels);
							}
						}
					}
					catch (IOException ex)
					{
						log.debug("Failed to load: ", ex);
					}
				}

				client.setSpriteOverrides(overrides);
			}
		}

		setupWidgets();
	}

	private void setupWidgets()
	{
		Map<Integer, SpritePixels> widgetOverrides = new HashMap<>();

		for (WidgetOverride widgetOverride : WidgetOverride.values())
		{
			if (widgetOverride.getSkin() == config.skin())
			{
				String path = config.skin().toString() + "/widget/" + widgetOverride.getName() + ".png";

				SpritePixels spritePixels = getSpritePixels(path);

				for (WidgetInfo widgetInfo : widgetOverride.getWidgetInfo())
				{
					widgetOverrides.put(widgetInfo.getPackedId(), spritePixels);
				}
			}
		}

		client.setWidgetSpriteOverrides(widgetOverrides);
		adjustDimensions();
	}

	private SpritePixels getSpritePixels(String path)
	{
		synchronized (ImageIO.class)
		{
			try
			{
				log.debug("Loading skin: " + config.skin().toString() + " - file: " + path);

				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(path));
				return fileToSpritePixels(image);
			}
			catch (IOException ex)
			{
				log.debug("Unable to load image: ", ex);
			}
		}
		return null;
	}

	private SpritePixels fileToSpritePixels(BufferedImage image)
	{
		int[] pixels = new int[image.getWidth() * image.getHeight()];

		try
		{
			new PixelGrabber(image, 0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth())
				.grabPixels();
		}
		catch (InterruptedException ex)
		{
			log.debug("PixelGrabber was interrupted: ", ex);
		}

		return client.createSpritePixels(pixels, image.getWidth(), image.getHeight());
	}

	private void adjustDimensions()
	{
		restoreDimensions();

		for (WidgetOffset widgetOffset : WidgetOffset.values())
		{
			if (widgetOffset.getSkin() != config.skin())
			{
				continue;
			}

			Widget widget = client.getWidget(widgetOffset.getWidgetInfo());

			if (widget != null)
			{
				if (widgetOffset.getOffsetX() != null)
				{
					widget.setRelativeX(widgetOffset.getOffsetX());
				}
				if (widgetOffset.getOffsetY() != null)
				{
					widget.setRelativeY(widgetOffset.getOffsetY());
				}
				if (widgetOffset.getWidth() != null)
				{
					widget.setWidth(widgetOffset.getWidth());
				}
				if (widgetOffset.getHeight() != null)
				{
					widget.setHeight(widgetOffset.getHeight());
				}
			}
		}
	}

	private void restoreDimensions()
	{
		for (WidgetOffset widgetOffset : WidgetOffset.values())
		{
			Widget widget = client.getWidget(widgetOffset.getWidgetInfo());

			if (widget != null)
			{
				widget.setRelativeX(widget.getOriginalX());
				widget.setRelativeY(widget.getOriginalY());
				widget.setHeight(widget.getOriginalHeight());
				widget.setWidth(widget.getOriginalWidth());
			}
		}
	}

	private void removeSkin()
	{
		BufferedImage compassImage = spriteManager.getSprite(SpriteID.COMPASS_TEXTURE, 0);

		if (compassImage != null)
		{
			SpritePixels compass = fileToSpritePixels(compassImage);
			client.setCompass(compass);
		}

		client.setSpriteOverrides(null);
		client.setWidgetSpriteOverrides(null);
	}
}