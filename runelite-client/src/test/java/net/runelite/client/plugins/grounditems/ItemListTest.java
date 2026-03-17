/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
import joptsimple.internal.Strings;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ItemListTest
{
	private static GroundItem item(String name, int qty)
	{
		return GroundItem.builder()
			.name(name)
			.quantity(qty)
			.build();
	}

	@Test
	public void testLoadItems()
	{
		ItemList loader = new ItemList(Arrays.asList("rune*", "Abyssal whip"));
		assertNotEquals(ItemList.NONE, loader.matches(item("rune pouch", 1)));
		assertNotEquals(ItemList.NONE, loader.matches(item("Rune pouch", 1)));
		assertEquals(ItemList.NONE, loader.matches(item("Adamant dagger", 1)));
		assertNotEquals(ItemList.NONE, loader.matches(item("Runeite Ore", 1)));
		assertNotEquals(ItemList.NONE, loader.matches(item("Abyssal whip", 1)));
		assertEquals(ItemList.NONE, loader.matches(item("Abyssal dagger", 1)));
	}

	@Test
	public void testLoadQuantities()
	{
		ItemList loader = new ItemList(Arrays.asList("rune* < 3", "*whip>3", "nature*<5", "*rune > 30"));
		assertNotEquals(ItemList.NONE, loader.matches(item("Nature Rune", 50)));
		assertEquals(ItemList.NONE, loader.matches(item("Nature Impling", 5)));
		assertNotEquals(ItemList.NONE, loader.matches(item("Abyssal whip", 4)));
		assertEquals(ItemList.NONE, loader.matches(item("Abyssal dagger", 1)));
		assertNotEquals(ItemList.NONE, loader.matches(item("Rune Longsword", 2)));
	}

	@Test(timeout = 1000)
	public void testExplosive()
	{
		String name = "archer" + Strings.repeat('e', 50000) + "s ring";
		ItemList loader = new ItemList(List.of(name + "* < 100"));
		assertNotEquals(ItemList.NONE, loader.matches(item(name, 50)));
		assertEquals(ItemList.NONE, loader.matches(item(name, 150)));
	}
}
