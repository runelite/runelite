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
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
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
			case AnimationID.HELLHOUND_DEFENCE:

			case AnimationID.WYRM_IDLE_DORMANT:
			case AnimationID.WYRM_IDLE_ACTIVE:
			case AnimationID.WYRM_ATTACK_MELEE:
			case AnimationID.WYRM_ATTACK_MAGE:

			case AnimationID.CYCLOPS_ATTACK:

			case AnimationID.TREE_SPIRIT_IDLE:
			case AnimationID.TREE_SPIRIT_WALK:

			case AnimationID.SIGN_HOLDING_ZOMBIE_PROTESTOR_WALK:

			case AnimationID.DUCK_BOBBING:

			case AnimationID.VIGGORAS_CHAINMACE_IDLE:

			case AnimationID.MLM_WATER_WHEEL_SPINNING:
			case AnimationID.HARMONY_ISLAND_WINDMILL_SPINNING:
			case AnimationID.GWENITH_WINDMILL_SPINNING:
			case AnimationID.LITHKREN_GENERATOR_SPINNING:
			case AnimationID.GIANTS_FOUNDRY_WATER_WHEEL_SPINNING:

			case AnimationID.MAGIC_ARCEUUS_DEMONBANE:

			case AnimationID.PORTAL_NEXUS_SPIN:

			case AnimationID.SLAYER_TOWER_WATER_BUCKET_DRIP:

			case AnimationID.KEY_MASTER_IDLE:
				return false;

			default:
				return true;
		}
	}
}
