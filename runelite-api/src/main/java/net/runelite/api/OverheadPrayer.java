/*
* Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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

public enum OverheadPrayer
{
	NONE(-1),
	PROTECT_MELEE(0),
	PROTECT_RANGED(1),
	PROTECT_MAGIC(2),
	RETRIBUTION(3),
	REDEMPTION(5),
	SMITE(4);

	private int id;

	OverheadPrayer(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return this.id;
	}

	public static OverheadPrayer fromId(int overheadId)
	{
		if (overheadId == PROTECT_MELEE.getId())
			return PROTECT_MELEE;
		if (overheadId == PROTECT_RANGED.getId())
			return PROTECT_RANGED;
		if (overheadId == PROTECT_MAGIC.getId())
			return PROTECT_MAGIC;
		if (overheadId == RETRIBUTION.getId())
			return RETRIBUTION;
		if (overheadId == REDEMPTION.getId())
			return REDEMPTION;
		if (overheadId == SMITE.getId())
			return SMITE;
		if (overheadId == NONE.getId())
			return NONE;
		else //failsafe
			return NONE;
	}
}
