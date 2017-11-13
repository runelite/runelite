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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.VarbitChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.attackindicator.AttackStyle.CASTING;
import static net.runelite.client.plugins.attackindicator.AttackStyle.DEFENSIVE_CASTING;

@PluginDescriptor(
	name = "Attack indicator plugin"
)
public class AttackIndicatorPlugin extends Plugin
{
	@Inject
	@Nullable
	Client client;

	private int attackStyleVarbit = -1;
	private int equippedWeaponTypeVarbit = -1;
	private int castingModeVarbit = -1;
	private AttackStyle attackStyle;

	@Inject
	AttackIndicatorOverlay overlay;

	@Override
	public void configure(Binder binder)
	{
		binder.bind(AttackIndicatorOverlay.class);
	}

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

	public AttackStyle getAttackStyle()
	{
		return attackStyle;
	}

	@Subscribe
	public void onAttackStyleChange(VarbitChanged event)
	{
		if (attackStyleVarbit == -1 || attackStyleVarbit != client.getSetting(Varbits.ATTACK_STYLE))
		{
			attackStyleVarbit = client.getSetting(Varbits.ATTACK_STYLE);
			updateAttackStyle(client.getSetting(Varbits.EQUIPPED_WEAPON_TYPE), attackStyleVarbit,
				client.getSetting(Varbits.DEFENSIVE_CASTING_MODE));
		}
	}

	@Subscribe
	public void onEquippedWeaponTypeChange(VarbitChanged event)
	{
		if (equippedWeaponTypeVarbit == -1 || equippedWeaponTypeVarbit != client.getSetting(Varbits.EQUIPPED_WEAPON_TYPE))
		{
			equippedWeaponTypeVarbit = client.getSetting(Varbits.EQUIPPED_WEAPON_TYPE);
			updateAttackStyle(equippedWeaponTypeVarbit, client.getSetting(Varbits.ATTACK_STYLE),
				client.getSetting(Varbits.DEFENSIVE_CASTING_MODE));
		}
	}

	@Subscribe
	public void onCastingModeChange(VarbitChanged event)
	{
		if (castingModeVarbit == -1 || castingModeVarbit != client.getSetting(Varbits.DEFENSIVE_CASTING_MODE))
		{
			castingModeVarbit = client.getSetting(Varbits.DEFENSIVE_CASTING_MODE);
			updateAttackStyle(client.getSetting(Varbits.EQUIPPED_WEAPON_TYPE), client.getSetting(Varbits.ATTACK_STYLE),
				castingModeVarbit);
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
				return;
			}
			if ((attackStyle == CASTING) && (castingMode == 1))
			{
				attackStyle = DEFENSIVE_CASTING;
			}
		}
	}

}
