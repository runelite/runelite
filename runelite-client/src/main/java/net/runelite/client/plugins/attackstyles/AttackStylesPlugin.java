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
import java.util.EnumSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EnumID;
import net.runelite.api.GameState;
import net.runelite.api.ParamID;
import net.runelite.api.ScriptID;
import net.runelite.api.Skill;
import net.runelite.api.StructComposition;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE_CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.OTHER;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Attack Styles",
	description = "Show your current attack style as an overlay",
	tags = {"combat", "defence", "magic", "overlay", "ranged", "strength", "warn", "pure"}
)
public class AttackStylesPlugin extends Plugin
{
	private int equippedWeaponTypeVarbit = -1;
	private AttackStyle attackStyle;
	private AttackStyle prevAttackStyle;
	private final Set<Skill> warnedSkills = EnumSet.noneOf(Skill.class);
	private boolean warnedSkillSelected;
	// Weapon type, component, hidden
	private final Table<Integer, Integer, Boolean> widgetsToHide = HashBasedTable.create();

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
	private ChatMessageManager chatManager;

	@Provides
	AttackStylesConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AttackStylesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);

		clientThread.invoke(() ->
		{
			resetWarnings(); // setup warnedSkills

			if (client.getGameState() == GameState.LOGGED_IN)
			{
				int attackStyleVarbit = client.getVarpValue(VarPlayer.ATTACK_STYLE);
				equippedWeaponTypeVarbit = client.getVarbitValue(Varbits.EQUIPPED_WEAPON_TYPE);
				int castingModeVarbit = client.getVarbitValue(Varbits.DEFENSIVE_CASTING_MODE);
				updateAttackStyle(
					equippedWeaponTypeVarbit,
					attackStyleVarbit,
					castingModeVarbit);
				updateWarning();
				processWidgets();
			}
		});
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		clientThread.invokeLater(() ->
		{
			updateWidgetsToHide(false);
			processWidgets();
			hideWidget(client.getWidget(ComponentID.COMBAT_AUTO_RETALIATE), false);
		});
		warnedSkills.clear();
	}

	@Nullable
	AttackStyle getAttackStyle()
	{
		return attackStyle;
	}

	boolean isWarnedSkillSelected()
	{
		return warnedSkillSelected;
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		if (scriptPostFired.getScriptId() == ScriptID.COMBAT_INTERFACE_SETUP)
		{
			processWidgets();
		}
	}

	/**
	 * Hide or unhide widgets depending on widgetsToHide
	 */
	private void processWidgets()
	{
		for (int componentId : widgetsToHide.row(equippedWeaponTypeVarbit).keySet())
		{
			hideWidget(client.getWidget(componentId), widgetsToHide.get(equippedWeaponTypeVarbit, componentId));
		}
		hideWidget(client.getWidget(ComponentID.COMBAT_AUTO_RETALIATE), config.hideAutoRetaliate());
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (event.getVarpId() == VarPlayer.ATTACK_STYLE
			|| event.getVarbitId() == Varbits.EQUIPPED_WEAPON_TYPE
			|| event.getVarbitId() == Varbits.DEFENSIVE_CASTING_MODE)
		{
			final int currentAttackStyleVarbit = client.getVarpValue(VarPlayer.ATTACK_STYLE);
			final int currentEquippedWeaponTypeVarbit = client.getVarbitValue(Varbits.EQUIPPED_WEAPON_TYPE);
			final int currentCastingModeVarbit = client.getVarbitValue(Varbits.DEFENSIVE_CASTING_MODE);

			boolean weaponSwitch = currentEquippedWeaponTypeVarbit != equippedWeaponTypeVarbit;

			equippedWeaponTypeVarbit = currentEquippedWeaponTypeVarbit;

			updateAttackStyle(equippedWeaponTypeVarbit, currentAttackStyleVarbit,
				currentCastingModeVarbit);
			updateWarning();

			// this is required because the widgets need to be hidden prior to interface tick, which is soon after this,
			// and before the client tick event.
			if (weaponSwitch)
			{
				processWidgets();
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("attackIndicator"))
		{
			boolean enabled = Boolean.TRUE.toString().equals(event.getNewValue());
			clientThread.invokeLater(() ->
			{
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
						updateWidgetsToHide(enabled);
						break;
				}
				updateWarning();
				processWidgets();
			});
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (attackStyle != prevAttackStyle && warnedSkillSelected && config.showChatWarnings())
		{
			final String message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("Your attack style has been changed to " + attackStyle.getName())
				.build();

			chatManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());
		}
		prevAttackStyle = attackStyle;
	}

	private void resetWarnings()
	{
		updateWarnedSkills(config.warnForAttack(), Skill.ATTACK);
		updateWarnedSkills(config.warnForStrength(), Skill.STRENGTH);
		updateWarnedSkills(config.warnForDefence(), Skill.DEFENCE);
		updateWarnedSkills(config.warnForRanged(), Skill.RANGED);
		updateWarnedSkills(config.warnForMagic(), Skill.MAGIC);
	}

	private void updateAttackStyle(int equippedWeaponType, int attackStyleIndex, int castingMode)
	{
		AttackStyle[] attackStyles = getWeaponTypeStyles(equippedWeaponType);
		if (attackStyleIndex < attackStyles.length)
		{
			// from script4525
			// Even though the client has 5 attack styles for Staffs, only attack styles 0-4 are used, with an additional
			// casting mode set for defensive casting
			if (attackStyleIndex == 4)
			{
				attackStyleIndex += castingMode;
			}

			attackStyle = attackStyles[attackStyleIndex];
			if (attackStyle == null)
			{
				attackStyle = OTHER;
			}
		}
	}

	private AttackStyle[] getWeaponTypeStyles(int weaponType)
	{
		// from script4525
		int weaponStyleEnum = client.getEnum(EnumID.WEAPON_STYLES).getIntValue(weaponType);
		if (weaponStyleEnum == -1)
		{
			if (weaponType == 30)
			{
				// Partisan
				return new AttackStyle[]{
					AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.AGGRESSIVE, DEFENSIVE
				};
			}
			return new AttackStyle[0];
		}
		int[] weaponStyleStructs = client.getEnum(weaponStyleEnum).getIntVals();

		AttackStyle[] styles = new AttackStyle[weaponStyleStructs.length];
		int i = 0;
		for (int style : weaponStyleStructs)
		{
			StructComposition attackStyleStruct = client.getStructComposition(style);
			String attackStyleName = attackStyleStruct.getStringValue(ParamID.ATTACK_STYLE_NAME);

			AttackStyle attackStyle = AttackStyle.valueOf(attackStyleName.toUpperCase());
			if (attackStyle == OTHER)
			{
				// "Other" is used for no style
				++i;
				continue;
			}

			// "Defensive" is used for Defensive and also Defensive casting
			if (i == 5 && attackStyle == DEFENSIVE)
			{
				attackStyle = DEFENSIVE_CASTING;
			}

			styles[i++] = attackStyle;
		}
		return styles;
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
	}

	// update the 'warned skill selected' flag and also rebuild the hide widgets table
	private void updateWarning()
	{
		warnedSkillSelected = false;
		if (attackStyle != null)
		{
			for (Skill skill : attackStyle.getSkills())
			{
				if (warnedSkills.contains(skill))
				{
					warnedSkillSelected = true;
					break;
				}
			}
		}
		updateWidgetsToHide(config.removeWarnedStyles());
	}

	private void updateWidgetsToHide(boolean enabled)
	{
		AttackStyle[] attackStyles = getWeaponTypeStyles(equippedWeaponTypeVarbit);

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

			// Remove appropriate combat option
			switch (i)
			{
				case 0:
					widgetsToHide.put(equippedWeaponTypeVarbit, ComponentID.COMBAT_STYLE_ONE, enabled && warnedSkill);
					break;
				case 1:
					widgetsToHide.put(equippedWeaponTypeVarbit, ComponentID.COMBAT_STYLE_TWO, enabled && warnedSkill);
					break;
				case 2:
					widgetsToHide.put(equippedWeaponTypeVarbit, ComponentID.COMBAT_STYLE_THREE, enabled && warnedSkill);
					break;
				case 3:
					widgetsToHide.put(equippedWeaponTypeVarbit, ComponentID.COMBAT_STYLE_FOUR, enabled && warnedSkill);
					break;
				case 4:
					widgetsToHide.put(equippedWeaponTypeVarbit, ComponentID.COMBAT_SPELLS, enabled && warnedSkill);
					break;
				case 5:
					// Magic staves defensive casting mode
					widgetsToHide.put(equippedWeaponTypeVarbit, ComponentID.COMBAT_DEFENSIVE_SPELL_BOX, enabled && warnedSkill);
					widgetsToHide.put(equippedWeaponTypeVarbit, ComponentID.COMBAT_DEFENSIVE_SPELL_ICON, enabled && warnedSkill);
					widgetsToHide.put(equippedWeaponTypeVarbit, ComponentID.COMBAT_DEFENSIVE_SPELL_SHIELD, enabled && warnedSkill);
					widgetsToHide.put(equippedWeaponTypeVarbit, ComponentID.COMBAT_DEFENSIVE_SPELL_TEXT, enabled && warnedSkill);
					break;
			}
		}
	}

	private static void hideWidget(Widget widget, boolean hidden)
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
	Table<Integer, Integer, Boolean> getHiddenWidgets()
	{
		return widgetsToHide;
	}
}