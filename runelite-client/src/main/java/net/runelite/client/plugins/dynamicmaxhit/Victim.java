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
package net.runelite.client.plugins.dynamicmaxhit;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.runelite.api.Player;
import net.runelite.api.Prayer;
import net.runelite.api.util.Text;
import static net.runelite.client.plugins.dynamicmaxhit.Utils.iconToPrayer;
import net.runelite.http.api.hiscore.HiscoreResult;

@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@ToString(exclude = "player")
class Victim
{
	private AttackStyle attackStyle;
	private AttackStyle weakness;
	private MeleeStyle meleeStyle;
	private HiscoreResult skills;
	private List<Integer> gear;
	private Player player;
	private Prayer overhead;
	private Prayer predictedPrayer;
	private Spells predictedSpell;
	private String location;
	private String name;
	private String targetString;
	private boolean manual;
	private boolean attacking;
	private boolean charged;
	private double dps;
	private double drainRate;
	private double maxHit;
	private double specMaxHit;
	private double spec;
	private int speed;
	private int hpLevel;
	private int magicStr;
	private int magicAttack;
	private int magicDefence;
	private int meleeAttack;
	private int meleeAtkSlash;
	private int meleeAtkStab;
	private int meleeAtkCrush;
	private int meleeDefSlash;
	private int meleeDefStab;
	private int meleeDefCrush;
	private int meleeDefence;
	private int meleeStr;
	private int prayerLevel;
	private int rangeAttack;
	private int rangeDefence;
	private int rangeStr;
	private int shield;
	private int timer;
	private int weapon;
	private int wildyLevel;
	private int potionBoost;

	Victim(Player player)
	{
		this.attackStyle = AttackStyle.UNKNOWN;
		this.attacking = false;
		this.charged = false;
		this.gear = new ArrayList<>();
		this.hpLevel = -1;
		this.magicAttack = 0;
		this.dps = 0;
		this.magicDefence = 0;
		this.maxHit = 0;
		this.manual = false;
		this.meleeStyle = MeleeStyle.NONE;
		this.meleeAttack = 0;
		this.meleeAtkCrush = 0;
		this.meleeAtkStab = 0;
		this.meleeAtkSlash = 0;
		this.meleeDefCrush = 0;
		this.meleeDefStab = 0;
		this.meleeDefSlash = 0;
		this.meleeDefence = 0;
		this.name = Text.standardize(player.getName());
		this.overhead = null;
		this.player = player;
		this.prayerLevel = -1;
		this.predictedPrayer = null;
		this.predictedSpell = Spells.UNKNOWNM;
		this.rangeAttack = 0;
		this.rangeDefence = 0;
		this.speed = 0;
		this.shield = 0;
		this.skills = null;
		this.specMaxHit = 0;
		this.spec = 100;
		this.targetString = "";
		this.timer = 0;
		this.weakness = AttackStyle.UNKNOWN;
		this.weapon = 0;
		this.wildyLevel = 0;
		this.potionBoost = 0;
	}

	void reset()
	{
		setSpeed(0);
		setMeleeAtkCrush(0);
		setMeleeAtkStab(0);
		setMeleeAtkSlash(0);
		setMeleeAttack(0);
		setMeleeDefCrush(0);
		setMeleeDefStab(0);
		setMeleeDefSlash(0);
		setMeleeDefence(0);
		setMagicAttack(0);
		setRangeAttack(0);
		setMagicDefence(0);
		setRangeDefence(0);
		setMagicStr(0);
		setMeleeStr(0);
		setRangeStr(0);
		setDrainRate(0);
		setOverhead(iconToPrayer(getPlayer()));
		setAttackStyle(AttackStyle.UNKNOWN);
		setMeleeStyle(MeleeStyle.NONE);
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