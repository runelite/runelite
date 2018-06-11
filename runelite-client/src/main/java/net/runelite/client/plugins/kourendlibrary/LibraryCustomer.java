/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Franck Maillot <https://github.com/Franck-M>
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
package net.runelite.client.plugins.kourendlibrary;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.NpcID;

/**
 * Class for the Kourend Library customers.
 * Each customer is defined by its npc id and his/her name.
 */
public enum LibraryCustomer
{
	VILLIA(NpcID.VILLIA, "Villia"),
	PROFESSOR_GRACKLEBONE(NpcID.PROFESSOR_GRACKLEBONE, "Prof. Gracklebone"),
	Sam(NpcID.SAM_7049, "Sam");

	/**
	 * Map of all customer by their npc id.
	 */
	private static final Map<Integer, LibraryCustomer> byId;

	/**
	 * Npc id of the customer.
	 */
	@Getter
	private final int id;

	/**
	 * Name of the customer.
	 */
	@Getter
	private final String name;

	// Static variables initialization
	static
	{
		byId = buildIdMap();
	}

	/**
	 * Static method, return a customer given its npc id.
	 *
	 * @param id Npc id of the customer.
	 * @return The LibraryCustomer object for the specified id.
	 */
	public static LibraryCustomer getById(int id)
	{
		return byId.get(id);
	}

	/**
	 * Static method, create a HashMap of customer using their npc id as key.
	 *
	 * @return Map of customers by id.
	 */
	private static Map<Integer, LibraryCustomer> buildIdMap()
	{
		Map<Integer, LibraryCustomer> byId = new HashMap<>();
		for (LibraryCustomer c : values())
		{
			byId.put(c.id, c);
		}
		return byId;
	}

	/**
	 * Constructor for Library customers.
	 *
	 * @param id   Npc id of the customer.
	 * @param name Name of the customer.
	 */
	LibraryCustomer(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
}