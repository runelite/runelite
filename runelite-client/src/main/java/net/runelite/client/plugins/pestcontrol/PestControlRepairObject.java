/*
 * Copyright (c) 2019, Yani <yani@xenokore.com>
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
package net.runelite.client.plugins.pestcontrol;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ObjectID;

@Getter(AccessLevel.PACKAGE)
class PestControlRepairObject
{
	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> repairableBarricades = ImmutableSet.of(
		//ObjectID.BARRICADE_14224,
		ObjectID.BARRICADE_14227,
		ObjectID.BARRICADE_14228,
		ObjectID.BARRICADE_14229,
		ObjectID.BARRICADE_14230,
		ObjectID.BARRICADE_14231,
		ObjectID.BARRICADE_14232
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> repairableGates = ImmutableSet.of(
		ObjectID.GATE_14238,
		ObjectID.GATE_14239,
		ObjectID.GATE_14240,
		ObjectID.GATE_14241,
		ObjectID.GATE_14242,
		ObjectID.GATE_14243,
		ObjectID.GATE_14244,
		ObjectID.GATE_14245,
		ObjectID.GATE_14246,
		ObjectID.GATE_14247,
		ObjectID.GATE_14248
	);

	static boolean isRepairableBarricadeId(int objectId)
	{
		return repairableBarricades.contains(objectId);
	}

	static boolean isRepairableGateId(int objectId)
	{
		return repairableGates.contains(objectId);
	}

	static boolean isRepairableId(int objectId)
	{
		return isRepairableBarricadeId(objectId) || isRepairableGateId(objectId);
	}
}