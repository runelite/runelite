/*
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
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
package net.runelite.client.plugins.questhelper;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import net.runelite.api.Client;

public class ItemRequirements
{
	Set<ItemRequirement> itemRequirements;

	Set<ItemRequirements> alternates = new HashSet<>();

	public ItemRequirements(int id)
	{
		this(id, 1);
	}

	public ItemRequirements(int id, int quantity)
	{
		this(id, quantity, false);
	}

	public ItemRequirements(int id, int quantity, boolean equip)
	{
		itemRequirements = new HashSet<>();
		itemRequirements.add(new ItemRequirement(id, quantity, equip));
	}

	public ItemRequirements(ItemRequirement... itemRequirements)
	{
		this.itemRequirements = new HashSet<>();
		Collections.addAll(this.itemRequirements, itemRequirements);
	}

	public void addAlternate(ItemRequirements... itemRequirements)
	{
		Collections.addAll(alternates, itemRequirements);
	}

	public boolean check(Client client)
	{
		for (ItemRequirements itemRequirements : alternates)
		{
			if (itemRequirements.check(client))
			{
				return true;
			}
		}

		for (ItemRequirement itemRequirement : itemRequirements)
		{
			if (!itemRequirement.check(client))
			{
				return false;
			}
		}

		return true;
	}
}
