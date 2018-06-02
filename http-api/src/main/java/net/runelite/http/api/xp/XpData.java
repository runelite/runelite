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
package net.runelite.http.api.xp;

import java.time.Instant;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "time")
public class XpData
{
	private Instant time;

	private int attack_xp;
	private int defence_xp;
	private int strength_xp;
	private int hitpoints_xp;
	private int ranged_xp;
	private int prayer_xp;
	private int magic_xp;
	private int cooking_xp;
	private int woodcutting_xp;
	private int fletching_xp;
	private int fishing_xp;
	private int firemaking_xp;
	private int crafting_xp;
	private int smithing_xp;
	private int mining_xp;
	private int herblore_xp;
	private int agility_xp;
	private int thieving_xp;
	private int slayer_xp;
	private int farming_xp;
	private int runecraft_xp;
	private int hunter_xp;
	private int construction_xp;

	private int overall_rank;
	private int attack_rank;
	private int defence_rank;
	private int strength_rank;
	private int hitpoints_rank;
	private int ranged_rank;
	private int prayer_rank;
	private int magic_rank;
	private int cooking_rank;
	private int woodcutting_rank;
	private int fletching_rank;
	private int fishing_rank;
	private int firemaking_rank;
	private int crafting_rank;
	private int smithing_rank;
	private int mining_rank;
	private int herblore_rank;
	private int agility_rank;
	private int thieving_rank;
	private int slayer_rank;
	private int farming_rank;
	private int runecraft_rank;
	private int hunter_rank;
	private int construction_rank;
}
