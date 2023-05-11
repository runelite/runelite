/*
 * Copyright (c) 2022, Jordan Atwood <nightfirecat@nightfirec.at>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.game;

import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.NpcID;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.NpcChanged;
import net.runelite.client.RuntimeConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import org.apache.commons.lang3.ArrayUtils;

@Singleton
public class NpcUtil
{
	private final RuntimeConfig runtimeConfig;

	@Inject
	private NpcUtil(@Nullable RuntimeConfig runtimeConfig, EventBus eventBus)
	{
		this.runtimeConfig = runtimeConfig;
		eventBus.register(this);
	}

	/**
	 * Returns whether an NPC is dying and can no longer be interacted with, or if it is still alive or in some special
	 * state where it can be 0hp without dying. (For example, Gargoyles and other slayer monsters with item weaknesses
	 * are not killed by reaching 0hp, so would not be dead based on that alone.)
	 *
	 * @param npc NPC to check whether it is dying
	 * @return {@code true} if the NPC is dying
	 */
	public boolean isDying(final NPC npc)
	{
		final int id = npc.getId();
		switch (id)
		{
			// These NPCs hit 0hp but don't actually die
			case NpcID.GARGOYLE:
			case NpcID.GARGOYLE_1543:
			case NpcID.MARBLE_GARGOYLE:
			case NpcID.DAWN_7884:
			case NpcID.DUSK_7888:
			case NpcID.ZYGOMITE:
			case NpcID.ZYGOMITE_1024:
			case NpcID.ANCIENT_ZYGOMITE:
			case NpcID.ROCKSLUG:
			case NpcID.ROCKSLUG_422:
			case NpcID.GIANT_ROCKSLUG:
			case NpcID.DESERT_LIZARD:
			case NpcID.DESERT_LIZARD_460:
			case NpcID.DESERT_LIZARD_461:
			case NpcID.LIZARD:
			case NpcID.SMALL_LIZARD:
			case NpcID.SMALL_LIZARD_463:
			case NpcID.GROWTHLING:
			// These NPCs die, but transform into forms which are attackable or interactable, so it would be jarring for
			// them to be considered dead when reaching 0hp.
			case NpcID.KALPHITE_QUEEN_963:
			case NpcID.VETION:
			case NpcID.CALVARION:
			case NpcID.WITCHS_EXPERIMENT:
			case NpcID.WITCHS_EXPERIMENT_6394:
			case NpcID.WITCHS_EXPERIMENT_HARD:
			case NpcID.WITCHS_EXPERIMENT_SECOND_FORM:
			case NpcID.WITCHS_EXPERIMENT_SECOND_FORM_6395:
			case NpcID.WITCHS_EXPERIMENT_SECOND_FORM_HARD:
			case NpcID.WITCHS_EXPERIMENT_THIRD_FORM:
			case NpcID.WITCHS_EXPERIMENT_THIRD_FORM_6396:
			case NpcID.WITCHS_EXPERIMENT_THIRD_FORM_HARD:
			case NpcID.NAZASTAROOL:
			case NpcID.NAZASTAROOL_5354:
			case NpcID.NAZASTAROOL_6398:
			case NpcID.NAZASTAROOL_6399:
			case NpcID.NAZASTAROOL_HARD:
			case NpcID.NAZASTAROOL_HARD_6338:
			case NpcID.KOLODION_1605:
			case NpcID.KOLODION_1606:
			case NpcID.KOLODION_1607:
			case NpcID.KOLODION_1608:
			case NpcID.MUTANT_TARN:
			case NpcID.XAMPHUR_10955:
			case NpcID.XAMPHUR_10956:
			case NpcID.KOSCHEI_THE_DEATHLESS:
			case NpcID.KOSCHEI_THE_DEATHLESS_3898:
			case NpcID.KOSCHEI_THE_DEATHLESS_3899:
			case NpcID.DAMIS:
			case NpcID.DAMIS_6346:
			case NpcID.DAMIS_HARD:
			case NpcID.CHOMPY_BIRD:
			case NpcID.JUBBLY_BIRD:
			case NpcID.ENT:
			case NpcID.ENT_7234:
			case NpcID.HOPELESS_CREATURE:
			case NpcID.HOPELESS_CREATURE_1073:
			case NpcID.GADDERANKS_4484:
			case NpcID.WALL_BEAST:
			case NpcID.RUNITE_GOLEM:
			case NpcID.RUNITE_ROCKS:
			case NpcID.STRANGE_CREATURE_12076: // Secrets of the North transitioning to Jhallan
			// Agrith Naar restores health upon reaching 0hp if the player does not have Silverlight
			// equipped, or moved away immediately after applying the killing blow.
			case NpcID.AGRITH_NAAR:
				return false;
			// These NPCs have no attack options, but are the dead and uninteractable form of otherwise attackable NPCs,
			// thus should not be considered alive.
			case NpcID.DRAKE_8613:
			case NpcID.GUARDIAN_DRAKE_10401:
			case NpcID.ALCHEMICAL_HYDRA_8622:
			case NpcID.XARPUS_8341:
			case NpcID.XARPUS_10769:
			case NpcID.XARPUS_10773:
			case NpcID.THE_NIGHTMARE_9433:
			case NpcID.PHOSANIS_NIGHTMARE_9424:
			// Gargoyles, Dawn, and Dusk each have cracking forms which contain their death animations, so should always
			// be considered dead.
			case NpcID.GARGOYLE_413:
			case NpcID.MARBLE_GARGOYLE_7408:
			case NpcID.DAWN_7885:
			case NpcID.DUSK_7889:
				return true;
			case NpcID.ZALCANO_9050:
				return npc.isDead();
			default:
				if (runtimeConfig != null)
				{
					Set<Integer> ignoredNpcs = runtimeConfig.getIgnoreDeadNpcs();
					if (ignoredNpcs != null && ignoredNpcs.contains(id))
					{
						return false;
					}

					Set<Integer> forceDeadNpcs = runtimeConfig.getForceDeadNpcs();
					if (forceDeadNpcs != null && forceDeadNpcs.contains(id))
					{
						return true;
					}

					Set<Integer> pureIsDeadNpcs = runtimeConfig.getNonAttackNpcs();
					if (pureIsDeadNpcs != null && pureIsDeadNpcs.contains(id))
					{
						return npc.isDead();
					}
				}

				final NPCComposition npcComposition = npc.getTransformedComposition();
				boolean hasAttack = npcComposition != null && ArrayUtils.contains(npcComposition.getActions(), "Attack");
				return hasAttack && npc.isDead();
		}
	}

	@Subscribe
	void onNpcChanged(NpcChanged e)
	{
		final NPC npc = e.getNpc();
		final int id = npc.getId();
		switch (id)
		{
			// These NPCs are final new forms of previous NPCs and should not be considered dead upon transformation.
			// Prior form(s) should be added to the `isDying()` exceptions list above to ensure they are not hidden or
			// made uninteractable during their death animations.
			case NpcID.KALPHITE_QUEEN_965:
			case NpcID.VETION_12002:    // Vet'ion and Calvar'ion have a non-attackable form for the animation between
			case NpcID.CALVARION_11995: // their first and second phase; resetting isDead() for that form works best
			case NpcID.WITCHS_EXPERIMENT_FOURTH_FORM:
			case NpcID.WITCHS_EXPERIMENT_FOURTH_FORM_6397:
			case NpcID.WITCHS_EXPERIMENT_FOURTH_FORM_HARD:
			case NpcID.NAZASTAROOL_5355:
			case NpcID.NAZASTAROOL_6400:
			case NpcID.NAZASTAROOL_HARD_6339:
			case NpcID.KOLODION_1609:
			case NpcID.TARN_6476:
			case NpcID.KOSCHEI_THE_DEATHLESS_3900:
			case NpcID.DAMIS_683:
			case NpcID.DAMIS_6347:
			case NpcID.DAMIS_HARD_1135:
			case NpcID.HOPELESS_CREATURE_1074:
			case NpcID.GADDERANKS_4485:
			// The Nightmare should be considered alive again once reaching its sleeping form
			case NpcID.THE_NIGHTMARE:
			case NpcID.PHOSANIS_NIGHTMARE:
			// Skotizo's altars should be considered alive again once they "respawn" from their inactive altar forms
			case NpcID.AWAKENED_ALTAR:
			case NpcID.AWAKENED_ALTAR_7290:
			case NpcID.AWAKENED_ALTAR_7292:
			case NpcID.AWAKENED_ALTAR_7294:
				npc.setDead(false);
				break;
			default:
				if (runtimeConfig != null)
				{
					Set<Integer> resetDeadOnChangeNpcs = runtimeConfig.getResetDeadOnChangeNpcs();
					if (resetDeadOnChangeNpcs != null && resetDeadOnChangeNpcs.contains(id))
					{
						npc.setDead(false);
					}
				}
				break;
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged animationChanged)
	{
		final Actor actor = animationChanged.getActor();
		final int anim = actor.getAnimation();
		switch (anim)
		{
			// Corp frequently dies in masses with hitpoints remaining, so additionally use the death anim
			// to determine if it is dead
			case AnimationID.CORP_DEATH:
				if (!(actor instanceof NPC) || ((NPC) actor).getId() != NpcID.CORPOREAL_BEAST)
				{
					break;
				}
				// intentional fallthrough
			case AnimationID.VERZIK_P2_BLUE_NYLO_EXPLOSION:
			case AnimationID.VERZIK_P2_GREEN_NYLO_EXPLOSION:
			case AnimationID.VERZIK_P2_WHITE_NYLO_EXPLOSION:
			case AnimationID.VERZIK_P2_PURPLE_NYLO_EXPLOSION:
			case AnimationID.VERZIK_P2_RED_NYLO_EXPLOSION:
				actor.setDead(true);
				break;
			default:
				if (runtimeConfig != null)
				{
					Set<Integer> forceDeadAnimations = runtimeConfig.getForceDeadAnimations();
					if (forceDeadAnimations != null && forceDeadAnimations.contains(anim))
					{
						actor.setDead(true);
					}
				}
				break;
		}
	}
}
