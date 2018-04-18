/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
 * Copyright (c) 2018, oplosthee <https://github.com/oplosthee>
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
package net.runelite.client.plugins.metronome;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.attackstyles.AttackStyle;
import net.runelite.client.plugins.attackstyles.WeaponType;

import static net.runelite.api.Skill.HITPOINTS;
import static net.runelite.client.plugins.attackstyles.AttackStyle.CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.RANGING;

@PluginDescriptor(
	name = "Metronome",
	enabledByDefault = false
)
public class MetronomePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private MetronomePluginConfiguration config;

	private int tickCounter = 0;
	private boolean shouldTock = false;
	private int curWeaponTickRate = 1;
	private boolean isCasting = false;
	private boolean isRapid = false;
	private static final int WEAPON_SLOT = EquipmentInventorySlot.WEAPON.getSlotIdx();
	private AttackStyle attackStyle;

	@Provides
	MetronomePluginConfiguration provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MetronomePluginConfiguration.class);
	}

	@Subscribe
	void onItemContainerChanged(ItemContainerChanged event)
	{
		if (config.syncWithAttack())
		{
			updateIsCasting(client.getSetting(Varbits.EQUIPPED_WEAPON_TYPE), client.getSetting(Setting.ATTACK_STYLE));
			if (!isCasting)
			{
				updateIsRapid(client.getSetting(Varbits.EQUIPPED_WEAPON_TYPE), client.getSetting(Setting.ATTACK_STYLE));
			}
			updateCurrentTickRate();
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		//Need to get the currently equipped weapon.
		if (config.syncWithAttack() && client.getGameState() == GameState.LOGGED_IN)
		{
			updateIsCasting(client.getSetting(Varbits.EQUIPPED_WEAPON_TYPE), client.getSetting(Setting.ATTACK_STYLE));
			if (!isCasting)
			{
				updateIsRapid(client.getSetting(Varbits.EQUIPPED_WEAPON_TYPE), client.getSetting(Setting.ATTACK_STYLE));
			}
			updateCurrentTickRate();
		}
	}

	private void updateIsRapid(int equippedWeaponType, int attackStyleIndex)
	{
		AttackStyle[] attackStyles = WeaponType.getWeaponType(equippedWeaponType).getAttackStyles();
		if (attackStyleIndex < attackStyles.length)
		{
			attackStyle = attackStyles[attackStyleIndex];
			if (attackStyle == RANGING && attackStyleIndex == 1)
			{
				isRapid = true;
			}
			else
				{
				isRapid = false;
			}
		}
	}

	private void updateIsCasting(int equippedWeaponType, int attackStyleIndex)
	{
		AttackStyle[] attackStyles = WeaponType.getWeaponType(equippedWeaponType).getAttackStyles();
		if (attackStyleIndex < attackStyles.length)
		{
			attackStyle = attackStyles[attackStyleIndex];
			if (attackStyle == CASTING)
			{
				isCasting = true;
			}
			else
			{
				isCasting = false;
			}
		}
	}

	public void updateCurrentTickRate()
	{
		final ItemContainer equipContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		if (isCasting)
		{
			curWeaponTickRate = 5;
		}
		else if (equipContainer != null)
		{
			Item[] equippedItems = equipContainer.getItems();
			if (equippedItems.length >= WEAPON_SLOT)
			{
				curWeaponTickRate = getChargedWeaponFromId(equippedItems[WEAPON_SLOT].getId()).getTickRate();
				if (isRapid)
				{
					curWeaponTickRate--;
				}
			}
		}
		else
		{
			curWeaponTickRate = 4;
		}
	}

	public weapontickrates getChargedWeaponFromId(int itemId)
	{
		for (weapontickrates weapon : weapontickrates.values())
		{
			if (itemId == weapon.getItemId())
			{
				return weapon;
			}
		}
		return null;
	}

	@Subscribe
	void onTick(GameTick tick)
	{
		if (config.tickCount() == 0 && !config.syncWithAttack())
		{
			return;
		}

		if (++tickCounter % (config.syncWithAttack() ? curWeaponTickRate : config.tickCount()) == 0)
		{
			if (config.enableTock() && shouldTock)
			{
				client.playSoundEffect(SoundEffectID.GE_DECREMENT_PLOP);
			}
			else
			{
				client.playSoundEffect(SoundEffectID.GE_INCREMENT_PLOP);
			}
			shouldTock = !shouldTock;
		}
	}

	@Subscribe
	public void onExperienceChanged(ExperienceChanged event)
	{
		if (!config.syncWithAttack() && event.getSkill() != HITPOINTS)
		{
			return;
		}
		tickCounter = 0;
		shouldTock = false;
	}
}
