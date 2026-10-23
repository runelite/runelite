/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import java.util.EnumSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;

@AllArgsConstructor
@Getter
public enum SailingAction implements NamedSkillAction
{
	SMALL_SHIPWRECK_SORTING("Small Salvage (Sorting)", 15, 5.5f, ItemID.SAILING_SMALL_SHIPWRECK_SALVAGE, SailingMethod.SORTING),
	SMALL_SHIPWRECK_SALVAGE("Small Salvage (Salvaging)", 15, 10, ItemID.SAILING_SMALL_SHIPWRECK_SALVAGE, SailingMethod.SALVAGING),
	FISHY_SHIPWRECK_SORTING("Fishy Salvage (Sorting)", 26, 9, ItemID.SAILING_FISHERMAN_SHIPWRECK_SALVAGE, SailingMethod.SORTING),
	FISHY_SHIPWRECK_SALVAGE("Fishy Salvage (Salvaging)", 26, 17, ItemID.SAILING_FISHERMAN_SHIPWRECK_SALVAGE, SailingMethod.SALVAGING),
	TEMPEST_TRIAL_UNRANKED("Unranked Tempor Trial", 30, 300, ItemID.RALPHS_FABRIC_ROLL, SailingMethod.BARRACUDA_TRIALS),
	TEMPEST_TRIAL_SWORDFISH("Swordfish Tempor Trial", 30, 595, ItemID.STORMY_KEY, SailingMethod.BARRACUDA_TRIALS),
	TEMPEST_TRIAL_SHARK("Shark Tempor Trial", 30, 1025, ItemID.WHIRLPOOL_SURPRISE, SailingMethod.BARRACUDA_TRIALS),
	TEMPEST_TRIAL_MARLIN("Marlin Tempor Trial", 30, 1790, ItemID.RALPHS_FABRIC_ROLL, SailingMethod.BARRACUDA_TRIALS),
	BULL_SHARK_BOUNTY_TASK("Bull Shark Bounty Task", 30, 3465, ItemID.SAILING_BULL_SHARK_JAW, SailingMethod.BOUNTY_TASKS),
	EAGLE_RAY_BOUNTY_TASK("Eagle Ray Bounty Task", 30, 3465, ItemID.SAILING_EAGLE_RAY_SKIN, SailingMethod.BOUNTY_TASKS),
	MOGRE_BOUNTY_TASK("Mogre Bounty Task", 30, 3465, ItemID.SAILING_SEA_MOGRE_HEAD, SailingMethod.BOUNTY_TASKS),
	OSPREY_BOUNTY_TASK("Osprey Bounty Task", 30, 3465, ItemID.SAILING_OSPREY_FEATHER, SailingMethod.BOUNTY_TASKS),
	TERN_BOUNTY_TASK("Tern Bounty Task", 30, 3465, ItemID.SAILING_TERN_FEATHER, SailingMethod.BOUNTY_TASKS),
	BARRACUDA_SHIPWRECK_SORTING("Barracuda Salvage (Sorting)", 35, 15.5f, ItemID.SAILING_BARRACUDA_SHIPWRECK_SALVAGE, SailingMethod.SORTING),
	BARRACUDA_SHIPWRECK_SALVAGE("Barracuda Salvage (Salvaging)", 35, 31, ItemID.SAILING_BARRACUDA_SHIPWRECK_SALVAGE, SailingMethod.SALVAGING),
	BUTTERFLY_RAY_BOUNTY_TASK("Butterfly Ray Bounty Task", 40, 8800, ItemID.SAILING_BUTTERFLY_RAY_SKIN, SailingMethod.BOUNTY_TASKS),
	HAMMERHEAD_SHARK_BOUNTY_TASK("Hammerhead Shark Bounty Task", 40, 8800, ItemID.SAILING_HAMMERHEAD_SHARK_JAW, SailingMethod.BOUNTY_TASKS),
	FRIGATEBIRD_BOUNTY_TASK("Frigatebird Bounty Task", 45, 11825, ItemID.SAILING_FRIGATEBIRD_FEATHER, SailingMethod.BOUNTY_TASKS),
	STINGRAY_BOUNTY_TASK("Stingray Bounty Task", 45, 11825, ItemID.SAILING_STINGRAY_SKIN, SailingMethod.BOUNTY_TASKS),
	ALBATROSS_BOUNTY_TASK("Albatross Bounty Task", 50, 14575, ItemID.SAILING_ALBATROSS_FEATHER, SailingMethod.BOUNTY_TASKS),
	PYGMY_KRAKEN_BOUNTY_TASK("Pygmy Kraken Bounty Task", 50, 14575, ItemID.SAILING_PYGMY_KRAKEN_TENTACLE, SailingMethod.BOUNTY_TASKS),
	LARGE_SHIPWRECK_SORTING("Large Salvage (Sorting)", 53, 24, ItemID.SAILING_LARGE_SHIPWRECK_SALVAGE, SailingMethod.SORTING),
	LARGE_SHIPWRECK_SALVAGE("Large Salvage (Salvaging)", 53, 48, ItemID.SAILING_LARGE_SHIPWRECK_SALVAGE, SailingMethod.SALVAGING),
	JIVE_TRIAL_UNRANKED("Unranked Jubbly Jive Trial", 55, 1592, ItemID.GURTOBS_FABRIC_ROLL, SailingMethod.BARRACUDA_TRIALS),
	JIVE_TRIAL_SWORDFISH("Swordfish Jubbly Jive Trial", 55, 2392, ItemID.FETID_KEY, SailingMethod.BARRACUDA_TRIALS),
	JIVE_TRIAL_SHARK("Shark Jubbly Jive Trial", 55, 4270, ItemID.CAPTURED_WIND_MOTE, SailingMethod.BARRACUDA_TRIALS),
	JIVE_TRIAL_MARLIN("Marlin Jubbly Jive Trial", 55, 8204, ItemID.GURTOBS_FABRIC_ROLL, SailingMethod.BARRACUDA_TRIALS),
	TIGER_SHARK_BOUNTY_TASK("Tiger Shark Bounty Task", 55, 19910, ItemID.SAILING_TIGER_SHARK_JAW, SailingMethod.BOUNTY_TASKS),
	MANTA_RAY_BOUNTY_TASK("Manta Ray Bounty Task", 60, 25135, ItemID.SAILING_MANTA_RAY_SKIN, SailingMethod.BOUNTY_TASKS),
	NARWHAL_BOUNTY_TASK("Narwhal Bounty Task", 62, 19910, ItemID.SAILING_NARWHAL_BLUBBER, SailingMethod.BOUNTY_TASKS),
	PLUNDERED_SHIPWRECK_SORTING("Plundered Salvage (Sorting)", 64, 31.5f, ItemID.SAILING_PIRATE_SHIPWRECK_SALVAGE, SailingMethod.SORTING),
	PLUNDERED_SHIPWRECK_SALVAGE("Plundered Salvage (Salvaging)", 64, 76, ItemID.SAILING_PIRATE_SHIPWRECK_SALVAGE, SailingMethod.SALVAGING),
	SPINED_KRAKEN_BOUNTY_TASK("Spined Kraken Bounty Task", 65, 30965, ItemID.SAILING_SPINED_KRAKEN_TENTACLE, SailingMethod.BOUNTY_TASKS),
	GLIDE_TRIAL_UNRANKED("Unranked Gwenith Glide Trial", 72, 3100, ItemID.GWYNAS_FABRIC_ROLL, SailingMethod.BARRACUDA_TRIALS),
	GLIDE_TRIAL_SWORDFISH("Swordfish Gwenith Glide Trial", 72, 4100, ItemID.SERRATED_KEY, SailingMethod.BARRACUDA_TRIALS),
	GLIDE_TRIAL_SHARK("Shark Gwenith Glide Trial", 72, 9315, ItemID.HEART_OF_ITHELL, SailingMethod.BARRACUDA_TRIALS),
	GLIDE_TRIAL_MARLIN("Marlin Gwenith Glide Trial", 72, 19410, ItemID.GWYNAS_FABRIC_ROLL, SailingMethod.BARRACUDA_TRIALS),
	MARTIAL_SHIPWRECK_SORTING("Martial Salvage (Sorting)", 73, 63.5f, ItemID.SAILING_MERCENARY_SHIPWRECK_SALVAGE, SailingMethod.SORTING),
	MARTIAL_SHIPWRECK_SALVAGE("Martial Salvage (Salvaging)", 73, 138, ItemID.SAILING_MERCENARY_SHIPWRECK_SALVAGE, SailingMethod.SALVAGING),
	ARMOURED_KRAKEN_BOUNTY_TASK("Armoured Kraken Bounty Task", 75, 40370, ItemID.SAILING_ARMOURED_KRAKEN_TENTACLE, SailingMethod.BOUNTY_TASKS),
	GREAT_WHITE_SHARK_BOUNTY_TASK("Great White Shark Bounty Task", 75, 40370, ItemID.SAILING_GREAT_WHITE_SHARK_JAW, SailingMethod.BOUNTY_TASKS),
	FREMENNIK_SHIPWRECK_SORTING("Fremennik Salvage (Sorting)", 80, 75, ItemID.SAILING_FREMENNIK_SHIPWRECK_SALVAGE, SailingMethod.SORTING),
	FREMENNIK_SHIPWRECK_SALVAGE("Fremennik Salvage (Salvaging)", 80, 162, ItemID.SAILING_FREMENNIK_SHIPWRECK_SALVAGE, SailingMethod.SALVAGING),
	ORCA_BOUNTY_TASK("Orca Bounty Task", 80, 47080, ItemID.SAILING_ORCA_BLUBBER, SailingMethod.BOUNTY_TASKS),
	VAMPYRE_KRAKEN_BOUNTY_TASK("Vampyre Kraken Bounty Task", 80, 47080, ItemID.SAILING_VAMPYRE_KRAKEN_TENTACLE, SailingMethod.BOUNTY_TASKS),
	VEILED_KRAKEN_BOUNTY_TASK("Veiled Kraken Bounty Task", 80, 47080, ItemID.SAILING_VEILED_KRAKEN_TENTACLE, SailingMethod.BOUNTY_TASKS),
	OPULENT_SHIPWRECK_SORTING("Opulent Salvage (Sorting)", 87, 95, ItemID.SAILING_MERCHANT_SHIPWRECK_SALVAGE, SailingMethod.SORTING),
	OPULENT_SHIPWRECK_SALVAGE("Opulent Salvage (Salvaging)", 87, 200, ItemID.SAILING_MERCHANT_SHIPWRECK_SALVAGE, SailingMethod.SALVAGING),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;
	private final SailingMethod sailingMethod;


	@Override
	public boolean isMembers(final ItemManager itemManager)
	{
		return true;
	}

	private enum SailingMethod
	{
		SALVAGING,
		SORTING,
		BARRACUDA_TRIALS,
		BOUNTY_TASKS,
	}

	@Override
	public Set<SailingBonus> getExcludedSkillBonuses()
	{
		switch (getSailingMethod())
		{
			case SALVAGING:
				return EnumSet.noneOf(SailingBonus.class);
			default:
				return EnumSet.of(
					SailingBonus.CREW_DECKHANDINESS_3,
					SailingBonus.CREW_DECKHANDINESS_4
				);
		}
	}
}
