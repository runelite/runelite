/*
 * Copyright (c) 2026, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.party.data.events;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.runelite.api.Item;
import net.runelite.client.party.data.PartyDataType;
import net.runelite.client.party.data.PartySerializationUtils;
import net.runelite.client.party.messages.PartyMemberMessage;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PartyDataChange extends PartyMemberMessage
{
	@SerializedName("i")
	int[] inventory;
	@SerializedName("e")
	int[] equipment;

	public boolean isValid()
	{
		return inventory != null || equipment != null;
	}

	public Collection<PartyDataEvent> processEvent()
	{
		Collection<PartyDataEvent> events = new ArrayList<>();
		if (inventory != null)
		{
			final Item[] items = PartySerializationUtils.convertIntArrayToItemArray(inventory);
			new PartyDataEvent(PartyDataType.INVENTORY, items);
		}

		if (equipment != null)
		{
			final Item[] items = PartySerializationUtils.convertIntArrayToItemArray(equipment);
			new PartyDataEvent(PartyDataType.EQUIPMENT, items);
		}

		return events;
	}
}
