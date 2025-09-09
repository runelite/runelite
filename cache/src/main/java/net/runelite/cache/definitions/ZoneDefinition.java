/*
 * Copyright (c) 2024, Christopher Brown <christoabrown@gmail.com>
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

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ZoneDefinition extends AbstractWorldMapDataDefinition
{
	public int sourceZoneX;
	public int sourceZoneZ;
	public int displayZoneX;
	public int displayZoneZ;

	public boolean equals(Object obj)
	{
		if (!(obj instanceof ZoneDefinition))
		{
			return false;
		}
		else
		{
			ZoneDefinition other = (ZoneDefinition) obj;
			return other.displaySquareX == this.displaySquareX && other.displaySquareZ == this.displaySquareZ
					&& other.displayZoneX == this.displayZoneX && other.displayZoneZ == this.displayZoneZ;
		}
	}

	public int hashCode()
	{
		return this.displaySquareX | this.displaySquareZ << 8 | this.displayZoneX << 16 | this.displayZoneZ << 24;
	}
}
