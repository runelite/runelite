/*
 * Copyright (c) 2020, Zach <https://github.com/zacharydwaller>
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
package net.runelite.client.plugins.menuentryswapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.MenuAction;

@Getter
@RequiredArgsConstructor
public enum ShiftDepositMode
{
	DEPOSIT_1("Deposit-1", MenuAction.CC_OP, 3),
	DEPOSIT_5("Deposit-5", MenuAction.CC_OP, 4),
	DEPOSIT_10("Deposit-10", MenuAction.CC_OP, 5),
	DEPOSIT_X("Deposit-X", MenuAction.CC_OP_LOW_PRIORITY, 6),
	DEPOSIT_ALL("Deposit-All", MenuAction.CC_OP_LOW_PRIORITY, 8),
	EXTRA_OP("Eat/Wield/Etc.", MenuAction.CC_OP_LOW_PRIORITY, 9),
	OFF("Off", MenuAction.UNKNOWN, 0);

	private final String name;
	private final MenuAction menuAction;
	private final int identifier;

	@Override
	public String toString()
	{
		return name;
	}
}
