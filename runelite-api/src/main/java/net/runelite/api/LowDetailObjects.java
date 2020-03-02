/*
 * Copyright (c) 2020, Trevor <https://github.com/Trevor159>
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
package net.runelite.api;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LowDetailObjects
{
	DRAYNOR_ROOFS1(NullObjectID.NULL_5737),
	DRAYNOR_ROOFS2(NullObjectID.NULL_1643),

	COX_ENTRANCE1(NullObjectID.NULL_29969),
	COX_ENTRANCE2(NullObjectID.NULL_29970),
	COX_ENTRANCE3(NullObjectID.NULL_29965),
	COX_ENTRANCE4(NullObjectID.NULL_29964),
	COX_ENTRANCE5(NullObjectID.NULL_29954),
	COX_ENTRANCE6(NullObjectID.NULL_29966),
	COX_ENTRANCE7(NullObjectID.NULL_29968),
	COX_ENTRANCE8(NullObjectID.NULL_29957),
	COX_ENTRANCE9(NullObjectID.NULL_29963),
	COX_ENTRANCE10(NullObjectID.NULL_29953),
	COX_ENTRANCE11(NullObjectID.NULL_29973),
	COX_ENTRANCE12(NullObjectID.NULL_29955),
	COX_ENTRANCE13(NullObjectID.NULL_29956),
	COX_ENTRANCE14(NullObjectID.NULL_29974),
	COX_ENTRANCE15(NullObjectID.NULL_29972),
	COX_ENTRANCE16(NullObjectID.NULL_29961),
	COX_ENTRANCE17(NullObjectID.NULL_29962),
	COX_ENTRANCE18(NullObjectID.NULL_29960),
	COX_ENTRANCE19(NullObjectID.NULL_29959),
	COX_ENTRANCE20(NullObjectID.NULL_29958),
	COX_BANK1(NullObjectID.NULL_25125),
	COX_BANK2(NullObjectID.NULL_25126),
	COX_BANK3(NullObjectID.NULL_25124);

	final private int objectId;

	private static final Set<Integer> ids = new HashSet<>();

	static
	{
		for (LowDetailObjects objects : LowDetailObjects.values())
		{
			ids.add(objects.objectId);
		}
	}

	public static boolean contains(int objectId)
	{
		return ids.contains(objectId);
	}
}
