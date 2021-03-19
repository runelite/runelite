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
package net.runelite.api;

import lombok.Getter;

/**
 * A hitsplat that has been applied to an {@link Actor}.
 */
public class Hitsplat
{
	/**
	 * An enumeration of hitsplat types.
	 */
	public enum HitsplatType
	{
		/**
		 * Blocking damage by me (blue).
		 */
		BLOCK_ME,
		/**
		 * Blocking damage by others (blue).
		 */
		BLOCK_OTHER,
		/**
		 * Taking damage by me (red).
		 */
		DAMAGE_ME,
		/**
		 * Taking damage by others (red).
		 */
		DAMAGE_OTHER,
		/**
		 * Taking damage by me (cyan).
		 */
		DAMAGE_ME_CYAN,
		/**
		 * Taking damage by others (cyan).
		 */
		DAMAGE_OTHER_CYAN,
		/**
		 * Taking damage by me (orange).
		 */
		DAMAGE_ME_ORANGE,
		/**
		 * Taking damage by others (orange).
		 */
		DAMAGE_OTHER_ORANGE,
		/**
		 * Taking damage by me (yellow).
		 */
		DAMAGE_ME_YELLOW,
		/**
		 * Taking damage by others (yellow).
		 */
		DAMAGE_OTHER_YELLOW,
		/**
		 * Taking damage by me (white).
		 */
		DAMAGE_ME_WHITE,
		/**
		 * Taking damage by others (white/black).
		 */
		DAMAGE_OTHER_WHITE,
		/**
		 * Damage from poison (green).
		 */
		POISON,
		/**
		 * Damage from venom (teal).
		 */
		VENOM,
		/**
		 * Damage from disease (orange).
		 */
		DISEASE,
		/**
		 * Healing (purple).
		 */
		HEAL;

		/**
		 * Utility method that maps the type value to its respective
		 * {@link Hitsplat} value.
		 *
		 * @param type the type value
		 * @return hitsplat type
		 */
		public static HitsplatType fromInteger(int type)
		{
			switch (type)
			{
				case 12: return BLOCK_ME;
				case 13: return BLOCK_OTHER;
				case 16: return DAMAGE_ME;
				case 17: return DAMAGE_OTHER;
				case 2: return POISON;
				case 4: return DISEASE;
				case 5: return VENOM;
				case 6: return HEAL;
				case 18: return DAMAGE_ME_CYAN;
				case 19: return DAMAGE_OTHER_CYAN;
				case 20: return DAMAGE_ME_ORANGE;
				case 21: return DAMAGE_OTHER_ORANGE;
				case 22: return DAMAGE_ME_YELLOW;
				case 23: return DAMAGE_OTHER_YELLOW;
				case 24: return DAMAGE_ME_WHITE;
				case 25: return DAMAGE_OTHER_WHITE;
			}
			return null;
		}
	}

	/**
	 * The type of hitsplat.
	 */
	@Getter
	private HitsplatType hitsplatType;

	/**
	 * The value displayed by the hitsplat.
	 */
	@Getter
	private int amount;

	/**
	 * When the hitsplat will disappear.
	 */
	@Getter
	private int disappearsOnGameCycle;

	public Hitsplat(HitsplatType hitsplatType, int amount, int disappearsOnGameCycle)
	{
		this.hitsplatType = hitsplatType;
		this.amount = amount;
		this.disappearsOnGameCycle = disappearsOnGameCycle;
	}

	public boolean isMine()
	{
		switch (this.getHitsplatType())
		{
			case BLOCK_ME:
			case DAMAGE_ME:
			case DAMAGE_ME_CYAN:
			case DAMAGE_ME_YELLOW:
			case DAMAGE_ME_ORANGE:
			case DAMAGE_ME_WHITE:
				return true;
			default:
				return false;
		}
	}

	public boolean isOthers()
	{
		switch (this.getHitsplatType())
		{
			case BLOCK_OTHER:
			case DAMAGE_OTHER:
			case DAMAGE_OTHER_CYAN:
			case DAMAGE_OTHER_YELLOW:
			case DAMAGE_OTHER_ORANGE:
			case DAMAGE_OTHER_WHITE:
				return true;
			default:
				return false;
		}
	}
}