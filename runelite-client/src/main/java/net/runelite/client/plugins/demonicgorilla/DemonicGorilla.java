/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.demonicgorilla;

import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Actor;
import net.runelite.api.HeadIcon;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.coords.WorldArea;

class DemonicGorilla
{
	static final int MAX_ATTACK_RANGE = 10; // Needs <= 10 tiles to reach target
	static final int ATTACK_RATE = 5; // 5 ticks between each attack
	static final int ATTACKS_PER_SWITCH = 3; // 3 unsuccessful attacks per style switch

	static final int PROJECTILE_MAGIC_SPEED = 8; // Travels 8 tiles per tick
	static final int PROJECTILE_RANGED_SPEED = 6; // Travels 6 tiles per tick
	static final int PROJECTILE_MAGIC_DELAY = 12; // Requires an extra 12 tiles
	static final int PROJECTILE_RANGED_DELAY = 9; // Requires an extra 9 tiles

	static final AttackStyle[] ALL_REGULAR_ATTACK_STYLES =
		{
			AttackStyle.MELEE,
			AttackStyle.RANGED,
			AttackStyle.MAGIC
		};

	enum AttackStyle
	{
		MAGIC,
		RANGED,
		MELEE,
		BOULDER
	}

	@Getter(AccessLevel.PACKAGE)
	private NPC npc;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private List<AttackStyle> nextPosibleAttackStyles;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int attacksUntilSwitch;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int nextAttackTick;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int lastTickAnimation;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private WorldArea lastWorldArea;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean initiatedCombat;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Actor lastTickInteracting;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean takenDamageRecently;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int recentProjectileId;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean changedPrayerThisTick;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean changedAttackStyleThisTick;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean changedAttackStyleLastTick;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private HeadIcon lastTickOverheadIcon;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int disabledMeleeMovementForTicks;

	DemonicGorilla(NPC npc)
	{
		this.npc = npc;
		this.nextPosibleAttackStyles = Arrays.asList(ALL_REGULAR_ATTACK_STYLES);
		this.nextAttackTick = -100;
		this.attacksUntilSwitch = ATTACKS_PER_SWITCH;
		this.recentProjectileId = -1;
	}

	HeadIcon getOverheadIcon()
	{
		NPCDefinition composition = this.npc.getDefinition();
		if (composition != null)
		{
			return composition.getOverheadIcon();
		}
		return null;
	}
}