/*
 * Copyright (c) 2019, 7ate9 <https://github.com/se7enAte9>
 * Copyright (c) 2019, https://runelitepl.us
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.MenuAction;
import net.runelite.client.menus.ComparableEntry;

@AllArgsConstructor
public enum Menus
{
	ATTACK_PENANCE_FIGHTER(Role.ATTACKER, new ComparableEntry("attack", "penance fighter", -1, -1, true, false)),
	ATTACK_PENANCE_RANGER(Role.ATTACKER, new ComparableEntry("attack", "penance ranger", -1, -1, true, false)),
	GET_SPIKES_PETRIFIED_MUSHROOM(Role.ATTACKER, new ComparableEntry("get-spikes", "petrified mushroom", -1, -1, true, true)),
	TAKE_ATTACKER_ITEM_MACHINE(Role.ATTACKER, new ComparableEntry("take", "attacker item machine", -1, -1, false, true)),
	TELL_RED_ATTACKER_HORN(Role.ATTACKER, new ComparableEntry("tell-red", "attacker horn", -1, -1, true, true)),
	TELL_GREEN_ATTACKER_HORN(Role.ATTACKER, new ComparableEntry("tell-green", "attacker horn", -1, -1, true, true)),
	TELL_BLUE_ATTACKER_HORN(Role.ATTACKER, new ComparableEntry("tell-blue", "attacker horn", -1, -1, true, true)),

	BLOCK_PENANCE_CAVE(Role.DEFENDER, new ComparableEntry("block", "penance cave", -1, -1, true, true)),
	DUNK_LAVA_CRATER(Role.DEFENDER, new ComparableEntry("dunk", "lava crater", -1, -1, true, true)),
	FIX(Role.DEFENDER, new ComparableEntry("fix", "", -1, -1, true, false)),
	STOCK_UP_DEFENDER_ITEM_MACHINE(Role.DEFENDER, new ComparableEntry("stock-up", "defender item machine", -1, -1, true, true)),
	TAKE_DEFENDER_ITEM_MACHINE(Role.DEFENDER, new ComparableEntry("take", "defender item machine", -1, -1, false, true)),
	TAKE_HAMMER(Role.DEFENDER, new ComparableEntry("take", "hammer", -1, -1, true, true)),
	TAKE_LOGS(Role.DEFENDER, new ComparableEntry("take", "logs", -1, -1, true, true)),
	TELL_WORMS_DEFENDER_HORN(Role.DEFENDER, new ComparableEntry("tell-worms", "defender horn", -1, -1, true, true)),
	TELL_TOFU_DEFENDER_HORN(Role.DEFENDER, new ComparableEntry("tell-tofu", "defender horn", -1, -1, true, true)),
	TELL_MEAT_DEFENDER_HORN(Role.DEFENDER, new ComparableEntry("tell-meat", "defender horn", -1, -1, true, true)),

	DRINK_FROM_HEALER_SPRING(Role.HEALER, new ComparableEntry("drink-from", "healer spring", -1, -1, true, true)),
	DUNK_POISON_CRATER(Role.HEALER, new ComparableEntry("dunk", "poison crater", -1, -1, true, true)),
	STOCK_UP_HEALER_ITEM_MACHINE(Role.HEALER, new ComparableEntry("stock-up", "healer item machine", -1, -1, true, true)),
	TAKE_HEALER_ITEM_MACHINE(Role.HEALER, new ComparableEntry("take", "healer item machine", -1, -1, false, true)),
	TAKE_FROM_HEALER_SPRING(Role.HEALER, new ComparableEntry("take-from", "healer spring", -1, -1, true, true)),
	TELL_TOFU_HEALER_HORN(Role.HEALER, new ComparableEntry("tell-tofu", "healer horn", -1, -1, true, true)),
	TELL_CRACKERS_HEALER_HORN(Role.HEALER, new ComparableEntry("tell-crackers", "healer horn", -1, -1, true, true)),
	TELL_WORMS_HEALER_HORN(Role.HEALER, new ComparableEntry("tell-worms", "healer horn", -1, -1, true, true)),
	USE_VIAL_GROUND(Role.HEALER, new ComparableEntry("use", "healing vial", -1, MenuAction.ITEM_USE_ON_GROUND_ITEM.getId(), true, false)),
	USE_VIAL_ITEM(Role.HEALER, new ComparableEntry("use", "healing vial", -1, MenuAction.ITEM_USE_ON_WIDGET_ITEM.getId(), true, false)),
	USE_VIAL_NPC(Role.HEALER, new ComparableEntry("use", "healing vial", -1, MenuAction.ITEM_USE_ON_NPC.getId(), true, false)),
	USE_VIAL_WIDGET(Role.HEALER, new ComparableEntry("use", "healing vial", -1, MenuAction.ITEM_USE_ON_WIDGET.getId(), true, false)),

	CONVERT_COLLECTOR_CONVERTER(Role.COLLECTOR, new ComparableEntry("convert", "collector converter", -1, -1, true, true)),
	LOAD_EGG_HOPPER(Role.COLLECTOR, new ComparableEntry("load", "egg hopper", -1, -1, true, true)),
	TAKE_BLUE_EGG(Role.COLLECTOR, new ComparableEntry("take", "blue egg", -1, -1, true, true)),
	TAKE_GREEN_EGG(Role.COLLECTOR, new ComparableEntry("take", "green egg", -1, -1, true, true)),
	TAKE_RED_EGG(Role.COLLECTOR, new ComparableEntry("take", "red egg", -1, -1, true, true)),
	TAKE_YELLOW_EGG(Role.COLLECTOR, new ComparableEntry("take", "yellow egg", -1, -1, true, true)),
	TELL_CONTROLLED_COLLECTOR_HORN(Role.COLLECTOR, new ComparableEntry("tell-controlled", "collector horn", -1, -1, true, true)),
	TELL_ACCURATE_COLLECTOR_HORN(Role.COLLECTOR, new ComparableEntry("tell-accurate", "collector horn", -1, -1, true, true)),
	TELL_AGGRESSIVE_COLLECTOR_HORN(Role.COLLECTOR, new ComparableEntry("tell-aggressive", "collector horn", -1, -1, true, true)),
	TELL_DEFENSIVE_COLLECTOR_HORN(Role.COLLECTOR, new ComparableEntry("tell-defensive", "collector horn", -1, -1, true, true)),

	ATTACK_PENANCE_QUEEN(null, new ComparableEntry("attack", "penance queen", -1, -1, true, false)),
	ATTACK_QUEEN_SPAWN(null, new ComparableEntry("attack", "queen spawn", -1, -1, true, false)),
	DROP_HORN(null, new ComparableEntry("drop", "r horn", -1, -1, true, false)),
	EXAMINE_HORN(null, new ComparableEntry("examine", "r horn", -1, -1, true, false)),
	LIGHT_LOGS(null, new ComparableEntry("light", "logs", -1, -1, true, true)),
	MEDIC_HORN(null, new ComparableEntry("medic", "r horn", -1, -1, true, false)),
	USE_HORN(null, new ComparableEntry("use", "r horn", -1, -1, true, false));

	@Getter
	private final Role role;

	@Getter
	private final ComparableEntry entry;

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
