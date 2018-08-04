/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.itemcharges;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
@AllArgsConstructor
public enum ItemWithVarCharge
{
	DODGY_NECKLACE(ItemID.DODGY_NECKLACE, 10,
		Pattern.compile("Your dodgy necklace.* (\\d+) charges? left.*")),
	RING_OF_RECOIL(ItemID.RING_OF_RECOIL, 40,
		Pattern.compile("You can inflict (\\d+) more points of damage before a ring will shatter."));

	private final int itemId;
	private final int chargesOnDepletion;
	private final Pattern checkPattern;

	int getCharges(String message)
	{
		final Matcher updateMatcher = checkPattern.matcher(message);
		return updateMatcher.matches() ? Integer.parseInt(updateMatcher.group(1)) : -1;
	}

	static Optional<ItemWithVarCharge> forId(int itemId)
	{
		return Arrays.stream(values())
			.filter(item -> item.getItemId() == itemId)
			.findFirst();
	}

	static Optional<ItemWithVarCharge> forOnCheckMessage(String message)
	{
		return Arrays.stream(values())
			.filter(item -> item.getCheckPattern().matcher(message).matches())
			.findFirst();
	}
}
