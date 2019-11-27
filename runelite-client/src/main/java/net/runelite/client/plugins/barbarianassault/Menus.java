/*
 * Copyright (c) 2019, 7ate9 <https://github.com/se7enAte9>
 * Copyright (c) 2019, https://openosrs.com
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
package net.runelite.client.plugins.barbarianassault;

import com.google.common.collect.ImmutableSet;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.MenuOpcode;
import net.runelite.client.menus.BaseComparableEntry;
import static net.runelite.client.menus.ComparableEntries.newBaseComparableEntry;

@AllArgsConstructor
public enum Menus
{
	ATTACK_PENANCE_FIGHTER(Role.ATTACKER, newBaseComparableEntry("attack", "penance fighter", -1, -1, true, false)),
	ATTACK_PENANCE_RANGER(Role.ATTACKER, newBaseComparableEntry("attack", "penance ranger", -1, -1, true, false)),
	GET_SPIKES_PETRIFIED_MUSHROOM(Role.ATTACKER, newBaseComparableEntry("get-spikes", "petrified mushroom", -1, -1, true, true)),
	TAKE_ATTACKER_ITEM_MACHINE(Role.ATTACKER, newBaseComparableEntry("take", "attacker item machine", -1, -1, false, true)),
	TELL_RED_ATTACKER_HORN(Role.ATTACKER, newBaseComparableEntry("tell-red", "attacker horn", -1, -1, true, true)),
	TELL_GREEN_ATTACKER_HORN(Role.ATTACKER, newBaseComparableEntry("tell-green", "attacker horn", -1, -1, true, true)),
	TELL_BLUE_ATTACKER_HORN(Role.ATTACKER, newBaseComparableEntry("tell-blue", "attacker horn", -1, -1, true, true)),

	BLOCK_PENANCE_CAVE(Role.DEFENDER, newBaseComparableEntry("block", "penance cave", -1, -1, true, true)),
	DUNK_LAVA_CRATER(Role.DEFENDER, newBaseComparableEntry("dunk", "lava crater", -1, -1, true, true)),
	FIX(Role.DEFENDER, newBaseComparableEntry("fix", "", -1, -1, true, false)),
	STOCK_UP_DEFENDER_ITEM_MACHINE(Role.DEFENDER, newBaseComparableEntry("stock-up", "defender item machine", -1, -1, true, true)),
	TAKE_DEFENDER_ITEM_MACHINE(Role.DEFENDER, newBaseComparableEntry("take", "defender item machine", -1, -1, false, true)),
	TAKE_HAMMER(Role.DEFENDER, newBaseComparableEntry("take", "hammer", -1, -1, true, true)),
	TAKE_LOGS(Role.DEFENDER, newBaseComparableEntry("take", "logs", -1, -1, true, true)),
	TELL_WORMS_DEFENDER_HORN(Role.DEFENDER, newBaseComparableEntry("tell-worms", "defender horn", -1, -1, true, true)),
	TELL_TOFU_DEFENDER_HORN(Role.DEFENDER, newBaseComparableEntry("tell-tofu", "defender horn", -1, -1, true, true)),
	TELL_MEAT_DEFENDER_HORN(Role.DEFENDER, newBaseComparableEntry("tell-meat", "defender horn", -1, -1, true, true)),

	DRINK_FROM_HEALER_SPRING(Role.HEALER, newBaseComparableEntry("drink-from", "healer spring", -1, -1, true, true)),
	DUNK_POISON_CRATER(Role.HEALER, newBaseComparableEntry("dunk", "poison crater", -1, -1, true, true)),
	STOCK_UP_HEALER_ITEM_MACHINE(Role.HEALER, newBaseComparableEntry("stock-up", "healer item machine", -1, -1, true, true)),
	TAKE_HEALER_ITEM_MACHINE(Role.HEALER, newBaseComparableEntry("take", "healer item machine", -1, -1, false, true)),
	TAKE_FROM_HEALER_SPRING(Role.HEALER, newBaseComparableEntry("take-from", "healer spring", -1, -1, true, true)),
	TELL_TOFU_HEALER_HORN(Role.HEALER, newBaseComparableEntry("tell-tofu", "healer horn", -1, -1, true, true)),
	TELL_CRACKERS_HEALER_HORN(Role.HEALER, newBaseComparableEntry("tell-crackers", "healer horn", -1, -1, true, true)),
	TELL_WORMS_HEALER_HORN(Role.HEALER, newBaseComparableEntry("tell-worms", "healer horn", -1, -1, true, true)),
	USE_VIAL_GROUND(Role.HEALER, newBaseComparableEntry("use", "healing vial", -1, MenuOpcode.ITEM_USE_ON_GROUND_ITEM.getId(), true, false)),
	USE_VIAL_ITEM(Role.HEALER, newBaseComparableEntry("use", "healing vial", -1, MenuOpcode.ITEM_USE_ON_WIDGET_ITEM.getId(), true, false)),
	USE_VIAL_NPC(Role.HEALER, newBaseComparableEntry("use", "healing vial", -1, MenuOpcode.ITEM_USE_ON_NPC.getId(), true, false)),
	USE_VIAL_WIDGET(Role.HEALER, newBaseComparableEntry("use", "healing vial", -1, MenuOpcode.ITEM_USE_ON_WIDGET.getId(), true, false)),

	CONVERT_COLLECTOR_CONVERTER(Role.COLLECTOR, newBaseComparableEntry("convert", "collector converter", -1, -1, true, true)),
	LOAD_EGG_HOPPER(Role.COLLECTOR, newBaseComparableEntry("load", "egg hopper", -1, -1, true, true)),
	TAKE_BLUE_EGG(Role.COLLECTOR, newBaseComparableEntry("take", "blue egg", -1, -1, true, true)),
	TAKE_GREEN_EGG(Role.COLLECTOR, newBaseComparableEntry("take", "green egg", -1, -1, true, true)),
	TAKE_RED_EGG(Role.COLLECTOR, newBaseComparableEntry("take", "red egg", -1, -1, true, true)),
	TAKE_YELLOW_EGG(Role.COLLECTOR, newBaseComparableEntry("take", "yellow egg", -1, -1, true, true)),
	TELL_CONTROLLED_COLLECTOR_HORN(Role.COLLECTOR, newBaseComparableEntry("tell-controlled", "collector horn", -1, -1, true, true)),
	TELL_ACCURATE_COLLECTOR_HORN(Role.COLLECTOR, newBaseComparableEntry("tell-accurate", "collector horn", -1, -1, true, true)),
	TELL_AGGRESSIVE_COLLECTOR_HORN(Role.COLLECTOR, newBaseComparableEntry("tell-aggressive", "collector horn", -1, -1, true, true)),
	TELL_DEFENSIVE_COLLECTOR_HORN(Role.COLLECTOR, newBaseComparableEntry("tell-defensive", "collector horn", -1, -1, true, true)),

	ATTACK_PENANCE_QUEEN(null, newBaseComparableEntry("attack", "penance queen", -1, -1, true, false)),
	ATTACK_QUEEN_SPAWN(null, newBaseComparableEntry("attack", "queen spawn", -1, -1, true, false)),
	DROP_HORN(null, newBaseComparableEntry("drop", "r horn", -1, -1, true, false)),
	EXAMINE_HORN(null, newBaseComparableEntry("examine", "r horn", -1, -1, true, false)),
	LIGHT_LOGS(null, newBaseComparableEntry("light", "logs", -1, -1, true, true)),
	MEDIC_HORN(null, newBaseComparableEntry("medic", "r horn", -1, -1, true, false)),
	USE_HORN(null, newBaseComparableEntry("use", "r horn", -1, -1, true, false));

	@Getter(AccessLevel.PACKAGE)
	private final Role role;

	@Getter(AccessLevel.PACKAGE)
	private final BaseComparableEntry entry;

	private static final ImmutableSet<Menus> ALL = ImmutableSet.copyOf(Menus.values());

	public String getOption()
	{
		return entry.getOption();
	}

	public String getTarget()
	{
		return entry.getTarget();
	}

	public int getId()
	{
		return entry.getId();
	}

	public int getType()
	{
		return entry.getType();
	}

	public boolean isStrictOption()
	{
		return entry.isStrictOption();
	}

	public boolean isStrictTarget()
	{
		return entry.isStrictTarget();
	}

	public static ImmutableSet<Menus> getMenus()
	{
		return ALL;
	}
}
