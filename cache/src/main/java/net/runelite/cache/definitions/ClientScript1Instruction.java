/*
 * Copyright (c) 2018 Abex
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
package net.runelite.cache.definitions;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
public class ClientScript1Instruction
{
	@RequiredArgsConstructor
	public enum Opcode
	{
		RETURN(0),
		BOOSTED_SKILL_LEVELS(1),
		REAL_SKILL_LEVELS(1),
		SKILL_EXPERIENCE(1),
		WIDGET_CONTAINS_ITEM_GET_QUANTITY(3),
		VARP(1),
		EXPERIENCE_AT_LEVEL_FOR_SKILL(1),
		VARP_TIMES_469(1),
		COMBAT_LEVEL(1),
		TOTAL_LEVEL(0),
		WIDGET_CONTAINS_ITEM_STAR(3),
		RUN_ENERGY(0),
		WEIGHT(0),
		VARP_TESTBIT(2),
		VARBIT(1),
		MINUS(0),
		DIV(0),
		MUL(0),
		WORLD_X(0),
		WORLD_Y(1),
		CONSTANT(1);

		public final int argumentCount;
	}

	public Opcode opcode;
	public int[] operands;
}
