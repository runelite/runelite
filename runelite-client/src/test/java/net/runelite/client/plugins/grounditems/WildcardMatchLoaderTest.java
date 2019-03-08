/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, Mikhail <mikhail@huizenvlees.nl>
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
package net.runelite.client.plugins.grounditems;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WildcardMatchLoaderTest
{
	@Test
	public void testLoad()
	{
		List<FilterItem> filterItemList = Arrays.asList(
				new FilterItem("rune*"),
				new FilterItem("Abyssal whip"),
				new FilterItem("Egg", "<", 5, ""),
				new FilterItem("Coins", ">", 2, "m"),
				new FilterItem("Arrow", "=", 2, "")
		);

		WildcardMatchLoader loader = new WildcardMatchLoader(filterItemList);
		assertTrue(loader.load(new ItemNameWithQuantity("rune pouch", 1)));
		assertTrue(loader.load(new ItemNameWithQuantity("Rune pouch", 1)));
		assertFalse(loader.load(new ItemNameWithQuantity("Adamant dagger", 1)));
		assertTrue(loader.load(new ItemNameWithQuantity("Runeite Ore", 1)));
		assertTrue(loader.load(new ItemNameWithQuantity("Abyssal whip", 1)));
		assertFalse(loader.load(new ItemNameWithQuantity("Abyssal dagger", 1)));
		assertTrue(loader.load(new ItemNameWithQuantity("Egg", 4)));
		assertFalse(loader.load(new ItemNameWithQuantity("Egg", 6)));
		assertFalse(loader.load(new ItemNameWithQuantity("Coins", 1500000)));
		assertTrue(loader.load(new ItemNameWithQuantity("coins", 2000001)));
		assertTrue(loader.load(new ItemNameWithQuantity("Arrow", 2)));
	}
}