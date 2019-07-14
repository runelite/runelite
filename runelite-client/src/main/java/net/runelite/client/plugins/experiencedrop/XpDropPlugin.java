/*
 * Copyright (c) 2019, Owain van Brakel <https://github.com/Owain94>
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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

import com.google.inject.Provides;
import java.awt.Color;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.IntStream;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import static net.runelite.api.ScriptID.XPDROP_DISABLED;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.NPCManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;

@PluginDescriptor(
	name = "XP Drop",
	description = "Enable customization of the way XP drops are displayed",
	tags = {"experience", "levels", "tick"}
)
@Singleton
public class XpDropPlugin extends Plugin
{
	private static final int XPDROP_PADDING = 2; // space between xp drop icons
	private static final double HITPOINT_RATIO = 1.33; // Base rate of hp xp per point damage
	private static final double DMM_MULTIPLIER_RATIO = 10;

	@Inject
	private Client client;

	@Inject
	private XpDropConfig config;

	@Inject
	private NPCManager npcManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private XpDropOverlay overlay;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private int damage = 0;

	@Getter(AccessLevel.PACKAGE)
	private int tickShow = 0;

	@Getter(AccessLevel.PACKAGE)
	private Actor lastOpponent;

	private int tickCounter = 0;
	private int previousExpGained;
	private boolean hasDropped = false;
	private boolean correctPrayer;
	private Skill lastSkill = null;
	private final Map<Skill, Integer> previousSkillExpTable = new EnumMap<>(Skill.class);
	private PrayerType currentTickPrayer;
	private XpDropConfig.DamageMode damageMode;

	private boolean hideSkillIcons;
	private Color getMeleePrayerColor;
	private Color getRangePrayerColor;
	private Color getMagePrayerColor;
	private int fakeXpDropDelay;
	private XpDropConfig.DamageMode showdamagedrops;
	@Getter(AccessLevel.PACKAGE)
	private Color damageColor;

	@Provides
	XpDropConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(XpDropConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		damageMode = config.showdamagedrops();

		if (damageMode == XpDropConfig.DamageMode.ABOVE_OPPONENT)
		{
			overlayManager.add(overlay);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(WidgetHiddenChanged.class, this, this::onWidgetHiddenChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(ExperienceChanged.class, this, this::onExperienceChanged);
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("xpdrop"))
		{
			return;
		}

		updateConfig();

		if (damageMode != XpDropConfig.DamageMode.ABOVE_OPPONENT)
		{
			damageMode = this.showdamagedrops;

			if (damageMode == XpDropConfig.DamageMode.ABOVE_OPPONENT)
			{
				overlayManager.add(overlay);
			}
		}
		else
		{
			damageMode = this.showdamagedrops;

			if (damageMode != XpDropConfig.DamageMode.ABOVE_OPPONENT)
			{
				overlayManager.remove(overlay);
			}
		}
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		damage = 0;
		tickShow = 0;
	}

	private void onWidgetHiddenChanged(WidgetHiddenChanged event)
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

		if (this.hideSkillIcons)
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

		PrayerType prayer = currentTickPrayer;
		if (prayer == null)
		{
			resetTextColor(widget);
			return;
		}

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
							|| correctPrayer))
					{
						color = this.getMeleePrayerColor.getRGB();
						correctPrayer = true;
					}
					break;
				case RANGE:
					if (spriteIDs.anyMatch(id -> id == SpriteID.SKILL_RANGED || correctPrayer))
					{
						color = this.getRangePrayerColor.getRGB();
						correctPrayer = true;
					}
					break;
				case MAGIC:
					if (spriteIDs.anyMatch(id -> id == SpriteID.SKILL_MAGIC || correctPrayer))
					{
						color = this.getMagePrayerColor.getRGB();
						correctPrayer = true;
					}
					break;
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

	private void onGameTick(GameTick tick)
	{
		lastOpponent = client.getLocalPlayer().getInteracting();

		if (tickShow > 0)
		{
			tickShow--;
		}

		currentTickPrayer = getActivePrayerType();
		correctPrayer = false;

		final int fakeTickDelay = this.fakeXpDropDelay;

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

	private void onExperienceChanged(ExperienceChanged event)
	{
		final Skill skill = event.getSkill();
		final int xp = client.getSkillExperience(skill);

		lastSkill = skill;

		Integer previous = previousSkillExpTable.put(skill, xp);
		if (previous != null)
		{
			previousExpGained = xp - previous;
			hasDropped = true;
		}
	}

	private void onScriptCallbackEvent(ScriptCallbackEvent e)
	{
		if (this.showdamagedrops == XpDropConfig.DamageMode.NONE)
		{
			return;
		}

		final String eventName = e.getEventName();

		if (eventName.equals("newXpDrop"))
		{
			damage = 0;
		}
		// Handles Fake XP drops (Ironman, DMM Cap, 200m xp, etc)
		else if (eventName.equals("fakeXpDrop"))
		{
			final int[] intStack = client.getIntStack();
			final int intStackSize = client.getIntStackSize();

			final int skillId = intStack[intStackSize - 2];
			final Skill skill = Skill.values()[skillId];

			if (skill.equals(Skill.HITPOINTS))
			{
				final int exp = intStack[intStackSize - 1];
				calculateDamageDealt(exp);
			}

			client.setIntStackSize(intStackSize - 2);
		}
		else if (eventName.equals("hpXpGained"))
		{
			final int[] intStack = client.getIntStack();
			final int intStackSize = client.getIntStackSize();

			final int exp = intStack[intStackSize - 1];
			calculateDamageDealt(exp);
		}
		else if (eventName.equals("xpDropAddDamage") &&
			damageMode == XpDropConfig.DamageMode.IN_XP_DROP &&
			damage > 0)
		{
			final String[] stringStack = client.getStringStack();
			final int stringStackSize = client.getStringStackSize();

			String builder = stringStack[stringStackSize - 1] +
				ColorUtil.colorTag(this.damageColor) +
				" (" + damage + ")";
			stringStack[stringStackSize - 1] = builder;
		}
	}

	private void calculateDamageDealt(int diff)
	{
		double damageDealt = diff / HITPOINT_RATIO;
		// DeadMan mode has an XP modifier
		if (client.getWorldType().contains(WorldType.DEADMAN))
		{
			damageDealt = damageDealt / DMM_MULTIPLIER_RATIO;
		}

		// Some NPCs have an XP modifier, account for it here.
		Actor a = client.getLocalPlayer().getInteracting();
		if (!(a instanceof NPC) && !(a instanceof Player))
		{
			// If we are interacting with nothing we may have clicked away at the perfect time fall back to last tick
			if (!(lastOpponent instanceof NPC) && !(lastOpponent instanceof Player))
			{
				damage = (int) Math.rint(damageDealt);
				tickShow = 3;
				return;
			}

			a = lastOpponent;
		}

		if (a instanceof Player)
		{
			damage = (int) Math.rint(damageDealt);
			tickShow = 3;
			return;
		}

		NPC target = (NPC) a;
		damage = (int) Math.rint(damageDealt / npcManager.getXpModifier(target.getId()));
		tickShow = 3;
	}

	private void updateConfig()
	{
		this.hideSkillIcons = config.hideSkillIcons();
		this.getMeleePrayerColor = config.getMeleePrayerColor();
		this.getRangePrayerColor = config.getRangePrayerColor();
		this.getMagePrayerColor = config.getMagePrayerColor();
		this.fakeXpDropDelay = config.fakeXpDropDelay();
		this.showdamagedrops = config.showdamagedrops();
		this.damageColor = config.getDamageColor();
	}
}
