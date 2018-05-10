/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.SpritePixels;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "UI Customizer"
)
public class UICustomizerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private UICustomizerConfig config;

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
		removeSkin();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged e)
	{
		if (e.getGroup().equals("uiCustomizer"))
		{
			adjustWidth();
			loadSkin();
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widget)
	{
		adjustWidth();
	}

	private void adjustWidth()
	{
		//Resize width of widgets to 33 so highlight sprite won't extend to adjacent widgets
		setWidgetSize(548, 32, 33, null);
		setWidgetSize(548, 50, 33, null);
		setWidgetSize(163, 53, 33, null);
		setWidgetSize(161, 53, 33, null);
	}

	private void setWidgetSize(int groupID, int childID, Integer width, Integer height)
	{
		if (client.getWidget(groupID, childID) != null)
		{
			if (width != null)
			{
				client.getWidget(groupID, childID).setWidth(width);
			}

			if (height != null)
			{
				client.getWidget(groupID, childID).setHeight(height);
			}
		}
	}

	private void loadSkin()
	{
		removeSkin();

		if(config.skin() == Skin.NONE)
		{
			return;
		}

		Map<Integer, SpritePixels> overrides = new HashMap<>();

		File sprites = new File(getClass().getResource(config.skin().toString()).getFile());
		File[] files = sprites.listFiles();

		if (files != null)
		{
			for (File file : files)
			{
				if (!file.isFile())
				{
					continue;
				}
				log.debug(config.skin().toString() + "\\" + file.getName());
				String name = file.getName();
				name = name.substring(0, name.length() - 4);

				try
				{
					int spriteId = Integer.parseInt(name);

					SpritePixels pixels = getSpritePixels(file.getName());
					overrides.put(spriteId, pixels);
				}
				catch (NumberFormatException e)
				{
					e.printStackTrace();
				}
			}

			client.setSpriteOverrides(overrides);
		}

		if(config.skin() == Skin.AROUND_2005)
		{
			Map<Integer, SpritePixels> widgetOverrides = new HashMap<>();

			SpritePixels topSprite = getSpritePixels( "\\widget\\1030_top.png");
			widgetOverrides.put(WidgetInfo.PACK(548, 49), topSprite);
			widgetOverrides.put(WidgetInfo.PACK(548, 50), topSprite);
			widgetOverrides.put(WidgetInfo.PACK(548, 52), topSprite);
			widgetOverrides.put(WidgetInfo.PACK(548, 53), topSprite);

			widgetOverrides.put(WidgetInfo.PACK(548, 51),
				getSpritePixels("\\widget\\1030_middle.png"));

			SpritePixels bottomSprite = getSpritePixels("\\widget\\1030_bottom.png");
			widgetOverrides.put(WidgetInfo.PACK(548, 32), bottomSprite);
			widgetOverrides.put(WidgetInfo.PACK(548, 33), bottomSprite);
			widgetOverrides.put(WidgetInfo.PACK(548, 35), bottomSprite);
			widgetOverrides.put(WidgetInfo.PACK(548, 36), bottomSprite);

			widgetOverrides.put(WidgetInfo.PACK(548, 34),
				getSpritePixels("\\widget\\1030_middle_bottom.png"));

			client.setWidgetSpriteOverrides(widgetOverrides);
		}
	}

	private void removeSkin()
	{
		client.setSpriteOverrides(null);
		client.setWidgetSpriteOverrides(null);
	}

	private SpritePixels getSpritePixels(String path)
	{
		synchronized (ImageIO.class)
		{
			try
			{
				BufferedImage image = ImageIO.read(getClass().getResourceAsStream(config.skin().toString()
					+ "\\" + path));
				return fileToSpritePixels(image);
			}
			catch (IOException ex)
			{
				log.debug("Unable to load image: " + ex);
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
			log.debug("PixelGrabber was interrupted: " + ex);
		}

		return client.createSpritePixels(pixels, image.getWidth(), image.getHeight());
	}
}