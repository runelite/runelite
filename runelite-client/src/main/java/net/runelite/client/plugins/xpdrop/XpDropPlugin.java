/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
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
package net.runelite.client.plugins.xpdrop;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.util.HashSet;
import java.util.Set;

@PluginDescriptor(
	name = "Experience drop plugin"
)
public class XpDropPlugin extends Plugin
{
	private enum PrayerType
	{
		MELEE, RANGE, MAGE;
	}

	private enum ColorDrop
	{
		WHITE(0, 16777215),
		LILAC(1, 13148872),
		CYAN(2, 47083),
		JADE(3, 43115),
		LIME(4, 12582656),
		YELLOW(5, 16776960),
		ORANGE(6, 16744192),
		PINK(7, 16763337);

		private int index;
		private int color;

		ColorDrop(int index, int color)
		{
			this.index = index;
			this.color = color;
		}
	}
	@Inject
	Client client;

	@Inject
	XpDropConfig config;

	private static Set<Integer> dropSet = new HashSet<>();
	private int defaultColor;

	static
    {
        dropSet.add(WidgetInfo.XP_DROP_1.getId());
        dropSet.add(WidgetInfo.XP_DROP_2.getId());
        dropSet.add(WidgetInfo.XP_DROP_3.getId());
        dropSet.add(WidgetInfo.XP_DROP_4.getId());
        dropSet.add(WidgetInfo.XP_DROP_5.getId());
        dropSet.add(WidgetInfo.XP_DROP_6.getId());
        dropSet.add(WidgetInfo.XP_DROP_7.getId());
    }

	@Provides
	XpDropConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(XpDropConfig.class);
	}

	@Subscribe
	public void onWidgetHidden(WidgetHiddenChanged event)
	{
		PrayerType prayer = getActivePrayerType();
		if (!config.enabled() || prayer == null)
		{
			return;
		}

		Widget widget = event.getWidget();
		if (widget != null && dropSet.contains(widget.getId()))
		{
			System.out.println(client.getSetting(Varbits.XP_DROP_COLOR));

			if (!widget.isHidden())
			{
				switch (prayer)
				{
					case MELEE:
						widget.setTextColor(config.getMeleePrayerColor().getRGB());
						break;
					case RANGE:
						widget.setTextColor(config.getRangePrayerColor().getRGB());
						break;
					case MAGE:
						widget.setTextColor(config.getMagePrayerColor().getRGB());
						break;
				}
			}
			else
			{
				int color = ColorDrop.values()[client.getSetting(Varbits.XP_DROP_COLOR)].color;
				widget.setTextColor(color);
			}
		}
	}

	private PrayerType getActivePrayerType()
	{
		for (Prayer pray : Prayer.values())
		{
			if (client.isPrayerActive(pray))
			{
				switch (pray.getVarbit())
				{
					case PRAYER_BURST_OF_STRENGTH:
					case PRAYER_SUPERHUMAN_STRENGTH:
					case PRAYER_ULTIMATE_STRENGTH:
					case PRAYER_CLARITY_OF_THOUGHT:
					case PRAYER_IMPROVED_REFLEXES:
					case PRAYER_INCREDIBLE_REFLEXES:
					case PRAYER_CHIVALRY:
					case PRAYER_PIETY:
						return PrayerType.MELEE;
					case PRAYER_SHARP_EYE:
					case PRAYER_HAWK_EYE:
					case PRAYER_EAGLE_EYE:
					case PRAYER_RIGOUR:
						return PrayerType.RANGE;
					case PRAYER_MYSTIC_WILL:
					case PRAYER_MYSTIC_LORE:
					case PRAYER_MYSTIC_MIGHT:
					case PRAYER_AUGURY:
						return PrayerType.MAGE;
				}
			}
		}

		return null;
	}
}
