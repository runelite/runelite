/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>, SoyChai <https://github.com/SoyChai>
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.Prayer;
import static net.runelite.api.ScriptID.XPDROPS_SETDROPSIZE;
import static net.runelite.api.ScriptID.XPDROP_DISABLED;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.StatChanged;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "XP Drop",
	description = "Enable customization of the way XP drops are displayed",
	tags = {"experience", "levels", "tick", "prayer", "xpdrop"}
)
public class XpDropPlugin extends Plugin
{
	enum PrayerType
	{
		MELEE,
		RANGE,
		MAGIC;
	}

	private static final Multimap<Prayer, PrayerType> PRAYER_TYPE = new ImmutableMultimap.Builder<Prayer, PrayerType>()
		.put(Prayer.BURST_OF_STRENGTH, PrayerType.MELEE)
		.put(Prayer.CLARITY_OF_THOUGHT, PrayerType.MELEE)
		.put(Prayer.SHARP_EYE, PrayerType.RANGE)
		.put(Prayer.MYSTIC_WILL, PrayerType.MAGIC)
		.put(Prayer.SUPERHUMAN_STRENGTH, PrayerType.MELEE)
		.put(Prayer.IMPROVED_REFLEXES, PrayerType.MELEE)
		.put(Prayer.HAWK_EYE, PrayerType.RANGE)
		.put(Prayer.MYSTIC_LORE, PrayerType.MAGIC)
		.put(Prayer.ULTIMATE_STRENGTH, PrayerType.MELEE)
		.put(Prayer.INCREDIBLE_REFLEXES, PrayerType.MELEE)
		.put(Prayer.EAGLE_EYE, PrayerType.RANGE)
		.put(Prayer.MYSTIC_MIGHT, PrayerType.MAGIC)
		.put(Prayer.CHIVALRY, PrayerType.MELEE)
		.put(Prayer.PIETY, PrayerType.MELEE)
		.put(Prayer.RIGOUR, PrayerType.RANGE)
		.put(Prayer.AUGURY, PrayerType.MAGIC)
		// RP
		.put(Prayer.RP_ANCIENT_STRENGTH, PrayerType.MELEE)
		.put(Prayer.RP_ANCIENT_SIGHT, PrayerType.RANGE)
		.put(Prayer.RP_ANCIENT_WILL, PrayerType.MAGIC)
		.putAll(Prayer.RP_TRINITAS, PrayerType.MELEE, PrayerType.RANGE, PrayerType.MAGIC)
		.put(Prayer.RP_DECIMATE, PrayerType.MELEE)
		.put(Prayer.RP_ANNIHILATE, PrayerType.RANGE)
		.put(Prayer.RP_VAPORISE, PrayerType.MAGIC)
		.putAll(Prayer.RP_INTENSIFY, PrayerType.MELEE, PrayerType.RANGE, PrayerType.MAGIC)
		.build();

	@Inject
	private Client client;

	@Inject
	private XpDropConfig config;

	private int tickCounter = 0;
	private int previousExpGained;
	private boolean hasDropped = false;
	private int xpdropColor;
	private Skill lastSkill = null;
	private final Map<Skill, Integer> previousSkillExpTable = new EnumMap<>(Skill.class);

	@Provides
	XpDropConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(XpDropConfig.class);
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired scriptPreFired)
	{
		if (scriptPreFired.getScriptId() == XPDROPS_SETDROPSIZE)
		{
			final int[] intStack = client.getIntStack();
			final int intStackSize = client.getIntStackSize();
			// This runs prior to the proc being invoked, so the arguments are still on the stack.
			// Grab the first argument to the script.
			final int widgetId = intStack[intStackSize - 4];
			processXpDrop(widgetId);
		}
	}

	private void processXpDrop(int widgetId)
	{
		final Widget xpdrop = client.getWidget(widgetId);
		final Widget[] children = xpdrop.getChildren();
		// child 0 is the xpdrop text, everything else are sprite ids for skills
		final Widget text = children[0];

		Collection<PrayerType> prayers = getActivePrayerType();
		if (prayers.isEmpty())
		{
			hideSkillIcons(xpdrop);
			resetTextColor(text);
			return;
		}

		final List<PrayerType> xpDropTypes =
			Arrays.stream(children)
				.skip(1) // skip text
				.filter(Objects::nonNull)
				.map(Widget::getSpriteId)
				.map(id ->
				{
					if (id == SpriteID.SKILL_ATTACK || id == SpriteID.SKILL_STRENGTH || id == SpriteID.SKILL_DEFENCE)
					{
						return PrayerType.MELEE;
					}
					if (id == SpriteID.SKILL_RANGED)
					{
						return PrayerType.RANGE;
					}
					if (id == SpriteID.SKILL_MAGIC)
					{
						return PrayerType.MAGIC;
					}
					return null;
				})
				.filter(Objects::nonNull)
				.distinct()
				.collect(Collectors.toList());

		// Check MELEE last to avoid defensive casting being categorized as melee
		if (xpDropTypes.contains(PrayerType.RANGE))
		{
			if (prayers.contains(PrayerType.RANGE))
			{
				xpdropColor = config.getRangePrayerColor().getRGB();
			}
		}
		else if (xpDropTypes.contains(PrayerType.MAGIC))
		{
			if (prayers.contains(PrayerType.MAGIC))
			{
				xpdropColor = config.getMagePrayerColor().getRGB();
			}
		}
		else if (xpDropTypes.contains(PrayerType.MELEE))
		{
			if (prayers.contains(PrayerType.MELEE))
			{
				xpdropColor = config.getMeleePrayerColor().getRGB();
			}
		}

		if (xpdropColor != 0)
		{
			text.setTextColor(xpdropColor);
		}
		else
		{
			resetTextColor(text);
		}

		hideSkillIcons(xpdrop);
	}

	private void resetTextColor(Widget widget)
	{
		Color standardColor = config.standardColor();
		if (standardColor != null)
		{
			int color = standardColor.getRGB();
			widget.setTextColor(color);
		}
		else
		{
			EnumComposition colorEnum = client.getEnum(EnumID.XPDROP_COLORS);
			int defaultColorId = client.getVarbitValue(VarbitID.XPDROPS_COLOUR);
			int color = colorEnum.getIntValue(defaultColorId);
			widget.setTextColor(color);
		}
	}

	private void hideSkillIcons(Widget xpdrop)
	{
		if (config.hideSkillIcons())
		{
			Widget[] children = xpdrop.getChildren();
			// keep only text
			Arrays.fill(children, 1, children.length, null);
		}
	}

	private Collection<PrayerType> getActivePrayerType()
	{
		for (Prayer prayer : PRAYER_TYPE.keySet())
		{
			if (client.getServerVarbitValue(prayer.getVarbit()) == 1)
			{
				return PRAYER_TYPE.get(prayer);
			}
		}
		return Collections.emptyList();
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		xpdropColor = 0;

		final int fakeTickDelay = config.fakeXpDropDelay();

		if (fakeTickDelay == 0 || lastSkill == null)
		{
			return;
		}

		// If an xp drop was created this tick, reset the counter
		if (hasDropped)
		{
			hasDropped = false;
			tickCounter = 0;
			return;
		}

		if (++tickCounter % fakeTickDelay != 0)
		{
			return;
		}

		client.runScript(XPDROP_DISABLED, lastSkill.ordinal(), previousExpGained);
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		final Skill skill = statChanged.getSkill();
		final int xp = statChanged.getXp();

		lastSkill = skill;

		Integer previous = previousSkillExpTable.put(skill, xp);
		if (previous != null)
		{
			previousExpGained = xp - previous;
			hasDropped = true;
		}
	}

}
