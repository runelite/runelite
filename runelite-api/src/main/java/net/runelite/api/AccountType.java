/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.api;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Account type of target player.
 */
@Getter
@RequiredArgsConstructor
public enum AccountType
{
	/**
	 * Normal account type.
	 */
	NORMAL(0, null),
	/**
	 * Ironman account type.
	 */
	IRONMAN(1, 2),
	/**
	 * Ultimate ironman account type.
	 */
	ULTIMATE_IRONMAN(2, 3),
	/**
	 * Hardcore ironman account type.
	 */
	HARDCORE_IRONMAN(3, 10);

	private static final Map<Integer, AccountType> FROM_VARBIT = new HashMap<>();
	private static final Map<Integer, AccountType> FROM_ICON = new HashMap<>();

	static
	{
		for (AccountType accountType : AccountType.values())
		{
			FROM_VARBIT.put(accountType.getVarbit(), accountType);

			if (accountType.getIcon() != null)
			{
				FROM_ICON.put(accountType.getIcon(), accountType);
			}
		}
	}

	private final int varbit;
	private final Integer icon;

	/**
	 * Gets account type from IRONMAN_STATUS varbit value.
	 *
	 * @param varbitVal the varbit val
	 * @return the account type
	 */
	public static AccountType fromVarbit(final int varbitVal)
	{
		return FROM_VARBIT.get(varbitVal);
	}

	/**
	 * Gets account type from un-sanitized player name.
	 *
	 * @param name the name
	 * @return the account type
	 */
	public static AccountType fromName(final String name)
	{
		if (name == null || !name.contains("<img="))
		{
			return NORMAL;
		}

		for (AccountType accountType : AccountType.values())
		{
			if (accountType.getIcon() != null && name.contains("<img=" + accountType.getIcon() + ">"))
			{
				return accountType;
			}
		}

		return NORMAL;
	}

	/**
	 * Gets account type from modicon.
	 *
	 * @param icon the icon
	 * @return the account type
	 */
	public static AccountType fromIcon(final int icon)
	{
		return FROM_ICON.get(icon);
	}
}
