/*
 * Copyright (c) 2018, Jeffrey Haywood <https://github.com/jeffreyjhaywood>
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
package net.runelite.client.plugins.grandexchange;

import java.util.Map;
import com.google.common.collect.ImmutableMap;

public abstract class GrandExchangeSearchAbbreviations
{
	private static final Map<String, String> AbbrDictionary = new ImmutableMap.Builder<String, String>()
		.put("acb", "armadyl crossbow")
		.put("bgs", "bandos godsword")
		.put("dclaws", "dragon claws")
		.put("d claws", "dragon claws")
		.put("dds", "dragon dagger")
		.put("dfs", "dragonfire shield")
		.put("dh", "dharok")
		.put("dwh", "dragon warhammer")
		.put("ely", "elysian")
		.put("gmaul", "granite maul")
		.put("p pot", "prayer potion")
		.put("ppot", "prayer potion")
		.put("sgs", "saradomin godsword")
		.put("tbow", "twisted bow")
		.put("zgs", "zamorak godsword")
		.build();

	/**
	*  CheckAbbreviation will check the GrandExchangePanel Search box and if
	*  it finds a match will assign the actual name of the item to
	*  a string to be looked up.
	*
	*  @param lookup Holds the string that contains the item being searched.
	*  @return Returns actual item name.
	*/
	public static String CheckAbbreviation(String lookup)
	{
		return AbbrDictionary.getOrDefault(lookup, lookup);
	}
}
