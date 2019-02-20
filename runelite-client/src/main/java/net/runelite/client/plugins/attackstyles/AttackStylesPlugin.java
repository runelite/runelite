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
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetLoaded;
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
import net.runelite.client.eventbus.Subscribe;
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
public class AttackStylesPlugin extends Plugin
{
	private static final String WEAPON_SWITCH_MESSAGE = "By switching your weapon you are now on a warned attack style.";
	private static final String LOCK_MESSAGE = "The attack option you selected is locked via the Attack Styles plugin.";
	private static final String WARN_MESSAGE = "WARNING: Your attack style switched to: ";
	private static final String WARN_AUTO_RETALIATE_MESSAGE = "WARNING: Your auto retaliate option changed to: ";

	private int attackStyleVarbit = -1;
	private int equippedWeaponTypeVarbit = -1;
	private int castingModeVarbit = -1;
	private AttackStyle attackStyle;
	private final Set<Skill> warnedSkills = new HashSet<>();
	private boolean warnedSkillSelected = false;
	private final Table<WeaponType, WidgetInfo, Boolean> widgetsToHideOrLock = HashBasedTable.create();

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
			clientThread.invoke(this::start);
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
		setWidgetsToHideOrLock();
		processWidgets();
		hideWidget(client.getWidget(WidgetInfo.COMBAT_AUTO_RETALIATE), false);
	}

	public AttackStyle getAttackStyle()
	{
		return attackStyle;
	}

	public boolean isWarnedSkillSelected()
	{
		return warnedSkillSelected && config.warnedStyleHandler() != HandleType.NONE;
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		if (event.getWidget().isSelfHidden() || TO_GROUP(event.getWidget().getId()) != COMBAT_GROUP_ID)
		{
			return;
		}

		processWidgets();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
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

		if (widgetsToHideOrLock.containsRow(equippedWeaponType))
		{
			for (WidgetInfo widgetKey : widgetsToHideOrLock.row(equippedWeaponType).keySet())
			{
				if (config.warnedStyleHandler() == HandleType.HIDE)
				{
					hideWidget(client.getWidget(widgetKey), widgetsToHideOrLock.get(equippedWeaponType, widgetKey));
				}
				else
				{
					// Always show widget when not on 'REMOVE' option
					hideWidget(client.getWidget(widgetKey), false);
				}
			}
		}
		hideWidget(client.getWidget(WidgetInfo.COMBAT_AUTO_RETALIATE), config.warnForAutoRetaliate() && config.warnedStyleHandler() == HandleType.HIDE);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			updateWarnedSkills(config.warnForAttack(), Skill.ATTACK);
			updateWarnedSkills(config.warnForStrength(), Skill.STRENGTH);
			updateWarnedSkills(config.warnForDefence(), Skill.DEFENCE);
			updateWarnedSkills(config.warnForRanged(), Skill.RANGED);
			updateWarnedSkills(config.warnForMagic(), Skill.MAGIC);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		// Warn for auto-retaliate?
		if (event.getWidgetId() == WidgetInfo.COMBAT_AUTO_RETALIATE.getId()
				&& config.warnForAutoRetaliate())
		{
			if (config.warnedStyleHandler() == HandleType.LOCK)
			{
				sendChatMessage(LOCK_MESSAGE);
				event.consume();
			}
			else if (config.warnedStyleHandler() == HandleType.WARN)
			{
				int autoRetaliateOn = client.getVar(VarPlayer.AUTO_RETALIATE);
				String onOffMessage = "OFF";
				if (autoRetaliateOn == 1)
				{
					onOffMessage = "ON";
				}
				sendChatMessage(WARN_AUTO_RETALIATE_MESSAGE + onOffMessage + ".");
			}
			return;
		}

		WeaponType equippedWeaponType = WeaponType.getWeaponType(equippedWeaponTypeVarbit);

		if (config.warnedStyleHandler() == HandleType.LOCK && widgetsToHideOrLock.containsRow(equippedWeaponType))
		{
			for (WidgetInfo widgetKey : widgetsToHideOrLock.row(equippedWeaponType).keySet())
			{
				if (widgetKey.getId() != event.getWidgetId())
				{
					continue;
				}

				if (widgetsToHideOrLock.get(equippedWeaponType, widgetKey))
				{
					sendChatMessage(LOCK_MESSAGE);
					event.consume();
				}
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
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
			}
			updateWarning(false);
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
	}

	private void updateWarning(boolean weaponSwitch)
	{
		warnedSkillSelected = false;
		if (attackStyle != null && config.warnedStyleHandler() != HandleType.NONE)
		{
			for (Skill skill : attackStyle.getSkills())
			{
				if (warnedSkills.contains(skill))
				{
					if (weaponSwitch)
					{
						sendChatMessage(WEAPON_SWITCH_MESSAGE);
					}
					else
					{
						sendChatMessage(WARN_MESSAGE + skill.getName() + ".");
					}
					warnedSkillSelected = true;
					break;
				}
			}
		}
		setWidgetsToHideOrLock();
	}

	private void setWidgetsToHideOrLock()
	{
		WeaponType equippedWeaponType = WeaponType.getWeaponType(equippedWeaponTypeVarbit);
		if (equippedWeaponType == null)
		{
			return;
		}

		Boolean enabled = config.warnedStyleHandler() == HandleType.LOCK
				|| config.warnedStyleHandler() == HandleType.HIDE;
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
				widgetsToHideOrLock.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_BOX, enabled && warnedSkill);
				widgetsToHideOrLock.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_ICON, enabled && warnedSkill);
				widgetsToHideOrLock.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_SHIELD, enabled && warnedSkill);
				widgetsToHideOrLock.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_TEXT, enabled && warnedSkill);
			}

			// Offensive casting
			if (attackStyle == AttackStyle.CASTING || !enabled)
			{
				widgetsToHideOrLock.put(equippedWeaponType, WidgetInfo.COMBAT_SPELL_BOX, enabled && warnedSkill);
				widgetsToHideOrLock.put(equippedWeaponType, WidgetInfo.COMBAT_SPELL_ICON, enabled && warnedSkill);
				widgetsToHideOrLock.put(equippedWeaponType, WidgetInfo.COMBAT_SPELL_TEXT, enabled && warnedSkill);
			}

			// Remove appropriate combat option
			switch (i)
			{
				case 0:
					widgetsToHideOrLock.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_ONE, enabled && warnedSkill);
					break;
				case 1:
					widgetsToHideOrLock.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_TWO, enabled && warnedSkill);
					break;
				case 2:
					widgetsToHideOrLock.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_THREE, enabled && warnedSkill);
					break;
				case 3:
					widgetsToHideOrLock.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_FOUR, enabled && warnedSkill);
					break;
				default:
					// 4 and 5 are magic related - handled above
			}
		}
	}

	private void sendChatMessage(String chatMessage)
	{
		final String message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append(chatMessage)
				.build();

		chatMessageManager.queue(
				QueuedMessage.builder()
						.type(ChatMessageType.GAME)
						.runeLiteFormattedMessage(message)
						.build());
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
		return widgetsToHideOrLock;
	}
}