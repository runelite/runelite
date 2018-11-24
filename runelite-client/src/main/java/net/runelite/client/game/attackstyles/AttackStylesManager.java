/*
 * Copyright (c) 2018, Davis Cook <daviscook447@gmail.com>
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
package net.runelite.client.game.attackstyles;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.events.AttackStyleChanged;
import net.runelite.client.events.EquippedWeaponChanged;

import javax.inject.Inject;
import javax.inject.Singleton;

import static net.runelite.client.game.attackstyles.AttackStyle.CASTING;
import static net.runelite.client.game.attackstyles.AttackStyle.DEFENSIVE_CASTING;
import static net.runelite.client.game.attackstyles.AttackStyle.OTHER;

@Singleton
@Slf4j
public class AttackStylesManager
{

	private int attackStyleVarbit = -1;
	private int equippedWeaponTypeVarbit = -1;
	private int castingModeVarbit = -1;

	private AttackStyle attackStyle;

	public AttackStyle getAttackStyle()
	{
		return attackStyle;
	}

	private final Client client;
	private final ClientThread clientThread;
	private final EventBus eventBus;

	@Inject
	public AttackStylesManager(Client client, ClientThread clientThread, EventBus eventBus)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.eventBus = eventBus;

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invoke(this::start);
		}
	}

	private void start()
	{
		attackStyleVarbit = client.getVar(VarPlayer.ATTACK_STYLE);
		equippedWeaponTypeVarbit = client.getVar(Varbits.EQUIPPED_WEAPON_TYPE);
		castingModeVarbit = client.getVar(Varbits.DEFENSIVE_CASTING_MODE);
		updateAttackStyle(
				equippedWeaponTypeVarbit,
				attackStyleVarbit,
				castingModeVarbit);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (attackStyleVarbit == -1 || attackStyleVarbit != client.getVar(VarPlayer.ATTACK_STYLE))
		{
			attackStyleVarbit = client.getVar(VarPlayer.ATTACK_STYLE);
			updateAttackStyle(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE),
					attackStyleVarbit,
					client.getVar(Varbits.DEFENSIVE_CASTING_MODE));
		}

		if (equippedWeaponTypeVarbit == -1 || equippedWeaponTypeVarbit != client.getVar(Varbits.EQUIPPED_WEAPON_TYPE))
		{
			equippedWeaponTypeVarbit = client.getVar(Varbits.EQUIPPED_WEAPON_TYPE);
			eventBus.post(new EquippedWeaponChanged(WeaponType.getWeaponType(equippedWeaponTypeVarbit)));
			updateAttackStyle(equippedWeaponTypeVarbit,
					client.getVar(VarPlayer.ATTACK_STYLE),
					client.getVar(Varbits.DEFENSIVE_CASTING_MODE));
		}

		if (castingModeVarbit == -1 || castingModeVarbit != client.getVar(Varbits.DEFENSIVE_CASTING_MODE))
		{
			castingModeVarbit = client.getVar(Varbits.DEFENSIVE_CASTING_MODE);
			updateAttackStyle(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE),
					client.getVar(VarPlayer.ATTACK_STYLE),
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
				attackStyle = OTHER;
			}
			else if ((attackStyle == CASTING) && (castingMode == 1))
			{
				attackStyle = DEFENSIVE_CASTING;
			}
			eventBus.post(new AttackStyleChanged(attackStyle));
		}
	}

}
