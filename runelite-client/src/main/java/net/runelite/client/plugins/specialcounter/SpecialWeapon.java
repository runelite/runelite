/*
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
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
package net.runelite.client.plugins.specialcounter;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;

@AllArgsConstructor
@Getter
public enum SpecialWeapon
{
	DRAGON_WARHAMMER("Dragon Warhammer", new int[]{ItemID.DRAGON_WARHAMMER, ItemID.BH_DRAGON_WARHAMMER_CORRUPTED}, false, SpecialCounterConfig::dragonWarhammerThreshold)
		{
			@Override
			public float computeDrainPercent(int hit, @Nullable NPC target)
			{
				if (hit > 0)
				{
					return 0.7f;
				}
				else if (target != null && TEKTON_VARIANTS.contains(target.getId()))
				{
					return 0.95f;
				}
				return 0;
			}
		},
	ARCLIGHT("Arclight", new int[]{ItemID.ARCLIGHT}, false, SpecialCounterConfig::arclightThreshold),
	DARKLIGHT("Darklight", new int[]{ItemID.DARKLIGHT}, false, SpecialCounterConfig::darklightThreshold),
	BANDOS_GODSWORD("Bandos Godsword", new int[]{ItemID.BGS, ItemID.BGSG}, true, SpecialCounterConfig::bandosGodswordThreshold)
		{
			@Override
			public int computeHit(int hit, @Nullable NPC target)
			{
				if (hit == 0 && target != null && TEKTON_VARIANTS.contains(target.getId()))
				{
					return 10;
				}
				return super.computeHit(hit, target);
			}
		},
	BARRELCHEST_ANCHOR("Barrelchest Anchor", new int[]{ItemID.BRAIN_ANCHOR}, true, (c) -> 0),
	BONE_DAGGER("Bone Dagger", new int[]{ItemID.DTTD_BONE_DAGGER, ItemID.DTTD_BONE_DAGGER_P, ItemID.DTTD_BONE_DAGGER_P_, ItemID.DTTD_BONE_DAGGER_P__}, true, (c) -> 0),
	DORGESHUUN_CROSSBOW(
		"Dorgeshuun Crossbow",
		new int[]{ItemID.DTTD_BONE_CROSSBOW},
		true,
		(distance) -> 60 + distance * 3,
		(c) -> 0
	),
	BULWARK("Dinh's Bulwark", new int[]{ItemID.DINHS_BULWARK}, false, SpecialCounterConfig::bulwarkThreshold),
	ACCURSED_SCEPTRE(
		"Accursed Sceptre",
		new int[]{ItemID.WILD_CAVE_ACCURSED_CHARGED, ItemID.WILD_CAVE_ACCURSED_CHARGED_RECOL},
		false,
		(distance) -> 46 + distance * 10,
		(c) -> 0
	),
	TONALZTICS_OF_RALOS(
		"Tonalztics of Ralos",
		new int[]{ItemID.TONALZTICS_OF_RALOS_CHARGED},
		true, // Not really, but we convert the number of hits into a single hit
		(distance) -> 50, //The hitsplat is always applied 2t after spec regardless of distance
		(c) -> 0
	),
	ELDER_MAUL("Elder Maul",
		new int[]{ItemID.ELDER_MAUL, ItemID.ELDER_MAUL_ORNAMENT},
		false,
		(distance) -> 50, //The hitsplat is applied 2t after spec unlike most melee weapons
		SpecialCounterConfig::elderMaulThreshold)
		{
			@Override
			public float computeDrainPercent(int hit, @Nullable NPC target)
			{
				if (hit > 0)
				{
					return 0.65f;
				}
				else if (target != null && TEKTON_VARIANTS.contains(target.getId()))
				{
					return 0.95f;
				}
				return 0;
			}
		},
	SEERCULL("Seercull", new int[]{ItemID.DAGANOTH_CAVE_MAGIC_SHORTBOW}, true, (d) -> 46 + (d * 5), (c) -> 0),
	EMBERLIGHT("Emberlight", new int[]{ItemID.EMBERLIGHT}, false, SpecialCounterConfig::emberlightThreshold);

	private static final Set<Integer> TEKTON_VARIANTS = ImmutableSet.of(
		NpcID.RAIDS_TEKTON_WAITING,
		NpcID.RAIDS_TEKTON_WALKING_STANDARD,
		NpcID.RAIDS_TEKTON_FIGHTING_STANDARD,
		NpcID.RAIDS_TEKTON_HAMMERING,
		NpcID.RAIDS_TEKTON_WALKING_ENRAGED,
		NpcID.RAIDS_TEKTON_FIGHTING_ENRAGED
	);

	private final String name;
	private final int[] itemID;
	private final boolean damage;
	/**
	 * Accepts an int representing distance in tiles to the target, and returns an int representing client cycles of
	 * delay until the hitsplat is applied.
	 * <p>
	 * For melee weapons, the returned value is always {@code 0}, as they have no delay. Calculating this delay can be
	 * done by extrapolating the difference between the cycle the projectile is created and the cycle it ends for
	 * various distances. In practice, projectiles are created at the same time special attack energy is drained for
	 * special attacks, so the difference can be taken between the cycle a player's special attack drains and the end
	 * cycle of the created projectile.
	 * <p>
	 * For example, a dorgeshuun crossbow will have its projectile end 63 cycles after a spec at distance 1, 66 at
	 * distance 2, etc. Hence, we can extrapolate its formula to be {@code int cycles = 60 + distance * 3}.
	 */
	private final Function<Integer, Integer> clientCycleHitDelay;
	private final Function<SpecialCounterConfig, Integer> threshold;

	SpecialWeapon(final String name, final int[] itemID, final boolean damage, final Function<SpecialCounterConfig, Integer> threshold)
	{
		this(name, itemID, damage, (distance) -> 0, threshold);
	}

	/**
	 * Gets the server cycle delay between special attack energy dropping and a hitsplat being applied to the target.
	 * This will be {@code 1} for all melee weapons.
	 *
	 * @param distance Distance from the target in tiles
	 * @return Number of server cycles (game ticks) delay for the special attack hitsplat to be applied
	 */
	public int getHitDelay(final int distance)
	{
		// Convert the client cycles of delay to server cycles delay. The server performs no rounding, so this is
		// simply (cycles / 30).
		final int serverCyclesDelay = getClientCycleHitDelay().apply(distance) / 30;

		// All attacks have one server cycle of additional delay beyond any projectile travel time for the weapon.
		return serverCyclesDelay + 1;
	}

	public float computeDrainPercent(int hit, @Nullable NPC target)
	{
		return 0f;
	}

	public int computeHit(int hit, @Nullable NPC target)
	{
		return hit;
	}
}
