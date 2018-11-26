/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.mixins;

import net.runelite.api.AnimationID;
import net.runelite.api.NPCComposition;
import net.runelite.api.NpcID;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSNPCComposition;

@Mixin(RSNPC.class)
public abstract class RSNPCMixin implements RSNPC
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	private int npcIndex;

	@Inject
	private boolean dead;

	//NOTE:: Unsure of correct Ids for kraken, snakeling and smoke devil pets, so have left commented out for now.
	private int[] petIds = {
			NpcID.ABYSSAL_ORPHAN,
			NpcID.ABYSSAL_ORPHAN_5884,
			NpcID.BABY_MOLE,
			NpcID.BABY_MOLE_5781,
			NpcID.BABY_MOLE_5782,
			NpcID.BABY_MOLE_6635,
			NpcID.BABY_MOLE_6651,
			NpcID.CALLISTO_CUB,
			NpcID.CALLISTO_CUB_5558,
			NpcID.HELLPUPPY,
			NpcID.HELLPUPPY_3099,
			NpcID.JALNIBREK,
			NpcID.JALNIBREK_7675,
			NpcID.TZREKZUK,
			NpcID.TZREKZUK_8011,
			NpcID.KALPHITE_PRINCESS,
			NpcID.KALPHITE_PRINCESS_6638,
			NpcID.KALPHITE_PRINCESS_6653,
			NpcID.KALPHITE_PRINCESS_6654,
			NpcID.LIL_ZIK,
			NpcID.LIL_ZIK_8337,
			NpcID.NOON,
			NpcID.NOON_7892,
			NpcID.MIDNIGHT,
			NpcID.MIDNIGHT_7893,
			NpcID.OLMLET,
			NpcID.OLMLET_7520,
			NpcID.CHAOS_ELEMENTAL_JR,
			NpcID.CHAOS_ELEMENTAL_JR_5907,
			NpcID.DAGANNOTH_PRIME_JR,
			NpcID.DAGANNOTH_PRIME_JR_6629,
			NpcID.DAGANNOTH_REX_JR,
			NpcID.DAGANNOTH_REX_JR_6641,
			NpcID.DAGANNOTH_SUPREME_JR,
			NpcID.DAGANNOTH_SUPREME_JR_6628,
			NpcID.DARK_CORE,
			NpcID.DARK_CORE_388,
			NpcID.CORPOREAL_CRITTER,
			NpcID.CORPOREAL_CRITTER_8010,
			NpcID.GENERAL_GRAARDOR_JR,
			NpcID.GENERAL_GRAARDOR_JR_6644,
			NpcID.KRIL_TSUTSAROTH_JR,
			NpcID.KRIL_TSUTSAROTH_JR_6647,
//			NpcID.KRAKEN,
			NpcID.KREEARRA_JR,
			NpcID.KREEARRA_JR_6643,
//			NpcID.THERMONUCLEAR_SMOKE_DEVIL,
//			NpcID.SNAKELING,
			NpcID.ZILYANA_JR,
			NpcID.ZILYANA_JR_6646,
			NpcID.PRINCE_BLACK_DRAGON,
			NpcID.PRINCE_BLACK_DRAGON_6652,
			NpcID.SCORPIAS_OFFSPRING,
			NpcID.SCORPIAS_OFFSPRING_5561,
			NpcID.SCORPIAS_OFFSPRING_6616,
			NpcID.SKOTOS,
			NpcID.SKOTOS_7671,
			NpcID.TZREKJAD,
			NpcID.TZREKJAD_5893,
			NpcID.VENENATIS_SPIDERLING,
			NpcID.VENENATIS_SPIDERLING_5557,
			NpcID.VETION_JR,
			NpcID.VETION_JR_5537,
			NpcID.VETION_JR_5559,
			NpcID.VETION_JR_5560,
			NpcID.VORKI,
			NpcID.VORKI_8029
	};

	@Inject
	@Override
	public int getId()
	{
		RSNPCComposition composition = getComposition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition == null ? -1 : composition.getId();
	}

	@Inject
	@Override
	public String getName()
	{
		RSNPCComposition composition = getComposition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition == null ? null : composition.getName().replace('\u00A0', ' ');
	}

	@Inject
	@Override
	public int getCombatLevel()
	{
		RSNPCComposition composition = getComposition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition == null ? -1 : composition.getCombatLevel();
	}

	@Inject
	@Override
	public int getIndex()
	{
		return npcIndex;
	}

	@Inject
	@Override
	public void setIndex(int id)
	{
		npcIndex = id;
	}

	@FieldHook(value = "composition", before = true)
	@Inject
	public void onCompositionChanged(RSNPCComposition composition)
	{
		if (composition == null)
		{
			client.getCallbacks().post(new NpcDespawned(this));
		}
	}

	@Copy("getModel")
	public abstract RSModel rs$getModel();

	@Replace("getModel")
	public RSModel rl$getModel()
	{
		if (!client.isInterpolateNpcAnimations()
			|| getAnimation() == AnimationID.HELLHOUND_DEFENCE)
		{
			return rs$getModel();
		}
		int actionFrame = getActionFrame();
		int poseFrame = getPoseFrame();
		int spotAnimFrame = getSpotAnimFrame();
		try
		{
			// combine the frames with the frame cycle so we can access this information in the sequence methods
			// without having to change method calls
			setActionFrame(Integer.MIN_VALUE | getActionFrameCycle() << 16 | actionFrame);
			setPoseFrame(Integer.MIN_VALUE | getPoseFrameCycle() << 16 | poseFrame);
			setSpotAnimFrame(Integer.MIN_VALUE | getSpotAnimFrameCycle() << 16 | spotAnimFrame);
			return rs$getModel();
		}
		finally
		{
			// reset frames
			setActionFrame(actionFrame);
			setPoseFrame(poseFrame);
			setSpotAnimFrame(spotAnimFrame);
		}
	}

	@Inject
	@Override
	public NPCComposition getTransformedComposition()
	{
		RSNPCComposition composition = getComposition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition;
	}

	@Inject
	@Override
	public boolean isDead()
	{
		return dead;
	}

	@Inject
	@Override
	public void setDead(boolean dead)
	{
		this.dead = dead;
	}

	@Inject
	@Override
	public boolean isPet()
	{
		int id = this.getId();
		for (int petId : petIds)
		{
			if (id == petId)
			{
				return true;
			}
		}
		return false;
	}
}
