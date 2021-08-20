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
public enum ShiftWithdrawMode
{
	WITHDRAW_1("Withdraw-1", MenuAction.CC_OP, 2, 1),
	WITHDRAW_5("Withdraw-5", MenuAction.CC_OP, 3, 2),
	WITHDRAW_10("Withdraw-10", MenuAction.CC_OP, 4, 3),
	WITHDRAW_X("Withdraw-X", MenuAction.CC_OP, 5, 5),
	WITHDRAW_ALL("Withdraw-All", MenuAction.CC_OP_LOW_PRIORITY, 7, 4),
	// chambers of xeric storage units do not have an "all-but-1" option, so this option will choose "Withdraw-all"
	// instead when using the storage unit.
	WITHDRAW_ALL_BUT_1("Withdraw-All-But-1", MenuAction.CC_OP_LOW_PRIORITY, 8, 4),
	OFF("Off", MenuAction.UNKNOWN, 0, 0);

	private final String name;
	private final MenuAction menuAction;
	private final int identifier;
	private final int identifierChambersStorageUnit;

	@Override
	public String toString()
	{
		return name;
	}
}
