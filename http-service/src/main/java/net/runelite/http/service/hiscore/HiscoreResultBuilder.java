/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.hiscore;

import java.util.function.Consumer;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.Skill;

public class HiscoreResultBuilder
{
	public static final int NUM_SKILLS = 24;

	private final HiscoreResult result = new HiscoreResult();

	private final Consumer<Skill>[] consumers = new Consumer[]
	{
		(s) -> result.setOverall((Skill) s),
		(s) -> result.setAttack((Skill) s),
		(s) -> result.setDefence((Skill) s),
		(s) -> result.setStrength((Skill) s),
		(s) -> result.setHitpoints((Skill) s),
		(s) -> result.setRanged((Skill) s),
		(s) -> result.setPrayer((Skill) s),
		(s) -> result.setMagic((Skill) s),
		(s) -> result.setCooking((Skill) s),
		(s) -> result.setWoodcutting((Skill) s),
		(s) -> result.setFletching((Skill) s),
		(s) -> result.setFishing((Skill) s),
		(s) -> result.setFiremaking((Skill) s),
		(s) -> result.setCrafting((Skill) s),
		(s) -> result.setSmithing((Skill) s),
		(s) -> result.setMining((Skill) s),
		(s) -> result.setHerblore((Skill) s),
		(s) -> result.setAgility((Skill) s),
		(s) -> result.setThieving((Skill) s),
		(s) -> result.setSlayer((Skill) s),
		(s) -> result.setFarming((Skill) s),
		(s) -> result.setRunecraft((Skill) s),
		(s) -> result.setHunter((Skill) s),
		(s) -> result.setConstruction((Skill) s),
	};

	private int position;

	public void setPlayer(String player)
	{
		result.setPlayer(player);
	}

	public void setNextSkill(Skill skill)
	{
		consumers[position++].accept(skill);
	}

	public HiscoreResult build()
	{
		return result;
	}
}
