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

@AllArgsConstructor
public enum ScriptVarType
{
	INTEGER('i', "integer"),
	BOOLEAN('1', "boolean"),
	SEQ('A', "seq"),
	COLOUR('C', "colour"),
	/**
	 * Also known as {@code Widget}.
	 */
	COMPONENT('I', "component"),
	IDKIT('K', "idkit"),
	MIDI('M', "midi"),
	SYNTH('P', "synth"),
	STAT('S', "stat"),
	COORDGRID('c', "coordgrid"),
	GRAPHIC('d', "graphic"),
	FONTMETRICS('f', "fontmetrics"),
	ENUM('g', "enum"),
	JINGLE('j', "jingle"),
	/**
	 * Also known as {@code Object}.
	 */
	LOC('l', "loc"),
	MODEL('m', "model"),
	NPC('n', "npc"),
	/**
	 * Also known as {@code Item}.
	 */
	OBJ('o', "obj"),
	/**
	 * Another version of {@code OBJ}, but means that on Jagex's side they used the internal name for an item.
	 */
	NAMEDOBJ('O', "namedobj"),
	STRING('s', "string"),
	SPOTANIM('t', "spotanim"),
	INV('v', "inv"),
	TEXTURE('x', "texture"),
	CHAR('z', "char"),
	MAPSCENEICON('£', "mapsceneicon"),
	MAPELEMENT('µ', "mapelement"),
	HITMARK('×', "hitmark"),
	STRUCT('J', "struct");

	private static final Map<Character, ScriptVarType> keyToTypeMap = new HashMap<>();

	static
	{
		for (ScriptVarType type : values())
		{
			keyToTypeMap.put(type.keyChar, type);
		}
	}

	public static ScriptVarType forCharKey(char key)
	{
		return keyToTypeMap.get(key);
	}

	/**
	 * The character used when encoding or decoding types.
	 */
	private final char keyChar;

	/**
	 * The full name of the var type.
	 */
	private final String fullName;

}
