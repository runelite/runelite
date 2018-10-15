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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetPositioned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Interface Styles",
	description = "Change the interface style to the 2005/2010 interface and toggle member skills",
	tags = {"2005", "2010", "skin", "theme", "ui", "f2p"},
	enabledByDefault = false
)
public class InterfaceStylesPlugin extends Plugin
{
	private static final int
			PRAYER_X = 1,
			PRAYER_Y = 129,
			MAGIC_X = 1,
			MAGIC_Y = 161,
			CRAFTING_X = 64,
			CRAFTING_Y = 129,
			RUNECRAFTING_X = 1,
			RUNECRAFTING_Y = 193,
			WOODCUTTING_X = 127,
			WOODCUTTING_Y = 161,
			TOTAL_X = 127,
			TOTAL_Y = 225;
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private InterfaceStylesConfig config;

	@Inject
	private SpriteManager spriteManager;

	@Provides
	InterfaceStylesConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InterfaceStylesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		clientThread.invoke(this::updateAllOverrides);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientThread.invoke(() ->
		{
			restoreWidgetDimensions();
			removeGameframe();
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

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		if (!client.getWorldType().contains(WorldType.MEMBERS))
		{
			showMemberOnlySkills();
		}
	}

	@Subscribe
	public void onWidgetPositioned(WidgetPositioned widgetPositioned)
	{
		adjustWidgetDimensions();
	}

	private void updateAllOverrides()
	{
		removeGameframe();
		overrideSprites();
		overrideWidgetSprites();
		restoreWidgetDimensions();
		adjustWidgetDimensions();

		if (!client.getWorldType().contains(WorldType.MEMBERS))
		{
			showMemberOnlySkills();
		}
	}

	private void overrideSprites()
	{
		for (SpriteOverride spriteOverride : SpriteOverride.values())
		{
			for (Skin skin : spriteOverride.getSkin())
			{
				if (skin == config.skin())
				{
					SpritePixels spritePixels = getFileSpritePixels(String.valueOf(spriteOverride.getSpriteID()), null);

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
			if (widgetOverride.getSkin() == config.skin())
			{
				SpritePixels spritePixels = getFileSpritePixels(widgetOverride.getName(), "widget");

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

	private SpritePixels getFileSpritePixels(String file, String subfolder)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(config.skin().toString() + "/");

		if (subfolder != null)
		{
			stringBuilder.append(subfolder + "/");
		}

		stringBuilder.append(file + ".png");
		String filePath = stringBuilder.toString();

		try (InputStream inputStream = InterfaceStylesPlugin.class.getResourceAsStream(filePath))
		{
			log.debug("Loading: " + filePath);
			BufferedImage spriteImage = ImageIO.read(inputStream);
			return getImageSpritePixels(spriteImage);
		}
		catch (IOException ex)
		{
			log.debug("Unable to load image: ", ex);
		}
		catch (IllegalArgumentException ex)
		{
			log.debug("Input stream of file path " + filePath + " could not be read: ", ex);
		}

		return null;
	}

	private SpritePixels getImageSpritePixels(BufferedImage image)
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

	private void adjustWidgetDimensions()
	{
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

	private void restoreWidgetDimensions()
	{
		for (WidgetOffset widgetOffset : WidgetOffset.values())
		{
			Widget widget = client.getWidget(widgetOffset.getWidgetInfo());

			if (widget != null)
			{
				if (widgetOffset.isOriginalWidthAndHeight())
				{
					widget.setHeight(widget.getOriginalHeight());
					widget.setWidth(widget.getOriginalWidth());
				}

				if (widgetOffset.getOriginalX() != null)
				{
					widget.setRelativeX(widgetOffset.getOriginalX());
				}
				else
				{
					widget.setRelativeX(widget.getOriginalX());
				}

				if (widgetOffset.getOriginalY() != null)
				{
					widget.setRelativeY(widgetOffset.getOriginalY());
				}
				else
				{
					widget.setRelativeY(widget.getOriginalY());
				}
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
			SpritePixels compass = getImageSpritePixels(compassImage);
			client.setCompass(compass);
		}
	}

	private ArrayList<Widget> getMemberSkills()
	{
		ArrayList<Widget> membersOnlyWidgets = new ArrayList<>();

		Widget agility = client.getWidget(WidgetInfo.SKILL_AGILITY),
				construction = client.getWidget(WidgetInfo.SKILL_CONSTRUCTION),
				farming = client.getWidget(WidgetInfo.SKILL_FARMING),
				fletching = client.getWidget(WidgetInfo.SKILL_FLETCHING),
				herblore = client.getWidget(WidgetInfo.SKILL_HERBLORE),
				hunter = client.getWidget(WidgetInfo.SKILL_HUNTER),
				thieving = client.getWidget(WidgetInfo.SKILL_THIEVING),
				slayer = client.getWidget(WidgetInfo.SKILL_SLAYER);

		membersOnlyWidgets.add(agility);
		membersOnlyWidgets.add(construction);
		membersOnlyWidgets.add(farming);
		membersOnlyWidgets.add(fletching);
		membersOnlyWidgets.add(herblore);
		membersOnlyWidgets.add(hunter);
		membersOnlyWidgets.add(thieving);
		membersOnlyWidgets.add(slayer);

		return membersOnlyWidgets;
	}

	private void shuffleSkills(boolean hideMembers)
	{
		if (hideMembers)
		{
			client.getWidget(WidgetInfo.SKILL_TOTAL).setRelativeX(WOODCUTTING_X);
			client.getWidget(WidgetInfo.SKILL_TOTAL).setRelativeY(WOODCUTTING_Y);
			client.getWidget(WidgetInfo.SKILL_PRAYER).setRelativeX(client.getWidget(WidgetInfo.SKILL_AGILITY).getRelativeX());
			client.getWidget(WidgetInfo.SKILL_PRAYER).setRelativeY(client.getWidget(WidgetInfo.SKILL_AGILITY).getRelativeY());
			client.getWidget(WidgetInfo.SKILL_MAGIC).setRelativeX(PRAYER_X);
			client.getWidget(WidgetInfo.SKILL_MAGIC).setRelativeY(PRAYER_Y);
			client.getWidget(WidgetInfo.SKILL_CRAFTING).setRelativeX(client.getWidget(WidgetInfo.SKILL_HERBLORE).getRelativeX());
			client.getWidget(WidgetInfo.SKILL_CRAFTING).setRelativeY(client.getWidget(WidgetInfo.SKILL_HERBLORE).getRelativeY());
			client.getWidget(WidgetInfo.SKILL_RUNECRAFTING).setRelativeX(client.getWidget(WidgetInfo.SKILL_THIEVING).getRelativeX());
			client.getWidget(WidgetInfo.SKILL_RUNECRAFTING).setRelativeY(client.getWidget(WidgetInfo.SKILL_THIEVING).getRelativeY());
			client.getWidget(WidgetInfo.SKILL_WOODCUTTING).setRelativeX(CRAFTING_X);
			client.getWidget(WidgetInfo.SKILL_WOODCUTTING).setRelativeY(CRAFTING_Y);
		}
		else
		{
			client.getWidget(WidgetInfo.SKILL_TOTAL).setRelativeX(TOTAL_X);
			client.getWidget(WidgetInfo.SKILL_TOTAL).setRelativeY(TOTAL_Y);
			client.getWidget(WidgetInfo.SKILL_PRAYER).setRelativeX(PRAYER_X);
			client.getWidget(WidgetInfo.SKILL_PRAYER).setRelativeY(PRAYER_Y);
			client.getWidget(WidgetInfo.SKILL_MAGIC).setRelativeX(MAGIC_X);
			client.getWidget(WidgetInfo.SKILL_MAGIC).setRelativeY(MAGIC_Y);
			client.getWidget(WidgetInfo.SKILL_CRAFTING).setRelativeX(CRAFTING_X);
			client.getWidget(WidgetInfo.SKILL_CRAFTING).setRelativeY(CRAFTING_Y);
			client.getWidget(WidgetInfo.SKILL_RUNECRAFTING).setRelativeX(RUNECRAFTING_X);
			client.getWidget(WidgetInfo.SKILL_RUNECRAFTING).setRelativeY(RUNECRAFTING_Y);
			client.getWidget(WidgetInfo.SKILL_WOODCUTTING).setRelativeX(WOODCUTTING_X);
			client.getWidget(WidgetInfo.SKILL_WOODCUTTING).setRelativeY(WOODCUTTING_Y);
		}
	}

	private void showMemberOnlySkills()
	{
		for (Widget widget : getMemberSkills())
		{
			widget.setHidden(config.hideMembersSkills());
		}
		shuffleSkills(config.hideMembersSkills());
		updateTotalLevels();
	}

	private void updateTotalLevels()
	{
		int totalLevel = 0;

		for (int skill = 1; skill <= 23; skill++)
		{
			Widget currentSkill = client.getWidget(WidgetID.STATS_GROUP_ID, skill);

			if (!currentSkill.isHidden() && currentSkill.getDynamicChildren().length >= 4)
			{
				// [4] is the denominator of the skill fraction widget
				totalLevel += Integer.parseInt(currentSkill.getDynamicChildren()[4].getText());
			}
		}
		client.getWidget(WidgetInfo.SKILL_TOTAL_TEXT).setText("Total level:<br>" + totalLevel);
	}
}