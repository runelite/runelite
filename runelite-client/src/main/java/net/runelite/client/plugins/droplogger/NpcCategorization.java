/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.droplogger;

import net.runelite.api.NpcID;

public class NpcCategorization
{
	public static boolean isNpcInBarbarianAssault(int npcId)
	{
		switch (npcId)
		{
			case NpcID.PENANCE_FIGHTER:
			case NpcID.PENANCE_FIGHTER_5739:
			case NpcID.PENANCE_FIGHTER_5740:
			case NpcID.PENANCE_FIGHTER_5741:
			case NpcID.PENANCE_FIGHTER_5742:
			case NpcID.PENANCE_FIGHTER_5743:
			case NpcID.PENANCE_FIGHTER_5744:
			case NpcID.PENANCE_FIGHTER_5745:
			case NpcID.PENANCE_FIGHTER_5746:
			case NpcID.PENANCE_FIGHTER_5747:
			case NpcID.PENANCE_RUNNER:
			case NpcID.PENANCE_RUNNER_5748:
			case NpcID.PENANCE_RUNNER_5749:
			case NpcID.PENANCE_RUNNER_5750:
			case NpcID.PENANCE_RUNNER_5751:
			case NpcID.PENANCE_RUNNER_5752:
			case NpcID.PENANCE_RUNNER_5753:
			case NpcID.PENANCE_RUNNER_5754:
			case NpcID.PENANCE_RUNNER_5755:
			case NpcID.PENANCE_RUNNER_5756:
			case NpcID.PENANCE_RANGER:
			case NpcID.PENANCE_RANGER_5757:
			case NpcID.PENANCE_RANGER_5758:
			case NpcID.PENANCE_RANGER_5759:
			case NpcID.PENANCE_RANGER_5760:
			case NpcID.PENANCE_RANGER_5761:
			case NpcID.PENANCE_RANGER_5762:
			case NpcID.PENANCE_RANGER_5763:
			case NpcID.PENANCE_RANGER_5764:
			case NpcID.PENANCE_RANGER_5765:
			case NpcID.PENANCE_HEALER:
			case NpcID.PENANCE_HEALER_5766:
			case NpcID.PENANCE_HEALER_5767:
			case NpcID.PENANCE_HEALER_5768:
			case NpcID.PENANCE_HEALER_5769:
			case NpcID.PENANCE_HEALER_5770:
			case NpcID.PENANCE_HEALER_5771:
			case NpcID.PENANCE_HEALER_5772:
			case NpcID.PENANCE_HEALER_5773:
			case NpcID.PENANCE_HEALER_5774:
				return true;
		}

		return false;
	}

	public static boolean isNpcInChambersOfXeric(int npcId)
	{
		switch (npcId)
		{
			case NpcID.TEKTON:
			case NpcID.TEKTON_7541:
			case NpcID.TEKTON_7542:
			case NpcID.TEKTON_7545:
			case NpcID.TEKTON_ENRAGED:
			case NpcID.TEKTON_ENRAGED_7544:
			case NpcID.VASA_NISTIRIO:
			case NpcID.VASA_NISTIRIO_7567:
			case NpcID.VESPULA:
			case NpcID.VESPULA_7531:
			case NpcID.VESPULA_7532:
			case NpcID.MUTTADILE:
			case NpcID.MUTTADILE_7562:
			case NpcID.MUTTADILE_7563:
			case NpcID.ICE_DEMON:
			case NpcID.ICE_DEMON_7585:
			case NpcID.DEATHLY_RANGER:
			case NpcID.DEATHLY_MAGE:
			case NpcID.VANGUARD:
			case NpcID.VANGUARD_7526:
			case NpcID.VANGUARD_7527:
			case NpcID.VANGUARD_7528:
			case NpcID.VANGUARD_7529:
			case NpcID.SCAVENGER_BEAST:
			case NpcID.SCAVENGER_BEAST_7549:
			case NpcID.SCAVENGER_RUNT:
			case NpcID.SCAVENGER_RUNT_7547:
			case NpcID.LIZARDMAN_SHAMAN_7573:
			case NpcID.LIZARDMAN_SHAMAN_7574:
			case NpcID.SPAWN_7575:
			case NpcID.SKELETAL_MYSTIC:
			case NpcID.SKELETAL_MYSTIC_7605:
			case NpcID.SKELETAL_MYSTIC_7606:
				return true;
		}

		return false;
	}
}