/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
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
package net.runelite.client.plugins.attackindicator;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Setting;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetID.COMBAT_GROUP_ID;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.attackindicator.AttackStyle.CASTING;
import static net.runelite.client.plugins.attackindicator.AttackStyle.DEFENSIVE_CASTING;
import static net.runelite.client.plugins.attackindicator.AttackStyle.OTHER;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@PluginDescriptor(
	name = "Attack indicator"
)
@Slf4j
public class AttackIndicatorPlugin extends Plugin
{
	private int attackStyleVarbit = -1;
	private int equippedWeaponTypeVarbit = -1;
	private int castingModeVarbit = -1;
	private AttackStyle attackStyle;
	private final Set<Skill> warnedSkills = new HashSet<>();
	private boolean warnedSkillSelected = false;
	private final Table<WeaponType, WidgetInfo, Boolean> widgetsToHide = HashBasedTable.create();

	/**
	 * the widgets available for our current weapon type + whether we should hide or not
	 */
	private List<Pair<WidgetInfo, Boolean>> touchedWidgets = new ArrayList<>();

	@Inject
	private Client client;

	@Inject
	private AttackIndicatorConfig config;

	@Inject
	private AttackIndicatorOverlay overlay;

	@Provides
	AttackIndicatorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AttackIndicatorConfig.class);
	}

	@Override
	public AttackIndicatorOverlay getOverlay()
	{
		return overlay;
	}


	@Override
	protected void startUp() throws Exception
	{
		if (client.getGameState() == GameState.LOGGED_IN || client.getGameState() == GameState.LOADING)
		{
			updateAttackStyle();
			updateTouchedWidgets();
			touchWidgets();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		updateTouchedWidgets(false);
		touchWidgets();
	}

	public AttackStyle getAttackStyle()
	{
		return attackStyle;
	}

	public boolean isWarnedSkillSelected()
	{
		return warnedSkillSelected;
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		if (event.getWidget().isLocalHidden() || TO_GROUP(event.getWidget().getId()) != COMBAT_GROUP_ID)
		{
			return;
		}

		touchWidgets();
	}

	/**
	 * will modify all widgets according to the hide parameter. This will hide or unhide regardless of the config, check that yourself
	 */
	private void touchWidgets()
	{
		for (Pair<WidgetInfo, Boolean> infoPair : touchedWidgets)
		{
			touchWidget(infoPair.getKey(), infoPair.getValue());
		}
	}

	private void touchWidget(WidgetInfo widget, boolean hide)
	{
		Widget w = client.getWidget(widget);

		if (w != null)
		{
			if (w.isHidden() != hide)
			{
				w.setHidden(hide);
			}
		}
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN || event.getGameState() == GameState.LOADING)
		{
			updateAttackStyle();
			updateTouchedWidgets();
			touchWidgets();
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		int newAttackStyle = client.getSetting(Setting.ATTACK_STYLE);
		int newWeaponType = client.getSetting(Varbits.EQUIPPED_WEAPON_TYPE);
		int newCastingMode = client.getSetting(Varbits.DEFENSIVE_CASTING_MODE);

		if (equippedWeaponTypeVarbit != newWeaponType || attackStyleVarbit != newAttackStyle || newCastingMode != castingModeVarbit)
		{
			equippedWeaponTypeVarbit = newWeaponType;
			attackStyleVarbit = newAttackStyle;
			castingModeVarbit = newCastingMode;
			updateAttackStyle();
			updateTouchedWidgets();
			touchWidgets();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN && client.getGameState() != GameState.LOADING)
			return;


		if (event.getGroup().equals("attackIndicator"))
		{
			boolean enabled = event.getNewValue().equals("true");
			switch (event.getKey())
			{
				default:
					updateAttackStyle();
					updateTouchedWidgets();
					touchWidgets();
			}
		}
	}

	private void updateTouchedWidgets(boolean hide)
	{
		WeaponType type = WeaponType.getWeaponType(equippedWeaponTypeVarbit);

		//clear so we don't hide old widgets
		touchedWidgets.clear();

		//check each style to see if they're allowed and add them to the touched set if not allowed

		AttackStyle style1 = type.getAttackStyles()[0];

		if (style1 != null)
		{
			boolean warned = isWarnedStyle(style1, 0);
			touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_STYLE_ONE, warned && hide));
		}

		AttackStyle style2 = type.getAttackStyles()[1];

		if (style2 != null)
		{
			boolean warned = isWarnedStyle(style2, 1);
			touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_STYLE_TWO, warned && hide));
		}


		AttackStyle style3 = type.getAttackStyles()[2];

		if (style3 != null)
		{
			boolean warned = isWarnedStyle(style3, 2);
			touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_STYLE_THREE, warned && hide));
		}

		AttackStyle style4 = type.getAttackStyles()[3];

		if (style4 != null)
		{
			boolean warned = isWarnedStyle(style4, 3);
			touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_STYLE_FOUR, warned && hide));
		}

		if (type.getAttackStyles().length > 4) //4th style is always magic
		{
			boolean warnedMagic = isWarnedStyle(AttackStyle.CASTING, 4);
			boolean warnedDefense = isWarnedStyle(AttackStyle.DEFENSIVE_CASTING, 4);

			touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_DEFENSIVE_SPELL_BOX, warnedDefense && hide));
			touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_DEFENSIVE_SPELL_ICON, warnedDefense && hide));
			touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_DEFENSIVE_SPELL_SHIELD, warnedDefense && hide));
			touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_DEFENSIVE_SPELL_TEXT, warnedDefense && hide));

			touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_SPELL_BOX, warnedMagic && hide));
			touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_SPELL_ICON, warnedMagic && hide));
			touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_SPELL_TEXT, warnedMagic && hide));
		}

		//add auto retaliate if necessary
		touchedWidgets.add(new Pair<>(WidgetInfo.COMBAT_AUTO_RETALIATE_BOX, config.removeAutoRetaliate()));

		client.getForceHiddenWidgetIds().clear();

		for (Pair<WidgetInfo, Boolean> pair : touchedWidgets)
		{
			if (pair.getValue())
			{
				client.getForceHiddenWidgetIds().add(pair.getKey().getPackedId());
			}
		}
	}

	private void updateTouchedWidgets()
	{
		boolean removeWarnedStyles = config.removeWarnedStyles();

		updateTouchedWidgets(removeWarnedStyles);
	}

	public boolean isDefensiveCastingEnabled()
	{
		return castingModeVarbit == 1;
	}

	private void updateAttackStyle()
	{
		WeaponType weaponType = WeaponType.getWeaponType(equippedWeaponTypeVarbit);

		if (weaponType == null)
			return;

		AttackStyle[] attackStyles = weaponType.getAttackStyles();
		boolean defensiveCasting = isDefensiveCastingEnabled();

		if (attackStyleVarbit < attackStyles.length)
		{
			attackStyle = attackStyles[attackStyleVarbit];
			if (attackStyle == null)
			{
				attackStyle = OTHER;
			}
			else if (defensiveCasting)
			{
				attackStyle = DEFENSIVE_CASTING;
			}
		}

		if (isWarnedStyle(attackStyle, attackStyleVarbit))
		{
			warnedSkillSelected = true;
		}
		else
		{
			warnedSkillSelected = false;
		}
	}

	private boolean isWarnedStyle(AttackStyle style, int styleNumber)
	{
		if (style == null)
			return false;

		switch (styleNumber)
		{
			case 0:
				if (config.warnForStyle1())
					return true;
				break;
			case 1:
				if (config.warnForStyle2())
					return true;
				break;
			case 2:
				if (config.warnForStyle3())
					return true;
				break;
			case 3:
				if (config.warnForStyle4())
					return true;
				break;
			default:
				break;
		}

		switch (style)
		{
			case ACCURATE:
				if (config.warnForAttack())
					return true;
				return false;
			case AGGRESSIVE:
				if (config.warnForStrength())
					return true;
				return false;
			case CONTROLLED:
				if (config.warnForAttack() || config.warnForStrength() || config.warnForDefensive())
					return true;
				return false;
			case OTHER:
				return false;
			case RANGING:
				if (config.warnForRanged())
					return true;
				return false;
			case LONGRANGE:
				if (config.warnForRanged() || config.warnForDefensive())
					return true;
				return false;
			case DEFENSIVE:
				if (config.warnForDefensive())
					return true;
				return false;
			case CASTING:
				if (config.warnForMagic())
					return true;
				return false;
			case DEFENSIVE_CASTING:
				if (config.warnForMagic() || config.warnForDefensive())
					return true;
				return false;
			default:
				return false;
		}
	}

	private void hideWidget(Widget widget, boolean hidden)
	{
		if (widget != null)
		{
			if (widget.isHidden() != hidden)
			{
				widget.setHidden(hidden);
			}
		}
	}
}
