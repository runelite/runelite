/*
 * Copyright (c) 2020, Anthony <https://github.com/while-loop>
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
package net.runelite.client.plugins.xptracker;

import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.util.QuantityFormatter;

@Getter
@AllArgsConstructor
public enum XpPanelLabel
{
	TIME_TO_LEVEL("TTL", XpSnapshotSingle::getTimeTillGoalShort),

	XP_GAINED("XP Gained", snap -> format(snap.getXpGainedInSession())),
	XP_HOUR("XP/hr", snap -> format(snap.getXpPerHour())),
	XP_LEFT("XP Left", snap -> format(snap.getXpRemainingToGoal())),

	ACTIONS_LEFT("Actions", snap -> format(snap.getActionsRemainingToGoal())),
	ACTIONS_HOUR("Actions/hr", snap -> format(snap.getActionsPerHour())),
	ACTIONS_DONE("Actions Done", snap -> format(snap.getActionsInSession())),
	;

	private final String key;
	private final Function<XpSnapshotSingle, String> valueFunc;

	private static String format(int val)
	{
		// actions remaining uses Integer.MAX_VALUE if the action history isn't initialized, which can happen
		// from restoring a save.
		return val == Integer.MAX_VALUE ? "N/A" : QuantityFormatter.quantityToRSDecimalStack(val, true);
	}
}
