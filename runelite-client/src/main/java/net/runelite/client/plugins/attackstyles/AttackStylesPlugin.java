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
package net.runelite.client.plugins.attackstyles;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.inject.Provides;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetID.COMBAT_GROUP_ID;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.attackstyles.AttackStyle.CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE_CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.OTHER;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Attack Styles",
	description = "Show your current attack style as an overlay",
	tags = {"combat", "defence", "magic", "overlay", "ranged", "strength", "warn", "pure"}
)
@Singleton
public class AttackStylesPlugin extends Plugin
{
	private int attackStyleVarbit = -1;
	private int equippedWeaponTypeVarbit = -1;
	private int castingModeVarbit = -1;
	private AttackStyle attackStyle;
	private final Set<Skill> warnedSkills = new HashSet<>();
	private boolean warnedSkillSelected = false;
	private final Table<WeaponType, WidgetInfo, Boolean> widgetsToHide = HashBasedTable.create();

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private AttackStylesConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private AttackStylesOverlay overlay;

	@Inject
	private EventBus eventBus;

	@Provides
	AttackStylesConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AttackStylesConfig.class);
	}

	// config values
	@Getter(AccessLevel.PACKAGE)
	private boolean alwaysShowStyle;
	private boolean warnForDefence;
	private boolean warnForAttack;
	private boolean warnForStrength;
	private boolean warnForRanged;
	private boolean warnForMagic;
	private boolean hideAutoRetaliate;
	private boolean removeWarnedStyles;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invoke(this::start);
		}
	}

	private void start()
	{
		updateWarnedSkills(warnForAttack, Skill.ATTACK);
		updateWarnedSkills(warnForStrength, Skill.STRENGTH);
		updateWarnedSkills(warnForDefence, Skill.DEFENCE);
		updateWarnedSkills(warnForRanged, Skill.RANGED);
		updateWarnedSkills(warnForMagic, Skill.MAGIC);
		attackStyleVarbit = client.getVar(VarPlayer.ATTACK_STYLE);
		equippedWeaponTypeVarbit = client.getVar(Varbits.EQUIPPED_WEAPON_TYPE);
		castingModeVarbit = client.getVar(Varbits.DEFENSIVE_CASTING_MODE);
		updateAttackStyle(
			equippedWeaponTypeVarbit,
			attackStyleVarbit,
			castingModeVarbit);
		updateWarning(false);
		processWidgets();
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		hideWarnedStyles(false);
		processWidgets();
		hideWidget(client.getWidget(WidgetInfo.COMBAT_AUTO_RETALIATE), false);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(WidgetHiddenChanged.class, this, this::onWidgetHiddenChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
	}

	public AttackStyle getAttackStyle()
	{
		return attackStyle;
	}

	boolean isWarnedSkillSelected()
	{
		return warnedSkillSelected;
	}

	private void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		if (event.getWidget().isSelfHidden() || TO_GROUP(event.getWidget().getId()) != COMBAT_GROUP_ID)
		{
			return;
		}

		processWidgets();
	}

	private void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() != COMBAT_GROUP_ID)
		{
			return;
		}

		processWidgets();
	}

	/**
	 * Hide or unhide widgets depending on widgetsToHide
	 */
	private void processWidgets()
	{
		WeaponType equippedWeaponType = WeaponType.getWeaponType(equippedWeaponTypeVarbit);

		if (widgetsToHide.containsRow(equippedWeaponType))
		{
			for (WidgetInfo widgetKey : widgetsToHide.row(equippedWeaponType).keySet())
			{
				hideWidget(client.getWidget(widgetKey), widgetsToHide.get(equippedWeaponType, widgetKey));
			}
		}
		hideWidget(client.getWidget(WidgetInfo.COMBAT_AUTO_RETALIATE), this.hideAutoRetaliate);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			updateWarnedSkills(this.warnForAttack, Skill.ATTACK);
			updateWarnedSkills(this.warnForStrength, Skill.STRENGTH);
			updateWarnedSkills(this.warnForDefence, Skill.DEFENCE);
			updateWarnedSkills(this.warnForRanged, Skill.RANGED);
			updateWarnedSkills(this.warnForMagic, Skill.MAGIC);
		}
	}

	void onVarbitChanged(VarbitChanged event)
	{
		if (attackStyleVarbit == -1 || attackStyleVarbit != client.getVar(VarPlayer.ATTACK_STYLE))
		{
			attackStyleVarbit = client.getVar(VarPlayer.ATTACK_STYLE);
			updateAttackStyle(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE), attackStyleVarbit,
				client.getVar(Varbits.DEFENSIVE_CASTING_MODE));
			updateWarning(false);
		}

		if (equippedWeaponTypeVarbit == -1 || equippedWeaponTypeVarbit != client.getVar(Varbits.EQUIPPED_WEAPON_TYPE))
		{
			equippedWeaponTypeVarbit = client.getVar(Varbits.EQUIPPED_WEAPON_TYPE);
			updateAttackStyle(equippedWeaponTypeVarbit, client.getVar(VarPlayer.ATTACK_STYLE),
				client.getVar(Varbits.DEFENSIVE_CASTING_MODE));
			updateWarning(true);
		}

		if (castingModeVarbit == -1 || castingModeVarbit != client.getVar(Varbits.DEFENSIVE_CASTING_MODE))
		{
			castingModeVarbit = client.getVar(Varbits.DEFENSIVE_CASTING_MODE);
			updateAttackStyle(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE), client.getVar(VarPlayer.ATTACK_STYLE),
				castingModeVarbit);
			updateWarning(false);
		}
	}

	void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("attackIndicator"))
		{
			updateConfig();

			boolean enabled = event.getNewValue().equals("true");
			switch (event.getKey())
			{
				case "warnForDefensive":
					updateWarnedSkills(enabled, Skill.DEFENCE);
					break;
				case "warnForAttack":
					updateWarnedSkills(enabled, Skill.ATTACK);
					break;
				case "warnForStrength":
					updateWarnedSkills(enabled, Skill.STRENGTH);
					break;
				case "warnForRanged":
					updateWarnedSkills(enabled, Skill.RANGED);
					break;
				case "warnForMagic":
					updateWarnedSkills(enabled, Skill.MAGIC);
					break;
				case "removeWarnedStyles":
					hideWarnedStyles(enabled);
					break;
			}
			processWidgets();
		}
	}

	private void updateConfig()
	{
		this.alwaysShowStyle = config.alwaysShowStyle();
		this.warnForDefence = config.warnForDefence();
		this.warnForAttack = config.warnForAttack();
		this.warnForStrength = config.warnForStrength();
		this.warnForRanged = config.warnForRanged();
		this.warnForMagic = config.warnForMagic();
		this.hideAutoRetaliate = config.hideAutoRetaliate();
		this.removeWarnedStyles = config.removeWarnedStyles();
	}

	private void updateAttackStyle(int equippedWeaponType, int attackStyleIndex, int castingMode)
	{
		AttackStyle[] attackStyles = WeaponType.getWeaponType(equippedWeaponType).getAttackStyles();
		if (attackStyleIndex < attackStyles.length)
		{
			attackStyle = attackStyles[attackStyleIndex];
			if (attackStyle == null)
			{
				attackStyle = OTHER;
			}
			else if ((attackStyle == CASTING) && (castingMode == 1))
			{
				attackStyle = DEFENSIVE_CASTING;
			}
		}
	}

	private void updateWarnedSkills(boolean enabled, Skill skill)
	{
		if (enabled)
		{
			warnedSkills.add(skill);
		}
		else
		{
			warnedSkills.remove(skill);
		}
		updateWarning(false);
	}

	private void updateWarning(boolean weaponSwitch)
	{
		warnedSkillSelected = false;
		if (attackStyle != null)
		{
			for (Skill skill : attackStyle.getSkills())
			{
				if (warnedSkills.contains(skill))
				{
//					if (weaponSwitch)
//					{
//						// TODO : chat message to warn players that their weapon switch also caused an unwanted attack style change
//					}
					warnedSkillSelected = true;
					break;
				}
			}
		}
		hideWarnedStyles(this.removeWarnedStyles);
	}

	private void hideWarnedStyles(boolean enabled)
	{
		WeaponType equippedWeaponType = WeaponType.getWeaponType(equippedWeaponTypeVarbit);
		if (equippedWeaponType == null)
		{
			return;
		}

		AttackStyle[] attackStyles = equippedWeaponType.getAttackStyles();

		// Iterate over attack styles
		for (int i = 0; i < attackStyles.length; i++)
		{
			AttackStyle attackStyle = attackStyles[i];
			if (attackStyle == null)
			{
				continue;
			}

			boolean warnedSkill = false;
			for (Skill skill : attackStyle.getSkills())
			{
				if (warnedSkills.contains(skill))
				{
					warnedSkill = true;
					break;
				}
			}

			// Magic staves defensive casting mode
			if (attackStyle == AttackStyle.DEFENSIVE_CASTING || !enabled)
			{
				widgetsToHide.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_BOX, enabled && warnedSkill);
				widgetsToHide.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_ICON, enabled && warnedSkill);
				widgetsToHide.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_SHIELD, enabled && warnedSkill);
				widgetsToHide.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_TEXT, enabled && warnedSkill);
			}

			// Remove appropriate combat option
			switch (i)
			{
				case 0:
					widgetsToHide.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_ONE, enabled && warnedSkill);
					break;
				case 1:
					widgetsToHide.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_TWO, enabled && warnedSkill);
					break;
				case 2:
					widgetsToHide.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_THREE, enabled && warnedSkill);
					break;
				case 3:
					widgetsToHide.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_FOUR, enabled && warnedSkill);
					break;
				case 4:
					widgetsToHide.put(equippedWeaponType, WidgetInfo.COMBAT_SPELLS, enabled && warnedSkill);
					break;
				default:
					// 5 can be defensive casting
			}
		}
	}

	private void hideWidget(Widget widget, boolean hidden)
	{
		if (widget != null)
		{
			widget.setHidden(hidden);
		}
	}

	@VisibleForTesting
	Set<Skill> getWarnedSkills()
	{
		return warnedSkills;
	}

	@VisibleForTesting
	Table<WeaponType, WidgetInfo, Boolean> getHiddenWidgets()
	{
		return widgetsToHide;
	}
}