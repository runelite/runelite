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
import java.util.Arrays;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.HealthBarConfig;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.SpritePixels;
import net.runelite.api.events.BeforeMenuRender;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.PostClientTick;
import net.runelite.api.events.PostHealthBarConfig;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.gameval.SpriteID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ImageUtil;

@Slf4j
@PluginDescriptor(
	name = "Interface Styles",
	description = "Change the interface style to the 2005/2010 interface",
	tags = {"2005", "2010", "skin", "theme", "ui", "hp", "bar"},
	enabledByDefault = false
)
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

	private SpritePixels[] defaultCrossSprites;

	@Provides
	InterfaceStylesConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InterfaceStylesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		queueUpdateAllOverrides();
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientThread.invoke(() ->
		{
			restoreWidgetDimensions();
			removeGameframe();
			restoreHealthBars();
			restoreCrossSprites();
		});
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.STARTING)
		{
			queueUpdateAllOverrides();
		}
	}

	private void queueUpdateAllOverrides()
	{
		clientThread.invoke(() ->
		{
			// Cross sprites and widget sprite cache are not setup until login screen
			if (client.getGameState().getState() < GameState.LOGIN_SCREEN.getState())
			{
				return false;
			}
			updateAllOverrides();
			return true;
		});
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged config)
	{
		if (config.getGroup().equals("interfaceStyles"))
		{
			clientThread.invoke(this::updateAllOverrides);
		}
	}

	// Use a higher priority so that player menu entries added by other sources are added to the player's submenu
	@Subscribe(priority = 1)
	public void onMenuOpened(MenuOpened event)
	{
		if (config.condensePlayerOptions())
		{
			condensePlayerOptions();
		}
	}

	private void condensePlayerOptions()
	{
		MenuEntry[] menuEntries = client.getMenuEntries();
		MenuEntry[] newMenus = new MenuEntry[menuEntries.length];
		int newIdx = 0;

		Menu submenu = null;
		Player prev = null;
		boolean changed = false;

		for (MenuEntry menuEntry : menuEntries)
		{
			MenuAction type = menuEntry.getType();

			Player player = menuEntry.getPlayer();
			if (player != null && type != MenuAction.ITEM_USE_ON_PLAYER && type != MenuAction.WIDGET_TARGET_ON_PLAYER)
			{
				String option = menuEntry.getOption();
				boolean deprioritized = menuEntry.isDeprioritized();

				if (prev != player)
				{
					// Change this menu to be the submenu parent
					menuEntry.setOption("");
					menuEntry.setType(MenuAction.RUNELITE);
					menuEntry.setDeprioritized(false);
					submenu = menuEntry.createSubMenu();

					newMenus[newIdx++] = menuEntry;
				}

				// Add this menu to the submenu
				assert submenu != null;
				submenu.createMenuEntry(-1)
					.setIdentifier(menuEntry.getIdentifier())
					.setOption(option)
					.setTarget(menuEntry.getTarget())
					.setType(type)
					.setParam0(menuEntry.getParam0())
					.setParam1(menuEntry.getParam1())
					.setDeprioritized(deprioritized);
				changed = true;
			}
			else
			{
				newMenus[newIdx++] = menuEntry;
			}

			prev = player;
		}

		if (changed)
		{
			client.setMenuEntries(Arrays.copyOf(newMenus, newIdx));
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if ("forceStackStones".equals(event.getEventName()) && config.alwaysStack())
		{
			int[] intStack = client.getIntStack();
			int intStackSize = client.getIntStackSize();
			intStack[intStackSize - 1] = 1;
		}
	}

	@Subscribe
	public void onPostClientTick(PostClientTick event)
	{
		adjustWidgetDimensions();
	}

	@Subscribe
	public void onPostHealthBarConfig(PostHealthBarConfig postHealthBar)
	{
		if (!config.hdHealthBars())
		{
			return;
		}

		HealthBarConfig healthBar = postHealthBar.getHealthBarConfig();
		HealthbarOverride override = HealthbarOverride.get(healthBar.getHealthBarFrontSpriteId());

		// Check if this is the health bar we are replacing
		if (override != null)
		{
			// Increase padding to show some more green at very low hp percentages
			healthBar.setPadding(override.getPadding());
		}
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

	@Subscribe
	public void onBeforeMenuRender(BeforeMenuRender event)
	{
		if (config.hdMenu())
		{
			client.draw2010Menu(config.menuAlpha());
			event.consume();
		}
		else if (config.menuAlpha() != 255)
		{
			client.drawOriginalMenu(config.menuAlpha());
			event.consume();
		}
	}

	private void overrideSprites()
	{
		final Skin configuredSkin = config.skin();
		if (configuredSkin == Skin.DEFAULT)
		{
			return;
		}

		for (SpriteOverride spriteOverride : SpriteOverride.values())
		{
			for (Skin skin : spriteOverride.getSkin())
			{
				if (skin == configuredSkin)
				{
					final String configSkin = skin.getExtendSkin() != null
						? skin.getExtendSkin().toString()
						: skin.toString();
					String file = configSkin + "/" + spriteOverride.getSpriteID() + ".png";
					SpritePixels spritePixels = getFileSpritePixels(file);

					if (spriteOverride.getSpriteID() == SpriteID.COMPASS)
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
		final Skin configuredSkin = config.skin();
		if (configuredSkin == Skin.DEFAULT)
		{
			return;
		}

		for (WidgetOverride widgetOverride : WidgetOverride.values())
		{
			if (widgetOverride.getSkin() == configuredSkin
				|| widgetOverride.getSkin() == configuredSkin.getExtendSkin())
			{
				final String configSkin = configuredSkin.getExtendSkin() != null
					? configuredSkin.getExtendSkin().toString()
					: configuredSkin.toString();
				String file = configSkin + "/widget/" + widgetOverride.getName() + ".png";
				SpritePixels spritePixels = getFileSpritePixels(file);

				if (spritePixels != null)
				{
					for (int widgetInfo : widgetOverride.getWidgetInfo())
					{
						client.getWidgetSpriteOverrides().put(widgetInfo, spritePixels);
					}
				}
			}
		}
	}

	private void restoreWidgetSprites()
	{
		for (WidgetOverride widgetOverride : WidgetOverride.values())
		{
			for (int widgetInfo : widgetOverride.getWidgetInfo())
			{
				client.getWidgetSpriteOverrides().remove(widgetInfo);
			}
		}
	}

	private SpritePixels getFileSpritePixels(String file)
	{
		try
		{
			log.debug("Loading: {}", file);
			BufferedImage image = ImageUtil.loadImageResource(this.getClass(), file);
			return ImageUtil.getImageSpritePixels(image, client);
		}
		catch (RuntimeException ex)
		{
			log.debug("Unable to load image: ", ex);
		}

		return null;
	}

	private void adjustWidgetDimensions()
	{
		var skin = config.skin();
		if (skin == Skin.DEFAULT)
		{
			return;
		}

		for (WidgetOffset widgetOffset : WidgetOffset.values())
		{
			if (widgetOffset.getSkin() != skin)
			{
				continue;
			}

			Widget widget = client.getWidget(widgetOffset.getComponent());

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
		if (config.hdHealthBars())
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
		if (config.rsCrossSprites())
		{
			// If we've already replaced them,
			// we don't need to replace them again
			if (defaultCrossSprites != null)
			{
				return;
			}

			SpritePixels[] crossSprites = client.getCrossSprites();

			if (crossSprites == null)
			{
				return;
			}

			defaultCrossSprites = new SpritePixels[crossSprites.length];
			System.arraycopy(crossSprites, 0, defaultCrossSprites, 0, defaultCrossSprites.length);

			for (int i = 0; i < crossSprites.length; i++)
			{
				SpritePixels newSprite = getFileSpritePixels("rs3/cross_sprites/" + i + ".png");

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

		SpritePixels[] crossSprites = client.getCrossSprites();

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
			Widget widget = client.getWidget(widgetOffset.getComponent());

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

		BufferedImage compassImage = spriteManager.getSprite(SpriteID.COMPASS, 0);

		if (compassImage != null)
		{
			SpritePixels compass = ImageUtil.getImageSpritePixels(compassImage, client);
			client.setCompass(compass);
		}
	}
}