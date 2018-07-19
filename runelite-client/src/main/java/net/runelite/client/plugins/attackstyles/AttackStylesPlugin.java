/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
 * Copyright (c) 2018, Damen <https://github.com/basicDamen> -> Warning Chat Message Rework
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
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetID.COMBAT_GROUP_ID;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.attackstyles.AttackStyle.CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE_CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.OTHER;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Attack Styles",
	description = "Show your current attack style as an overlay",
	tags = {"combat", "defence", "magic", "overlay", "ranged", "strength"}
)
@Slf4j
public class AttackStylesPlugin extends Plugin
{
	private int attackStyleVarbit = -1;
	private int equippedWeaponTypeVarbit = -1;
	private int castingModeVarbit = -1;
	private AttackStyle attackStyle;
	private final Set<Skill> warnedSkills = new HashSet<>();
	private boolean warnedSkillSelected = false;
	private final Table<WeaponType, WidgetInfo, Boolean> widgetsToHide = HashBasedTable.create();
	private int loginWarningMessageCount = 0;

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
	private ChatMessageManager chatMessageManager;

	@Provides
	AttackStylesConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AttackStylesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invokeLater(this::start);
		}
	}

	private void start()
	{
		updateWarnedSkills(config.warnForAttack(), Skill.ATTACK);
		updateWarnedSkills(config.warnForStrength(), Skill.STRENGTH);
		updateWarnedSkills(config.warnForDefence(), Skill.DEFENCE);
		updateWarnedSkills(config.warnForRanged(), Skill.RANGED);
		updateWarnedSkills(config.warnForMagic(), Skill.MAGIC);
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
		overlayManager.remove(overlay);
		hideWarnedStyles(false);
		processWidgets();
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
	public void hideWidgets(WidgetHiddenChanged event)
	{
		if (event.getWidget().isSelfHidden() || TO_GROUP(event.getWidget().getId()) != COMBAT_GROUP_ID)
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
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			updateWarnedSkills(config.warnForAttack(), Skill.ATTACK);
			updateWarnedSkills(config.warnForStrength(), Skill.STRENGTH);
			updateWarnedSkills(config.warnForDefence(), Skill.DEFENCE);
			updateWarnedSkills(config.warnForRanged(), Skill.RANGED);
			updateWarnedSkills(config.warnForMagic(), Skill.MAGIC);
		}

		if (event.getGameState() == GameState.LOGIN_SCREEN ||
			event.getGameState() == GameState.HOPPING ||
			event.getGameState() == GameState.CONNECTION_LOST)
		{
			loginWarningMessageCount = 0;
		}
	}

	@Subscribe
	public void onAttackStyleChange(VarbitChanged event)
	{
		if (attackStyleVarbit == -1 || attackStyleVarbit != client.getVar(VarPlayer.ATTACK_STYLE))
		{
			attackStyleVarbit = client.getVar(VarPlayer.ATTACK_STYLE);
			updateAttackStyle(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE), attackStyleVarbit,
				client.getVar(Varbits.DEFENSIVE_CASTING_MODE));

			// This will be ran twice before it's successfully set for the player, if they have a weapon equipped.
			// Maximum value this method can set the count to is 3.
			// If the count hits 3, the `onEquippedWeaponTypeChange` event will run the `updateWarning`, setting the count to 4.
			if (loginWarningMessageCount <= 3)
				loginWarningMessageCount++;
			if (loginWarningMessageCount == 1 && equippedWeaponTypeVarbit == 0)
				sendChatMessage("test");
				// If the value is anything greater than 3, that means the LOGIN message has been sent via the `onEquippedWeaponTypeChange` event.
				// The LOGIN message queues the count to be set to 4. Anything after 4 is a generic message, which is below.
			else if (loginWarningMessageCount == 4)
				updateWarning(false);
		}
	}

	@Subscribe
	public void onEquippedWeaponTypeChange(VarbitChanged event)
	{
		if (equippedWeaponTypeVarbit == -1 || equippedWeaponTypeVarbit != client.getVar(Varbits.EQUIPPED_WEAPON_TYPE))
		{
			// This check is to accommodate the counter if the player's attackStyleVAR is saved as 0, seeing as upon setting VARS, it will only run one event to set it to 0.
			// It skips over this check on the FIRST `onEquippedWeaponTypeChange`run and continues the method.
			// After this method finishes, the count will be set to 2, though, it was setting the `EquippedWeapon` to nothing.
			// Meaning, whenever there is a weapon loaded from the VARs, it will spring this event again...
			// Upon the second run, it will run this check to increase the count to 3, to accommodate the missing `OnAttackStyleChange` event.
			// Once it hits 3, then it can run the `updateWarning` to send the initial LOGIN message.
			// Once it runs the `updateWarning` and goes past the initial LOGIN message, it will see that the count is at 3, then increase it by 1, equaling 4.
			// From any point onward, after being LOGGED_IN, the count will always remain 4 and not send another LOGIN message, seeing as the LOGIN message requires a count of 3.
			if (client.getVar(VarPlayer.ATTACK_STYLE) == 0 && loginWarningMessageCount < 3 && loginWarningMessageCount != 1)
			{
				loginWarningMessageCount++;
			}

			equippedWeaponTypeVarbit = client.getVar(Varbits.EQUIPPED_WEAPON_TYPE);
			updateAttackStyle(equippedWeaponTypeVarbit, client.getVar(VarPlayer.ATTACK_STYLE),
				client.getVar(Varbits.DEFENSIVE_CASTING_MODE));

			// It should not send a warningMessage until it hits count 3 for the LOGIN message and then the normal messages are sent afterwards, upon hitting a count of 4.
			if (loginWarningMessageCount >= 3)
			{
				updateWarning(true);
			}
			// This increases the count to ensure the event is counted and continues with either the `OnAttackStyle` event or the check above to accommodate it if AttackStyle == 0.
			else
				loginWarningMessageCount++;
		}
	}

	@Subscribe
	public void onCastingModeChange(VarbitChanged event)
	{
		if (castingModeVarbit == -1 || castingModeVarbit != client.getVar(Varbits.DEFENSIVE_CASTING_MODE))
		{
			castingModeVarbit = client.getVar(Varbits.DEFENSIVE_CASTING_MODE);
			updateAttackStyle(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE), client.getVar(VarPlayer.ATTACK_STYLE),
				castingModeVarbit);

			// This is the third event ran, causing the count to be set to 3. The LOGIN message will be sent and be set to 4, therefore,
			// no need to be continuing the count.
			// This is also ran if the player is equipping a magic weapon with the defensive casting mode enabled.
			if (loginWarningMessageCount == 4)
				updateWarning(false);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("attackIndicator"))
		{
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
		//updateWarning(false);
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
					// LOGIN message requirement
					if (loginWarningMessageCount == 3)
					{
						sendChatMessage("<col=871A1A>[ATTACK STYLE]</col> You logged in wielding a weapon that will grant you " + returnAttackColor(skill) + " XP.");
					}
					// Normal Message Requirement
					else if (loginWarningMessageCount == 4)
					{
						// Oriented around actually switching weapons.
						if (weaponSwitch)
						{
							sendChatMessage("<col=871A1A>[ATTACK STYLE]</col> This weapon's attack style will grant you " + returnAttackColor(skill) + " XP.");
						}
						// Oriented around clicking a different Combat Styles option from the interface.
						else
						{
							sendChatMessage("<col=871A1A>[ATTACK STYLE]</col> This attack style will grant you " + returnAttackColor(skill) + " XP.");
						}
					}
					warnedSkillSelected = true;
				}
			}
			// This count must be checked AFTER it runs the LOGIN message, otherwise the attackStyles that support 2 or more skills only send
			// the first option within the list from LOGIN, then sends the remaining ones in a 'normal' message.
			if (loginWarningMessageCount == 3)
				loginWarningMessageCount++;
		}
		hideWarnedStyles(config.removeWarnedStyles());
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

	private void sendChatMessage(String chatMessage)
	{
		if (config.warningMessages())
		{
			final String message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append(chatMessage)
				.build();

			chatMessageManager.queue(
				QueuedMessage.builder()
					.type(ChatMessageType.GAME)
					.runeLiteFormattedMessage(message)
					.build());
		}
	}

	private String returnAttackColor(Skill skill)
	{
		String color = "<col=ff0000>" + skill + "</col>";
		switch (skill)
		{
			case ATTACK:
			case STRENGTH:
			case DEFENCE:
				return color = "<col=D44A4A>" + skill + "</col>";
			case RANGED:
				return color = "<col=259443>" + skill + "</col>";
			case MAGIC:
				return color = "<col=369EB3>" + skill + "</col>";
		}
		return color;
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