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
package net.runelite.client.plugins.raids.solver;

import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/*
 * Implementation of https://github.com/WooxSolo/raids-layout
 * Copyright (c) 2017 WooxSolo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */
@Slf4j
@Singleton
public class LayoutSolver
{
	@Getter
	private static final List<Layout> layouts = new ArrayList<>();
	private static final Pattern regex = Pattern.compile("^([A-Z]*)\\.([A-Z]*) - #([A-Z]*)#([A-Z]*)$");
	private static final String[] codes =
	{
		"FSCCP.PCSCF - #WNWSWN#ESEENW",
		"FSCCS.PCPSF - #WSEEEN#WSWNWS",
		"FSCPC.CSCPF - #WNWWSE#EENWWW",
		"SCCFC.PSCSF - #EEENWW#WSEEEN",
		"SCCFP.CCSPF - #NESEEN#WSWNWS",
		"SCFCP.CCSPF - #ESEENW#ESWWNW",
		"SCFCP.CSCFS - #ENEESW#ENWWSW",
		"SCFCPC.CSPCSF - #ESWWNWS#NESENES",
		"SCFPC.CSPCF - #WSWWNE#WSEENE",
		"SCFPC.PCCSF - #WSEENE#WWWSEE",
		"SCFPC.SCPCF - #NESENE#WSWWNE",
		"SCPFC.CCPSF - #NWWWSE#WNEESE",
		"SCPFC.CSPCF - #NEEESW#WWNEEE",
		"SCPFC.CSPSF - #WWSEEE#NWSWWN",
		"SCSPF.CCSPF - #ESWWNW#ESENES",
		"SFCCP.CSCPF - #WNEESE#NWSWWN",
		"SFCCS.PCPSF - #ENWWSW#ENESEN",
		"SPCFC.CSPCF - #WWNEEE#WSWNWS",
		"SPCFC.SCCPF - #ESENES#WWWNEE",
		"SPSFP.CCCSF - #NWSWWN#ESEENW",
		"SCFCP.CSCPF - #ENESEN#WWWSEE",
		"SCPFC.PCSCF - #WNEEES#NWSWNW",
		"SFCCPC.PCSCPF - #WSEENES#WWWNEEE",
		"FSPCC.PSCCF - #WWWSEE#ENWWSW",
		"FSCCP.PCSCF - #ENWWWS#NEESEN",
		"SCPFC.CCSSF - #NEESEN#WSWWNE",
	};

	public LayoutSolver()
	{
		build();
	}

	public Layout findLayout(String code)
	{
		Layout solution = null;
		int matches = 0;
		boolean match;

		for (Layout layout : layouts)
		{
			match = true;

			for (int i = 0; i < code.length(); i++)
			{
				Room room = layout.getRoomAt(i);
				char c = code.charAt(i);

				if (room != null && c != ' ' && c != room.getSymbol())
				{
					match = false;
					break;
				}
			}

			if (match)
			{
				solution = layout;
				matches++;
				log.debug("Found matching layout: " + layout.toCode());
			}
		}

		if (matches == 1)
		{
			return solution;
		}

		return null;
	}

	private int calcStart(String directions)
	{
		int startPos = 0;
		int position = 0;

		for (int i = 0; i < directions.length(); i++)
		{
			char c = directions.charAt(i);
			int delta = dirToPosDelta(c);
			position += delta;

			if (position < 0 || position >= 8 || (position == 3 && delta == -1) || (position == 4 && delta == 1))
			{
				position -= delta;
				startPos -= delta;
			}
		}

		return startPos;
	}

	private int dirToPosDelta(char direction)
	{
		switch (String.valueOf(direction))
		{
			case "N":
				return -4;

			case "E":
				return 1;

			case "S":
				return 4;

			case "W":
				return -1;

			default:
				return 0;
		}
	}

	private void build()
	{
		for (String code : codes)
		{
			Matcher match = regex.matcher(code);

			if (!match.find())
			{
				continue;
			}

			String symbols, directions;
			int position = calcStart(match.group(3));
			Layout layout = new Layout();
			Room lastRoom = null;
			Room room;

			for (int floor = 0; floor < 2; floor++)
			{
				symbols = match.group(1 + floor);
				directions = match.group(3 + floor);

				for (int i = 0; i < directions.length(); i++)
				{
					char symbol = (i == 0 ? '#' : symbols.charAt(i - 1));

					room = new Room(position, symbol);

					if (lastRoom != null)
					{
						lastRoom.setNext(room);
						room.setPrevious(lastRoom);
					}

					layout.add(room);
					lastRoom = room;

					int delta = dirToPosDelta(directions.charAt(i));
					position += delta;
				}

				room = new Room(position, '¤');
				room.setPrevious(lastRoom);
				lastRoom.setNext(room);
				layout.add(room);
				position += 8;
			}

			layouts.add(layout);
		}
	}
}
