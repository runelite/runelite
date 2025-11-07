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
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ParamID;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.gameval.AnimationID;
import net.runelite.api.gameval.NpcID;
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

			Set<Integer> healthCheckDeadNpcs = runtimeConfig.getHealthCheckDeadNpcs();
			if (healthCheckDeadNpcs != null && healthCheckDeadNpcs.contains(id))
			{
				return npc.getHealthRatio() == 0;
			}
		}

		switch (id)
		{
			// These NPCs hit 0hp but don't actually die
			case NpcID.SLAYER_GARGOYLE_1:
			case NpcID.SLAYER_CAVE_GARGOYLE:
			case NpcID.SUPERIOR_GARGOYLE:
			case NpcID.GARGBOSS_DAWN_PHASE3:
			case NpcID.GARGBOSS_DUSK_PHASE4:
			case NpcID.SLAYER_MUTATED_ZYGOMITE_ADOLESCENT:
			case NpcID.SLAYER_MUTATED_ZYGOMITE_ADULT:
			case NpcID.FOSSIL_ZYGOMITE:
			case NpcID.SLAYER_ROCKSLUG:
			case NpcID.SLAYER_ROCKSLUG_BABY:
			case NpcID.SUPERIOR_ROCKSLUG:
			case NpcID.SLAYER_LIZARD_LARGE1_GREEN:
			case NpcID.SLAYER_LIZARD_LARGE2_SANDY:
			case NpcID.SLAYER_LIZARD_LARGE3_SANDY:
			case NpcID.SLAYER_LIZARD_MASSIVE:
			case NpcID.SLAYER_LIZARD_SMALL1_GREEN:
			case NpcID.SLAYER_LIZARD_SMALL2_SANDY:
			case NpcID.GB_GROWTHLING:
			case NpcID.COLOSSEUM_MODIFIER_BEES:
			// These NPCs die, but transform into forms which are attackable or interactable, so it would be jarring for
			// them to be considered dead when reaching 0hp.
			case NpcID.KALPHITE_QUEEN:
			case NpcID.VETION:
			case NpcID.VETION_SINGLE:
			case NpcID.SHAPESHIFTERGLOB:
			case NpcID.NZONE_SHAPESHIFTERGLOB_NORMAL:
			case NpcID.NZONE_SHAPESHIFTERGLOB_HARD:
			case NpcID.SHAPESHIFTERSPIDER:
			case NpcID.NZONE_SHAPESHIFTERSPIDER_NORMAL:
			case NpcID.NZONE_SHAPESHIFTERSPIDER_HARD:
			case NpcID.SHAPESHIFTERBEAR:
			case NpcID.NZONE_SHAPESHIFTERBEAR_NORMAL:
			case NpcID.NZONE_SHAPESHIFTERBEAR_HARD:
			case NpcID.ZQ_MAINZOMBIE1:
			case NpcID.ZQ_MAINZOMBIE2:
			case NpcID.NZONE_ZQ_MAINZOMBIE1_NORMAL:
			case NpcID.NZONE_ZQ_MAINZOMBIE2_NORMAL:
			case NpcID.NZONE_ZQ_MAINZOMBIE1_HARD:
			case NpcID.NZONE_ZQ_MAINZOMBIE2_HARD:
			case NpcID.KOLHUMAN:
			case NpcID.KOLOGRE:
			case NpcID.KOLSPIDER:
			case NpcID.KOLETHEREAL:
			case NpcID.LOTR_TRAN_RAZORLOR_MUTANT:
			case NpcID.AKD_XAMPHUR_COMBAT:
			case NpcID.AKD_XAMPHUR_COMBAT_NOHANDS:
			case NpcID.VIKING_ENEMY1:
			case NpcID.VIKING_ENEMY2:
			case NpcID.VIKING_ENEMY3:
			case NpcID.FD_DAMIS_NORMAL:
			case NpcID.NZONE_FD_DAMIS_NORMAL_NORMAL:
			case NpcID.NZONE_FD_DAMIS_NORMAL_HARD:
			case NpcID.CHOMPYBIRD:
			case NpcID._100_JUBBLY_BIRD:
			case NpcID.WILDERNESS_ENT:
			case NpcID.WCGUILD_ENT:
			case NpcID.SOULBANE_HOPE_MONST3:
			case NpcID.SOULBANE_HOPE_MONST2:
			case NpcID.BURGH_GADDERANKS_ATTACKABLE:
			case NpcID.SWAMP_WALLBEAST_COMBAT:
			case NpcID.WILDERNESS_RUNE_GOLEM:
			case NpcID.WILDERNESS_GOLEM_RUNE_ROCK:
			case NpcID.MUSPAH_FINAL_QUEST: // Secrets of the North transitioning to Jhallan
			case NpcID.SHADOW_MAJ_BOUNCER:
			// Tutorial island giant rats respawn instantly.
			case NpcID.NEWBIEGIANTRAT:
			// Agrith Naar restores health upon reaching 0hp if the player does not have Silverlight
			// equipped, or moved away immediately after applying the killing blow.
			case NpcID.AGRITH_NAAR:
				return false;
			// These NPCs have no attack options, but are the dead and uninteractable form of otherwise attackable NPCs,
			// thus should not be considered alive.
			case NpcID.DRAKE_DEATH:
			case NpcID.SUPERIOR_DRAKE_DEATH:
			case NpcID.HYDRABOSS_FINALDEATH:
			case NpcID.XARPUS_DEATH:
			case NpcID.XARPUS_DEATH_STORY:
			case NpcID.XARPUS_DEATH_HARD:
			case NpcID.NIGHTMARE_DYING:
			case NpcID.NIGHTMARE_CHALLENGE_DYING:
			// Gargoyles, Dawn, and Dusk each have cracking forms which contain their death animations, so should always
			// be considered dead.
			case NpcID.SLAYER_GARGOYLE_DEAD:
			case NpcID.SUPERIOR_GARGOYLE_DEAD:
			case NpcID.GARGBOSS_DAWN_DEATH:
			case NpcID.GARGBOSS_DUSK_DEATH:
				return true;
			case NpcID.ZALCANO_WEAK:
				return npc.isDead();
			// Amoxliatl has a nonstandard health bar which isDead() doesn't work with.
			case NpcID.AMOXLIATL:
				return npc.getHealthRatio() == 0;
			default:
				final NPCComposition npcComposition = npc.getTransformedComposition();
				if (npcComposition == null)
				{
					return false;
				}

				boolean hasAttack = ArrayUtils.contains(npcComposition.getActions(), "Attack");
				if (!hasAttack || !npc.isDead())
				{
					return false;
				}

				if (npcComposition.getIntValue(ParamID.NPC_DEATH_HIDER_EXCLUDE) != 0)
				{
					return false;
				}

				return true;
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
			case NpcID.KALPHITE_FLYINGQUEEN:
			case NpcID.VETION_TRANS:    // Vet'ion and Calvar'ion have a non-attackable form for the animation between
			case NpcID.VETION_TRANS_SINGLE: // their first and second phase; resetting isDead() for that form works best
			case NpcID.SHAPESHIFTERWOLF:
			case NpcID.NZONE_SHAPESHIFTERWOLF_NORMAL:
			case NpcID.NZONE_SHAPESHIFTERWOLF_HARD:
			case NpcID.ZQ_MAINZOMBIE3:
			case NpcID.NZONE_ZQ_MAINZOMBIE3_NORMAL:
			case NpcID.NZONE_ZQ_MAINZOMBIE3_HARD:
			case NpcID.KOLDEMON:
			case NpcID.LOTR_TRAN_RAZORLOR_GHOST:
			case NpcID.VIKING_ENEMY4:
			case NpcID.FD_DAMIS_TOUGHER:
			case NpcID.NZONE_FD_DAMIS_TOUGHER_NORMAL:
			case NpcID.NZONE_FD_DAMIS_TOUGHER_HARD:
			case NpcID.SOULBANE_HOPE_MONST1:
			case NpcID.BURGH_GADDERANKS_WOUNDED:
			// The Nightmare should be considered alive again once reaching its sleeping form
			case NpcID.NIGHTMARE_DEAD:
			case NpcID.NIGHTMARE_CHALLENGE_DEAD:
			// Skotizo's altars should be considered alive again once they "respawn" from their inactive altar forms
			case NpcID.CATA_BOSS_ALTAR_OPEN_N:
			case NpcID.CATA_BOSS_ALTAR_OPEN_E:
			case NpcID.CATA_BOSS_ALTAR_OPEN_S:
			case NpcID.CATA_BOSS_ALTAR_OPEN_W:
			case NpcID.SHADOW_MAJ_BOUNCER_CUTSCENE:
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
			case AnimationID.CORPBEAST_DEATH:
				if (!(actor instanceof NPC) || ((NPC) actor).getId() != NpcID.CORP_BEAST)
				{
					break;
				}
				// intentional fallthrough
			case AnimationID.TOP_SPIDER_MAGIC_DEATH_DETONATE:
			case AnimationID.TOP_SPIDER_RANGED_DEATH_DETONATE:
			case AnimationID.TOP_SPIDER_MELEE_DEATH_DETONATE:
			case AnimationID.TOB_SPIDER_TANK_DEATH:
			case AnimationID.ELEMENTAL_DEATH:
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
