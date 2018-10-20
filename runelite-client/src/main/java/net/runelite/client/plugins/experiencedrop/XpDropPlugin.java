/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>, SoyChai <https://github.com/SoyChai>
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.experiencedrop;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.stream.IntStream;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ResizeableChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.WidgetOverlay;

@PluginDescriptor(
	name = "XP Drop",
	description = "Enable customization of the way XP drops are displayed",
	tags = {"experience", "levels"}
)
public class XpDropPlugin extends Plugin
{
	private static final int XPDROP_PADDING = 2; // space between xp drop icons

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private XpDropConfig config;

	@Provides
	XpDropConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(XpDropConfig.class);
	}

	private WidgetOverlay overlay;
	private int overlayPosition = -1;
	private boolean createOverlayFlag = false;

	@Subscribe
	public void onWidgetHidden(WidgetHiddenChanged event)
	{
		Widget widget = event.getWidget();

		int group = WidgetInfo.TO_GROUP(widget.getId());

		if (group != WidgetID.EXPERIENCE_DROP_GROUP_ID)
		{
			return;
		}

		if (widget.isHidden())
		{
			return;
		}

		if (config.hideSkillIcons())
		{
			if (widget.getSpriteId() > 0)
			{
				widget.setHidden(true);
				return;
			}
			else if (!widget.getText().isEmpty())
			{
				// Align text accordingly to take up hidden skill icon space
				int width = 0;
				for (Widget w : widget.getParent().getDynamicChildren())
				{
					if (w.getSpriteId() != -1)
					{
						if (width > 0)
						{
							// Add in space between sprites
							width += XPDROP_PADDING;
						}
						width += w.getWidth(); // width of sprite
					}
				}

				final int xpDropPosition = client.getVar(Varbits.EXPERIENCE_TRACKER_POSITION);
				switch (xpDropPosition)
				{
					case 2: // left
						int cur = widget.getRelativeX();
						cur -= width;
						widget.setRelativeX(cur);
						break;
					case 0: // right
						break;
					case 1: // center
						cur = widget.getRelativeX();
						cur -= width / 2;
						widget.setRelativeX(cur);
						break;
				}
			}
		}

		PrayerType prayer = getActivePrayerType();
		if (prayer == null)
		{
			resetTextColor(widget);
			return;
		}

		if (config.recolorDrops())
		{
			String text = widget.getText();
			final IntStream spriteIDs =
				Arrays.stream(widget.getParent().getDynamicChildren()).mapToInt(Widget::getSpriteId);

			if (text != null)
			{
				int color = widget.getTextColor();

				switch (prayer)
				{
					case MELEE:
						if (spriteIDs.anyMatch(id ->
							id == SpriteID.SKILL_ATTACK || id == SpriteID.SKILL_STRENGTH || id == SpriteID.SKILL_DEFENCE
								|| id == SpriteID.SKILL_HITPOINTS))
						{
							color = config.getMeleePrayerColor().getRGB();
						}
						break;

					case RANGE:
						if (spriteIDs.anyMatch(id -> id == SpriteID.SKILL_RANGED || id == SpriteID.SKILL_HITPOINTS))
						{
							color = config.getRangePrayerColor().getRGB();
						}
						break;
					case MAGIC:
						if (spriteIDs.anyMatch(id -> id == SpriteID.SKILL_MAGIC || id == SpriteID.SKILL_HITPOINTS))
						{
							color = config.getMagePrayerColor().getRGB();
						}
						break;
				}

				widget.setTextColor(color);
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("xpdrop"))
		{
			if (config.moveableDrops())
			{
				createOverlayFlag = true;
			}
			else
			{
				removeOverlay();
			}
		}
	}

	private void resetTextColor(Widget widget)
	{
		int defaultColorIdx = client.getVar(Varbits.EXPERIENCE_DROP_COLOR);
		int defaultColor = DefaultColors.values()[defaultColorIdx].getColor().getRGB();
		widget.setTextColor(defaultColor);
	}

	private PrayerType getActivePrayerType()
	{
		for (XpPrayer prayer : XpPrayer.values())
		{
			if (client.isPrayerActive(prayer.getPrayer()))
			{
				return prayer.getType();
			}
		}
		return null;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (createOverlayFlag)
		{
			updateOverlay();
		}
	}

	@Override
	public void startUp() throws Exception
	{
		updateOverlay();
	}

	@Override
	public void shutDown() throws Exception
	{
		removeOverlay();
	}

	private void moveMoveableXPDropWidget(int position)
	{
		if (config.moveableDrops())
		{
			Widget viewport = client.getViewportWidget();
			if (viewport != null)
			{
				Rectangle viewportBounds = viewport.getBounds();
				if (viewportBounds.width > 0 && viewportBounds.height > 0)
				{
					Rectangle bounds = new Rectangle(0, 0, 50, 50);
					switch (position)
					{
						case 0: //Right
							bounds.x = viewportBounds.width - bounds.width;
							break;

						case 1: //Middle
							bounds.x = (int) (viewportBounds.width / 2.0f - bounds.width / 2.0f);
							break;

						case 2: //Left
							bounds.x = 0;
							break;

						default:
							return;
					}

					if (overlay != null)
					{
						overlayManager.remove(overlay);
					}
					overlay = new WidgetOverlay(client, WidgetInfo.EXPERIENCE_DROPS, OverlayPosition.DETACHED, bounds);
					overlayManager.add(overlay);

					overlayPosition = position;
					createOverlayFlag = false;
				}
			}
		}
	}

	private void updateOverlay()
	{

		Widget widget = client.getWidget(WidgetInfo.EXPERIENCE_DROPS);
		if (widget != null)
		{
			int newPos = client.getVar(Varbits.EXPERIENCE_TRACKER_POSITION);
			if (newPos != overlayPosition)
			{
				moveMoveableXPDropWidget(newPos);
			}
		}
	}

	private void resetOverlay()
	{
		Widget widget = client.getWidget(WidgetInfo.EXPERIENCE_DROPS);
		if (widget != null)
		{
			moveMoveableXPDropWidget(overlayPosition);
		}
	}

	private void removeOverlay()
	{
		if (overlay != null)
		{
			overlayManager.remove(overlay);
		}
		overlayPosition = -1;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		updateOverlay();
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		updateOverlay();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		updateOverlay();
	}

	@Subscribe
	public void onResizeableChanged(ResizeableChanged event)
	{
		resetOverlay();
	}
}
