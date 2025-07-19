/*
 * Copyright (c) 2018, Joshua Filby <joshua@filby.me>
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
package net.runelite.cache.util;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ScriptVarType
{
	INTEGER(0, 'i', "integer"),
	BOOLEAN(1, '1', "boolean"),
	SEQ(6, 'A', "seq"),
	COLOUR(7, 'C', "colour"),
	/**
	 * Also known as {@code Widget}.
	 */
	COMPONENT(9, 'I', "component"),
	IDKIT(10, 'K', "idkit"),
	MIDI(11, 'M', "midi"),
	/**
	 * Another version of {@code OBJ}, but means that on Jagex's side they used the internal name for an item.
	 */
	NAMEDOBJ(13, 'O', "namedobj"),
	SYNTH(14, 'P', "synth"),
	STAT(17, 'S', "stat"),
	COORDGRID(22, 'c', "coordgrid"),
	GRAPHIC(23, 'd', "graphic"),
	FONTMETRICS(25, 'f', "fontmetrics"),
	ENUM(26, 'g', "enum"),
	JINGLE(28, 'j', "jingle"),
	/**
	 * Also known as {@code Object}.
	 */
	LOC(30, 'l', "loc"),
	MODEL(31, 'm', "model"),
	NPC(32, 'n', "npc"),
	/**
	 * Also known as {@code Item}.
	 */
	OBJ(33, 'o', "obj"),
	STRING(36, 's', "string"),
	SPOTANIM(37, 't', "spotanim"),
	INV(39, 'v', "inv"),
	TEXTURE(40, 'x', "texture"),
	CHAR(42, 'z', "char"),
	MAPSCENEICON(55, '£', "mapsceneicon"),
	MAPELEMENT(59, 'µ', "mapelement"),
	HITMARK(62, '×', "hitmark"),
	STRUCT(73, 'J', "struct"),
	DBROW(74, 'Ð', "dbrow"),
	VARP(209, '7', "varp"),
	;

	private static final Map<Integer, ScriptVarType> idToTypeMap = new HashMap<>();
	private static final Map<Character, ScriptVarType> keyToTypeMap = new HashMap<>();

	static
	{
		for (ScriptVarType type : values())
		{
			if (type.id != -1)
			{
				idToTypeMap.put(type.id, type);
			}
			keyToTypeMap.put(type.keyChar, type);
		}
	}

	public static ScriptVarType forId(int id)
	{
		return idToTypeMap.get(id);
	}

	public static ScriptVarType forCharKey(char key)
	{
		return keyToTypeMap.get(key);
	}

	/**
	 * The type id when encoding or decoding types from some data structures.
	 */
	private final int id;

	/**
	 * The character used when encoding or decoding types.
	 */
	private final char keyChar;

	/**
	 * The full name of the var type.
	 */
	private final String fullName;

}
