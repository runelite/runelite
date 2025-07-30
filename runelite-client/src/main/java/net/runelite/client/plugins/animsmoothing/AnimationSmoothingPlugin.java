/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.animsmoothing;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.gameval.AnimationID;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Animation Smoothing",
	description = "Show smoother player, NPC, and object animations",
	tags = {"npcs", "objects", "players"},
	enabledByDefault = false
)
public class AnimationSmoothingPlugin extends Plugin
{
	@Inject
	private Client client;

	@Override
	protected void startUp() throws Exception
	{
		update();
	}

	@Override
	protected void shutDown() throws Exception
	{
		client.setAnimationInterpolationFilter(null);
	}

	private void update()
	{
		client.setAnimationInterpolationFilter(AnimationSmoothingPlugin::isAnimationInterpolatable);
	}

	private static boolean isAnimationInterpolatable(int animId)
	{
		switch (animId)
		{
			case AnimationID.DOG_UPDATE_JACKAL_DEFEND:

			case AnimationID.WYRM_WALK:
			case AnimationID.WYRM_READY:
			case AnimationID.WYRM_ATTACK_MELEE:
			case AnimationID.WYRM_ATTACK_MAGIC:

			case AnimationID.GIANT_UPDATE_BASIC_ATTACK:

			case AnimationID.GHOST_UPDATE_NORMAL_READY:
			case AnimationID.GHOST_UPDATE_NORMAL_WALK:

			case AnimationID.ZOMBIE_UPDATE_SIGN_WALK:

			case AnimationID.DUCK_REWORK_UNDERWATER_READY_AND_EXTRA:

			case AnimationID.WILD_CAVE_CHAINMACE_READY:

			case AnimationID.ELEMENTAL_WHEEL_SPIN:
			case AnimationID.BRAIN_MILL_SAIL_ROTATE:
			case AnimationID.FAI_VARROCK_MILLSAIL:
			case AnimationID.DS2_LITHKREN_GENERATOR_WHEEL:
			case AnimationID.WATERWHEEL_CHUTE:

			case AnimationID.HUMAN_SPELLCAST_DEMONBANE:

			case AnimationID.POH_NEXUS:

			case AnimationID.BURGH_BUCKET_DRIP:

			case AnimationID.KEYKEEPER:

			case AnimationID.TOA_SOT_CAST_B:

			case AnimationID.BASILISK_KNIGHT_MELEE:

			case AnimationID.WGS_HEROIC_CLIMB_SUCCESS_TWO:
				return false;

			default:
				return true;
		}
	}
}
