/*
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
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

import com.google.common.base.Strings;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Value;

@Value
class ItemThreshold
{
	enum Inequality
	{
		LESS_THAN,
		MORE_THAN
	}

	private static final Pattern QUANTITY_THRESHOLD_PATTERN = Pattern.compile("(.+)(<|>)\\s*(\\d+)");

	private final String itemName;
	private final int quantity;
	private final Inequality inequality;

	static ItemThreshold fromConfigEntry(String entry)
	{
		if (Strings.isNullOrEmpty(entry))
		{
			return null;
		}

		Matcher matcher = QUANTITY_THRESHOLD_PATTERN.matcher(entry);

		if (matcher.find())
		{
			String name = matcher.group(1).trim();
			String sign = matcher.group(2);
			int quantity = Integer.parseInt(matcher.group(3));
			Inequality inequality = sign.equals("<") ? Inequality.LESS_THAN : Inequality.MORE_THAN;

			return new ItemThreshold(name, quantity, inequality);
		}

		return new ItemThreshold(entry, 0, Inequality.MORE_THAN);
	}

	boolean quantityHolds(int itemCount)
	{
		if (inequality == Inequality.LESS_THAN)
		{
			return itemCount < quantity;
		}
		else
		{
			return itemCount > quantity;
		}
	}
}
