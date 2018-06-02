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
		START("Start", "#"),
		END("End", "¤"),
		SCAVENGERS("Scavengers", "S"),
		FARMING("Farming", "F"),
		COMBAT("Combat", "C"),
		PUZZLE("Puzzle", "P"),
		EMPTY("Empty", " ");

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
		TEKTON("Tekton"),
		MUTTADILES("Muttadiles"),
		GUARDIANS("Guardians"),
		VESPULA("Vespula"),
		SHAMANS("Shamans"),
		VASA("Vasa"),
		VANGUARDS("Vanguards"),
		MYSTICS("Mystics"),
		UNKNOWN("Unknown");

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
		CRABS("Crabs"),
		ICE_DEMON("Ice Demon"),
		TIGHTROPE("Tightrope"),
		THIEVING("Thieving"),
		UNKNOWN("Unknown");

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
				return "RaidRoom (type: " + type.getName() + ", " + boss.getName() + ")";

			case PUZZLE:
				return "RaidRoom (type: " + type.getName() + ", " + puzzle.getName() + ")";

			default:
				return "RaidRoom (type: " + type.getName() + ")";
		}
	}
}
