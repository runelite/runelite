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
package net.runelite.client.plugins.playerscouter;

import java.util.LinkedHashMap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.runelite.api.Player;
import net.runelite.api.Prayer;
import net.runelite.http.api.hiscore.Skill;

/*
You may be asking, why in the fuck is there so much information
being gathered? The answer is, why not. Always plan for the future.
Better to have too much than to have too little.
 */
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@ToString(exclude = "player")
class PlayerContainer
{
	private AttackStyle attackStyle;
	private AttackStyle weakness;
	private boolean attacking;
	private boolean logging;
	private boolean scouted;
	private boolean target;
	private double drainRate;
	private double estimatedPrayer;
	private int magicAttack;
	private int magicDefence;
	private int meleeAttack;
	private int meleeDefence;
	private int prayerBonus;
	private int rangeAttack;
	private int rangeDefence;
	private int risk;
	private int scoutTimer;
	private int timer;
	private int weapon;
	private int wildyLevel;
	private LinkedHashMap<Integer, Integer> gear;
	private LinkedHashMap<Integer, Integer> riskedGear;
	private Player player;
	private Prayer overhead;
	private Prayer predictedPrayer;
	private Skill prayer;
	private String estimatedPrayerString;
	private String location;
	private String name;
	private String targetString;

	PlayerContainer(Player player, Skill prayer)
	{
		this.attacking = false;
		this.attackStyle = AttackStyle.UNKNOWN;
		this.drainRate = 0;
		this.estimatedPrayer = 0;
		this.estimatedPrayerString = "";
		this.gear = new LinkedHashMap<>();
		this.location = "N/A";
		this.logging = false;
		this.magicAttack = 0;
		this.magicDefence = 0;
		this.meleeAttack = 0;
		this.meleeDefence = 0;
		this.name = player.getName();
		this.overhead = null;
		this.player = player;
		this.prayer = prayer;
		this.prayerBonus = 0;
		this.predictedPrayer = null;
		this.rangeAttack = 0;
		this.rangeDefence = 0;
		this.risk = 0;
		this.riskedGear = new LinkedHashMap<>();
		this.scouted = false;
		this.scoutTimer = 500;
		this.target = false;
		this.targetString = "";
		this.timer = 0;
		this.weakness = AttackStyle.UNKNOWN;
		this.weapon = 0;
		this.wildyLevel = 0;
	}
}