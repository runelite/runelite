/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>, SoyChai <https://github.com/SoyChai>
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

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

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
	private XpDropConfig config;

	@Provides
	XpDropConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(XpDropConfig.class);
	}

	private int hitpointsXp = -1;
	private int magicXp = -1;
	private int rangedXp = -1;
	private int attackXp = -1;
	private int strengthXp = -1;
	private int defenseXp = -1;

	private SkillAmountPrayer hpDrop = null;
	private SkillAmountPrayer magicDrop = null;
	private SkillAmountPrayer rangedDrop = null;
	private SkillAmountPrayer attackDrop = null;
	private SkillAmountPrayer strengthDrop = null;
	private SkillAmountPrayer defenseDrop = null;

	@Subscribe
	public void onExperienceChanged(ExperienceChanged event)
	{
		final Skill skill = event.getSkill();
		final int currentXp = client.getSkillExperience(skill);
		switch (skill)
		{
			case HITPOINTS:
				if (hitpointsXp != -1)
				{
					final int delta = currentXp - hitpointsXp;
					hpDrop = new SkillAmountPrayer(Skill.HITPOINTS, delta, getActivePrayerType());
				}
				hitpointsXp = currentXp;
				break;
			case MAGIC:
				if (magicXp != -1)
				{
					final int delta = currentXp - magicXp;
					magicDrop = new SkillAmountPrayer(Skill.MAGIC, delta, getActivePrayerType());
				}
				magicXp = currentXp;
				break;
			case RANGED:
				if (rangedXp != -1)
				{
					final int delta = currentXp - rangedXp;
					rangedDrop = new SkillAmountPrayer(Skill.RANGED, delta, getActivePrayerType());
				}
				rangedXp = currentXp;
				break;
			case ATTACK:
				if (attackXp != -1)
				{
					final int delta = currentXp - attackXp;
					attackDrop = new SkillAmountPrayer(Skill.ATTACK, delta, getActivePrayerType());
				}
				attackXp = currentXp;
				break;
			case STRENGTH:
				if (strengthXp != -1)
				{
					final int delta = currentXp - strengthXp;
					strengthDrop = new SkillAmountPrayer(Skill.STRENGTH, delta, getActivePrayerType());
				}
				strengthXp = currentXp;
				break;
			case DEFENCE:
				if (defenseXp != -1)
				{
					final int delta = currentXp - defenseXp;
					defenseDrop = new SkillAmountPrayer(Skill.DEFENCE, delta, getActivePrayerType());
				}
				defenseXp = currentXp;
				break;
		}
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
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

		String text = widget.getText();
		final Set<Integer> spriteIDs = Arrays.stream(widget.getParent()
			.getDynamicChildren()).map(Widget::getSpriteId).collect(Collectors.toSet());

		if (text != null)
		{
			int defaultColorIdx = client.getVar(Varbits.EXPERIENCE_DROP_COLOR);
			int color = DefaultColors.values()[defaultColorIdx].getColor().getRGB();

			if (spriteIDs.contains(SpriteID.SKILL_RANGED))
			{
				if (rangedDrop != null && rangedDrop.getPrayerType() == PrayerType.RANGE)
				{
					color = config.getRangePrayerColor().getRGB();
				}
			}
			else if (spriteIDs.contains(SpriteID.SKILL_MAGIC))
			{
				if (magicDrop != null && magicDrop.getPrayerType() == PrayerType.MAGIC)
				{
					color = config.getMagePrayerColor().getRGB();
				}
			}
			else if (spriteIDs.contains(SpriteID.SKILL_ATTACK) || spriteIDs.contains(SpriteID.SKILL_STRENGTH)
				|| spriteIDs.contains(SpriteID.SKILL_DEFENCE))
			{
				if (attackDrop != null && attackDrop.getPrayerType() == PrayerType.MELEE)
				{
					color = config.getMeleePrayerColor().getRGB();
				}
				if (strengthDrop != null && strengthDrop.getPrayerType() == PrayerType.MELEE)
				{
					color = config.getMeleePrayerColor().getRGB();
				}
				if (defenseDrop != null && defenseDrop.getPrayerType() == PrayerType.MELEE)
				{
					color = config.getMeleePrayerColor().getRGB();
				}
			}
			if (spriteIDs.contains(SpriteID.SKILL_HITPOINTS))
			{
				if (hpDrop != null && hpDrop.getPrayerType() != null)
				{
					switch (hpDrop.getPrayerType())
					{
						case MELEE:
							color = config.getMeleePrayerColor().getRGB();
							break;
						case MAGIC:
							color = config.getMagePrayerColor().getRGB();
							break;
						case RANGE:
							color = config.getRangePrayerColor().getRGB();
					}
				}
			}

			widget.setTextColor(color);
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
}
