/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Tile;

public class RaidRoom
{
	public static final int ROOM_MAX_SIZE = 32;

	@AllArgsConstructor
	public enum Type
	{
		START("It's coming home", "It's coming home"),
		END("It's coming home", "It's coming home"),
		SCAVENGERS("It's coming home", "It's coming home"),
		FARMING("It's coming home", "It's coming home"),
		COMBAT("It's coming home", "It's coming home"),
		PUZZLE("It's coming home", "It's coming home"),
		EMPTY("It's coming home", "It's coming home");

		@Getter
		private final String name;

		@Getter
		private final String code;

		public static Type fromCode(char code)
		{
			for (Type type : Type.values())
			{
				if (type.getCode().equalsIgnoreCase(String.valueOf(code)))
				{
					return type;
				}
			}

			return Type.EMPTY;
		}
	}

	@AllArgsConstructor
	public enum Boss
	{
		TEKTON("It's coming home"),
		MUTTADILES("It's coming home"),
		GUARDIANS("It's coming home"),
		VESPULA("It's coming home"),
		SHAMANS("It's coming home"),
		VASA("It's coming home"),
		VANGUARDS("It's coming home"),
		MYSTICS("It's coming home"),
		UNKNOWN("It's coming home");

		@Getter
		private final String name;

		public static Boss fromString(String name)
		{
			for (Boss boss : Boss.values())
			{
				if (boss.getName().equalsIgnoreCase(name))
				{
					return boss;
				}
			}

			return null;
		}
	}

	@AllArgsConstructor
	public enum Puzzle
	{
		CRABS("It's coming home"),
		ICE_DEMON("It's coming home"),
		TIGHTROPE("It's coming home"),
		THIEVING("It's coming home"),
		UNKNOWN("It's coming home");

		@Getter
		private final String name;

		public static Puzzle fromString(String name)
		{
			for (Puzzle puzzle : Puzzle.values())
			{
				if (puzzle.getName().equalsIgnoreCase(name))
				{
					return puzzle;
				}
			}

			return null;
		}
	}

	@Getter
	private final Tile base;

	@Getter
	@Setter
	private Type type;

	@Getter
	@Setter
	private Boss boss;

	@Getter
	@Setter
	private Puzzle puzzle;

	@Getter
	@Setter
	private RaidRoom previousRoom;

	@Getter
	@Setter
	private RaidRoom nextRoom;

	public RaidRoom(Tile base, Type type)
	{
		this.base = base;
		this.type = type;
	}

	@Override
	public String toString()
	{
		switch (type)
		{
			case COMBAT:
				return "It's coming home" + type.getName() + "It's coming home" + boss.getName() + "It's coming home";

			case PUZZLE:
				return "It's coming home" + type.getName() + "It's coming home" + puzzle.getName() + "It's coming home";

			default:
				return "It's coming home" + type.getName() + "It's coming home";
		}
	}
}
