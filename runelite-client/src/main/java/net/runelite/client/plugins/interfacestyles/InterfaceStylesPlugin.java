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
package net.runelite.client.plugins.interfacestyles;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.HealthBar;
import net.runelite.api.SpriteID;
import net.runelite.api.Sprite;
import net.runelite.api.events.BeforeMenuRender;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.PostHealthBar;
import net.runelite.api.events.WidgetPositioned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ImageUtil;

@Slf4j
@PluginDescriptor(
	name = "Interface Styles",
	description = "Change the interface style to the 2005/2010 interface",
	tags = {"2005", "2010", "skin", "theme", "ui"},
	enabledByDefault = false
)
@Singleton
public class InterfaceStylesPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private InterfaceStylesConfig config;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private EventBus eventBus;

	private Sprite[] defaultCrossSprites;

	private Skin skin;
	private boolean hdHealthBars;
	private boolean hdMenu;
	private boolean rsCrossSprites;

	@Provides
	InterfaceStylesConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InterfaceStylesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();
		clientThread.invoke(this::updateAllOverrides);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		clientThread.invoke(() ->
		{
			restoreWidgetDimensions();
			removeGameframe();
			restoreHealthBars();
			restoreCrossSprites();
		});
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(WidgetPositioned.class, this, this::onWidgetPositioned);
		eventBus.subscribe(PostHealthBar.class, this, this::onPostHealthBar);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(BeforeMenuRender.class, this, this::onBeforeMenuRender);
	}

	private void onConfigChanged(ConfigChanged config)
	{
		if (config.getGroup().equals("interfaceStyles"))
		{
			updateConfig();
			clientThread.invoke(this::updateAllOverrides);
		}
	}

	private void onWidgetPositioned(WidgetPositioned widgetPositioned)
	{
		adjustWidgetDimensions();
	}

	private void onPostHealthBar(PostHealthBar postHealthBar)
	{
		if (!this.hdHealthBars)
		{
			return;
		}

		HealthBar healthBar = postHealthBar.getHealthBar();
		HealthbarOverride override = HealthbarOverride.get(healthBar.getHealthBarFrontSpriteId());

		// Check if this is the health bar we are replacing
		if (override != null)
		{
			// Increase padding to show some more green at very low hp percentages
			healthBar.setPadding(override.getPadding());
		}
	}

	private void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGIN_SCREEN)
		{
			return;
		}

		/*
		 * The cross sprites aren't loaded yet when the initial config change event is received.
		 * So run the overriding for cross sprites when we reach the login screen,
		 * at which point the cross sprites will have been loaded.
		 */
		overrideCrossSprites();
	}

	private void updateAllOverrides()
	{
		removeGameframe();
		overrideSprites();
		overrideWidgetSprites();
		restoreWidgetDimensions();
		adjustWidgetDimensions();
		overrideHealthBars();
		overrideCrossSprites();
	}

	private void onBeforeMenuRender(BeforeMenuRender event)
	{
		if (this.hdMenu)
		{
			client.draw2010Menu();
			event.consume();
		}
	}

	private void overrideSprites()
	{
		for (SpriteOverride spriteOverride : SpriteOverride.values())
		{
			for (Skin skin : spriteOverride.getSkin())
			{
				if (skin == this.skin)
				{
					String file = this.skin.toString() + "/" + spriteOverride.getSpriteID() + ".png";
					Sprite spritePixels = getFileSpritePixels(file);

					if (spriteOverride.getSpriteID() == SpriteID.COMPASS_TEXTURE)
					{
						client.setCompass(spritePixels);
					}
					else
					{
						client.getSpriteOverrides().put(spriteOverride.getSpriteID(), spritePixels);
					}
				}
			}
		}
	}

	private void restoreSprites()
	{
		client.getWidgetSpriteCache().reset();

		for (SpriteOverride spriteOverride : SpriteOverride.values())
		{
			client.getSpriteOverrides().remove(spriteOverride.getSpriteID());
		}
	}

	private void overrideWidgetSprites()
	{
		for (WidgetOverride widgetOverride : WidgetOverride.values())
		{
			if (widgetOverride.getSkin() == this.skin)
			{
				String file = this.skin.toString() + "/widget/" + widgetOverride.getName() + ".png";
				Sprite spritePixels = getFileSpritePixels(file);

				if (spritePixels != null)
				{
					for (WidgetInfo widgetInfo : widgetOverride.getWidgetInfo())
					{
						client.getWidgetSpriteOverrides().put(widgetInfo.getPackedId(), spritePixels);
					}
				}
			}
		}
	}

	private void restoreWidgetSprites()
	{
		for (WidgetOverride widgetOverride : WidgetOverride.values())
		{
			for (WidgetInfo widgetInfo : widgetOverride.getWidgetInfo())
			{
				client.getWidgetSpriteOverrides().remove(widgetInfo.getPackedId());
			}
		}
	}

	private Sprite getFileSpritePixels(String file)
	{
		try
		{
			log.debug("Loading: {}", file);
			BufferedImage image = ImageUtil.getResourceStreamFromClass(this.getClass(), file);
			return ImageUtil.getImageSprite(image, client);
		}
		catch (RuntimeException ex)
		{
			log.debug("Unable to load image: ", ex);
		}

		return null;
	}

	private void adjustWidgetDimensions()
	{
		for (WidgetOffset widgetOffset : WidgetOffset.values())
		{
			if (widgetOffset.getSkin() != this.skin)
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

	private void overrideHealthBars()
	{
		if (this.hdHealthBars)
		{
			spriteManager.addSpriteOverrides(HealthbarOverride.values());
			// Reset health bar caches to apply the override
			clientThread.invokeLater(client::resetHealthBarCaches);
		}
		else
		{
			restoreHealthBars();
		}
	}

	private void restoreHealthBars()
	{
		spriteManager.removeSpriteOverrides(HealthbarOverride.values());
		clientThread.invokeLater(client::resetHealthBarCaches);
	}

	private void overrideCrossSprites()
	{
		if (this.rsCrossSprites)
		{
			// If we've already replaced them,
			// we don't need to replace them again
			if (defaultCrossSprites != null)
			{
				return;
			}

			Sprite[] crossSprites = client.getCrossSprites();

			if (crossSprites == null)
			{
				return;
			}

			defaultCrossSprites = new Sprite[crossSprites.length];
			System.arraycopy(crossSprites, 0, defaultCrossSprites, 0, defaultCrossSprites.length);

			for (int i = 0; i < crossSprites.length; i++)
			{
				Sprite newSprite = getFileSpritePixels("rs3/cross_sprites/" + i + ".png");

				if (newSprite == null)
				{
					continue;
				}

				crossSprites[i] = newSprite;
			}
		}
		else
		{
			restoreCrossSprites();
		}
	}

	private void restoreCrossSprites()
	{
		if (defaultCrossSprites == null)
		{
			return;
		}

		Sprite[] crossSprites = client.getCrossSprites();

		if (crossSprites != null && defaultCrossSprites.length == crossSprites.length)
		{
			System.arraycopy(defaultCrossSprites, 0, crossSprites, 0, defaultCrossSprites.length);
		}

		defaultCrossSprites = null;
	}

	private void restoreWidgetDimensions()
	{
		for (WidgetOffset widgetOffset : WidgetOffset.values())
		{
			Widget widget = client.getWidget(widgetOffset.getWidgetInfo());

			if (widget != null)
			{
				widget.revalidate();
			}
		}
	}

	private void removeGameframe()
	{
		restoreSprites();
		restoreWidgetSprites();

		BufferedImage compassImage = spriteManager.getSprite(SpriteID.COMPASS_TEXTURE, 0);

		if (compassImage != null)
		{
			Sprite compass = ImageUtil.getImageSprite(compassImage, client);
			client.setCompass(compass);
		}
	}

	private void updateConfig()
	{
		this.skin = config.skin();
		this.hdHealthBars = config.hdHealthBars();
		this.hdMenu = config.hdMenu();
		this.rsCrossSprites = config.rsCrossSprites();
	}
}