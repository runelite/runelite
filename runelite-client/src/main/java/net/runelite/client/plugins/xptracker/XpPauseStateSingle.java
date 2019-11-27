/*
 * Copyright (c) 2018, Levi <me@levischuck.com>
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

import java.util.EnumSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Skill;

@RequiredArgsConstructor
class XpPauseStateSingle
{
	@Getter(AccessLevel.PACKAGE)
	private final Skill skill;
	private final Set<XpPauseReason> pauseReasons = EnumSet.noneOf(XpPauseReason.class);
	@Getter(AccessLevel.PACKAGE)
	private long lastChangeMillis;
	@Getter(AccessLevel.PACKAGE)
	private long xp;

	boolean isPaused()
	{
		return !pauseReasons.isEmpty();
	}

	boolean login()
	{
		return pauseReasons.remove(XpPauseReason.PAUSED_LOGOUT);
	}

	boolean logout()
	{
		return pauseReasons.add(XpPauseReason.PAUSED_LOGOUT);
	}

	boolean timeout()
	{
		return pauseReasons.add(XpPauseReason.PAUSED_TIMEOUT);
	}

	boolean manualPause()
	{
		return pauseReasons.add(XpPauseReason.PAUSE_MANUAL);
	}

	boolean xpChanged(long xp)
	{
		this.xp = xp;
		this.lastChangeMillis = System.currentTimeMillis();
		return clearAll();
	}

	boolean unpause()
	{
		this.lastChangeMillis = System.currentTimeMillis();
		return clearAll();
	}

	private boolean clearAll()
	{
		if (pauseReasons.isEmpty())
		{
			return false;
		}

		pauseReasons.clear();
		return true;
	}

	private enum XpPauseReason
	{
		PAUSE_MANUAL,
		PAUSED_LOGOUT,
		PAUSED_TIMEOUT
	}
}
