/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.game;

import java.util.LinkedHashMap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.runelite.api.Player;
import net.runelite.http.api.hiscore.HiscoreResult;

@Getter
@Setter
@ToString(exclude = "player")
public class PlayerContainer
{
	private AttackStyle attackStyle;
	private AttackStyle weakness;
	private HiscoreResult skills;
	private LinkedHashMap<Integer, Integer> gear;
	private LinkedHashMap<Integer, Integer> riskedGear;
	private MeleeStyle meleeStyle;
	private Player player;
	private String location;
	private String name;
	private String targetString;
	private CombatStats combatStats;
	private boolean httpRetry;
	private boolean scouted;
	private boolean attacking;
	private boolean friend;
	private boolean clan;
	private int hpLevel;
	private int potionBoost;
	private int prayerLevel;
	private int risk;
	private int scoutTimer;
	private int shield;
	private int timer;
	private int weapon;
	private int wildyLevel;

	PlayerContainer(Player player)
	{
		this.attackStyle = AttackStyle.UNKNOWN;
		this.gear = new LinkedHashMap<>();
		this.hpLevel = 0;
		this.location = "N/A";
		this.meleeStyle = MeleeStyle.STAB;
		this.name = player.getName();
		this.player = player;
		this.riskedGear = new LinkedHashMap<>();
		this.scoutTimer = 500;
		this.scouted = false;
		this.skills = null;
		this.targetString = "";
		this.weakness = AttackStyle.UNKNOWN;
	}

	void reset()
	{
		setMeleeStyle(MeleeStyle.NONE);
		if (getTimer() > 0)
		{
			setTimer(getTimer() - 1);
			if (getTimer() == 0)
			{
				setAttacking(false);
			}
		}
	}

	@Getter(AccessLevel.PACKAGE)
	enum MeleeStyle
	{
		CRUSH,
		SLASH,
		STAB,
		NONE
	}
}