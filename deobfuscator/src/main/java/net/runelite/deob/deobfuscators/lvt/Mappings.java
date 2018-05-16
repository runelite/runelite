/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob.deobfuscators.lvt;

import java.util.HashMap;
import java.util.Map;
import net.runelite.asm.attributes.code.instruction.types.LVTInstructionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mappings
{
	private static final Logger logger = LoggerFactory.getLogger(Mappings.class);

	private final int maxVariables;
	private int offset;
	private Map<Integer, LVTType> map = new HashMap<>();
	private Map<MapKey, Integer> newIdxMap = new HashMap<>();

	public Mappings(int maxVariables)
	{
		this.maxVariables = maxVariables;
	}

	private static LVTType toLvtType(LVTInstructionType type)
	{
		switch (type)
		{
			case DOUBLE:
			case LONG:
				return LVTType.LONG;
			case FLOAT:
			case INT:
				return LVTType.INT;
			case OBJECT:
				return LVTType.OBJECT;
			default:
				throw new IllegalArgumentException("Unknown type " + type);
		}
	}

	public Integer remap(int idx, LVTInstructionType type)
	{
		LVTType seen = map.get(idx);

		if (seen == null)
		{
			map.put(idx, toLvtType(type));
		}
		else if (toLvtType(type) != seen)
		{
			MapKey key = new MapKey(idx, toLvtType(type));

			Integer newIdx = newIdxMap.get(key);
			if (newIdx == null)
			{
				newIdx = maxVariables + offset;
				newIdxMap.put(key, newIdx);

				logger.debug("Mapping {} -> {}", idx, newIdx);

				offset += type.getSlots();
			}

			return newIdx;
		}

		return null;
	}
}
